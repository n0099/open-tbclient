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
import com.baidu.tieba.b55;
import com.baidu.tieba.cp8;
import com.baidu.tieba.cz8;
import com.baidu.tieba.da5;
import com.baidu.tieba.dz8;
import com.baidu.tieba.ea5;
import com.baidu.tieba.fx8;
import com.baidu.tieba.gi8;
import com.baidu.tieba.gx8;
import com.baidu.tieba.h55;
import com.baidu.tieba.hw8;
import com.baidu.tieba.hx8;
import com.baidu.tieba.ij8;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im8;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.immessagecenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.immessagecenter.mention.base.NotificationView;
import com.baidu.tieba.immessagecenter.msgtab.ui.slice.MsgChatCenterSlice;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgChatCenterSliceViewModel;
import com.baidu.tieba.j55;
import com.baidu.tieba.ku8;
import com.baidu.tieba.lz8;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.vp5;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000ù\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b*\u00018\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00052\u00020\u0006:\u0002\u0095\u0001B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZJ\b\u0010[\u001a\u00020XH\u0002J\u0006\u0010\\\u001a\u00020XJ\b\u0010]\u001a\u00020XH\u0002J\u0010\u0010^\u001a\u00020X2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010_\u001a\u00020XH\u0002J\b\u0010`\u001a\u00020XH\u0002J\b\u0010a\u001a\u00020\u0004H\u0014J\u001e\u0010b\u001a\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u000fJ\u0006\u0010f\u001a\u00020XJ\u0010\u0010g\u001a\u00020X2\u0006\u0010h\u001a\u00020\u000fH\u0016J\u0006\u0010i\u001a\u00020XJ\b\u0010j\u001a\u00020XH\u0007J\b\u0010k\u001a\u00020XH\u0007J\b\u0010l\u001a\u00020XH\u0016J\u000e\u0010m\u001a\u00020X2\u0006\u0010n\u001a\u00020\u0019J\u0010\u0010o\u001a\u00020X2\b\u0010p\u001a\u0004\u0018\u00010qJ\u0006\u0010r\u001a\u00020XJ\u0010\u0010s\u001a\u00020X2\u0006\u0010t\u001a\u00020\u0002H\u0014J\b\u0010u\u001a\u00020XH\u0007J\b\u0010v\u001a\u00020XH\u0007J\b\u0010w\u001a\u00020XH\u0007J\u0006\u0010x\u001a\u00020XJ\u000e\u0010y\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020ZJ\b\u0010z\u001a\u00020XH\u0002J\u0006\u0010{\u001a\u00020XJ\u0006\u0010|\u001a\u00020XJ\b\u0010}\u001a\u00020XH\u0002J\u0016\u0010~\u001a\u00020X2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u007fH\u0002J\u0007\u0010\u0080\u0001\u001a\u00020XJ\u0012\u0010\u0081\u0001\u001a\u00020X2\u0007\u0010\u0082\u0001\u001a\u00020\u0019H\u0002J\u0010\u0010\u0083\u0001\u001a\u00020X2\u0007\u0010\u0084\u0001\u001a\u00020\u0019J\u0010\u0010\u0085\u0001\u001a\u00020X2\u0007\u0010\u0086\u0001\u001a\u00020\u0019J\u000f\u0010\u0087\u0001\u001a\u00020X2\u0006\u0010\u001b\u001a\u00020\u0019J\u0012\u0010\u0088\u0001\u001a\u00020X2\u0007\u0010\u0089\u0001\u001a\u00020\u0019H\u0002J\u0012\u0010\u008a\u0001\u001a\u00020X2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010MJ\u0011\u0010\u008c\u0001\u001a\u00020X2\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001J\u0011\u0010\u008f\u0001\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0002J\t\u0010\u0090\u0001\u001a\u00020XH\u0002J\t\u0010\u0091\u0001\u001a\u00020XH\u0002J\u0012\u0010\u0092\u0001\u001a\u00020X2\u0007\u0010\u0093\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u0094\u0001\u001a\u00020XH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010*\u001a\u0004\b>\u0010?R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010C\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010*\u001a\u0004\bE\u0010FR2\u0010H\u001a&\u0012\f\u0012\n K*\u0004\u0018\u00010J0J K*\u0012\u0012\f\u0012\n K*\u0004\u0018\u00010J0J\u0018\u00010I0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u000e\u0010P\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010S\u001a\n K*\u0004\u0018\u00010T0TX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0096\u0001"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView;", "Lcom/baidu/tieba/immessagecenter/arch/view/BaseView;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterChatTabUiState;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterChatTabUiIntent;", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/vm/MsgChatCenterSliceViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/baidu/tieba/immessagecenter/msgtab/adapt/IMsgAdapterProxy;", "frag", "Lcom/baidu/tbadk/core/BaseFragment;", "slice", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterSlice;", "pageSource", "", "(Lcom/baidu/tbadk/core/BaseFragment;Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterSlice;Ljava/lang/String;)V", "CHAT_TAB_CLICK", "", "context", "Landroid/content/Context;", "dialog", "Landroidx/appcompat/app/AlertDialog;", "emptyViewRunnable", "Ljava/lang/Runnable;", "getFrag", "()Lcom/baidu/tbadk/core/BaseFragment;", "isEnterGroupChatPage", "", "isFirstPrimary", "isNeedRefresh", "isPageShowBeStatistic", "isRefresh", "isShowNoDataView", "isShowOpenNotification", "isShowShutDownValidate", "mChatListAdapter", "Lcom/baidu/tieba/immessagecenter/im/chat/notify/MessageAggregationListAdapter;", "mFooterView", "Landroid/view/View;", "mHeaderContainer", "Landroid/widget/RelativeLayout;", "getMHeaderContainer", "()Landroid/widget/RelativeLayout;", "mHeaderContainer$delegate", "Lkotlin/Lazy;", "mIProcessImpl", "Lcom/baidu/tieba/im/chat/notify/IProcess;", "mMenuDialog", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "getMMenuDialog", "()Lcom/baidu/tbadk/core/dialog/PopupDialog;", "setMMenuDialog", "(Lcom/baidu/tbadk/core/dialog/PopupDialog;)V", "mMenuListener", "Lcom/baidu/tbadk/core/dialog/PopupDialogView$OnItemClickListener;", "mNoDataView", "Lcom/baidu/tbadk/core/view/NoDataView;", "mOnNotificationViewCloseListener", "com/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView$mOnNotificationViewCloseListener$1", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView$mOnNotificationViewCloseListener$1;", "mOnPullRefreshListener", "Lcom/baidu/tbadk/core/view/TbListCommonPullView$ListPullRefreshListener;", "mOpenNotificationView", "Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView;", "getMOpenNotificationView", "()Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView;", "mOpenNotificationView$delegate", "mProgressDialog", "Lcom/baidu/tbadk/core/dialog/BdProgressDialog1080;", "mPullView", "Lcom/baidu/tbadk/core/view/TbListViewPullView;", "getMPullView", "()Lcom/baidu/tbadk/core/view/TbListViewPullView;", "mPullView$delegate", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "kotlin.jvm.PlatformType", "renderCallBack", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/listener/MsgChatDataChangedCallBack;", "getSlice", "()Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterSlice;", "srcNotifyId", "tbAlertBuilder", "Lcom/baidu/tbadk/core/dialog/TBAlertBuilder;", "uniqueId", "Lcom/baidu/adp/BdUniqueId;", "viewBinding", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView$ViewBinding;", "actionToGroupChatPage", "", "data", "Lcom/baidu/tbadk/core/data/ImMessageCenterShowItemData;", "dismissDialog", "exitMsgGroupChat", "hideNotificationView", "init", "initNoDataView", "initView", "initViewModel", "jumpGroupChatPageStatistic", "roomId", "", "type", "notifyDataSetChanged", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCompleteProcess", "onCreate", MissionEvent.MESSAGE_DESTROY, "onFinishInflate", "onNetworkChange", "hasNetwork", "onNewIntent", "intent", "Landroid/content/Intent;", "onPrimary", "onRender", "state", "onResumes", "onStart", MissionEvent.MESSAGE_STOP, "onViewCreated", "prepareMenuDialog", "pullRefreshData", "reenterMsgGroupChat", "refreshPageData", "refreshUserList", "renderData", "", "resetDispatcher", "setChatListViewVisible", "isVisible", "setIsFirstPrimary", "isFirst", "setIsRefreshing", "isRefreshing", "setNeedRefresh", "setNoDataViewVisible", UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, "setRenderCallBack", "callBack", "setSrcNotifyId", StateManager.KEY_STATE, "Landroid/os/Bundle;", "showDeleteConfirmDialog", "showNotificationView", "showProgressDialog", "shutDownValidate", "isValid", "stateInvitationEntranceShow", "ViewBinding", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgChatCenterSliceView extends BaseView<dz8, cz8, MsgChatCenterSliceViewModel> implements LifecycleObserver, hw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public final Runnable F;
    public final gi8 G;
    public final b H;
    public final da5.g I;
    public final BaseFragment f;
    public final String g;
    public final Context h;
    public final TbPageContext<BaseFragmentActivity> i;
    public final BdUniqueId j;
    public a k;
    public MessageAggregationListAdapter l;
    public View m;
    public NoDataView n;
    public final int o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public h55 s;
    public j55.f t;
    public AlertDialog u;
    public TBAlertBuilder v;
    public b55 w;
    public int x;
    public fx8 y;
    public boolean z;

    public final void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final C0347a f;
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
            f = new C0347a(null);
        }

        /* renamed from: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0347a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ C0347a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public C0347a() {
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
                    View findViewById = root.findViewById(R.id.obfuscated_res_0x7f092258);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.slice_msg_chat_root)");
                    aVar.j((RelativeLayout) findViewById);
                    View findViewById2 = root.findViewById(R.id.obfuscated_res_0x7f0917fb);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.msg_round_corner_container)");
                    aVar.g((RoundRelativeLayout) findViewById2);
                    View findViewById3 = root.findViewById(R.id.obfuscated_res_0x7f0917c6);
                    Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.msg_center_chat_list)");
                    aVar.f((BdListView) findViewById3);
                    View findViewById4 = root.findViewById(R.id.obfuscated_res_0x7f0917c7);
                    Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.m…nter_chat_refresh_layout)");
                    aVar.h((BdSwipeRefreshLayout) findViewById4);
                    View findViewById5 = root.findViewById(R.id.obfuscated_res_0x7f09181a);
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
            a aVar = this.a.k;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().removeHeaderView(this.a.b0());
            this.a.B = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgChatCenterSliceView(BaseFragment frag, MsgChatCenterSlice slice, String pageSource) {
        super(R.layout.obfuscated_res_0x7f0d08de);
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
        this.f = frag;
        this.g = pageSource;
        Activity pageActivity = frag.getPageContext().getPageActivity();
        Intrinsics.checkNotNullExpressionValue(pageActivity, "frag.pageContext.pageActivity");
        this.h = pageActivity;
        this.i = this.f.getPageContext();
        this.j = this.f.getPageContext().getUniqueId();
        this.o = 1;
        this.p = LazyKt__LazyJVMKt.lazy(new Function0<NotificationView>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$mOpenNotificationView$2
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
                context = this.this$0.h;
                return new NotificationView(context, null, 0, 6, null);
            }
        });
        this.q = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$mHeaderContainer$2
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
                NotificationView d0;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (RelativeLayout) invokeV.objValue;
                }
                context = this.this$0.h;
                RelativeLayout relativeLayout = new RelativeLayout(context);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout.setGravity(17);
                relativeLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), 0);
                d0 = this.this$0.d0();
                relativeLayout.addView(d0);
                return relativeLayout;
            }
        });
        this.r = LazyKt__LazyJVMKt.lazy(new Function0<ea5>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$mPullView$2
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
            public final ea5 invoke() {
                InterceptResult invokeV;
                TbPageContext tbPageContext;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (ea5) invokeV.objValue;
                }
                tbPageContext = this.this$0.i;
                return new ea5(tbPageContext);
            }
        });
        this.x = 16;
        this.A = true;
        this.C = true;
        this.F = new Runnable() { // from class: com.baidu.tieba.ux8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    MsgChatCenterSliceView.Y(MsgChatCenterSliceView.this);
                }
            }
        };
        this.G = new gi8(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$mIProcessImpl$1
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

            @Override // com.baidu.tieba.gi8
            public void onCanceled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.X();
            }

            @Override // com.baidu.tieba.gi8
            public void onPostExecute() {
                TbPageContext tbPageContext;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                    return;
                }
                this.a.X();
                tbPageContext = this.a.i;
                tbPageContext.showToast(R.string.delete_success, false);
                this.a.n0();
            }

            @Override // com.baidu.tieba.gi8
            public void onPreExecute() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                    return;
                }
                this.a.L0();
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
                r6 = r4.a.w;
             */
            @Override // com.baidu.tieba.gi8
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onProgressUpdate(int i3, String id, int i4) {
                b55 b55Var;
                b55 b55Var2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i3), id, Integer.valueOf(i4)}) == null) {
                    Intrinsics.checkNotNullParameter(id, "id");
                    b55Var = this.a.w;
                    if (b55Var != null && b55Var2 != null) {
                        b55Var2.b(i3);
                    }
                }
            }
        };
        this.H = new b(this);
        this.I = new da5.g() { // from class: com.baidu.tieba.sx8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.da5.g
            public final void e(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    MsgChatCenterSliceView.l0(MsgChatCenterSliceView.this, z);
                }
            }
        };
    }

    public static final void I0(MsgChatCenterSliceView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            AlertDialog alertDialog = this$0.u;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }
    }

    public static final void l0(MsgChatCenterSliceView this$0, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, null, this$0, z) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.C0(true);
            this$0.v0();
            a aVar = this$0.k;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.c().setRefreshing(false);
        }
    }

    public static final void J0(MsgChatCenterSliceView this$0, ImMessageCenterShowItemData data, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, data, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            AlertDialog alertDialog = this$0.u;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            StatisticItem statisticItem = new StatisticItem("c14670");
            if (ku8.a(data)) {
                statisticItem.param("obj_type", 1);
            } else if (ku8.b(data)) {
                statisticItem.param("obj_type", 3);
            } else {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
            this$0.o().m(data, this$0.G);
        }
    }

    public final void k0(ImMessageCenterShowItemData data, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{data, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 3).param("fid", data.getForumId()).param("room_id", j).param("obj_type", i));
        }
    }

    public static final void Y(MsgChatCenterSliceView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.E0(this$0.E);
        }
    }

    public static final void p0(MsgChatCenterSliceView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a aVar = this$0.k;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().E();
        }
    }

    public final void B0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.A = z;
        }
    }

    public final void D0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.z = z;
        }
    }

    public final void F0(fx8 fx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fx8Var) == null) {
            this.y = fx8Var;
        }
    }

    public final void G0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            this.x = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, 16);
        }
    }

    public final void onNewIntent(Intent intent) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, intent) == null) {
            if (intent != null) {
                i = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            } else {
                i = 16;
            }
            this.x = i;
            if (i == -1) {
                return;
            }
            D0(true);
            q0();
        }
    }

    public final void y0(List<? extends ImMessageCenterShowItemData> list) {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, list) == null) && (messageAggregationListAdapter = this.l) != null) {
            messageAggregationListAdapter.u(list);
        }
    }

    public static final void i0(MsgChatCenterSliceView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SharedPrefHelper.getInstance().putBoolean("is_shut_down_validate", true);
            this$0.C = false;
            a aVar = this$0.k;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.d().setVisibility(8);
        }
    }

    public static final void u0(MsgChatCenterSliceView this$0, String menuDelete, ImMessageCenterShowItemData data, String menuMarkTop, String menuMarkCancelTop, String menuNoTip, String menuNoTipCancel, j55 j55Var, int i, View view2) {
        boolean z;
        h55 h55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{this$0, menuDelete, data, menuMarkTop, menuMarkCancelTop, menuNoTip, menuNoTipCancel, j55Var, Integer.valueOf(i), view2}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(menuDelete, "$menuDelete");
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(menuMarkTop, "$menuMarkTop");
            Intrinsics.checkNotNullParameter(menuMarkCancelTop, "$menuMarkCancelTop");
            Intrinsics.checkNotNullParameter(menuNoTip, "$menuNoTip");
            Intrinsics.checkNotNullParameter(menuNoTipCancel, "$menuNoTipCancel");
            h55 h55Var2 = this$0.s;
            if (h55Var2 != null && h55Var2.isShowing()) {
                z = true;
            } else {
                z = false;
            }
            if (z && (h55Var = this$0.s) != null) {
                h55Var.dismiss();
            }
            if (view2 != null) {
                String obj = ((EMTextView) view2).getText().toString();
                if (Intrinsics.areEqual(menuDelete, obj)) {
                    TiebaStatic.log("c12933");
                    StatisticItem statisticItem = new StatisticItem("c14665");
                    if (ku8.a(data)) {
                        statisticItem.param("obj_type", 1);
                    } else if (ku8.b(data)) {
                        statisticItem.param("obj_type", 3);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    TiebaStatic.log(statisticItem);
                    this$0.H0(data);
                    return;
                } else if (Intrinsics.areEqual(menuMarkTop, obj)) {
                    StatisticItem statisticItem2 = new StatisticItem("c14664");
                    statisticItem2.param("obj_type", 1);
                    if (ku8.b(data)) {
                        statisticItem2.param("obj_source", 2);
                        long currentTimeMillis = System.currentTimeMillis();
                        im8.b().g(Long.valueOf(JavaTypesHelper.toLong(data.getFriendId(), 0L)), data.getFriendNameShow(), data.getFriendBjhAvatar(), currentTimeMillis);
                        data.setMarkTopIndex(currentTimeMillis);
                        this$0.o().B(true);
                    } else {
                        statisticItem2.param("obj_source", 1);
                        cp8.c(data.getFriendId(), true);
                    }
                    TiebaStatic.log(statisticItem2);
                    return;
                } else if (Intrinsics.areEqual(menuMarkCancelTop, obj)) {
                    StatisticItem statisticItem3 = new StatisticItem("c14664");
                    statisticItem3.param("obj_type", 2);
                    if (ku8.b(data)) {
                        statisticItem3.param("obj_source", 2);
                        im8.b().g(Long.valueOf(JavaTypesHelper.toLong(data.getFriendId(), 0L)), data.getFriendNameShow(), data.getFriendBjhAvatar(), 0L);
                        data.setMarkTopIndex(0L);
                        this$0.o().B(true);
                    } else {
                        statisticItem3.param("obj_source", 1);
                        cp8.c(data.getFriendId(), false);
                    }
                    TiebaStatic.log(statisticItem3);
                    return;
                } else if (Intrinsics.areEqual(menuNoTip, obj)) {
                    StatisticItem statisticItem4 = new StatisticItem("c14669");
                    statisticItem4.param("obj_type", 1);
                    if (ku8.c(data)) {
                        statisticItem4.param("obj_source", 1);
                        String friendId = data.getFriendId();
                        Intrinsics.checkNotNullExpressionValue(friendId, "data.friendId");
                        this$0.o().r(true, friendId);
                    } else if (ku8.b(data)) {
                        statisticItem4.param("obj_source", 2);
                        im8.b().f(Long.valueOf(JavaTypesHelper.toLong(data.getFriendId(), 0L)), data.getFriendNameShow(), data.getFriendBjhAvatar(), false);
                        data.setNotify(false);
                        this$0.o().B(false);
                        this$0.o().E(null, data, 5);
                    }
                    TiebaStatic.log(statisticItem4);
                    return;
                } else if (Intrinsics.areEqual(menuNoTipCancel, obj)) {
                    StatisticItem statisticItem5 = new StatisticItem("c14669");
                    statisticItem5.param("obj_type", 2);
                    if (ku8.c(data)) {
                        statisticItem5.param("obj_source", 1);
                        String friendId2 = data.getFriendId();
                        Intrinsics.checkNotNullExpressionValue(friendId2, "data.friendId");
                        this$0.o().r(false, friendId2);
                    } else if (ku8.b(data)) {
                        statisticItem5.param("obj_source", 2);
                        im8.b().f(Long.valueOf(JavaTypesHelper.toLong(data.getFriendId(), 0L)), data.getFriendNameShow(), data.getFriendBjhAvatar(), true);
                        data.setNotify(true);
                        this$0.o().B(false);
                        this$0.o().E(null, data, 5);
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

    public final void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            a aVar = null;
            if (z) {
                a aVar2 = this.k;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                } else {
                    aVar = aVar2;
                }
                aVar.a().setVisibility(0);
                return;
            }
            a aVar3 = this.k;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                aVar = aVar3;
            }
            aVar.a().setVisibility(8);
        }
    }

    public final void C0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            a aVar = null;
            if (z) {
                a aVar2 = this.k;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    aVar2 = null;
                }
                aVar2.a().setSelection(0);
            }
            a aVar3 = this.k;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                aVar = aVar3;
            }
            aVar.c().setRefreshing(z);
        }
    }

    public final void E0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                A0(false);
                a aVar = this.k;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    aVar = null;
                }
                aVar.a().setVisibility(8);
                NoDataView noDataView = this.n;
                if (noDataView != null) {
                    noDataView.setVisibility(0);
                }
                NoDataView noDataView2 = this.n;
                if (noDataView2 != null) {
                    noDataView2.setTextOption(NoDataViewFactory.e.d(null, this.h.getResources().getString(R.string.obfuscated_res_0x7f0f0cd4)));
                }
                NoDataView noDataView3 = this.n;
                if (noDataView3 != null) {
                    noDataView3.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE));
                    return;
                }
                return;
            }
            A0(true);
            NoDataView noDataView4 = this.n;
            if (noDataView4 != null) {
                noDataView4.setVisibility(8);
            }
        }
    }

    public final void W(ImMessageCenterShowItemData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (!TextUtils.isEmpty(data.getGroupJumpUrl())) {
                String friendId = data.getFriendId();
                Intrinsics.checkNotNullExpressionValue(friendId, "data.friendId");
                long parseLong = Long.parseLong(friendId);
                vp5.a().e(this.h, parseLong, "source_from_message_tab", 3);
                k0(data, parseLong, this.o);
                o().o().t(true);
            }
        }
    }

    @Override // com.baidu.tieba.hw8
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            hw8.a.a(this, z);
            a aVar = null;
            if (z) {
                if (this.C) {
                    a aVar2 = this.k;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        aVar2 = null;
                    }
                    if (aVar2.d().getVisibility() != 0) {
                        a aVar3 = this.k;
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
            a aVar4 = this.k;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar4 = null;
            }
            if (aVar4.d().getVisibility() != 8) {
                a aVar5 = this.k;
                if (aVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                } else {
                    aVar = aVar5;
                }
                aVar.d().setVisibility(8);
            }
        }
    }

    public final void o0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048604, this, z) != null) || !z) {
            return;
        }
        a aVar = this.k;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            aVar = null;
        }
        if (aVar.a().getWrappedAdapter() == null) {
            return;
        }
        a aVar3 = this.k;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            aVar2 = aVar3;
        }
        if (aVar2.a().getWrappedAdapter().getCount() <= 0) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.vx8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MsgChatCenterSliceView.p0(MsgChatCenterSliceView.this);
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: r0 */
    public void H(dz8 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (!(state instanceof dz8.a)) {
                if (state instanceof dz8.f) {
                    y0(((dz8.f) state).a());
                } else if (state instanceof dz8.d) {
                    n0();
                } else if (state instanceof dz8.c) {
                    m0();
                } else if (state instanceof dz8.e) {
                    C0(((dz8.e) state).a());
                } else if (state instanceof dz8.b) {
                    if (((dz8.b) state).a()) {
                        K0();
                    } else {
                        f0();
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k = a.f.a(n());
            h0();
        }
    }

    public final void X() {
        b55 b55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (b55Var = this.w) != null) {
            boolean z = true;
            if ((b55Var == null || !b55Var.isShowing()) ? false : false) {
                b55 b55Var2 = this.w;
                if (b55Var2 != null) {
                    b55Var2.dismiss();
                }
                this.w = null;
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            o().o().J();
        }
    }

    public final RelativeLayout b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return (RelativeLayout) this.q.getValue();
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final h55 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.s;
        }
        return (h55) invokeV.objValue;
    }

    public final NotificationView d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return (NotificationView) this.p.getValue();
        }
        return (NotificationView) invokeV.objValue;
    }

    public final ea5 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return (ea5) this.r.getValue();
        }
        return (ea5) invokeV.objValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            a aVar = this.k;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().removeHeaderView(b0());
            this.B = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: j0 */
    public MsgChatCenterSliceViewModel r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = this.f.getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "frag.pageContext");
            return new MsgChatCenterSliceViewModel(pageContext);
        }
        return (MsgChatCenterSliceViewModel) invokeV.objValue;
    }

    public final void m0() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (messageAggregationListAdapter = this.l) != null) {
            messageAggregationListAdapter.notifyDataSetChanged();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            o().s();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResumes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            x0();
            M0();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (noDataView = this.n) != null) {
            noDataView.d(this.i);
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            a aVar = this.k;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().E();
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            TbSingleton.getInstance().setNeedJoinChatRoom(true);
            v0();
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            o().C();
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            TbSingleton.getInstance().setNeedJoinChatRoom(false);
            o().o().J();
        }
    }

    public final void H0(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, imMessageCenterShowItemData) != null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.unfriend_del, TBAlertConfig.OperateBtnStyle.ALERT);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.unfriend_cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        int i = R.string.obfuscated_res_0x7f0f14b6;
        if (Intrinsics.areEqual("9", imMessageCenterShowItemData.getOwnerName())) {
            i = R.string.obfuscated_res_0x7f0f14b7;
        }
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        Intrinsics.checkNotNull(currentActivity);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(currentActivity);
        this.v = tBAlertBuilder;
        Intrinsics.checkNotNull(tBAlertBuilder);
        this.u = tBAlertBuilder.setTitle(R.string.obfuscated_res_0x7f0f16d1).setDesc(i).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig2.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.xx8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    MsgChatCenterSliceView.I0(MsgChatCenterSliceView.this, view2);
                }
            }
        });
        operateBtnConfig.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.hy8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    MsgChatCenterSliceView.J0(MsgChatCenterSliceView.this, imMessageCenterShowItemData, view2);
                }
            }
        });
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.B) {
            d0().setOnCloseListener(this.H);
            a aVar = this.k;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().w(b0(), 0);
            this.B = true;
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            X();
            if (this.w == null) {
                this.w = ij8.l().o(this.h);
            }
            b55 b55Var = this.w;
            if (b55Var != null) {
                b55Var.show();
            }
            b55 b55Var2 = this.w;
            if (b55Var2 != null) {
                b55Var2.b(0);
            }
        }
    }

    public final void q0() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.l;
            if (messageAggregationListAdapter != null && messageAggregationListAdapter.getCount() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                D0(true);
            }
            if (this.A || this.z) {
                this.A = false;
                this.z = false;
                v0();
            }
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            int dimens = BdUtilHelper.getDimens(this.h, R.dimen.tbds385);
            Context context = this.h;
            a aVar = this.k;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            NoDataView a2 = NoDataViewFactory.a(context, aVar.e(), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, dimens), NoDataViewFactory.e.d(null, this.h.getResources().getString(R.string.obfuscated_res_0x7f0f0cd4)), null);
            this.n = a2;
            if (a2 != null) {
                a2.f(this.i, TbadkCoreApplication.getInst().getSkinType());
            }
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            g0();
            this.m = new View(this.h);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, BdUtilHelper.getDimens(this.h, R.dimen.obfuscated_res_0x7f070379));
            View view2 = this.m;
            if (view2 != null) {
                view2.setLayoutParams(layoutParams);
            }
            a aVar = this.k;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.d().setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.wx8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        MsgChatCenterSliceView.i0(MsgChatCenterSliceView.this, view3);
                    }
                }
            });
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.l;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.Q();
            }
            SafeHandler.getInst().removeCallbacks(this.F);
            a aVar = this.k;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().setOnScrollListener(null);
            a aVar2 = this.k;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar2 = null;
            }
            aVar2.a().setOnItemClickListener(null);
            a aVar3 = this.k;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar3 = null;
            }
            aVar3.a().setOnItemLongClickListener(null);
            TbSingleton.getInstance().setNeedJoinChatRoom(false);
            o().y();
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            a aVar = this.k;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().z(0L);
            if (o().n().getData() != null && ListUtils.getCount(o().n().getData()) > 0) {
                fx8 fx8Var = this.y;
                if (fx8Var != null) {
                    fx8Var.a(true);
                }
                this.E = false;
                List<ImMessageCenterShowItemData> data = o().n().getData();
                Intrinsics.checkNotNullExpressionValue(data, "viewModel.getMessageCenterModel().data");
                y0(data);
                if (!this.D) {
                    this.D = true;
                    lz8.a.a("0");
                }
            } else {
                fx8 fx8Var2 = this.y;
                if (fx8Var2 != null) {
                    fx8Var2.a(false);
                }
                this.E = true;
                lz8.a.a("1");
            }
            SafeHandler.getInst().postDelayed(this.F, 500L);
        }
    }

    @Override // com.baidu.tieba.nq8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            m0();
            e0().C(i);
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.f(this.i, i);
            }
            d0().a(i);
            a aVar = this.k;
            a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.d().b(i);
            a aVar3 = this.k;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar3 = null;
            }
            SkinManager.setBackgroundColor(aVar3.c(), R.color.CAM_X0201);
            a aVar4 = this.k;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar4 = null;
            }
            EMManager.from(aVar4.e()).setCorner(R.string.J_X19).setBackGroundColor(R.color.CAM_X0201);
            a aVar5 = this.k;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar5 = null;
            }
            EMManager.from(aVar5.c()).setBackGroundColor(R.color.CAM_X0201);
            a aVar6 = this.k;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar6 = null;
            }
            EMManager.from(aVar6.b()).setBackGroundColor(R.color.CAM_X0201);
            a aVar7 = this.k;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar7 = null;
            }
            EMManager.from(aVar7.a()).setCorner(R.string.J_X19).setBackGroundColor(R.color.CAM_X0201);
            if (Intrinsics.areEqual("FRS", this.g)) {
                float dimens = BdUtilHelper.getDimens(this.h, R.dimen.tbds52);
                float[] fArr = {dimens, dimens, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                a aVar8 = this.k;
                if (aVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    aVar8 = null;
                }
                aVar8.b().setRoundLayoutRadius(fArr);
            } else {
                a aVar9 = this.k;
                if (aVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    aVar9 = null;
                }
                aVar9.a().setPadding(0, 0, 0, 0);
                a aVar10 = this.k;
                if (aVar10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    aVar10 = null;
                }
                aVar10.b().setRoundLayoutRadius(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            a aVar11 = this.k;
            if (aVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                aVar2 = aVar11;
            }
            aVar2.a().setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void p(Context context) {
        ViewParent parent;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            MessageAggregationListAdapter messageAggregationListAdapter = new MessageAggregationListAdapter(context);
            this.l = messageAggregationListAdapter;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.a0(this.i);
            }
            MessageAggregationListAdapter messageAggregationListAdapter2 = this.l;
            if (messageAggregationListAdapter2 != null) {
                messageAggregationListAdapter2.X(this);
            }
            MessageAggregationListAdapter messageAggregationListAdapter3 = this.l;
            if (messageAggregationListAdapter3 != null) {
                messageAggregationListAdapter3.x(this.g);
            }
            a aVar = this.k;
            a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().setDividerHeight(0);
            a aVar3 = this.k;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar3 = null;
            }
            BdListView a2 = aVar3.a();
            BdUniqueId uniqueId = this.j;
            Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
            a2.setOnItemClickListener(new gx8(context, uniqueId, this, this.l, o()));
            a aVar4 = this.k;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar4 = null;
            }
            BdListView a3 = aVar4.a();
            TbPageContext<BaseFragmentActivity> pageContext = this.i;
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            a3.setOnItemLongClickListener(new hx8(pageContext, this, this.l));
            a aVar5 = this.k;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar5 = null;
            }
            aVar5.a().addFooterView(this.m);
            a aVar6 = this.k;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar6 = null;
            }
            aVar6.a().setAdapter((ListAdapter) this.l);
            e0().a(this.I);
            e0().V(this.i.getUniqueId());
            View view2 = e0().getView();
            if (view2 != null && (parent = view2.getParent()) != null) {
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(e0().getView());
                }
            }
            a aVar7 = this.k;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                aVar2 = aVar7;
            }
            aVar2.c().setProgressView(e0());
            s0();
        }
    }

    public final boolean t0(final ImMessageCenterShowItemData data) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            final String string = this.h.getString(R.string.delete_user_chat);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.delete_user_chat)");
            final String string2 = this.h.getString(R.string.obfuscated_res_0x7f0f16e4);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.top)");
            final String string3 = this.h.getString(R.string.cancel_top);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.cancel_top)");
            final String string4 = this.h.getString(R.string.im_chat_no_tip);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.im_chat_no_tip)");
            final String string5 = this.h.getString(R.string.im_chat_no_tip_cancel);
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
            j55.f fVar = new j55.f() { // from class: com.baidu.tieba.yx8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.j55.f
                public final void G0(j55 j55Var, int i, View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, j55Var, i, view2) == null) {
                        MsgChatCenterSliceView.u0(MsgChatCenterSliceView.this, string, data, string2, string3, string4, string5, j55Var, i, view2);
                    }
                }
            };
            ArrayList arrayList = new ArrayList(5);
            if (ku8.a(data)) {
                arrayList.add(str);
                arrayList.add(string);
            } else if (ku8.c(data)) {
                arrayList.add(str3);
                arrayList.add(string);
            } else if (!ku8.b(data)) {
                return false;
            } else {
                arrayList.add(str);
                arrayList.add(str3);
                arrayList.add(string);
            }
            this.t = fVar;
            this.s = new h55(this.i);
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                h55 h55Var = this.s;
                if (h55Var != null) {
                    h55Var.i(null, strArr, this.t);
                    return true;
                }
                return true;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        return invokeL.booleanValue;
    }
}
