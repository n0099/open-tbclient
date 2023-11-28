package com.baidu.tieba.im.under.common.uiliststyle.group.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter;
import com.baidu.tieba.im.base.core.uilist.BaseViewHolder;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.ShareChatRoomSysItem;
import com.baidu.tieba.im.widget.sharecard.ChatShareChatroomCard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u001c2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u001cB\u0019\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J>\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u0014H\u0014¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/im/under/common/uiliststyle/group/adapter/ShareChatRoomAdapter;", "Lcom/baidu/tieba/im/under/common/uiliststyle/group/adapter/BaseStyleNormalAdapter;", "Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/ShareChatRoomSysItem;", "Lcom/baidu/tieba/im/base/core/uilist/BaseViewHolder;", "Lcom/baidu/tieba/im/base/core/uilist/BaseNormalAdapter$NonExtraHolder;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "type", "Lcom/baidu/adp/BdUniqueId;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/adp/BdUniqueId;)V", "createViewHolder", "context", "Landroid/content/Context;", "onCreateChildLeftViewHolder", "parent", "Landroid/view/ViewGroup;", "onCreateChildRightViewHolder", "onFillChildViewHolder", "", CriusAttrConstants.POSITION, "", "directParent", "data", "holder", "payloads", "", "", WriteMulitImageActivityConfig.SKIN_TYPE, "Companion", "im-under-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ShareChatRoomAdapter extends BaseStyleNormalAdapter<ShareChatRoomSysItem, BaseViewHolder, BaseNormalAdapter.NonExtraHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1626536978, "Lcom/baidu/tieba/im/under/common/uiliststyle/group/adapter/ShareChatRoomAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1626536978, "Lcom/baidu/tieba/im/under/common/uiliststyle/group/adapter/ShareChatRoomAdapter;");
                return;
            }
        }
        m = UtilHelper.getDimenPixelSize(R.dimen.tbds666);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareChatRoomAdapter(TbPageContext<?> pageContext, BdUniqueId type) {
        super(pageContext, type);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, type};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    public BaseViewHolder O(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return g0(context);
        }
        return (BaseViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    public BaseViewHolder Q(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return g0(context);
        }
        return (BaseViewHolder) invokeL.objValue;
    }

    public final BaseViewHolder g0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            final ChatShareChatroomCard chatShareChatroomCard = new ChatShareChatroomCard(context, null, 2, null);
            chatShareChatroomCard.setId(R.id.obfuscated_res_0x7f090f1f);
            chatShareChatroomCard.setScene(1);
            chatShareChatroomCard.setLayoutParams(new ViewGroup.LayoutParams(m, -2));
            return new BaseViewHolder(chatShareChatroomCard) { // from class: com.baidu.tieba.im.under.common.uiliststyle.group.adapter.ShareChatRoomAdapter$createViewHolder$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(chatShareChatroomCard);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {chatShareChatroomCard};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((View) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
                public void b(View.OnLongClickListener onLongClickListener) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, onLongClickListener) == null) {
                        this.itemView.setOnLongClickListener(onLongClickListener);
                    }
                }
            };
        }
        return (BaseViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    /* renamed from: h0 */
    public void V(int i, ViewGroup directParent, ShareChatRoomSysItem data, BaseViewHolder holder, List<Object> payloads, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), directParent, data, holder, payloads, Integer.valueOf(i2)}) == null) {
            Intrinsics.checkNotNullParameter(directParent, "directParent");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            ChatShareChatroomCard chatShareChatroomCard = (ChatShareChatroomCard) holder.itemView;
            chatShareChatroomCard.setCurrentRoomId(data.getTbMsg().getSessionId());
            chatShareChatroomCard.b(data.getTbMsg().formatMsg());
            if (data.isLeft()) {
                i3 = R.drawable.icon_pic_im_bubble_left;
            } else {
                i3 = R.drawable.icon_pic_im_bubble_share_right;
            }
            chatShareChatroomCard.e(i3, data.isLeft());
        }
    }
}
