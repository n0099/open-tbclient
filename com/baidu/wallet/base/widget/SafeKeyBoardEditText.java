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
    public SafeKeyBoardState f23587a;

    /* renamed from: b  reason: collision with root package name */
    public Context f23588b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f23589c;

    /* renamed from: d  reason: collision with root package name */
    public SafeScrollView f23590d;

    /* renamed from: e  reason: collision with root package name */
    public View f23591e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23592f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23593g;

    /* renamed from: h  reason: collision with root package name */
    public int f23594h;

    /* renamed from: i  reason: collision with root package name */
    public int f23595i;
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
        this.f23590d.dismissKeyBoard(this);
    }

    public CheckFunc getCheckFunc() {
        return this.r;
    }

    public int getCloseBtnVisibility() {
        return this.f23594h;
    }

    public int getGap() {
        if (this.m == 0) {
            this.m = 8;
        }
        return this.m;
    }

    public int getHeadLayoutVisibility() {
        return this.f23595i;
    }

    public SafeKeyBoardState getKeyBoardState() {
        return this.f23587a;
    }

    public View.OnClickListener getOnConfirmListener() {
        return this.q;
    }

    public boolean getUseKeyDot() {
        return this.f23592f;
    }

    public boolean getUseKeyX() {
        return this.f23593g;
    }

    public boolean getUseRandKey() {
        return this.k;
    }

    public boolean getUseSafeKeyBoard() {
        return this.l;
    }

    public ViewGroup getViewGroup() {
        return this.f23589c;
    }

    public View getVisibleView() {
        return this.f23591e;
    }

    public void initSafeKeyBoardParams(ViewGroup viewGroup, SafeScrollView safeScrollView, View view, boolean z) {
        this.f23589c = viewGroup;
        this.f23590d = safeScrollView;
        this.f23591e = view;
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
            SafeScrollView safeScrollView = this.f23590d;
            if (safeScrollView == null) {
                GlobalUtils.showInputMethod(this.f23588b, this);
                return true;
            } else if (safeScrollView.isPopupWindowShowing()) {
                return true;
            } else {
                this.f23590d.showKeyBoard(this.f23589c, this, this.f23591e);
                return true;
            }
        }
        return true;
    }

    public void setCheckFunc(CheckFunc checkFunc) {
        this.r = checkFunc;
    }

    public void setCloseBtnVisibility(int i2) {
        this.f23594h = i2;
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
        this.f23595i = i2;
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
        this.f23592f = z;
    }

    public void setUseKeyX(boolean z) {
        this.f23593g = z;
    }

    public void setUseRandKey(boolean z) {
        this.k = z;
    }

    public void setUseSafeKeyBoard(boolean z) {
        this.l = z;
    }

    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23592f = false;
        this.f23593g = false;
        this.f23594h = 0;
        this.f23595i = 0;
        this.j = true;
        this.l = true;
        this.m = 0;
        this.o = false;
        this.p = false;
    }

    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23592f = false;
        this.f23593g = false;
        this.f23594h = 0;
        this.f23595i = 0;
        this.j = true;
        this.l = true;
        this.m = 0;
        this.o = false;
        this.p = false;
        this.f23588b = context;
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
                        if (safeKeyBoardEditText.f23590d != null) {
                            SafeKeyBoardEditText.this.f23590d.dismissKeyBoard(SafeKeyBoardEditText.this);
                        } else {
                            GlobalUtils.hideInputMethod(SafeKeyBoardEditText.this.f23588b, SafeKeyBoardEditText.this);
                        }
                    }
                } else if (SafeKeyBoardEditText.this.l) {
                    GlobalUtils.hideInputMethod(SafeKeyBoardEditText.this.f23588b, SafeKeyBoardEditText.this);
                    if (SafeKeyBoardEditText.this.f23590d != null && SafeKeyBoardEditText.this.f23590d.hasWindowFocus() && !SafeKeyBoardEditText.this.f23590d.isPopupWindowShowing()) {
                        SafeScrollView safeScrollView = SafeKeyBoardEditText.this.f23590d;
                        ViewGroup viewGroup = SafeKeyBoardEditText.this.f23589c;
                        SafeKeyBoardEditText safeKeyBoardEditText2 = SafeKeyBoardEditText.this;
                        safeScrollView.showKeyBoard(viewGroup, safeKeyBoardEditText2, safeKeyBoardEditText2.f23591e);
                    }
                }
                if (SafeKeyBoardEditText.this.n != null) {
                    SafeKeyBoardEditText.this.n.onMyFocusChange(view, z);
                }
            }
        });
    }
}
