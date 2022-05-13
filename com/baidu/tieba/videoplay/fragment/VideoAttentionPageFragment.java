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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
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
import com.baidu.tieba.videoplay.VideoRecommentPlayActivity;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.tieba.videoplay.fragment.VideoAttentionPageFragment;
import com.baidu.tieba.videoplay.model.VideoAttentionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cu8;
import com.repackage.dv8;
import com.repackage.er6;
import com.repackage.gu8;
import com.repackage.hu8;
import com.repackage.kg;
import com.repackage.mi;
import com.repackage.mm8;
import com.repackage.w55;
import com.repackage.x8;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0017\u0010*\u001a\u00020)2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010,J\"\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u00020.H\u0016J\b\u00105\u001a\u00020.H\u0002J\u0012\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\"\u00109\u001a\u00020.2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020\bH\u0016J&\u0010<\u001a\u0004\u0018\u00010\u001e2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010A\u001a\u00020.H\u0016J\b\u0010B\u001a\u00020.H\u0016J\b\u0010C\u001a\u00020.H\u0016J\b\u0010D\u001a\u00020.H\u0016J\b\u0010E\u001a\u00020.H\u0016J\u0010\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020\bH\u0002J\u0010\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020\u0012H\u0016J\b\u0010J\u001a\u00020.H\u0002J\b\u0010K\u001a\u00020\u0012H\u0002J\b\u0010L\u001a\u00020.H\u0002J\b\u0010M\u001a\u00020\u0012H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoAttentionPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/videoplay/fragment/IVideoPlayActicityFragment;", "mActivityPageUniqueId", "Lcom/baidu/adp/BdUniqueId;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "mainPageType", "", "mCurrentType", "(Lcom/baidu/adp/BdUniqueId;Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;II)V", "backGroundListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "goPbCommentFloatListener", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "isVertail", "", "keyboardShowHideListener", "mFeedBackListener", "mFrom", "", "mFromPage", "mIsVisibleToUser", "mLocate", "mObjId", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "mVideoAttentionModel", "Lcom/baidu/tieba/videoplay/model/VideoAttentionModel;", "mVideoIndex", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "getCurrentPageKey", "getMissionTid", "", "getShowVideoTid", "index", "(Ljava/lang/Integer;)J", "handleActivityResult", "", GroupInfoActivityConfig.REQUEST_CODE, "resultCode", "data", "Landroid/content/Intent;", "handleBackPress", "handleIndexMessage", "initData", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "setEmptyHeight", "height", "setUserVisibleHint", "isVisibleToUser", "showData", "showNoLoginData", "stepStat", "whetherHasVideo", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class VideoAttentionPageFragment extends BaseFragment implements dv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public final BdSwipeRefreshLayout.k b;
    public final int c;
    public final int d;
    public View e;
    public VideoPlayView f;
    public final gu8 g;
    public int h;
    public Rect i;
    public String j;
    public String k;
    public boolean l;
    public String m;
    public VideoAttentionModel n;
    public final VideoPlayFragment.GoPbCommentFloatListener o;
    public final CustomMessageListener p;
    public VideoPlayView.h q;
    public final CustomMessageListener r;
    public final CustomMessageListener s;

    /* loaded from: classes4.dex */
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
                if (msg.getCmd() == 2001011 && (msg instanceof BackgroundSwitchMessage)) {
                    BackgroundSwitchMessage backgroundSwitchMessage = (BackgroundSwitchMessage) msg;
                    if (backgroundSwitchMessage.getData() != null) {
                        Boolean isBackground = backgroundSwitchMessage.getData();
                        Intrinsics.checkNotNullExpressionValue(isBackground, "isBackground");
                        if (isBackground.booleanValue()) {
                            boolean z = false;
                            if (x8.g().b() instanceof mm8) {
                                Activity b = x8.g().b();
                                if (b != null) {
                                    if (((mm8) b).getCurrentTabType() == 22) {
                                        z = true;
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.tblauncher.IMaintabType");
                                }
                            }
                            if ((this.a.l && z) || ((x8.g().b() instanceof VideoPlayActivity) && (this.a.getActivity() instanceof VideoPlayActivity))) {
                                this.a.O0();
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (ListUtils.isEmpty(datas)) {
                    return;
                }
                this.a.g.z(datas);
                VideoPlayView videoPlayView = this.a.f;
                if (videoPlayView != null) {
                    videoPlayView.B();
                }
                VideoPlayView videoPlayView2 = this.a.f;
                if (videoPlayView2 != null) {
                    videoPlayView2.Q(0, true);
                }
                VideoPlayView videoPlayView3 = this.a.f;
                if (videoPlayView3 == null) {
                    return;
                }
                videoPlayView3.O(this.a.isPrimary());
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void b(List<? extends VideoItemData> datas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, datas) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                if (ListUtils.isEmpty(datas) || this.a.g.v()) {
                    return;
                }
                this.a.g.b(datas);
                VideoPlayView videoPlayView = this.a.f;
                if (videoPlayView != null) {
                    videoPlayView.B();
                }
                VideoPlayView videoPlayView2 = this.a.f;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.T(true);
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void c(List<? extends VideoAttentionPersonListData> list, String str, boolean z) {
            VideoAttentionListPageFragment t;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, list, str, z) == null) {
                this.a.g.A(list, str);
                VideoPlayView videoPlayView = this.a.f;
                if (videoPlayView != null) {
                    videoPlayView.B();
                }
                VideoPlayView videoPlayView2 = this.a.f;
                if (videoPlayView2 != null && (t = videoPlayView2.t()) != null) {
                    t.F0(0);
                }
                VideoPlayView videoPlayView3 = this.a.f;
                if (videoPlayView3 == null) {
                    return;
                }
                videoPlayView3.T(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(VideoAttentionPageFragment videoAttentionPageFragment) {
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
                        if (this.a.d == 4 || (TbSingleton.getInstance().isFromFeedVideoClick() && this.a.d == 2)) {
                            if (booleanValue) {
                                this.a.K0(0);
                                return;
                            } else {
                                this.a.K0(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
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

    /* loaded from: classes4.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VideoAttentionPageFragment videoAttentionPageFragment) {
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
                if (responsedMessage.getData() instanceof Integer) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        if (this.a.g.e(((Integer) data).intValue())) {
                            VideoPlayView videoPlayView = this.a.f;
                            if (videoPlayView != null) {
                                videoPlayView.B();
                            }
                            VideoPlayView videoPlayView2 = this.a.f;
                            if (videoPlayView2 == null) {
                                return;
                            }
                            videoPlayView2.O(this.a.isPrimary());
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class e implements VideoPlayView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPageFragment a;

        public e(VideoAttentionPageFragment videoAttentionPageFragment) {
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

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
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
                statisticItem.param("tid", this.a.I0(Integer.valueOf(i)));
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
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

    public /* synthetic */ VideoAttentionPageFragment(BdUniqueId bdUniqueId, BdSwipeRefreshLayout.k kVar, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bdUniqueId, (i3 & 2) != 0 ? null : kVar, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public static final void J0(VideoAttentionPageFragment this$0, Void r5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, this$0, r5) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setInterceptStimeStat(true);
        }
    }

    public static final void M0(VideoAttentionPageFragment this$0) {
        VideoAttentionModel videoAttentionModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            VideoAttentionModel videoAttentionModel2 = this$0.n;
            if (videoAttentionModel2 != null) {
                videoAttentionModel2.setFrom(this$0.k);
            }
            if (this$0.g.x() || (videoAttentionModel = this$0.n) == null) {
                return;
            }
            videoAttentionModel.loadMore();
        }
    }

    public static final void P0(VideoAttentionPageFragment this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.d != 4 || !this$0.Q0() || this$0.getPageContext() == null || this$0.getPageContext().getPageActivity() == null) {
                return;
            }
            VideoAttentionModel videoAttentionModel = this$0.n;
            boolean z = false;
            if (videoAttentionModel != null && videoAttentionModel.mHasMore == 0) {
                z = true;
            }
            if (z) {
                mi.N(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c60));
            }
        }
    }

    public final long I0(Integer num) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, num)) == null) {
            gu8 gu8Var = this.g;
            if (num == null) {
                VideoPlayView videoPlayView = this.f;
                Intrinsics.checkNotNull(videoPlayView);
                intValue = videoPlayView.h;
            } else {
                intValue = num.intValue();
            }
            VideoItemData s = gu8Var.s(intValue);
            if (s == null || TextUtils.isEmpty(s.thread_id)) {
                return 0L;
            }
            return kg.g(s.thread_id, 0L);
        }
        return invokeL.longValue;
    }

    public final void K0(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (view2 = this.e) == null) {
            return;
        }
        Intrinsics.checkNotNull(view2);
        int paddingLeft = view2.getPaddingLeft();
        View view3 = this.e;
        Intrinsics.checkNotNull(view3);
        int paddingTop = view3.getPaddingTop();
        View view4 = this.e;
        Intrinsics.checkNotNull(view4);
        view2.setPadding(paddingLeft, paddingTop, view4.getPaddingRight(), i);
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdUniqueId bdUniqueId = this.a;
            Activity pageActivity = getPageContext().getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView = new VideoPlayView(bdUniqueId, (FragmentActivity) pageActivity, this, this.k, getUniqueId(), 0, this.d, false);
                this.f = videoPlayView;
                if (videoPlayView != null) {
                    videoPlayView.R("from_attention_sub_fragment");
                }
                VideoPlayView videoPlayView2 = this.f;
                if (videoPlayView2 != null) {
                    videoPlayView2.P(this.b);
                }
                VideoPlayView videoPlayView3 = this.f;
                if (videoPlayView3 != null) {
                    videoPlayView3.F(this.q);
                }
                VideoPlayView videoPlayView4 = this.f;
                if (videoPlayView4 != null) {
                    videoPlayView4.M(new VideoPlayView.f() { // from class: com.repackage.xu8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.videoplay.VideoPlayView.f
                        public final void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                VideoAttentionPageFragment.M0(VideoAttentionPageFragment.this);
                            }
                        }
                    });
                }
                VideoPlayView videoPlayView5 = this.f;
                if (videoPlayView5 != null) {
                    videoPlayView5.U(this.g, this.h, this.i);
                }
                VideoPlayView videoPlayView6 = this.f;
                if (videoPlayView6 != null) {
                    videoPlayView6.N(this.j);
                }
                VideoPlayView videoPlayView7 = this.f;
                if (videoPlayView7 != null) {
                    videoPlayView7.K(this.m);
                }
                VideoPlayView videoPlayView8 = this.f;
                if (videoPlayView8 != null) {
                    videoPlayView8.S(this.c);
                }
                VideoPlayView videoPlayView9 = this.f;
                if (videoPlayView9 == null) {
                    return;
                }
                videoPlayView9.H(new e(this));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public final boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return false;
            }
            gu8 gu8Var = this.g;
            if (gu8Var != null) {
                gu8Var.B();
            }
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView == null) {
                return true;
            }
            videoPlayView.B();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            hu8.e(getActivity() instanceof VideoPlayActivity ? "2" : "4");
        }
    }

    public final boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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

    @Override // com.repackage.dv8
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            VideoPlayView videoPlayView = this.f;
            Intrinsics.checkNotNull(videoPlayView);
            int i = videoPlayView.i;
            VideoPlayView videoPlayView2 = this.f;
            Intrinsics.checkNotNull(videoPlayView2);
            if (i != videoPlayView2.h) {
                VideoPlayView videoPlayView3 = this.f;
                Intrinsics.checkNotNull(videoPlayView3);
                if (videoPlayView3.h >= 0) {
                    VideoPlayView videoPlayView4 = this.f;
                    Intrinsics.checkNotNull(videoPlayView4);
                    if (videoPlayView4.h < this.g.k()) {
                        gu8 gu8Var = this.g;
                        VideoPlayView videoPlayView5 = this.f;
                        Intrinsics.checkNotNull(videoPlayView5);
                        VideoItemData s = gu8Var.s(videoPlayView5.h);
                        if (s == null || StringUtils.isNull(s.thread_id)) {
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, s.thread_id));
                    }
                }
            }
        }
    }

    @Override // com.repackage.dv8
    public long X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoItemData s = this.g.s(this.h);
            if (s == null || TextUtils.isEmpty(s.thread_id)) {
                return 0L;
            }
            return kg.g(s.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.m85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d == 4 ? "a089" : "a023" : (String) invokeV.objValue;
    }

    public final void initData() {
        int i;
        VideoAttentionModel videoAttentionModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                Bundle arguments = getArguments();
                this.g.z((ArrayList) (arguments == null ? null : arguments.getSerializable("video_list")));
            }
            if (getArguments() != null) {
                Bundle arguments2 = getArguments();
                Intrinsics.checkNotNull(arguments2);
                i = arguments2.getInt("video_index", 0);
            } else {
                i = 0;
            }
            this.h = i;
            Bundle arguments3 = getArguments();
            this.i = arguments3 == null ? null : (Rect) arguments3.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
            Bundle arguments4 = getArguments();
            this.j = arguments4 == null ? null : arguments4.getString("page_from");
            Bundle arguments5 = getArguments();
            this.k = arguments5 == null ? null : arguments5.getString("from");
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
                Intrinsics.checkNotNull(arguments8);
                arguments8.getBoolean("is_vertail", true);
            }
            if (UbsABTestHelper.isVideoSetUrlAgainABTest() && this.g.v() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.g.z(VideoPlayActivityConfig.bigDataList);
            }
            this.g.C(getUniqueId());
            if (this.d != 4 && (!TbSingleton.getInstance().isFromFeedVideoClick() || this.d != 2)) {
                this.g.D("a023");
            } else {
                K0(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.g.D("a088");
            }
            VideoAttentionModel videoAttentionModel2 = new VideoAttentionModel(getPageContext(), getUniqueId());
            this.n = videoAttentionModel2;
            if (videoAttentionModel2 != null) {
                videoAttentionModel2.setFrom(this.k);
            }
            VideoAttentionModel videoAttentionModel3 = this.n;
            if (videoAttentionModel3 != null) {
                videoAttentionModel3.J(0);
            }
            VideoAttentionModel videoAttentionModel4 = this.n;
            if (videoAttentionModel4 != null) {
                videoAttentionModel4.K(new b(this));
            }
            if (this.g.s(0) != null) {
                VideoItemData s = this.g.s(0);
                this.m = s != null ? s.thread_id : null;
            }
            VideoAttentionModel videoAttentionModel5 = this.n;
            if (videoAttentionModel5 != null) {
                videoAttentionModel5.setFrom(this.k);
            }
            if (N0() || (videoAttentionModel = this.n) == null) {
                return;
            }
            videoAttentionModel.I();
        }
    }

    @Override // com.repackage.dv8
    public void m0(int i, int i2, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048586, this, i, i2, intent) == null) || (videoPlayView = this.f) == null) {
            return;
        }
        videoPlayView.v(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getLifecycle().addObserver(this.o);
            initData();
            L0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (intent != null) {
                m0(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.C(i);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            registerListener(this.p);
            registerListener(this.s);
            registerListener(this.r);
            this.e = inflater.inflate(R.layout.obfuscated_res_0x7f0d087d, viewGroup, false);
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !(getActivity() instanceof VideoRecommentPlayActivity) && (view2 = this.e) != null) {
                view2.setBackgroundColor(0);
            }
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            getLifecycle().removeObserver(this.o);
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.D();
            }
            if (isPrimary()) {
                O0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroyView();
            er6.j().d("6061002332-203360688");
            er6.j().c("6061002410-390177882");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView == null) {
                return;
            }
            videoPlayView.E();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
            if (!this.l) {
                O0();
            }
            if (this.l && this.d == 4) {
                cu8.c(2);
            }
            if (this.l && !Q0() && TbadkCoreApplication.isLogin()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_LIST_PAGE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
            if (isPrimary()) {
                w55.b().c();
                w55.b().l(true);
            }
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.O(isPrimary());
            }
            if (N0()) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            if (N0()) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.setUserVisibleHint(z);
            VideoPlayView videoPlayView = this.f;
            if (videoPlayView != null) {
                videoPlayView.G(z);
            }
            this.l = z;
        }
    }

    @Override // com.repackage.dv8
    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            VideoPlayView videoPlayView = this.f;
            return videoPlayView != null && videoPlayView.w();
        }
        return invokeV.booleanValue;
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
        this.g = new gu8();
        this.o = new VideoPlayFragment.GoPbCommentFloatListener(new SimpleMessageListener.b() { // from class: com.repackage.uu8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tbadk.util.SimpleMessageListener.b
            public final void call(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    VideoAttentionPageFragment.J0(VideoAttentionPageFragment.this, (Void) obj);
                }
            }
        });
        this.p = new d(this);
        this.q = new VideoPlayView.h() { // from class: com.repackage.wu8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.videoplay.VideoPlayView.h
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    VideoAttentionPageFragment.P0(VideoAttentionPageFragment.this);
                }
            }
        };
        this.r = new c(this);
        this.s = new a(this);
    }
}
