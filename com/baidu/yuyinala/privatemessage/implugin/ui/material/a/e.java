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
/* loaded from: classes4.dex */
public class e {
    private boolean mIsLoading = false;
    private b oDh;
    private a oDi;

    /* loaded from: classes4.dex */
    public interface a {
        void eha();
    }

    public static e egZ() {
        return new e();
    }

    public void Ol(int i) {
        if (this.oDh != null && this.mIsLoading) {
            this.oDh.Om(i);
        }
    }

    public void showToast(Context context, String str) {
        if (this.oDh != null && this.mIsLoading) {
            this.oDh.hideLoading();
        }
        this.oDh = new b(context);
        this.oDh.showToast(str);
    }

    public void bn(Context context, String str) {
        if (this.oDh != null && this.mIsLoading) {
            this.oDh.hideLoading();
        }
        this.oDh = new b(context);
        this.oDh.Xr(str);
    }

    public void bo(Context context, String str) {
        if (this.oDh != null && this.mIsLoading) {
            this.oDh.hideLoading();
        }
        this.oDh = new b(context);
        this.oDh.Xs(str);
    }

    public void hideLoading() {
        if (this.oDh != null && this.mIsLoading) {
            this.oDh.hideLoading();
        }
    }

    public void dismiss() {
        hideLoading();
        if (this.oDh != null) {
            this.oDh.cancel();
        }
        this.oDi = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends Toast {
        private TextView hct;
        private Context mContext;
        private Handler mHandler;
        private WindowManager.LayoutParams mParams;
        private Runnable mRunnable;
        private View mView;
        private WindowManager mWM;
        private ImageView oDj;
        private ImageView oDk;

        @SuppressLint({"InflateParams"})
        public b(Context context) {
            super(context);
            this.mHandler = new Handler();
            this.mContext = context;
            this.mWM = (WindowManager) this.mContext.getSystemService("window");
            this.mView = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_menu_toast_dialog, (ViewGroup) null);
            this.hct = (TextView) this.mView.findViewById(a.f.tipsText);
            this.oDj = (ImageView) this.mView.findViewById(a.f.tipsImage);
            this.oDk = (ImageView) this.mView.findViewById(a.f.subscribe_image);
        }

        public void Om(int i) {
            if (this.mWM != null && this.mView != null && e.this.mIsLoading && this.mParams != null) {
                this.mParams.y = i;
                this.mWM.updateViewLayout(this.mView, this.mParams);
            }
        }

        public void hideLoading() {
            if (this.mView != null) {
                e.this.mIsLoading = false;
                try {
                    ((AnimationDrawable) this.oDj.getDrawable()).stop();
                    this.mWM.removeView(this.mView);
                } catch (Exception e) {
                    Log.e("ToastDialog", e.getMessage());
                }
                if (e.this.oDi != null) {
                    e.this.oDi.eha();
                }
                e.this.oDi = null;
                this.mHandler.removeCallbacks(this.mRunnable);
            }
        }

        public void showToast(String str) {
            this.oDj.setVisibility(8);
            this.oDk.setVisibility(8);
            setView(this.mView);
            setDuration(0);
            setGravity(80, 0, ((int) this.mContext.getResources().getDimension(a.d.bd_im_chat_bottom_bar)) + 44);
            if (!TextUtils.isEmpty(str)) {
                this.hct.setText(str);
            }
            show();
        }

        public void Xr(String str) {
            this.oDj.setVisibility(8);
            this.oDk.setVisibility(8);
            setView(this.mView);
            setDuration(0);
            setGravity(17, 0, 0);
            if (!TextUtils.isEmpty(str)) {
                this.hct.setText(str);
            }
            show();
        }

        public void Xs(String str) {
            this.oDj.setVisibility(8);
            this.mView.setMinimumHeight(f.dip2px(this.mContext, 104.0f));
            this.mView.setPadding(f.dip2px(this.mContext, 26.0f), 0, f.dip2px(this.mContext, 26.0f), 0);
            this.hct.setTextSize(13.0f);
            setView(this.mView);
            setDuration(0);
            setGravity(17, 0, 0);
            if (!TextUtils.isEmpty(str)) {
                this.hct.setText(str);
            }
            show();
        }
    }
}
