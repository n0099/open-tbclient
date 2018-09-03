package com.baidu.tieba.l;

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
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.f;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private volatile boolean cdm;
    private RelativeLayout fhY;
    private TextView fhZ;
    private Runnable fia;
    private Runnable fib;
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

    public void aWd() {
        if (!this.cdm && isMainProcess() && aWf()) {
            if (this.mHandlerThread == null) {
                this.mHandlerThread = new HandlerThread("splash-thread");
                this.mHandlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(this.mHandlerThread.getLooper());
            }
            if (this.fia == null) {
                this.fia = new Runnable() { // from class: com.baidu.tieba.l.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.fhY != null) {
                            ((WindowManager) c.this.mContext.getSystemService("window")).removeViewImmediate(c.this.fhY);
                            c.this.aWe();
                        }
                    }
                };
            }
            if (this.fib == null) {
                this.fib = new Runnable() { // from class: com.baidu.tieba.l.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.qE(c.this.mContext.getString(f.j.data_init));
                    }
                };
            }
            this.mHandler.removeCallbacks(this.fib);
            this.mHandler.postAtFrontOfQueue(this.fib);
            this.cdm = true;
            this.mHandler.postDelayed(this.fia, 20000L);
        }
    }

    public void hide() {
        if (this.fhY != null && this.fhZ != null) {
            this.mHandler.removeCallbacks(this.fia);
            this.mHandler.post(this.fia);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWe() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.fia);
            this.mHandler.removeCallbacks(this.fib);
            this.fib = null;
            this.fia = null;
            this.mHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
        }
        if (this.fhZ != null) {
            this.fhZ = null;
        }
        if (this.fhY != null) {
            this.fhY = null;
        }
        this.cdm = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qE(String str) {
        if (this.fhZ == null) {
            this.fhZ = new b(this.mContext);
            this.fhZ.setTextSize(1, 18.0f);
        }
        this.fhZ.setText(str);
        this.fhY = new RelativeLayout(this.mContext);
        this.fhY.setBackgroundResource(f.C0146f.bg_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.fhY.addView(this.fhZ, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.fhY, layoutParams2);
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
    private boolean aWf() {
        List<String> bR = bR(this.mContext);
        if (bR == null || bR.size() == 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1).get(0);
        String shortString = runningTaskInfo.baseActivity.toShortString();
        String shortString2 = runningTaskInfo.topActivity.toShortString();
        for (String str : bR) {
            if (shortString.equals(str) || shortString2.equals(str)) {
                return true;
            }
            while (r3.hasNext()) {
            }
        }
        return false;
    }

    private List<String> bR(Context context) {
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
        private int MJ;
        private LinearGradient fie;
        private Matrix fif;
        private int fig;
        private boolean mAnimating;
        private Paint mPaint;

        public b(Context context) {
            super(context);
            this.MJ = 0;
            this.fig = 0;
            this.mAnimating = true;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mAnimating && this.fif != null) {
                this.fig += this.MJ / 10;
                if (this.fig > this.MJ * 2) {
                    this.fig = -this.MJ;
                }
                this.fif.setTranslate(this.fig, 0.0f);
                this.fie.setLocalMatrix(this.fif);
                postInvalidateDelayed(50L);
            }
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.MJ == 0) {
                this.MJ = getMeasuredWidth();
                if (this.MJ > 0) {
                    this.mPaint = getPaint();
                    this.fie = new LinearGradient(-this.MJ, 0.0f, 0.0f, 0.0f, new int[]{1610612736, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.mPaint.setShader(this.fie);
                    this.fif = new Matrix();
                }
            }
        }
    }
}
