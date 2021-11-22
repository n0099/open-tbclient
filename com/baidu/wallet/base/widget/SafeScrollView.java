package com.baidu.wallet.base.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.utils.BdWalletUtils;
/* loaded from: classes10.dex */
public class SafeScrollView extends ScrollView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HIDE_KEYBOARD_LISTENER = "hide_keyboard_listener";

    /* renamed from: a  reason: collision with root package name */
    public static final String f58610a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ScrollChangedListener f58611b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58612c;

    /* renamed from: d  reason: collision with root package name */
    public EventBus f58613d;

    /* renamed from: e  reason: collision with root package name */
    public int f58614e;

    /* renamed from: f  reason: collision with root package name */
    public Context f58615f;

    /* renamed from: g  reason: collision with root package name */
    public SafeKeyBoardEditText f58616g;

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardUtil f58617h;

    /* renamed from: i  reason: collision with root package name */
    public onKeyBoardStatusChangeListener f58618i;
    public int j;
    public int k;
    public boolean l;

    /* loaded from: classes10.dex */
    public interface ScrollChangedListener {
        void onScrollChanged(int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes10.dex */
    public interface onKeyBoardStatusChangeListener {
        void onKeyBoardStatusChange(boolean z, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2113990873, "Lcom/baidu/wallet/base/widget/SafeScrollView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2113990873, "Lcom/baidu/wallet/base/widget/SafeScrollView;");
                return;
            }
        }
        f58610a = SafeScrollView.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f58612c = false;
        this.f58613d = EventBus.getInstance();
        this.f58614e = 0;
        this.f58617h = new SafeKeyBoardUtil();
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.f58615f = context;
        setSafeFlag(false);
    }

    private void setSafeFlag(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65544, this, z) == null) && (getContext() instanceof Activity)) {
            if (z) {
                BdWalletUtils.clearFlagsSecure((Activity) getContext());
            } else {
                BdWalletUtils.addFlagsSecure((Activity) getContext());
            }
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58613d.unregister(this);
        }
    }

    public void dismissKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, safeKeyBoardEditText) == null) {
            if (safeKeyBoardEditText.getUseSafeKeyBoard()) {
                onKeyBoardStatusChangeListener onkeyboardstatuschangelistener = this.f58618i;
                if (onkeyboardstatuschangelistener != null) {
                    onkeyboardstatuschangelistener.onKeyBoardStatusChange(false, 0);
                }
                this.f58617h.hideSoftKeyBoard();
                return;
            }
            GlobalUtils.hideInputMethod(this.f58615f, safeKeyBoardEditText);
        }
    }

    public boolean isPopupWindowShowing() {
        InterceptResult invokeV;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SafeKeyBoardUtil safeKeyBoardUtil = this.f58617h;
            return (safeKeyBoardUtil == null || (safeKeyBoardPopupWindow = safeKeyBoardUtil.mPopupWindow) == null || !safeKeyBoardPopupWindow.isShowing()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void notifyShowKeyBoard(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.f58618i == null) {
            return;
        }
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f58617h.mPopupWindow;
        if (safeKeyBoardPopupWindow != null) {
            safeKeyBoardPopupWindow.getHeight();
        }
        this.f58618i.onKeyBoardStatusChange(true, i2);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            clear();
            a();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
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
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, event) == null) && event != null && "hide_keyboard_listener".equals(event.mEventKey)) {
            this.f58617h.hideSoftKeyBoard();
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            ScrollChangedListener scrollChangedListener = this.f58611b;
            if (scrollChangedListener != null) {
                scrollChangedListener.onScrollChanged(i2, i3, i4, i5);
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z && !this.f58612c) {
                this.f58617h.hideSoftKeyBoard();
                return;
            }
            this.f58614e = 0;
            a((View) this);
            if (this.f58614e == 1 && (safeKeyBoardEditText = this.f58616g) != null && safeKeyBoardEditText.isFocused() && this.f58616g.getUseSafeKeyBoard()) {
                new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.wallet.base.widget.SafeScrollView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SafeScrollView f58619a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f58619a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f58619a.f58617h.init(this.f58619a.f58615f, this.f58619a.f58616g.getViewGroup(), this.f58619a);
                            this.f58619a.f58617h.showSoftKeyBoard(this.f58619a.f58616g, this.f58619a.f58616g.getVisibleView());
                        }
                    }
                }, 100L);
            }
        }
    }

    public void setAlwaysShowSoftKeyBoard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f58612c = z;
            this.f58613d.register(this, "hide_keyboard_listener", 0, EventBus.ThreadMode.MainThread);
        }
    }

    public void setKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener onkeyboardstatuschangelistener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onkeyboardstatuschangelistener) == null) {
            this.f58618i = onkeyboardstatuschangelistener;
        }
    }

    public void setSafeKeyBoardUtil(SafeKeyBoardUtil safeKeyBoardUtil) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, safeKeyBoardUtil) == null) {
            this.f58617h = safeKeyBoardUtil;
        }
    }

    public void setScrollChangeListener(ScrollChangedListener scrollChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, scrollChangedListener) == null) {
            this.f58611b = scrollChangedListener;
        }
    }

    public void showKeyBoard(ViewGroup viewGroup, SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, viewGroup, safeKeyBoardEditText, view) == null) {
            if (safeKeyBoardEditText.getUseSafeKeyBoard() && view != null) {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f58617h.mPopupWindow;
                if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                    this.f58617h.init(this.f58615f, viewGroup, this);
                }
                this.f58617h.showSoftKeyBoard(safeKeyBoardEditText, view);
                return;
            }
            GlobalUtils.showInputMethod(this.f58615f, safeKeyBoardEditText);
        }
    }

    private void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, view) != null) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            if ((view instanceof EditText) && view.hasWindowFocus() && view.getVisibility() == 0 && view.isShown() && view.isEnabled()) {
                int i2 = this.f58614e + 1;
                this.f58614e = i2;
                if (i2 == 1 && (view instanceof SafeKeyBoardEditText)) {
                    this.f58616g = (SafeKeyBoardEditText) view;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f58617h.hideSoftKeyBoard();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f58611b = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SafeScrollView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58615f = context;
        setSafeFlag(false);
    }
}
