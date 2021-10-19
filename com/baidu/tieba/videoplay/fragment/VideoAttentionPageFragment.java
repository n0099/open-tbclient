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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.util.SimpleMessageListener;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.VideoPlayActivity;
import com.baidu.tieba.videoplay.VideoPlayFragment;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\b\b\u0002\u0010X\u001a\u00020\t\u0012\b\b\u0002\u0010B\u001a\u00020\t¢\u0006\u0004\b_\u0010`J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001b\u0010\u0010J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u000eH\u0016¢\u0006\u0004\b&\u0010\u0015J\u000f\u0010'\u001a\u00020\u000eH\u0016¢\u0006\u0004\b'\u0010\u0015J\u000f\u0010(\u001a\u00020\u000eH\u0016¢\u0006\u0004\b(\u0010\u0015J\u000f\u0010)\u001a\u00020\u000eH\u0016¢\u0006\u0004\b)\u0010\u0015J\u000f\u0010*\u001a\u00020\u000eH\u0016¢\u0006\u0004\b*\u0010\u0015J\u0017\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\tH\u0002¢\u0006\u0004\b,\u0010\u001eJ\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u0011H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u000eH\u0002¢\u0006\u0004\b0\u0010\u0015J\u000f\u00101\u001a\u00020\u0011H\u0002¢\u0006\u0004\b1\u0010\u0013J\u000f\u00102\u001a\u00020\u000eH\u0002¢\u0006\u0004\b2\u0010\u0015J\u000f\u00103\u001a\u00020\u0011H\u0002¢\u0006\u0004\b3\u0010\u0013R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u00106R\u0018\u0010E\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR\u0016\u0010H\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010>R\u0018\u0010I\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010FR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010N\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010P\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010FR\u0018\u0010R\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010CR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010CR\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010]\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^¨\u0006a"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoAttentionPageFragment;", "Lc/a/r0/a4/f/a;", "Lcom/baidu/tbadk/core/BaseFragment;", "", "getCurrentPageKey", "()Ljava/lang/String;", "", "getMissionTid", "()J", "", "requestCode", MiPushCommandMessage.KEY_RESULT_CODE, "Landroid/content/Intent;", "data", "", "handleActivityResult", "(IILandroid/content/Intent;)V", "", "handleBackPress", "()Z", "handleIndexMessage", "()V", "initData", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/os/Bundle;)V", "onActivityResult", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "height", "setEmptyHeight", "isVisibleToUser", "setUserVisibleHint", "(Z)V", "showData", "showNoLoginData", "stepStat", "whetherHasVideo", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "backGroundListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "goPbCommentFloatListener", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "isVertail", "Z", "Lcom/baidu/adp/BdUniqueId;", "mActivityPageUniqueId", "Lcom/baidu/adp/BdUniqueId;", "mCurrentType", "I", "mFeedBackListener", "mFrom", "Ljava/lang/String;", "mFromPage", "mIsVisibleToUser", "mLocate", "mObjId", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "Lcom/baidu/tieba/videoplay/model/VideoAttentionModel;", "mVideoAttentionModel", "Lcom/baidu/tieba/videoplay/model/VideoAttentionModel;", "mVideoIndex", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mainPageType", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "<init>", "(Lcom/baidu/adp/BdUniqueId;Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;II)V", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class VideoAttentionPageFragment extends BaseFragment implements c.a.r0.a4.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f58041e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayView f58042f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.r0.a4.c.d f58043g;

    /* renamed from: h  reason: collision with root package name */
    public int f58044h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f58045i;

    /* renamed from: j  reason: collision with root package name */
    public String f58046j;
    public String k;
    public boolean l;
    public String m;
    public VideoAttentionModel n;
    public final VideoPlayFragment.GoPbCommentFloatListener o;
    public final CustomMessageListener p;
    public VideoPlayView.g q;
    public final CustomMessageListener r;
    public final BdUniqueId s;
    public final BdSwipeRefreshLayout.k t;
    public final int u;
    public final int v;

    /* loaded from: classes7.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f58047a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoAttentionPageFragment videoAttentionPageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageFragment, Integer.valueOf(i2)};
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
            this.f58047a = videoAttentionPageFragment;
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
                        if (c.a.e.a.b.g().b() instanceof c.a.r0.n3.a) {
                            Activity b2 = c.a.e.a.b.g().b();
                            if (b2 != null) {
                                if (((c.a.r0.n3.a) b2).getCurrentTabType() == 22) {
                                    z = true;
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type com.baidu.tieba.tblauncher.IMaintabType");
                            }
                        }
                        if ((this.f58047a.l && z) || ((c.a.e.a.b.g().b() instanceof VideoPlayActivity) && (this.f58047a.getActivity() instanceof VideoPlayActivity))) {
                            this.f58047a.i();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements SimpleMessageListener.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f58048a;

        public b(VideoAttentionPageFragment videoAttentionPageFragment) {
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
            this.f58048a = videoAttentionPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.util.SimpleMessageListener.b
        /* renamed from: a */
        public final void call(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                this.f58048a.setInterceptStimeStat(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements VideoAttentionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f58049a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
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
            this.f58049a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void a(List<? extends VideoItemData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f58049a.f58043g.y(list);
            VideoPlayView videoPlayView = this.f58049a.f58042f;
            if (videoPlayView != null) {
                videoPlayView.notifyDataSetChanged();
            }
            VideoPlayView videoPlayView2 = this.f58049a.f58042f;
            if (videoPlayView2 != null) {
                videoPlayView2.setSelectIndex(0, true);
            }
            VideoPlayView videoPlayView3 = this.f58049a.f58042f;
            if (videoPlayView3 != null) {
                videoPlayView3.setPrimary(this.f58049a.isPrimary());
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void b(List<? extends VideoItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f58049a.f58043g.v()) {
                return;
            }
            this.f58049a.f58043g.b(list);
            VideoPlayView videoPlayView = this.f58049a.f58042f;
            if (videoPlayView != null) {
                videoPlayView.notifyDataSetChanged();
            }
            VideoPlayView videoPlayView2 = this.f58049a.f58042f;
            if (videoPlayView2 != null) {
                videoPlayView2.setViewPagerScrollable(true);
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void c(List<? extends VideoAttentionPersonListData> list, String str, boolean z) {
            VideoAttentionListPageFragment attentionListFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, list, str, z) == null) {
                this.f58049a.f58043g.z(list, str);
                VideoPlayView videoPlayView = this.f58049a.f58042f;
                if (videoPlayView != null) {
                    videoPlayView.notifyDataSetChanged();
                }
                VideoPlayView videoPlayView2 = this.f58049a.f58042f;
                if (videoPlayView2 != null && (attentionListFragment = videoPlayView2.getAttentionListFragment()) != null) {
                    attentionListFragment.scrollToPosition(0);
                }
                VideoPlayView videoPlayView3 = this.f58049a.f58042f;
                if (videoPlayView3 != null) {
                    videoPlayView3.setViewPagerScrollable(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f58050a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VideoAttentionPageFragment videoAttentionPageFragment, int i2, boolean z) {
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
            this.f58050a = videoAttentionPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    if (this.f58050a.f58043g.e(((Integer) data).intValue())) {
                        VideoPlayView videoPlayView = this.f58050a.f58042f;
                        if (videoPlayView != null) {
                            videoPlayView.notifyDataSetChanged();
                        }
                        VideoPlayView videoPlayView2 = this.f58050a.f58042f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.setPrimary(this.f58050a.isPrimary());
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
    public static final class e implements VideoPlayView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f58051a;

        public e(VideoAttentionPageFragment videoAttentionPageFragment) {
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
            this.f58051a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public final void a() {
            VideoAttentionModel videoAttentionModel;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoAttentionModel videoAttentionModel2 = this.f58051a.n;
                if (videoAttentionModel2 != null) {
                    videoAttentionModel2.setFrom(this.f58051a.k);
                }
                if (this.f58051a.f58043g.w() || (videoAttentionModel = this.f58051a.n) == null) {
                    return;
                }
                videoAttentionModel.loadMore();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class f implements VideoPlayView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageFragment f58052a;

        public f(VideoAttentionPageFragment videoAttentionPageFragment) {
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
            this.f58052a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.g
        public final void a() {
            VideoAttentionModel videoAttentionModel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f58052a.v == 4 && this.f58052a.j() && this.f58052a.getPageContext() != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f58052a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                if (pageContext.getPageActivity() == null || (videoAttentionModel = this.f58052a.n) == null || videoAttentionModel.mHasMore != 0) {
                    return;
                }
                TbPageContext<BaseFragmentActivity> pageContext2 = this.f58052a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext2, "pageContext");
                Activity pageActivity = pageContext2.getPageActivity();
                TbPageContext<BaseFragmentActivity> pageContext3 = this.f58052a.getPageContext();
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
        this.s = bdUniqueId;
        this.t = kVar;
        this.u = i2;
        this.v = i3;
        this.f58043g = new c.a.r0.a4.c.d();
        this.o = new VideoPlayFragment.GoPbCommentFloatListener(new b(this));
        this.p = new d(this, 2921566, true);
        this.q = new f(this);
        this.r = new a(this, 2001011);
    }

    public final void b(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (view = this.f58041e) == null) {
            return;
        }
        if (view == null) {
            Intrinsics.throwNpe();
        }
        int paddingLeft = view.getPaddingLeft();
        View view2 = this.f58041e;
        if (view2 == null) {
            Intrinsics.throwNpe();
        }
        int paddingTop = view2.getPaddingTop();
        View view3 = this.f58041e;
        if (view3 == null) {
            Intrinsics.throwNpe();
        }
        int paddingRight = view3.getPaddingRight();
        View view4 = this.f58041e;
        if (view4 == null) {
            Intrinsics.throwNpe();
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, view4.getPaddingBottom() + i2);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BdUniqueId bdUniqueId = this.s;
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            Activity pageActivity = pageContext.getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView = new VideoPlayView(bdUniqueId, (FragmentActivity) pageActivity, this, this.k, getUniqueId(), 0, this.v, false);
                this.f58042f = videoPlayView;
                if (videoPlayView != null) {
                    videoPlayView.setSubFrom(VideoPlayView.FROM_ATTENTION_SUB_FRAGMENT);
                }
                VideoPlayView videoPlayView2 = this.f58042f;
                if (videoPlayView2 != null) {
                    videoPlayView2.setProgressViewCallback(this.t);
                }
                VideoPlayView videoPlayView3 = this.f58042f;
                if (videoPlayView3 != null) {
                    videoPlayView3.setBottomScrollMoreCallback(this.q);
                }
                VideoPlayView videoPlayView4 = this.f58042f;
                if (videoPlayView4 != null) {
                    videoPlayView4.setOnLoadMoreListener(new e(this));
                }
                VideoPlayView videoPlayView5 = this.f58042f;
                if (videoPlayView5 != null) {
                    videoPlayView5.showData(this.f58043g, this.f58044h, this.f58045i);
                }
                VideoPlayView videoPlayView6 = this.f58042f;
                if (videoPlayView6 != null) {
                    videoPlayView6.setPageFrom(this.f58046j);
                }
                VideoPlayView videoPlayView7 = this.f58042f;
                if (videoPlayView7 != null) {
                    videoPlayView7.setObjId(this.m);
                }
                VideoPlayView videoPlayView8 = this.f58042f;
                if (videoPlayView8 != null) {
                    videoPlayView8.setVideoChannelPageType(this.u);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.v == 4 ? "a089" : "a023" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.a4.f.a
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VideoItemData s = this.f58043g.s(this.f58044h);
            if (s == null || TextUtils.isEmpty(s.thread_id)) {
                return 0L;
            }
            return c.a.e.e.m.b.g(s.thread_id, 0L);
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
            c.a.r0.a4.c.d dVar = this.f58043g;
            if (dVar != null) {
                dVar.A();
            }
            VideoPlayView videoPlayView = this.f58042f;
            if (videoPlayView != null) {
                videoPlayView.notifyDataSetChanged();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a4.f.a
    public void handleActivityResult(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) || (videoPlayView = this.f58042f) == null) {
            return;
        }
        videoPlayView.handleActivityResult(i2, i3, intent);
    }

    @Override // c.a.r0.a4.f.a
    public boolean handleBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            VideoPlayView videoPlayView = this.f58042f;
            return videoPlayView != null && videoPlayView.handleBackPress();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a4.f.a
    public void handleIndexMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            VideoPlayView videoPlayView = this.f58042f;
            if (videoPlayView == null) {
                Intrinsics.throwNpe();
            }
            int i2 = videoPlayView.firstInIndex;
            VideoPlayView videoPlayView2 = this.f58042f;
            if (videoPlayView2 == null) {
                Intrinsics.throwNpe();
            }
            if (i2 != videoPlayView2.currentSelectIndex) {
                VideoPlayView videoPlayView3 = this.f58042f;
                if (videoPlayView3 == null) {
                    Intrinsics.throwNpe();
                }
                if (videoPlayView3.currentSelectIndex >= 0) {
                    VideoPlayView videoPlayView4 = this.f58042f;
                    if (videoPlayView4 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (videoPlayView4.currentSelectIndex < this.f58043g.k()) {
                        c.a.r0.a4.c.d dVar = this.f58043g;
                        VideoPlayView videoPlayView5 = this.f58042f;
                        if (videoPlayView5 == null) {
                            Intrinsics.throwNpe();
                        }
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.r0.a4.c.e.d(getActivity() instanceof VideoPlayActivity ? "2" : "4");
        }
    }

    public final void initData() {
        int i2;
        VideoAttentionModel videoAttentionModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Bundle arguments = getArguments();
            this.f58043g.y((ArrayList) (arguments != null ? arguments.getSerializable("video_list") : null));
            if (getArguments() != null) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    Intrinsics.throwNpe();
                }
                i2 = arguments2.getInt("video_index", 0);
            } else {
                i2 = 0;
            }
            this.f58044h = i2;
            Bundle arguments3 = getArguments();
            this.f58045i = arguments3 != null ? (Rect) arguments3.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT) : null;
            Bundle arguments4 = getArguments();
            this.f58046j = arguments4 != null ? arguments4.getString("page_from") : null;
            Bundle arguments5 = getArguments();
            this.k = arguments5 != null ? arguments5.getString("from") : null;
            Bundle arguments6 = getArguments();
            if (arguments6 != null) {
                arguments6.getString("st_type");
            }
            Bundle arguments7 = getArguments();
            if (arguments7 != null) {
                arguments7.getString("yuelaou_locate");
            }
            if (getArguments() != null) {
                Bundle arguments8 = getArguments();
                if (arguments8 == null) {
                    Intrinsics.throwNpe();
                }
                arguments8.getBoolean("is_vertail", true);
            }
            if (this.f58043g.v() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.f58043g.y(VideoPlayActivityConfig.bigDataList);
            }
            this.f58043g.B(getUniqueId());
            if (this.v != 4 && (!TbSingleton.getInstance().isFromFeedVideoClick() || this.v != 2)) {
                this.f58043g.C("a023");
            } else {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
                b(inst.getMainTabBottomBarHeight());
                this.f58043g.C("a088");
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
                videoAttentionModel4.I(new c(this));
            }
            if (this.f58043g.s(0) != null) {
                VideoItemData s = this.f58043g.s(0);
                this.m = s != null ? s.thread_id : null;
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

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f58043g.j() == null) {
                return false;
            }
            if (this.f58043g.j().size() == 1) {
                VideoItemModel videoItemModel = this.f58043g.j().get(0);
                Intrinsics.checkExpressionValueIsNotNull(videoItemModel, "dataController.dataList[0]");
                VideoItemModel videoItemModel2 = videoItemModel;
                if (videoItemModel2 != null && (videoItemModel2.getDataType() == 1 || videoItemModel2.getDataType() == 2)) {
                    return true;
                }
            } else if (this.f58043g.j().size() > 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getLifecycle().addObserver(this.o);
            initData();
            g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                handleActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            VideoPlayView videoPlayView = this.f58042f;
            if (videoPlayView != null) {
                videoPlayView.onChangeSkinType(i2);
            }
            SkinManager.setBackgroundColor(this.f58041e, R.color.CAM_X0611);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.p);
            registerListener(this.r);
            View inflate = layoutInflater.inflate(R.layout.video_vertical_page_fragment, viewGroup, false);
            this.f58041e = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            getLifecycle().removeObserver(this.o);
            VideoPlayView videoPlayView = this.f58042f;
            if (videoPlayView != null) {
                videoPlayView.onDestroy();
            }
            if (isPrimary()) {
                i();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroyView();
            c.a.r0.y0.a.i().d("6061002332-203360688");
            c.a.r0.y0.a.i().c("6061002410-390177882");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f58042f;
            if (videoPlayView != null) {
                videoPlayView.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
            if (!this.l) {
                i();
            }
            if (this.l && this.v == 4) {
                c.a.r0.a4.b.c(2);
            }
            if (this.l && !j() && TbadkCoreApplication.isLogin()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_LIST_PAGE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
            VideoPlayView videoPlayView = this.f58042f;
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
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            if (h()) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.setUserVisibleHint(z);
            VideoPlayView videoPlayView = this.f58042f;
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
