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
import c.a.s0.f1.r.b;
import c.a.s0.s.q.e2;
import c.a.t0.f1.a;
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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.module.hottopic.VideoHotTopicParams;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tbadk.util.OnActivityFinishListener;
import com.baidu.tbadk.util.SimpleMessageListener;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.FrsVideoTabPlayActivity;
import com.baidu.tieba.videoplay.VideoPlayActivity;
import com.baidu.tieba.videoplay.VideoPlayActivityStatic;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.tieba.videoplay.VideoRecommentPlayActivity;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import com.baidu.tieba.videoplay.model.FrsVideoTabModel;
import com.baidu.tieba.videoplay.model.VideoChannelModel;
import com.baidu.tieba.videoplay.model.VideoHotTopicModel;
import com.baidu.tieba.videoplay.model.VideoPersonalModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VideoRedIcon.RedIcon;
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u009a\u0001B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010S\u001a\u00020;H\u0002J\b\u0010T\u001a\u00020\u001fH\u0016J\r\u0010U\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010VJ\r\u0010W\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010VJ\b\u0010X\u001a\u00020\u0012H\u0016J\u0017\u0010Y\u001a\u00020\u00122\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010[J\b\u0010\\\u001a\u0004\u0018\u00010\u0010J\"\u0010]\u001a\u00020;2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\b2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010b\u001a\u00020\u0017H\u0016J\b\u0010c\u001a\u00020;H\u0016J\b\u0010d\u001a\u00020;H\u0002J\b\u0010e\u001a\u00020\u0017H\u0002J\b\u0010f\u001a\u00020\u0017H\u0002J\b\u0010g\u001a\u00020\u0017H\u0002J\b\u0010h\u001a\u00020\u0017H\u0002J\b\u0010i\u001a\u00020\u0017H\u0002J\b\u0010j\u001a\u00020\u0017H\u0002J\b\u0010k\u001a\u00020\u0017H\u0002J\b\u0010l\u001a\u00020\u0017H\u0002J\b\u0010m\u001a\u00020\u0017H\u0002J\b\u0010n\u001a\u00020\u0017H\u0002J\b\u0010o\u001a\u00020\u0017H\u0002J\b\u0010p\u001a\u00020\u0017H\u0002J\b\u0010q\u001a\u00020\u0017H\u0002J\b\u0010r\u001a\u00020\u0017H\u0002J\b\u0010s\u001a\u00020\u0017H\u0002J\b\u0010t\u001a\u00020\u0017H\u0002J\"\u0010u\u001a\u00020;2\u0006\u0010v\u001a\u00020\u00172\u0006\u0010w\u001a\u00020\u00172\b\u0010x\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010y\u001a\u00020;H\u0002J\u0012\u0010z\u001a\u00020;2\b\u0010{\u001a\u0004\u0018\u00010|H\u0016J\"\u0010}\u001a\u00020;2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\b2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0010\u0010~\u001a\u00020;2\u0006\u0010\u007f\u001a\u00020\bH\u0016J+\u0010\u0080\u0001\u001a\u0004\u0018\u00010-2\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010{\u001a\u0004\u0018\u00010|H\u0016J\t\u0010\u0085\u0001\u001a\u00020;H\u0016J\t\u0010\u0086\u0001\u001a\u00020;H\u0016J\t\u0010\u0087\u0001\u001a\u00020;H\u0016J\t\u0010\u0088\u0001\u001a\u00020;H\u0016J\t\u0010\u0089\u0001\u001a\u00020;H\u0016J\t\u0010\u008a\u0001\u001a\u00020;H\u0002J\t\u0010\u008b\u0001\u001a\u00020;H\u0002J\u0012\u0010\u008c\u0001\u001a\u00020;2\u0007\u0010\u008d\u0001\u001a\u00020\bH\u0002J\u0011\u0010\u008e\u0001\u001a\u00020;2\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0012\u0010\u008f\u0001\u001a\u00020;2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0010J\t\u0010\u0091\u0001\u001a\u00020;H\u0002J\t\u0010\u0092\u0001\u001a\u00020;H\u0002J$\u0010\u0093\u0001\u001a\u00020;2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u000f\u0010\u0096\u0001\u001a\n\u0012\u0005\u0012\u00030\u0095\u00010\u0097\u0001H\u0002J&\u0010\u0098\u0001\u001a\u00020;2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\u000f\u0010\u0096\u0001\u001a\n\u0012\u0005\u0012\u00030\u0095\u00010\u0097\u0001H\u0002J\t\u0010\u0099\u0001\u001a\u00020;H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009b\u0001"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/videoplay/fragment/IVideoPlayActicityFragment;", "mActivityPageUniqueId", "Lcom/baidu/adp/BdUniqueId;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "mainPageType", "", "mCurrentType", "(Lcom/baidu/adp/BdUniqueId;Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;II)V", "backGroundListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "eventListener", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "firstVideoTid", "", "Ljava/lang/Long;", "goPbCommentFloatListener", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "isSchemeUp", "", "isVertail", "isVisibleToUser", "keyboardShowHideListener", "lastVideoTid", "mAdCloseListener", "mFeedBackListener", "mFrom", "", "mFromPage", "mFrsVideoTabModel", "Lcom/baidu/tieba/videoplay/model/FrsVideoTabModel;", "mHasMore", "mLocate", "mNAdDispatcher", "Lcom/baidu/tieba/videoplay/nad/AdVideoFlowDispatcher;", "mNetworkChangedMessageListener", "mObjId", "mRecommendTabInsertDataListener", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "mUEGFeedBackListener", "mVideoChannelModel", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoIndex", "mVideoPlayModel", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoShowIndex", "mVideoTabReqFunAd", "onActivityFinishListener", "Lcom/baidu/tbadk/util/OnActivityFinishListener;", "", "onDeleteSelfPostListener", "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "personalPageParams", "Lcom/baidu/tbadk/core/atomData/VideoRecommentPlayActivityConfig$PersonalPageParams;", "progressViewCallbackFra", "getProgressViewCallbackFra", "()Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "setProgressViewCallbackFra", "(Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;)V", "videoHotTopicModel", "Lcom/baidu/tieba/videoplay/model/VideoHotTopicModel;", "videoHotTopicParams", "Lcom/baidu/tbadk/module/hottopic/VideoHotTopicParams;", "videoPersonalModel", "Lcom/baidu/tieba/videoplay/model/VideoPersonalModel;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "getViewPagerBottomScrollMoreCallback", "()Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "setViewPagerBottomScrollMoreCallback", "(Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;)V", "youngsterVerticalLayout", "Landroid/widget/RelativeLayout;", "frsStepStat", "getCurrentPageKey", "getFirstVideoTid", "()Ljava/lang/Long;", "getLastVideoTid", "getMissionTid", "getShowVideoTid", "index", "(Ljava/lang/Integer;)J", "getVEventListener", "handleActivityResult", "requestCode", MiPushCommandMessage.KEY_RESULT_CODE, "data", "Landroid/content/Intent;", "handleBackPress", "handleIndexMessage", "initData", "isFromAgreePage", "isFromAtPage", "isFromCreateCenterPage", "isFromLink", "isFromOfficalVideo", "isFromPbVideoSchema", "isFromPersonalPage", "isFromReplyPage", "isFromWorkManagement", "isFrsVideoTab", "isHotTopicPlay", "isNoTabPlay", "isPersonalPlay", "isPersonalSharePlay", "isRecommendPlay", "isShareThread", "notifyPersonalPage", "isDelete", "isDeleteSucceed", "deleteErrorMessage", "notifyVideoHotTopicPage", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "processVideoHotTopicModel", "processVideoPersonalModel", "setEmptyHeight", "height", "setUserVisibleHint", "setVideoPlayViewEventListener", "listener", "showData", "stepStat", "syncFirstVideoFollowState", "originalData", "Lcom/baidu/tieba/video/VideoItemData;", "newList", "", "syncFirstVideoThreadData", "updateYoungsterMode", "OnDeleteSelfPostListener", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class VideoVerticalPageFragment extends BaseFragment implements c.a.t0.m4.p.n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoPlayModel A;
    public VideoChannelModel B;
    public VideoPersonalModel C;
    public VideoHotTopicModel D;
    public FrsVideoTabModel E;
    public boolean F;
    public boolean G;
    public boolean H;
    public final VideoPlayFragment.GoPbCommentFloatListener I;
    public OnActivityFinishListener<Unit> J;
    public OnDeleteSelfPostListener K;
    public b.InterfaceC0856b L;
    public final CustomMessageListener M;
    public c.a.t0.m4.q.a N;
    public final CustomMessageListener O;
    public final CustomMessageListener P;
    public final CustomMessageListener Q;
    public final CustomMessageListener R;
    public BdSwipeRefreshLayout.k S;
    public VideoPlayView.h T;
    public final CustomMessageListener U;
    public final CustomMessageListener V;

    /* renamed from: e  reason: collision with root package name */
    public final BdUniqueId f48931e;

    /* renamed from: f  reason: collision with root package name */
    public final BdSwipeRefreshLayout.k f48932f;

    /* renamed from: g  reason: collision with root package name */
    public final int f48933g;

    /* renamed from: h  reason: collision with root package name */
    public final int f48934h;

    /* renamed from: i  reason: collision with root package name */
    public View f48935i;

    /* renamed from: j  reason: collision with root package name */
    public VideoPlayView f48936j;
    public RelativeLayout k;
    public final c.a.t0.m4.l.d l;
    public int m;
    public int n;
    public Rect o;
    public String p;
    public String q;
    public boolean r;
    public String s;
    public String t;
    public boolean u;
    public VideoRecommentPlayActivityConfig.PersonalPageParams v;
    public VideoHotTopicParams w;
    public Long x;
    public Long y;
    public String z;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB-\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "Lcom/baidu/tbadk/util/SimpleMessageListener;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tbadk/util/SimpleMessageListener$Callback;", "Landroidx/core/util/Pair;", "", "", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tbadk/util/SimpleMessageListener$Callback;)V", "Companion", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class OnDeleteSelfPostListener extends SimpleMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public static final a Companion;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes13.dex */
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

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final void a(TbPageContext<?> pageContext, Pair<Boolean, String> data) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, pageContext, data) == null) {
                    Intrinsics.checkNotNullParameter(pageContext, "pageContext");
                    Intrinsics.checkNotNullParameter(data, "data");
                    SimpleMessageListener.sendMessage(2001460, pageContext, data);
                }
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
        public OnDeleteSelfPostListener(TbPageContext<?> pageContext, SimpleMessageListener.b<Pair<Boolean, String>> callback) {
            super(2001460, false, callback);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pageContext, callback};
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
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            Intrinsics.checkNotNullParameter(callback, "callback");
            bindPage(pageContext);
        }

        @JvmStatic
        public static final void sendMessage(TbPageContext<?> tbPageContext, Pair<Boolean, String> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, tbPageContext, pair) == null) {
                Companion.a(tbPageContext, pair);
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoVerticalPageFragment videoVerticalPageFragment) {
            super(2001011);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.getCmd() == 2001011 && (msg instanceof BackgroundSwitchMessage)) {
                    BackgroundSwitchMessage backgroundSwitchMessage = (BackgroundSwitchMessage) msg;
                    if (backgroundSwitchMessage.getData() != null) {
                        Boolean isBackground = backgroundSwitchMessage.getData();
                        Intrinsics.checkNotNullExpressionValue(isBackground, "isBackground");
                        if (isBackground.booleanValue()) {
                            boolean z = false;
                            if (c.a.d.a.b.f().b() instanceof c.a.t0.z3.a) {
                                Activity b2 = c.a.d.a.b.f().b();
                                if (b2 != null) {
                                    if (((c.a.t0.z3.a) b2).getCurrentTabType() == 22) {
                                        z = true;
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.tblauncher.IMaintabType");
                                }
                            }
                            if ((this.a.G && z) || ((c.a.d.a.b.f().b() instanceof VideoPlayActivity) && (this.a.getActivity() instanceof VideoPlayActivity))) {
                                this.a.N();
                            }
                            if (!z && (c.a.d.a.b.f().b() instanceof FrsVideoTabPlayActivity) && (this.a.getActivity() instanceof FrsVideoTabPlayActivity)) {
                                this.a.i();
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class b implements b.InterfaceC0856b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f48937e;

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
            this.f48937e = videoVerticalPageFragment;
        }

        @Override // c.a.s0.f1.r.b.InterfaceC0856b
        public void onViewClick() {
            VideoPlayView videoPlayView;
            b.InterfaceC0856b currentFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoPlayView = this.f48937e.f48936j) == null || (currentFragment = videoPlayView.getCurrentFragment()) == null) {
                return;
            }
            currentFragment.onViewClick();
        }

        @Override // c.a.s0.f1.r.b.InterfaceC0856b
        public void onViewDoubleClick(float f2, float f3) {
            VideoPlayView videoPlayView;
            b.InterfaceC0856b currentFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (videoPlayView = this.f48937e.f48936j) == null || (currentFragment = videoPlayView.getCurrentFragment()) == null) {
                return;
            }
            currentFragment.onViewDoubleClick(f2, f3);
        }

        @Override // c.a.s0.f1.r.b.InterfaceC0856b
        public void onViewDragToRight() {
            VideoPlayView videoPlayView;
            b.InterfaceC0856b currentFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (videoPlayView = this.f48937e.f48936j) == null || (currentFragment = videoPlayView.getCurrentFragment()) == null) {
                return;
            }
            currentFragment.onViewDragToRight();
        }
    }

    /* loaded from: classes13.dex */
    public static final class c implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

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
            this.a = videoVerticalPageFragment;
        }

        @Override // c.a.t0.f1.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && c.a.t0.f1.a.i().m("6061002332-203360688") && this.a.f48936j != null) {
                c.a.t0.m4.l.d dVar = this.a.l;
                VideoPlayView videoPlayView = this.a.f48936j;
                Intrinsics.checkNotNull(videoPlayView);
                dVar.a(videoPlayView.currentSelectIndex);
                VideoPlayView videoPlayView2 = this.a.f48936j;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.notifyDataSetChanged();
            }
        }

        @Override // c.a.t0.f1.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class d implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

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
            this.a = videoVerticalPageFragment;
        }

        @Override // c.a.t0.f1.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && c.a.t0.f1.a.i().m("6061002410-390177882") && this.a.f48936j != null) {
                c.a.t0.m4.l.d dVar = this.a.l;
                VideoPlayView videoPlayView = this.a.f48936j;
                Intrinsics.checkNotNull(videoPlayView);
                dVar.a(videoPlayView.currentSelectIndex);
                VideoPlayView videoPlayView2 = this.a.f48936j;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.notifyDataSetChanged();
            }
        }

        @Override // c.a.t0.f1.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class e implements VideoPlayModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

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
            this.a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v27, resolved type: c.a.t0.m4.l.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void a(List<? extends VideoItemData> datas, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, datas, z) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                this.a.r = z;
                if (ListUtils.isEmpty(datas) || this.a.l.v()) {
                    return;
                }
                VideoVerticalPageFragment videoVerticalPageFragment = this.a;
                VideoItemData s = videoVerticalPageFragment.l.s(0);
                Intrinsics.checkNotNull(s);
                Intrinsics.checkNotNullExpressionValue(s, "dataController.getVideoData(0)!!");
                videoVerticalPageFragment.O(s, datas);
                VideoVerticalPageFragment videoVerticalPageFragment2 = this.a;
                videoVerticalPageFragment2.P(videoVerticalPageFragment2.l.s(0), datas);
                if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_H5_SEARCH, this.a.q)) {
                    this.a.l.b(datas.subList(1, datas.size()));
                } else {
                    this.a.l.z(datas);
                }
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && c.a.s0.b.d.p0() && c.a.t0.f1.a.i().m("6061002332-203360688") && this.a.f48936j != null) {
                    c.a.t0.m4.l.d dVar = this.a.l;
                    VideoPlayView videoPlayView = this.a.f48936j;
                    Intrinsics.checkNotNull(videoPlayView);
                    dVar.a(videoPlayView.currentSelectIndex - 1);
                }
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && c.a.s0.b.d.q0() && c.a.t0.f1.a.i().m("6061002410-390177882") && this.a.f48936j != null) {
                    c.a.t0.m4.l.d dVar2 = this.a.l;
                    VideoPlayView videoPlayView2 = this.a.f48936j;
                    Intrinsics.checkNotNull(videoPlayView2);
                    dVar2.a(videoPlayView2.currentSelectIndex - 1);
                }
                VideoPlayView videoPlayView3 = this.a.f48936j;
                if (videoPlayView3 != null) {
                    videoPlayView3.notifyDataSetChanged();
                }
                VideoPlayView videoPlayView4 = this.a.f48936j;
                if (videoPlayView4 != null) {
                    videoPlayView4.initTiePlusView();
                }
                VideoPlayView videoPlayView5 = this.a.f48936j;
                if (videoPlayView5 != null) {
                    videoPlayView5.setSelectIndex(0, true);
                }
                VideoPlayView videoPlayView6 = this.a.f48936j;
                if (videoPlayView6 != null) {
                    videoPlayView6.setPrimary(this.a.isPrimary());
                }
                VideoPlayView videoPlayView7 = this.a.f48936j;
                if (videoPlayView7 == null) {
                    return;
                }
                videoPlayView7.setCurrentFragmentUserHint(this.a.G);
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void b(List<? extends VideoItemData> datas, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, datas, z) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                this.a.r = z;
                if (ListUtils.isEmpty(datas)) {
                    return;
                }
                c.a.t0.m4.l.d dVar = this.a.l;
                if ((dVar == null ? null : Boolean.valueOf(dVar.v())).booleanValue()) {
                    return;
                }
                this.a.l.b(datas);
                if (this.a.f48936j != null) {
                    c.a.t0.m4.l.d dVar2 = this.a.l;
                    VideoPlayView videoPlayView = this.a.f48936j;
                    Intrinsics.checkNotNull(videoPlayView);
                    dVar2.a(videoPlayView.currentSelectIndex);
                }
                VideoPlayView videoPlayView2 = this.a.f48936j;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class f implements FrsVideoTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Ref.ObjectRef<List<VideoItemData>> a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f48938b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f48939c;

        public f(Ref.ObjectRef<List<VideoItemData>> objectRef, Ref.ObjectRef<String> objectRef2, VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectRef, objectRef2, videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = objectRef;
            this.f48938b = objectRef2;
            this.f48939c = videoVerticalPageFragment;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List, T] */
        @Override // com.baidu.tieba.videoplay.model.FrsVideoTabModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.element = FrsVideoTabPlayActivityConfig.getVideoTabListByFid(this.f48938b.element);
                if (this.a.element == null || this.f48939c.l.v() || this.f48939c.f48936j == null) {
                    return;
                }
                this.f48939c.l.z(this.a.element);
                VideoPlayView videoPlayView = this.f48939c.f48936j;
                Intrinsics.checkNotNull(videoPlayView);
                videoPlayView.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class g implements VideoChannelModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        public g(VideoVerticalPageFragment videoVerticalPageFragment) {
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
            this.a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void a(List<? extends VideoItemData> datas, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, datas, z) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                if (ListUtils.isEmpty(datas)) {
                    return;
                }
                this.a.l.z(datas);
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && (((c.a.s0.b.d.p0() && c.a.t0.f1.a.i().m("6061002332-203360688")) || (c.a.s0.b.d.q0() && c.a.t0.f1.a.i().m("6061002410-390177882"))) && this.a.f48936j != null)) {
                    c.a.t0.m4.l.d dVar = this.a.l;
                    VideoPlayView videoPlayView = this.a.f48936j;
                    Intrinsics.checkNotNull(videoPlayView);
                    dVar.a(videoPlayView.currentSelectIndex);
                }
                VideoPlayView videoPlayView2 = this.a.f48936j;
                if (videoPlayView2 != null) {
                    videoPlayView2.notifyDataSetChanged();
                }
                VideoPlayView videoPlayView3 = this.a.f48936j;
                if (videoPlayView3 != null) {
                    videoPlayView3.setSelectIndex(0, true);
                }
                VideoPlayView videoPlayView4 = this.a.f48936j;
                if (videoPlayView4 != null) {
                    videoPlayView4.setPrimary(this.a.isPrimary());
                }
                c.a.t0.m4.q.a aVar = this.a.N;
                if (aVar == null) {
                    return;
                }
                aVar.i();
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void b(List<? extends VideoItemData> datas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, datas) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                if (ListUtils.isEmpty(datas) || this.a.l.v()) {
                    return;
                }
                this.a.l.b(datas);
                if (this.a.f48936j != null) {
                    c.a.t0.m4.l.d dVar = this.a.l;
                    VideoPlayView videoPlayView = this.a.f48936j;
                    Intrinsics.checkNotNull(videoPlayView);
                    dVar.a(videoPlayView.currentSelectIndex);
                }
                VideoPlayView videoPlayView2 = this.a.f48936j;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(VideoVerticalPageFragment videoVerticalPageFragment) {
            super(2921646);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (this.a.isVisible() && (responsedMessage.getData() instanceof Boolean)) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        boolean booleanValue = ((Boolean) data).booleanValue();
                        if (this.a.f48934h == 3 || (TbSingleton.getInstance().isFromFeedVideoClick() && this.a.f48934h == 1)) {
                            if (booleanValue) {
                                this.a.K(0);
                                return;
                            } else {
                                this.a.K(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                                return;
                            }
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(VideoVerticalPageFragment videoVerticalPageFragment) {
            super(2016331);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                Object data = responsedMessage.getData();
                if (data != null) {
                    String str = (String) data;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    c.a.t0.m4.q.a aVar = this.a.N;
                    List<VideoItemModel> h2 = aVar == null ? null : aVar.h(str);
                    if (h2 != null) {
                        if (!h2.isEmpty()) {
                            this.a.l.h().removeAll(h2);
                            VideoPlayView videoPlayView = this.a.f48936j;
                            if (videoPlayView == null) {
                                return;
                            }
                            videoPlayView.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.baidu.tieba.video.VideoItemModel>");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(VideoVerticalPageFragment videoVerticalPageFragment) {
            super(2921566, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getData() instanceof Integer) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        if (this.a.l.e(((Integer) data).intValue())) {
                            VideoPlayView videoPlayView = this.a.f48936j;
                            if (videoPlayView != null) {
                                videoPlayView.notifyDataSetChanged();
                            }
                            VideoPlayView videoPlayView2 = this.a.f48936j;
                            if (videoPlayView2 != null) {
                                videoPlayView2.setPrimary(this.a.isPrimary());
                            }
                            VideoPlayView videoPlayView3 = this.a.f48936j;
                            if (videoPlayView3 == null) {
                                return;
                            }
                            videoPlayView3.setCurrentFragmentUserHint(this.a.G);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(VideoVerticalPageFragment videoVerticalPageFragment) {
            super(2000994);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> resMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, resMsg) == null) {
                Intrinsics.checkNotNullParameter(resMsg, "resMsg");
                if ((resMsg instanceof NetWorkChangedMessage) && resMsg.getCmd() == 2000994 && !resMsg.hasError() && c.a.d.f.p.l.z() && this.a.l.v()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921568));
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(VideoVerticalPageFragment videoVerticalPageFragment) {
            super(2921581);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
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
                    e2 e2Var = new e2();
                    e2Var.d3(redIcon.thread_list.get(0));
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData(e2Var);
                    VideoItemModel videoItemModel = new VideoItemModel(videoItemData, 1);
                    c.a.t0.m4.l.d dVar = this.a.l;
                    VideoPlayView videoPlayView = this.a.f48936j;
                    if (dVar.u(videoItemModel, videoPlayView != null ? videoPlayView.currentSelectIndex : 0)) {
                        VideoPlayActivityStatic.a(redIcon);
                        TbSingleton.getInstance().setVideoChannelRecommendRedIcon(null);
                        VideoPlayView videoPlayView2 = this.a.f48936j;
                        if (videoPlayView2 != null) {
                            videoPlayView2.notifyDataSetChanged();
                        }
                        VideoPlayView videoPlayView3 = this.a.f48936j;
                        if (videoPlayView3 != null) {
                            videoPlayView3.setPrimary(this.a.isPrimary());
                        }
                        VideoPlayView videoPlayView4 = this.a.f48936j;
                        if (videoPlayView4 == null) {
                            return;
                        }
                        videoPlayView4.setCurrentFragmentUserHint(this.a.G);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type tbclient.VideoRedIcon.RedIcon");
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(VideoVerticalPageFragment videoVerticalPageFragment) {
            super(2016488);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getData() instanceof JSONObject) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        String optString = ((JSONObject) data).optString("tid");
                        if (optString != null) {
                            if (this.a.l.f(optString)) {
                                VideoPlayView videoPlayView = this.a.f48936j;
                                if (videoPlayView != null) {
                                    videoPlayView.notifyDataSetChanged();
                                }
                                VideoPlayView videoPlayView2 = this.a.f48936j;
                                if (videoPlayView2 != null) {
                                    videoPlayView2.setPrimary(this.a.isPrimary());
                                }
                                VideoPlayView videoPlayView3 = this.a.f48936j;
                                if (videoPlayView3 == null) {
                                    return;
                                }
                                videoPlayView3.setCurrentFragmentUserHint(this.a.G);
                                return;
                            }
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class n implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

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
            this.a = videoVerticalPageFragment;
        }

        @Override // c.a.t0.f1.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && c.a.t0.f1.a.i().m("6061002332-203360688") && this.a.f48936j != null) {
                c.a.t0.m4.l.d dVar = this.a.l;
                VideoPlayView videoPlayView = this.a.f48936j;
                Intrinsics.checkNotNull(videoPlayView);
                dVar.a(videoPlayView.currentSelectIndex);
                VideoPlayView videoPlayView2 = this.a.f48936j;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.notifyDataSetChanged();
            }
        }

        @Override // c.a.t0.f1.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class o implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

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
            this.a = videoVerticalPageFragment;
        }

        @Override // c.a.t0.f1.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && c.a.t0.f1.a.i().m("6061002410-390177882") && this.a.f48936j != null) {
                c.a.t0.m4.l.d dVar = this.a.l;
                VideoPlayView videoPlayView = this.a.f48936j;
                Intrinsics.checkNotNull(videoPlayView);
                dVar.a(videoPlayView.currentSelectIndex);
                VideoPlayView videoPlayView2 = this.a.f48936j;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.notifyDataSetChanged();
            }
        }

        @Override // c.a.t0.f1.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class p implements VideoPersonalModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        public p(VideoVerticalPageFragment videoVerticalPageFragment) {
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
            this.a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoPersonalModel.b
        public void a(List<VideoItemData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "list");
                if (!(!list.isEmpty()) || this.a.l.v() || this.a.f48936j == null) {
                    return;
                }
                this.a.l.b(list);
                VideoPlayView videoPlayView = this.a.f48936j;
                Intrinsics.checkNotNull(videoPlayView);
                videoPlayView.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class q implements VideoPlayView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

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
            this.a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_ROLLBACK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.a.f48934h != 3 && this.a.f48934h != 4) {
                    if (c.a.s0.b.d.e()) {
                        statisticItem.param("obj_type", 1);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    statisticItem.param("obj_locate", 2);
                } else {
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", this.a.getShowVideoTid(Integer.valueOf(i2)));
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class r implements VideoPlayView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

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
            this.a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || VideoVerticalPageFragment.getShowVideoTid$default(this.a, null, 1, null) == 0) {
                return;
            }
            VideoVerticalPageFragment videoVerticalPageFragment = this.a;
            videoVerticalPageFragment.y = Long.valueOf(VideoVerticalPageFragment.getShowVideoTid$default(videoVerticalPageFragment, null, 1, null));
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

    public /* synthetic */ VideoVerticalPageFragment(BdUniqueId bdUniqueId, BdSwipeRefreshLayout.k kVar, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : bdUniqueId, (i4 & 2) != 0 ? null : kVar, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    public static final void D(VideoVerticalPageFragment this$0, Unit unit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, unit) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.r()) {
                this$0.B(false, false, null);
            } else if (this$0.v()) {
                this$0.C();
            }
        }
    }

    public static final void E(VideoVerticalPageFragment this$0, Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, pair) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (pair == null) {
                return;
            }
            Boolean bool = (Boolean) pair.first;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            this$0.B(true, bool.booleanValue(), (String) pair.second);
        }
    }

    public static final boolean F(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view, motionEvent)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static final void H(VideoVerticalPageFragment this$0, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, list) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(list, "list");
            if (!(!list.isEmpty()) || this$0.l.v() || this$0.f48936j == null) {
                return;
            }
            this$0.l.b(list);
            VideoPlayView videoPlayView = this$0.f48936j;
            Intrinsics.checkNotNull(videoPlayView);
            videoPlayView.notifyDataSetChanged();
        }
    }

    public static final void J(VideoVerticalPageFragment this$0, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{this$0, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!z || !this$0.w() || this$0.getPageContext() == null || this$0.getPageContext().getPageActivity() == null || this$0.q() || this$0.l() || this$0.k() || this$0.s() || this$0.o() || this$0.n() || this$0.t() || this$0.p()) {
                return;
            }
            c.a.d.f.p.n.N(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(c.a.t0.m4.i.no_more_production));
        }
    }

    public static final void M(VideoVerticalPageFragment this$0) {
        VideoPlayModel videoPlayModel;
        VideoChannelModel videoChannelModel;
        FrsVideoTabModel frsVideoTabModel;
        VideoHotTopicModel videoHotTopicModel;
        VideoPersonalModel videoPersonalModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.r) {
                if (this$0.x()) {
                    Long l2 = this$0.l.l();
                    c.a.t0.m4.l.d dVar = this$0.l;
                    VideoPlayView videoPlayView = this$0.f48936j;
                    Intrinsics.checkNotNull(videoPlayView);
                    UserItemData i2 = dVar.i(videoPlayView.currentSelectIndex);
                    if (l2 == null || i2 == null || (videoPersonalModel = this$0.C) == null) {
                        return;
                    }
                    videoPersonalModel.C(l2, i2);
                } else if (this$0.v()) {
                    Long l3 = this$0.l.l();
                    if (l3 == null || (videoHotTopicModel = this$0.D) == null) {
                        return;
                    }
                    videoHotTopicModel.B(l3);
                } else {
                    int i3 = this$0.f48934h;
                    if (i3 == 1 || i3 == 2) {
                        VideoPlayModel videoPlayModel2 = this$0.A;
                        if (videoPlayModel2 != null) {
                            videoPlayModel2.setFrom(this$0.q);
                        }
                        if (this$0.l.x() || (videoPlayModel = this$0.A) == null) {
                            return;
                        }
                        videoPlayModel.I(this$0.l.s(0));
                    } else if (i3 == 7) {
                        if (this$0.l.x() || (frsVideoTabModel = this$0.E) == null) {
                            return;
                        }
                        frsVideoTabModel.loadMore();
                    } else {
                        VideoChannelModel videoChannelModel2 = this$0.B;
                        if (videoChannelModel2 != null) {
                            videoChannelModel2.setFrom(this$0.q);
                        }
                        if (this$0.l.x() || (videoChannelModel = this$0.B) == null) {
                            return;
                        }
                        videoChannelModel.loadMore();
                    }
                }
            }
        }
    }

    public static final void R(VideoVerticalPageFragment this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.w() && this$0.getPageContext() != null && this$0.getPageContext().getPageActivity() != null && !this$0.q() && !this$0.l() && !this$0.k() && !this$0.s() && !this$0.o() && !this$0.n() && !this$0.t() && !this$0.p()) {
                c.a.d.f.p.n.N(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(c.a.t0.m4.i.no_more_production));
            }
            if (this$0.u()) {
                VideoPlayView videoPlayView = this$0.f48936j;
                boolean z = false;
                if (videoPlayView != null && videoPlayView.isUpOrDownScroll()) {
                    z = true;
                }
                if (!z || this$0.getPageContext() == null || this$0.getPageContext().getPageActivity() == null) {
                    return;
                }
                c.a.d.f.p.n.N(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(c.a.t0.m4.i.no_more_video));
            }
        }
    }

    public static /* synthetic */ long getShowVideoTid$default(VideoVerticalPageFragment videoVerticalPageFragment, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        return videoVerticalPageFragment.getShowVideoTid(num);
    }

    public static final void j(VideoVerticalPageFragment this$0, Void r5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, this$0, r5) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setInterceptStimeStat(true);
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = this.v;
            if (personalPageParams == null) {
                return false;
            }
            return personalPageParams.isShareThread();
        }
        return invokeV.booleanValue;
    }

    public final void B(boolean z, boolean z2, String str) {
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        VideoPersonalModel videoPersonalModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) || (personalPageParams = this.v) == null || (videoPersonalModel = this.C) == null) {
            return;
        }
        c.a.t0.m4.l.d dVar = this.l;
        VideoPlayView videoPlayView = this.f48936j;
        Intrinsics.checkNotNull(videoPlayView);
        String r2 = dVar.r(videoPlayView.currentSelectIndex);
        if (r2 == null) {
            return;
        }
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

    public final void C() {
        VideoHotTopicParams videoHotTopicParams;
        VideoHotTopicModel videoHotTopicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (videoHotTopicParams = this.w) == null || (videoHotTopicModel = this.D) == null) {
            return;
        }
        c.a.t0.m4.l.d dVar = this.l;
        VideoPlayView videoPlayView = this.f48936j;
        Intrinsics.checkNotNull(videoPlayView);
        String r2 = dVar.r(videoPlayView.currentSelectIndex);
        if (r2 == null) {
            return;
        }
        VideoNotifyPersonalPageData videoNotifyPersonalPageData = new VideoNotifyPersonalPageData();
        videoNotifyPersonalPageData.setCurrentThreadId(r2);
        videoNotifyPersonalPageData.setFlutterPageId(videoHotTopicParams.getFlutterPageId());
        videoNotifyPersonalPageData.setVideoHotTopicDataResMapList(videoHotTopicModel.A());
        videoNotifyPersonalPageData.setCurrentPn(videoHotTopicParams.getCurrentPn());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921623, videoNotifyPersonalPageData));
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || getPageContext() == null || getUniqueId() == null || this.w == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        VideoHotTopicParams videoHotTopicParams = this.w;
        Intrinsics.checkNotNull(videoHotTopicParams);
        VideoHotTopicModel videoHotTopicModel = new VideoHotTopicModel(pageContext, videoHotTopicParams);
        this.D = videoHotTopicModel;
        if (videoHotTopicModel == null) {
            return;
        }
        videoHotTopicModel.C(new VideoHotTopicModel.b() { // from class: c.a.t0.m4.p.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.videoplay.model.VideoHotTopicModel.b
            public final void a(List list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                    VideoVerticalPageFragment.H(VideoVerticalPageFragment.this, list);
                }
            }
        });
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || getPageContext() == null || getUniqueId() == null || this.v == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = this.v;
        Intrinsics.checkNotNull(personalPageParams);
        VideoPersonalModel videoPersonalModel = new VideoPersonalModel(pageContext, personalPageParams);
        this.C = videoPersonalModel;
        if (videoPersonalModel == null) {
            return;
        }
        videoPersonalModel.D(new p(this));
    }

    public final void K(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (view = this.f48935i) == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        int paddingLeft = view.getPaddingLeft();
        View view2 = this.f48935i;
        Intrinsics.checkNotNull(view2);
        int paddingTop = view2.getPaddingTop();
        View view3 = this.f48935i;
        Intrinsics.checkNotNull(view3);
        view.setPadding(paddingLeft, paddingTop, view3.getPaddingRight(), i2);
    }

    public final void L() {
        VideoPlayView videoPlayView;
        VideoPlayView videoPlayView2;
        VideoPlayView videoPlayView3;
        VideoPlayView videoPlayView4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BdUniqueId bdUniqueId = this.f48931e;
            Activity pageActivity = getPageContext().getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView5 = new VideoPlayView(bdUniqueId, (FragmentActivity) pageActivity, this, this.q, getUniqueId(), 1, this.f48934h, A());
                this.f48936j = videoPlayView5;
                if (videoPlayView5 != null) {
                    videoPlayView5.setDragDirectionListener(new q(this));
                }
                if (this.f48934h == 3 && (videoPlayView4 = this.f48936j) != null) {
                    videoPlayView4.setSubFrom(VideoPlayView.FROM_SUGGEST_SUB_FRAGMENT);
                }
                VideoPlayView videoPlayView6 = this.f48936j;
                if (videoPlayView6 != null) {
                    BdSwipeRefreshLayout.k kVar = this.f48932f;
                    if (kVar == null) {
                        kVar = this.S;
                    }
                    videoPlayView6.setProgressViewCallback(kVar);
                }
                VideoPlayView videoPlayView7 = this.f48936j;
                if (videoPlayView7 != null) {
                    videoPlayView7.setBottomScrollMoreCallback(this.T);
                }
                if (this.f48933g != 1 && (videoPlayView3 = this.f48936j) != null) {
                    videoPlayView3.setEventListener(this.L);
                }
                if (this.f48934h == 7 && (videoPlayView2 = this.f48936j) != null) {
                    videoPlayView2.setOnLastShowVideoCallBack(new r(this));
                }
                c.a.t0.m4.q.a aVar = this.N;
                if (aVar != null) {
                    aVar.o(this.f48936j);
                }
                VideoPlayView videoPlayView8 = this.f48936j;
                if (videoPlayView8 != null) {
                    videoPlayView8.setOnLoadMoreListener(new VideoPlayView.f() { // from class: c.a.t0.m4.p.i
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.videoplay.VideoPlayView.f
                        public final void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                VideoVerticalPageFragment.M(VideoVerticalPageFragment.this);
                            }
                        }
                    });
                }
                VideoPlayView videoPlayView9 = this.f48936j;
                if (videoPlayView9 != null) {
                    videoPlayView9.showData(this.l, this.m, this.o);
                }
                VideoPlayView videoPlayView10 = this.f48936j;
                if (videoPlayView10 != null) {
                    videoPlayView10.setPageFrom(this.p);
                }
                VideoPlayView videoPlayView11 = this.f48936j;
                if (videoPlayView11 != null) {
                    videoPlayView11.setObjId(this.z);
                }
                VideoPlayView videoPlayView12 = this.f48936j;
                if (videoPlayView12 != null) {
                    videoPlayView12.setVideoChannelPageType(this.f48933g);
                }
                if (w() && (videoPlayView = this.f48936j) != null) {
                    videoPlayView.setSelectIndex(this.n, false);
                }
                VideoPlayView videoPlayView13 = this.f48936j;
                if (videoPlayView13 == null) {
                    return;
                }
                videoPlayView13.setNadDispatcher(this.N);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.t0.m4.l.e.g(getActivity() instanceof VideoPlayActivity ? "1" : "3");
        }
    }

    public final void O(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        UserItemData userItemData;
        UserItemData userItemData2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoItemData, list) == null) {
            VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list, 0);
            if (videoItemData == null || (userItemData = videoItemData.author_info) == null || videoItemData2 == null || (userItemData2 = videoItemData2.author_info) == null || (str = userItemData2.user_id) == null || !Intrinsics.areEqual(str, userItemData.user_id)) {
                return;
            }
            videoItemData2.author_info.is_follow = videoItemData.author_info.is_follow;
        }
    }

    public final void P(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, videoItemData, list) == null) {
            VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list, 0);
            if (videoItemData == null) {
                return;
            }
            videoItemData.threadData = videoItemData2 == null ? null : videoItemData2.threadData;
            if (videoItemData.feedBackReasonMap == null) {
                videoItemData.feedBackReasonMap = videoItemData2 == null ? null : videoItemData2.feedBackReasonMap;
                videoItemData.feedBackExtraMap = videoItemData2 == null ? null : videoItemData2.feedBackExtraMap;
            }
            videoItemData.mRichAbstractList = videoItemData2 != null ? videoItemData2.mRichAbstractList : null;
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean d2 = c.a.s0.g1.b.c.d();
            RelativeLayout relativeLayout = this.k;
            if (relativeLayout != null) {
                Intrinsics.checkNotNull(relativeLayout);
                relativeLayout.setVisibility(d2 ? 0 : 8);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f48934h == 3 ? "a088" : "a023" : (String) invokeV.objValue;
    }

    public final Long getFirstVideoTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.x : (Long) invokeV.objValue;
    }

    public final Long getLastVideoTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.y : (Long) invokeV.objValue;
    }

    @Override // c.a.t0.m4.p.n
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            VideoItemData s = this.l.s(this.m);
            if (s == null || TextUtils.isEmpty(s.thread_id)) {
                return 0L;
            }
            return c.a.d.f.m.b.g(s.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    public final BdSwipeRefreshLayout.k getProgressViewCallbackFra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.S : (BdSwipeRefreshLayout.k) invokeV.objValue;
    }

    public final long getShowVideoTid(Integer num) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, num)) == null) {
            c.a.t0.m4.l.d dVar = this.l;
            if (num == null) {
                VideoPlayView videoPlayView = this.f48936j;
                Intrinsics.checkNotNull(videoPlayView);
                intValue = videoPlayView.currentSelectIndex;
            } else {
                intValue = num.intValue();
            }
            VideoItemData s = dVar.s(intValue);
            if (s == null || TextUtils.isEmpty(s.thread_id)) {
                return 0L;
            }
            return c.a.d.f.m.b.g(s.thread_id, 0L);
        }
        return invokeL.longValue;
    }

    public final b.InterfaceC0856b getVEventListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.L : (b.InterfaceC0856b) invokeV.objValue;
    }

    public final VideoPlayView.h getViewPagerBottomScrollMoreCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.T : (VideoPlayView.h) invokeV.objValue;
    }

    @Override // c.a.t0.m4.p.n
    public void handleActivityResult(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048595, this, i2, i3, intent) == null) || (videoPlayView = this.f48936j) == null) {
            return;
        }
        videoPlayView.handleActivityResult(i2, i3, intent);
    }

    @Override // c.a.t0.m4.p.n
    public boolean handleBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            VideoPlayView videoPlayView = this.f48936j;
            return videoPlayView != null && videoPlayView.handleBackPress();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.m4.p.n
    public void handleIndexMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            VideoPlayView videoPlayView = this.f48936j;
            Intrinsics.checkNotNull(videoPlayView);
            int i2 = videoPlayView.firstInIndex;
            VideoPlayView videoPlayView2 = this.f48936j;
            Intrinsics.checkNotNull(videoPlayView2);
            if (i2 != videoPlayView2.currentSelectIndex) {
                VideoPlayView videoPlayView3 = this.f48936j;
                Intrinsics.checkNotNull(videoPlayView3);
                if (videoPlayView3.currentSelectIndex >= 0) {
                    VideoPlayView videoPlayView4 = this.f48936j;
                    Intrinsics.checkNotNull(videoPlayView4);
                    if (videoPlayView4.currentSelectIndex < this.l.k()) {
                        c.a.t0.m4.l.d dVar = this.l;
                        VideoPlayView videoPlayView5 = this.f48936j;
                        Intrinsics.checkNotNull(videoPlayView5);
                        VideoItemData s = dVar.s(videoPlayView5.currentSelectIndex);
                        if (s == null || StringUtils.isNull(s.thread_id)) {
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, s.thread_id));
                    }
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            c.a.t0.m4.l.e.f("5");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v102, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v103, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v101, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r3v99, types: [java.util.List<com.baidu.tieba.video.VideoItemData>, T] */
    public final void initData() {
        int i2;
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.l.c();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Bundle arguments = getArguments();
            objectRef.element = (ArrayList) (arguments == null ? null : arguments.getSerializable("video_list"));
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Bundle arguments2 = getArguments();
            T string = arguments2 == null ? 0 : arguments2.getString("forum_id");
            objectRef2.element = string;
            if (objectRef.element == 0) {
                if (this.f48934h == 7) {
                    objectRef.element = FrsVideoTabPlayActivityConfig.getVideoTabListByFid((String) string);
                } else {
                    objectRef.element = VideoPlayActivityConfig.bigDataList;
                }
            }
            this.l.z((List) objectRef.element);
            if (getArguments() != null) {
                Bundle arguments3 = getArguments();
                Intrinsics.checkNotNull(arguments3);
                i2 = arguments3.getInt("video_index", 0);
            } else {
                i2 = 0;
            }
            this.m = i2;
            if (getArguments() != null) {
                Bundle arguments4 = getArguments();
                Intrinsics.checkNotNull(arguments4);
                i3 = arguments4.getInt("video_show_index", 0);
            } else {
                i3 = 0;
            }
            this.n = i3;
            Bundle arguments5 = getArguments();
            if ((arguments5 == null ? null : (Rect) arguments5.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT)) != null) {
                Bundle arguments6 = getArguments();
                this.o = arguments6 == null ? null : (Rect) arguments6.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
            } else {
                Bundle arguments7 = getArguments();
                if ((arguments7 == null ? null : (Rect) arguments7.getParcelable("video_cover_rect")) != null) {
                    Bundle arguments8 = getArguments();
                    this.o = arguments8 == null ? null : (Rect) arguments8.getParcelable("video_cover_rect");
                } else {
                    Bundle arguments9 = getArguments();
                    this.o = arguments9 == null ? null : (Rect) arguments9.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
                }
            }
            Bundle arguments10 = getArguments();
            this.p = arguments10 == null ? null : arguments10.getString("page_from");
            Bundle arguments11 = getArguments();
            this.q = arguments11 == null ? null : arguments11.getString("from");
            Bundle arguments12 = getArguments();
            this.s = arguments12 == null ? null : arguments12.getString("st_type");
            Bundle arguments13 = getArguments();
            this.t = arguments13 == null ? null : arguments13.getString("yuelaou_locate");
            if (getArguments() != null) {
                Bundle arguments14 = getArguments();
                Intrinsics.checkNotNull(arguments14);
                z = arguments14.getBoolean("is_vertail", true);
            } else {
                z = false;
            }
            this.u = z;
            if (this.v == null) {
                this.v = VideoRecommentPlayActivityConfig.bigPersonalPageParams;
            }
            if (this.w == null) {
                this.w = VideoRecommentPlayActivityConfig.bigVideoHotTopicParams;
            }
            if (this.l.v() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.l.z(VideoPlayActivityConfig.bigDataList);
            }
            this.l.C(getUniqueId());
            if (this.f48934h != 3 && (!TbSingleton.getInstance().isFromFeedVideoClick() || this.f48934h != 1)) {
                this.l.D("a023");
            } else {
                K(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.l.D("a088");
            }
            int i4 = this.f48934h;
            if (i4 != 1 && i4 != 2) {
                if (w()) {
                    if (this.n >= this.l.k()) {
                        this.n = 0;
                    }
                    if (x()) {
                        I();
                    }
                    if (v()) {
                        G();
                    }
                } else if (!q() && !l() && !k() && !s() && !o() && !n() && !t() && !p()) {
                    if (this.f48934h == 7) {
                        if (getPageContext() == null || getUniqueId() == null) {
                            return;
                        }
                        FrsVideoTabModel frsVideoTabModel = new FrsVideoTabModel(getPageContext(), getUniqueId());
                        this.E = frsVideoTabModel;
                        if (frsVideoTabModel != null) {
                            frsVideoTabModel.setFrom(this.q);
                        }
                        FrsVideoTabModel frsVideoTabModel2 = this.E;
                        if (frsVideoTabModel2 != null) {
                            frsVideoTabModel2.y(this.f48933g);
                        }
                        FrsVideoTabModel frsVideoTabModel3 = this.E;
                        if (frsVideoTabModel3 != null) {
                            frsVideoTabModel3.z(new f(objectRef, objectRef2, this));
                        }
                    } else {
                        VideoChannelModel videoChannelModel = new VideoChannelModel(getPageContext(), getUniqueId());
                        this.B = videoChannelModel;
                        if (videoChannelModel != null) {
                            videoChannelModel.setFrom(this.q);
                        }
                        VideoChannelModel videoChannelModel2 = this.B;
                        if (videoChannelModel2 != null) {
                            videoChannelModel2.F(this.f48933g);
                        }
                        VideoChannelModel videoChannelModel3 = this.B;
                        if (videoChannelModel3 != null) {
                            videoChannelModel3.G(new g(this));
                        }
                        if (this.l.s(0) != null) {
                            VideoItemData s = this.l.s(0);
                            this.z = s != null ? s.thread_id : null;
                        }
                        VideoChannelModel videoChannelModel4 = this.B;
                        if (videoChannelModel4 != null) {
                            videoChannelModel4.setFrom(this.q);
                        }
                        if (!c.a.d.f.p.l.z() && !isPrimary()) {
                            return;
                        }
                        if (y()) {
                            VideoChannelModel videoChannelModel5 = this.B;
                            if (videoChannelModel5 != null) {
                                videoChannelModel5.loadMore();
                            }
                        } else {
                            VideoChannelModel videoChannelModel6 = this.B;
                            if (videoChannelModel6 != null) {
                                videoChannelModel6.E();
                            }
                        }
                    }
                } else if (this.n >= this.l.k()) {
                    this.n = 0;
                }
            } else {
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest()) {
                    if (c.a.s0.b.d.p0()) {
                        c.a.t0.f1.a.i().q(getActivity(), new c(this), this.l.o());
                    }
                    if (c.a.s0.b.d.q0()) {
                        c.a.t0.f1.a.i().p(getActivity(), new d(this), this.l.o());
                    }
                }
                VideoPlayModel videoPlayModel = new VideoPlayModel(getPageContext(), getUniqueId());
                this.A = videoPlayModel;
                if (videoPlayModel != null) {
                    videoPlayModel.setFrom(this.q);
                }
                VideoPlayModel videoPlayModel2 = this.A;
                if (videoPlayModel2 != null) {
                    videoPlayModel2.K(this.f48933g);
                }
                VideoPlayModel videoPlayModel3 = this.A;
                if (videoPlayModel3 != null) {
                    videoPlayModel3.L(new e(this));
                }
                if (this.l.s(0) != null) {
                    VideoItemData s2 = this.l.s(0);
                    this.z = s2 != null ? s2.thread_id : null;
                }
                VideoPlayModel videoPlayModel4 = this.A;
                if (videoPlayModel4 != null) {
                    videoPlayModel4.setFrom(this.q);
                }
                VideoPlayModel videoPlayModel5 = this.A;
                if (videoPlayModel5 != null) {
                    videoPlayModel5.J(this.l.s(0), this.s, this.t, this.u);
                }
            }
            this.N = new c.a.t0.m4.q.a(this.l.h(), getPageContext());
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f48934h == 11 : invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f48934h == 10 : invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f48934h == 18 : invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f48934h == 13 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.J = new OnActivityFinishListener<>(getPageContext(), new SimpleMessageListener.b() { // from class: c.a.t0.m4.p.h
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.util.SimpleMessageListener.b
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        VideoVerticalPageFragment.D(VideoVerticalPageFragment.this, (Unit) obj);
                    }
                }
            });
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            this.K = new OnDeleteSelfPostListener(pageContext, new SimpleMessageListener.b() { // from class: c.a.t0.m4.p.j
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.util.SimpleMessageListener.b
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        VideoVerticalPageFragment.E(VideoVerticalPageFragment.this, (Pair) obj);
                    }
                }
            });
            Lifecycle lifecycle = getLifecycle();
            OnDeleteSelfPostListener onDeleteSelfPostListener = this.K;
            Intrinsics.checkNotNull(onDeleteSelfPostListener);
            lifecycle.addObserver(onDeleteSelfPostListener);
            Lifecycle lifecycle2 = getLifecycle();
            OnActivityFinishListener<Unit> onActivityFinishListener = this.J;
            Intrinsics.checkNotNull(onActivityFinishListener);
            lifecycle2.addObserver(onActivityFinishListener);
            getLifecycle().addObserver(this.I);
            initData();
            L();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048605, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                handleActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            VideoPlayView videoPlayView = this.f48936j;
            if (videoPlayView != null) {
                videoPlayView.onChangeSkinType(i2);
            }
            if (!c.a.s0.b.d.m() || (getActivity() instanceof VideoRecommentPlayActivity)) {
                SkinManager.setBackgroundColor(this.f48935i, c.a.t0.m4.c.CAM_X0611);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048607, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            registerListener(this.P);
            registerListener(this.O);
            registerListener(this.R);
            registerListener(this.M);
            registerListener(this.Q);
            registerListener(this.V);
            registerListener(this.U);
            this.f48935i = inflater.inflate(c.a.t0.m4.g.video_vertical_page_fragment, viewGroup, false);
            if (c.a.s0.b.d.m() && !(getActivity() instanceof VideoRecommentPlayActivity) && (view = this.f48935i) != null) {
                view.setBackgroundColor(0);
            }
            View view2 = this.f48935i;
            RelativeLayout relativeLayout = view2 == null ? null : (RelativeLayout) view2.findViewById(c.a.t0.m4.f.youngster_vertical_layout);
            this.k = relativeLayout;
            if (relativeLayout != null) {
                relativeLayout.setOnTouchListener(c.a.t0.m4.p.d.f19658e);
            }
            return this.f48935i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onDestroy();
            if (this.K != null) {
                Lifecycle lifecycle = getLifecycle();
                OnDeleteSelfPostListener onDeleteSelfPostListener = this.K;
                Intrinsics.checkNotNull(onDeleteSelfPostListener);
                lifecycle.removeObserver(onDeleteSelfPostListener);
            }
            if (this.J != null) {
                Lifecycle lifecycle2 = getLifecycle();
                OnActivityFinishListener<Unit> onActivityFinishListener = this.J;
                Intrinsics.checkNotNull(onActivityFinishListener);
                lifecycle2.removeObserver(onActivityFinishListener);
            }
            getLifecycle().removeObserver(this.I);
            VideoPlayView videoPlayView = this.f48936j;
            if (videoPlayView != null) {
                videoPlayView.onDestroy();
            }
            if (isPrimary()) {
                N();
            }
            if (getActivity() instanceof FrsVideoTabPlayActivity) {
                i();
            }
            VideoPersonalModel videoPersonalModel = this.C;
            if (videoPersonalModel == null) {
                return;
            }
            videoPersonalModel.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onDestroyView();
            c.a.t0.f1.a.i().d("6061002332-203360688");
            c.a.t0.f1.a.i().c("6061002410-390177882");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f48936j;
            if (videoPlayView == null) {
                return;
            }
            videoPlayView.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onPrimary();
            if (!this.G) {
                N();
            }
            if (getActivity() instanceof FrsVideoTabPlayActivity) {
                i();
            }
            if (this.G && this.f48934h == 3) {
                c.a.t0.m4.k.c(1);
            }
            if (isPrimary()) {
                c.a.s0.j0.g.c.b().c();
                c.a.s0.j0.g.c.b().l(true);
            }
            this.x = Long.valueOf(getMissionTid());
            VideoPlayView videoPlayView = this.f48936j;
            if (videoPlayView != null) {
                videoPlayView.setPrimary(isPrimary());
            }
            if (!this.F && isPrimary() && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.f48934h == 3) {
                this.F = true;
                if (c.a.s0.b.d.p0()) {
                    c.a.t0.f1.a.i().q(getActivity(), new n(this), this.l.o());
                } else if (c.a.s0.b.d.q0()) {
                    c.a.t0.f1.a.i().p(getActivity(), new o(this), this.l.o());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onResume();
            if (this.H && this.G && isPrimary()) {
                setUserVisibleHint(true);
                this.H = false;
            }
            if (TbSingleton.getInstance().isVideoChannelRelogin() && isPrimary()) {
                TbSingleton.getInstance().setVideoChannelRelogin(false);
                VideoPlayView videoPlayView = this.f48936j;
                if (videoPlayView == null) {
                    return;
                }
                videoPlayView.setCurrentFragmentUserHint(this.G);
            }
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f48934h == 14 : invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f48934h == 9 : invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f48934h == 6 : invokeV.booleanValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f48934h == 12 : invokeV.booleanValue;
    }

    public final void setProgressViewCallbackFra(BdSwipeRefreshLayout.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, kVar) == null) {
            Intrinsics.checkNotNullParameter(kVar, "<set-?>");
            this.S = kVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z && this.f48934h == 6) {
                Q();
            }
            VideoPlayView videoPlayView = this.f48936j;
            if (videoPlayView != null) {
                videoPlayView.setCurrentFragmentUserHint(z);
            }
            this.G = z;
        }
    }

    public final void setVideoPlayViewEventListener(b.InterfaceC0856b interfaceC0856b) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, interfaceC0856b) == null) || (videoPlayView = this.f48936j) == null) {
            return;
        }
        videoPlayView.setEventListener(interfaceC0856b);
    }

    public final void setViewPagerBottomScrollMoreCallback(VideoPlayView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, hVar) == null) {
            Intrinsics.checkNotNullParameter(hVar, "<set-?>");
            this.T = hVar;
        }
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f48934h == 19 : invokeV.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f48934h == 7 : invokeV.booleanValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f48934h == 8 : invokeV.booleanValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? z() || x() || v() : invokeV.booleanValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? r() && !A() : invokeV.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? r() && A() : invokeV.booleanValue;
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f48934h == 5 : invokeV.booleanValue;
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
        this.f48931e = bdUniqueId;
        this.f48932f = kVar;
        this.f48933g = i2;
        this.f48934h = i3;
        this.l = new c.a.t0.m4.l.d();
        this.r = true;
        this.H = c.a.s0.a.d.y().E();
        this.I = new VideoPlayFragment.GoPbCommentFloatListener(new SimpleMessageListener.b() { // from class: c.a.t0.m4.p.c
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tbadk.util.SimpleMessageListener.b
            public final void call(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    VideoVerticalPageFragment.j(VideoVerticalPageFragment.this, (Void) obj);
                }
            }
        });
        this.L = new b(this);
        this.M = new l(this);
        this.O = new j(this);
        this.P = new m(this);
        this.Q = new i(this);
        this.R = new k(this);
        this.S = new BdSwipeRefreshLayout.k() { // from class: c.a.t0.m4.p.f
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
            public final void a(int i6, int i7, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z)}) == null) {
                    VideoVerticalPageFragment.J(VideoVerticalPageFragment.this, i6, i7, z);
                }
            }
        };
        this.T = new VideoPlayView.h() { // from class: c.a.t0.m4.p.l
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.videoplay.VideoPlayView.h
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    VideoVerticalPageFragment.R(VideoVerticalPageFragment.this);
                }
            }
        };
        this.U = new h(this);
        this.V = new a(this);
    }
}
