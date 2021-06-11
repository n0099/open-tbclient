package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.GestureDetectorCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoMiddleNiaiControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.video.ActivityItemData;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.tencent.connect.common.Constants;
import d.a.m0.b1.p.a;
import d.a.m0.h.a;
import d.a.m0.r.s.a;
import d.a.m0.r.s.l;
import d.a.n0.k2.f;
import d.a.n0.t3.b.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPlayFragment extends BaseFragment implements a.b, d.a.n0.t3.c.a.a {
    public EMTextView A;
    public EMTextView B;
    public EMTextView C;
    public TextView D;
    public View E;
    public LinearLayout F;
    public LinearLayout G;
    public LinearLayout H;
    public VideoItemData I;
    public VideoItemModel J;
    public TextView K;
    public VideoMiddleNiaiControllerView L;
    public boolean M;
    public boolean N;
    public AlphaAnimation O;
    public Rect P;
    public ImageView Q;
    public ImageView R;
    public ImageView S;
    public TextView T;
    public View U;
    public TextView V;
    public RelativeLayout.LayoutParams W;
    public int X;
    public int Y;
    public boolean Z;
    public int a0;
    public boolean b0;
    public String c0;
    public String d0;
    public d.a.m0.r.s.j e0;
    public d.a.m0.r.s.l f0;

    /* renamed from: g  reason: collision with root package name */
    public View f21526g;

    /* renamed from: h  reason: collision with root package name */
    public TbCyberVideoView f21527h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f21528i;
    public View j;
    public ImageView k;
    public String k0;
    public ImageView l;
    public HeadImageView m;
    public RelativeLayout.LayoutParams m0;
    public LinearLayout n;
    public String n0;
    public LinearLayout o;
    public boolean o0;
    public LinearLayout p;
    public TBLottieAnimationView p0;
    public LinearLayout q;
    public LinearLayout r;
    public ImageView s;
    public ImageView t;
    public d.a.n0.t3.b.a t0;
    public ImageView u;
    public f.c u0;
    public ExpandableTextView v;
    public k0 v0;
    public EMTextView w;
    public EMTextView x;
    public EMTextView y;
    public EMTextView z;

    /* renamed from: e  reason: collision with root package name */
    public int f21524e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f21525f = 1;
    public ForumManageModel g0 = null;
    public d.a.m0.h.a h0 = null;
    public d.a.m0.s.e.a i0 = null;
    public BdUniqueId j0 = BdUniqueId.gen();
    public boolean l0 = false;
    public boolean q0 = false;
    public int r0 = 1;
    public int s0 = -1;
    public CustomMessageListener w0 = new k(2001115);
    public final CustomMessageListener x0 = new v(2000994);
    public CustomMessageListener y0 = new d0(2016528);
    public l.d z0 = new t();
    public l.d A0 = new u();
    public l.d B0 = new w();
    public Runnable C0 = new y();
    public CyberPlayerManager.OnInfoListener D0 = new a0();
    public CyberPlayerManager.OnCompletionListener E0 = new b0();
    public CyberPlayerManager.OnPreparedListener F0 = new c0();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21529e;

        public a(String str) {
            this.f21529e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f21529e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{this.f21529e}, true);
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements CyberPlayerManager.OnInfoListener {
        public a0() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (VideoPlayFragment.this.M) {
                if ((i2 == 3 || i2 == 904) && VideoPlayFragment.this.f21528i.getVisibility() == 0) {
                    VideoPlayFragment.this.f21528i.clearAnimation();
                    VideoPlayFragment.this.f21528i.startAnimation(VideoPlayFragment.this.O);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserItemData userItemData;
            UserItemData userItemData2;
            VideoItemData videoItemData = VideoPlayFragment.this.I;
            if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id)) {
                return;
            }
            VideoItemData videoItemData2 = VideoPlayFragment.this.I;
            if (videoItemData2 != null && (userItemData2 = videoItemData2.author_info) != null) {
                long f2 = d.a.c.e.m.b.f(userItemData2.user_id, 0L);
                long f3 = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
                boolean z = f2 == f3;
                if (f2 == 0 && f3 == 0) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(f2, z, false)));
                StatisticItem statisticItem = new StatisticItem("c12798");
                statisticItem.param("tid", VideoPlayFragment.this.I.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
            VideoPlayFragment.this.I1(5);
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements CyberPlayerManager.OnCompletionListener {
        public b0() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            TbCyberVideoView tbCyberVideoView = VideoPlayFragment.this.f21527h;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.N();
                VideoPlayFragment.this.f21527h.seekTo(0);
                VideoPlayFragment.this.f21527h.start();
                VideoPlayFragment.this.T1();
                VideoPlayFragment.q1(VideoPlayFragment.this);
                if (VideoPlayFragment.this.r0 == 3) {
                    VideoPlayFragment.this.B1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
            VideoItemData videoItemData = videoPlayFragment.I;
            if (videoItemData == null || videoItemData.act_info == null) {
                return;
            }
            d.a.m0.l.a.k(videoPlayFragment.getActivity(), VideoPlayFragment.this.I.act_info.link_url);
            StatisticItem statisticItem = new StatisticItem("c12799");
            statisticItem.param("tid", VideoPlayFragment.this.I.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements CyberPlayerManager.OnPreparedListener {
        public c0() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TbCyberVideoView tbCyberVideoView = VideoPlayFragment.this.f21527h;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.setVolume(1.0f, 1.0f);
                if (VideoPlayFragment.this.f21527h.getDuration() < 15000 || VideoPlayFragment.this.L == null) {
                    VideoPlayFragment.this.L.setVisibility(8);
                    return;
                }
                VideoPlayFragment.this.L.setVisibility(0);
                if (VideoPlayFragment.this.L.getCurProgress() == 0) {
                    VideoPlayFragment.this.L.s();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment.this.M1();
            VideoPlayFragment.this.I1(7);
        }
    }

    /* loaded from: classes5.dex */
    public class d0 extends CustomMessageListener {
        public d0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.n0.e3.h0.e)) {
                return;
            }
            AgreeData agreeData = ((d.a.n0.e3.h0.e) customResponsedMessage.getData()).f57686b;
            if (VideoPlayFragment.this.I == null || agreeData == null) {
                return;
            }
            String str = agreeData.nid;
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                BaijiahaoData baijiahaoData = VideoPlayFragment.this.I.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
                VideoPlayFragment.this.I.agree_num = String.valueOf(agreeData.agreeNum);
                VideoPlayFragment.this.I.is_agreed = agreeData.hasAgree ? "1" : "0";
                VideoPlayFragment.this.y1();
                return;
            }
            String str2 = agreeData.threadId;
            String str3 = VideoPlayFragment.this.I.thread_id;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
            VideoPlayFragment.this.I.agree_num = String.valueOf(agreeData.agreeNum);
            VideoPlayFragment.this.I.is_agreed = agreeData.hasAgree ? "1" : "0";
            VideoPlayFragment.this.y1();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoItemData videoItemData = VideoPlayFragment.this.I;
            if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.I.thread_id));
            }
            VideoPlayFragment.this.getActivity().finish();
        }
    }

    /* loaded from: classes5.dex */
    public class e0 extends GestureDetector.SimpleOnGestureListener {
        public e0() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            VideoPlayFragment.this.O(0.0f, 0.0f);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (motionEvent.getX() - motionEvent2.getX() > 50.0f) {
                VideoPlayFragment.this.k();
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            VideoPlayFragment.this.m();
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment.this.f2();
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetectorCompat f21541e;

        public f0(GestureDetectorCompat gestureDetectorCompat) {
            this.f21541e = gestureDetectorCompat;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f21541e.onTouchEvent(motionEvent);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AntiHelper.c(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.I)) {
                return;
            }
            VideoPlayFragment.this.M1();
            StatisticItem statisticItem = new StatisticItem("c12796");
            statisticItem.param("tid", VideoPlayFragment.this.I.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            VideoPlayFragment.this.I1(2);
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements View.OnLongClickListener {
        public g0() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
            videoPlayFragment.F1(videoPlayFragment.f21524e);
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements f.c {
        public h0() {
        }

        @Override // d.a.n0.k2.f.c
        public void a(int i2, int i3) {
            if (VideoPlayFragment.this.u0 != null) {
                VideoPlayFragment.this.u0.a(i2, i3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment.this.h2();
            StatisticItem statisticItem = new StatisticItem("c12797");
            statisticItem.param("tid", VideoPlayFragment.this.I.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            VideoPlayFragment.this.I1(3);
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem2.param("tid", VideoPlayFragment.this.I.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("obj_locate", 19);
            statisticItem2.param("nid", VideoPlayFragment.this.I.nid);
            BaijiahaoData baijiahaoData = VideoPlayFragment.this.I.baijiahaoData;
            if (baijiahaoData != null && !d.a.c.e.p.k.isEmpty(baijiahaoData.oriUgcVid)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, VideoPlayFragment.this.I.baijiahaoData.oriUgcVid);
            }
            if (VideoPlayFragment.this.I.getVideoType() == 1) {
                statisticItem2.param("card_type", 2);
            } else if (VideoPlayFragment.this.I.getVideoType() == 2) {
                statisticItem2.param("card_type", 8);
            } else if (VideoPlayFragment.this.I.getVideoType() == 3) {
                statisticItem2.param("card_type", 6);
            }
            statisticItem2.param("recom_source", VideoPlayFragment.this.I.mRecomSource);
            statisticItem2.param("ab_tag", VideoPlayFragment.this.I.mRecomAbTag);
            statisticItem2.param("weight", VideoPlayFragment.this.I.mRecomWeight);
            statisticItem2.param("extra", VideoPlayFragment.this.I.mRecomExtra);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
            if (d.a.m0.j0.c.j(VideoPlayFragment.this.getBaseFragmentActivity()) != null && d.a.m0.j0.c.j(VideoPlayFragment.this.getBaseFragmentActivity()).a() != null && d.a.m0.j0.c.j(VideoPlayFragment.this.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(d.a.m0.j0.c.j(VideoPlayFragment.this.getBaseFragmentActivity()).b().locatePage)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements View.OnClickListener {
        public i0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
            if (videoPlayFragment.D1(videoPlayFragment.getPageContext(), 11001)) {
                VideoPlayFragment.this.U.setVisibility(8);
                if (VideoPlayFragment.this.t0 != null && VideoPlayFragment.this.t0.a() != null) {
                    VideoPlayFragment.this.t0.a().j();
                    VideoPlayFragment videoPlayFragment2 = VideoPlayFragment.this;
                    if (videoPlayFragment2.I != null) {
                        videoPlayFragment2.t0.w(VideoPlayFragment.this.I);
                    }
                }
                if (VideoPlayFragment.this.I != null) {
                    StatisticItem statisticItem = new StatisticItem("c13025");
                    statisticItem.param("tid", VideoPlayFragment.this.I.thread_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", VideoPlayFragment.this.I.forum_id);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoItemData videoItemData;
            if (ViewHelper.checkUpIsLogin(VideoPlayFragment.this.getActivity())) {
                VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
                if (videoPlayFragment.B != null && (videoItemData = videoPlayFragment.I) != null && videoItemData.author_info != null && videoPlayFragment.C != null) {
                    d.a.m0.s.e.a aVar = videoPlayFragment.i0;
                    VideoPlayFragment videoPlayFragment2 = VideoPlayFragment.this;
                    UserItemData userItemData = videoPlayFragment2.I.author_info;
                    aVar.m(true, userItemData.portrait, userItemData.user_id, false, "6", videoPlayFragment2.j0, VideoPlayFragment.this.I.forum_id, "0");
                    VideoPlayFragment videoPlayFragment3 = VideoPlayFragment.this;
                    videoPlayFragment3.I.author_info.is_follow = "1";
                    videoPlayFragment3.z1();
                    VideoPlayFragment.this.B.setVisibility(8);
                    VideoPlayFragment.this.C.setVisibility(0);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setStartOffset(1000L);
                    scaleAnimation.setDuration(300L);
                    scaleAnimation.setFillAfter(true);
                    VideoPlayFragment.this.C.startAnimation(scaleAnimation);
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_CLICK);
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(VideoPlayFragment.this.d0)) {
                    statisticItem.param("obj_locate", 1);
                } else {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param("obj_source", VideoPlayFragment.this.L1());
                }
                statisticItem.param("tid", VideoPlayFragment.this.I.thread_id);
                statisticItem.param("fid", VideoPlayFragment.this.I.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                VideoPlayFragment.this.I1(6);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements SeekBar.OnSeekBarChangeListener {
        public j0() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z) {
                VideoPlayFragment.this.G1(true);
                EMTextView eMTextView = VideoPlayFragment.this.z;
                if (eMTextView != null) {
                    eMTextView.setText(StringHelper.stringForVideoTime(i2));
                }
                EMTextView eMTextView2 = VideoPlayFragment.this.A;
                if (eMTextView2 != null) {
                    eMTextView2.setText("/" + StringHelper.stringForVideoTime(VideoPlayFragment.this.f21527h.getDuration()));
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_PROGRESS_CLICK);
                statisticItem.param("tid", VideoPlayFragment.this.I.thread_id);
                statisticItem.param("fid", VideoPlayFragment.this.I.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(VideoPlayFragment.this.d0)) {
                    statisticItem.param("obj_type", 1);
                } else {
                    statisticItem.param("obj_type", 2);
                }
                statisticItem.param("obj_type", VideoPlayFragment.this.L1());
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            VideoPlayFragment.this.o0 = true;
            if (VideoPlayFragment.this.L != null) {
                VideoPlayFragment.this.L.setBottomBarShow(false, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(VideoPlayFragment.this.d0) ? 1 : 0);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            VideoPlayFragment.this.o0 = false;
            if (seekBar != null) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(null);
                VideoPlayFragment.this.G1(false);
                if (!VideoPlayFragment.this.f21527h.isPlaying()) {
                    VideoPlayFragment.this.f21527h.start();
                    VideoPlayFragment.this.u.setVisibility(8);
                }
                d.a.c.e.m.e.a().postDelayed(VideoPlayFragment.this.C0, 3000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserItemData userItemData;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                VideoItemData videoItemData = VideoPlayFragment.this.I;
                if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id) || data == null || !VideoPlayFragment.this.I.author_info.user_id.equals(data.f12638c)) {
                    return;
                }
                boolean z = true;
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.j0)) ? false : false;
                if (data.l != null) {
                    return;
                }
                if (!data.f12636a) {
                    if (!z || "0".equals(VideoPlayFragment.this.I.author_info.is_follow)) {
                        return;
                    }
                    d.a.c.e.p.l.L(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                    VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
                    videoPlayFragment.I.author_info.is_follow = "0";
                    videoPlayFragment.z1();
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    if (VideoPlayFragment.this.M) {
                        if (z) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.I));
                        } else {
                            VideoPlayFragment videoPlayFragment2 = VideoPlayFragment.this;
                            videoPlayFragment2.I.author_info.is_follow = "1";
                            videoPlayFragment2.z1();
                        }
                    }
                } else {
                    VideoPlayFragment videoPlayFragment3 = VideoPlayFragment.this;
                    videoPlayFragment3.I.author_info.is_follow = "0";
                    videoPlayFragment3.z1();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if ("index".equals(VideoPlayFragment.this.d0)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface k0 {
        void onStart();
    }

    /* loaded from: classes5.dex */
    public class l implements Animation.AnimationListener {
        public l() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (VideoPlayFragment.this.f21528i != null) {
                VideoPlayFragment.this.f21528i.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayFragment.this.M) {
                    VideoPlayFragment.this.startPlay();
                    VideoPlayFragment.this.P = null;
                }
            }
        }

        public m() {
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00a9  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i2;
            int i3;
            float f2;
            int width = VideoPlayFragment.this.f21528i.getWidth();
            int height = VideoPlayFragment.this.f21528i.getHeight();
            if (height > 0 && width > 0) {
                if (d.a.c.e.m.b.d(VideoPlayFragment.this.I.video_height, 0) > 0 && d.a.c.e.m.b.d(VideoPlayFragment.this.I.video_width, 0) > 0) {
                    float f3 = width;
                    float f4 = height;
                    float f5 = f3 / f4;
                    float c2 = d.a.c.e.m.b.c(VideoPlayFragment.this.I.video_width, 0.0f) / d.a.c.e.m.b.c(VideoPlayFragment.this.I.video_height, 0.0f);
                    if (c2 > 0.0f && Math.abs(c2 - f5) > 0.05d) {
                        if (c2 > f5) {
                            i3 = (int) (f3 / c2);
                            i2 = width;
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.X, VideoPlayFragment.this.Y);
                            layoutParams.leftMargin = VideoPlayFragment.this.P.left;
                            layoutParams.topMargin = VideoPlayFragment.this.P.top;
                            VideoPlayFragment.this.f21528i.setLayoutParams(layoutParams);
                            float f6 = 1.0f;
                            if (VideoPlayFragment.this.Y > 0 || VideoPlayFragment.this.X <= 0) {
                                f2 = 1.0f;
                            } else {
                                f6 = i3 / VideoPlayFragment.this.Y;
                                f2 = i2 / VideoPlayFragment.this.X;
                            }
                            VideoPlayFragment.this.f21528i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f6).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.P.left + ((VideoPlayFragment.this.P.right - VideoPlayFragment.this.P.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.P.top + ((VideoPlayFragment.this.P.bottom - VideoPlayFragment.this.P.top) / 2))).start();
                            VideoPlayFragment.this.f21528i.postDelayed(new a(), 200L);
                        }
                        i2 = (int) (f4 * c2);
                        i3 = height;
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.X, VideoPlayFragment.this.Y);
                        layoutParams2.leftMargin = VideoPlayFragment.this.P.left;
                        layoutParams2.topMargin = VideoPlayFragment.this.P.top;
                        VideoPlayFragment.this.f21528i.setLayoutParams(layoutParams2);
                        float f62 = 1.0f;
                        if (VideoPlayFragment.this.Y > 0) {
                        }
                        f2 = 1.0f;
                        VideoPlayFragment.this.f21528i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f62).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.P.left + ((VideoPlayFragment.this.P.right - VideoPlayFragment.this.P.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.P.top + ((VideoPlayFragment.this.P.bottom - VideoPlayFragment.this.P.top) / 2))).start();
                        VideoPlayFragment.this.f21528i.postDelayed(new a(), 200L);
                    }
                }
            }
            i2 = width;
            i3 = height;
            RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.X, VideoPlayFragment.this.Y);
            layoutParams22.leftMargin = VideoPlayFragment.this.P.left;
            layoutParams22.topMargin = VideoPlayFragment.this.P.top;
            VideoPlayFragment.this.f21528i.setLayoutParams(layoutParams22);
            float f622 = 1.0f;
            if (VideoPlayFragment.this.Y > 0) {
            }
            f2 = 1.0f;
            VideoPlayFragment.this.f21528i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f622).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.P.left + ((VideoPlayFragment.this.P.right - VideoPlayFragment.this.P.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.P.top + ((VideoPlayFragment.this.P.bottom - VideoPlayFragment.this.P.top) / 2))).start();
            VideoPlayFragment.this.f21528i.postDelayed(new a(), 200L);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoItemData videoItemData;
            int width = VideoPlayFragment.this.f21528i.getWidth();
            int height = VideoPlayFragment.this.f21528i.getHeight();
            if (height <= 0 || width <= 0 || (videoItemData = VideoPlayFragment.this.I) == null) {
                return;
            }
            if (d.a.c.e.m.b.d(videoItemData.video_height, 0) <= 0 || d.a.c.e.m.b.d(VideoPlayFragment.this.I.video_width, 0) <= 0) {
                return;
            }
            float f2 = width;
            float f3 = height;
            float f4 = f2 / f3;
            float c2 = d.a.c.e.m.b.c(VideoPlayFragment.this.I.video_width, 0.0f) / d.a.c.e.m.b.c(VideoPlayFragment.this.I.video_height, 0.0f);
            if (c2 > 0.0f && Math.abs(c2 - f4) > 0.05d) {
                if (c2 > f4) {
                    height = (int) (f2 / c2);
                } else {
                    width = (int) (f3 * c2);
                }
            }
            ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.f21528i.getLayoutParams();
            layoutParams.height = height;
            layoutParams.width = width;
            VideoPlayFragment.this.f21528i.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes5.dex */
    public class o implements a.d {
        public o() {
        }

        @Override // d.a.n0.t3.b.a.d
        public void a(boolean z) {
            VideoPlayFragment.this.U.setVisibility(8);
            if (z) {
                VideoPlayFragment.this.V.setText(R.string.reply_something);
            } else {
                VideoPlayFragment.this.V.setText(StringUtils.isNull(((d.a.n0.t3.b.c) VideoPlayFragment.this.t0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
            }
            VideoItemData videoItemData = VideoPlayFragment.this.I;
            if (videoItemData == null || !z) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(videoItemData.comment_num, 0L) + 1;
            VideoPlayFragment.this.I.comment_num = String.valueOf(f2);
            VideoPlayFragment.this.w.setText(StringHelper.numberUniformFormatExtraWithRoundVote(f2));
        }
    }

    /* loaded from: classes5.dex */
    public class p extends d.a.c.a.e {
        public p() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj == null || VideoPlayFragment.this.g0.getLoadDataMode() != 0) {
                return;
            }
            VideoPlayFragment.this.getActivity().finish();
        }
    }

    /* loaded from: classes5.dex */
    public class q implements a.InterfaceC1180a {
        public q() {
        }

        @Override // d.a.m0.h.a.InterfaceC1180a
        public void a(boolean z, boolean z2, String str) {
            if (z) {
                if (VideoPlayFragment.this.h0 != null) {
                    VideoPlayFragment.this.h0.h(z2);
                }
                VideoItemData videoItemData = VideoPlayFragment.this.I;
                if (videoItemData != null) {
                    if (z2) {
                        videoItemData.mark_id = videoItemData.post_id;
                    } else {
                        videoItemData.mark_id = null;
                    }
                }
                if (z2) {
                    VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
                    videoPlayFragment.showToast(videoPlayFragment.getPageContext().getString(R.string.add_mark));
                    return;
                }
                VideoPlayFragment videoPlayFragment2 = VideoPlayFragment.this;
                videoPlayFragment2.showToast(videoPlayFragment2.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPlayFragment videoPlayFragment3 = VideoPlayFragment.this;
            videoPlayFragment3.showToast(videoPlayFragment3.getPageContext().getString(R.string.update_mark_failed));
        }
    }

    /* loaded from: classes5.dex */
    public class r implements l.c {
        public r() {
        }

        @Override // d.a.m0.r.s.l.c
        public void onClick() {
            VideoPlayFragment.this.P1();
        }
    }

    /* loaded from: classes5.dex */
    public class s implements DialogInterface.OnDismissListener {
        public s() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            VideoPlayFragment.this.e0 = null;
            VideoPlayFragment.this.f0 = null;
            if (TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity())) {
                return;
            }
            TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class t implements l.d {
        public t() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            if (!ViewHelper.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                if (VideoPlayFragment.this.e0 != null) {
                    VideoPlayFragment.this.e0.dismiss();
                    return;
                }
                return;
            }
            if (VideoPlayFragment.this.e0 != null) {
                VideoPlayFragment.this.e0.dismiss();
            }
            VideoItemData videoItemData = VideoPlayFragment.this.I;
            if (videoItemData == null) {
                return;
            }
            String str = videoItemData.post_id;
            boolean z = str != null && str.equals(videoItemData.mark_id);
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(VideoPlayFragment.this.I.thread_id);
            markData.setPostId(VideoPlayFragment.this.I.post_id);
            markData.setTime(date.getTime());
            markData.setHostMode(false);
            markData.setId(VideoPlayFragment.this.I.thread_id);
            markData.setForumId(VideoPlayFragment.this.I.forum_id);
            if (VideoPlayFragment.this.h0 != null) {
                VideoPlayFragment.this.h0.i(markData);
                if (!z) {
                    VideoPlayFragment.this.h0.a();
                } else {
                    VideoPlayFragment.this.h0.d();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements l.d {
        public u() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            VideoPlayFragment.this.e0.dismiss();
            if (ViewHelper.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && (videoItemData = (videoPlayFragment = VideoPlayFragment.this).I) != null) {
                String str = videoItemData.thread_id;
                String str2 = videoItemData.forum_id;
                String string = videoPlayFragment.getResources().getString(R.string.web_view_report_title);
                String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.I.post_id;
                VideoItemData videoItemData2 = VideoPlayFragment.this.I;
                if (videoItemData2.isBjhVideo) {
                    str3 = String.format(TbConfig.URL_BJH_REPORT, str, videoItemData2.post_id) + "&channelid=33840";
                    string = "";
                }
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                if (VideoPlayFragment.this.I.isBjhVideo) {
                    tbWebViewActivityConfig.setFixTitle(true);
                }
                VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v extends CustomMessageListener {
        public v(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                if (d.a.c.e.p.j.z() || !VideoPlayFragment.this.b0 || !VideoPlayFragment.this.isPrimary()) {
                    VideoPlayFragment.this.g2();
                } else {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements l.d {

        /* loaded from: classes5.dex */
        public class a implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.r.s.a f21565e;

            public a(d.a.m0.r.s.a aVar) {
                this.f21565e = aVar;
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                this.f21565e.dismiss();
                VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
                if (videoPlayFragment.I != null) {
                    ForumManageModel forumManageModel = videoPlayFragment.g0;
                    VideoPlayFragment videoPlayFragment2 = VideoPlayFragment.this;
                    VideoItemData videoItemData = videoPlayFragment2.I;
                    forumManageModel.R(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.Z, null);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.r.s.a f21567e;

            public b(w wVar, d.a.m0.r.s.a aVar) {
                this.f21567e = aVar;
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                this.f21567e.dismiss();
            }
        }

        public w() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            WorksInfoData worksInfoData;
            VideoPlayFragment.this.e0.dismiss();
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(VideoPlayFragment.this.getActivity());
            VideoItemData videoItemData = VideoPlayFragment.this.I;
            if (videoItemData != null && (worksInfoData = videoItemData.mWorksInfoData) != null && worksInfoData.isWorks) {
                aVar.setMessageId(R.string.del_work_thread_confirm);
            } else {
                aVar.setMessageId(R.string.del_thread_confirm);
            }
            aVar.setPositiveButton(R.string.dialog_ok, new a(aVar));
            aVar.setNegativeButton(R.string.dialog_cancel, new b(this, aVar));
            aVar.setCancelable(true);
            aVar.create(VideoPlayFragment.this.getPageContext());
            aVar.show();
        }
    }

    /* loaded from: classes5.dex */
    public class x implements ExpandableTextView.e {
        public x() {
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            VideoPlayFragment.this.I.isTitleExpanded = z;
        }
    }

    /* loaded from: classes5.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoPlayFragment.this.o0) {
                return;
            }
            VideoPlayFragment.this.A1(true);
        }
    }

    /* loaded from: classes5.dex */
    public class z implements Animator.AnimatorListener {
        public z() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
            View view = videoPlayFragment.f21526g;
            if (view instanceof RelativeLayout) {
                ((RelativeLayout) view).removeView(videoPlayFragment.p0);
            }
            VideoPlayFragment.this.l0 = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static /* synthetic */ int q1(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.r0;
        videoPlayFragment.r0 = i2 + 1;
        return i2;
    }

    public final void A1(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.L;
        if (videoMiddleNiaiControllerView != null) {
            videoMiddleNiaiControllerView.setBottomBarShow(z2, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.d0) ? 1 : 0);
        }
    }

    public final void B1() {
        if (this.t == null || this.s == null) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(300L);
        this.s.clearAnimation();
        this.t.clearAnimation();
        this.s.setVisibility(8);
        this.t.setVisibility(0);
        this.t.startAnimation(scaleAnimation2);
        this.s.startAnimation(scaleAnimation);
    }

    public final void C1() {
        String str;
        VideoItemData videoItemData = this.I;
        if (videoItemData == null) {
            return;
        }
        this.f21528i.U(videoItemData.thumbnail_url, 10, false);
        if (!StringUtils.isNull(this.I.title)) {
            str = this.I.title;
        } else {
            str = !StringUtils.isNull(this.I.abstext) ? this.I.abstext : "";
        }
        if (StringUtils.isNull(str)) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
            this.v.setTextSize(d.a.c.e.p.l.g(getContext(), R.dimen.T_X07));
            this.v.setTextColor(R.color.CAM_X0621);
            this.v.setLineSpacingExtra(d.a.c.e.p.l.g(getContext(), R.dimen.tbds10));
            this.v.setExpandable(false);
            this.v.setTextMaxLine(3);
            this.v.setLimitLine(3);
            this.v.setOnStatusChangedListener(new x());
            ExpandableTextView expandableTextView = this.v;
            VideoItemData videoItemData2 = this.I;
            expandableTextView.setData(str, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
        }
        this.w.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.c.e.m.b.f(this.I.comment_num, 0L)));
        this.x.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.c.e.m.b.f(this.I.agree_num, 0L)));
        this.y.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.c.e.m.b.f(this.I.share_num, 0L)));
        UserItemData userItemData = this.I.author_info;
        if (userItemData != null) {
            if (!TextUtils.isEmpty(userItemData.bjhAvatar)) {
                this.m.U(this.I.author_info.bjhAvatar, 12, false);
            } else if (!StringUtils.isNull(this.I.author_info.portrait) && this.I.author_info.portrait.startsWith("http")) {
                this.m.U(this.I.author_info.portrait, 10, false);
            } else {
                this.m.U(this.I.author_info.portrait, 12, false);
            }
            if (StringUtils.isNull(this.I.author_info.a())) {
                this.T.setVisibility(8);
            } else {
                this.T.setVisibility(0);
                this.T.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.I.author_info.a(), 16, StringHelper.STRING_MORE));
            }
        }
        if ("1".equals(this.I.is_private) && this.K.getVisibility() != 0) {
            this.H.setVisibility(0);
        } else {
            this.H.setVisibility(8);
        }
        if ("1".equals(this.I.is_agreed)) {
            this.Q.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.Q.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        ActivityItemData activityItemData = this.I.act_info;
        if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.K.getVisibility() != 0) {
            this.G.setVisibility(0);
            this.D.setText(this.I.act_info.activity_name);
        } else {
            this.G.setVisibility(8);
        }
        z1();
        if (this.I.isBjhVideo) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
    }

    public final boolean D1(TbPageContext<?> tbPageContext, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return true;
    }

    public final void E1() {
        if (this.f21526g == null || this.l0) {
            return;
        }
        this.l0 = true;
        this.p0 = new TBLottieAnimationView(this.f21526g.getContext());
        if (this.m0 == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396), TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396));
            this.m0 = layoutParams;
            layoutParams.addRule(13);
        }
        SkinManager.setLottieAnimation(this.p0, R.raw.lottie_agree_big_photo);
        View view = this.f21526g;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).addView(this.p0, this.m0);
        }
        this.p0.addAnimatorListener(new z());
        this.p0.playAnimation();
    }

    public final void F1(int i2) {
        VideoItemData videoItemData;
        if (!ViewHelper.checkUpIsLogin(getActivity()) || (videoItemData = this.I) == null) {
            return;
        }
        int i3 = 0;
        if (i2 == this.f21524e) {
            if ("1".equals(videoItemData.is_agreed)) {
                VideoItemData videoItemData2 = this.I;
                videoItemData2.agree_num = String.valueOf(d.a.c.e.m.b.d(videoItemData2.agree_num, 0) - 1);
                this.I.is_agreed = "0";
                i3 = 1;
            } else {
                VideoItemData videoItemData3 = this.I;
                videoItemData3.agree_num = String.valueOf(d.a.c.e.m.b.d(videoItemData3.agree_num, 0) + 1);
                this.I.is_agreed = "1";
                E1();
                I1(1);
            }
        } else {
            videoItemData.agree_num = String.valueOf(d.a.c.e.m.b.d(videoItemData.agree_num, 0) + 1);
            this.I.is_agreed = "1";
            I1(1);
        }
        StatisticItem statisticItem = new StatisticItem("c12795");
        statisticItem.param("tid", this.I.thread_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (i2 == this.f21524e) {
            statisticItem.param("obj_type", i3);
        } else {
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
        StatisticItem statisticItem2 = new StatisticItem("c12003");
        statisticItem2.param("tid", this.I.thread_id);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (i2 == this.f21524e) {
            statisticItem2.param("obj_type", i3);
        } else {
            statisticItem2.param("obj_type", 2);
        }
        if ("index".equals(this.d0)) {
            statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
            statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
        }
        d.a.m0.i0.c k2 = TbPageExtraHelper.k(getContext());
        if (k2 != null) {
            statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
            StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_AGREE_SUCCESS_CLICK);
            if (i2 == this.f21524e) {
                statisticItem3.param("obj_type", i3);
            } else {
                statisticItem3.param("obj_type", 2);
            }
            if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.d0)) {
                statisticItem3.param("obj_locate", 1);
                statisticItem3.param("obj_source", L1());
            } else {
                statisticItem3.param("obj_locate", 2);
            }
            statisticItem3.param("tid", this.I.thread_id);
            statisticItem3.param("fid", this.I.forum_id);
            TiebaStatic.log(statisticItem3);
        }
        if (TbPageExtraHelper.m() != null) {
            statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
        }
        TiebaStatic.log(statisticItem2);
        C1();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        httpMessage.addParam("thread_id", this.I.thread_id);
        httpMessage.addParam("op_type", i3);
        httpMessage.addParam("obj_type", 3);
        httpMessage.addParam("agree_type", 2);
        httpMessage.addHeader("needSig", "1");
        BaijiahaoData baijiahaoData = this.I.baijiahaoData;
        if (baijiahaoData != null) {
            httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
            httpMessage.addParam("ori_ugc_nid", this.I.baijiahaoData.oriUgcNid);
            httpMessage.addParam("ori_ugc_vid", this.I.baijiahaoData.oriUgcVid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, this.I.baijiahaoData.oriUgcType);
        }
        if (k2 != null) {
            httpMessage.addParam("obj_source", k2.a());
        }
        sendMessage(httpMessage);
        d.a.n0.e3.h0.e eVar = new d.a.n0.e3.h0.e();
        AgreeData agreeData = new AgreeData();
        String str = this.I.thread_id;
        if (str != null) {
            agreeData.threadId = str;
        }
        agreeData.agreeNum = Long.valueOf(this.I.agree_num).longValue();
        agreeData.agreeType = 2;
        agreeData.hasAgree = "1".equals(this.I.is_agreed);
        eVar.f57686b = agreeData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.I));
    }

    public final void G1(boolean z2) {
        if (z2) {
            this.o.setVisibility(8);
            this.E.setVisibility(8);
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            this.n.setVisibility(8);
            this.r.setVisibility(0);
            return;
        }
        this.o.setVisibility(0);
        this.E.setVisibility(0);
        this.p.setVisibility(0);
        this.q.setVisibility(0);
        this.n.setVisibility(0);
        this.r.setVisibility(8);
    }

    public final void H1() {
        if (this.I == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.I.thread_id);
        statisticItem.param("nid", this.I.nid);
        statisticItem.param("fid", this.I.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.a0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("obj_param1", d.a.c.e.p.k.isEmpty(this.I.mRecomWeight) ? "0" : this.I.mRecomWeight);
        statisticItem.param("extra", d.a.c.e.p.k.isEmpty(this.I.mRecomExtra) ? "0" : this.I.mRecomExtra);
        statisticItem.param("obj_id", this.n0);
        statisticItem.param("ab_tag", d.a.c.e.p.k.isEmpty(this.I.mRecomAbTag) ? "0" : this.I.mRecomAbTag);
        statisticItem.param("obj_source", d.a.c.e.p.k.isEmpty(this.I.mRecomSource) ? "0" : this.I.mRecomSource);
        statisticItem.param("obj_type", this.d0);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 1);
        BaijiahaoData baijiahaoData = this.I.baijiahaoData;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.I.baijiahaoData.oriUgcVid);
            int i2 = this.I.baijiahaoData.oriUgcType;
            if (i2 == 4) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (i2 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
        } else {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
        }
        if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.d0)) {
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.I.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", this.d0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a088");
            statisticItem2.param("page_type", "a088");
            TiebaStatic.log(statisticItem2);
        }
        TiebaStatic.log(statisticItem);
    }

    public void I1(int i2) {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_CLICK);
        statisticItem.param("tid", this.I.thread_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.d0)) {
            statisticItem.param("obj_locate", 1);
        } else {
            statisticItem.param("obj_locate", 2);
        }
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
    }

    public String J1() {
        return null;
    }

    public List<String> K1() {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        if (r0.equals("index") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int L1() {
        char c2 = 0;
        if (TextUtils.isEmpty(this.d0)) {
            return 0;
        }
        String str = this.d0;
        int hashCode = str.hashCode();
        if (hashCode == 101671) {
            if (str.equals("frs")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 100346066) {
            if (hashCode == 157161846 && str.equals("concern_tab")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                return c2 != 2 ? 7 : 4;
            }
            return 2;
        }
        return 1;
    }

    public final void M1() {
        if (this.I == null) {
            return;
        }
        PbActivityConfig pbActivityConfig = new PbActivityConfig(getActivity());
        VideoItemData videoItemData = this.I;
        PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(videoItemData.thread_id, videoItemData.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.I.forum_id));
        createNormalCfg.setForumName(this.I.forum_name);
        createNormalCfg.setVideo_source(VideoPlayActivity.FROM_VIDEO_PLAY);
        createNormalCfg.setJumpToCommentArea(false);
        createNormalCfg.setBjhData(this.I.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void N1(int i2, int i3, Intent intent) {
        d.a.n0.t3.b.a aVar = this.t0;
        if (aVar != null) {
            aVar.n(i2, i3, intent);
        }
        if (intent == null || i2 != 24007) {
            return;
        }
        int intExtra = intent.getIntExtra("extra_share_status", 2);
        int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
        if (intExtra == 1) {
            d.a.n0.s2.a.g().m(getPageContext());
            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
            if (shareItem != null) {
                statisticItem.param("tid", shareItem.K);
                statisticItem.param("uid", shareItem.N);
                statisticItem.param("fid", shareItem.J);
                statisticItem.param("obj_type", intExtra2);
                statisticItem.param("obj_locate", shareItem.I);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // d.a.m0.b1.p.a.b
    public void O(float f2, float f3) {
        if (ViewHelper.checkUpIsLogin(getActivity())) {
            E1();
            VideoItemData videoItemData = this.I;
            if (videoItemData == null || !"0".equals(videoItemData.is_agreed)) {
                return;
            }
            F1(this.f21525f);
        }
    }

    public boolean O1() {
        d.a.n0.t3.b.a aVar = this.t0;
        if (aVar == null || aVar.a() == null || !this.t0.a().v()) {
            return false;
        }
        this.t0.a().o();
        this.U.setVisibility(8);
        if (!(this.t0.a().n(28) instanceof d.a.n0.t3.b.c) || ((d.a.n0.t3.b.c) this.t0.a().n(28)).g() == null || ((d.a.n0.t3.b.c) this.t0.a().n(28)).g().getText() == null) {
            return true;
        }
        this.V.setText(StringUtils.isNull(((d.a.n0.t3.b.c) this.t0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        return true;
    }

    public void P1() {
        d.a.m0.r.s.j jVar = this.e0;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.e0.dismiss();
    }

    @Override // d.a.n0.t3.c.a.a
    public void Q(int i2) {
        this.s0 = i2;
    }

    public final void Q1() {
        d.a.n0.t3.b.a aVar = (d.a.n0.t3.b.a) new d.a.n0.t3.b.b().a(getActivity());
        this.t0 = aVar;
        if (aVar == null || this.I == null) {
            return;
        }
        aVar.s(getPageContext());
        d.a.n0.t3.b.a aVar2 = this.t0;
        VideoItemData videoItemData = this.I;
        aVar2.t(videoItemData.thread_id, videoItemData.forum_id, videoItemData.forum_name);
        this.t0.u(new o());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        ((RelativeLayout) this.f21526g).addView(this.t0.a(), layoutParams);
    }

    public final void R1() {
        TbCyberVideoView tbCyberVideoView = this.f21527h;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.pause();
        }
    }

    public final void S1(int i2) {
        if (this.I == null || this.P != null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12794");
        statisticItem.param("tid", this.I.thread_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
        StatisticItem statisticItem2 = new StatisticItem("common_exp");
        statisticItem2.param("tid", this.I.thread_id);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem2.param("obj_type", i2);
        statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
        statisticItem2.param("page_type", "a023");
        statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, 1);
        TiebaStatic.log(statisticItem2);
    }

    public final void T1() {
        if (this.I != null) {
            d.a.n0.k2.o oVar = new d.a.n0.k2.o();
            oVar.f60587a = VideoPlayActivity.FROM_VIDEO_PLAY;
            VideoItemData videoItemData = this.I;
            oVar.f60589c = videoItemData.thread_id;
            oVar.t = videoItemData.nid;
            oVar.f60590d = this.I.forum_id + "";
            oVar.f60591e = TbadkCoreApplication.getCurrentAccount();
            VideoItemData videoItemData2 = this.I;
            oVar.f60592f = videoItemData2.mRecomSource;
            oVar.f60593g = videoItemData2.mRecomAbTag;
            oVar.f60594h = videoItemData2.mRecomWeight;
            oVar.f60595i = "";
            oVar.k = "";
            oVar.m = videoItemData2.mMd5;
            if (this.P != null) {
                oVar.n = "1";
            } else {
                oVar.n = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.c0)) {
                oVar.p = "1";
                oVar.f60587a = "auto_midpage";
                oVar.f60595i = "index";
            }
            d.a.n0.k2.h.e(this.I.mMd5, "", "1", oVar, this.f21527h.getPcdnState());
        }
    }

    public final void U1() {
        ImageView imageView;
        if (this.t == null || (imageView = this.s) == null) {
            return;
        }
        imageView.clearAnimation();
        this.t.clearAnimation();
        this.s.setVisibility(0);
        this.t.setVisibility(8);
    }

    public final void V1() {
        if (g2()) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f21527h;
        if (tbCyberVideoView != null && this.u != null && this.I != null) {
            if (tbCyberVideoView.getParent() == null) {
                Z1();
                a2();
            }
            if (TbVideoViewSet.d().e(this.k0) == null || TbVideoViewSet.d().e(this.k0) != this.f21527h) {
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.L;
                if (videoMiddleNiaiControllerView != null) {
                    videoMiddleNiaiControllerView.q();
                }
                this.f21527h.setVideoPath(this.k0, this.I.thread_id);
            }
            TbImageView tbImageView = this.f21528i;
            if (tbImageView != null && tbImageView.getVisibility() == 0) {
                this.f21528i.setVisibility(8);
            }
            this.f21527h.R(null);
            this.L.s();
            this.u.setVisibility(8);
            e2();
            k0 k0Var = this.v0;
            if (k0Var != null) {
                k0Var.onStart();
            }
        }
        if (this.b0 || isPrimary()) {
            return;
        }
        R1();
    }

    public void W1(boolean z2) {
        this.b0 = z2;
        setPrimary(z2);
    }

    public final void X1() {
        if (this.C == null) {
            return;
        }
        Drawable drawable = getPageContext().getResources().getDrawable(R.drawable.icon_pure_followed);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds29), UtilHelper.getDimenPixelSize(R.dimen.tbds18));
        this.C.setCompoundDrawables(drawable, null, null, null);
    }

    public void Y1(f.c cVar) {
        this.u0 = cVar;
    }

    public void Z1() {
        TbCyberVideoView tbCyberVideoView;
        TbCyberVideoView tbCyberVideoView2 = this.f21527h;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.getParent() != null) {
            return;
        }
        VideoItemData videoItemData = this.I;
        if (videoItemData != null) {
            int d2 = d.a.c.e.m.b.d(videoItemData.video_height, 0);
            int d3 = d.a.c.e.m.b.d(this.I.video_width, 0);
            float f2 = 0.0f;
            if (d2 != 0 && d3 != 0) {
                f2 = (d2 * 1.0f) / d3;
            }
            if (f2 > 1.0f) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                this.W = layoutParams;
                layoutParams.addRule(13);
            } else {
                d.a.c.e.p.l.i(this.f21526g.getContext());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) (f2 * d.a.c.e.p.l.k(this.f21526g.getContext())));
                this.W = layoutParams2;
                layoutParams2.addRule(13);
                this.f21528i.setLayoutParams(this.W);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
                layoutParams3.removeRule(13);
                layoutParams3.addRule(13);
                this.u.requestLayout();
            }
            if (this.f21526g != null && (tbCyberVideoView = this.f21527h) != null && tbCyberVideoView.getView() != null) {
                ((ViewGroup) this.f21526g).addView(this.f21527h.getView(), 0, this.W);
            }
        }
        if (this.I != null) {
            d.a.n0.k2.o oVar = new d.a.n0.k2.o();
            oVar.f60591e = TbadkCoreApplication.getCurrentAccount();
            VideoItemData videoItemData2 = this.I;
            oVar.f60589c = videoItemData2.thread_id;
            oVar.t = videoItemData2.nid;
            oVar.f60590d = videoItemData2.forum_id;
            oVar.m = videoItemData2.mMd5;
            oVar.k = "";
            oVar.f60592f = videoItemData2.mRecomSource;
            oVar.l = videoItemData2.mRecomAbTag;
            oVar.j = 1;
            BaijiahaoData baijiahaoData = videoItemData2.baijiahaoData;
            if (baijiahaoData != null) {
                int i2 = baijiahaoData.oriUgcType;
                if (i2 == 2) {
                    oVar.j = 3;
                } else if (i2 == 4) {
                    oVar.j = 2;
                }
            }
            oVar.f60594h = this.I.mRecomWeight;
            if (this.P != null) {
                oVar.n = "1";
            } else {
                oVar.n = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.c0)) {
                oVar.p = "1";
                oVar.f60587a = "13";
                oVar.f60595i = this.d0;
                oVar.k = this.n0;
                oVar.f60593g = this.I.mRecomWeight;
            } else {
                oVar.f60587a = "14";
            }
            if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.d0)) {
                oVar.p = "1";
                oVar.f60587a = Constants.VIA_REPORT_TYPE_QQFAVORITES;
                oVar.f60595i = this.d0;
                oVar.k = this.n0;
                oVar.f60593g = this.I.mRecomWeight;
            }
            this.f21527h.setVideoStatData(oVar);
            this.f21527h.setLocateSource("v_mid_page");
        }
        this.f21527h.setContinuePlayEnable(true);
    }

    @Override // d.a.n0.t3.c.a.a
    public VideoItemModel a0() {
        return this.J;
    }

    public final void a2() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f21527h.setOnPreparedListener(this.F0);
        }
        this.f21527h.setOnCompletionListener(this.E0);
        this.f21527h.setOnInfoListener(this.D0);
    }

    public final void b2(String str) {
        if (this.f21527h == null || str == null || str.equals(this.k0)) {
            return;
        }
        this.f21527h.setVideoPath(str, this.I.thread_id);
        this.k0 = str;
    }

    public void c2(k0 k0Var) {
        this.v0 = k0Var;
    }

    public void d2() {
        if (this.e0 == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.e0.l();
    }

    public final void e2() {
        if (d.a.c.e.p.j.x()) {
            d.a.n0.r3.f.d().g(getContext());
        }
    }

    public final void f2() {
        String str;
        if (this.e0 == null) {
            this.f0 = new d.a.m0.r.s.l(getActivity());
            this.e0 = new d.a.m0.r.s.j(getPageContext(), this.f0);
            ArrayList arrayList = new ArrayList();
            d.a.m0.r.s.h hVar = new d.a.m0.r.s.h(getActivity().getString(R.string.mark), this.f0);
            boolean z2 = false;
            VideoItemData videoItemData = this.I;
            if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                z2 = true;
            }
            if (z2) {
                hVar.n(getResources().getString(R.string.remove_mark));
            } else {
                hVar.n(getResources().getString(R.string.mark));
            }
            hVar.m(this.z0);
            VideoItemData videoItemData2 = this.I;
            if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                arrayList.add(hVar);
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ADD_COLLECTION_CLICK);
                statisticItem.param("tid", this.I.thread_id);
                statisticItem.param("fid", this.I.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.d0)) {
                    statisticItem.param("obj_type", 1);
                } else {
                    statisticItem.param("obj_type", 2);
                }
                statisticItem.param("obj_source", L1());
                TiebaStatic.log(statisticItem);
            }
            d.a.m0.r.s.h hVar2 = new d.a.m0.r.s.h(getActivity().getString(R.string.report_text), this.f0);
            hVar2.m(this.A0);
            arrayList.add(hVar2);
            d.a.m0.r.s.h hVar3 = new d.a.m0.r.s.h(getActivity().getString(R.string.delete), this.f0);
            hVar3.m(this.B0);
            if (this.Z) {
                arrayList.add(hVar3);
            }
            this.f0.m(new r());
            this.e0.setOnDismissListener(new s());
            this.f0.k(arrayList);
        }
        d2();
    }

    public final boolean g2() {
        if (d.a.n0.r3.f.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || (!VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.d0) && TbSingleton.getInstance().isTipsAutoPlayInVideoMiddle())) {
            return false;
        }
        if ((!VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.d0) || !TbSingleton.getInstance().isTipsAutoPlayInVideoChannel()) && d.a.c.e.p.j.x() && this.b0 && isPrimary()) {
            d.a.c.e.p.l.N(TbadkCoreApplication.getInst(), getResources().getString(R.string.video_no_wifi_tips), 3000);
            if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.d0)) {
                TbSingleton.getInstance().setTipsAutoPlayInVideoChannel(true);
            } else {
                TbSingleton.getInstance().setTipsAutoPlayInVideoMiddle(true);
            }
        }
        return false;
    }

    public final void h2() {
        String str;
        String str2;
        String format;
        VideoItemData videoItemData;
        UserItemData userItemData;
        VideoItemData videoItemData2 = this.I;
        if (videoItemData2 == null) {
            return;
        }
        String str3 = videoItemData2.forum_id;
        String str4 = videoItemData2.forum_name;
        String str5 = videoItemData2.title;
        BaijiahaoData baijiahaoData = videoItemData2.baijiahaoData;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.I.baijiahaoData.oriUgcType + "&dvid=" + this.I.baijiahaoData.oriUgcVid + "&nid=" + this.I.baijiahaoData.oriUgcNid;
        } else {
            str = videoItemData2.thread_id;
            str2 = "?share=9105&fr=share";
        }
        String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
        String str7 = this.I.thumbnail_url;
        String string = getResources().getString(R.string.share_content_tpl);
        String string2 = getResources().getString(R.string.default_share_content_tpl);
        VideoItemData videoItemData3 = this.I;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
        } else {
            format = MessageFormat.format(string, str5, "");
        }
        Uri parse = str7 == null ? null : Uri.parse(str7);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str5;
        shareItem.s = format;
        if (this.I.baijiahaoData == null) {
            shareItem.R = videoItemData.play_count;
        }
        if (this.I.isBjhVideo) {
            shareItem.D = format;
        } else {
            shareItem.D = "";
        }
        shareItem.t = str6;
        shareItem.o = 2;
        shareItem.q = str;
        shareItem.F = 3;
        shareItem.J = str3;
        shareItem.p = str4;
        shareItem.K = str;
        shareItem.f12662f = true;
        if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.d0)) {
            shareItem.E = 25;
            shareItem.I = 19;
        } else {
            shareItem.E = 12;
            shareItem.I = 18;
        }
        if (this.I.getVideoType() == 1) {
            shareItem.M = 2;
        } else if (this.I.getVideoType() == 2) {
            shareItem.M = 8;
        } else if (this.I.getVideoType() == 3) {
            shareItem.M = 6;
        }
        if (parse != null) {
            shareItem.v = parse;
        }
        if (this.I.isBjhVideo) {
            shareItem.f0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        VideoItemData videoItemData4 = this.I;
        originalThreadInfo.f12097c = videoItemData4.thumbnail_url;
        originalThreadInfo.f12095a = 3;
        originalThreadInfo.f12096b = videoItemData4.title;
        originalThreadInfo.f12100f = videoItemData4.thread_id;
        originalThreadInfo.p = videoItemData4.baijiahaoData;
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.k(bundle);
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        d.a.n0.d0.f.b().k(shareDialogConfig);
    }

    @Override // d.a.m0.b1.p.a.b
    public void k() {
        UserItemData userItemData;
        VideoItemData videoItemData = this.I;
        if (videoItemData == null || (userItemData = videoItemData.author_info) == null) {
            return;
        }
        long f2 = d.a.c.e.m.b.f(userItemData.user_id, 0L);
        long f3 = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        boolean z2 = f2 == f3;
        if (f2 == 0 && f3 == 0) {
            z2 = false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(f2, z2, false)));
    }

    @Override // d.a.m0.b1.p.a.b
    public void m() {
        if (this.f21527h.isPlaying()) {
            this.f21527h.pause();
            this.u.setVisibility(0);
            A1(false);
            d.a.c.e.m.e.a().removeCallbacks(this.C0);
            I1(4);
        } else if (g2()) {
        } else {
            this.f21527h.start();
            this.u.setVisibility(8);
            A1(true);
            this.L.s();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.Z) {
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.g0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(new p());
        }
        d.a.m0.h.a c2 = d.a.m0.h.a.c(getBaseFragmentActivity());
        this.h0 = c2;
        if (c2 != null) {
            c2.j(new q());
        }
        this.i0 = new d.a.m0.s.e.a(null);
        registerListener(this.w0);
        registerListener(this.x0);
        if (Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode()) {
            return;
        }
        this.q0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        N1(i2, i3, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.t3.b.a aVar = this.t0;
        if (aVar != null && aVar.a() != null) {
            this.t0.a().w(i2);
        }
        d.a.m0.r.s.l lVar = this.f0;
        if (lVar != null) {
            lVar.j();
        }
        if (this.f21526g != null) {
            this.R.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_reply36, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.S.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_share36, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.t.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_share_wechat120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.u.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
            y1();
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.U);
            d2.m(R.string.J_X01);
            d2.f(R.color.CAM_X0614);
            d.a.m0.r.u.c d3 = d.a.m0.r.u.c.d(this.z);
            d3.x(R.string.F_X02);
            d3.s(R.color.CAM_X0101);
            d.a.m0.r.u.c.d(this.A).x(R.string.F_X02);
            d.a.m0.r.u.c d4 = d.a.m0.r.u.c.d(this.y);
            d4.w(R.dimen.T_X09);
            d4.x(R.string.F_X02);
            d4.v(R.array.S_O_X001);
            d.a.m0.r.u.c d5 = d.a.m0.r.u.c.d(this.x);
            d5.w(R.dimen.T_X09);
            d5.x(R.string.F_X02);
            d5.v(R.array.S_O_X001);
            d.a.m0.r.u.c d6 = d.a.m0.r.u.c.d(this.w);
            d6.w(R.dimen.T_X09);
            d6.x(R.string.F_X02);
            d6.v(R.array.S_O_X001);
            d.a.m0.r.u.c d7 = d.a.m0.r.u.c.d(this.T);
            d7.w(R.dimen.T_X06);
            d7.x(R.string.F_X02);
            d7.v(R.array.S_O_X001);
            d.a.m0.r.u.c d8 = d.a.m0.r.u.c.d(this.B);
            d8.m(R.string.J_X01);
            d8.w(R.dimen.T_X09);
            d8.s(R.color.CAM_X0101);
            d8.x(R.string.F_X02);
            d8.f(R.color.CAM_X0302);
            d.a.m0.r.u.c d9 = d.a.m0.r.u.c.d(this.C);
            d9.m(R.string.J_X01);
            d9.w(R.dimen.T_X09);
            d9.f(R.color.CAM_X0302);
            this.A.setTextColor(d.a.n0.e3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.m0.r.u.a.a(R.string.A_X08)));
            this.x.setTextColor(d.a.n0.e3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.m0.r.u.a.a(R.string.A_X03)));
            this.y.setTextColor(d.a.n0.e3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.m0.r.u.a.a(R.string.A_X03)));
            this.w.setTextColor(d.a.n0.e3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.m0.r.u.a.a(R.string.A_X03)));
        }
        WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.y0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        VideoItemModel videoItemModel = (VideoItemModel) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.J = videoItemModel;
        this.I = videoItemModel == null ? null : videoItemModel.getVideoItemData();
        this.P = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.a0 = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.c0 = arguments.getString("page_from");
        this.d0 = arguments.getString("from");
        this.n0 = arguments.getString("obj_id");
        VideoItemData videoItemData = this.I;
        if (videoItemData != null && videoItemData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.I.author_info.user_id)) {
            this.Z = true;
        }
        this.f21526g = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.f21526g.setOnTouchListener(new f0(new GestureDetectorCompat(getContext(), new e0())));
        this.f21526g.setOnLongClickListener(new g0());
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
        this.f21527h = tbCyberVideoView;
        tbCyberVideoView.setStageType("2005");
        this.f21527h.getMediaProgressObserver().j(new h0());
        TbImageView tbImageView = (TbImageView) this.f21526g.findViewById(R.id.video_cover);
        this.f21528i = tbImageView;
        tbImageView.setPlaceHolder(4);
        this.f21528i.setDefaultBgResource(R.color.CAM_X0214);
        this.u = (ImageView) this.f21526g.findViewById(R.id.play_btn);
        Z1();
        if (DeviceInfoUtil.isHWnova() || (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity()))) {
            this.j = this.f21526g.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.j.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.k = (ImageView) this.f21526g.findViewById(R.id.back_btn);
        if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.d0)) {
            this.k.setVisibility(8);
        }
        this.l = (ImageView) this.f21526g.findViewById(R.id.more_btn);
        HeadImageView headImageView = (HeadImageView) this.f21526g.findViewById(R.id.author_portrait);
        this.m = headImageView;
        headImageView.setDefaultResource(17170445);
        this.m.setPlaceHolder(2);
        this.m.setIsRound(true);
        this.m.setBorderWidth(R.dimen.L_X02);
        this.m.setBorderColor(R.color.CAM_X0622);
        this.m.setDrawBorder(true);
        this.E = (RelativeLayout) this.f21526g.findViewById(R.id.author_info_container);
        this.n = (LinearLayout) this.f21526g.findViewById(R.id.bottom_container);
        this.B = (EMTextView) this.f21526g.findViewById(R.id.love_btn);
        this.C = (EMTextView) this.f21526g.findViewById(R.id.has_love);
        X1();
        this.Q = (ImageView) this.f21526g.findViewById(R.id.agree_img);
        this.v = (ExpandableTextView) this.f21526g.findViewById(R.id.video_title);
        this.L = (VideoMiddleNiaiControllerView) this.f21526g.findViewById(R.id.media_controller);
        this.D = (TextView) this.f21526g.findViewById(R.id.video_activity);
        this.p = (LinearLayout) this.f21526g.findViewById(R.id.comment_container);
        this.w = (EMTextView) this.f21526g.findViewById(R.id.comment_num);
        this.R = (ImageView) this.f21526g.findViewById(R.id.comment_img);
        this.o = (LinearLayout) this.f21526g.findViewById(R.id.agree_container);
        this.r = (LinearLayout) this.f21526g.findViewById(R.id.ll_drag_container);
        this.q = (LinearLayout) this.f21526g.findViewById(R.id.share_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
        if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.d0)) {
            this.L.t(1);
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds109);
            layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
            layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
        } else {
            this.L.t(0);
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds211);
            layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds123);
            layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds126);
        }
        this.x = (EMTextView) this.f21526g.findViewById(R.id.agree_num);
        this.S = (ImageView) this.f21526g.findViewById(R.id.share_img);
        this.y = (EMTextView) this.f21526g.findViewById(R.id.share_num);
        this.z = (EMTextView) this.f21526g.findViewById(R.id.drag_cur_time);
        this.A = (EMTextView) this.f21526g.findViewById(R.id.drag_total_time);
        this.s = (ImageView) this.f21526g.findViewById(R.id.share_img);
        this.t = (ImageView) this.f21526g.findViewById(R.id.share_img_changed);
        U1();
        this.F = (LinearLayout) this.f21526g.findViewById(R.id.video_act_private_container);
        this.G = (LinearLayout) this.f21526g.findViewById(R.id.video_activity_container);
        this.H = (LinearLayout) this.f21526g.findViewById(R.id.video_private);
        this.T = (TextView) this.f21526g.findViewById(R.id.video_author_name);
        View findViewById = this.f21526g.findViewById(R.id.quick_reply_comment_layout);
        this.U = findViewById;
        findViewById.setOnClickListener(new i0());
        VideoItemData videoItemData2 = this.I;
        if (videoItemData2 != null) {
            if (videoItemData2.video_duration > 15) {
                this.L.setVisibility(0);
            } else {
                this.L.setVisibility(8);
            }
        }
        this.L.setPlayer(this.f21527h);
        this.L.setOnSeekBarChangeListener(new j0());
        this.V = (TextView) this.f21526g.findViewById(R.id.quick_reply_comment_text);
        TextView textView = (TextView) this.f21526g.findViewById(R.id.download_nani_guide_txt);
        this.K = textView;
        textView.setVisibility(8);
        String p2 = d.a.m0.r.d0.b.j().p("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(p2)) {
            this.K.setText(p2);
        }
        this.K.setOnClickListener(new a(d.a.m0.r.d0.b.j().p("nani_key_download_link_url", null)));
        C1();
        b bVar = new b();
        this.m.setOnClickListener(bVar);
        this.T.setOnClickListener(bVar);
        this.G.setOnClickListener(new c());
        this.v.setHasDown();
        this.v.setOnClickListener(new d());
        this.k.setOnClickListener(new e());
        this.l.setOnClickListener(new f());
        this.p.setOnClickListener(new g());
        this.o.setOnClickListener(new h());
        this.q.setOnClickListener(new i());
        this.B.setOnClickListener(new j());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.O = alphaAnimation;
        alphaAnimation.setDuration(100L);
        this.O.setAnimationListener(new l());
        Rect rect = this.P;
        if (rect != null) {
            this.X = rect.right - rect.left;
            this.Y = rect.bottom - rect.top;
            this.f21528i.post(new m());
        } else {
            this.f21528i.post(new n());
        }
        Q1();
        if (this.M) {
            H1();
        }
        VideoItemData videoItemData3 = this.I;
        if (videoItemData3 != null && !StringUtils.isNull(videoItemData3.video_url)) {
            b2(this.I.video_url);
        }
        return this.f21526g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.y0);
        d.a.n0.t3.b.a aVar = this.t0;
        if (aVar != null) {
            aVar.o();
        }
        if (this.C0 != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.C0);
            this.C0 = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        R1();
        d.a.n0.t3.b.a aVar = this.t0;
        if (aVar == null || aVar.a() == null) {
            return;
        }
        this.t0.a().o();
        this.U.setVisibility(8);
        this.V.setText(StringUtils.isNull(((d.a.n0.t3.b.c) this.t0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.b0 && isPrimary()) {
            if (!TbSingleton.getInstance().isNotchScreen(getActivity())) {
                TbSingleton.getInstance().isCutoutScreen(getActivity());
            }
            VideoItemData videoItemData = this.I;
            if (videoItemData == null || StringUtils.isNull(videoItemData.video_url)) {
                return;
            }
            this.N = true;
            if (this.M) {
                T1();
                V1();
                S1(0);
                return;
            }
            R1();
            return;
        }
        R1();
        d.a.n0.t3.b.a aVar = this.t0;
        if (aVar == null || aVar.a() == null) {
            return;
        }
        this.t0.a().o();
        this.U.setVisibility(8);
        this.V.setText(StringUtils.isNull(((d.a.n0.t3.b.c) this.t0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        R1();
        d.a.n0.t3.b.a aVar = this.t0;
        if (aVar == null || aVar.a() == null) {
            return;
        }
        this.t0.a().o();
        this.U.setVisibility(8);
        this.V.setText(StringUtils.isNull(((d.a.n0.t3.b.c) this.t0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        C1();
        a2();
    }

    @Override // d.a.n0.t3.c.a.a
    public int q() {
        return this.s0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        this.M = z2;
        if (!z2 && this.t0 != null) {
            this.V.setText(R.string.reply_something);
            this.t0.l();
        }
        if (this.N) {
            if (this.M && (!this.q0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                S1(1);
                startPlay();
                H1();
                this.q0 = false;
                return;
            }
            U1();
            this.r0 = 1;
            R1();
        }
    }

    public final void startPlay() {
        if (g2()) {
            return;
        }
        e2();
        ImageView imageView = this.u;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT < 17 && this.f21528i.getVisibility() == 0) {
            this.f21528i.clearAnimation();
            this.f21528i.startAnimation(this.O);
        }
        if (this.f21527h != null) {
            if (TbVideoViewSet.d().e(this.k0) == null || TbVideoViewSet.d().e(this.k0) != this.f21527h) {
                this.f21527h.setVideoPath(this.k0, this.I.thread_id);
            }
            this.f21527h.start();
            this.L.s();
            T1();
        }
        if (this.b0 || isPrimary()) {
            return;
        }
        R1();
    }

    public final void stopPlay() {
        TbCyberVideoView tbCyberVideoView = this.f21527h;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    public final void y1() {
        VideoItemData videoItemData = this.I;
        if (videoItemData != null) {
            if ("1".equals(videoItemData.is_agreed)) {
                this.Q.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
            } else {
                this.Q.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
            }
            this.x.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.c.e.m.b.f(this.I.agree_num, 0L)));
        }
    }

    public final void z1() {
        UserItemData userItemData;
        if (!this.Z && ((userItemData = this.I.author_info) == null || !"1".equals(userItemData.is_follow))) {
            this.B.setVisibility(0);
            this.B.setClickable(true);
            this.C.setVisibility(8);
            return;
        }
        this.B.setVisibility(4);
        this.B.setClickable(false);
        this.C.setVisibility(8);
    }
}
