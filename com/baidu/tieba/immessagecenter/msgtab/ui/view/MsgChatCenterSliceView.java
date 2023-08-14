package com.baidu.tieba.immessagecenter.msgtab.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.ui.state.StateManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ho5;
import com.baidu.tieba.i95;
import com.baidu.tieba.ija;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.immessagecenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.immessagecenter.mention.base.NotificationView;
import com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.slice.MsgChatCenterSlice;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgChatCenterSliceViewModel;
import com.baidu.tieba.j95;
import com.baidu.tieba.jq8;
import com.baidu.tieba.js8;
import com.baidu.tieba.kd8;
import com.baidu.tieba.kq8;
import com.baidu.tieba.ks8;
import com.baidu.tieba.lq8;
import com.baidu.tieba.mp8;
import com.baidu.tieba.o45;
import com.baidu.tieba.pa8;
import com.baidu.tieba.rb8;
import com.baidu.tieba.ss8;
import com.baidu.tieba.tn8;
import com.baidu.tieba.tracker.core.data.ErrCode;
import com.baidu.tieba.u45;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.w45;
import com.baidu.tieba.we8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000ó\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b*\u00015\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00052\u00020\u0006:\u0002\u0092\u0001B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WJ\b\u0010X\u001a\u00020UH\u0002J\u0006\u0010Y\u001a\u00020UJ\b\u0010Z\u001a\u00020UH\u0002J\u0010\u0010[\u001a\u00020U2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\\\u001a\u00020UH\u0002J\b\u0010]\u001a\u00020UH\u0002J\b\u0010^\u001a\u00020\u0004H\u0014J\u001e\u0010_\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u000fJ\u0006\u0010c\u001a\u00020UJ\u0010\u0010d\u001a\u00020U2\u0006\u0010e\u001a\u00020\u000fH\u0016J\u0006\u0010f\u001a\u00020UJ\b\u0010g\u001a\u00020UH\u0007J\b\u0010h\u001a\u00020UH\u0007J\b\u0010i\u001a\u00020UH\u0016J\u000e\u0010j\u001a\u00020U2\u0006\u0010k\u001a\u00020\u0017J\u0010\u0010l\u001a\u00020U2\b\u0010m\u001a\u0004\u0018\u00010nJ\u0006\u0010o\u001a\u00020UJ\u0010\u0010p\u001a\u00020U2\u0006\u0010q\u001a\u00020\u0002H\u0014J\b\u0010r\u001a\u00020UH\u0007J\b\u0010s\u001a\u00020UH\u0007J\b\u0010t\u001a\u00020UH\u0007J\u0006\u0010u\u001a\u00020UJ\u000e\u0010v\u001a\u00020\u00172\u0006\u0010V\u001a\u00020WJ\b\u0010w\u001a\u00020UH\u0002J\u0006\u0010x\u001a\u00020UJ\u0006\u0010y\u001a\u00020UJ\b\u0010z\u001a\u00020UH\u0002J\u0016\u0010{\u001a\u00020U2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020W0|H\u0002J\u0006\u0010}\u001a\u00020UJ\u0010\u0010~\u001a\u00020U2\u0006\u0010\u007f\u001a\u00020\u0017H\u0002J\u0010\u0010\u0080\u0001\u001a\u00020U2\u0007\u0010\u0081\u0001\u001a\u00020\u0017J\u0010\u0010\u0082\u0001\u001a\u00020U2\u0007\u0010\u0083\u0001\u001a\u00020\u0017J\u000f\u0010\u0084\u0001\u001a\u00020U2\u0006\u0010\u0019\u001a\u00020\u0017J\u0012\u0010\u0085\u0001\u001a\u00020U2\u0007\u0010\u0086\u0001\u001a\u00020\u0017H\u0002J\u0012\u0010\u0087\u0001\u001a\u00020U2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010JJ\u0011\u0010\u0089\u0001\u001a\u00020U2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001J\u0011\u0010\u008c\u0001\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0002J\t\u0010\u008d\u0001\u001a\u00020UH\u0002J\t\u0010\u008e\u0001\u001a\u00020UH\u0002J\u0012\u0010\u008f\u0001\u001a\u00020U2\u0007\u0010\u0090\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u0091\u0001\u001a\u00020UH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010'\u001a\u0004\b;\u0010<R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010'\u001a\u0004\bB\u0010CR2\u0010E\u001a&\u0012\f\u0012\n H*\u0004\u0018\u00010G0G H*\u0012\u0012\f\u0012\n H*\u0004\u0018\u00010G0G\u0018\u00010F0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010P\u001a\n H*\u0004\u0018\u00010Q0QX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0093\u0001"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView;", "Lcom/baidu/tieba/immessagecenter/arch/view/BaseView;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterChatTabUiState;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterChatTabUiIntent;", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/vm/MsgChatCenterSliceViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/baidu/tieba/immessagecenter/msgtab/adapt/IMsgAdapterProxy;", "frag", "Lcom/baidu/tbadk/core/BaseFragment;", "slice", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterSlice;", "pageSource", "", "(Lcom/baidu/tbadk/core/BaseFragment;Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterSlice;Ljava/lang/String;)V", "CHAT_TAB_CLICK", "", "context", "Landroid/content/Context;", "dialog", "Landroidx/appcompat/app/AlertDialog;", "getFrag", "()Lcom/baidu/tbadk/core/BaseFragment;", "isEnterGroupChatPage", "", "isFirstPrimary", "isNeedRefresh", "isPageShowBeStatistic", "isRefresh", "isShowOpenNotification", "isShowShutDownValidate", "mChatListAdapter", "Lcom/baidu/tieba/immessagecenter/im/chat/notify/MessageAggregationListAdapter;", "mFooterView", "Landroid/view/View;", "mHeaderContainer", "Landroid/widget/RelativeLayout;", "getMHeaderContainer", "()Landroid/widget/RelativeLayout;", "mHeaderContainer$delegate", "Lkotlin/Lazy;", "mIProcessImpl", "Lcom/baidu/tieba/im/chat/notify/IProcess;", "mMenuDialog", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "getMMenuDialog", "()Lcom/baidu/tbadk/core/dialog/PopupDialog;", "setMMenuDialog", "(Lcom/baidu/tbadk/core/dialog/PopupDialog;)V", "mMenuListener", "Lcom/baidu/tbadk/core/dialog/PopupDialogView$OnItemClickListener;", "mNoDataView", "Lcom/baidu/tbadk/core/view/NoDataView;", "mOnNotificationViewCloseListener", "com/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView$mOnNotificationViewCloseListener$1", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView$mOnNotificationViewCloseListener$1;", "mOnPullRefreshListener", "Lcom/baidu/tbadk/core/view/TbListCommonPullView$ListPullRefreshListener;", "mOpenNotificationView", "Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView;", "getMOpenNotificationView", "()Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView;", "mOpenNotificationView$delegate", "mProgressDialog", "Lcom/baidu/tbadk/core/dialog/BdProgressDialog1080;", "mPullView", "Lcom/baidu/tbadk/core/view/TbListViewPullView;", "getMPullView", "()Lcom/baidu/tbadk/core/view/TbListViewPullView;", "mPullView$delegate", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "kotlin.jvm.PlatformType", "renderCallBack", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/listener/MsgChatDataChangedCallBack;", "getSlice", "()Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterSlice;", "srcNotifyId", "tbAlertBuilder", "Lcom/baidu/tbadk/core/dialog/TBAlertBuilder;", "uniqueId", "Lcom/baidu/adp/BdUniqueId;", "viewBinding", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView$ViewBinding;", "actionToGroupChatPage", "", "data", "Lcom/baidu/tbadk/core/data/ImMessageCenterShowItemData;", "dismissDialog", "exitMsgGroupChat", "hideNotificationView", "init", "initNoDataView", "initView", "initViewModel", "jumpGroupChatPageStatistic", "roomId", "", "type", "notifyDataSetChanged", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCompleteProcess", "onCreate", MissionEvent.MESSAGE_DESTROY, "onFinishInflate", "onNetworkChange", "hasNetwork", "onNewIntent", "intent", "Landroid/content/Intent;", "onPrimary", "onRender", "state", "onResumes", "onStart", MissionEvent.MESSAGE_STOP, "onViewCreated", "prepareMenuDialog", "pullRefreshData", "reenterMsgGroupChat", "refreshPageData", "refreshUserList", "renderData", "", "resetDispatcher", "setChatListViewVisible", "isVisible", "setIsFirstPrimary", "isFirst", "setIsRefreshing", "isRefreshing", "setNeedRefresh", "setNoDataViewVisible", UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, "setRenderCallBack", "callBack", "setSrcNotifyId", StateManager.KEY_STATE, "Landroid/os/Bundle;", "showDeleteConfirmDialog", "showNotificationView", "showProgressDialog", "shutDownValidate", "isValid", "stateInvitationEntranceShow", "ViewBinding", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgChatCenterSliceView extends BaseView<ks8, js8, MsgChatCenterSliceViewModel> implements LifecycleObserver, mp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public final pa8 D;
    public final b E;
    public final i95.g F;
    public final BaseFragment e;
    public final String f;
    public final Context g;
    public final TbPageContext<BaseFragmentActivity> h;
    public final BdUniqueId i;
    public a j;
    public MessageAggregationListAdapter k;
    public View l;
    public NoDataView m;
    public final int n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public u45 r;
    public w45.f s;
    public AlertDialog t;
    public TBAlertBuilder u;
    public o45 v;
    public int w;
    public jq8 x;
    public boolean y;
    public boolean z;

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final C0360a f;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;
        public RoundRelativeLayout b;
        public BdListView c;
        public BdSwipeRefreshLayout d;
        public ShutDownValidateTipView e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-221455312, "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-221455312, "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView$a;");
                    return;
                }
            }
            f = new C0360a(null);
        }

        /* renamed from: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0360a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ C0360a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public C0360a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public final a a(View root) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, root)) == null) {
                    Intrinsics.checkNotNullParameter(root, "root");
                    a aVar = new a();
                    View findViewById = root.findViewById(R.id.obfuscated_res_0x7f092227);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.slice_msg_chat_root)");
                    aVar.j((RelativeLayout) findViewById);
                    View findViewById2 = root.findViewById(R.id.obfuscated_res_0x7f0917e3);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.msg_round_corner_container)");
                    aVar.g((RoundRelativeLayout) findViewById2);
                    View findViewById3 = root.findViewById(R.id.obfuscated_res_0x7f0917ae);
                    Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.msg_center_chat_list)");
                    aVar.f((BdListView) findViewById3);
                    View findViewById4 = root.findViewById(R.id.obfuscated_res_0x7f0917af);
                    Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.m…nter_chat_refresh_layout)");
                    aVar.h((BdSwipeRefreshLayout) findViewById4);
                    View findViewById5 = root.findViewById(R.id.obfuscated_res_0x7f0917f4);
                    Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.msg_view_no_validate)");
                    aVar.i((ShutDownValidateTipView) findViewById5);
                    return aVar;
                }
                return (a) invokeL.objValue;
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final BdListView a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                BdListView bdListView = this.c;
                if (bdListView != null) {
                    return bdListView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mChatListView");
                return null;
            }
            return (BdListView) invokeV.objValue;
        }

        public final RoundRelativeLayout b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                RoundRelativeLayout roundRelativeLayout = this.b;
                if (roundRelativeLayout != null) {
                    return roundRelativeLayout;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                return null;
            }
            return (RoundRelativeLayout) invokeV.objValue;
        }

        public final BdSwipeRefreshLayout c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.d;
                if (bdSwipeRefreshLayout != null) {
                    return bdSwipeRefreshLayout;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mSwipeRefreshLayout");
                return null;
            }
            return (BdSwipeRefreshLayout) invokeV.objValue;
        }

        public final ShutDownValidateTipView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                ShutDownValidateTipView shutDownValidateTipView = this.e;
                if (shutDownValidateTipView != null) {
                    return shutDownValidateTipView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mValidateTipView");
                return null;
            }
            return (ShutDownValidateTipView) invokeV.objValue;
        }

        public final RelativeLayout e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                RelativeLayout relativeLayout = this.a;
                if (relativeLayout != null) {
                    return relativeLayout;
                }
                Intrinsics.throwUninitializedPropertyAccessException("root");
                return null;
            }
            return (RelativeLayout) invokeV.objValue;
        }

        public final void f(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bdListView) == null) {
                Intrinsics.checkNotNullParameter(bdListView, "<set-?>");
                this.c = bdListView;
            }
        }

        public final void g(RoundRelativeLayout roundRelativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, roundRelativeLayout) == null) {
                Intrinsics.checkNotNullParameter(roundRelativeLayout, "<set-?>");
                this.b = roundRelativeLayout;
            }
        }

        public final void h(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, bdSwipeRefreshLayout) == null) {
                Intrinsics.checkNotNullParameter(bdSwipeRefreshLayout, "<set-?>");
                this.d = bdSwipeRefreshLayout;
            }
        }

        public final void i(ShutDownValidateTipView shutDownValidateTipView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shutDownValidateTipView) == null) {
                Intrinsics.checkNotNullParameter(shutDownValidateTipView, "<set-?>");
                this.e = shutDownValidateTipView;
            }
        }

        public final void j(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, relativeLayout) == null) {
                Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
                this.a = relativeLayout;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements NotificationView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgChatCenterSliceView a;

        public b(MsgChatCenterSliceView msgChatCenterSliceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgChatCenterSliceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgChatCenterSliceView;
        }

        @Override // com.baidu.tieba.immessagecenter.mention.base.NotificationView.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            a aVar = this.a.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().removeHeaderView(this.a.a0());
            this.a.A = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgChatCenterSliceView(BaseFragment frag, MsgChatCenterSlice slice, String pageSource) {
        super(R.layout.obfuscated_res_0x7f0d08c4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frag, slice, pageSource};
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
        Intrinsics.checkNotNullParameter(frag, "frag");
        Intrinsics.checkNotNullParameter(slice, "slice");
        Intrinsics.checkNotNullParameter(pageSource, "pageSource");
        this.e = frag;
        this.f = pageSource;
        Activity pageActivity = frag.getPageContext().getPageActivity();
        Intrinsics.checkNotNullExpressionValue(pageActivity, "frag.pageContext.pageActivity");
        this.g = pageActivity;
        this.h = this.e.getPageContext();
        this.i = this.e.getPageContext().getUniqueId();
        this.n = 1;
        this.o = LazyKt__LazyJVMKt.lazy(new Function0<NotificationView>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$mOpenNotificationView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsgChatCenterSliceView this$0;

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

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NotificationView invoke() {
                InterceptResult invokeV;
                Context context;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (NotificationView) invokeV.objValue;
                }
                context = this.this$0.g;
                return new NotificationView(context, null, 0, 6, null);
            }
        });
        this.p = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$mHeaderContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsgChatCenterSliceView this$0;

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

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RelativeLayout invoke() {
                InterceptResult invokeV;
                Context context;
                NotificationView c0;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (RelativeLayout) invokeV.objValue;
                }
                context = this.this$0.g;
                RelativeLayout relativeLayout = new RelativeLayout(context);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout.setGravity(17);
                relativeLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_W_X003));
                c0 = this.this$0.c0();
                relativeLayout.addView(c0);
                return relativeLayout;
            }
        });
        this.q = LazyKt__LazyJVMKt.lazy(new Function0<j95>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$mPullView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsgChatCenterSliceView this$0;

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

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final j95 invoke() {
                InterceptResult invokeV;
                TbPageContext tbPageContext;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (j95) invokeV.objValue;
                }
                tbPageContext = this.this$0.h;
                return new j95(tbPageContext);
            }
        });
        this.w = 16;
        this.z = true;
        this.B = true;
        this.D = new pa8(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$mIProcessImpl$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsgChatCenterSliceView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.tieba.pa8
            public void onCanceled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.Y();
            }

            @Override // com.baidu.tieba.pa8
            public void onPostExecute() {
                TbPageContext tbPageContext;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                    return;
                }
                this.a.Y();
                tbPageContext = this.a.h;
                tbPageContext.showToast(R.string.delete_success, false);
                this.a.m0();
            }

            @Override // com.baidu.tieba.pa8
            public void onPreExecute() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                    return;
                }
                this.a.K0();
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
                r6 = r4.a.v;
             */
            @Override // com.baidu.tieba.pa8
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onProgressUpdate(int i3, String id, int i4) {
                o45 o45Var;
                o45 o45Var2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i3), id, Integer.valueOf(i4)}) == null) {
                    Intrinsics.checkNotNullParameter(id, "id");
                    o45Var = this.a.v;
                    if (o45Var != null && o45Var2 != null) {
                        o45Var2.b(i3);
                    }
                }
            }
        };
        this.E = new b(this);
        this.F = new i95.g() { // from class: com.baidu.tieba.fr8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.i95.g
            public final void e(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    MsgChatCenterSliceView.k0(MsgChatCenterSliceView.this, z);
                }
            }
        };
    }

    public static final void H0(MsgChatCenterSliceView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            AlertDialog alertDialog = this$0.t;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }
    }

    public static final void k0(MsgChatCenterSliceView this$0, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, this$0, z) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.B0(true);
            this$0.u0();
            a aVar = this$0.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.c().setRefreshing(false);
        }
    }

    public static final void I0(MsgChatCenterSliceView this$0, ImMessageCenterShowItemData data, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, data, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            AlertDialog alertDialog = this$0.t;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            StatisticItem statisticItem = new StatisticItem("c14670");
            if (tn8.a(data)) {
                statisticItem.param("obj_type", 1);
            } else if (tn8.b(data)) {
                statisticItem.param("obj_type", 3);
            } else {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
            this$0.p().m(data, this$0.D);
        }
    }

    public final void j0(ImMessageCenterShowItemData data, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{data, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 3).param("fid", data.getForumId()).param("room_id", j).param("obj_type", i));
        }
    }

    public static final void o0(MsgChatCenterSliceView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a aVar = this$0.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().E();
        }
    }

    public final void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.z = z;
        }
    }

    public final void C0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.y = z;
        }
    }

    public final void E0(jq8 jq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jq8Var) == null) {
            this.x = jq8Var;
        }
    }

    public final void F0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            this.w = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, 16);
        }
    }

    public final void onNewIntent(Intent intent) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, intent) == null) {
            if (intent != null) {
                i = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            } else {
                i = 16;
            }
            this.w = i;
            if (i == -1) {
                return;
            }
            C0(true);
            p0();
        }
    }

    public final void x0(List<? extends ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, list) == null) {
            ija.f(this.e, new Pair[0]);
            MessageAggregationListAdapter messageAggregationListAdapter = this.k;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.u(list);
            }
        }
    }

    public static final void h0(MsgChatCenterSliceView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SharedPrefHelper.getInstance().putBoolean("is_shut_down_validate", true);
            this$0.B = false;
            a aVar = this$0.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.d().setVisibility(8);
        }
    }

    public static final void t0(MsgChatCenterSliceView this$0, String menuDelete, ImMessageCenterShowItemData data, String menuMarkTop, String menuMarkCancelTop, String menuNoTip, String menuNoTipCancel, w45 w45Var, int i, View view2) {
        boolean z;
        u45 u45Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{this$0, menuDelete, data, menuMarkTop, menuMarkCancelTop, menuNoTip, menuNoTipCancel, w45Var, Integer.valueOf(i), view2}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(menuDelete, "$menuDelete");
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(menuMarkTop, "$menuMarkTop");
            Intrinsics.checkNotNullParameter(menuMarkCancelTop, "$menuMarkCancelTop");
            Intrinsics.checkNotNullParameter(menuNoTip, "$menuNoTip");
            Intrinsics.checkNotNullParameter(menuNoTipCancel, "$menuNoTipCancel");
            u45 u45Var2 = this$0.r;
            if (u45Var2 != null && u45Var2.isShowing()) {
                z = true;
            } else {
                z = false;
            }
            if (z && (u45Var = this$0.r) != null) {
                u45Var.dismiss();
            }
            if (view2 != null) {
                String obj = ((EMTextView) view2).getText().toString();
                if (Intrinsics.areEqual(menuDelete, obj)) {
                    TiebaStatic.log("c12933");
                    StatisticItem statisticItem = new StatisticItem("c14665");
                    if (tn8.a(data)) {
                        statisticItem.param("obj_type", 1);
                    } else if (tn8.b(data)) {
                        statisticItem.param("obj_type", 3);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    TiebaStatic.log(statisticItem);
                    this$0.G0(data);
                    return;
                } else if (Intrinsics.areEqual(menuMarkTop, obj)) {
                    StatisticItem statisticItem2 = new StatisticItem("c14664");
                    statisticItem2.param("obj_type", 1);
                    if (tn8.b(data)) {
                        statisticItem2.param("obj_source", 2);
                        long currentTimeMillis = System.currentTimeMillis();
                        kd8.b().g(Long.valueOf(JavaTypesHelper.toLong(data.getFriendId(), 0L)), data.getFriendNameShow(), data.getFriendBjhAvatar(), currentTimeMillis);
                        data.setMarkTopIndex(currentTimeMillis);
                        this$0.p().B(true);
                    } else {
                        statisticItem2.param("obj_source", 1);
                        we8.c(data.getFriendId(), true);
                    }
                    TiebaStatic.log(statisticItem2);
                    return;
                } else if (Intrinsics.areEqual(menuMarkCancelTop, obj)) {
                    StatisticItem statisticItem3 = new StatisticItem("c14664");
                    statisticItem3.param("obj_type", 2);
                    if (tn8.b(data)) {
                        statisticItem3.param("obj_source", 2);
                        kd8.b().g(Long.valueOf(JavaTypesHelper.toLong(data.getFriendId(), 0L)), data.getFriendNameShow(), data.getFriendBjhAvatar(), 0L);
                        data.setMarkTopIndex(0L);
                        this$0.p().B(true);
                    } else {
                        statisticItem3.param("obj_source", 1);
                        we8.c(data.getFriendId(), false);
                    }
                    TiebaStatic.log(statisticItem3);
                    return;
                } else if (Intrinsics.areEqual(menuNoTip, obj)) {
                    StatisticItem statisticItem4 = new StatisticItem("c14669");
                    statisticItem4.param("obj_type", 1);
                    if (tn8.c(data)) {
                        statisticItem4.param("obj_source", 1);
                        String friendId = data.getFriendId();
                        Intrinsics.checkNotNullExpressionValue(friendId, "data.friendId");
                        this$0.p().r(true, friendId);
                    } else if (tn8.b(data)) {
                        statisticItem4.param("obj_source", 2);
                        kd8.b().f(Long.valueOf(JavaTypesHelper.toLong(data.getFriendId(), 0L)), data.getFriendNameShow(), data.getFriendBjhAvatar(), false);
                        data.setNotify(false);
                        this$0.p().B(false);
                        this$0.p().E(null, data, 5);
                    }
                    TiebaStatic.log(statisticItem4);
                    return;
                } else if (Intrinsics.areEqual(menuNoTipCancel, obj)) {
                    StatisticItem statisticItem5 = new StatisticItem("c14669");
                    statisticItem5.param("obj_type", 2);
                    if (tn8.c(data)) {
                        statisticItem5.param("obj_source", 1);
                        String friendId2 = data.getFriendId();
                        Intrinsics.checkNotNullExpressionValue(friendId2, "data.friendId");
                        this$0.p().r(false, friendId2);
                    } else if (tn8.b(data)) {
                        statisticItem5.param("obj_source", 2);
                        kd8.b().f(Long.valueOf(JavaTypesHelper.toLong(data.getFriendId(), 0L)), data.getFriendNameShow(), data.getFriendBjhAvatar(), true);
                        data.setNotify(true);
                        this$0.p().B(false);
                        this$0.p().E(null, data, 5);
                    }
                    TiebaStatic.log(statisticItem5);
                    return;
                } else {
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.elementsMaven.view.EMTextView");
        }
    }

    @Override // com.baidu.tieba.mp8
    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            mp8.a.a(this, z);
            a aVar = null;
            if (z) {
                if (this.B) {
                    a aVar2 = this.j;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        aVar2 = null;
                    }
                    if (aVar2.d().getVisibility() != 0) {
                        a aVar3 = this.j;
                        if (aVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        } else {
                            aVar = aVar3;
                        }
                        aVar.d().setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            a aVar4 = this.j;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar4 = null;
            }
            if (aVar4.d().getVisibility() != 8) {
                a aVar5 = this.j;
                if (aVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                } else {
                    aVar = aVar5;
                }
                aVar.d().setVisibility(8);
            }
        }
    }

    public final void D0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                z0(false);
                a aVar = this.j;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    aVar = null;
                }
                aVar.a().setVisibility(8);
                NoDataView noDataView = this.m;
                if (noDataView != null) {
                    noDataView.setVisibility(0);
                }
                NoDataView noDataView2 = this.m;
                if (noDataView2 != null) {
                    noDataView2.setTextOption(NoDataViewFactory.e.d(null, this.g.getResources().getString(R.string.obfuscated_res_0x7f0f0cb4)));
                }
                NoDataView noDataView3 = this.m;
                if (noDataView3 != null) {
                    noDataView3.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE));
                    return;
                }
                return;
            }
            z0(true);
            NoDataView noDataView4 = this.m;
            if (noDataView4 != null) {
                noDataView4.setVisibility(8);
            }
        }
    }

    public final void X(ImMessageCenterShowItemData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (!TextUtils.isEmpty(data.getGroupJumpUrl())) {
                String friendId = data.getFriendId();
                Intrinsics.checkNotNullExpressionValue(friendId, "data.friendId");
                long parseLong = Long.parseLong(friendId);
                ho5.a().d(this.g, parseLong, "source_from_message_tab", 3);
                j0(data, parseLong, this.n);
                p().o().u(true);
            }
        }
    }

    public final void n0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048603, this, z) != null) || !z) {
            return;
        }
        a aVar = this.j;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            aVar = null;
        }
        if (aVar.a().getWrappedAdapter() == null) {
            return;
        }
        a aVar3 = this.j;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            aVar2 = aVar3;
        }
        if (aVar2.a().getWrappedAdapter().getCount() <= 0) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.lr8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MsgChatCenterSliceView.o0(MsgChatCenterSliceView.this);
                    }
                }
            });
        }
    }

    public final void B0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            a aVar = null;
            if (z) {
                a aVar2 = this.j;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    aVar2 = null;
                }
                aVar2.a().setSelection(0);
            }
            a aVar3 = this.j;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                aVar = aVar3;
            }
            aVar.c().setRefreshing(z);
        }
    }

    public final void z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            a aVar = null;
            if (z) {
                a aVar2 = this.j;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                } else {
                    aVar = aVar2;
                }
                aVar.a().setVisibility(0);
                return;
            }
            a aVar3 = this.j;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                aVar = aVar3;
            }
            aVar.a().setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j = a.f.a(m());
            g0();
        }
    }

    public final void Y() {
        o45 o45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (o45Var = this.v) != null) {
            boolean z = true;
            if ((o45Var == null || !o45Var.isShowing()) ? false : false) {
                o45 o45Var2 = this.v;
                if (o45Var2 != null) {
                    o45Var2.dismiss();
                }
                this.v = null;
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            p().o().K();
        }
    }

    public final RelativeLayout a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return (RelativeLayout) this.p.getValue();
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final u45 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.r;
        }
        return (u45) invokeV.objValue;
    }

    public final NotificationView c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return (NotificationView) this.o.getValue();
        }
        return (NotificationView) invokeV.objValue;
    }

    public final j95 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return (j95) this.q.getValue();
        }
        return (j95) invokeV.objValue;
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().removeHeaderView(a0());
            this.A = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: i0 */
    public MsgChatCenterSliceViewModel r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = this.e.getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "frag.pageContext");
            return new MsgChatCenterSliceViewModel(pageContext);
        }
        return (MsgChatCenterSliceViewModel) invokeV.objValue;
    }

    public final void l0() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (messageAggregationListAdapter = this.k) != null) {
            messageAggregationListAdapter.notifyDataSetChanged();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            p().s();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResumes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            w0();
            L0();
            NotificationChangedMonitor.c.a().i();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (noDataView = this.m) != null) {
            noDataView.d(this.h);
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().E();
            NotificationChangedMonitor.c.a().i();
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            TbSingleton.getInstance().setNeedJoinChatRoom(true);
            u0();
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            p().C();
        }
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            TbSingleton.getInstance().setNeedJoinChatRoom(false);
            p().o().K();
        }
    }

    public final void G0(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imMessageCenterShowItemData) != null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.unfriend_del, TBAlertConfig.OperateBtnStyle.ALERT);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.unfriend_cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        int i = R.string.obfuscated_res_0x7f0f148c;
        if (Intrinsics.areEqual("9", imMessageCenterShowItemData.getOwnerName())) {
            i = R.string.obfuscated_res_0x7f0f148d;
        }
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        Intrinsics.checkNotNull(currentActivity);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(currentActivity);
        this.u = tBAlertBuilder;
        Intrinsics.checkNotNull(tBAlertBuilder);
        this.t = tBAlertBuilder.setTitle(R.string.obfuscated_res_0x7f0f16a1).setDesc(i).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig2.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.cr8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    MsgChatCenterSliceView.H0(MsgChatCenterSliceView.this, view2);
                }
            }
        });
        operateBtnConfig.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.qr8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    MsgChatCenterSliceView.I0(MsgChatCenterSliceView.this, imMessageCenterShowItemData, view2);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: q0 */
    public void H(ks8 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (!(state instanceof ks8.a)) {
                if (state instanceof ks8.f) {
                    x0(((ks8.f) state).a());
                } else if (state instanceof ks8.d) {
                    m0();
                } else if (state instanceof ks8.c) {
                    l0();
                } else if (state instanceof ks8.e) {
                    B0(((ks8.e) state).a());
                } else if (state instanceof ks8.b) {
                    if (((ks8.b) state).a()) {
                        J0();
                    } else {
                        e0();
                    }
                } else {
                    ija.b(this.e, new Pair(StatConstants.KEY_EXT_ERR_CODE, ErrCode.NET_ERROR.getValue()));
                }
            }
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.A) {
            c0().setOnCloseListener(this.E);
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().w(a0(), 0);
            this.A = true;
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Y();
            if (this.v == null) {
                this.v = rb8.l().o(this.g);
            }
            o45 o45Var = this.v;
            if (o45Var != null) {
                o45Var.show();
            }
            o45 o45Var2 = this.v;
            if (o45Var2 != null) {
                o45Var2.b(0);
            }
        }
    }

    public final void p0() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.k;
            if (messageAggregationListAdapter != null && messageAggregationListAdapter.getCount() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                C0(true);
            }
            if (this.z || this.y) {
                this.z = false;
                this.y = false;
                u0();
            }
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            int dimens = BdUtilHelper.getDimens(this.g, R.dimen.tbds385);
            Context context = this.g;
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            NoDataView a2 = NoDataViewFactory.a(context, aVar.e(), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, dimens), NoDataViewFactory.e.d(null, this.g.getResources().getString(R.string.obfuscated_res_0x7f0f0cb4)), null);
            this.m = a2;
            if (a2 != null) {
                a2.f(this.h, TbadkCoreApplication.getInst().getSkinType());
            }
            NoDataView noDataView = this.m;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            f0();
            this.l = new View(this.g);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, BdUtilHelper.getDimens(this.g, R.dimen.obfuscated_res_0x7f070375));
            View view2 = this.l;
            if (view2 != null) {
                view2.setLayoutParams(layoutParams);
            }
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.d().setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.jr8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        MsgChatCenterSliceView.h0(MsgChatCenterSliceView.this, view3);
                    }
                }
            });
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.k;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.Q();
            }
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().setOnScrollListener(null);
            a aVar2 = this.j;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar2 = null;
            }
            aVar2.a().setOnItemClickListener(null);
            a aVar3 = this.j;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar3 = null;
            }
            aVar3.a().setOnItemLongClickListener(null);
            TbSingleton.getInstance().setNeedJoinChatRoom(false);
            p().y();
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().z(0L);
            if (p().n().getData() != null && ListUtils.getCount(p().n().getData()) > 0) {
                jq8 jq8Var = this.x;
                if (jq8Var != null) {
                    jq8Var.a(true);
                }
                D0(false);
                List<ImMessageCenterShowItemData> data = p().n().getData();
                Intrinsics.checkNotNullExpressionValue(data, "viewModel.getMessageCenterModel().data");
                x0(data);
                if (!this.C) {
                    this.C = true;
                    ss8.a.a("0");
                    return;
                }
                return;
            }
            jq8 jq8Var2 = this.x;
            if (jq8Var2 != null) {
                jq8Var2.a(false);
            }
            D0(true);
            ss8.a.a("1");
        }
    }

    @Override // com.baidu.tieba.hg8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            l0();
            d0().C(i);
            NoDataView noDataView = this.m;
            if (noDataView != null) {
                noDataView.f(this.h, i);
            }
            c0().a(i);
            a aVar = this.j;
            a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.d().b(i);
            a aVar3 = this.j;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar3 = null;
            }
            SkinManager.setBackgroundColor(aVar3.c(), R.color.CAM_X0201);
            a aVar4 = this.j;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar4 = null;
            }
            EMManager.from(aVar4.e()).setCorner(R.string.J_X19).setBackGroundColor(R.color.CAM_X0201);
            a aVar5 = this.j;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar5 = null;
            }
            EMManager.from(aVar5.c()).setBackGroundColor(R.color.CAM_X0201);
            a aVar6 = this.j;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar6 = null;
            }
            EMManager.from(aVar6.b()).setBackGroundColor(R.color.CAM_X0201);
            a aVar7 = this.j;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar7 = null;
            }
            EMManager.from(aVar7.a()).setCorner(R.string.J_X19).setBackGroundColor(R.color.CAM_X0201);
            if (Intrinsics.areEqual("FRS", this.f)) {
                float dimens = BdUtilHelper.getDimens(this.g, R.dimen.tbds52);
                float[] fArr = {dimens, dimens, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                a aVar8 = this.j;
                if (aVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    aVar8 = null;
                }
                aVar8.b().setRoundLayoutRadius(fArr);
            } else {
                a aVar9 = this.j;
                if (aVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    aVar9 = null;
                }
                aVar9.a().setPadding(0, 0, 0, 0);
                a aVar10 = this.j;
                if (aVar10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    aVar10 = null;
                }
                aVar10.b().setRoundLayoutRadius(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            a aVar11 = this.j;
            if (aVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                aVar2 = aVar11;
            }
            aVar2.a().setPadding(0, BdUtilHelper.getDimens(this.g, R.dimen.M_H_X003), 0, 0);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void q(Context context) {
        ViewParent parent;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            MessageAggregationListAdapter messageAggregationListAdapter = new MessageAggregationListAdapter(context);
            this.k = messageAggregationListAdapter;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.b0(this.h);
            }
            MessageAggregationListAdapter messageAggregationListAdapter2 = this.k;
            if (messageAggregationListAdapter2 != null) {
                messageAggregationListAdapter2.X(this);
            }
            MessageAggregationListAdapter messageAggregationListAdapter3 = this.k;
            if (messageAggregationListAdapter3 != null) {
                messageAggregationListAdapter3.x(this.f);
            }
            a aVar = this.j;
            a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().setDividerHeight(0);
            a aVar3 = this.j;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar3 = null;
            }
            BdListView a2 = aVar3.a();
            BdUniqueId uniqueId = this.i;
            Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
            a2.setOnItemClickListener(new kq8(context, uniqueId, this, this.k, p()));
            a aVar4 = this.j;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar4 = null;
            }
            BdListView a3 = aVar4.a();
            TbPageContext<BaseFragmentActivity> pageContext = this.h;
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            a3.setOnItemLongClickListener(new lq8(pageContext, this, this.k));
            a aVar5 = this.j;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar5 = null;
            }
            aVar5.a().addFooterView(this.l);
            a aVar6 = this.j;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar6 = null;
            }
            aVar6.a().setAdapter((ListAdapter) this.k);
            d0().a(this.F);
            d0().V(this.h.getUniqueId());
            View view2 = d0().getView();
            if (view2 != null && (parent = view2.getParent()) != null) {
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(d0().getView());
                }
            }
            a aVar7 = this.j;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                aVar2 = aVar7;
            }
            aVar2.c().setProgressView(d0());
            r0();
        }
    }

    public final boolean s0(final ImMessageCenterShowItemData data) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            final String string = this.g.getString(R.string.delete_user_chat);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.delete_user_chat)");
            final String string2 = this.g.getString(R.string.obfuscated_res_0x7f0f16b4);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.top)");
            final String string3 = this.g.getString(R.string.cancel_top);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.cancel_top)");
            final String string4 = this.g.getString(R.string.im_chat_no_tip);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.im_chat_no_tip)");
            final String string5 = this.g.getString(R.string.im_chat_no_tip_cancel);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.string.im_chat_no_tip_cancel)");
            if (data.getMarkTopIndex() > 0) {
                str = string3;
            } else {
                str = string2;
            }
            if (data.getGroupSetting() != null && !Intrinsics.areEqual("9", data.getOwnerName()) && !data.getGroupSetting().isAcceptNotify()) {
                str2 = string5;
            } else {
                str2 = string4;
            }
            if (Intrinsics.areEqual("9", data.getOwnerName())) {
                if (data.isNotify) {
                    str2 = string4;
                } else {
                    str2 = string5;
                }
            }
            String str3 = str2;
            w45.f fVar = new w45.f() { // from class: com.baidu.tieba.ar8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.w45.f
                public final void K0(w45 w45Var, int i, View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                        MsgChatCenterSliceView.t0(MsgChatCenterSliceView.this, string, data, string2, string3, string4, string5, w45Var, i, view2);
                    }
                }
            };
            ArrayList arrayList = new ArrayList(5);
            if (tn8.a(data)) {
                arrayList.add(str);
                arrayList.add(string);
            } else if (tn8.c(data)) {
                arrayList.add(str3);
                arrayList.add(string);
            } else if (!tn8.b(data)) {
                return false;
            } else {
                arrayList.add(str);
                arrayList.add(str3);
                arrayList.add(string);
            }
            this.s = fVar;
            this.r = new u45(this.h);
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                u45 u45Var = this.r;
                if (u45Var != null) {
                    u45Var.i(null, strArr, this.s);
                    return true;
                }
                return true;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        return invokeL.booleanValue;
    }
}
