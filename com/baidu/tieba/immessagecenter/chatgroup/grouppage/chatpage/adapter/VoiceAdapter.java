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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.fb5;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.VoiceMsg;
import com.baidu.tieba.oj8;
import com.baidu.tieba.xi8;
import com.baidu.tieba.xj8;
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
    public VoiceManager l;

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
        public void b(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                super.b(onClickListener);
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void c(@Nullable View.OnLongClickListener onLongClickListener) {
            ChatVoiceView chatVoiceView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) && (chatVoiceView = this.a) != null) {
                chatVoiceView.setOnLongClickListener(onLongClickListener);
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void e(@NonNull oj8 oj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oj8Var) == null) {
                super.e(oj8Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements xi8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ ChatVoiceView b;
        public final /* synthetic */ VoiceMsg c;
        public final /* synthetic */ int d;
        public final /* synthetic */ VoiceAdapter e;

        public a(VoiceAdapter voiceAdapter, ViewGroup viewGroup, ChatVoiceView chatVoiceView, VoiceMsg voiceMsg, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceAdapter, viewGroup, chatVoiceView, voiceMsg, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = voiceAdapter;
            this.a = viewGroup;
            this.b = chatVoiceView;
            this.c = voiceMsg;
            this.d = i;
        }

        @Override // com.baidu.tieba.xi8
        public void a(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.a.setBackground(drawable);
                this.e.d0(this.b, this.c, this.d, false);
            }
        }

        @Override // com.baidu.tieba.xi8
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.e.k0(this.a, this.c);
                this.e.d0(this.b, this.c, this.d, true);
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

    public final ChatVoiceView e0(@NonNull Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, context, z)) == null) {
            ChatVoiceView chatVoiceView = new ChatVoiceView(context, z);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            chatVoiceView.setLayoutParams(layoutParams);
            chatVoiceView.setId(R.id.obfuscated_res_0x7f090eb7);
            chatVoiceView.setVoiceManager(this.l);
            chatVoiceView.setOnClickListener(chatVoiceView);
            chatVoiceView.d();
            return chatVoiceView;
        }
        return (ChatVoiceView) invokeLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: g0 */
    public ViewHolder O(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            return new ViewHolder(e0(viewGroup.getContext(), true));
        }
        return (ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: h0 */
    public ViewHolder Q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            return new ViewHolder(e0(viewGroup.getContext(), false));
        }
        return (ViewHolder) invokeL.objValue;
    }

    public void j0(VoiceManager voiceManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, voiceManager) == null) {
            this.l = voiceManager;
        }
    }

    public final void d0(ChatVoiceView chatVoiceView, VoiceMsg voiceMsg, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{chatVoiceView, voiceMsg, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            int u = xj8.u(voiceMsg, i);
            if (u != 0 && !z) {
                chatVoiceView.setVoicePureColor(u);
            } else if (voiceMsg.isLeft()) {
                chatVoiceView.setVoicePureColor(SkinManager.getColor(R.color.CAM_X0105));
            } else {
                chatVoiceView.setVoicePureColor(0);
            }
            chatVoiceView.g(false, voiceMsg.isLeft());
        }
    }

    @NonNull
    public final VoiceData.VoiceModel f0(@NonNull VoiceMsg voiceMsg) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, voiceMsg)) == null) {
            if (voiceMsg.getVoiceModel() != null) {
                return voiceMsg.getVoiceModel();
            }
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceMsg.setVoiceModel(voiceModel);
            voiceModel.setDuration(JavaTypesHelper.toInt(voiceMsg.getDuring(), 0));
            if (fb5.b(voiceMsg.getVid()) == null && voiceMsg.getVoiceUrl() != null && (parse = Uri.parse(voiceMsg.getVoiceUrl())) != null) {
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
    /* renamed from: i0 */
    public void V(int i, @NonNull ViewGroup viewGroup, @NonNull VoiceMsg voiceMsg, @NonNull ViewHolder viewHolder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), viewGroup, voiceMsg, viewHolder, list, Integer.valueOf(i2)}) == null) {
            ChatVoiceView chatVoiceView = (ChatVoiceView) viewHolder.getView();
            xj8.t(this.mType, voiceMsg, viewGroup, new a(this, viewGroup, chatVoiceView, voiceMsg, i2));
            chatVoiceView.setData(f0(voiceMsg));
        }
    }

    public final void k0(@NonNull ViewGroup viewGroup, @NonNull VoiceMsg voiceMsg) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, viewGroup, voiceMsg) == null) {
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
