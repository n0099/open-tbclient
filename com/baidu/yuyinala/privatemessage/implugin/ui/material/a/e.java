package com.baidu.yuyinala.privatemessage.implugin.ui.material.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.util.f;
/* loaded from: classes10.dex */
public class e {
    private boolean mIsLoading = false;
    private b pgL;
    private a pgM;

    /* loaded from: classes10.dex */
    public interface a {
        void elK();
    }

    public static e elJ() {
        return new e();
    }

    public void NQ(int i) {
        if (this.pgL != null && this.mIsLoading) {
            this.pgL.NR(i);
        }
    }

    public void showToast(Context context, String str) {
        if (this.pgL != null && this.mIsLoading) {
            this.pgL.hideLoading();
        }
        this.pgL = new b(context);
        this.pgL.showToast(str);
    }

    public void bu(Context context, String str) {
        if (this.pgL != null && this.mIsLoading) {
            this.pgL.hideLoading();
        }
        this.pgL = new b(context);
        this.pgL.YI(str);
    }

    public void bv(Context context, String str) {
        if (this.pgL != null && this.mIsLoading) {
            this.pgL.hideLoading();
        }
        this.pgL = new b(context);
        this.pgL.YJ(str);
    }

    public void hideLoading() {
        if (this.pgL != null && this.mIsLoading) {
            this.pgL.hideLoading();
        }
    }

    public void dismiss() {
        hideLoading();
        if (this.pgL != null) {
            this.pgL.cancel();
        }
        this.pgM = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends Toast {
        private TextView hzA;
        private Context mContext;
        private Handler mHandler;
        private WindowManager.LayoutParams mParams;
        private Runnable mRunnable;
        private View mView;
        private WindowManager mWM;
        private ImageView pgN;
        private ImageView pgO;

        @SuppressLint({"InflateParams"})
        public b(Context context) {
            super(context);
            this.mHandler = new Handler();
            this.mContext = context;
            this.mWM = (WindowManager) this.mContext.getSystemService("window");
            this.mView = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_menu_toast_dialog, (ViewGroup) null);
            this.hzA = (TextView) this.mView.findViewById(a.f.tipsText);
            this.pgN = (ImageView) this.mView.findViewById(a.f.tipsImage);
            this.pgO = (ImageView) this.mView.findViewById(a.f.subscribe_image);
        }

        public void NR(int i) {
            if (this.mWM != null && this.mView != null && e.this.mIsLoading && this.mParams != null) {
                this.mParams.y = i;
                this.mWM.updateViewLayout(this.mView, this.mParams);
            }
        }

        public void hideLoading() {
            if (this.mView != null) {
                e.this.mIsLoading = false;
                try {
                    ((AnimationDrawable) this.pgN.getDrawable()).stop();
                    this.mWM.removeView(this.mView);
                } catch (Exception e) {
                    Log.e("ToastDialog", e.getMessage());
                }
                if (e.this.pgM != null) {
                    e.this.pgM.elK();
                }
                e.this.pgM = null;
                this.mHandler.removeCallbacks(this.mRunnable);
            }
        }

        public void showToast(String str) {
            this.pgN.setVisibility(8);
            this.pgO.setVisibility(8);
            setView(this.mView);
            setDuration(0);
            setGravity(80, 0, ((int) this.mContext.getResources().getDimension(a.d.bd_im_chat_bottom_bar)) + 44);
            if (!TextUtils.isEmpty(str)) {
                this.hzA.setText(str);
            }
            show();
        }

        public void YI(String str) {
            this.pgN.setVisibility(8);
            this.pgO.setVisibility(8);
            setView(this.mView);
            setDuration(0);
            setGravity(17, 0, 0);
            if (!TextUtils.isEmpty(str)) {
                this.hzA.setText(str);
            }
            show();
        }

        public void YJ(String str) {
            this.pgN.setVisibility(8);
            this.mView.setMinimumHeight(f.dip2px(this.mContext, 104.0f));
            this.mView.setPadding(f.dip2px(this.mContext, 26.0f), 0, f.dip2px(this.mContext, 26.0f), 0);
            this.hzA.setTextSize(13.0f);
            setView(this.mView);
            setDuration(0);
            setGravity(17, 0, 0);
            if (!TextUtils.isEmpty(str)) {
                this.hzA.setText(str);
            }
            show();
        }
    }
}
