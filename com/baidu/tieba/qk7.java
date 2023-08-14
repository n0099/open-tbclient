package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailSelfVH;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes7.dex */
public class qk7 extends lm<uk7, ForumRuleDetailSelfVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity a;
    public String b;
    public boolean c;
    public int d;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uk7 a;
        public final /* synthetic */ qk7 b;

        public a(qk7 qk7Var, uk7 uk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk7Var, uk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qk7Var;
            this.a = uk7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.c) {
                    this.b.B();
                } else {
                    this.b.C(this.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qk7(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
        super(forumRulesShowActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = 0;
        this.a = forumRulesShowActivity;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.b = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: z */
    public ForumRuleDetailSelfVH onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d030d, viewGroup, false));
            this.viewholder = forumRuleDetailSelfVH;
            return forumRuleDetailSelfVH;
        }
        return (ForumRuleDetailSelfVH) invokeL.objValue;
    }

    public View A(int i, View view2, ViewGroup viewGroup, uk7 uk7Var, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uk7Var, forumRuleDetailSelfVH})) == null) {
            if (uk7Var == null) {
                return view2;
            }
            x(forumRuleDetailSelfVH, uk7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void B() {
        ForumRulesShowActivity forumRulesShowActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (forumRulesShowActivity = this.a) == null) {
            return;
        }
        String string = forumRulesShowActivity.getString(R.string.obfuscated_res_0x7f0f07ce);
        String format = String.format(string, this.d + "");
        if (this.a.v1() != null) {
            new BdTopToast(this.a).setIcon(false).setContent(format).show(this.a.v1().F());
        }
    }

    public final void C(uk7 uk7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uk7Var) == null) && this.a != null && uk7Var != null) {
            ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
            forumRuleBaseData.setTitle(uk7Var.l());
            forumRuleBaseData.setPreface(uk7Var.g());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < uk7Var.i().size(); i++) {
                ForumRule forumRule = uk7Var.i().get(i);
                ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData = new ForumRuleBaseData.ForumRuleItemPbData();
                forumRuleItemPbData.status = forumRule.status + "";
                forumRuleItemPbData.title = forumRule.title + "";
                forumRuleItemPbData.mContent = new ArrayList();
                List<PbContent> list = forumRule.content;
                if (list != null && list.size() > 0) {
                    for (int i2 = 0; i2 < forumRule.content.size(); i2++) {
                        PbContent pbContent = forumRule.content.get(i2);
                        ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = new ForumRuleBaseData.ForumRuleItemPbContentData();
                        forumRuleItemPbContentData.href = pbContent.link;
                        if (pbContent.type.intValue() == 0) {
                            forumRuleItemPbContentData.tag = "plainText";
                        } else if (pbContent.type.intValue() == 1) {
                            forumRuleItemPbContentData.tag = "a";
                        } else if (pbContent.type.intValue() == 2) {
                            forumRuleItemPbContentData.tag = "br";
                        }
                        forumRuleItemPbContentData.value = pbContent.text;
                        forumRuleItemPbData.mContent.add(forumRuleItemPbContentData);
                    }
                }
                arrayList.add(forumRuleItemPbData);
            }
            forumRuleBaseData.setPbDataList(arrayList);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.a, uk7Var.e().forum_id + "", uk7Var.e().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, uk7Var.e().avatar, uk7Var.c().user_level.intValue(), 25053)));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.lm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, uk7 uk7Var, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        A(i, view2, viewGroup, uk7Var, forumRuleDetailSelfVH);
        return view2;
    }

    public final void x(ForumRuleDetailSelfVH forumRuleDetailSelfVH, uk7 uk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, forumRuleDetailSelfVH, uk7Var) == null) {
            if (uk7Var.c() != null) {
                forumRuleDetailSelfVH.b.setDefaultResource(R.drawable.img_default_100);
                forumRuleDetailSelfVH.b.startLoad(uk7Var.c().portrait, 12, false);
                forumRuleDetailSelfVH.c.setText(uk7Var.c().name_show);
                forumRuleDetailSelfVH.e.setVisibility(0);
                forumRuleDetailSelfVH.c(uk7Var.c());
            }
            forumRuleDetailSelfVH.d.setText(R.string.bawu_member_bazhu_tip);
            forumRuleDetailSelfVH.d.setVisibility(0);
            forumRuleDetailSelfVH.h("manager");
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.b)) {
                forumRuleDetailSelfVH.g(String.valueOf(System.currentTimeMillis() / 1000));
            } else {
                forumRuleDetailSelfVH.g.setText(uk7Var.h());
            }
            y(forumRuleDetailSelfVH, uk7Var);
            forumRuleDetailSelfVH.d(uk7Var.g());
        }
    }

    public final void y(ForumRuleDetailSelfVH forumRuleDetailSelfVH, uk7 uk7Var) {
        String d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, forumRuleDetailSelfVH, uk7Var) == null) && uk7Var.f()) {
            forumRuleDetailSelfVH.h.setOnClickListener(new a(this, uk7Var));
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.b)) {
                forumRuleDetailSelfVH.h.setVisibility(8);
            } else if (!StringUtils.isNull(uk7Var.h()) && uk7Var.b() == 0) {
                long a2 = zk7.a(uk7Var.h());
                if (StringUtils.isNull(uk7Var.d())) {
                    d = "0";
                } else {
                    d = uk7Var.d();
                }
                int b = zk7.b(Long.valueOf(d).longValue() - a2);
                if (b < 0) {
                    b = zk7.b((System.currentTimeMillis() / 1000) - a2);
                }
                forumRuleDetailSelfVH.h.setVisibility(0);
                if (b >= 7) {
                    this.c = false;
                    return;
                }
                forumRuleDetailSelfVH.h.setUseDisableState(true);
                this.c = true;
                this.d = 7 - b;
            } else {
                forumRuleDetailSelfVH.f(uk7Var.b());
            }
        }
    }
}
