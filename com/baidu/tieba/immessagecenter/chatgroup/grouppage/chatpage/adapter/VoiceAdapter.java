package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.b98;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.VoiceMsg;
import com.baidu.tieba.k98;
import com.baidu.tieba.l88;
import com.baidu.tieba.pg;
import com.baidu.tieba.w85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class VoiceAdapter extends BaseChatAdapter<VoiceMsg, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VoiceManager j;

    /* loaded from: classes6.dex */
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                super.a(onClickListener);
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            ChatVoiceView chatVoiceView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) && (chatVoiceView = this.a) != null) {
                chatVoiceView.setOnLongClickListener(onLongClickListener);
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void d(@NonNull b98 b98Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b98Var) == null) {
                super.d(b98Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements l88 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ VoiceMsg b;
        public final /* synthetic */ VoiceAdapter c;

        public a(VoiceAdapter voiceAdapter, ViewGroup viewGroup, VoiceMsg voiceMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceAdapter, viewGroup, voiceMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = voiceAdapter;
            this.a = viewGroup;
            this.b = voiceMsg;
        }

        @Override // com.baidu.tieba.l88
        public void a(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.a.setBackground(drawable);
            }
        }

        @Override // com.baidu.tieba.l88
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.c.d0(this.a, this.b);
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

    public final ChatVoiceView X(@NonNull Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, context, z)) == null) {
            ChatVoiceView chatVoiceView = new ChatVoiceView(context, z);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            chatVoiceView.setLayoutParams(layoutParams);
            chatVoiceView.setId(R.id.obfuscated_res_0x7f090e7c);
            chatVoiceView.setVoiceManager(this.j);
            chatVoiceView.setOnClickListener(chatVoiceView);
            chatVoiceView.g();
            return chatVoiceView;
        }
        return (ChatVoiceView) invokeLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: Z */
    public ViewHolder J(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new ViewHolder(X(viewGroup.getContext(), true));
        }
        return (ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: a0 */
    public ViewHolder M(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            return new ViewHolder(X(viewGroup.getContext(), false));
        }
        return (ViewHolder) invokeL.objValue;
    }

    public void c0(VoiceManager voiceManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, voiceManager) == null) {
            this.j = voiceManager;
        }
    }

    @NonNull
    public final VoiceData.VoiceModel Y(@NonNull VoiceMsg voiceMsg) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, voiceMsg)) == null) {
            if (voiceMsg.getVoiceModel() != null) {
                return voiceMsg.getVoiceModel();
            }
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceMsg.setVoiceModel(voiceModel);
            voiceModel.setDuration(pg.e(voiceMsg.getDuring(), 0));
            if (w85.b(voiceMsg.getVid()) == null && voiceMsg.getVoiceUrl() != null && (parse = Uri.parse(voiceMsg.getVoiceUrl())) != null) {
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
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    /* renamed from: b0 */
    public void R(int i, @NonNull ViewGroup viewGroup, @NonNull VoiceMsg voiceMsg, @NonNull ViewHolder viewHolder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), viewGroup, voiceMsg, viewHolder, list, Integer.valueOf(i2)}) == null) {
            k98.r(this.mType, voiceMsg, viewGroup, new a(this, viewGroup, voiceMsg));
            ChatVoiceView chatVoiceView = (ChatVoiceView) viewHolder.getView();
            int s = k98.s(voiceMsg, i2);
            if (s == 0) {
                if (voiceMsg.isLeft()) {
                    chatVoiceView.setVoicePureColor(SkinManager.getColor(R.color.CAM_X0105));
                } else {
                    chatVoiceView.setVoicePureColor(0);
                }
            } else {
                chatVoiceView.setVoicePureColor(s);
            }
            VoiceData.VoiceModel Y = Y(voiceMsg);
            chatVoiceView.j(false, voiceMsg.isLeft());
            chatVoiceView.setData(Y);
        }
    }

    public final void d0(@NonNull ViewGroup viewGroup, @NonNull VoiceMsg voiceMsg) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, viewGroup, voiceMsg) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (voiceMsg.isLeft()) {
                i = R.drawable.selector_msg_text_bubble_other;
            } else {
                i = R.drawable.selector_msg_text_bubble_me;
            }
            viewGroup.setBackground(SkinManager.getDrawable(skinType, i));
        }
    }
}
