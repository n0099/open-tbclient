package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.VoiceMsg;
import com.baidu.tieba.rh7;
import com.baidu.tieba.xg;
import com.baidu.tieba.y05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class VoiceAdapter extends BaseChatAdapter<VoiceMsg, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VoiceManager g;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ChatVoiceView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NonNull ChatVoiceView chatVoiceView) {
            super(chatVoiceView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatVoiceView;
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                super.a(onClickListener);
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            ChatVoiceView chatVoiceView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) && (chatVoiceView = this.a) != null) {
                chatVoiceView.setOnLongClickListener(onLongClickListener);
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void d(@NonNull rh7 rh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rh7Var) == null) {
                super.d(rh7Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final ChatVoiceView K(@NonNull Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, context, z)) == null) {
            ChatVoiceView chatVoiceView = new ChatVoiceView(context, z);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            chatVoiceView.setLayoutParams(layoutParams);
            chatVoiceView.setId(R.id.obfuscated_res_0x7f090d71);
            chatVoiceView.setVoiceManager(this.g);
            chatVoiceView.setOnClickListener(chatVoiceView);
            return chatVoiceView;
        }
        return (ChatVoiceView) invokeLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: M */
    public ViewHolder A(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new ViewHolder(K(viewGroup.getContext(), true));
        }
        return (ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: N */
    public ViewHolder B(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            return new ViewHolder(K(viewGroup.getContext(), false));
        }
        return (ViewHolder) invokeL.objValue;
    }

    public void P(VoiceManager voiceManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, voiceManager) == null) {
            this.g = voiceManager;
        }
    }

    @NonNull
    public final VoiceData.VoiceModel L(@NonNull VoiceMsg voiceMsg) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, voiceMsg)) == null) {
            if (voiceMsg.getVoiceModel() != null) {
                return voiceMsg.getVoiceModel();
            }
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceMsg.setVoiceModel(voiceModel);
            voiceModel.setDuration(xg.e(voiceMsg.getDuring(), 0));
            if (y05.b(voiceMsg.getVid()) == null && voiceMsg.getVoiceUrl() != null && (parse = Uri.parse(voiceMsg.getVoiceUrl())) != null) {
                voiceMsg.setVid(parse.getLastPathSegment());
            }
            voiceModel.setVoiceId(voiceMsg.getVid());
            voiceModel.voice_status = Integer.valueOf(voiceMsg.getVoiceStatus());
            voiceModel.isLocal = voiceMsg.isLocal();
            voiceModel.isGroupChat = true;
            voiceModel.setVoiceUrl(voiceMsg.getVoiceUrl());
            return voiceModel;
        }
        return (VoiceData.VoiceModel) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    /* renamed from: O */
    public void F(int i, @NonNull ViewGroup viewGroup, @NonNull VoiceMsg voiceMsg, @NonNull ViewHolder viewHolder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), viewGroup, voiceMsg, viewHolder, list, Integer.valueOf(i2)}) == null) {
            ChatVoiceView chatVoiceView = (ChatVoiceView) viewHolder.getView();
            VoiceData.VoiceModel L = L(voiceMsg);
            chatVoiceView.f("");
            chatVoiceView.setData(L);
        }
    }
}
