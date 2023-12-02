package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mt extends os<fw4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public ThreadLinkView g;
    public TextView h;
    public fw4 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mt(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (TbadkCoreApplication.getInst().getPersonalizeViewData().o != null && TbadkCoreApplication.getInst().getPersonalizeViewData().o.getParent() == null) {
            this.f = TbadkCoreApplication.getInst().getPersonalizeViewData().o;
        } else {
            this.f = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        }
        this.g = (ThreadLinkView) this.f.findViewById(R.id.link_thread_root);
        this.h = (TextView) this.f.findViewById(R.id.link_seg_title);
    }

    @Override // com.baidu.tieba.os
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.os
    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            super.o(bdUniqueId);
            this.g.setTag(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.g.b();
            fw4 fw4Var = this.i;
            if (fw4Var != null && fw4Var.getThreadData() != null) {
                xl6.l(this.h, this.i.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: r */
    public void onBindDataToView(fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fw4Var) == null) {
            if (fw4Var != null && fw4Var.getThreadData() != null) {
                this.i = fw4Var;
                ThreadData threadData = fw4Var.getThreadData();
                xl6.j(threadData, this.h);
                this.g.setData(threadData);
                return;
            }
            g().setVisibility(8);
        }
    }
}
