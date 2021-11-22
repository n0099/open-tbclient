package com.baidu.tieba.write.bottomButton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import b.a.q0.h0.b;
import b.a.q0.h0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class WriteThreadDelegateStatic extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WriteThreadDelegateStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // b.a.q0.h0.b
    public c createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = new c();
            cVar.f13359a = new WriteThreadFragment();
            cVar.f13363e = 9;
            cVar.f13360b = R.string.send;
            cVar.f13362d = R.drawable.icon_tabbar_add_n;
            cVar.f13367i = c.j;
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    @Override // b.a.q0.h0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
            this.mIndicator = maintabBottomIndicator;
            return maintabBottomIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // b.a.q0.h0.b
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
