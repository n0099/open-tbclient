package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tk8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class si8 extends jz5<bi8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public BarImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TBSpecificationBtn o;
    public String p;
    public String q;
    public bi8 r;
    public LikeModel s;
    public tk8 t;
    public boolean u;

    /* loaded from: classes5.dex */
    public class a extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ si8 a;

        public a(si8 si8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = si8Var;
        }

        @Override // com.baidu.tieba.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.u = false;
                if (this.a.s.getErrorCode() == 22) {
                    ri.N(this.a.b.getPageActivity(), this.a.b.getString(R.string.obfuscated_res_0x7f0f0828));
                } else if (obj == null) {
                } else {
                    if (this.a.s.getErrorCode() != 0) {
                        ri.N(this.a.b.getPageActivity(), this.a.s.getErrorString());
                    } else {
                        this.a.x(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements tk8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ si8 a;

        public b(si8 si8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = si8Var;
        }

        @Override // com.baidu.tieba.tk8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.a.u = false;
            }
        }

        @Override // com.baidu.tieba.tk8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.u = false;
                this.a.x(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public si8(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = false;
        this.p = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0687);
        this.q = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f068b);
        View h = h();
        this.i = h;
        this.j = (BarImageView) h.findViewById(R.id.obfuscated_res_0x7f09032a);
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090337);
        this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090780);
        this.m = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0914da);
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091a18);
        this.o = (TBSpecificationBtn) h.findViewById(R.id.obfuscated_res_0x7f090a67);
    }

    @Override // com.baidu.tieba.jz5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07ce : invokeV.intValue;
    }

    @Override // com.baidu.tieba.jz5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            this.o.k();
            SkinManager.setBackgroundColor(h(), R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || this.r == null) {
            return;
        }
        if (this.i == view2) {
            v();
            j06<T> j06Var = this.e;
            if (j06Var != 0) {
                j06Var.a(view2, this.r);
            }
        } else if (this.o == view2) {
            if (this.b.getPageActivity() instanceof ForumSquareActivity) {
                String className = ((ForumSquareActivity) this.b.getPageActivity()).z1().getClassName();
                if (!"推荐".equals(className)) {
                    statisticItem = new StatisticItem("c13653");
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, className);
                } else {
                    statisticItem = new StatisticItem("c13644");
                    statisticItem.param("obj_locate", 3);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.r.a);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.r.n() ? 2 : 1);
                TiebaStatic.log(statisticItem);
            }
            if (this.r.n()) {
                u();
            } else {
                t();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.u) {
            return;
        }
        if (!ri.D()) {
            UtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.obfuscated_res_0x7f0f0c40));
            return;
        }
        bi8 bi8Var = this.r;
        if (bi8Var == null || StringUtils.isNull(bi8Var.h()) || this.r.f() <= 0 || !ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
            return;
        }
        if (this.s == null) {
            LikeModel likeModel = new LikeModel(this.b);
            this.s = likeModel;
            likeModel.setLoadDataCallBack(new a(this));
        }
        if (qi.isForumName(this.r.h())) {
            this.u = true;
            this.s.M();
            this.s.Q(this.r.h(), String.valueOf(this.r.f()));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.u) {
            return;
        }
        if (!ri.D()) {
            UtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.obfuscated_res_0x7f0f0c40));
            return;
        }
        bi8 bi8Var = this.r;
        if (bi8Var == null || StringUtils.isNull(bi8Var.h()) || this.r.f() <= 0 || !ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
            return;
        }
        if (this.t == null) {
            tk8 tk8Var = new tk8();
            this.t = tk8Var;
            tk8Var.b(new b(this));
        }
        this.u = true;
        this.t.c(this.r.h(), this.r.f());
    }

    public final void v() {
        bi8 bi8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bi8Var = this.r) == null) {
            return;
        }
        String h = bi8Var.h();
        if (qi.isForumName(h)) {
            this.b.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.b.getPageActivity()).createNormalCfg(h, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jz5
    /* renamed from: w */
    public void i(bi8 bi8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bi8Var) == null) || bi8Var == null) {
            return;
        }
        this.r = bi8Var;
        this.j.setShowOval(true);
        this.j.setShowOuterBorder(false);
        this.j.setShowInnerBorder(true);
        this.j.setStrokeWith(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.j.setStrokeColorResId(R.color.CAM_X0401);
        this.j.K(bi8Var.c(), 10, false);
        String h = bi8Var.h();
        if (qi.isEmpty(h)) {
            h = "";
        }
        this.k.setText(h);
        this.m.setText(this.p + " " + StringHelper.numberUniformFormatExtra(bi8Var.j()));
        this.n.setText(this.q + " " + StringHelper.numberUniformFormatExtra((long) bi8Var.l()));
        y(bi8Var.getRecomReason());
        x(this.r.n());
        this.i.setOnClickListener(this);
        this.o.setOnClickListener(this);
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (!z) {
                sv4 sv4Var = new sv4();
                sv4Var.r(R.color.CAM_X0302);
                this.o.setConfig(sv4Var);
                this.o.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0670));
            } else {
                sv4 sv4Var2 = new sv4();
                sv4Var2.t(R.color.CAM_X0109);
                this.o.setConfig(sv4Var2);
                this.o.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0683));
            }
            this.r.s(z);
        }
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (qi.isEmpty(str)) {
                if (this.l.getVisibility() != 8) {
                    this.l.setVisibility(8);
                    if (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = ri.f(this.b.getPageActivity(), R.dimen.tbds47);
                        this.k.requestLayout();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.l.getVisibility() != 0) {
                this.l.setVisibility(0);
                if (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = ri.f(this.b.getPageActivity(), R.dimen.tbds24);
                    this.k.requestLayout();
                }
            }
            this.l.setText(str);
        }
    }
}
