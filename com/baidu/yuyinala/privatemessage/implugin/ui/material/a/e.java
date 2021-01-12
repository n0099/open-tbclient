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
    private b oTS;
    private a oTT;

    /* loaded from: classes10.dex */
    public interface a {
        void eiY();
    }

    public static e eiX() {
        return new e();
    }

    public void Nq(int i) {
        if (this.oTS != null && this.mIsLoading) {
            this.oTS.Nr(i);
        }
    }

    public void showToast(Context context, String str) {
        if (this.oTS != null && this.mIsLoading) {
            this.oTS.hideLoading();
        }
        this.oTS = new b(context);
        this.oTS.showToast(str);
    }

    public void bw(Context context, String str) {
        if (this.oTS != null && this.mIsLoading) {
            this.oTS.hideLoading();
        }
        this.oTS = new b(context);
        this.oTS.Xn(str);
    }

    public void bx(Context context, String str) {
        if (this.oTS != null && this.mIsLoading) {
            this.oTS.hideLoading();
        }
        this.oTS = new b(context);
        this.oTS.Xo(str);
    }

    public void hideLoading() {
        if (this.oTS != null && this.mIsLoading) {
            this.oTS.hideLoading();
        }
    }

    public void dismiss() {
        hideLoading();
        if (this.oTS != null) {
            this.oTS.cancel();
        }
        this.oTT = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends Toast {
        private TextView htt;
        private Context mContext;
        private Handler mHandler;
        private WindowManager.LayoutParams mParams;
        private Runnable mRunnable;
        private View mView;
        private WindowManager mWM;
        private ImageView oTU;
        private ImageView oTV;

        @SuppressLint({"InflateParams"})
        public b(Context context) {
            super(context);
            this.mHandler = new Handler();
            this.mContext = context;
            this.mWM = (WindowManager) this.mContext.getSystemService("window");
            this.mView = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_menu_toast_dialog, (ViewGroup) null);
            this.htt = (TextView) this.mView.findViewById(a.f.tipsText);
            this.oTU = (ImageView) this.mView.findViewById(a.f.tipsImage);
            this.oTV = (ImageView) this.mView.findViewById(a.f.subscribe_image);
        }

        public void Nr(int i) {
            if (this.mWM != null && this.mView != null && e.this.mIsLoading && this.mParams != null) {
                this.mParams.y = i;
                this.mWM.updateViewLayout(this.mView, this.mParams);
            }
        }

        public void hideLoading() {
            if (this.mView != null) {
                e.this.mIsLoading = false;
                try {
                    ((AnimationDrawable) this.oTU.getDrawable()).stop();
                    this.mWM.removeView(this.mView);
                } catch (Exception e) {
                    Log.e("ToastDialog", e.getMessage());
                }
                if (e.this.oTT != null) {
                    e.this.oTT.eiY();
                }
                e.this.oTT = null;
                this.mHandler.removeCallbacks(this.mRunnable);
            }
        }

        public void showToast(String str) {
            this.oTU.setVisibility(8);
            this.oTV.setVisibility(8);
            setView(this.mView);
            setDuration(0);
            setGravity(80, 0, ((int) this.mContext.getResources().getDimension(a.d.bd_im_chat_bottom_bar)) + 44);
            if (!TextUtils.isEmpty(str)) {
                this.htt.setText(str);
            }
            show();
        }

        public void Xn(String str) {
            this.oTU.setVisibility(8);
            this.oTV.setVisibility(8);
            setView(this.mView);
            setDuration(0);
            setGravity(17, 0, 0);
            if (!TextUtils.isEmpty(str)) {
                this.htt.setText(str);
            }
            show();
        }

        public void Xo(String str) {
            this.oTU.setVisibility(8);
            this.mView.setMinimumHeight(f.dip2px(this.mContext, 104.0f));
            this.mView.setPadding(f.dip2px(this.mContext, 26.0f), 0, f.dip2px(this.mContext, 26.0f), 0);
            this.htt.setTextSize(13.0f);
            setView(this.mView);
            setDuration(0);
            setGravity(17, 0, 0);
            if (!TextUtils.isEmpty(str)) {
                this.htt.setText(str);
            }
            show();
        }
    }
}
