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
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tieba.e;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private TextView fyA;
    private Runnable fyB;
    private Runnable fyC;
    private RelativeLayout fyz;
    private Context mContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private volatile boolean mIsShowing;

    /* loaded from: classes.dex */
    public interface a {
        c getSplash();
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void bbc() {
        if (!this.mIsShowing && isMainProcess() && bbd()) {
            if (this.mHandlerThread == null) {
                this.mHandlerThread = new HandlerThread("splash-thread");
                this.mHandlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(this.mHandlerThread.getLooper());
            }
            if (this.fyB == null) {
                this.fyB = new Runnable() { // from class: com.baidu.tieba.l.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.fyz != null) {
                            ((WindowManager) c.this.mContext.getSystemService(WindowConfig.JSON_WINDOW_KEY)).removeViewImmediate(c.this.fyz);
                            c.this.clean();
                        }
                    }
                };
            }
            if (this.fyC == null) {
                this.fyC = new Runnable() { // from class: com.baidu.tieba.l.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rK(c.this.mContext.getString(e.j.data_init));
                    }
                };
            }
            this.mHandler.removeCallbacks(this.fyC);
            this.mHandler.postAtFrontOfQueue(this.fyC);
            this.mIsShowing = true;
            this.mHandler.postDelayed(this.fyB, 20000L);
        }
    }

    public void hide() {
        if (this.fyz != null && this.fyA != null) {
            this.mHandler.removeCallbacks(this.fyB);
            this.mHandler.post(this.fyB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clean() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.fyB);
            this.mHandler.removeCallbacks(this.fyC);
            this.fyC = null;
            this.fyB = null;
            this.mHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
        }
        if (this.fyA != null) {
            this.fyA = null;
        }
        if (this.fyz != null) {
            this.fyz = null;
        }
        this.mIsShowing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rK(String str) {
        if (this.fyA == null) {
            this.fyA = new b(this.mContext);
            this.fyA.setTextSize(1, 18.0f);
        }
        this.fyA.setText(str);
        this.fyz = new RelativeLayout(this.mContext);
        this.fyz.setBackgroundResource(e.f.bg_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.fyz.addView(this.fyA, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.mContext.getSystemService(WindowConfig.JSON_WINDOW_KEY)).addView(this.fyz, layoutParams2);
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
    private boolean bbd() {
        List<String> cG = cG(this.mContext);
        if (cG == null || cG.size() == 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1).get(0);
        String shortString = runningTaskInfo.baseActivity.toShortString();
        String shortString2 = runningTaskInfo.topActivity.toShortString();
        for (String str : cG) {
            if (shortString.equals(str) || shortString2.equals(str)) {
                return true;
            }
            while (r3.hasNext()) {
            }
        }
        return false;
    }

    private List<String> cG(Context context) {
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
        private int PE;
        private LinearGradient fyE;
        private Matrix fyF;
        private int fyG;
        private boolean mAnimating;
        private Paint mPaint;

        public b(Context context) {
            super(context);
            this.PE = 0;
            this.fyG = 0;
            this.mAnimating = true;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mAnimating && this.fyF != null) {
                this.fyG += this.PE / 10;
                if (this.fyG > this.PE * 2) {
                    this.fyG = -this.PE;
                }
                this.fyF.setTranslate(this.fyG, 0.0f);
                this.fyE.setLocalMatrix(this.fyF);
                postInvalidateDelayed(50L);
            }
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.PE == 0) {
                this.PE = getMeasuredWidth();
                if (this.PE > 0) {
                    this.mPaint = getPaint();
                    this.fyE = new LinearGradient(-this.PE, 0.0f, 0.0f, 0.0f, new int[]{1610612736, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.mPaint.setShader(this.fyE);
                    this.fyF = new Matrix();
                }
            }
        }
    }
}
