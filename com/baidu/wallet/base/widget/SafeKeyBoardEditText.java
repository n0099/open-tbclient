package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.utils.GlobalUtils;
/* loaded from: classes5.dex */
public class SafeKeyBoardEditText extends PluginEditText implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public SafeKeyBoardState f24342a;

    /* renamed from: b  reason: collision with root package name */
    public Context f24343b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f24344c;

    /* renamed from: d  reason: collision with root package name */
    public SafeScrollView f24345d;

    /* renamed from: e  reason: collision with root package name */
    public View f24346e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24347f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24348g;

    /* renamed from: h  reason: collision with root package name */
    public int f24349h;

    /* renamed from: i  reason: collision with root package name */
    public int f24350i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public OnMyFocusChangeListener n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;
    public CheckFunc r;

    /* loaded from: classes5.dex */
    public interface CheckFunc {
        boolean check(String str);
    }

    /* loaded from: classes5.dex */
    public interface OnMyFocusChangeListener {
        void onMyFocusChange(View view, boolean z);
    }

    /* loaded from: classes5.dex */
    public enum SafeKeyBoardState {
        NORMAL_STATE,
        CONFRIM_STATE
    }

    public SafeKeyBoardEditText(Context context) {
        this(context, null);
    }

    public void dismissKeyBorad() {
        this.f24345d.dismissKeyBoard(this);
    }

    public CheckFunc getCheckFunc() {
        return this.r;
    }

    public int getCloseBtnVisibility() {
        return this.f24349h;
    }

    public int getGap() {
        if (this.m == 0) {
            this.m = 8;
        }
        return this.m;
    }

    public int getHeadLayoutVisibility() {
        return this.f24350i;
    }

    public SafeKeyBoardState getKeyBoardState() {
        return this.f24342a;
    }

    public View.OnClickListener getOnConfirmListener() {
        return this.q;
    }

    public boolean getUseKeyDot() {
        return this.f24347f;
    }

    public boolean getUseKeyX() {
        return this.f24348g;
    }

    public boolean getUseRandKey() {
        return this.k;
    }

    public boolean getUseSafeKeyBoard() {
        return this.l;
    }

    public ViewGroup getViewGroup() {
        return this.f24344c;
    }

    public View getVisibleView() {
        return this.f24346e;
    }

    public void initSafeKeyBoardParams(ViewGroup viewGroup, SafeScrollView safeScrollView, View view, boolean z) {
        this.f24344c = viewGroup;
        this.f24345d = safeScrollView;
        this.f24346e = view;
        if (z) {
            safeScrollView.showKeyBoard(viewGroup, this, view);
        }
    }

    public boolean isShowLogoLockAnim() {
        return this.j;
    }

    @Override // com.baidu.wallet.base.widget.PluginEditText, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        super.setShowSystemMethodFlag(this.o);
        super.onTouch(view, motionEvent);
        int action = motionEvent.getAction();
        Layout layout = getLayout();
        if (action != 0) {
            return true;
        }
        requestFocus();
        this.off = layout.getOffsetForHorizontal(layout.getLineForVertical(getScrollY() + ((int) motionEvent.getY())), (int) motionEvent.getX());
        if (hasFocus()) {
            SafeScrollView safeScrollView = this.f24345d;
            if (safeScrollView == null) {
                GlobalUtils.showInputMethod(this.f24343b, this);
                return true;
            } else if (safeScrollView.isPopupWindowShowing()) {
                return true;
            } else {
                this.f24345d.showKeyBoard(this.f24344c, this, this.f24346e);
                return true;
            }
        }
        return true;
    }

    public void setCheckFunc(CheckFunc checkFunc) {
        this.r = checkFunc;
    }

    public void setCloseBtnVisibility(int i2) {
        this.f24349h = i2;
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void setDisablePast(boolean z) {
        this.p = z;
    }

    public void setGap(int i2) {
        this.m = i2;
    }

    public void setHeadLayoutVisibility(int i2) {
        this.f24350i = i2;
    }

    public void setOnConfirmListener(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void setOnMyFocusChangeListener(OnMyFocusChangeListener onMyFocusChangeListener) {
        this.n = onMyFocusChangeListener;
    }

    public void setShowLogoLockAnim(boolean z) {
        this.j = z;
    }

    public void setShowSystemKeyBoard(boolean z) {
        this.o = z;
    }

    public void setUseKeyDot(boolean z) {
        this.f24347f = z;
    }

    public void setUseKeyX(boolean z) {
        this.f24348g = z;
    }

    public void setUseRandKey(boolean z) {
        this.k = z;
    }

    public void setUseSafeKeyBoard(boolean z) {
        this.l = z;
    }

    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24347f = false;
        this.f24348g = false;
        this.f24349h = 0;
        this.f24350i = 0;
        this.j = true;
        this.l = true;
        this.m = 0;
        this.o = false;
        this.p = false;
    }

    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24347f = false;
        this.f24348g = false;
        this.f24349h = 0;
        this.f24350i = 0;
        this.j = true;
        this.l = true;
        this.m = 0;
        this.o = false;
        this.p = false;
        this.f24343b = context;
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.wallet.base.widget.SafeKeyBoardEditText.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SafeKeyBoardEditText.this.p) {
                    SafeKeyBoardEditText.this.requestFocusFromTouch();
                    return true;
                }
                return false;
            }
        });
        setOnTouchListener(this);
        setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.wallet.base.widget.SafeKeyBoardEditText.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    SafeKeyBoardEditText safeKeyBoardEditText = SafeKeyBoardEditText.this;
                    if (!safeKeyBoardEditText.isAlwaysShow) {
                        if (safeKeyBoardEditText.f24345d != null) {
                            SafeKeyBoardEditText.this.f24345d.dismissKeyBoard(SafeKeyBoardEditText.this);
                        } else {
                            GlobalUtils.hideInputMethod(SafeKeyBoardEditText.this.f24343b, SafeKeyBoardEditText.this);
                        }
                    }
                } else if (SafeKeyBoardEditText.this.l) {
                    GlobalUtils.hideInputMethod(SafeKeyBoardEditText.this.f24343b, SafeKeyBoardEditText.this);
                    if (SafeKeyBoardEditText.this.f24345d != null && SafeKeyBoardEditText.this.f24345d.hasWindowFocus() && !SafeKeyBoardEditText.this.f24345d.isPopupWindowShowing()) {
                        SafeScrollView safeScrollView = SafeKeyBoardEditText.this.f24345d;
                        ViewGroup viewGroup = SafeKeyBoardEditText.this.f24344c;
                        SafeKeyBoardEditText safeKeyBoardEditText2 = SafeKeyBoardEditText.this;
                        safeScrollView.showKeyBoard(viewGroup, safeKeyBoardEditText2, safeKeyBoardEditText2.f24346e);
                    }
                }
                if (SafeKeyBoardEditText.this.n != null) {
                    SafeKeyBoardEditText.this.n.onMyFocusChange(view, z);
                }
            }
        });
    }
}
