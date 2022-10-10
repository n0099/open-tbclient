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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.module.hottopic.VideoHotTopicParams;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.OnActivityFinishListener;
import com.baidu.tbadk.util.SimpleMessageListener;
import com.baidu.tieba.R;
import com.baidu.tieba.dh;
import com.baidu.tieba.ej;
import com.baidu.tieba.ey8;
import com.baidu.tieba.fa5;
import com.baidu.tieba.n9;
import com.baidu.tieba.nx8;
import com.baidu.tieba.oy8;
import com.baidu.tieba.py8;
import com.baidu.tieba.qm5;
import com.baidu.tieba.qp8;
import com.baidu.tieba.rl4;
import com.baidu.tieba.rx8;
import com.baidu.tieba.sx8;
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
import com.baidu.tieba.videoplay.model.JumpYYLiveHttpResponseMessage;
import com.baidu.tieba.videoplay.model.VideoChannelModel;
import com.baidu.tieba.videoplay.model.VideoHotTopicModel;
import com.baidu.tieba.videoplay.model.VideoPersonalModel;
import com.baidu.tieba.wu6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.ThreadInfo;
import tbclient.VideoRedIcon.RedIcon;
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0002£\u0001B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010W\u001a\u00020?H\u0002J\b\u0010X\u001a\u00020\u0012H\u0016J\r\u0010Y\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010ZJ\r\u0010[\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010ZJ\b\u0010\\\u001a\u00020\u0014H\u0016J\u0017\u0010]\u001a\u00020\u00142\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010_J\b\u0010`\u001a\u0004\u0018\u00010\u0010J\"\u0010a\u001a\u00020?2\u0006\u0010b\u001a\u00020\b2\u0006\u0010c\u001a\u00020\b2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\b\u0010f\u001a\u00020\u0019H\u0016J\b\u0010g\u001a\u00020?H\u0016J\b\u0010h\u001a\u00020?H\u0002J\b\u0010i\u001a\u00020\u0019H\u0002J\b\u0010j\u001a\u00020\u0019H\u0002J\b\u0010k\u001a\u00020\u0019H\u0002J\b\u0010l\u001a\u00020\u0019H\u0002J\b\u0010m\u001a\u00020\u0019H\u0002J\b\u0010n\u001a\u00020\u0019H\u0002J\b\u0010o\u001a\u00020\u0019H\u0002J\b\u0010p\u001a\u00020\u0019H\u0002J\b\u0010q\u001a\u00020\u0019H\u0002J\b\u0010r\u001a\u00020\u0019H\u0002J\b\u0010s\u001a\u00020\u0019H\u0002J\b\u0010t\u001a\u00020\u0019H\u0002J\b\u0010u\u001a\u00020\u0019H\u0002J\b\u0010v\u001a\u00020\u0019H\u0002J\b\u0010w\u001a\u00020\u0019H\u0002J\b\u0010x\u001a\u00020\u0019H\u0002J\b\u0010y\u001a\u00020\u0019H\u0002J\b\u0010z\u001a\u00020\u0019H\u0002J\b\u0010{\u001a\u00020\u0019H\u0002J\b\u0010|\u001a\u00020\u0019H\u0002J#\u0010}\u001a\u00020?2\u0006\u0010~\u001a\u00020\u00192\u0006\u0010\u007f\u001a\u00020\u00192\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0012H\u0002J\t\u0010\u0081\u0001\u001a\u00020?H\u0002J\u0015\u0010\u0082\u0001\u001a\u00020?2\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J#\u0010\u0085\u0001\u001a\u00020?2\u0006\u0010b\u001a\u00020\b2\u0006\u0010c\u001a\u00020\b2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0012\u0010\u0086\u0001\u001a\u00020?2\u0007\u0010\u0087\u0001\u001a\u00020\bH\u0016J-\u0010\u0088\u0001\u001a\u0004\u0018\u0001012\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J\t\u0010\u008d\u0001\u001a\u00020?H\u0016J\t\u0010\u008e\u0001\u001a\u00020?H\u0016J\t\u0010\u008f\u0001\u001a\u00020?H\u0016J\t\u0010\u0090\u0001\u001a\u00020?H\u0016J\t\u0010\u0091\u0001\u001a\u00020?H\u0016J\t\u0010\u0092\u0001\u001a\u00020?H\u0002J\t\u0010\u0093\u0001\u001a\u00020?H\u0002J\t\u0010\u0094\u0001\u001a\u00020?H\u0002J\u0012\u0010\u0095\u0001\u001a\u00020?2\u0007\u0010\u0096\u0001\u001a\u00020\bH\u0002J\u0011\u0010\u0097\u0001\u001a\u00020?2\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020?2\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0010J\t\u0010\u009a\u0001\u001a\u00020?H\u0002J\t\u0010\u009b\u0001\u001a\u00020?H\u0002J$\u0010\u009c\u0001\u001a\u00020?2\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u00030\u009e\u00010 \u0001H\u0002J&\u0010¡\u0001\u001a\u00020?2\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u00012\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u00030\u009e\u00010 \u0001H\u0002J\t\u0010¢\u0001\u001a\u00020?H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010=\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010?\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¤\u0001"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/videoplay/fragment/IVideoPlayActicityFragment;", "mActivityPageUniqueId", "Lcom/baidu/adp/BdUniqueId;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "mainPageType", "", "mCurrentType", "(Lcom/baidu/adp/BdUniqueId;Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;II)V", "backGroundListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "eventListener", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "fid", "", "firstVideoTid", "", "Ljava/lang/Long;", "goPbCommentFloatListener", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "isSchemeUp", "", "isVertail", "isVisibleToUser", "keyboardShowHideListener", "lastVideoTid", "mAdCloseListener", "mFeedBackListener", "mFrom", "mFromPage", "mFrsVideoTabModel", "Lcom/baidu/tieba/videoplay/model/FrsVideoTabModel;", "mHasMore", "mLocate", "mMidChannelNum", "mNAdDispatcher", "Lcom/baidu/tieba/videoplay/nad/AdVideoFlowDispatcher;", "mNetworkChangedMessageListener", "mObjId", "mPollingModel", "Lcom/baidu/tbadk/core/leveiconlivepolling/PollingModel;", "mRecommendTabInsertDataListener", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "mUEGFeedBackListener", "mVideoChannelModel", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoIndex", "mVideoPlayModel", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoShowIndex", "mVideoTabReqFunAd", "onActivityFinishListener", "Lcom/baidu/tbadk/util/OnActivityFinishListener;", "", "onDeleteSelfPostListener", "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "personalPageParams", "Lcom/baidu/tbadk/core/atomData/VideoRecommentPlayActivityConfig$PersonalPageParams;", "progressViewCallbackFra", "getProgressViewCallbackFra", "()Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "setProgressViewCallbackFra", "(Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;)V", "videoHotTopicModel", "Lcom/baidu/tieba/videoplay/model/VideoHotTopicModel;", "videoHotTopicParams", "Lcom/baidu/tbadk/module/hottopic/VideoHotTopicParams;", "videoPersonalModel", "Lcom/baidu/tieba/videoplay/model/VideoPersonalModel;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "getViewPagerBottomScrollMoreCallback", "()Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "setViewPagerBottomScrollMoreCallback", "(Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;)V", "youngsterVerticalLayout", "Landroid/widget/RelativeLayout;", "frsStepStat", "getCurrentPageKey", "getFirstVideoTid", "()Ljava/lang/Long;", "getLastVideoTid", "getMissionTid", "getShowVideoTid", "index", "(Ljava/lang/Integer;)J", "getVEventListener", "handleActivityResult", GroupInfoActivityConfig.REQUEST_CODE, "resultCode", "data", "Landroid/content/Intent;", "handleBackPress", "handleIndexMessage", "initData", "isFromAgreePage", "isFromAtPage", "isFromCollection", "isFromCreateCenterPage", "isFromFrsTop", "isFromHistory", "isFromLink", "isFromMyThread", "isFromOfficalVideo", "isFromPbVideoSchema", "isFromPersonalPage", "isFromReplyPage", "isFromWorkManagement", "isFrsVideoTab", "isHotTopicPlay", "isNoTabPlay", "isPersonalPlay", "isPersonalSharePlay", "isRecommendPlay", "isShareThread", "notifyPersonalPage", "isDelete", "isDeleteSucceed", "deleteErrorMessage", "notifyVideoHotTopicPage", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "processVideoHotTopicModel", "processVideoPersonalModel", "registerJumpYYLiveHttpTask", "setEmptyHeight", "height", "setUserVisibleHint", "setVideoPlayViewEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showData", "stepStat", "syncFirstVideoFollowState", "originalData", "Lcom/baidu/tieba/video/VideoItemData;", "newList", "", "syncFirstVideoThreadData", "updateYoungsterMode", "OnDeleteSelfPostListener", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class VideoVerticalPageFragment extends BaseFragment implements oy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoHotTopicModel A;
    public FrsVideoTabModel B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public final VideoPlayFragment.GoPbCommentFloatListener G;
    public OnActivityFinishListener<Unit> H;
    public OnDeleteSelfPostListener I;
    public String J;
    public qm5.b K;
    public final CustomMessageListener L;
    public py8 M;
    public final CustomMessageListener N;
    public final CustomMessageListener O;
    public final CustomMessageListener P;
    public final CustomMessageListener Q;
    public BdSwipeRefreshLayout.k R;
    public VideoPlayView.k S;
    public final CustomMessageListener T;
    public final CustomMessageListener U;
    public final BdUniqueId a;
    public final BdSwipeRefreshLayout.k b;
    public final int c;
    public final int d;
    public View e;
    public VideoPlayView f;
    public RelativeLayout g;
    public final rx8 h;
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
    public PollingModel w;
    public VideoPlayModel x;
    public VideoChannelModel y;
    public VideoPersonalModel z;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB-\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "Lcom/baidu/tbadk/util/SimpleMessageListener;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tbadk/util/SimpleMessageListener$Callback;", "Landroidx/core/util/Pair;", "", "", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tbadk/util/SimpleMessageListener$Callback;)V", "Companion", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class OnDeleteSelfPostListener extends SimpleMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public static final a c;
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
                    SimpleMessageListener.i(2001460, pageContext, data);
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
            c = new a(null);
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
            h(pageContext);
        }

        @JvmStatic
        public static final void k(TbPageContext<?> tbPageContext, Pair<Boolean, String> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, tbPageContext, pair) == null) {
                c.a(tbPageContext, pair);
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
                            if (n9.g().b() instanceof qp8) {
                                Activity b = n9.g().b();
                                if (b != null) {
                                    if (((qp8) b).getCurrentTabType() == 22) {
                                        z = true;
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.tblauncher.IMaintabType");
                                }
                            }
                            if ((this.a.D && z) || ((n9.g().b() instanceof VideoPlayActivity) && (this.a.getActivity() instanceof VideoPlayActivity))) {
                                this.a.v2();
                            }
                            if (!z && (n9.g().b() instanceof FrsVideoTabPlayActivity) && (this.a.getActivity() instanceof FrsVideoTabPlayActivity)) {
                                this.a.G1();
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements qm5.b {
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

        @Override // com.baidu.tieba.qm5.b
        public void j0(float f, float f2) {
            VideoPlayView videoPlayView;
            qm5.b E;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || (videoPlayView = this.a.f) == null || (E = videoPlayView.E()) == null) {
                return;
            }
            E.j0(f, f2);
        }

        @Override // com.baidu.tieba.qm5.b
        public void onViewClick() {
            VideoPlayView videoPlayView;
            qm5.b E;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (videoPlayView = this.a.f) == null || (E = videoPlayView.E()) == null) {
                return;
            }
            E.onViewClick();
        }

        @Override // com.baidu.tieba.qm5.b
        public void onViewDragToRight() {
            VideoPlayView videoPlayView;
            qm5.b E;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (videoPlayView = this.a.f) == null || (E = videoPlayView.E()) == null) {
                return;
            }
            E.onViewDragToRight();
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements wu6.h {
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

        @Override // com.baidu.tieba.wu6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && wu6.m().v("6061002332-203360688") && this.a.f != null) {
                rx8 rx8Var = this.a.h;
                VideoPlayView videoPlayView = this.a.f;
                Intrinsics.checkNotNull(videoPlayView);
                rx8Var.a(videoPlayView.n);
                VideoPlayView videoPlayView2 = this.a.f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.S();
            }
        }

        @Override // com.baidu.tieba.wu6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements wu6.h {
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

        @Override // com.baidu.tieba.wu6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && wu6.m().v(wu6.s()) && this.a.f != null) {
                rx8 rx8Var = this.a.h;
                VideoPlayView videoPlayView = this.a.f;
                Intrinsics.checkNotNull(videoPlayView);
                rx8Var.a(videoPlayView.n);
                VideoPlayView videoPlayView2 = this.a.f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.S();
            }
        }

        @Override // com.baidu.tieba.wu6.h
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

        /* JADX DEBUG: Multi-variable search result rejected for r6v27, resolved type: com.baidu.tieba.rx8 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void a(List<? extends VideoItemData> datas, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, datas, z) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                this.a.n = z;
                if (ListUtils.isEmpty(datas) || this.a.h.v()) {
                    return;
                }
                VideoVerticalPageFragment videoVerticalPageFragment = this.a;
                VideoItemData s = videoVerticalPageFragment.h.s(0);
                Intrinsics.checkNotNull(s);
                Intrinsics.checkNotNullExpressionValue(s, "dataController.getVideoData(0)!!");
                videoVerticalPageFragment.w2(s, datas);
                VideoVerticalPageFragment videoVerticalPageFragment2 = this.a;
                videoVerticalPageFragment2.x2(videoVerticalPageFragment2.h.s(0), datas);
                if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_H5_SEARCH, this.a.m)) {
                    this.a.h.b(datas.subList(1, datas.size()));
                } else {
                    this.a.h.z(datas);
                }
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && UbsABTestHelper.isVideoAdDrawABTestA() && wu6.m().v("6061002332-203360688") && this.a.f != null) {
                    rx8 rx8Var = this.a.h;
                    VideoPlayView videoPlayView = this.a.f;
                    Intrinsics.checkNotNull(videoPlayView);
                    rx8Var.a(videoPlayView.n - 1);
                }
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && UbsABTestHelper.isVideoAdDrawABTestB() && wu6.m().v(wu6.s()) && this.a.f != null) {
                    rx8 rx8Var2 = this.a.h;
                    VideoPlayView videoPlayView2 = this.a.f;
                    Intrinsics.checkNotNull(videoPlayView2);
                    rx8Var2.a(videoPlayView2.n - 1);
                }
                VideoPlayView videoPlayView3 = this.a.f;
                if (videoPlayView3 != null) {
                    videoPlayView3.S();
                }
                VideoPlayView videoPlayView4 = this.a.f;
                if (videoPlayView4 != null) {
                    videoPlayView4.K();
                }
                VideoPlayView videoPlayView5 = this.a.f;
                if (videoPlayView5 != null) {
                    videoPlayView5.j0(0, true);
                }
                VideoPlayView videoPlayView6 = this.a.f;
                if (videoPlayView6 != null) {
                    videoPlayView6.h0(this.a.isPrimary());
                }
                VideoPlayView videoPlayView7 = this.a.f;
                if (videoPlayView7 == null) {
                    return;
                }
                videoPlayView7.Y(this.a.D);
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
                rx8 rx8Var = this.a.h;
                if ((rx8Var == null ? null : Boolean.valueOf(rx8Var.v())).booleanValue()) {
                    return;
                }
                this.a.h.b(datas);
                if (this.a.f != null) {
                    rx8 rx8Var2 = this.a.h;
                    VideoPlayView videoPlayView = this.a.f;
                    Intrinsics.checkNotNull(videoPlayView);
                    rx8Var2.a(videoPlayView.n);
                }
                VideoPlayView videoPlayView2 = this.a.f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.S();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f implements FrsVideoTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Ref.ObjectRef<List<VideoItemData>> a;
        public final /* synthetic */ VideoVerticalPageFragment b;

        public f(Ref.ObjectRef<List<VideoItemData>> objectRef, VideoVerticalPageFragment videoVerticalPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectRef, videoVerticalPageFragment};
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
            this.b = videoVerticalPageFragment;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List, T] */
        @Override // com.baidu.tieba.videoplay.model.FrsVideoTabModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.element = FrsVideoTabPlayActivityConfig.getVideoTabListByFid(this.b.J);
                if (this.a.element == null || this.b.h.v() || this.b.f == null) {
                    return;
                }
                this.b.h.z(this.a.element);
                VideoPlayView videoPlayView = this.b.f;
                Intrinsics.checkNotNull(videoPlayView);
                videoPlayView.S();
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
                this.a.h.z(datas);
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && (((UbsABTestHelper.isVideoAdDrawABTestA() && wu6.m().v("6061002332-203360688")) || (UbsABTestHelper.isVideoAdDrawABTestB() && wu6.m().v(wu6.s()))) && this.a.f != null)) {
                    rx8 rx8Var = this.a.h;
                    VideoPlayView videoPlayView = this.a.f;
                    Intrinsics.checkNotNull(videoPlayView);
                    rx8Var.a(videoPlayView.n);
                }
                VideoPlayView videoPlayView2 = this.a.f;
                if (videoPlayView2 != null) {
                    videoPlayView2.S();
                }
                VideoPlayView videoPlayView3 = this.a.f;
                if (videoPlayView3 != null) {
                    videoPlayView3.j0(0, true);
                }
                VideoPlayView videoPlayView4 = this.a.f;
                if (videoPlayView4 != null) {
                    videoPlayView4.h0(this.a.isPrimary());
                }
                py8 py8Var = this.a.M;
                if (py8Var == null) {
                    return;
                }
                py8Var.i();
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void b(List<? extends VideoItemData> datas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, datas) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                if (ListUtils.isEmpty(datas) || this.a.h.v()) {
                    return;
                }
                this.a.h.b(datas);
                if (this.a.f != null) {
                    rx8 rx8Var = this.a.h;
                    VideoPlayView videoPlayView = this.a.f;
                    Intrinsics.checkNotNull(videoPlayView);
                    rx8Var.a(videoPlayView.n);
                }
                VideoPlayView videoPlayView2 = this.a.f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.S();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class h implements PollingModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        public h(VideoVerticalPageFragment videoVerticalPageFragment) {
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

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.b
        public void onSuccess(List<AlaLiveInfo> liveSecondFloor) {
            VideoPlayView videoPlayView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveSecondFloor) == null) {
                Intrinsics.checkNotNullParameter(liveSecondFloor, "liveSecondFloor");
                if (this.a.d != 1 || this.a.f == null) {
                    return;
                }
                VideoPlayView videoPlayView2 = this.a.f;
                Intrinsics.checkNotNull(videoPlayView2);
                if (!videoPlayView2.Q(liveSecondFloor) || (videoPlayView = this.a.f) == null) {
                    return;
                }
                videoPlayView.q0(this.a.a, liveSecondFloor, "video_recommend");
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
                        if (this.a.d == 3) {
                            if (booleanValue) {
                                this.a.r2(0);
                                return;
                            } else {
                                this.a.r2(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
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
    public static final class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(VideoVerticalPageFragment videoVerticalPageFragment) {
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
                    py8 py8Var = this.a.M;
                    List<VideoItemModel> h = py8Var == null ? null : py8Var.h(str);
                    if (h != null) {
                        if (!h.isEmpty()) {
                            this.a.h.h().removeAll(h);
                            VideoPlayView videoPlayView = this.a.f;
                            if (videoPlayView == null) {
                                return;
                            }
                            videoPlayView.S();
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
    public static final class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(VideoVerticalPageFragment videoVerticalPageFragment) {
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
                        if (this.a.h.e(((Integer) data).intValue())) {
                            VideoPlayView videoPlayView = this.a.f;
                            if (videoPlayView != null) {
                                videoPlayView.S();
                            }
                            VideoPlayView videoPlayView2 = this.a.f;
                            if (videoPlayView2 != null) {
                                videoPlayView2.h0(this.a.isPrimary());
                            }
                            VideoPlayView videoPlayView3 = this.a.f;
                            if (videoPlayView3 == null) {
                                return;
                            }
                            videoPlayView3.Y(this.a.D);
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
    public static final class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(VideoVerticalPageFragment videoVerticalPageFragment) {
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
                if ((resMsg instanceof NetWorkChangedMessage) && resMsg.getCmd() == 2000994 && !resMsg.hasError() && BdNetTypeUtil.isNetWorkAvailable() && this.a.h.v()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921568));
                }
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
                    rx8 rx8Var = this.a.h;
                    VideoPlayView videoPlayView = this.a.f;
                    if (rx8Var.u(videoItemModel, videoPlayView != null ? videoPlayView.n : 0)) {
                        VideoPlayActivityStatic.a(redIcon);
                        TbSingleton.getInstance().setVideoChannelRecommendRedIcon(null);
                        VideoPlayView videoPlayView2 = this.a.f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.S();
                        }
                        VideoPlayView videoPlayView3 = this.a.f;
                        if (videoPlayView3 != null) {
                            videoPlayView3.h0(this.a.isPrimary());
                        }
                        VideoPlayView videoPlayView4 = this.a.f;
                        if (videoPlayView4 == null) {
                            return;
                        }
                        videoPlayView4.Y(this.a.D);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type tbclient.VideoRedIcon.RedIcon");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(VideoVerticalPageFragment videoVerticalPageFragment) {
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
                            if (this.a.h.f(optString)) {
                                VideoPlayView videoPlayView = this.a.f;
                                if (videoPlayView != null) {
                                    videoPlayView.S();
                                }
                                VideoPlayView videoPlayView2 = this.a.f;
                                if (videoPlayView2 != null) {
                                    videoPlayView2.h0(this.a.isPrimary());
                                }
                                VideoPlayView videoPlayView3 = this.a.f;
                                if (videoPlayView3 == null) {
                                    return;
                                }
                                videoPlayView3.Y(this.a.D);
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
    public static final class o implements wu6.h {
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

        @Override // com.baidu.tieba.wu6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && wu6.m().v("6061002332-203360688") && this.a.f != null) {
                rx8 rx8Var = this.a.h;
                VideoPlayView videoPlayView = this.a.f;
                Intrinsics.checkNotNull(videoPlayView);
                rx8Var.a(videoPlayView.n);
                VideoPlayView videoPlayView2 = this.a.f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.S();
            }
        }

        @Override // com.baidu.tieba.wu6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class p implements wu6.h {
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

        @Override // com.baidu.tieba.wu6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && wu6.m().v(wu6.s()) && this.a.f != null) {
                rx8 rx8Var = this.a.h;
                VideoPlayView videoPlayView = this.a.f;
                Intrinsics.checkNotNull(videoPlayView);
                rx8Var.a(videoPlayView.n);
                VideoPlayView videoPlayView2 = this.a.f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.S();
            }
        }

        @Override // com.baidu.tieba.wu6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class q implements VideoPersonalModel.b {
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

        @Override // com.baidu.tieba.videoplay.model.VideoPersonalModel.b
        public void a(List<VideoItemData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "list");
                if (!(!list.isEmpty()) || this.a.h.v() || this.a.f == null) {
                    return;
                }
                this.a.h.b(list);
                VideoPlayView videoPlayView = this.a.f;
                Intrinsics.checkNotNull(videoPlayView);
                videoPlayView.S();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class r implements VideoPlayView.h {
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

        @Override // com.baidu.tieba.videoplay.VideoPlayView.h
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_ROLLBACK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.a.d != 3 && this.a.d != 4) {
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
                statisticItem.param("tid", this.a.J1(Integer.valueOf(i)));
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.h
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class s implements VideoPlayView.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        public s(VideoVerticalPageFragment videoVerticalPageFragment) {
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

        @Override // com.baidu.tieba.videoplay.VideoPlayView.j
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || VideoVerticalPageFragment.K1(this.a, null, 1, null) == 0) {
                return;
            }
            VideoVerticalPageFragment videoVerticalPageFragment = this.a;
            videoVerticalPageFragment.u = Long.valueOf(VideoVerticalPageFragment.K1(videoVerticalPageFragment, null, 1, null));
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

    public static /* synthetic */ long K1(VideoVerticalPageFragment videoVerticalPageFragment, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        return videoVerticalPageFragment.J1(num);
    }

    public static final void M1(VideoVerticalPageFragment this$0, Void r5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, this$0, r5) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setInterceptStimeStat(true);
        }
    }

    public static final void j2(VideoVerticalPageFragment this$0, Unit unit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, this$0, unit) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.X1()) {
                this$0.h2(false, false, null);
            } else if (this$0.b2()) {
                this$0.i2();
            }
        }
    }

    public static final void k2(VideoVerticalPageFragment this$0, Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, this$0, pair) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (pair == null) {
                return;
            }
            Boolean bool = (Boolean) pair.first;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            this$0.h2(true, bool.booleanValue(), (String) pair.second);
        }
    }

    public static final boolean l2(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, view2, motionEvent)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static final void n2(VideoVerticalPageFragment this$0, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, this$0, list) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(list, "list");
            if (!(!list.isEmpty()) || this$0.h.v() || this$0.f == null) {
                return;
            }
            this$0.h.b(list);
            VideoPlayView videoPlayView = this$0.f;
            Intrinsics.checkNotNull(videoPlayView);
            videoPlayView.S();
        }
    }

    public static final void p2(VideoVerticalPageFragment this$0, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{this$0, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!z || !this$0.c2() || this$0.getPageContext() == null || this$0.getPageContext().getPageActivity() == null || this$0.W1() || this$0.O1() || this$0.N1() || this$0.Y1() || this$0.T1() || this$0.Q1() || this$0.Z1() || this$0.V1() || this$0.U1() || this$0.P1() || this$0.S1() || this$0.R1()) {
                return;
            }
            ej.N(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c8d));
        }
    }

    public static final void u2(VideoVerticalPageFragment this$0) {
        VideoPlayModel videoPlayModel;
        FrsVideoTabModel frsVideoTabModel;
        VideoChannelModel videoChannelModel;
        VideoHotTopicModel videoHotTopicModel;
        VideoPersonalModel videoPersonalModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.n) {
                if (this$0.d2()) {
                    Long l2 = this$0.h.l();
                    rx8 rx8Var = this$0.h;
                    VideoPlayView videoPlayView = this$0.f;
                    Intrinsics.checkNotNull(videoPlayView);
                    UserItemData i2 = rx8Var.i(videoPlayView.n);
                    if (l2 == null || i2 == null || (videoPersonalModel = this$0.z) == null) {
                        return;
                    }
                    videoPersonalModel.F(l2, i2);
                } else if (this$0.b2()) {
                    Long l3 = this$0.h.l();
                    if (l3 == null || (videoHotTopicModel = this$0.A) == null) {
                        return;
                    }
                    videoHotTopicModel.E(l3);
                } else {
                    int i3 = this$0.d;
                    if (i3 == 1 || i3 == 2) {
                        VideoPlayModel videoPlayModel2 = this$0.x;
                        if (videoPlayModel2 != null) {
                            videoPlayModel2.setFrom(this$0.m);
                        }
                        if (this$0.h.x() || (videoPlayModel = this$0.x) == null) {
                            return;
                        }
                        videoPlayModel.L(this$0.h.s(0));
                    } else if (i3 != 7 && i3 != 20) {
                        VideoChannelModel videoChannelModel2 = this$0.y;
                        if (videoChannelModel2 != null) {
                            videoChannelModel2.setFrom(this$0.m);
                        }
                        if (this$0.h.x() || (videoChannelModel = this$0.y) == null) {
                            return;
                        }
                        videoChannelModel.b();
                    } else if (this$0.h.x() || (frsVideoTabModel = this$0.B) == null) {
                    } else {
                        frsVideoTabModel.b();
                    }
                }
            }
        }
    }

    public static final void z2(VideoVerticalPageFragment this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.c2() && this$0.getPageContext() != null && this$0.getPageContext().getPageActivity() != null && !this$0.W1() && !this$0.O1() && !this$0.N1() && !this$0.Y1() && !this$0.T1() && !this$0.Q1() && !this$0.Z1() && !this$0.V1() && !this$0.U1() && !this$0.P1() && !this$0.S1() && !this$0.R1()) {
                ej.N(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c8d));
            }
            if (this$0.a2()) {
                VideoPlayView videoPlayView = this$0.f;
                boolean z = false;
                if (videoPlayView != null && videoPlayView.N()) {
                    z = true;
                }
                if (!z || this$0.getPageContext() == null || this$0.getPageContext().getPageActivity() == null || this$0.R1()) {
                    return;
                }
                ej.N(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c8f));
            }
        }
    }

    @Override // com.baidu.tieba.oy8
    public long E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoItemData s2 = this.h.s(this.i);
            if (s2 == null || TextUtils.isEmpty(s2.thread_id)) {
                return 0L;
            }
            return dh.g(s2.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sx8.f("5");
        }
    }

    public final Long H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t : (Long) invokeV.objValue;
    }

    public final Long I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.u : (Long) invokeV.objValue;
    }

    public final long J1(Integer num) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, num)) == null) {
            rx8 rx8Var = this.h;
            if (num == null) {
                VideoPlayView videoPlayView = this.f;
                Intrinsics.checkNotNull(videoPlayView);
                intValue = videoPlayView.n;
            } else {
                intValue = num.intValue();
            }
            VideoItemData s2 = rx8Var.s(intValue);
            if (s2 == null || TextUtils.isEmpty(s2.thread_id)) {
                return 0L;
            }
            return dh.g(s2.thread_id, 0L);
        }
        return invokeL.longValue;
    }

    public final qm5.b L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.K : (qm5.b) invokeV.objValue;
    }

    public final boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d == 11 : invokeV.booleanValue;
    }

    public final boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d == 10 : invokeV.booleanValue;
    }

    public final boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d == 16 : invokeV.booleanValue;
    }

    public final boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.d == 18 : invokeV.booleanValue;
    }

    public final boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d == 20 : invokeV.booleanValue;
    }

    public final boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.d == 17 : invokeV.booleanValue;
    }

    public final boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.d == 13 : invokeV.booleanValue;
    }

    public final boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.d == 15 : invokeV.booleanValue;
    }

    public final boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.d == 14 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.oy8
    public void W0(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048591, this, i2, i3, intent) == null) || (videoPlayView = this.f) == null) {
            return;
        }
        videoPlayView.G(i2, i3, intent);
    }

    public final boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.d == 9 : invokeV.booleanValue;
    }

    public final boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.d == 6 : invokeV.booleanValue;
    }

    public final boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.d == 12 : invokeV.booleanValue;
    }

    public final boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.d == 19 : invokeV.booleanValue;
    }

    public final boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.d == 7 : invokeV.booleanValue;
    }

    public final boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.d == 8 : invokeV.booleanValue;
    }

    public final boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? f2() || d2() || b2() : invokeV.booleanValue;
    }

    public final boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? X1() && !g2() : invokeV.booleanValue;
    }

    public final boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? X1() && g2() : invokeV.booleanValue;
    }

    public final boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.d == 5 : invokeV.booleanValue;
    }

    public final boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = this.r;
            if (personalPageParams == null) {
                return false;
            }
            return personalPageParams.isShareThread();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.uc5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.d == 3 ? "a088" : "a023" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oy8
    public boolean h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            VideoPlayView videoPlayView = this.f;
            return videoPlayView != null && videoPlayView.H();
        }
        return invokeV.booleanValue;
    }

    public final void h2(boolean z, boolean z2, String str) {
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        VideoPersonalModel videoPersonalModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) || (personalPageParams = this.r) == null || (videoPersonalModel = this.z) == null) {
            return;
        }
        rx8 rx8Var = this.h;
        VideoPlayView videoPlayView = this.f;
        Intrinsics.checkNotNull(videoPlayView);
        String r2 = rx8Var.r(videoPlayView.n);
        if (r2 == null) {
            return;
        }
        VideoNotifyPersonalPageData videoNotifyPersonalPageData = new VideoNotifyPersonalPageData();
        videoNotifyPersonalPageData.setPersonalPageUid(personalPageParams.getPersonalPageUid());
        videoNotifyPersonalPageData.setCurrentThreadId(r2);
        videoNotifyPersonalPageData.setFlutterPageId(personalPageParams.getFlutterPageId());
        videoNotifyPersonalPageData.setUserPostDataResMapList(videoPersonalModel.E());
        videoNotifyPersonalPageData.setCurrentPn(personalPageParams.getCurrentPn());
        videoNotifyPersonalPageData.setIsDeleteOperate(z);
        videoNotifyPersonalPageData.setDeleteStatus(z2);
        videoNotifyPersonalPageData.setDeleteStatusMessage(str);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921623, videoNotifyPersonalPageData));
    }

    public final void i2() {
        VideoHotTopicParams videoHotTopicParams;
        VideoHotTopicModel videoHotTopicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (videoHotTopicParams = this.s) == null || (videoHotTopicModel = this.A) == null) {
            return;
        }
        rx8 rx8Var = this.h;
        VideoPlayView videoPlayView = this.f;
        Intrinsics.checkNotNull(videoPlayView);
        String r2 = rx8Var.r(videoPlayView.n);
        if (r2 == null) {
            return;
        }
        VideoNotifyPersonalPageData videoNotifyPersonalPageData = new VideoNotifyPersonalPageData();
        videoNotifyPersonalPageData.setCurrentThreadId(r2);
        videoNotifyPersonalPageData.setFlutterPageId(videoHotTopicParams.getFlutterPageId());
        videoNotifyPersonalPageData.setVideoHotTopicDataResMapList(videoHotTopicModel.D());
        videoNotifyPersonalPageData.setCurrentPn(videoHotTopicParams.getCurrentPn());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921623, videoNotifyPersonalPageData));
    }

    /* JADX WARN: Type inference failed for: r1v124, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v126, types: [java.util.List<com.baidu.tieba.video.VideoItemData>, T] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.util.ArrayList] */
    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.h.c();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Bundle arguments = getArguments();
            objectRef.element = (ArrayList) (arguments == null ? null : arguments.getSerializable("video_list"));
            Bundle arguments2 = getArguments();
            this.J = arguments2 == null ? null : arguments2.getString("forum_id");
            if (objectRef.element == 0) {
                int i2 = this.d;
                if (i2 != 7 && i2 != 20) {
                    List<VideoItemData> list = VideoPlayActivityConfig.bigDataList;
                    if (list != null) {
                        list.get(0).setChannelMidRequestVideoNum(this.E);
                        VideoPlayActivityConfig.bigDataList.get(0).setChannelMidRequestNum(this.E);
                    }
                    objectRef.element = VideoPlayActivityConfig.bigDataList;
                } else {
                    objectRef.element = FrsVideoTabPlayActivityConfig.getVideoTabListByFid(this.J);
                }
            }
            this.h.z((List) objectRef.element);
            this.i = getArguments() != null ? requireArguments().getInt("video_index", 0) : 0;
            this.j = getArguments() != null ? requireArguments().getInt("video_show_index", 0) : 0;
            Bundle arguments3 = getArguments();
            if ((arguments3 == null ? null : (Rect) arguments3.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT)) != null) {
                Bundle arguments4 = getArguments();
                this.k = arguments4 == null ? null : (Rect) arguments4.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
            } else {
                Bundle arguments5 = getArguments();
                if ((arguments5 == null ? null : (Rect) arguments5.getParcelable("video_cover_rect")) != null) {
                    Bundle arguments6 = getArguments();
                    this.k = arguments6 == null ? null : (Rect) arguments6.getParcelable("video_cover_rect");
                } else {
                    Bundle arguments7 = getArguments();
                    this.k = arguments7 == null ? null : (Rect) arguments7.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
                }
            }
            Bundle arguments8 = getArguments();
            this.l = arguments8 == null ? null : arguments8.getString("page_from");
            Bundle arguments9 = getArguments();
            this.m = arguments9 == null ? null : arguments9.getString("from");
            Bundle arguments10 = getArguments();
            this.o = arguments10 == null ? null : arguments10.getString("st_type");
            Bundle arguments11 = getArguments();
            this.p = arguments11 == null ? null : arguments11.getString("yuelaou_locate");
            this.q = getArguments() != null ? requireArguments().getBoolean("is_vertail", true) : false;
            if (this.r == null) {
                this.r = VideoRecommentPlayActivityConfig.bigPersonalPageParams;
            }
            if (this.s == null) {
                this.s = VideoRecommentPlayActivityConfig.bigVideoHotTopicParams;
            }
            if (this.h.v() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.h.z(VideoPlayActivityConfig.bigDataList);
            }
            this.h.C(getUniqueId());
            if (this.d == 3) {
                r2(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.h.D("a088");
            } else {
                this.h.D("a023");
            }
            int i3 = this.d;
            if (i3 != 1 && i3 != 2) {
                if (c2()) {
                    if (this.j >= this.h.k()) {
                        this.j = 0;
                    }
                    if (d2()) {
                        o2();
                    }
                    if (b2()) {
                        m2();
                    }
                } else if (!W1() && !O1() && !N1() && !Y1() && !T1() && !Q1() && !Z1() && !V1() && !U1() && !P1() && !S1() && !R1()) {
                    int i4 = this.d;
                    if (i4 != 7 && i4 != 20) {
                        VideoChannelModel videoChannelModel = new VideoChannelModel(getPageContext(), getUniqueId());
                        this.y = videoChannelModel;
                        if (videoChannelModel != null) {
                            videoChannelModel.setFrom(this.m);
                        }
                        VideoChannelModel videoChannelModel2 = this.y;
                        if (videoChannelModel2 != null) {
                            videoChannelModel2.I(this.c);
                        }
                        VideoChannelModel videoChannelModel3 = this.y;
                        if (videoChannelModel3 != null) {
                            videoChannelModel3.J(new g(this));
                        }
                        if (this.h.s(0) != null) {
                            VideoItemData s2 = this.h.s(0);
                            this.v = s2 != null ? s2.thread_id : null;
                        }
                        VideoChannelModel videoChannelModel4 = this.y;
                        if (videoChannelModel4 != null) {
                            videoChannelModel4.setFrom(this.m);
                        }
                        if (!BdNetTypeUtil.isNetWorkAvailable() && !isPrimary()) {
                            return;
                        }
                        if (e2()) {
                            VideoChannelModel videoChannelModel5 = this.y;
                            if (videoChannelModel5 != null) {
                                videoChannelModel5.b();
                            }
                        } else {
                            VideoChannelModel videoChannelModel6 = this.y;
                            if (videoChannelModel6 != null) {
                                videoChannelModel6.H();
                            }
                        }
                    } else if (getPageContext() == null || getUniqueId() == null) {
                        return;
                    } else {
                        FrsVideoTabModel frsVideoTabModel = new FrsVideoTabModel(getPageContext(), getUniqueId());
                        this.B = frsVideoTabModel;
                        if (frsVideoTabModel != null) {
                            frsVideoTabModel.setFrom(this.m);
                        }
                        FrsVideoTabModel frsVideoTabModel2 = this.B;
                        if (frsVideoTabModel2 != null) {
                            frsVideoTabModel2.B(this.c);
                        }
                        FrsVideoTabModel frsVideoTabModel3 = this.B;
                        if (frsVideoTabModel3 != null) {
                            frsVideoTabModel3.C(new f(objectRef, this));
                        }
                    }
                } else if (this.j >= this.h.k()) {
                    this.j = 0;
                }
            } else {
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest()) {
                    if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                        wu6.m().z(getActivity(), new c(this), this.h.o());
                    }
                    if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                        wu6.m().y(getActivity(), new d(this), this.h.o());
                    }
                }
                VideoPlayModel videoPlayModel = new VideoPlayModel(getPageContext(), getUniqueId());
                this.x = videoPlayModel;
                if (videoPlayModel != null) {
                    videoPlayModel.setFrom(this.m);
                }
                VideoPlayModel videoPlayModel2 = this.x;
                if (videoPlayModel2 != null) {
                    videoPlayModel2.N(this.c);
                }
                VideoPlayModel videoPlayModel3 = this.x;
                if (videoPlayModel3 != null) {
                    videoPlayModel3.O(new e(this));
                }
                if (this.h.s(0) != null) {
                    VideoItemData s3 = this.h.s(0);
                    this.v = s3 != null ? s3.thread_id : null;
                }
                VideoPlayModel videoPlayModel4 = this.x;
                if (videoPlayModel4 != null) {
                    videoPlayModel4.setFrom(this.m);
                }
                VideoPlayModel videoPlayModel5 = this.x;
                if (videoPlayModel5 != null) {
                    videoPlayModel5.M(this.h.s(0), this.o, this.p, this.q);
                }
            }
            this.M = new py8(this.h.h(), getPageContext());
            q2();
            if (this.w == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getPageContext().getUniqueId());
                this.w = pollingModel;
                if (pollingModel == null) {
                    return;
                }
                pollingModel.X(new h(this));
            }
        }
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || getPageContext() == null || getUniqueId() == null || this.s == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        VideoHotTopicParams videoHotTopicParams = this.s;
        Intrinsics.checkNotNull(videoHotTopicParams);
        VideoHotTopicModel videoHotTopicModel = new VideoHotTopicModel(pageContext, videoHotTopicParams);
        this.A = videoHotTopicModel;
        if (videoHotTopicModel == null) {
            return;
        }
        videoHotTopicModel.F(new VideoHotTopicModel.b() { // from class: com.baidu.tieba.cy8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.videoplay.model.VideoHotTopicModel.b
            public final void a(List list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                    VideoVerticalPageFragment.n2(VideoVerticalPageFragment.this, list);
                }
            }
        });
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || getPageContext() == null || getUniqueId() == null || this.r == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = this.r;
        Intrinsics.checkNotNull(personalPageParams);
        VideoPersonalModel videoPersonalModel = new VideoPersonalModel(pageContext, personalPageParams);
        this.z = videoPersonalModel;
        if (videoPersonalModel == null) {
            return;
        }
        videoPersonalModel.G(new q(this));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.H = new OnActivityFinishListener<>(getPageContext(), new SimpleMessageListener.b() { // from class: com.baidu.tieba.jy8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.util.SimpleMessageListener.b
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        VideoVerticalPageFragment.j2(VideoVerticalPageFragment.this, (Unit) obj);
                    }
                }
            });
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            this.I = new OnDeleteSelfPostListener(pageContext, new SimpleMessageListener.b() { // from class: com.baidu.tieba.ly8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.util.SimpleMessageListener.b
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        VideoVerticalPageFragment.k2(VideoVerticalPageFragment.this, (Pair) obj);
                    }
                }
            });
            Lifecycle lifecycle = getLifecycle();
            OnDeleteSelfPostListener onDeleteSelfPostListener = this.I;
            Intrinsics.checkNotNull(onDeleteSelfPostListener);
            lifecycle.addObserver(onDeleteSelfPostListener);
            Lifecycle lifecycle2 = getLifecycle();
            OnActivityFinishListener<Unit> onActivityFinishListener = this.H;
            Intrinsics.checkNotNull(onActivityFinishListener);
            lifecycle2.addObserver(onActivityFinishListener);
            getLifecycle().addObserver(this.G);
            initData();
            t2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                W0(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.T(i2);
            }
            if (!UbsABTestHelper.isFeedVideoImmersionTransition() || (getActivity() instanceof VideoRecommentPlayActivity)) {
                SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048613, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            registerListener(this.O);
            registerListener(this.N);
            registerListener(this.Q);
            registerListener(this.L);
            registerListener(this.P);
            registerListener(this.U);
            registerListener(this.T);
            this.e = inflater.inflate(R.layout.obfuscated_res_0x7f0d08e3, viewGroup, false);
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !(getActivity() instanceof VideoRecommentPlayActivity) && (view2 = this.e) != null) {
                view2.setBackgroundColor(0);
            }
            View view3 = this.e;
            RelativeLayout relativeLayout = view3 == null ? null : (RelativeLayout) view3.findViewById(R.id.obfuscated_res_0x7f0926e9);
            this.g = relativeLayout;
            if (relativeLayout != null) {
                relativeLayout.setOnTouchListener(ey8.a);
            }
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onDestroy();
            if (this.I != null) {
                Lifecycle lifecycle = getLifecycle();
                OnDeleteSelfPostListener onDeleteSelfPostListener = this.I;
                Intrinsics.checkNotNull(onDeleteSelfPostListener);
                lifecycle.removeObserver(onDeleteSelfPostListener);
            }
            if (this.H != null) {
                Lifecycle lifecycle2 = getLifecycle();
                OnActivityFinishListener<Unit> onActivityFinishListener = this.H;
                Intrinsics.checkNotNull(onActivityFinishListener);
                lifecycle2.removeObserver(onActivityFinishListener);
            }
            getLifecycle().removeObserver(this.G);
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.U();
            }
            if (isPrimary()) {
                v2();
            }
            if (getActivity() instanceof FrsVideoTabPlayActivity) {
                G1();
            }
            VideoPersonalModel videoPersonalModel = this.z;
            if (videoPersonalModel == null) {
                return;
            }
            videoPersonalModel.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onDestroyView();
            wu6.m().d("6061002332-203360688");
            wu6.m().c(wu6.s());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView == null) {
                return;
            }
            videoPlayView.V();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onPrimary();
            if (!this.D) {
                v2();
            }
            if (getActivity() instanceof FrsVideoTabPlayActivity) {
                G1();
            }
            if (this.D && this.d == 3) {
                nx8.a(1);
            }
            if (isPrimary()) {
                fa5.b().c();
                fa5.b().l(true);
            }
            this.t = Long.valueOf(E0());
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.h0(isPrimary());
            }
            if (!this.C && isPrimary() && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.d == 3) {
                this.C = true;
                if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                    wu6.m().z(getActivity(), new o(this), this.h.o());
                } else if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                    wu6.m().y(getActivity(), new p(this), this.h.o());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onResume();
            if (this.F && this.D && isPrimary()) {
                setUserVisibleHint(true);
                this.F = false;
            }
            if (TbSingleton.getInstance().isVideoChannelRelogin() && isPrimary()) {
                TbSingleton.getInstance().setVideoChannelRelogin(false);
                VideoPlayView videoPlayView = this.f;
                if (videoPlayView == null) {
                    return;
                }
                videoPlayView.Y(this.D);
            }
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_JUMP_YY_LIVE_IN_VIDEO_LIST, Intrinsics.stringPlus(TbConfig.SERVER_ADDRESS, TbConfig.URL_JUMP_YY_LIVE_IN_VIDEO_LIST));
            tbHttpMessageTask.setResponsedClass(JumpYYLiveHttpResponseMessage.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void r2(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048620, this, i2) == null) || (view2 = this.e) == null) {
            return;
        }
        Intrinsics.checkNotNull(view2);
        int paddingLeft = view2.getPaddingLeft();
        View view3 = this.e;
        Intrinsics.checkNotNull(view3);
        int paddingTop = view3.getPaddingTop();
        View view4 = this.e;
        Intrinsics.checkNotNull(view4);
        view2.setPadding(paddingLeft, paddingTop, view4.getPaddingRight(), i2);
    }

    public final void s2(qm5.b bVar) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, bVar) == null) || (videoPlayView = this.f) == null) {
            return;
        }
        videoPlayView.a0(bVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z && this.d == 6) {
                y2();
            }
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.Y(z);
            }
            this.D = z;
        }
    }

    public final void t2() {
        VideoPlayView videoPlayView;
        VideoPlayView videoPlayView2;
        VideoPlayView videoPlayView3;
        VideoPlayView videoPlayView4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            BdUniqueId bdUniqueId = this.a;
            Activity pageActivity = getPageContext().getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView5 = new VideoPlayView(bdUniqueId, (FragmentActivity) pageActivity, this, this.m, getUniqueId(), 1, this.d, g2(), this.J);
                this.f = videoPlayView5;
                if (videoPlayView5 != null) {
                    videoPlayView5.Z(new r(this));
                }
                if (this.d == 3 && (videoPlayView4 = this.f) != null) {
                    videoPlayView4.k0("from_suggest_sub_fragment");
                }
                VideoPlayView videoPlayView6 = this.f;
                if (videoPlayView6 != null) {
                    BdSwipeRefreshLayout.k kVar = this.b;
                    if (kVar == null) {
                        kVar = this.R;
                    }
                    videoPlayView6.i0(kVar);
                }
                VideoPlayView videoPlayView7 = this.f;
                if (videoPlayView7 != null) {
                    videoPlayView7.X(this.S);
                }
                if (this.c != 1 && (videoPlayView3 = this.f) != null) {
                    videoPlayView3.a0(this.K);
                }
                int i2 = this.d;
                if ((i2 == 7 || i2 == 20) && (videoPlayView = this.f) != null) {
                    videoPlayView.e0(new s(this));
                }
                py8 py8Var = this.M;
                if (py8Var != null) {
                    py8Var.o(this.f);
                }
                VideoPlayView videoPlayView8 = this.f;
                if (videoPlayView8 != null) {
                    videoPlayView8.f0(new VideoPlayView.i() { // from class: com.baidu.tieba.ky8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.videoplay.VideoPlayView.i
                        public final void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                VideoVerticalPageFragment.u2(VideoVerticalPageFragment.this);
                            }
                        }
                    });
                }
                VideoPlayView videoPlayView9 = this.f;
                if (videoPlayView9 != null) {
                    videoPlayView9.n0(this.h, this.i, this.k);
                }
                VideoPlayView videoPlayView10 = this.f;
                if (videoPlayView10 != null) {
                    videoPlayView10.g0(this.l);
                }
                VideoPlayView videoPlayView11 = this.f;
                if (videoPlayView11 != null) {
                    videoPlayView11.d0(this.v);
                }
                VideoPlayView videoPlayView12 = this.f;
                if (videoPlayView12 != null) {
                    videoPlayView12.l0(this.c);
                }
                if (c2() && (videoPlayView2 = this.f) != null) {
                    videoPlayView2.j0(this.j, false);
                }
                VideoPlayView videoPlayView13 = this.f;
                if (videoPlayView13 == null) {
                    return;
                }
                videoPlayView13.c0(this.M);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            sx8.g(getActivity() instanceof VideoPlayActivity ? "1" : "3");
        }
    }

    public final void w2(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        UserItemData userItemData;
        UserItemData userItemData2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, videoItemData, list) == null) {
            VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list, 0);
            if (videoItemData == null || (userItemData = videoItemData.author_info) == null || videoItemData2 == null || (userItemData2 = videoItemData2.author_info) == null || (str = userItemData2.user_id) == null || !Intrinsics.areEqual(str, userItemData.user_id)) {
                return;
            }
            videoItemData2.author_info.is_follow = videoItemData.author_info.is_follow;
        }
    }

    public final void x2(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, videoItemData, list) == null) {
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

    @Override // com.baidu.tieba.oy8
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            VideoPlayView videoPlayView = this.f;
            Intrinsics.checkNotNull(videoPlayView);
            int i2 = videoPlayView.o;
            VideoPlayView videoPlayView2 = this.f;
            Intrinsics.checkNotNull(videoPlayView2);
            if (i2 != videoPlayView2.n) {
                VideoPlayView videoPlayView3 = this.f;
                Intrinsics.checkNotNull(videoPlayView3);
                if (videoPlayView3.n >= 0) {
                    VideoPlayView videoPlayView4 = this.f;
                    Intrinsics.checkNotNull(videoPlayView4);
                    if (videoPlayView4.n < this.h.k()) {
                        rx8 rx8Var = this.h;
                        VideoPlayView videoPlayView5 = this.f;
                        Intrinsics.checkNotNull(videoPlayView5);
                        VideoItemData s2 = rx8Var.s(videoPlayView5.n);
                        if (s2 == null || StringUtils.isNull(s2.thread_id)) {
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, s2.thread_id));
                    }
                }
            }
        }
    }

    public final void y2() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (relativeLayout = this.g) == null) {
            return;
        }
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(8);
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
        this.b = kVar;
        this.c = i2;
        this.d = i3;
        this.h = new rx8();
        this.n = true;
        this.E = 1;
        this.F = rl4.w().C();
        this.G = new VideoPlayFragment.GoPbCommentFloatListener(new SimpleMessageListener.b() { // from class: com.baidu.tieba.dy8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tbadk.util.SimpleMessageListener.b
            public final void call(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    VideoVerticalPageFragment.M1(VideoVerticalPageFragment.this, (Void) obj);
                }
            }
        });
        this.K = new b(this);
        this.L = new m(this);
        this.N = new k(this);
        this.O = new n(this);
        this.P = new j(this);
        this.Q = new l(this);
        this.R = new BdSwipeRefreshLayout.k() { // from class: com.baidu.tieba.gy8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
            public final void a(int i6, int i7, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z)}) == null) {
                    VideoVerticalPageFragment.p2(VideoVerticalPageFragment.this, i6, i7, z);
                }
            }
        };
        this.S = new VideoPlayView.k() { // from class: com.baidu.tieba.my8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.videoplay.VideoPlayView.k
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    VideoVerticalPageFragment.z2(VideoVerticalPageFragment.this);
                }
            }
        };
        this.T = new i(this);
        this.U = new a(this);
    }
}
