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
import com.baidu.tieba.dh;
import com.baidu.tieba.dp5;
import com.baidu.tieba.e2c;
import com.baidu.tieba.h29;
import com.baidu.tieba.hi8;
import com.baidu.tieba.i2c;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedGroupChatListCompleteMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.tieba.immessagecenter.arch.utils.IMLog;
import com.baidu.tieba.immessagecenter.im.model.IMOfficialMaskModel;
import com.baidu.tieba.immessagecenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.immessagecenter.im.model.MsgChatTabModel;
import com.baidu.tieba.immessagecenter.im.model.MsgNotifyTabModel;
import com.baidu.tieba.immessagecenter.msgtab.obs.MainTabChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel;
import com.baidu.tieba.p6c;
import com.baidu.tieba.qf8;
import com.baidu.tieba.sr8;
import com.baidu.tieba.tc8;
import com.baidu.tieba.u1c;
import com.baidu.tieba.uc8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wg;
import com.baidu.tieba.xn6;
import com.baidu.tieba.yi8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0014J\b\u0010M\u001a\u00020\u0007H\u0002J\u0016\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020 2\u0006\u0010P\u001a\u00020QJ\u0006\u0010R\u001a\u00020KJ\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00140TJ\u0012\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0TJ$\u0010V\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f050TJ\u0006\u0010W\u001a\u00020\u0007J\b\u0010X\u001a\u00020KH\u0002J\u001d\u0010Y\u001a\u0002HZ\"\b\b\u0000\u0010Z*\u00020[2\u0006\u0010\\\u001a\u00020]¢\u0006\u0002\u0010^J\u0016\u0010_\u001a\u00020K2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010a\u001a\u00020\u0014H\u0002J.\u0010b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002J\u0016\u0010e\u001a\u00020K2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u001fJ\u0006\u0010g\u001a\u00020KJ\u0006\u0010h\u001a\u00020KJ\u0006\u0010i\u001a\u00020KJ\u0010\u0010j\u001a\u00020K2\u0006\u0010k\u001a\u00020lH\u0002J\u0010\u0010m\u001a\u00020K2\u0006\u0010n\u001a\u00020oH\u0002J\u0016\u0010p\u001a\u00020K2\f\u0010q\u001a\b\u0012\u0002\b\u0003\u0018\u00010rH\u0002J\u0010\u0010s\u001a\u00020K2\u0006\u0010t\u001a\u00020uH\u0002J\u000e\u0010v\u001a\u00020K2\u0006\u0010w\u001a\u00020\u0014J\u0006\u0010x\u001a\u00020KJ\u0006\u0010y\u001a\u00020KJ(\u0010z\u001a\u00020K2\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001f2\b\u0010O\u001a\u0004\u0018\u00010 2\u0006\u0010\\\u001a\u00020]J$\u0010{\u001a\u00020K2\b\u0010|\u001a\u0004\u0018\u00010}2\b\b\u0001\u0010~\u001a\u00020]2\u0006\u0010\u007f\u001a\u00020\u0014H\u0002J\u001a\u0010\u0080\u0001\u001a\u00020K2\u0007\u0010\u0081\u0001\u001a\u00020\u00142\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001J\u0007\u0010\u0084\u0001\u001a\u00020KR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000e\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R*\u00102\u001a\b\u0012\u0004\u0012\u0002010\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002010\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001cR,\u00104\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f050\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R*\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001cR\u000e\u0010;\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u000e\u001a\u0004\bA\u0010BR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010\u0005R!\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u000e\u001a\u0004\bH\u0010\f¨\u0006\u0085\u0001"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/model/ChatMsgModel;", "Lcom/baidu/tieba/immessagecenter/arch/model/BaseModel;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "(Lcom/baidu/tbadk/TbPageContext;)V", "dispatcher", "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/ChatTabSubscribeGroupMessageDispatcher;", "groupCacheList", "", "Lcom/baidu/tieba/im/db/pojo/ImMessageCenterPojo;", "getGroupCacheList", "()Ljava/util/List;", "groupCacheList$delegate", "Lkotlin/Lazy;", "imOfficialMaskModel", "Lcom/baidu/tieba/immessagecenter/im/model/IMOfficialMaskModel;", "imUserListModel", "Lcom/baidu/tieba/im/model/IMUserListModel;", "isCurrentChatTab", "", "isInit", "isMsgTabPrimary", "mAgainRequestGroupListListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mAnswerVisibleBs", "Lrx/subjects/BehaviorSubject;", "getMAnswerVisibleBs", "()Lrx/subjects/BehaviorSubject;", "mAnswerVisibleBs$delegate", "mChatMsgDataBs", "", "Lcom/baidu/tbadk/core/data/ImMessageCenterShowItemData;", "mCompleteProcess", "Lcom/baidu/tieba/im/chat/notify/ICompleteProcess;", "<set-?>", "mCompleteProcessBs", "getMCompleteProcessBs", "mId", "Lcom/baidu/adp/BdUniqueId;", "mMarkTopListener", "mMemoryListener", "mModel", "Lcom/baidu/tieba/immessagecenter/im/model/MsgChatTabModel;", "getMModel", "()Lcom/baidu/tieba/immessagecenter/im/model/MsgChatTabModel;", "mModel$delegate", "mMsgInvitationListener", "mNewMessageListener", "", "mNotifyAdapterBs", "getMNotifyAdapterBs", "mNotifyMsgDataBs", "Lkotlin/Pair;", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgNotifyData;", "mOnChatGroupCallback", "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/ChatTabSubscribeGroupMessageDispatcher$OnChatGroupMessageCallback;", "mRefreshStatusBs", "getMRefreshStatusBs", "mRemoveListItemListener", "mUserListMessageListener", "Lcom/baidu/adp/framework/listener/HttpMessageListener;", "memoryInitCompleted", "notifyTabModel", "Lcom/baidu/tieba/immessagecenter/im/model/MsgNotifyTabModel;", "getNotifyTabModel", "()Lcom/baidu/tieba/immessagecenter/im/model/MsgNotifyTabModel;", "notifyTabModel$delegate", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "setPageContext", "personCacheList", "getPersonCacheList", "personCacheList$delegate", "answerVisibleChange", "", "boolean", "createDispatcher", "deleteItem", "data", "iProcess", "Lcom/baidu/tieba/im/chat/notify/IProcess;", "forceRefreshUserListWhenInit", "getAnswerVisibleBs", "Lrx/Observable;", "getChatMsgDataObs", "getNotifyMsgDataBs", "getSocketDispatcher", "getSubscribeRequest", "getTabModel", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/tieba/immessagecenter/im/model/ImMessageCenterModel;", "type", "", "(I)Lcom/baidu/tieba/immessagecenter/im/model/ImMessageCenterModel;", "initNotifyModel", "list", "isHaveLocalGroupCache", "mergeChatTabData", "groupList", "personList", "notifyDataSetChanged", "msgList", MissionEvent.MESSAGE_DESTROY, "onMsgTabPause", "onMsgTabPrimary", "processMemoryChanged", "changeMessage", "Lcom/baidu/tieba/im/message/MemoryChangedMessage;", "processMemoryInitComplete", "message", "Lcom/baidu/tieba/im/message/MemoryInitCompleteMessage;", "processNotify", "msg", "Lcom/baidu/adp/framework/message/ResponsedMessage;", "processResponseMemoryList", "resMessage", "Lcom/baidu/tieba/im/message/ResponsedMemoryListMessage;", "refreshMsg", "isSort", "refreshUserList", "registerListener", "sendChatTabRedTipUpdateMsg", "showTopToast", "act", "Landroid/app/Activity;", "resId", "isSuc", "switchSingleMask", "isMask", TbEnum.ParamKey.GID, "", "unRegisterListener", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatMsgModel extends hi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public final HttpMessageListener B;
    public TbPageContext<BaseFragmentActivity> a;
    public final p6c<List<ImMessageCenterShowItemData>> b;
    public final p6c<Pair<List<sr8>, List<ImMessageCenterShowItemData>>> c;
    public final Lazy d;
    public p6c<Boolean> e;
    public p6c<Object> f;
    public p6c<Boolean> g;
    public yi8 h;
    public final BdUniqueId i;
    public final Lazy j;
    public final Lazy k;
    public final IMUserListModel l;
    public final tc8 m;
    public final IMOfficialMaskModel n;
    public final Lazy o;
    public final Lazy p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public final CustomMessageListener u;
    public final CustomMessageListener v;
    public final yi8.n w;
    public final CustomMessageListener x;
    public final CustomMessageListener y;
    public final CustomMessageListener z;

    /* loaded from: classes6.dex */
    public static final class a implements dp5 {
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
            Activity activity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                TbPageContext<BaseFragmentActivity> G = this$0.G();
                if (G != null) {
                    activity = G.getPageActivity();
                } else {
                    activity = null;
                }
                this$0.Z(activity, R.string.obfuscated_res_0x7f0f0ca9, false);
            }
        }

        @Override // com.baidu.tieba.dp5
        public void a(int i, long j, List<Long> roomIdList, int i2, String errMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), roomIdList, Integer.valueOf(i2), errMsg}) == null) {
                Intrinsics.checkNotNullParameter(roomIdList, "roomIdList");
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                if (this.a.q && this.a.r && i2 != 0) {
                    final ChatMsgModel chatMsgModel = this.a;
                    dh.g(new Runnable() { // from class: com.baidu.tieba.rs8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ChatMsgModel.a.b(ChatMsgModel.this);
                            }
                        }
                    });
                }
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
                    if (this.a.C().getData().contains(imMessageCenterShowItemData)) {
                        imMessageCenterShowItemData.setGroupDelete(true);
                        qf8.b().e(Long.valueOf(wg.g(imMessageCenterShowItemData.getFriendId(), 0L)), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendBjhAvatar(), imMessageCenterShowItemData.getServerTime());
                        this.a.C().getData().remove(imMessageCenterShowItemData);
                        this.a.b.onNext(this.a.C().getData());
                        yi8 yi8Var = this.a.h;
                        if (yi8Var != null) {
                            yi8Var.W(wg.g(imMessageCenterShowItemData.getFriendId(), 0L));
                        }
                        this.a.Y(null, imMessageCenterShowItemData, 3);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.data.ImMessageCenterShowItemData");
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
                        this.a.C().queryMarkTopStatus((String) data);
                        this.a.C().sortList();
                        this.a.b.onNext(this.a.C().getData());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
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
                    this.a.S((MemoryInitCompleteMessage) msg);
                } else if (msg.getCmd() == 2016004 && this.a.t) {
                    if (!(msg instanceof MemoryChangedMessage)) {
                        return;
                    }
                    this.a.R((MemoryChangedMessage) msg);
                } else if (msg.getCmd() == 2016007 && this.a.t) {
                    if (!(msg instanceof ResponsedMemoryListMessage)) {
                        return;
                    }
                    this.a.U((ResponsedMemoryListMessage) msg);
                    this.a.E().onNext(Boolean.FALSE);
                    this.a.x();
                } else if (msg.getCmd() == 2016001 && this.a.t) {
                    h29 iMLog = IMLog.getInstance();
                    iMLog.c("ChatMsgModel", "mMemoryListener <内存被清空前> 列表展示数据: " + ListUtils.getCount(this.a.C().getData()));
                    this.a.C().setData(null, this.a.m);
                    h29 iMLog2 = IMLog.getInstance();
                    iMLog2.c("ChatMsgModel", "mMemoryListener <内存被清空后> 列表展示数据: " + ListUtils.getCount(this.a.C().getData()));
                } else if (msg.getCmd() == 2016010 && this.a.t) {
                    this.a.D().onNext(null);
                } else if (msg.getCmd() == 2016011 && this.a.t) {
                    this.a.D().onNext(null);
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
                    this.a.u(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ChatMsgModel chatMsgModel) {
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
                this.a.T(msg);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements yi8.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgModel a;

        public g(ChatMsgModel chatMsgModel) {
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

        @Override // com.baidu.tieba.yi8.n
        public void b(List<? extends ImMessageCenterPojo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.a.C().updateGroupchatList(list, this.a.m);
            this.a.Y(list, null, 1);
        }

        @Override // com.baidu.tieba.yi8.n
        public void a(List<? extends ImMessageCenterPojo> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) {
                if (list != null && ListUtils.isNotEmpty(list)) {
                    this.a.z().clear();
                    this.a.z().addAll(list);
                    ChatMsgModel chatMsgModel = this.a;
                    List<ImMessageCenterPojo> O = chatMsgModel.O(chatMsgModel.z(), this.a.H());
                    this.a.Y(O, null, 1);
                    this.a.C().setData(O, this.a.m);
                    h29 iMLog = IMLog.getInstance();
                    iMLog.c("ChatMsgModel", "mOnChatGroupCallback <hasGroupList = true> 群聊列表数据: " + ListUtils.getCount(list) + " || 私聊列表数据: " + ListUtils.getCount(this.a.H()));
                    return;
                }
                ChatMsgModel chatMsgModel2 = this.a;
                List<ImMessageCenterPojo> O2 = chatMsgModel2.O(chatMsgModel2.z(), this.a.H());
                this.a.Y(O2, null, 1);
                this.a.C().setData(O2, this.a.m);
                h29 iMLog2 = IMLog.getInstance();
                iMLog2.c("ChatMsgModel", "mOnChatGroupCallback <hasGroupList = false> 私聊列表数据: " + ListUtils.getCount(this.a.H()) + " || 群聊内存数据: " + ListUtils.getCount(this.a.z()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ChatMsgModel chatMsgModel) {
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

        public static final void a(ChatMsgModel this$0) {
            yi8 yi8Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (!this$0.M() && (yi8Var = this$0.h) != null) {
                    yi8Var.X(null);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (this.a.r && responsedMessage.getCmd() == 2921784) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        String str = (String) data;
                        ImMessageCenterShowItemData removeItemByRoomId = this.a.C().getRemoveItemByRoomId(str);
                        if (removeItemByRoomId != null && this.a.C().getData().contains(removeItemByRoomId)) {
                            this.a.C().getData().remove(removeItemByRoomId);
                            this.a.b.onNext(this.a.C().getData());
                            yi8 yi8Var = this.a.h;
                            if (yi8Var != null) {
                                yi8Var.Y(str);
                            }
                            final ChatMsgModel chatMsgModel = this.a;
                            dh.e(new Runnable() { // from class: com.baidu.tieba.ss8
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        ChatMsgModel.h.a(ChatMsgModel.this);
                                    }
                                }
                            });
                            if (ListUtils.isEmpty(this.a.C().getData())) {
                                this.a.B().onNext(null);
                            }
                            yi8 yi8Var2 = this.a.h;
                            if (yi8Var2 != null) {
                                yi8Var2.W(wg.g(removeItemByRoomId.getFriendId(), 0L));
                            }
                            this.a.Y(null, removeItemByRoomId, 3);
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
    public static final class i extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ChatMsgModel chatMsgModel) {
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
                if ((responsedMessage instanceof IMUserListHttpResponseMsg) && !ListUtils.isEmpty(this.a.C().getData()) && (hashMap = (iMUserListHttpResponseMsg = (IMUserListHttpResponseMsg) responsedMessage).changedList) != null) {
                    Intrinsics.checkNotNullExpressionValue(hashMap, "responsedMessage.changedList");
                    if (!hashMap.isEmpty()) {
                        for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.a.C().getData()) {
                            if (imMessageCenterShowItemData != null && iMUserListHttpResponseMsg.changedList.containsKey(imMessageCenterShowItemData.getFriendId()) && (imMessageCenterPojo = iMUserListHttpResponseMsg.changedList.get(imMessageCenterShowItemData.getFriendId())) != null) {
                                imMessageCenterShowItemData.setFriendNameShow(imMessageCenterPojo.getNameShow());
                                imMessageCenterShowItemData.setRelation(imMessageCenterPojo.getIsFriend());
                                imMessageCenterShowItemData.setUserExtraData(imMessageCenterPojo.getImUserExtraData());
                            }
                        }
                        this.a.B().onNext(null);
                    }
                }
            }
        }
    }

    public ChatMsgModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        p6c<List<ImMessageCenterShowItemData>> Q = p6c.Q();
        Intrinsics.checkNotNullExpressionValue(Q, "create()");
        this.b = Q;
        p6c<Pair<List<sr8>, List<ImMessageCenterShowItemData>>> Q2 = p6c.Q();
        Intrinsics.checkNotNullExpressionValue(Q2, "create()");
        this.c = Q2;
        this.d = LazyKt__LazyJVMKt.lazy(ChatMsgModel$mAnswerVisibleBs$2.INSTANCE);
        p6c<Boolean> R = p6c.R(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(R, "create(false)");
        this.e = R;
        p6c<Object> R2 = p6c.R(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(R2, "create(false)");
        this.f = R2;
        p6c<Boolean> R3 = p6c.R(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(R3, "create(false)");
        this.g = R3;
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        this.i = gen;
        this.j = LazyKt__LazyJVMKt.lazy(ChatMsgModel$mModel$2.INSTANCE);
        this.k = LazyKt__LazyJVMKt.lazy(ChatMsgModel$notifyTabModel$2.INSTANCE);
        this.m = new tc8() { // from class: com.baidu.tieba.ts8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.tc8
            public final void onComplete() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ChatMsgModel.N(ChatMsgModel.this);
                }
            }
        };
        this.o = LazyKt__LazyJVMKt.lazy(ChatMsgModel$personCacheList$2.INSTANCE);
        this.p = LazyKt__LazyJVMKt.lazy(ChatMsgModel$groupCacheList$2.INSTANCE);
        this.s = true;
        this.u = new f(this);
        this.v = new e(this);
        this.w = new g(this);
        this.x = new d(this);
        this.y = new h(this);
        this.z = new b(this);
        this.A = new c(this);
        this.B = new i(this);
        this.h = v();
        this.c.onNext(new Pair<>(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList()));
        this.l = new IMUserListModel(null, this.i);
        this.n = new IMOfficialMaskModel();
        MainTabChangedMonitor.c.a().d().g().H(new i2c() { // from class: com.baidu.tieba.qs8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.i2c
            public final void call(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    ChatMsgModel.a(ChatMsgModel.this, (Integer) obj);
                }
            }
        });
    }

    public static final void N(ChatMsgModel this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.g.onNext(null);
        }
    }

    public final void S(MemoryInitCompleteMessage memoryInitCompleteMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, memoryInitCompleteMessage) == null) {
            boolean areEqual = Intrinsics.areEqual(memoryInitCompleteMessage.getData(), Boolean.TRUE);
            this.t = areEqual;
            if (areEqual) {
                MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
                J();
            }
        }
    }

    public final void T(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, responsedMessage) != null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
        } else {
            V(false);
        }
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            A().onNext(Boolean.valueOf(z));
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
            this$0.r = z;
        }
    }

    public final void a0(boolean z, String gid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048601, this, z, gid) == null) {
            Intrinsics.checkNotNullParameter(gid, "gid");
            this.n.V(z, gid);
        }
    }

    public final void w(ImMessageCenterShowItemData data, uc8 iProcess) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, data, iProcess) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(iProcess, "iProcess");
            C().asyncDeleteItem(data, iProcess);
        }
    }

    public final p6c<Boolean> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Object value = this.d.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mAnswerVisibleBs>(...)");
            return (p6c) value;
        }
        return (p6c) invokeV.objValue;
    }

    public final p6c<Boolean> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (p6c) invokeV.objValue;
    }

    public final MsgChatTabModel C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (MsgChatTabModel) this.j.getValue();
        }
        return (MsgChatTabModel) invokeV.objValue;
    }

    public final p6c<Object> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (p6c) invokeV.objValue;
    }

    public final p6c<Boolean> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (p6c) invokeV.objValue;
    }

    public final MsgNotifyTabModel F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (MsgNotifyTabModel) this.k.getValue();
        }
        return (MsgNotifyTabModel) invokeV.objValue;
    }

    public final TbPageContext<BaseFragmentActivity> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final List<ImMessageCenterPojo> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (List) this.o.getValue();
        }
        return (List) invokeV.objValue;
    }

    public final yi8 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            yi8 yi8Var = this.h;
            if (yi8Var == null) {
                yi8 v = v();
                this.h = v;
                return v;
            }
            return yi8Var;
        }
        return (yi8) invokeV.objValue;
    }

    public final void J() {
        yi8 yi8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && BdNetTypeUtil.isNetWorkAvailable() && (yi8Var = this.h) != null) {
            yi8Var.V();
        }
    }

    public final boolean M() {
        InterceptResult invokeV;
        List<Map<String, Long>> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            yi8 yi8Var = this.h;
            if (yi8Var != null) {
                list = yi8Var.O(0);
            } else {
                list = null;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.q = false;
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.q = true;
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.l.request(true, C().getUids());
        }
    }

    public final yi8 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            yi8 yi8Var = new yi8(this.a, this.w);
            yi8Var.s(new a(this));
            return yi8Var;
        }
        return (yi8) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && this.s) {
            this.l.request(false, C().getUids());
            this.s = false;
        }
    }

    public final u1c<List<ImMessageCenterShowItemData>> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            u1c<List<ImMessageCenterShowItemData>> s = this.b.w().a().s(e2c.b());
            Intrinsics.checkNotNullExpressionValue(s, "mChatMsgDataBs.onBackpre…dSchedulers.mainThread())");
            return s;
        }
        return (u1c) invokeV.objValue;
    }

    public final List<ImMessageCenterPojo> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return (List) this.p.getValue();
        }
        return (List) invokeV.objValue;
    }

    public final <T extends ImMessageCenterModel> T K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return C();
                }
                throw new IllegalStateException("消息Tab改版未知的 tab type: " + i2);
            }
            return F();
        }
        return (T) invokeI.objValue;
    }

    public final void L(List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            F().setData(list, this.m);
            p6c<Pair<List<sr8>, List<ImMessageCenterShowItemData>>> p6cVar = this.c;
            p6cVar.onNext(new Pair<>(p6cVar.T().getFirst(), F().getData()));
        }
    }

    public final List<ImMessageCenterPojo> O(List<ImMessageCenterPojo> list, List<ImMessageCenterPojo> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, list, list2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                if (!ListUtils.isNotEmpty(list)) {
                    list = null;
                }
                if (list != null) {
                    arrayList.addAll(list);
                }
            }
            if (list2 != null) {
                if (!ListUtils.isNotEmpty(list2)) {
                    list2 = null;
                }
                if (list2 != null) {
                    arrayList.addAll(list2);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public final void R(MemoryChangedMessage memoryChangedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, memoryChangedMessage) == null) {
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                C().insertOrUpdate(data, this.m);
                F().insertOrUpdate(data, this.m);
            } else if (memoryChangedMessage.getType() == 2) {
                C().remove(data, this.m);
                F().remove(data, this.m);
            }
            this.b.onNext(C().getData());
            p6c<Pair<List<sr8>, List<ImMessageCenterShowItemData>>> p6cVar = this.c;
            p6cVar.onNext(new Pair<>(p6cVar.T().getFirst(), F().getData()));
        }
    }

    public final void U(ResponsedMemoryListMessage responsedMemoryListMessage) {
        yi8 yi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, responsedMemoryListMessage) == null) {
            H().clear();
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (data != null) {
                H().addAll(data);
            }
            L(H());
            if (ListUtils.isEmpty(C().getData()) && (yi8Var = this.h) != null) {
                yi8Var.U();
            }
            if (responsedMemoryListMessage.getType() == 1 && this.q) {
                J();
            }
        }
    }

    public final void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (z && !xn6.a(C().getData())) {
                C().sortList();
            }
            this.b.onNext(C().getData());
            p6c<Pair<List<sr8>, List<ImMessageCenterShowItemData>>> p6cVar = this.c;
            p6cVar.onNext(new Pair<>(p6cVar.T().getFirst(), F().getData()));
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            MessageManager.getInstance().registerListener(2016004, this.x);
            MessageManager.getInstance().registerListener(2016001, this.x);
            MessageManager.getInstance().registerListener(2016010, this.x);
            MessageManager.getInstance().registerListener(2016007, this.x);
            MessageManager.getInstance().registerListener(2016011, this.x);
            MessageManager.getInstance().registerListener(2016002, this.x);
            MessageManager.getInstance().registerListener(this.u);
            MessageManager.getInstance().registerListener(this.y);
            MessageManager.getInstance().registerListener(this.z);
            MessageManager.getInstance().registerListener(this.A);
            MessageManager.getInstance().registerListener(this.B);
            MessageManager.getInstance().registerListener(this.v);
        }
    }

    public final void Y(List<? extends ImMessageCenterPojo> list, ImMessageCenterShowItemData imMessageCenterShowItemData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048599, this, list, imMessageCenterShowItemData, i2) == null) {
            ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage = new ResponsedGroupChatListCompleteMessage();
            if (i2 != 1) {
                String str = null;
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 5) {
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

    public final void Z(Activity activity, @StringRes int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{activity, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && activity != null) {
            BdTopToast bdTopToast = new BdTopToast(activity);
            bdTopToast.g(activity.getString(i2));
            bdTopToast.h(z);
            bdTopToast.i((ViewGroup) activity.findViewById(16908290));
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.u);
            MessageManager.getInstance().unRegisterListener(this.x);
            MessageManager.getInstance().unRegisterListener(this.y);
            MessageManager.getInstance().unRegisterListener(this.z);
            MessageManager.getInstance().unRegisterListener(this.A);
            MessageManager.getInstance().unRegisterListener(this.B);
            MessageManager.getInstance().unRegisterListener(this.v);
            yi8 yi8Var = this.h;
            if (yi8Var != null) {
                yi8Var.o();
            }
        }
    }
}
