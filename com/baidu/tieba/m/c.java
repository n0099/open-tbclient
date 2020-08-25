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
/* loaded from: classes2.dex */
public class c {
    private RelativeLayout kim;
    private TextView kin;
    private Runnable kio;
    private Runnable kip;
    private Context mContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private volatile boolean mIsShowing;

    /* loaded from: classes2.dex */
    public interface a {
        c getSplash();
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void cRu() {
        if (!this.mIsShowing && isMainProcess() && cRv()) {
            if (this.mHandlerThread == null) {
                this.mHandlerThread = new HandlerThread("splash-thread");
                this.mHandlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(this.mHandlerThread.getLooper());
            }
            if (this.kio == null) {
                this.kio = new Runnable() { // from class: com.baidu.tieba.m.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.kim != null) {
                            ((WindowManager) c.this.mContext.getSystemService("window")).removeViewImmediate(c.this.kim);
                            c.this.clean();
                        }
                    }
                };
            }
            if (this.kip == null) {
                this.kip = new Runnable() { // from class: com.baidu.tieba.m.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ML(c.this.mContext.getString(R.string.data_init));
                    }
                };
            }
            this.mHandler.removeCallbacks(this.kip);
            this.mHandler.postAtFrontOfQueue(this.kip);
            this.mIsShowing = true;
            this.mHandler.postDelayed(this.kio, 20000L);
        }
    }

    public void hide() {
        if (this.kim != null && this.kin != null) {
            this.mHandler.removeCallbacks(this.kio);
            this.mHandler.post(this.kio);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clean() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.kio);
            this.mHandler.removeCallbacks(this.kip);
            this.kip = null;
            this.kio = null;
            this.mHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
        }
        if (this.kin != null) {
            this.kin = null;
        }
        if (this.kim != null) {
            this.kim = null;
        }
        this.mIsShowing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ML(String str) {
        if (this.kin == null) {
            this.kin = new b(this.mContext);
            this.kin.setTextSize(1, 18.0f);
        }
        this.kin.setText(str);
        this.kim = new RelativeLayout(this.mContext);
        this.kim.setBackgroundResource(R.drawable.pic_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.kim.addView(this.kin, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = PlatformPlugin.DEFAULT_SYSTEM_UI;
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.kim, layoutParams2);
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
    private boolean cRv() {
        List<String> fs = fs(this.mContext);
        if (fs == null || fs.size() == 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1).get(0);
        String shortString = runningTaskInfo.baseActivity.toShortString();
        String shortString2 = runningTaskInfo.topActivity.toShortString();
        for (String str : fs) {
            if (shortString.equals(str) || shortString2.equals(str)) {
                return true;
            }
            while (r3.hasNext()) {
            }
        }
        return false;
    }

    private List<String> fs(Context context) {
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
    /* loaded from: classes2.dex */
    public class b extends TextView {
        private LinearGradient bop;
        private Matrix kir;
        private int kis;
        private boolean mAnimating;
        private Paint mPaint;
        private int mViewWidth;

        public b(Context context) {
            super(context);
            this.mViewWidth = 0;
            this.kis = 0;
            this.mAnimating = true;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mAnimating && this.kir != null) {
                this.kis += this.mViewWidth / 10;
                if (this.kis > this.mViewWidth * 2) {
                    this.kis = -this.mViewWidth;
                }
                this.kir.setTranslate(this.kis, 0.0f);
                this.bop.setLocalMatrix(this.kir);
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
                    this.bop = new LinearGradient(-this.mViewWidth, 0.0f, 0.0f, 0.0f, new int[]{1610612736, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.mPaint.setShader(this.bop);
                    this.kir = new Matrix();
                }
            }
        }
    }
}
