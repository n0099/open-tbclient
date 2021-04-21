package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
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
import com.baidu.tbadk.core.util.SvgManager;
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
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.tencent.connect.common.Constants;
import d.b.i0.b1.p.a;
import d.b.i0.h.a;
import d.b.i0.r.s.a;
import d.b.i0.r.s.l;
import d.b.j0.j2.f;
import d.b.j0.s3.b.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class VideoPlayFragment extends BaseFragment implements a.b {
    public EMTextView A;
    public EMTextView B;
    public TextView C;
    public FrameLayout D;
    public LinearLayout E;
    public LinearLayout F;
    public LinearLayout G;
    public VideoItemData H;
    public TextView I;
    public VideoMiddleNiaiControllerView J;
    public boolean K;
    public boolean L;
    public AlphaAnimation M;
    public Rect N;
    public ImageView O;
    public ImageView P;
    public ImageView Q;
    public TextView R;
    public View S;
    public TextView T;
    public int U;
    public int V;
    public boolean W;
    public int X;
    public String Y;
    public String Z;
    public d.b.i0.r.s.j a0;
    public d.b.i0.r.s.l b0;

    /* renamed from: g  reason: collision with root package name */
    public View f21630g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public TbCyberVideoView f21631h;
    public TbImageView i;
    public RelativeLayout.LayoutParams i0;
    public View j;
    public String j0;
    public ImageView k;
    public boolean k0;
    public ImageView l;
    public TBLottieAnimationView l0;
    public HeadImageView m;
    public LinearLayout n;
    public LinearLayout o;
    public d.b.j0.s3.b.a o0;
    public LinearLayout p;
    public f.c p0;
    public LinearLayout q;
    public k0 q0;
    public LinearLayout r;
    public ImageView s;
    public ImageView t;
    public ImageView u;
    public ImageView v;
    public ExpandableTextView w;
    public EMTextView x;
    public d.b.i0.r.s.a x0;
    public EMTextView y;
    public EMTextView z;

    /* renamed from: e  reason: collision with root package name */
    public int f21628e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f21629f = 1;
    public ForumManageModel c0 = null;
    public d.b.i0.h.a d0 = null;
    public d.b.i0.s.e.a e0 = null;
    public BdUniqueId f0 = BdUniqueId.gen();
    public boolean h0 = false;
    public boolean m0 = false;
    public int n0 = 1;
    public CustomMessageListener r0 = new k(2001115);
    public final CustomMessageListener s0 = new v(2000994);
    public CustomMessageListener t0 = new d0(2016528);
    public l.d u0 = new q();
    public l.d v0 = new r();
    public l.d w0 = new s();
    public Runnable y0 = new y();
    public CyberPlayerManager.OnInfoListener z0 = new a0();
    public CyberPlayerManager.OnCompletionListener A0 = new b0();
    public CyberPlayerManager.OnPreparedListener B0 = new c0();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment.this.G1();
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements CyberPlayerManager.OnInfoListener {
        public a0() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.K) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.i.getVisibility() == 0) {
                    VideoPlayFragment.this.i.clearAnimation();
                    VideoPlayFragment.this.i.startAnimation(VideoPlayFragment.this.M);
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
            VideoItemData videoItemData = VideoPlayFragment.this.H;
            if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.H.thread_id));
            }
            VideoPlayFragment.this.getActivity().finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements CyberPlayerManager.OnCompletionListener {
        public b0() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            TbCyberVideoView tbCyberVideoView = VideoPlayFragment.this.f21631h;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.P();
                VideoPlayFragment.this.f21631h.seekTo(0);
                VideoPlayFragment.this.f21631h.start();
                VideoPlayFragment.this.N1();
                VideoPlayFragment.l1(VideoPlayFragment.this);
                if (VideoPlayFragment.this.n0 == 3) {
                    VideoPlayFragment.this.x1();
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
            VideoPlayFragment.this.X1();
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements CyberPlayerManager.OnPreparedListener {
        public c0() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TbCyberVideoView tbCyberVideoView = VideoPlayFragment.this.f21631h;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.setVolume(1.0f, 1.0f);
                if (VideoPlayFragment.this.f21631h.getDuration() < 15000 || VideoPlayFragment.this.J == null) {
                    VideoPlayFragment.this.J.setVisibility(8);
                    return;
                }
                VideoPlayFragment.this.J.setVisibility(0);
                if (VideoPlayFragment.this.J.getCurProgress() == 0) {
                    VideoPlayFragment.this.J.s();
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
            if (AntiHelper.c(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.H)) {
                return;
            }
            VideoPlayFragment.this.G1();
            StatisticItem statisticItem = new StatisticItem("c12796");
            statisticItem.param("tid", VideoPlayFragment.this.H.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class d0 extends CustomMessageListener {
        public d0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.j0.d3.h0.e)) {
                return;
            }
            AgreeData agreeData = ((d.b.j0.d3.h0.e) customResponsedMessage.getData()).f55240b;
            if (VideoPlayFragment.this.H == null || agreeData == null) {
                return;
            }
            String str = agreeData.nid;
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                BaijiahaoData baijiahaoData = VideoPlayFragment.this.H.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
                VideoPlayFragment.this.H.agree_num = String.valueOf(agreeData.agreeNum);
                VideoPlayFragment.this.H.is_agreed = agreeData.hasAgree ? "1" : "0";
                VideoPlayFragment.this.u1();
                return;
            }
            String str2 = agreeData.threadId;
            String str3 = VideoPlayFragment.this.H.thread_id;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
            VideoPlayFragment.this.H.agree_num = String.valueOf(agreeData.agreeNum);
            VideoPlayFragment.this.H.is_agreed = agreeData.hasAgree ? "1" : "0";
            VideoPlayFragment.this.u1();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
            videoPlayFragment.B1(videoPlayFragment.f21628e);
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements f.c {
        public e0() {
        }

        @Override // d.b.j0.j2.f.c
        public void a(int i, int i2) {
            if (VideoPlayFragment.this.p0 != null) {
                VideoPlayFragment.this.p0.a(i, i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment.this.a2();
            StatisticItem statisticItem = new StatisticItem("c12797");
            statisticItem.param("tid", VideoPlayFragment.this.H.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem2.param("tid", VideoPlayFragment.this.H.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("obj_locate", 19);
            statisticItem2.param("nid", VideoPlayFragment.this.H.nid);
            BaijiahaoData baijiahaoData = VideoPlayFragment.this.H.baijiahaoData;
            if (baijiahaoData != null && !d.b.c.e.p.k.isEmpty(baijiahaoData.oriUgcVid)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, VideoPlayFragment.this.H.baijiahaoData.oriUgcVid);
            }
            if (VideoPlayFragment.this.H.getVideoType() == 1) {
                statisticItem2.param("card_type", 2);
            } else if (VideoPlayFragment.this.H.getVideoType() == 2) {
                statisticItem2.param("card_type", 8);
            } else if (VideoPlayFragment.this.H.getVideoType() == 3) {
                statisticItem2.param("card_type", 6);
            }
            statisticItem2.param("recom_source", VideoPlayFragment.this.H.mRecomSource);
            statisticItem2.param("ab_tag", VideoPlayFragment.this.H.mRecomAbTag);
            statisticItem2.param("weight", VideoPlayFragment.this.H.mRecomWeight);
            statisticItem2.param("extra", VideoPlayFragment.this.H.mRecomExtra);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
            if (d.b.i0.j0.c.j(VideoPlayFragment.this.getBaseFragmentActivity()) != null && d.b.i0.j0.c.j(VideoPlayFragment.this.getBaseFragmentActivity()).a() != null && d.b.i0.j0.c.j(VideoPlayFragment.this.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(d.b.i0.j0.c.j(VideoPlayFragment.this.getBaseFragmentActivity()).b().locatePage)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements View.OnClickListener {
        public f0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
            if (videoPlayFragment.z1(videoPlayFragment.getPageContext(), 11001)) {
                VideoPlayFragment.this.S.setVisibility(4);
                if (VideoPlayFragment.this.o0 != null && VideoPlayFragment.this.o0.a() != null) {
                    VideoPlayFragment.this.o0.a().j();
                    VideoPlayFragment videoPlayFragment2 = VideoPlayFragment.this;
                    if (videoPlayFragment2.H != null) {
                        videoPlayFragment2.o0.w(VideoPlayFragment.this.H);
                    }
                }
                if (VideoPlayFragment.this.H != null) {
                    StatisticItem statisticItem = new StatisticItem("c13025");
                    statisticItem.param("tid", VideoPlayFragment.this.H.thread_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", VideoPlayFragment.this.H.forum_id);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoItemData videoItemData;
            if (ViewHelper.checkUpIsLogin(VideoPlayFragment.this.getActivity())) {
                VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
                if (videoPlayFragment.s == null || (videoItemData = videoPlayFragment.H) == null || videoItemData.author_info == null) {
                    return;
                }
                d.b.i0.s.e.a aVar = videoPlayFragment.e0;
                VideoPlayFragment videoPlayFragment2 = VideoPlayFragment.this;
                UserItemData userItemData = videoPlayFragment2.H.author_info;
                aVar.m(true, userItemData.portrait, userItemData.user_id, false, "6", videoPlayFragment2.f0, VideoPlayFragment.this.H.forum_id, "0");
                VideoPlayFragment videoPlayFragment3 = VideoPlayFragment.this;
                videoPlayFragment3.H.author_info.is_follow = "1";
                videoPlayFragment3.v1();
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(300L);
                VideoPlayFragment.this.s.startAnimation(scaleAnimation);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements SeekBar.OnSeekBarChangeListener {
        public g0() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                VideoPlayFragment.this.C1(true);
                EMTextView eMTextView = VideoPlayFragment.this.A;
                if (eMTextView != null) {
                    eMTextView.setText(StringHelper.stringForVideoTime(i));
                }
                EMTextView eMTextView2 = VideoPlayFragment.this.B;
                if (eMTextView2 != null) {
                    eMTextView2.setText("/" + StringHelper.stringForVideoTime(VideoPlayFragment.this.f21631h.getDuration()));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            VideoPlayFragment.this.k0 = true;
            if (seekBar != null) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_navi_seekbar_thumb_pressed));
                seekBar.setProgressDrawable(TbadkCoreApplication.getInst().getDrawable(R.drawable.video_navi_video_eight_width_seekbar));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            VideoPlayFragment.this.k0 = false;
            if (seekBar != null) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoPlayFragment.this.C1(false);
                if (!VideoPlayFragment.this.f21631h.isPlaying()) {
                    VideoPlayFragment.this.f21631h.start();
                    VideoPlayFragment.this.v.setVisibility(8);
                }
                d.b.c.e.m.e.a().postDelayed(VideoPlayFragment.this.y0, 3000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Animation.AnimationListener {
        public h() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (VideoPlayFragment.this.i != null) {
                VideoPlayFragment.this.i.setVisibility(8);
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
    public class h0 implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21647e;

        public h0(String str) {
            this.f21647e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f21647e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) d.b.c.a.j.a(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{this.f21647e}, true);
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayFragment.this.K) {
                    VideoPlayFragment.this.startPlay();
                    VideoPlayFragment.this.N = null;
                }
            }
        }

        public i() {
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00a9  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i;
            int i2;
            float f2;
            int width = VideoPlayFragment.this.i.getWidth();
            int height = VideoPlayFragment.this.i.getHeight();
            if (height > 0 && width > 0) {
                if (d.b.c.e.m.b.d(VideoPlayFragment.this.H.video_height, 0) > 0 && d.b.c.e.m.b.d(VideoPlayFragment.this.H.video_width, 0) > 0) {
                    float f3 = width;
                    float f4 = height;
                    float f5 = f3 / f4;
                    float c2 = d.b.c.e.m.b.c(VideoPlayFragment.this.H.video_width, 0.0f) / d.b.c.e.m.b.c(VideoPlayFragment.this.H.video_height, 0.0f);
                    if (c2 > 0.0f && Math.abs(c2 - f5) > 0.05d) {
                        if (c2 > f5) {
                            i2 = (int) (f3 / c2);
                            i = width;
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.U, VideoPlayFragment.this.V);
                            layoutParams.leftMargin = VideoPlayFragment.this.N.left;
                            layoutParams.topMargin = VideoPlayFragment.this.N.top;
                            VideoPlayFragment.this.i.setLayoutParams(layoutParams);
                            float f6 = 1.0f;
                            if (VideoPlayFragment.this.V > 0 || VideoPlayFragment.this.U <= 0) {
                                f2 = 1.0f;
                            } else {
                                f6 = i2 / VideoPlayFragment.this.V;
                                f2 = i / VideoPlayFragment.this.U;
                            }
                            VideoPlayFragment.this.i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f6).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.N.left + ((VideoPlayFragment.this.N.right - VideoPlayFragment.this.N.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.N.top + ((VideoPlayFragment.this.N.bottom - VideoPlayFragment.this.N.top) / 2))).start();
                            VideoPlayFragment.this.i.postDelayed(new a(), 200L);
                        }
                        i = (int) (f4 * c2);
                        i2 = height;
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.U, VideoPlayFragment.this.V);
                        layoutParams2.leftMargin = VideoPlayFragment.this.N.left;
                        layoutParams2.topMargin = VideoPlayFragment.this.N.top;
                        VideoPlayFragment.this.i.setLayoutParams(layoutParams2);
                        float f62 = 1.0f;
                        if (VideoPlayFragment.this.V > 0) {
                        }
                        f2 = 1.0f;
                        VideoPlayFragment.this.i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f62).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.N.left + ((VideoPlayFragment.this.N.right - VideoPlayFragment.this.N.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.N.top + ((VideoPlayFragment.this.N.bottom - VideoPlayFragment.this.N.top) / 2))).start();
                        VideoPlayFragment.this.i.postDelayed(new a(), 200L);
                    }
                }
            }
            i = width;
            i2 = height;
            RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.U, VideoPlayFragment.this.V);
            layoutParams22.leftMargin = VideoPlayFragment.this.N.left;
            layoutParams22.topMargin = VideoPlayFragment.this.N.top;
            VideoPlayFragment.this.i.setLayoutParams(layoutParams22);
            float f622 = 1.0f;
            if (VideoPlayFragment.this.V > 0) {
            }
            f2 = 1.0f;
            VideoPlayFragment.this.i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f622).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.N.left + ((VideoPlayFragment.this.N.right - VideoPlayFragment.this.N.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.N.top + ((VideoPlayFragment.this.N.bottom - VideoPlayFragment.this.N.top) / 2))).start();
            VideoPlayFragment.this.i.postDelayed(new a(), 200L);
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements View.OnClickListener {
        public i0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserItemData userItemData;
            VideoItemData videoItemData;
            UserItemData userItemData2;
            VideoItemData videoItemData2 = VideoPlayFragment.this.H;
            if (videoItemData2 == null || (userItemData = videoItemData2.author_info) == null || StringUtils.isNull(userItemData.user_id) || (videoItemData = VideoPlayFragment.this.H) == null || (userItemData2 = videoItemData.author_info) == null) {
                return;
            }
            long f2 = d.b.c.e.m.b.f(userItemData2.user_id, 0L);
            long f3 = d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = f2 == f3;
            if (f2 == 0 && f3 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(f2, z, false)));
            StatisticItem statisticItem = new StatisticItem("c12798");
            statisticItem.param("tid", VideoPlayFragment.this.H.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int width = VideoPlayFragment.this.i.getWidth();
            int height = VideoPlayFragment.this.i.getHeight();
            if (height <= 0 || width <= 0) {
                return;
            }
            if (d.b.c.e.m.b.d(VideoPlayFragment.this.H.video_height, 0) <= 0 || d.b.c.e.m.b.d(VideoPlayFragment.this.H.video_width, 0) <= 0) {
                return;
            }
            float f2 = width;
            float f3 = height;
            float f4 = f2 / f3;
            float c2 = d.b.c.e.m.b.c(VideoPlayFragment.this.H.video_width, 0.0f) / d.b.c.e.m.b.c(VideoPlayFragment.this.H.video_height, 0.0f);
            if (c2 > 0.0f && Math.abs(c2 - f4) > 0.05d) {
                if (c2 > f4) {
                    height = (int) (f2 / c2);
                } else {
                    width = (int) (f3 * c2);
                }
            }
            ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.i.getLayoutParams();
            layoutParams.height = height;
            layoutParams.width = width;
            VideoPlayFragment.this.i.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements View.OnClickListener {
        public j0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
            VideoItemData videoItemData = videoPlayFragment.H;
            if (videoItemData == null || videoItemData.act_info == null) {
                return;
            }
            d.b.i0.l.a.k(videoPlayFragment.getActivity(), VideoPlayFragment.this.H.act_info.link_url);
            StatisticItem statisticItem = new StatisticItem("c12799");
            statisticItem.param("tid", VideoPlayFragment.this.H.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public k(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserItemData userItemData;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                VideoItemData videoItemData = VideoPlayFragment.this.H;
                if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id) || data == null || !VideoPlayFragment.this.H.author_info.user_id.equals(data.f13364c)) {
                    return;
                }
                boolean z = true;
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.f0)) ? false : false;
                if (data.k != null) {
                    return;
                }
                if (!data.f13362a) {
                    if (!z || "0".equals(VideoPlayFragment.this.H.author_info.is_follow)) {
                        return;
                    }
                    d.b.c.e.p.l.K(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                    VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
                    videoPlayFragment.H.author_info.is_follow = "0";
                    videoPlayFragment.v1();
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    if (VideoPlayFragment.this.K) {
                        if (z) {
                            d.b.c.e.p.l.K(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.H));
                        } else {
                            VideoPlayFragment videoPlayFragment2 = VideoPlayFragment.this;
                            videoPlayFragment2.H.author_info.is_follow = "1";
                            videoPlayFragment2.v1();
                        }
                    }
                } else {
                    VideoPlayFragment videoPlayFragment3 = VideoPlayFragment.this;
                    videoPlayFragment3.H.author_info.is_follow = "0";
                    videoPlayFragment3.v1();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if ("index".equals(VideoPlayFragment.this.Z)) {
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
    public class l implements a.d {
        public l() {
        }

        @Override // d.b.j0.s3.b.a.d
        public void a(boolean z) {
            VideoPlayFragment.this.S.setVisibility(0);
            if (z) {
                VideoPlayFragment.this.T.setText(R.string.reply_something);
            } else {
                VideoPlayFragment.this.T.setText(StringUtils.isNull(((d.b.j0.s3.b.c) VideoPlayFragment.this.o0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
            }
            VideoItemData videoItemData = VideoPlayFragment.this.H;
            if (videoItemData == null || !z) {
                return;
            }
            long f2 = d.b.c.e.m.b.f(videoItemData.comment_num, 0L) + 1;
            VideoPlayFragment.this.H.comment_num = String.valueOf(f2);
            VideoPlayFragment.this.x.setText(StringHelper.numFormatOverWan(f2));
        }
    }

    /* loaded from: classes5.dex */
    public class m extends d.b.c.a.e {
        public m() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (obj == null || VideoPlayFragment.this.c0.getLoadDataMode() != 0) {
                return;
            }
            VideoPlayFragment.this.getActivity().finish();
        }
    }

    /* loaded from: classes5.dex */
    public class n implements a.InterfaceC1100a {
        public n() {
        }

        @Override // d.b.i0.h.a.InterfaceC1100a
        public void a(boolean z, boolean z2, String str) {
            if (z) {
                if (VideoPlayFragment.this.d0 != null) {
                    VideoPlayFragment.this.d0.h(z2);
                }
                VideoItemData videoItemData = VideoPlayFragment.this.H;
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
    public class o implements l.c {
        public o() {
        }

        @Override // d.b.i0.r.s.l.c
        public void onClick() {
            VideoPlayFragment.this.J1();
        }
    }

    /* loaded from: classes5.dex */
    public class p implements DialogInterface.OnDismissListener {
        public p() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            VideoPlayFragment.this.a0 = null;
            VideoPlayFragment.this.b0 = null;
            if (TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity())) {
                return;
            }
            TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class q implements l.d {
        public q() {
        }

        @Override // d.b.i0.r.s.l.d
        public void onClick() {
            if (!ViewHelper.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                if (VideoPlayFragment.this.a0 != null) {
                    VideoPlayFragment.this.a0.dismiss();
                    return;
                }
                return;
            }
            if (VideoPlayFragment.this.a0 != null) {
                VideoPlayFragment.this.a0.dismiss();
            }
            VideoItemData videoItemData = VideoPlayFragment.this.H;
            if (videoItemData == null) {
                return;
            }
            String str = videoItemData.post_id;
            boolean z = str != null && str.equals(videoItemData.mark_id);
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(VideoPlayFragment.this.H.thread_id);
            markData.setPostId(VideoPlayFragment.this.H.post_id);
            markData.setTime(date.getTime());
            markData.setHostMode(false);
            markData.setId(VideoPlayFragment.this.H.thread_id);
            markData.setForumId(VideoPlayFragment.this.H.forum_id);
            if (VideoPlayFragment.this.d0 != null) {
                VideoPlayFragment.this.d0.i(markData);
                if (!z) {
                    VideoPlayFragment.this.d0.a();
                } else {
                    VideoPlayFragment.this.d0.d();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements l.d {
        public r() {
        }

        @Override // d.b.i0.r.s.l.d
        public void onClick() {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            VideoPlayFragment.this.a0.dismiss();
            if (ViewHelper.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && (videoItemData = (videoPlayFragment = VideoPlayFragment.this).H) != null) {
                String str = videoItemData.thread_id;
                String str2 = videoItemData.forum_id;
                String string = videoPlayFragment.getResources().getString(R.string.web_view_report_title);
                String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.H.post_id;
                VideoItemData videoItemData2 = VideoPlayFragment.this.H;
                if (videoItemData2.isBjhVideo) {
                    str3 = String.format(TbConfig.URL_BJH_REPORT, str, videoItemData2.post_id) + "&channelid=33840";
                    string = "";
                }
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                if (VideoPlayFragment.this.H.isBjhVideo) {
                    tbWebViewActivityConfig.setFixTitle(true);
                }
                VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements l.d {

        /* loaded from: classes5.dex */
        public class a implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.i0.r.s.a f21663e;

            public a(d.b.i0.r.s.a aVar) {
                this.f21663e = aVar;
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                this.f21663e.dismiss();
                VideoPlayFragment videoPlayFragment = VideoPlayFragment.this;
                if (videoPlayFragment.H != null) {
                    ForumManageModel forumManageModel = videoPlayFragment.c0;
                    VideoPlayFragment videoPlayFragment2 = VideoPlayFragment.this;
                    VideoItemData videoItemData = videoPlayFragment2.H;
                    forumManageModel.N(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.W, null);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.i0.r.s.a f21665e;

            public b(s sVar, d.b.i0.r.s.a aVar) {
                this.f21665e = aVar;
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                this.f21665e.dismiss();
            }
        }

        public s() {
        }

        @Override // d.b.i0.r.s.l.d
        public void onClick() {
            WorksInfoData worksInfoData;
            VideoPlayFragment.this.a0.dismiss();
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(VideoPlayFragment.this.getActivity());
            VideoItemData videoItemData = VideoPlayFragment.this.H;
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
    public class t implements ExpandableTextView.e {
        public t() {
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            VideoPlayFragment.this.H.isTitleExpanded = z;
        }
    }

    /* loaded from: classes5.dex */
    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.l.a.u(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
        }
    }

    /* loaded from: classes5.dex */
    public class v extends CustomMessageListener {
        public v(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.Z1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements a.e {
        public w() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
            TbSingleton.getInstance().setHasAgreeToPlay(true);
            VideoPlayFragment.this.startPlay();
        }
    }

    /* loaded from: classes5.dex */
    public class x implements a.e {
        public x() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoPlayFragment.this.k0) {
                return;
            }
            VideoPlayFragment.this.w1(true);
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
            View view = videoPlayFragment.f21630g;
            if (view instanceof RelativeLayout) {
                ((RelativeLayout) view).removeView(videoPlayFragment.l0);
            }
            VideoPlayFragment.this.h0 = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static /* synthetic */ int l1(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.n0;
        videoPlayFragment.n0 = i2 + 1;
        return i2;
    }

    public final void A1() {
        if (this.f21630g == null || this.h0) {
            return;
        }
        this.h0 = true;
        this.l0 = new TBLottieAnimationView(this.f21630g.getContext());
        if (this.i0 == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396), TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396));
            this.i0 = layoutParams;
            layoutParams.addRule(13);
        }
        SkinManager.setLottieAnimation(this.l0, R.raw.lottie_agree_big_photo);
        View view = this.f21630g;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).addView(this.l0, this.i0);
        }
        this.l0.addAnimatorListener(new z());
        this.l0.playAnimation();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B1(int i2) {
        VideoItemData videoItemData;
        d.b.i0.i0.c k2;
        BaijiahaoData baijiahaoData;
        String str;
        if (!ViewHelper.checkUpIsLogin(getActivity()) || (videoItemData = this.H) == null) {
            return;
        }
        int i3 = 1;
        if (i2 == this.f21628e) {
            if ("1".equals(videoItemData.is_agreed)) {
                VideoItemData videoItemData2 = this.H;
                videoItemData2.agree_num = String.valueOf(d.b.c.e.m.b.d(videoItemData2.agree_num, 0) - 1);
                this.H.is_agreed = "0";
                StatisticItem statisticItem = new StatisticItem("c12795");
                statisticItem.param("tid", this.H.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (i2 != this.f21628e) {
                    statisticItem.param("obj_type", i3);
                } else {
                    statisticItem.param("obj_type", 2);
                }
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c12003");
                statisticItem2.param("tid", this.H.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (i2 != this.f21628e) {
                    statisticItem2.param("obj_type", i3);
                } else {
                    statisticItem2.param("obj_type", 2);
                }
                if ("index".equals(this.Z)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                k2 = TbPageExtraHelper.k(getContext());
                if (k2 != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
                }
                if (TbPageExtraHelper.m() != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                }
                TiebaStatic.log(statisticItem2);
                y1();
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                httpMessage.addParam("thread_id", this.H.thread_id);
                httpMessage.addParam("op_type", i3);
                httpMessage.addParam("obj_type", 3);
                httpMessage.addParam("agree_type", 2);
                httpMessage.addHeader("needSig", "1");
                baijiahaoData = this.H.baijiahaoData;
                if (baijiahaoData != null) {
                    httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
                    httpMessage.addParam("ori_ugc_nid", this.H.baijiahaoData.oriUgcNid);
                    httpMessage.addParam("ori_ugc_vid", this.H.baijiahaoData.oriUgcVid);
                    httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, this.H.baijiahaoData.oriUgcType);
                }
                if (k2 != null) {
                    httpMessage.addParam("obj_source", k2.a());
                }
                sendMessage(httpMessage);
                d.b.j0.d3.h0.e eVar = new d.b.j0.d3.h0.e();
                AgreeData agreeData = new AgreeData();
                str = this.H.thread_id;
                if (str != null) {
                    agreeData.threadId = str;
                }
                agreeData.agreeNum = Long.valueOf(this.H.agree_num).longValue();
                agreeData.agreeType = 2;
                agreeData.hasAgree = "1".equals(this.H.is_agreed);
                eVar.f55240b = agreeData;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.H));
            }
            VideoItemData videoItemData3 = this.H;
            videoItemData3.agree_num = String.valueOf(d.b.c.e.m.b.d(videoItemData3.agree_num, 0) + 1);
            this.H.is_agreed = "1";
            A1();
        } else {
            videoItemData.agree_num = String.valueOf(d.b.c.e.m.b.d(videoItemData.agree_num, 0) + 1);
            this.H.is_agreed = "1";
        }
        i3 = 0;
        StatisticItem statisticItem3 = new StatisticItem("c12795");
        statisticItem3.param("tid", this.H.thread_id);
        statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (i2 != this.f21628e) {
        }
        TiebaStatic.log(statisticItem3);
        StatisticItem statisticItem22 = new StatisticItem("c12003");
        statisticItem22.param("tid", this.H.thread_id);
        statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (i2 != this.f21628e) {
        }
        if ("index".equals(this.Z)) {
        }
        k2 = TbPageExtraHelper.k(getContext());
        if (k2 != null) {
        }
        if (TbPageExtraHelper.m() != null) {
        }
        TiebaStatic.log(statisticItem22);
        y1();
        HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        httpMessage2.addParam("thread_id", this.H.thread_id);
        httpMessage2.addParam("op_type", i3);
        httpMessage2.addParam("obj_type", 3);
        httpMessage2.addParam("agree_type", 2);
        httpMessage2.addHeader("needSig", "1");
        baijiahaoData = this.H.baijiahaoData;
        if (baijiahaoData != null) {
        }
        if (k2 != null) {
        }
        sendMessage(httpMessage2);
        d.b.j0.d3.h0.e eVar2 = new d.b.j0.d3.h0.e();
        AgreeData agreeData2 = new AgreeData();
        str = this.H.thread_id;
        if (str != null) {
        }
        agreeData2.agreeNum = Long.valueOf(this.H.agree_num).longValue();
        agreeData2.agreeType = 2;
        agreeData2.hasAgree = "1".equals(this.H.is_agreed);
        eVar2.f55240b = agreeData2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar2));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.H));
    }

    public final void C1(boolean z2) {
        if (z2) {
            this.o.setVisibility(8);
            this.D.setVisibility(8);
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            this.n.setVisibility(8);
            this.r.setVisibility(0);
            return;
        }
        this.o.setVisibility(0);
        this.D.setVisibility(0);
        this.p.setVisibility(0);
        this.q.setVisibility(0);
        this.n.setVisibility(0);
        this.r.setVisibility(8);
    }

    public final void D1() {
        if (this.H == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.H.thread_id);
        statisticItem.param("nid", this.H.nid);
        statisticItem.param("fid", this.H.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.X);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("obj_param1", d.b.c.e.p.k.isEmpty(this.H.mRecomWeight) ? "0" : this.H.mRecomWeight);
        statisticItem.param("extra", d.b.c.e.p.k.isEmpty(this.H.mRecomExtra) ? "0" : this.H.mRecomExtra);
        statisticItem.param("obj_id", this.j0);
        statisticItem.param("ab_tag", d.b.c.e.p.k.isEmpty(this.H.mRecomAbTag) ? "0" : this.H.mRecomAbTag);
        statisticItem.param("obj_source", d.b.c.e.p.k.isEmpty(this.H.mRecomSource) ? "0" : this.H.mRecomSource);
        statisticItem.param("obj_type", this.Z);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 1);
        BaijiahaoData baijiahaoData = this.H.baijiahaoData;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.H.baijiahaoData.oriUgcVid);
            int i2 = this.H.baijiahaoData.oriUgcType;
            if (i2 == 4) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (i2 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
        } else {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
        }
        TiebaStatic.log(statisticItem);
    }

    public String E1() {
        return null;
    }

    public List<String> F1() {
        return null;
    }

    public final void G1() {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(getActivity());
        VideoItemData videoItemData = this.H;
        PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(videoItemData.thread_id, videoItemData.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.H.forum_id));
        createNormalCfg.setForumName(this.H.forum_name);
        createNormalCfg.setVideo_source(VideoPlayActivity.FROM_VIDEO_PLAY);
        createNormalCfg.setJumpToCommentArea(false);
        createNormalCfg.setBjhData(this.H.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void H1(int i2, int i3, Intent intent) {
        d.b.j0.s3.b.a aVar = this.o0;
        if (aVar != null) {
            aVar.n(i2, i3, intent);
        }
    }

    public boolean I1() {
        d.b.j0.s3.b.a aVar = this.o0;
        if (aVar == null || aVar.a() == null || !this.o0.a().v()) {
            return false;
        }
        this.o0.a().o();
        this.S.setVisibility(0);
        if (!(this.o0.a().n(28) instanceof d.b.j0.s3.b.c) || ((d.b.j0.s3.b.c) this.o0.a().n(28)).g() == null || ((d.b.j0.s3.b.c) this.o0.a().n(28)).g().getText() == null) {
            return true;
        }
        this.T.setText(StringUtils.isNull(((d.b.j0.s3.b.c) this.o0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        return true;
    }

    public void J1() {
        d.b.i0.r.s.j jVar = this.a0;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.a0.dismiss();
    }

    public final void K1() {
        d.b.j0.s3.b.a aVar = (d.b.j0.s3.b.a) new d.b.j0.s3.b.b().a(getActivity());
        this.o0 = aVar;
        if (aVar == null || this.H == null) {
            return;
        }
        aVar.s(getPageContext());
        d.b.j0.s3.b.a aVar2 = this.o0;
        VideoItemData videoItemData = this.H;
        aVar2.t(videoItemData.thread_id, videoItemData.forum_id, videoItemData.forum_name);
        this.o0.u(new l());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        ((RelativeLayout) this.f21630g).addView(this.o0.a(), layoutParams);
    }

    public final void L1() {
        TbCyberVideoView tbCyberVideoView = this.f21631h;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.pause();
        }
    }

    public final void M1(int i2) {
        if (this.H == null || this.N != null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12794");
        statisticItem.param("tid", this.H.thread_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
        StatisticItem statisticItem2 = new StatisticItem("common_exp");
        statisticItem2.param("tid", this.H.thread_id);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem2.param("obj_type", i2);
        statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
        statisticItem2.param("page_type", "a023");
        statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, 1);
        TiebaStatic.log(statisticItem2);
    }

    public final void N1() {
        if (this.H != null) {
            d.b.j0.j2.o oVar = new d.b.j0.j2.o();
            oVar.f58032a = VideoPlayActivity.FROM_VIDEO_PLAY;
            VideoItemData videoItemData = this.H;
            oVar.f58034c = videoItemData.thread_id;
            oVar.t = videoItemData.nid;
            oVar.f58035d = this.H.forum_id + "";
            oVar.f58036e = TbadkCoreApplication.getCurrentAccount();
            VideoItemData videoItemData2 = this.H;
            oVar.f58037f = videoItemData2.mRecomSource;
            oVar.f58038g = videoItemData2.mRecomAbTag;
            oVar.f58039h = videoItemData2.mRecomWeight;
            oVar.i = "";
            oVar.k = "";
            oVar.m = videoItemData2.mMd5;
            if (this.N != null) {
                oVar.n = "1";
            } else {
                oVar.n = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.Y)) {
                oVar.p = "1";
                oVar.f58032a = "auto_midpage";
                oVar.i = "index";
            }
            d.b.j0.j2.h.e(this.H.mMd5, "", "1", oVar, this.f21631h.getPcdnState());
        }
    }

    public final void O1() {
        ImageView imageView;
        if (this.u == null || (imageView = this.t) == null) {
            return;
        }
        imageView.clearAnimation();
        this.u.clearAnimation();
        this.t.setVisibility(0);
        this.u.setVisibility(8);
    }

    public final void P1() {
        TbCyberVideoView tbCyberVideoView;
        if (Z1() || (tbCyberVideoView = this.f21631h) == null || this.v == null || this.H == null) {
            return;
        }
        if (tbCyberVideoView.getParent() == null) {
            R1();
            S1();
        }
        if (TbVideoViewSet.d().e(this.g0) == null || TbVideoViewSet.d().e(this.g0) != this.f21631h) {
            this.f21631h.setVideoPath(this.g0, this.H.thread_id);
        }
        TbImageView tbImageView = this.i;
        if (tbImageView != null && tbImageView.getVisibility() == 0) {
            this.i.setVisibility(8);
        }
        this.f21631h.T(null);
        this.J.s();
        this.v.setVisibility(8);
        W1();
        k0 k0Var = this.q0;
        if (k0Var != null) {
            k0Var.onStart();
        }
    }

    public void Q1(f.c cVar) {
        this.p0 = cVar;
    }

    public void R1() {
        TbCyberVideoView tbCyberVideoView = this.f21631h;
        if (tbCyberVideoView == null || tbCyberVideoView.getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.f21630g).addView(this.f21631h.getView(), 0);
        this.f21631h.getView().setLayoutParams(layoutParams);
        if (this.H != null) {
            d.b.j0.j2.o oVar = new d.b.j0.j2.o();
            oVar.f58036e = TbadkCoreApplication.getCurrentAccount();
            VideoItemData videoItemData = this.H;
            oVar.f58034c = videoItemData.thread_id;
            oVar.t = videoItemData.nid;
            oVar.f58035d = videoItemData.forum_id;
            oVar.m = videoItemData.mMd5;
            oVar.k = "";
            oVar.f58037f = videoItemData.mRecomSource;
            oVar.l = videoItemData.mRecomAbTag;
            oVar.j = 1;
            BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
            if (baijiahaoData != null) {
                int i2 = baijiahaoData.oriUgcType;
                if (i2 == 2) {
                    oVar.j = 3;
                } else if (i2 == 4) {
                    oVar.j = 2;
                }
            }
            oVar.f58039h = this.H.mRecomWeight;
            if (this.N != null) {
                oVar.n = "1";
            } else {
                oVar.n = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.Y)) {
                oVar.p = "1";
                oVar.f58032a = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                oVar.i = this.Z;
                oVar.k = this.j0;
                oVar.f58038g = this.H.mRecomWeight;
            } else {
                oVar.f58032a = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.f21631h.setVideoStatData(oVar);
            this.f21631h.setLocateSource("v_mid_page");
        }
        this.f21631h.setContinuePlayEnable(true);
    }

    public final void S1() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f21631h.setOnPreparedListener(this.B0);
        }
        this.f21631h.setOnCompletionListener(this.A0);
        this.f21631h.setOnInfoListener(this.z0);
    }

    public final void T1(String str) {
        if (this.f21631h == null || str == null || str.equals(this.g0)) {
            return;
        }
        this.f21631h.setVideoPath(str, this.H.thread_id);
        this.g0 = str;
    }

    public void U1(k0 k0Var) {
        this.q0 = k0Var;
    }

    public void V1() {
        if (this.a0 == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.a0.l();
    }

    public final void W1() {
        if (d.b.c.e.p.j.x()) {
            d.b.j0.q3.f.d().g(getContext());
        }
    }

    public final void X1() {
        String str;
        if (this.a0 == null) {
            this.b0 = new d.b.i0.r.s.l(getActivity());
            this.a0 = new d.b.i0.r.s.j(getPageContext(), this.b0);
            ArrayList arrayList = new ArrayList();
            d.b.i0.r.s.h hVar = new d.b.i0.r.s.h(getActivity().getString(R.string.mark), this.b0);
            boolean z2 = false;
            VideoItemData videoItemData = this.H;
            if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                z2 = true;
            }
            if (z2) {
                hVar.n(getResources().getString(R.string.remove_mark));
            } else {
                hVar.n(getResources().getString(R.string.mark));
            }
            hVar.m(this.u0);
            VideoItemData videoItemData2 = this.H;
            if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                arrayList.add(hVar);
            }
            d.b.i0.r.s.h hVar2 = new d.b.i0.r.s.h(getActivity().getString(R.string.report_text), this.b0);
            hVar2.m(this.v0);
            arrayList.add(hVar2);
            d.b.i0.r.s.h hVar3 = new d.b.i0.r.s.h(getActivity().getString(R.string.delete), this.b0);
            hVar3.m(this.w0);
            if (this.W) {
                arrayList.add(hVar3);
            }
            this.b0.m(new o());
            this.a0.setOnDismissListener(new p());
            this.b0.k(arrayList);
        }
        V1();
    }

    public final void Y1() {
        if (getActivity() != null) {
            d.b.i0.r.s.a aVar = this.x0;
            if (aVar == null || !aVar.isShowing()) {
                this.x0 = new d.b.i0.r.s.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new u());
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, null);
                this.x0.setContentView(inflate);
                this.x0.setPositiveButton(R.string.confirm, new w());
                this.x0.setNegativeButton(R.string.cancel, new x());
                this.x0.setContentViewSize(1);
                this.x0.setButtonTextColor(R.color.CAM_X0105);
                this.x0.setCancelable(true);
                this.x0.create(getPageContext());
                this.x0.show();
            }
        }
    }

    public final boolean Z1() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || d.b.j0.q3.f.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !d.b.c.e.p.j.x() || !this.K) {
            return false;
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        L1();
        Y1();
        return true;
    }

    public final void a2() {
        String str;
        String str2;
        String format;
        VideoItemData videoItemData;
        UserItemData userItemData;
        VideoItemData videoItemData2 = this.H;
        if (videoItemData2 == null) {
            return;
        }
        String str3 = videoItemData2.forum_id;
        String str4 = videoItemData2.forum_name;
        String str5 = videoItemData2.title;
        BaijiahaoData baijiahaoData = videoItemData2.baijiahaoData;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.H.baijiahaoData.oriUgcType + "&dvid=" + this.H.baijiahaoData.oriUgcVid + "&nid=" + this.H.baijiahaoData.oriUgcNid;
        } else {
            str = videoItemData2.thread_id;
            str2 = "?share=9105&fr=share";
        }
        String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
        String str7 = this.H.thumbnail_url;
        String string = getResources().getString(R.string.share_content_tpl);
        String string2 = getResources().getString(R.string.default_share_content_tpl);
        VideoItemData videoItemData3 = this.H;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
        } else {
            format = MessageFormat.format(string, str5, "");
        }
        Uri parse = str7 == null ? null : Uri.parse(str7);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str5;
        shareItem.s = format;
        if (this.H.baijiahaoData == null) {
            shareItem.Q = videoItemData.play_count;
        }
        if (this.H.isBjhVideo) {
            shareItem.C = format;
        } else {
            shareItem.C = "";
        }
        shareItem.t = str6;
        shareItem.o = 2;
        shareItem.q = str;
        shareItem.E = 3;
        shareItem.I = str3;
        shareItem.p = str4;
        shareItem.J = str;
        shareItem.f13386f = true;
        shareItem.D = 12;
        if (this.H.getVideoType() == 1) {
            shareItem.L = 2;
        } else if (this.H.getVideoType() == 2) {
            shareItem.L = 8;
        } else if (this.H.getVideoType() == 3) {
            shareItem.L = 6;
        }
        if (parse != null) {
            shareItem.v = parse;
        }
        if (this.H.isBjhVideo) {
            shareItem.d0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        VideoItemData videoItemData4 = this.H;
        originalThreadInfo.f12882c = videoItemData4.thumbnail_url;
        originalThreadInfo.f12880a = 3;
        originalThreadInfo.f12881b = videoItemData4.title;
        originalThreadInfo.f12885f = videoItemData4.thread_id;
        originalThreadInfo.p = videoItemData4.baijiahaoData;
        shareItem.S = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.E);
        bundle.putInt("obj_type", shareItem.L);
        bundle.putString("fid", shareItem.I);
        bundle.putString("tid", shareItem.J);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.i(bundle);
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        d.b.j0.b0.f.b().k(shareDialogConfig);
    }

    @Override // d.b.i0.b1.p.a.b
    public void k() {
        if (this.f21631h.isPlaying()) {
            this.f21631h.pause();
            this.v.setVisibility(0);
            w1(false);
            d.b.c.e.m.e.a().removeCallbacks(this.y0);
        } else if (Z1()) {
        } else {
            this.f21631h.start();
            this.v.setVisibility(8);
            w1(true);
            this.J.s();
        }
    }

    @Override // d.b.i0.b1.p.a.b
    public void l() {
        UserItemData userItemData;
        VideoItemData videoItemData = this.H;
        if (videoItemData == null || (userItemData = videoItemData.author_info) == null) {
            return;
        }
        long f2 = d.b.c.e.m.b.f(userItemData.user_id, 0L);
        long f3 = d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        boolean z2 = f2 == f3;
        if (f2 == 0 && f3 == 0) {
            z2 = false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(f2, z2, false)));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.W) {
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.c0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(new m());
        }
        d.b.i0.h.a c2 = d.b.i0.h.a.c(getBaseFragmentActivity());
        this.d0 = c2;
        if (c2 != null) {
            c2.j(new n());
        }
        this.e0 = new d.b.i0.s.e.a(null);
        registerListener(this.r0);
        registerListener(this.s0);
        if (Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode()) {
            return;
        }
        this.m0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        H1(i2, i3, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.b.j0.s3.b.a aVar = this.o0;
        if (aVar != null && aVar.a() != null) {
            this.o0.a().w(i2);
        }
        d.b.i0.r.s.l lVar = this.b0;
        if (lVar != null) {
            lVar.j();
        }
        if (this.f21630g != null) {
            this.P.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_reply120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.Q.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_share120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.u.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_share_wechat120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.s.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_follow24, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.v.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
            d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(this.S);
            d2.k(R.string.J_X01);
            d2.f(R.color.CAM_X0614);
            d.b.i0.r.u.c d3 = d.b.i0.r.u.c.d(this.A);
            d3.v(R.string.F_X02);
            d3.q(R.color.CAM_X0101);
            d.b.i0.r.u.c.d(this.B).v(R.string.F_X02);
            d.b.i0.r.u.c d4 = d.b.i0.r.u.c.d(this.z);
            d4.u(R.dimen.T_X09);
            d4.v(R.string.F_X02);
            d4.t(R.array.S_O_X001);
            d.b.i0.r.u.c d5 = d.b.i0.r.u.c.d(this.y);
            d5.u(R.dimen.T_X09);
            d5.v(R.string.F_X02);
            d5.t(R.array.S_O_X001);
            d.b.i0.r.u.c d6 = d.b.i0.r.u.c.d(this.x);
            d6.u(R.dimen.T_X09);
            d6.v(R.string.F_X02);
            d6.t(R.array.S_O_X001);
            d.b.i0.r.u.c d7 = d.b.i0.r.u.c.d(this.R);
            d7.u(R.dimen.T_X06);
            d7.v(R.string.F_X02);
            d7.t(R.array.S_O_X001);
            this.B.setTextColor(d.b.j0.d3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.b.i0.r.u.a.a(R.string.A_X08)));
            this.y.setTextColor(d.b.j0.d3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.b.i0.r.u.a.a(R.string.A_X03)));
            this.z.setTextColor(d.b.j0.d3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.b.i0.r.u.a.a(R.string.A_X03)));
            this.x.setTextColor(d.b.j0.d3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.b.i0.r.u.a.a(R.string.A_X03)));
        }
        WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.t0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.H = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.N = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.X = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.Y = arguments.getString("page_from");
        this.Z = arguments.getString("from");
        this.j0 = arguments.getString("obj_id");
        VideoItemData videoItemData = this.H;
        if (videoItemData != null && videoItemData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.H.author_info.user_id)) {
            this.W = true;
        }
        this.f21630g = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
        this.f21631h = tbCyberVideoView;
        tbCyberVideoView.setStageType("2005");
        this.f21631h.getMediaProgressObserver().j(new e0());
        R1();
        TbImageView tbImageView = (TbImageView) this.f21630g.findViewById(R.id.video_cover);
        this.i = tbImageView;
        tbImageView.setPlaceHolder(4);
        if (DeviceInfoUtil.isHWnova() || (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity()))) {
            this.j = this.f21630g.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.j.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.k = (ImageView) this.f21630g.findViewById(R.id.back_btn);
        this.l = (ImageView) this.f21630g.findViewById(R.id.more_btn);
        HeadImageView headImageView = (HeadImageView) this.f21630g.findViewById(R.id.author_portrait);
        this.m = headImageView;
        headImageView.setDefaultResource(17170445);
        this.m.setPlaceHolder(2);
        this.m.setIsRound(true);
        this.D = (FrameLayout) this.f21630g.findViewById(R.id.author_info_container);
        this.n = (LinearLayout) this.f21630g.findViewById(R.id.bottom_container);
        this.s = (ImageView) this.f21630g.findViewById(R.id.love_btn);
        this.O = (ImageView) this.f21630g.findViewById(R.id.agree_img);
        this.w = (ExpandableTextView) this.f21630g.findViewById(R.id.video_title);
        this.J = (VideoMiddleNiaiControllerView) this.f21630g.findViewById(R.id.media_controller);
        this.C = (TextView) this.f21630g.findViewById(R.id.video_activity);
        this.p = (LinearLayout) this.f21630g.findViewById(R.id.comment_container);
        this.x = (EMTextView) this.f21630g.findViewById(R.id.comment_num);
        this.P = (ImageView) this.f21630g.findViewById(R.id.comment_img);
        this.o = (LinearLayout) this.f21630g.findViewById(R.id.agree_container);
        this.r = (LinearLayout) this.f21630g.findViewById(R.id.ll_drag_container);
        this.y = (EMTextView) this.f21630g.findViewById(R.id.agree_num);
        this.Q = (ImageView) this.f21630g.findViewById(R.id.share_img);
        this.z = (EMTextView) this.f21630g.findViewById(R.id.share_num);
        this.A = (EMTextView) this.f21630g.findViewById(R.id.drag_cur_time);
        this.B = (EMTextView) this.f21630g.findViewById(R.id.drag_total_time);
        this.t = (ImageView) this.f21630g.findViewById(R.id.share_img);
        this.u = (ImageView) this.f21630g.findViewById(R.id.share_img_changed);
        O1();
        this.v = (ImageView) this.f21630g.findViewById(R.id.play_btn);
        this.E = (LinearLayout) this.f21630g.findViewById(R.id.video_act_private_container);
        this.F = (LinearLayout) this.f21630g.findViewById(R.id.video_activity_container);
        this.G = (LinearLayout) this.f21630g.findViewById(R.id.video_private);
        this.q = (LinearLayout) this.f21630g.findViewById(R.id.share_container);
        this.R = (TextView) this.f21630g.findViewById(R.id.video_author_name);
        View findViewById = this.f21630g.findViewById(R.id.quick_reply_comment_layout);
        this.S = findViewById;
        findViewById.setOnClickListener(new f0());
        VideoItemData videoItemData2 = this.H;
        if (videoItemData2 != null) {
            if (videoItemData2.video_duration > 15) {
                this.J.setVisibility(0);
            } else {
                this.J.setVisibility(8);
            }
        }
        this.J.setPlayer(this.f21631h);
        this.J.setOnSeekBarChangeListener(new g0());
        this.T = (TextView) this.f21630g.findViewById(R.id.quick_reply_comment_text);
        TextView textView = (TextView) this.f21630g.findViewById(R.id.download_nani_guide_txt);
        this.I = textView;
        textView.setVisibility(8);
        String p2 = d.b.i0.r.d0.b.j().p("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(p2)) {
            this.I.setText(p2);
        }
        this.I.setOnClickListener(new h0(d.b.i0.r.d0.b.j().p("nani_key_download_link_url", null)));
        y1();
        this.m.setOnClickListener(new i0());
        this.F.setOnClickListener(new j0());
        this.w.setHasDown();
        this.w.setOnClickListener(new a());
        this.k.setOnClickListener(new b());
        this.l.setOnClickListener(new c());
        this.p.setOnClickListener(new d());
        this.o.setOnClickListener(new e());
        this.q.setOnClickListener(new f());
        this.s.setOnClickListener(new g());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.M = alphaAnimation;
        alphaAnimation.setDuration(100L);
        this.M.setAnimationListener(new h());
        Rect rect = this.N;
        if (rect != null) {
            this.U = rect.right - rect.left;
            this.V = rect.bottom - rect.top;
            this.i.post(new i());
        } else {
            this.i.post(new j());
        }
        K1();
        if (this.K) {
            D1();
        }
        VideoItemData videoItemData3 = this.H;
        if (videoItemData3 != null && !StringUtils.isNull(videoItemData3.video_url)) {
            T1(this.H.video_url);
        }
        return this.f21630g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.t0);
        d.b.j0.s3.b.a aVar = this.o0;
        if (aVar != null) {
            aVar.o();
        }
        if (this.y0 != null) {
            d.b.c.e.m.e.a().removeCallbacks(this.y0);
            this.y0 = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        L1();
        d.b.j0.s3.b.a aVar = this.o0;
        if (aVar == null || aVar.a() == null) {
            return;
        }
        this.o0.a().o();
        this.S.setVisibility(0);
        this.T.setText(StringUtils.isNull(((d.b.j0.s3.b.c) this.o0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity())) {
            TbSingleton.getInstance().isCutoutScreen(getActivity());
        }
        VideoItemData videoItemData = this.H;
        if (videoItemData == null || StringUtils.isNull(videoItemData.video_url)) {
            return;
        }
        this.L = true;
        if (this.K) {
            N1();
            P1();
            M1(0);
            return;
        }
        L1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        y1();
        S1();
    }

    @Override // d.b.i0.b1.p.a.b
    public void r0(float f2, float f3) {
        if (ViewHelper.checkUpIsLogin(getActivity())) {
            A1();
            VideoItemData videoItemData = this.H;
            if (videoItemData == null || !"0".equals(videoItemData.is_agreed)) {
                return;
            }
            B1(this.f21629f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        this.K = z2;
        if (!z2 && this.o0 != null) {
            this.T.setText(R.string.reply_something);
            this.o0.l();
        }
        if (this.L) {
            if (this.K && (!this.m0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                M1(1);
                startPlay();
                D1();
                this.m0 = false;
                return;
            }
            O1();
            this.n0 = 1;
            L1();
        }
    }

    public final void startPlay() {
        if (Z1()) {
            return;
        }
        W1();
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT < 17 && this.i.getVisibility() == 0) {
            this.i.clearAnimation();
            this.i.startAnimation(this.M);
        }
        if (this.f21631h != null) {
            if (TbVideoViewSet.d().e(this.g0) == null || TbVideoViewSet.d().e(this.g0) != this.f21631h) {
                this.f21631h.setVideoPath(this.g0, this.H.thread_id);
            }
            this.f21631h.start();
            this.J.s();
            N1();
        }
    }

    public final void stopPlay() {
        TbCyberVideoView tbCyberVideoView = this.f21631h;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    public final void u1() {
        VideoItemData videoItemData = this.H;
        if (videoItemData != null) {
            if ("1".equals(videoItemData.is_agreed)) {
                this.O.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
            } else {
                this.O.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
            }
            this.y.setText(StringHelper.numFormatOverWan(d.b.c.e.m.b.f(this.H.agree_num, 0L)));
        }
    }

    public final void v1() {
        UserItemData userItemData;
        if (!this.W && ((userItemData = this.H.author_info) == null || !"1".equals(userItemData.is_follow))) {
            this.s.setVisibility(0);
            this.s.setClickable(true);
            return;
        }
        this.s.setVisibility(4);
        this.s.setClickable(false);
    }

    public final void w1(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.J;
        if (videoMiddleNiaiControllerView != null) {
            videoMiddleNiaiControllerView.setBottomBarShow(z2);
        }
    }

    public final void x1() {
        if (this.u == null || this.t == null) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(300L);
        this.t.clearAnimation();
        this.u.clearAnimation();
        this.t.setVisibility(8);
        this.u.setVisibility(0);
        this.u.startAnimation(scaleAnimation2);
        this.t.startAnimation(scaleAnimation);
    }

    public final void y1() {
        VideoItemData videoItemData = this.H;
        if (videoItemData != null) {
            this.i.W(videoItemData.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.H.title);
            if (!StringUtils.isNull(this.H.title) && !matcher.matches()) {
                this.w.setVisibility(0);
                this.w.setTextSize(d.b.c.e.p.l.g(getContext(), R.dimen.T_X07));
                this.w.setTextColor(R.color.CAM_X0101);
                this.w.setLineSpacingExtra(d.b.c.e.p.l.g(getContext(), R.dimen.tbds2));
                this.w.setExpandable(true);
                this.w.setOnStatusChangedListener(new t());
                ExpandableTextView expandableTextView = this.w;
                VideoItemData videoItemData2 = this.H;
                expandableTextView.setData(videoItemData2.title, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
            } else {
                this.w.setVisibility(8);
            }
            this.x.setText(StringHelper.numFormatOverWan(d.b.c.e.m.b.f(this.H.comment_num, 0L)));
            this.y.setText(StringHelper.numFormatOverWan(d.b.c.e.m.b.f(this.H.agree_num, 0L)));
            this.z.setText(StringHelper.numFormatOverWan(d.b.c.e.m.b.f(this.H.share_num, 0L)));
            UserItemData userItemData = this.H.author_info;
            if (userItemData != null) {
                if (!TextUtils.isEmpty(userItemData.bjhAvatar)) {
                    this.m.W(this.H.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.H.author_info.portrait) && this.H.author_info.portrait.startsWith("http")) {
                    this.m.W(this.H.author_info.portrait, 10, false);
                } else {
                    this.m.W(this.H.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.H.author_info.a())) {
                    this.R.setVisibility(8);
                } else {
                    this.R.setVisibility(0);
                    TextView textView = this.R;
                    textView.setText("@" + this.H.author_info.a());
                }
            }
            if ("1".equals(this.H.is_private) && this.I.getVisibility() != 0) {
                this.G.setVisibility(0);
            } else {
                this.G.setVisibility(8);
            }
            if ("1".equals(this.H.is_agreed)) {
                this.O.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
            } else {
                this.O.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
            }
            ActivityItemData activityItemData = this.H.act_info;
            if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.I.getVisibility() != 0) {
                this.F.setVisibility(0);
                this.C.setText(this.H.act_info.activity_name);
            } else {
                this.F.setVisibility(8);
            }
            v1();
            if (this.H.isBjhVideo) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
            }
        }
    }

    public final boolean z1(TbPageContext<?> tbPageContext, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return true;
    }
}
