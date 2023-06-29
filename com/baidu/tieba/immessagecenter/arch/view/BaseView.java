package com.baidu.tieba.immessagecenter.arch.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.htb;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel;
import com.baidu.tieba.immessagecenter.arch.vm.IUiIntent;
import com.baidu.tieba.immessagecenter.arch.vm.IUiState;
import com.baidu.tieba.immessagecenter.msgtab.obs.SkinTypeChangedMonitor;
import com.baidu.tieba.ltb;
import com.baidu.tieba.lx5;
import com.baidu.tieba.ptb;
import com.baidu.tieba.sd8;
import com.baidu.tieba.xxb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\u0014\b\u0002\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00062\u00020\u0007B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ#\u0010!\u001a\u0002H\"\"\n\b\u0003\u0010\"*\u0004\u0018\u00010#2\b\b\u0001\u0010$\u001a\u00020\tH\u0004¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H$J\r\u0010*\u001a\u00028\u0002H$¢\u0006\u0002\u0010\u001eJ\b\u0010+\u001a\u00020'H\u0016J\b\u0010,\u001a\u00020'H\u0016J\b\u0010-\u001a\u00020'H$J\u0015\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00028\u0000H$¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u00102\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u00020\fJ\b\u00107\u001a\u00020'H\u0002R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00028\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u00068"}, d2 = {"Lcom/baidu/tieba/immessagecenter/arch/view/BaseView;", "UiState", "Lcom/baidu/tieba/immessagecenter/arch/vm/IUiState;", "UiIntent", "Lcom/baidu/tieba/immessagecenter/arch/vm/IUiIntent;", "VM", "Lcom/baidu/tieba/immessagecenter/arch/vm/BaseViewModel;", "Lcom/baidu/tieba/immessagecenter/arch/view/IView;", "layoutId", "", "(I)V", "value", "", "isSelected", "()Z", "setSelected", "(Z)V", "mSubscriptions", "Lrx/subscriptions/CompositeSubscription;", "getMSubscriptions", "()Lrx/subscriptions/CompositeSubscription;", "setMSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "<set-?>", "Lcom/baidu/tieba/immessagecenter/arch/view/LifecycleRootView;", "rootView", "getRootView", "()Lcom/baidu/tieba/immessagecenter/arch/view/LifecycleRootView;", "viewModel", "getViewModel", "()Lcom/baidu/tieba/immessagecenter/arch/vm/BaseViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "findViewById", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "id", "(I)Landroid/view/View;", "init", "", "context", "Landroid/content/Context;", "initViewModel", "onAttachedUi", "onDetachedUi", "onFinishInflate", "onRender", "state", "(Lcom/baidu/tieba/immessagecenter/arch/vm/IUiState;)V", "onSelected", "syncInflate", "root", "Landroid/view/ViewGroup;", "attachToRoot", "isAutoAttache", "unsubscribeAll", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class BaseView<UiState extends IUiState, UiIntent extends IUiIntent, VM extends BaseViewModel<UiState, UiIntent>> implements sd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public xxb b;
    public LifecycleRootView c;
    public final Lazy d;

    public abstract void C();

    public abstract void D(UiState uistate);

    @Override // com.baidu.tieba.sd8
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public abstract void p(Context context);

    public abstract VM q();

    public BaseView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<VM>(this) { // from class: com.baidu.tieba.immessagecenter.arch.view.BaseView$viewModel$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseView<UiState, UiIntent, VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Incorrect return type in method signature: ()TVM; */
            @Override // kotlin.jvm.functions.Function0
            public final BaseViewModel invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return this.this$0.q();
                }
                return (BaseViewModel) invokeV.objValue;
            }
        });
    }

    public static /* synthetic */ View H(BaseView baseView, Context context, ViewGroup viewGroup, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 8) != 0) {
                z2 = true;
            }
            return baseView.G(context, viewGroup, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncInflate");
    }

    public static final void r(BaseView this$0, Integer skinType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, skinType) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(skinType, "skinType");
            this$0.onChangeSkinType(skinType.intValue());
        }
    }

    public static final void t(BaseView this$0, IUiState uiState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, uiState) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(uiState, "uiState");
            this$0.D(uiState);
        }
    }

    public static final Boolean s(IUiState iUiState) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iUiState)) == null) {
            if (iUiState != null) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeL.objValue;
    }

    public final void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            l().setSelected(z);
        }
    }

    public final <T extends View> T g(@IdRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            lx5.b(l());
            return (T) l().findViewById(i);
        }
        return (T) invokeI.objValue;
    }

    public final View G(Context context, ViewGroup viewGroup, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, viewGroup, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            View inflate = LayoutInflater.from(context).inflate(this.a, viewGroup, z);
            LifecycleRootView lifecycleRootView = new LifecycleRootView(context, this, z2);
            lifecycleRootView.addView(inflate);
            this.c = lifecycleRootView;
            C();
            p(context);
            return l();
        }
        return (View) invokeCommon.objValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            xxb xxbVar = this.b;
            if (xxbVar != null) {
                xxbVar.unsubscribe();
            }
            xxb xxbVar2 = this.b;
            if (xxbVar2 != null) {
                xxbVar2.c();
            }
            this.b = null;
        }
    }

    @Override // com.baidu.tieba.jd8
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            m().f();
            I();
        }
    }

    public final xxb j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return (xxb) invokeV.objValue;
    }

    public final LifecycleRootView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            LifecycleRootView lifecycleRootView = this.c;
            if (lifecycleRootView != null) {
                return lifecycleRootView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            return null;
        }
        return (LifecycleRootView) invokeV.objValue;
    }

    public final VM m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return (VM) this.d.getValue();
        }
        return (VM) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jd8
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            m().b();
            I();
            xxb xxbVar = new xxb();
            xxbVar.a(SkinTypeChangedMonitor.c.a().d().s(htb.b()).g().F(new ltb() { // from class: com.baidu.tieba.rd8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ltb
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        BaseView.r(BaseView.this, (Integer) obj);
                    }
                }
            }));
            xxbVar.a(m().g().k(new ptb() { // from class: com.baidu.tieba.qd8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ptb
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? BaseView.s((IUiState) obj) : invokeL.objValue;
                }
            }).F(new ltb() { // from class: com.baidu.tieba.pd8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ltb
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        BaseView.t(BaseView.this, (IUiState) obj);
                    }
                }
            }));
            this.b = xxbVar;
        }
    }
}
