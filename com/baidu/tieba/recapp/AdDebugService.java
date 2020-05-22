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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.activity.AdDebugActivityConfig;
/* loaded from: classes13.dex */
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
        mFloatView.setTextSize(getResources().getDimension(R.dimen.ds12));
        am.setBackgroundResource(mFloatView, R.drawable.ad_debug_view_bg);
        mFloatView.setText("AD");
        this.mParams = new WindowManager.LayoutParams(-2, -2, 2005, 40, -3);
        this.mParams.gravity = 51;
        this.mWindowManager.addView(mFloatView, this.mParams);
        mFloatView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.recapp.AdDebugService.1
            private int kIL;
            private int kIM;
            private float kIN;
            private float kIO;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.kIL = AdDebugService.this.mParams.x;
                        this.kIM = AdDebugService.this.mParams.y;
                        this.kIN = motionEvent.getRawX();
                        this.kIO = motionEvent.getRawY();
                        return true;
                    case 1:
                        float abs = Math.abs(motionEvent.getRawX() - this.kIN);
                        float abs2 = Math.abs(motionEvent.getRawY() - this.kIO);
                        if (abs >= 10.0f || abs2 >= 10.0f) {
                            return true;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AdDebugActivityConfig(TbadkCoreApplication.getInst().getContext())));
                        return true;
                    case 2:
                        AdDebugService.this.mParams.x = this.kIL + ((int) (motionEvent.getRawX() - this.kIN));
                        AdDebugService.this.mParams.y = this.kIM + ((int) (motionEvent.getRawY() - this.kIO));
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
        Toast.makeText(getApplicationContext(), MissionEvent.MESSAGE_DESTROY, 0);
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
