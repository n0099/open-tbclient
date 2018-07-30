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
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private volatile boolean cdo;
    private RelativeLayout fif;
    private TextView fig;
    private Runnable fih;
    private Runnable fii;
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

    public void aWh() {
        if (!this.cdo && isMainProcess() && aWj()) {
            if (this.mHandlerThread == null) {
                this.mHandlerThread = new HandlerThread("splash-thread");
                this.mHandlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(this.mHandlerThread.getLooper());
            }
            if (this.fih == null) {
                this.fih = new Runnable() { // from class: com.baidu.tieba.l.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.fif != null) {
                            ((WindowManager) c.this.mContext.getSystemService("window")).removeViewImmediate(c.this.fif);
                            c.this.aWi();
                        }
                    }
                };
            }
            if (this.fii == null) {
                this.fii = new Runnable() { // from class: com.baidu.tieba.l.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.qB(c.this.mContext.getString(d.j.data_init));
                    }
                };
            }
            this.mHandler.removeCallbacks(this.fii);
            this.mHandler.postAtFrontOfQueue(this.fii);
            this.cdo = true;
            this.mHandler.postDelayed(this.fih, 20000L);
        }
    }

    public void hide() {
        if (this.fif != null && this.fig != null) {
            this.mHandler.removeCallbacks(this.fih);
            this.mHandler.post(this.fih);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWi() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.fih);
            this.mHandler.removeCallbacks(this.fii);
            this.fii = null;
            this.fih = null;
            this.mHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
        }
        if (this.fig != null) {
            this.fig = null;
        }
        if (this.fif != null) {
            this.fif = null;
        }
        this.cdo = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB(String str) {
        if (this.fig == null) {
            this.fig = new b(this.mContext);
            this.fig.setTextSize(1, 18.0f);
        }
        this.fig.setText(str);
        this.fif = new RelativeLayout(this.mContext);
        this.fif.setBackgroundResource(d.f.bg_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.fif.addView(this.fig, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.fif, layoutParams2);
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
    private boolean aWj() {
        List<String> bS = bS(this.mContext);
        if (bS == null || bS.size() == 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1).get(0);
        String shortString = runningTaskInfo.baseActivity.toShortString();
        String shortString2 = runningTaskInfo.topActivity.toShortString();
        for (String str : bS) {
            if (shortString.equals(str) || shortString2.equals(str)) {
                return true;
            }
            while (r3.hasNext()) {
            }
        }
        return false;
    }

    private List<String> bS(Context context) {
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
        private LinearGradient fik;
        private Matrix fil;
        private int fim;
        private boolean mAnimating;
        private Paint mPaint;

        public b(Context context) {
            super(context);
            this.MJ = 0;
            this.fim = 0;
            this.mAnimating = true;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mAnimating && this.fil != null) {
                this.fim += this.MJ / 10;
                if (this.fim > this.MJ * 2) {
                    this.fim = -this.MJ;
                }
                this.fil.setTranslate(this.fim, 0.0f);
                this.fik.setLocalMatrix(this.fil);
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
                    this.fik = new LinearGradient(-this.MJ, 0.0f, 0.0f, 0.0f, new int[]{1610612736, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.mPaint.setShader(this.fik);
                    this.fil = new Matrix();
                }
            }
        }
    }
}
