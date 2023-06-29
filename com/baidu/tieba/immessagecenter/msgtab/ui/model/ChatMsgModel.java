package com.baidu.tieba.immessagecenter.msgtab.ui.model;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ce8;
import com.baidu.tieba.ch;
import com.baidu.tieba.cm8;
import com.baidu.tieba.eo5;
import com.baidu.tieba.htb;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedGroupChatListCompleteMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.tieba.immessagecenter.im.model.IMOfficialMaskModel;
import com.baidu.tieba.immessagecenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.immessagecenter.im.model.MsgChatTabModel;
import com.baidu.tieba.immessagecenter.im.model.MsgNotifyTabModel;
import com.baidu.tieba.immessagecenter.msgtab.obs.MainTabChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel;
import com.baidu.tieba.ld8;
import com.baidu.tieba.ltb;
import com.baidu.tieba.sxb;
import com.baidu.tieba.tm6;
import com.baidu.tieba.ua8;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.xsb;
import com.baidu.tieba.y78;
import com.baidu.tieba.z78;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0011J\u0016\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020OJ\u0006\u0010P\u001a\u00020JJ\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00110RJ\u0012\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0RJ$\u0010T\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c020RJ\u0006\u0010U\u001a\u00020\u0007J\b\u0010V\u001a\u00020JH\u0002J\u001d\u0010W\u001a\u0002HX\"\b\b\u0000\u0010X*\u00020Y2\u0006\u0010Z\u001a\u00020[¢\u0006\u0002\u0010\\J\u0016\u0010]\u001a\u00020J2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020E0DH\u0002J\b\u0010_\u001a\u00020\u0011H\u0002J\u0016\u0010`\u001a\u00020J2\u000e\u0010a\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u001cJ\u0006\u0010b\u001a\u00020JJ\u0006\u0010c\u001a\u00020JJ\u0006\u0010d\u001a\u00020JJ\u0010\u0010e\u001a\u00020J2\u0006\u0010f\u001a\u00020gH\u0002J\u0010\u0010h\u001a\u00020J2\u0006\u0010i\u001a\u00020jH\u0002J\u0016\u0010k\u001a\u00020J2\f\u0010l\u001a\b\u0012\u0002\b\u0003\u0018\u00010mH\u0002J\u0010\u0010n\u001a\u00020J2\u0006\u0010o\u001a\u00020pH\u0002J\u000e\u0010q\u001a\u00020J2\u0006\u0010r\u001a\u00020\u0011J\u0006\u0010s\u001a\u00020JJ\u0006\u0010t\u001a\u00020JJ(\u0010u\u001a\u00020J2\u000e\u0010^\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u001c2\b\u0010M\u001a\u0004\u0018\u00010\u001d2\u0006\u0010Z\u001a\u00020[J$\u0010v\u001a\u00020J2\b\u0010w\u001a\u0004\u0018\u00010x2\b\b\u0001\u0010y\u001a\u00020[2\u0006\u0010z\u001a\u00020\u0011H\u0002J\u0016\u0010{\u001a\u00020J2\u0006\u0010|\u001a\u00020\u00112\u0006\u0010}\u001a\u00020~J\u0006\u0010\u007f\u001a\u00020JR\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020.0\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0019R,\u00101\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R*\u00106\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0019R\u000e\u00108\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u000b\u001a\u0004\b>\u0010?R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR!\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u000b\u001a\u0004\bF\u0010G¨\u0006\u0080\u0001"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/model/ChatMsgModel;", "Lcom/baidu/tieba/immessagecenter/arch/model/BaseModel;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "(Lcom/baidu/tbadk/TbPageContext;)V", "dispatcher", "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/ChatTabSubscribeGroupMessageDispatcher;", "getDispatcher", "()Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/ChatTabSubscribeGroupMessageDispatcher;", "dispatcher$delegate", "Lkotlin/Lazy;", "imOfficialMaskModel", "Lcom/baidu/tieba/immessagecenter/im/model/IMOfficialMaskModel;", "imUserListModel", "Lcom/baidu/tieba/im/model/IMUserListModel;", "isCurrentChatTab", "", "isInit", "isMsgTabPrimary", "mAgainRequestGroupListListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mAnswerVisibleBs", "Lrx/subjects/BehaviorSubject;", "getMAnswerVisibleBs", "()Lrx/subjects/BehaviorSubject;", "mAnswerVisibleBs$delegate", "mChatMsgDataBs", "", "Lcom/baidu/tbadk/core/data/ImMessageCenterShowItemData;", "mCompleteProcess", "Lcom/baidu/tieba/im/chat/notify/ICompleteProcess;", "<set-?>", "mCompleteProcessBs", "getMCompleteProcessBs", "mId", "Lcom/baidu/adp/BdUniqueId;", "mMarkTopListener", "mMemoryListener", "mModel", "Lcom/baidu/tieba/immessagecenter/im/model/MsgChatTabModel;", "getMModel", "()Lcom/baidu/tieba/immessagecenter/im/model/MsgChatTabModel;", "mModel$delegate", "mMsgInvitationListener", "mNewMessageListener", "", "mNotifyAdapterBs", "getMNotifyAdapterBs", "mNotifyMsgDataBs", "Lkotlin/Pair;", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgNotifyData;", "mOnChatGroupCallback", "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/ChatTabSubscribeGroupMessageDispatcher$OnChatGroupMessageCallback;", "mRefreshStatusBs", "getMRefreshStatusBs", "mRemoveListItemListener", "mUserListMessageListener", "Lcom/baidu/adp/framework/listener/HttpMessageListener;", "memoryInitCompleted", "notifyTabModel", "Lcom/baidu/tieba/immessagecenter/im/model/MsgNotifyTabModel;", "getNotifyTabModel", "()Lcom/baidu/tieba/immessagecenter/im/model/MsgNotifyTabModel;", "notifyTabModel$delegate", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "personCacheList", "", "Lcom/baidu/tieba/im/db/pojo/ImMessageCenterPojo;", "getPersonCacheList", "()Ljava/util/List;", "personCacheList$delegate", "answerVisibleChange", "", "boolean", "deleteItem", "data", "iProcess", "Lcom/baidu/tieba/im/chat/notify/IProcess;", "forceRefreshUserListWhenInit", "getAnswerVisibleBs", "Lrx/Observable;", "getChatMsgDataObs", "getNotifyMsgDataBs", "getSocketDispatcher", "getSubscribeRequest", "getTabModel", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/tieba/immessagecenter/im/model/ImMessageCenterModel;", "type", "", "(I)Lcom/baidu/tieba/immessagecenter/im/model/ImMessageCenterModel;", "initNotifyModel", "list", "isHaveLocalGroupCache", "notifyDataSetChanged", "msgList", MissionEvent.MESSAGE_DESTROY, "onMsgTabPause", "onMsgTabPrimary", "processMemoryChanged", "changeMessage", "Lcom/baidu/tieba/im/message/MemoryChangedMessage;", "processMemoryInitComplete", "message", "Lcom/baidu/tieba/im/message/MemoryInitCompleteMessage;", "processNotify", "msg", "Lcom/baidu/adp/framework/message/ResponsedMessage;", "processResponseMemoryList", "resMessage", "Lcom/baidu/tieba/im/message/ResponsedMemoryListMessage;", "refreshMsg", "isSort", "refreshUserList", "registerListener", "sendChatTabRedTipUpdateMsg", "showTopToast", "act", "Landroid/app/Activity;", "resId", "isSuc", "switchSingleMask", "isMask", TbEnum.ParamKey.GID, "", "unRegisterListener", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatMsgModel extends ld8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpMessageListener A;
    public final TbPageContext<BaseFragmentActivity> a;
    public final sxb<List<ImMessageCenterShowItemData>> b;
    public final sxb<Pair<List<cm8>, List<ImMessageCenterShowItemData>>> c;
    public final Lazy d;
    public sxb<Boolean> e;
    public sxb<Object> f;
    public sxb<Boolean> g;
    public final Lazy h;
    public final BdUniqueId i;
    public final Lazy j;
    public final Lazy k;
    public final IMUserListModel l;
    public final y78 m;
    public final IMOfficialMaskModel n;
    public final Lazy o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final CustomMessageListener t;
    public final CustomMessageListener u;
    public final ce8.h v;
    public final CustomMessageListener w;
    public final CustomMessageListener x;
    public final CustomMessageListener y;
    public final CustomMessageListener z;

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ChatMsgModel chatMsgModel) {
            super(2921762);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatMsgModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getCmd() != 2921762) {
                    return;
                }
                Object data = responsedMessage.getData();
                if (data != null) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) data;
                    if (this.a.A().getData().contains(imMessageCenterShowItemData)) {
                        imMessageCenterShowItemData.setGroupDelete(true);
                        ua8.b().e(Long.valueOf(vg.g(imMessageCenterShowItemData.getFriendId(), 0L)), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendBjhAvatar(), imMessageCenterShowItemData.getServerTime());
                        this.a.A().getData().remove(imMessageCenterShowItemData);
                        this.a.b.onNext(this.a.A().getData());
                        this.a.x().T(vg.g(imMessageCenterShowItemData.getFriendId(), 0L));
                        this.a.V(null, imMessageCenterShowItemData, 3);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.data.ImMessageCenterShowItemData");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ChatMsgModel chatMsgModel) {
            super(2921691);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatMsgModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getCmd() == 2921691 && (responsedMessage.getData() instanceof String)) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        this.a.A().queryMarkTopStatus((String) data);
                        this.a.A().sortList();
                        this.a.b.onNext(this.a.A().getData());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ChatMsgModel chatMsgModel) {
            super(0, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatMsgModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.getCmd() == 2016002) {
                    if (!(msg instanceof MemoryInitCompleteMessage)) {
                        return;
                    }
                    this.a.P((MemoryInitCompleteMessage) msg);
                } else if (msg.getCmd() == 2016004 && this.a.s) {
                    if (!(msg instanceof MemoryChangedMessage)) {
                        return;
                    }
                    this.a.O((MemoryChangedMessage) msg);
                } else if (msg.getCmd() == 2016007 && this.a.s) {
                    if (!(msg instanceof ResponsedMemoryListMessage)) {
                        return;
                    }
                    this.a.R((ResponsedMemoryListMessage) msg);
                    this.a.C().onNext(Boolean.FALSE);
                    this.a.v();
                } else if (msg.getCmd() == 2016001 && this.a.s) {
                    this.a.A().setData(null, this.a.m);
                } else if (msg.getCmd() == 2016010 && this.a.s) {
                    this.a.B().onNext(null);
                } else if (msg.getCmd() == 2016011 && this.a.s) {
                    this.a.B().onNext(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ChatMsgModel chatMsgModel) {
            super(2921726);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatMsgModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.getCmd() == 2921726) {
                    this.a.t(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ChatMsgModel chatMsgModel) {
            super(2001120);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatMsgModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.getCmd() != 2001120) {
                    return;
                }
                this.a.Q(msg);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f implements ce8.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgModel a;

        public f(ChatMsgModel chatMsgModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatMsgModel;
        }

        @Override // com.baidu.tieba.ce8.h
        public void b(List<? extends ImMessageCenterPojo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.a.A().updateGroupchatList(list, this.a.m);
            this.a.V(list, null, 1);
        }

        @Override // com.baidu.tieba.ce8.h
        public void a(List<? extends ImMessageCenterPojo> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    arrayList.addAll(list);
                }
                if (z) {
                    if ((!this.a.F().isEmpty()) && !ListUtils.isEmpty(this.a.F())) {
                        arrayList.addAll(this.a.F());
                    }
                    this.a.V(arrayList, null, 1);
                    this.a.A().setData(arrayList, this.a.m);
                    return;
                }
                if ((!this.a.F().isEmpty()) && !ListUtils.isEmpty(this.a.F())) {
                    ChatMsgModel chatMsgModel = this.a;
                    chatMsgModel.V(chatMsgModel.F(), null, 1);
                }
                this.a.A().setData(this.a.F(), this.a.m);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ChatMsgModel chatMsgModel) {
            super(2921784);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatMsgModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (this.a.q && responsedMessage.getCmd() == 2921784) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        String str = (String) data;
                        ImMessageCenterShowItemData removeItemByRoomId = this.a.A().getRemoveItemByRoomId(str);
                        if (removeItemByRoomId != null && this.a.A().getData().contains(removeItemByRoomId)) {
                            this.a.A().getData().remove(removeItemByRoomId);
                            this.a.b.onNext(this.a.A().getData());
                            this.a.x().V(str);
                            if (!this.a.K()) {
                                this.a.x().U(null);
                            }
                            if (ListUtils.isEmpty(this.a.A().getData())) {
                                this.a.z().onNext(null);
                            }
                            this.a.x().T(vg.g(removeItemByRoomId.getFriendId(), 0L));
                            this.a.V(null, removeItemByRoomId, 3);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class h extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ChatMsgModel chatMsgModel) {
            super(CmdConfigHttp.CMD_GET_USER_LIST);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatMsgModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage responsedMessage) {
            IMUserListHttpResponseMsg iMUserListHttpResponseMsg;
            HashMap<String, ImMessageCenterPojo> hashMap;
            ImMessageCenterPojo imMessageCenterPojo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if ((responsedMessage instanceof IMUserListHttpResponseMsg) && !ListUtils.isEmpty(this.a.A().getData()) && (hashMap = (iMUserListHttpResponseMsg = (IMUserListHttpResponseMsg) responsedMessage).changedList) != null) {
                    Intrinsics.checkNotNullExpressionValue(hashMap, "responsedMessage.changedList");
                    if (!hashMap.isEmpty()) {
                        for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.a.A().getData()) {
                            if (imMessageCenterShowItemData != null && iMUserListHttpResponseMsg.changedList.containsKey(imMessageCenterShowItemData.getFriendId()) && (imMessageCenterPojo = iMUserListHttpResponseMsg.changedList.get(imMessageCenterShowItemData.getFriendId())) != null) {
                                imMessageCenterShowItemData.setFriendNameShow(imMessageCenterPojo.getNameShow());
                                imMessageCenterShowItemData.setRelation(imMessageCenterPojo.getIsFriend());
                                imMessageCenterShowItemData.setUserExtraData(imMessageCenterPojo.getImUserExtraData());
                            }
                        }
                        this.a.z().onNext(null);
                    }
                }
            }
        }
    }

    public ChatMsgModel(TbPageContext<BaseFragmentActivity> pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.a = pageContext;
        sxb<List<ImMessageCenterShowItemData>> O = sxb.O();
        Intrinsics.checkNotNullExpressionValue(O, "create()");
        this.b = O;
        sxb<Pair<List<cm8>, List<ImMessageCenterShowItemData>>> O2 = sxb.O();
        Intrinsics.checkNotNullExpressionValue(O2, "create()");
        this.c = O2;
        this.d = LazyKt__LazyJVMKt.lazy(ChatMsgModel$mAnswerVisibleBs$2.INSTANCE);
        sxb<Boolean> P = sxb.P(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(P, "create(false)");
        this.e = P;
        sxb<Object> P2 = sxb.P(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(P2, "create(false)");
        this.f = P2;
        sxb<Boolean> P3 = sxb.P(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(P3, "create(false)");
        this.g = P3;
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<ce8>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel$dispatcher$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMsgModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* loaded from: classes6.dex */
            public static final class a implements eo5 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgModel a;

                public a(ChatMsgModel chatMsgModel) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {chatMsgModel};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = chatMsgModel;
                }

                public static final void b(ChatMsgModel this$0) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.W(this$0.E().getPageActivity(), R.string.obfuscated_res_0x7f0f0c9e, false);
                    }
                }

                @Override // com.baidu.tieba.eo5
                public void a(int i, long j, List<Long> roomIdList, int i2, String errMsg) {
                    boolean z;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), roomIdList, Integer.valueOf(i2), errMsg}) == null) {
                        Intrinsics.checkNotNullParameter(roomIdList, "roomIdList");
                        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                        z = this.a.p;
                        if (z && i2 != 0) {
                            final ChatMsgModel chatMsgModel = this.a;
                            ch.g(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001f: INVOKE  
                                  (wrap: java.lang.Runnable : 0x001c: CONSTRUCTOR  (r6v1 java.lang.Runnable A[REMOVE]) = (r5v5 'chatMsgModel' com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel A[DONT_INLINE]) call: com.baidu.tieba.sm8.<init>(com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel):void type: CONSTRUCTOR)
                                 type: STATIC call: com.baidu.tieba.ch.g(java.lang.Runnable):void in method: com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel$dispatcher$2.a.a(int, long, java.util.List<java.lang.Long>, int, java.lang.String):void, file: classes6.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.baidu.tieba.sm8, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                                	... 31 more
                                */
                            /*
                                this = this;
                                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel$dispatcher$2.a.$ic
                                if (r0 != 0) goto L23
                            L4:
                                java.lang.String r5 = "roomIdList"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r5)
                                java.lang.String r5 = "errMsg"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r5)
                                com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel r5 = r4.a
                                boolean r5 = com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel.n(r5)
                                if (r5 == 0) goto L22
                                if (r9 == 0) goto L22
                                com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel r5 = r4.a
                                com.baidu.tieba.sm8 r6 = new com.baidu.tieba.sm8
                                r6.<init>(r5)
                                com.baidu.tieba.ch.g(r6)
                            L22:
                                return
                            L23:
                                r3 = 5
                                java.lang.Object[] r3 = new java.lang.Object[r3]
                                r1 = 0
                                java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
                                r3[r1] = r2
                                r1 = 1
                                java.lang.Long r2 = java.lang.Long.valueOf(r6)
                                r3[r1] = r2
                                r1 = 2
                                r3[r1] = r8
                                r1 = 3
                                java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
                                r3[r1] = r2
                                r1 = 4
                                r3[r1] = r10
                                r1 = 1048576(0x100000, float:1.469368E-39)
                                r2 = r4
                                com.baidu.titan.sdk.runtime.InterceptResult r0 = r0.invokeCommon(r1, r2, r3)
                                if (r0 == 0) goto L4
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel$dispatcher$2.a.a(int, long, java.util.List, int, java.lang.String):void");
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ce8 invoke() {
                        InterceptResult invokeV;
                        ce8.h hVar;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            TbPageContext<BaseFragmentActivity> E = this.this$0.E();
                            hVar = this.this$0.v;
                            ce8 ce8Var = new ce8(E, hVar);
                            ce8Var.r(new a(this.this$0));
                            return ce8Var;
                        }
                        return (ce8) invokeV.objValue;
                    }
                });
                BdUniqueId gen = BdUniqueId.gen();
                Intrinsics.checkNotNullExpressionValue(gen, "gen()");
                this.i = gen;
                this.j = LazyKt__LazyJVMKt.lazy(ChatMsgModel$mModel$2.INSTANCE);
                this.k = LazyKt__LazyJVMKt.lazy(ChatMsgModel$notifyTabModel$2.INSTANCE);
                this.m = new y78() { // from class: com.baidu.tieba.qm8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.y78
                    public final void onComplete() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ChatMsgModel.L(ChatMsgModel.this);
                        }
                    }
                };
                this.o = LazyKt__LazyJVMKt.lazy(ChatMsgModel$personCacheList$2.INSTANCE);
                this.r = true;
                this.t = new e(this);
                this.u = new d(this);
                this.v = new f(this);
                this.w = new c(this);
                this.x = new g(this);
                this.y = new a(this);
                this.z = new b(this);
                this.A = new h(this);
                this.c.onNext(new Pair<>(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList()));
                this.l = new IMUserListModel(null, this.i);
                this.n = new IMOfficialMaskModel();
                MainTabChangedMonitor.c.a().d().g().F(new ltb() { // from class: com.baidu.tieba.rm8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ltb
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            ChatMsgModel.a(ChatMsgModel.this, (Integer) obj);
                        }
                    }
                });
            }

            public static final void L(ChatMsgModel this$0) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    this$0.g.onNext(null);
                }
            }

            public final void P(MemoryInitCompleteMessage memoryInitCompleteMessage) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048590, this, memoryInitCompleteMessage) == null) {
                    boolean areEqual = Intrinsics.areEqual(memoryInitCompleteMessage.getData(), Boolean.TRUE);
                    this.s = areEqual;
                    if (areEqual) {
                        MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
                        H();
                    }
                }
            }

            public final void Q(ResponsedMessage<?> responsedMessage) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048591, this, responsedMessage) != null) || responsedMessage == null) {
                    return;
                }
                if (!(responsedMessage instanceof NewsNotifyMessage)) {
                    BdLog.e("transform error");
                } else {
                    S(false);
                }
            }

            public final void t(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
                    y().onNext(Boolean.valueOf(z));
                }
            }

            public static final void a(ChatMsgModel this$0, Integer num) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(65538, null, this$0, num) == null) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    if (num != null && num.intValue() == 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this$0.q = z;
                }
            }

            public final void X(boolean z, String gid) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048598, this, z, gid) == null) {
                    Intrinsics.checkNotNullParameter(gid, "gid");
                    this.n.U(z, gid);
                }
            }

            public final void u(ImMessageCenterShowItemData data, z78 iProcess) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048601, this, data, iProcess) == null) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(iProcess, "iProcess");
                    A().asyncDeleteItem(data, iProcess);
                }
            }

            public final MsgChatTabModel A() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return (MsgChatTabModel) this.j.getValue();
                }
                return (MsgChatTabModel) invokeV.objValue;
            }

            public final sxb<Object> B() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.f;
                }
                return (sxb) invokeV.objValue;
            }

            public final sxb<Boolean> C() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.e;
                }
                return (sxb) invokeV.objValue;
            }

            public final MsgNotifyTabModel D() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    return (MsgNotifyTabModel) this.k.getValue();
                }
                return (MsgNotifyTabModel) invokeV.objValue;
            }

            public final TbPageContext<BaseFragmentActivity> E() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    return this.a;
                }
                return (TbPageContext) invokeV.objValue;
            }

            public final List<ImMessageCenterPojo> F() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    return (List) this.o.getValue();
                }
                return (List) invokeV.objValue;
            }

            public final ce8 G() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    return x();
                }
                return (ce8) invokeV.objValue;
            }

            public final void H() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
                    return;
                }
                x().S();
            }

            public final boolean K() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    return !ListUtils.isEmpty(x().L(0));
                }
                return invokeV.booleanValue;
            }

            public final void M() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                    this.p = false;
                }
            }

            public final void N() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                    this.p = true;
                }
            }

            public final void T() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
                    this.l.request(true, A().getUids());
                }
            }

            public final void v() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.r) {
                    this.l.request(false, A().getUids());
                    this.r = false;
                }
            }

            public final xsb<List<ImMessageCenterShowItemData>> w() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                    xsb<List<ImMessageCenterShowItemData>> s = this.b.w().a().s(htb.b());
                    Intrinsics.checkNotNullExpressionValue(s, "mChatMsgDataBs.onBackpre…dSchedulers.mainThread())");
                    return s;
                }
                return (xsb) invokeV.objValue;
            }

            public final ce8 x() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                    return (ce8) this.h.getValue();
                }
                return (ce8) invokeV.objValue;
            }

            public final sxb<Boolean> y() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                    Object value = this.d.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "<get-mAnswerVisibleBs>(...)");
                    return (sxb) value;
                }
                return (sxb) invokeV.objValue;
            }

            public final sxb<Boolean> z() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                    return this.g;
                }
                return (sxb) invokeV.objValue;
            }

            public final <T extends ImMessageCenterModel> T I(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                    if (i != 1) {
                        if (i == 2) {
                            return A();
                        }
                        throw new IllegalStateException("消息Tab改版未知的 tab type: " + i);
                    }
                    return D();
                }
                return (T) invokeI.objValue;
            }

            public final void J(List<ImMessageCenterPojo> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
                    D().setData(list, this.m);
                    sxb<Pair<List<cm8>, List<ImMessageCenterShowItemData>>> sxbVar = this.c;
                    sxbVar.onNext(new Pair<>(sxbVar.R().getFirst(), D().getData()));
                }
            }

            public final void O(MemoryChangedMessage memoryChangedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048589, this, memoryChangedMessage) == null) {
                    ImMessageCenterPojo data = memoryChangedMessage.getData();
                    if (memoryChangedMessage.getType() == 1) {
                        A().insertOrUpdate(data, this.m);
                        D().insertOrUpdate(data, this.m);
                    } else if (memoryChangedMessage.getType() == 2) {
                        A().remove(data, this.m);
                        D().remove(data, this.m);
                    }
                    this.b.onNext(A().getData());
                    sxb<Pair<List<cm8>, List<ImMessageCenterShowItemData>>> sxbVar = this.c;
                    sxbVar.onNext(new Pair<>(sxbVar.R().getFirst(), D().getData()));
                }
            }

            public final void R(ResponsedMemoryListMessage responsedMemoryListMessage) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048592, this, responsedMemoryListMessage) == null) {
                    F().clear();
                    List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
                    if (data != null) {
                        F().addAll(data);
                    }
                    J(F());
                    if (ListUtils.isEmpty(A().getData())) {
                        x().R();
                    }
                    if (responsedMemoryListMessage.getType() == 1 && this.p) {
                        H();
                    }
                }
            }

            public final void S(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
                    if (z && !tm6.a(A().getData())) {
                        A().sortList();
                    }
                    this.b.onNext(A().getData());
                    sxb<Pair<List<cm8>, List<ImMessageCenterShowItemData>>> sxbVar = this.c;
                    sxbVar.onNext(new Pair<>(sxbVar.R().getFirst(), D().getData()));
                }
            }

            public final void U() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
                    MessageManager.getInstance().registerListener(2016004, this.w);
                    MessageManager.getInstance().registerListener(2016001, this.w);
                    MessageManager.getInstance().registerListener(2016010, this.w);
                    MessageManager.getInstance().registerListener(2016007, this.w);
                    MessageManager.getInstance().registerListener(2016011, this.w);
                    MessageManager.getInstance().registerListener(2016002, this.w);
                    MessageManager.getInstance().registerListener(this.t);
                    MessageManager.getInstance().registerListener(this.x);
                    MessageManager.getInstance().registerListener(this.y);
                    MessageManager.getInstance().registerListener(this.z);
                    MessageManager.getInstance().registerListener(this.A);
                    MessageManager.getInstance().registerListener(this.u);
                }
            }

            public final void V(List<? extends ImMessageCenterPojo> list, ImMessageCenterShowItemData imMessageCenterShowItemData, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048596, this, list, imMessageCenterShowItemData, i) == null) {
                    ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage = new ResponsedGroupChatListCompleteMessage();
                    if (i != 1) {
                        String str = null;
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 5) {
                                    responsedGroupChatListCompleteMessage.setType(5);
                                }
                            } else {
                                responsedGroupChatListCompleteMessage.setType(3);
                                if (imMessageCenterShowItemData != null) {
                                    str = imMessageCenterShowItemData.getFriendId();
                                }
                                responsedGroupChatListCompleteMessage.setGid(str);
                            }
                        } else {
                            responsedGroupChatListCompleteMessage.setType(2);
                            if (imMessageCenterShowItemData != null) {
                                str = imMessageCenterShowItemData.getFriendId();
                            }
                            responsedGroupChatListCompleteMessage.setGid(str);
                        }
                    } else {
                        responsedGroupChatListCompleteMessage.setType(1);
                        responsedGroupChatListCompleteMessage.setListInfo(list);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(responsedGroupChatListCompleteMessage);
                }
            }

            public final void W(Activity activity, @StringRes int i, boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && activity != null) {
                    BdTopToast bdTopToast = new BdTopToast(activity);
                    bdTopToast.g(activity.getString(i));
                    bdTopToast.h(z);
                    bdTopToast.i((ViewGroup) activity.findViewById(16908290));
                }
            }

            public final void Y() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
                    MessageManager.getInstance().unRegisterListener(this.t);
                    MessageManager.getInstance().unRegisterListener(this.w);
                    MessageManager.getInstance().unRegisterListener(this.x);
                    MessageManager.getInstance().unRegisterListener(this.y);
                    MessageManager.getInstance().unRegisterListener(this.z);
                    MessageManager.getInstance().unRegisterListener(this.A);
                    MessageManager.getInstance().unRegisterListener(this.u);
                    x().o();
                }
            }
        }
