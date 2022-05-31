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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.CommunityConventionView;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.view.CustomPrivacyDialogView;
import com.baidu.tieba.write.write.TransmitPostEditActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dq4;
import com.repackage.f05;
import com.repackage.j15;
import com.repackage.li;
import com.repackage.ot4;
import com.repackage.sz4;
import com.repackage.wq4;
import com.repackage.ys4;
import com.repackage.yv8;
/* loaded from: classes4.dex */
public class EditorInfoContainer extends LinearLayout implements f05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LocationInfoView a;
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public final /* synthetic */ dq4 b;
        public final /* synthetic */ EditorInfoContainer c;

        public b(EditorInfoContainer editorInfoContainer, h hVar, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, hVar, dq4Var};
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
            this.b = dq4Var;
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

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public final /* synthetic */ dq4 b;
        public final /* synthetic */ EditorInfoContainer c;

        public c(EditorInfoContainer editorInfoContainer, h hVar, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, hVar, dq4Var};
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
            this.b = dq4Var;
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

    /* loaded from: classes4.dex */
    public class d implements LocationInfoView.a {
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

        @Override // com.baidu.tbadk.editortools.editorinfotool.LocationInfoView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 3));
                this.a.g(new sz4(18, -1, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public e(EditorInfoContainer editorInfoContainer) {
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
                this.a.g(new sz4(43, -1, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ EditorInfoContainer b;

        /* loaded from: classes4.dex */
        public class a implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // com.baidu.tieba.write.editor.EditorInfoContainer.h
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if (TransmitPostEditActivity.FROM_SHARE_WRITE.equals(this.a.b.h)) {
                        if (!"1".equals(this.a.b.g)) {
                            if ("2".equals(this.a.b.g)) {
                                TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 5));
                            }
                        } else {
                            TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 6));
                        }
                    }
                    if (z) {
                        int i = ((Integer) this.a.b.b.a).intValue() == 0 ? 1 : 0;
                        this.a.b.w(i);
                        if ("2".equals(this.a.b.g)) {
                            yv8.b(this.a.b.i, i);
                        }
                    }
                }
            }
        }

        public f(EditorInfoContainer editorInfoContainer, Context context) {
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
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", ((Integer) this.b.b.a).intValue() == 0 ? 11 : 12));
                EditorInfoContainer editorInfoContainer = this.b;
                editorInfoContainer.v(this.a, ((Integer) editorInfoContainer.b.a).intValue(), new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements yv8.c {
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

        @Override // com.repackage.yv8.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.w(i);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    @Override // com.repackage.f05
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f) {
                this.f = false;
                g(new sz4(18, -1, Config.TRACE_VISIT_FIRST));
            }
            setVisibility(0);
        }
    }

    @Override // com.repackage.f05
    public void g(sz4 sz4Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sz4Var) == null) || (editorTools = this.d) == null) {
            return;
        }
        editorTools.A(sz4Var);
    }

    @Override // com.repackage.f05
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.intValue;
    }

    @Override // com.repackage.f05
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i();
            setVisibility(8);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.repackage.f05
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            this.n = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds1), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
            layoutParams.gravity = 16;
            addView(this.n, layoutParams);
            CommunityConventionView communityConventionView = new CommunityConventionView(context);
            this.j = communityConventionView;
            communityConventionView.setOnClickListener(new a(this));
            this.j.setId(R.id.obfuscated_res_0x7f090849);
            addView(this.j, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, li.f(getContext(), R.dimen.tbds62));
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            ot4 ot4Var = new ot4();
            ot4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            ot4Var.h(R.color.CAM_X0110);
            ot4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            ot4Var.m(li.f(getContext(), R.dimen.M_W_X004), li.f(getContext(), R.dimen.M_W_X004));
            ot4Var.n(li.f(getContext(), R.dimen.M_H_X002));
            ot4Var.i(R.drawable.obfuscated_res_0x7f0805fe, 0, TBSpecificationButtonConfig.IconType.WEBP);
            ot4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.c = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(ot4Var);
            this.c.setTextSize(R.dimen.T_X09);
            this.c.setText(getContext().getString(R.string.obfuscated_res_0x7f0f052e));
            this.c.setOnClickListener(new e(this));
            this.l.addView(this.c, layoutParams);
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            LocationInfoView locationInfoView = new LocationInfoView(context);
            this.a = locationInfoView;
            locationInfoView.setId(R.id.obfuscated_res_0x7f09084a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            this.a.setLocationClickListener(new d(this));
            this.l.addView(this.a, layoutParams);
        }
    }

    @Override // com.repackage.tz4
    public void onAction(sz4 sz4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sz4Var) == null) || sz4Var == null) {
            return;
        }
        int i = sz4Var.a;
        if (i == 19) {
            LocationInfoView locationInfoView = this.a;
            if (locationInfoView == null) {
                return;
            }
            Object obj = sz4Var.c;
            if (obj instanceof j15) {
                j15 j15Var = (j15) obj;
                locationInfoView.setState(j15Var.a, j15Var.b);
                return;
            }
            locationInfoView.setState(0, null);
        } else if (i == 20) {
            LocationInfoView locationInfoView2 = this.a;
            if (locationInfoView2 == null) {
                return;
            }
            locationInfoView2.setState(0, null);
        } else if (i == 54) {
            g(new sz4(55, -1, Boolean.valueOf(t())));
        } else if (i != 57) {
        } else {
            g(new sz4(58, -1, Boolean.FALSE));
        }
    }

    @Override // com.repackage.f05
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            wq4.d(this.n).f(R.color.CAM_X0401);
            LocationInfoView locationInfoView = this.a;
            if (locationInfoView != null) {
                locationInfoView.b(i);
            }
            TBSpecificationBtn tBSpecificationBtn = this.b;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.c;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.k();
            }
            CommunityConventionView communityConventionView = this.j;
            if (communityConventionView != null) {
                communityConventionView.onChangeSkinType(i);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, li.f(getContext(), R.dimen.tbds62));
            ot4 ot4Var = new ot4();
            ot4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            ot4Var.h(R.color.CAM_X0302);
            ot4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            ot4Var.m(li.f(getContext(), R.dimen.M_W_X004), li.f(getContext(), R.dimen.M_W_X004));
            ot4Var.n(li.f(getContext(), R.dimen.M_H_X002));
            ot4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.b = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(ot4Var);
            this.b.setTextSize(R.dimen.T_X09);
            w(0);
            this.b.setLayoutParams(layoutParams);
            this.b.setOnClickListener(new f(this, context));
            this.l.addView(this.b);
        }
    }

    public void q(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048591, this, str, i) == null) && "2".equals(this.g)) {
            this.i = str;
            yv8.a(str, i, new g(this));
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && "2".equals(this.g)) {
            w(i);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
        }
    }

    @Override // com.repackage.f05
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.d = editorTools;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.h = str;
        }
    }

    @Override // com.repackage.f05
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.e = i;
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            TBSpecificationBtn tBSpecificationBtn2 = this.b;
            return (tBSpecificationBtn2 == null || ((Integer) tBSpecificationBtn2.a).intValue() != 0) && (tBSpecificationBtn = this.b) != null && ((Integer) tBSpecificationBtn.a).intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public void u(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (tBSpecificationBtn = this.c) == null) {
            return;
        }
        tBSpecificationBtn.setVisibility(z ? 0 : 8);
    }

    public final void v(Context context, int i, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048599, this, context, i, hVar) == null) {
            boolean h2 = ys4.k().h("show_privacy_dialog", false);
            if (i == 1 || h2) {
                if (hVar != null) {
                    hVar.a(true);
                    return;
                }
                return;
            }
            ys4.k().u("show_privacy_dialog", true);
            BaseActivity baseActivity = (BaseActivity) context;
            dq4 dq4Var = new dq4(baseActivity);
            dq4Var.setCancelable(false);
            dq4Var.setPositiveButton((String) null, (dq4.e) null);
            dq4Var.setNegativeButton((String) null, (dq4.e) null);
            dq4Var.setContentViewSize(6);
            CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
            customPrivacyDialogView.setMessageTextViewMessage(context.getString(R.string.obfuscated_res_0x7f0f15d2));
            customPrivacyDialogView.setMessageTextViewColor(SkinManager.getColor(R.color.CAM_X0107));
            customPrivacyDialogView.setPrivacyDialogCancelButtonText(context.getString(R.string.obfuscated_res_0x7f0f15d0));
            customPrivacyDialogView.setPrivacyDialogConfirmButtonText(context.getString(R.string.obfuscated_res_0x7f0f15d1));
            customPrivacyDialogView.setPrivacyDialogCancelButtonListener(new b(this, hVar, dq4Var));
            customPrivacyDialogView.setPrivacyDialogConfirmButtonListener(new c(this, hVar, dq4Var));
            dq4Var.setContentView(customPrivacyDialogView);
            dq4Var.create(baseActivity.getPageContext()).show();
            TiebaStatic.log(new StatisticItem("c13804"));
        }
    }

    public final void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.b.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0f15));
            this.b.getStyleConfig().i(i == 0 ? R.drawable.obfuscated_res_0x7f080983 : R.drawable.obfuscated_res_0x7f080982, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.b.getStyleConfig().h(i == 0 ? R.color.CAM_X0302 : R.color.CAM_X0110);
            this.b.a = Integer.valueOf(i);
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
        o(context);
        n(context);
        p(context);
    }
}
