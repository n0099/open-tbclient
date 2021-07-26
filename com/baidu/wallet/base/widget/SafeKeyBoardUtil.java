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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public final class SafeKeyBoardUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f24541a;

    /* renamed from: b  reason: collision with root package name */
    public Context f24542b;

    /* renamed from: c  reason: collision with root package name */
    public SafeKeyBoardEditText f24543c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f24544d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f24545e;

    /* renamed from: f  reason: collision with root package name */
    public View f24546f;

    /* renamed from: g  reason: collision with root package name */
    public int f24547g;

    /* renamed from: h  reason: collision with root package name */
    public int f24548h;

    /* renamed from: i  reason: collision with root package name */
    public int f24549i;
    public int j;
    public SafeKeyBoardState k;
    public SafeKeyBoardPopupWindow mPopupWindow;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class SafeKeyBoardState {
        public static final /* synthetic */ SafeKeyBoardState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SafeKeyBoardState CONFRIM_STATE;
        public static final SafeKeyBoardState NORMAL_STATE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-339910057, "Lcom/baidu/wallet/base/widget/SafeKeyBoardUtil$SafeKeyBoardState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-339910057, "Lcom/baidu/wallet/base/widget/SafeKeyBoardUtil$SafeKeyBoardState;");
                    return;
                }
            }
            NORMAL_STATE = new SafeKeyBoardState("NORMAL_STATE", 0);
            SafeKeyBoardState safeKeyBoardState = new SafeKeyBoardState("CONFRIM_STATE", 1);
            CONFRIM_STATE = safeKeyBoardState;
            $VALUES = new SafeKeyBoardState[]{NORMAL_STATE, safeKeyBoardState};
        }

        public SafeKeyBoardState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SafeKeyBoardState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SafeKeyBoardState) Enum.valueOf(SafeKeyBoardState.class, str) : (SafeKeyBoardState) invokeL.objValue;
        }

        public static SafeKeyBoardState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SafeKeyBoardState[]) $VALUES.clone() : (SafeKeyBoardState[]) invokeV.objValue;
        }
    }

    public SafeKeyBoardUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void hideSoftInputMethod(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editText) == null) {
            ((InputMethodManager) this.f24542b.getSystemService("input_method")).hideSoftInputFromWindow(this.f24543c.getWindowToken(), 0);
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
    }

    public void hideSoftKeyBoard() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (safeKeyBoardPopupWindow = this.mPopupWindow) != null && safeKeyBoardPopupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
            b();
        }
    }

    public void init(Context context, ViewGroup viewGroup, SafeScrollView safeScrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, viewGroup, safeScrollView) == null) {
            this.f24542b = context;
            this.f24544d = viewGroup;
            this.f24545e = safeScrollView;
            if (this.mPopupWindow == null) {
                if (this.k == SafeKeyBoardState.CONFRIM_STATE) {
                    this.mPopupWindow = new SafeKeyBoardPopUpWindowNew(context);
                } else {
                    this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
                }
            }
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                SafeScrollView safeScrollView2 = this.f24545e;
                if (safeScrollView2 != null) {
                    this.f24548h = safeScrollView2.getLayoutParams().height;
                } else {
                    LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
                }
            }
        }
    }

    public void setState(SafeKeyBoardState safeKeyBoardState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, safeKeyBoardState) == null) {
            this.k = safeKeyBoardState;
        }
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, safeKeyBoardEditText, view) == null) {
            this.f24543c = safeKeyBoardEditText;
            this.f24546f = view;
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
            if (safeKeyBoardPopupWindow != null && safeKeyBoardEditText != null && view != null && this.f24545e != null && this.f24544d != null) {
                safeKeyBoardPopupWindow.setSafeEditTet(safeKeyBoardEditText);
                this.mPopupWindow.setScrollView(this.f24545e);
                hideSoftInputMethod(this.f24543c);
                if (this.f24545e.hasWindowFocus() && this.f24543c.isEnabled()) {
                    if (this.mPopupWindow != null && this.f24545e.hasWindowFocus()) {
                        this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                        try {
                            this.mPopupWindow.showAtLocation(this.f24544d, 80, 0, 0);
                            if (Build.VERSION.SDK_INT <= 23) {
                                this.mPopupWindow.update();
                            }
                        } catch (Exception unused) {
                            this.mPopupWindow = null;
                            return;
                        }
                    }
                    new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.wallet.base.widget.SafeKeyBoardUtil.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ SafeKeyBoardUtil f24550a;

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
                            this.f24550a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow2 = this.f24550a.mPopupWindow;
                                if (safeKeyBoardPopupWindow2 != null && safeKeyBoardPopupWindow2.isShowing() && this.f24550a.f24545e.hasWindowFocus()) {
                                    this.f24550a.a();
                                } else {
                                    new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.wallet.base.widget.SafeKeyBoardUtil.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass1 f24551a;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f24551a = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow3;
                                            Interceptable interceptable3 = $ic;
                                            if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && (safeKeyBoardPopupWindow3 = this.f24551a.f24550a.mPopupWindow) != null && safeKeyBoardPopupWindow3.isShowing() && this.f24551a.f24550a.f24545e.hasWindowFocus()) {
                                                this.f24551a.f24550a.a();
                                            }
                                        }
                                    }, 150L);
                                }
                            }
                        }
                    }, 150L);
                    return;
                }
                return;
            }
            LogUtil.errord("gaolou", "SafeKeyBoardUtil.showSoftKeyBoard ++ View == null");
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f24545e.getLayoutParams();
            layoutParams.height = this.f24548h;
            this.f24545e.setLayoutParams(layoutParams);
        }
    }

    private View a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, view)) == null) {
            while (view instanceof View) {
                if (16908290 == view.getId()) {
                    return view;
                }
                view = (View) view.getParent();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.mPopupWindow == null || this.f24545e == null || this.f24546f == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f24542b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f24547g = displayMetrics.heightPixels;
        this.j = this.mPopupWindow.getPopupWindowHeight();
        int[] iArr = new int[2];
        this.f24545e.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int i3 = 0;
        View a2 = a(this.f24545e);
        if (a2 != null) {
            i3 = this.f24547g - a2.getHeight();
        }
        int i4 = ((this.f24547g - this.j) - i2) - i3;
        if (i4 <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f24545e.getLayoutParams();
        layoutParams.height = i4;
        this.f24545e.setLayoutParams(layoutParams);
        this.f24545e.post(new Runnable(this, i3) { // from class: com.baidu.wallet.base.widget.SafeKeyBoardUtil.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f24552a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ SafeKeyBoardUtil f24553b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i3)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24553b = this;
                this.f24552a = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int[] iArr2 = new int[2];
                    this.f24553b.f24546f.getLocationOnScreen(iArr2);
                    SafeKeyBoardUtil safeKeyBoardUtil = this.f24553b;
                    safeKeyBoardUtil.f24549i = ((iArr2[1] + safeKeyBoardUtil.f24546f.getHeight()) - (this.f24553b.f24547g - this.f24553b.j)) + this.f24553b.f24543c.getGap() + this.f24552a;
                    if (this.f24553b.f24549i > 0) {
                        this.f24553b.f24545e.smoothScrollBy(0, this.f24553b.f24549i);
                    }
                    this.f24553b.f24545e.notifyShowKeyBoard(this.f24553b.j);
                }
            }
        });
    }
}
