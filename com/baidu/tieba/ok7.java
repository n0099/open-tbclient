package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailBottomVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ok7 extends lm<tk7, ForumRuleDetailBottomVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ok7(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
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
        this.a = context;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.b = str;
        }
    }

    public void t(ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, forumRuleDetailBottomVH) != null) || forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.c(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: u */
    public ForumRuleDetailBottomVH onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            ForumRuleDetailBottomVH forumRuleDetailBottomVH = new ForumRuleDetailBottomVH(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0309, viewGroup, false));
            t(forumRuleDetailBottomVH);
            this.viewholder = forumRuleDetailBottomVH;
            return forumRuleDetailBottomVH;
        }
        return (ForumRuleDetailBottomVH) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.lm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, tk7 tk7Var, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        x(i, view2, viewGroup, tk7Var, forumRuleDetailBottomVH);
        return view2;
    }

    public final void s(ForumRuleDetailBottomVH forumRuleDetailBottomVH, tk7 tk7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumRuleDetailBottomVH, tk7Var) != null) || forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.b.setDefaultBgResource(R.drawable.img_default_100);
        forumRuleDetailBottomVH.b.startLoad(tk7Var.a(), 10, false);
        String string = TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f07ca);
        EMTextView eMTextView = forumRuleDetailBottomVH.d;
        eMTextView.setText(tk7Var.b() + string);
        forumRuleDetailBottomVH.f.setDefaultBgResource(R.drawable.img_default_100);
        forumRuleDetailBottomVH.f.startLoad(tk7Var.d(), 12, false);
        forumRuleDetailBottomVH.g.setText(tk7Var.c());
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.b)) {
            forumRuleDetailBottomVH.b(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            forumRuleDetailBottomVH.h.setText(String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07d1), tk7Var.e()));
            forumRuleDetailBottomVH.e.setText(String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07d1), tk7Var.e()));
        }
        forumRuleDetailBottomVH.c(TbadkCoreApplication.getInst().getSkinType());
    }

    public View x(int i, View view2, ViewGroup viewGroup, tk7 tk7Var, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, tk7Var, forumRuleDetailBottomVH})) == null) {
            if (tk7Var != null) {
                s(forumRuleDetailBottomVH, tk7Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
