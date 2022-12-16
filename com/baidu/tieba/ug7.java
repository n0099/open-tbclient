package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.ChatBannerViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.ChatItemViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.ChatNameViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ug7 implements zg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ch7 a;

    public ug7(ch7 ch7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ch7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ch7Var;
    }

    @Override // com.baidu.tieba.zg7
    @Nullable
    public BaseItemViewHolder a(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i == 2) {
                return new ChatItemViewHolder(LayoutInflater.from(SelectorHelper.getContext()).inflate(R.layout.obfuscated_res_0x7f0d038f, (ViewGroup) null, false), this.a);
            }
            if (i == 1) {
                return new ChatNameViewHolder(LayoutInflater.from(SelectorHelper.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0390, (ViewGroup) null, false));
            }
            if (i != 3) {
                return null;
            }
            return new ChatBannerViewHolder(LayoutInflater.from(SelectorHelper.getContext()).inflate(R.layout.obfuscated_res_0x7f0d038d, (ViewGroup) null, false));
        }
        return (BaseItemViewHolder) invokeLI.objValue;
    }
}
