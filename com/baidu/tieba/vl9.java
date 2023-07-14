package com.baidu.tieba;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.VoteCountDownView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class vl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public ze9 c;
    public kf9 d;
    public int e;
    public TextView f;
    public View g;
    public TextView h;
    public TBSpecificationBtn i;
    public TextView j;
    public View k;
    public TextView l;
    public VoteCountDownView m;
    public View n;
    public TextView o;
    public SelectRuleView p;
    public TextView q;
    public VoteCountDownView.b r;
    public View.OnClickListener s;
    public HttpMessageListener t;

    /* loaded from: classes8.dex */
    public class a implements VoteCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vl9 a;

        public a(vl9 vl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vl9Var;
        }

        @Override // com.baidu.tieba.view.VoteCountDownView.b
        public void onFinished() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.b == null) {
                return;
            }
            if (this.a.c != null && this.a.c.h != null) {
                this.a.c.h.k(3);
                vl9 vl9Var = this.a;
                vl9Var.j(vl9Var.c);
                return;
            }
            this.a.b.setVisibility(8);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vl9 a;

        public b(vl9 vl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vl9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091ac0) {
                    if (this.a.c == null || this.a.a == null || !ViewHelper.checkUpIsLogin(this.a.a.getPageActivity())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.a.a.getPageActivity()).createNormalConfig(wg.g(this.a.c.l(), 0L), 3)));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091b2c && ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) && this.a.c != null && this.a.d != null && this.a.c.N() != null) {
                    if (this.a.d.a()) {
                        xm9.x("c13444", this.a.c.l());
                        be9 be9Var = new be9();
                        be9Var.i(wg.g(this.a.c.P(), 0L));
                        be9Var.g(wg.g(this.a.c.l(), 0L));
                        vl9 vl9Var = this.a;
                        yca f = vl9Var.f(vl9Var.c);
                        if (f != null && f.q() != null) {
                            str = f.q().getUserId();
                        } else {
                            str = "";
                        }
                        be9Var.f(wg.g(str, 0L));
                        be9Var.h(2);
                        be9Var.j(this.a.a.getUniqueId());
                        CustomMessage customMessage = new CustomMessage(2921411);
                        customMessage.setData(be9Var);
                        MessageManager.getInstance().sendMessage(customMessage);
                        return;
                    }
                    yi.Q(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vl9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(vl9 vl9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vl9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && this.a.c != null && this.a.c.h != null && this.a.a != null && httpResponsedMessage.getOrginalMessage().getTag() == this.a.a.getUniqueId()) {
                    if (error == 0) {
                        yi.Q(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        this.a.c.h.l(this.a.c.h.h() + 1);
                        this.a.c.h.j(false);
                        vl9 vl9Var = this.a;
                        vl9Var.j(vl9Var.c);
                    } else if (error == 3250023) {
                        dea.b(error, "", null);
                    } else if (error == 3250021) {
                        dea.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
                    } else if (error != 3250002 && error != 3250004) {
                        yi.R(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (xi.isEmpty(httpResponsedMessage.getErrorString())) {
                            errorString = this.a.a.getResources().getString(R.string.block_user_tip);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        blockPopInfoData.block_info = errorString;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.block_user_feed);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b3d);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                }
            }
        }
    }

    public vl9(TbPageContext tbPageContext) {
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
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this, CmdConfigHttp.CMD_BAR_VOTE);
        this.a = tbPageContext;
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0304, 1, i);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0304, 1, i);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1, i);
            TBSpecificationBtn tBSpecificationBtn = this.i;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0206, i);
            VoteCountDownView voteCountDownView = this.m;
            if (voteCountDownView != null) {
                voteCountDownView.e(i);
            }
            SelectRuleView selectRuleView = this.p;
            if (selectRuleView != null) {
                selectRuleView.d(i);
            }
        }
    }

    public View a(ze9 ze9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ze9Var)) == null) {
            TbPageContext tbPageContext = this.a;
            if (tbPageContext == null) {
                return null;
            }
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0144, (ViewGroup) null);
            this.b = inflate;
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091a5c);
            this.g = this.b.findViewById(R.id.obfuscated_res_0x7f091b2d);
            this.l = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a6c);
            this.i = (TBSpecificationBtn) this.b.findViewById(R.id.obfuscated_res_0x7f091b2c);
            gb5 gb5Var = new gb5();
            gb5Var.e(GradientDrawable.Orientation.TL_BR);
            this.i.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
            this.i.setTextSize(R.dimen.tbfontsize44);
            this.i.setConfig(gb5Var);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b2f);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a5d);
            this.k = this.b.findViewById(R.id.obfuscated_res_0x7f091a6b);
            this.m = (VoteCountDownView) this.b.findViewById(R.id.obfuscated_res_0x7f091b2e);
            this.n = this.b.findViewById(R.id.obfuscated_res_0x7f091b30);
            this.o = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b32);
            this.p = (SelectRuleView) this.b.findViewById(R.id.obfuscated_res_0x7f091b31);
            this.q = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091ac0);
            if (this.t != null) {
                if (this.a.getPageActivity() instanceof BaseActivity) {
                    this.t.setTag(((BaseActivity) this.a.getPageActivity()).getUniqueId());
                } else if (this.a.getPageActivity() instanceof BaseFragmentActivity) {
                    this.t.setTag(((BaseFragmentActivity) this.a.getPageActivity()).getUniqueId());
                }
                MessageManager.getInstance().registerListener(this.t);
            }
            j(ze9Var);
            return this.b;
        }
        return (View) invokeL.objValue;
    }

    public void j(ze9 ze9Var) {
        kf9 kf9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ze9Var) != null) || this.b == null) {
            return;
        }
        if (ze9Var != null && (kf9Var = ze9Var.h) != null) {
            this.c = ze9Var;
            this.d = kf9Var;
            if (kf9Var.d() != 0) {
                int d = this.d.d();
                this.e = d;
                if (d == 2) {
                    this.g.setVisibility(8);
                    this.k.setVisibility(0);
                    this.m.setOnCountDownFinished(this.r);
                    this.m.setData(this.d.c() * 1000);
                    this.q.setVisibility(8);
                } else if (d == 3) {
                    this.g.setVisibility(0);
                    this.i.setOnClickListener(this.s);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView = this.h;
                    textView.setText(this.d.h() + "票");
                } else if (d != 4 && d != 5) {
                    if (d == 6) {
                        this.g.setVisibility(0);
                        this.i.setEnabled(false);
                        this.k.setVisibility(8);
                        TextView textView2 = this.h;
                        textView2.setText(this.d.h() + "票");
                        this.q.setVisibility(8);
                    } else {
                        this.b.setVisibility(8);
                        return;
                    }
                } else {
                    this.g.setVisibility(0);
                    this.i.setEnabled(false);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView3 = this.h;
                    textView3.setText(this.d.h() + "票");
                }
                if (!ListUtils.isEmpty(this.d.g()) || !ListUtils.isEmpty(this.d.f())) {
                    this.p.setColumn(2);
                    this.p.setData(this.d.g(), this.d.f());
                }
                i(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        this.b.setVisibility(8);
    }

    public yca f(ze9 ze9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ze9Var)) == null) {
            yca ycaVar = null;
            if (ze9Var == null) {
                return null;
            }
            if (ze9Var.X() != null) {
                return ze9Var.X();
            }
            if (!ListUtils.isEmpty(ze9Var.F())) {
                Iterator<yca> it = ze9Var.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    yca next = it.next();
                    if (next != null && next.I() == 1) {
                        ycaVar = next;
                        break;
                    }
                }
            }
            if (ycaVar == null) {
                ycaVar = ze9Var.i();
            }
            if (ycaVar == null) {
                ycaVar = g(ze9Var);
            }
            if (ycaVar != null && ycaVar.q() != null && ycaVar.q().getUserTbVipInfoData() != null && ycaVar.q().getUserTbVipInfoData().getvipIntro() != null) {
                ycaVar.q().getGodUserData().setIntro(ycaVar.q().getUserTbVipInfoData().getvipIntro());
            }
            return ycaVar;
        }
        return (yca) invokeL.objValue;
    }

    public final yca g(ze9 ze9Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ze9Var)) == null) {
            if (ze9Var != null && ze9Var.N() != null && ze9Var.N().getAuthor() != null) {
                yca ycaVar = new yca();
                MetaData author = ze9Var.N().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = ze9Var.N().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                ycaVar.S0(1);
                ycaVar.Y0(ze9Var.N().getFirstPostId());
                ycaVar.p1(ze9Var.N().getTitle());
                ycaVar.o1(ze9Var.N().getCreateTime());
                ycaVar.N0(author);
                return ycaVar;
            }
            return null;
        }
        return (yca) invokeL.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }
}
