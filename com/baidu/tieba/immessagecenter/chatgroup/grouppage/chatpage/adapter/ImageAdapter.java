package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg;
import com.baidu.tieba.yd8;
import com.baidu.tieba.zd8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ImageAdapter extends BaseChatAdapter<BaseImageMsg<?>, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yd8 l;
    public String m;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseImageMsg a;
        public final /* synthetic */ ImageAdapter b;

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
            this.b = imageAdapter;
            this.a = baseImageMsg;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.m = this.a.getBigSrc();
                if (StringUtils.isNull(this.b.m)) {
                    this.b.m = this.a.getThumbUrl();
                }
                if (StringUtils.isNull(this.b.m)) {
                    return;
                }
                CommonMsgField commonMsgField = this.a.getCommonMsgField();
                long roomId = commonMsgField.getRoomId();
                long forumId = commonMsgField.getForumId();
                this.b.l = new yd8(this.b.mContext, this.b.m, forumId, null, roomId, false);
                this.b.l.execute(new String[0]);
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
        this.l = null;
    }

    public final ChatImageWithTailView g0(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            ChatImageWithTailView chatImageWithTailView = new ChatImageWithTailView(context);
            chatImageWithTailView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            chatImageWithTailView.e(false);
            chatImageWithTailView.getImage().setId(R.id.obfuscated_res_0x7f090e99);
            return chatImageWithTailView;
        }
        return (ChatImageWithTailView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: j0 */
    public Holder N(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            return new Holder(g0(viewGroup.getContext()));
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: k0 */
    public Holder P(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            return new Holder(g0(viewGroup.getContext()));
        }
        return (Holder) invokeL.objValue;
    }

    public final void h0(ChatImageWithTailView chatImageWithTailView, BaseImageMsg<?> baseImageMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, chatImageWithTailView, baseImageMsg) == null) {
            String thumbUrl = baseImageMsg.getThumbUrl();
            Pair<Boolean, String> i0 = i0(baseImageMsg.getThumbSize());
            if (!StringUtils.isNull(thumbUrl)) {
                CommonMsgField commonMsgField = baseImageMsg.getCommonMsgField();
                if (commonMsgField != null && commonMsgField.isRobot()) {
                    chatImageWithTailView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    chatImageWithTailView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                baseImageMsg.setThumbSize(zd8.d(chatImageWithTailView, thumbUrl, i0.second, R.drawable.icon_pic_im_image_default));
            }
        }
    }

    public final Pair<Boolean, String> i0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return Pair.create(Boolean.TRUE, "240.0,240.0");
            }
            String[] split = str.split(",");
            if (split != null && split.length > 1) {
                int i = (int) JavaTypesHelper.toFloat(split[0], 0.0f);
                int i2 = (int) JavaTypesHelper.toFloat(split[1], 0.0f);
                if (i > 0 && i2 > 0) {
                    return Pair.create(Boolean.FALSE, str);
                }
                return Pair.create(Boolean.TRUE, "240.0,240.0");
            }
            return Pair.create(Boolean.TRUE, "240.0,240.0");
        }
        return (Pair) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    /* renamed from: l0 */
    public void U(int i, @NonNull ViewGroup viewGroup, @NonNull BaseImageMsg<?> baseImageMsg, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), viewGroup, baseImageMsg, holder, list, Integer.valueOf(i2)}) == null) {
            viewGroup.setBackgroundColor(SkinManager.getColor(R.color.transparent));
            holder.a(new a(this, baseImageMsg));
            h0((ChatImageWithTailView) holder.getView(), baseImageMsg);
        }
    }
}
