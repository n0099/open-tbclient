package com.baidu.tieba.immessagecenter.msgtab.ui.model;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ctc;
import com.baidu.tieba.eoc;
import com.baidu.tieba.fk6;
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
import com.baidu.tieba.immessagecenter.im.model.MsgChatTabModel;
import com.baidu.tieba.immessagecenter.msgtab.obs.MainTabChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.model.ChatMsgModel;
import com.baidu.tieba.loc;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.ooc;
import com.baidu.tieba.r19;
import com.baidu.tieba.soc;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.vs8;
import com.baidu.tieba.ws8;
import com.baidu.tieba.x09;
import com.baidu.tieba.yk5;
import com.baidu.tieba.yw8;
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
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0014J\b\u0010F\u001a\u00020\u0007H\u0002J\u0016\u0010G\u001a\u00020D2\u0006\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020DJ\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00140MJ\u0012\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0MJ\u0006\u0010O\u001a\u00020+J\u0006\u0010P\u001a\u00020\u0007J\b\u0010Q\u001a\u00020DH\u0002J\b\u0010R\u001a\u00020\u0014H\u0002J.\u0010S\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002J\u0006\u0010V\u001a\u00020DJ\u0006\u0010W\u001a\u00020DJ\u0006\u0010X\u001a\u00020DJ\u0010\u0010Y\u001a\u00020D2\u0006\u0010Z\u001a\u00020[H\u0002J\u0010\u0010\\\u001a\u00020D2\u0006\u0010]\u001a\u00020^H\u0002J\u0010\u0010_\u001a\u00020D2\u0006\u0010`\u001a\u00020aH\u0002J\u000e\u0010b\u001a\u00020D2\u0006\u0010c\u001a\u00020\u0014J\u0006\u0010d\u001a\u00020DJ\u0006\u0010e\u001a\u00020DJ(\u0010f\u001a\u00020D2\u000e\u0010g\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001f2\b\u0010H\u001a\u0004\u0018\u00010 2\u0006\u0010h\u001a\u00020iJ$\u0010j\u001a\u00020D2\b\u0010k\u001a\u0004\u0018\u00010l2\b\b\u0001\u0010m\u001a\u00020i2\u0006\u0010n\u001a\u00020\u0014H\u0002J\u0016\u0010o\u001a\u00020D2\u0006\u0010p\u001a\u00020\u00142\u0006\u0010q\u001a\u00020rJ\u0006\u0010s\u001a\u00020DR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000e\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R*\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002000\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001cR\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R*\u00105\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001cR\u000e\u00107\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010\u0005R!\u0010>\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u000e\u001a\u0004\b?\u0010\fR\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/model/ChatMsgModel;", "Lcom/baidu/tieba/immessagecenter/arch/model/BaseModel;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "(Lcom/baidu/tbadk/TbPageContext;)V", "dispatcher", "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/ChatTabSubscribeGroupMessageDispatcher;", "groupCacheList", "", "Lcom/baidu/tieba/im/db/pojo/ImMessageCenterPojo;", "getGroupCacheList", "()Ljava/util/List;", "groupCacheList$delegate", "Lkotlin/Lazy;", "imOfficialMaskModel", "Lcom/baidu/tieba/immessagecenter/im/model/IMOfficialMaskModel;", "imUserListModel", "Lcom/baidu/tieba/im/model/IMUserListModel;", "isCurrentChatTab", "", "isInit", "isMsgTabPrimary", "mAgainRequestGroupListListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mAnswerVisibleBs", "Lrx/subjects/BehaviorSubject;", "getMAnswerVisibleBs", "()Lrx/subjects/BehaviorSubject;", "mAnswerVisibleBs$delegate", "mChatMsgDataBs", "", "Lcom/baidu/tbadk/core/data/ImMessageCenterShowItemData;", "mCompleteProcess", "Lcom/baidu/tieba/im/chat/notify/ICompleteProcess;", "<set-?>", "mCompleteProcessBs", "getMCompleteProcessBs", "mId", "Lcom/baidu/adp/BdUniqueId;", "mMarkTopListener", "mMemoryListener", "mModel", "Lcom/baidu/tieba/immessagecenter/im/model/MsgChatTabModel;", "getMModel", "()Lcom/baidu/tieba/immessagecenter/im/model/MsgChatTabModel;", "mModel$delegate", "mMsgInvitationListener", "", "mNotifyAdapterBs", "getMNotifyAdapterBs", "mOnChatGroupCallback", "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/ChatTabSubscribeGroupMessageDispatcher$OnChatGroupMessageCallback;", "mRefreshStatusBs", "getMRefreshStatusBs", "mRemoveListItemListener", "mUserListMessageListener", "Lcom/baidu/adp/framework/listener/HttpMessageListener;", "memoryInitCompleted", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "setPageContext", "personCacheList", "getPersonCacheList", "personCacheList$delegate", "tabChangeSubscribe", "Lrx/Subscription;", "answerVisibleChange", "", "boolean", "createDispatcher", "deleteItem", "data", "iProcess", "Lcom/baidu/tieba/im/chat/notify/IProcess;", "forceRefreshUserListWhenInit", "getAnswerVisibleBs", "Lrx/Observable;", "getChatMsgDataObs", "getChatTabModel", "getSocketDispatcher", "getSubscribeRequest", "isHaveLocalGroupCache", "mergeChatTabData", "groupList", "personList", MissionEvent.MESSAGE_DESTROY, "onMsgTabPause", "onMsgTabPrimary", "processMemoryChanged", "changeMessage", "Lcom/baidu/tieba/im/message/MemoryChangedMessage;", "processMemoryInitComplete", "message", "Lcom/baidu/tieba/im/message/MemoryInitCompleteMessage;", "processResponseMemoryList", "resMessage", "Lcom/baidu/tieba/im/message/ResponsedMemoryListMessage;", "refreshMsg", "isSort", "refreshUserList", "registerListener", "sendChatTabRedTipUpdateMsg", "list", "type", "", "showTopToast", "act", "Landroid/app/Activity;", "resId", "isSuc", "switchSingleMask", "isMask", TbEnum.ParamKey.GID, "", "unRegisterListener", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatMsgModel extends x09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<BaseFragmentActivity> a;
    public final ctc<List<ImMessageCenterShowItemData>> b;
    public final Lazy c;
    public ctc<Boolean> d;
    public ctc<Object> e;
    public ctc<Boolean> f;
    public r19 g;
    public final BdUniqueId h;
    public final Lazy i;
    public final IMUserListModel j;
    public final vs8 k;
    public final IMOfficialMaskModel l;
    public final Lazy m;
    public final Lazy n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public loc s;
    public final CustomMessageListener t;
    public final r19.o u;
    public final CustomMessageListener v;
    public final CustomMessageListener w;
    public final CustomMessageListener x;
    public final CustomMessageListener y;
    public final HttpMessageListener z;

    /* loaded from: classes6.dex */
    public static final class a implements yk5 {
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
                TbPageContext<BaseFragmentActivity> F = this$0.F();
                if (F != null) {
                    activity = F.getPageActivity();
                } else {
                    activity = null;
                }
                this$0.W(activity, R.string.obfuscated_res_0x7f0f0cf8, false);
            }
        }

        @Override // com.baidu.tieba.yk5
        public void a(int i, long j, List<Long> roomIdList, int i2, String errMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), roomIdList, Integer.valueOf(i2), errMsg}) == null) {
                Intrinsics.checkNotNullParameter(roomIdList, "roomIdList");
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                if (this.a.o && this.a.p && i2 != 0) {
                    final ChatMsgModel chatMsgModel = this.a;
                    UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.i89
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
                        yw8.b().e(Long.valueOf(JavaTypesHelper.toLong(imMessageCenterShowItemData.getFriendId(), 0L)), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendBjhAvatar(), imMessageCenterShowItemData.getServerTime());
                        this.a.C().getData().remove(imMessageCenterShowItemData);
                        this.a.b.onNext(this.a.C().getData());
                        r19 r19Var = this.a.g;
                        if (r19Var != null) {
                            r19Var.W(JavaTypesHelper.toLong(imMessageCenterShowItemData.getFriendId(), 0L));
                        }
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
                    this.a.Q((MemoryInitCompleteMessage) msg);
                } else if (msg.getCmd() == 2016004 && this.a.r) {
                    if (!(msg instanceof MemoryChangedMessage)) {
                        return;
                    }
                    this.a.P((MemoryChangedMessage) msg);
                } else if (msg.getCmd() == 2016007 && this.a.r) {
                    if (!(msg instanceof ResponsedMemoryListMessage)) {
                        return;
                    }
                    this.a.R((ResponsedMemoryListMessage) msg);
                    this.a.E().onNext(Boolean.FALSE);
                    this.a.w();
                } else if (msg.getCmd() == 2016001 && this.a.r) {
                    TbLog iMLog = IMLog.getInstance();
                    iMLog.i("ChatMsgModel", "mMemoryListener <内存被清空前> 列表展示数据: " + ListUtils.getCount(this.a.C().getData()));
                    this.a.C().setData(null, this.a.k);
                    TbLog iMLog2 = IMLog.getInstance();
                    iMLog2.i("ChatMsgModel", "mMemoryListener <内存被清空后> 列表展示数据: " + ListUtils.getCount(this.a.C().getData()));
                } else if (msg.getCmd() == 2016010 && this.a.r) {
                    this.a.D().onNext(null);
                } else if (msg.getCmd() == 2016011 && this.a.r) {
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
                    this.a.t(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f implements r19.o {
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

        @Override // com.baidu.tieba.r19.o
        public void b(List<? extends ImMessageCenterPojo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.a.C().updateGroupchatList(list, this.a.k);
            this.a.V(list, null, 1);
        }

        @Override // com.baidu.tieba.r19.o
        public void a(List<? extends ImMessageCenterPojo> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) {
                if (list != null && ListUtils.isNotEmpty(list)) {
                    this.a.z().clear();
                    this.a.z().addAll(list);
                    ChatMsgModel chatMsgModel = this.a;
                    List<ImMessageCenterPojo> L = chatMsgModel.L(chatMsgModel.z(), this.a.G());
                    this.a.V(L, null, 1);
                    this.a.C().setData(L, this.a.k);
                    TbLog iMLog = IMLog.getInstance();
                    iMLog.i("ChatMsgModel", "mOnChatGroupCallback <hasGroupList = true> 群聊列表数据: " + ListUtils.getCount(list) + " || 私聊列表数据: " + ListUtils.getCount(this.a.G()));
                    return;
                }
                ChatMsgModel chatMsgModel2 = this.a;
                List<ImMessageCenterPojo> L2 = chatMsgModel2.L(chatMsgModel2.z(), this.a.G());
                this.a.V(L2, null, 1);
                this.a.C().setData(L2, this.a.k);
                TbLog iMLog2 = IMLog.getInstance();
                iMLog2.i("ChatMsgModel", "mOnChatGroupCallback <hasGroupList = false> 私聊列表数据: " + ListUtils.getCount(this.a.G()) + " || 群聊内存数据: " + ListUtils.getCount(this.a.z()));
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

        public static final void g(ChatMsgModel this$0) {
            r19 r19Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (!this$0.J() && (r19Var = this$0.g) != null) {
                    r19Var.X(null);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (this.a.p && responsedMessage.getCmd() == 2921784) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        String str = (String) data;
                        ImMessageCenterShowItemData removeItemByRoomId = this.a.C().getRemoveItemByRoomId(str);
                        if (removeItemByRoomId != null && this.a.C().getData().contains(removeItemByRoomId)) {
                            this.a.C().getData().remove(removeItemByRoomId);
                            this.a.b.onNext(this.a.C().getData());
                            r19 r19Var = this.a.g;
                            if (r19Var != null) {
                                r19Var.Y(str);
                            }
                            final ChatMsgModel chatMsgModel = this.a;
                            UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.j89
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        ChatMsgModel.g.g(ChatMsgModel.this);
                                    }
                                }
                            });
                            r19 r19Var2 = this.a.g;
                            if (r19Var2 != null) {
                                r19Var2.W(JavaTypesHelper.toLong(removeItemByRoomId.getFriendId(), 0L));
                            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        ctc<List<ImMessageCenterShowItemData>> Q = ctc.Q();
        Intrinsics.checkNotNullExpressionValue(Q, "create()");
        this.b = Q;
        this.c = LazyKt__LazyJVMKt.lazy(ChatMsgModel$mAnswerVisibleBs$2.INSTANCE);
        ctc<Boolean> R = ctc.R(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(R, "create(false)");
        this.d = R;
        ctc<Object> R2 = ctc.R(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(R2, "create(false)");
        this.e = R2;
        ctc<Boolean> R3 = ctc.R(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(R3, "create(false)");
        this.f = R3;
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        this.h = gen;
        this.i = LazyKt__LazyJVMKt.lazy(ChatMsgModel$mModel$2.INSTANCE);
        this.k = new vs8() { // from class: com.baidu.tieba.l89
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.vs8
            public final void onComplete() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ChatMsgModel.K(ChatMsgModel.this);
                }
            }
        };
        this.m = LazyKt__LazyJVMKt.lazy(ChatMsgModel$personCacheList$2.INSTANCE);
        this.n = LazyKt__LazyJVMKt.lazy(ChatMsgModel$groupCacheList$2.INSTANCE);
        this.q = true;
        this.t = new e(this);
        this.u = new f(this);
        this.v = new d(this);
        this.w = new g(this);
        this.x = new b(this);
        this.y = new c(this);
        this.z = new h(this);
        this.g = u();
        this.j = new IMUserListModel(null, this.h);
        this.l = new IMOfficialMaskModel();
        this.s = MainTabChangedMonitor.c.a().d().g().H(new soc() { // from class: com.baidu.tieba.k89
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.soc
            public final void call(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    ChatMsgModel.a(ChatMsgModel.this, (Integer) obj);
                }
            }
        });
    }

    public static final void K(ChatMsgModel this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.f.onNext(null);
        }
    }

    public final void Q(MemoryInitCompleteMessage memoryInitCompleteMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, memoryInitCompleteMessage) == null) {
            boolean areEqual = Intrinsics.areEqual(memoryInitCompleteMessage.getData(), Boolean.TRUE);
            this.r = areEqual;
            if (areEqual) {
                MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
            }
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
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
            this$0.p = z;
        }
    }

    public final void X(boolean z, String gid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048598, this, z, gid) == null) {
            Intrinsics.checkNotNullParameter(gid, "gid");
            this.l.O(z, gid);
        }
    }

    public final void v(ImMessageCenterShowItemData data, ws8 iProcess) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, data, iProcess) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(iProcess, "iProcess");
            C().asyncDeleteItem(data, iProcess);
        }
    }

    public final ctc<Boolean> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Object value = this.c.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mAnswerVisibleBs>(...)");
            return (ctc) value;
        }
        return (ctc) invokeV.objValue;
    }

    public final ctc<Boolean> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (ctc) invokeV.objValue;
    }

    public final MsgChatTabModel C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (MsgChatTabModel) this.i.getValue();
        }
        return (MsgChatTabModel) invokeV.objValue;
    }

    public final ctc<Object> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (ctc) invokeV.objValue;
    }

    public final ctc<Boolean> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (ctc) invokeV.objValue;
    }

    public final TbPageContext<BaseFragmentActivity> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final List<ImMessageCenterPojo> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (List) this.m.getValue();
        }
        return (List) invokeV.objValue;
    }

    public final r19 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            r19 r19Var = this.g;
            if (r19Var == null) {
                r19 u = u();
                this.g = u;
                return u;
            }
            return r19Var;
        }
        return (r19) invokeV.objValue;
    }

    public final void I() {
        r19 r19Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && BdNetTypeUtil.isNetWorkAvailable() && (r19Var = this.g) != null) {
            r19Var.V();
        }
    }

    public final boolean J() {
        InterceptResult invokeV;
        List<Map<String, Long>> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            r19 r19Var = this.g;
            if (r19Var != null) {
                list = r19Var.N(0);
            } else {
                list = null;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            loc locVar = this.s;
            if (locVar != null) {
                locVar.unsubscribe();
            }
            this.s = null;
            Y();
            this.g = null;
            this.a = null;
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.o = false;
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.o = true;
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.j.request(true, C().getUids());
        }
    }

    public final r19 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            r19 r19Var = new r19(this.a, this.u);
            r19Var.s(new a(this));
            return r19Var;
        }
        return (r19) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.q) {
            this.j.request(false, C().getUids());
            this.q = false;
        }
    }

    public final eoc<List<ImMessageCenterShowItemData>> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            eoc<List<ImMessageCenterShowItemData>> s = this.b.w().a().s(ooc.b());
            Intrinsics.checkNotNullExpressionValue(s, "mChatMsgDataBs.onBackpre…dSchedulers.mainThread())");
            return s;
        }
        return (eoc) invokeV.objValue;
    }

    public final MsgChatTabModel y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return C();
        }
        return (MsgChatTabModel) invokeV.objValue;
    }

    public final List<ImMessageCenterPojo> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return (List) this.n.getValue();
        }
        return (List) invokeV.objValue;
    }

    public final List<ImMessageCenterPojo> L(List<ImMessageCenterPojo> list, List<ImMessageCenterPojo> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, list, list2)) == null) {
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

    public final void P(MemoryChangedMessage memoryChangedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, memoryChangedMessage) == null) {
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                C().insertOrUpdate(data, this.k);
            } else if (memoryChangedMessage.getType() == 2) {
                C().remove(data, this.k);
            }
        }
    }

    public final void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z && !fk6.a(C().getData())) {
                C().sortList();
            }
            this.b.onNext(C().getData());
        }
    }

    public final void R(ResponsedMemoryListMessage responsedMemoryListMessage) {
        r19 r19Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, responsedMemoryListMessage) == null) {
            G().clear();
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (data != null) {
                G().addAll(data);
            }
            if (ListUtils.isEmpty(C().getData()) && (r19Var = this.g) != null) {
                r19Var.U();
            }
            if (responsedMemoryListMessage.getType() == 1 && this.o) {
                I();
            }
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MessageManager.getInstance().registerListener(2016004, this.v);
            MessageManager.getInstance().registerListener(2016001, this.v);
            MessageManager.getInstance().registerListener(2016010, this.v);
            MessageManager.getInstance().registerListener(2016007, this.v);
            MessageManager.getInstance().registerListener(2016011, this.v);
            MessageManager.getInstance().registerListener(2016002, this.v);
            MessageManager.getInstance().registerListener(this.w);
            MessageManager.getInstance().registerListener(this.x);
            MessageManager.getInstance().registerListener(this.y);
            MessageManager.getInstance().registerListener(this.z);
            MessageManager.getInstance().registerListener(this.t);
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
            new BdTopToast(activity).setContent(activity.getString(i)).setIcon(z).show((ViewGroup) activity.findViewById(16908290));
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.v);
            MessageManager.getInstance().unRegisterListener(this.w);
            MessageManager.getInstance().unRegisterListener(this.x);
            MessageManager.getInstance().unRegisterListener(this.y);
            MessageManager.getInstance().unRegisterListener(this.z);
            MessageManager.getInstance().unRegisterListener(this.t);
            r19 r19Var = this.g;
            if (r19Var != null) {
                r19Var.p();
            }
        }
    }
}
