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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
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
public class vm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public ye9 c;
    public jf9 d;
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
        public final /* synthetic */ vm9 a;

        public a(vm9 vm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vm9Var;
        }

        @Override // com.baidu.tieba.view.VoteCountDownView.b
        public void onFinished() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.b == null) {
                return;
            }
            if (this.a.c != null && this.a.c.h != null) {
                this.a.c.h.k(3);
                vm9 vm9Var = this.a;
                vm9Var.j(vm9Var.c);
                return;
            }
            this.a.b.setVisibility(8);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vm9 a;

        public b(vm9 vm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vm9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091b2c) {
                    if (this.a.c == null || this.a.a == null || !ViewHelper.checkUpIsLogin(this.a.a.getPageActivity())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.a.a.getPageActivity()).createNormalConfig(JavaTypesHelper.toLong(this.a.c.l(), 0L), 3)));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091b99 && ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) && this.a.c != null && this.a.d != null && this.a.c.O() != null) {
                    if (this.a.d.a()) {
                        xn9.L("c13444", this.a.c.l());
                        dd9 dd9Var = new dd9();
                        dd9Var.i(JavaTypesHelper.toLong(this.a.c.Q(), 0L));
                        dd9Var.g(JavaTypesHelper.toLong(this.a.c.l(), 0L));
                        vm9 vm9Var = this.a;
                        pea f = vm9Var.f(vm9Var.c);
                        if (f != null && f.t() != null) {
                            str = f.t().getUserId();
                        } else {
                            str = "";
                        }
                        dd9Var.f(JavaTypesHelper.toLong(str, 0L));
                        dd9Var.h(2);
                        dd9Var.j(this.a.a.getUniqueId());
                        CustomMessage customMessage = new CustomMessage(2921411);
                        customMessage.setData(dd9Var);
                        MessageManager.getInstance().sendMessage(customMessage);
                        return;
                    }
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vm9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(vm9 vm9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm9Var, Integer.valueOf(i)};
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
            this.a = vm9Var;
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
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        this.a.c.h.l(this.a.c.h.h() + 1);
                        this.a.c.h.j(false);
                        vm9 vm9Var = this.a;
                        vm9Var.j(vm9Var.c);
                    } else if (error == 3250023) {
                        wfa.b(error, "", null);
                    } else if (error == 3250021) {
                        wfa.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
                    } else if (error != 3250002 && error != 3250004) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (ad.isEmpty(httpResponsedMessage.getErrorString())) {
                            errorString = this.a.a.getResources().getString(R.string.block_user_tip);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        blockPopInfoData.block_info = errorString;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.block_user_feed);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b68);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                }
            }
        }
    }

    public vm9(TbPageContext tbPageContext) {
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

    public View a(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ye9Var)) == null) {
            TbPageContext tbPageContext = this.a;
            if (tbPageContext == null) {
                return null;
            }
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0149, (ViewGroup) null);
            this.b = inflate;
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ac8);
            this.g = this.b.findViewById(R.id.obfuscated_res_0x7f091b9a);
            this.l = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091ad8);
            this.i = (TBSpecificationBtn) this.b.findViewById(R.id.obfuscated_res_0x7f091b99);
            z45 z45Var = new z45();
            z45Var.e(GradientDrawable.Orientation.TL_BR);
            this.i.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
            this.i.setTextSize(R.dimen.tbfontsize44);
            this.i.setConfig(z45Var);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b9c);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091ac9);
            this.k = this.b.findViewById(R.id.obfuscated_res_0x7f091ad7);
            this.m = (VoteCountDownView) this.b.findViewById(R.id.obfuscated_res_0x7f091b9b);
            this.n = this.b.findViewById(R.id.obfuscated_res_0x7f091b9d);
            this.o = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b9f);
            this.p = (SelectRuleView) this.b.findViewById(R.id.obfuscated_res_0x7f091b9e);
            this.q = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b2c);
            if (this.t != null) {
                if (this.a.getPageActivity() instanceof BaseActivity) {
                    this.t.setTag(((BaseActivity) this.a.getPageActivity()).getUniqueId());
                } else if (this.a.getPageActivity() instanceof BaseFragmentActivity) {
                    this.t.setTag(((BaseFragmentActivity) this.a.getPageActivity()).getUniqueId());
                }
                MessageManager.getInstance().registerListener(this.t);
            }
            j(ye9Var);
            return this.b;
        }
        return (View) invokeL.objValue;
    }

    public void j(ye9 ye9Var) {
        jf9 jf9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ye9Var) != null) || this.b == null) {
            return;
        }
        if (ye9Var != null && (jf9Var = ye9Var.h) != null) {
            this.c = ye9Var;
            this.d = jf9Var;
            if (jf9Var.d() != 0) {
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

    public pea f(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ye9Var)) == null) {
            pea peaVar = null;
            if (ye9Var == null) {
                return null;
            }
            if (ye9Var.Y() != null) {
                return ye9Var.Y();
            }
            if (!ListUtils.isEmpty(ye9Var.F())) {
                Iterator<pea> it = ye9Var.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    pea next = it.next();
                    if (next != null && next.L() == 1) {
                        peaVar = next;
                        break;
                    }
                }
            }
            if (peaVar == null) {
                peaVar = ye9Var.i();
            }
            if (peaVar == null) {
                peaVar = g(ye9Var);
            }
            if (peaVar != null && peaVar.t() != null && peaVar.t().getUserTbVipInfoData() != null && peaVar.t().getUserTbVipInfoData().getvipIntro() != null) {
                peaVar.t().getGodUserData().setIntro(peaVar.t().getUserTbVipInfoData().getvipIntro());
            }
            return peaVar;
        }
        return (pea) invokeL.objValue;
    }

    public final pea g(ye9 ye9Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ye9Var)) == null) {
            if (ye9Var != null && ye9Var.O() != null && ye9Var.O().getAuthor() != null) {
                pea peaVar = new pea();
                MetaData author = ye9Var.O().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = ye9Var.O().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                peaVar.W0(1);
                peaVar.c1(ye9Var.O().getFirstPostId());
                peaVar.t1(ye9Var.O().getTitle());
                peaVar.s1(ye9Var.O().getCreateTime());
                peaVar.P0(author);
                return peaVar;
            }
            return null;
        }
        return (pea) invokeL.objValue;
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
