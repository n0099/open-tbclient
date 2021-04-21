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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.activity.AdDebugActivityConfig;
/* loaded from: classes4.dex */
public class AdDebugService extends Service {
    public static TextView mFloatView;
    public boolean mIsFloatingViewAttached = false;
    public WindowManager.LayoutParams mParams;
    public WindowManager mWindowManager;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public int f20384e;

        /* renamed from: f  reason: collision with root package name */
        public int f20385f;

        /* renamed from: g  reason: collision with root package name */
        public float f20386g;

        /* renamed from: h  reason: collision with root package name */
        public float f20387h;

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f20384e = AdDebugService.this.mParams.x;
                this.f20385f = AdDebugService.this.mParams.y;
                this.f20386g = motionEvent.getRawX();
                this.f20387h = motionEvent.getRawY();
                return true;
            } else if (action == 1) {
                float abs = Math.abs(motionEvent.getRawX() - this.f20386g);
                float abs2 = Math.abs(motionEvent.getRawY() - this.f20387h);
                if (abs < 10.0f && abs2 < 10.0f) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AdDebugActivityConfig(TbadkCoreApplication.getInst().getContext())));
                }
                return true;
            } else if (action != 2) {
                return false;
            } else {
                AdDebugService.this.mParams.x = this.f20384e + ((int) (motionEvent.getRawX() - this.f20386g));
                AdDebugService.this.mParams.y = this.f20385f + ((int) (motionEvent.getRawY() - this.f20387h));
                AdDebugService.this.mWindowManager.updateViewLayout(AdDebugService.mFloatView, AdDebugService.this.mParams);
                return true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20388e;

        public b(String str) {
            this.f20388e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdDebugService.mFloatView.setText(this.f20388e);
        }
    }

    public static void updateFloatView(String str) {
        TextView textView = mFloatView;
        if (textView == null) {
            return;
        }
        textView.post(new b(str));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mWindowManager = (WindowManager) getSystemService("window");
        TextView textView = new TextView(this);
        mFloatView = textView;
        textView.setGravity(17);
        mFloatView.setTextSize(getResources().getDimension(R.dimen.ds12));
        SkinManager.setBackgroundResource(mFloatView, R.drawable.ad_debug_view_bg);
        mFloatView.setText("AD");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2005, 40, -3);
        this.mParams = layoutParams;
        layoutParams.gravity = 51;
        this.mWindowManager.addView(mFloatView, layoutParams);
        mFloatView.setOnTouchListener(new a());
        this.mIsFloatingViewAttached = true;
    }

    @Override // android.app.Service
    public void onDestroy() {
        Toast.makeText(getApplicationContext(), MissionEvent.MESSAGE_DESTROY, 0);
        super.onDestroy();
        removeView();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (!this.mIsFloatingViewAttached) {
            WindowManager windowManager = this.mWindowManager;
            TextView textView = mFloatView;
            windowManager.addView(textView, textView.getLayoutParams());
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void removeView() {
        TextView textView = mFloatView;
        if (textView != null) {
            this.mWindowManager.removeView(textView);
            this.mIsFloatingViewAttached = false;
        }
    }
}
