package com.baidu.tieba.k;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private volatile boolean cAK;
    private RelativeLayout fwR;
    private TextView fwS;
    private Runnable fwT;
    private Runnable fwU;
    private Context mContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    /* loaded from: classes.dex */
    public interface a {
        c getSplash();
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void aXn() {
        if (!this.cAK && isMainProcess() && aXp()) {
            if (this.mHandlerThread == null) {
                this.mHandlerThread = new HandlerThread("splash-thread");
                this.mHandlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(this.mHandlerThread.getLooper());
            }
            if (this.fwT == null) {
                this.fwT = new Runnable() { // from class: com.baidu.tieba.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.fwR != null) {
                            ((WindowManager) c.this.mContext.getSystemService("window")).removeViewImmediate(c.this.fwR);
                            c.this.aXo();
                        }
                    }
                };
            }
            if (this.fwU == null) {
                this.fwU = new Runnable() { // from class: com.baidu.tieba.k.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.pL(c.this.mContext.getString(d.j.data_init));
                    }
                };
            }
            this.mHandler.removeCallbacks(this.fwU);
            this.mHandler.postAtFrontOfQueue(this.fwU);
            this.cAK = true;
            this.mHandler.postDelayed(this.fwT, 20000L);
        }
    }

    public void hide() {
        if (this.fwR != null && this.fwS != null) {
            this.mHandler.removeCallbacks(this.fwT);
            this.mHandler.post(this.fwT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXo() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.fwT);
            this.mHandler.removeCallbacks(this.fwU);
            this.fwU = null;
            this.fwT = null;
            this.mHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
        }
        if (this.fwS != null) {
            this.fwS = null;
        }
        if (this.fwR != null) {
            this.fwR = null;
        }
        this.cAK = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pL(String str) {
        if (this.fwS == null) {
            this.fwS = new b(this.mContext);
            this.fwS.setTextSize(1, 18.0f);
        }
        this.fwS.setText(str);
        this.fwR = new RelativeLayout(this.mContext);
        this.fwR.setBackgroundResource(d.f.bg_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.fwR.addView(this.fwS, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE_BROADCAST;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.fwR, layoutParams2);
    }

    private boolean isMainProcess() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = this.mContext.getPackageName();
        int myPid = Process.myPid();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            if (runningAppProcesses.get(i).pid == myPid && TextUtils.equals(runningAppProcesses.get(i).processName, packageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean aXp() {
        List<String> bT = bT(this.mContext);
        if (bT == null || bT.size() == 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1).get(0);
        String shortString = runningTaskInfo.baseActivity.toShortString();
        String shortString2 = runningTaskInfo.topActivity.toShortString();
        for (String str : bT) {
            if (shortString.equals(str) || shortString2.equals(str)) {
                return true;
            }
            while (r3.hasNext()) {
            }
        }
        return false;
    }

    private List<String> bT(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("com.baidu.tieba.SPLASH_PIPELINE_ACTION");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        ArrayList arrayList = new ArrayList();
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            String packageName = context.getPackageName();
            Iterator<ResolveInfo> it = queryIntentActivities.iterator();
            while (it.hasNext()) {
                arrayList.add("{" + packageName + "/" + it.next().activityInfo.name + "}");
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends TextView {
        private LinearGradient fwW;
        private Matrix fwX;
        private int fwY;
        private boolean mAnimating;
        private Paint mPaint;
        private int mViewWidth;

        public b(Context context) {
            super(context);
            this.mViewWidth = 0;
            this.fwY = 0;
            this.mAnimating = true;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mAnimating && this.fwX != null) {
                this.fwY += this.mViewWidth / 10;
                if (this.fwY > this.mViewWidth * 2) {
                    this.fwY = -this.mViewWidth;
                }
                this.fwX.setTranslate(this.fwY, 0.0f);
                this.fwW.setLocalMatrix(this.fwX);
                postInvalidateDelayed(50L);
            }
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.mViewWidth == 0) {
                this.mViewWidth = getMeasuredWidth();
                if (this.mViewWidth > 0) {
                    this.mPaint = getPaint();
                    this.fwW = new LinearGradient(-this.mViewWidth, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.mPaint.setShader(this.fwW);
                    this.fwX = new Matrix();
                }
            }
        }
    }
}
