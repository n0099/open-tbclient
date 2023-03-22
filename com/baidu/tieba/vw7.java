package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.AbilityTagItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.ElementFileItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.ElementItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.SkillIconViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.SkillTagItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.TagItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vw7 extends vx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vw7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.vx7
    public BaseTagItemViewHolder b(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i == dx7.b) {
                return new TagItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08cb, viewGroup, false), this.a);
            }
            if (i == bx7.d) {
                return new ElementItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08c8, viewGroup, false), this.a);
            }
            if (i == ax7.c) {
                return new SkillTagItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0838, viewGroup, false), this.a);
            }
            if (i == zw7.a) {
                return new SkillIconViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0837, viewGroup, false), this.a);
            }
            if (i == cx7.c) {
                return new ElementFileItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08ca, viewGroup, false), this.a);
            }
            if (i == yw7.c) {
                return new AbilityTagItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08c7, viewGroup, false), this.b);
            }
            return null;
        }
        return (BaseTagItemViewHolder) invokeLI.objValue;
    }
}
