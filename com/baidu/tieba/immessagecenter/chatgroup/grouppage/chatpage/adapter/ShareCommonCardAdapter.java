package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.widget.sharecard.ChatShareCommonCard;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ShareCommonCardSysMsg;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0019\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J>\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020\u0019H\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/adapter/ShareCommonCardAdapter;", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseChatAdapter;", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/ShareCommonCardSysMsg;", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseViewHolder;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "uid", "Lcom/baidu/adp/BdUniqueId;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/adp/BdUniqueId;)V", "roomId", "", "getRoomId", "()J", "setRoomId", "(J)V", "createViewHolder", "context", "Landroid/content/Context;", "onCreateChildLeftViewHolder", "parent", "Landroid/view/ViewGroup;", "onCreateChildRightViewHolder", "onFillChildViewHolder", "", CriusAttrConstants.POSITION, "", "directParent", "data", "holder", "payloads", "", "", WriteMulitImageActivityConfig.SKIN_TYPE, "Companion", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ShareCommonCardAdapter extends BaseChatAdapter<ShareCommonCardSysMsg, BaseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-7910900, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/adapter/ShareCommonCardAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-7910900, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/adapter/ShareCommonCardAdapter;");
                return;
            }
        }
        m = UtilHelper.getDimenPixelSize(R.dimen.tbds666);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareCommonCardAdapter(TbPageContext<?> pageContext, BdUniqueId uid) {
        super(pageContext, uid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, uid};
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
        Intrinsics.checkNotNullParameter(uid, "uid");
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    public BaseViewHolder N(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return b0(context);
        }
        return (BaseViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    public BaseViewHolder P(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return b0(context);
        }
        return (BaseViewHolder) invokeL.objValue;
    }

    public final void d0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.l = j;
        }
    }

    public final BaseViewHolder b0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            final ChatShareCommonCard chatShareCommonCard = new ChatShareCommonCard(context, null, 2, null);
            chatShareCommonCard.setId(R.id.obfuscated_res_0x7f090eb9);
            chatShareCommonCard.setScene(1);
            chatShareCommonCard.setRoomId(this.l);
            chatShareCommonCard.setLayoutParams(new ViewGroup.LayoutParams(m, -2));
            return new BaseViewHolder(chatShareCommonCard) { // from class: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.ShareCommonCardAdapter$createViewHolder$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(chatShareCommonCard);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {chatShareCommonCard};
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

                @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
                public void c(View.OnLongClickListener onLongClickListener) {
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
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    /* renamed from: c0 */
    public void U(int i, ViewGroup directParent, ShareCommonCardSysMsg data, BaseViewHolder holder, List<Object> payloads, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), directParent, data, holder, payloads, Integer.valueOf(i2)}) == null) {
            Intrinsics.checkNotNullParameter(directParent, "directParent");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            if (data.isLeft()) {
                i3 = R.drawable.icon_pic_im_bubble_left;
            } else {
                i3 = R.drawable.icon_pic_im_bubble_share_right;
            }
            SkinManager.setBackgroundResource(directParent, i3);
            ChatShareCommonCard chatShareCommonCard = (ChatShareCommonCard) holder.itemView;
            chatShareCommonCard.a(data.shareCommon);
            chatShareCommonCard.f(data.isLeft());
        }
    }
}
