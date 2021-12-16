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
import c.a.d.f.p.m;
import c.a.s0.l4.g;
import c.a.s0.l4.i;
import c.a.s0.l4.k;
import c.a.s0.l4.p.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
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
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.VideoPlayActivity;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.tieba.videoplay.fragment.VideoAttentionPageFragment;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0017\u0010*\u001a\u00020)2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010,J\"\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u00020.H\u0016J\b\u00105\u001a\u00020.H\u0002J\u0012\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\"\u00109\u001a\u00020.2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020\bH\u0016J&\u0010<\u001a\u0004\u0018\u00010\u001e2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010A\u001a\u00020.H\u0016J\b\u0010B\u001a\u00020.H\u0016J\b\u0010C\u001a\u00020.H\u0016J\b\u0010D\u001a\u00020.H\u0016J\b\u0010E\u001a\u00020.H\u0016J\u0010\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020\bH\u0002J\u0010\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020\u0012H\u0016J\b\u0010J\u001a\u00020.H\u0002J\b\u0010K\u001a\u00020\u0012H\u0002J\b\u0010L\u001a\u00020.H\u0002J\b\u0010M\u001a\u00020\u0012H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoAttentionPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/videoplay/fragment/IVideoPlayActicityFragment;", "mActivityPageUniqueId", "Lcom/baidu/adp/BdUniqueId;", "progressViewCallback", "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;", "mainPageType", "", "mCurrentType", "(Lcom/baidu/adp/BdUniqueId;Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout$OnProgressViewCallback;II)V", "backGroundListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "goPbCommentFloatListener", "Lcom/baidu/tieba/videoplay/VideoPlayFragment$GoPbCommentFloatListener;", "isVertail", "", "keyboardShowHideListener", "mFeedBackListener", "mFrom", "", "mFromPage", "mIsVisibleToUser", "mLocate", "mObjId", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "mVideoAttentionModel", "Lcom/baidu/tieba/videoplay/model/VideoAttentionModel;", "mVideoIndex", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "viewPagerBottomScrollMoreCallback", "Lcom/baidu/tieba/videoplay/VideoPlayView$OnViewPagerBottomScrollMoreCallback;", "getCurrentPageKey", "getMissionTid", "", "getShowVideoTid", "index", "(Ljava/lang/Integer;)J", "handleActivityResult", "", "requestCode", MiPushCommandMessage.KEY_RESULT_CODE, "data", "Landroid/content/Intent;", "handleBackPress", "handleIndexMessage", "initData", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "setEmptyHeight", "height", "setUserVisibleHint", "isVisibleToUser", "showData", "showNoLoginData", "stepStat", "whetherHasVideo", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class VideoAttentionPageFragment extends BaseFragment implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final BdUniqueId f50588e;

    /* renamed from: f  reason: collision with root package name */
    public final BdSwipeRefreshLayout.k f50589f;

    /* renamed from: g  reason: collision with root package name */
    public final int f50590g;

    /* renamed from: h  reason: collision with root package name */
    public final int f50591h;

    /* renamed from: i  reason: collision with root package name */
    public View f50592i;

    /* renamed from: j  reason: collision with root package name */
    public VideoPlayView f50593j;

    /* renamed from: k  reason: collision with root package name */
    public final c.a.s0.l4.l.d f50594k;
    public int l;
    public Rect m;
    public String n;
    public String o;
    public boolean p;
    public String q;
    public VideoAttentionModel r;
    public final VideoPlayFragment.GoPbCommentFloatListener s;
    public final CustomMessageListener t;
    public VideoPlayView.h u;
    public final CustomMessageListener v;
    public final CustomMessageListener w;

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                            if (c.a.d.a.b.g().b() instanceof c.a.s0.y3.a) {
                                Activity b2 = c.a.d.a.b.g().b();
                                if (b2 != null) {
                                    if (((c.a.s0.y3.a) b2).getCurrentTabType() == 22) {
                                        z = true;
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.tblauncher.IMaintabType");
                                }
                            }
                            if ((this.a.p && z) || ((c.a.d.a.b.g().b() instanceof VideoPlayActivity) && (this.a.getActivity() instanceof VideoPlayActivity))) {
                                this.a.l();
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.f50594k.z(datas);
                VideoPlayView videoPlayView = this.a.f50593j;
                if (videoPlayView != null) {
                    videoPlayView.notifyDataSetChanged();
                }
                VideoPlayView videoPlayView2 = this.a.f50593j;
                if (videoPlayView2 != null) {
                    videoPlayView2.setSelectIndex(0, true);
                }
                VideoPlayView videoPlayView3 = this.a.f50593j;
                if (videoPlayView3 == null) {
                    return;
                }
                videoPlayView3.setPrimary(this.a.isPrimary());
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void b(List<? extends VideoItemData> datas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, datas) == null) {
                Intrinsics.checkNotNullParameter(datas, "datas");
                if (ListUtils.isEmpty(datas) || this.a.f50594k.v()) {
                    return;
                }
                this.a.f50594k.b(datas);
                VideoPlayView videoPlayView = this.a.f50593j;
                if (videoPlayView != null) {
                    videoPlayView.notifyDataSetChanged();
                }
                VideoPlayView videoPlayView2 = this.a.f50593j;
                if (videoPlayView2 == null) {
                    return;
                }
                videoPlayView2.setViewPagerScrollable(true);
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoAttentionModel.c
        public void c(List<? extends VideoAttentionPersonListData> list, String str, boolean z) {
            VideoAttentionListPageFragment attentionListFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, list, str, z) == null) {
                this.a.f50594k.A(list, str);
                VideoPlayView videoPlayView = this.a.f50593j;
                if (videoPlayView != null) {
                    videoPlayView.notifyDataSetChanged();
                }
                VideoPlayView videoPlayView2 = this.a.f50593j;
                if (videoPlayView2 != null && (attentionListFragment = videoPlayView2.getAttentionListFragment()) != null) {
                    attentionListFragment.scrollToPosition(0);
                }
                VideoPlayView videoPlayView3 = this.a.f50593j;
                if (videoPlayView3 == null) {
                    return;
                }
                videoPlayView3.setViewPagerScrollable(false);
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                        if (this.a.f50591h == 4 || (TbSingleton.getInstance().isFromFeedVideoClick() && this.a.f50591h == 2)) {
                            if (booleanValue) {
                                this.a.b(0);
                                return;
                            } else {
                                this.a.b(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
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

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                        if (this.a.f50594k.e(((Integer) data).intValue())) {
                            VideoPlayView videoPlayView = this.a.f50593j;
                            if (videoPlayView != null) {
                                videoPlayView.notifyDataSetChanged();
                            }
                            VideoPlayView videoPlayView2 = this.a.f50593j;
                            if (videoPlayView2 == null) {
                                return;
                            }
                            videoPlayView2.setPrimary(this.a.isPrimary());
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAttentionPageFragment;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_MIDDLE_AUTO_PLAY);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.a.f50591h != 3 && this.a.f50591h != 4) {
                    if (c.a.r0.b.d.e()) {
                        statisticItem.param("obj_type", 1);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    statisticItem.param("obj_locate", 2);
                } else {
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", this.a.getShowVideoTid(Integer.valueOf(i2)));
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
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

    public /* synthetic */ VideoAttentionPageFragment(BdUniqueId bdUniqueId, BdSwipeRefreshLayout.k kVar, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : bdUniqueId, (i4 & 2) != 0 ? null : kVar, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    public static final void a(VideoAttentionPageFragment this$0, Void r5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, r5) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setInterceptStimeStat(true);
        }
    }

    public static /* synthetic */ long getShowVideoTid$default(VideoAttentionPageFragment videoAttentionPageFragment, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        return videoAttentionPageFragment.getShowVideoTid(num);
    }

    public static final void j(VideoAttentionPageFragment this$0) {
        VideoAttentionModel videoAttentionModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            VideoAttentionModel videoAttentionModel2 = this$0.r;
            if (videoAttentionModel2 != null) {
                videoAttentionModel2.setFrom(this$0.o);
            }
            if (this$0.f50594k.x() || (videoAttentionModel = this$0.r) == null) {
                return;
            }
            videoAttentionModel.loadMore();
        }
    }

    public static final void n(VideoAttentionPageFragment this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.f50591h != 4 || !this$0.o() || this$0.getPageContext() == null || this$0.getPageContext().getPageActivity() == null) {
                return;
            }
            VideoAttentionModel videoAttentionModel = this$0.r;
            boolean z = false;
            if (videoAttentionModel != null && videoAttentionModel.mHasMore == 0) {
                z = true;
            }
            if (z) {
                m.M(this$0.getPageContext().getPageActivity(), this$0.getPageContext().getPageActivity().getString(i.no_more_production));
            }
        }
    }

    public final void b(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (view = this.f50592i) == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        int paddingLeft = view.getPaddingLeft();
        View view2 = this.f50592i;
        Intrinsics.checkNotNull(view2);
        int paddingTop = view2.getPaddingTop();
        View view3 = this.f50592i;
        Intrinsics.checkNotNull(view3);
        view.setPadding(paddingLeft, paddingTop, view3.getPaddingRight(), i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.r0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50591h == 4 ? "a089" : "a023" : (String) invokeV.objValue;
    }

    @Override // c.a.s0.l4.p.n
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VideoItemData s = this.f50594k.s(this.l);
            if (s == null || TextUtils.isEmpty(s.thread_id)) {
                return 0L;
            }
            return c.a.d.f.m.b.g(s.thread_id, 0L);
        }
        return invokeV.longValue;
    }

    public final long getShowVideoTid(Integer num) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, num)) == null) {
            c.a.s0.l4.l.d dVar = this.f50594k;
            if (num == null) {
                VideoPlayView videoPlayView = this.f50593j;
                Intrinsics.checkNotNull(videoPlayView);
                intValue = videoPlayView.currentSelectIndex;
            } else {
                intValue = num.intValue();
            }
            VideoItemData s = dVar.s(intValue);
            if (s == null || TextUtils.isEmpty(s.thread_id)) {
                return 0L;
            }
            return c.a.d.f.m.b.g(s.thread_id, 0L);
        }
        return invokeL.longValue;
    }

    @Override // c.a.s0.l4.p.n
    public void handleActivityResult(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, intent) == null) || (videoPlayView = this.f50593j) == null) {
            return;
        }
        videoPlayView.handleActivityResult(i2, i3, intent);
    }

    @Override // c.a.s0.l4.p.n
    public boolean handleBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            VideoPlayView videoPlayView = this.f50593j;
            return videoPlayView != null && videoPlayView.handleBackPress();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.l4.p.n
    public void handleIndexMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            VideoPlayView videoPlayView = this.f50593j;
            Intrinsics.checkNotNull(videoPlayView);
            int i2 = videoPlayView.firstInIndex;
            VideoPlayView videoPlayView2 = this.f50593j;
            Intrinsics.checkNotNull(videoPlayView2);
            if (i2 != videoPlayView2.currentSelectIndex) {
                VideoPlayView videoPlayView3 = this.f50593j;
                Intrinsics.checkNotNull(videoPlayView3);
                if (videoPlayView3.currentSelectIndex >= 0) {
                    VideoPlayView videoPlayView4 = this.f50593j;
                    Intrinsics.checkNotNull(videoPlayView4);
                    if (videoPlayView4.currentSelectIndex < this.f50594k.k()) {
                        c.a.s0.l4.l.d dVar = this.f50594k;
                        VideoPlayView videoPlayView5 = this.f50593j;
                        Intrinsics.checkNotNull(videoPlayView5);
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
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BdUniqueId bdUniqueId = this.f50588e;
            Activity pageActivity = getPageContext().getPageActivity();
            if (pageActivity != null) {
                VideoPlayView videoPlayView = new VideoPlayView(bdUniqueId, (FragmentActivity) pageActivity, this, this.o, getUniqueId(), 0, this.f50591h, false);
                this.f50593j = videoPlayView;
                if (videoPlayView != null) {
                    videoPlayView.setSubFrom(VideoPlayView.FROM_ATTENTION_SUB_FRAGMENT);
                }
                VideoPlayView videoPlayView2 = this.f50593j;
                if (videoPlayView2 != null) {
                    videoPlayView2.setProgressViewCallback(this.f50589f);
                }
                VideoPlayView videoPlayView3 = this.f50593j;
                if (videoPlayView3 != null) {
                    videoPlayView3.setBottomScrollMoreCallback(this.u);
                }
                VideoPlayView videoPlayView4 = this.f50593j;
                if (videoPlayView4 != null) {
                    videoPlayView4.setOnLoadMoreListener(new VideoPlayView.f() { // from class: c.a.s0.l4.p.i
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.videoplay.VideoPlayView.f
                        public final void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                VideoAttentionPageFragment.j(VideoAttentionPageFragment.this);
                            }
                        }
                    });
                }
                VideoPlayView videoPlayView5 = this.f50593j;
                if (videoPlayView5 != null) {
                    videoPlayView5.showData(this.f50594k, this.l, this.m);
                }
                VideoPlayView videoPlayView6 = this.f50593j;
                if (videoPlayView6 != null) {
                    videoPlayView6.setPageFrom(this.n);
                }
                VideoPlayView videoPlayView7 = this.f50593j;
                if (videoPlayView7 != null) {
                    videoPlayView7.setObjId(this.q);
                }
                VideoPlayView videoPlayView8 = this.f50593j;
                if (videoPlayView8 != null) {
                    videoPlayView8.setVideoChannelPageType(this.f50590g);
                }
                VideoPlayView videoPlayView9 = this.f50593j;
                if (videoPlayView9 == null) {
                    return;
                }
                videoPlayView9.setDragDirectionListener(new e(this));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public final void initData() {
        int i2;
        VideoAttentionModel videoAttentionModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Bundle arguments = getArguments();
            this.f50594k.z((ArrayList) (arguments == null ? null : arguments.getSerializable("video_list")));
            if (getArguments() != null) {
                Bundle arguments2 = getArguments();
                Intrinsics.checkNotNull(arguments2);
                i2 = arguments2.getInt("video_index", 0);
            } else {
                i2 = 0;
            }
            this.l = i2;
            Bundle arguments3 = getArguments();
            this.m = arguments3 == null ? null : (Rect) arguments3.getParcelable(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
            Bundle arguments4 = getArguments();
            this.n = arguments4 == null ? null : arguments4.getString("page_from");
            Bundle arguments5 = getArguments();
            this.o = arguments5 == null ? null : arguments5.getString("from");
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
            if (this.f50594k.v() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
                this.f50594k.z(VideoPlayActivityConfig.bigDataList);
            }
            this.f50594k.C(getUniqueId());
            if (this.f50591h != 4 && (!TbSingleton.getInstance().isFromFeedVideoClick() || this.f50591h != 2)) {
                this.f50594k.D("a023");
            } else {
                b(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f50594k.D("a088");
            }
            VideoAttentionModel videoAttentionModel2 = new VideoAttentionModel(getPageContext(), getUniqueId());
            this.r = videoAttentionModel2;
            if (videoAttentionModel2 != null) {
                videoAttentionModel2.setFrom(this.o);
            }
            VideoAttentionModel videoAttentionModel3 = this.r;
            if (videoAttentionModel3 != null) {
                videoAttentionModel3.H(0);
            }
            VideoAttentionModel videoAttentionModel4 = this.r;
            if (videoAttentionModel4 != null) {
                videoAttentionModel4.I(new b(this));
            }
            if (this.f50594k.s(0) != null) {
                VideoItemData s = this.f50594k.s(0);
                this.q = s != null ? s.thread_id : null;
            }
            VideoAttentionModel videoAttentionModel5 = this.r;
            if (videoAttentionModel5 != null) {
                videoAttentionModel5.setFrom(this.o);
            }
            if (k() || (videoAttentionModel = this.r) == null) {
                return;
            }
            videoAttentionModel.G();
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return false;
            }
            c.a.s0.l4.l.d dVar = this.f50594k;
            if (dVar != null) {
                dVar.B();
            }
            VideoPlayView videoPlayView = this.f50593j;
            if (videoPlayView == null) {
                return true;
            }
            videoPlayView.notifyDataSetChanged();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.s0.l4.l.e.e(getActivity() instanceof VideoPlayActivity ? "2" : "4");
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f50594k.j() == null) {
                return false;
            }
            if (this.f50594k.j().size() == 1) {
                VideoItemModel videoItemModel = this.f50594k.j().get(0);
                Intrinsics.checkNotNullExpressionValue(videoItemModel, "dataController.dataList[0]");
                VideoItemModel videoItemModel2 = videoItemModel;
                if (videoItemModel2.getDataType() == 1 || videoItemModel2.getDataType() == 2) {
                    return true;
                }
            } else if (this.f50594k.j().size() > 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getLifecycle().addObserver(this.s);
            initData();
            i();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                handleActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            VideoPlayView videoPlayView = this.f50593j;
            if (videoPlayView != null) {
                videoPlayView.onChangeSkinType(i2);
            }
            SkinManager.setBackgroundColor(this.f50592i, c.a.s0.l4.c.CAM_X0611);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            registerListener(this.t);
            registerListener(this.w);
            registerListener(this.v);
            View inflate = inflater.inflate(g.video_vertical_page_fragment, viewGroup, false);
            this.f50592i = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            getLifecycle().removeObserver(this.s);
            VideoPlayView videoPlayView = this.f50593j;
            if (videoPlayView != null) {
                videoPlayView.onDestroy();
            }
            if (isPrimary()) {
                l();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroyView();
            c.a.s0.e1.a.i().d("6061002332-203360688");
            c.a.s0.e1.a.i().c("6061002410-390177882");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            VideoPlayView videoPlayView = this.f50593j;
            if (videoPlayView == null) {
                return;
            }
            videoPlayView.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrimary();
            if (!this.p) {
                l();
            }
            if (this.p && this.f50591h == 4) {
                k.c(2);
            }
            if (this.p && !o() && TbadkCoreApplication.isLogin()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_LIST_PAGE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
            VideoPlayView videoPlayView = this.f50593j;
            if (videoPlayView != null) {
                videoPlayView.setPrimary(isPrimary());
            }
            if (k()) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            if (k()) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.setUserVisibleHint(z);
            VideoPlayView videoPlayView = this.f50593j;
            if (videoPlayView != null) {
                videoPlayView.setCurrentFragmentUserHint(z);
            }
            this.p = z;
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
        this.f50588e = bdUniqueId;
        this.f50589f = kVar;
        this.f50590g = i2;
        this.f50591h = i3;
        this.f50594k = new c.a.s0.l4.l.d();
        this.s = new VideoPlayFragment.GoPbCommentFloatListener(new SimpleMessageListener.b() { // from class: c.a.s0.l4.p.d
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tbadk.util.SimpleMessageListener.b
            public final void call(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    VideoAttentionPageFragment.a(VideoAttentionPageFragment.this, (Void) obj);
                }
            }
        });
        this.t = new d(this);
        this.u = new VideoPlayView.h() { // from class: c.a.s0.l4.p.f
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.videoplay.VideoPlayView.h
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    VideoAttentionPageFragment.n(VideoAttentionPageFragment.this);
                }
            }
        };
        this.v = new c(this);
        this.w = new a(this);
    }
}
