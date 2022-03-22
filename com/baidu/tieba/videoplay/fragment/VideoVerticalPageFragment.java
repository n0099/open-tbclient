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
import c.a.o0.e1.r.b;
import c.a.p0.g1.b;
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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
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
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u009f\u0001B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010T\u001a\u00020<H\u0002J\b\u0010U\u001a\u00020\u001fH\u0016J\r\u0010V\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010WJ\r\u0010X\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010WJ\b\u0010Y\u001a\u00020\u0012H\u0016J\u0017\u0010Z\u001a\u00020\u00122\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\\J\b\u0010]\u001a\u0004\u0018\u00010\u0010J\"\u0010^\u001a\u00020<2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\b2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010c\u001a\u00020\u0017H\u0016J\b\u0010d\u001a\u00020<H\u0016J\b\u0010e\u001a\u00020<H\u0002J\b\u0010f\u001a\u00020\u0017H\u0002J\b\u0010g\u001a\u00020\u0017H\u0002J\b\u0010h\u001a\u00020\u0017H\u0002J\b\u0010i\u001a\u00020\u0017H\u0002J\b\u0010j\u001a\u00020\u0017H\u0002J\b\u0010k\u001a\u00020\u0017H\u0002J\b\u0010l\u001a\u00020\u0017H\u0002J\b\u0010m\u001a\u00020\u0017H\u0002J\b\u0010n\u001a\u00020\u0017H\u0002J\b\u0010o\u001a\u00020\u0017H\u0002J\b\u0010p\u001a\u00020\u0017H\u0002J\b\u0010q\u001a\u00020\u0017H\u0002J\b\u0010r\u001a\u00020\u0017H\u0002J\b\u0010s\u001a\u00020\u0017H\u0002J\b\u0010t\u001a\u00020\u0017H\u0002J\b\u0010u\u001a\u00020\u0017H\u0002J\b\u0010v\u001a\u00020\u0017H\u0002J\b\u0010w\u001a\u00020\u0017H\u0002J\b\u0010x\u001a\u00020\u0017H\u0002J\b\u0010y\u001a\u00020\u0017H\u0002J\"\u0010z\u001a\u00020<2\u0006\u0010{\u001a\u00020\u00172\u0006\u0010|\u001a\u00020\u00172\b\u0010}\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010~\u001a\u00020<H\u0002J\u0014\u0010\u007f\u001a\u00020<2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J#\u0010\u0082\u0001\u001a\u00020<2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\b2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0012\u0010\u0083\u0001\u001a\u00020<2\u0007\u0010\u0084\u0001\u001a\u00020\bH\u0016J-\u0010\u0085\u0001\u001a\u0004\u0018\u00010.2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\t\u0010\u008a\u0001\u001a\u00020<H\u0016J\t\u0010\u008b\u0001\u001a\u00020<H\u0016J\t\u0010\u008c\u0001\u001a\u00020<H\u0016J\t\u0010\u008d\u0001\u001a\u00020<H\u0016J\t\u0010\u008e\u0001\u001a\u00020<H\u0016J\t\u0010\u008f\u0001\u001a\u00020<H\u0002J\t\u0010\u0090\u0001\u001a\u00020<H\u0002J\u0012\u0010\u0091\u0001\u001a\u00020<2\u0007\u0010\u0092\u0001\u001a\u00020\bH\u0002J\u0011\u0010\u0093\u0001\u001a\u00020<2\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020<2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0010J\t\u0010\u0096\u0001\u001a\u00020<H\u0002J\t\u0010\u0097\u0001\u001a\u00020<H\u0002J$\u0010\u0098\u0001\u001a\u00020<2\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u000f\u0010\u009b\u0001\u001a\n\u0012\u0005\u0012\u00030\u009a\u00010\u009c\u0001H\u0002J&\u0010\u009d\u0001\u001a\u00020<2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\u000f\u0010\u009b\u0001\u001a\n\u0012\u0005\u0012\u00030\u009a\u00010\u009c\u0001H\u0002J\t\u0010\u009e\u0001\u001a\u00020<H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010<\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\u00020MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 \u0001"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/videoplay/fragment/IVideoPlayActicityFragment;", "mActivityPageUniqueId", "Lcom/baidu/adp/BdUniqueId;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "mainPageType", "", "mCurrentType", "(Lcom/baidu/adp/BdUniqueId;Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;II)V", "backGroundListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "eventListener", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "firstVideoTid", "", "Ljava/lang/Long;", "goPbCommentFloatListener", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "isSchemeUp", "", "isVertail", "isVisibleToUser", "keyboardShowHideListener", "lastVideoTid", "mAdCloseListener", "mFeedBackListener", "mFrom", "", "mFromPage", "mFrsVideoTabModel", "Lcom/baidu/tieba/videoplay/model/FrsVideoTabModel;", "mHasMore", "mLocate", "mMidChannelNum", "mNAdDispatcher", "Lcom/baidu/tieba/videoplay/nad/AdVideoFlowDispatcher;", "mNetworkChangedMessageListener", "mObjId", "mRecommendTabInsertDataListener", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "mUEGFeedBackListener", "mVideoChannelModel", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoIndex", "mVideoPlayModel", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoShowIndex", "mVideoTabReqFunAd", "onActivityFinishListener", "Lcom/baidu/tbadk/util/OnActivityFinishListener;", "", "onDeleteSelfPostListener", "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "personalPageParams", "Lcom/baidu/tbadk/core/atomData/VideoRecommentPlayActivityConfig$PersonalPageParams;", "progressViewCallbackFra", "getProgressViewCallbackFra", "()Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "setProgressViewCallbackFra", "(Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;)V", "videoHotTopicModel", "Lcom/baidu/tieba/videoplay/model/VideoHotTopicModel;", "videoHotTopicParams", "Lcom/baidu/tbadk/module/hottopic/VideoHotTopicParams;", "videoPersonalModel", "Lcom/baidu/tieba/videoplay/model/VideoPersonalModel;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "getViewPagerBottomScrollMoreCallback", "()Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "setViewPagerBottomScrollMoreCallback", "(Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;)V", "youngsterVerticalLayout", "Landroid/widget/RelativeLayout;", "frsStepStat", "getCurrentPageKey", "getFirstVideoTid", "()Ljava/lang/Long;", "getLastVideoTid", "getMissionTid", "getShowVideoTid", "index", "(Ljava/lang/Integer;)J", "getVEventListener", "handleActivityResult", GroupInfoActivityConfig.REQUEST_CODE, "resultCode", "data", "Landroid/content/Intent;", "handleBackPress", "handleIndexMessage", "initData", "isFromAgreePage", "isFromAtPage", "isFromCollection", "isFromCreateCenterPage", "isFromFrsTop", "isFromHistory", "isFromLink", "isFromMyThread", "isFromOfficalVideo", "isFromPbVideoSchema", "isFromPersonalPage", "isFromReplyPage", "isFromWorkManagement", "isFrsVideoTab", "isHotTopicPlay", "isNoTabPlay", "isPersonalPlay", "isPersonalSharePlay", "isRecommendPlay", "isShareThread", "notifyPersonalPage", "isDelete", "isDeleteSucceed", "deleteErrorMessage", "notifyVideoHotTopicPage", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "processVideoHotTopicModel", "processVideoPersonalModel", "setEmptyHeight", "height", "setUserVisibleHint", "setVideoPlayViewEventListener", "listener", "showData", "stepStat", "syncFirstVideoFollowState", "originalData", "Lcom/baidu/tieba/video/VideoItemData;", "newList", "", "syncFirstVideoThreadData", "updateYoungsterMode", "OnDeleteSelfPostListener", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class VideoVerticalPageFragment extends BaseFragment implements c.a.p0.p4.g.n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsVideoTabModel A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public final VideoPlayFragment.GoPbCommentFloatListener F;
    public OnActivityFinishListener<Unit> G;
    public OnDeleteSelfPostListener H;
    public b.InterfaceC0807b I;
    public final CustomMessageListener J;
    public c.a.p0.p4.h.a K;
    public final CustomMessageListener L;
    public final CustomMessageListener M;
    public final CustomMessageListener N;
    public final CustomMessageListener O;
    public BdSwipeRefreshLayout.k P;
    public VideoPlayView.h Q;
    public final CustomMessageListener R;
    public final CustomMessageListener S;
    public final BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public final BdSwipeRefreshLayout.k f36718b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36719c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36720d;

    /* renamed from: e  reason: collision with root package name */
    public View f36721e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayView f36722f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f36723g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.p0.p4.c.d f36724h;
    public int i;
    public int j;
    public Rect k;
    public String l;
    public String m;
    public boolean n;
    public String o;
    public String p;
    public boolean q;
    public VideoRecommentPlayActivityConfig.PersonalPageParams r;
    public VideoHotTopicParams s;
    public Long t;
    public Long u;
    public String v;
    public VideoPlayModel w;
    public VideoChannelModel x;
    public VideoPersonalModel y;
    public VideoHotTopicModel z;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB-\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "Lcom/baidu/tbadk/util/SimpleMessageListener;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tbadk/util/SimpleMessageListener$Callback;", "Landroidx/core/util/Pair;", "", "", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tbadk/util/SimpleMessageListener$Callback;)V", "Companion", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class OnDeleteSelfPostListener extends SimpleMessageListener {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final a f36725c;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final void a(TbPageContext<?> pageContext, Pair<Boolean, String> data) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, pageContext, data) == null) {
                    Intrinsics.checkNotNullParameter(pageContext, "pageContext");
                    Intrinsics.checkNotNullParameter(data, "data");
                    SimpleMessageListener.b(2001460, pageContext, data);
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
            f36725c = new a(null);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), (SimpleMessageListener.b) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            Intrinsics.checkNotNullParameter(callback, "callback");
            a(pageContext);
        }

        @JvmStatic
        public static final void d(TbPageContext<?> tbPageContext, Pair<Boolean, String> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, tbPageContext, pair) == null) {
                f36725c.a(tbPageContext, pair);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                            if (c.a.d.a.b.g().b() instanceof c.a.p0.c4.a) {
                                Activity b2 = c.a.d.a.b.g().b();
                                if (b2 != null) {
                                    if (((c.a.p0.c4.a) b2).getCurrentTabType() == 22) {
                                        z = true;
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.tblauncher.IMaintabType");
                                }
                            }
                            if ((this.a.C && z) || ((c.a.d.a.b.g().b() instanceof VideoPlayActivity) && (this.a.getActivity() instanceof VideoPlayActivity))) {
                                this.a.D1();
                            }
                            if (!z && (c.a.d.a.b.g().b() instanceof FrsVideoTabPlayActivity) && (this.a.getActivity() instanceof FrsVideoTabPlayActivity)) {
                                this.a.P0();
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements b.InterfaceC0807b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        public b(VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        @Override // c.a.o0.e1.r.b.InterfaceC0807b
        public void K(float f2, float f3) {
            VideoPlayView videoPlayView;
            b.InterfaceC0807b t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (videoPlayView = this.a.f36722f) == null || (t = videoPlayView.t()) == null) {
                return;
            }
            t.K(f2, f3);
        }

        @Override // c.a.o0.e1.r.b.InterfaceC0807b
        public void onViewClick() {
            VideoPlayView videoPlayView;
            b.InterfaceC0807b t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (videoPlayView = this.a.f36722f) == null || (t = videoPlayView.t()) == null) {
                return;
            }
            t.onViewClick();
        }

        @Override // c.a.o0.e1.r.b.InterfaceC0807b
        public void onViewDragToRight() {
            VideoPlayView videoPlayView;
            b.InterfaceC0807b t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (videoPlayView = this.a.f36722f) == null || (t = videoPlayView.t()) == null) {
                return;
            }
            t.onViewDragToRight();
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements b.h {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        @Override // c.a.p0.g1.b.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && c.a.p0.g1.b.j().o("6061002332-203360688") && this.a.f36722f != null) {
                c.a.p0.p4.c.d dVar = this.a.f36724h;
                VideoPlayView videoPlayView = this.a.f36722f;
                Intrinsics.checkNotNull(videoPlayView);
                dVar.a(videoPlayView.f36633h);
                VideoPlayView videoPlayView2 = this.a.f36722f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.A();
            }
        }

        @Override // c.a.p0.g1.b.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements b.h {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        @Override // c.a.p0.g1.b.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && c.a.p0.g1.b.j().o("6061002410-390177882") && this.a.f36722f != null) {
                c.a.p0.p4.c.d dVar = this.a.f36724h;
                VideoPlayView videoPlayView = this.a.f36722f;
                Intrinsics.checkNotNull(videoPlayView);
                dVar.a(videoPlayView.f36633h);
                VideoPlayView videoPlayView2 = this.a.f36722f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.A();
            }
        }

        @Override // c.a.p0.g1.b.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v27, resolved type: c.a.p0.p4.c.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void a(List<? extends VideoItemData> datas, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, datas, z) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                this.a.n = z;
                if (ListUtils.isEmpty(datas) || this.a.f36724h.v()) {
                    return;
                }
                VideoVerticalPageFragment videoVerticalPageFragment = this.a;
                VideoItemData s = videoVerticalPageFragment.f36724h.s(0);
                Intrinsics.checkNotNull(s);
                Intrinsics.checkNotNullExpressionValue(s, "dataController.getVideoData(0)!!");
                videoVerticalPageFragment.E1(s, datas);
                VideoVerticalPageFragment videoVerticalPageFragment2 = this.a;
                videoVerticalPageFragment2.F1(videoVerticalPageFragment2.f36724h.s(0), datas);
                if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_H5_SEARCH, this.a.m)) {
                    this.a.f36724h.b(datas.subList(1, datas.size()));
                } else {
                    this.a.f36724h.z(datas);
                }
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && UbsABTestHelper.isVideoAdDrawABTestA() && c.a.p0.g1.b.j().o("6061002332-203360688") && this.a.f36722f != null) {
                    c.a.p0.p4.c.d dVar = this.a.f36724h;
                    VideoPlayView videoPlayView = this.a.f36722f;
                    Intrinsics.checkNotNull(videoPlayView);
                    dVar.a(videoPlayView.f36633h - 1);
                }
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && UbsABTestHelper.isVideoAdDrawABTestB() && c.a.p0.g1.b.j().o("6061002410-390177882") && this.a.f36722f != null) {
                    c.a.p0.p4.c.d dVar2 = this.a.f36724h;
                    VideoPlayView videoPlayView2 = this.a.f36722f;
                    Intrinsics.checkNotNull(videoPlayView2);
                    dVar2.a(videoPlayView2.f36633h - 1);
                }
                VideoPlayView videoPlayView3 = this.a.f36722f;
                if (videoPlayView3 != null) {
                    videoPlayView3.A();
                }
                VideoPlayView videoPlayView4 = this.a.f36722f;
                if (videoPlayView4 != null) {
                    videoPlayView4.w();
                }
                VideoPlayView videoPlayView5 = this.a.f36722f;
                if (videoPlayView5 != null) {
                    videoPlayView5.P(0, true);
                }
                VideoPlayView videoPlayView6 = this.a.f36722f;
                if (videoPlayView6 != null) {
                    videoPlayView6.N(this.a.isPrimary());
                }
                VideoPlayView videoPlayView7 = this.a.f36722f;
                if (videoPlayView7 == null) {
                    return;
                }
                videoPlayView7.F(this.a.C);
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void b(List<? extends VideoItemData> datas, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, datas, z) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                this.a.n = z;
                if (ListUtils.isEmpty(datas)) {
                    return;
                }
                c.a.p0.p4.c.d dVar = this.a.f36724h;
                if ((dVar == null ? null : Boolean.valueOf(dVar.v())).booleanValue()) {
                    return;
                }
                this.a.f36724h.b(datas);
                if (this.a.f36722f != null) {
                    c.a.p0.p4.c.d dVar2 = this.a.f36724h;
                    VideoPlayView videoPlayView = this.a.f36722f;
                    Intrinsics.checkNotNull(videoPlayView);
                    dVar2.a(videoPlayView.f36633h);
                }
                VideoPlayView videoPlayView2 = this.a.f36722f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.A();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f implements FrsVideoTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Ref.ObjectRef<List<VideoItemData>> a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f36726b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f36727c;

        public f(Ref.ObjectRef<List<VideoItemData>> objectRef, Ref.ObjectRef<String> objectRef2, VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectRef, objectRef2, videoVerticalPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = objectRef;
            this.f36726b = objectRef2;
            this.f36727c = videoVerticalPageFragment;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List, T] */
        @Override // com.baidu.tieba.videoplay.model.FrsVideoTabModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.element = FrsVideoTabPlayActivityConfig.getVideoTabListByFid(this.f36726b.element);
                if (this.a.element == null || this.f36727c.f36724h.v() || this.f36727c.f36722f == null) {
                    return;
                }
                this.f36727c.f36724h.z(this.a.element);
                VideoPlayView videoPlayView = this.f36727c.f36722f;
                Intrinsics.checkNotNull(videoPlayView);
                videoPlayView.A();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.f36724h.z(datas);
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && (((UbsABTestHelper.isVideoAdDrawABTestA() && c.a.p0.g1.b.j().o("6061002332-203360688")) || (UbsABTestHelper.isVideoAdDrawABTestB() && c.a.p0.g1.b.j().o("6061002410-390177882"))) && this.a.f36722f != null)) {
                    c.a.p0.p4.c.d dVar = this.a.f36724h;
                    VideoPlayView videoPlayView = this.a.f36722f;
                    Intrinsics.checkNotNull(videoPlayView);
                    dVar.a(videoPlayView.f36633h);
                }
                VideoPlayView videoPlayView2 = this.a.f36722f;
                if (videoPlayView2 != null) {
                    videoPlayView2.A();
                }
                VideoPlayView videoPlayView3 = this.a.f36722f;
                if (videoPlayView3 != null) {
                    videoPlayView3.P(0, true);
                }
                VideoPlayView videoPlayView4 = this.a.f36722f;
                if (videoPlayView4 != null) {
                    videoPlayView4.N(this.a.isPrimary());
                }
                c.a.p0.p4.h.a aVar = this.a.K;
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
                if (ListUtils.isEmpty(datas) || this.a.f36724h.v()) {
                    return;
                }
                this.a.f36724h.b(datas);
                if (this.a.f36722f != null) {
                    c.a.p0.p4.c.d dVar = this.a.f36724h;
                    VideoPlayView videoPlayView = this.a.f36722f;
                    Intrinsics.checkNotNull(videoPlayView);
                    dVar.a(videoPlayView.f36633h);
                }
                VideoPlayView videoPlayView2 = this.a.f36722f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.A();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                        if (this.a.f36720d == 3 || (TbSingleton.getInstance().isFromFeedVideoClick() && this.a.f36720d == 1)) {
                            if (booleanValue) {
                                this.a.z1(0);
                                return;
                            } else {
                                this.a.z1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
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

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    c.a.p0.p4.h.a aVar = this.a.K;
                    List<VideoItemModel> h2 = aVar == null ? null : aVar.h(str);
                    if (h2 != null) {
                        if (!h2.isEmpty()) {
                            this.a.f36724h.h().removeAll(h2);
                            VideoPlayView videoPlayView = this.a.f36722f;
                            if (videoPlayView == null) {
                                return;
                            }
                            videoPlayView.A();
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

    /* loaded from: classes6.dex */
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
                        if (this.a.f36724h.e(((Integer) data).intValue())) {
                            VideoPlayView videoPlayView = this.a.f36722f;
                            if (videoPlayView != null) {
                                videoPlayView.A();
                            }
                            VideoPlayView videoPlayView2 = this.a.f36722f;
                            if (videoPlayView2 != null) {
                                videoPlayView2.N(this.a.isPrimary());
                            }
                            VideoPlayView videoPlayView3 = this.a.f36722f;
                            if (videoPlayView3 == null) {
                                return;
                            }
                            videoPlayView3.F(this.a.C);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if ((resMsg instanceof NetWorkChangedMessage) && resMsg.getCmd() == 2000994 && !resMsg.hasError() && c.a.d.f.p.l.z() && this.a.f36724h.v()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921568));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(redIcon.thread_list.get(0));
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData(threadData);
                    VideoItemModel videoItemModel = new VideoItemModel(videoItemData, 1);
                    c.a.p0.p4.c.d dVar = this.a.f36724h;
                    VideoPlayView videoPlayView = this.a.f36722f;
                    if (dVar.u(videoItemModel, videoPlayView != null ? videoPlayView.f36633h : 0)) {
                        VideoPlayActivityStatic.a(redIcon);
                        TbSingleton.getInstance().setVideoChannelRecommendRedIcon(null);
                        VideoPlayView videoPlayView2 = this.a.f36722f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.A();
                        }
                        VideoPlayView videoPlayView3 = this.a.f36722f;
                        if (videoPlayView3 != null) {
                            videoPlayView3.N(this.a.isPrimary());
                        }
                        VideoPlayView videoPlayView4 = this.a.f36722f;
                        if (videoPlayView4 == null) {
                            return;
                        }
                        videoPlayView4.F(this.a.C);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type tbclient.VideoRedIcon.RedIcon");
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                            if (this.a.f36724h.f(optString)) {
                                VideoPlayView videoPlayView = this.a.f36722f;
                                if (videoPlayView != null) {
                                    videoPlayView.A();
                                }
                                VideoPlayView videoPlayView2 = this.a.f36722f;
                                if (videoPlayView2 != null) {
                                    videoPlayView2.N(this.a.isPrimary());
                                }
                                VideoPlayView videoPlayView3 = this.a.f36722f;
                                if (videoPlayView3 == null) {
                                    return;
                                }
                                videoPlayView3.F(this.a.C);
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

    /* loaded from: classes6.dex */
    public static final class n implements b.h {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        @Override // c.a.p0.g1.b.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && c.a.p0.g1.b.j().o("6061002332-203360688") && this.a.f36722f != null) {
                c.a.p0.p4.c.d dVar = this.a.f36724h;
                VideoPlayView videoPlayView = this.a.f36722f;
                Intrinsics.checkNotNull(videoPlayView);
                dVar.a(videoPlayView.f36633h);
                VideoPlayView videoPlayView2 = this.a.f36722f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.A();
            }
        }

        @Override // c.a.p0.g1.b.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class o implements b.h {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        @Override // c.a.p0.g1.b.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && c.a.p0.g1.b.j().o("6061002410-390177882") && this.a.f36722f != null) {
                c.a.p0.p4.c.d dVar = this.a.f36724h;
                VideoPlayView videoPlayView = this.a.f36722f;
                Intrinsics.checkNotNull(videoPlayView);
                dVar.a(videoPlayView.f36633h);
                VideoPlayView videoPlayView2 = this.a.f36722f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.A();
            }
        }

        @Override // c.a.p0.g1.b.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (!(!list.isEmpty()) || this.a.f36724h.v() || this.a.f36722f == null) {
                    return;
                }
                this.a.f36724h.b(list);
                VideoPlayView videoPlayView = this.a.f36722f;
                Intrinsics.checkNotNull(videoPlayView);
                videoPlayView.A();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_ROLLBACK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.a.f36720d != 3 && this.a.f36720d != 4) {
                    if (UbsABTestHelper.isAutoPlayNextVideo()) {
                        statisticItem.param("obj_type", 1);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    statisticItem.param("obj_locate", 2);
                } else {
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", this.a.S0(Integer.valueOf(i)));
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || VideoVerticalPageFragment.T0(this.a, null, 1, null) == 0) {
                return;
            }
            VideoVerticalPageFragment videoVerticalPageFragment = this.a;
            videoVerticalPageFragment.u = Long.valueOf(VideoVerticalPageFragment.T0(videoVerticalPageFragment, null, 1, null));
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

    public static final void C1(VideoVerticalPageFragment this$0) {
        VideoPlayModel videoPlayModel;
        FrsVideoTabModel frsVideoTabModel;
        VideoChannelModel videoChannelModel;
        VideoHotTopicModel videoHotTopicModel;
        VideoPersonalModel videoPersonalModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.n) {
                if (this$0.m1()) {
                    Long l2 = this$0.f36724h.l();
                    c.a.p0.p4.c.d dVar = this$0.f36724h;
                    VideoPlayView videoPlayView = this$0.f36722f;
                    Intrinsics.checkNotNull(videoPlayView);
                    UserItemData i2 = dVar.i(videoPlayView.f36633h);
                    if (l2 == null || i2 == null || (videoPersonalModel = this$0.y) == null) {
                        return;
                    }
                    videoPersonalModel.E(l2, i2);
                } else if (this$0.k1()) {
                    Long l3 = this$0.f36724h.l();
                    if (l3 == null || (videoHotTopicModel = this$0.z) == null) {
                        return;
                    }
                    videoHotTopicModel.D(l3);
                } else {
                    int i3 = this$0.f36720d;
                    if (i3 == 1 || i3 == 2) {
                        VideoPlayModel videoPlayModel2 = this$0.w;
                        if (videoPlayModel2 != null) {
                            videoPlayModel2.setFrom(this$0.m);
                        }
                        if (this$0.f36724h.x() || (videoPlayModel = this$0.w) == null) {
                            return;
                        }
                        videoPlayModel.K(this$0.f36724h.s(0));
                    } else if (i3 != 7 && i3 != 20) {
                        VideoChannelModel videoChannelModel2 = this$0.x;
                        if (videoChannelModel2 != null) {
                            videoChannelModel2.setFrom(this$0.m);
                        }
                        if (this$0.f36724h.x() || (videoChannelModel = this$0.x) == null) {
                            return;
                        }
                        videoChannelModel.loadMore();
                    } else if (this$0.f36724h.x() || (frsVideoTabModel = this$0.A) == null) {
                    } else {
                        frsVideoTabModel.loadMore();
                    }
                }
            }
        }
    }

    public static final void H1(VideoVerticalPageFragment this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.l1() && this$0.getPageContext() != null && this$0.getPageContext().getPageActivity() != null && !this$0.f1() && !this$0.X0() && !this$0.W0() && !this$0.h1() && !this$0.c1() && !this$0.Z0() && !this$0.i1() && !this$0.e1() && !this$0.d1() && !this$0.Y0() && !this$0.b1() && !this$0.a1()) {
                c.a.d.f.p.n.N(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c47));
            }
            if (this$0.j1()) {
                VideoPlayView videoPlayView = this$0.f36722f;
                boolean z = false;
                if (videoPlayView != null && videoPlayView.z()) {
                    z = true;
                }
                if (!z || this$0.getPageContext() == null || this$0.getPageContext().getPageActivity() == null || this$0.a1()) {
                    return;
                }
                c.a.d.f.p.n.N(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c49));
            }
        }
    }

    public static /* synthetic */ long T0(VideoVerticalPageFragment videoVerticalPageFragment, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        return videoVerticalPageFragment.S0(num);
    }

    public static final void V0(VideoVerticalPageFragment this$0, Void r5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, this$0, r5) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setInterceptStimeStat(true);
        }
    }

    public static final void s1(VideoVerticalPageFragment this$0, Unit unit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, this$0, unit) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.g1()) {
                this$0.q1(false, false, null);
            } else if (this$0.k1()) {
                this$0.r1();
            }
        }
    }

    public static final void t1(VideoVerticalPageFragment this$0, Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, this$0, pair) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (pair == null) {
                return;
            }
            Boolean bool = (Boolean) pair.first;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            this$0.q1(true, bool.booleanValue(), (String) pair.second);
        }
    }

    public static final boolean u1(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, view, motionEvent)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static final void w1(VideoVerticalPageFragment this$0, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, this$0, list) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(list, "list");
            if (!(!list.isEmpty()) || this$0.f36724h.v() || this$0.f36722f == null) {
                return;
            }
            this$0.f36724h.b(list);
            VideoPlayView videoPlayView = this$0.f36722f;
            Intrinsics.checkNotNull(videoPlayView);
            videoPlayView.A();
        }
    }

    public static final void y1(VideoVerticalPageFragment this$0, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{this$0, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!z || !this$0.l1() || this$0.getPageContext() == null || this$0.getPageContext().getPageActivity() == null || this$0.f1() || this$0.X0() || this$0.W0() || this$0.h1() || this$0.c1() || this$0.Z0() || this$0.i1() || this$0.e1() || this$0.d1() || this$0.Y0() || this$0.b1() || this$0.a1()) {
                return;
            }
            c.a.d.f.p.n.N(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c47));
        }
    }

    public final void A1(b.InterfaceC0807b interfaceC0807b) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, interfaceC0807b) == null) || (videoPlayView = this.f36722f) == null) {
            return;
        }
        videoPlayView.H(interfaceC0807b);
    }

    public final void B1() {
        VideoPlayView videoPlayView;
        VideoPlayView videoPlayView2;
        VideoPlayView videoPlayView3;
        VideoPlayView videoPlayView4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BdUniqueId bdUniqueId = this.a;
            Activity pageActivity = getPageContext().getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView5 = new VideoPlayView(bdUniqueId, (FragmentActivity) pageActivity, this, this.m, getUniqueId(), 1, this.f36720d, p1());
                this.f36722f = videoPlayView5;
                if (videoPlayView5 != null) {
                    videoPlayView5.G(new q(this));
                }
                if (this.f36720d == 3 && (videoPlayView4 = this.f36722f) != null) {
                    videoPlayView4.Q("from_suggest_sub_fragment");
                }
                VideoPlayView videoPlayView6 = this.f36722f;
                if (videoPlayView6 != null) {
                    BdSwipeRefreshLayout.k kVar = this.f36718b;
                    if (kVar == null) {
                        kVar = this.P;
                    }
                    videoPlayView6.O(kVar);
                }
                VideoPlayView videoPlayView7 = this.f36722f;
                if (videoPlayView7 != null) {
                    videoPlayView7.E(this.Q);
                }
                if (this.f36719c != 1 && (videoPlayView3 = this.f36722f) != null) {
                    videoPlayView3.H(this.I);
                }
                int i2 = this.f36720d;
                if ((i2 == 7 || i2 == 20) && (videoPlayView = this.f36722f) != null) {
                    videoPlayView.K(new r(this));
                }
                c.a.p0.p4.h.a aVar = this.K;
                if (aVar != null) {
                    aVar.o(this.f36722f);
                }
                VideoPlayView videoPlayView8 = this.f36722f;
                if (videoPlayView8 != null) {
                    videoPlayView8.L(new VideoPlayView.f() { // from class: c.a.p0.p4.g.j
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.videoplay.VideoPlayView.f
                        public final void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                VideoVerticalPageFragment.C1(VideoVerticalPageFragment.this);
                            }
                        }
                    });
                }
                VideoPlayView videoPlayView9 = this.f36722f;
                if (videoPlayView9 != null) {
                    videoPlayView9.T(this.f36724h, this.i, this.k);
                }
                VideoPlayView videoPlayView10 = this.f36722f;
                if (videoPlayView10 != null) {
                    videoPlayView10.M(this.l);
                }
                VideoPlayView videoPlayView11 = this.f36722f;
                if (videoPlayView11 != null) {
                    videoPlayView11.J(this.v);
                }
                VideoPlayView videoPlayView12 = this.f36722f;
                if (videoPlayView12 != null) {
                    videoPlayView12.R(this.f36719c);
                }
                if (l1() && (videoPlayView2 = this.f36722f) != null) {
                    videoPlayView2.P(this.j, false);
                }
                VideoPlayView videoPlayView13 = this.f36722f;
                if (videoPlayView13 == null) {
                    return;
                }
                videoPlayView13.I(this.K);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.p4.c.e.g(getActivity() instanceof VideoPlayActivity ? "1" : "3");
        }
    }

    public final void E1(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        UserItemData userItemData;
        UserItemData userItemData2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, videoItemData, list) == null) {
            VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list, 0);
            if (videoItemData == null || (userItemData = videoItemData.author_info) == null || videoItemData2 == null || (userItemData2 = videoItemData2.author_info) == null || (str = userItemData2.user_id) == null || !Intrinsics.areEqual(str, userItemData.user_id)) {
                return;
            }
            videoItemData2.author_info.is_follow = videoItemData.author_info.is_follow;
        }
    }

    public final void F1(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, videoItemData, list) == null) {
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

    public final void G1() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (relativeLayout = this.f36723g) == null) {
            return;
        }
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(8);
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.p0.p4.c.e.f("5");
        }
    }

    public final Long Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.t : (Long) invokeV.objValue;
    }

    public final Long R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.u : (Long) invokeV.objValue;
    }

    public final long S0(Integer num) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, num)) == null) {
            c.a.p0.p4.c.d dVar = this.f36724h;
            if (num == null) {
                VideoPlayView videoPlayView = this.f36722f;
                Intrinsics.checkNotNull(videoPlayView);
                intValue = videoPlayView.f36633h;
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

    @Override // c.a.p0.p4.g.n
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            VideoPlayView videoPlayView = this.f36722f;
            Intrinsics.checkNotNull(videoPlayView);
            int i2 = videoPlayView.i;
            VideoPlayView videoPlayView2 = this.f36722f;
            Intrinsics.checkNotNull(videoPlayView2);
            if (i2 != videoPlayView2.f36633h) {
                VideoPlayView videoPlayView3 = this.f36722f;
                Intrinsics.checkNotNull(videoPlayView3);
                if (videoPlayView3.f36633h >= 0) {
                    VideoPlayView videoPlayView4 = this.f36722f;
                    Intrinsics.checkNotNull(videoPlayView4);
                    if (videoPlayView4.f36633h < this.f36724h.k()) {
                        c.a.p0.p4.c.d dVar = this.f36724h;
                        VideoPlayView videoPlayView5 = this.f36722f;
                        Intrinsics.checkNotNull(videoPlayView5);
                        VideoItemData s = dVar.s(videoPlayView5.f36633h);
                        if (s == null || StringUtils.isNull(s.thread_id)) {
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, s.thread_id));
                    }
                }
            }
        }
    }

    public final b.InterfaceC0807b U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.I : (b.InterfaceC0807b) invokeV.objValue;
    }

    public final boolean W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36720d == 11 : invokeV.booleanValue;
    }

    @Override // c.a.p0.p4.g.n
    public long X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            VideoItemData s = this.f36724h.s(this.i);
            if (s == null || TextUtils.isEmpty(s.thread_id)) {
                return 0L;
            }
            return c.a.d.f.m.b.g(s.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    public final boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36720d == 10 : invokeV.booleanValue;
    }

    public final boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f36720d == 16 : invokeV.booleanValue;
    }

    public final boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f36720d == 18 : invokeV.booleanValue;
    }

    public final boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f36720d == 20 : invokeV.booleanValue;
    }

    public final boolean b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f36720d == 17 : invokeV.booleanValue;
    }

    public final boolean c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f36720d == 13 : invokeV.booleanValue;
    }

    public final boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f36720d == 15 : invokeV.booleanValue;
    }

    public final boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f36720d == 14 : invokeV.booleanValue;
    }

    public final boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f36720d == 9 : invokeV.booleanValue;
    }

    public final boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f36720d == 6 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.o0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f36720d == 3 ? "a088" : "a023" : (String) invokeV.objValue;
    }

    public final boolean h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f36720d == 12 : invokeV.booleanValue;
    }

    public final boolean i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f36720d == 19 : invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v115, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v116, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v107, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r3v109, types: [java.util.List<com.baidu.tieba.video.VideoItemData>, T] */
    public final void initData() {
        int i2;
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f36724h.c();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Bundle arguments = getArguments();
            objectRef.element = (ArrayList) (arguments == null ? null : arguments.getSerializable("video_list"));
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Bundle arguments2 = getArguments();
            objectRef2.element = arguments2 == null ? 0 : arguments2.getString("forum_id");
            if (objectRef.element == 0) {
                int i4 = this.f36720d;
                if (i4 != 7 && i4 != 20) {
                    List<VideoItemData> list = VideoPlayActivityConfig.bigDataList;
                    if (list != null) {
                        list.get(0).setChannelMidRequestVideoNum(this.D);
                        VideoPlayActivityConfig.bigDataList.get(0).setChannelMidRequestNum(this.D);
                    }
                    objectRef.element = VideoPlayActivityConfig.bigDataList;
                } else {
                    objectRef.element = FrsVideoTabPlayActivityConfig.getVideoTabListByFid((String) objectRef2.element);
                }
            }
            this.f36724h.z((List) objectRef.element);
            if (getArguments() != null) {
                Bundle arguments3 = getArguments();
                Intrinsics.checkNotNull(arguments3);
                i2 = arguments3.getInt("video_index", 0);
            } else {
                i2 = 0;
            }
            this.i = i2;
            if (getArguments() != null) {
                Bundle arguments4 = getArguments();
                Intrinsics.checkNotNull(arguments4);
                i3 = arguments4.getInt("video_show_index", 0);
            } else {
                i3 = 0;
            }
            this.j = i3;
            Bundle arguments5 = getArguments();
            if ((arguments5 == null ? null : (Rect) arguments5.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT)) != null) {
                Bundle arguments6 = getArguments();
                this.k = arguments6 == null ? null : (Rect) arguments6.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
            } else {
                Bundle arguments7 = getArguments();
                if ((arguments7 == null ? null : (Rect) arguments7.getParcelable("video_cover_rect")) != null) {
                    Bundle arguments8 = getArguments();
                    this.k = arguments8 == null ? null : (Rect) arguments8.getParcelable("video_cover_rect");
                } else {
                    Bundle arguments9 = getArguments();
                    this.k = arguments9 == null ? null : (Rect) arguments9.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
                }
            }
            Bundle arguments10 = getArguments();
            this.l = arguments10 == null ? null : arguments10.getString("page_from");
            Bundle arguments11 = getArguments();
            this.m = arguments11 == null ? null : arguments11.getString("from");
            Bundle arguments12 = getArguments();
            this.o = arguments12 == null ? null : arguments12.getString("st_type");
            Bundle arguments13 = getArguments();
            this.p = arguments13 == null ? null : arguments13.getString("yuelaou_locate");
            if (getArguments() != null) {
                Bundle arguments14 = getArguments();
                Intrinsics.checkNotNull(arguments14);
                z = arguments14.getBoolean("is_vertail", true);
            } else {
                z = false;
            }
            this.q = z;
            if (this.r == null) {
                this.r = VideoRecommentPlayActivityConfig.bigPersonalPageParams;
            }
            if (this.s == null) {
                this.s = VideoRecommentPlayActivityConfig.bigVideoHotTopicParams;
            }
            if (this.f36724h.v() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.f36724h.z(VideoPlayActivityConfig.bigDataList);
            }
            this.f36724h.C(getUniqueId());
            if (this.f36720d != 3 && (!TbSingleton.getInstance().isFromFeedVideoClick() || this.f36720d != 1)) {
                this.f36724h.D("a023");
            } else {
                z1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f36724h.D("a088");
            }
            int i5 = this.f36720d;
            if (i5 != 1 && i5 != 2) {
                if (l1()) {
                    if (this.j >= this.f36724h.k()) {
                        this.j = 0;
                    }
                    if (m1()) {
                        x1();
                    }
                    if (k1()) {
                        v1();
                    }
                } else if (!f1() && !X0() && !W0() && !h1() && !c1() && !Z0() && !i1() && !e1() && !d1() && !Y0() && !b1() && !a1()) {
                    int i6 = this.f36720d;
                    if (i6 != 7 && i6 != 20) {
                        VideoChannelModel videoChannelModel = new VideoChannelModel(getPageContext(), getUniqueId());
                        this.x = videoChannelModel;
                        if (videoChannelModel != null) {
                            videoChannelModel.setFrom(this.m);
                        }
                        VideoChannelModel videoChannelModel2 = this.x;
                        if (videoChannelModel2 != null) {
                            videoChannelModel2.H(this.f36719c);
                        }
                        VideoChannelModel videoChannelModel3 = this.x;
                        if (videoChannelModel3 != null) {
                            videoChannelModel3.I(new g(this));
                        }
                        if (this.f36724h.s(0) != null) {
                            VideoItemData s = this.f36724h.s(0);
                            this.v = s != null ? s.thread_id : null;
                        }
                        VideoChannelModel videoChannelModel4 = this.x;
                        if (videoChannelModel4 != null) {
                            videoChannelModel4.setFrom(this.m);
                        }
                        if (!c.a.d.f.p.l.z() && !isPrimary()) {
                            return;
                        }
                        if (n1()) {
                            VideoChannelModel videoChannelModel5 = this.x;
                            if (videoChannelModel5 != null) {
                                videoChannelModel5.loadMore();
                            }
                        } else {
                            VideoChannelModel videoChannelModel6 = this.x;
                            if (videoChannelModel6 != null) {
                                videoChannelModel6.G();
                            }
                        }
                    } else if (getPageContext() == null || getUniqueId() == null) {
                        return;
                    } else {
                        FrsVideoTabModel frsVideoTabModel = new FrsVideoTabModel(getPageContext(), getUniqueId());
                        this.A = frsVideoTabModel;
                        if (frsVideoTabModel != null) {
                            frsVideoTabModel.setFrom(this.m);
                        }
                        FrsVideoTabModel frsVideoTabModel2 = this.A;
                        if (frsVideoTabModel2 != null) {
                            frsVideoTabModel2.A(this.f36719c);
                        }
                        FrsVideoTabModel frsVideoTabModel3 = this.A;
                        if (frsVideoTabModel3 != null) {
                            frsVideoTabModel3.B(new f(objectRef, objectRef2, this));
                        }
                    }
                } else if (this.j >= this.f36724h.k()) {
                    this.j = 0;
                }
            } else {
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest()) {
                    if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                        c.a.p0.g1.b.j().s(getActivity(), new c(this), this.f36724h.o());
                    }
                    if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                        c.a.p0.g1.b.j().r(getActivity(), new d(this), this.f36724h.o());
                    }
                }
                VideoPlayModel videoPlayModel = new VideoPlayModel(getPageContext(), getUniqueId());
                this.w = videoPlayModel;
                if (videoPlayModel != null) {
                    videoPlayModel.setFrom(this.m);
                }
                VideoPlayModel videoPlayModel2 = this.w;
                if (videoPlayModel2 != null) {
                    videoPlayModel2.M(this.f36719c);
                }
                VideoPlayModel videoPlayModel3 = this.w;
                if (videoPlayModel3 != null) {
                    videoPlayModel3.N(new e(this));
                }
                if (this.f36724h.s(0) != null) {
                    VideoItemData s2 = this.f36724h.s(0);
                    this.v = s2 != null ? s2.thread_id : null;
                }
                VideoPlayModel videoPlayModel4 = this.w;
                if (videoPlayModel4 != null) {
                    videoPlayModel4.setFrom(this.m);
                }
                VideoPlayModel videoPlayModel5 = this.w;
                if (videoPlayModel5 != null) {
                    videoPlayModel5.L(this.f36724h.s(0), this.o, this.p, this.q);
                }
            }
            this.K = new c.a.p0.p4.h.a(this.f36724h.h(), getPageContext());
        }
    }

    public final boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f36720d == 7 : invokeV.booleanValue;
    }

    public final boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f36720d == 8 : invokeV.booleanValue;
    }

    @Override // c.a.p0.p4.g.n
    public void l0(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048606, this, i2, i3, intent) == null) || (videoPlayView = this.f36722f) == null) {
            return;
        }
        videoPlayView.u(i2, i3, intent);
    }

    public final boolean l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? o1() || m1() || k1() : invokeV.booleanValue;
    }

    public final boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? g1() && !p1() : invokeV.booleanValue;
    }

    public final boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? g1() && p1() : invokeV.booleanValue;
    }

    public final boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f36720d == 5 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.G = new OnActivityFinishListener<>(getPageContext(), new SimpleMessageListener.b() { // from class: c.a.p0.p4.g.i
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.util.SimpleMessageListener.b
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        VideoVerticalPageFragment.s1(VideoVerticalPageFragment.this, (Unit) obj);
                    }
                }
            });
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            this.H = new OnDeleteSelfPostListener(pageContext, new SimpleMessageListener.b() { // from class: c.a.p0.p4.g.k
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.util.SimpleMessageListener.b
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        VideoVerticalPageFragment.t1(VideoVerticalPageFragment.this, (Pair) obj);
                    }
                }
            });
            Lifecycle lifecycle = getLifecycle();
            OnDeleteSelfPostListener onDeleteSelfPostListener = this.H;
            Intrinsics.checkNotNull(onDeleteSelfPostListener);
            lifecycle.addObserver(onDeleteSelfPostListener);
            Lifecycle lifecycle2 = getLifecycle();
            OnActivityFinishListener<Unit> onActivityFinishListener = this.G;
            Intrinsics.checkNotNull(onActivityFinishListener);
            lifecycle2.addObserver(onActivityFinishListener);
            getLifecycle().addObserver(this.F);
            initData();
            B1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048612, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                l0(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            VideoPlayView videoPlayView = this.f36722f;
            if (videoPlayView != null) {
                videoPlayView.B(i2);
            }
            if (!UbsABTestHelper.isFeedVideoImmersionTransition() || (getActivity() instanceof VideoRecommentPlayActivity)) {
                SkinManager.setBackgroundColor(this.f36721e, R.color.CAM_X0611);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048614, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            registerListener(this.M);
            registerListener(this.L);
            registerListener(this.O);
            registerListener(this.J);
            registerListener(this.N);
            registerListener(this.S);
            registerListener(this.R);
            this.f36721e = inflater.inflate(R.layout.obfuscated_res_0x7f0d0891, viewGroup, false);
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !(getActivity() instanceof VideoRecommentPlayActivity) && (view = this.f36721e) != null) {
                view.setBackgroundColor(0);
            }
            View view2 = this.f36721e;
            RelativeLayout relativeLayout = view2 == null ? null : (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0924c2);
            this.f36723g = relativeLayout;
            if (relativeLayout != null) {
                relativeLayout.setOnTouchListener(c.a.p0.p4.g.d.a);
            }
            return this.f36721e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onDestroy();
            if (this.H != null) {
                Lifecycle lifecycle = getLifecycle();
                OnDeleteSelfPostListener onDeleteSelfPostListener = this.H;
                Intrinsics.checkNotNull(onDeleteSelfPostListener);
                lifecycle.removeObserver(onDeleteSelfPostListener);
            }
            if (this.G != null) {
                Lifecycle lifecycle2 = getLifecycle();
                OnActivityFinishListener<Unit> onActivityFinishListener = this.G;
                Intrinsics.checkNotNull(onActivityFinishListener);
                lifecycle2.removeObserver(onActivityFinishListener);
            }
            getLifecycle().removeObserver(this.F);
            VideoPlayView videoPlayView = this.f36722f;
            if (videoPlayView != null) {
                videoPlayView.C();
            }
            if (isPrimary()) {
                D1();
            }
            if (getActivity() instanceof FrsVideoTabPlayActivity) {
                P0();
            }
            VideoPersonalModel videoPersonalModel = this.y;
            if (videoPersonalModel == null) {
                return;
            }
            videoPersonalModel.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onDestroyView();
            c.a.p0.g1.b.j().d("6061002332-203360688");
            c.a.p0.g1.b.j().c("6061002410-390177882");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f36722f;
            if (videoPlayView == null) {
                return;
            }
            videoPlayView.D();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onPrimary();
            if (!this.C) {
                D1();
            }
            if (getActivity() instanceof FrsVideoTabPlayActivity) {
                P0();
            }
            if (this.C && this.f36720d == 3) {
                c.a.p0.p4.b.c(1);
            }
            if (isPrimary()) {
                c.a.o0.i0.g.c.b().c();
                c.a.o0.i0.g.c.b().l(true);
            }
            this.t = Long.valueOf(X());
            VideoPlayView videoPlayView = this.f36722f;
            if (videoPlayView != null) {
                videoPlayView.N(isPrimary());
            }
            if (!this.B && isPrimary() && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.f36720d == 3) {
                this.B = true;
                if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                    c.a.p0.g1.b.j().s(getActivity(), new n(this), this.f36724h.o());
                } else if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                    c.a.p0.g1.b.j().r(getActivity(), new o(this), this.f36724h.o());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onResume();
            if (this.E && this.C && isPrimary()) {
                setUserVisibleHint(true);
                this.E = false;
            }
            if (TbSingleton.getInstance().isVideoChannelRelogin() && isPrimary()) {
                TbSingleton.getInstance().setVideoChannelRelogin(false);
                VideoPlayView videoPlayView = this.f36722f;
                if (videoPlayView == null) {
                    return;
                }
                videoPlayView.F(this.C);
            }
        }
    }

    public final boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = this.r;
            if (personalPageParams == null) {
                return false;
            }
            return personalPageParams.isShareThread();
        }
        return invokeV.booleanValue;
    }

    public final void q1(boolean z, boolean z2, String str) {
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        VideoPersonalModel videoPersonalModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) || (personalPageParams = this.r) == null || (videoPersonalModel = this.y) == null) {
            return;
        }
        c.a.p0.p4.c.d dVar = this.f36724h;
        VideoPlayView videoPlayView = this.f36722f;
        Intrinsics.checkNotNull(videoPlayView);
        String r2 = dVar.r(videoPlayView.f36633h);
        if (r2 == null) {
            return;
        }
        VideoNotifyPersonalPageData videoNotifyPersonalPageData = new VideoNotifyPersonalPageData();
        videoNotifyPersonalPageData.setPersonalPageUid(personalPageParams.getPersonalPageUid());
        videoNotifyPersonalPageData.setCurrentThreadId(r2);
        videoNotifyPersonalPageData.setFlutterPageId(personalPageParams.getFlutterPageId());
        videoNotifyPersonalPageData.setUserPostDataResMapList(videoPersonalModel.D());
        videoNotifyPersonalPageData.setCurrentPn(personalPageParams.getCurrentPn());
        videoNotifyPersonalPageData.setIsDeleteOperate(z);
        videoNotifyPersonalPageData.setDeleteStatus(z2);
        videoNotifyPersonalPageData.setDeleteStatusMessage(str);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921623, videoNotifyPersonalPageData));
    }

    public final void r1() {
        VideoHotTopicParams videoHotTopicParams;
        VideoHotTopicModel videoHotTopicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (videoHotTopicParams = this.s) == null || (videoHotTopicModel = this.z) == null) {
            return;
        }
        c.a.p0.p4.c.d dVar = this.f36724h;
        VideoPlayView videoPlayView = this.f36722f;
        Intrinsics.checkNotNull(videoPlayView);
        String r2 = dVar.r(videoPlayView.f36633h);
        if (r2 == null) {
            return;
        }
        VideoNotifyPersonalPageData videoNotifyPersonalPageData = new VideoNotifyPersonalPageData();
        videoNotifyPersonalPageData.setCurrentThreadId(r2);
        videoNotifyPersonalPageData.setFlutterPageId(videoHotTopicParams.getFlutterPageId());
        videoNotifyPersonalPageData.setVideoHotTopicDataResMapList(videoHotTopicModel.C());
        videoNotifyPersonalPageData.setCurrentPn(videoHotTopicParams.getCurrentPn());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921623, videoNotifyPersonalPageData));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z && this.f36720d == 6) {
                G1();
            }
            VideoPlayView videoPlayView = this.f36722f;
            if (videoPlayView != null) {
                videoPlayView.F(z);
            }
            this.C = z;
        }
    }

    @Override // c.a.p0.p4.g.n
    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            VideoPlayView videoPlayView = this.f36722f;
            return videoPlayView != null && videoPlayView.v();
        }
        return invokeV.booleanValue;
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || getPageContext() == null || getUniqueId() == null || this.s == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        VideoHotTopicParams videoHotTopicParams = this.s;
        Intrinsics.checkNotNull(videoHotTopicParams);
        VideoHotTopicModel videoHotTopicModel = new VideoHotTopicModel(pageContext, videoHotTopicParams);
        this.z = videoHotTopicModel;
        if (videoHotTopicModel == null) {
            return;
        }
        videoHotTopicModel.E(new VideoHotTopicModel.b() { // from class: c.a.p0.p4.g.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.videoplay.model.VideoHotTopicModel.b
            public final void a(List list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                    VideoVerticalPageFragment.w1(VideoVerticalPageFragment.this, list);
                }
            }
        });
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || getPageContext() == null || getUniqueId() == null || this.r == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = this.r;
        Intrinsics.checkNotNull(personalPageParams);
        VideoPersonalModel videoPersonalModel = new VideoPersonalModel(pageContext, personalPageParams);
        this.y = videoPersonalModel;
        if (videoPersonalModel == null) {
            return;
        }
        videoPersonalModel.F(new p(this));
    }

    public final void z1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048627, this, i2) == null) || (view = this.f36721e) == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        int paddingLeft = view.getPaddingLeft();
        View view2 = this.f36721e;
        Intrinsics.checkNotNull(view2);
        int paddingTop = view2.getPaddingTop();
        View view3 = this.f36721e;
        Intrinsics.checkNotNull(view3);
        view.setPadding(paddingLeft, paddingTop, view3.getPaddingRight(), i2);
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
        this.a = bdUniqueId;
        this.f36718b = kVar;
        this.f36719c = i2;
        this.f36720d = i3;
        this.f36724h = new c.a.p0.p4.c.d();
        this.n = true;
        this.D = 1;
        this.E = c.a.o0.a.d.y().E();
        this.F = new VideoPlayFragment.GoPbCommentFloatListener(new SimpleMessageListener.b() { // from class: c.a.p0.p4.g.c
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tbadk.util.SimpleMessageListener.b
            public final void call(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    VideoVerticalPageFragment.V0(VideoVerticalPageFragment.this, (Void) obj);
                }
            }
        });
        this.I = new b(this);
        this.J = new l(this);
        this.L = new j(this);
        this.M = new m(this);
        this.N = new i(this);
        this.O = new k(this);
        this.P = new BdSwipeRefreshLayout.k() { // from class: c.a.p0.p4.g.f
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
            public final void a(int i6, int i7, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z)}) == null) {
                    VideoVerticalPageFragment.y1(VideoVerticalPageFragment.this, i6, i7, z);
                }
            }
        };
        this.Q = new VideoPlayView.h() { // from class: c.a.p0.p4.g.l
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.videoplay.VideoPlayView.h
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    VideoVerticalPageFragment.H1(VideoVerticalPageFragment.this);
                }
            }
        };
        this.R = new h(this);
        this.S = new a(this);
    }
}
