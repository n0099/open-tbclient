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
import c.a.e.e.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u0012\b\b\u0002\u0010S\u001a\u00020\t\u0012\b\b\u0002\u0010;\u001a\u00020\t¢\u0006\u0004\bZ\u0010[J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001b\u0010\u0010J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u000eH\u0016¢\u0006\u0004\b&\u0010\u0015J\u000f\u0010'\u001a\u00020\u000eH\u0016¢\u0006\u0004\b'\u0010\u0015J\u000f\u0010(\u001a\u00020\u000eH\u0016¢\u0006\u0004\b(\u0010\u0015J\u000f\u0010)\u001a\u00020\u000eH\u0016¢\u0006\u0004\b)\u0010\u0015J\u000f\u0010*\u001a\u00020\u000eH\u0016¢\u0006\u0004\b*\u0010\u0015J\u0017\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\tH\u0002¢\u0006\u0004\b,\u0010\u001eJ\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u0011H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u000eH\u0002¢\u0006\u0004\b0\u0010\u0015J\u000f\u00101\u001a\u00020\u0011H\u0002¢\u0006\u0004\b1\u0010\u0013J\u000f\u00102\u001a\u00020\u0011H\u0002¢\u0006\u0004\b2\u0010\u0013R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010B\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010AR\u0016\u0010C\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00107R\u0018\u0010D\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010AR\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010AR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010<R\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010<R\u0018\u0010U\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010Y¨\u0006\\"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoAttentionPageFragment;", "Lc/a/p0/y3/f/a;", "Lcom/baidu/tbadk/core/BaseFragment;", "", "getCurrentPageKey", "()Ljava/lang/String;", "", "getMissionTid", "()J", "", "requestCode", MiPushCommandMessage.KEY_RESULT_CODE, "Landroid/content/Intent;", "data", "", "handleActivityResult", "(IILandroid/content/Intent;)V", "", "handleBackPress", "()Z", "handleIndexMessage", "()V", "initData", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/os/Bundle;)V", "onActivityResult", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "height", "setEmptyHeight", "isVisibleToUser", "setUserVisibleHint", "(Z)V", "showData", "showNoLoginData", "whetherHasVideo", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "isVertail", "Z", "Lcom/baidu/adp/BdUniqueId;", "mActivityPageUniqueId", "Lcom/baidu/adp/BdUniqueId;", "mCurrentType", "I", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFeedBackListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFrom", "Ljava/lang/String;", "mFromPage", "mIsVisibleToUser", "mLocate", "mObjId", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "Lcom/baidu/tieba/videoplay/model/VideoAttentionModel;", "mVideoAttentionModel", "Lcom/baidu/tieba/videoplay/model/VideoAttentionModel;", "mVideoIndex", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mainPageType", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "<init>", "(Lcom/baidu/adp/BdUniqueId;Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;II)V", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class VideoAttentionPageFragment extends BaseFragment implements c.a.p0.y3.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f57635e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayView f57636f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.p0.y3.c.d f57637g;

    /* renamed from: h  reason: collision with root package name */
    public int f57638h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f57639i;

    /* renamed from: j  reason: collision with root package name */
    public String f57640j;
    public String k;
    public boolean l;
    public String m;
    public VideoAttentionModel n;
    public final CustomMessageListener o;
    public VideoPlayView.f p;
    public final BdUniqueId q;
    public final BdSwipeRefreshLayout.k r;
    public final int s;
    public final int t;

    /* loaded from: classes7.dex */
    public static final class a implements VideoAttentionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f57641a;

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
            this.f57641a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f57641a.f57637g.u(list);
            VideoPlayView videoPlayView = this.f57641a.f57636f;
            if (videoPlayView != null) {
                videoPlayView.notifyDataSetChanged();
            }
            VideoPlayView videoPlayView2 = this.f57641a.f57636f;
            if (videoPlayView2 != null) {
                videoPlayView2.setSelectIndex(0, true);
            }
            VideoPlayView videoPlayView3 = this.f57641a.f57636f;
            if (videoPlayView3 != null) {
                videoPlayView3.setPrimary(this.f57641a.isPrimary());
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void b(List<? extends VideoItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f57641a.f57637g.r()) {
                return;
            }
            this.f57641a.f57637g.b(list);
            VideoPlayView videoPlayView = this.f57641a.f57636f;
            if (videoPlayView != null) {
                videoPlayView.notifyDataSetChanged();
            }
            VideoPlayView videoPlayView2 = this.f57641a.f57636f;
            if (videoPlayView2 != null) {
                videoPlayView2.setViewPagerScrollable(true);
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void c(List<? extends VideoAttentionPersonListData> list, String str, boolean z) {
            VideoAttentionListPageFragment attentionListFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, list, str, z) == null) {
                this.f57641a.f57637g.v(list, str);
                VideoPlayView videoPlayView = this.f57641a.f57636f;
                if (videoPlayView != null) {
                    videoPlayView.notifyDataSetChanged();
                }
                VideoPlayView videoPlayView2 = this.f57641a.f57636f;
                if (videoPlayView2 != null && (attentionListFragment = videoPlayView2.getAttentionListFragment()) != null) {
                    attentionListFragment.scrollToPosition(0);
                }
                VideoPlayView videoPlayView3 = this.f57641a.f57636f;
                if (videoPlayView3 != null) {
                    videoPlayView3.setViewPagerScrollable(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f57642a;

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
            this.f57642a = videoAttentionPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    if (this.f57642a.f57637g.e(((Integer) data).intValue())) {
                        VideoPlayView videoPlayView = this.f57642a.f57636f;
                        if (videoPlayView != null) {
                            videoPlayView.notifyDataSetChanged();
                        }
                        VideoPlayView videoPlayView2 = this.f57642a.f57636f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.setPrimary(this.f57642a.isPrimary());
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
    public static final class c implements VideoPlayView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f57643a;

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
            this.f57643a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public final void a() {
            VideoAttentionModel videoAttentionModel;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoAttentionModel videoAttentionModel2 = this.f57643a.n;
                if (videoAttentionModel2 != null) {
                    videoAttentionModel2.setFrom(this.f57643a.k);
                }
                if (this.f57643a.f57637g.s() || (videoAttentionModel = this.f57643a.n) == null) {
                    return;
                }
                videoAttentionModel.loadMore();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements VideoPlayView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f57644a;

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
            this.f57644a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.f
        public final void a() {
            VideoAttentionModel videoAttentionModel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f57644a.t == 4 && this.f57644a.i() && this.f57644a.getPageContext() != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f57644a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                if (pageContext.getPageActivity() == null || (videoAttentionModel = this.f57644a.n) == null || videoAttentionModel.mHasMore != 0) {
                    return;
                }
                TbPageContext<BaseFragmentActivity> pageContext2 = this.f57644a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                Activity pageActivity = pageContext2.getPageActivity();
                TbPageContext<BaseFragmentActivity> pageContext3 = this.f57644a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext3, "pageContext");
                l.M(pageActivity, pageContext3.getPageActivity().getString(R.string.no_more_production));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoAttentionPageFragment() {
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

    public VideoAttentionPageFragment(BdUniqueId bdUniqueId, BdSwipeRefreshLayout.k kVar, int i2, int i3) {
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
        this.q = bdUniqueId;
        this.r = kVar;
        this.s = i2;
        this.t = i3;
        this.f57637g = new c.a.p0.y3.c.d();
        this.o = new b(this, 2921566, true);
        this.p = new d(this);
    }

    public final void b(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (view = this.f57635e) == null) {
            return;
        }
        if (view == null) {
            Intrinsics.throwNpe();
        }
        int paddingLeft = view.getPaddingLeft();
        View view2 = this.f57635e;
        if (view2 == null) {
            Intrinsics.throwNpe();
        }
        int paddingTop = view2.getPaddingTop();
        View view3 = this.f57635e;
        if (view3 == null) {
            Intrinsics.throwNpe();
        }
        int paddingRight = view3.getPaddingRight();
        View view4 = this.f57635e;
        if (view4 == null) {
            Intrinsics.throwNpe();
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, view4.getPaddingBottom() + i2);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BdUniqueId bdUniqueId = this.q;
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            Activity pageActivity = pageContext.getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView = new VideoPlayView(bdUniqueId, (FragmentActivity) pageActivity, this, this.k, getUniqueId(), 0, this.t);
                this.f57636f = videoPlayView;
                if (videoPlayView != null) {
                    videoPlayView.setSubFrom(VideoPlayView.FROM_ATTENTION_SUB_FRAGMENT);
                }
                VideoPlayView videoPlayView2 = this.f57636f;
                if (videoPlayView2 != null) {
                    videoPlayView2.setProgressViewCallback(this.r);
                }
                VideoPlayView videoPlayView3 = this.f57636f;
                if (videoPlayView3 != null) {
                    videoPlayView3.setBottomScrollMoreCallback(this.p);
                }
                VideoPlayView videoPlayView4 = this.f57636f;
                if (videoPlayView4 != null) {
                    videoPlayView4.setOnLoadMoreListener(new c(this));
                }
                VideoPlayView videoPlayView5 = this.f57636f;
                if (videoPlayView5 != null) {
                    videoPlayView5.showData(this.f57637g, this.f57638h, this.f57639i);
                }
                VideoPlayView videoPlayView6 = this.f57636f;
                if (videoPlayView6 != null) {
                    videoPlayView6.setPageFrom(this.f57640j);
                }
                VideoPlayView videoPlayView7 = this.f57636f;
                if (videoPlayView7 != null) {
                    videoPlayView7.setObjId(this.m);
                }
                VideoPlayView videoPlayView8 = this.f57636f;
                if (videoPlayView8 != null) {
                    videoPlayView8.setVideoChannelPageType(this.s);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.o0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t == 4 ? "a089" : "a023" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.y3.f.a
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VideoItemData p = this.f57637g.p(this.f57638h);
            if (p == null || TextUtils.isEmpty(p.thread_id)) {
                return 0L;
            }
            return c.a.e.e.m.b.f(p.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return false;
            }
            c.a.p0.y3.c.d dVar = this.f57637g;
            if (dVar != null) {
                dVar.w();
            }
            VideoPlayView videoPlayView = this.f57636f;
            if (videoPlayView != null) {
                videoPlayView.notifyDataSetChanged();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.y3.f.a
    public void handleActivityResult(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) || (videoPlayView = this.f57636f) == null) {
            return;
        }
        videoPlayView.handleActivityResult(i2, i3, intent);
    }

    @Override // c.a.p0.y3.f.a
    public boolean handleBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            VideoPlayView videoPlayView = this.f57636f;
            return videoPlayView != null && videoPlayView.handleBackPress();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.y3.f.a
    public void handleIndexMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            VideoPlayView videoPlayView = this.f57636f;
            if (videoPlayView == null) {
                Intrinsics.throwNpe();
            }
            int i2 = videoPlayView.firstInIndex;
            VideoPlayView videoPlayView2 = this.f57636f;
            if (videoPlayView2 == null) {
                Intrinsics.throwNpe();
            }
            if (i2 != videoPlayView2.currentSelectIndex) {
                VideoPlayView videoPlayView3 = this.f57636f;
                if (videoPlayView3 == null) {
                    Intrinsics.throwNpe();
                }
                if (videoPlayView3.currentSelectIndex >= 0) {
                    VideoPlayView videoPlayView4 = this.f57636f;
                    if (videoPlayView4 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (videoPlayView4.currentSelectIndex < this.f57637g.j()) {
                        c.a.p0.y3.c.d dVar = this.f57637g;
                        VideoPlayView videoPlayView5 = this.f57636f;
                        if (videoPlayView5 == null) {
                            Intrinsics.throwNpe();
                        }
                        VideoItemData p = dVar.p(videoPlayView5.currentSelectIndex);
                        if (p == null || StringUtils.isNull(p.thread_id)) {
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, p.thread_id));
                    }
                }
            }
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f57637g.i() == null) {
                return false;
            }
            if (this.f57637g.i().size() == 1) {
                VideoItemModel videoItemModel = this.f57637g.i().get(0);
                Intrinsics.checkExpressionValueIsNotNull(videoItemModel, "dataController.dataList[0]");
                VideoItemModel videoItemModel2 = videoItemModel;
                if (videoItemModel2 != null && (videoItemModel2.getDataType() == 1 || videoItemModel2.getDataType() == 2)) {
                    return true;
                }
            } else if (this.f57637g.i().size() > 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void initData() {
        int i2;
        VideoAttentionModel videoAttentionModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Bundle arguments = getArguments();
            this.f57637g.u((ArrayList) (arguments != null ? arguments.getSerializable("video_list") : null));
            if (getArguments() != null) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    Intrinsics.throwNpe();
                }
                i2 = arguments2.getInt("video_index", 0);
            } else {
                i2 = 0;
            }
            this.f57638h = i2;
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            Activity pageActivity = pageContext.getPageActivity();
            Intrinsics.checkExpressionValueIsNotNull(pageActivity, "pageContext.pageActivity");
            Intent intent = pageActivity.getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent, "pageContext.pageActivity.intent");
            this.f57639i = intent.getSourceBounds();
            Bundle arguments3 = getArguments();
            this.f57640j = arguments3 != null ? arguments3.getString("page_from") : null;
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
                arguments7.getBoolean("is_vertail", true);
            }
            if (this.f57637g.r() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.f57637g.u(VideoPlayActivityConfig.bigDataList);
            }
            this.f57637g.x(getUniqueId());
            if (this.t == 4) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
                b(inst.getMainTabBottomBarHeight());
                this.f57637g.y("a088");
            } else {
                this.f57637g.y("a023");
            }
            VideoAttentionModel videoAttentionModel2 = new VideoAttentionModel(getPageContext(), getUniqueId());
            this.n = videoAttentionModel2;
            if (videoAttentionModel2 != null) {
                videoAttentionModel2.setFrom(this.k);
            }
            VideoAttentionModel videoAttentionModel3 = this.n;
            if (videoAttentionModel3 != null) {
                videoAttentionModel3.H(0);
            }
            VideoAttentionModel videoAttentionModel4 = this.n;
            if (videoAttentionModel4 != null) {
                videoAttentionModel4.I(new a(this));
            }
            if (this.f57637g.p(0) != null) {
                VideoItemData p = this.f57637g.p(0);
                this.m = p != null ? p.thread_id : null;
            }
            VideoAttentionModel videoAttentionModel5 = this.n;
            if (videoAttentionModel5 != null) {
                videoAttentionModel5.setFrom(this.k);
            }
            if (h() || (videoAttentionModel = this.n) == null) {
                return;
            }
            videoAttentionModel.G();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onActivityCreated(bundle);
            initData();
            g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                handleActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            VideoPlayView videoPlayView = this.f57636f;
            if (videoPlayView != null) {
                videoPlayView.onChangeSkinType(i2);
            }
            SkinManager.setBackgroundColor(this.f57635e, R.color.CAM_X0611);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.o);
            View inflate = layoutInflater.inflate(R.layout.video_vertical_page_fragment, viewGroup, false);
            this.f57635e = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            VideoPlayView videoPlayView = this.f57636f;
            if (videoPlayView != null) {
                videoPlayView.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroyView();
            c.a.p0.w0.a.i().d("6061002332-203360688");
            c.a.p0.w0.a.i().c("6061002410-390177882");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f57636f;
            if (videoPlayView != null) {
                videoPlayView.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            if (this.l && this.t == 4) {
                c.a.p0.y3.b.a(2);
            }
            if (this.l && !i() && TbadkCoreApplication.isLogin()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_LIST_PAGE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
            VideoPlayView videoPlayView = this.f57636f;
            if (videoPlayView != null) {
                videoPlayView.setPrimary(isPrimary());
            }
            if (h()) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            if (h()) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            super.setUserVisibleHint(z);
            VideoPlayView videoPlayView = this.f57636f;
            if (videoPlayView != null) {
                videoPlayView.setCurrentFragmentUserHint(z);
            }
            this.l = z;
        }
    }

    public /* synthetic */ VideoAttentionPageFragment(BdUniqueId bdUniqueId, BdSwipeRefreshLayout.k kVar, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : bdUniqueId, (i4 & 2) != 0 ? null : kVar, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}
