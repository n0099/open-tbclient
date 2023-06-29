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
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
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
import com.baidu.tieba.aa5;
import com.baidu.tieba.ba5;
import com.baidu.tieba.bm8;
import com.baidu.tieba.c98;
import com.baidu.tieba.hc8;
import com.baidu.tieba.ik8;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.immessagecenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.immessagecenter.mention.base.NotificationView;
import com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.slice.MsgChatCenterSlice;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgChatCenterSliceViewModel;
import com.baidu.tieba.j55;
import com.baidu.tieba.lo8;
import com.baidu.tieba.mm8;
import com.baidu.tieba.mo8;
import com.baidu.tieba.nm8;
import com.baidu.tieba.om8;
import com.baidu.tieba.p55;
import com.baidu.tieba.r55;
import com.baidu.tieba.r95;
import com.baidu.tieba.s75;
import com.baidu.tieba.ua8;
import com.baidu.tieba.uo8;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.xi;
import com.baidu.tieba.yg;
import com.baidu.tieba.yo5;
import com.baidu.tieba.z78;
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
@Metadata(d1 = {"\u0000ó\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b*\u00013\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00052\u00020\u0006:\u0002\u0090\u0001B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VJ\b\u0010W\u001a\u00020TH\u0002J\u0006\u0010X\u001a\u00020TJ\b\u0010Y\u001a\u00020TH\u0002J\u0010\u0010Z\u001a\u00020T2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010[\u001a\u00020TH\u0002J\b\u0010\\\u001a\u00020TH\u0002J\b\u0010]\u001a\u00020\u0004H\u0014J\u0016\u0010^\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010_\u001a\u00020`J\u0006\u0010a\u001a\u00020TJ\u0010\u0010b\u001a\u00020T2\u0006\u0010c\u001a\u00020LH\u0016J\u0006\u0010d\u001a\u00020TJ\b\u0010e\u001a\u00020TH\u0007J\b\u0010f\u001a\u00020TH\u0007J\b\u0010g\u001a\u00020TH\u0016J\u000e\u0010h\u001a\u00020T2\u0006\u0010i\u001a\u00020\u0015J\u0010\u0010j\u001a\u00020T2\b\u0010k\u001a\u0004\u0018\u00010lJ\u0006\u0010m\u001a\u00020TJ\u0010\u0010n\u001a\u00020T2\u0006\u0010o\u001a\u00020\u0002H\u0014J\b\u0010p\u001a\u00020TH\u0007J\b\u0010q\u001a\u00020TH\u0007J\b\u0010r\u001a\u00020TH\u0007J\u0006\u0010s\u001a\u00020TJ\u000e\u0010t\u001a\u00020\u00152\u0006\u0010U\u001a\u00020VJ\b\u0010u\u001a\u00020TH\u0002J\u0006\u0010v\u001a\u00020TJ\u0006\u0010w\u001a\u00020TJ\b\u0010x\u001a\u00020TH\u0002J\u0014\u0010y\u001a\u00020T2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020V0zJ\u0006\u0010{\u001a\u00020TJ\u0010\u0010|\u001a\u00020T2\u0006\u0010}\u001a\u00020\u0015H\u0002J\u000e\u0010~\u001a\u00020T2\u0006\u0010\u007f\u001a\u00020\u0015J\u0010\u0010\u0080\u0001\u001a\u00020T2\u0007\u0010\u0081\u0001\u001a\u00020\u0015J\u000f\u0010\u0082\u0001\u001a\u00020T2\u0006\u0010\u0017\u001a\u00020\u0015J\u0012\u0010\u0083\u0001\u001a\u00020T2\u0007\u0010\u0084\u0001\u001a\u00020\u0015H\u0002J\u0012\u0010\u0085\u0001\u001a\u00020T2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010HJ\u0011\u0010\u0087\u0001\u001a\u00020T2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001J\u0011\u0010\u008a\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0002J\t\u0010\u008b\u0001\u001a\u00020TH\u0002J\t\u0010\u008c\u0001\u001a\u00020TH\u0002J\u0012\u0010\u008d\u0001\u001a\u00020T2\u0007\u0010\u008e\u0001\u001a\u00020\u0015H\u0016J\t\u0010\u008f\u0001\u001a\u00020TH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0004\n\u0002\u00104R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010%\u001a\u0004\b9\u0010:R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010>\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010%\u001a\u0004\b@\u0010AR2\u0010C\u001a&\u0012\f\u0012\n F*\u0004\u0018\u00010E0E F*\u0012\u0012\f\u0012\n F*\u0004\u0018\u00010E0E\u0018\u00010D0DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010O\u001a\n F*\u0004\u0018\u00010P0PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0091\u0001"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView;", "Lcom/baidu/tieba/immessagecenter/arch/view/BaseView;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterChatTabUiState;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterChatTabUiIntent;", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/vm/MsgChatCenterSliceViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/baidu/tieba/immessagecenter/msgtab/adapt/IMsgAdapterProxy;", "frag", "Lcom/baidu/tbadk/core/BaseFragment;", "slice", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterSlice;", "pageSource", "", "(Lcom/baidu/tbadk/core/BaseFragment;Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterSlice;Ljava/lang/String;)V", "context", "Landroid/content/Context;", "dialog", "Landroidx/appcompat/app/AlertDialog;", "getFrag", "()Lcom/baidu/tbadk/core/BaseFragment;", "isEnterGroupChatPage", "", "isFirstPrimary", "isNeedRefresh", "isPageShowBeStatistic", "isRefresh", "isShowOpenNotification", "isShowShutDownValidate", "mChatListAdapter", "Lcom/baidu/tieba/immessagecenter/im/chat/notify/MessageAggregationListAdapter;", "mFooterView", "Landroid/view/View;", "mHeaderContainer", "Landroid/widget/RelativeLayout;", "getMHeaderContainer", "()Landroid/widget/RelativeLayout;", "mHeaderContainer$delegate", "Lkotlin/Lazy;", "mIProcessImpl", "Lcom/baidu/tieba/im/chat/notify/IProcess;", "mMenuDialog", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "getMMenuDialog", "()Lcom/baidu/tbadk/core/dialog/PopupDialog;", "setMMenuDialog", "(Lcom/baidu/tbadk/core/dialog/PopupDialog;)V", "mMenuListener", "Lcom/baidu/tbadk/core/dialog/PopupDialogView$OnItemClickListener;", "mNoDataView", "Lcom/baidu/tbadk/core/view/NoDataView;", "mOnNotificationViewCloseListener", "com/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView$mOnNotificationViewCloseListener$1", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView$mOnNotificationViewCloseListener$1;", "mOnPullRefreshListener", "Lcom/baidu/tbadk/core/view/TbListCommonPullView$ListPullRefreshListener;", "mOpenNotificationView", "Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView;", "getMOpenNotificationView", "()Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView;", "mOpenNotificationView$delegate", "mProgressDialog", "Lcom/baidu/tbadk/core/dialog/BdProgressDialog1080;", "mPullView", "Lcom/baidu/tbadk/core/view/TbListViewPullView;", "getMPullView", "()Lcom/baidu/tbadk/core/view/TbListViewPullView;", "mPullView$delegate", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "kotlin.jvm.PlatformType", "renderCallBack", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/listener/MsgChatDataChangedCallBack;", "getSlice", "()Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterSlice;", "srcNotifyId", "", "tbAlertBuilder", "Lcom/baidu/tbadk/core/dialog/TBAlertBuilder;", "uniqueId", "Lcom/baidu/adp/BdUniqueId;", "viewBinding", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgChatCenterSliceView$ViewBinding;", "actionToGroupChatPage", "", "data", "Lcom/baidu/tbadk/core/data/ImMessageCenterShowItemData;", "dismissDialog", "exitMsgGroupChat", "hideNotificationView", "init", "initNoDataView", "initView", "initViewModel", "jumpGroupChatPageStatistic", "roomId", "", "notifyDataSetChanged", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCompleteProcess", "onCreate", MissionEvent.MESSAGE_DESTROY, "onFinishInflate", "onNetworkChange", "hasNetwork", "onNewIntent", "intent", "Landroid/content/Intent;", "onPrimary", "onRender", "state", "onResumes", "onStart", MissionEvent.MESSAGE_STOP, "onViewCreated", "prepareMenuDialog", "pullRefreshData", "reenterMsgGroupChat", "refreshPageData", "refreshUserList", "renderData", "", "resetDispatcher", "setChatListViewVisible", "isVisible", "setIsFirstPrimary", "isFirst", "setIsRefreshing", "isRefreshing", "setNeedRefresh", "setNoDataViewVisible", UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, "setRenderCallBack", "callBack", "setSrcNotifyId", StateManager.KEY_STATE, "Landroid/os/Bundle;", "showDeleteConfirmDialog", "showNotificationView", "showProgressDialog", "shutDownValidate", "isValid", "stateInvitationEntranceShow", "ViewBinding", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgChatCenterSliceView extends BaseView<mo8, lo8, MsgChatCenterSliceViewModel> implements LifecycleObserver, bm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public final z78 C;
    public final b D;
    public final aa5.g E;
    public final BaseFragment e;
    public final String f;
    public final Context g;
    public final TbPageContext<BaseFragmentActivity> h;
    public final BdUniqueId i;
    public a j;
    public MessageAggregationListAdapter k;
    public View l;
    public NoDataView m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public p55 q;
    public r55.f r;
    public AlertDialog s;
    public TBAlertBuilder t;
    public j55 u;
    public int v;
    public mm8 w;
    public boolean x;
    public boolean y;
    public boolean z;

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final C0352a f;
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
            f = new C0352a(null);
        }

        /* renamed from: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0352a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ C0352a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public C0352a() {
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
                    View findViewById = root.findViewById(R.id.obfuscated_res_0x7f0921d7);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.slice_msg_chat_root)");
                    aVar.j((RelativeLayout) findViewById);
                    View findViewById2 = root.findViewById(R.id.obfuscated_res_0x7f0917bd);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.msg_round_corner_container)");
                    aVar.g((RoundRelativeLayout) findViewById2);
                    View findViewById3 = root.findViewById(R.id.obfuscated_res_0x7f091788);
                    Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.msg_center_chat_list)");
                    aVar.f((BdListView) findViewById3);
                    View findViewById4 = root.findViewById(R.id.obfuscated_res_0x7f091789);
                    Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.m…nter_chat_refresh_layout)");
                    aVar.h((BdSwipeRefreshLayout) findViewById4);
                    View findViewById5 = root.findViewById(R.id.obfuscated_res_0x7f0917ce);
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
            aVar.a().removeHeaderView(this.a.Y());
            this.a.z = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgChatCenterSliceView(BaseFragment frag, MsgChatCenterSlice slice, String pageSource) {
        super(R.layout.obfuscated_res_0x7f0d08a0);
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
        this.n = LazyKt__LazyJVMKt.lazy(new Function0<NotificationView>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$mOpenNotificationView$2
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
        this.o = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$mHeaderContainer$2
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
                NotificationView a0;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (RelativeLayout) invokeV.objValue;
                }
                context = this.this$0.g;
                RelativeLayout relativeLayout = new RelativeLayout(context);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout.setGravity(17);
                relativeLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_W_X003));
                a0 = this.this$0.a0();
                relativeLayout.addView(a0);
                return relativeLayout;
            }
        });
        this.p = LazyKt__LazyJVMKt.lazy(new Function0<ba5>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$mPullView$2
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
            public final ba5 invoke() {
                InterceptResult invokeV;
                TbPageContext tbPageContext;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (ba5) invokeV.objValue;
                }
                tbPageContext = this.this$0.h;
                return new ba5(tbPageContext);
            }
        });
        this.v = 16;
        this.y = true;
        this.A = true;
        this.C = new z78(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView$mIProcessImpl$1
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

            @Override // com.baidu.tieba.z78
            public void onCanceled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.W();
            }

            @Override // com.baidu.tieba.z78
            public void onPostExecute() {
                TbPageContext tbPageContext;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                    return;
                }
                this.a.W();
                tbPageContext = this.a.h;
                tbPageContext.showToast(R.string.delete_success, false);
                this.a.k0();
            }

            @Override // com.baidu.tieba.z78
            public void onPreExecute() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                    return;
                }
                this.a.I0();
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
                r6 = r4.a.u;
             */
            @Override // com.baidu.tieba.z78
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onProgressUpdate(int i3, String id, int i4) {
                j55 j55Var;
                j55 j55Var2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i3), id, Integer.valueOf(i4)}) == null) {
                    Intrinsics.checkNotNullParameter(id, "id");
                    j55Var = this.a.u;
                    if (j55Var != null && j55Var2 != null) {
                        j55Var2.b(i3);
                    }
                }
            }
        };
        this.D = new b(this);
        this.E = new aa5.g() { // from class: com.baidu.tieba.fn8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.aa5.g
            public final void f(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    MsgChatCenterSliceView.i0(MsgChatCenterSliceView.this, z);
                }
            }
        };
    }

    public static final void F0(MsgChatCenterSliceView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            AlertDialog alertDialog = this$0.s;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }
    }

    public static final void i0(MsgChatCenterSliceView this$0, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, this$0, z) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.z0(true);
            this$0.s0();
            a aVar = this$0.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.c().setRefreshing(false);
        }
    }

    public static final void G0(MsgChatCenterSliceView this$0, ImMessageCenterShowItemData data, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, data, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            AlertDialog alertDialog = this$0.s;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            StatisticItem statisticItem = new StatisticItem("c14670");
            if (ik8.a(data)) {
                statisticItem.param("obj_type", 1);
            } else if (ik8.b(data)) {
                statisticItem.param("obj_type", 3);
            } else {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
            this$0.m().m(data, this$0.C);
        }
    }

    public static final void m0(MsgChatCenterSliceView this$0) {
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
            this.x = z;
        }
    }

    public final void C0(mm8 mm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mm8Var) == null) {
            this.w = mm8Var;
        }
    }

    public final void D0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            this.v = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, 16);
        }
    }

    public final void onNewIntent(Intent intent) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, intent) == null) {
            if (intent != null) {
                i = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            } else {
                i = 16;
            }
            this.v = i;
            if (i == -1) {
                return;
            }
            A0(true);
            n0();
        }
    }

    public final void v0(List<? extends ImMessageCenterShowItemData> data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            MessageAggregationListAdapter messageAggregationListAdapter = this.k;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.u(data);
            }
        }
    }

    public final void y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.y = z;
        }
    }

    public static final void f0(MsgChatCenterSliceView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            r95.p().A("is_shut_down_validate", true);
            this$0.A = false;
            a aVar = this$0.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.d().setVisibility(8);
        }
    }

    public final void h0(ImMessageCenterShowItemData data, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048597, this, data, j) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 3).param("fid", data.getForumId()).param("room_id", j));
        }
    }

    public static final void r0(MsgChatCenterSliceView this$0, String menuDelete, ImMessageCenterShowItemData data, String menuMarkTop, String menuMarkCancelTop, String menuNoTip, String menuNoTipCancel, r55 r55Var, int i, View view2) {
        boolean z;
        p55 p55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{this$0, menuDelete, data, menuMarkTop, menuMarkCancelTop, menuNoTip, menuNoTipCancel, r55Var, Integer.valueOf(i), view2}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(menuDelete, "$menuDelete");
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(menuMarkTop, "$menuMarkTop");
            Intrinsics.checkNotNullParameter(menuMarkCancelTop, "$menuMarkCancelTop");
            Intrinsics.checkNotNullParameter(menuNoTip, "$menuNoTip");
            Intrinsics.checkNotNullParameter(menuNoTipCancel, "$menuNoTipCancel");
            p55 p55Var2 = this$0.q;
            if (p55Var2 != null && p55Var2.isShowing()) {
                z = true;
            } else {
                z = false;
            }
            if (z && (p55Var = this$0.q) != null) {
                p55Var.dismiss();
            }
            if (view2 != null) {
                String obj = ((EMTextView) view2).getText().toString();
                if (Intrinsics.areEqual(menuDelete, obj)) {
                    TiebaStatic.log("c12933");
                    StatisticItem statisticItem = new StatisticItem("c14665");
                    if (ik8.a(data)) {
                        statisticItem.param("obj_type", 1);
                    } else if (ik8.b(data)) {
                        statisticItem.param("obj_type", 3);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    TiebaStatic.log(statisticItem);
                    this$0.E0(data);
                    return;
                } else if (Intrinsics.areEqual(menuMarkTop, obj)) {
                    StatisticItem statisticItem2 = new StatisticItem("c14664");
                    statisticItem2.param("obj_type", 1);
                    if (ik8.b(data)) {
                        statisticItem2.param("obj_source", 2);
                        long currentTimeMillis = System.currentTimeMillis();
                        ua8.b().g(Long.valueOf(vg.g(data.getFriendId(), 0L)), data.getFriendNameShow(), data.getFriendBjhAvatar(), currentTimeMillis);
                        data.setMarkTopIndex(currentTimeMillis);
                        this$0.m().B(true);
                    } else {
                        statisticItem2.param("obj_source", 1);
                        hc8.c(data.getFriendId(), true);
                    }
                    TiebaStatic.log(statisticItem2);
                    return;
                } else if (Intrinsics.areEqual(menuMarkCancelTop, obj)) {
                    StatisticItem statisticItem3 = new StatisticItem("c14664");
                    statisticItem3.param("obj_type", 2);
                    if (ik8.b(data)) {
                        statisticItem3.param("obj_source", 2);
                        ua8.b().g(Long.valueOf(vg.g(data.getFriendId(), 0L)), data.getFriendNameShow(), data.getFriendBjhAvatar(), 0L);
                        data.setMarkTopIndex(0L);
                        this$0.m().B(true);
                    } else {
                        statisticItem3.param("obj_source", 1);
                        hc8.c(data.getFriendId(), false);
                    }
                    TiebaStatic.log(statisticItem3);
                    return;
                } else if (Intrinsics.areEqual(menuNoTip, obj)) {
                    StatisticItem statisticItem4 = new StatisticItem("c14669");
                    statisticItem4.param("obj_type", 1);
                    if (ik8.c(data)) {
                        statisticItem4.param("obj_source", 1);
                        String friendId = data.getFriendId();
                        Intrinsics.checkNotNullExpressionValue(friendId, "data.friendId");
                        this$0.m().r(true, friendId);
                    } else if (ik8.b(data)) {
                        statisticItem4.param("obj_source", 2);
                        ua8.b().f(Long.valueOf(vg.g(data.getFriendId(), 0L)), data.getFriendNameShow(), data.getFriendBjhAvatar(), false);
                        data.setNotify(false);
                        this$0.m().B(false);
                        this$0.m().E(null, data, 5);
                    }
                    TiebaStatic.log(statisticItem4);
                    return;
                } else if (Intrinsics.areEqual(menuNoTipCancel, obj)) {
                    StatisticItem statisticItem5 = new StatisticItem("c14669");
                    statisticItem5.param("obj_type", 2);
                    if (ik8.c(data)) {
                        statisticItem5.param("obj_source", 1);
                        String friendId2 = data.getFriendId();
                        Intrinsics.checkNotNullExpressionValue(friendId2, "data.friendId");
                        this$0.m().r(false, friendId2);
                    } else if (ik8.b(data)) {
                        statisticItem5.param("obj_source", 2);
                        ua8.b().f(Long.valueOf(vg.g(data.getFriendId(), 0L)), data.getFriendNameShow(), data.getFriendBjhAvatar(), true);
                        data.setNotify(true);
                        this$0.m().B(false);
                        this$0.m().E(null, data, 5);
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

    public final void B0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                x0(false);
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
                    noDataView2.setTextOption(NoDataViewFactory.e.d(null, this.g.getResources().getString(R.string.obfuscated_res_0x7f0f0ca7)));
                }
                NoDataView noDataView3 = this.m;
                if (noDataView3 != null) {
                    noDataView3.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE));
                    return;
                }
                return;
            }
            x0(true);
            NoDataView noDataView4 = this.m;
            if (noDataView4 != null) {
                noDataView4.setVisibility(8);
            }
        }
    }

    public final void V(ImMessageCenterShowItemData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (!TextUtils.isEmpty(data.getGroupJumpUrl())) {
                String friendId = data.getFriendId();
                Intrinsics.checkNotNullExpressionValue(friendId, "data.friendId");
                long parseLong = Long.parseLong(friendId);
                yo5.a().d(this.g, parseLong, "source_from_message_tab", 3);
                h0(data, parseLong);
                m().o().t(true);
            }
        }
    }

    public final void l0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048600, this, z) != null) || !z) {
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
            yg.a().post(new Runnable() { // from class: com.baidu.tieba.mn8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MsgChatCenterSliceView.m0(MsgChatCenterSliceView.this);
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: o0 */
    public void D(mo8 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (state instanceof mo8.f) {
                v0(((mo8.f) state).a());
            } else if (state instanceof mo8.d) {
                k0();
            } else if (state instanceof mo8.c) {
                j0();
            } else if (state instanceof mo8.e) {
                z0(((mo8.e) state).a());
            } else if (state instanceof mo8.b) {
                if (((mo8.b) state).a()) {
                    H0();
                } else {
                    c0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.bm8
    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            bm8.a.a(this, z);
            a aVar = null;
            if (z) {
                if (this.A) {
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

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j = a.f.a(l());
            e0();
        }
    }

    public final void W() {
        j55 j55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (j55Var = this.u) != null) {
            boolean z = true;
            if ((j55Var == null || !j55Var.isShowing()) ? false : false) {
                j55 j55Var2 = this.u;
                if (j55Var2 != null) {
                    j55Var2.dismiss();
                }
                this.u = null;
            }
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            m().o().I();
        }
    }

    public final RelativeLayout Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return (RelativeLayout) this.o.getValue();
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final p55 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.q;
        }
        return (p55) invokeV.objValue;
    }

    public final NotificationView a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (NotificationView) this.n.getValue();
        }
        return (NotificationView) invokeV.objValue;
    }

    public final ba5 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return (ba5) this.p.getValue();
        }
        return (ba5) invokeV.objValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().removeHeaderView(Y());
            this.z = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: g0 */
    public MsgChatCenterSliceViewModel q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = this.e.getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "frag.pageContext");
            return new MsgChatCenterSliceViewModel(pageContext);
        }
        return (MsgChatCenterSliceViewModel) invokeV.objValue;
    }

    public final void j0() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (messageAggregationListAdapter = this.k) != null) {
            messageAggregationListAdapter.notifyDataSetChanged();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            m().s();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResumes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            u0();
            J0();
            NotificationChangedMonitor.c.a().i();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (noDataView = this.m) != null) {
            noDataView.d(this.h);
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().E();
            NotificationChangedMonitor.c.a().i();
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            TbSingleton.getInstance().setNeedJoinChatRoom(true);
            s0();
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            m().C();
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            TbSingleton.getInstance().setNeedJoinChatRoom(false);
            m().o().I();
        }
    }

    public final void E0(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, imMessageCenterShowItemData) != null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.unfriend_del, TBAlertConfig.OperateBtnStyle.ALERT);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.unfriend_cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        int i = R.string.obfuscated_res_0x7f0f1472;
        if (Intrinsics.areEqual("9", imMessageCenterShowItemData.getOwnerName())) {
            i = R.string.obfuscated_res_0x7f0f1473;
        }
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        Intrinsics.checkNotNull(currentActivity);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(currentActivity);
        this.t = tBAlertBuilder;
        Intrinsics.checkNotNull(tBAlertBuilder);
        tBAlertBuilder.w(R.string.obfuscated_res_0x7f0f1687);
        tBAlertBuilder.m(i);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        this.s = tBAlertBuilder.z();
        aVar2.a(new View.OnClickListener() { // from class: com.baidu.tieba.cn8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    MsgChatCenterSliceView.F0(MsgChatCenterSliceView.this, view2);
                }
            }
        });
        aVar.a(new View.OnClickListener() { // from class: com.baidu.tieba.rn8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    MsgChatCenterSliceView.G0(MsgChatCenterSliceView.this, imMessageCenterShowItemData, view2);
                }
            }
        });
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.z) {
            a0().setOnCloseListener(this.D);
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().w(Y(), 0);
            this.z = true;
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            W();
            if (this.u == null) {
                this.u = c98.l().o(this.g);
            }
            j55 j55Var = this.u;
            if (j55Var != null) {
                j55Var.show();
            }
            j55 j55Var2 = this.u;
            if (j55Var2 != null) {
                j55Var2.b(0);
            }
        }
    }

    public final void n0() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.k;
            if (messageAggregationListAdapter != null && messageAggregationListAdapter.getCount() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                A0(true);
            }
            if (this.y || this.x) {
                this.y = false;
                this.x = false;
                s0();
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            int g = xi.g(this.g, R.dimen.tbds385);
            Context context = this.g;
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            NoDataView a2 = NoDataViewFactory.a(context, aVar.e(), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, g), NoDataViewFactory.e.d(null, this.g.getResources().getString(R.string.obfuscated_res_0x7f0f0ca7)), null);
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

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            d0();
            this.l = new View(this.g);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, xi.g(this.g, R.dimen.obfuscated_res_0x7f07036f));
            View view2 = this.l;
            if (view2 != null) {
                view2.setLayoutParams(layoutParams);
            }
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.d().setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.kn8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        MsgChatCenterSliceView.f0(MsgChatCenterSliceView.this, view3);
                    }
                }
            });
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
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
            m().y();
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            a aVar = this.j;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar = null;
            }
            aVar.a().z(0L);
            if (m().n().getData() != null && ListUtils.getCount(m().n().getData()) > 0) {
                mm8 mm8Var = this.w;
                if (mm8Var != null) {
                    mm8Var.a(true);
                }
                B0(false);
                MessageAggregationListAdapter messageAggregationListAdapter = this.k;
                Intrinsics.checkNotNull(messageAggregationListAdapter);
                messageAggregationListAdapter.u(m().n().getData());
                if (!this.B) {
                    this.B = true;
                    uo8.a.a("0");
                    return;
                }
                return;
            }
            mm8 mm8Var2 = this.w;
            if (mm8Var2 != null) {
                mm8Var2.a(false);
            }
            B0(true);
            uo8.a.a("1");
        }
    }

    @Override // com.baidu.tieba.sd8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            j0();
            b0().H(i);
            NoDataView noDataView = this.m;
            if (noDataView != null) {
                noDataView.f(this.h, i);
            }
            a0().a(i);
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
            s75 d = s75.d(aVar4.e());
            d.o(R.string.J_X19);
            d.f(R.color.CAM_X0201);
            a aVar5 = this.j;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar5 = null;
            }
            s75.d(aVar5.c()).f(R.color.CAM_X0201);
            a aVar6 = this.j;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar6 = null;
            }
            s75.d(aVar6.b()).f(R.color.CAM_X0201);
            a aVar7 = this.j;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar7 = null;
            }
            s75 d2 = s75.d(aVar7.a());
            d2.o(R.string.J_X19);
            d2.f(R.color.CAM_X0201);
            if (Intrinsics.areEqual("FRS", this.f)) {
                float g = xi.g(this.g, R.dimen.tbds52);
                float[] fArr = {g, g, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
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
            aVar2.a().setPadding(0, xi.g(this.g, R.dimen.M_H_X003), 0, 0);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void p(Context context) {
        ViewParent parent;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, context) == null) {
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
            a2.setOnItemClickListener(new nm8(context, uniqueId, this, this.k, m()));
            a aVar4 = this.j;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                aVar4 = null;
            }
            BdListView a3 = aVar4.a();
            TbPageContext<BaseFragmentActivity> pageContext = this.h;
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            a3.setOnItemLongClickListener(new om8(pageContext, this, this.k));
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
            b0().f(this.E);
            b0().a0(this.h.getUniqueId());
            View view2 = b0().getView();
            if (view2 != null && (parent = view2.getParent()) != null) {
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(b0().getView());
                }
            }
            a aVar7 = this.j;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                aVar2 = aVar7;
            }
            aVar2.c().setProgressView(b0());
            p0();
        }
    }

    public final boolean q0(final ImMessageCenterShowItemData data) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            final String string = this.g.getString(R.string.delete_user_chat);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.delete_user_chat)");
            final String string2 = this.g.getString(R.string.obfuscated_res_0x7f0f169a);
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
            r55.f fVar = new r55.f() { // from class: com.baidu.tieba.an8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.r55.f
                public final void M0(r55 r55Var, int i, View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, r55Var, i, view2) == null) {
                        MsgChatCenterSliceView.r0(MsgChatCenterSliceView.this, string, data, string2, string3, string4, string5, r55Var, i, view2);
                    }
                }
            };
            ArrayList arrayList = new ArrayList(5);
            if (ik8.a(data)) {
                arrayList.add(str);
                arrayList.add(string);
            } else if (ik8.c(data)) {
                arrayList.add(str3);
                arrayList.add(string);
            } else if (!ik8.b(data)) {
                return false;
            } else {
                arrayList.add(str);
                arrayList.add(str3);
                arrayList.add(string);
            }
            this.r = fVar;
            this.q = new p55(this.h);
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                p55 p55Var = this.q;
                if (p55Var != null) {
                    p55Var.i(null, strArr, this.r);
                    return true;
                }
                return true;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        return invokeL.booleanValue;
    }

    public final void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
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

    public final void z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
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
}
