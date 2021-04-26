package com.baidu.wallet.base.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.wallet.core.utils.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public final class SafeKeyBoardUtil {

    /* renamed from: a  reason: collision with root package name */
    public String f24371a;

    /* renamed from: b  reason: collision with root package name */
    public Context f24372b;

    /* renamed from: c  reason: collision with root package name */
    public SafeKeyBoardEditText f24373c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f24374d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f24375e;

    /* renamed from: f  reason: collision with root package name */
    public View f24376f;

    /* renamed from: g  reason: collision with root package name */
    public int f24377g;

    /* renamed from: h  reason: collision with root package name */
    public int f24378h;

    /* renamed from: i  reason: collision with root package name */
    public int f24379i;
    public int j;
    public SafeKeyBoardState k;
    public SafeKeyBoardPopupWindow mPopupWindow;

    /* loaded from: classes5.dex */
    public enum SafeKeyBoardState {
        NORMAL_STATE,
        CONFRIM_STATE
    }

    public void hideSoftInputMethod(EditText editText) {
        ((InputMethodManager) this.f24372b.getSystemService("input_method")).hideSoftInputFromWindow(this.f24373c.getWindowToken(), 0);
        if (Build.VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            return;
        }
        try {
            Method method = EditText.class.getMethod("setSoftInputShownOnFocus", Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(editText, Boolean.FALSE);
        } catch (IllegalAccessException e2) {
            LogUtil.d(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            LogUtil.d(e3.getMessage());
        } catch (NoSuchMethodException e4) {
            LogUtil.d(e4.getMessage());
            try {
                Method method2 = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                method2.setAccessible(true);
                method2.invoke(editText, Boolean.FALSE);
            } catch (NoSuchMethodException e5) {
                LogUtil.d(e5.getMessage());
                editText.setInputType(0);
            } catch (Exception e6) {
                LogUtil.d(e6.getMessage());
                editText.setInputType(0);
            }
        } catch (InvocationTargetException e7) {
            LogUtil.d(e7.getMessage());
        } catch (Exception e8) {
            LogUtil.d(e8.getMessage());
        }
    }

    public void hideSoftKeyBoard() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.dismiss();
        b();
    }

    public void init(Context context, ViewGroup viewGroup, SafeScrollView safeScrollView) {
        this.f24372b = context;
        this.f24374d = viewGroup;
        this.f24375e = safeScrollView;
        if (this.mPopupWindow == null) {
            if (this.k == SafeKeyBoardState.CONFRIM_STATE) {
                this.mPopupWindow = new SafeKeyBoardPopUpWindowNew(context);
            } else {
                this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
            }
        }
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            SafeScrollView safeScrollView2 = this.f24375e;
            if (safeScrollView2 != null) {
                this.f24378h = safeScrollView2.getLayoutParams().height;
            } else {
                LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
            }
        }
    }

    public void setState(SafeKeyBoardState safeKeyBoardState) {
        this.k = safeKeyBoardState;
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        this.f24373c = safeKeyBoardEditText;
        this.f24376f = view;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow != null && safeKeyBoardEditText != null && view != null && this.f24375e != null && this.f24374d != null) {
            safeKeyBoardPopupWindow.setSafeEditTet(safeKeyBoardEditText);
            this.mPopupWindow.setScrollView(this.f24375e);
            hideSoftInputMethod(this.f24373c);
            if (this.f24375e.hasWindowFocus() && this.f24373c.isEnabled()) {
                if (this.mPopupWindow != null && this.f24375e.hasWindowFocus()) {
                    this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                    try {
                        this.mPopupWindow.showAtLocation(this.f24374d, 80, 0, 0);
                        if (Build.VERSION.SDK_INT <= 23) {
                            this.mPopupWindow.update();
                        }
                    } catch (Exception unused) {
                        this.mPopupWindow = null;
                        return;
                    }
                }
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.SafeKeyBoardUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow2 = SafeKeyBoardUtil.this.mPopupWindow;
                        if (safeKeyBoardPopupWindow2 != null && safeKeyBoardPopupWindow2.isShowing() && SafeKeyBoardUtil.this.f24375e.hasWindowFocus()) {
                            SafeKeyBoardUtil.this.a();
                        } else {
                            new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.SafeKeyBoardUtil.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SafeKeyBoardPopupWindow safeKeyBoardPopupWindow3 = SafeKeyBoardUtil.this.mPopupWindow;
                                    if (safeKeyBoardPopupWindow3 != null && safeKeyBoardPopupWindow3.isShowing() && SafeKeyBoardUtil.this.f24375e.hasWindowFocus()) {
                                        SafeKeyBoardUtil.this.a();
                                    }
                                }
                            }, 150L);
                        }
                    }
                }, 150L);
                return;
            }
            return;
        }
        LogUtil.errord("gaolou", "SafeKeyBoardUtil.showSoftKeyBoard ++ View == null");
    }

    private void b() {
        ViewGroup.LayoutParams layoutParams = this.f24375e.getLayoutParams();
        layoutParams.height = this.f24378h;
        this.f24375e.setLayoutParams(layoutParams);
    }

    private View a(View view) {
        while (view instanceof View) {
            if (16908290 == view.getId()) {
                return view;
            }
            view = (View) view.getParent();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.mPopupWindow == null || this.f24375e == null || this.f24376f == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f24372b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f24377g = displayMetrics.heightPixels;
        this.j = this.mPopupWindow.getPopupWindowHeight();
        int[] iArr = new int[2];
        this.f24375e.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        final int i3 = 0;
        View a2 = a(this.f24375e);
        if (a2 != null) {
            i3 = this.f24377g - a2.getHeight();
        }
        int i4 = ((this.f24377g - this.j) - i2) - i3;
        if (i4 <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f24375e.getLayoutParams();
        layoutParams.height = i4;
        this.f24375e.setLayoutParams(layoutParams);
        this.f24375e.post(new Runnable() { // from class: com.baidu.wallet.base.widget.SafeKeyBoardUtil.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                SafeKeyBoardUtil.this.f24376f.getLocationOnScreen(iArr2);
                SafeKeyBoardUtil safeKeyBoardUtil = SafeKeyBoardUtil.this;
                safeKeyBoardUtil.f24379i = ((iArr2[1] + safeKeyBoardUtil.f24376f.getHeight()) - (SafeKeyBoardUtil.this.f24377g - SafeKeyBoardUtil.this.j)) + SafeKeyBoardUtil.this.f24373c.getGap() + i3;
                if (SafeKeyBoardUtil.this.f24379i > 0) {
                    SafeKeyBoardUtil.this.f24375e.smoothScrollBy(0, SafeKeyBoardUtil.this.f24379i);
                }
                SafeKeyBoardUtil.this.f24375e.notifyShowKeyBoard(SafeKeyBoardUtil.this.j);
            }
        });
    }
}
