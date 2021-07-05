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
import com.baidu.tbadk.core.util.UtilHelper;
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
import d.a.c.e.p.l;
import d.a.r0.b1.p.a;
import d.a.r0.r.q.b2;
import d.a.s0.v0.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThreadInfo;
import tbclient.VideoRedIcon.RedIcon;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010`\u0012\b\b\u0002\u0010_\u001a\u00020\u000b¢\u0006\u0004\bo\u0010pJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001d\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u0012J\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010 J-\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0010H\u0016¢\u0006\u0004\b(\u0010\u0017J\u000f\u0010)\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010\u0017J\u000f\u0010*\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010\u0017J\u000f\u0010+\u001a\u00020\u0010H\u0016¢\u0006\u0004\b+\u0010\u0017J\u000f\u0010,\u001a\u00020\u0010H\u0016¢\u0006\u0004\b,\u0010\u0017J\u0017\u0010.\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u000bH\u0002¢\u0006\u0004\b.\u0010 J\u0017\u00100\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0010H\u0002¢\u0006\u0004\b2\u0010\u0017J%\u00107\u001a\u00020\u00102\u0006\u00104\u001a\u0002032\f\u00106\u001a\b\u0012\u0004\u0012\u00020305H\u0002¢\u0006\u0004\b7\u00108J'\u00109\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u0001032\f\u00106\u001a\b\u0012\u0004\u0012\u00020305H\u0002¢\u0006\u0004\b9\u00108R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010D\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010ER\u0016\u0010G\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010@R\u0018\u0010H\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010ER\u0016\u0010I\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010CR\u0018\u0010J\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010ER\u0016\u0010K\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010CR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010O\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010ER\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010X\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010[\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010VR\u0016\u0010^\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010@R\u0016\u0010_\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010VR\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\"\u0010c\u001a\u00020`8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010b\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010i\u001a\u00020h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n¨\u0006q"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "", "getCurrentPageKey", "()Ljava/lang/String;", "", "getMissionTid", "()J", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "getVEventListener", "()Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "", "requestCode", MiPushCommandMessage.KEY_RESULT_CODE, "Landroid/content/Intent;", "data", "", "handleActivityResult", "(IILandroid/content/Intent;)V", "", "handleBackPress", "()Z", "handleIndexMessage", "()V", "initData", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/os/Bundle;)V", "onActivityResult", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", MissionEvent.MESSAGE_RESUME, "height", "setEmptyHeight", "listener", "setVideoPlayViewEventListener", "(Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;)V", "showData", "Lcom/baidu/tieba/video/VideoItemData;", "originalData", "", "newList", "syncFirstVideoFollowState", "(Lcom/baidu/tieba/video/VideoItemData;Ljava/util/List;)V", "syncFirstVideoThreadData", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "eventListener", "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPagerEventController$EventListener;", "isVertail", "Z", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFeedBackListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFrom", "Ljava/lang/String;", "mFromPage", "mHasMore", "mLocate", "mNetworkChangedMessageListener", "mObjId", "mRecommendTabInsertDataListener", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoChannelModel", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoIndex", "I", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "mVideoPlayModel", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoShowIndex", "mVideoTabReqFunAd", "mainPageType", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallbackFra", "getProgressViewCallbackFra", "()Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "setProgressViewCallbackFra", "(Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;)V", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "getViewPagerBottomScrollMoreCallback", "()Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "setViewPagerBottomScrollMoreCallback", "(Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;)V", "<init>", "(Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;I)V", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public final class VideoVerticalPageFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdSwipeRefreshLayout.k A;
    public final int B;

    /* renamed from: e  reason: collision with root package name */
    public View f21885e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayView f21886f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.s0.x3.b.c f21887g;

    /* renamed from: h  reason: collision with root package name */
    public int f21888h;

    /* renamed from: i  reason: collision with root package name */
    public int f21889i;
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
    public a.b u;
    public final CustomMessageListener v;
    public final CustomMessageListener w;
    public final CustomMessageListener x;
    public BdSwipeRefreshLayout.k y;
    public VideoPlayView.h z;

    /* loaded from: classes5.dex */
    public static final class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21890e;

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
            this.f21890e = videoVerticalPageFragment;
        }

        @Override // d.a.r0.b1.p.a.b
        public void N(float f2, float f3) {
            VideoPlayView videoPlayView;
            VideoPlayFragment r;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (videoPlayView = this.f21890e.f21886f) == null || (r = videoPlayView.r()) == null) {
                return;
            }
            r.N(f2, f3);
        }

        @Override // d.a.r0.b1.p.a.b
        public void k() {
            VideoPlayView videoPlayView;
            VideoPlayFragment r;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (videoPlayView = this.f21890e.f21886f) == null || (r = videoPlayView.r()) == null) {
                return;
            }
            r.k();
        }

        @Override // d.a.r0.b1.p.a.b
        public void l() {
            VideoPlayView videoPlayView;
            VideoPlayFragment r;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (videoPlayView = this.f21890e.f21886f) == null || (r = videoPlayView.r()) == null) {
                return;
            }
            r.l();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21891a;

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
            this.f21891a = videoVerticalPageFragment;
        }

        @Override // d.a.s0.v0.a.f
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && d.a.s0.v0.a.h().k("6061002332-203360688") && this.f21891a.f21886f != null) {
                d.a.s0.x3.b.c cVar = this.f21891a.f21887g;
                VideoPlayView videoPlayView = this.f21891a.f21886f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                cVar.a(videoPlayView.j);
                VideoPlayView videoPlayView2 = this.f21891a.f21886f;
                if (videoPlayView2 != null) {
                    videoPlayView2.A();
                }
            }
        }

        @Override // d.a.s0.v0.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements VideoPlayModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21892a;

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
            this.f21892a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.b
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) {
                this.f21892a.m = z;
                if (ListUtils.isEmpty(list) || this.f21892a.f21887g.m()) {
                    return;
                }
                VideoVerticalPageFragment videoVerticalPageFragment = this.f21892a;
                VideoItemData k = videoVerticalPageFragment.f21887g.k(0);
                if (k == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(k, "dataController.getVideoData(0)!!");
                videoVerticalPageFragment.Y0(k, list);
                VideoVerticalPageFragment videoVerticalPageFragment2 = this.f21892a;
                videoVerticalPageFragment2.Z0(videoVerticalPageFragment2.f21887g.k(0), list);
                this.f21892a.f21887g.o(list);
                if (d.a.s0.v0.a.h().k("6061002332-203360688") && this.f21892a.f21886f != null) {
                    d.a.s0.x3.b.c cVar = this.f21892a.f21887g;
                    VideoPlayView videoPlayView = this.f21892a.f21886f;
                    if (videoPlayView == null) {
                        Intrinsics.throwNpe();
                    }
                    cVar.a(videoPlayView.j - 1);
                }
                VideoPlayView videoPlayView2 = this.f21892a.f21886f;
                if (videoPlayView2 != null) {
                    videoPlayView2.A();
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.b
        public void b(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) {
                this.f21892a.m = z;
                if (ListUtils.isEmpty(list) || this.f21892a.f21887g.m()) {
                    return;
                }
                this.f21892a.f21887g.b(list);
                if (this.f21892a.f21886f != null) {
                    d.a.s0.x3.b.c cVar = this.f21892a.f21887g;
                    VideoPlayView videoPlayView = this.f21892a.f21886f;
                    if (videoPlayView == null) {
                        Intrinsics.throwNpe();
                    }
                    cVar.a(videoPlayView.j);
                }
                VideoPlayView videoPlayView2 = this.f21892a.f21886f;
                if (videoPlayView2 != null) {
                    videoPlayView2.A();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements VideoChannelModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21893a;

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
            this.f21893a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f21893a.f21887g.o(list);
            if (d.a.s0.v0.a.h().k("6061002332-203360688") && this.f21893a.f21886f != null) {
                d.a.s0.x3.b.c cVar = this.f21893a.f21887g;
                VideoPlayView videoPlayView = this.f21893a.f21886f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                cVar.a(videoPlayView.j);
            }
            VideoPlayView videoPlayView2 = this.f21893a.f21886f;
            if (videoPlayView2 != null) {
                videoPlayView2.A();
            }
            VideoPlayView videoPlayView3 = this.f21893a.f21886f;
            if (videoPlayView3 != null) {
                videoPlayView3.T(0, true);
            }
            VideoPlayView videoPlayView4 = this.f21893a.f21886f;
            if (videoPlayView4 != null) {
                videoPlayView4.R(this.f21893a.isPrimary());
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void b(List<? extends VideoItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f21893a.f21887g.m()) {
                return;
            }
            this.f21893a.f21887g.b(list);
            if (this.f21893a.f21886f != null) {
                d.a.s0.x3.b.c cVar = this.f21893a.f21887g;
                VideoPlayView videoPlayView = this.f21893a.f21886f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                cVar.a(videoPlayView.j);
            }
            VideoPlayView videoPlayView2 = this.f21893a.f21886f;
            if (videoPlayView2 != null) {
                videoPlayView2.A();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21894a;

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
            this.f21894a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    if (this.f21894a.f21887g.c(((Integer) data).intValue())) {
                        VideoPlayView videoPlayView = this.f21894a.f21886f;
                        if (videoPlayView != null) {
                            videoPlayView.A();
                        }
                        VideoPlayView videoPlayView2 = this.f21894a.f21886f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.R(this.f21894a.isPrimary());
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

    /* loaded from: classes5.dex */
    public static final class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21895a;

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
            this.f21895a = videoVerticalPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && d.a.c.e.p.j.z() && this.f21895a.f21887g.m()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921568));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21896a;

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
            this.f21896a = videoVerticalPageFragment;
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
                    d.a.s0.x3.b.c cVar = this.f21896a.f21887g;
                    VideoPlayView videoPlayView = this.f21896a.f21886f;
                    if (cVar.l(videoItemModel, videoPlayView != null ? videoPlayView.j : 0)) {
                        VideoPlayActivityStatic.a(redIcon);
                        TbSingleton tbSingleton = TbSingleton.getInstance();
                        Intrinsics.checkExpressionValueIsNotNull(tbSingleton, "TbSingleton.getInstance()");
                        tbSingleton.setVideoChannelRecommendRedIcon(null);
                        VideoPlayView videoPlayView2 = this.f21896a.f21886f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.A();
                        }
                        VideoPlayView videoPlayView3 = this.f21896a.f21886f;
                        if (videoPlayView3 != null) {
                            videoPlayView3.R(this.f21896a.isPrimary());
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

    /* loaded from: classes5.dex */
    public static final class h implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21897a;

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
            this.f21897a = videoVerticalPageFragment;
        }

        @Override // d.a.s0.v0.a.f
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && d.a.s0.v0.a.h().k("6061002332-203360688") && this.f21897a.f21886f != null) {
                d.a.s0.x3.b.c cVar = this.f21897a.f21887g;
                VideoPlayView videoPlayView = this.f21897a.f21886f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                cVar.a(videoPlayView.j);
                VideoPlayView videoPlayView2 = this.f21897a.f21886f;
                if (videoPlayView2 != null) {
                    videoPlayView2.A();
                }
            }
        }

        @Override // d.a.s0.v0.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class i implements BdSwipeRefreshLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21898a;

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
            this.f21898a = videoVerticalPageFragment;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
        public final void a(int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) && z && Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_ATTENTION_TAB, this.f21898a.k) && this.f21898a.getPageContext() != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f21898a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                if (pageContext.getPageActivity() != null) {
                    TbPageContext<BaseFragmentActivity> pageContext2 = this.f21898a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                    Activity pageActivity = pageContext2.getPageActivity();
                    TbPageContext<BaseFragmentActivity> pageContext3 = this.f21898a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext3, "pageContext");
                    l.M(pageActivity, pageContext3.getPageActivity().getString(R.string.no_more_production));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class j implements VideoPlayView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21899a;

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
            this.f21899a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.g
        public final void a() {
            VideoChannelModel videoChannelModel;
            VideoPlayModel videoPlayModel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f21899a.m) {
                if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_NANI_VIDEO, this.f21899a.k)) {
                    VideoPlayModel videoPlayModel2 = this.f21899a.r;
                    if (videoPlayModel2 != null) {
                        videoPlayModel2.setFrom(this.f21899a.l);
                    }
                    if (this.f21899a.f21887g.e() <= 0 || (videoPlayModel = this.f21899a.r) == null) {
                        return;
                    }
                    videoPlayModel.A(this.f21899a.f21887g.k(0));
                    return;
                }
                VideoChannelModel videoChannelModel2 = this.f21899a.s;
                if (videoChannelModel2 != null) {
                    videoChannelModel2.setFrom(this.f21899a.l);
                }
                if (this.f21899a.f21887g.e() <= 0 || (videoChannelModel = this.f21899a.s) == null) {
                    return;
                }
                videoChannelModel.loadMore();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class k implements VideoPlayView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoVerticalPageFragment f21900a;

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
            this.f21900a = videoVerticalPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.h
        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_ATTENTION_TAB, this.f21900a.k) && this.f21900a.getPageContext() != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f21900a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                if (pageContext.getPageActivity() != null) {
                    TbPageContext<BaseFragmentActivity> pageContext2 = this.f21900a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                    Activity pageActivity = pageContext2.getPageActivity();
                    TbPageContext<BaseFragmentActivity> pageContext3 = this.f21900a.getPageContext();
                    Intrinsics.checkExpressionValueIsNotNull(pageContext3, "pageContext");
                    l.M(pageActivity, pageContext3.getPageActivity().getString(R.string.no_more_production));
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
        this.A = kVar;
        this.B = i2;
        this.f21887g = new d.a.s0.x3.b.c();
        this.m = true;
        this.u = new a(this);
        this.v = new g(this, 2921581);
        this.w = new e(this, 2921566, true);
        this.x = new f(this, 2000994);
        this.y = new i(this);
        this.z = new k(this);
    }

    public final long Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoItemData k2 = this.f21887g.k(this.f21888h);
            if (k2 == null || TextUtils.isEmpty(k2.thread_id)) {
                return 0L;
            }
            return d.a.c.e.m.b.f(k2.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    public final a.b R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u : (a.b) invokeV.objValue;
    }

    public final void S0(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) || (videoPlayView = this.f21886f) == null) {
            return;
        }
        videoPlayView.t(i2, i3, intent);
    }

    public final boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VideoPlayView videoPlayView = this.f21886f;
            return videoPlayView != null && videoPlayView.u();
        }
        return invokeV.booleanValue;
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            VideoPlayView videoPlayView = this.f21886f;
            if (videoPlayView == null) {
                Intrinsics.throwNpe();
            }
            int i2 = videoPlayView.k;
            VideoPlayView videoPlayView2 = this.f21886f;
            if (videoPlayView2 == null) {
                Intrinsics.throwNpe();
            }
            if (i2 != videoPlayView2.j) {
                VideoPlayView videoPlayView3 = this.f21886f;
                if (videoPlayView3 == null) {
                    Intrinsics.throwNpe();
                }
                if (videoPlayView3.j >= 0) {
                    VideoPlayView videoPlayView4 = this.f21886f;
                    if (videoPlayView4 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (videoPlayView4.j < this.f21887g.e()) {
                        d.a.s0.x3.b.c cVar = this.f21887g;
                        VideoPlayView videoPlayView5 = this.f21886f;
                        if (videoPlayView5 == null) {
                            Intrinsics.throwNpe();
                        }
                        VideoItemData k2 = cVar.k(videoPlayView5.j);
                        if (k2 == null || StringUtils.isNull(k2.thread_id)) {
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, k2.thread_id));
                    }
                }
            }
        }
    }

    public final void V0(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (view = this.f21885e) == null) {
            return;
        }
        if (view == null) {
            Intrinsics.throwNpe();
        }
        int paddingLeft = view.getPaddingLeft();
        View view2 = this.f21885e;
        if (view2 == null) {
            Intrinsics.throwNpe();
        }
        int paddingTop = view2.getPaddingTop() + UtilHelper.getStatusBarHeight();
        View view3 = this.f21885e;
        if (view3 == null) {
            Intrinsics.throwNpe();
        }
        int paddingRight = view3.getPaddingRight();
        View view4 = this.f21885e;
        if (view4 == null) {
            Intrinsics.throwNpe();
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, view4.getPaddingBottom() + i2);
    }

    public final void W0(a.b bVar) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (videoPlayView = this.f21886f) == null) {
            return;
        }
        videoPlayView.M(bVar);
    }

    public final void X0() {
        VideoPlayView videoPlayView;
        VideoPlayView videoPlayView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            Activity pageActivity = pageContext.getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView3 = new VideoPlayView((FragmentActivity) pageActivity, this, this.l, getUniqueId(), 1);
                this.f21886f = videoPlayView3;
                if (videoPlayView3 != null) {
                    BdSwipeRefreshLayout.k kVar = this.A;
                    if (kVar == null) {
                        kVar = this.y;
                    }
                    videoPlayView3.S(kVar);
                }
                VideoPlayView videoPlayView4 = this.f21886f;
                if (videoPlayView4 != null) {
                    videoPlayView4.L(this.z);
                }
                if (this.B != 1 && (videoPlayView2 = this.f21886f) != null) {
                    videoPlayView2.M(this.u);
                }
                VideoPlayView videoPlayView5 = this.f21886f;
                if (videoPlayView5 != null) {
                    videoPlayView5.P(new j(this));
                }
                VideoPlayView videoPlayView6 = this.f21886f;
                if (videoPlayView6 != null) {
                    videoPlayView6.Y(this.f21887g, this.f21888h, this.j);
                }
                VideoPlayView videoPlayView7 = this.f21886f;
                if (videoPlayView7 != null) {
                    videoPlayView7.Q(this.k);
                }
                VideoPlayView videoPlayView8 = this.f21886f;
                if (videoPlayView8 != null) {
                    videoPlayView8.O(this.q);
                }
                VideoPlayView videoPlayView9 = this.f21886f;
                if (videoPlayView9 != null) {
                    videoPlayView9.U(this.B);
                }
                if (!Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_ATTENTION_TAB, this.k) || (videoPlayView = this.f21886f) == null) {
                    return;
                }
                videoPlayView.T(this.f21889i, false);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public final void Y0(VideoItemData videoItemData, List<? extends VideoItemData> list) {
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

    public final void Z0(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, videoItemData, list) == null) || videoItemData == null) {
            return;
        }
        VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list, 0);
        videoItemData.threadData = videoItemData2 != null ? videoItemData2.threadData : null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
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
            Bundle arguments = getArguments();
            this.f21887g.o((ArrayList) (arguments != null ? arguments.getSerializable(VideoPlayActivityConfig.VIDEO_LIST) : null));
            if (getArguments() != null) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    Intrinsics.throwNpe();
                }
                i2 = arguments2.getInt(VideoPlayActivityConfig.VIDEO_INDEX, 0);
            } else {
                i2 = 0;
            }
            this.f21888h = i2;
            if (getArguments() != null) {
                Bundle arguments3 = getArguments();
                if (arguments3 == null) {
                    Intrinsics.throwNpe();
                }
                i3 = arguments3.getInt(VideoPlayActivityConfig.VIDEO_SHOW_INDEX, 0);
            } else {
                i3 = 0;
            }
            this.f21889i = i3;
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
            if (this.f21887g.m() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.f21887g.o(VideoPlayActivityConfig.bigDataList);
            }
            this.f21887g.r(getUniqueId());
            if (Intrinsics.areEqual(this.l, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB)) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
                V0(inst.getMainTabBottomBarHeight());
                this.f21887g.s("a088");
            } else {
                this.f21887g.s("a023");
            }
            if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_NANI_VIDEO, this.k)) {
                if (VideoMiddleAdSwitch.isOn()) {
                    d.a.s0.v0.a.h().n(getActivity(), new b(this), this.f21887g.h());
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
                if (this.f21887g.k(0) != null) {
                    VideoItemData k2 = this.f21887g.k(0);
                    this.q = k2 != null ? k2.thread_id : null;
                }
                VideoPlayModel videoPlayModel3 = this.r;
                if (videoPlayModel3 != null) {
                    videoPlayModel3.setFrom(this.l);
                }
                VideoPlayModel videoPlayModel4 = this.r;
                if (videoPlayModel4 != null) {
                    videoPlayModel4.B(this.f21887g.k(0), this.n, this.o, this.p);
                }
            } else if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_ATTENTION_TAB, this.k)) {
                if (this.f21889i >= this.f21887g.e()) {
                    this.f21889i = 0;
                }
            } else {
                VideoChannelModel videoChannelModel2 = new VideoChannelModel(getPageContext(), getUniqueId());
                this.s = videoChannelModel2;
                if (videoChannelModel2 != null) {
                    videoChannelModel2.setFrom(this.l);
                }
                VideoChannelModel videoChannelModel3 = this.s;
                if (videoChannelModel3 != null) {
                    videoChannelModel3.F(this.B);
                }
                VideoChannelModel videoChannelModel4 = this.s;
                if (videoChannelModel4 != null) {
                    videoChannelModel4.G(new d(this));
                }
                if (this.f21887g.k(0) != null) {
                    VideoItemData k3 = this.f21887g.k(0);
                    this.q = k3 != null ? k3.thread_id : null;
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
            X0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                S0(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            VideoPlayView videoPlayView = this.f21886f;
            if (videoPlayView != null) {
                videoPlayView.B(i2);
            }
            SkinManager.setBackgroundColor(this.f21885e, R.color.CAM_X0611);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.w);
            registerListener(this.x);
            registerListener(this.v);
            this.f21885e = layoutInflater.inflate(R.layout.video_vertical_page_fragment, viewGroup, false);
            d.a.s0.x3.a.a(1);
            return this.f21885e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            VideoPlayView videoPlayView = this.f21886f;
            if (videoPlayView != null) {
                videoPlayView.F();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroyView();
            d.a.s0.v0.a.h().c("6061002332-203360688");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f21886f;
            if (videoPlayView != null) {
                videoPlayView.G();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrimary();
            VideoPlayView videoPlayView = this.f21886f;
            if (videoPlayView != null) {
                videoPlayView.R(isPrimary());
            }
            if (this.t || !isPrimary() || !VideoMiddleAdSwitch.isOn() || (!Intrinsics.areEqual(this.l, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB))) {
                return;
            }
            this.t = true;
            d.a.s0.v0.a.h().n(getActivity(), new h(this), this.f21887g.h());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
        }
    }

    public /* synthetic */ VideoVerticalPageFragment(BdSwipeRefreshLayout.k kVar, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : kVar, (i3 & 2) != 0 ? 0 : i2);
    }
}
