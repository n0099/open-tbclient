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
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.tieba.videoplay.model.VideoChannelModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import d.a.o0.b1.p.a;
import d.a.o0.r.q.b2;
import d.a.p0.v0.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VideoRedIcon.RedIcon;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d\u0012\b\b\u0002\u0010c\u001a\u00020\u000b¢\u0006\u0004\bs\u0010tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001d\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u0012J\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010 J-\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0010H\u0016¢\u0006\u0004\b(\u0010\u0017J\u000f\u0010)\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010\u0017J\u000f\u0010*\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010\u0017J\u000f\u0010+\u001a\u00020\u0010H\u0016¢\u0006\u0004\b+\u0010\u0017J\u000f\u0010,\u001a\u00020\u0010H\u0016¢\u0006\u0004\b,\u0010\u0017J\u0017\u0010.\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u000bH\u0002¢\u0006\u0004\b.\u0010 J\u0017\u00100\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u0013H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0010H\u0002¢\u0006\u0004\b5\u0010\u0017J%\u0010:\u001a\u00020\u00102\u0006\u00107\u001a\u0002062\f\u00109\u001a\b\u0012\u0004\u0012\u00020608H\u0002¢\u0006\u0004\b:\u0010;J'\u0010<\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u0001062\f\u00109\u001a\b\u0012\u0004\u0012\u00020608H\u0002¢\u0006\u0004\b<\u0010;R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010HR\u0016\u0010J\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010CR\u0018\u0010K\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010HR\u0016\u0010L\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010FR\u0018\u0010M\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010HR\u0016\u0010N\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010FR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010R\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010T\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010HR\u0016\u0010U\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010FR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010ZR\u0016\u0010b\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010CR\u0016\u0010c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010ZR\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\"\u0010g\u001a\u00020d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010f\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010m\u001a\u00020l8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010r¨\u0006u"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "", "getCurrentPageKey", "()Ljava/lang/String;", "", "getMissionTid", "()J", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "getVEventListener", "()Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "", "requestCode", MiPushCommandMessage.KEY_RESULT_CODE, "Landroid/content/Intent;", "data", "", "handleActivityResult", "(IILandroid/content/Intent;)V", "", "handleBackPress", "()Z", "handleIndexMessage", "()V", "initData", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/os/Bundle;)V", "onActivityResult", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", MissionEvent.MESSAGE_RESUME, "height", "setEmptyHeight", "isVisibleToUser", "setUserVisibleHint", "(Z)V", "listener", "setVideoPlayViewEventListener", "(Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;)V", "showData", "Lcom/baidu/tieba/video/VideoItemData;", "originalData", "", "newList", "syncFirstVideoFollowState", "(Lcom/baidu/tieba/video/VideoItemData;Ljava/util/List;)V", "syncFirstVideoThreadData", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "eventListener", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "isVertail", "Z", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFeedBackListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFrom", "Ljava/lang/String;", "mFromPage", "mHasMore", "mLocate", "mNetworkChangedMessageListener", "mObjId", "mRecommendTabInsertDataListener", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "mUEGFeedBackListener", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoChannelModel", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoIndex", "I", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "mVideoPlayModel", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoShowIndex", "mVideoTabReqFunAd", "mainPageType", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallbackFra", "getProgressViewCallbackFra", "()Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "setProgressViewCallbackFra", "(Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;)V", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "getViewPagerBottomScrollMoreCallback", "()Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "setViewPagerBottomScrollMoreCallback", "(Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;)V", "<init>", "(Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;I)V", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoVerticalPageFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdSwipeRefreshLayout.k A;
    public VideoPlayView.e B;
    public final BdSwipeRefreshLayout.k C;
    public final int D;

    /* renamed from: e  reason: collision with root package name */
    public View f21934e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayView f21935f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.p0.x3.c.d f21936g;

    /* renamed from: h  reason: collision with root package name */
    public int f21937h;

    /* renamed from: i  reason: collision with root package name */
    public int f21938i;
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
        public final /* synthetic */ VideoVerticalPageFragment f21939e;

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
            this.f21939e = videoVerticalPageFragment;
        }

        @Override // d.a.o0.b1.p.a.b
        public void N(float f2, float f3) {
            VideoPlayView videoPlayView;
            VideoPlayFragment q;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (videoPlayView = this.f21939e.f21935f) == null || (q = videoPlayView.q()) == null) {
                return;
            }
            q.N(f2, f3);
        }

        @Override // d.a.o0.b1.p.a.b
        public void j() {
            VideoPlayView videoPlayView;
            VideoPlayFragment q;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (videoPlayView = this.f21939e.f21935f) == null || (q = videoPlayView.q()) == null) {
                return;
            }
            q.j();
        }

        @Override // d.a.o0.b1.p.a.b
        public void k() {
            VideoPlayView videoPlayView;
            VideoPlayFragment q;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (videoPlayView = this.f21939e.f21935f) == null || (q = videoPlayView.q()) == null) {
                return;
            }
            q.k();
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21940a;

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
            this.f21940a = videoVerticalPageFragment;
        }

        @Override // d.a.p0.v0.a.f
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && d.a.p0.v0.a.h().k("6061002332-203360688") && this.f21940a.f21935f != null) {
                d.a.p0.x3.c.d dVar = this.f21940a.f21936g;
                VideoPlayView videoPlayView = this.f21940a.f21935f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.j);
                VideoPlayView videoPlayView2 = this.f21940a.f21935f;
                if (videoPlayView2 != null) {
                    videoPlayView2.u();
                }
            }
        }

        @Override // d.a.p0.v0.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements VideoPlayModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21941a;

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
            this.f21941a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.b
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) {
                this.f21941a.m = z;
                if (ListUtils.isEmpty(list) || this.f21941a.f21936g.p()) {
                    return;
                }
                VideoVerticalPageFragment videoVerticalPageFragment = this.f21941a;
                VideoItemData n = videoVerticalPageFragment.f21936g.n(0);
                if (n == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(n, "dataController.getVideoData(0)!!");
                videoVerticalPageFragment.Z0(n, list);
                VideoVerticalPageFragment videoVerticalPageFragment2 = this.f21941a;
                videoVerticalPageFragment2.a1(videoVerticalPageFragment2.f21936g.n(0), list);
                this.f21941a.f21936g.s(list);
                if (d.a.p0.v0.a.h().k("6061002332-203360688") && this.f21941a.f21935f != null) {
                    d.a.p0.x3.c.d dVar = this.f21941a.f21936g;
                    VideoPlayView videoPlayView = this.f21941a.f21935f;
                    if (videoPlayView == null) {
                        Intrinsics.throwNpe();
                    }
                    dVar.a(videoPlayView.j - 1);
                }
                VideoPlayView videoPlayView2 = this.f21941a.f21935f;
                if (videoPlayView2 != null) {
                    videoPlayView2.u();
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.b
        public void b(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) {
                this.f21941a.m = z;
                if (ListUtils.isEmpty(list) || this.f21941a.f21936g.p()) {
                    return;
                }
                this.f21941a.f21936g.b(list);
                if (this.f21941a.f21935f != null) {
                    d.a.p0.x3.c.d dVar = this.f21941a.f21936g;
                    VideoPlayView videoPlayView = this.f21941a.f21935f;
                    if (videoPlayView == null) {
                        Intrinsics.throwNpe();
                    }
                    dVar.a(videoPlayView.j);
                }
                VideoPlayView videoPlayView2 = this.f21941a.f21935f;
                if (videoPlayView2 != null) {
                    videoPlayView2.u();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements VideoChannelModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21942a;

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
            this.f21942a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f21942a.f21936g.s(list);
            if (d.a.p0.v0.a.h().k("6061002332-203360688") && this.f21942a.f21935f != null) {
                d.a.p0.x3.c.d dVar = this.f21942a.f21936g;
                VideoPlayView videoPlayView = this.f21942a.f21935f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.j);
            }
            VideoPlayView videoPlayView2 = this.f21942a.f21935f;
            if (videoPlayView2 != null) {
                videoPlayView2.u();
            }
            VideoPlayView videoPlayView3 = this.f21942a.f21935f;
            if (videoPlayView3 != null) {
                videoPlayView3.J(0, true);
            }
            VideoPlayView videoPlayView4 = this.f21942a.f21935f;
            if (videoPlayView4 != null) {
                videoPlayView4.H(this.f21942a.isPrimary());
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void b(List<? extends VideoItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f21942a.f21936g.p()) {
                return;
            }
            this.f21942a.f21936g.b(list);
            if (this.f21942a.f21935f != null) {
                d.a.p0.x3.c.d dVar = this.f21942a.f21936g;
                VideoPlayView videoPlayView = this.f21942a.f21935f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.j);
            }
            VideoPlayView videoPlayView2 = this.f21942a.f21935f;
            if (videoPlayView2 != null) {
                videoPlayView2.u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21943a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(VideoVerticalPageFragment videoVerticalPageFragment, int i2, boolean z) {
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
            this.f21943a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    if (this.f21943a.f21936g.e(((Integer) data).intValue())) {
                        VideoPlayView videoPlayView = this.f21943a.f21935f;
                        if (videoPlayView != null) {
                            videoPlayView.u();
                        }
                        VideoPlayView videoPlayView2 = this.f21943a.f21935f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.H(this.f21943a.isPrimary());
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
    public static final class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21944a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(VideoVerticalPageFragment videoVerticalPageFragment, int i2) {
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
            this.f21944a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && d.a.c.e.p.j.z() && this.f21944a.f21936g.p()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921568));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21945a;

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
            this.f21945a = videoVerticalPageFragment;
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
                    b2Var.I2(redIcon.thread_list.get(0));
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData(b2Var);
                    VideoItemModel videoItemModel = new VideoItemModel(videoItemData, 1);
                    d.a.p0.x3.c.d dVar = this.f21945a.f21936g;
                    VideoPlayView videoPlayView = this.f21945a.f21935f;
                    if (dVar.o(videoItemModel, videoPlayView != null ? videoPlayView.j : 0)) {
                        VideoPlayActivityStatic.a(redIcon);
                        TbSingleton tbSingleton = TbSingleton.getInstance();
                        Intrinsics.checkExpressionValueIsNotNull(tbSingleton, "TbSingleton.getInstance()");
                        tbSingleton.setVideoChannelRecommendRedIcon(null);
                        VideoPlayView videoPlayView2 = this.f21945a.f21935f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.u();
                        }
                        VideoPlayView videoPlayView3 = this.f21945a.f21935f;
                        if (videoPlayView3 != null) {
                            videoPlayView3.H(this.f21945a.isPrimary());
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
    public static final class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21946a;

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
            this.f21946a = videoVerticalPageFragment;
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
                        if (this.f21946a.f21936g.f(optString)) {
                            VideoPlayView videoPlayView = this.f21946a.f21935f;
                            if (videoPlayView != null) {
                                videoPlayView.u();
                            }
                            VideoPlayView videoPlayView2 = this.f21946a.f21935f;
                            if (videoPlayView2 != null) {
                                videoPlayView2.H(this.f21946a.isPrimary());
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
    public static final class i implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21947a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public i(VideoVerticalPageFragment videoVerticalPageFragment) {
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
            this.f21947a = videoVerticalPageFragment;
        }

        @Override // d.a.p0.v0.a.f
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && d.a.p0.v0.a.h().k("6061002332-203360688") && this.f21947a.f21935f != null) {
                d.a.p0.x3.c.d dVar = this.f21947a.f21936g;
                VideoPlayView videoPlayView = this.f21947a.f21935f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                dVar.a(videoPlayView.j);
                VideoPlayView videoPlayView2 = this.f21947a.f21935f;
                if (videoPlayView2 != null) {
                    videoPlayView2.u();
                }
            }
        }

        @Override // d.a.p0.v0.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class j implements BdSwipeRefreshLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21948a;

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
            this.f21948a = videoVerticalPageFragment;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
        public final void a(int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) && z && Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_ATTENTION_TAB, this.f21948a.k) && this.f21948a.getPageContext() != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f21948a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                if (pageContext.getPageActivity() != null) {
                    TbPageContext<BaseFragmentActivity> pageContext2 = this.f21948a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                    Activity pageActivity = pageContext2.getPageActivity();
                    TbPageContext<BaseFragmentActivity> pageContext3 = this.f21948a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext3, "pageContext");
                    d.a.c.e.p.l.M(pageActivity, pageContext3.getPageActivity().getString(R.string.no_more_production));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class k implements VideoPlayView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21949a;

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
            this.f21949a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.d
        public final void a() {
            VideoChannelModel videoChannelModel;
            VideoPlayModel videoPlayModel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f21949a.m) {
                if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_NANI_VIDEO, this.f21949a.k)) {
                    VideoPlayModel videoPlayModel2 = this.f21949a.r;
                    if (videoPlayModel2 != null) {
                        videoPlayModel2.setFrom(this.f21949a.l);
                    }
                    if (this.f21949a.f21936g.q() || (videoPlayModel = this.f21949a.r) == null) {
                        return;
                    }
                    videoPlayModel.A(this.f21949a.f21936g.n(0));
                    return;
                }
                VideoChannelModel videoChannelModel2 = this.f21949a.s;
                if (videoChannelModel2 != null) {
                    videoChannelModel2.setFrom(this.f21949a.l);
                }
                if (this.f21949a.f21936g.q() || (videoChannelModel = this.f21949a.s) == null) {
                    return;
                }
                videoChannelModel.loadMore();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class l implements VideoPlayView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21950a;

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
            this.f21950a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_ATTENTION_TAB, this.f21950a.k) && this.f21950a.getPageContext() != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f21950a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                if (pageContext.getPageActivity() != null) {
                    TbPageContext<BaseFragmentActivity> pageContext2 = this.f21950a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                    Activity pageActivity = pageContext2.getPageActivity();
                    TbPageContext<BaseFragmentActivity> pageContext3 = this.f21950a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext3, "pageContext");
                    d.a.c.e.p.l.M(pageActivity, pageContext3.getPageActivity().getString(R.string.no_more_production));
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoVerticalPageFragment() {
        this(null, 0, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((BdSwipeRefreshLayout.k) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), (DefaultConstructorMarker) objArr[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public VideoVerticalPageFragment(BdSwipeRefreshLayout.k kVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.C = kVar;
        this.D = i2;
        this.f21936g = new d.a.p0.x3.c.d();
        this.m = true;
        this.v = new a(this);
        this.w = new g(this, 2921581);
        this.x = new e(this, 2921566, true);
        this.y = new h(this, 2016488);
        this.z = new f(this, 2000994);
        this.A = new j(this);
        this.B = new l(this);
    }

    public final long R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoItemData n = this.f21936g.n(this.f21937h);
            if (n == null || TextUtils.isEmpty(n.thread_id)) {
                return 0L;
            }
            return d.a.c.e.m.b.f(n.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    public final a.b S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v : (a.b) invokeV.objValue;
    }

    public final void T0(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) || (videoPlayView = this.f21935f) == null) {
            return;
        }
        videoPlayView.r(i2, i3, intent);
    }

    public final boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VideoPlayView videoPlayView = this.f21935f;
            return videoPlayView != null && videoPlayView.s();
        }
        return invokeV.booleanValue;
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            VideoPlayView videoPlayView = this.f21935f;
            if (videoPlayView == null) {
                Intrinsics.throwNpe();
            }
            int i2 = videoPlayView.k;
            VideoPlayView videoPlayView2 = this.f21935f;
            if (videoPlayView2 == null) {
                Intrinsics.throwNpe();
            }
            if (i2 != videoPlayView2.j) {
                VideoPlayView videoPlayView3 = this.f21935f;
                if (videoPlayView3 == null) {
                    Intrinsics.throwNpe();
                }
                if (videoPlayView3.j >= 0) {
                    VideoPlayView videoPlayView4 = this.f21935f;
                    if (videoPlayView4 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (videoPlayView4.j < this.f21936g.h()) {
                        d.a.p0.x3.c.d dVar = this.f21936g;
                        VideoPlayView videoPlayView5 = this.f21935f;
                        if (videoPlayView5 == null) {
                            Intrinsics.throwNpe();
                        }
                        VideoItemData n = dVar.n(videoPlayView5.j);
                        if (n == null || StringUtils.isNull(n.thread_id)) {
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, n.thread_id));
                    }
                }
            }
        }
    }

    public final void W0(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (view = this.f21934e) == null) {
            return;
        }
        if (view == null) {
            Intrinsics.throwNpe();
        }
        int paddingLeft = view.getPaddingLeft();
        View view2 = this.f21934e;
        if (view2 == null) {
            Intrinsics.throwNpe();
        }
        int paddingTop = view2.getPaddingTop();
        View view3 = this.f21934e;
        if (view3 == null) {
            Intrinsics.throwNpe();
        }
        int paddingRight = view3.getPaddingRight();
        View view4 = this.f21934e;
        if (view4 == null) {
            Intrinsics.throwNpe();
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, view4.getPaddingBottom() + i2);
    }

    public final void X0(a.b bVar) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (videoPlayView = this.f21935f) == null) {
            return;
        }
        videoPlayView.A(bVar);
    }

    public final void Y0() {
        VideoPlayView videoPlayView;
        VideoPlayView videoPlayView2;
        VideoPlayView videoPlayView3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            Activity pageActivity = pageContext.getPageActivity();
            if (pageActivity != null) {
                this.f21935f = new VideoPlayView((FragmentActivity) pageActivity, this, this.l, getUniqueId(), 1);
                if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB, this.l) && (videoPlayView3 = this.f21935f) != null) {
                    videoPlayView3.K("from_suggest_sub_fragment");
                }
                VideoPlayView videoPlayView4 = this.f21935f;
                if (videoPlayView4 != null) {
                    BdSwipeRefreshLayout.k kVar = this.C;
                    if (kVar == null) {
                        kVar = this.A;
                    }
                    videoPlayView4.I(kVar);
                }
                VideoPlayView videoPlayView5 = this.f21935f;
                if (videoPlayView5 != null) {
                    videoPlayView5.y(this.B);
                }
                if (this.D != 1 && (videoPlayView2 = this.f21935f) != null) {
                    videoPlayView2.A(this.v);
                }
                VideoPlayView videoPlayView6 = this.f21935f;
                if (videoPlayView6 != null) {
                    videoPlayView6.F(new k(this));
                }
                VideoPlayView videoPlayView7 = this.f21935f;
                if (videoPlayView7 != null) {
                    videoPlayView7.N(this.f21936g, this.f21937h, this.j);
                }
                VideoPlayView videoPlayView8 = this.f21935f;
                if (videoPlayView8 != null) {
                    videoPlayView8.G(this.k);
                }
                VideoPlayView videoPlayView9 = this.f21935f;
                if (videoPlayView9 != null) {
                    videoPlayView9.B(this.q);
                }
                VideoPlayView videoPlayView10 = this.f21935f;
                if (videoPlayView10 != null) {
                    videoPlayView10.L(this.D);
                }
                if (!Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_ATTENTION_TAB, this.k) || (videoPlayView = this.f21935f) == null) {
                    return;
                }
                videoPlayView.J(this.f21938i, false);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public final void Z0(VideoItemData videoItemData, List<? extends VideoItemData> list) {
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

    public final void a1(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, videoItemData, list) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.o0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB, this.l) ? "a088" : "a023" : (String) invokeV.objValue;
    }

    public final void initData() {
        int i2;
        int i3;
        boolean z;
        VideoChannelModel videoChannelModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f21936g.c();
            Bundle arguments = getArguments();
            this.f21936g.s((ArrayList) (arguments != null ? arguments.getSerializable(VideoPlayActivityConfig.VIDEO_LIST) : null));
            if (getArguments() != null) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    Intrinsics.throwNpe();
                }
                i2 = arguments2.getInt(VideoPlayActivityConfig.VIDEO_INDEX, 0);
            } else {
                i2 = 0;
            }
            this.f21937h = i2;
            if (getArguments() != null) {
                Bundle arguments3 = getArguments();
                if (arguments3 == null) {
                    Intrinsics.throwNpe();
                }
                i3 = arguments3.getInt(VideoPlayActivityConfig.VIDEO_SHOW_INDEX, 0);
            } else {
                i3 = 0;
            }
            this.f21938i = i3;
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
                z = arguments8.getBoolean(VideoPlayActivityConfig.PARAM_IS_VERTAIL, true);
            } else {
                z = false;
            }
            this.p = z;
            if (this.f21936g.p() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.f21936g.s(VideoPlayActivityConfig.bigDataList);
            }
            this.f21936g.v(getUniqueId());
            if (Intrinsics.areEqual(this.l, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB)) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
                W0(inst.getMainTabBottomBarHeight());
                this.f21936g.w("a088");
            } else {
                this.f21936g.w("a023");
            }
            if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_NANI_VIDEO, this.k)) {
                if (VideoMiddleAdSwitch.isOn()) {
                    d.a.p0.v0.a.h().n(getActivity(), new b(this), this.f21936g.k());
                }
                VideoPlayModel videoPlayModel = new VideoPlayModel(getPageContext());
                this.r = videoPlayModel;
                if (videoPlayModel != null) {
                    videoPlayModel.setFrom(this.l);
                }
                VideoPlayModel videoPlayModel2 = this.r;
                if (videoPlayModel2 != null) {
                    videoPlayModel2.C(new c(this));
                }
                if (this.f21936g.n(0) != null) {
                    VideoItemData n = this.f21936g.n(0);
                    this.q = n != null ? n.thread_id : null;
                }
                VideoPlayModel videoPlayModel3 = this.r;
                if (videoPlayModel3 != null) {
                    videoPlayModel3.setFrom(this.l);
                }
                VideoPlayModel videoPlayModel4 = this.r;
                if (videoPlayModel4 != null) {
                    videoPlayModel4.B(this.f21936g.n(0), this.n, this.o, this.p);
                }
            } else if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_ATTENTION_TAB, this.k)) {
                if (this.f21938i >= this.f21936g.h()) {
                    this.f21938i = 0;
                }
            } else {
                VideoChannelModel videoChannelModel2 = new VideoChannelModel(getPageContext(), getUniqueId());
                this.s = videoChannelModel2;
                if (videoChannelModel2 != null) {
                    videoChannelModel2.setFrom(this.l);
                }
                VideoChannelModel videoChannelModel3 = this.s;
                if (videoChannelModel3 != null) {
                    videoChannelModel3.F(this.D);
                }
                VideoChannelModel videoChannelModel4 = this.s;
                if (videoChannelModel4 != null) {
                    videoChannelModel4.G(new d(this));
                }
                if (this.f21936g.n(0) != null) {
                    VideoItemData n2 = this.f21936g.n(0);
                    this.q = n2 != null ? n2.thread_id : null;
                }
                VideoChannelModel videoChannelModel5 = this.s;
                if (videoChannelModel5 != null) {
                    videoChannelModel5.setFrom(this.l);
                }
                if ((d.a.c.e.p.j.z() || isPrimary()) && (videoChannelModel = this.s) != null) {
                    videoChannelModel.E();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onActivityCreated(bundle);
            initData();
            Y0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                T0(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            VideoPlayView videoPlayView = this.f21935f;
            if (videoPlayView != null) {
                videoPlayView.v(i2);
            }
            SkinManager.setBackgroundColor(this.f21934e, R.color.CAM_X0611);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.y);
            registerListener(this.x);
            registerListener(this.z);
            registerListener(this.w);
            View inflate = layoutInflater.inflate(R.layout.video_vertical_page_fragment, viewGroup, false);
            this.f21934e = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            VideoPlayView videoPlayView = this.f21935f;
            if (videoPlayView != null) {
                videoPlayView.w();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroyView();
            d.a.p0.v0.a.h().c("6061002332-203360688");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f21935f;
            if (videoPlayView != null) {
                videoPlayView.x();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrimary();
            if (this.u) {
                d.a.p0.x3.b.a(1);
            }
            VideoPlayView videoPlayView = this.f21935f;
            if (videoPlayView != null) {
                videoPlayView.H(isPrimary());
            }
            if (this.t || !isPrimary() || !VideoMiddleAdSwitch.isOn() || (!Intrinsics.areEqual(this.l, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB))) {
                return;
            }
            this.t = true;
            d.a.p0.v0.a.h().n(getActivity(), new i(this), this.f21936g.k());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.setUserVisibleHint(z);
            VideoPlayView videoPlayView = this.f21935f;
            if (videoPlayView != null) {
                videoPlayView.z(z);
            }
            this.u = z;
        }
    }

    public /* synthetic */ VideoVerticalPageFragment(BdSwipeRefreshLayout.k kVar, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : kVar, (i3 & 2) != 0 ? 0 : i2);
    }
}
