package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.im.under.common.tag.item.AbilityTagItemViewHolder;
import com.baidu.tieba.im.under.common.tag.item.AddEmojiPendantVH;
import com.baidu.tieba.im.under.common.tag.item.ElementFileItemViewHolder;
import com.baidu.tieba.im.under.common.tag.item.ElementItemViewHolder;
import com.baidu.tieba.im.under.common.tag.item.EmojiReplyPendantVH;
import com.baidu.tieba.im.under.common.tag.item.SkillIconViewHolder;
import com.baidu.tieba.im.under.common.tag.item.SkillTagItemViewHolder;
import com.baidu.tieba.im.under.common.tag.item.TagItemViewHolder;
import com.baidu.tieba.im.under.common.tag.item.TagSugItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tu8 extends vm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public BotsDTO.BotListDTO.SkillDTO d;
    @Nullable
    public BotsDTO.BotListDTO.UserDTO e;

    public tu8() {
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

    @Override // com.baidu.tieba.vm8
    public BaseTagItemViewHolder b(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i == iv8.b) {
                return new TagItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d097a, viewGroup, false), this.a);
            }
            if (i == ym8.d) {
                return new ElementItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0977, viewGroup, false), this.a);
            }
            if (i == hv8.c) {
                return new SkillTagItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08dc, viewGroup, false), this.a);
            }
            if (i == gv8.a) {
                return new SkillIconViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08db, viewGroup, false), this.a);
            }
            if (i == zm8.f) {
                return new ElementFileItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0979, viewGroup, false), this.a);
            }
            if (i == bv8.e) {
                return new AbilityTagItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0976, viewGroup, false), this.b, this.c);
            }
            if (i == jv8.b) {
                TagSugItemViewHolder tagSugItemViewHolder = new TagSugItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0977, viewGroup, false), this.a, this.c);
                tagSugItemViewHolder.q(this.d);
                tagSugItemViewHolder.t(this.e);
                return tagSugItemViewHolder;
            } else if (i == ev8.d) {
                return new EmojiReplyPendantVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0534, viewGroup, false), this.b);
            } else {
                if (i == cv8.b) {
                    return new AddEmojiPendantVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0534, viewGroup, false), this.b);
                }
                return null;
            }
        }
        return (BaseTagItemViewHolder) invokeLI.objValue;
    }

    public void e(@Nullable BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, skillDTO) == null) {
            this.d = skillDTO;
        }
    }

    public void f(@Nullable BotsDTO.BotListDTO.UserDTO userDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, userDTO) == null) {
            this.e = userDTO;
        }
    }
}
