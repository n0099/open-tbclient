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
import com.baidu.tieba.videoplay.VideoPlayActivity;
import com.baidu.tieba.videoplay.VideoPlayActivityStatic;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
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
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VideoRedIcon.RedIcon;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u009f\u0001B7\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\f\b\u0002\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u0001\u0012\b\b\u0002\u0010~\u001a\u00020\f\u0012\b\b\u0002\u0010]\u001a\u00020\f¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u0016J\u000f\u0010\u001c\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001d\u0010\u0016J\u000f\u0010\u001e\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001e\u0010\u0016J\u000f\u0010\u001f\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001f\u0010\u0016J)\u0010#\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J)\u0010)\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b)\u0010\u0013J\u0017\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\fH\u0016¢\u0006\u0004\b+\u0010,J-\u00102\u001a\u0004\u0018\u0001012\u0006\u0010.\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010/2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0011H\u0016¢\u0006\u0004\b4\u0010\u0018J\u000f\u00105\u001a\u00020\u0011H\u0016¢\u0006\u0004\b5\u0010\u0018J\u000f\u00106\u001a\u00020\u0011H\u0016¢\u0006\u0004\b6\u0010\u0018J\u000f\u00107\u001a\u00020\u0011H\u0016¢\u0006\u0004\b7\u0010\u0018J\u000f\u00108\u001a\u00020\u0011H\u0016¢\u0006\u0004\b8\u0010\u0018J\u000f\u00109\u001a\u00020\u0011H\u0002¢\u0006\u0004\b9\u0010\u0018J\u0017\u0010;\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\fH\u0002¢\u0006\u0004\b;\u0010,J\u0017\u0010=\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u0014H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\u00112\b\u0010?\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0011H\u0002¢\u0006\u0004\bB\u0010\u0018J\u000f\u0010C\u001a\u00020\u0011H\u0002¢\u0006\u0004\bC\u0010\u0018J%\u0010H\u001a\u00020\u00112\u0006\u0010E\u001a\u00020D2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020D0FH\u0002¢\u0006\u0004\bH\u0010IJ'\u0010J\u001a\u00020\u00112\b\u0010E\u001a\u0004\u0018\u00010D2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020D0FH\u0002¢\u0006\u0004\bJ\u0010IJ\u000f\u0010K\u001a\u00020\u0011H\u0002¢\u0006\u0004\bK\u0010\u0018R\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010<\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010NR\u0016\u0010]\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010NR\u0018\u0010`\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010aR\u0016\u0010c\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010XR\u0018\u0010d\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010NR\u0018\u0010i\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010aR\u0016\u0010j\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010NR\u0018\u0010l\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010n\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010p\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010aR\u0016\u0010q\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010NR\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010^R\u0018\u0010w\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010z\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010|\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010^R\u0016\u0010}\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010XR\u0016\u0010~\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010^R#\u0010\u0080\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R*\u0010\u008b\u0001\u001a\u00030\u0088\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008a\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R*\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001¨\u0006 \u0001"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment;", "Lc/a/r0/z3/f/a;", "Lcom/baidu/tbadk/core/BaseFragment;", "", "getCurrentPageKey", "()Ljava/lang/String;", "", "getMissionTid", "()J", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "getVEventListener", "()Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "", "requestCode", MiPushCommandMessage.KEY_RESULT_CODE, "Landroid/content/Intent;", "data", "", "handleActivityResult", "(IILandroid/content/Intent;)V", "", "handleBackPress", "()Z", "handleIndexMessage", "()V", "initData", "isFromPersonalPage", "isPersonalPlay", "isPersonalSharePlay", "isRecommendPlay", "isRecommendPlayOrPersonalPlay", "isShareThread", "isDelete", "isDeleteSucceed", "deleteErrorMessage", "notifyPersonalPage", "(ZZLjava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/os/Bundle;)V", "onActivityResult", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "processVideoPersonalModel", "height", "setEmptyHeight", "isVisibleToUser", "setUserVisibleHint", "(Z)V", "listener", "setVideoPlayViewEventListener", "(Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;)V", "showData", "stepStat", "Lcom/baidu/tieba/video/VideoItemData;", "originalData", "", "newList", "syncFirstVideoFollowState", "(Lcom/baidu/tieba/video/VideoItemData;Ljava/util/List;)V", "syncFirstVideoThreadData", "updateYoungsterMode", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "backGroundListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "eventListener", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "goPbCommentFloatListener", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "isVertail", "Z", "Lcom/baidu/adp/BdUniqueId;", "mActivityPageUniqueId", "Lcom/baidu/adp/BdUniqueId;", "mAdCloseListener", "mCurrentType", "I", "mFeedBackListener", "mFrom", "Ljava/lang/String;", "mFromPage", "mHasMore", "mLocate", "Lcom/baidu/tieba/videoplay/nad/AdVideoFlowDispatcher;", "mNAdDispatcher", "Lcom/baidu/tieba/videoplay/nad/AdVideoFlowDispatcher;", "mNetworkChangedMessageListener", "mObjId", "mRecommendTabInsertDataListener", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "mUEGFeedBackListener", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoChannelModel", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoIndex", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "mVideoPlayModel", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoShowIndex", "mVideoTabReqFunAd", "mainPageType", "Lcom/baidu/tbadk/util/OnActivityFinishListener;", "onActivityFinishListener", "Lcom/baidu/tbadk/util/OnActivityFinishListener;", "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "onDeleteSelfPostListener", "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$OnDeleteSelfPostListener;", "Lcom/baidu/tbadk/core/atomData/VideoRecommentPlayActivityConfig$PersonalPageParams;", "personalPageParams", "Lcom/baidu/tbadk/core/atomData/VideoRecommentPlayActivityConfig$PersonalPageParams;", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallbackFra", "getProgressViewCallbackFra", "()Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "setProgressViewCallbackFra", "(Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;)V", "Lcom/baidu/tieba/videoplay/model/VideoPersonalModel;", "videoPersonalModel", "Lcom/baidu/tieba/videoplay/model/VideoPersonalModel;", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "getViewPagerBottomScrollMoreCallback", "()Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "setViewPagerBottomScrollMoreCallback", "(Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;)V", "Landroid/widget/RelativeLayout;", "youngsterVerticalLayout", "Landroid/widget/RelativeLayout;", "<init>", "(Lcom/baidu/adp/BdUniqueId;Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;II)V", "OnDeleteSelfPostListener", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class VideoVerticalPageFragment extends BaseFragment implements c.a.r0.z3.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OnDeleteSelfPostListener A;
    public b.InterfaceC0664b B;
    public final CustomMessageListener C;
    public c.a.r0.z3.g.a D;
    public final CustomMessageListener E;
    public final CustomMessageListener F;
    public final CustomMessageListener G;
    public final CustomMessageListener H;
    public BdSwipeRefreshLayout.k I;
    public VideoPlayView.f J;
    public final CustomMessageListener K;
    public final BdUniqueId L;
    public final BdSwipeRefreshLayout.k M;
    public final int N;
    public final int O;

    /* renamed from: e  reason: collision with root package name */
    public View f58006e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayView f58007f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f58008g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.r0.z3.c.d f58009h;

    /* renamed from: i  reason: collision with root package name */
    public int f58010i;

    /* renamed from: j  reason: collision with root package name */
    public int f58011j;
    public Rect k;
    public String l;
    public String m;
    public boolean n;
    public String o;
    public String p;
    public boolean q;
    public VideoRecommentPlayActivityConfig.PersonalPageParams r;
    public String s;
    public VideoPlayModel t;
    public VideoChannelModel u;
    public VideoPersonalModel v;
    public boolean w;
    public boolean x;
    public final VideoPlayFragment.GoPbCommentFloatListener y;
    public OnActivityFinishListener<Unit> z;

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
        public final /* synthetic */ VideoVerticalPageFragment f58012a;

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
            this.f58012a = videoVerticalPageFragment;
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
                        if ((this.f58012a.x && z) || ((c.a.e.a.b.f().b() instanceof VideoPlayActivity) && (this.f58012a.getActivity() instanceof VideoPlayActivity))) {
                            this.f58012a.q();
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
        public final /* synthetic */ VideoVerticalPageFragment f58013e;

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
            this.f58013e = videoVerticalPageFragment;
        }

        @Override // c.a.q0.f1.q.b.InterfaceC0664b
        public void onViewClick() {
            VideoPlayView videoPlayView;
            b.InterfaceC0664b currentFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoPlayView = this.f58013e.f58007f) == null || (currentFragment = videoPlayView.getCurrentFragment()) == null) {
                return;
            }
            currentFragment.onViewClick();
        }

        @Override // c.a.q0.f1.q.b.InterfaceC0664b
        public void onViewDoubleClick(float f2, float f3) {
            VideoPlayView videoPlayView;
            b.InterfaceC0664b currentFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (videoPlayView = this.f58013e.f58007f) == null || (currentFragment = videoPlayView.getCurrentFragment()) == null) {
                return;
            }
            currentFragment.onViewDoubleClick(f2, f3);
        }

        @Override // c.a.q0.f1.q.b.InterfaceC0664b
        public void onViewDragToRight() {
            VideoPlayView videoPlayView;
            b.InterfaceC0664b currentFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (videoPlayView = this.f58013e.f58007f) == null || (currentFragment = videoPlayView.getCurrentFragment()) == null) {
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
        public final /* synthetic */ VideoVerticalPageFragment f58014a;

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
            this.f58014a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.util.SimpleMessageListener.b
        /* renamed from: a */
        public final void call(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                this.f58014a.setInterceptStimeStat(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58015a;

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
            this.f58015a = videoVerticalPageFragment;
        }

        @Override // c.a.r0.x0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && c.a.r0.x0.a.i().m("6061002332-203360688") && this.f58015a.f58007f != null) {
                c.a.r0.z3.c.d dVar = this.f58015a.f58009h;
                VideoPlayView videoPlayView = this.f58015a.f58007f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.currentSelectIndex);
                VideoPlayView videoPlayView2 = this.f58015a.f58007f;
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
        public final /* synthetic */ VideoVerticalPageFragment f58016a;

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
            this.f58016a = videoVerticalPageFragment;
        }

        @Override // c.a.r0.x0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && c.a.r0.x0.a.i().m("6061002410-390177882") && this.f58016a.f58007f != null) {
                c.a.r0.z3.c.d dVar = this.f58016a.f58009h;
                VideoPlayView videoPlayView = this.f58016a.f58007f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.currentSelectIndex);
                VideoPlayView videoPlayView2 = this.f58016a.f58007f;
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
        public final /* synthetic */ VideoVerticalPageFragment f58017a;

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
            this.f58017a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) {
                this.f58017a.n = z;
                if (ListUtils.isEmpty(list) || this.f58017a.f58009h.v()) {
                    return;
                }
                VideoVerticalPageFragment videoVerticalPageFragment = this.f58017a;
                VideoItemData s = videoVerticalPageFragment.f58009h.s(0);
                if (s == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(s, "dataController.getVideoData(0)!!");
                videoVerticalPageFragment.r(s, list);
                VideoVerticalPageFragment videoVerticalPageFragment2 = this.f58017a;
                videoVerticalPageFragment2.s(videoVerticalPageFragment2.f58009h.s(0), list);
                this.f58017a.f58009h.y(list);
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && c.a.q0.b.d.R() && c.a.r0.x0.a.i().m("6061002332-203360688") && this.f58017a.f58007f != null) {
                    c.a.r0.z3.c.d dVar = this.f58017a.f58009h;
                    VideoPlayView videoPlayView = this.f58017a.f58007f;
                    if (videoPlayView == null) {
                        Intrinsics.throwNpe();
                    }
                    dVar.a(videoPlayView.currentSelectIndex - 1);
                }
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && c.a.q0.b.d.S() && c.a.r0.x0.a.i().m("6061002410-390177882") && this.f58017a.f58007f != null) {
                    c.a.r0.z3.c.d dVar2 = this.f58017a.f58009h;
                    VideoPlayView videoPlayView2 = this.f58017a.f58007f;
                    if (videoPlayView2 == null) {
                        Intrinsics.throwNpe();
                    }
                    dVar2.a(videoPlayView2.currentSelectIndex - 1);
                }
                VideoPlayView videoPlayView3 = this.f58017a.f58007f;
                if (videoPlayView3 != null) {
                    videoPlayView3.notifyDataSetChanged();
                }
                VideoPlayView videoPlayView4 = this.f58017a.f58007f;
                if (videoPlayView4 != null) {
                    videoPlayView4.setSelectIndex(0, true);
                }
                VideoPlayView videoPlayView5 = this.f58017a.f58007f;
                if (videoPlayView5 != null) {
                    videoPlayView5.setPrimary(this.f58017a.isPrimary());
                }
                VideoPlayView videoPlayView6 = this.f58017a.f58007f;
                if (videoPlayView6 != null) {
                    videoPlayView6.setCurrentFragmentUserHint(this.f58017a.x);
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void b(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) {
                this.f58017a.n = z;
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                c.a.r0.z3.c.d dVar = this.f58017a.f58009h;
                if ((dVar != null ? Boolean.valueOf(dVar.v()) : null).booleanValue()) {
                    return;
                }
                this.f58017a.f58009h.b(list);
                if (this.f58017a.f58007f != null) {
                    c.a.r0.z3.c.d dVar2 = this.f58017a.f58009h;
                    VideoPlayView videoPlayView = this.f58017a.f58007f;
                    if (videoPlayView == null) {
                        Intrinsics.throwNpe();
                    }
                    dVar2.a(videoPlayView.currentSelectIndex);
                }
                VideoPlayView videoPlayView2 = this.f58017a.f58007f;
                if (videoPlayView2 != null) {
                    videoPlayView2.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class g implements VideoChannelModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58018a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
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
            this.f58018a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f58018a.f58009h.y(list);
            if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && (((c.a.q0.b.d.R() && c.a.r0.x0.a.i().m("6061002332-203360688")) || (c.a.q0.b.d.S() && c.a.r0.x0.a.i().m("6061002410-390177882"))) && this.f58018a.f58007f != null)) {
                c.a.r0.z3.c.d dVar = this.f58018a.f58009h;
                VideoPlayView videoPlayView = this.f58018a.f58007f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.currentSelectIndex);
            }
            VideoPlayView videoPlayView2 = this.f58018a.f58007f;
            if (videoPlayView2 != null) {
                videoPlayView2.notifyDataSetChanged();
            }
            VideoPlayView videoPlayView3 = this.f58018a.f58007f;
            if (videoPlayView3 != null) {
                videoPlayView3.setSelectIndex(0, true);
            }
            VideoPlayView videoPlayView4 = this.f58018a.f58007f;
            if (videoPlayView4 != null) {
                videoPlayView4.setPrimary(this.f58018a.isPrimary());
            }
            c.a.r0.z3.g.a aVar = this.f58018a.D;
            if (aVar != null) {
                aVar.i();
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void b(List<? extends VideoItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f58018a.f58009h.v()) {
                return;
            }
            this.f58018a.f58009h.b(list);
            if (this.f58018a.f58007f != null) {
                c.a.r0.z3.c.d dVar = this.f58018a.f58009h;
                VideoPlayView videoPlayView = this.f58018a.f58007f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.currentSelectIndex);
            }
            VideoPlayView videoPlayView2 = this.f58018a.f58007f;
            if (videoPlayView2 != null) {
                videoPlayView2.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58019a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(VideoVerticalPageFragment videoVerticalPageFragment, int i2) {
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
            this.f58019a = videoVerticalPageFragment;
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
                    c.a.r0.z3.g.a aVar = this.f58019a.D;
                    List<VideoItemModel> h2 = aVar != null ? aVar.h(str) : null;
                    if (h2 != null) {
                        if (!h2.isEmpty()) {
                            this.f58019a.f58009h.h().removeAll(h2);
                            VideoPlayView videoPlayView = this.f58019a.f58007f;
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
    public static final class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58020a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(VideoVerticalPageFragment videoVerticalPageFragment, int i2, boolean z) {
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
            this.f58020a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    if (this.f58020a.f58009h.e(((Integer) data).intValue())) {
                        VideoPlayView videoPlayView = this.f58020a.f58007f;
                        if (videoPlayView != null) {
                            videoPlayView.notifyDataSetChanged();
                        }
                        VideoPlayView videoPlayView2 = this.f58020a.f58007f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.setPrimary(this.f58020a.isPrimary());
                        }
                        VideoPlayView videoPlayView3 = this.f58020a.f58007f;
                        if (videoPlayView3 != null) {
                            videoPlayView3.setCurrentFragmentUserHint(this.f58020a.x);
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
    public static final class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58021a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(VideoVerticalPageFragment videoVerticalPageFragment, int i2) {
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
            this.f58021a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && c.a.e.e.p.j.z() && this.f58021a.f58009h.v()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921568));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58022a;

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
            this.f58022a = videoVerticalPageFragment;
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
                    c.a.r0.z3.c.d dVar = this.f58022a.f58009h;
                    VideoPlayView videoPlayView = this.f58022a.f58007f;
                    if (dVar.u(videoItemModel, videoPlayView != null ? videoPlayView.currentSelectIndex : 0)) {
                        VideoPlayActivityStatic.a(redIcon);
                        TbSingleton tbSingleton = TbSingleton.getInstance();
                        Intrinsics.checkExpressionValueIsNotNull(tbSingleton, "TbSingleton.getInstance()");
                        tbSingleton.setVideoChannelRecommendRedIcon(null);
                        VideoPlayView videoPlayView2 = this.f58022a.f58007f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.notifyDataSetChanged();
                        }
                        VideoPlayView videoPlayView3 = this.f58022a.f58007f;
                        if (videoPlayView3 != null) {
                            videoPlayView3.setPrimary(this.f58022a.isPrimary());
                        }
                        VideoPlayView videoPlayView4 = this.f58022a.f58007f;
                        if (videoPlayView4 != null) {
                            videoPlayView4.setCurrentFragmentUserHint(this.f58022a.x);
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
    public static final class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58023a;

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
            this.f58023a = videoVerticalPageFragment;
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
                        if (this.f58023a.f58009h.f(optString)) {
                            VideoPlayView videoPlayView = this.f58023a.f58007f;
                            if (videoPlayView != null) {
                                videoPlayView.notifyDataSetChanged();
                            }
                            VideoPlayView videoPlayView2 = this.f58023a.f58007f;
                            if (videoPlayView2 != null) {
                                videoPlayView2.setPrimary(this.f58023a.isPrimary());
                            }
                            VideoPlayView videoPlayView3 = this.f58023a.f58007f;
                            if (videoPlayView3 != null) {
                                videoPlayView3.setCurrentFragmentUserHint(this.f58023a.x);
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
    public static final class m<T> implements SimpleMessageListener.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58024a;

        public m(VideoVerticalPageFragment videoVerticalPageFragment) {
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
            this.f58024a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.util.SimpleMessageListener.b
        /* renamed from: a */
        public final void call(Unit unit) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, unit) == null) {
                this.f58024a.m(false, false, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class n<T> implements SimpleMessageListener.b<Pair<Boolean, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58025a;

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
            this.f58025a = videoVerticalPageFragment;
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
            this.f58025a.m(true, bool.booleanValue(), pair.second);
        }
    }

    /* loaded from: classes7.dex */
    public static final class o implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final o f58026e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2029232847, "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$o;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2029232847, "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment$o;");
                    return;
                }
            }
            f58026e = new o();
        }

        public o() {
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
    public static final class p implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58027a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
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
            this.f58027a = videoVerticalPageFragment;
        }

        @Override // c.a.r0.x0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && c.a.r0.x0.a.i().m("6061002332-203360688") && this.f58027a.f58007f != null) {
                c.a.r0.z3.c.d dVar = this.f58027a.f58009h;
                VideoPlayView videoPlayView = this.f58027a.f58007f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.currentSelectIndex);
                VideoPlayView videoPlayView2 = this.f58027a.f58007f;
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
    public static final class q implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58028a;

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
            this.f58028a = videoVerticalPageFragment;
        }

        @Override // c.a.r0.x0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && c.a.r0.x0.a.i().m("6061002410-390177882") && this.f58028a.f58007f != null) {
                c.a.r0.z3.c.d dVar = this.f58028a.f58009h;
                VideoPlayView videoPlayView = this.f58028a.f58007f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.currentSelectIndex);
                VideoPlayView videoPlayView2 = this.f58028a.f58007f;
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
    public static final class r implements VideoPersonalModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58029a;

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
            this.f58029a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoPersonalModel.b
        public void a(List<VideoItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || !(!list.isEmpty()) || this.f58029a.f58009h.v() || this.f58029a.f58007f == null) {
                return;
            }
            this.f58029a.f58009h.b(list);
            VideoPlayView videoPlayView = this.f58029a.f58007f;
            if (videoPlayView == null) {
                Intrinsics.throwNpe();
            }
            videoPlayView.notifyDataSetChanged();
        }
    }

    /* loaded from: classes7.dex */
    public static final class s implements BdSwipeRefreshLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58030a;

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
            this.f58030a = videoVerticalPageFragment;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
        public final void a(int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) && z && this.f58030a.k() && this.f58030a.getPageContext() != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f58030a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                if (pageContext.getPageActivity() != null) {
                    TbPageContext<BaseFragmentActivity> pageContext2 = this.f58030a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                    Activity pageActivity = pageContext2.getPageActivity();
                    TbPageContext<BaseFragmentActivity> pageContext3 = this.f58030a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext3, "pageContext");
                    c.a.e.e.p.l.M(pageActivity, pageContext3.getPageActivity().getString(R.string.no_more_production));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class t implements VideoPlayView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58031a;

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
            this.f58031a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public final void a() {
            VideoPlayModel videoPlayModel;
            VideoChannelModel videoChannelModel;
            VideoPersonalModel videoPersonalModel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f58031a.n) {
                if (this.f58031a.h()) {
                    Long l = this.f58031a.f58009h.l();
                    c.a.r0.z3.c.d dVar = this.f58031a.f58009h;
                    VideoPlayView videoPlayView = this.f58031a.f58007f;
                    if (videoPlayView == null) {
                        Intrinsics.throwNpe();
                    }
                    UserItemData i2 = dVar.i(videoPlayView.currentSelectIndex);
                    if (l == null || i2 == null || (videoPersonalModel = this.f58031a.v) == null) {
                        return;
                    }
                    videoPersonalModel.C(l, i2);
                } else if (this.f58031a.O == 1 || this.f58031a.O == 2) {
                    VideoPlayModel videoPlayModel2 = this.f58031a.t;
                    if (videoPlayModel2 != null) {
                        videoPlayModel2.setFrom(this.f58031a.m);
                    }
                    if (this.f58031a.f58009h.w() || (videoPlayModel = this.f58031a.t) == null) {
                        return;
                    }
                    videoPlayModel.I(this.f58031a.f58009h.s(0));
                } else {
                    VideoChannelModel videoChannelModel2 = this.f58031a.u;
                    if (videoChannelModel2 != null) {
                        videoChannelModel2.setFrom(this.f58031a.m);
                    }
                    if (this.f58031a.f58009h.w() || (videoChannelModel = this.f58031a.u) == null) {
                        return;
                    }
                    videoChannelModel.loadMore();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class u implements VideoPlayView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f58032a;

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
            this.f58032a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.f
        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f58032a.k() && this.f58032a.getPageContext() != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f58032a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                if (pageContext.getPageActivity() != null) {
                    TbPageContext<BaseFragmentActivity> pageContext2 = this.f58032a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                    Activity pageActivity = pageContext2.getPageActivity();
                    TbPageContext<BaseFragmentActivity> pageContext3 = this.f58032a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext3, "pageContext");
                    c.a.e.e.p.l.M(pageActivity, pageContext3.getPageActivity().getString(R.string.no_more_production));
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
        this.L = bdUniqueId;
        this.M = kVar;
        this.N = i2;
        this.O = i3;
        this.f58009h = new c.a.r0.z3.c.d();
        this.n = true;
        this.y = new VideoPlayFragment.GoPbCommentFloatListener(new c(this));
        this.B = new b(this);
        this.C = new k(this, 2921581);
        this.E = new i(this, 2921566, true);
        this.F = new l(this, 2016488);
        this.G = new h(this, 2016331);
        this.H = new j(this, 2000994);
        this.I = new s(this);
        this.J = new u(this);
        this.K = new a(this, 2001011);
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.O == 6 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.O == 3 ? "a088" : "a023" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.z3.f.a
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VideoItemData s2 = this.f58009h.s(this.f58010i);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.I : (BdSwipeRefreshLayout.k) invokeV.objValue;
    }

    public final b.InterfaceC0664b getVEventListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.B : (b.InterfaceC0664b) invokeV.objValue;
    }

    public final VideoPlayView.f getViewPagerBottomScrollMoreCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.J : (VideoPlayView.f) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? g() && !l() : invokeV.booleanValue;
    }

    @Override // c.a.r0.z3.f.a
    public void handleActivityResult(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, intent) == null) || (videoPlayView = this.f58007f) == null) {
            return;
        }
        videoPlayView.handleActivityResult(i2, i3, intent);
    }

    @Override // c.a.r0.z3.f.a
    public boolean handleBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            VideoPlayView videoPlayView = this.f58007f;
            return videoPlayView != null && videoPlayView.handleBackPress();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.z3.f.a
    public void handleIndexMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            VideoPlayView videoPlayView = this.f58007f;
            if (videoPlayView == null) {
                Intrinsics.throwNpe();
            }
            int i2 = videoPlayView.firstInIndex;
            VideoPlayView videoPlayView2 = this.f58007f;
            if (videoPlayView2 == null) {
                Intrinsics.throwNpe();
            }
            if (i2 != videoPlayView2.currentSelectIndex) {
                VideoPlayView videoPlayView3 = this.f58007f;
                if (videoPlayView3 == null) {
                    Intrinsics.throwNpe();
                }
                if (videoPlayView3.currentSelectIndex >= 0) {
                    VideoPlayView videoPlayView4 = this.f58007f;
                    if (videoPlayView4 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (videoPlayView4.currentSelectIndex < this.f58009h.k()) {
                        c.a.r0.z3.c.d dVar = this.f58009h;
                        VideoPlayView videoPlayView5 = this.f58007f;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? g() && l() : invokeV.booleanValue;
    }

    public final void initData() {
        int i2;
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f58009h.c();
            Bundle arguments = getArguments();
            List<VideoItemData> list = (ArrayList) (arguments != null ? arguments.getSerializable("video_list") : null);
            if (list == null) {
                list = VideoPlayActivityConfig.bigDataList;
            }
            this.f58009h.y(list);
            if (getArguments() != null) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    Intrinsics.throwNpe();
                }
                i2 = arguments2.getInt("video_index", 0);
            } else {
                i2 = 0;
            }
            this.f58010i = i2;
            if (getArguments() != null) {
                Bundle arguments3 = getArguments();
                if (arguments3 == null) {
                    Intrinsics.throwNpe();
                }
                i3 = arguments3.getInt("video_show_index", 0);
            } else {
                i3 = 0;
            }
            this.f58011j = i3;
            Bundle arguments4 = getArguments();
            this.k = arguments4 != null ? (Rect) arguments4.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT) : null;
            Bundle arguments5 = getArguments();
            this.l = arguments5 != null ? arguments5.getString("page_from") : null;
            Bundle arguments6 = getArguments();
            this.m = arguments6 != null ? arguments6.getString("from") : null;
            Bundle arguments7 = getArguments();
            this.o = arguments7 != null ? arguments7.getString("st_type") : null;
            Bundle arguments8 = getArguments();
            this.p = arguments8 != null ? arguments8.getString("yuelaou_locate") : null;
            if (getArguments() != null) {
                Bundle arguments9 = getArguments();
                if (arguments9 == null) {
                    Intrinsics.throwNpe();
                }
                z = arguments9.getBoolean("is_vertail", true);
            } else {
                z = false;
            }
            this.q = z;
            if (this.r == null) {
                this.r = VideoRecommentPlayActivityConfig.bigPersonalPageParams;
            }
            if (this.f58009h.v() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.f58009h.y(VideoPlayActivityConfig.bigDataList);
            }
            this.f58009h.B(getUniqueId());
            if (this.O != 3 && (!TbSingleton.getInstance().isFromFeedVideoClick() || this.O != 1)) {
                this.f58009h.C("a023");
            } else {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
                o(inst.getMainTabBottomBarHeight());
                this.f58009h.C("a088");
            }
            int i4 = this.O;
            if (i4 != 1 && i4 != 2) {
                if (k()) {
                    if (this.f58011j >= this.f58009h.k()) {
                        this.f58011j = 0;
                    }
                    if (h()) {
                        n();
                    }
                } else {
                    VideoChannelModel videoChannelModel = new VideoChannelModel(getPageContext(), getUniqueId());
                    this.u = videoChannelModel;
                    if (videoChannelModel != null) {
                        videoChannelModel.setFrom(this.m);
                    }
                    VideoChannelModel videoChannelModel2 = this.u;
                    if (videoChannelModel2 != null) {
                        videoChannelModel2.F(this.N);
                    }
                    VideoChannelModel videoChannelModel3 = this.u;
                    if (videoChannelModel3 != null) {
                        videoChannelModel3.G(new g(this));
                    }
                    if (this.f58009h.s(0) != null) {
                        VideoItemData s2 = this.f58009h.s(0);
                        this.s = s2 != null ? s2.thread_id : null;
                    }
                    VideoChannelModel videoChannelModel4 = this.u;
                    if (videoChannelModel4 != null) {
                        videoChannelModel4.setFrom(this.m);
                    }
                    if (!c.a.e.e.p.j.z() && !isPrimary()) {
                        return;
                    }
                    if (i()) {
                        VideoChannelModel videoChannelModel5 = this.u;
                        if (videoChannelModel5 != null) {
                            videoChannelModel5.loadMore();
                        }
                    } else {
                        VideoChannelModel videoChannelModel6 = this.u;
                        if (videoChannelModel6 != null) {
                            videoChannelModel6.E();
                        }
                    }
                }
            } else {
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest()) {
                    if (c.a.q0.b.d.R()) {
                        c.a.r0.x0.a.i().q(getActivity(), new d(this), this.f58009h.o());
                    }
                    if (c.a.q0.b.d.S()) {
                        c.a.r0.x0.a.i().p(getActivity(), new e(this), this.f58009h.o());
                    }
                }
                VideoPlayModel videoPlayModel = new VideoPlayModel(getPageContext(), getUniqueId());
                this.t = videoPlayModel;
                if (videoPlayModel != null) {
                    videoPlayModel.setFrom(this.m);
                }
                VideoPlayModel videoPlayModel2 = this.t;
                if (videoPlayModel2 != null) {
                    videoPlayModel2.K(this.N);
                }
                VideoPlayModel videoPlayModel3 = this.t;
                if (videoPlayModel3 != null) {
                    videoPlayModel3.L(new f(this));
                }
                if (this.f58009h.s(0) != null) {
                    VideoItemData s3 = this.f58009h.s(0);
                    this.s = s3 != null ? s3.thread_id : null;
                }
                VideoPlayModel videoPlayModel4 = this.t;
                if (videoPlayModel4 != null) {
                    videoPlayModel4.setFrom(this.m);
                }
                VideoPlayModel videoPlayModel5 = this.t;
                if (videoPlayModel5 != null) {
                    videoPlayModel5.J(this.f58009h.s(0), this.o, this.p, this.q);
                }
            }
            this.D = new c.a.r0.z3.g.a(this.f58009h.h(), getPageContext());
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.O == 5 : invokeV.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? j() || h() : invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = this.r;
            if (personalPageParams != null) {
                return personalPageParams.isShareThread();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m(boolean z, boolean z2, String str) {
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        VideoPersonalModel videoPersonalModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) || (personalPageParams = this.r) == null || (videoPersonalModel = this.v) == null) {
            return;
        }
        c.a.r0.z3.c.d dVar = this.f58009h;
        VideoPlayView videoPlayView = this.f58007f;
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

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || getPageContext() == null || getUniqueId() == null || this.r == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = this.r;
        if (personalPageParams == null) {
            Intrinsics.throwNpe();
        }
        VideoPersonalModel videoPersonalModel = new VideoPersonalModel(pageContext, personalPageParams);
        this.v = videoPersonalModel;
        if (videoPersonalModel != null) {
            videoPersonalModel.D(new r(this));
        }
    }

    public final void o(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (view = this.f58006e) == null) {
            return;
        }
        if (view == null) {
            Intrinsics.throwNpe();
        }
        int paddingLeft = view.getPaddingLeft();
        View view2 = this.f58006e;
        if (view2 == null) {
            Intrinsics.throwNpe();
        }
        int paddingTop = view2.getPaddingTop();
        View view3 = this.f58006e;
        if (view3 == null) {
            Intrinsics.throwNpe();
        }
        int paddingRight = view3.getPaddingRight();
        View view4 = this.f58006e;
        if (view4 == null) {
            Intrinsics.throwNpe();
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, view4.getPaddingBottom() + i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.z = new OnActivityFinishListener<>(getPageContext(), new m(this));
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            this.A = new OnDeleteSelfPostListener(pageContext, new n(this));
            Lifecycle lifecycle = getLifecycle();
            OnDeleteSelfPostListener onDeleteSelfPostListener = this.A;
            if (onDeleteSelfPostListener == null) {
                Intrinsics.throwNpe();
            }
            lifecycle.addObserver(onDeleteSelfPostListener);
            Lifecycle lifecycle2 = getLifecycle();
            OnActivityFinishListener<Unit> onActivityFinishListener = this.z;
            if (onActivityFinishListener == null) {
                Intrinsics.throwNpe();
            }
            lifecycle2.addObserver(onActivityFinishListener);
            getLifecycle().addObserver(this.y);
            initData();
            p();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048595, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                handleActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            VideoPlayView videoPlayView = this.f58007f;
            if (videoPlayView != null) {
                videoPlayView.onChangeSkinType(i2);
            }
            SkinManager.setBackgroundColor(this.f58006e, R.color.CAM_X0611);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.F);
            registerListener(this.E);
            registerListener(this.H);
            registerListener(this.C);
            registerListener(this.G);
            registerListener(this.K);
            View inflate = layoutInflater.inflate(R.layout.video_vertical_page_fragment, viewGroup, false);
            this.f58006e = inflate;
            RelativeLayout relativeLayout = inflate != null ? (RelativeLayout) inflate.findViewById(R.id.youngster_vertical_layout) : null;
            this.f58008g = relativeLayout;
            if (relativeLayout != null) {
                relativeLayout.setOnTouchListener(o.f58026e);
            }
            return this.f58006e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
            if (this.A != null) {
                Lifecycle lifecycle = getLifecycle();
                OnDeleteSelfPostListener onDeleteSelfPostListener = this.A;
                if (onDeleteSelfPostListener == null) {
                    Intrinsics.throwNpe();
                }
                lifecycle.removeObserver(onDeleteSelfPostListener);
            }
            if (this.z != null) {
                Lifecycle lifecycle2 = getLifecycle();
                OnActivityFinishListener<Unit> onActivityFinishListener = this.z;
                if (onActivityFinishListener == null) {
                    Intrinsics.throwNpe();
                }
                lifecycle2.removeObserver(onActivityFinishListener);
            }
            getLifecycle().removeObserver(this.y);
            VideoPlayView videoPlayView = this.f58007f;
            if (videoPlayView != null) {
                videoPlayView.onDestroy();
            }
            if (isPrimary()) {
                q();
            }
            VideoPersonalModel videoPersonalModel = this.v;
            if (videoPersonalModel != null) {
                videoPersonalModel.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDestroyView();
            c.a.r0.x0.a.i().d("6061002332-203360688");
            c.a.r0.x0.a.i().c("6061002410-390177882");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f58007f;
            if (videoPlayView != null) {
                videoPlayView.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onPrimary();
            if (!this.x) {
                q();
            }
            if (this.x && this.O == 3) {
                c.a.r0.z3.b.c(1);
            }
            VideoPlayView videoPlayView = this.f58007f;
            if (videoPlayView != null) {
                videoPlayView.setPrimary(isPrimary());
            }
            if (!this.w && isPrimary() && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.O == 3) {
                this.w = true;
                if (c.a.q0.b.d.R()) {
                    c.a.r0.x0.a.i().q(getActivity(), new p(this), this.f58009h.o());
                } else if (c.a.q0.b.d.S()) {
                    c.a.r0.x0.a.i().p(getActivity(), new q(this), this.f58009h.o());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onResume();
        }
    }

    public final void p() {
        VideoPlayView videoPlayView;
        VideoPlayView videoPlayView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            BdUniqueId bdUniqueId = this.L;
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            Activity pageActivity = pageContext.getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView3 = new VideoPlayView(bdUniqueId, (FragmentActivity) pageActivity, this, this.m, getUniqueId(), 1, this.O, l());
                this.f58007f = videoPlayView3;
                if (this.O == 3 && videoPlayView3 != null) {
                    videoPlayView3.setSubFrom(VideoPlayView.FROM_SUGGEST_SUB_FRAGMENT);
                }
                VideoPlayView videoPlayView4 = this.f58007f;
                if (videoPlayView4 != null) {
                    BdSwipeRefreshLayout.k kVar = this.M;
                    if (kVar == null) {
                        kVar = this.I;
                    }
                    videoPlayView4.setProgressViewCallback(kVar);
                }
                VideoPlayView videoPlayView5 = this.f58007f;
                if (videoPlayView5 != null) {
                    videoPlayView5.setBottomScrollMoreCallback(this.J);
                }
                if (this.N != 1 && (videoPlayView2 = this.f58007f) != null) {
                    videoPlayView2.setEventListener(this.B);
                }
                c.a.r0.z3.g.a aVar = this.D;
                if (aVar != null) {
                    aVar.o(this.f58007f);
                }
                VideoPlayView videoPlayView6 = this.f58007f;
                if (videoPlayView6 != null) {
                    videoPlayView6.setOnLoadMoreListener(new t(this));
                }
                VideoPlayView videoPlayView7 = this.f58007f;
                if (videoPlayView7 != null) {
                    videoPlayView7.showData(this.f58009h, this.f58010i, this.k);
                }
                VideoPlayView videoPlayView8 = this.f58007f;
                if (videoPlayView8 != null) {
                    videoPlayView8.setPageFrom(this.l);
                }
                VideoPlayView videoPlayView9 = this.f58007f;
                if (videoPlayView9 != null) {
                    videoPlayView9.setObjId(this.s);
                }
                VideoPlayView videoPlayView10 = this.f58007f;
                if (videoPlayView10 != null) {
                    videoPlayView10.setVideoChannelPageType(this.N);
                }
                if (k() && (videoPlayView = this.f58007f) != null) {
                    videoPlayView.setSelectIndex(this.f58011j, false);
                }
                VideoPlayView videoPlayView11 = this.f58007f;
                if (videoPlayView11 != null) {
                    videoPlayView11.setNadDispatcher(this.D);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            c.a.r0.z3.c.e.e(getActivity() instanceof VideoPlayActivity ? "1" : "3");
        }
    }

    public final void r(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        UserItemData userItemData;
        UserItemData userItemData2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, videoItemData, list) == null) {
            VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list, 0);
            if (videoItemData == null || (userItemData = videoItemData.author_info) == null || videoItemData2 == null || (userItemData2 = videoItemData2.author_info) == null || (str = userItemData2.user_id) == null || !Intrinsics.areEqual(str, userItemData.user_id)) {
                return;
            }
            videoItemData2.author_info.is_follow = videoItemData.author_info.is_follow;
        }
    }

    public final void s(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, videoItemData, list) == null) {
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

    public final void setProgressViewCallbackFra(BdSwipeRefreshLayout.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, kVar) == null) {
            this.I = kVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z && this.O == 6) {
                t();
            }
            VideoPlayView videoPlayView = this.f58007f;
            if (videoPlayView != null) {
                videoPlayView.setCurrentFragmentUserHint(z);
            }
            this.x = z;
        }
    }

    public final void setVideoPlayViewEventListener(b.InterfaceC0664b interfaceC0664b) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, interfaceC0664b) == null) || (videoPlayView = this.f58007f) == null) {
            return;
        }
        videoPlayView.setEventListener(interfaceC0664b);
    }

    public final void setViewPagerBottomScrollMoreCallback(VideoPlayView.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, fVar) == null) {
            this.J = fVar;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            boolean d2 = c.a.q0.g1.b.e.d();
            RelativeLayout relativeLayout = this.f58008g;
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
