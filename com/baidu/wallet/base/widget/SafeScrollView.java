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
/* loaded from: classes8.dex */
public class SafeScrollView extends ScrollView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HIDE_KEYBOARD_LISTENER = "hide_keyboard_listener";

    /* renamed from: a  reason: collision with root package name */
    public static final String f60458a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ScrollChangedListener f60459b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60460c;

    /* renamed from: d  reason: collision with root package name */
    public EventBus f60461d;

    /* renamed from: e  reason: collision with root package name */
    public int f60462e;

    /* renamed from: f  reason: collision with root package name */
    public Context f60463f;

    /* renamed from: g  reason: collision with root package name */
    public SafeKeyBoardEditText f60464g;

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardUtil f60465h;

    /* renamed from: i  reason: collision with root package name */
    public onKeyBoardStatusChangeListener f60466i;

    /* renamed from: j  reason: collision with root package name */
    public int f60467j;
    public int k;
    public boolean l;

    /* loaded from: classes8.dex */
    public interface ScrollChangedListener {
        void onScrollChanged(int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes8.dex */
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
        f60458a = SafeScrollView.class.getSimpleName();
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
        this.f60460c = false;
        this.f60461d = EventBus.getInstance();
        this.f60462e = 0;
        this.f60465h = new SafeKeyBoardUtil();
        this.f60467j = 0;
        this.k = 0;
        this.l = false;
        this.f60463f = context;
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
            this.f60461d.unregister(this);
        }
    }

    public void dismissKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, safeKeyBoardEditText) == null) {
            if (safeKeyBoardEditText.getUseSafeKeyBoard()) {
                onKeyBoardStatusChangeListener onkeyboardstatuschangelistener = this.f60466i;
                if (onkeyboardstatuschangelistener != null) {
                    onkeyboardstatuschangelistener.onKeyBoardStatusChange(false, 0);
                }
                this.f60465h.hideSoftKeyBoard();
                return;
            }
            GlobalUtils.hideInputMethod(this.f60463f, safeKeyBoardEditText);
        }
    }

    public boolean isPopupWindowShowing() {
        InterceptResult invokeV;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SafeKeyBoardUtil safeKeyBoardUtil = this.f60465h;
            return (safeKeyBoardUtil == null || (safeKeyBoardPopupWindow = safeKeyBoardUtil.mPopupWindow) == null || !safeKeyBoardPopupWindow.isShowing()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void notifyShowKeyBoard(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.f60466i == null) {
            return;
        }
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f60465h.mPopupWindow;
        if (safeKeyBoardPopupWindow != null) {
            safeKeyBoardPopupWindow.getHeight();
        }
        this.f60466i.onKeyBoardStatusChange(true, i2);
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
                this.f60467j = i5;
                this.k = i5;
                return;
            }
            int i6 = this.k;
            if (i6 != i5) {
                int i7 = this.f60467j;
                if (i5 >= i7 || i6 >= i7) {
                    this.k = i5;
                }
            }
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, event) == null) && event != null && "hide_keyboard_listener".equals(event.mEventKey)) {
            this.f60465h.hideSoftKeyBoard();
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            ScrollChangedListener scrollChangedListener = this.f60459b;
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
            if (!z && !this.f60460c) {
                this.f60465h.hideSoftKeyBoard();
                return;
            }
            this.f60462e = 0;
            a((View) this);
            if (this.f60462e == 1 && (safeKeyBoardEditText = this.f60464g) != null && safeKeyBoardEditText.isFocused() && this.f60464g.getUseSafeKeyBoard()) {
                new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.wallet.base.widget.SafeScrollView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SafeScrollView f60468a;

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
                        this.f60468a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f60468a.f60465h.init(this.f60468a.f60463f, this.f60468a.f60464g.getViewGroup(), this.f60468a);
                            this.f60468a.f60465h.showSoftKeyBoard(this.f60468a.f60464g, this.f60468a.f60464g.getVisibleView());
                        }
                    }
                }, 100L);
            }
        }
    }

    public void setAlwaysShowSoftKeyBoard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f60460c = z;
            this.f60461d.register(this, "hide_keyboard_listener", 0, EventBus.ThreadMode.MainThread);
        }
    }

    public void setKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener onkeyboardstatuschangelistener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onkeyboardstatuschangelistener) == null) {
            this.f60466i = onkeyboardstatuschangelistener;
        }
    }

    public void setSafeKeyBoardUtil(SafeKeyBoardUtil safeKeyBoardUtil) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, safeKeyBoardUtil) == null) {
            this.f60465h = safeKeyBoardUtil;
        }
    }

    public void setScrollChangeListener(ScrollChangedListener scrollChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, scrollChangedListener) == null) {
            this.f60459b = scrollChangedListener;
        }
    }

    public void showKeyBoard(ViewGroup viewGroup, SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, viewGroup, safeKeyBoardEditText, view) == null) {
            if (safeKeyBoardEditText.getUseSafeKeyBoard() && view != null) {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f60465h.mPopupWindow;
                if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                    this.f60465h.init(this.f60463f, viewGroup, this);
                }
                this.f60465h.showSoftKeyBoard(safeKeyBoardEditText, view);
                return;
            }
            GlobalUtils.showInputMethod(this.f60463f, safeKeyBoardEditText);
        }
    }

    private void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, view) != null) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            if ((view instanceof EditText) && view.hasWindowFocus() && view.getVisibility() == 0 && view.isShown() && view.isEnabled()) {
                int i2 = this.f60462e + 1;
                this.f60462e = i2;
                if (i2 == 1 && (view instanceof SafeKeyBoardEditText)) {
                    this.f60464g = (SafeKeyBoardEditText) view;
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
            this.f60465h.hideSoftKeyBoard();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f60459b = null;
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
        this.f60463f = context;
        setSafeFlag(false);
    }
}
