package com.baidu.tieba.m;

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
import com.baidu.tieba.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private RelativeLayout jSQ;
    private TextView jSR;
    private Runnable jSS;
    private Runnable jST;
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

    public void cGF() {
        if (!this.mIsShowing && isMainProcess() && cGG()) {
            if (this.mHandlerThread == null) {
                this.mHandlerThread = new HandlerThread("splash-thread");
                this.mHandlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(this.mHandlerThread.getLooper());
            }
            if (this.jSS == null) {
                this.jSS = new Runnable() { // from class: com.baidu.tieba.m.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.jSQ != null) {
                            ((WindowManager) c.this.mContext.getSystemService("window")).removeViewImmediate(c.this.jSQ);
                            c.this.clean();
                        }
                    }
                };
            }
            if (this.jST == null) {
                this.jST = new Runnable() { // from class: com.baidu.tieba.m.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.JT(c.this.mContext.getString(R.string.data_init));
                    }
                };
            }
            this.mHandler.removeCallbacks(this.jST);
            this.mHandler.postAtFrontOfQueue(this.jST);
            this.mIsShowing = true;
            this.mHandler.postDelayed(this.jSS, 20000L);
        }
    }

    public void hide() {
        if (this.jSQ != null && this.jSR != null) {
            this.mHandler.removeCallbacks(this.jSS);
            this.mHandler.post(this.jSS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clean() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.jSS);
            this.mHandler.removeCallbacks(this.jST);
            this.jST = null;
            this.jSS = null;
            this.mHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
        }
        if (this.jSR != null) {
            this.jSR = null;
        }
        if (this.jSQ != null) {
            this.jSQ = null;
        }
        this.mIsShowing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JT(String str) {
        if (this.jSR == null) {
            this.jSR = new b(this.mContext);
            this.jSR.setTextSize(1, 18.0f);
        }
        this.jSR.setText(str);
        this.jSQ = new RelativeLayout(this.mContext);
        this.jSQ.setBackgroundResource(R.drawable.pic_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.jSQ.addView(this.jSR, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = PlatformPlugin.DEFAULT_SYSTEM_UI;
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.jSQ, layoutParams2);
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
    private boolean cGG() {
        List<String> fe = fe(this.mContext);
        if (fe == null || fe.size() == 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1).get(0);
        String shortString = runningTaskInfo.baseActivity.toShortString();
        String shortString2 = runningTaskInfo.topActivity.toShortString();
        for (String str : fe) {
            if (shortString.equals(str) || shortString2.equals(str)) {
                return true;
            }
            while (r3.hasNext()) {
            }
        }
        return false;
    }

    private List<String> fe(Context context) {
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
        private LinearGradient biK;
        private Matrix jSV;
        private int jSW;
        private boolean mAnimating;
        private Paint mPaint;
        private int mViewWidth;

        public b(Context context) {
            super(context);
            this.mViewWidth = 0;
            this.jSW = 0;
            this.mAnimating = true;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mAnimating && this.jSV != null) {
                this.jSW += this.mViewWidth / 10;
                if (this.jSW > this.mViewWidth * 2) {
                    this.jSW = -this.mViewWidth;
                }
                this.jSV.setTranslate(this.jSW, 0.0f);
                this.biK.setLocalMatrix(this.jSV);
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
                    this.biK = new LinearGradient(-this.mViewWidth, 0.0f, 0.0f, 0.0f, new int[]{1610612736, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.mPaint.setShader(this.biK);
                    this.jSV = new Matrix();
                }
            }
        }
    }
}
