package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class SafeKeyBoardEditText extends PluginEditText implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SafeKeyBoardState a;

    /* renamed from: b  reason: collision with root package name */
    public Context f52748b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f52749c;

    /* renamed from: d  reason: collision with root package name */
    public SafeScrollView f52750d;

    /* renamed from: e  reason: collision with root package name */
    public View f52751e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52752f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52753g;

    /* renamed from: h  reason: collision with root package name */
    public int f52754h;

    /* renamed from: i  reason: collision with root package name */
    public int f52755i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f52756j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f52757k;
    public boolean l;
    public int m;
    public OnMyFocusChangeListener n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;
    public CheckFunc r;

    /* loaded from: classes13.dex */
    public interface CheckFunc {
        boolean check(String str);
    }

    /* loaded from: classes13.dex */
    public interface OnMyFocusChangeListener {
        void onMyFocusChange(View view, boolean z);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes13.dex */
    public static final class SafeKeyBoardState {
        public static final /* synthetic */ SafeKeyBoardState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SafeKeyBoardState CONFRIM_STATE;
        public static final SafeKeyBoardState NORMAL_STATE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1442765410, "Lcom/baidu/wallet/base/widget/SafeKeyBoardEditText$SafeKeyBoardState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1442765410, "Lcom/baidu/wallet/base/widget/SafeKeyBoardEditText$SafeKeyBoardState;");
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SafeKeyBoardEditText(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void dismissKeyBorad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f52750d.dismissKeyBoard(this);
        }
    }

    public CheckFunc getCheckFunc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : (CheckFunc) invokeV.objValue;
    }

    public int getCloseBtnVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52754h : invokeV.intValue;
    }

    public int getGap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.m == 0) {
                this.m = 8;
            }
            return this.m;
        }
        return invokeV.intValue;
    }

    public int getHeadLayoutVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f52755i : invokeV.intValue;
    }

    public SafeKeyBoardState getKeyBoardState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (SafeKeyBoardState) invokeV.objValue;
    }

    public View.OnClickListener getOnConfirmListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : (View.OnClickListener) invokeV.objValue;
    }

    public boolean getUseKeyDot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f52752f : invokeV.booleanValue;
    }

    public boolean getUseKeyX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f52753g : invokeV.booleanValue;
    }

    public boolean getUseRandKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f52757k : invokeV.booleanValue;
    }

    public boolean getUseSafeKeyBoard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public ViewGroup getViewGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f52749c : (ViewGroup) invokeV.objValue;
    }

    public View getVisibleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f52751e : (View) invokeV.objValue;
    }

    public void initSafeKeyBoardParams(ViewGroup viewGroup, SafeScrollView safeScrollView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{viewGroup, safeScrollView, view, Boolean.valueOf(z)}) == null) {
            this.f52749c = viewGroup;
            this.f52750d = safeScrollView;
            this.f52751e = view;
            if (z) {
                safeScrollView.showKeyBoard(viewGroup, this, view);
            }
        }
    }

    public boolean isShowLogoLockAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f52756j : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.base.widget.PluginEditText, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, view, motionEvent)) == null) {
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
                SafeScrollView safeScrollView = this.f52750d;
                if (safeScrollView == null) {
                    GlobalUtils.showInputMethod(this.f52748b, this);
                    return true;
                } else if (safeScrollView.isPopupWindowShowing()) {
                    return true;
                } else {
                    this.f52750d.showKeyBoard(this.f52749c, this, this.f52751e);
                    return true;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setCheckFunc(CheckFunc checkFunc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, checkFunc) == null) {
            this.r = checkFunc;
        }
    }

    public void setCloseBtnVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f52754h = i2;
        }
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.q = onClickListener;
        }
    }

    public void setDisablePast(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.p = z;
        }
    }

    public void setGap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.m = i2;
        }
    }

    public void setHeadLayoutVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f52755i = i2;
        }
    }

    public void setOnConfirmListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.q = onClickListener;
        }
    }

    public void setOnMyFocusChangeListener(OnMyFocusChangeListener onMyFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onMyFocusChangeListener) == null) {
            this.n = onMyFocusChangeListener;
        }
    }

    public void setShowLogoLockAnim(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f52756j = z;
        }
    }

    public void setShowSystemKeyBoard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.o = z;
        }
    }

    public void setUseKeyDot(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.f52752f = z;
        }
    }

    public void setUseKeyX(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.f52753g = z;
        }
    }

    public void setUseRandKey(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f52757k = z;
        }
    }

    public void setUseSafeKeyBoard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.l = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f52752f = false;
        this.f52753g = false;
        this.f52754h = 0;
        this.f52755i = 0;
        this.f52756j = true;
        this.l = true;
        this.m = 0;
        this.o = false;
        this.p = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52752f = false;
        this.f52753g = false;
        this.f52754h = 0;
        this.f52755i = 0;
        this.f52756j = true;
        this.l = true;
        this.m = 0;
        this.o = false;
        this.p = false;
        this.f52748b = context;
        setOnLongClickListener(new View.OnLongClickListener(this) { // from class: com.baidu.wallet.base.widget.SafeKeyBoardEditText.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SafeKeyBoardEditText a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view)) == null) {
                    if (this.a.p) {
                        this.a.requestFocusFromTouch();
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        });
        setOnTouchListener(this);
        setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: com.baidu.wallet.base.widget.SafeKeyBoardEditText.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SafeKeyBoardEditText a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view, z) == null) {
                    if (!z) {
                        SafeKeyBoardEditText safeKeyBoardEditText = this.a;
                        if (!safeKeyBoardEditText.isAlwaysShow) {
                            if (safeKeyBoardEditText.f52750d != null) {
                                this.a.f52750d.dismissKeyBoard(this.a);
                            } else {
                                GlobalUtils.hideInputMethod(this.a.f52748b, this.a);
                            }
                        }
                    } else if (this.a.l) {
                        GlobalUtils.hideInputMethod(this.a.f52748b, this.a);
                        if (this.a.f52750d != null && this.a.f52750d.hasWindowFocus() && !this.a.f52750d.isPopupWindowShowing()) {
                            SafeScrollView safeScrollView = this.a.f52750d;
                            ViewGroup viewGroup = this.a.f52749c;
                            SafeKeyBoardEditText safeKeyBoardEditText2 = this.a;
                            safeScrollView.showKeyBoard(viewGroup, safeKeyBoardEditText2, safeKeyBoardEditText2.f52751e);
                        }
                    }
                    if (this.a.n != null) {
                        this.a.n.onMyFocusChange(view, z);
                    }
                }
            }
        });
    }
}
