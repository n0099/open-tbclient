package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.LocalCacheData;
import com.baidu.tieba.oj7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ImageAdapter extends BaseChatAdapter<BaseImageMsg<?>, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class Holder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ChatImageWithTailView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(@NonNull ChatImageWithTailView chatImageWithTailView) {
            super(chatImageWithTailView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatImageWithTailView};
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
            this.a = chatImageWithTailView;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            ChatImageWithTailView chatImageWithTailView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) && (chatImageWithTailView = this.a) != null) {
                chatImageWithTailView.getImage().setOnClickListener(onClickListener);
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            ChatImageWithTailView chatImageWithTailView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) && (chatImageWithTailView = this.a) != null) {
                chatImageWithTailView.getImage().setOnLongClickListener(onLongClickListener);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseImageMsg a;

        public a(ImageAdapter imageAdapter, BaseImageMsg baseImageMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageAdapter, baseImageMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseImageMsg;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String bigSrc = this.a.getBigSrc();
                if (StringUtils.isNull(bigSrc)) {
                    bigSrc = this.a.getThumbUrl();
                }
                String str = bigSrc;
                if (StringUtils.isNull(str)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalMsgImageActivityConfig(view2.getContext(), str, TbadkCoreApplication.getCurrentAccountId(), "")));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
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

    public final void P(ChatImageWithTailView chatImageWithTailView, BaseImageMsg<?> baseImageMsg) {
        String thumbUrl;
        String thumbSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, chatImageWithTailView, baseImageMsg) == null) {
            if (baseImageMsg.getCacheData() != null) {
                thumbUrl = baseImageMsg.getCacheData().localPath;
                thumbSize = baseImageMsg.getCacheData().imgSize;
            } else {
                thumbUrl = baseImageMsg.getThumbUrl();
                thumbSize = baseImageMsg.getThumbSize();
            }
            baseImageMsg.setThumbSize(oj7.c(chatImageWithTailView, thumbUrl, thumbSize, R.drawable.icon_pic_im_image_default));
        }
    }

    public final void O(BaseImageMsg<?> baseImageMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, baseImageMsg) == null) && !StringUtils.isNull(baseImageMsg.getThumbUrl()) && !baseImageMsg.getThumbUrl().startsWith("http")) {
            if (baseImageMsg.getCacheData() == null) {
                LocalCacheData localCacheData = new LocalCacheData();
                localCacheData.imgSize = baseImageMsg.getThumbSize();
                localCacheData.localPath = baseImageMsg.getThumbUrl();
                baseImageMsg.setCacheData(localCacheData);
                return;
            }
            baseImageMsg.getCacheData().imgSize = baseImageMsg.getThumbSize();
            baseImageMsg.getCacheData().localPath = baseImageMsg.getThumbUrl();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: Q */
    public Holder B(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            ChatImageWithTailView chatImageWithTailView = new ChatImageWithTailView(viewGroup.getContext());
            chatImageWithTailView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            chatImageWithTailView.getImage().setId(R.id.obfuscated_res_0x7f090d9c);
            return new Holder(chatImageWithTailView);
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: R */
    public Holder D(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            ChatImageWithTailView chatImageWithTailView = new ChatImageWithTailView(viewGroup.getContext());
            chatImageWithTailView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            chatImageWithTailView.getImage().setId(R.id.obfuscated_res_0x7f090d9c);
            return new Holder(chatImageWithTailView);
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    /* renamed from: S */
    public void J(int i, @NonNull ViewGroup viewGroup, @NonNull BaseImageMsg<?> baseImageMsg, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), viewGroup, baseImageMsg, holder, list, Integer.valueOf(i2)}) == null) {
            viewGroup.setBackgroundColor(SkinManager.getColor(R.color.transparent));
            O(baseImageMsg);
            holder.a(new a(this, baseImageMsg));
            P((ChatImageWithTailView) holder.getView(), baseImageMsg);
        }
    }
}
