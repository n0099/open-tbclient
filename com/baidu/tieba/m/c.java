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
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.tieba.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private volatile boolean epJ;
    private RelativeLayout lrF;
    private TextView lrG;
    private Runnable lrH;
    private Runnable lrI;
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

    public void diQ() {
        if (!this.epJ && isMainProcess() && diR()) {
            if (this.mHandlerThread == null) {
                this.mHandlerThread = new HandlerThread("splash-thread");
                this.mHandlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(this.mHandlerThread.getLooper());
            }
            if (this.lrH == null) {
                this.lrH = new Runnable() { // from class: com.baidu.tieba.m.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.lrF != null) {
                            ((WindowManager) c.this.mContext.getSystemService("window")).removeViewImmediate(c.this.lrF);
                            c.this.clean();
                        }
                    }
                };
            }
            if (this.lrI == null) {
                this.lrI = new Runnable() { // from class: com.baidu.tieba.m.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.Pc(c.this.mContext.getString(R.string.data_init));
                    }
                };
            }
            this.mHandler.removeCallbacks(this.lrI);
            this.mHandler.postAtFrontOfQueue(this.lrI);
            this.epJ = true;
            this.mHandler.postDelayed(this.lrH, 20000L);
        }
    }

    public void hide() {
        if (this.lrF != null && this.lrG != null) {
            this.mHandler.removeCallbacks(this.lrH);
            this.mHandler.post(this.lrH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clean() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.lrH);
            this.mHandler.removeCallbacks(this.lrI);
            this.lrI = null;
            this.lrH = null;
            this.mHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
        }
        if (this.lrG != null) {
            this.lrG = null;
        }
        if (this.lrF != null) {
            this.lrF = null;
        }
        this.epJ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pc(String str) {
        if (this.lrG == null) {
            this.lrG = new b(this.mContext);
            this.lrG.setTextSize(1, 18.0f);
        }
        this.lrG.setText(str);
        this.lrF = new RelativeLayout(this.mContext);
        this.lrF.setBackgroundResource(R.drawable.pic_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.lrF.addView(this.lrG, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = PlatformPlugin.DEFAULT_SYSTEM_UI;
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.lrF, layoutParams2);
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
    private boolean diR() {
        List<String> gG = gG(this.mContext);
        if (gG == null || gG.size() == 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1).get(0);
        String shortString = runningTaskInfo.baseActivity.toShortString();
        String shortString2 = runningTaskInfo.topActivity.toShortString();
        for (String str : gG) {
            if (shortString.equals(str) || shortString2.equals(str)) {
                return true;
            }
            while (r3.hasNext()) {
            }
        }
        return false;
    }

    private List<String> gG(Context context) {
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
        private LinearGradient bLY;
        private Matrix lrK;
        private int lrL;
        private boolean mAnimating;
        private Paint mPaint;
        private int mViewWidth;

        public b(Context context) {
            super(context);
            this.mViewWidth = 0;
            this.lrL = 0;
            this.mAnimating = true;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mAnimating && this.lrK != null) {
                this.lrL += this.mViewWidth / 10;
                if (this.lrL > this.mViewWidth * 2) {
                    this.lrL = -this.mViewWidth;
                }
                this.lrK.setTranslate(this.lrL, 0.0f);
                this.bLY.setLocalMatrix(this.lrK);
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
                    this.bLY = new LinearGradient(-this.mViewWidth, 0.0f, 0.0f, 0.0f, new int[]{1610612736, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.mPaint.setShader(this.bLY);
                    this.lrK = new Matrix();
                }
            }
        }
    }
}
