package com.baidu.wallet.base.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.wallet.utils.BdWalletUtils;
/* loaded from: classes5.dex */
public class SafeScrollView extends ScrollView {
    public static final String HIDE_KEYBOARD_LISTENER = "hide_keyboard_listener";

    /* renamed from: a  reason: collision with root package name */
    public static final String f24384a = SafeScrollView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public ScrollChangedListener f24385b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24386c;

    /* renamed from: d  reason: collision with root package name */
    public EventBus f24387d;

    /* renamed from: e  reason: collision with root package name */
    public int f24388e;

    /* renamed from: f  reason: collision with root package name */
    public Context f24389f;

    /* renamed from: g  reason: collision with root package name */
    public SafeKeyBoardEditText f24390g;

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardUtil f24391h;

    /* renamed from: i  reason: collision with root package name */
    public onKeyBoardStatusChangeListener f24392i;
    public int j;
    public int k;
    public boolean l;

    /* loaded from: classes5.dex */
    public interface ScrollChangedListener {
        void onScrollChanged(int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes5.dex */
    public interface onKeyBoardStatusChangeListener {
        void onKeyBoardStatusChange(boolean z, int i2);
    }

    public SafeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24386c = false;
        this.f24387d = EventBus.getInstance();
        this.f24388e = 0;
        this.f24391h = new SafeKeyBoardUtil();
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.f24389f = context;
        setSafeFlag(false);
    }

    private void setSafeFlag(boolean z) {
        if (getContext() instanceof Activity) {
            if (z) {
                BdWalletUtils.clearFlagsSecure((Activity) getContext());
            } else {
                BdWalletUtils.addFlagsSecure((Activity) getContext());
            }
        }
    }

    public void clear() {
        this.f24387d.unregister(this);
    }

    public void dismissKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText) {
        if (safeKeyBoardEditText.getUseSafeKeyBoard()) {
            onKeyBoardStatusChangeListener onkeyboardstatuschangelistener = this.f24392i;
            if (onkeyboardstatuschangelistener != null) {
                onkeyboardstatuschangelistener.onKeyBoardStatusChange(false, 0);
            }
            this.f24391h.hideSoftKeyBoard();
            return;
        }
        GlobalUtils.hideInputMethod(this.f24389f, safeKeyBoardEditText);
    }

    public boolean isPopupWindowShowing() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        SafeKeyBoardUtil safeKeyBoardUtil = this.f24391h;
        return (safeKeyBoardUtil == null || (safeKeyBoardPopupWindow = safeKeyBoardUtil.mPopupWindow) == null || !safeKeyBoardPopupWindow.isShowing()) ? false : true;
    }

    public void notifyShowKeyBoard(int i2) {
        if (this.f24392i != null) {
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f24391h.mPopupWindow;
            if (safeKeyBoardPopupWindow != null) {
                safeKeyBoardPopupWindow.getHeight();
            }
            this.f24392i.onKeyBoardStatusChange(true, i2);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        clear();
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (!this.l) {
            this.l = true;
            this.j = i5;
            this.k = i5;
            return;
        }
        int i6 = this.k;
        if (i6 != i5) {
            int i7 = this.j;
            if (i5 >= i7 || i6 >= i7) {
                this.k = i5;
            }
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !HIDE_KEYBOARD_LISTENER.equals(event.mEventKey)) {
            return;
        }
        this.f24391h.hideSoftKeyBoard();
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        ScrollChangedListener scrollChangedListener = this.f24385b;
        if (scrollChangedListener != null) {
            scrollChangedListener.onScrollChanged(i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        super.onWindowFocusChanged(z);
        if (!z && !this.f24386c) {
            this.f24391h.hideSoftKeyBoard();
            return;
        }
        this.f24388e = 0;
        a((View) this);
        if (this.f24388e == 1 && (safeKeyBoardEditText = this.f24390g) != null && safeKeyBoardEditText.isFocused() && this.f24390g.getUseSafeKeyBoard()) {
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.SafeScrollView.1
                @Override // java.lang.Runnable
                public void run() {
                    SafeScrollView.this.f24391h.init(SafeScrollView.this.f24389f, SafeScrollView.this.f24390g.getViewGroup(), SafeScrollView.this);
                    SafeScrollView.this.f24391h.showSoftKeyBoard(SafeScrollView.this.f24390g, SafeScrollView.this.f24390g.getVisibleView());
                }
            }, 100L);
        }
    }

    public void setAlwaysShowSoftKeyBoard(boolean z) {
        this.f24386c = z;
        this.f24387d.register(this, HIDE_KEYBOARD_LISTENER, 0, EventBus.ThreadMode.MainThread);
    }

    public void setKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener onkeyboardstatuschangelistener) {
        this.f24392i = onkeyboardstatuschangelistener;
    }

    public void setSafeKeyBoardUtil(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f24391h = safeKeyBoardUtil;
    }

    public void setScrollChangeListener(ScrollChangedListener scrollChangedListener) {
        this.f24385b = scrollChangedListener;
    }

    public void showKeyBoard(ViewGroup viewGroup, SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        if (safeKeyBoardEditText.getUseSafeKeyBoard() && view != null) {
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f24391h.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                this.f24391h.init(this.f24389f, viewGroup, this);
            }
            this.f24391h.showSoftKeyBoard(safeKeyBoardEditText, view);
            return;
        }
        GlobalUtils.showInputMethod(this.f24389f, safeKeyBoardEditText);
    }

    private void a(View view) {
        if (!(view instanceof ViewGroup)) {
            if ((view instanceof EditText) && view.hasWindowFocus() && view.getVisibility() == 0 && view.isShown() && view.isEnabled()) {
                int i2 = this.f24388e + 1;
                this.f24388e = i2;
                if (i2 == 1 && (view instanceof SafeKeyBoardEditText)) {
                    this.f24390g = (SafeKeyBoardEditText) view;
                    return;
                }
                return;
            }
            return;
        }
        int i3 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i3 >= viewGroup.getChildCount()) {
                return;
            }
            a(viewGroup.getChildAt(i3));
            i3++;
        }
    }

    public void dismissKeyBoard() {
        this.f24391h.hideSoftKeyBoard();
    }

    private void a() {
        this.f24385b = null;
    }

    public SafeScrollView(Context context) {
        this(context, null);
        this.f24389f = context;
        setSafeFlag(false);
    }
}
