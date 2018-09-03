package com.baidu.tieba.recapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.activity.AdDebugActivityConfig;
/* loaded from: classes3.dex */
public class AdDebugService extends Service {
    private static TextView mFloatView;
    private boolean mIsFloatingViewAttached = false;
    private WindowManager.LayoutParams mParams;
    private WindowManager mWindowManager;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (!this.mIsFloatingViewAttached) {
            this.mWindowManager.addView(mFloatView, mFloatView.getLayoutParams());
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mWindowManager = (WindowManager) getSystemService("window");
        mFloatView = new TextView(this);
        mFloatView.setGravity(17);
        mFloatView.setTextSize(getResources().getDimension(f.e.ds12));
        am.i(mFloatView, f.C0146f.ad_debug_view_bg);
        mFloatView.setText("AD");
        this.mParams = new WindowManager.LayoutParams(-2, -2, 2005, 40, -3);
        this.mParams.gravity = 51;
        this.mWindowManager.addView(mFloatView, this.mParams);
        mFloatView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.recapp.AdDebugService.1
            private int gnv;
            private int gnw;
            private float gnx;
            private float gny;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.gnv = AdDebugService.this.mParams.x;
                        this.gnw = AdDebugService.this.mParams.y;
                        this.gnx = motionEvent.getRawX();
                        this.gny = motionEvent.getRawY();
                        return true;
                    case 1:
                        float abs = Math.abs(motionEvent.getRawX() - this.gnx);
                        float abs2 = Math.abs(motionEvent.getRawY() - this.gny);
                        if (abs >= 10.0f || abs2 >= 10.0f) {
                            return true;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AdDebugActivityConfig(TbadkCoreApplication.getInst().getContext())));
                        return true;
                    case 2:
                        AdDebugService.this.mParams.x = this.gnv + ((int) (motionEvent.getRawX() - this.gnx));
                        AdDebugService.this.mParams.y = this.gnw + ((int) (motionEvent.getRawY() - this.gny));
                        AdDebugService.this.mWindowManager.updateViewLayout(AdDebugService.mFloatView, AdDebugService.this.mParams);
                        return true;
                    default:
                        return false;
                }
            }
        });
        this.mIsFloatingViewAttached = true;
    }

    public void removeView() {
        if (mFloatView != null) {
            this.mWindowManager.removeView(mFloatView);
            this.mIsFloatingViewAttached = false;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Toast.makeText(getApplicationContext(), "onDestroy", 0);
        super.onDestroy();
        removeView();
    }

    public static void updateFloatView(final String str) {
        if (mFloatView != null) {
            mFloatView.post(new Runnable() { // from class: com.baidu.tieba.recapp.AdDebugService.2
                @Override // java.lang.Runnable
                public void run() {
                    AdDebugService.mFloatView.setText(str);
                }
            });
        }
    }
}
