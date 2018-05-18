package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.f;
import com.baidu.tieba.videoplay.editor.a;
import com.baidu.tieba.videoplay.editor.c;
import com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager;
import com.baidu.tieba.view.a;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class VideoPlayFragment extends BaseFragment implements VerticalViewPager.a {
    private String XN;
    private boolean aOW;
    protected ScaleAnimation apc;
    public ImageView biL;
    private n blg;
    private e cqE;
    private a cqF;
    private boolean dyy;
    public QuickVideoView gVV;
    private TbImageView gVW;
    public TbImageView gVX;
    public LinearLayout gVY;
    public LinearLayout gVZ;
    com.baidu.tbadk.core.dialog.a gWA;
    public LinearLayout gWa;
    public ImageView gWb;
    public TextView gWc;
    public TextView gWd;
    public TextView gWe;
    public TextView gWf;
    public TextView gWg;
    public ImageView gWh;
    private LinearLayout gWi;
    public LinearLayout gWj;
    public LinearLayout gWk;
    public VideoItemData gWl;
    private TextView gWm;
    private AlphaAnimation gWn;
    public ImageView gWo;
    public TextView gWp;
    private View gWq;
    private TextView gWr;
    private int gWs;
    private int gWt;
    private int gWu;
    private boolean gWv;
    private AnimatorSet gWw;
    private RelativeLayout.LayoutParams gWx;
    private boolean gWy;
    private com.baidu.tieba.videoplay.editor.a gWz;
    public ImageView mBackBtn;
    private String mFrom;
    private boolean mIsVisible;
    private Rect mRect;
    public View mRootView;
    private int gVT = 0;
    private int gVU = 1;
    private ForumManageModel cqN = null;
    private com.baidu.tbadk.baseEditMark.a eHB = null;
    private com.baidu.tbadk.coreExtra.model.a ait = null;
    private BdUniqueId aBL = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.gWl != null && VideoPlayFragment.this.gWl.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.gWl.author_info.user_id) && data != null && VideoPlayFragment.this.gWl.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aBL)) ? false : false;
                    if (data.aup == null) {
                        if (!data.Ai) {
                            if (z && !"0".equals(VideoPlayFragment.this.gWl.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), d.k.attention_fail);
                                VideoPlayFragment.this.gWl.author_info.is_follow = "0";
                                VideoPlayFragment.this.bzD();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), d.k.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.gWl));
                                    return;
                                }
                                VideoPlayFragment.this.gWl.author_info.is_follow = "1";
                                VideoPlayFragment.this.bzD();
                            }
                        } else {
                            VideoPlayFragment.this.gWl.author_info.is_follow = "0";
                            VideoPlayFragment.this.bzD();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.bzF();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.gWl = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.gWu = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.gWy = arguments.getBoolean(VideoPlayActivityConfig.PAGE_FIRST_IN);
        this.XN = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.gWl != null && this.gWl.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.gWl.author_info.user_id)) {
            this.dyy = true;
        }
        this.blg = new n(getActivity());
        this.mRootView = layoutInflater.inflate(d.i.video_play_view, (ViewGroup) null);
        this.gVV = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.gVV.setBusiness(this.blg);
        if (this.gWl != null) {
            y yVar = new y();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.aNv = this.gWl.thread_id;
            yVar.csP = this.gWl.forum_id;
            yVar.fRT = this.gWl.mMd5;
            yVar.XN = "";
            yVar.mSource = this.gWl.mRecomSource;
            yVar.fRS = this.gWl.mRecomAbTag;
            yVar.fRQ = this.gWl.mRecomWeight;
            if (this.mRect != null) {
                yVar.fRU = "1";
            } else {
                yVar.fRU = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.fRV = "1";
                yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                yVar.fRR = "index";
                yVar.XN = this.XN;
                yVar.fRP = this.gWl.mRecomWeight;
            } else {
                yVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.blg.setVideoStatsData(yVar);
        }
        this.gVW = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.gVW.setDefaultBgResource(d.f.icon_play_bg);
        this.gVW.setDefaultErrorResource(d.f.icon_play_bg);
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.biL = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.gVX = (TbImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.gVX.setIsRound(true);
        this.gVX.setDrawerType(1);
        this.gVX.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gVX.setDefaultResource(d.C0126d.transparent);
        this.gVX.setDefaultBgResource(d.C0126d.transparent);
        this.gWb = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.gWo = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.gWc = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.gWd = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.gVZ = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.gWe = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.gVY = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.gWf = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.gWg = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.gWh = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.gWi = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.gWj = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.gWk = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.gWa = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.gWp = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.gWq = this.mRootView.findViewById(d.g.quick_reply_comment_layout);
        this.gWq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.gWq.setVisibility(4);
                    if (VideoPlayFragment.this.gWz != null && VideoPlayFragment.this.gWz.DD() != null) {
                        VideoPlayFragment.this.gWz.DD().lM();
                    }
                    if (VideoPlayFragment.this.gWl != null) {
                        al alVar = new al("c13025");
                        alVar.ac("tid", VideoPlayFragment.this.gWl.thread_id);
                        alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                        alVar.ac(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.gWl.forum_id);
                        TiebaStatic.log(alVar);
                    }
                }
            }
        });
        this.gWr = (TextView) this.mRootView.findViewById(d.g.quick_reply_comment_text);
        this.gWm = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.gWm.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.gWm.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.gWm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ax.wf().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bzC();
        this.gVX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoPlayFragment.this.gWl != null && VideoPlayFragment.this.gWl.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.gWl.author_info.user_id) && VideoPlayFragment.this.gWl != null && VideoPlayFragment.this.gWl.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.gWl.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(c, z, false)));
                    al alVar = new al("c12798");
                    alVar.ac("tid", VideoPlayFragment.this.gWl.thread_id);
                    alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(alVar);
                }
            }
        });
        this.gWj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoPlayFragment.this.gWl != null && VideoPlayFragment.this.gWl.act_info != null) {
                    com.baidu.tbadk.browser.a.N(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.gWl.act_info.link_url);
                    al alVar = new al("c12799");
                    alVar.ac("tid", VideoPlayFragment.this.gWl.thread_id);
                    alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(alVar);
                }
            }
        });
        this.gWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoPlayFragment.this.bzA();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoPlayFragment.this.gWl != null && !StringUtils.isNull(VideoPlayFragment.this.gWl.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.gWl.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.biL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoPlayFragment.this.bzB();
            }
        });
        this.gVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoPlayFragment.this.bzA();
                al alVar = new al("c12796");
                alVar.ac("tid", VideoPlayFragment.this.gWl.thread_id);
                alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(alVar);
            }
        });
        this.gVY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoPlayFragment.this.uB(VideoPlayFragment.this.gVT);
            }
        });
        this.gWa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoPlayFragment.this.xc();
                al alVar = new al("c12797");
                alVar.ac("tid", VideoPlayFragment.this.gWl.thread_id);
                alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(alVar);
            }
        });
        this.gWb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (az.aK(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.gWl != null && VideoPlayFragment.this.gWl.author_info != null) {
                    VideoPlayFragment.this.ait.a(true, VideoPlayFragment.this.gWl.author_info.portrait, VideoPlayFragment.this.gWl.author_info.user_id, false, "6", VideoPlayFragment.this.aBL, VideoPlayFragment.this.gWl.forum_id, "0");
                    VideoPlayFragment.this.gWl.author_info.is_follow = "1";
                    VideoPlayFragment.this.bzD();
                }
            }
        });
        this.gWn = new AlphaAnimation(1.0f, 0.0f);
        this.gWn.setDuration(100L);
        this.gWn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.gVW != null) {
                    VideoPlayFragment.this.gVW.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.gWs = this.mRect.right - this.mRect.left;
            this.gWt = this.mRect.bottom - this.mRect.top;
            this.gVW.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.gVW.getWidth();
                    int height = VideoPlayFragment.this.gVW.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.gWl.video_height, 0) > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.gWl.video_width, 0) > 0) {
                        float f3 = width / height;
                        float b = com.baidu.adp.lib.g.b.b(VideoPlayFragment.this.gWl.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(VideoPlayFragment.this.gWl.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f3) > 0.05d) {
                            if (b > f3) {
                                i = (int) (width / b);
                                i2 = width;
                            } else {
                                i2 = (int) (height * b);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.gWs, VideoPlayFragment.this.gWt);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.gVW.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.gWt > 0 || VideoPlayFragment.this.gWs <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.gWs;
                                f = i / VideoPlayFragment.this.gWt;
                            }
                            VideoPlayFragment.this.gVW.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.gVW.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.mIsVisible) {
                                        if (VideoPlayFragment.this.gWy) {
                                            VideoPlayFragment.this.gWy = b.getInstance().getBoolean("video_play_vertical_first_in", true);
                                        }
                                        if (!VideoPlayFragment.this.gWy) {
                                            VideoPlayFragment.this.startPlay();
                                        }
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.gWs, VideoPlayFragment.this.gWt);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.gVW.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.gWt > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.gVW.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.gVW.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (VideoPlayFragment.this.gWy) {
                                    VideoPlayFragment.this.gWy = b.getInstance().getBoolean("video_play_vertical_first_in", true);
                                }
                                if (!VideoPlayFragment.this.gWy) {
                                    VideoPlayFragment.this.startPlay();
                                }
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.gVW.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.gVW.getWidth();
                    int height = VideoPlayFragment.this.gVW.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.gWl.video_height, 0) > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.gWl.video_width, 0) > 0) {
                        float f = width / height;
                        float b = com.baidu.adp.lib.g.b.b(VideoPlayFragment.this.gWl.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(VideoPlayFragment.this.gWl.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f) > 0.05d) {
                            if (b > f) {
                                height = (int) (width / b);
                            } else {
                                width = (int) (height * b);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.gVW.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.gVW.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.mIsVisible) {
            bzy();
        }
        return this.mRootView;
    }

    private void initEditor() {
        this.gWz = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().aO(getActivity());
        if (this.gWz != null && this.gWl != null) {
            this.gWz.setContext(getPageContext());
            this.gWz.J(this.gWl.thread_id, this.gWl.forum_id, this.gWl.forum_name);
            this.gWz.a(new a.InterfaceC0231a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0231a
                public void nf(boolean z) {
                    VideoPlayFragment.this.gWq.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.gWr.setText(d.k.reply_something);
                    } else {
                        VideoPlayFragment.this.gWr.setText(StringUtils.isNull(((c) VideoPlayFragment.this.gWz.DD().eI(28)).getInputView().getText().toString()) ? d.k.reply_something : d.k.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.gWl != null && z) {
                        VideoPlayFragment.this.gWe.setText(an.B(com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.gWl.comment_num, 0L) + 1));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.gWz.DD(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        if (this.gWl != null) {
            String str = this.gWl.forum_id;
            String str2 = this.gWl.forum_name;
            String str3 = this.gWl.title;
            String str4 = this.gWl.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.gWl.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.k.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.awZ = "";
            dVar.linkUrl = str5;
            dVar.abV = 2;
            dVar.extData = str4;
            dVar.axc = 3;
            dVar.fid = str;
            dVar.awU = str2;
            dVar.tid = str4;
            dVar.awR = true;
            dVar.axb = 0;
            dVar.axd = 2;
            if (parse != null) {
                dVar.awW = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.gWl.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.gWl.title;
            originalThreadInfo.threadId = this.gWl.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.axc);
            bundle.putInt("obj_type", dVar.axd);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.abV);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.d.d.ahh().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.dyy) {
            this.cqN = new ForumManageModel(getPageContext());
            this.cqN.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.cqN.getLoadDataMode()) {
                            case 0:
                                VideoPlayFragment.this.getActivity().finish();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
        this.eHB = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.eHB != null) {
            this.eHB.a(new a.InterfaceC0082a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0082a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.eHB != null) {
                            VideoPlayFragment.this.eHB.ae(z2);
                        }
                        if (z2) {
                            VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(d.k.add_mark));
                            return;
                        } else {
                            VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(d.k.remove_mark));
                            return;
                        }
                    }
                    VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(d.k.update_mark_failed));
                }
            });
        }
        this.ait = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        bzC();
        if (Build.VERSION.SDK_INT >= 17) {
            this.gVV.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.tieba.play.g.e
                public boolean a(g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.mIsVisible && i == 3 && VideoPlayFragment.this.gVW.getVisibility() == 0) {
                        VideoPlayFragment.this.gVW.clearAnimation();
                        VideoPlayFragment.this.gVW.startAnimation(VideoPlayFragment.this.gWn);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.gVV.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (VideoPlayFragment.this.gVV != null) {
                    VideoPlayFragment.this.gVV.seekTo(0);
                    VideoPlayFragment.this.gVV.start();
                    VideoPlayFragment.this.afi();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB(int i) {
        int i2;
        if (az.aK(getActivity()) && this.gWl != null) {
            if (i == this.gVT) {
                if ("1".equals(this.gWl.is_agreed)) {
                    i2 = 1;
                    this.gWl.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.gWl.agree_num, 0) - 1);
                    this.gWl.is_agreed = "0";
                } else {
                    this.gWl.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.gWl.agree_num, 0) + 1);
                    this.gWl.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.gWl.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.gWl.agree_num, 0) + 1);
                this.gWl.is_agreed = "1";
                i2 = 0;
            }
            al alVar = new al("c12795");
            alVar.ac("tid", this.gWl.thread_id);
            alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.gVT) {
                alVar.r("obj_type", i2);
            } else {
                alVar.r("obj_type", 2);
            }
            TiebaStatic.log(alVar);
            bzC();
            if (this.gWo != null && i2 == 0) {
                this.gWo.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.gWl.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.gWl));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.gWl != null && !StringUtils.isNull(this.gWl.video_url)) {
            ut(this.gWl.video_url);
            this.aOW = true;
            if (this.mIsVisible) {
                if (this.gWy) {
                    this.gWy = b.getInstance().getBoolean("video_play_vertical_first_in", true);
                }
                if (!this.gWy) {
                    afi();
                    aLC();
                }
                if (this.gWl != null && this.mRect != null) {
                    al alVar = new al("c12794");
                    alVar.ac("tid", this.gWl.thread_id);
                    alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    alVar.r("obj_type", 0);
                    TiebaStatic.log(alVar);
                    return;
                }
                return;
            }
            pausePlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        pausePlay();
        if (this.gWz != null && this.gWz.DD() != null) {
            this.gWz.DD().hide();
        }
        this.gWq.setVisibility(0);
        this.gWr.setText(StringUtils.isNull(((c) this.gWz.DD().eI(28)).getInputView().getText().toString()) ? d.k.reply_something : d.k.draft_to_replay);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        stopPlay();
        if (this.gWz != null) {
            this.gWz.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisible = z;
        if (this.aOW) {
            if (this.mIsVisible) {
                if (this.gWl != null && this.mRect == null) {
                    al alVar = new al("c12794");
                    alVar.ac("tid", this.gWl.thread_id);
                    alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    alVar.r("obj_type", 1);
                    TiebaStatic.log(alVar);
                }
                if (this.gWy) {
                    this.gWy = b.getInstance().getBoolean("video_play_vertical_first_in", true);
                }
                if (!this.gWy) {
                    startPlay();
                }
                bzy();
                return;
            }
            pausePlay();
        }
    }

    private void bzy() {
        if (this.gWl != null) {
            al alVar = new al("c12590");
            alVar.ac("tid", this.gWl.thread_id);
            alVar.ac(ImageViewerConfig.FORUM_ID, this.gWl.forum_id);
            alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            alVar.r("obj_locate", this.gWu);
            alVar.ac("cuid", TbadkCoreApplication.getInst().getCuid());
            alVar.r("obj_param2", 1);
            alVar.ac("obj_param1", this.gWl.mRecomWeight);
            alVar.ac("extra", this.gWl.mRecomExtra);
            alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.XN);
            alVar.ac("ab_tag", this.gWl.mRecomAbTag);
            alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.gWl.mRecomSource);
            alVar.r("is_vertical", 1);
            TiebaStatic.log(alVar);
        }
    }

    private void ut(String str) {
        if (this.gVV != null) {
            this.gVV.setRecoveryState(0);
            this.gVV.setVideoPath(str, this.gWl.thread_id);
        }
    }

    public void bzz() {
        if (this.gWy) {
            this.gWy = false;
            if (this.mIsVisible) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || f.bvU().bvV() || bzF()) {
            bgc();
            if (this.gWh != null) {
                this.gWh.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.gVW.getVisibility() == 0) {
                this.gVW.clearAnimation();
                this.gVW.startAnimation(this.gWn);
            }
            if (this.gVV != null) {
                this.gVV.seekTo(0);
                this.gVV.start();
                afi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afi() {
        if (this.gWl != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.aNv = this.gWl.thread_id;
            yVar.csP = this.gWl.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.gWl.mRecomSource;
            yVar.fRP = this.gWl.mRecomAbTag;
            yVar.fRQ = this.gWl.mRecomWeight;
            yVar.fRR = "";
            yVar.XN = "";
            yVar.fRT = this.gWl.mMd5;
            if (this.mRect != null) {
                yVar.fRU = "1";
            } else {
                yVar.fRU = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.fRV = "1";
                yVar.mLocate = "auto_midpage";
                yVar.fRR = "index";
            }
            com.baidu.tieba.play.l.a(this.gWl.mMd5, "", "1", yVar);
        }
    }

    private void bgc() {
        if (j.gR()) {
            f.bvU().cb(getContext());
        }
    }

    private void pausePlay() {
        if (this.gVV != null) {
            this.gVV.pause();
        }
    }

    private void stopPlay() {
        this.gVV.setRecoveryState(5);
        this.gVV.stopPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzA() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.gWl.thread_id, this.gWl.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.gWl.forum_id));
        createNormalCfg.setForumName(this.gWl.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzB() {
        if (this.cqE == null) {
            this.cqF = new com.baidu.tieba.view.a(getActivity());
            ArrayList arrayList = new ArrayList();
            a.C0232a c0232a = new a.C0232a(this.cqF);
            c0232a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.cqE.dismiss();
                    if (VideoPlayFragment.this.gWl != null) {
                        boolean z = VideoPlayFragment.this.gWl.post_id != null && VideoPlayFragment.this.gWl.post_id.equals(VideoPlayFragment.this.gWl.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.gWl.thread_id);
                        markData.setPostId(VideoPlayFragment.this.gWl.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.gWl.thread_id);
                        markData.setForumId(VideoPlayFragment.this.gWl.forum_id);
                        if (VideoPlayFragment.this.eHB != null) {
                            VideoPlayFragment.this.eHB.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.eHB.oJ();
                            } else {
                                VideoPlayFragment.this.eHB.oI();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.gWl != null && this.gWl.post_id != null && this.gWl.post_id.equals(this.gWl.mark_id)) {
                z = true;
            }
            if (z) {
                c0232a.setText(getResources().getString(d.k.remove_mark));
            } else {
                c0232a.setText(getResources().getString(d.k.mark));
            }
            arrayList.add(c0232a);
            a.C0232a c0232a2 = new a.C0232a(getActivity().getString(d.k.delete), this.cqF);
            c0232a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.cqE.dismiss();
                    if (az.aK(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.gWl != null) {
                        String str = VideoPlayFragment.this.gWl.thread_id;
                        String str2 = VideoPlayFragment.this.gWl.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(d.k.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.gWl.post_id, true)));
                    }
                }
            });
            c0232a2.setText(getResources().getString(d.k.report_text));
            arrayList.add(c0232a2);
            if (this.dyy) {
                a.C0232a c0232a3 = new a.C0232a(getActivity().getString(d.k.delete), this.cqF);
                c0232a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.cqE.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.ca(d.k.del_thread_confirm);
                        aVar.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.gWl != null) {
                                    VideoPlayFragment.this.cqN.a(VideoPlayFragment.this.gWl.forum_id, VideoPlayFragment.this.gWl.forum_name, VideoPlayFragment.this.gWl.thread_id, VideoPlayFragment.this.gWl.post_id, 0, 0, VideoPlayFragment.this.dyy);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                                }
                            }
                        });
                        aVar.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.ar(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.tC();
                    }
                });
                c0232a3.setText(getResources().getString(d.k.delete));
                arrayList.add(c0232a3);
            }
            this.cqF.dI(arrayList);
            this.cqE = new e(getActivity(), this.cqF.bAa());
        }
        this.cqE.show();
    }

    private void bzC() {
        if (this.gWl != null) {
            this.gVW.startLoad(this.gWl.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.gWl.title);
            if (StringUtils.isNull(this.gWl.title) || matcher.matches()) {
                this.gWc.setVisibility(8);
            } else {
                this.gWc.setVisibility(0);
                this.gWc.setText(this.gWl.title);
            }
            this.gWe.setText(an.B(com.baidu.adp.lib.g.b.c(this.gWl.comment_num, 0L)));
            this.gWf.setText(an.B(com.baidu.adp.lib.g.b.c(this.gWl.agree_num, 0L)));
            this.gWg.setText(an.B(com.baidu.adp.lib.g.b.c(this.gWl.share_num, 0L)));
            if (this.gWl.author_info != null) {
                if (!StringUtils.isNull(this.gWl.author_info.portrait) && this.gWl.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.gVX.startLoad(this.gWl.author_info.portrait, 10, false);
                } else {
                    this.gVX.startLoad(this.gWl.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.gWl.author_info.bvQ())) {
                    this.gWp.setVisibility(8);
                } else {
                    this.gWp.setVisibility(0);
                    this.gWp.setText("@" + this.gWl.author_info.bvQ());
                }
            }
            if ("1".equals(this.gWl.is_private) && this.gWm.getVisibility() != 0) {
                this.gWk.setVisibility(0);
            } else {
                this.gWk.setVisibility(8);
            }
            if ("1".equals(this.gWl.is_agreed)) {
                ak.c(this.gWo, d.f.icon_home_card_like_s);
            } else {
                ak.c(this.gWo, d.f.btn_video_agree);
            }
            if (this.gWl.act_info != null && !StringUtils.isNull(this.gWl.act_info.activity_name) && this.gWm.getVisibility() != 0) {
                this.gWj.setVisibility(0);
                this.gWd.setText(this.gWl.act_info.activity_name);
            } else {
                this.gWj.setVisibility(8);
            }
            bzD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzD() {
        if (this.dyy || (this.gWl.author_info != null && !"0".equals(this.gWl.author_info.is_follow))) {
            this.gWb.setVisibility(4);
            this.gWb.setClickable(false);
            return;
        }
        this.gWb.setVisibility(0);
        this.gWb.setClickable(true);
    }

    private void bzE() {
        if (this.gWA == null || !this.gWA.isShowing()) {
            this.gWA = new com.baidu.tbadk.core.dialog.a(getActivity());
            View inflate = LayoutInflater.from(getActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.a(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            this.gWA.w(inflate);
            this.gWA.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                    VideoPlayFragment.this.startPlay();
                }
            });
            this.gWA.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gWA.cc(1);
            this.gWA.cb(d.C0126d.cp_cont_b);
            this.gWA.ar(true);
            this.gWA.b(getPageContext());
            this.gWA.tC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzF() {
        if (!j.gP() || j.gQ()) {
            return true;
        }
        if (!this.mIsVisible || f.bvU().bvV()) {
            return false;
        }
        if (this.gWh != null) {
            this.gWh.setVisibility(0);
        }
        pausePlay();
        bzE();
        return false;
    }

    private void aLC() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bzF() || f.bvU().bvV()) && this.gVV != null && this.gWh != null) {
            this.gVV.start();
            this.gWh.setVisibility(8);
            bgc();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.apc == null) {
            this.apc = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.apc.setDuration(200L);
        }
        return this.apc;
    }

    public long bzG() {
        if (this.gWi != null) {
            this.gWi.setVisibility(8);
        }
        if (this.gWm != null) {
            this.gWm.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }

    @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
    public void bzt() {
        if (this.gVV.isPlaying()) {
            this.gVV.pause();
            this.gWh.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bzF() || f.bvU().bvV()) {
            this.gVV.start();
            this.gWh.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
    public void n(float f, float f2) {
        if (az.aK(getActivity()) && !this.gWv) {
            bzH();
            if (this.gWl != null && "0".equals(this.gWl.is_agreed)) {
                uB(this.gVU);
            }
        }
    }

    private void bzH() {
        if (this.mRootView != null) {
            this.gWv = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(d.f.icon_video_like);
            if (this.gWx == null) {
                this.gWx = new RelativeLayout.LayoutParams(-2, -2);
                this.gWx.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.gWx);
            }
            if (this.gWw == null) {
                this.gWw = new AnimatorSet();
                this.gWw.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.gWv = false;
                        if (VideoPlayFragment.this.mRootView instanceof RelativeLayout) {
                            ((RelativeLayout) VideoPlayFragment.this.mRootView).removeView(imageView);
                        }
                    }
                });
            }
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.08f, 1.0f);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.08f, 1.0f);
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, ofFloat, ofFloat2);
            ofPropertyValuesHolder.setDuration(500L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(imageView, ofFloat3);
            ofPropertyValuesHolder2.setDuration(300L);
            ofPropertyValuesHolder2.setStartDelay(500L);
            this.gWw.setTarget(imageView);
            this.gWw.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.gWw.start();
        }
    }

    @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
    public void bzv() {
        if (this.gWl != null && this.gWl.author_info != null) {
            long c = com.baidu.adp.lib.g.b.c(this.gWl.author_info.user_id, 0L);
            long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = c == c2;
            if (c == 0 && c2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(c, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.gVV != null) {
            return this.gVV.getMediaIDs();
        }
        return null;
    }

    public String bzI() {
        if (this.gVV != null) {
            return this.gVV.getMediaId();
        }
        return null;
    }

    public boolean bzJ() {
        if (this.gWz == null || this.gWz.DD() == null || !this.gWz.DD().isVisible()) {
            return false;
        }
        this.gWz.DD().hide();
        this.gWq.setVisibility(0);
        if ((this.gWz.DD().eI(28) instanceof c) && ((c) this.gWz.DD().eI(28)).getInputView() != null && ((c) this.gWz.DD().eI(28)).getInputView().getText() != null) {
            this.gWr.setText(StringUtils.isNull(((c) this.gWz.DD().eI(28)).getInputView().getText().toString()) ? d.k.reply_something : d.k.draft_to_replay);
        }
        return true;
    }

    public void b(int i, int i2, Intent intent) {
        if (this.gWz != null) {
            this.gWz.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        b(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gWz != null && this.gWz.DD() != null) {
            this.gWz.DD().onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.k.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
