package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.tabfeed.view.NearbyForumFriendCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o98 extends pm<fd9, AdapterViewHolder<NearbyForumFriendCardView>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public AdapterViewHolder<NearbyForumFriendCardView> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o98(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), fd9.d);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: s */
    public AdapterViewHolder<NearbyForumFriendCardView> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            AdapterViewHolder<NearbyForumFriendCardView> adapterViewHolder = new AdapterViewHolder<>(new NearbyForumFriendCardView(this.a.getPageActivity()));
            this.b = adapterViewHolder;
            return adapterViewHolder;
        }
        return (AdapterViewHolder) invokeL.objValue;
    }

    public void u(boolean z) {
        AdapterViewHolder<NearbyForumFriendCardView> adapterViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (adapterViewHolder = this.b) != null) {
            adapterViewHolder.a().setNeedCompleteProfile(z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, fd9 fd9Var, AdapterViewHolder<NearbyForumFriendCardView> adapterViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fd9Var, adapterViewHolder})) == null) {
            NearbyForumFriendCardView a = adapterViewHolder.a();
            a.onBindDataToView(fd9Var);
            a.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            return adapterViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
