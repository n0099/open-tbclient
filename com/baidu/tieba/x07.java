package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.x3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public View b;
    public BarImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TBSpecificationBtn h;
    public String i;
    public String j;
    public b45 k;
    public LikeModel l;
    public x3a m;
    public boolean n;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x07 a;

        public a(x07 x07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.j();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x07 a;

        public b(x07 x07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = new StatisticItem("c13644");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.a.k.f());
                int i = 1;
                statisticItem.param("obj_locate", 1);
                if (this.a.k.l()) {
                    i = 2;
                }
                statisticItem.param(TiebaStatic.Params.OBJ_TO, i);
                TiebaStatic.log(statisticItem);
                if (this.a.k.l()) {
                    this.a.i();
                } else {
                    this.a.h();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends k9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x07 a;

        public c(x07 x07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x07Var;
        }

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.l.getErrorCode() == 22) {
                    xi.Q(this.a.a.getPageActivity(), this.a.a.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.a.l.getErrorCode() != 0) {
                        xi.Q(this.a.a.getPageActivity(), this.a.l.getErrorString());
                    } else {
                        this.a.n(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements x3a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x07 a;

        @Override // com.baidu.tieba.x3a.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        public d(x07 x07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x07Var;
        }

        @Override // com.baidu.tieba.x3a.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.n(false);
                xi.Q(this.a.a.getPageActivity(), this.a.a.getString(R.string.un_attention_success));
            }
        }
    }

    public x07(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.i = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e8);
        this.j = TbadkCoreApplication.getInst().getString(R.string.thread_str);
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0831, (ViewGroup) null);
        this.b = inflate;
        this.c = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090348);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090355);
        this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090871);
        this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090b7c);
        this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0924d7);
        this.h = (TBSpecificationBtn) this.b.findViewById(R.id.obfuscated_res_0x7f090bcc);
        this.b.setOnClickListener(new a(this));
        this.h.setOnClickListener(new b(this));
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void g(b45 b45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, b45Var) != null) || b45Var == null) {
            return;
        }
        this.k = b45Var;
        this.c.setShowOval(true);
        this.c.setShowOuterBorder(false);
        this.c.setShowInnerBorder(true);
        this.c.setStrokeWith(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.c.setStrokeColorResId(R.color.CAM_X0401);
        this.c.N(b45Var.e(), 10, false);
        String h = b45Var.h();
        if (wi.isEmpty(h)) {
            h = "";
        }
        this.d.setText(h);
        this.f.setText(this.i + " " + StringHelper.numFormatOverWanWithoutDecimals(b45Var.i()));
        this.g.setText(this.j + " " + StringHelper.numFormatOverWanWithoutDecimals((long) b45Var.k()));
        String recomReason = b45Var.getRecomReason();
        if (wi.isEmpty(recomReason)) {
            if (this.e.getVisibility() != 8) {
                this.e.setVisibility(8);
                if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()).topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds47);
                    this.d.requestLayout();
                }
            }
        } else {
            if (this.e.getVisibility() != 0) {
                this.e.setVisibility(0);
                if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()).topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds24);
                    this.d.requestLayout();
                }
            }
            this.e.setText(recomReason);
        }
        n(this.k.l());
        l();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!xi.F()) {
                UtilHelper.showToast(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0e0f));
                return;
            }
            b45 b45Var = this.k;
            if (b45Var != null && !StringUtils.isNull(b45Var.h()) && this.k.f() > 0) {
                if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    return;
                }
                if (this.l == null) {
                    this.l = new LikeModel(this.a);
                }
                this.l.setLoadDataCallBack(new c(this));
                if (wi.isForumName(this.k.h())) {
                    this.l.i0();
                    this.l.m0(this.k.h(), String.valueOf(this.k.f()));
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!xi.F()) {
                UtilHelper.showToast(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0e0f));
                return;
            }
            b45 b45Var = this.k;
            if (b45Var != null && !StringUtils.isNull(b45Var.h()) && this.k.f() > 0) {
                if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    return;
                }
                if (this.m == null) {
                    this.m = new x3a();
                }
                this.m.b(new d(this));
                this.m.c(this.k.h(), this.k.f());
            }
        }
    }

    public final void j() {
        b45 b45Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (b45Var = this.k) == null) {
            return;
        }
        String h = b45Var.h();
        if (!wi.isForumName(h)) {
            return;
        }
        this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(h, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
        StatisticItem statisticItem = new StatisticItem("c13643");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", this.k.f());
        int i = 1;
        statisticItem.param("obj_locate", 1);
        if (this.n) {
            i = 4;
        }
        statisticItem.param("obj_type", i);
        TiebaStatic.log(statisticItem);
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (!z) {
                pa5 pa5Var = new pa5();
                pa5Var.t(R.color.CAM_X0302);
                this.h.setConfig(pa5Var);
                this.h.setText(this.i);
            } else {
                pa5 pa5Var2 = new pa5();
                pa5Var2.v(R.color.CAM_X0109);
                this.h.setConfig(pa5Var2);
                this.h.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            }
            this.k.n(z);
        }
    }
}
