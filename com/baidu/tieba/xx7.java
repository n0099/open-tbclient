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
/* loaded from: classes9.dex */
public class xx7 extends ci<by7, ForumRuleDetailSelfVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity a;
    public String b;
    public boolean c;
    public int d;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ by7 a;
        public final /* synthetic */ xx7 b;

        public a(xx7 xx7Var, by7 by7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx7Var, by7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xx7Var;
            this.a = by7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.c) {
                    this.b.C();
                } else {
                    this.b.D(this.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xx7(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: A */
    public ForumRuleDetailSelfVH onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d032b, viewGroup, false));
            this.viewholder = forumRuleDetailSelfVH;
            return forumRuleDetailSelfVH;
        }
        return (ForumRuleDetailSelfVH) invokeL.objValue;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.b = str;
        }
    }

    public View B(int i, View view2, ViewGroup viewGroup, by7 by7Var, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, by7Var, forumRuleDetailSelfVH})) == null) {
            if (by7Var == null) {
                return view2;
            }
            y(forumRuleDetailSelfVH, by7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void C() {
        ForumRulesShowActivity forumRulesShowActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (forumRulesShowActivity = this.a) == null) {
            return;
        }
        String string = forumRulesShowActivity.getString(R.string.obfuscated_res_0x7f0f07ea);
        String format = String.format(string, this.d + "");
        if (this.a.I0() != null) {
            new BdTopToast(this.a).setIcon(false).setContent(format).show(this.a.I0().E());
        }
    }

    public final void D(by7 by7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, by7Var) == null) && this.a != null && by7Var != null) {
            ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
            forumRuleBaseData.setTitle(by7Var.l());
            forumRuleBaseData.setPreface(by7Var.g());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < by7Var.k().size(); i++) {
                ForumRule forumRule = by7Var.k().get(i);
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.a, by7Var.e().forum_id + "", by7Var.e().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, by7Var.e().avatar, by7Var.c().user_level.intValue(), 25053)));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.ci
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, by7 by7Var, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        B(i, view2, viewGroup, by7Var, forumRuleDetailSelfVH);
        return view2;
    }

    public final void y(ForumRuleDetailSelfVH forumRuleDetailSelfVH, by7 by7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, forumRuleDetailSelfVH, by7Var) == null) {
            if (by7Var.c() != null) {
                forumRuleDetailSelfVH.b.setDefaultResource(R.drawable.img_default_100);
                forumRuleDetailSelfVH.b.startLoad(by7Var.c().portrait, 12, false);
                forumRuleDetailSelfVH.c.setText(by7Var.c().name_show);
                forumRuleDetailSelfVH.e.setVisibility(0);
                forumRuleDetailSelfVH.b(by7Var.c());
            }
            forumRuleDetailSelfVH.d.setText(R.string.bawu_member_bazhu_tip);
            forumRuleDetailSelfVH.d.setVisibility(0);
            forumRuleDetailSelfVH.g("manager");
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.b)) {
                forumRuleDetailSelfVH.f(String.valueOf(System.currentTimeMillis() / 1000));
            } else {
                forumRuleDetailSelfVH.g.setText(by7Var.h());
            }
            z(forumRuleDetailSelfVH, by7Var);
            forumRuleDetailSelfVH.c(by7Var.g());
        }
    }

    public final void z(ForumRuleDetailSelfVH forumRuleDetailSelfVH, by7 by7Var) {
        String d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumRuleDetailSelfVH, by7Var) == null) && by7Var.f()) {
            forumRuleDetailSelfVH.h.setOnClickListener(new a(this, by7Var));
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.b)) {
                forumRuleDetailSelfVH.h.setVisibility(8);
            } else if (!StringUtils.isNull(by7Var.h()) && by7Var.b() == 0) {
                long a2 = gy7.a(by7Var.h());
                if (StringUtils.isNull(by7Var.d())) {
                    d = "0";
                } else {
                    d = by7Var.d();
                }
                int b = gy7.b(Long.valueOf(d).longValue() - a2);
                if (b < 0) {
                    b = gy7.b((System.currentTimeMillis() / 1000) - a2);
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
                forumRuleDetailSelfVH.e(by7Var.b());
            }
        }
    }
}
