package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionViewHolder;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class n47 extends om<s47, ForumEmotionViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public r47 b;
    public m47 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n47(TbPageContext<?> tbPageContext, r47 r47Var, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, r47Var, bdUniqueId};
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
        this.a = tbPageContext;
        this.b = r47Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: s */
    public ForumEmotionViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ForumEmotionItemView forumEmotionItemView = new ForumEmotionItemView(this.a);
            ForumEmotionViewHolder forumEmotionViewHolder = new ForumEmotionViewHolder(this.a, forumEmotionItemView);
            forumEmotionItemView.b(TbadkCoreApplication.getInst().getSkinType());
            return forumEmotionViewHolder;
        }
        return (ForumEmotionViewHolder) invokeL.objValue;
    }

    public void u(m47 m47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, m47Var) == null) {
            this.c = m47Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, s47 s47Var, ForumEmotionViewHolder forumEmotionViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, s47Var, forumEmotionViewHolder})) == null) {
            forumEmotionViewHolder.m(s47Var, this.b, this.c, i);
            return forumEmotionViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
