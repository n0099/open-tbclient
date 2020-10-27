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
    private b osk;
    private a osl;

    /* loaded from: classes4.dex */
    public interface a {
        void edn();
    }

    public static e edm() {
        return new e();
    }

    public void Nn(int i) {
        if (this.osk != null && this.mIsLoading) {
            this.osk.No(i);
        }
    }

    public void showToast(Context context, String str) {
        if (this.osk != null && this.mIsLoading) {
            this.osk.hideLoading();
        }
        this.osk = new b(context);
        this.osk.showToast(str);
    }

    public void bq(Context context, String str) {
        if (this.osk != null && this.mIsLoading) {
            this.osk.hideLoading();
        }
        this.osk = new b(context);
        this.osk.Xc(str);
    }

    public void br(Context context, String str) {
        if (this.osk != null && this.mIsLoading) {
            this.osk.hideLoading();
        }
        this.osk = new b(context);
        this.osk.Xd(str);
    }

    public void hideLoading() {
        if (this.osk != null && this.mIsLoading) {
            this.osk.hideLoading();
        }
    }

    public void dismiss() {
        hideLoading();
        if (this.osk != null) {
            this.osk.cancel();
        }
        this.osl = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends Toast {
        private TextView gWI;
        private Context mContext;
        private Handler mHandler;
        private WindowManager.LayoutParams mParams;
        private Runnable mRunnable;
        private View mView;
        private WindowManager mWM;
        private ImageView osm;
        private ImageView osn;

        @SuppressLint({"InflateParams"})
        public b(Context context) {
            super(context);
            this.mHandler = new Handler();
            this.mContext = context;
            this.mWM = (WindowManager) this.mContext.getSystemService("window");
            this.mView = LayoutInflater.from(this.mContext).inflate(a.h.bd_im_menu_toast_dialog, (ViewGroup) null);
            this.gWI = (TextView) this.mView.findViewById(a.g.tipsText);
            this.osm = (ImageView) this.mView.findViewById(a.g.tipsImage);
            this.osn = (ImageView) this.mView.findViewById(a.g.subscribe_image);
        }

        public void No(int i) {
            if (this.mWM != null && this.mView != null && e.this.mIsLoading && this.mParams != null) {
                this.mParams.y = i;
                this.mWM.updateViewLayout(this.mView, this.mParams);
            }
        }

        public void hideLoading() {
            if (this.mView != null) {
                e.this.mIsLoading = false;
                try {
                    ((AnimationDrawable) this.osm.getDrawable()).stop();
                    this.mWM.removeView(this.mView);
                } catch (Exception e) {
                    Log.e("ToastDialog", e.getMessage());
                }
                if (e.this.osl != null) {
                    e.this.osl.edn();
                }
                e.this.osl = null;
                this.mHandler.removeCallbacks(this.mRunnable);
            }
        }

        public void showToast(String str) {
            this.osm.setVisibility(8);
            this.osn.setVisibility(8);
            setView(this.mView);
            setDuration(0);
            setGravity(80, 0, ((int) this.mContext.getResources().getDimension(a.e.bd_im_chat_bottom_bar)) + 44);
            if (!TextUtils.isEmpty(str)) {
                this.gWI.setText(str);
            }
            show();
        }

        public void Xc(String str) {
            this.osm.setVisibility(8);
            this.osn.setVisibility(8);
            setView(this.mView);
            setDuration(0);
            setGravity(17, 0, 0);
            if (!TextUtils.isEmpty(str)) {
                this.gWI.setText(str);
            }
            show();
        }

        public void Xd(String str) {
            this.osm.setVisibility(8);
            this.mView.setMinimumHeight(f.dip2px(this.mContext, 104.0f));
            this.mView.setPadding(f.dip2px(this.mContext, 26.0f), 0, f.dip2px(this.mContext, 26.0f), 0);
            this.gWI.setTextSize(13.0f);
            setView(this.mView);
            setDuration(0);
            setGravity(17, 0, 0);
            if (!TextUtils.isEmpty(str)) {
                this.gWI.setText(str);
            }
            show();
        }
    }
}
