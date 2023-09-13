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
/* loaded from: classes9.dex */
public class yx extends ax<b15> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public ThreadLinkView g;
    public TextView h;
    public b15 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yx(Context context) {
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

    @Override // com.baidu.tieba.ax
    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ax
    public void p(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            super.p(bdUniqueId);
            this.g.setTag(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.g.b();
            b15 b15Var = this.i;
            if (b15Var != null && b15Var.getThreadData() != null) {
                xo6.l(this.h, this.i.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: s */
    public void onBindDataToView(b15 b15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b15Var) == null) {
            if (b15Var != null && b15Var.getThreadData() != null) {
                this.i = b15Var;
                ThreadData threadData = b15Var.getThreadData();
                xo6.j(threadData, this.h);
                this.g.setData(threadData);
                return;
            }
            j().setVisibility(8);
        }
    }
}
