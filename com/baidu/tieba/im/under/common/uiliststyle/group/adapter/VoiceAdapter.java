package com.baidu.tieba.im.under.common.uiliststyle.group.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
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
import com.baidu.tieba.az8;
import com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter;
import com.baidu.tieba.im.base.core.uilist.BaseViewHolder;
import com.baidu.tieba.im.lib.socket.msg.TbVoiceMsg;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.VoiceItem;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.n75;
import com.baidu.tieba.sq8;
import com.baidu.tieba.zy8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class VoiceAdapter extends BaseStyleNormalAdapter<VoiceItem, ViewHolder, BaseNormalAdapter.NonExtraHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VoiceManager m;

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

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void a(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                super.a(onClickListener);
            }
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void b(View.OnLongClickListener onLongClickListener) {
            ChatVoiceView chatVoiceView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) && (chatVoiceView = this.a) != null) {
                chatVoiceView.setOnLongClickListener(onLongClickListener);
            }
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void d(@NonNull sq8 sq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sq8Var) == null) {
                super.d(sq8Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements az8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ ChatVoiceView b;
        public final /* synthetic */ VoiceItem c;
        public final /* synthetic */ int d;
        public final /* synthetic */ VoiceAdapter e;

        public a(VoiceAdapter voiceAdapter, ViewGroup viewGroup, ChatVoiceView chatVoiceView, VoiceItem voiceItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceAdapter, viewGroup, chatVoiceView, voiceItem, Integer.valueOf(i)};
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
            this.c = voiceItem;
            this.d = i;
        }

        @Override // com.baidu.tieba.az8
        public void a(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.a.setBackground(drawable);
                this.e.i0(this.b, this.c, this.d, false);
            }
        }

        @Override // com.baidu.tieba.az8
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.e.p0(this.a, this.c);
                this.e.i0(this.b, this.c, this.d, true);
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

    public final ChatVoiceView j0(@NonNull Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, context, z)) == null) {
            ChatVoiceView chatVoiceView = new ChatVoiceView(context, z);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            chatVoiceView.setLayoutParams(layoutParams);
            chatVoiceView.setId(R.id.obfuscated_res_0x7f090f2a);
            chatVoiceView.setVoiceManager(this.m);
            chatVoiceView.setOnClickListener(chatVoiceView);
            chatVoiceView.d();
            return chatVoiceView;
        }
        return (ChatVoiceView) invokeLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    @NonNull
    /* renamed from: l0 */
    public ViewHolder O(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            return new ViewHolder(j0(viewGroup.getContext(), true));
        }
        return (ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    @NonNull
    /* renamed from: m0 */
    public ViewHolder Q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            return new ViewHolder(j0(viewGroup.getContext(), false));
        }
        return (ViewHolder) invokeL.objValue;
    }

    public void o0(VoiceManager voiceManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, voiceManager) == null) {
            this.m = voiceManager;
        }
    }

    public final void i0(ChatVoiceView chatVoiceView, VoiceItem voiceItem, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{chatVoiceView, voiceItem, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            int v = zy8.v(voiceItem, i);
            if (v != 0 && !z) {
                chatVoiceView.setVoicePureColor(v);
            } else if (voiceItem.isLeft()) {
                chatVoiceView.setVoicePureColor(SkinManager.getColor(R.color.CAM_X0105));
            } else {
                chatVoiceView.setVoicePureColor(0);
            }
            chatVoiceView.g(false, voiceItem.isLeft());
        }
    }

    @NonNull
    public final VoiceData.VoiceModel k0(@NonNull VoiceItem voiceItem) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, voiceItem)) == null) {
            TbVoiceMsg tbMsg = voiceItem.getTbMsg();
            if (tbMsg.getVoiceModel() != null) {
                return tbMsg.getVoiceModel();
            }
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            tbMsg.setVoiceModel(voiceModel);
            voiceModel.setDuration(JavaTypesHelper.toInt(tbMsg.getDuring(), 0));
            if (n75.b(tbMsg.getVid()) == null && tbMsg.getVoiceUrl() != null && (parse = Uri.parse(tbMsg.getVoiceUrl())) != null) {
                tbMsg.setVid(parse.getLastPathSegment());
            }
            voiceModel.setVoiceId(tbMsg.getVid());
            voiceModel.voice_status = Integer.valueOf(tbMsg.getVoiceStatus());
            voiceModel.isLocal = tbMsg.isLocal();
            voiceModel.isUseUrl = true;
            voiceModel.setVoiceUrl(tbMsg.getVoiceUrl());
            return voiceModel;
        }
        return (VoiceData.VoiceModel) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    /* renamed from: n0 */
    public void V(int i, @NonNull ViewGroup viewGroup, @NonNull VoiceItem voiceItem, @NonNull ViewHolder viewHolder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), viewGroup, voiceItem, viewHolder, list, Integer.valueOf(i2)}) == null) {
            ChatVoiceView chatVoiceView = (ChatVoiceView) viewHolder.getView();
            zy8.t(this.mType, voiceItem, viewGroup, new a(this, viewGroup, chatVoiceView, voiceItem, i2));
            chatVoiceView.setData(k0(voiceItem));
        }
    }

    public final void p0(@NonNull ViewGroup viewGroup, @NonNull VoiceItem voiceItem) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, viewGroup, voiceItem) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (voiceItem.isLeft()) {
                i = R.drawable.selector_msg_text_bubble_other;
            } else {
                i = R.drawable.selector_msg_text_bubble_me;
            }
            viewGroup.setBackground(SkinManager.getDrawable(skinType, i));
        }
    }
}
