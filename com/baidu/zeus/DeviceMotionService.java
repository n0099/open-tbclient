package com.baidu.zeus;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import java.util.List;
/* loaded from: classes.dex */
final class DeviceMotionService implements SensorEventListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int INTERVAL_MILLIS = 100;
    private Context mContext;
    private Handler mHandler;
    private boolean mHaveSentErrorEvent;
    private boolean mIsRunning;
    private float[] mLastAcceleration;
    private DeviceMotionAndOrientationManager mManager;
    private SensorManager mSensorManager;
    private Runnable mUpdateRunnable;

    static {
        $assertionsDisabled = !DeviceMotionService.class.desiredAssertionStatus();
    }

    public DeviceMotionService(DeviceMotionAndOrientationManager deviceMotionAndOrientationManager, Context context) {
        this.mManager = deviceMotionAndOrientationManager;
        if (!$assertionsDisabled && this.mManager == null) {
            throw new AssertionError();
        }
        this.mContext = context;
        if (!$assertionsDisabled && this.mContext == null) {
            throw new AssertionError();
        }
    }

    public void start() {
        this.mIsRunning = true;
        registerForSensor();
    }

    public void stop() {
        this.mIsRunning = false;
        stopSendingUpdates();
        unregisterFromSensor();
    }

    public void suspend() {
        if (this.mIsRunning) {
            stopSendingUpdates();
            unregisterFromSensor();
        }
    }

    public void resume() {
        if (this.mIsRunning) {
            registerForSensor();
        }
    }

    private void sendErrorEvent() {
        if (!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName())) {
            throw new AssertionError();
        }
        if (!this.mHaveSentErrorEvent) {
            this.mHaveSentErrorEvent = true;
            createHandler();
            this.mHandler.post(new Runnable() { // from class: com.baidu.zeus.DeviceMotionService.1
                static final /* synthetic */ boolean $assertionsDisabled;

                static {
                    $assertionsDisabled = !DeviceMotionService.class.desiredAssertionStatus();
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName())) {
                        throw new AssertionError();
                    }
                    if (DeviceMotionService.this.mIsRunning) {
                        DeviceMotionService.this.mManager.onMotionChange(null, null, null, 0.0d);
                    }
                }
            });
        }
    }

    private void createHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
            this.mUpdateRunnable = new Runnable() { // from class: com.baidu.zeus.DeviceMotionService.2
                static final /* synthetic */ boolean $assertionsDisabled;

                static {
                    $assertionsDisabled = !DeviceMotionService.class.desiredAssertionStatus();
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!$assertionsDisabled && !DeviceMotionService.this.mIsRunning) {
                        throw new AssertionError();
                    }
                    DeviceMotionService.this.mManager.onMotionChange(new Double(DeviceMotionService.this.mLastAcceleration[0]), new Double(DeviceMotionService.this.mLastAcceleration[1]), new Double(DeviceMotionService.this.mLastAcceleration[2]), 100.0d);
                    DeviceMotionService.this.mHandler.postDelayed(DeviceMotionService.this.mUpdateRunnable, 100L);
                    DeviceMotionService.this.mHaveSentErrorEvent = false;
                }
            };
        }
    }

    private void startSendingUpdates() {
        createHandler();
        this.mUpdateRunnable.run();
    }

    private void stopSendingUpdates() {
        this.mHandler.removeCallbacks(this.mUpdateRunnable);
        this.mLastAcceleration = null;
    }

    private void registerForSensor() {
        if (!registerForAccelerometerSensor()) {
            sendErrorEvent();
        }
    }

    private SensorManager getSensorManager() {
        if ($assertionsDisabled || "WebViewCoreThread".equals(Thread.currentThread().getName())) {
            if (this.mSensorManager == null) {
                this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            }
            return this.mSensorManager;
        }
        throw new AssertionError();
    }

    private boolean registerForAccelerometerSensor() {
        List<Sensor> sensorList = getSensorManager().getSensorList(1);
        if (sensorList.isEmpty()) {
            return false;
        }
        createHandler();
        return getSensorManager().registerListener(this, sensorList.get(0), 2, this.mHandler);
    }

    private void unregisterFromSensor() {
        getSensorManager().unregisterListener(this);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!$assertionsDisabled && sensorEvent.values.length != 3) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName())) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && sensorEvent.sensor.getType() != 1) {
            throw new AssertionError();
        }
        if (this.mIsRunning) {
            boolean z = this.mLastAcceleration == null;
            this.mLastAcceleration = sensorEvent.values;
            if (z) {
                startSendingUpdates();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        if (!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName())) {
            throw new AssertionError();
        }
    }
}
