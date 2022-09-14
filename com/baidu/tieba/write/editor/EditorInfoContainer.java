package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.CommunityConventionView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.au4;
import com.baidu.tieba.ay4;
import com.baidu.tieba.bx4;
import com.baidu.tieba.ej;
import com.baidu.tieba.g55;
import com.baidu.tieba.u45;
import com.baidu.tieba.uu4;
import com.baidu.tieba.write.view.CustomPrivacyDialogView;
import com.baidu.tieba.x19;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class EditorInfoContainer extends LinearLayout implements g55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn a;
    public TBSpecificationBtn b;
    public TBSpecificationBtn c;
    public EditorTools d;
    public int e;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public CommunityConventionView j;
    public LinearLayout k;
    public LinearLayout l;
    public HorizontalScrollView m;
    public View n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public a(EditorInfoContainer editorInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorInfoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_COMMUNITY_CONVENTION_CLICK).addParam("obj_locate", "2").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getContext(), "", TbConfig.COMMUNITY_CONVENTION, true);
                tbWebViewActivityConfig.setFixTitle(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public final /* synthetic */ au4 b;
        public final /* synthetic */ EditorInfoContainer c;

        public b(EditorInfoContainer editorInfoContainer, h hVar, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, hVar, au4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = editorInfoContainer;
            this.a = hVar;
            this.b = au4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null) {
                    TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 2));
                    this.a.a(true);
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public final /* synthetic */ au4 b;
        public final /* synthetic */ EditorInfoContainer c;

        public c(EditorInfoContainer editorInfoContainer, h hVar, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, hVar, au4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = editorInfoContainer;
            this.a = hVar;
            this.b = au4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null) {
                    TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 1));
                    this.a.a(false);
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public d(EditorInfoContainer editorInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorInfoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.K(new u45(43, -1, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ EditorInfoContainer b;

        /* loaded from: classes6.dex */
        public class a implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.write.editor.EditorInfoContainer.h
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if ("from_share_write".equals(this.a.b.h)) {
                        if (!"1".equals(this.a.b.g)) {
                            if ("2".equals(this.a.b.g)) {
                                TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 5));
                            }
                        } else {
                            TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 6));
                        }
                    }
                    if (z) {
                        int i = ((Integer) this.a.b.a.a).intValue() == 0 ? 1 : 0;
                        this.a.b.x(i);
                        if ("2".equals(this.a.b.g)) {
                            x19.b(this.a.b.i, i);
                        }
                    }
                }
            }
        }

        public e(EditorInfoContainer editorInfoContainer, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = editorInfoContainer;
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", ((Integer) this.b.a.a).intValue() == 0 ? 11 : 12));
                EditorInfoContainer editorInfoContainer = this.b;
                editorInfoContainer.w(this.a, ((Integer) editorInfoContainer.a.a).intValue(), new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public f(EditorInfoContainer editorInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorInfoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !((Boolean) this.a.c.a).booleanValue();
                this.a.y(z);
                bx4.k().u("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements x19.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public g(EditorInfoContainer editorInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorInfoContainer;
        }

        @Override // com.baidu.tieba.x19.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.x(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface h {
        void a(boolean z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (AttributeSet) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.v45
    public void B(u45 u45Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, u45Var) == null) || u45Var == null) {
            return;
        }
        int i = u45Var.a;
        if (i == 54) {
            K(new u45(55, -1, Boolean.valueOf(t())));
        } else if (i == 57) {
            K(new u45(58, -1, Boolean.FALSE));
        } else if (i != 65) {
        } else {
            K(new u45(66, -1, Boolean.valueOf(u())));
        }
    }

    @Override // com.baidu.tieba.g55
    public void K(u45 u45Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u45Var) == null) || (editorTools = this.d) == null) {
            return;
        }
        editorTools.A(u45Var);
    }

    @Override // com.baidu.tieba.g55
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f) {
                this.f = false;
            }
            setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.g55
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : invokeV.intValue;
    }

    @Override // com.baidu.tieba.g55
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i();
            setVisibility(8);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.g55
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void k() {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (tBSpecificationBtn = this.c) == null) {
            return;
        }
        tBSpecificationBtn.setVisibility(8);
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            this.n = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds1), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
            layoutParams.gravity = 16;
            addView(this.n, layoutParams);
            CommunityConventionView communityConventionView = new CommunityConventionView(context);
            this.j = communityConventionView;
            communityConventionView.setOnClickListener(new a(this));
            this.j.setId(R.id.obfuscated_res_0x7f090886);
            addView(this.j, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            LinearLayout linearLayout = new LinearLayout(context);
            this.k = linearLayout;
            linearLayout.setGravity(3);
            addView(this.k, layoutParams);
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
            this.m = horizontalScrollView;
            horizontalScrollView.setHorizontalFadingEdgeEnabled(true);
            this.m.setHorizontalScrollBarEnabled(false);
            this.k.addView(this.m);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout2 = new LinearLayout(context);
            this.l = linearLayout2;
            this.m.addView(linearLayout2, layoutParams2);
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ej.f(getContext(), R.dimen.tbds62));
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            ay4 ay4Var = new ay4();
            ay4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            ay4Var.h(R.color.CAM_X0110);
            ay4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            ay4Var.m(ej.f(getContext(), R.dimen.M_W_X004), ej.f(getContext(), R.dimen.M_W_X004));
            ay4Var.n(ej.f(getContext(), R.dimen.M_H_X002));
            ay4Var.i(R.drawable.obfuscated_res_0x7f080617, 0, TBSpecificationButtonConfig.IconType.WEBP);
            ay4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.b = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(ay4Var);
            this.b.setTextSize(R.dimen.T_X09);
            this.b.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0543));
            this.b.setOnClickListener(new d(this));
            this.l.addView(this.b, layoutParams);
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ej.f(getContext(), R.dimen.tbds62));
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            ay4 ay4Var = new ay4();
            ay4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            ay4Var.h(R.color.CAM_X0302);
            ay4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            ay4Var.m(ej.f(getContext(), R.dimen.M_W_X004), ej.f(getContext(), R.dimen.M_W_X004));
            ay4Var.n(ej.f(getContext(), R.dimen.M_H_X002));
            ay4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.a = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(ay4Var);
            this.a.setTextSize(R.dimen.T_X09);
            x(0);
            this.a.setLayoutParams(layoutParams);
            this.a.setOnClickListener(new e(this, context));
            this.l.addView(this.a);
        }
    }

    @Override // com.baidu.tieba.g55
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            uu4.d(this.n).f(R.color.CAM_X0401);
            TBSpecificationBtn tBSpecificationBtn = this.a;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.b;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.k();
            }
            CommunityConventionView communityConventionView = this.j;
            if (communityConventionView != null) {
                communityConventionView.onChangeSkinType(i);
            }
            TBSpecificationBtn tBSpecificationBtn3 = this.c;
            if (tBSpecificationBtn3 != null) {
                tBSpecificationBtn3.k();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    public void p(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048591, this, str, i) == null) && "2".equals(this.g)) {
            this.i = str;
            x19.a(str, i, new g(this));
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && "2".equals(this.g)) {
            x(i);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
        }
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ej.f(getContext(), R.dimen.tbds62));
            ay4 ay4Var = new ay4();
            ay4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            ay4Var.h(R.color.CAM_X0302);
            ay4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            ay4Var.m(ej.f(getContext(), R.dimen.M_W_X004), ej.f(getContext(), R.dimen.M_W_X004));
            ay4Var.n(ej.f(getContext(), R.dimen.M_H_X002));
            ay4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.c = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(ay4Var);
            this.c.setTextSize(R.dimen.T_X09);
            this.c.setLayoutParams(layoutParams);
            this.c.setOnClickListener(new f(this));
            this.l.addView(this.c);
            bx4 k = bx4.k();
            y(k.h("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
        }
    }

    @Override // com.baidu.tieba.g55
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.d = editorTools;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.h = str;
        }
    }

    @Override // com.baidu.tieba.g55
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.e = i;
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            TBSpecificationBtn tBSpecificationBtn2 = this.a;
            return (tBSpecificationBtn2 == null || ((Integer) tBSpecificationBtn2.a).intValue() != 0) && (tBSpecificationBtn = this.a) != null && ((Integer) tBSpecificationBtn.a).intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.c;
            if (tBSpecificationBtn != null) {
                Object obj = tBSpecificationBtn.a;
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void v(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (tBSpecificationBtn = this.b) == null) {
            return;
        }
        tBSpecificationBtn.setVisibility(z ? 0 : 8);
    }

    public final void w(Context context, int i, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048601, this, context, i, hVar) == null) {
            boolean h2 = bx4.k().h("show_privacy_dialog", false);
            if (i == 1 || h2) {
                if (hVar != null) {
                    hVar.a(true);
                    return;
                }
                return;
            }
            bx4.k().u("show_privacy_dialog", true);
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) context;
            if (tbPageContextSupport == null || tbPageContextSupport.getPageContext() == null || tbPageContextSupport.getPageContext().getPageActivity() == null) {
                return;
            }
            au4 au4Var = new au4(tbPageContextSupport.getPageContext().getPageActivity());
            au4Var.setCancelable(false);
            au4Var.setPositiveButton((String) null, (au4.e) null);
            au4Var.setNegativeButton((String) null, (au4.e) null);
            au4Var.setContentViewSize(6);
            CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
            customPrivacyDialogView.setMessageTextViewMessage(context.getString(R.string.obfuscated_res_0x7f0f15fb));
            customPrivacyDialogView.setMessageTextViewColor(SkinManager.getColor(R.color.CAM_X0107));
            customPrivacyDialogView.setPrivacyDialogCancelButtonText(context.getString(R.string.obfuscated_res_0x7f0f15f9));
            customPrivacyDialogView.setPrivacyDialogConfirmButtonText(context.getString(R.string.obfuscated_res_0x7f0f15fa));
            customPrivacyDialogView.setPrivacyDialogCancelButtonListener(new b(this, hVar, au4Var));
            customPrivacyDialogView.setPrivacyDialogConfirmButtonListener(new c(this, hVar, au4Var));
            au4Var.setContentView(customPrivacyDialogView);
            au4Var.create(tbPageContextSupport.getPageContext()).show();
            TiebaStatic.log(new StatisticItem("c13804"));
        }
    }

    public final void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.a.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0f53));
            this.a.getStyleConfig().i(i == 0 ? R.drawable.obfuscated_res_0x7f0809b4 : R.drawable.obfuscated_res_0x7f0809b3, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.a.getStyleConfig().h(i == 0 ? R.color.CAM_X0302 : R.color.CAM_X0110);
            this.a.a = Integer.valueOf(i);
        }
    }

    public final void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.c.setText(getResources().getString(R.string.obfuscated_res_0x7f0f119a));
            this.c.getStyleConfig().i(z ? R.drawable.obfuscated_res_0x7f0809b4 : R.drawable.obfuscated_res_0x7f0809b3, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.c.getStyleConfig().h(z ? R.color.CAM_X0302 : R.color.CAM_X0110);
            this.c.a = Boolean.valueOf(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = true;
        this.g = str;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) context.getResources().getDimension(R.dimen.M_H_X004), 0, (int) context.getResources().getDimension(R.dimen.M_H_X003));
        setGravity(16);
        setOrientation(0);
        m(context);
        l(context);
        n(context);
        o(context);
        s(context);
    }
}
