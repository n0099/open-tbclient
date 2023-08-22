package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.SdkDoubleLiveViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sa6 extends om<wa6, SdkDoubleLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public ac6 b;
    public int c;
    public boolean d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public sa6(TbPageContext tbPageContext, int i, boolean z) {
        super(r0, r1);
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (z) {
            bdUniqueId = wa6.d;
        } else {
            bdUniqueId = wa6.c;
        }
        this.a = tbPageContext;
        this.c = i;
        this.d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: s */
    public SdkDoubleLiveViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.b = new ac6(this.a, viewGroup, this.c, this.d);
            return new SdkDoubleLiveViewHolder(this.b);
        }
        return (SdkDoubleLiveViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, wa6 wa6Var, SdkDoubleLiveViewHolder sdkDoubleLiveViewHolder) {
        InterceptResult invokeCommon;
        ac6 ac6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wa6Var, sdkDoubleLiveViewHolder})) == null) {
            if (sdkDoubleLiveViewHolder != null && (ac6Var = sdkDoubleLiveViewHolder.a) != null) {
                ac6Var.i(wa6Var);
                sdkDoubleLiveViewHolder.a.j(this.a, TbadkCoreApplication.getInst().getSkinType());
                return sdkDoubleLiveViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
