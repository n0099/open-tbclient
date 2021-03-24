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
    public static final String f23955a = SafeScrollView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public ScrollChangedListener f23956b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23957c;

    /* renamed from: d  reason: collision with root package name */
    public EventBus f23958d;

    /* renamed from: e  reason: collision with root package name */
    public int f23959e;

    /* renamed from: f  reason: collision with root package name */
    public Context f23960f;

    /* renamed from: g  reason: collision with root package name */
    public SafeKeyBoardEditText f23961g;

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardUtil f23962h;
    public onKeyBoardStatusChangeListener i;
    public int j;
    public int k;
    public boolean l;

    /* loaded from: classes5.dex */
    public interface ScrollChangedListener {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    /* loaded from: classes5.dex */
    public interface onKeyBoardStatusChangeListener {
        void onKeyBoardStatusChange(boolean z, int i);
    }

    public SafeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23957c = false;
        this.f23958d = EventBus.getInstance();
        this.f23959e = 0;
        this.f23962h = new SafeKeyBoardUtil();
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.f23960f = context;
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
        this.f23958d.unregister(this);
    }

    public void dismissKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText) {
        if (safeKeyBoardEditText.getUseSafeKeyBoard()) {
            onKeyBoardStatusChangeListener onkeyboardstatuschangelistener = this.i;
            if (onkeyboardstatuschangelistener != null) {
                onkeyboardstatuschangelistener.onKeyBoardStatusChange(false, 0);
            }
            this.f23962h.hideSoftKeyBoard();
            return;
        }
        GlobalUtils.hideInputMethod(this.f23960f, safeKeyBoardEditText);
    }

    public boolean isPopupWindowShowing() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        SafeKeyBoardUtil safeKeyBoardUtil = this.f23962h;
        return (safeKeyBoardUtil == null || (safeKeyBoardPopupWindow = safeKeyBoardUtil.mPopupWindow) == null || !safeKeyBoardPopupWindow.isShowing()) ? false : true;
    }

    public void notifyShowKeyBoard(int i) {
        if (this.i != null) {
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f23962h.mPopupWindow;
            if (safeKeyBoardPopupWindow != null) {
                safeKeyBoardPopupWindow.getHeight();
            }
            this.i.onKeyBoardStatusChange(true, i);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        clear();
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.l) {
            this.l = true;
            this.j = i4;
            this.k = i4;
            return;
        }
        int i5 = this.k;
        if (i5 != i4) {
            int i6 = this.j;
            if (i4 >= i6 || i5 >= i6) {
                this.k = i4;
            }
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !HIDE_KEYBOARD_LISTENER.equals(event.mEventKey)) {
            return;
        }
        this.f23962h.hideSoftKeyBoard();
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ScrollChangedListener scrollChangedListener = this.f23956b;
        if (scrollChangedListener != null) {
            scrollChangedListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        super.onWindowFocusChanged(z);
        if (!z && !this.f23957c) {
            this.f23962h.hideSoftKeyBoard();
            return;
        }
        this.f23959e = 0;
        a((View) this);
        if (this.f23959e == 1 && (safeKeyBoardEditText = this.f23961g) != null && safeKeyBoardEditText.isFocused() && this.f23961g.getUseSafeKeyBoard()) {
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.SafeScrollView.1
                @Override // java.lang.Runnable
                public void run() {
                    SafeScrollView.this.f23962h.init(SafeScrollView.this.f23960f, SafeScrollView.this.f23961g.getViewGroup(), SafeScrollView.this);
                    SafeScrollView.this.f23962h.showSoftKeyBoard(SafeScrollView.this.f23961g, SafeScrollView.this.f23961g.getVisibleView());
                }
            }, 100L);
        }
    }

    public void setAlwaysShowSoftKeyBoard(boolean z) {
        this.f23957c = z;
        this.f23958d.register(this, HIDE_KEYBOARD_LISTENER, 0, EventBus.ThreadMode.MainThread);
    }

    public void setKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener onkeyboardstatuschangelistener) {
        this.i = onkeyboardstatuschangelistener;
    }

    public void setSafeKeyBoardUtil(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f23962h = safeKeyBoardUtil;
    }

    public void setScrollChangeListener(ScrollChangedListener scrollChangedListener) {
        this.f23956b = scrollChangedListener;
    }

    public void showKeyBoard(ViewGroup viewGroup, SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        if (safeKeyBoardEditText.getUseSafeKeyBoard() && view != null) {
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f23962h.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                this.f23962h.init(this.f23960f, viewGroup, this);
            }
            this.f23962h.showSoftKeyBoard(safeKeyBoardEditText, view);
            return;
        }
        GlobalUtils.showInputMethod(this.f23960f, safeKeyBoardEditText);
    }

    private void a(View view) {
        if (!(view instanceof ViewGroup)) {
            if ((view instanceof EditText) && view.hasWindowFocus() && view.getVisibility() == 0 && view.isShown() && view.isEnabled()) {
                int i = this.f23959e + 1;
                this.f23959e = i;
                if (i == 1 && (view instanceof SafeKeyBoardEditText)) {
                    this.f23961g = (SafeKeyBoardEditText) view;
                    return;
                }
                return;
            }
            return;
        }
        int i2 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            a(viewGroup.getChildAt(i2));
            i2++;
        }
    }

    public void dismissKeyBoard() {
        this.f23962h.hideSoftKeyBoard();
    }

    private void a() {
        this.f23956b = null;
    }

    public SafeScrollView(Context context) {
        this(context, null);
        this.f23960f = context;
        setSafeFlag(false);
    }
}
