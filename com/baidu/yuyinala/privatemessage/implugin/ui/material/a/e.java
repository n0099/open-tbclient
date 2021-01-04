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
/* loaded from: classes11.dex */
public class e {
    private boolean mIsLoading = false;
    private b oYu;
    private a oYv;

    /* loaded from: classes11.dex */
    public interface a {
        void emR();
    }

    public static e emQ() {
        return new e();
    }

    public void OX(int i) {
        if (this.oYu != null && this.mIsLoading) {
            this.oYu.OY(i);
        }
    }

    public void showToast(Context context, String str) {
        if (this.oYu != null && this.mIsLoading) {
            this.oYu.hideLoading();
        }
        this.oYu = new b(context);
        this.oYu.showToast(str);
    }

    public void bw(Context context, String str) {
        if (this.oYu != null && this.mIsLoading) {
            this.oYu.hideLoading();
        }
        this.oYu = new b(context);
        this.oYu.Yw(str);
    }

    public void bx(Context context, String str) {
        if (this.oYu != null && this.mIsLoading) {
            this.oYu.hideLoading();
        }
        this.oYu = new b(context);
        this.oYu.Yx(str);
    }

    public void hideLoading() {
        if (this.oYu != null && this.mIsLoading) {
            this.oYu.hideLoading();
        }
    }

    public void dismiss() {
        hideLoading();
        if (this.oYu != null) {
            this.oYu.cancel();
        }
        this.oYv = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Toast {
        private TextView hxZ;
        private Context mContext;
        private Handler mHandler;
        private WindowManager.LayoutParams mParams;
        private Runnable mRunnable;
        private View mView;
        private WindowManager mWM;
        private ImageView oYw;
        private ImageView oYx;

        @SuppressLint({"InflateParams"})
        public b(Context context) {
            super(context);
            this.mHandler = new Handler();
            this.mContext = context;
            this.mWM = (WindowManager) this.mContext.getSystemService("window");
            this.mView = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_menu_toast_dialog, (ViewGroup) null);
            this.hxZ = (TextView) this.mView.findViewById(a.f.tipsText);
            this.oYw = (ImageView) this.mView.findViewById(a.f.tipsImage);
            this.oYx = (ImageView) this.mView.findViewById(a.f.subscribe_image);
        }

        public void OY(int i) {
            if (this.mWM != null && this.mView != null && e.this.mIsLoading && this.mParams != null) {
                this.mParams.y = i;
                this.mWM.updateViewLayout(this.mView, this.mParams);
            }
        }

        public void hideLoading() {
            if (this.mView != null) {
                e.this.mIsLoading = false;
                try {
                    ((AnimationDrawable) this.oYw.getDrawable()).stop();
                    this.mWM.removeView(this.mView);
                } catch (Exception e) {
                    Log.e("ToastDialog", e.getMessage());
                }
                if (e.this.oYv != null) {
                    e.this.oYv.emR();
                }
                e.this.oYv = null;
                this.mHandler.removeCallbacks(this.mRunnable);
            }
        }

        public void showToast(String str) {
            this.oYw.setVisibility(8);
            this.oYx.setVisibility(8);
            setView(this.mView);
            setDuration(0);
            setGravity(80, 0, ((int) this.mContext.getResources().getDimension(a.d.bd_im_chat_bottom_bar)) + 44);
            if (!TextUtils.isEmpty(str)) {
                this.hxZ.setText(str);
            }
            show();
        }

        public void Yw(String str) {
            this.oYw.setVisibility(8);
            this.oYx.setVisibility(8);
            setView(this.mView);
            setDuration(0);
            setGravity(17, 0, 0);
            if (!TextUtils.isEmpty(str)) {
                this.hxZ.setText(str);
            }
            show();
        }

        public void Yx(String str) {
            this.oYw.setVisibility(8);
            this.mView.setMinimumHeight(f.dip2px(this.mContext, 104.0f));
            this.mView.setPadding(f.dip2px(this.mContext, 26.0f), 0, f.dip2px(this.mContext, 26.0f), 0);
            this.hxZ.setTextSize(13.0f);
            setView(this.mView);
            setDuration(0);
            setGravity(17, 0, 0);
            if (!TextUtils.isEmpty(str)) {
                this.hxZ.setText(str);
            }
            show();
        }
    }
}
