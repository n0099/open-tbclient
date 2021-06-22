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
/* loaded from: classes6.dex */
public class SVProgressHUD {
    public static final long DISMISSDELAYED = 1000;
    public WeakReference<Context> contextWeak;
    public ViewGroup decorView;
    public int gravity;
    public Animation inAnim;
    public boolean isDismissing;
    public boolean isShowing;
    public SVProgressHUDMaskType mSVProgressHUDMaskType;
    public SVProgressDefaultView mSharedView;
    public OnDismissListener onDismissListener;
    public Animation outAnim;
    public ViewGroup rootView;
    public final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2, 80);
    public Handler mHandler = new Handler() { // from class: com.bigkoo.svprogresshud.SVProgressHUD.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            SVProgressHUD.this.dismiss();
        }
    };
    public final View.OnTouchListener onCancelableTouchListener = new View.OnTouchListener() { // from class: com.bigkoo.svprogresshud.SVProgressHUD.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                SVProgressHUD.this.dismiss();
                SVProgressHUD.this.setCancelable(false);
            }
            return false;
        }
    };
    public Animation.AnimationListener outAnimListener = new Animation.AnimationListener() { // from class: com.bigkoo.svprogresshud.SVProgressHUD.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SVProgressHUD.this.dismissImmediately();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    };

    /* renamed from: com.bigkoo.svprogresshud.SVProgressHUD$4  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType;

        static {
            int[] iArr = new int[SVProgressHUDMaskType.values().length];
            $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType = iArr;
            try {
                iArr[SVProgressHUDMaskType.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[SVProgressHUDMaskType.Clear.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[SVProgressHUDMaskType.ClearCancel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[SVProgressHUDMaskType.Black.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[SVProgressHUDMaskType.BlackCancel.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[SVProgressHUDMaskType.Gradient.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[SVProgressHUDMaskType.GradientCancel.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes6.dex */
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

    private void configMaskType(int i2, boolean z, boolean z2) {
        this.rootView.setBackgroundResource(i2);
        this.rootView.setClickable(z);
        setCancelable(z2);
    }

    private void onAttached() {
        this.isShowing = true;
        this.decorView.addView(this.rootView);
        if (this.mSharedView.getParent() != null) {
            ((ViewGroup) this.mSharedView.getParent()).removeView(this.mSharedView);
        }
        this.rootView.addView(this.mSharedView);
    }

    private void scheduleDismiss() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.sendEmptyMessageDelayed(0, 1000L);
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

    private void setMaskType(SVProgressHUDMaskType sVProgressHUDMaskType) {
        this.mSVProgressHUDMaskType = sVProgressHUDMaskType;
        switch (AnonymousClass4.$SwitchMap$com$bigkoo$svprogresshud$SVProgressHUD$SVProgressHUDMaskType[sVProgressHUDMaskType.ordinal()]) {
            case 1:
                configMaskType(17170445, false, false);
                return;
            case 2:
                configMaskType(17170445, true, false);
                return;
            case 3:
                configMaskType(17170445, true, true);
                return;
            case 4:
                configMaskType(R.color.bgColor_overlay, true, false);
                return;
            case 5:
                configMaskType(R.color.bgColor_overlay, true, true);
                return;
            case 6:
                configMaskType(R.drawable.bg_overlay_gradient, true, false);
                return;
            case 7:
                configMaskType(R.drawable.bg_overlay_gradient, true, true);
                return;
            default:
                return;
        }
    }

    private void svShow() {
        this.mHandler.removeCallbacksAndMessages(null);
        onAttached();
        this.mSharedView.startAnimation(this.inAnim);
    }

    public void dismiss() {
        if (this.isDismissing) {
            return;
        }
        this.isDismissing = true;
        this.outAnim.setAnimationListener(this.outAnimListener);
        this.mSharedView.dismiss();
        this.mSharedView.startAnimation(this.outAnim);
    }

    public void dismissImmediately() {
        this.mSharedView.dismiss();
        this.rootView.removeView(this.mSharedView);
        this.decorView.removeView(this.rootView);
        this.isShowing = false;
        this.isDismissing = false;
        OnDismissListener onDismissListener = this.onDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
    }

    public Animation getInAnimation() {
        Context context = this.contextWeak.get();
        if (context == null) {
            return null;
        }
        return AnimationUtils.loadAnimation(context, SVProgressHUDAnimateUtil.getAnimationResource(this.gravity, true));
    }

    public OnDismissListener getOnDismissListener() {
        return this.onDismissListener;
    }

    public Animation getOutAnimation() {
        Context context = this.contextWeak.get();
        if (context == null) {
            return null;
        }
        return AnimationUtils.loadAnimation(context, SVProgressHUDAnimateUtil.getAnimationResource(this.gravity, false));
    }

    public SVCircleProgressBar getProgressBar() {
        return this.mSharedView.getCircleProgressBar();
    }

    public void initAnimation() {
        if (this.inAnim == null) {
            this.inAnim = getInAnimation();
        }
        if (this.outAnim == null) {
            this.outAnim = getOutAnimation();
        }
    }

    public void initDefaultView() {
        Context context = this.contextWeak.get();
        if (context == null) {
            return;
        }
        SVProgressDefaultView sVProgressDefaultView = new SVProgressDefaultView(context);
        this.mSharedView = sVProgressDefaultView;
        FrameLayout.LayoutParams layoutParams = this.params;
        layoutParams.gravity = this.gravity;
        sVProgressDefaultView.setLayoutParams(layoutParams);
    }

    public void initViews() {
        Context context = this.contextWeak.get();
        if (context == null) {
            return;
        }
        LayoutInflater from = LayoutInflater.from(context);
        this.decorView = (ViewGroup) ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_svprogresshud, (ViewGroup) null, false);
        this.rootView = viewGroup;
        viewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public boolean isShowing() {
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    public void setText(String str) {
        this.mSharedView.setText(str);
    }

    public void show() {
        if (isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        this.mSharedView.show();
        svShow();
    }

    public void showErrorWithStatus(String str) {
        if (isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        this.mSharedView.showErrorWithStatus(str);
        svShow();
        scheduleDismiss();
    }

    public void showInfoWithStatus(String str) {
        if (isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        this.mSharedView.showInfoWithStatus(str);
        svShow();
        scheduleDismiss();
    }

    public void showSuccessWithStatus(String str) {
        if (isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        this.mSharedView.showSuccessWithStatus(str);
        svShow();
        scheduleDismiss();
    }

    public void showWithMaskType(SVProgressHUDMaskType sVProgressHUDMaskType) {
        if (isShowing()) {
            return;
        }
        setMaskType(sVProgressHUDMaskType);
        this.mSharedView.show();
        svShow();
    }

    public void showWithProgress(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        if (isShowing()) {
            return;
        }
        setMaskType(sVProgressHUDMaskType);
        this.mSharedView.showWithProgress(str);
        svShow();
    }

    public void showWithStatus(String str) {
        if (isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        this.mSharedView.showWithStatus(str);
        svShow();
    }

    public void showWithStatus(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        if (isShowing()) {
            return;
        }
        setMaskType(sVProgressHUDMaskType);
        this.mSharedView.showWithStatus(str);
        svShow();
    }

    public void showErrorWithStatus(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        if (isShowing()) {
            return;
        }
        setMaskType(sVProgressHUDMaskType);
        this.mSharedView.showErrorWithStatus(str);
        svShow();
        scheduleDismiss();
    }

    public void showInfoWithStatus(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        if (isShowing()) {
            return;
        }
        setMaskType(sVProgressHUDMaskType);
        this.mSharedView.showInfoWithStatus(str);
        svShow();
        scheduleDismiss();
    }

    public void showSuccessWithStatus(String str, SVProgressHUDMaskType sVProgressHUDMaskType) {
        if (isShowing()) {
            return;
        }
        setMaskType(sVProgressHUDMaskType);
        this.mSharedView.showSuccessWithStatus(str);
        svShow();
        scheduleDismiss();
    }
}
