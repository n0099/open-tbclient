package com.bigkoo.svprogresshud;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bigkoo.svprogresshud.listener.OnDismissListener;
import com.bigkoo.svprogresshud.view.SVCircleProgressBar;
import com.bigkoo.svprogresshud.view.SVProgressDefaultView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class SVProgressHUD {
    private static final long DISMISSDELAYED = 1000;
    private WeakReference<Context> contextWeak;
    private ViewGroup decorView;
    private int gravity;
    private Animation inAnim;
    private boolean isDismissing;
    private boolean isShowing;
    private SVProgressHUDMaskType mSVProgressHUDMaskType;
    private SVProgressDefaultView mSharedView;
    private OnDismissListener onDismissListener;
    private Animation outAnim;
    private ViewGroup rootView;
    private final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2, 80);
    private Handler mHandler = new Handler() { // from class: com.bigkoo.svprogresshud.SVProgressHUD.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            SVProgressHUD.this.dismiss();
        }
    };
    private final View.OnTouchListener onCancelableTouchListener = new View.OnTouchListener() { // from class: com.bigkoo.svprogresshud.SVProgressHUD.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                SVProgressHUD.this.dismiss();
                SVProgressHUD.this.setCancelable(false);
            }
            return false;
        }
    };
    private Animation.AnimationListener outAnimListener = new Animation.AnimationListener() { // from class: com.bigkoo.svprogresshud.SVProgressHUD.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SVProgressHUD.this.dismissImmediately();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    /* loaded from: classes5.dex */
    public enum SVProgressHUDMaskType {
        None,
        Clear,
        Black,
        Gradient,
        ClearCancel,
        BlackCancel,
        GradientCancel
    }

    public SVProgressHUD(Context context) {
        this.gravity = 17;
        this.contextWeak = new WeakReference<>(context);
        this.gravity = 17;
        initViews();
        initDefaultView();
        initAnimation();
    }

    protected void initViews() {
        Context context = this.contextWeak.get();
        if (context != null) {
            LayoutInflater from = LayoutInflater.from(context);
            this.decorView = (ViewGroup) ((Activity) context).getWindow().getDecorView().findViewById(16908290);
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_svprogresshud, (ViewGroup) null, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    protected void initDefaultView() {
        Context context = this.contextWeak.get();
        if (context != null) {
            this.mSharedView = new SVProgressDefaultView(context);
            this.params.gravity = this.gravity;
            this.mSharedView.setLayoutParams(this.params);
        }
    }

    protected void initAnimation() {
        if (this.inAnim == null) {
            this.inAnim = getInAnimation();
        }
        if (this.outAnim == null) {
            this.outAnim = getOutAnimation();
        }
    }

    private void onAttached() {
        this.isShowing = true;
        this.decorView.addView(this.rootView);
        if (this.mSharedView.getParent() != null) {
            ((ViewGroup) this.mSharedView.getParent()).removeView(this.mSharedView);
        }
        this.rootView.addView(this.mSharedView);
    }

    private void svShow() {
        this.mHandler.removeCallbacksAndMessages(null);
        onAttached();
        this.mSharedView.startAnimation(this.inAnim);
    }

    public void show() {
        if (!isShowing()) {
            setMaskType(SVProgressHUDMaskType.Black);
            this.mSharedView.show();
            svShow();
        }
    }

    public void showWithMaskType(SVProgressHUDMaskType sVProgressHUDMaskType) {
        if (!isShowing()) {
            setMaskType(sVProgressHUDMaskType);
            this.mSharedView.show();
            svShow();
        }
    }

    public void showWithStatus(String str) {
        if (!isShowing()) {
            setMaskType(SVProgressHUDMaskType.Black);
            this.mSharedView.showWithStatus(str);
            svShow();
        }
    }

    public void showWithStatus(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        if (!isShowing()) {
            setMaskType(sVProgressHUDMaskType);
            this.mSharedView.showWithStatus(str);
            svShow();
        }
    }

    public void showInfoWithStatus(String str) {
        if (!isShowing()) {
            setMaskType(SVProgressHUDMaskType.Black);
            this.mSharedView.showInfoWithStatus(str);
            svShow();
            scheduleDismiss();
        }
    }

    public void showInfoWithStatus(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        if (!isShowing()) {
            setMaskType(sVProgressHUDMaskType);
            this.mSharedView.showInfoWithStatus(str);
            svShow();
            scheduleDismiss();
        }
    }

    public void showSuccessWithStatus(String str) {
        if (!isShowing()) {
            setMaskType(SVProgressHUDMaskType.Black);
            this.mSharedView.showSuccessWithStatus(str);
            svShow();
            scheduleDismiss();
        }
    }

    public void showSuccessWithStatus(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        if (!isShowing()) {
            setMaskType(sVProgressHUDMaskType);
            this.mSharedView.showSuccessWithStatus(str);
            svShow();
            scheduleDismiss();
        }
    }

    public void showErrorWithStatus(String str) {
        if (!isShowing()) {
            setMaskType(SVProgressHUDMaskType.Black);
            this.mSharedView.showErrorWithStatus(str);
            svShow();
            scheduleDismiss();
        }
    }

    public void showErrorWithStatus(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        if (!isShowing()) {
            setMaskType(sVProgressHUDMaskType);
            this.mSharedView.showErrorWithStatus(str);
            svShow();
            scheduleDismiss();
        }
    }

    public void showWithProgress(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        if (!isShowing()) {
            setMaskType(sVProgressHUDMaskType);
            this.mSharedView.showWithProgress(str);
            svShow();
        }
    }

    public SVCircleProgressBar getProgressBar() {
        return this.mSharedView.getCircleProgressBar();
    }

    public void setText(String str) {
        this.mSharedView.setText(str);
    }

    private void setMaskType(SVProgressHUDMaskType sVProgressHUDMaskType) {
        this.mSVProgressHUDMaskType = sVProgressHUDMaskType;
        switch (this.mSVProgressHUDMaskType) {
            case None:
                configMaskType(17170445, false, false);
                return;
            case Clear:
                configMaskType(17170445, true, false);
                return;
            case ClearCancel:
                configMaskType(17170445, true, true);
                return;
            case Black:
                configMaskType(R.color.bgColor_overlay, true, false);
                return;
            case BlackCancel:
                configMaskType(R.color.bgColor_overlay, true, true);
                return;
            case Gradient:
                configMaskType(R.drawable.bg_overlay_gradient, true, false);
                return;
            case GradientCancel:
                configMaskType(R.drawable.bg_overlay_gradient, true, true);
                return;
            default:
                return;
        }
    }

    private void configMaskType(int i, boolean z, boolean z2) {
        this.rootView.setBackgroundResource(i);
        this.rootView.setClickable(z);
        setCancelable(z2);
    }

    public boolean isShowing() {
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (!this.isDismissing) {
            this.isDismissing = true;
            this.outAnim.setAnimationListener(this.outAnimListener);
            this.mSharedView.dismiss();
            this.mSharedView.startAnimation(this.outAnim);
        }
    }

    public void dismissImmediately() {
        this.mSharedView.dismiss();
        this.rootView.removeView(this.mSharedView);
        this.decorView.removeView(this.rootView);
        this.isShowing = false;
        this.isDismissing = false;
        if (this.onDismissListener != null) {
            this.onDismissListener.onDismiss(this);
        }
    }

    public Animation getInAnimation() {
        Context context = this.contextWeak.get();
        if (context == null) {
            return null;
        }
        return AnimationUtils.loadAnimation(context, SVProgressHUDAnimateUtil.getAnimationResource(this.gravity, true));
    }

    public Animation getOutAnimation() {
        Context context = this.contextWeak.get();
        if (context == null) {
            return null;
        }
        return AnimationUtils.loadAnimation(context, SVProgressHUDAnimateUtil.getAnimationResource(this.gravity, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCancelable(boolean z) {
        View findViewById = this.rootView.findViewById(R.id.sv_outmost_container);
        if (z) {
            findViewById.setOnTouchListener(this.onCancelableTouchListener);
        } else {
            findViewById.setOnTouchListener(null);
        }
    }

    private void scheduleDismiss() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.sendEmptyMessageDelayed(0, 1000L);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    public OnDismissListener getOnDismissListener() {
        return this.onDismissListener;
    }
}
