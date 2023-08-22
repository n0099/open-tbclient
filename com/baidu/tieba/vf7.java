package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.forumSquare.ForumSquareActivity;
import com.baidu.tieba.kfa;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vf7 extends ln6<sf7> {
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
    public sf7 r;
    public LikeModel s;
    public kfa t;
    public boolean u;

    @Override // com.baidu.tieba.ln6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d08eb : invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a extends h9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf7 a;

        public a(vf7 vf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vf7Var;
        }

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.u = false;
                if (this.a.s.getErrorCode() == 22) {
                    BdUtilHelper.showToast(this.a.b.getPageActivity(), this.a.b.getString(R.string.had_liked_forum));
                } else if (!(obj instanceof LikeReturnData)) {
                } else {
                    if (this.a.s.getErrorCode() != 0) {
                        BdUtilHelper.showToast(this.a.b.getPageActivity(), this.a.s.getErrorString());
                        return;
                    }
                    this.a.A(true);
                    if (tk5.b.a().a("jump_to_frs")) {
                        BdToastData toastData = ((LikeReturnData) obj).getToastData();
                        if (toastData == null || toastData.toJson() == null) {
                            this.a.y(null);
                        } else {
                            this.a.y(toastData.toJson().toString());
                        }
                    } else if (!BdToastHelper.canShowToast(((LikeReturnData) obj).getToastData())) {
                        BdUtilHelper.showToastByTextCenter(TbadkCoreApplication.getInst(), R.string.push_like_tip_msg);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements kfa.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf7 a;

        public b(vf7 vf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vf7Var;
        }

        @Override // com.baidu.tieba.kfa.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.a.u = false;
            }
        }

        @Override // com.baidu.tieba.kfa.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.u = false;
                this.a.A(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vf7(TbPageContext<?> tbPageContext) {
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
        this.p = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.q = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View h = h();
        this.i = h;
        this.j = (BarImageView) h.findViewById(R.id.obfuscated_res_0x7f09034b);
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090358);
        this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090886);
        this.m = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09173f);
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091d31);
        this.o = (TBSpecificationBtn) h.findViewById(R.id.obfuscated_res_0x7f090bf6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        StatisticItem statisticItem;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, view2) != null) || this.r == null) {
            return;
        }
        if (this.i == view2) {
            y(null);
            jo6<T> jo6Var = this.e;
            if (jo6Var != 0) {
                jo6Var.a(view2, this.r);
            }
        } else if (this.o == view2) {
            if (this.b.getPageActivity() instanceof ForumSquareActivity) {
                String f = ((ForumSquareActivity) this.b.getPageActivity()).s1().f();
                if (!"推荐".equals(f)) {
                    statisticItem = new StatisticItem("c13653");
                    statisticItem.param("resource_id", f);
                } else {
                    statisticItem = new StatisticItem("c13644");
                    statisticItem.param("obj_locate", 3);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.r.a);
                if (this.r.h()) {
                    i = 2;
                } else {
                    i = 1;
                }
                statisticItem.param(TiebaStatic.Params.OBJ_TO, i);
                TiebaStatic.log(statisticItem);
            }
            if (this.r.h()) {
                x();
            } else {
                u();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln6
    /* renamed from: z */
    public void i(sf7 sf7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, sf7Var) != null) || sf7Var == null) {
            return;
        }
        this.r = sf7Var;
        this.j.setShowOval(true);
        this.j.setShowOuterBorder(false);
        this.j.setShowInnerBorder(true);
        this.j.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.j.setStrokeColorResId(R.color.CAM_X0401);
        this.j.startLoad(sf7Var.c(), 10, false);
        String e = sf7Var.e();
        if (di.isEmpty(e)) {
            e = "";
        }
        this.k.setText(e);
        this.m.setText(this.p + " " + StringHelper.numberUniformFormatExtra(sf7Var.f()));
        this.n.setText(this.q + " " + StringHelper.numberUniformFormatExtra((long) sf7Var.g()));
        B(sf7Var.getRecomReason());
        A(this.r.h());
        this.i.setOnClickListener(this);
        this.o.setOnClickListener(this);
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (!z) {
                ea5 ea5Var = new ea5();
                ea5Var.u(R.color.CAM_X0302);
                this.o.setConfig(ea5Var);
                this.o.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
            } else {
                ea5 ea5Var2 = new ea5();
                ea5Var2.w(R.color.CAM_X0109);
                this.o.setConfig(ea5Var2);
                this.o.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
            }
            this.r.l(z);
        }
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (di.isEmpty(str)) {
                if (this.l.getVisibility() != 8) {
                    this.l.setVisibility(8);
                    if (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds47);
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
                    ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds24);
                    this.k.requestLayout();
                }
            }
            this.l.setText(str);
        }
    }

    @Override // com.baidu.tieba.ln6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            this.o.k();
            SkinManager.setBackgroundColor(h(), R.color.CAM_X0205);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.u) {
            return;
        }
        if (!BdUtilHelper.isNetOk()) {
            UtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.obfuscated_res_0x7f0f0e29));
            return;
        }
        sf7 sf7Var = this.r;
        if (sf7Var == null || StringUtils.isNull(sf7Var.e()) || this.r.d() <= 0 || !ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
            return;
        }
        if (this.s == null) {
            LikeModel likeModel = new LikeModel(this.b);
            this.s = likeModel;
            likeModel.setLoadDataCallBack(new a(this));
        }
        if (di.isForumName(this.r.e())) {
            this.u = true;
            this.s.b0();
            if (tk5.b.a().a("jump_to_frs")) {
                this.s.setNeedShowSeverToast(false);
            }
            this.s.f0(this.r.e(), String.valueOf(this.r.d()));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.u) {
            return;
        }
        if (!BdUtilHelper.isNetOk()) {
            UtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.obfuscated_res_0x7f0f0e29));
            return;
        }
        sf7 sf7Var = this.r;
        if (sf7Var == null || StringUtils.isNull(sf7Var.e()) || this.r.d() <= 0 || !ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
            return;
        }
        if (this.t == null) {
            kfa kfaVar = new kfa();
            this.t = kfaVar;
            kfaVar.b(new b(this));
        }
        this.u = true;
        this.t.c(this.r.e(), this.r.d());
    }

    public final void y(String str) {
        sf7 sf7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || (sf7Var = this.r) == null) {
            return;
        }
        String e = sf7Var.e();
        if (!di.isForumName(e)) {
            return;
        }
        FrsActivityConfig callFrom = new FrsActivityConfig(this.b.getPageActivity()).createNormalCfg(e, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5);
        callFrom.setToastData(str);
        this.b.sendMessage(new CustomMessage(2003000, callFrom));
    }
}
