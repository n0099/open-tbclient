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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.VoteCountDownView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class m18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public jv7 c;
    public sv7 d;
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

    /* loaded from: classes4.dex */
    public class a implements VoteCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        public a(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m18Var;
        }

        @Override // com.baidu.tieba.view.VoteCountDownView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            if (this.a.c == null || this.a.c.h == null) {
                this.a.b.setVisibility(8);
                return;
            }
            this.a.c.h.k(3);
            m18 m18Var = this.a;
            m18Var.j(m18Var.c);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        public b(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091839) {
                    if (this.a.c == null || this.a.a == null || !ViewHelper.checkUpIsLogin(this.a.a.getPageActivity())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.a.a.getPageActivity()).createNormalConfig(dh.g(this.a.c.m(), 0L), 3)));
                } else if (view2.getId() != R.id.obfuscated_res_0x7f0918ac || !ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) || this.a.c == null || this.a.d == null || this.a.c.O() == null) {
                } else {
                    if (this.a.d.a()) {
                        new StatisticItem("c13444").param("forum_id", this.a.c.m()).eventStat();
                        ku7 ku7Var = new ku7();
                        ku7Var.i(dh.g(this.a.c.Q(), 0L));
                        ku7Var.g(dh.g(this.a.c.m(), 0L));
                        m18 m18Var = this.a;
                        PostData f = m18Var.f(m18Var.c);
                        ku7Var.f(dh.g((f == null || f.s() == null) ? "" : f.s().getUserId(), 0L));
                        ku7Var.h(2);
                        ku7Var.j(this.a.a.getUniqueId());
                        CustomMessage customMessage = new CustomMessage(2921411);
                        customMessage.setData(ku7Var);
                        MessageManager.getInstance().sendMessage(customMessage);
                        return;
                    }
                    ej.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0841);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(m18 m18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, Integer.valueOf(i)};
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
            this.a = m18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof CommitVoteResMsg) || this.a.c == null || this.a.c.h == null || this.a.a == null || httpResponsedMessage.getOrginalMessage().getTag() != this.a.a.getUniqueId()) {
                return;
            }
            if (error == 0) {
                ej.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f02f0);
                this.a.c.h.l(this.a.c.h.h() + 1);
                this.a.c.h.j(false);
                m18 m18Var = this.a;
                m18Var.j(m18Var.c);
            } else if (error == 3250023) {
                no8.b(error, "", null);
            } else if (error == 3250021) {
                no8.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
            } else if (error != 3250002 && error != 3250004) {
                ej.N(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            } else {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                blockPopInfoData.block_info = dj.isEmpty(httpResponsedMessage.getErrorString()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0328) : httpResponsedMessage.getErrorString();
                blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0326);
                blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09b7);
                blockPopInfoData.ahead_url = AntiHelper.a;
                AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
            }
        }
    }

    public m18(TbPageContext tbPageContext) {
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

    public View a(jv7 jv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jv7Var)) == null) {
            TbPageContext tbPageContext = this.a;
            if (tbPageContext == null) {
                return null;
            }
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d013c, (ViewGroup) null);
            this.b = inflate;
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0917db);
            this.g = this.b.findViewById(R.id.obfuscated_res_0x7f0918ad);
            this.l = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0917ea);
            this.i = (TBSpecificationBtn) this.b.findViewById(R.id.obfuscated_res_0x7f0918ac);
            my4 my4Var = new my4();
            my4Var.e(GradientDrawable.Orientation.TL_BR);
            this.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e22));
            this.i.setTextSize(R.dimen.tbfontsize44);
            this.i.setConfig(my4Var);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0918af);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0917dc);
            this.k = this.b.findViewById(R.id.obfuscated_res_0x7f0917e9);
            this.m = (VoteCountDownView) this.b.findViewById(R.id.obfuscated_res_0x7f0918ae);
            this.n = this.b.findViewById(R.id.obfuscated_res_0x7f0918b0);
            this.o = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0918b2);
            this.p = (SelectRuleView) this.b.findViewById(R.id.obfuscated_res_0x7f0918b1);
            this.q = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091839);
            if (this.t != null) {
                if (this.a.getPageActivity() instanceof BaseActivity) {
                    this.t.setTag(((BaseActivity) this.a.getPageActivity()).getUniqueId());
                } else if (this.a.getPageActivity() instanceof BaseFragmentActivity) {
                    this.t.setTag(((BaseFragmentActivity) this.a.getPageActivity()).getUniqueId());
                }
                MessageManager.getInstance().registerListener(this.t);
            }
            j(jv7Var);
            return this.b;
        }
        return (View) invokeL.objValue;
    }

    public PostData f(jv7 jv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv7Var)) == null) {
            PostData postData = null;
            if (jv7Var == null) {
                return null;
            }
            if (jv7Var.X() != null) {
                return jv7Var.X();
            }
            if (!ListUtils.isEmpty(jv7Var.F())) {
                Iterator<PostData> it = jv7Var.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.C() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = jv7Var.j();
            }
            if (postData == null) {
                postData = g(jv7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final PostData g(jv7 jv7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jv7Var)) == null) {
            if (jv7Var == null || jv7Var.O() == null || jv7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = jv7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = jv7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.D0(1);
            postData.J0(jv7Var.O().getFirstPostId());
            postData.a1(jv7Var.O().getTitle());
            postData.Z0(jv7Var.O().getCreateTime());
            postData.B0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (View) invokeV.objValue;
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

    public void j(jv7 jv7Var) {
        sv7 sv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jv7Var) == null) || this.b == null) {
            return;
        }
        if (jv7Var != null && (sv7Var = jv7Var.h) != null) {
            this.c = jv7Var;
            this.d = sv7Var;
            if (sv7Var.d() != 0) {
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
                } else if (d == 4 || d == 5) {
                    this.g.setVisibility(0);
                    this.i.setEnabled(false);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView2 = this.h;
                    textView2.setText(this.d.h() + "票");
                } else if (d == 6) {
                    this.g.setVisibility(0);
                    this.i.setEnabled(false);
                    this.k.setVisibility(8);
                    TextView textView3 = this.h;
                    textView3.setText(this.d.h() + "票");
                    this.q.setVisibility(8);
                } else {
                    this.b.setVisibility(8);
                    return;
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
}
