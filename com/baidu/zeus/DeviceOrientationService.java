package com.baidu.zeus;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import java.util.List;
/* loaded from: classes.dex */
final class DeviceOrientationService implements SensorEventListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final double DELTA_DEGRESS = 1.0d;
    private Double mAlpha;
    private Double mBeta;
    private Context mContext;
    private Double mGamma;
    private float[] mGravityVector;
    private Handler mHandler;
    private boolean mHaveSentErrorEvent;
    private boolean mIsRunning;
    private float[] mMagneticFieldVector;
    private DeviceMotionAndOrientationManager mManager;
    private SensorManager mSensorManager;

    static {
        $assertionsDisabled = !DeviceOrientationService.class.desiredAssertionStatus();
    }

    public DeviceOrientationService(DeviceMotionAndOrientationManager deviceMotionAndOrientationManager, Context context) {
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
        registerForSensors();
    }

    public void stop() {
        this.mIsRunning = false;
        unregisterFromSensors();
    }

    public void suspend() {
        if (this.mIsRunning) {
            unregisterFromSensors();
        }
    }

    public void resume() {
        if (this.mIsRunning) {
            registerForSensors();
        }
    }

    private void sendErrorEvent() {
        if (!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName())) {
            throw new AssertionError();
        }
        if (!this.mHaveSentErrorEvent) {
            this.mHaveSentErrorEvent = true;
            this.mHandler.post(new Runnable() { // from class: com.baidu.zeus.DeviceOrientationService.1
                static final /* synthetic */ boolean $assertionsDisabled;

                static {
                    $assertionsDisabled = !DeviceOrientationService.class.desiredAssertionStatus();
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName())) {
                        throw new AssertionError();
                    }
                    if (DeviceOrientationService.this.mIsRunning) {
                        DeviceOrientationService.this.mManager.onOrientationChange(null, null, null);
                    }
                }
            });
        }
    }

    private void registerForSensors() {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        if (!registerForAccelerometerSensor() || !registerForMagneticFieldSensor()) {
            unregisterFromSensors();
            sendErrorEvent();
        }
    }

    private void getOrientationUsingGetRotationMatrix() {
        if (this.mGravityVector != null && this.mMagneticFieldVector != null) {
            float[] fArr = new float[9];
            if (SensorManager.getRotationMatrix(fArr, null, this.mGravityVector, this.mMagneticFieldVector)) {
                float[] fArr2 = new float[3];
                SensorManager.getOrientation(fArr, fArr2);
                double degrees = Math.toDegrees(-fArr2[0]) - 90.0d;
                while (degrees < 0.0d) {
                    degrees += 360.0d;
                }
                double degrees2 = Math.toDegrees(-fArr2[1]);
                while (degrees2 < -180.0d) {
                    degrees2 += 360.0d;
                }
                double degrees3 = Math.toDegrees(fArr2[2]);
                while (degrees3 < -90.0d) {
                    degrees3 += 360.0d;
                }
                maybeSendChange(degrees, degrees2, degrees3);
            }
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
        return getSensorManager().registerListener(this, sensorList.get(0), 0, this.mHandler);
    }

    private boolean registerForMagneticFieldSensor() {
        List<Sensor> sensorList = getSensorManager().getSensorList(2);
        if (sensorList.isEmpty()) {
            return false;
        }
        return getSensorManager().registerListener(this, sensorList.get(0), 0, this.mHandler);
    }

    private void unregisterFromSensors() {
        getSensorManager().unregisterListener(this);
    }

    private void maybeSendChange(double d, double d2, double d3) {
        if (!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName())) {
            throw new AssertionError();
        }
        if (this.mAlpha == null || this.mBeta == null || this.mGamma == null || Math.abs(d - this.mAlpha.doubleValue()) > DELTA_DEGRESS || Math.abs(d2 - this.mBeta.doubleValue()) > DELTA_DEGRESS || Math.abs(d3 - this.mGamma.doubleValue()) > DELTA_DEGRESS) {
            this.mAlpha = Double.valueOf(d);
            this.mBeta = Double.valueOf(d2);
            this.mGamma = Double.valueOf(d3);
            this.mManager.onOrientationChange(this.mAlpha, this.mBeta, this.mGamma);
            this.mHaveSentErrorEvent = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!$assertionsDisabled && sensorEvent.values.length != 3) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName())) {
            throw new AssertionError();
        }
        if (this.mIsRunning) {
            switch (sensorEvent.sensor.getType()) {
                case 1:
                    if (this.mGravityVector == null) {
                        this.mGravityVector = new float[3];
                    }
                    this.mGravityVector[0] = sensorEvent.values[0];
                    this.mGravityVector[1] = sensorEvent.values[1];
                    this.mGravityVector[2] = sensorEvent.values[2];
                    getOrientationUsingGetRotationMatrix();
                    return;
                case 2:
                    if (this.mMagneticFieldVector == null) {
                        this.mMagneticFieldVector = new float[3];
                    }
                    this.mMagneticFieldVector[0] = sensorEvent.values[0];
                    this.mMagneticFieldVector[1] = sensorEvent.values[1];
                    this.mMagneticFieldVector[2] = sensorEvent.values[2];
                    getOrientationUsingGetRotationMatrix();
                    return;
                default:
                    if (!$assertionsDisabled) {
                        throw new AssertionError();
                    }
                    return;
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
