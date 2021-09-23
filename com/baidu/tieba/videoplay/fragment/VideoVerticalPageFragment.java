package com.baidu.tieba.videoplay.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import c.a.q0.f1.q.b;
import c.a.q0.s.q.d2;
import c.a.r0.x0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VideoNotifyPersonalPageData;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tbadk.util.OnActivityFinishListener;
import com.baidu.tbadk.util.SimpleMessageListener;
import com.baidu.tieba.R;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.FrsVideoTabPlayActivity;
import com.baidu.tieba.videoplay.VideoPlayActivity;
import com.baidu.tieba.videoplay.VideoPlayActivityStatic;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.tieba.videoplay.model.FrsVideoTabModel;
import com.baidu.tieba.videoplay.model.VideoChannelModel;
import com.baidu.tieba.videoplay.model.VideoPersonalModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VideoRedIcon.RedIcon;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002«\u0001B8\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010b\u0012\f\b\u0002\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u0001\u0012\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u0013\u0012\b\b\u0002\u0010f\u001a\u00020\u0013¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\u001aH\u0002¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\u001aH\u0002¢\u0006\u0004\b!\u0010\u001cJ\u000f\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\"\u0010\u001cJ\u000f\u0010#\u001a\u00020\u001aH\u0002¢\u0006\u0004\b#\u0010\u001cJ\u000f\u0010$\u001a\u00020\u001aH\u0002¢\u0006\u0004\b$\u0010\u001cJ\u000f\u0010%\u001a\u00020\u001aH\u0002¢\u0006\u0004\b%\u0010\u001cJ)\u0010)\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J)\u0010/\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b/\u0010\u0019J\u0017\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0013H\u0016¢\u0006\u0004\b1\u00102J-\u00108\u001a\u0004\u0018\u0001072\u0006\u00104\u001a\u0002032\b\u00106\u001a\u0004\u0018\u0001052\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0003H\u0016¢\u0006\u0004\b:\u0010\u0005J\u000f\u0010;\u001a\u00020\u0003H\u0016¢\u0006\u0004\b;\u0010\u0005J\u000f\u0010<\u001a\u00020\u0003H\u0016¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010=\u001a\u00020\u0003H\u0016¢\u0006\u0004\b=\u0010\u0005J\u000f\u0010>\u001a\u00020\u0003H\u0016¢\u0006\u0004\b>\u0010\u0005J\u000f\u0010?\u001a\u00020\u0003H\u0002¢\u0006\u0004\b?\u0010\u0005J\u0017\u0010A\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u0013H\u0002¢\u0006\u0004\bA\u00102J\u0017\u0010C\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u001aH\u0016¢\u0006\u0004\bC\u0010DJ\u0017\u0010F\u001a\u00020\u00032\b\u0010E\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0003H\u0002¢\u0006\u0004\bH\u0010\u0005J\u000f\u0010I\u001a\u00020\u0003H\u0002¢\u0006\u0004\bI\u0010\u0005J%\u0010N\u001a\u00020\u00032\u0006\u0010K\u001a\u00020J2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020J0LH\u0002¢\u0006\u0004\bN\u0010OJ'\u0010P\u001a\u00020\u00032\b\u0010K\u001a\u0004\u0018\u00010J2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020J0LH\u0002¢\u0006\u0004\bP\u0010OJ\u000f\u0010Q\u001a\u00020\u0003H\u0002¢\u0006\u0004\bQ\u0010\u0005R\u0016\u0010S\u001a\u00020R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010V\u001a\u00020U8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010]\u001a\u00020\\8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010B\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010`R\u0018\u0010a\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010[R\u0018\u0010c\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010e\u001a\u00020R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010TR\u0016\u0010f\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010TR\u0018\u0010i\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010jR\u0018\u0010m\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010o\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010`R\u0018\u0010p\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010jR\u0018\u0010r\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010t\u001a\u00020R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010TR\u0018\u0010u\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010jR\u0016\u0010v\u001a\u00020R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010TR\u0018\u0010x\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010z\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010|\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010jR\u0016\u0010}\u001a\u00020R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010TR\u0019\u0010\u007f\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0081\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010gR\u001c\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u0088\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010gR\u0018\u0010\u0089\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010`R\u0018\u0010\u008a\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010gR$\u0010\u008c\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001c\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R*\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0096\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R*\u0010 \u0001\u001a\u00030\u009f\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R\u001c\u0010§\u0001\u001a\u0005\u0018\u00010¦\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001¨\u0006¬\u0001"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment;", "Lc/a/r0/z3/f/a;", "Lcom/baidu/tbadk/core/BaseFragment;", "", "frsStepStat", "()V", "", "getCurrentPageKey", "()Ljava/lang/String;", "", "getFirstVideoTid", "()Ljava/lang/Long;", "getLastVideoTid", "getMissionTid", "()J", "getShowVideoTid", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "getVEventListener", "()Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "", "requestCode", MiPushCommandMessage.KEY_RESULT_CODE, "Landroid/content/Intent;", "data", "handleActivityResult", "(IILandroid/content/Intent;)V", "", "handleBackPress", "()Z", "handleIndexMessage", "initData", "isFromPersonalPage", "isFrsVideoTab", "isPersonalPlay", "isPersonalSharePlay", "isRecommendPlay", "isRecommendPlayOrPersonalPlay", "isShareThread", "isDelete", "isDeleteSucceed", "deleteErrorMessage", "notifyPersonalPage", "(ZZLjava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/os/Bundle;)V", "onActivityResult", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "processVideoPersonalModel", "height", "setEmptyHeight", "isVisibleToUser", "setUserVisibleHint", "(Z)V", "listener", "setVideoPlayViewEventListener", "(Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;)V", "showData", "stepStat", "Lcom/baidu/tieba/video/VideoItemData;", "originalData", "", "newList", "syncFirstVideoFollowState", "(Lcom/baidu/tieba/video/VideoItemData;Ljava/util/List;)V", "syncFirstVideoThreadData", "updateYoungsterMode", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "backGroundListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "eventListener", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "firstVideoTid", "Ljava/lang/Long;", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "goPbCommentFloatListener", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "isVertail", "Z", "lastVideoTid", "Lcom/baidu/adp/BdUniqueId;", "mActivityPageUniqueId", "Lcom/baidu/adp/BdUniqueId;", "mAdCloseListener", "mCurrentType", "I", "mFeedBackListener", "mFrom", "Ljava/lang/String;", "mFromPage", "Lcom/baidu/tieba/videoplay/model/FrsVideoTabModel;", "mFrsVideoTabModel", "Lcom/baidu/tieba/videoplay/model/FrsVideoTabModel;", "mHasMore", "mLocate", "Lcom/baidu/tieba/videoplay/nad/AdVideoFlowDispatcher;", "mNAdDispatcher", "Lcom/baidu/tieba/videoplay/nad/AdVideoFlowDispatcher;", "mNetworkChangedMessageListener", "mObjId", "mRecommendTabInsertDataListener", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "mUEGFeedBackListener", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoChannelModel", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoIndex", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "mVideoPlayModel", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoShowIndex", "mVideoTabReqFunAd", "mainPageType", "Lcom/baidu/tbadk/util/OnActivityFinishListener;", "onActivityFinishListener", "Lcom/baidu/tbadk/util/OnActivityFinishListener;", "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "onDeleteSelfPostListener", "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "Lcom/baidu/tbadk/core/atomData/VideoRecommentPlayActivityConfig$PersonalPageParams;", "personalPageParams", "Lcom/baidu/tbadk/core/atomData/VideoRecommentPlayActivityConfig$PersonalPageParams;", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallbackFra", "getProgressViewCallbackFra", "()Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "setProgressViewCallbackFra", "(Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;)V", "Lcom/baidu/tieba/videoplay/model/VideoPersonalModel;", "videoPersonalModel", "Lcom/baidu/tieba/videoplay/model/VideoPersonalModel;", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "getViewPagerBottomScrollMoreCallback", "()Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "setViewPagerBottomScrollMoreCallback", "(Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;)V", "Landroid/widget/RelativeLayout;", "youngsterVerticalLayout", "Landroid/widget/RelativeLayout;", "<init>", "(Lcom/baidu/adp/BdUniqueId;Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;II)V", "OnDeleteSelfPostListener", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class VideoVerticalPageFragment extends BaseFragment implements c.a.r0.z3.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public final VideoPlayFragment.GoPbCommentFloatListener B;
    public OnActivityFinishListener<Unit> C;
    public OnDeleteSelfPostListener D;
    public b.InterfaceC0664b E;
    public final CustomMessageListener F;
    public c.a.r0.z3.g.a G;
    public final CustomMessageListener H;
    public final CustomMessageListener I;
    public final CustomMessageListener J;
    public final CustomMessageListener K;
    public BdSwipeRefreshLayout.k L;
    public VideoPlayView.g M;
    public final CustomMessageListener N;
    public final BdUniqueId O;
    public final BdSwipeRefreshLayout.k P;
    public final int Q;
    public final int R;

    /* renamed from: e  reason: collision with root package name */
    public View f58128e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayView f58129f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f58130g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.r0.z3.c.d f58131h;

    /* renamed from: i  reason: collision with root package name */
    public int f58132i;

    /* renamed from: j  reason: collision with root package name */
    public int f58133j;
    public Rect k;
    public String l;
    public String m;
    public boolean n;
    public String o;
    public String p;
    public boolean q;
    public VideoRecommentPlayActivityConfig.PersonalPageParams r;
    public Long s;
    public Long t;
    public String u;
    public VideoPlayModel v;
    public VideoChannelModel w;
    public VideoPersonalModel x;
    public FrsVideoTabModel y;
    public boolean z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB/\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u001a\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "Lcom/baidu/tbadk/util/SimpleMessageListener;", "Lcom/baidu/tbadk/TbPageContext;", "pageContext", "Lcom/baidu/tbadk/util/SimpleMessageListener$Callback;", "Landroidx/core/util/Pair;", "", "", "callback", "<init>", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tbadk/util/SimpleMessageListener$Callback;)V", "Companion", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class OnDeleteSelfPostListener extends SimpleMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public static final a Companion;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @JvmStatic
            public final void a(TbPageContext<?> tbPageContext, Pair<Boolean, String> pair) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, pair) == null) {
                    SimpleMessageListener.sendMessage(2001460, tbPageContext, pair);
                }
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1353115444, "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1353115444, "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;");
                    return;
                }
            }
            Companion = new a(null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnDeleteSelfPostListener(TbPageContext<?> tbPageContext, SimpleMessageListener.b<Pair<Boolean, String>> bVar) {
            super(2001460, false, bVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, bVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), (SimpleMessageListener.b) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            bindPage(tbPageContext);
        }

        @JvmStatic
        public static final void sendMessage(TbPageContext<?> tbPageContext, Pair<Boolean, String> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, tbPageContext, pair) == null) {
                Companion.a(tbPageContext, pair);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58134a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoVerticalPageFragment videoVerticalPageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58134a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                BackgroundSwitchMessage backgroundSwitchMessage = (BackgroundSwitchMessage) customResponsedMessage;
                if (backgroundSwitchMessage.getData() instanceof Boolean) {
                    Boolean isBackground = backgroundSwitchMessage.getData();
                    Intrinsics.checkExpressionValueIsNotNull(isBackground, "isBackground");
                    if (isBackground.booleanValue()) {
                        boolean z = false;
                        if (c.a.e.a.b.f().b() instanceof c.a.r0.m3.a) {
                            Activity b2 = c.a.e.a.b.f().b();
                            if (b2 != null) {
                                if (((c.a.r0.m3.a) b2).getCurrentTabType() == 22) {
                                    z = true;
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type com.baidu.tieba.tblauncher.IMaintabType");
                            }
                        }
                        if ((this.f58134a.A && z) || ((c.a.e.a.b.f().b() instanceof VideoPlayActivity) && (this.f58134a.getActivity() instanceof VideoPlayActivity))) {
                            this.f58134a.s();
                        }
                        if (!z && (c.a.e.a.b.f().b() instanceof FrsVideoTabPlayActivity) && (this.f58134a.getActivity() instanceof FrsVideoTabPlayActivity)) {
                            this.f58134a.g();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements b.InterfaceC0664b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58135e;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58135e = videoVerticalPageFragment;
        }

        @Override // c.a.q0.f1.q.b.InterfaceC0664b
        public void onViewClick() {
            VideoPlayView videoPlayView;
            b.InterfaceC0664b currentFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoPlayView = this.f58135e.f58129f) == null || (currentFragment = videoPlayView.getCurrentFragment()) == null) {
                return;
            }
            currentFragment.onViewClick();
        }

        @Override // c.a.q0.f1.q.b.InterfaceC0664b
        public void onViewDoubleClick(float f2, float f3) {
            VideoPlayView videoPlayView;
            b.InterfaceC0664b currentFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (videoPlayView = this.f58135e.f58129f) == null || (currentFragment = videoPlayView.getCurrentFragment()) == null) {
                return;
            }
            currentFragment.onViewDoubleClick(f2, f3);
        }

        @Override // c.a.q0.f1.q.b.InterfaceC0664b
        public void onViewDragToRight() {
            VideoPlayView videoPlayView;
            b.InterfaceC0664b currentFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (videoPlayView = this.f58135e.f58129f) == null || (currentFragment = videoPlayView.getCurrentFragment()) == null) {
                return;
            }
            currentFragment.onViewDragToRight();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements SimpleMessageListener.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58136a;

        public c(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58136a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.util.SimpleMessageListener.b
        /* renamed from: a */
        public final void call(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                this.f58136a.setInterceptStimeStat(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58137a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public d(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58137a = videoVerticalPageFragment;
        }

        @Override // c.a.r0.x0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && c.a.r0.x0.a.i().m("6061002332-203360688") && this.f58137a.f58129f != null) {
                c.a.r0.z3.c.d dVar = this.f58137a.f58131h;
                VideoPlayView videoPlayView = this.f58137a.f58129f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.currentSelectIndex);
                VideoPlayView videoPlayView2 = this.f58137a.f58129f;
                if (videoPlayView2 != null) {
                    videoPlayView2.notifyDataSetChanged();
                }
            }
        }

        @Override // c.a.r0.x0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58138a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public e(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58138a = videoVerticalPageFragment;
        }

        @Override // c.a.r0.x0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && c.a.r0.x0.a.i().m("6061002410-390177882") && this.f58138a.f58129f != null) {
                c.a.r0.z3.c.d dVar = this.f58138a.f58131h;
                VideoPlayView videoPlayView = this.f58138a.f58129f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.currentSelectIndex);
                VideoPlayView videoPlayView2 = this.f58138a.f58129f;
                if (videoPlayView2 != null) {
                    videoPlayView2.notifyDataSetChanged();
                }
            }
        }

        @Override // c.a.r0.x0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class f implements VideoPlayModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58139a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public f(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58139a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) {
                this.f58139a.n = z;
                if (ListUtils.isEmpty(list) || this.f58139a.f58131h.v()) {
                    return;
                }
                VideoVerticalPageFragment videoVerticalPageFragment = this.f58139a;
                VideoItemData s = videoVerticalPageFragment.f58131h.s(0);
                if (s == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(s, "dataController.getVideoData(0)!!");
                videoVerticalPageFragment.t(s, list);
                VideoVerticalPageFragment videoVerticalPageFragment2 = this.f58139a;
                videoVerticalPageFragment2.u(videoVerticalPageFragment2.f58131h.s(0), list);
                this.f58139a.f58131h.y(list);
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && c.a.q0.b.d.V() && c.a.r0.x0.a.i().m("6061002332-203360688") && this.f58139a.f58129f != null) {
                    c.a.r0.z3.c.d dVar = this.f58139a.f58131h;
                    VideoPlayView videoPlayView = this.f58139a.f58129f;
                    if (videoPlayView == null) {
                        Intrinsics.throwNpe();
                    }
                    dVar.a(videoPlayView.currentSelectIndex - 1);
                }
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && c.a.q0.b.d.W() && c.a.r0.x0.a.i().m("6061002410-390177882") && this.f58139a.f58129f != null) {
                    c.a.r0.z3.c.d dVar2 = this.f58139a.f58131h;
                    VideoPlayView videoPlayView2 = this.f58139a.f58129f;
                    if (videoPlayView2 == null) {
                        Intrinsics.throwNpe();
                    }
                    dVar2.a(videoPlayView2.currentSelectIndex - 1);
                }
                VideoPlayView videoPlayView3 = this.f58139a.f58129f;
                if (videoPlayView3 != null) {
                    videoPlayView3.notifyDataSetChanged();
                }
                VideoPlayView videoPlayView4 = this.f58139a.f58129f;
                if (videoPlayView4 != null) {
                    videoPlayView4.setSelectIndex(0, true);
                }
                VideoPlayView videoPlayView5 = this.f58139a.f58129f;
                if (videoPlayView5 != null) {
                    videoPlayView5.setPrimary(this.f58139a.isPrimary());
                }
                VideoPlayView videoPlayView6 = this.f58139a.f58129f;
                if (videoPlayView6 != null) {
                    videoPlayView6.setCurrentFragmentUserHint(this.f58139a.A);
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void b(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) {
                this.f58139a.n = z;
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                c.a.r0.z3.c.d dVar = this.f58139a.f58131h;
                if ((dVar != null ? Boolean.valueOf(dVar.v()) : null).booleanValue()) {
                    return;
                }
                this.f58139a.f58131h.b(list);
                if (this.f58139a.f58129f != null) {
                    c.a.r0.z3.c.d dVar2 = this.f58139a.f58131h;
                    VideoPlayView videoPlayView = this.f58139a.f58129f;
                    if (videoPlayView == null) {
                        Intrinsics.throwNpe();
                    }
                    dVar2.a(videoPlayView.currentSelectIndex);
                }
                VideoPlayView videoPlayView2 = this.f58139a.f58129f;
                if (videoPlayView2 != null) {
                    videoPlayView2.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class g implements FrsVideoTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58140a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f58141b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f58142c;

        public g(VideoVerticalPageFragment videoVerticalPageFragment, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment, objectRef, objectRef2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58140a = videoVerticalPageFragment;
            this.f58141b = objectRef;
            this.f58142c = objectRef2;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List, T] */
        @Override // com.baidu.tieba.videoplay.model.FrsVideoTabModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58141b.element = FrsVideoTabPlayActivityConfig.getVideoTabListByFid((String) this.f58142c.element);
                if (((List) this.f58141b.element) == null || this.f58140a.f58131h.v() || this.f58140a.f58129f == null) {
                    return;
                }
                this.f58140a.f58131h.y((List) this.f58141b.element);
                VideoPlayView videoPlayView = this.f58140a.f58129f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                videoPlayView.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class h implements VideoChannelModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58143a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public h(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58143a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f58143a.f58131h.y(list);
            if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && (((c.a.q0.b.d.V() && c.a.r0.x0.a.i().m("6061002332-203360688")) || (c.a.q0.b.d.W() && c.a.r0.x0.a.i().m("6061002410-390177882"))) && this.f58143a.f58129f != null)) {
                c.a.r0.z3.c.d dVar = this.f58143a.f58131h;
                VideoPlayView videoPlayView = this.f58143a.f58129f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.currentSelectIndex);
            }
            VideoPlayView videoPlayView2 = this.f58143a.f58129f;
            if (videoPlayView2 != null) {
                videoPlayView2.notifyDataSetChanged();
            }
            VideoPlayView videoPlayView3 = this.f58143a.f58129f;
            if (videoPlayView3 != null) {
                videoPlayView3.setSelectIndex(0, true);
            }
            VideoPlayView videoPlayView4 = this.f58143a.f58129f;
            if (videoPlayView4 != null) {
                videoPlayView4.setPrimary(this.f58143a.isPrimary());
            }
            c.a.r0.z3.g.a aVar = this.f58143a.G;
            if (aVar != null) {
                aVar.i();
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void b(List<? extends VideoItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f58143a.f58131h.v()) {
                return;
            }
            this.f58143a.f58131h.b(list);
            if (this.f58143a.f58129f != null) {
                c.a.r0.z3.c.d dVar = this.f58143a.f58131h;
                VideoPlayView videoPlayView = this.f58143a.f58129f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.currentSelectIndex);
            }
            VideoPlayView videoPlayView2 = this.f58143a.f58129f;
            if (videoPlayView2 != null) {
                videoPlayView2.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58144a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(VideoVerticalPageFragment videoVerticalPageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58144a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    String str = (String) data;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    c.a.r0.z3.g.a aVar = this.f58144a.G;
                    List<VideoItemModel> h2 = aVar != null ? aVar.h(str) : null;
                    if (h2 != null) {
                        if (!h2.isEmpty()) {
                            this.f58144a.f58131h.h().removeAll(h2);
                            VideoPlayView videoPlayView = this.f58144a.f58129f;
                            if (videoPlayView != null) {
                                videoPlayView.notifyDataSetChanged();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.baidu.tieba.video.VideoItemModel>");
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58145a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(VideoVerticalPageFragment videoVerticalPageFragment, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58145a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    if (this.f58145a.f58131h.e(((Integer) data).intValue())) {
                        VideoPlayView videoPlayView = this.f58145a.f58129f;
                        if (videoPlayView != null) {
                            videoPlayView.notifyDataSetChanged();
                        }
                        VideoPlayView videoPlayView2 = this.f58145a.f58129f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.setPrimary(this.f58145a.isPrimary());
                        }
                        VideoPlayView videoPlayView3 = this.f58145a.f58129f;
                        if (videoPlayView3 != null) {
                            videoPlayView3.setCurrentFragmentUserHint(this.f58145a.A);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58146a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(VideoVerticalPageFragment videoVerticalPageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58146a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && c.a.e.e.p.j.z() && this.f58146a.f58131h.v()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921568));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58147a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(VideoVerticalPageFragment videoVerticalPageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58147a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedIcon)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    RedIcon redIcon = (RedIcon) data;
                    List<ThreadInfo> list = redIcon.thread_list;
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    d2 d2Var = new d2();
                    d2Var.Y2(redIcon.thread_list.get(0));
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData(d2Var);
                    VideoItemModel videoItemModel = new VideoItemModel(videoItemData, 1);
                    c.a.r0.z3.c.d dVar = this.f58147a.f58131h;
                    VideoPlayView videoPlayView = this.f58147a.f58129f;
                    if (dVar.u(videoItemModel, videoPlayView != null ? videoPlayView.currentSelectIndex : 0)) {
                        VideoPlayActivityStatic.a(redIcon);
                        TbSingleton tbSingleton = TbSingleton.getInstance();
                        Intrinsics.checkExpressionValueIsNotNull(tbSingleton, "TbSingleton.getInstance()");
                        tbSingleton.setVideoChannelRecommendRedIcon(null);
                        VideoPlayView videoPlayView2 = this.f58147a.f58129f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.notifyDataSetChanged();
                        }
                        VideoPlayView videoPlayView3 = this.f58147a.f58129f;
                        if (videoPlayView3 != null) {
                            videoPlayView3.setPrimary(this.f58147a.isPrimary());
                        }
                        VideoPlayView videoPlayView4 = this.f58147a.f58129f;
                        if (videoPlayView4 != null) {
                            videoPlayView4.setCurrentFragmentUserHint(this.f58147a.A);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type tbclient.VideoRedIcon.RedIcon");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58148a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(VideoVerticalPageFragment videoVerticalPageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58148a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof JSONObject)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    String optString = ((JSONObject) data).optString("tid");
                    if (optString != null) {
                        if (this.f58148a.f58131h.f(optString)) {
                            VideoPlayView videoPlayView = this.f58148a.f58129f;
                            if (videoPlayView != null) {
                                videoPlayView.notifyDataSetChanged();
                            }
                            VideoPlayView videoPlayView2 = this.f58148a.f58129f;
                            if (videoPlayView2 != null) {
                                videoPlayView2.setPrimary(this.f58148a.isPrimary());
                            }
                            VideoPlayView videoPlayView3 = this.f58148a.f58129f;
                            if (videoPlayView3 != null) {
                                videoPlayView3.setCurrentFragmentUserHint(this.f58148a.A);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
                throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class n<T> implements SimpleMessageListener.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58149a;

        public n(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58149a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.util.SimpleMessageListener.b
        /* renamed from: a */
        public final void call(Unit unit) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, unit) == null) {
                this.f58149a.o(false, false, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class o<T> implements SimpleMessageListener.b<Pair<Boolean, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58150a;

        public o(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58150a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.util.SimpleMessageListener.b
        /* renamed from: a */
        public final void call(Pair<Boolean, String> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pair) == null) || pair == null) {
                return;
            }
            Intrinsics.checkExpressionValueIsNotNull(pair, "it ?: return@Callback");
            Boolean bool = pair.first;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            Intrinsics.checkExpressionValueIsNotNull(bool, "data.first ?: false");
            this.f58150a.o(true, bool.booleanValue(), pair.second);
        }
    }

    /* loaded from: classes7.dex */
    public static final class p implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final p f58151e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2029232816, "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$p;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2029232816, "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$p;");
                    return;
                }
            }
            f58151e = new p();
        }

        public p() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class q implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58152a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public q(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58152a = videoVerticalPageFragment;
        }

        @Override // c.a.r0.x0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && c.a.r0.x0.a.i().m("6061002332-203360688") && this.f58152a.f58129f != null) {
                c.a.r0.z3.c.d dVar = this.f58152a.f58131h;
                VideoPlayView videoPlayView = this.f58152a.f58129f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.currentSelectIndex);
                VideoPlayView videoPlayView2 = this.f58152a.f58129f;
                if (videoPlayView2 != null) {
                    videoPlayView2.notifyDataSetChanged();
                }
            }
        }

        @Override // c.a.r0.x0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class r implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58153a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public r(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58153a = videoVerticalPageFragment;
        }

        @Override // c.a.r0.x0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && c.a.r0.x0.a.i().m("6061002410-390177882") && this.f58153a.f58129f != null) {
                c.a.r0.z3.c.d dVar = this.f58153a.f58131h;
                VideoPlayView videoPlayView = this.f58153a.f58129f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.currentSelectIndex);
                VideoPlayView videoPlayView2 = this.f58153a.f58129f;
                if (videoPlayView2 != null) {
                    videoPlayView2.notifyDataSetChanged();
                }
            }
        }

        @Override // c.a.r0.x0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class s implements VideoPersonalModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58154a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public s(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58154a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoPersonalModel.b
        public void a(List<VideoItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || !(!list.isEmpty()) || this.f58154a.f58131h.v() || this.f58154a.f58129f == null) {
                return;
            }
            this.f58154a.f58131h.b(list);
            VideoPlayView videoPlayView = this.f58154a.f58129f;
            if (videoPlayView == null) {
                Intrinsics.throwNpe();
            }
            videoPlayView.notifyDataSetChanged();
        }
    }

    /* loaded from: classes7.dex */
    public static final class t implements BdSwipeRefreshLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58155a;

        public t(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58155a = videoVerticalPageFragment;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
        public final void a(int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) && z && this.f58155a.m() && this.f58155a.getPageContext() != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f58155a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                if (pageContext.getPageActivity() != null) {
                    TbPageContext<BaseFragmentActivity> pageContext2 = this.f58155a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                    Activity pageActivity = pageContext2.getPageActivity();
                    TbPageContext<BaseFragmentActivity> pageContext3 = this.f58155a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext3, "pageContext");
                    c.a.e.e.p.l.M(pageActivity, pageContext3.getPageActivity().getString(R.string.no_more_production));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class u implements VideoPlayView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58156a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public u(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58156a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58156a.getShowVideoTid() == 0) {
                return;
            }
            VideoVerticalPageFragment videoVerticalPageFragment = this.f58156a;
            videoVerticalPageFragment.t = Long.valueOf(videoVerticalPageFragment.getShowVideoTid());
        }
    }

    /* loaded from: classes7.dex */
    public static final class v implements VideoPlayView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58157a;

        public v(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58157a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public final void a() {
            VideoPlayModel videoPlayModel;
            VideoChannelModel videoChannelModel;
            FrsVideoTabModel frsVideoTabModel;
            VideoPersonalModel videoPersonalModel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f58157a.n) {
                if (this.f58157a.j()) {
                    Long l = this.f58157a.f58131h.l();
                    c.a.r0.z3.c.d dVar = this.f58157a.f58131h;
                    VideoPlayView videoPlayView = this.f58157a.f58129f;
                    if (videoPlayView == null) {
                        Intrinsics.throwNpe();
                    }
                    UserItemData i2 = dVar.i(videoPlayView.currentSelectIndex);
                    if (l == null || i2 == null || (videoPersonalModel = this.f58157a.x) == null) {
                        return;
                    }
                    videoPersonalModel.C(l, i2);
                } else if (this.f58157a.R == 1 || this.f58157a.R == 2) {
                    VideoPlayModel videoPlayModel2 = this.f58157a.v;
                    if (videoPlayModel2 != null) {
                        videoPlayModel2.setFrom(this.f58157a.m);
                    }
                    if (this.f58157a.f58131h.w() || (videoPlayModel = this.f58157a.v) == null) {
                        return;
                    }
                    videoPlayModel.I(this.f58157a.f58131h.s(0));
                } else if (this.f58157a.R == 7) {
                    if (this.f58157a.f58131h.w() || (frsVideoTabModel = this.f58157a.y) == null) {
                        return;
                    }
                    frsVideoTabModel.loadMore();
                } else {
                    VideoChannelModel videoChannelModel2 = this.f58157a.w;
                    if (videoChannelModel2 != null) {
                        videoChannelModel2.setFrom(this.f58157a.m);
                    }
                    if (this.f58157a.f58131h.w() || (videoChannelModel = this.f58157a.w) == null) {
                        return;
                    }
                    videoChannelModel.loadMore();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class w implements VideoPlayView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58158a;

        public w(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58158a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.g
        public final void a() {
            VideoPlayView videoPlayView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f58158a.m() && this.f58158a.getPageContext() != null) {
                    TbPageContext<BaseFragmentActivity> pageContext = this.f58158a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                    if (pageContext.getPageActivity() != null) {
                        TbPageContext<BaseFragmentActivity> pageContext2 = this.f58158a.getPageContext();
                        Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                        Activity pageActivity = pageContext2.getPageActivity();
                        TbPageContext<BaseFragmentActivity> pageContext3 = this.f58158a.getPageContext();
                        Intrinsics.checkExpressionValueIsNotNull(pageContext3, "pageContext");
                        c.a.e.e.p.l.M(pageActivity, pageContext3.getPageActivity().getString(R.string.no_more_production));
                    }
                }
                if (!this.f58158a.i() || (videoPlayView = this.f58158a.f58129f) == null || !videoPlayView.isUpOrDownScroll() || this.f58158a.getPageContext() == null) {
                    return;
                }
                TbPageContext<BaseFragmentActivity> pageContext4 = this.f58158a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext4, "pageContext");
                if (pageContext4.getPageActivity() != null) {
                    TbPageContext<BaseFragmentActivity> pageContext5 = this.f58158a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext5, "pageContext");
                    Activity pageActivity2 = pageContext5.getPageActivity();
                    TbPageContext<BaseFragmentActivity> pageContext6 = this.f58158a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext6, "pageContext");
                    c.a.e.e.p.l.M(pageActivity2, pageContext6.getPageActivity().getString(R.string.no_more_video));
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoVerticalPageFragment() {
        this(null, null, 0, 0, 15, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((BdUniqueId) objArr[0], (BdSwipeRefreshLayout.k) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), (DefaultConstructorMarker) objArr[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public VideoVerticalPageFragment(BdUniqueId bdUniqueId, BdSwipeRefreshLayout.k kVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, kVar, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.O = bdUniqueId;
        this.P = kVar;
        this.Q = i2;
        this.R = i3;
        this.f58131h = new c.a.r0.z3.c.d();
        this.n = true;
        this.B = new VideoPlayFragment.GoPbCommentFloatListener(new c(this));
        this.E = new b(this);
        this.F = new l(this, 2921581);
        this.H = new j(this, 2921566, true);
        this.I = new m(this, 2016488);
        this.J = new i(this, 2016331);
        this.K = new k(this, 2000994);
        this.L = new t(this);
        this.M = new w(this);
        this.N = new a(this, 2001011);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.r0.z3.c.e.e("5");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.R == 3 ? "a088" : "a023" : (String) invokeV.objValue;
    }

    public final Long getFirstVideoTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.s : (Long) invokeV.objValue;
    }

    public final Long getLastVideoTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (Long) invokeV.objValue;
    }

    @Override // c.a.r0.z3.f.a
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            VideoItemData s2 = this.f58131h.s(this.f58132i);
            if (s2 == null || TextUtils.isEmpty(s2.thread_id)) {
                return 0L;
            }
            return c.a.e.e.m.b.g(s2.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    public final BdSwipeRefreshLayout.k getProgressViewCallbackFra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.L : (BdSwipeRefreshLayout.k) invokeV.objValue;
    }

    public final long getShowVideoTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.r0.z3.c.d dVar = this.f58131h;
            VideoPlayView videoPlayView = this.f58129f;
            if (videoPlayView == null) {
                Intrinsics.throwNpe();
            }
            VideoItemData s2 = dVar.s(videoPlayView.currentSelectIndex);
            if (s2 == null || TextUtils.isEmpty(s2.thread_id)) {
                return 0L;
            }
            return c.a.e.e.m.b.g(s2.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    public final b.InterfaceC0664b getVEventListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.E : (b.InterfaceC0664b) invokeV.objValue;
    }

    public final VideoPlayView.g getViewPagerBottomScrollMoreCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.M : (VideoPlayView.g) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.R == 6 : invokeV.booleanValue;
    }

    @Override // c.a.r0.z3.f.a
    public void handleActivityResult(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, intent) == null) || (videoPlayView = this.f58129f) == null) {
            return;
        }
        videoPlayView.handleActivityResult(i2, i3, intent);
    }

    @Override // c.a.r0.z3.f.a
    public boolean handleBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            VideoPlayView videoPlayView = this.f58129f;
            return videoPlayView != null && videoPlayView.handleBackPress();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.z3.f.a
    public void handleIndexMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            VideoPlayView videoPlayView = this.f58129f;
            if (videoPlayView == null) {
                Intrinsics.throwNpe();
            }
            int i2 = videoPlayView.firstInIndex;
            VideoPlayView videoPlayView2 = this.f58129f;
            if (videoPlayView2 == null) {
                Intrinsics.throwNpe();
            }
            if (i2 != videoPlayView2.currentSelectIndex) {
                VideoPlayView videoPlayView3 = this.f58129f;
                if (videoPlayView3 == null) {
                    Intrinsics.throwNpe();
                }
                if (videoPlayView3.currentSelectIndex >= 0) {
                    VideoPlayView videoPlayView4 = this.f58129f;
                    if (videoPlayView4 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (videoPlayView4.currentSelectIndex < this.f58131h.k()) {
                        c.a.r0.z3.c.d dVar = this.f58131h;
                        VideoPlayView videoPlayView5 = this.f58129f;
                        if (videoPlayView5 == null) {
                            Intrinsics.throwNpe();
                        }
                        VideoItemData s2 = dVar.s(videoPlayView5.currentSelectIndex);
                        if (s2 == null || StringUtils.isNull(s2.thread_id)) {
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, s2.thread_id));
                    }
                }
            }
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.R == 7 : invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v72, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v68, types: [java.util.List<com.baidu.tieba.video.VideoItemData>, T] */
    /* JADX WARN: Type inference failed for: r3v70, types: [java.util.List, T] */
    public final void initData() {
        int i2;
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f58131h.c();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Bundle arguments = getArguments();
            objectRef.element = (ArrayList) (arguments != null ? arguments.getSerializable("video_list") : null);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Bundle arguments2 = getArguments();
            T string = arguments2 != null ? arguments2.getString("forum_id") : 0;
            objectRef2.element = string;
            if (((List) objectRef.element) == null) {
                if (this.R == 7) {
                    objectRef.element = FrsVideoTabPlayActivityConfig.getVideoTabListByFid((String) string);
                } else {
                    objectRef.element = VideoPlayActivityConfig.bigDataList;
                }
            }
            this.f58131h.y((List) objectRef.element);
            if (getArguments() != null) {
                Bundle arguments3 = getArguments();
                if (arguments3 == null) {
                    Intrinsics.throwNpe();
                }
                i2 = arguments3.getInt("video_index", 0);
            } else {
                i2 = 0;
            }
            this.f58132i = i2;
            if (getArguments() != null) {
                Bundle arguments4 = getArguments();
                if (arguments4 == null) {
                    Intrinsics.throwNpe();
                }
                i3 = arguments4.getInt("video_show_index", 0);
            } else {
                i3 = 0;
            }
            this.f58133j = i3;
            Bundle arguments5 = getArguments();
            this.k = arguments5 != null ? (Rect) arguments5.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT) : null;
            Bundle arguments6 = getArguments();
            this.l = arguments6 != null ? arguments6.getString("page_from") : null;
            Bundle arguments7 = getArguments();
            this.m = arguments7 != null ? arguments7.getString("from") : null;
            Bundle arguments8 = getArguments();
            this.o = arguments8 != null ? arguments8.getString("st_type") : null;
            Bundle arguments9 = getArguments();
            this.p = arguments9 != null ? arguments9.getString("yuelaou_locate") : null;
            if (getArguments() != null) {
                Bundle arguments10 = getArguments();
                if (arguments10 == null) {
                    Intrinsics.throwNpe();
                }
                z = arguments10.getBoolean("is_vertail", true);
            } else {
                z = false;
            }
            this.q = z;
            if (this.r == null) {
                this.r = VideoRecommentPlayActivityConfig.bigPersonalPageParams;
            }
            if (this.f58131h.v() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.f58131h.y(VideoPlayActivityConfig.bigDataList);
            }
            this.f58131h.B(getUniqueId());
            if (this.R != 3 && (!TbSingleton.getInstance().isFromFeedVideoClick() || this.R != 1)) {
                this.f58131h.C("a023");
            } else {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
                q(inst.getMainTabBottomBarHeight());
                this.f58131h.C("a088");
            }
            int i4 = this.R;
            if (i4 != 1 && i4 != 2) {
                if (m()) {
                    if (this.f58133j >= this.f58131h.k()) {
                        this.f58133j = 0;
                    }
                    if (j()) {
                        p();
                    }
                } else if (this.R == 7) {
                    if (getPageContext() == null || getUniqueId() == null) {
                        return;
                    }
                    FrsVideoTabModel frsVideoTabModel = new FrsVideoTabModel(getPageContext(), getUniqueId());
                    this.y = frsVideoTabModel;
                    if (frsVideoTabModel != null) {
                        frsVideoTabModel.setFrom(this.m);
                    }
                    FrsVideoTabModel frsVideoTabModel2 = this.y;
                    if (frsVideoTabModel2 != null) {
                        frsVideoTabModel2.y(this.Q);
                    }
                    FrsVideoTabModel frsVideoTabModel3 = this.y;
                    if (frsVideoTabModel3 != null) {
                        frsVideoTabModel3.z(new g(this, objectRef, objectRef2));
                    }
                } else {
                    VideoChannelModel videoChannelModel = new VideoChannelModel(getPageContext(), getUniqueId());
                    this.w = videoChannelModel;
                    if (videoChannelModel != null) {
                        videoChannelModel.setFrom(this.m);
                    }
                    VideoChannelModel videoChannelModel2 = this.w;
                    if (videoChannelModel2 != null) {
                        videoChannelModel2.F(this.Q);
                    }
                    VideoChannelModel videoChannelModel3 = this.w;
                    if (videoChannelModel3 != null) {
                        videoChannelModel3.G(new h(this));
                    }
                    if (this.f58131h.s(0) != null) {
                        VideoItemData s2 = this.f58131h.s(0);
                        this.u = s2 != null ? s2.thread_id : null;
                    }
                    VideoChannelModel videoChannelModel4 = this.w;
                    if (videoChannelModel4 != null) {
                        videoChannelModel4.setFrom(this.m);
                    }
                    if (!c.a.e.e.p.j.z() && !isPrimary()) {
                        return;
                    }
                    if (k()) {
                        VideoChannelModel videoChannelModel5 = this.w;
                        if (videoChannelModel5 != null) {
                            videoChannelModel5.loadMore();
                        }
                    } else {
                        VideoChannelModel videoChannelModel6 = this.w;
                        if (videoChannelModel6 != null) {
                            videoChannelModel6.E();
                        }
                    }
                }
            } else {
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest()) {
                    if (c.a.q0.b.d.V()) {
                        c.a.r0.x0.a.i().q(getActivity(), new d(this), this.f58131h.o());
                    }
                    if (c.a.q0.b.d.W()) {
                        c.a.r0.x0.a.i().p(getActivity(), new e(this), this.f58131h.o());
                    }
                }
                VideoPlayModel videoPlayModel = new VideoPlayModel(getPageContext(), getUniqueId());
                this.v = videoPlayModel;
                if (videoPlayModel != null) {
                    videoPlayModel.setFrom(this.m);
                }
                VideoPlayModel videoPlayModel2 = this.v;
                if (videoPlayModel2 != null) {
                    videoPlayModel2.K(this.Q);
                }
                VideoPlayModel videoPlayModel3 = this.v;
                if (videoPlayModel3 != null) {
                    videoPlayModel3.L(new f(this));
                }
                if (this.f58131h.s(0) != null) {
                    VideoItemData s3 = this.f58131h.s(0);
                    this.u = s3 != null ? s3.thread_id : null;
                }
                VideoPlayModel videoPlayModel4 = this.v;
                if (videoPlayModel4 != null) {
                    videoPlayModel4.setFrom(this.m);
                }
                VideoPlayModel videoPlayModel5 = this.v;
                if (videoPlayModel5 != null) {
                    videoPlayModel5.J(this.f58131h.s(0), this.o, this.p, this.q);
                }
            }
            this.G = new c.a.r0.z3.g.a(this.f58131h.h(), getPageContext());
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? h() && !n() : invokeV.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? h() && n() : invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.R == 5 : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? l() || j() : invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = this.r;
            if (personalPageParams != null) {
                return personalPageParams.isShareThread();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void o(boolean z, boolean z2, String str) {
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        VideoPersonalModel videoPersonalModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) || (personalPageParams = this.r) == null || (videoPersonalModel = this.x) == null) {
            return;
        }
        c.a.r0.z3.c.d dVar = this.f58131h;
        VideoPlayView videoPlayView = this.f58129f;
        if (videoPlayView == null) {
            Intrinsics.throwNpe();
        }
        String r2 = dVar.r(videoPlayView.currentSelectIndex);
        if (r2 != null) {
            Intrinsics.checkExpressionValueIsNotNull(r2, "dataController\n         …ex)\n            ?: return");
            VideoNotifyPersonalPageData videoNotifyPersonalPageData = new VideoNotifyPersonalPageData();
            videoNotifyPersonalPageData.setPersonalPageUid(personalPageParams.getPersonalPageUid());
            videoNotifyPersonalPageData.setCurrentThreadId(r2);
            videoNotifyPersonalPageData.setFlutterPageId(personalPageParams.getFlutterPageId());
            videoNotifyPersonalPageData.setUserPostDataResMapList(videoPersonalModel.B());
            videoNotifyPersonalPageData.setCurrentPn(personalPageParams.getCurrentPn());
            videoNotifyPersonalPageData.setIsDeleteOperate(z);
            videoNotifyPersonalPageData.setDeleteStatus(z2);
            videoNotifyPersonalPageData.setDeleteStatusMessage(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921623, videoNotifyPersonalPageData));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.C = new OnActivityFinishListener<>(getPageContext(), new n(this));
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            this.D = new OnDeleteSelfPostListener(pageContext, new o(this));
            Lifecycle lifecycle = getLifecycle();
            OnDeleteSelfPostListener onDeleteSelfPostListener = this.D;
            if (onDeleteSelfPostListener == null) {
                Intrinsics.throwNpe();
            }
            lifecycle.addObserver(onDeleteSelfPostListener);
            Lifecycle lifecycle2 = getLifecycle();
            OnActivityFinishListener<Unit> onActivityFinishListener = this.C;
            if (onActivityFinishListener == null) {
                Intrinsics.throwNpe();
            }
            lifecycle2.addObserver(onActivityFinishListener);
            getLifecycle().addObserver(this.B);
            initData();
            r();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048598, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                handleActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            VideoPlayView videoPlayView = this.f58129f;
            if (videoPlayView != null) {
                videoPlayView.onChangeSkinType(i2);
            }
            SkinManager.setBackgroundColor(this.f58128e, R.color.CAM_X0611);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.I);
            registerListener(this.H);
            registerListener(this.K);
            registerListener(this.F);
            registerListener(this.J);
            registerListener(this.N);
            View inflate = layoutInflater.inflate(R.layout.video_vertical_page_fragment, viewGroup, false);
            this.f58128e = inflate;
            RelativeLayout relativeLayout = inflate != null ? (RelativeLayout) inflate.findViewById(R.id.youngster_vertical_layout) : null;
            this.f58130g = relativeLayout;
            if (relativeLayout != null) {
                relativeLayout.setOnTouchListener(p.f58151e);
            }
            return this.f58128e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            if (this.D != null) {
                Lifecycle lifecycle = getLifecycle();
                OnDeleteSelfPostListener onDeleteSelfPostListener = this.D;
                if (onDeleteSelfPostListener == null) {
                    Intrinsics.throwNpe();
                }
                lifecycle.removeObserver(onDeleteSelfPostListener);
            }
            if (this.C != null) {
                Lifecycle lifecycle2 = getLifecycle();
                OnActivityFinishListener<Unit> onActivityFinishListener = this.C;
                if (onActivityFinishListener == null) {
                    Intrinsics.throwNpe();
                }
                lifecycle2.removeObserver(onActivityFinishListener);
            }
            getLifecycle().removeObserver(this.B);
            VideoPlayView videoPlayView = this.f58129f;
            if (videoPlayView != null) {
                videoPlayView.onDestroy();
            }
            if (isPrimary()) {
                s();
            }
            if (getActivity() instanceof FrsVideoTabPlayActivity) {
                g();
            }
            VideoPersonalModel videoPersonalModel = this.x;
            if (videoPersonalModel != null) {
                videoPersonalModel.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDestroyView();
            c.a.r0.x0.a.i().d("6061002332-203360688");
            c.a.r0.x0.a.i().c("6061002410-390177882");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f58129f;
            if (videoPlayView != null) {
                videoPlayView.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onPrimary();
            if (!this.A) {
                s();
            }
            if (getActivity() instanceof FrsVideoTabPlayActivity) {
                g();
            }
            if (this.A && this.R == 3) {
                c.a.r0.z3.b.c(1);
            }
            this.s = Long.valueOf(getMissionTid());
            VideoPlayView videoPlayView = this.f58129f;
            if (videoPlayView != null) {
                videoPlayView.setPrimary(isPrimary());
            }
            if (!this.z && isPrimary() && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.R == 3) {
                this.z = true;
                if (c.a.q0.b.d.V()) {
                    c.a.r0.x0.a.i().q(getActivity(), new q(this), this.f58131h.o());
                } else if (c.a.q0.b.d.W()) {
                    c.a.r0.x0.a.i().p(getActivity(), new r(this), this.f58131h.o());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onResume();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || getPageContext() == null || getUniqueId() == null || this.r == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = this.r;
        if (personalPageParams == null) {
            Intrinsics.throwNpe();
        }
        VideoPersonalModel videoPersonalModel = new VideoPersonalModel(pageContext, personalPageParams);
        this.x = videoPersonalModel;
        if (videoPersonalModel != null) {
            videoPersonalModel.D(new s(this));
        }
    }

    public final void q(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || (view = this.f58128e) == null) {
            return;
        }
        if (view == null) {
            Intrinsics.throwNpe();
        }
        int paddingLeft = view.getPaddingLeft();
        View view2 = this.f58128e;
        if (view2 == null) {
            Intrinsics.throwNpe();
        }
        int paddingTop = view2.getPaddingTop();
        View view3 = this.f58128e;
        if (view3 == null) {
            Intrinsics.throwNpe();
        }
        int paddingRight = view3.getPaddingRight();
        View view4 = this.f58128e;
        if (view4 == null) {
            Intrinsics.throwNpe();
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, view4.getPaddingBottom() + i2);
    }

    public final void r() {
        VideoPlayView videoPlayView;
        VideoPlayView videoPlayView2;
        VideoPlayView videoPlayView3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            BdUniqueId bdUniqueId = this.O;
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            Activity pageActivity = pageContext.getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView4 = new VideoPlayView(bdUniqueId, (FragmentActivity) pageActivity, this, this.m, getUniqueId(), 1, this.R, n());
                this.f58129f = videoPlayView4;
                if (this.R == 3 && videoPlayView4 != null) {
                    videoPlayView4.setSubFrom(VideoPlayView.FROM_SUGGEST_SUB_FRAGMENT);
                }
                VideoPlayView videoPlayView5 = this.f58129f;
                if (videoPlayView5 != null) {
                    BdSwipeRefreshLayout.k kVar = this.P;
                    if (kVar == null) {
                        kVar = this.L;
                    }
                    videoPlayView5.setProgressViewCallback(kVar);
                }
                VideoPlayView videoPlayView6 = this.f58129f;
                if (videoPlayView6 != null) {
                    videoPlayView6.setBottomScrollMoreCallback(this.M);
                }
                if (this.Q != 1 && (videoPlayView3 = this.f58129f) != null) {
                    videoPlayView3.setEventListener(this.E);
                }
                if (this.R == 7 && (videoPlayView2 = this.f58129f) != null) {
                    videoPlayView2.setOnLastShowVideoCallBack(new u(this));
                }
                c.a.r0.z3.g.a aVar = this.G;
                if (aVar != null) {
                    aVar.o(this.f58129f);
                }
                VideoPlayView videoPlayView7 = this.f58129f;
                if (videoPlayView7 != null) {
                    videoPlayView7.setOnLoadMoreListener(new v(this));
                }
                VideoPlayView videoPlayView8 = this.f58129f;
                if (videoPlayView8 != null) {
                    videoPlayView8.showData(this.f58131h, this.f58132i, this.k);
                }
                VideoPlayView videoPlayView9 = this.f58129f;
                if (videoPlayView9 != null) {
                    videoPlayView9.setPageFrom(this.l);
                }
                VideoPlayView videoPlayView10 = this.f58129f;
                if (videoPlayView10 != null) {
                    videoPlayView10.setObjId(this.u);
                }
                VideoPlayView videoPlayView11 = this.f58129f;
                if (videoPlayView11 != null) {
                    videoPlayView11.setVideoChannelPageType(this.Q);
                }
                if (m() && (videoPlayView = this.f58129f) != null) {
                    videoPlayView.setSelectIndex(this.f58133j, false);
                }
                VideoPlayView videoPlayView12 = this.f58129f;
                if (videoPlayView12 != null) {
                    videoPlayView12.setNadDispatcher(this.G);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            c.a.r0.z3.c.e.f(getActivity() instanceof VideoPlayActivity ? "1" : "3");
        }
    }

    public final void setProgressViewCallbackFra(BdSwipeRefreshLayout.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, kVar) == null) {
            this.L = kVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z && this.R == 6) {
                v();
            }
            VideoPlayView videoPlayView = this.f58129f;
            if (videoPlayView != null) {
                videoPlayView.setCurrentFragmentUserHint(z);
            }
            this.A = z;
        }
    }

    public final void setVideoPlayViewEventListener(b.InterfaceC0664b interfaceC0664b) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, interfaceC0664b) == null) || (videoPlayView = this.f58129f) == null) {
            return;
        }
        videoPlayView.setEventListener(interfaceC0664b);
    }

    public final void setViewPagerBottomScrollMoreCallback(VideoPlayView.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, gVar) == null) {
            this.M = gVar;
        }
    }

    public final void t(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        UserItemData userItemData;
        UserItemData userItemData2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, videoItemData, list) == null) {
            VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list, 0);
            if (videoItemData == null || (userItemData = videoItemData.author_info) == null || videoItemData2 == null || (userItemData2 = videoItemData2.author_info) == null || (str = userItemData2.user_id) == null || !Intrinsics.areEqual(str, userItemData.user_id)) {
                return;
            }
            videoItemData2.author_info.is_follow = videoItemData.author_info.is_follow;
        }
    }

    public final void u(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, videoItemData, list) == null) {
            VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list, 0);
            if (videoItemData != null) {
                videoItemData.threadData = videoItemData2 != null ? videoItemData2.threadData : null;
                if (videoItemData.feedBackReasonMap == null) {
                    videoItemData.feedBackReasonMap = videoItemData2 != null ? videoItemData2.feedBackReasonMap : null;
                    videoItemData.feedBackExtraMap = videoItemData2 != null ? videoItemData2.feedBackExtraMap : null;
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            boolean d2 = c.a.q0.g1.b.c.d();
            RelativeLayout relativeLayout = this.f58130g;
            if (relativeLayout != null) {
                if (relativeLayout == null) {
                    Intrinsics.throwNpe();
                }
                relativeLayout.setVisibility(d2 ? 0 : 8);
            }
        }
    }

    public /* synthetic */ VideoVerticalPageFragment(BdUniqueId bdUniqueId, BdSwipeRefreshLayout.k kVar, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : bdUniqueId, (i4 & 2) != 0 ? null : kVar, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}
