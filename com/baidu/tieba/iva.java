package com.baidu.tieba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.iva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class iva {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final TBLottieAnimationView b;
    public View.OnClickListener c;
    public sa d;
    public int e;
    public final CustomMessageListener f;
    public final View.OnLayoutChangeListener g;
    public final Runnable h;

    /* loaded from: classes6.dex */
    public static final class a implements ra {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iva a;

        @Override // com.baidu.tieba.ra
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 2;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ra
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ra
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public a(iva ivaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ivaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ivaVar;
        }

        public static final void d(iva this$0, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                View.OnClickListener g = this$0.g();
                if (g != null) {
                    g.onClick(view2);
                }
                this$0.e();
            }
        }

        @Override // com.baidu.tieba.ra
        public View c(LayoutInflater inflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inflater)) == null) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                View contentView = inflater.inflate(R.layout.obfuscated_res_0x7f0d0a5c, (ViewGroup) null);
                SkinManager.setImageResource((ImageView) contentView.findViewById(R.id.obfuscated_res_0x7f09116a), R.drawable.write_guide);
                SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f09255d), (int) R.color.CAM_X0105);
                final iva ivaVar = this.a;
                contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.xua
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            iva.a.d(iva.this, view2);
                        }
                    }
                });
                Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
                return contentView;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ra
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return BdUtilHelper.getDimens(this.a.a, R.dimen.tbds4);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iva a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(iva ivaVar) {
            super(2921818);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ivaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ivaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921818) {
                this.a.b.playAnimation();
                this.a.j();
            }
        }
    }

    public iva(Activity activity, TBLottieAnimationView writeIcon) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, writeIcon};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(writeIcon, "writeIcon");
        this.a = activity;
        this.b = writeIcon;
        this.e = -1;
        this.f = new b(this);
        this.g = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.vua
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
                    iva.h(iva.this, view2, i3, i4, i5, i6, i7, i8, i9, i10);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.f);
        this.a.getWindow().getDecorView().addOnLayoutChangeListener(this.g);
        this.h = new Runnable() { // from class: com.baidu.tieba.wua
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    iva.f(iva.this);
                }
            }
        };
    }

    public static final void f(iva this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.e();
        }
    }

    public final void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }

    public static final void h(iva this$0, View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{this$0, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.e == -1) {
                this$0.e = i4;
            }
            if (i4 != this$0.e) {
                if (hxa.i.a().i()) {
                    this$0.b.resumeAnimation();
                    sa saVar = this$0.d;
                    if (saVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guide");
                        saVar = null;
                    }
                    saVar.d();
                    this$0.b.playAnimation();
                    this$0.j();
                }
                this$0.e = i4;
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f);
            SafeHandler.getInst().removeCallbacks(this.h);
            this.a.getWindow().getDecorView().removeOnLayoutChangeListener(this.g);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sa saVar = this.d;
            if (saVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guide");
                saVar = null;
            }
            saVar.d();
            YunDialogManager.unMarkShowingDialogName("writeGuide");
            hxa.i.a().o(false);
        }
    }

    public final View.OnClickListener g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            hxa.i.a().o(true);
            ta taVar = new ta();
            taVar.k(this.b);
            taVar.c(0);
            taVar.j(true);
            taVar.i(true);
            taVar.d(true);
            taVar.e(R.anim.anim_alpha_0_to_1_duration_300);
            taVar.f(R.anim.anim_alpha_1_to_0_duration_300);
            taVar.a(new a(this));
            sa b2 = taVar.b();
            Intrinsics.checkNotNullExpressionValue(b2, "builder.createGuide()");
            this.d = b2;
            sa saVar = null;
            if (b2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guide");
                b2 = null;
            }
            b2.l(false);
            sa saVar2 = this.d;
            if (saVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guide");
                saVar2 = null;
            }
            saVar2.m(true);
            sa saVar3 = this.d;
            if (saVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guide");
            } else {
                saVar = saVar3;
            }
            saVar.n(this.a);
            YunDialogManager.markShowingDialogName("writeGuide");
            SafeHandler.getInst().removeCallbacks(this.h);
            SafeHandler.getInst().postDelayed(this.h, 5000L);
            TiebaStatic.log(new StatisticItem("c15362").param("obj_type", 1));
        }
    }
}
