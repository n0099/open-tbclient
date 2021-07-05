package com.baidu.tieba.videoplay.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.tieba.videoplay.model.VideoAttentionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J\u0012\b\b\u0002\u0010G\u001a\u00020\u0005¢\u0006\u0004\bP\u0010QJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010\u0011J\u000f\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010\u0011J\u000f\u0010$\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\u0011J\u000f\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010\u0011J\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010\u0011J\u0017\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\u001aJ\u000f\u0010)\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010\u0011J\u000f\u0010*\u001a\u00020\rH\u0002¢\u0006\u0004\b*\u0010\u000fJ\u000f\u0010+\u001a\u00020\rH\u0002¢\u0006\u0004\b+\u0010\u000fR\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0018\u00107\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00105R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0019\u0010G\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010C\u001a\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006R"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoAttentionPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "", "getCurrentPageKey", "()Ljava/lang/String;", "", "requestCode", MiPushCommandMessage.KEY_RESULT_CODE, "Landroid/content/Intent;", "data", "", "handleActivityResult", "(IILandroid/content/Intent;)V", "", "handleBackPress", "()Z", "handleIndexMessage", "()V", "initData", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/os/Bundle;)V", "onActivityResult", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", MissionEvent.MESSAGE_RESUME, "height", "setEmptyHeight", "showData", "showNoLoginData", "whetherHasVideo", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "isVertail", "Z", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFeedBackListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFrom", "Ljava/lang/String;", "mFromPage", "mLocate", "mObjId", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "Lcom/baidu/tieba/videoplay/model/VideoAttentionModel;", "mVideoAttentionModel", "Lcom/baidu/tieba/videoplay/model/VideoAttentionModel;", "mVideoIndex", "I", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mainPageType", "getMainPageType", "()I", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "<init>", "(Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;I)V", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public final class VideoAttentionPageFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f21854e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayView f21855f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.s0.x3.b.c f21856g;

    /* renamed from: h  reason: collision with root package name */
    public int f21857h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f21858i;
    public String j;
    public String k;
    public String l;
    public VideoAttentionModel m;
    public final CustomMessageListener n;
    public VideoPlayView.h o;
    public final BdSwipeRefreshLayout.k p;
    public final int q;

    /* loaded from: classes5.dex */
    public static final class a implements VideoAttentionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f21859a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(VideoAttentionPageFragment videoAttentionPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21859a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f21859a.f21856g.o(list);
            VideoPlayView videoPlayView = this.f21859a.f21855f;
            if (videoPlayView != null) {
                videoPlayView.A();
            }
            VideoPlayView videoPlayView2 = this.f21859a.f21855f;
            if (videoPlayView2 != null) {
                videoPlayView2.T(0, true);
            }
            VideoPlayView videoPlayView3 = this.f21859a.f21855f;
            if (videoPlayView3 != null) {
                videoPlayView3.R(this.f21859a.isPrimary());
            }
            VideoPlayView videoPlayView4 = this.f21859a.f21855f;
            if (videoPlayView4 != null) {
                videoPlayView4.X(true);
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void b(List<? extends VideoItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f21859a.f21856g.m()) {
                return;
            }
            this.f21859a.f21856g.b(list);
            VideoPlayView videoPlayView = this.f21859a.f21855f;
            if (videoPlayView != null) {
                videoPlayView.A();
            }
            VideoPlayView videoPlayView2 = this.f21859a.f21855f;
            if (videoPlayView2 != null) {
                videoPlayView2.X(true);
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void c(List<? extends VideoAttentionPersonListData> list, String str, boolean z) {
            VideoAttentionListPageFragment q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, list, str, z) == null) {
                this.f21859a.f21856g.p(list, str);
                VideoPlayView videoPlayView = this.f21859a.f21855f;
                if (videoPlayView != null) {
                    videoPlayView.A();
                }
                VideoPlayView videoPlayView2 = this.f21859a.f21855f;
                if (videoPlayView2 != null && (q = videoPlayView2.q()) != null) {
                    q.I0(0);
                }
                VideoPlayView videoPlayView3 = this.f21859a.f21855f;
                if (videoPlayView3 != null) {
                    videoPlayView3.X(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f21860a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoAttentionPageFragment videoAttentionPageFragment, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageFragment, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.f21860a = videoAttentionPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    if (this.f21860a.f21856g.c(((Integer) data).intValue())) {
                        VideoPlayView videoPlayView = this.f21860a.f21855f;
                        if (videoPlayView != null) {
                            videoPlayView.A();
                        }
                        VideoPlayView videoPlayView2 = this.f21860a.f21855f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.R(this.f21860a.isPrimary());
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
    public static final class c implements VideoPlayView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f21861a;

        public c(VideoAttentionPageFragment videoAttentionPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21861a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.g
        public final void a() {
            VideoAttentionModel videoAttentionModel;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoAttentionModel videoAttentionModel2 = this.f21861a.m;
                if (videoAttentionModel2 != null) {
                    videoAttentionModel2.setFrom(this.f21861a.k);
                }
                if (this.f21861a.f21856g.e() <= 0 || (videoAttentionModel = this.f21861a.m) == null) {
                    return;
                }
                videoAttentionModel.loadMore();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements VideoPlayView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f21862a;

        public d(VideoAttentionPageFragment videoAttentionPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21862a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.h
        public final void a() {
            VideoAttentionModel videoAttentionModel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB, this.f21862a.k) && this.f21862a.P0() && this.f21862a.getPageContext() != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f21862a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                if (pageContext.getPageActivity() == null || (videoAttentionModel = this.f21862a.m) == null || videoAttentionModel.mHasMore != 0) {
                    return;
                }
                TbPageContext<BaseFragmentActivity> pageContext2 = this.f21862a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                Activity pageActivity = pageContext2.getPageActivity();
                TbPageContext<BaseFragmentActivity> pageContext3 = this.f21862a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext3, "pageContext");
                l.M(pageActivity, pageContext3.getPageActivity().getString(R.string.no_more_production));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoAttentionPageFragment() {
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

    public VideoAttentionPageFragment(BdSwipeRefreshLayout.k kVar, int i2) {
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
        this.p = kVar;
        this.q = i2;
        this.f21856g = new d.a.s0.x3.b.c();
        this.n = new b(this, 2921566, true);
        this.o = new d(this);
    }

    public final void L0(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) || (videoPlayView = this.f21855f) == null) {
            return;
        }
        videoPlayView.t(i2, i3, intent);
    }

    public final void M0(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (view = this.f21854e) == null) {
            return;
        }
        if (view == null) {
            Intrinsics.throwNpe();
        }
        int paddingLeft = view.getPaddingLeft();
        View view2 = this.f21854e;
        if (view2 == null) {
            Intrinsics.throwNpe();
        }
        int paddingTop = view2.getPaddingTop() + UtilHelper.getStatusBarHeight();
        View view3 = this.f21854e;
        if (view3 == null) {
            Intrinsics.throwNpe();
        }
        int paddingRight = view3.getPaddingRight();
        View view4 = this.f21854e;
        if (view4 == null) {
            Intrinsics.throwNpe();
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, view4.getPaddingBottom() + i2);
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            Activity pageActivity = pageContext.getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView = new VideoPlayView((FragmentActivity) pageActivity, this, this.k, getUniqueId(), 0);
                this.f21855f = videoPlayView;
                if (videoPlayView != null) {
                    videoPlayView.S(this.p);
                }
                VideoPlayView videoPlayView2 = this.f21855f;
                if (videoPlayView2 != null) {
                    videoPlayView2.L(this.o);
                }
                VideoPlayView videoPlayView3 = this.f21855f;
                if (videoPlayView3 != null) {
                    videoPlayView3.P(new c(this));
                }
                VideoPlayView videoPlayView4 = this.f21855f;
                if (videoPlayView4 != null) {
                    videoPlayView4.Y(this.f21856g, this.f21857h, this.f21858i);
                }
                VideoPlayView videoPlayView5 = this.f21855f;
                if (videoPlayView5 != null) {
                    videoPlayView5.Q(this.j);
                }
                VideoPlayView videoPlayView6 = this.f21855f;
                if (videoPlayView6 != null) {
                    videoPlayView6.O(this.l);
                }
                VideoPlayView videoPlayView7 = this.f21855f;
                if (videoPlayView7 != null) {
                    videoPlayView7.U(this.q);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public final boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return false;
            }
            d.a.s0.x3.b.c cVar = this.f21856g;
            if (cVar != null) {
                cVar.q();
            }
            VideoPlayView videoPlayView = this.f21855f;
            if (videoPlayView != null) {
                videoPlayView.A();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f21856g.d() == null) {
                return false;
            }
            if (this.f21856g.d().size() == 1) {
                VideoItemModel videoItemModel = this.f21856g.d().get(0);
                Intrinsics.checkExpressionValueIsNotNull(videoItemModel, "dataController.dataList[0]");
                VideoItemModel videoItemModel2 = videoItemModel;
                if (videoItemModel2 != null && (videoItemModel2.getDataType() == 1 || videoItemModel2.getDataType() == 2)) {
                    return true;
                }
            } else if (this.f21856g.d().size() > 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB, this.k) ? "a089" : "a023" : (String) invokeV.objValue;
    }

    public final void initData() {
        int i2;
        VideoAttentionModel videoAttentionModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Bundle arguments = getArguments();
            this.f21856g.o((ArrayList) (arguments != null ? arguments.getSerializable(VideoPlayActivityConfig.VIDEO_LIST) : null));
            if (getArguments() != null) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    Intrinsics.throwNpe();
                }
                i2 = arguments2.getInt(VideoPlayActivityConfig.VIDEO_INDEX, 0);
            } else {
                i2 = 0;
            }
            this.f21857h = i2;
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            Activity pageActivity = pageContext.getPageActivity();
            Intrinsics.checkExpressionValueIsNotNull(pageActivity, "pageContext.pageActivity");
            Intent intent = pageActivity.getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent, "pageContext.pageActivity.intent");
            this.f21858i = intent.getSourceBounds();
            Bundle arguments3 = getArguments();
            this.j = arguments3 != null ? arguments3.getString("page_from") : null;
            Bundle arguments4 = getArguments();
            this.k = arguments4 != null ? arguments4.getString("from") : null;
            Bundle arguments5 = getArguments();
            if (arguments5 != null) {
                arguments5.getString("st_type");
            }
            Bundle arguments6 = getArguments();
            if (arguments6 != null) {
                arguments6.getString("yuelaou_locate");
            }
            if (getArguments() != null) {
                Bundle arguments7 = getArguments();
                if (arguments7 == null) {
                    Intrinsics.throwNpe();
                }
                arguments7.getBoolean(VideoPlayActivityConfig.PARAM_IS_VERTAIL, true);
            }
            if (this.f21856g.m() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.f21856g.o(VideoPlayActivityConfig.bigDataList);
            }
            this.f21856g.r(getUniqueId());
            if (Intrinsics.areEqual(this.k, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB)) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
                M0(inst.getMainTabBottomBarHeight());
                this.f21856g.s("a088");
            } else {
                this.f21856g.s("a023");
            }
            VideoAttentionModel videoAttentionModel2 = new VideoAttentionModel(getPageContext(), getUniqueId());
            this.m = videoAttentionModel2;
            if (videoAttentionModel2 != null) {
                videoAttentionModel2.setFrom(this.k);
            }
            VideoAttentionModel videoAttentionModel3 = this.m;
            if (videoAttentionModel3 != null) {
                videoAttentionModel3.H(0);
            }
            VideoAttentionModel videoAttentionModel4 = this.m;
            if (videoAttentionModel4 != null) {
                videoAttentionModel4.I(new a(this));
            }
            if (this.f21856g.k(0) != null) {
                VideoItemData k = this.f21856g.k(0);
                this.l = k != null ? k.thread_id : null;
            }
            VideoAttentionModel videoAttentionModel5 = this.m;
            if (videoAttentionModel5 != null) {
                videoAttentionModel5.setFrom(this.k);
            }
            if (O0() || (videoAttentionModel = this.m) == null) {
                return;
            }
            videoAttentionModel.G();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onActivityCreated(bundle);
            initData();
            N0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                L0(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            VideoPlayView videoPlayView = this.f21855f;
            if (videoPlayView != null) {
                videoPlayView.B(i2);
            }
            SkinManager.setBackgroundColor(this.f21854e, R.color.CAM_X0611);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.n);
            this.f21854e = layoutInflater.inflate(R.layout.video_vertical_page_fragment, viewGroup, false);
            d.a.s0.x3.a.a(2);
            return this.f21854e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            VideoPlayView videoPlayView = this.f21855f;
            if (videoPlayView != null) {
                videoPlayView.F();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroyView();
            d.a.s0.v0.a.h().c("6061002332-203360688");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f21855f;
            if (videoPlayView != null) {
                videoPlayView.G();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            VideoPlayView videoPlayView = this.f21855f;
            if (videoPlayView != null) {
                videoPlayView.R(isPrimary());
            }
            if (O0()) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            if (O0()) {
            }
        }
    }

    public /* synthetic */ VideoAttentionPageFragment(BdSwipeRefreshLayout.k kVar, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : kVar, (i3 & 2) != 0 ? 0 : i2);
    }
}
