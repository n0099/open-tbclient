package com.baidu.tieba.videoplay.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
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
import com.baidu.tieba.aq4;
import com.baidu.tieba.bo9;
import com.baidu.tieba.dk7;
import com.baidu.tieba.gg;
import com.baidu.tieba.ii;
import com.baidu.tieba.jw5;
import com.baidu.tieba.sw9;
import com.baidu.tieba.ti5;
import com.baidu.tieba.tx9;
import com.baidu.tieba.ux9;
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
import com.baidu.tieba.w8;
import com.baidu.tieba.ww9;
import com.baidu.tieba.xw9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.Serializable;
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
import tbclient.PbContent;
import tbclient.ThreadInfo;
import tbclient.VideoRedIcon.RedIcon;
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0002£\u0001B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010W\u001a\u00020?H\u0002J\b\u0010X\u001a\u00020\u0012H\u0016J\r\u0010Y\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010ZJ\r\u0010[\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010ZJ\b\u0010\\\u001a\u00020\u0014H\u0016J\u0017\u0010]\u001a\u00020\u00142\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010_J\b\u0010`\u001a\u0004\u0018\u00010\u0010J\"\u0010a\u001a\u00020?2\u0006\u0010b\u001a\u00020\b2\u0006\u0010c\u001a\u00020\b2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\b\u0010f\u001a\u00020\u0019H\u0016J\b\u0010g\u001a\u00020?H\u0016J\b\u0010h\u001a\u00020?H\u0002J\b\u0010i\u001a\u00020\u0019H\u0002J\b\u0010j\u001a\u00020\u0019H\u0002J\b\u0010k\u001a\u00020\u0019H\u0002J\b\u0010l\u001a\u00020\u0019H\u0002J\b\u0010m\u001a\u00020\u0019H\u0002J\b\u0010n\u001a\u00020\u0019H\u0002J\b\u0010o\u001a\u00020\u0019H\u0002J\b\u0010p\u001a\u00020\u0019H\u0002J\b\u0010q\u001a\u00020\u0019H\u0002J\b\u0010r\u001a\u00020\u0019H\u0002J\b\u0010s\u001a\u00020\u0019H\u0002J\b\u0010t\u001a\u00020\u0019H\u0002J\b\u0010u\u001a\u00020\u0019H\u0002J\b\u0010v\u001a\u00020\u0019H\u0002J\b\u0010w\u001a\u00020\u0019H\u0002J\b\u0010x\u001a\u00020\u0019H\u0002J\b\u0010y\u001a\u00020\u0019H\u0002J\b\u0010z\u001a\u00020\u0019H\u0002J\b\u0010{\u001a\u00020\u0019H\u0002J\b\u0010|\u001a\u00020\u0019H\u0002J#\u0010}\u001a\u00020?2\u0006\u0010~\u001a\u00020\u00192\u0006\u0010\u007f\u001a\u00020\u00192\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0012H\u0002J\t\u0010\u0081\u0001\u001a\u00020?H\u0002J\u0015\u0010\u0082\u0001\u001a\u00020?2\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J#\u0010\u0085\u0001\u001a\u00020?2\u0006\u0010b\u001a\u00020\b2\u0006\u0010c\u001a\u00020\b2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0012\u0010\u0086\u0001\u001a\u00020?2\u0007\u0010\u0087\u0001\u001a\u00020\bH\u0016J-\u0010\u0088\u0001\u001a\u0004\u0018\u0001012\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J\t\u0010\u008d\u0001\u001a\u00020?H\u0016J\t\u0010\u008e\u0001\u001a\u00020?H\u0016J\t\u0010\u008f\u0001\u001a\u00020?H\u0016J\t\u0010\u0090\u0001\u001a\u00020?H\u0016J\t\u0010\u0091\u0001\u001a\u00020?H\u0016J\t\u0010\u0092\u0001\u001a\u00020?H\u0002J\t\u0010\u0093\u0001\u001a\u00020?H\u0002J\t\u0010\u0094\u0001\u001a\u00020?H\u0002J\u0012\u0010\u0095\u0001\u001a\u00020?2\u0007\u0010\u0096\u0001\u001a\u00020\bH\u0002J\u0011\u0010\u0097\u0001\u001a\u00020?2\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020?2\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0010J\t\u0010\u009a\u0001\u001a\u00020?H\u0002J\t\u0010\u009b\u0001\u001a\u00020?H\u0002J$\u0010\u009c\u0001\u001a\u00020?2\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u00030\u009e\u00010 \u0001H\u0002J&\u0010¡\u0001\u001a\u00020?2\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u00012\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u00030\u009e\u00010 \u0001H\u0002J\t\u0010¢\u0001\u001a\u00020?H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010=\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010?\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¤\u0001"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/videoplay/fragment/IVideoPlayActicityFragment;", "mActivityPageUniqueId", "Lcom/baidu/adp/BdUniqueId;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "mainPageType", "", "mCurrentType", "(Lcom/baidu/adp/BdUniqueId;Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;II)V", "backGroundListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "eventListener", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "fid", "", "firstVideoTid", "", "Ljava/lang/Long;", "goPbCommentFloatListener", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "isSchemeUp", "", "isVertail", "isVisibleToUser", "keyboardShowHideListener", "lastVideoTid", "mAdCloseListener", "mFeedBackListener", "mFrom", "mFromPage", "mFrsVideoTabModel", "Lcom/baidu/tieba/videoplay/model/FrsVideoTabModel;", "mHasMore", "mLocate", "mMidChannelNum", "mNAdDispatcher", "Lcom/baidu/tieba/videoplay/nad/AdVideoFlowDispatcher;", "mNetworkChangedMessageListener", "mObjId", "mPollingModel", "Lcom/baidu/tbadk/core/leveiconlivepolling/PollingModel;", "mRecommendTabInsertDataListener", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "mUEGFeedBackListener", "mVideoChannelModel", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoIndex", "mVideoPlayModel", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoShowIndex", "mVideoTabReqFunAd", "onActivityFinishListener", "Lcom/baidu/tbadk/util/OnActivityFinishListener;", "", "onDeleteSelfPostListener", "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "personalPageParams", "Lcom/baidu/tbadk/core/atomData/VideoRecommentPlayActivityConfig$PersonalPageParams;", "progressViewCallbackFra", "getProgressViewCallbackFra", "()Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "setProgressViewCallbackFra", "(Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;)V", "videoHotTopicModel", "Lcom/baidu/tieba/videoplay/model/VideoHotTopicModel;", "videoHotTopicParams", "Lcom/baidu/tbadk/module/hottopic/VideoHotTopicParams;", "videoPersonalModel", "Lcom/baidu/tieba/videoplay/model/VideoPersonalModel;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "getViewPagerBottomScrollMoreCallback", "()Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "setViewPagerBottomScrollMoreCallback", "(Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;)V", "youngsterVerticalLayout", "Landroid/widget/RelativeLayout;", "frsStepStat", "getCurrentPageKey", "getFirstVideoTid", "()Ljava/lang/Long;", "getLastVideoTid", "getMissionTid", "getShowVideoTid", "index", "(Ljava/lang/Integer;)J", "getVEventListener", "handleActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "handleBackPress", "handleIndexMessage", "initData", "isFromAgreePage", "isFromAtPage", "isFromCollection", "isFromCreateCenterPage", "isFromFrsTop", "isFromHistory", "isFromLink", "isFromMyThread", "isFromOfficalVideo", "isFromPbVideoSchema", "isFromPersonalPage", "isFromReplyPage", "isFromWorkManagement", "isFrsVideoTab", "isHotTopicPlay", "isNoTabPlay", "isPersonalPlay", "isPersonalSharePlay", "isRecommendPlay", "isShareThread", "notifyPersonalPage", "isDelete", "isDeleteSucceed", "deleteErrorMessage", "notifyVideoHotTopicPage", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "processVideoHotTopicModel", "processVideoPersonalModel", "registerJumpYYLiveHttpTask", "setEmptyHeight", "height", "setUserVisibleHint", "setVideoPlayViewEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showData", "stepStat", "syncFirstVideoFollowState", "originalData", "Lcom/baidu/tieba/video/VideoItemData;", "newList", "", "syncFirstVideoThreadData", "updateYoungsterMode", "OnDeleteSelfPostListener", "VideoPlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VideoVerticalPageFragment extends BaseFragment implements tx9 {
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
    public jw5.b K;
    public final CustomMessageListener L;
    public ux9 M;
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
    public final ww9 h;
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

    public static final boolean y2(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, view2, motionEvent)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB-\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "Lcom/baidu/tbadk/util/SimpleMessageListener;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tbadk/util/SimpleMessageListener$Callback;", "Landroidx/core/util/Pair;", "", "", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tbadk/util/SimpleMessageListener$Callback;)V", "Companion", "VideoPlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class OnDeleteSelfPostListener extends SimpleMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public static final a c;
        public transient /* synthetic */ FieldHolder $fh;

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

        @JvmStatic
        public static final void g(TbPageContext<?> tbPageContext, Pair<Boolean, String> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, tbPageContext, pair) == null) {
                c.a(tbPageContext, pair);
            }
        }

        /* loaded from: classes6.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

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

            @JvmStatic
            public final void a(TbPageContext<?> pageContext, Pair<Boolean, String> data) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, pageContext, data) == null) {
                    Intrinsics.checkNotNullParameter(pageContext, "pageContext");
                    Intrinsics.checkNotNullParameter(data, "data");
                    SimpleMessageListener.d(2001460, pageContext, data);
                }
            }
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
            b(pageContext);
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
                if (msg.getCmd() != 2001011 || !(msg instanceof BackgroundSwitchMessage)) {
                    return;
                }
                BackgroundSwitchMessage backgroundSwitchMessage = (BackgroundSwitchMessage) msg;
                if (backgroundSwitchMessage.getData() != null) {
                    Boolean isBackground = backgroundSwitchMessage.getData();
                    Intrinsics.checkNotNullExpressionValue(isBackground, "isBackground");
                    if (isBackground.booleanValue()) {
                        boolean z = false;
                        if (w8.f().b() instanceof bo9) {
                            Activity b = w8.f().b();
                            if (b != null) {
                                if (((bo9) b).getCurrentTabType() == 22) {
                                    z = true;
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.tblauncher.IMaintabType");
                            }
                        }
                        if ((this.a.D && z) || ((w8.f().b() instanceof VideoPlayActivity) && (this.a.getActivity() instanceof VideoPlayActivity))) {
                            this.a.I2();
                        }
                        if (z || !(w8.f().b() instanceof FrsVideoTabPlayActivity) || !(this.a.getActivity() instanceof FrsVideoTabPlayActivity)) {
                            return;
                        }
                        this.a.T1();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements jw5.b {
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

        @Override // com.baidu.tieba.jw5.b
        public void onViewClick() {
            VideoPlayView videoPlayView;
            jw5.b G;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (videoPlayView = this.a.f) != null && (G = videoPlayView.G()) != null) {
                G.onViewClick();
            }
        }

        @Override // com.baidu.tieba.jw5.b
        public void onViewDragToRight() {
            VideoPlayView videoPlayView;
            jw5.b G;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (videoPlayView = this.a.f) != null && (G = videoPlayView.G()) != null) {
                G.onViewDragToRight();
            }
        }

        @Override // com.baidu.tieba.jw5.b
        public void s0(float f, float f2) {
            VideoPlayView videoPlayView;
            jw5.b G;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) && (videoPlayView = this.a.f) != null && (G = videoPlayView.G()) != null) {
                G.s0(f, f2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements dk7.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        @Override // com.baidu.tieba.dk7.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

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

        @Override // com.baidu.tieba.dk7.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, str, i) != null) || !dk7.m().v("6061002332-203360688") || this.a.f == null) {
                return;
            }
            ww9 ww9Var = this.a.h;
            VideoPlayView videoPlayView = this.a.f;
            Intrinsics.checkNotNull(videoPlayView);
            ww9Var.a(videoPlayView.n);
            VideoPlayView videoPlayView2 = this.a.f;
            if (videoPlayView2 != null) {
                videoPlayView2.U();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements dk7.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        @Override // com.baidu.tieba.dk7.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

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

        @Override // com.baidu.tieba.dk7.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, str, i) != null) || !dk7.m().v(dk7.s()) || this.a.f == null) {
                return;
            }
            ww9 ww9Var = this.a.h;
            VideoPlayView videoPlayView = this.a.f;
            Intrinsics.checkNotNull(videoPlayView);
            ww9Var.a(videoPlayView.n);
            VideoPlayView videoPlayView2 = this.a.f;
            if (videoPlayView2 != null) {
                videoPlayView2.U();
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

        /* JADX DEBUG: Multi-variable search result rejected for r6v27, resolved type: com.baidu.tieba.ww9 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void a(List<? extends VideoItemData> datas, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, datas, z) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                this.a.n = z;
                if (!ListUtils.isEmpty(datas) && !this.a.h.v()) {
                    VideoVerticalPageFragment videoVerticalPageFragment = this.a;
                    VideoItemData s = videoVerticalPageFragment.h.s(0);
                    Intrinsics.checkNotNull(s);
                    videoVerticalPageFragment.J2(s, datas);
                    VideoVerticalPageFragment videoVerticalPageFragment2 = this.a;
                    videoVerticalPageFragment2.K2(videoVerticalPageFragment2.h.s(0), datas);
                    if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_H5_SEARCH, this.a.m)) {
                        this.a.h.b(datas.subList(1, datas.size()));
                    } else {
                        this.a.h.z(datas);
                    }
                    if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && UbsABTestHelper.isVideoAdDrawABTestA() && dk7.m().v("6061002332-203360688") && this.a.f != null) {
                        ww9 ww9Var = this.a.h;
                        VideoPlayView videoPlayView = this.a.f;
                        Intrinsics.checkNotNull(videoPlayView);
                        ww9Var.a(videoPlayView.n - 1);
                    }
                    if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && UbsABTestHelper.isVideoAdDrawABTestB() && dk7.m().v(dk7.s()) && this.a.f != null) {
                        ww9 ww9Var2 = this.a.h;
                        VideoPlayView videoPlayView2 = this.a.f;
                        Intrinsics.checkNotNull(videoPlayView2);
                        ww9Var2.a(videoPlayView2.n - 1);
                    }
                    VideoPlayView videoPlayView3 = this.a.f;
                    if (videoPlayView3 != null) {
                        videoPlayView3.U();
                    }
                    VideoPlayView videoPlayView4 = this.a.f;
                    if (videoPlayView4 != null) {
                        videoPlayView4.M();
                    }
                    VideoPlayView videoPlayView5 = this.a.f;
                    if (videoPlayView5 != null) {
                        videoPlayView5.l0(0, true);
                    }
                    VideoPlayView videoPlayView6 = this.a.f;
                    if (videoPlayView6 != null) {
                        videoPlayView6.j0(this.a.isPrimary());
                    }
                    VideoPlayView videoPlayView7 = this.a.f;
                    if (videoPlayView7 != null) {
                        videoPlayView7.a0(this.a.D);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void b(List<? extends VideoItemData> datas, boolean z) {
            Boolean bool;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, datas, z) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                this.a.n = z;
                if (ListUtils.isEmpty(datas)) {
                    return;
                }
                ww9 ww9Var = this.a.h;
                if (ww9Var != null) {
                    bool = Boolean.valueOf(ww9Var.v());
                } else {
                    bool = null;
                }
                if (!bool.booleanValue()) {
                    this.a.h.b(datas);
                    if (this.a.f != null) {
                        ww9 ww9Var2 = this.a.h;
                        VideoPlayView videoPlayView = this.a.f;
                        Intrinsics.checkNotNull(videoPlayView);
                        ww9Var2.a(videoPlayView.n);
                    }
                    VideoPlayView videoPlayView2 = this.a.f;
                    if (videoPlayView2 != null) {
                        videoPlayView2.U();
                    }
                }
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
                if (this.a.element != null && !this.b.h.v() && this.b.f != null) {
                    this.b.h.z(this.a.element);
                    VideoPlayView videoPlayView = this.b.f;
                    Intrinsics.checkNotNull(videoPlayView);
                    videoPlayView.U();
                }
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
                if (!ListUtils.isEmpty(datas)) {
                    this.a.h.z(datas);
                    if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && (((UbsABTestHelper.isVideoAdDrawABTestA() && dk7.m().v("6061002332-203360688")) || (UbsABTestHelper.isVideoAdDrawABTestB() && dk7.m().v(dk7.s()))) && this.a.f != null)) {
                        ww9 ww9Var = this.a.h;
                        VideoPlayView videoPlayView = this.a.f;
                        Intrinsics.checkNotNull(videoPlayView);
                        ww9Var.a(videoPlayView.n);
                    }
                    VideoPlayView videoPlayView2 = this.a.f;
                    if (videoPlayView2 != null) {
                        videoPlayView2.U();
                    }
                    VideoPlayView videoPlayView3 = this.a.f;
                    if (videoPlayView3 != null) {
                        videoPlayView3.l0(0, true);
                    }
                    VideoPlayView videoPlayView4 = this.a.f;
                    if (videoPlayView4 != null) {
                        videoPlayView4.j0(this.a.isPrimary());
                    }
                    ux9 ux9Var = this.a.M;
                    if (ux9Var != null) {
                        ux9Var.i();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void b(List<? extends VideoItemData> datas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, datas) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                if (!ListUtils.isEmpty(datas) && !this.a.h.v()) {
                    this.a.h.b(datas);
                    if (this.a.f != null) {
                        ww9 ww9Var = this.a.h;
                        VideoPlayView videoPlayView = this.a.f;
                        Intrinsics.checkNotNull(videoPlayView);
                        ww9Var.a(videoPlayView.n);
                    }
                    VideoPlayView videoPlayView2 = this.a.f;
                    if (videoPlayView2 != null) {
                        videoPlayView2.U();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class h implements PollingModel.d {
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

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
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
                if (videoPlayView2.S(liveSecondFloor) && (videoPlayView = this.a.f) != null) {
                    videoPlayView.s0(this.a.a, liveSecondFloor, "video_recommend");
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
                                this.a.E2(0);
                                return;
                            } else {
                                this.a.E2(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
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
            List<VideoItemModel> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                Object data = responsedMessage.getData();
                if (data != null) {
                    String str = (String) data;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    ux9 ux9Var = this.a.M;
                    if (ux9Var != null) {
                        list = ux9Var.h(str);
                    } else {
                        list = null;
                    }
                    if (list != null) {
                        if (!list.isEmpty()) {
                            this.a.h.h().removeAll(list);
                            VideoPlayView videoPlayView = this.a.f;
                            if (videoPlayView != null) {
                                videoPlayView.U();
                                return;
                            }
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
                if (!(responsedMessage.getData() instanceof Integer)) {
                    return;
                }
                Object data = responsedMessage.getData();
                if (data != null) {
                    if (!this.a.h.e(((Integer) data).intValue())) {
                        return;
                    }
                    VideoPlayView videoPlayView = this.a.f;
                    if (videoPlayView != null) {
                        videoPlayView.U();
                    }
                    VideoPlayView videoPlayView2 = this.a.f;
                    if (videoPlayView2 != null) {
                        videoPlayView2.j0(this.a.isPrimary());
                    }
                    VideoPlayView videoPlayView3 = this.a.f;
                    if (videoPlayView3 != null) {
                        videoPlayView3.a0(this.a.D);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
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
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedIcon)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    RedIcon redIcon = (RedIcon) data;
                    List<ThreadInfo> list = redIcon.thread_list;
                    int i = 0;
                    if (list != null && !list.isEmpty()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        ThreadData threadData = new ThreadData();
                        threadData.parserProtobuf(redIcon.thread_list.get(0));
                        VideoItemData videoItemData = new VideoItemData();
                        videoItemData.buildWithThreadData(threadData);
                        VideoItemModel videoItemModel = new VideoItemModel(videoItemData, 1);
                        ww9 ww9Var = this.a.h;
                        VideoPlayView videoPlayView = this.a.f;
                        if (videoPlayView != null) {
                            i = videoPlayView.n;
                        }
                        if (ww9Var.u(videoItemModel, i)) {
                            VideoPlayActivityStatic.a(redIcon);
                            TbSingleton.getInstance().setVideoChannelRecommendRedIcon(null);
                            VideoPlayView videoPlayView2 = this.a.f;
                            if (videoPlayView2 != null) {
                                videoPlayView2.U();
                            }
                            VideoPlayView videoPlayView3 = this.a.f;
                            if (videoPlayView3 != null) {
                                videoPlayView3.j0(this.a.isPrimary());
                            }
                            VideoPlayView videoPlayView4 = this.a.f;
                            if (videoPlayView4 != null) {
                                videoPlayView4.a0(this.a.D);
                                return;
                            }
                            return;
                        }
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
                if (!(responsedMessage.getData() instanceof JSONObject)) {
                    return;
                }
                Object data = responsedMessage.getData();
                if (data != null) {
                    String optString = ((JSONObject) data).optString("tid");
                    if (optString != null) {
                        if (!this.a.h.f(optString)) {
                            return;
                        }
                        VideoPlayView videoPlayView = this.a.f;
                        if (videoPlayView != null) {
                            videoPlayView.U();
                        }
                        VideoPlayView videoPlayView2 = this.a.f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.j0(this.a.isPrimary());
                        }
                        VideoPlayView videoPlayView3 = this.a.f;
                        if (videoPlayView3 != null) {
                            videoPlayView3.a0(this.a.D);
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

    /* loaded from: classes6.dex */
    public static final class o implements dk7.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        @Override // com.baidu.tieba.dk7.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

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

        @Override // com.baidu.tieba.dk7.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, str, i) != null) || !dk7.m().v("6061002332-203360688") || this.a.f == null) {
                return;
            }
            ww9 ww9Var = this.a.h;
            VideoPlayView videoPlayView = this.a.f;
            Intrinsics.checkNotNull(videoPlayView);
            ww9Var.a(videoPlayView.n);
            VideoPlayView videoPlayView2 = this.a.f;
            if (videoPlayView2 != null) {
                videoPlayView2.U();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class p implements dk7.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        @Override // com.baidu.tieba.dk7.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

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

        @Override // com.baidu.tieba.dk7.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, str, i) != null) || !dk7.m().v(dk7.s()) || this.a.f == null) {
                return;
            }
            ww9 ww9Var = this.a.h;
            VideoPlayView videoPlayView = this.a.f;
            Intrinsics.checkNotNull(videoPlayView);
            ww9Var.a(videoPlayView.n);
            VideoPlayView videoPlayView2 = this.a.f;
            if (videoPlayView2 != null) {
                videoPlayView2.U();
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
                if ((!list.isEmpty()) && !this.a.h.v() && this.a.f != null) {
                    this.a.h.b(list);
                    VideoPlayView videoPlayView = this.a.f;
                    Intrinsics.checkNotNull(videoPlayView);
                    videoPlayView.U();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class r implements VideoPlayView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoVerticalPageFragment a;

        @Override // com.baidu.tieba.videoplay.VideoPlayView.h
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

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
                statisticItem.param("tid", this.a.W1(Integer.valueOf(i)));
                TiebaStatic.log(statisticItem);
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && VideoVerticalPageFragment.X1(this.a, null, 1, null) != 0) {
                VideoVerticalPageFragment videoVerticalPageFragment = this.a;
                videoVerticalPageFragment.u = Long.valueOf(VideoVerticalPageFragment.X1(videoVerticalPageFragment, null, 1, null));
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
        this.a = bdUniqueId;
        this.b = kVar;
        this.c = i2;
        this.d = i3;
        this.h = new ww9();
        this.n = true;
        this.E = 1;
        this.F = aq4.w().C();
        this.G = new VideoPlayFragment.GoPbCommentFloatListener(new SimpleMessageListener.b() { // from class: com.baidu.tieba.ix9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tbadk.util.SimpleMessageListener.b
            public final void call(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    VideoVerticalPageFragment.Z1(VideoVerticalPageFragment.this, (Void) obj);
                }
            }
        });
        this.K = new b(this);
        this.L = new m(this);
        this.N = new k(this);
        this.O = new n(this);
        this.P = new j(this);
        this.Q = new l(this);
        this.R = new BdSwipeRefreshLayout.k() { // from class: com.baidu.tieba.lx9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
            public final void a(int i6, int i7, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z)}) == null) {
                    VideoVerticalPageFragment.C2(VideoVerticalPageFragment.this, i6, i7, z);
                }
            }
        };
        this.S = new VideoPlayView.k() { // from class: com.baidu.tieba.rx9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.videoplay.VideoPlayView.k
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    VideoVerticalPageFragment.M2(VideoVerticalPageFragment.this);
                }
            }
        };
        this.T = new i(this);
        this.U = new a(this);
    }

    public static final void C2(VideoVerticalPageFragment this$0, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{this$0, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z && this$0.p2() && this$0.getPageContext() != null && this$0.getPageContext().getPageActivity() != null && !this$0.j2() && !this$0.b2() && !this$0.a2() && !this$0.l2() && !this$0.g2() && !this$0.d2() && !this$0.m2() && !this$0.i2() && !this$0.h2() && !this$0.c2() && !this$0.f2() && !this$0.e2()) {
                ii.Q(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0d53));
            }
        }
    }

    public /* synthetic */ VideoVerticalPageFragment(BdUniqueId bdUniqueId, BdSwipeRefreshLayout.k kVar, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : bdUniqueId, (i4 & 2) != 0 ? null : kVar, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    public static final void A2(VideoVerticalPageFragment this$0, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, list) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(list, "list");
            if ((!list.isEmpty()) && !this$0.h.v() && this$0.f != null) {
                this$0.h.b(list);
                VideoPlayView videoPlayView = this$0.f;
                Intrinsics.checkNotNull(videoPlayView);
                videoPlayView.U();
            }
        }
    }

    public final void J2(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        UserItemData userItemData;
        UserItemData userItemData2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, videoItemData, list) == null) {
            VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list, 0);
            if (videoItemData != null && (userItemData = videoItemData.author_info) != null && videoItemData2 != null && (userItemData2 = videoItemData2.author_info) != null && (str = userItemData2.user_id) != null && Intrinsics.areEqual(str, userItemData.user_id)) {
                videoItemData2.author_info.is_follow = videoItemData.author_info.is_follow;
            }
        }
    }

    public final void K2(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        ThreadData threadData;
        SparseArray<String> sparseArray;
        SparseArray<String> sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoItemData, list) == null) {
            VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list, 0);
            if (videoItemData != null) {
                List<PbContent> list2 = null;
                if (videoItemData2 != null) {
                    threadData = videoItemData2.threadData;
                } else {
                    threadData = null;
                }
                videoItemData.threadData = threadData;
                if (videoItemData.feedBackReasonMap == null) {
                    if (videoItemData2 != null) {
                        sparseArray = videoItemData2.feedBackReasonMap;
                    } else {
                        sparseArray = null;
                    }
                    videoItemData.feedBackReasonMap = sparseArray;
                    if (videoItemData2 != null) {
                        sparseArray2 = videoItemData2.feedBackExtraMap;
                    } else {
                        sparseArray2 = null;
                    }
                    videoItemData.feedBackExtraMap = sparseArray2;
                }
                if (videoItemData2 != null) {
                    list2 = videoItemData2.mRichAbstractList;
                }
                videoItemData.mRichAbstractList = list2;
            }
        }
    }

    public final void E2(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && (view2 = this.e) != null) {
            Intrinsics.checkNotNull(view2);
            int paddingLeft = view2.getPaddingLeft();
            View view3 = this.e;
            Intrinsics.checkNotNull(view3);
            int paddingTop = view3.getPaddingTop();
            View view4 = this.e;
            Intrinsics.checkNotNull(view4);
            view2.setPadding(paddingLeft, paddingTop, view4.getPaddingRight(), i2);
        }
    }

    public final void F2(jw5.b bVar) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && (videoPlayView = this.f) != null) {
            videoPlayView.c0(bVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.V(i2);
            }
            if (!UbsABTestHelper.isFeedVideoImmersionTransition() || (getActivity() instanceof VideoRecommentPlayActivity)) {
                SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z && this.d == 6) {
                L2();
            }
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.a0(z);
            }
            this.D = z;
        }
    }

    public static final void H2(VideoVerticalPageFragment this$0) {
        VideoPlayModel videoPlayModel;
        FrsVideoTabModel frsVideoTabModel;
        VideoChannelModel videoChannelModel;
        VideoHotTopicModel videoHotTopicModel;
        VideoPersonalModel videoPersonalModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.n) {
                if (this$0.q2()) {
                    Long l2 = this$0.h.l();
                    ww9 ww9Var = this$0.h;
                    VideoPlayView videoPlayView = this$0.f;
                    Intrinsics.checkNotNull(videoPlayView);
                    UserItemData i2 = ww9Var.i(videoPlayView.n);
                    if (l2 != null && i2 != null && (videoPersonalModel = this$0.z) != null) {
                        videoPersonalModel.W(l2, i2);
                    }
                } else if (this$0.o2()) {
                    Long l3 = this$0.h.l();
                    if (l3 != null && (videoHotTopicModel = this$0.A) != null) {
                        videoHotTopicModel.V(l3);
                    }
                } else {
                    int i3 = this$0.d;
                    if (i3 != 1 && i3 != 2) {
                        if (i3 != 7 && i3 != 20) {
                            VideoChannelModel videoChannelModel2 = this$0.y;
                            if (videoChannelModel2 != null) {
                                videoChannelModel2.setFrom(this$0.m);
                            }
                            if (!this$0.h.x() && (videoChannelModel = this$0.y) != null) {
                                videoChannelModel.b();
                                return;
                            }
                            return;
                        } else if (!this$0.h.x() && (frsVideoTabModel = this$0.B) != null) {
                            frsVideoTabModel.b();
                            return;
                        } else {
                            return;
                        }
                    }
                    VideoPlayModel videoPlayModel2 = this$0.x;
                    if (videoPlayModel2 != null) {
                        videoPlayModel2.setFrom(this$0.m);
                    }
                    if (!this$0.h.x() && (videoPlayModel = this$0.x) != null) {
                        videoPlayModel.c0(this$0.h.s(0));
                    }
                }
            }
        }
    }

    public static final void M2(VideoVerticalPageFragment this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.p2() && this$0.getPageContext() != null && this$0.getPageContext().getPageActivity() != null && !this$0.j2() && !this$0.b2() && !this$0.a2() && !this$0.l2() && !this$0.g2() && !this$0.d2() && !this$0.m2() && !this$0.i2() && !this$0.h2() && !this$0.c2() && !this$0.f2() && !this$0.e2()) {
                ii.Q(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0d53));
            }
            if (this$0.n2()) {
                VideoPlayView videoPlayView = this$0.f;
                boolean z = true;
                if (((videoPlayView == null || !videoPlayView.P()) ? false : false) && this$0.getPageContext() != null && this$0.getPageContext().getPageActivity() != null && !this$0.e2()) {
                    ii.Q(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0d55));
                }
            }
        }
    }

    public static final void Z1(VideoVerticalPageFragment this$0, Void r5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, this$0, r5) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setInterceptStimeStat(true);
        }
    }

    public static final void w2(VideoVerticalPageFragment this$0, Unit unit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, this$0, unit) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.k2()) {
                this$0.u2(false, false, null);
            } else if (this$0.o2()) {
                this$0.v2();
            }
        }
    }

    public static final void x2(VideoVerticalPageFragment this$0, Pair pair) {
        boolean booleanValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, this$0, pair) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (pair == null) {
                return;
            }
            Boolean bool = (Boolean) pair.first;
            if (bool == null) {
                booleanValue = false;
            } else {
                booleanValue = bool.booleanValue();
            }
            this$0.u2(true, booleanValue, (String) pair.second);
        }
    }

    @Override // com.baidu.tieba.tx9
    public void m(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048606, this, i2, i3, intent) == null) && (videoPlayView = this.f) != null) {
            videoPlayView.I(i2, i3, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                m(i2, i3, intent);
            }
        }
    }

    public static /* synthetic */ long X1(VideoVerticalPageFragment videoVerticalPageFragment, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        return videoVerticalPageFragment.W1(num);
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getPageContext() != null && getUniqueId() != null && this.r != null) {
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = this.r;
            Intrinsics.checkNotNull(personalPageParams);
            VideoPersonalModel videoPersonalModel = new VideoPersonalModel(pageContext, personalPageParams);
            this.z = videoPersonalModel;
            if (videoPersonalModel != null) {
                videoPersonalModel.X(new q(this));
            }
        }
    }

    public final void D2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_JUMP_YY_LIVE_IN_VIDEO_LIST, TbConfig.SERVER_ADDRESS + TbConfig.URL_JUMP_YY_LIVE_IN_VIDEO_LIST);
            tbHttpMessageTask.setResponsedClass(JumpYYLiveHttpResponseMessage.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void z2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && getPageContext() != null && getUniqueId() != null && this.s != null) {
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            VideoHotTopicParams videoHotTopicParams = this.s;
            Intrinsics.checkNotNull(videoHotTopicParams);
            VideoHotTopicModel videoHotTopicModel = new VideoHotTopicModel(pageContext, videoHotTopicParams);
            this.A = videoHotTopicModel;
            if (videoHotTopicModel != null) {
                videoHotTopicModel.W(new VideoHotTopicModel.b() { // from class: com.baidu.tieba.hx9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.videoplay.model.VideoHotTopicModel.b
                    public final void a(List list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                            VideoVerticalPageFragment.A2(VideoVerticalPageFragment.this, list);
                        }
                    }
                });
            }
        }
    }

    public final void G2() {
        VideoPlayView videoPlayView;
        VideoPlayView videoPlayView2;
        VideoPlayView videoPlayView3;
        VideoPlayView videoPlayView4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdUniqueId bdUniqueId = this.a;
            Activity pageActivity = getPageContext().getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView5 = new VideoPlayView(bdUniqueId, (FragmentActivity) pageActivity, this, this.m, getUniqueId(), 1, this.d, t2(), this.J);
                this.f = videoPlayView5;
                if (videoPlayView5 != null) {
                    videoPlayView5.b0(new r(this));
                }
                if (this.d == 3 && (videoPlayView4 = this.f) != null) {
                    videoPlayView4.m0("from_suggest_sub_fragment");
                }
                VideoPlayView videoPlayView6 = this.f;
                if (videoPlayView6 != null) {
                    BdSwipeRefreshLayout.k kVar = this.b;
                    if (kVar == null) {
                        kVar = this.R;
                    }
                    videoPlayView6.k0(kVar);
                }
                VideoPlayView videoPlayView7 = this.f;
                if (videoPlayView7 != null) {
                    videoPlayView7.Z(this.S);
                }
                if (this.c != 1 && (videoPlayView3 = this.f) != null) {
                    videoPlayView3.c0(this.K);
                }
                int i2 = this.d;
                if ((i2 == 7 || i2 == 20) && (videoPlayView = this.f) != null) {
                    videoPlayView.g0(new s(this));
                }
                ux9 ux9Var = this.M;
                if (ux9Var != null) {
                    ux9Var.o(this.f);
                }
                VideoPlayView videoPlayView8 = this.f;
                if (videoPlayView8 != null) {
                    videoPlayView8.h0(new VideoPlayView.i() { // from class: com.baidu.tieba.px9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.videoplay.VideoPlayView.i
                        public final void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                VideoVerticalPageFragment.H2(VideoVerticalPageFragment.this);
                            }
                        }
                    });
                }
                VideoPlayView videoPlayView9 = this.f;
                if (videoPlayView9 != null) {
                    videoPlayView9.p0(this.h, this.i, this.k);
                }
                VideoPlayView videoPlayView10 = this.f;
                if (videoPlayView10 != null) {
                    videoPlayView10.i0(this.l);
                }
                VideoPlayView videoPlayView11 = this.f;
                if (videoPlayView11 != null) {
                    videoPlayView11.f0(this.v);
                }
                VideoPlayView videoPlayView12 = this.f;
                if (videoPlayView12 != null) {
                    videoPlayView12.n0(this.c);
                }
                if (p2() && (videoPlayView2 = this.f) != null) {
                    videoPlayView2.l0(this.j, false);
                }
                VideoPlayView videoPlayView13 = this.f;
                if (videoPlayView13 != null) {
                    videoPlayView13.e0(this.M);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    @Override // com.baidu.tieba.tx9
    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
                        ww9 ww9Var = this.h;
                        VideoPlayView videoPlayView5 = this.f;
                        Intrinsics.checkNotNull(videoPlayView5);
                        VideoItemData s2 = ww9Var.s(videoPlayView5.n);
                        if (s2 != null && !StringUtils.isNull(s2.thread_id)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, s2.thread_id));
                        }
                    }
                }
            }
        }
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
                videoPlayView.W();
            }
            if (isPrimary()) {
                I2();
            }
            if (getActivity() instanceof FrsVideoTabPlayActivity) {
                T1();
            }
            VideoPersonalModel videoPersonalModel = this.z;
            if (videoPersonalModel != null) {
                videoPersonalModel.onDestroy();
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
                if (videoPlayView != null) {
                    videoPlayView.a0(this.D);
                }
            }
        }
    }

    public final void v2() {
        VideoHotTopicParams videoHotTopicParams;
        VideoHotTopicModel videoHotTopicModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048627, this) != null) || (videoHotTopicParams = this.s) == null || (videoHotTopicModel = this.A) == null) {
            return;
        }
        ww9 ww9Var = this.h;
        VideoPlayView videoPlayView = this.f;
        Intrinsics.checkNotNull(videoPlayView);
        String r2 = ww9Var.r(videoPlayView.n);
        if (r2 == null) {
            return;
        }
        VideoNotifyPersonalPageData videoNotifyPersonalPageData = new VideoNotifyPersonalPageData();
        videoNotifyPersonalPageData.setCurrentThreadId(r2);
        videoNotifyPersonalPageData.setFlutterPageId(videoHotTopicParams.getFlutterPageId());
        videoNotifyPersonalPageData.setVideoHotTopicDataResMapList(videoHotTopicModel.U());
        videoNotifyPersonalPageData.setCurrentPn(videoHotTopicParams.getCurrentPn());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921623, videoNotifyPersonalPageData));
    }

    public final void I2() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (getActivity() instanceof VideoPlayActivity) {
                str = "1";
            } else {
                str = "3";
            }
            xw9.g(str);
        }
    }

    public final void L2() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (relativeLayout = this.g) != null) {
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setVisibility(8);
        }
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            xw9.f("5");
        }
    }

    public final Long U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.t;
        }
        return (Long) invokeV.objValue;
    }

    public final Long V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.u;
        }
        return (Long) invokeV.objValue;
    }

    public final jw5.b Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.K;
        }
        return (jw5.b) invokeV.objValue;
    }

    public final boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.d == 11) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.d == 10) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.d == 16) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.d == 18) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.d == 20) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.d == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.d == 13) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.ll5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.d == 3) {
                return "a088";
            }
            return "a023";
        }
        return (String) invokeV.objValue;
    }

    public final boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.d == 15) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.d == 14) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.d == 9) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tx9
    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            VideoItemData s2 = this.h.s(this.i);
            if (s2 == null || TextUtils.isEmpty(s2.thread_id)) {
                return 0L;
            }
            return gg.g(s2.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    public final boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.d == 6) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.d == 12) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.d == 19) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.d == 7) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.d == 8) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onDestroyView();
            dk7.m().d("6061002332-203360688");
            dk7.m().c(dk7.s());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.X();
            }
        }
    }

    @Override // com.baidu.tieba.tx9
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null && videoPlayView.J()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (!s2() && !q2() && !o2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (k2() && !t2()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (k2() && t2()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.d == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = this.r;
            if (personalPageParams != null) {
                return personalPageParams.isShareThread();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final long W1(Integer num) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, num)) == null) {
            ww9 ww9Var = this.h;
            if (num != null) {
                i2 = num.intValue();
            } else {
                VideoPlayView videoPlayView = this.f;
                Intrinsics.checkNotNull(videoPlayView);
                i2 = videoPlayView.n;
            }
            VideoItemData s2 = ww9Var.s(i2);
            if (s2 == null || TextUtils.isEmpty(s2.thread_id)) {
                return 0L;
            }
            return gg.g(s2.thread_id, 0L);
        }
        return invokeL.longValue;
    }

    /* JADX WARN: Type inference failed for: r1v124, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v126, types: [java.util.List<com.baidu.tieba.video.VideoItemData>, T] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.util.ArrayList] */
    public final void initData() {
        Serializable serializable;
        String str;
        int i2;
        int i3;
        Rect rect;
        Rect rect2;
        Rect rect3;
        Rect rect4;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        Rect rect5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.h.c();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Bundle arguments = getArguments();
            String str6 = null;
            if (arguments != null) {
                serializable = arguments.getSerializable("video_list");
            } else {
                serializable = null;
            }
            objectRef.element = (ArrayList) serializable;
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("forum_id");
            } else {
                str = null;
            }
            this.J = str;
            if (objectRef.element == 0) {
                int i4 = this.d;
                if (i4 != 7 && i4 != 20) {
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
            if (getArguments() != null) {
                i2 = requireArguments().getInt("video_index", 0);
            } else {
                i2 = 0;
            }
            this.i = i2;
            if (getArguments() != null) {
                i3 = requireArguments().getInt("video_show_index", 0);
            } else {
                i3 = 0;
            }
            this.j = i3;
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                rect = (Rect) arguments3.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
            } else {
                rect = null;
            }
            if (rect != null) {
                Bundle arguments4 = getArguments();
                if (arguments4 != null) {
                    rect5 = (Rect) arguments4.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
                } else {
                    rect5 = null;
                }
                this.k = rect5;
            } else {
                Bundle arguments5 = getArguments();
                if (arguments5 != null) {
                    rect2 = (Rect) arguments5.getParcelable("video_cover_rect");
                } else {
                    rect2 = null;
                }
                if (rect2 != null) {
                    Bundle arguments6 = getArguments();
                    if (arguments6 != null) {
                        rect4 = (Rect) arguments6.getParcelable("video_cover_rect");
                    } else {
                        rect4 = null;
                    }
                    this.k = rect4;
                } else {
                    Bundle arguments7 = getArguments();
                    if (arguments7 != null) {
                        rect3 = (Rect) arguments7.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
                    } else {
                        rect3 = null;
                    }
                    this.k = rect3;
                }
            }
            Bundle arguments8 = getArguments();
            if (arguments8 != null) {
                str2 = arguments8.getString("page_from");
            } else {
                str2 = null;
            }
            this.l = str2;
            Bundle arguments9 = getArguments();
            if (arguments9 != null) {
                str3 = arguments9.getString("from");
            } else {
                str3 = null;
            }
            this.m = str3;
            Bundle arguments10 = getArguments();
            if (arguments10 != null) {
                str4 = arguments10.getString("st_type");
            } else {
                str4 = null;
            }
            this.o = str4;
            Bundle arguments11 = getArguments();
            if (arguments11 != null) {
                str5 = arguments11.getString("yuelaou_locate");
            } else {
                str5 = null;
            }
            this.p = str5;
            if (getArguments() != null) {
                z = requireArguments().getBoolean(VideoPlayActivityConfig.PARAM_IS_VERTAIL, true);
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
            if (this.h.v() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.h.z(VideoPlayActivityConfig.bigDataList);
            }
            this.h.C(getUniqueId());
            if (this.d == 3) {
                E2(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.h.D("a088");
            } else {
                this.h.D("a023");
            }
            int i5 = this.d;
            if (i5 != 1 && i5 != 2) {
                if (p2()) {
                    if (this.j >= this.h.k()) {
                        this.j = 0;
                    }
                    if (q2()) {
                        B2();
                    }
                    if (o2()) {
                        z2();
                    }
                } else if (!j2() && !b2() && !a2() && !l2() && !g2() && !d2() && !m2() && !i2() && !h2() && !c2() && !f2() && !e2()) {
                    int i6 = this.d;
                    if (i6 != 7 && i6 != 20) {
                        VideoChannelModel videoChannelModel = new VideoChannelModel(getPageContext(), getUniqueId());
                        this.y = videoChannelModel;
                        if (videoChannelModel != null) {
                            videoChannelModel.setFrom(this.m);
                        }
                        VideoChannelModel videoChannelModel2 = this.y;
                        if (videoChannelModel2 != null) {
                            videoChannelModel2.Z(this.c);
                        }
                        VideoChannelModel videoChannelModel3 = this.y;
                        if (videoChannelModel3 != null) {
                            videoChannelModel3.a0(new g(this));
                        }
                        if (this.h.s(0) != null) {
                            VideoItemData s2 = this.h.s(0);
                            if (s2 != null) {
                                str6 = s2.thread_id;
                            }
                            this.v = str6;
                        }
                        VideoChannelModel videoChannelModel4 = this.y;
                        if (videoChannelModel4 != null) {
                            videoChannelModel4.setFrom(this.m);
                        }
                        if (!BdNetTypeUtil.isNetWorkAvailable() && !isPrimary()) {
                            return;
                        }
                        if (r2()) {
                            VideoChannelModel videoChannelModel5 = this.y;
                            if (videoChannelModel5 != null) {
                                videoChannelModel5.b();
                            }
                        } else {
                            VideoChannelModel videoChannelModel6 = this.y;
                            if (videoChannelModel6 != null) {
                                videoChannelModel6.Y();
                            }
                        }
                    } else if (getPageContext() != null && getUniqueId() != null) {
                        FrsVideoTabModel frsVideoTabModel = new FrsVideoTabModel(getPageContext(), getUniqueId());
                        this.B = frsVideoTabModel;
                        if (frsVideoTabModel != null) {
                            frsVideoTabModel.setFrom(this.m);
                        }
                        FrsVideoTabModel frsVideoTabModel2 = this.B;
                        if (frsVideoTabModel2 != null) {
                            frsVideoTabModel2.S(this.c);
                        }
                        FrsVideoTabModel frsVideoTabModel3 = this.B;
                        if (frsVideoTabModel3 != null) {
                            frsVideoTabModel3.T(new f(objectRef, this));
                        }
                    } else {
                        return;
                    }
                } else if (this.j >= this.h.k()) {
                    this.j = 0;
                }
            } else {
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest()) {
                    if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                        dk7.m().z(getActivity(), new c(this), this.h.o());
                    }
                    if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                        dk7.m().y(getActivity(), new d(this), this.h.o());
                    }
                }
                VideoPlayModel videoPlayModel = new VideoPlayModel(getPageContext(), getUniqueId());
                this.x = videoPlayModel;
                if (videoPlayModel != null) {
                    videoPlayModel.setFrom(this.m);
                }
                VideoPlayModel videoPlayModel2 = this.x;
                if (videoPlayModel2 != null) {
                    videoPlayModel2.e0(this.c);
                }
                VideoPlayModel videoPlayModel3 = this.x;
                if (videoPlayModel3 != null) {
                    videoPlayModel3.f0(new e(this));
                }
                if (this.h.s(0) != null) {
                    VideoItemData s3 = this.h.s(0);
                    if (s3 != null) {
                        str6 = s3.thread_id;
                    }
                    this.v = str6;
                }
                VideoPlayModel videoPlayModel4 = this.x;
                if (videoPlayModel4 != null) {
                    videoPlayModel4.setFrom(this.m);
                }
                VideoPlayModel videoPlayModel5 = this.x;
                if (videoPlayModel5 != null) {
                    videoPlayModel5.d0(this.h.s(0), this.o, this.p, this.q);
                }
            }
            this.M = new ux9(this.h.h(), getPageContext());
            D2();
            if (this.w == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getPageContext().getUniqueId());
                this.w = pollingModel;
                if (pollingModel != null) {
                    pollingModel.K0(new h(this));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.H = new OnActivityFinishListener<>(getPageContext(), new SimpleMessageListener.b() { // from class: com.baidu.tieba.ox9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.util.SimpleMessageListener.b
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        VideoVerticalPageFragment.w2(VideoVerticalPageFragment.this, (Unit) obj);
                    }
                }
            });
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            this.I = new OnDeleteSelfPostListener(pageContext, new SimpleMessageListener.b() { // from class: com.baidu.tieba.qx9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.util.SimpleMessageListener.b
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        VideoVerticalPageFragment.x2(VideoVerticalPageFragment.this, (Pair) obj);
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
            G2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        RelativeLayout relativeLayout;
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
            this.e = inflater.inflate(R.layout.obfuscated_res_0x7f0d0955, viewGroup, false);
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !(getActivity() instanceof VideoRecommentPlayActivity) && (view2 = this.e) != null) {
                view2.setBackgroundColor(0);
            }
            View view3 = this.e;
            if (view3 != null) {
                relativeLayout = (RelativeLayout) view3.findViewById(R.id.obfuscated_res_0x7f0928ec);
            } else {
                relativeLayout = null;
            }
            this.g = relativeLayout;
            if (relativeLayout != null) {
                relativeLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.jx9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view4, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view4, motionEvent)) == null) ? VideoVerticalPageFragment.y2(view4, motionEvent) : invokeLL.booleanValue;
                    }
                });
            }
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }

    public final void u2(boolean z, boolean z2, String str) {
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        VideoPersonalModel videoPersonalModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048626, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) != null) || (personalPageParams = this.r) == null || (videoPersonalModel = this.z) == null) {
            return;
        }
        ww9 ww9Var = this.h;
        VideoPlayView videoPlayView = this.f;
        Intrinsics.checkNotNull(videoPlayView);
        String r2 = ww9Var.r(videoPlayView.n);
        if (r2 == null) {
            return;
        }
        VideoNotifyPersonalPageData videoNotifyPersonalPageData = new VideoNotifyPersonalPageData();
        videoNotifyPersonalPageData.setPersonalPageUid(personalPageParams.getPersonalPageUid());
        videoNotifyPersonalPageData.setCurrentThreadId(r2);
        videoNotifyPersonalPageData.setFlutterPageId(personalPageParams.getFlutterPageId());
        videoNotifyPersonalPageData.setUserPostDataResMapList(videoPersonalModel.V());
        videoNotifyPersonalPageData.setCurrentPn(personalPageParams.getCurrentPn());
        videoNotifyPersonalPageData.setIsDeleteOperate(z);
        videoNotifyPersonalPageData.setDeleteStatus(z2);
        videoNotifyPersonalPageData.setDeleteStatusMessage(str);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921623, videoNotifyPersonalPageData));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onPrimary();
            if (!this.D) {
                I2();
            }
            if (getActivity() instanceof FrsVideoTabPlayActivity) {
                T1();
            }
            if (this.D && this.d == 3) {
                sw9.a(1);
            }
            if (isPrimary()) {
                ti5.b().c();
                ti5.b().l(true);
            }
            this.t = Long.valueOf(k());
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.j0(isPrimary());
            }
            if (!this.C && isPrimary() && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.d == 3) {
                this.C = true;
                if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                    dk7.m().z(getActivity(), new o(this), this.h.o());
                } else if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                    dk7.m().y(getActivity(), new p(this), this.h.o());
                }
            }
        }
    }
}
