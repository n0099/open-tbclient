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
    public static final String f23661a = SafeScrollView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public ScrollChangedListener f23662b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23663c;

    /* renamed from: d  reason: collision with root package name */
    public EventBus f23664d;

    /* renamed from: e  reason: collision with root package name */
    public int f23665e;

    /* renamed from: f  reason: collision with root package name */
    public Context f23666f;

    /* renamed from: g  reason: collision with root package name */
    public SafeKeyBoardEditText f23667g;

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardUtil f23668h;

    /* renamed from: i  reason: collision with root package name */
    public onKeyBoardStatusChangeListener f23669i;
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
        this.f23663c = false;
        this.f23664d = EventBus.getInstance();
        this.f23665e = 0;
        this.f23668h = new SafeKeyBoardUtil();
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.f23666f = context;
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
        this.f23664d.unregister(this);
    }

    public void dismissKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText) {
        if (safeKeyBoardEditText.getUseSafeKeyBoard()) {
            onKeyBoardStatusChangeListener onkeyboardstatuschangelistener = this.f23669i;
            if (onkeyboardstatuschangelistener != null) {
                onkeyboardstatuschangelistener.onKeyBoardStatusChange(false, 0);
            }
            this.f23668h.hideSoftKeyBoard();
            return;
        }
        GlobalUtils.hideInputMethod(this.f23666f, safeKeyBoardEditText);
    }

    public boolean isPopupWindowShowing() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        SafeKeyBoardUtil safeKeyBoardUtil = this.f23668h;
        return (safeKeyBoardUtil == null || (safeKeyBoardPopupWindow = safeKeyBoardUtil.mPopupWindow) == null || !safeKeyBoardPopupWindow.isShowing()) ? false : true;
    }

    public void notifyShowKeyBoard(int i2) {
        if (this.f23669i != null) {
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f23668h.mPopupWindow;
            if (safeKeyBoardPopupWindow != null) {
                safeKeyBoardPopupWindow.getHeight();
            }
            this.f23669i.onKeyBoardStatusChange(true, i2);
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
        this.f23668h.hideSoftKeyBoard();
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        ScrollChangedListener scrollChangedListener = this.f23662b;
        if (scrollChangedListener != null) {
            scrollChangedListener.onScrollChanged(i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        super.onWindowFocusChanged(z);
        if (!z && !this.f23663c) {
            this.f23668h.hideSoftKeyBoard();
            return;
        }
        this.f23665e = 0;
        a((View) this);
        if (this.f23665e == 1 && (safeKeyBoardEditText = this.f23667g) != null && safeKeyBoardEditText.isFocused() && this.f23667g.getUseSafeKeyBoard()) {
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.SafeScrollView.1
                @Override // java.lang.Runnable
                public void run() {
                    SafeScrollView.this.f23668h.init(SafeScrollView.this.f23666f, SafeScrollView.this.f23667g.getViewGroup(), SafeScrollView.this);
                    SafeScrollView.this.f23668h.showSoftKeyBoard(SafeScrollView.this.f23667g, SafeScrollView.this.f23667g.getVisibleView());
                }
            }, 100L);
        }
    }

    public void setAlwaysShowSoftKeyBoard(boolean z) {
        this.f23663c = z;
        this.f23664d.register(this, HIDE_KEYBOARD_LISTENER, 0, EventBus.ThreadMode.MainThread);
    }

    public void setKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener onkeyboardstatuschangelistener) {
        this.f23669i = onkeyboardstatuschangelistener;
    }

    public void setSafeKeyBoardUtil(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f23668h = safeKeyBoardUtil;
    }

    public void setScrollChangeListener(ScrollChangedListener scrollChangedListener) {
        this.f23662b = scrollChangedListener;
    }

    public void showKeyBoard(ViewGroup viewGroup, SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        if (safeKeyBoardEditText.getUseSafeKeyBoard() && view != null) {
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f23668h.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                this.f23668h.init(this.f23666f, viewGroup, this);
            }
            this.f23668h.showSoftKeyBoard(safeKeyBoardEditText, view);
            return;
        }
        GlobalUtils.showInputMethod(this.f23666f, safeKeyBoardEditText);
    }

    private void a(View view) {
        if (!(view instanceof ViewGroup)) {
            if ((view instanceof EditText) && view.hasWindowFocus() && view.getVisibility() == 0 && view.isShown() && view.isEnabled()) {
                int i2 = this.f23665e + 1;
                this.f23665e = i2;
                if (i2 == 1 && (view instanceof SafeKeyBoardEditText)) {
                    this.f23667g = (SafeKeyBoardEditText) view;
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
        this.f23668h.hideSoftKeyBoard();
    }

    private void a() {
        this.f23662b = null;
    }

    public SafeScrollView(Context context) {
        this(context, null);
        this.f23666f = context;
        setSafeFlag(false);
    }
}
