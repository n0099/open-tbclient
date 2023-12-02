package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.tieba.push.PushGuideManager;
import com.baidu.tieba.push.PushSceneItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    @NonNull
    public final b b;

    /* loaded from: classes8.dex */
    public interface a {
        void onClose();
    }

    /* loaded from: classes8.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final BdPageContext<?> a;
        public final Context b;
        public View c;
        public TextView d;
        public ViewGroup e;
        @Nullable
        public a f;
        @NonNull
        public final View.OnClickListener g;
        @NonNull
        public final View.OnClickListener h;

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public abstract void c();

        @LayoutRes
        public abstract int e();

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    DialogUtil.jumpSystemNotificationSetting(this.a.a);
                    TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 1));
                }
            }
        }

        /* renamed from: com.baidu.tieba.t69$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC0480b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public View$OnClickListenerC0480b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    a aVar = this.a.f;
                    if (aVar != null) {
                        aVar.onClose();
                    }
                    TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 2));
                }
            }
        }

        public b(@NonNull BdPageContext<?> bdPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = new a(this);
            this.h = new View$OnClickListenerC0480b(this);
            this.a = bdPageContext;
            this.b = bdPageContext.getPageActivity();
        }

        @NonNull
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                View inflate = LayoutInflater.from(this.b).inflate(e(), (ViewGroup) null);
                this.c = inflate;
                this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ae7);
                this.e = (ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f091aea);
                c();
                return this.c;
            }
            return (View) invokeV.objValue;
        }

        @CallSuper
        public void d(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                if (z) {
                    TBSelector.makeDrawableSelector().setShape(0).tlRadius(BdUtilHelper.getDimens(this.b, R.dimen.tbds36)).blRadius(BdUtilHelper.getDimens(this.b, R.dimen.tbds36)).gradientLinear(DrawableSelector.LEFT_RIGHT, R.color.open_notify_start_color, R.color.open_notify_start_color, R.color.open_notify_end_color).into(this.e);
                } else {
                    SkinManager.setBackgroundResource(this.c, R.color.CAM_X0204);
                }
                EMManager.from(this.d).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0107).setTextStyle(R.string.F_X01);
            }
        }

        public void f(@Nullable a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
                this.f = aVar;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TBSpecificationBtn i;
        public TBSpecificationBtn j;

        @Override // com.baidu.tieba.t69.b
        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d078d : invokeV.intValue;
        }

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    PushGuideManager.m("message_tab");
                    this.a.h.onClick(view2);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NonNull BdPageContext<?> bdPageContext) {
            super(bdPageContext);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((BdPageContext) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.t69.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.i = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f090517);
                e65 e65Var = new e65();
                e65Var.s(R.color.CAM_X0302, R.color.CAM_X0101);
                this.i.setConfig(e65Var);
                this.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f3e));
                this.i.setTextSize(R.dimen.T_X08);
                this.i.setOnClickListener(this.g);
                this.j = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f0904f4);
                e65 e65Var2 = new e65();
                e65Var2.w(R.color.CAM_X0105);
                this.j.setConfig(e65Var2);
                this.j.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f3d));
                this.j.setTextSize(R.dimen.T_X08);
                this.j.setOnClickListener(new a(this));
                PushSceneItem l = PushGuideManager.l("message_tab");
                if (l != null && !TextUtils.isEmpty(l.getTitle())) {
                    this.d.setText(l.getTitle());
                }
            }
        }

        @Override // com.baidu.tieba.t69.b
        public void d(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                super.d(i, z);
                this.i.l(i);
                this.j.l(i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView i;
        public ImageView j;
        public RelativeLayout k;

        @Override // com.baidu.tieba.t69.b
        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d078c : invokeV.intValue;
        }

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    SharedPrefHelper.getInstance().putLong("key_im_open_notification_close_time", System.currentTimeMillis());
                    this.a.h.onClick(view2);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NonNull BdPageContext<?> bdPageContext) {
            super(bdPageContext);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((BdPageContext) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.t69.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.M_H_X001);
                layoutParams.rightMargin = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.M_H_X004);
                this.k.setLayoutParams(layoutParams);
                int dimens = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.M_W_X007);
                this.j.setLeft(dimens);
                this.j.setRight(dimens);
            }
        }

        @Override // com.baidu.tieba.t69.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.k = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091aea);
                TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090517);
                this.i = textView;
                textView.setOnClickListener(this.g);
                ImageView imageView = (ImageView) this.c.findViewById(R.id.img_close);
                this.j = imageView;
                imageView.setOnClickListener(new a(this));
            }
        }

        @Override // com.baidu.tieba.t69.b
        public void d(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                super.d(i, z);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0110, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                EMManager.from(this.i).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0341);
            }
        }
    }

    public t69(BdPageContext bdPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        cga j = PushGuideManager.j("message_tab");
        if (j != null && j.i()) {
            this.b = new c(bdPageContext);
        } else {
            this.b = new d(bdPageContext);
        }
        this.a = this.b.b();
        TiebaStatic.log("c13704");
        b(TbadkCoreApplication.getInst().getSkinType(), z);
        if (!z) {
            this.b.a();
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            cga j = PushGuideManager.j("message_tab");
            if (j != null && j.f()) {
                return j.i();
            }
            return e();
        }
        return invokeV.booleanValue;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (PushGuideManager.d()) {
                return false;
            }
            long j = SharedPrefHelper.getInstance().getLong("key_im_open_notification_close_time", 0L);
            if (j != 0 && System.currentTimeMillis() - j <= 604800000) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void b(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.b.d(i, z);
        }
    }

    public void c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.b.f(aVar);
        }
    }
}
