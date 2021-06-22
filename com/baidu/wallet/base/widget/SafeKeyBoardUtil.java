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
    public String f23730a;

    /* renamed from: b  reason: collision with root package name */
    public Context f23731b;

    /* renamed from: c  reason: collision with root package name */
    public SafeKeyBoardEditText f23732c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f23733d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f23734e;

    /* renamed from: f  reason: collision with root package name */
    public View f23735f;

    /* renamed from: g  reason: collision with root package name */
    public int f23736g;

    /* renamed from: h  reason: collision with root package name */
    public int f23737h;

    /* renamed from: i  reason: collision with root package name */
    public int f23738i;
    public int j;
    public SafeKeyBoardState k;
    public SafeKeyBoardPopupWindow mPopupWindow;

    /* loaded from: classes5.dex */
    public enum SafeKeyBoardState {
        NORMAL_STATE,
        CONFRIM_STATE
    }

    public void hideSoftInputMethod(EditText editText) {
        ((InputMethodManager) this.f23731b.getSystemService("input_method")).hideSoftInputFromWindow(this.f23732c.getWindowToken(), 0);
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
        this.f23731b = context;
        this.f23733d = viewGroup;
        this.f23734e = safeScrollView;
        if (this.mPopupWindow == null) {
            if (this.k == SafeKeyBoardState.CONFRIM_STATE) {
                this.mPopupWindow = new SafeKeyBoardPopUpWindowNew(context);
            } else {
                this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
            }
        }
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            SafeScrollView safeScrollView2 = this.f23734e;
            if (safeScrollView2 != null) {
                this.f23737h = safeScrollView2.getLayoutParams().height;
            } else {
                LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
            }
        }
    }

    public void setState(SafeKeyBoardState safeKeyBoardState) {
        this.k = safeKeyBoardState;
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        this.f23732c = safeKeyBoardEditText;
        this.f23735f = view;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow != null && safeKeyBoardEditText != null && view != null && this.f23734e != null && this.f23733d != null) {
            safeKeyBoardPopupWindow.setSafeEditTet(safeKeyBoardEditText);
            this.mPopupWindow.setScrollView(this.f23734e);
            hideSoftInputMethod(this.f23732c);
            if (this.f23734e.hasWindowFocus() && this.f23732c.isEnabled()) {
                if (this.mPopupWindow != null && this.f23734e.hasWindowFocus()) {
                    this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                    try {
                        this.mPopupWindow.showAtLocation(this.f23733d, 80, 0, 0);
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
                        if (safeKeyBoardPopupWindow2 != null && safeKeyBoardPopupWindow2.isShowing() && SafeKeyBoardUtil.this.f23734e.hasWindowFocus()) {
                            SafeKeyBoardUtil.this.a();
                        } else {
                            new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.SafeKeyBoardUtil.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SafeKeyBoardPopupWindow safeKeyBoardPopupWindow3 = SafeKeyBoardUtil.this.mPopupWindow;
                                    if (safeKeyBoardPopupWindow3 != null && safeKeyBoardPopupWindow3.isShowing() && SafeKeyBoardUtil.this.f23734e.hasWindowFocus()) {
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
        ViewGroup.LayoutParams layoutParams = this.f23734e.getLayoutParams();
        layoutParams.height = this.f23737h;
        this.f23734e.setLayoutParams(layoutParams);
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
        if (this.mPopupWindow == null || this.f23734e == null || this.f23735f == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f23731b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f23736g = displayMetrics.heightPixels;
        this.j = this.mPopupWindow.getPopupWindowHeight();
        int[] iArr = new int[2];
        this.f23734e.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        final int i3 = 0;
        View a2 = a(this.f23734e);
        if (a2 != null) {
            i3 = this.f23736g - a2.getHeight();
        }
        int i4 = ((this.f23736g - this.j) - i2) - i3;
        if (i4 <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f23734e.getLayoutParams();
        layoutParams.height = i4;
        this.f23734e.setLayoutParams(layoutParams);
        this.f23734e.post(new Runnable() { // from class: com.baidu.wallet.base.widget.SafeKeyBoardUtil.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr2 = new int[2];
                SafeKeyBoardUtil.this.f23735f.getLocationOnScreen(iArr2);
                SafeKeyBoardUtil safeKeyBoardUtil = SafeKeyBoardUtil.this;
                safeKeyBoardUtil.f23738i = ((iArr2[1] + safeKeyBoardUtil.f23735f.getHeight()) - (SafeKeyBoardUtil.this.f23736g - SafeKeyBoardUtil.this.j)) + SafeKeyBoardUtil.this.f23732c.getGap() + i3;
                if (SafeKeyBoardUtil.this.f23738i > 0) {
                    SafeKeyBoardUtil.this.f23734e.smoothScrollBy(0, SafeKeyBoardUtil.this.f23738i);
                }
                SafeKeyBoardUtil.this.f23734e.notifyShowKeyBoard(SafeKeyBoardUtil.this.j);
            }
        });
    }
}
