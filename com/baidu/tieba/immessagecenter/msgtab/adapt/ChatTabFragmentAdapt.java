package com.baidu.tieba.immessagecenter.msgtab.adapt;

import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.immessagecenter.mention.ChatAggregationFragment;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.ChatTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ChatTabFragmentAdapt extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public ChatAggregationFragment b;
    public ChatTabFragment c;

    public ChatTabFragmentAdapt(ChatAggregationFragment chatAggregationFragment, ChatTabFragment chatTabFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatAggregationFragment, chatTabFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.a = chatTabFragment != null;
    }

    public BaseFragment W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a) {
                return this.c;
            }
            return this.b;
        }
        return (BaseFragment) invokeV.objValue;
    }
}
