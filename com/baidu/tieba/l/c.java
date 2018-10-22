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
    private RelativeLayout fxc;
    private TextView fxd;
    private Runnable fxe;
    private Runnable fxf;
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

    public void bbD() {
        if (!this.mIsShowing && isMainProcess() && bbE()) {
            if (this.mHandlerThread == null) {
                this.mHandlerThread = new HandlerThread("splash-thread");
                this.mHandlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(this.mHandlerThread.getLooper());
            }
            if (this.fxe == null) {
                this.fxe = new Runnable() { // from class: com.baidu.tieba.l.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.fxc != null) {
                            ((WindowManager) c.this.mContext.getSystemService(WindowConfig.JSON_WINDOW_KEY)).removeViewImmediate(c.this.fxc);
                            c.this.clean();
                        }
                    }
                };
            }
            if (this.fxf == null) {
                this.fxf = new Runnable() { // from class: com.baidu.tieba.l.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rJ(c.this.mContext.getString(e.j.data_init));
                    }
                };
            }
            this.mHandler.removeCallbacks(this.fxf);
            this.mHandler.postAtFrontOfQueue(this.fxf);
            this.mIsShowing = true;
            this.mHandler.postDelayed(this.fxe, 20000L);
        }
    }

    public void hide() {
        if (this.fxc != null && this.fxd != null) {
            this.mHandler.removeCallbacks(this.fxe);
            this.mHandler.post(this.fxe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clean() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.fxe);
            this.mHandler.removeCallbacks(this.fxf);
            this.fxf = null;
            this.fxe = null;
            this.mHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
        }
        if (this.fxd != null) {
            this.fxd = null;
        }
        if (this.fxc != null) {
            this.fxc = null;
        }
        this.mIsShowing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ(String str) {
        if (this.fxd == null) {
            this.fxd = new b(this.mContext);
            this.fxd.setTextSize(1, 18.0f);
        }
        this.fxd.setText(str);
        this.fxc = new RelativeLayout(this.mContext);
        this.fxc.setBackgroundResource(e.f.bg_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.fxc.addView(this.fxd, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.mContext.getSystemService(WindowConfig.JSON_WINDOW_KEY)).addView(this.fxc, layoutParams2);
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
    private boolean bbE() {
        List<String> cL = cL(this.mContext);
        if (cL == null || cL.size() == 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1).get(0);
        String shortString = runningTaskInfo.baseActivity.toShortString();
        String shortString2 = runningTaskInfo.topActivity.toShortString();
        for (String str : cL) {
            if (shortString.equals(str) || shortString2.equals(str)) {
                return true;
            }
            while (r3.hasNext()) {
            }
        }
        return false;
    }

    private List<String> cL(Context context) {
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
        private int PC;
        private LinearGradient fxh;
        private Matrix fxi;
        private int fxj;
        private boolean mAnimating;
        private Paint mPaint;

        public b(Context context) {
            super(context);
            this.PC = 0;
            this.fxj = 0;
            this.mAnimating = true;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mAnimating && this.fxi != null) {
                this.fxj += this.PC / 10;
                if (this.fxj > this.PC * 2) {
                    this.fxj = -this.PC;
                }
                this.fxi.setTranslate(this.fxj, 0.0f);
                this.fxh.setLocalMatrix(this.fxi);
                postInvalidateDelayed(50L);
            }
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.PC == 0) {
                this.PC = getMeasuredWidth();
                if (this.PC > 0) {
                    this.mPaint = getPaint();
                    this.fxh = new LinearGradient(-this.PC, 0.0f, 0.0f, 0.0f, new int[]{1610612736, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.mPaint.setShader(this.fxh);
                    this.fxi = new Matrix();
                }
            }
        }
    }
}
