package com.baidu.tieba.videoplay.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
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
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.VideoPlayActivityStatic;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.tieba.videoplay.model.VideoChannelModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import d.a.p0.d1.p.a;
import d.a.p0.s.q.b2;
import d.a.q0.v0.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VideoRedIcon.RedIcon;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010i\u0012\b\b\u0002\u0010h\u001a\u00020\f\u0012\b\b\u0002\u0010H\u001a\u00020\f¢\u0006\u0004\bx\u0010yJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0019\u0010\u001c\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001e\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u0013J\u0017\u0010 \u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\fH\u0016¢\u0006\u0004\b \u0010!J-\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0011H\u0016¢\u0006\u0004\b)\u0010\u0018J\u000f\u0010*\u001a\u00020\u0011H\u0016¢\u0006\u0004\b*\u0010\u0018J\u000f\u0010+\u001a\u00020\u0011H\u0016¢\u0006\u0004\b+\u0010\u0018J\u000f\u0010,\u001a\u00020\u0011H\u0016¢\u0006\u0004\b,\u0010\u0018J\u000f\u0010-\u001a\u00020\u0011H\u0016¢\u0006\u0004\b-\u0010\u0018J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u0010!J\u0017\u00101\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0014H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0011H\u0002¢\u0006\u0004\b6\u0010\u0018J%\u0010;\u001a\u00020\u00112\u0006\u00108\u001a\u0002072\f\u0010:\u001a\b\u0012\u0004\u0012\u00020709H\u0002¢\u0006\u0004\b;\u0010<J'\u0010=\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u0001072\f\u0010:\u001a\b\u0012\u0004\u0012\u00020709H\u0002¢\u0006\u0004\b=\u0010<R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u00100\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010M\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010O\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010NR\u0016\u0010P\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010DR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010NR\u0016\u0010R\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010LR\u0018\u0010S\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010NR\u0016\u0010T\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010LR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010X\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010NR\u0016\u0010[\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010LR\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010IR\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010d\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010IR\u0016\u0010g\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010DR\u0016\u0010h\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010IR\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\"\u0010l\u001a\u00020i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010k\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010r\u001a\u00020q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010w¨\u0006z"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment;", "Ld/a/q0/x3/f/a;", "Lcom/baidu/tbadk/core/BaseFragment;", "", "getCurrentPageKey", "()Ljava/lang/String;", "", "getMissionTid", "()J", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "getVEventListener", "()Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "", "requestCode", MiPushCommandMessage.KEY_RESULT_CODE, "Landroid/content/Intent;", "data", "", "handleActivityResult", "(IILandroid/content/Intent;)V", "", "handleBackPress", "()Z", "handleIndexMessage", "()V", "initData", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/os/Bundle;)V", "onActivityResult", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", MissionEvent.MESSAGE_RESUME, "height", "setEmptyHeight", "isVisibleToUser", "setUserVisibleHint", "(Z)V", "listener", "setVideoPlayViewEventListener", "(Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;)V", "showData", "Lcom/baidu/tieba/video/VideoItemData;", "originalData", "", "newList", "syncFirstVideoFollowState", "(Lcom/baidu/tieba/video/VideoItemData;Ljava/util/List;)V", "syncFirstVideoThreadData", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "eventListener", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "isVertail", "Z", "Lcom/baidu/adp/BdUniqueId;", "mActivityPageUniqueId", "Lcom/baidu/adp/BdUniqueId;", "mCurrentType", "I", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFeedBackListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFrom", "Ljava/lang/String;", "mFromPage", "mHasMore", "mLocate", "mNetworkChangedMessageListener", "mObjId", "mRecommendTabInsertDataListener", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "mUEGFeedBackListener", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoChannelModel", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoIndex", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "mVideoPlayModel", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoShowIndex", "mVideoTabReqFunAd", "mainPageType", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallbackFra", "getProgressViewCallbackFra", "()Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "setProgressViewCallbackFra", "(Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;)V", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "getViewPagerBottomScrollMoreCallback", "()Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "setViewPagerBottomScrollMoreCallback", "(Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;)V", "<init>", "(Lcom/baidu/adp/BdUniqueId;Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;II)V", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoVerticalPageFragment extends BaseFragment implements d.a.q0.x3.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdSwipeRefreshLayout.k A;
    public VideoPlayView.e B;
    public final BdUniqueId C;
    public final BdSwipeRefreshLayout.k D;
    public final int E;
    public final int F;

    /* renamed from: e  reason: collision with root package name */
    public View f22080e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayView f22081f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.q0.x3.c.d f22082g;

    /* renamed from: h  reason: collision with root package name */
    public int f22083h;

    /* renamed from: i  reason: collision with root package name */
    public int f22084i;
    public Rect j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String o;
    public boolean p;
    public String q;
    public VideoPlayModel r;
    public VideoChannelModel s;
    public boolean t;
    public boolean u;
    public a.b v;
    public final CustomMessageListener w;
    public final CustomMessageListener x;
    public final CustomMessageListener y;
    public final CustomMessageListener z;

    /* loaded from: classes4.dex */
    public static final class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22085e;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(VideoVerticalPageFragment videoVerticalPageFragment) {
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
            this.f22085e = videoVerticalPageFragment;
        }

        @Override // d.a.p0.d1.p.a.b
        public void O(float f2, float f3) {
            VideoPlayView videoPlayView;
            a.b q;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (videoPlayView = this.f22085e.f22081f) == null || (q = videoPlayView.q()) == null) {
                return;
            }
            q.O(f2, f3);
        }

        @Override // d.a.p0.d1.p.a.b
        public void j() {
            VideoPlayView videoPlayView;
            a.b q;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (videoPlayView = this.f22085e.f22081f) == null || (q = videoPlayView.q()) == null) {
                return;
            }
            q.j();
        }

        @Override // d.a.p0.d1.p.a.b
        public void k() {
            VideoPlayView videoPlayView;
            a.b q;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (videoPlayView = this.f22085e.f22081f) == null || (q = videoPlayView.q()) == null) {
                return;
            }
            q.k();
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements a.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22086a;

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
            this.f22086a = videoVerticalPageFragment;
        }

        @Override // d.a.q0.v0.a.g
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && d.a.q0.v0.a.i().m("6061002332-203360688") && this.f22086a.f22081f != null) {
                d.a.q0.x3.c.d dVar = this.f22086a.f22082g;
                VideoPlayView videoPlayView = this.f22086a.f22081f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.k);
                VideoPlayView videoPlayView2 = this.f22086a.f22081f;
                if (videoPlayView2 != null) {
                    videoPlayView2.u();
                }
            }
        }

        @Override // d.a.q0.v0.a.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements a.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22087a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
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
            this.f22087a = videoVerticalPageFragment;
        }

        @Override // d.a.q0.v0.a.g
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && d.a.q0.v0.a.i().m("6061002410-390177882") && this.f22087a.f22081f != null) {
                d.a.q0.x3.c.d dVar = this.f22087a.f22082g;
                VideoPlayView videoPlayView = this.f22087a.f22081f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.k);
                VideoPlayView videoPlayView2 = this.f22087a.f22081f;
                if (videoPlayView2 != null) {
                    videoPlayView2.u();
                }
            }
        }

        @Override // d.a.q0.v0.a.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements VideoPlayModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22088a;

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
            this.f22088a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) {
                this.f22088a.m = z;
                if (ListUtils.isEmpty(list) || this.f22088a.f22082g.q()) {
                    return;
                }
                VideoVerticalPageFragment videoVerticalPageFragment = this.f22088a;
                VideoItemData o = videoVerticalPageFragment.f22082g.o(0);
                if (o == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(o, "dataController.getVideoData(0)!!");
                videoVerticalPageFragment.b1(o, list);
                VideoVerticalPageFragment videoVerticalPageFragment2 = this.f22088a;
                videoVerticalPageFragment2.c1(videoVerticalPageFragment2.f22082g.o(0), list);
                this.f22088a.f22082g.t(list);
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && d.a.p0.b.d.a0() && d.a.q0.v0.a.i().m("6061002332-203360688") && this.f22088a.f22081f != null) {
                    d.a.q0.x3.c.d dVar = this.f22088a.f22082g;
                    VideoPlayView videoPlayView = this.f22088a.f22081f;
                    if (videoPlayView == null) {
                        Intrinsics.throwNpe();
                    }
                    dVar.a(videoPlayView.k - 1);
                }
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && d.a.p0.b.d.b0() && d.a.q0.v0.a.i().m("6061002410-390177882") && this.f22088a.f22081f != null) {
                    d.a.q0.x3.c.d dVar2 = this.f22088a.f22082g;
                    VideoPlayView videoPlayView2 = this.f22088a.f22081f;
                    if (videoPlayView2 == null) {
                        Intrinsics.throwNpe();
                    }
                    dVar2.a(videoPlayView2.k - 1);
                }
                VideoPlayView videoPlayView3 = this.f22088a.f22081f;
                if (videoPlayView3 != null) {
                    videoPlayView3.u();
                }
                VideoPlayView videoPlayView4 = this.f22088a.f22081f;
                if (videoPlayView4 != null) {
                    videoPlayView4.J(0, true);
                }
                VideoPlayView videoPlayView5 = this.f22088a.f22081f;
                if (videoPlayView5 != null) {
                    videoPlayView5.H(this.f22088a.isPrimary());
                }
                VideoPlayView videoPlayView6 = this.f22088a.f22081f;
                if (videoPlayView6 != null) {
                    videoPlayView6.z(this.f22088a.u);
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.c
        public void b(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) {
                this.f22088a.m = z;
                if (ListUtils.isEmpty(list) || this.f22088a.f22082g.q()) {
                    return;
                }
                this.f22088a.f22082g.b(list);
                if (this.f22088a.f22081f != null) {
                    d.a.q0.x3.c.d dVar = this.f22088a.f22082g;
                    VideoPlayView videoPlayView = this.f22088a.f22081f;
                    if (videoPlayView == null) {
                        Intrinsics.throwNpe();
                    }
                    dVar.a(videoPlayView.k);
                }
                VideoPlayView videoPlayView2 = this.f22088a.f22081f;
                if (videoPlayView2 != null) {
                    videoPlayView2.u();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class e implements VideoChannelModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22089a;

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
            this.f22089a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f22089a.f22082g.t(list);
            if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && (((d.a.p0.b.d.a0() && d.a.q0.v0.a.i().m("6061002332-203360688")) || (d.a.p0.b.d.b0() && d.a.q0.v0.a.i().m("6061002410-390177882"))) && this.f22089a.f22081f != null)) {
                d.a.q0.x3.c.d dVar = this.f22089a.f22082g;
                VideoPlayView videoPlayView = this.f22089a.f22081f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.k);
            }
            VideoPlayView videoPlayView2 = this.f22089a.f22081f;
            if (videoPlayView2 != null) {
                videoPlayView2.u();
            }
            VideoPlayView videoPlayView3 = this.f22089a.f22081f;
            if (videoPlayView3 != null) {
                videoPlayView3.J(0, true);
            }
            VideoPlayView videoPlayView4 = this.f22089a.f22081f;
            if (videoPlayView4 != null) {
                videoPlayView4.H(this.f22089a.isPrimary());
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void b(List<? extends VideoItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f22089a.f22082g.q()) {
                return;
            }
            this.f22089a.f22082g.b(list);
            if (this.f22089a.f22081f != null) {
                d.a.q0.x3.c.d dVar = this.f22089a.f22082g;
                VideoPlayView videoPlayView = this.f22089a.f22081f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.k);
            }
            VideoPlayView videoPlayView2 = this.f22089a.f22081f;
            if (videoPlayView2 != null) {
                videoPlayView2.u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22090a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(VideoVerticalPageFragment videoVerticalPageFragment, int i2, boolean z) {
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
            this.f22090a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    if (this.f22090a.f22082g.e(((Integer) data).intValue())) {
                        VideoPlayView videoPlayView = this.f22090a.f22081f;
                        if (videoPlayView != null) {
                            videoPlayView.u();
                        }
                        VideoPlayView videoPlayView2 = this.f22090a.f22081f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.H(this.f22090a.isPrimary());
                        }
                        VideoPlayView videoPlayView3 = this.f22090a.f22081f;
                        if (videoPlayView3 != null) {
                            videoPlayView3.z(this.f22090a.u);
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

    /* loaded from: classes4.dex */
    public static final class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22091a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(VideoVerticalPageFragment videoVerticalPageFragment, int i2) {
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
            this.f22091a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && d.a.d.e.p.j.z() && this.f22091a.f22082g.q()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921568));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22092a;

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
            this.f22092a = videoVerticalPageFragment;
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
                    b2 b2Var = new b2();
                    b2Var.K2(redIcon.thread_list.get(0));
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData(b2Var);
                    VideoItemModel videoItemModel = new VideoItemModel(videoItemData, 1);
                    d.a.q0.x3.c.d dVar = this.f22092a.f22082g;
                    VideoPlayView videoPlayView = this.f22092a.f22081f;
                    if (dVar.p(videoItemModel, videoPlayView != null ? videoPlayView.k : 0)) {
                        VideoPlayActivityStatic.a(redIcon);
                        TbSingleton tbSingleton = TbSingleton.getInstance();
                        Intrinsics.checkExpressionValueIsNotNull(tbSingleton, "TbSingleton.getInstance()");
                        tbSingleton.setVideoChannelRecommendRedIcon(null);
                        VideoPlayView videoPlayView2 = this.f22092a.f22081f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.u();
                        }
                        VideoPlayView videoPlayView3 = this.f22092a.f22081f;
                        if (videoPlayView3 != null) {
                            videoPlayView3.H(this.f22092a.isPrimary());
                        }
                        VideoPlayView videoPlayView4 = this.f22092a.f22081f;
                        if (videoPlayView4 != null) {
                            videoPlayView4.z(this.f22092a.u);
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

    /* loaded from: classes4.dex */
    public static final class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22093a;

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
            this.f22093a = videoVerticalPageFragment;
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
                        if (this.f22093a.f22082g.f(optString)) {
                            VideoPlayView videoPlayView = this.f22093a.f22081f;
                            if (videoPlayView != null) {
                                videoPlayView.u();
                            }
                            VideoPlayView videoPlayView2 = this.f22093a.f22081f;
                            if (videoPlayView2 != null) {
                                videoPlayView2.H(this.f22093a.isPrimary());
                            }
                            VideoPlayView videoPlayView3 = this.f22093a.f22081f;
                            if (videoPlayView3 != null) {
                                videoPlayView3.z(this.f22093a.u);
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

    /* loaded from: classes4.dex */
    public static final class j implements a.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22094a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public j(VideoVerticalPageFragment videoVerticalPageFragment) {
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
            this.f22094a = videoVerticalPageFragment;
        }

        @Override // d.a.q0.v0.a.g
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && d.a.q0.v0.a.i().m("6061002332-203360688") && this.f22094a.f22081f != null) {
                d.a.q0.x3.c.d dVar = this.f22094a.f22082g;
                VideoPlayView videoPlayView = this.f22094a.f22081f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.k);
                VideoPlayView videoPlayView2 = this.f22094a.f22081f;
                if (videoPlayView2 != null) {
                    videoPlayView2.u();
                }
            }
        }

        @Override // d.a.q0.v0.a.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class k implements a.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22095a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public k(VideoVerticalPageFragment videoVerticalPageFragment) {
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
            this.f22095a = videoVerticalPageFragment;
        }

        @Override // d.a.q0.v0.a.g
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && d.a.q0.v0.a.i().m("6061002410-390177882") && this.f22095a.f22081f != null) {
                d.a.q0.x3.c.d dVar = this.f22095a.f22082g;
                VideoPlayView videoPlayView = this.f22095a.f22081f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.k);
                VideoPlayView videoPlayView2 = this.f22095a.f22081f;
                if (videoPlayView2 != null) {
                    videoPlayView2.u();
                }
            }
        }

        @Override // d.a.q0.v0.a.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class l implements BdSwipeRefreshLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22096a;

        public l(VideoVerticalPageFragment videoVerticalPageFragment) {
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
            this.f22096a = videoVerticalPageFragment;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
        public final void a(int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) && z && this.f22096a.F == 5 && this.f22096a.getPageContext() != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f22096a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                if (pageContext.getPageActivity() != null) {
                    TbPageContext<BaseFragmentActivity> pageContext2 = this.f22096a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                    Activity pageActivity = pageContext2.getPageActivity();
                    TbPageContext<BaseFragmentActivity> pageContext3 = this.f22096a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext3, "pageContext");
                    d.a.d.e.p.l.M(pageActivity, pageContext3.getPageActivity().getString(R.string.no_more_production));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class m implements VideoPlayView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22097a;

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
            this.f22097a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.d
        public final void a() {
            VideoPlayModel videoPlayModel;
            VideoChannelModel videoChannelModel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f22097a.m) {
                if (this.f22097a.F == 1 || this.f22097a.F == 2) {
                    VideoPlayModel videoPlayModel2 = this.f22097a.r;
                    if (videoPlayModel2 != null) {
                        videoPlayModel2.setFrom(this.f22097a.l);
                    }
                    if (this.f22097a.f22082g.r() || (videoPlayModel = this.f22097a.r) == null) {
                        return;
                    }
                    videoPlayModel.I(this.f22097a.f22082g.o(0));
                    return;
                }
                VideoChannelModel videoChannelModel2 = this.f22097a.s;
                if (videoChannelModel2 != null) {
                    videoChannelModel2.setFrom(this.f22097a.l);
                }
                if (this.f22097a.f22082g.r() || (videoChannelModel = this.f22097a.s) == null) {
                    return;
                }
                videoChannelModel.loadMore();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class n implements VideoPlayView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f22098a;

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
            this.f22098a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f22098a.F == 5 && this.f22098a.getPageContext() != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f22098a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                if (pageContext.getPageActivity() != null) {
                    TbPageContext<BaseFragmentActivity> pageContext2 = this.f22098a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                    Activity pageActivity = pageContext2.getPageActivity();
                    TbPageContext<BaseFragmentActivity> pageContext3 = this.f22098a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext3, "pageContext");
                    d.a.d.e.p.l.M(pageActivity, pageContext3.getPageActivity().getString(R.string.no_more_production));
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
        this.C = bdUniqueId;
        this.D = kVar;
        this.E = i2;
        this.F = i3;
        this.f22082g = new d.a.q0.x3.c.d();
        this.m = true;
        this.v = new a(this);
        this.w = new h(this, 2921581);
        this.x = new f(this, 2921566, true);
        this.y = new i(this, 2016488);
        this.z = new g(this, 2000994);
        this.A = new l(this);
        this.B = new n(this);
    }

    @Override // d.a.q0.x3.f.a
    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoPlayView videoPlayView = this.f22081f;
            return videoPlayView != null && videoPlayView.s();
        }
        return invokeV.booleanValue;
    }

    public final a.b X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v : (a.b) invokeV.objValue;
    }

    public final void Y0(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (view = this.f22080e) == null) {
            return;
        }
        if (view == null) {
            Intrinsics.throwNpe();
        }
        int paddingLeft = view.getPaddingLeft();
        View view2 = this.f22080e;
        if (view2 == null) {
            Intrinsics.throwNpe();
        }
        int paddingTop = view2.getPaddingTop();
        View view3 = this.f22080e;
        if (view3 == null) {
            Intrinsics.throwNpe();
        }
        int paddingRight = view3.getPaddingRight();
        View view4 = this.f22080e;
        if (view4 == null) {
            Intrinsics.throwNpe();
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, view4.getPaddingBottom() + i2);
    }

    @Override // d.a.q0.x3.f.a
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            VideoPlayView videoPlayView = this.f22081f;
            if (videoPlayView == null) {
                Intrinsics.throwNpe();
            }
            int i2 = videoPlayView.l;
            VideoPlayView videoPlayView2 = this.f22081f;
            if (videoPlayView2 == null) {
                Intrinsics.throwNpe();
            }
            if (i2 != videoPlayView2.k) {
                VideoPlayView videoPlayView3 = this.f22081f;
                if (videoPlayView3 == null) {
                    Intrinsics.throwNpe();
                }
                if (videoPlayView3.k >= 0) {
                    VideoPlayView videoPlayView4 = this.f22081f;
                    if (videoPlayView4 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (videoPlayView4.k < this.f22082g.i()) {
                        d.a.q0.x3.c.d dVar = this.f22082g;
                        VideoPlayView videoPlayView5 = this.f22081f;
                        if (videoPlayView5 == null) {
                            Intrinsics.throwNpe();
                        }
                        VideoItemData o = dVar.o(videoPlayView5.k);
                        if (o == null || StringUtils.isNull(o.thread_id)) {
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, o.thread_id));
                    }
                }
            }
        }
    }

    public final void Z0(a.b bVar) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || (videoPlayView = this.f22081f) == null) {
            return;
        }
        videoPlayView.A(bVar);
    }

    public final void a1() {
        VideoPlayView videoPlayView;
        VideoPlayView videoPlayView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BdUniqueId bdUniqueId = this.C;
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            Activity pageActivity = pageContext.getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView3 = new VideoPlayView(bdUniqueId, (FragmentActivity) pageActivity, this, this.l, getUniqueId(), 1, this.F);
                this.f22081f = videoPlayView3;
                if (this.F == 3 && videoPlayView3 != null) {
                    videoPlayView3.K("from_suggest_sub_fragment");
                }
                VideoPlayView videoPlayView4 = this.f22081f;
                if (videoPlayView4 != null) {
                    BdSwipeRefreshLayout.k kVar = this.D;
                    if (kVar == null) {
                        kVar = this.A;
                    }
                    videoPlayView4.I(kVar);
                }
                VideoPlayView videoPlayView5 = this.f22081f;
                if (videoPlayView5 != null) {
                    videoPlayView5.y(this.B);
                }
                if (this.E != 1 && (videoPlayView2 = this.f22081f) != null) {
                    videoPlayView2.A(this.v);
                }
                VideoPlayView videoPlayView6 = this.f22081f;
                if (videoPlayView6 != null) {
                    videoPlayView6.F(new m(this));
                }
                VideoPlayView videoPlayView7 = this.f22081f;
                if (videoPlayView7 != null) {
                    videoPlayView7.N(this.f22082g, this.f22083h, this.j);
                }
                VideoPlayView videoPlayView8 = this.f22081f;
                if (videoPlayView8 != null) {
                    videoPlayView8.G(this.k);
                }
                VideoPlayView videoPlayView9 = this.f22081f;
                if (videoPlayView9 != null) {
                    videoPlayView9.B(this.q);
                }
                VideoPlayView videoPlayView10 = this.f22081f;
                if (videoPlayView10 != null) {
                    videoPlayView10.L(this.E);
                }
                if (this.F != 5 || (videoPlayView = this.f22081f) == null) {
                    return;
                }
                videoPlayView.J(this.f22084i, false);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public final void b1(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        UserItemData userItemData;
        UserItemData userItemData2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, videoItemData, list) == null) {
            VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list, 0);
            if (videoItemData == null || (userItemData = videoItemData.author_info) == null || videoItemData2 == null || (userItemData2 = videoItemData2.author_info) == null || (str = userItemData2.user_id) == null || !Intrinsics.areEqual(str, userItemData.user_id)) {
                return;
            }
            videoItemData2.author_info.is_follow = videoItemData.author_info.is_follow;
        }
    }

    public final void c1(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, videoItemData, list) == null) {
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

    @Override // d.a.q0.x3.f.a
    public long d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            VideoItemData o = this.f22082g.o(this.f22083h);
            if (o == null || TextUtils.isEmpty(o.thread_id)) {
                return 0L;
            }
            return d.a.d.e.m.b.f(o.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.F == 3 ? "a088" : "a023" : (String) invokeV.objValue;
    }

    public final void initData() {
        int i2;
        int i3;
        boolean z;
        VideoChannelModel videoChannelModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f22082g.c();
            Bundle arguments = getArguments();
            this.f22082g.t((ArrayList) (arguments != null ? arguments.getSerializable("video_list") : null));
            if (getArguments() != null) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    Intrinsics.throwNpe();
                }
                i2 = arguments2.getInt("video_index", 0);
            } else {
                i2 = 0;
            }
            this.f22083h = i2;
            if (getArguments() != null) {
                Bundle arguments3 = getArguments();
                if (arguments3 == null) {
                    Intrinsics.throwNpe();
                }
                i3 = arguments3.getInt("video_show_index", 0);
            } else {
                i3 = 0;
            }
            this.f22084i = i3;
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            Activity pageActivity = pageContext.getPageActivity();
            Intrinsics.checkExpressionValueIsNotNull(pageActivity, "pageContext.pageActivity");
            Intent intent = pageActivity.getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent, "pageContext.pageActivity.intent");
            this.j = intent.getSourceBounds();
            Bundle arguments4 = getArguments();
            this.k = arguments4 != null ? arguments4.getString("page_from") : null;
            Bundle arguments5 = getArguments();
            this.l = arguments5 != null ? arguments5.getString("from") : null;
            Bundle arguments6 = getArguments();
            this.n = arguments6 != null ? arguments6.getString("st_type") : null;
            Bundle arguments7 = getArguments();
            this.o = arguments7 != null ? arguments7.getString("yuelaou_locate") : null;
            if (getArguments() != null) {
                Bundle arguments8 = getArguments();
                if (arguments8 == null) {
                    Intrinsics.throwNpe();
                }
                z = arguments8.getBoolean("is_vertail", true);
            } else {
                z = false;
            }
            this.p = z;
            if (this.f22082g.q() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.f22082g.t(VideoPlayActivityConfig.bigDataList);
            }
            this.f22082g.w(getUniqueId());
            if (this.F == 3) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
                Y0(inst.getMainTabBottomBarHeight());
                this.f22082g.x("a088");
            } else {
                this.f22082g.x("a023");
            }
            int i4 = this.F;
            if (i4 == 1 || i4 == 2) {
                if (VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest()) {
                    if (d.a.p0.b.d.a0()) {
                        d.a.q0.v0.a.i().q(getActivity(), new b(this), this.f22082g.l());
                    }
                    if (d.a.p0.b.d.b0()) {
                        d.a.q0.v0.a.i().p(getActivity(), new c(this), this.f22082g.l());
                    }
                }
                VideoPlayModel videoPlayModel = new VideoPlayModel(getPageContext(), getUniqueId());
                this.r = videoPlayModel;
                if (videoPlayModel != null) {
                    videoPlayModel.setFrom(this.l);
                }
                VideoPlayModel videoPlayModel2 = this.r;
                if (videoPlayModel2 != null) {
                    videoPlayModel2.K(this.E);
                }
                VideoPlayModel videoPlayModel3 = this.r;
                if (videoPlayModel3 != null) {
                    videoPlayModel3.L(new d(this));
                }
                if (this.f22082g.o(0) != null) {
                    VideoItemData o = this.f22082g.o(0);
                    this.q = o != null ? o.thread_id : null;
                }
                VideoPlayModel videoPlayModel4 = this.r;
                if (videoPlayModel4 != null) {
                    videoPlayModel4.setFrom(this.l);
                }
                VideoPlayModel videoPlayModel5 = this.r;
                if (videoPlayModel5 != null) {
                    videoPlayModel5.J(this.f22082g.o(0), this.n, this.o, this.p);
                }
            } else if (i4 == 5) {
                if (this.f22084i >= this.f22082g.i()) {
                    this.f22084i = 0;
                }
            } else {
                VideoChannelModel videoChannelModel2 = new VideoChannelModel(getPageContext(), getUniqueId());
                this.s = videoChannelModel2;
                if (videoChannelModel2 != null) {
                    videoChannelModel2.setFrom(this.l);
                }
                VideoChannelModel videoChannelModel3 = this.s;
                if (videoChannelModel3 != null) {
                    videoChannelModel3.F(this.E);
                }
                VideoChannelModel videoChannelModel4 = this.s;
                if (videoChannelModel4 != null) {
                    videoChannelModel4.G(new e(this));
                }
                if (this.f22082g.o(0) != null) {
                    VideoItemData o2 = this.f22082g.o(0);
                    this.q = o2 != null ? o2.thread_id : null;
                }
                VideoChannelModel videoChannelModel5 = this.s;
                if (videoChannelModel5 != null) {
                    videoChannelModel5.setFrom(this.l);
                }
                if ((d.a.d.e.p.j.z() || isPrimary()) && (videoChannelModel = this.s) != null) {
                    videoChannelModel.E();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            initData();
            a1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                r0(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            VideoPlayView videoPlayView = this.f22081f;
            if (videoPlayView != null) {
                videoPlayView.v(i2);
            }
            SkinManager.setBackgroundColor(this.f22080e, R.color.CAM_X0611);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.y);
            registerListener(this.x);
            registerListener(this.z);
            registerListener(this.w);
            View inflate = layoutInflater.inflate(R.layout.video_vertical_page_fragment, viewGroup, false);
            this.f22080e = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            VideoPlayView videoPlayView = this.f22081f;
            if (videoPlayView != null) {
                videoPlayView.w();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroyView();
            d.a.q0.v0.a.i().d("6061002332-203360688");
            d.a.q0.v0.a.i().c("6061002410-390177882");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f22081f;
            if (videoPlayView != null) {
                videoPlayView.x();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
            if (this.u && this.F == 3) {
                d.a.q0.x3.b.a(1);
            }
            VideoPlayView videoPlayView = this.f22081f;
            if (videoPlayView != null) {
                videoPlayView.H(isPrimary());
            }
            if (!this.t && isPrimary() && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.F == 3) {
                this.t = true;
                if (d.a.p0.b.d.a0()) {
                    d.a.q0.v0.a.i().q(getActivity(), new j(this), this.f22082g.l());
                }
                if (d.a.p0.b.d.b0()) {
                    d.a.q0.v0.a.i().p(getActivity(), new k(this), this.f22082g.l());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
        }
    }

    @Override // d.a.q0.x3.f.a
    public void r0(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048596, this, i2, i3, intent) == null) || (videoPlayView = this.f22081f) == null) {
            return;
        }
        videoPlayView.r(i2, i3, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.setUserVisibleHint(z);
            VideoPlayView videoPlayView = this.f22081f;
            if (videoPlayView != null) {
                videoPlayView.z(z);
            }
            this.u = z;
        }
    }

    public /* synthetic */ VideoVerticalPageFragment(BdUniqueId bdUniqueId, BdSwipeRefreshLayout.k kVar, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : bdUniqueId, (i4 & 2) != 0 ? null : kVar, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}
