package com.baidu.tieba.videoplay.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.tieba.videoplay.model.VideoChannelModel;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import d.a.c.e.p.j;
import d.a.o0.s0.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bT\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0019\u0010\u0018\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001a\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u000fJ\u0017\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\rH\u0016¢\u0006\u0004\b%\u0010\u0014J\u000f\u0010&\u001a\u00020\rH\u0016¢\u0006\u0004\b&\u0010\u0014J\u000f\u0010'\u001a\u00020\rH\u0016¢\u0006\u0004\b'\u0010\u0014J\u000f\u0010(\u001a\u00020\rH\u0016¢\u0006\u0004\b(\u0010\u0014J\u000f\u0010)\u001a\u00020\rH\u0016¢\u0006\u0004\b)\u0010\u0014J\u0017\u0010+\u001a\u00020\r2\u0006\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010\u001dJ\u000f\u0010,\u001a\u00020\rH\u0002¢\u0006\u0004\b,\u0010\u0014J%\u00101\u001a\u00020\r2\u0006\u0010.\u001a\u00020-2\f\u00100\u001a\b\u0012\u0004\u0012\u00020-0/H\u0002¢\u0006\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010<R\u0016\u0010>\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00107R\u0018\u0010?\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010<R\u0016\u0010@\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010:R\u0018\u0010A\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010<R\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010<R\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u00107¨\u0006U"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "", "getCurrentPageKey", "()Ljava/lang/String;", "", "getMissionTid", "()J", "", "requestCode", MiPushCommandMessage.KEY_RESULT_CODE, "Landroid/content/Intent;", "data", "", "handleActivityResult", "(IILandroid/content/Intent;)V", "", "handleBackPress", "()Z", "handleIndexMessage", "()V", "initData", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/os/Bundle;)V", "onActivityResult", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onPrimary", MissionEvent.MESSAGE_RESUME, "height", "setEmptyHeight", "showData", "Lcom/baidu/tieba/video/VideoItemData;", "originalData", "", "newList", "syncFirstVideoFollowState", "(Lcom/baidu/tieba/video/VideoItemData;Ljava/util/List;)V", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "dataController", "Lcom/baidu/tieba/videoplay/controller/VideoDataController;", "isVertail", "Z", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFeedBackListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFrom", "Ljava/lang/String;", "mFromPage", "mHasMore", "mLocate", "mNetworkChangedMessageListener", "mObjId", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Rect;", "mRootView", "Landroid/view/View;", "mStType", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoChannelModel", "Lcom/baidu/tieba/videoplay/model/VideoChannelModel;", "mVideoIndex", "I", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "mVideoPlayModel", "Lcom/baidu/tieba/videoplay/VideoPlayModel;", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoPlayView", "Lcom/baidu/tieba/videoplay/VideoPlayView;", "mVideoTabReqFunAd", "<init>", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public final class VideoVerticalPageFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public View f21689e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayView f21690f;

    /* renamed from: h  reason: collision with root package name */
    public int f21692h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f21693i;
    public String j;
    public String k;
    public String m;
    public String n;
    public boolean o;
    public String p;
    public VideoPlayModel q;
    public VideoChannelModel r;
    public boolean s;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.o0.t3.a.c f21691g = new d.a.o0.t3.a.c();
    public boolean l = true;
    public final CustomMessageListener t = new d(2921565, true);
    public final CustomMessageListener u = new e(2000994);

    /* loaded from: classes5.dex */
    public static final class a implements a.f {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // d.a.o0.s0.a.f
        public void a(String str, int i2) {
            if (!d.a.o0.s0.a.h().k("6061002182-391683336") || VideoVerticalPageFragment.this.f21690f == null) {
                return;
            }
            d.a.o0.t3.a.c cVar = VideoVerticalPageFragment.this.f21691g;
            VideoPlayView videoPlayView = VideoVerticalPageFragment.this.f21690f;
            if (videoPlayView == null) {
                Intrinsics.throwNpe();
            }
            cVar.a(videoPlayView.f21671h);
            VideoPlayView videoPlayView2 = VideoVerticalPageFragment.this.f21690f;
            if (videoPlayView2 != null) {
                videoPlayView2.x();
            }
        }

        @Override // d.a.o0.s0.a.f
        public void onError(String str) {
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements VideoPlayModel.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.b
        public void a(List<? extends VideoItemData> list, boolean z) {
            VideoVerticalPageFragment.this.l = z;
            if (ListUtils.isEmpty(list) || VideoVerticalPageFragment.this.f21691g.i()) {
                return;
            }
            VideoVerticalPageFragment videoVerticalPageFragment = VideoVerticalPageFragment.this;
            VideoItemData h2 = videoVerticalPageFragment.f21691g.h(0);
            if (h2 == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(h2, "dataController.getVideoData(0)!!");
            videoVerticalPageFragment.V0(h2, list);
            VideoVerticalPageFragment.this.f21691g.k(list);
            if (d.a.o0.s0.a.h().k("6061002182-391683336") && VideoVerticalPageFragment.this.f21690f != null) {
                d.a.o0.t3.a.c cVar = VideoVerticalPageFragment.this.f21691g;
                VideoPlayView videoPlayView = VideoVerticalPageFragment.this.f21690f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                cVar.a(videoPlayView.f21671h - 1);
            }
            VideoPlayView videoPlayView2 = VideoVerticalPageFragment.this.f21690f;
            if (videoPlayView2 != null) {
                videoPlayView2.x();
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.b
        public void b(List<? extends VideoItemData> list, boolean z) {
            VideoVerticalPageFragment.this.l = z;
            if (ListUtils.isEmpty(list) || VideoVerticalPageFragment.this.f21691g.i()) {
                return;
            }
            VideoVerticalPageFragment.this.f21691g.b(list);
            if (VideoVerticalPageFragment.this.f21690f != null) {
                d.a.o0.t3.a.c cVar = VideoVerticalPageFragment.this.f21691g;
                VideoPlayView videoPlayView = VideoVerticalPageFragment.this.f21690f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                cVar.a(videoPlayView.f21671h);
            }
            VideoPlayView videoPlayView2 = VideoVerticalPageFragment.this.f21690f;
            if (videoPlayView2 != null) {
                videoPlayView2.x();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements VideoChannelModel.c {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void a(List<? extends VideoItemData> list, boolean z) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            VideoVerticalPageFragment.this.f21691g.k(list);
            if (d.a.o0.s0.a.h().k("6061002182-391683336") && VideoVerticalPageFragment.this.f21690f != null) {
                d.a.o0.t3.a.c cVar = VideoVerticalPageFragment.this.f21691g;
                VideoPlayView videoPlayView = VideoVerticalPageFragment.this.f21690f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                cVar.a(videoPlayView.f21671h);
            }
            VideoPlayView videoPlayView2 = VideoVerticalPageFragment.this.f21690f;
            if (videoPlayView2 != null) {
                videoPlayView2.x();
            }
            if (z) {
                VideoPlayView videoPlayView3 = VideoVerticalPageFragment.this.f21690f;
                if (videoPlayView3 != null) {
                    videoPlayView3.N(0, true);
                }
                VideoPlayView videoPlayView4 = VideoVerticalPageFragment.this.f21690f;
                if (videoPlayView4 != null) {
                    videoPlayView4.M(VideoVerticalPageFragment.this.isPrimary());
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.model.VideoChannelModel.c
        public void b(List<? extends VideoItemData> list) {
            if (ListUtils.isEmpty(list) || VideoVerticalPageFragment.this.f21691g.i()) {
                return;
            }
            VideoVerticalPageFragment.this.f21691g.b(list);
            if (VideoVerticalPageFragment.this.f21690f != null) {
                d.a.o0.t3.a.c cVar = VideoVerticalPageFragment.this.f21691g;
                VideoPlayView videoPlayView = VideoVerticalPageFragment.this.f21690f;
                if (videoPlayView == null) {
                    Intrinsics.throwNpe();
                }
                cVar.a(videoPlayView.f21671h);
            }
            VideoPlayView videoPlayView2 = VideoVerticalPageFragment.this.f21690f;
            if (videoPlayView2 != null) {
                videoPlayView2.x();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends CustomMessageListener {
        public d(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Integer) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    if (VideoVerticalPageFragment.this.f21691g.c(((Integer) data).intValue())) {
                        VideoPlayView videoPlayView = VideoVerticalPageFragment.this.f21690f;
                        if (videoPlayView != null) {
                            videoPlayView.x();
                        }
                        VideoPlayView videoPlayView2 = VideoVerticalPageFragment.this.f21690f;
                        if (videoPlayView2 != null) {
                            videoPlayView2.M(VideoVerticalPageFragment.this.isPrimary());
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
    public static final class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && j.z() && VideoVerticalPageFragment.this.f21691g.i()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921567));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class f implements a.f {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public f() {
        }

        @Override // d.a.o0.s0.a.f
        public void a(String str, int i2) {
            if (!d.a.o0.s0.a.h().k("6061002182-391683336") || VideoVerticalPageFragment.this.f21690f == null) {
                return;
            }
            d.a.o0.t3.a.c cVar = VideoVerticalPageFragment.this.f21691g;
            VideoPlayView videoPlayView = VideoVerticalPageFragment.this.f21690f;
            if (videoPlayView == null) {
                Intrinsics.throwNpe();
            }
            cVar.a(videoPlayView.f21671h);
            VideoPlayView videoPlayView2 = VideoVerticalPageFragment.this.f21690f;
            if (videoPlayView2 != null) {
                videoPlayView2.x();
            }
        }

        @Override // d.a.o0.s0.a.f
        public void onError(String str) {
        }
    }

    /* loaded from: classes5.dex */
    public static final class g implements VideoPlayView.g {
        public g() {
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.g
        public final void a() {
            VideoChannelModel videoChannelModel;
            VideoPlayModel videoPlayModel;
            if (VideoVerticalPageFragment.this.l) {
                if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_NANI_VIDEO, VideoVerticalPageFragment.this.j)) {
                    VideoPlayModel videoPlayModel2 = VideoVerticalPageFragment.this.q;
                    if (videoPlayModel2 != null) {
                        videoPlayModel2.setFrom(VideoVerticalPageFragment.this.k);
                    }
                    if (VideoVerticalPageFragment.this.f21691g.d() <= 0 || (videoPlayModel = VideoVerticalPageFragment.this.q) == null) {
                        return;
                    }
                    videoPlayModel.A(VideoVerticalPageFragment.this.f21691g.h(0));
                    return;
                }
                VideoChannelModel videoChannelModel2 = VideoVerticalPageFragment.this.r;
                if (videoChannelModel2 != null) {
                    videoChannelModel2.setFrom(VideoVerticalPageFragment.this.k);
                }
                if (VideoVerticalPageFragment.this.f21691g.d() <= 0 || (videoChannelModel = VideoVerticalPageFragment.this.r) == null) {
                    return;
                }
                videoChannelModel.loadMore();
            }
        }
    }

    public final long P0() {
        VideoItemData h2 = this.f21691g.h(this.f21692h);
        if (h2 == null || TextUtils.isEmpty(h2.thread_id)) {
            return 0L;
        }
        return d.a.c.e.m.b.f(h2.thread_id, 0L);
    }

    public final void Q0(int i2, int i3, Intent intent) {
        VideoPlayView videoPlayView = this.f21690f;
        if (videoPlayView != null) {
            videoPlayView.q(i2, i3, intent);
        }
    }

    public final boolean R0() {
        VideoPlayView videoPlayView = this.f21690f;
        return videoPlayView != null && videoPlayView.r();
    }

    public final void S0() {
        VideoPlayView videoPlayView = this.f21690f;
        if (videoPlayView == null) {
            Intrinsics.throwNpe();
        }
        int i2 = videoPlayView.f21672i;
        VideoPlayView videoPlayView2 = this.f21690f;
        if (videoPlayView2 == null) {
            Intrinsics.throwNpe();
        }
        if (i2 != videoPlayView2.f21671h) {
            VideoPlayView videoPlayView3 = this.f21690f;
            if (videoPlayView3 == null) {
                Intrinsics.throwNpe();
            }
            if (videoPlayView3.f21671h >= 0) {
                VideoPlayView videoPlayView4 = this.f21690f;
                if (videoPlayView4 == null) {
                    Intrinsics.throwNpe();
                }
                if (videoPlayView4.f21671h < this.f21691g.d()) {
                    d.a.o0.t3.a.c cVar = this.f21691g;
                    VideoPlayView videoPlayView5 = this.f21690f;
                    if (videoPlayView5 == null) {
                        Intrinsics.throwNpe();
                    }
                    VideoItemData h2 = cVar.h(videoPlayView5.f21671h);
                    if (h2 == null || StringUtils.isNull(h2.thread_id)) {
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, h2.thread_id));
                }
            }
        }
    }

    public final void T0(int i2) {
        View view = this.f21689e;
        if (view != null) {
            if (view == null) {
                Intrinsics.throwNpe();
            }
            int paddingLeft = view.getPaddingLeft();
            View view2 = this.f21689e;
            if (view2 == null) {
                Intrinsics.throwNpe();
            }
            int paddingTop = view2.getPaddingTop() + UtilHelper.getStatusBarHeight();
            View view3 = this.f21689e;
            if (view3 == null) {
                Intrinsics.throwNpe();
            }
            int paddingRight = view3.getPaddingRight();
            View view4 = this.f21689e;
            if (view4 == null) {
                Intrinsics.throwNpe();
            }
            view.setPadding(paddingLeft, paddingTop, paddingRight, view4.getPaddingBottom() + i2);
        }
    }

    public final void U0() {
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
        Activity pageActivity = pageContext.getPageActivity();
        if (pageActivity != null) {
            VideoPlayView videoPlayView = new VideoPlayView((FragmentActivity) pageActivity, this.k, getUniqueId());
            this.f21690f = videoPlayView;
            if (videoPlayView != null) {
                videoPlayView.K(new g());
            }
            VideoPlayView videoPlayView2 = this.f21690f;
            if (videoPlayView2 != null) {
                videoPlayView2.P(this.f21691g, this.f21692h, this.f21693i);
            }
            VideoPlayView videoPlayView3 = this.f21690f;
            if (videoPlayView3 != null) {
                videoPlayView3.L(this.j);
            }
            VideoPlayView videoPlayView4 = this.f21690f;
            if (videoPlayView4 != null) {
                videoPlayView4.J(this.p);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final void V0(VideoItemData videoItemData, List<? extends VideoItemData> list) {
        UserItemData userItemData;
        UserItemData userItemData2;
        String str;
        VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list, 0);
        if (videoItemData == null || (userItemData = videoItemData.author_info) == null || videoItemData2 == null || (userItemData2 = videoItemData2.author_info) == null || (str = userItemData2.user_id) == null || !Intrinsics.areEqual(str, userItemData.user_id)) {
            return;
        }
        videoItemData2.author_info.is_follow = videoItemData.author_info.is_follow;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.n0.k0.a
    public String getCurrentPageKey() {
        return Intrinsics.areEqual(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB, this.k) ? "a088" : "a023";
    }

    public final void initData() {
        int i2;
        boolean z;
        VideoChannelModel videoChannelModel;
        Bundle arguments = getArguments();
        this.f21691g.k((ArrayList) (arguments != null ? arguments.getSerializable(VideoPlayActivityConfig.VIDEO_LIST) : null));
        if (getArguments() != null) {
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                Intrinsics.throwNpe();
            }
            i2 = arguments2.getInt(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        } else {
            i2 = 0;
        }
        this.f21692h = i2;
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
        Activity pageActivity = pageContext.getPageActivity();
        Intrinsics.checkExpressionValueIsNotNull(pageActivity, "pageContext.pageActivity");
        Intent intent = pageActivity.getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "pageContext.pageActivity.intent");
        this.f21693i = intent.getSourceBounds();
        Bundle arguments3 = getArguments();
        this.j = arguments3 != null ? arguments3.getString("page_from") : null;
        Bundle arguments4 = getArguments();
        this.k = arguments4 != null ? arguments4.getString("from") : null;
        Bundle arguments5 = getArguments();
        this.m = arguments5 != null ? arguments5.getString("st_type") : null;
        Bundle arguments6 = getArguments();
        this.n = arguments6 != null ? arguments6.getString("yuelaou_locate") : null;
        if (getArguments() != null) {
            Bundle arguments7 = getArguments();
            if (arguments7 == null) {
                Intrinsics.throwNpe();
            }
            z = arguments7.getBoolean(VideoPlayActivityConfig.PARAM_IS_VERTAIL, true);
        } else {
            z = false;
        }
        this.o = z;
        if (this.f21691g.i() && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            this.f21691g.k(VideoPlayActivityConfig.bigDataList);
        }
        this.f21691g.l(getUniqueId());
        if (Intrinsics.areEqual(this.k, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB)) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
            T0(inst.getMainTabBottomBarHeight());
            this.f21691g.m("a088");
        } else {
            this.f21691g.m("a023");
        }
        if (Intrinsics.areEqual(VideoPlayActivityConfig.FROM_NANI_VIDEO, this.j)) {
            if (VideoMiddleAdSwitch.isOn()) {
                d.a.o0.s0.a.h().n(getActivity(), new a(), this.f21691g.g());
            }
            VideoPlayModel videoPlayModel = new VideoPlayModel(getPageContext());
            this.q = videoPlayModel;
            if (videoPlayModel != null) {
                videoPlayModel.setFrom(this.k);
            }
            VideoPlayModel videoPlayModel2 = this.q;
            if (videoPlayModel2 != null) {
                videoPlayModel2.C(new b());
            }
            if (this.f21691g.h(0) != null) {
                VideoItemData h2 = this.f21691g.h(0);
                this.p = h2 != null ? h2.thread_id : null;
            }
            VideoPlayModel videoPlayModel3 = this.q;
            if (videoPlayModel3 != null) {
                videoPlayModel3.setFrom(this.k);
            }
            VideoPlayModel videoPlayModel4 = this.q;
            if (videoPlayModel4 != null) {
                videoPlayModel4.B(this.f21691g.h(0), this.m, this.n, this.o);
                return;
            }
            return;
        }
        VideoChannelModel videoChannelModel2 = new VideoChannelModel(getPageContext(), getUniqueId());
        this.r = videoChannelModel2;
        if (videoChannelModel2 != null) {
            videoChannelModel2.setFrom(this.k);
        }
        VideoChannelModel videoChannelModel3 = this.r;
        if (videoChannelModel3 != null) {
            videoChannelModel3.E(new c());
        }
        if (this.f21691g.h(0) != null) {
            VideoItemData h3 = this.f21691g.h(0);
            this.p = h3 != null ? h3.thread_id : null;
        }
        VideoChannelModel videoChannelModel4 = this.r;
        if (videoChannelModel4 != null) {
            videoChannelModel4.setFrom(this.k);
        }
        if ((j.z() || isPrimary()) && (videoChannelModel = this.r) != null) {
            videoChannelModel.D();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initData();
        U0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (intent != null) {
            Q0(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        VideoPlayView videoPlayView = this.f21690f;
        if (videoPlayView != null) {
            videoPlayView.y(i2);
        }
        SkinManager.setBackgroundColor(this.f21689e, R.color.CAM_X0611);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        registerListener(this.t);
        registerListener(this.u);
        View inflate = layoutInflater.inflate(R.layout.video_vertical_page_fragment, viewGroup, false);
        this.f21689e = inflate;
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VideoPlayView videoPlayView = this.f21690f;
        if (videoPlayView != null) {
            videoPlayView.z();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        d.a.o0.s0.a.h().c("6061002182-391683336");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VideoPlayView videoPlayView = this.f21690f;
        if (videoPlayView != null) {
            videoPlayView.A();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        VideoPlayView videoPlayView = this.f21690f;
        if (videoPlayView != null) {
            videoPlayView.M(isPrimary());
        }
        if (this.s || !isPrimary() || !VideoMiddleAdSwitch.isOn() || (!Intrinsics.areEqual(this.k, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB))) {
            return;
        }
        this.s = true;
        d.a.o0.s0.a.h().n(getActivity(), new f(), this.f21691g.g());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
