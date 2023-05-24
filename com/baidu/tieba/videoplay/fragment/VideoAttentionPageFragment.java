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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.util.SimpleMessageListener;
import com.baidu.tieba.R;
import com.baidu.tieba.bu9;
import com.baidu.tieba.c3a;
import com.baidu.tieba.c9;
import com.baidu.tieba.d3a;
import com.baidu.tieba.nn7;
import com.baidu.tieba.pg;
import com.baidu.tieba.ri;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.VideoPlayActivity;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.tieba.videoplay.VideoRecommentPlayActivity;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.tieba.videoplay.fragment.VideoAttentionPageFragment;
import com.baidu.tieba.videoplay.model.VideoAttentionModel;
import com.baidu.tieba.wk5;
import com.baidu.tieba.y2a;
import com.baidu.tieba.z3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AlaLiveInfo;
@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001*\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010.\u001a\u00020\u0010H\u0016J\b\u0010/\u001a\u000200H\u0016J\u0017\u00101\u001a\u0002002\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u00103J\"\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020\u0014H\u0016J\b\u0010;\u001a\u000205H\u0016J\b\u0010<\u001a\u000205H\u0002J\u0012\u0010=\u001a\u0002052\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\"\u0010@\u001a\u0002052\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010A\u001a\u0002052\u0006\u0010B\u001a\u00020\bH\u0016J&\u0010C\u001a\u0004\u0018\u00010!2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010H\u001a\u000205H\u0016J\b\u0010I\u001a\u000205H\u0016J\b\u0010J\u001a\u000205H\u0016J\b\u0010K\u001a\u000205H\u0016J\b\u0010L\u001a\u000205H\u0016J\u0010\u0010M\u001a\u0002052\u0006\u0010N\u001a\u00020\bH\u0002J\u0010\u0010O\u001a\u0002052\u0006\u0010P\u001a\u00020\u0014H\u0016J\b\u0010Q\u001a\u000205H\u0002J\b\u0010R\u001a\u00020\u0014H\u0002J\b\u0010S\u001a\u000205H\u0002J\b\u0010T\u001a\u00020\u0014H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoAttentionPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/videoplay/fragment/IVideoPlayActicityFragment;", "mActivityPageUniqueId", "Lcom/baidu/adp/BdUniqueId;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "mainPageType", "", "mCurrentType", "(Lcom/baidu/adp/BdUniqueId;Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;II)V", "backGroundListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "fid", "", "goPbCommentFloatListener", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "isVertail", "", "keyboardShowHideListener", "mFeedBackListener", "mFrom", "mFromPage", "mIsVisibleToUser", "mLocate", "mObjId", "mPollingModel", "Lcom/baidu/tbadk/core/leveiconlivepolling/PollingModel;", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "mVideoAttentionModel", "Lcom/baidu/tieba/videoplay/model/VideoAttentionModel;", "mVideoIndex", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "noLoginIsShowing", "userChangeListener", "com/baidu/tieba/videoplay/fragment/VideoAttentionPageFragment$userChangeListener$1", "Lcom/baidu/tieba/videoplay/fragment/VideoAttentionPageFragment$userChangeListener$1;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "getCurrentPageKey", "getMissionTid", "", "getShowVideoTid", "index", "(Ljava/lang/Integer;)J", "handleActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "handleBackPress", "handleIndexMessage", "initData", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "setEmptyHeight", "height", "setUserVisibleHint", "isVisibleToUser", "showData", "showNoLoginData", "stepStat", "whetherHasVideo", "VideoPlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VideoAttentionPageFragment extends BaseFragment implements z3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public final BdSwipeRefreshLayout.k b;
    public final int c;
    public final int d;
    public View e;
    public VideoPlayView f;
    public final c3a g;
    public int h;
    public Rect i;
    public String j;
    public String k;
    public boolean l;
    public String m;
    public String n;
    public PollingModel o;
    public VideoAttentionModel p;
    public final VideoPlayFragment.GoPbCommentFloatListener q;
    public final CustomMessageListener r;
    public VideoPlayView.k s;
    public final CustomMessageListener t;
    public boolean u;
    public final g v;
    public final CustomMessageListener w;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoAttentionPageFragment() {
        this(null, null, 0, 0, 15, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((BdUniqueId) objArr[0], (BdSwipeRefreshLayout.k) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), (DefaultConstructorMarker) objArr[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoAttentionPageFragment videoAttentionPageFragment) {
            super(2001011);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageFragment};
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
            this.a = videoAttentionPageFragment;
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
                        if (c9.f().b() instanceof bu9) {
                            Activity b = c9.f().b();
                            if (b != null) {
                                if (((bu9) b).getCurrentTabType() == 22) {
                                    z = true;
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.tblauncher.IMaintabType");
                            }
                        }
                        if ((!this.a.l || !z) && (!(c9.f().b() instanceof VideoPlayActivity) || !(this.a.getActivity() instanceof VideoPlayActivity))) {
                            return;
                        }
                        this.a.W1();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements VideoAttentionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPageFragment a;

        public b(VideoAttentionPageFragment videoAttentionPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void a(List<? extends VideoItemData> datas, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, datas, z) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                if (!ListUtils.isEmpty(datas)) {
                    this.a.g.z(datas);
                    VideoPlayView videoPlayView = this.a.f;
                    if (videoPlayView != null) {
                        videoPlayView.notifyDataSetChanged();
                    }
                    VideoPlayView videoPlayView2 = this.a.f;
                    if (videoPlayView2 != null) {
                        videoPlayView2.k0(0, true);
                    }
                    VideoPlayView videoPlayView3 = this.a.f;
                    if (videoPlayView3 != null) {
                        videoPlayView3.i0(this.a.isPrimary());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void b(List<? extends VideoItemData> datas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, datas) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                if (!ListUtils.isEmpty(datas) && !this.a.g.v()) {
                    this.a.g.b(datas);
                    VideoPlayView videoPlayView = this.a.f;
                    if (videoPlayView != null) {
                        videoPlayView.notifyDataSetChanged();
                    }
                    VideoPlayView videoPlayView2 = this.a.f;
                    if (videoPlayView2 != null) {
                        videoPlayView2.n0(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void c(List<? extends VideoAttentionPersonListData> list, String str, boolean z) {
            VideoAttentionListPageFragment F;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, list, str, z) == null) {
                this.a.g.A(list, str);
                VideoPlayView videoPlayView = this.a.f;
                if (videoPlayView != null) {
                    videoPlayView.notifyDataSetChanged();
                }
                VideoPlayView videoPlayView2 = this.a.f;
                if (videoPlayView2 != null && (F = videoPlayView2.F()) != null) {
                    F.J1(0);
                }
                VideoPlayView videoPlayView3 = this.a.f;
                if (videoPlayView3 != null) {
                    videoPlayView3.n0(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements PollingModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPageFragment a;

        public c(VideoAttentionPageFragment videoAttentionPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
        public void onSuccess(List<AlaLiveInfo> liveSecondFloor) {
            VideoPlayView videoPlayView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveSecondFloor) == null) {
                Intrinsics.checkNotNullParameter(liveSecondFloor, "liveSecondFloor");
                if (this.a.d != 2 || this.a.f == null) {
                    return;
                }
                VideoPlayView videoPlayView2 = this.a.f;
                Intrinsics.checkNotNull(videoPlayView2);
                if (videoPlayView2.S(liveSecondFloor) && (videoPlayView = this.a.f) != null) {
                    videoPlayView.r0(this.a.a, liveSecondFloor, "video_concern");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VideoAttentionPageFragment videoAttentionPageFragment) {
            super(2921646);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageFragment};
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
            this.a = videoAttentionPageFragment;
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
                        if (this.a.d == 4) {
                            if (booleanValue) {
                                this.a.S1(0);
                                return;
                            } else {
                                this.a.S1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
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

    /* loaded from: classes7.dex */
    public static final class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(VideoAttentionPageFragment videoAttentionPageFragment) {
            super(2921566, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageFragment};
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
            this.a = videoAttentionPageFragment;
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
                    if (!this.a.g.e(((Integer) data).intValue())) {
                        return;
                    }
                    VideoPlayView videoPlayView = this.a.f;
                    if (videoPlayView != null) {
                        videoPlayView.notifyDataSetChanged();
                    }
                    VideoPlayView videoPlayView2 = this.a.f;
                    if (videoPlayView2 != null) {
                        videoPlayView2.i0(this.a.isPrimary());
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class f implements VideoPlayView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPageFragment a;

        @Override // com.baidu.tieba.videoplay.VideoPlayView.h
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public f(VideoAttentionPageFragment videoAttentionPageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.h
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_MIDDLE_AUTO_PLAY);
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
                statisticItem.param("tid", this.a.Q1(Integer.valueOf(i)));
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(VideoAttentionPageFragment videoAttentionPageFragment) {
            super(2921410);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageFragment};
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
            this.a = videoAttentionPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.u || !TbadkCoreApplication.isLogin()) {
                return;
            }
            this.a.u = false;
            VideoAttentionModel videoAttentionModel = this.a.p;
            if (videoAttentionModel != null) {
                videoAttentionModel.e0();
            }
        }
    }

    public VideoAttentionPageFragment(BdUniqueId bdUniqueId, BdSwipeRefreshLayout.k kVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, kVar, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = bdUniqueId;
        this.b = kVar;
        this.c = i;
        this.d = i2;
        this.g = new c3a();
        this.q = new VideoPlayFragment.GoPbCommentFloatListener(new SimpleMessageListener.b() { // from class: com.baidu.tieba.q3a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tbadk.util.SimpleMessageListener.b
            public final void call(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    VideoAttentionPageFragment.R1(VideoAttentionPageFragment.this, (Void) obj);
                }
            }
        });
        this.r = new e(this);
        this.s = new VideoPlayView.k() { // from class: com.baidu.tieba.s3a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.videoplay.VideoPlayView.k
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    VideoAttentionPageFragment.X1(VideoAttentionPageFragment.this);
                }
            }
        };
        this.t = new d(this);
        this.v = new g(this);
        this.w = new a(this);
    }

    public /* synthetic */ VideoAttentionPageFragment(BdUniqueId bdUniqueId, BdSwipeRefreshLayout.k kVar, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bdUniqueId, (i3 & 2) != 0 ? null : kVar, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public static final void U1(VideoAttentionPageFragment this$0) {
        VideoAttentionModel videoAttentionModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            VideoAttentionModel videoAttentionModel2 = this$0.p;
            if (videoAttentionModel2 != null) {
                videoAttentionModel2.setFrom(this$0.k);
            }
            if (!this$0.g.x() && (videoAttentionModel = this$0.p) != null) {
                videoAttentionModel.b();
            }
        }
    }

    public final void S1(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (view2 = this.e) != null) {
            Intrinsics.checkNotNull(view2);
            int paddingLeft = view2.getPaddingLeft();
            View view3 = this.e;
            Intrinsics.checkNotNull(view3);
            int paddingTop = view3.getPaddingTop();
            View view4 = this.e;
            Intrinsics.checkNotNull(view4);
            view2.setPadding(paddingLeft, paddingTop, view4.getPaddingRight(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getLifecycle().addObserver(this.q);
            initData();
            T1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.U(i);
            }
            if (!UbsABTestHelper.isFeedVideoImmersionTransition() || (getActivity() instanceof VideoRecommentPlayActivity)) {
                SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.setUserVisibleHint(z);
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.Z(z);
            }
            this.l = z;
        }
    }

    public static final void R1(VideoAttentionPageFragment this$0, Void r5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, this$0, r5) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setInterceptStimeStat(true);
        }
    }

    public static final void X1(VideoAttentionPageFragment this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.d == 4 && this$0.Y1() && this$0.getPageContext() != null && this$0.getPageContext().getPageActivity() != null) {
                VideoAttentionModel videoAttentionModel = this$0.p;
                boolean z = false;
                if (videoAttentionModel != null && videoAttentionModel.mHasMore == 0) {
                    z = true;
                }
                if (z) {
                    ri.Q(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0df2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.z3a
    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            VideoPlayView videoPlayView = this.f;
            Intrinsics.checkNotNull(videoPlayView);
            int i = videoPlayView.o;
            VideoPlayView videoPlayView2 = this.f;
            Intrinsics.checkNotNull(videoPlayView2);
            if (i != videoPlayView2.n) {
                VideoPlayView videoPlayView3 = this.f;
                Intrinsics.checkNotNull(videoPlayView3);
                if (videoPlayView3.n >= 0) {
                    VideoPlayView videoPlayView4 = this.f;
                    Intrinsics.checkNotNull(videoPlayView4);
                    if (videoPlayView4.n < this.g.k()) {
                        c3a c3aVar = this.g;
                        VideoPlayView videoPlayView5 = this.f;
                        Intrinsics.checkNotNull(videoPlayView5);
                        VideoItemData s = c3aVar.s(videoPlayView5.n);
                        if (s != null && !StringUtils.isNull(s.thread_id)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, s.thread_id));
                        }
                    }
                }
            }
        }
    }

    public final boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.g.j() == null) {
                return false;
            }
            if (this.g.j().size() == 1) {
                VideoItemModel videoItemModel = this.g.j().get(0);
                Intrinsics.checkNotNullExpressionValue(videoItemModel, "dataController.dataList[0]");
                VideoItemModel videoItemModel2 = videoItemModel;
                if (videoItemModel2.getDataType() == 1 || videoItemModel2.getDataType() == 2) {
                    return true;
                }
            } else if (this.g.j().size() > 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final long Q1(Integer num) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num)) == null) {
            c3a c3aVar = this.g;
            if (num != null) {
                i = num.intValue();
            } else {
                VideoPlayView videoPlayView = this.f;
                Intrinsics.checkNotNull(videoPlayView);
                i = videoPlayView.n;
            }
            VideoItemData s = c3aVar.s(i);
            if (s == null || TextUtils.isEmpty(s.thread_id)) {
                return 0L;
            }
            return pg.g(s.thread_id, 0L);
        }
        return invokeL.longValue;
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdUniqueId bdUniqueId = this.a;
            Activity pageActivity = getPageContext().getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView = new VideoPlayView(bdUniqueId, (FragmentActivity) pageActivity, this, this.k, getUniqueId(), 0, this.d, false, this.n);
                this.f = videoPlayView;
                if (videoPlayView != null) {
                    videoPlayView.l0("from_attention_sub_fragment");
                }
                VideoPlayView videoPlayView2 = this.f;
                if (videoPlayView2 != null) {
                    videoPlayView2.j0(this.b);
                }
                VideoPlayView videoPlayView3 = this.f;
                if (videoPlayView3 != null) {
                    videoPlayView3.Y(this.s);
                }
                VideoPlayView videoPlayView4 = this.f;
                if (videoPlayView4 != null) {
                    videoPlayView4.g0(new VideoPlayView.i() { // from class: com.baidu.tieba.t3a
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.videoplay.VideoPlayView.i
                        public final void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                VideoAttentionPageFragment.U1(VideoAttentionPageFragment.this);
                            }
                        }
                    });
                }
                VideoPlayView videoPlayView5 = this.f;
                if (videoPlayView5 != null) {
                    videoPlayView5.o0(this.g, this.h, this.i);
                }
                VideoPlayView videoPlayView6 = this.f;
                if (videoPlayView6 != null) {
                    videoPlayView6.h0(this.j);
                }
                VideoPlayView videoPlayView7 = this.f;
                if (videoPlayView7 != null) {
                    videoPlayView7.e0(this.m);
                }
                VideoPlayView videoPlayView8 = this.f;
                if (videoPlayView8 != null) {
                    videoPlayView8.m0(this.c);
                }
                VideoPlayView videoPlayView9 = this.f;
                if (videoPlayView9 != null) {
                    videoPlayView9.a0(new f(this));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
            if (!this.l) {
                W1();
            }
            if (this.l && this.d == 4) {
                y2a.a(2);
            }
            if (this.l && !Y1() && TbadkCoreApplication.isLogin()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_LIST_PAGE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
            if (isPrimary()) {
                wk5.b().c();
                wk5.b().l(true);
            }
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.i0(isPrimary());
            }
            if (V1()) {
            }
        }
    }

    public final boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return false;
            }
            this.u = true;
            c3a c3aVar = this.g;
            if (c3aVar != null) {
                c3aVar.B();
            }
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.notifyDataSetChanged();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void W1() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (getActivity() instanceof VideoPlayActivity) {
                str = "2";
            } else {
                str = "4";
            }
            d3a.e(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.on5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.d == 4) {
                return "a089";
            }
            return "a023";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z3a
    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            VideoItemData s = this.g.s(this.h);
            if (s == null || TextUtils.isEmpty(s.thread_id)) {
                return 0L;
            }
            return pg.g(s.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            getLifecycle().removeObserver(this.q);
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.V();
            }
            if (isPrimary()) {
                W1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroyView();
            nn7.m().d("6061002332-203360688");
            nn7.m().c(nn7.s());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.W();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            if (V1()) {
            }
        }
    }

    @Override // com.baidu.tieba.z3a
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null && videoPlayView.J()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void initData() {
        int i;
        String str;
        Rect rect;
        String str2;
        String str3;
        Serializable serializable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String str4 = null;
            if (UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    serializable = arguments.getSerializable("video_list");
                } else {
                    serializable = null;
                }
                this.g.z((ArrayList) serializable);
            }
            if (getArguments() != null) {
                i = requireArguments().getInt("video_index", 0);
            } else {
                i = 0;
            }
            this.h = i;
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("forum_id");
            } else {
                str = null;
            }
            this.n = str;
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                rect = (Rect) arguments3.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
            } else {
                rect = null;
            }
            this.i = rect;
            Bundle arguments4 = getArguments();
            if (arguments4 != null) {
                str2 = arguments4.getString("page_from");
            } else {
                str2 = null;
            }
            this.j = str2;
            Bundle arguments5 = getArguments();
            if (arguments5 != null) {
                str3 = arguments5.getString("from");
            } else {
                str3 = null;
            }
            this.k = str3;
            Bundle arguments6 = getArguments();
            if (arguments6 != null) {
                arguments6.getString("st_type");
            }
            Bundle arguments7 = getArguments();
            if (arguments7 != null) {
                arguments7.getString("yuelaou_locate");
            }
            if (getArguments() != null) {
                requireArguments().getBoolean(VideoPlayActivityConfig.PARAM_IS_VERTAIL, true);
            }
            if (UbsABTestHelper.isVideoSetUrlAgainABTest() && this.g.v() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.g.z(VideoPlayActivityConfig.bigDataList);
            }
            this.g.C(getUniqueId());
            if (this.d == 4) {
                S1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.g.D("a088");
            } else {
                this.g.D("a023");
            }
            VideoAttentionModel videoAttentionModel = new VideoAttentionModel(getPageContext(), getUniqueId());
            this.p = videoAttentionModel;
            if (videoAttentionModel != null) {
                videoAttentionModel.setFrom(this.k);
            }
            VideoAttentionModel videoAttentionModel2 = this.p;
            if (videoAttentionModel2 != null) {
                videoAttentionModel2.f0(0);
            }
            VideoAttentionModel videoAttentionModel3 = this.p;
            if (videoAttentionModel3 != null) {
                videoAttentionModel3.g0(new b(this));
            }
            if (this.g.s(0) != null) {
                VideoItemData s = this.g.s(0);
                if (s != null) {
                    str4 = s.thread_id;
                }
                this.m = str4;
            }
            VideoAttentionModel videoAttentionModel4 = this.p;
            if (videoAttentionModel4 != null) {
                videoAttentionModel4.setFrom(this.k);
            }
            if (V1()) {
                return;
            }
            VideoAttentionModel videoAttentionModel5 = this.p;
            if (videoAttentionModel5 != null) {
                videoAttentionModel5.e0();
            }
            if (this.o == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getPageContext().getUniqueId());
                this.o = pollingModel;
                if (pollingModel != null) {
                    pollingModel.P0(new c(this));
                }
            }
        }
    }

    @Override // com.baidu.tieba.z3a
    public void o(int i, int i2, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048586, this, i, i2, intent) == null) && (videoPlayView = this.f) != null) {
            videoPlayView.I(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (intent != null) {
                o(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            registerListener(this.r);
            registerListener(this.w);
            registerListener(this.t);
            registerListener(this.v);
            this.e = inflater.inflate(R.layout.obfuscated_res_0x7f0d0995, viewGroup, false);
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !(getActivity() instanceof VideoRecommentPlayActivity) && (view2 = this.e) != null) {
                view2.setBackgroundColor(0);
            }
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }
}
