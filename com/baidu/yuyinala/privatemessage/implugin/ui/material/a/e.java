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
    private b peg;
    private a peh;

    /* loaded from: classes11.dex */
    public interface a {
        void els();
    }

    public static e elr() {
        return new e();
    }

    public void NL(int i) {
        if (this.peg != null && this.mIsLoading) {
            this.peg.NM(i);
        }
    }

    public void showToast(Context context, String str) {
        if (this.peg != null && this.mIsLoading) {
            this.peg.hideLoading();
        }
        this.peg = new b(context);
        this.peg.showToast(str);
    }

    public void bv(Context context, String str) {
        if (this.peg != null && this.mIsLoading) {
            this.peg.hideLoading();
        }
        this.peg = new b(context);
        this.peg.Yp(str);
    }

    public void bw(Context context, String str) {
        if (this.peg != null && this.mIsLoading) {
            this.peg.hideLoading();
        }
        this.peg = new b(context);
        this.peg.Yq(str);
    }

    public void hideLoading() {
        if (this.peg != null && this.mIsLoading) {
            this.peg.hideLoading();
        }
    }

    public void dismiss() {
        hideLoading();
        if (this.peg != null) {
            this.peg.cancel();
        }
        this.peh = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends Toast {
        private TextView hxD;
        private Context mContext;
        private Handler mHandler;
        private WindowManager.LayoutParams mParams;
        private Runnable mRunnable;
        private View mView;
        private WindowManager mWM;
        private ImageView pei;
        private ImageView pej;

        @SuppressLint({"InflateParams"})
        public b(Context context) {
            super(context);
            this.mHandler = new Handler();
            this.mContext = context;
            this.mWM = (WindowManager) this.mContext.getSystemService("window");
            this.mView = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_menu_toast_dialog, (ViewGroup) null);
            this.hxD = (TextView) this.mView.findViewById(a.f.tipsText);
            this.pei = (ImageView) this.mView.findViewById(a.f.tipsImage);
            this.pej = (ImageView) this.mView.findViewById(a.f.subscribe_image);
        }

        public void NM(int i) {
            if (this.mWM != null && this.mView != null && e.this.mIsLoading && this.mParams != null) {
                this.mParams.y = i;
                this.mWM.updateViewLayout(this.mView, this.mParams);
            }
        }

        public void hideLoading() {
            if (this.mView != null) {
                e.this.mIsLoading = false;
                try {
                    ((AnimationDrawable) this.pei.getDrawable()).stop();
                    this.mWM.removeView(this.mView);
                } catch (Exception e) {
                    Log.e("ToastDialog", e.getMessage());
                }
                if (e.this.peh != null) {
                    e.this.peh.els();
                }
                e.this.peh = null;
                this.mHandler.removeCallbacks(this.mRunnable);
            }
        }

        public void showToast(String str) {
            this.pei.setVisibility(8);
            this.pej.setVisibility(8);
            setView(this.mView);
            setDuration(0);
            setGravity(80, 0, ((int) this.mContext.getResources().getDimension(a.d.bd_im_chat_bottom_bar)) + 44);
            if (!TextUtils.isEmpty(str)) {
                this.hxD.setText(str);
            }
            show();
        }

        public void Yp(String str) {
            this.pei.setVisibility(8);
            this.pej.setVisibility(8);
            setView(this.mView);
            setDuration(0);
            setGravity(17, 0, 0);
            if (!TextUtils.isEmpty(str)) {
                this.hxD.setText(str);
            }
            show();
        }

        public void Yq(String str) {
            this.pei.setVisibility(8);
            this.mView.setMinimumHeight(f.dip2px(this.mContext, 104.0f));
            this.mView.setPadding(f.dip2px(this.mContext, 26.0f), 0, f.dip2px(this.mContext, 26.0f), 0);
            this.hxD.setTextSize(13.0f);
            setView(this.mView);
            setDuration(0);
            setGravity(17, 0, 0);
            if (!TextUtils.isEmpty(str)) {
                this.hxD.setText(str);
            }
            show();
        }
    }
}
