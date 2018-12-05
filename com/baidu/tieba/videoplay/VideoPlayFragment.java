package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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
import android.view.animation.AnimationUtils;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.e;
import com.baidu.tieba.person.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.editor.a;
import com.baidu.tieba.videoplay.editor.c;
import com.baidu.tieba.view.a;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0180a {
    private boolean UI;
    private String aEN;
    private e ane;
    private String arh;
    public ImageView bLW;
    private n bOp;
    private AlphaAnimation bRS;
    private String bUG;
    private com.baidu.tieba.view.a cVA;
    private View dyl;
    private boolean eni;
    private QuickVideoView.c gCG;
    private j.b gCq;
    public QuickVideoView hKP;
    private TbImageView hKQ;
    public HeadImageView hKR;
    public LinearLayout hKS;
    public LinearLayout hKT;
    public LinearLayout hKU;
    public ImageView hKV;
    public ImageView hKW;
    public ImageView hKX;
    public TextView hKY;
    public TextView hKZ;
    public TextView hLa;
    public TextView hLb;
    public TextView hLc;
    public ImageView hLd;
    private LinearLayout hLe;
    public LinearLayout hLf;
    public LinearLayout hLg;
    public VideoItemData hLh;
    private TextView hLi;
    private boolean hLj;
    public ImageView hLk;
    public TextView hLl;
    private View hLm;
    private TextView hLn;
    private int hLo;
    private int hLp;
    private int hLq;
    protected Animation hLr;
    private boolean hLs;
    private AnimatorSet hLt;
    private RelativeLayout.LayoutParams hLu;
    private com.baidu.tieba.videoplay.editor.a hLw;
    com.baidu.tbadk.core.dialog.a hLx;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int hKN = 0;
    private int hKO = 1;
    private ForumManageModel cVI = null;
    private com.baidu.tbadk.baseEditMark.a fSW = null;
    private com.baidu.tbadk.coreExtra.model.a aCb = null;
    private BdUniqueId aBS = BdUniqueId.gen();
    private boolean hLv = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.hLh != null && VideoPlayFragment.this.hLh.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hLh.author_info.user_id) && data != null && VideoPlayFragment.this.hLh.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aBS)) ? false : false;
                    if (data.aPr == null) {
                        if (!data.Jr) {
                            if (z && !"0".equals(VideoPlayFragment.this.hLh.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_fail);
                                VideoPlayFragment.this.hLh.author_info.is_follow = "0";
                                VideoPlayFragment.this.bLy();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.hLj) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.hLh));
                                    return;
                                }
                                VideoPlayFragment.this.hLh.author_info.is_follow = "1";
                                VideoPlayFragment.this.bLy();
                            }
                        } else {
                            VideoPlayFragment.this.hLh.author_info.is_follow = "0";
                            VideoPlayFragment.this.bLy();
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
                VideoPlayFragment.this.bLA();
            }
        }
    };

    static /* synthetic */ int x(VideoPlayFragment videoPlayFragment) {
        int i = videoPlayFragment.playTime;
        videoPlayFragment.playTime = i + 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.hLh = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hLq = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.bUG = arguments.getString("from");
        this.arh = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.hLh != null && this.hLh.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hLh.author_info.user_id)) {
            this.eni = true;
        }
        this.bOp = new n(getActivity());
        this.bOp.a(this.hLh);
        this.bOp.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bC(int i, int i2) {
                if (VideoPlayFragment.this.gCq != null) {
                    VideoPlayFragment.this.gCq.bC(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(e.h.video_play_view, (ViewGroup) null);
        this.hKP = (QuickVideoView) this.mRootView.findViewById(e.g.videoView);
        this.hKP.setPlayerReuseEnable(true);
        this.hKP.setContinuePlayEnable(true);
        this.hKP.setBusiness(this.bOp);
        this.hKP.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.gCG != null) {
                    VideoPlayFragment.this.gCG.onStart();
                }
            }
        });
        this.hKP.setNeedRecovery(true);
        if (this.hLh != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.biw = this.hLh.thread_id;
            zVar.cXO = this.hLh.forum_id;
            zVar.gER = this.hLh.mMd5;
            zVar.arh = "";
            zVar.mSource = this.hLh.mRecomSource;
            zVar.gEQ = this.hLh.mRecomAbTag;
            zVar.gEO = this.hLh.mRecomWeight;
            if (this.mRect != null) {
                zVar.gES = "1";
            } else {
                zVar.gES = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.gET = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.gEP = this.bUG;
                zVar.arh = this.arh;
                zVar.gEN = this.hLh.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.bOp.setVideoStatsData(zVar);
        }
        this.hKQ = (TbImageView) this.mRootView.findViewById(e.g.video_cover);
        this.hKQ.setDefaultBgResource(e.f.icon_play_bg);
        this.hKQ.setDefaultErrorResource(e.f.icon_play_bg);
        if (g.CF()) {
            this.dyl = this.mRootView.findViewById(e.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.dyl.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dyl.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(e.g.back_btn);
        this.bLW = (ImageView) this.mRootView.findViewById(e.g.more_btn);
        this.hKR = (HeadImageView) this.mRootView.findViewById(e.g.author_portrait);
        this.hKR.setDefaultResource(17170445);
        this.hKR.setDefaultBgResource(e.d.cp_bg_line_e);
        this.hKR.setIsRound(true);
        this.hKV = (ImageView) this.mRootView.findViewById(e.g.love_btn);
        this.hLk = (ImageView) this.mRootView.findViewById(e.g.agree_img);
        this.hKY = (TextView) this.mRootView.findViewById(e.g.video_title);
        this.hKZ = (TextView) this.mRootView.findViewById(e.g.video_activity);
        this.hKT = (LinearLayout) this.mRootView.findViewById(e.g.comment_container);
        this.hLa = (TextView) this.mRootView.findViewById(e.g.comment_num);
        this.hKS = (LinearLayout) this.mRootView.findViewById(e.g.agree_container);
        this.hLb = (TextView) this.mRootView.findViewById(e.g.agree_num);
        this.hLc = (TextView) this.mRootView.findViewById(e.g.share_num);
        this.hKW = (ImageView) this.mRootView.findViewById(e.g.share_img);
        this.hKX = (ImageView) this.mRootView.findViewById(e.g.share_img_changed);
        bLt();
        this.hLd = (ImageView) this.mRootView.findViewById(e.g.play_btn);
        this.hLe = (LinearLayout) this.mRootView.findViewById(e.g.video_act_private_container);
        this.hLf = (LinearLayout) this.mRootView.findViewById(e.g.video_activity_container);
        this.hLg = (LinearLayout) this.mRootView.findViewById(e.g.video_private);
        this.hKU = (LinearLayout) this.mRootView.findViewById(e.g.share_container);
        this.hLl = (TextView) this.mRootView.findViewById(e.g.video_author_name);
        this.hLm = this.mRootView.findViewById(e.g.quick_reply_comment_layout);
        this.hLm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.hLm.setVisibility(4);
                    if (VideoPlayFragment.this.hLw != null && VideoPlayFragment.this.hLw.LX() != null) {
                        VideoPlayFragment.this.hLw.LX().pN();
                    }
                    if (VideoPlayFragment.this.hLh != null) {
                        am amVar = new am("c13025");
                        amVar.aA("tid", VideoPlayFragment.this.hLh.thread_id);
                        amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.aA(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.hLh.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.hLn = (TextView) this.mRootView.findViewById(e.g.quick_reply_comment_text);
        this.hLi = (TextView) this.mRootView.findViewById(e.g.download_nani_guide_txt);
        this.hLi.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hLi.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.hLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.Ef().a((TbPageContext) i.aK(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bLx();
        this.hKR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hLh != null && VideoPlayFragment.this.hLh.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hLh.author_info.user_id) && VideoPlayFragment.this.hLh != null && VideoPlayFragment.this.hLh.author_info != null) {
                    long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.hLh.author_info.user_id, 0L);
                    long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = d == d2;
                    if (d == 0 && d2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(d, z, false)));
                    am amVar = new am("c12798");
                    amVar.aA("tid", VideoPlayFragment.this.hLh.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hLf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hLh != null && VideoPlayFragment.this.hLh.act_info != null) {
                    com.baidu.tbadk.browser.a.af(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.hLh.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.aA("tid", VideoPlayFragment.this.hLh.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hKY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bLv();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hLh != null && !StringUtils.isNull(VideoPlayFragment.this.hLh.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.hLh.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.bLW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bLw();
            }
        });
        this.hKT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bLv();
                am amVar = new am("c12796");
                amVar.aA("tid", VideoPlayFragment.this.hLh.thread_id);
                amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hKS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.wI(VideoPlayFragment.this.hKN);
            }
        });
        this.hKU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Fp();
                am amVar = new am("c12797");
                amVar.aA("tid", VideoPlayFragment.this.hLh.thread_id);
                amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hLh != null && VideoPlayFragment.this.hLh.author_info != null) {
                    VideoPlayFragment.this.aCb.a(true, VideoPlayFragment.this.hLh.author_info.portrait, VideoPlayFragment.this.hLh.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.aBS, VideoPlayFragment.this.hLh.forum_id, "0");
                    VideoPlayFragment.this.hLh.author_info.is_follow = "1";
                    VideoPlayFragment.this.bLy();
                }
            }
        });
        this.bRS = new AlphaAnimation(1.0f, 0.0f);
        this.bRS.setDuration(100L);
        this.bRS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.hKQ != null) {
                    VideoPlayFragment.this.hKQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.hLo = this.mRect.right - this.mRect.left;
            this.hLp = this.mRect.bottom - this.mRect.top;
            this.hKQ.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.hKQ.getWidth();
                    int height = VideoPlayFragment.this.hKQ.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hLh.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hLh.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hLh.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hLh.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hLo, VideoPlayFragment.this.hLp);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.hKQ.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hLp > 0 || VideoPlayFragment.this.hLo <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.hLo;
                                f = i / VideoPlayFragment.this.hLp;
                            }
                            VideoPlayFragment.this.hKQ.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.hKQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.hLj) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hLo, VideoPlayFragment.this.hLp);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.hKQ.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hLp > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.hKQ.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.hKQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.hLj) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.hKQ.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.hKQ.getWidth();
                    int height = VideoPlayFragment.this.hKQ.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hLh.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hLh.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hLh.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hLh.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.hKQ.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.hKQ.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.hLj) {
            bLu();
        }
        if (this.hLh != null && !StringUtils.isNull(this.hLh.video_url)) {
            xe(this.hLh.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.gCq = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gCG = cVar;
    }

    private void initEditor() {
        this.hLw = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().bM(getActivity());
        if (this.hLw != null && this.hLh != null) {
            this.hLw.setContext(getPageContext());
            this.hLw.R(this.hLh.thread_id, this.hLh.forum_id, this.hLh.forum_name);
            this.hLw.a(new a.InterfaceC0333a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0333a
                public void oj(boolean z) {
                    VideoPlayFragment.this.hLm.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.hLn.setText(e.j.reply_something);
                    } else {
                        VideoPlayFragment.this.hLn.setText(StringUtils.isNull(((c) VideoPlayFragment.this.hLw.LX().fK(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.hLh != null && z) {
                        long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.hLh.comment_num, 0L) + 1;
                        VideoPlayFragment.this.hLh.comment_num = String.valueOf(d);
                        VideoPlayFragment.this.hLa.setText(ao.W(d));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.hLw.LX(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fp() {
        if (this.hLh != null) {
            String str = this.hLh.forum_id;
            String str2 = this.hLh.forum_name;
            String str3 = this.hLh.title;
            String str4 = this.hLh.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hLh.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            d dVar = new d();
            dVar.title = str3;
            dVar.content = format;
            dVar.aSj = "";
            dVar.linkUrl = str5;
            dVar.avK = 2;
            dVar.extData = str4;
            dVar.aSm = 3;
            dVar.fid = str;
            dVar.aSf = str2;
            dVar.tid = str4;
            dVar.aSb = true;
            dVar.aSl = 0;
            dVar.aSn = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hLh.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hLh.title;
            originalThreadInfo.threadId = this.hLh.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aSm);
            bundle.putInt("obj_type", dVar.aSn);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.avK);
            dVar.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.aro().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eni) {
            this.cVI = new ForumManageModel(getPageContext());
            this.cVI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.cVI.getLoadDataMode()) {
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
        this.fSW = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.fSW != null) {
            this.fSW.a(new a.InterfaceC0154a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0154a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.fSW != null) {
                            VideoPlayFragment.this.fSW.aP(z2);
                        }
                        if (VideoPlayFragment.this.hLh != null) {
                            if (z2) {
                                VideoPlayFragment.this.hLh.mark_id = VideoPlayFragment.this.hLh.post_id;
                            } else {
                                VideoPlayFragment.this.hLh.mark_id = null;
                            }
                        }
                        if (z2) {
                            VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(e.j.add_mark));
                            return;
                        } else {
                            VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(e.j.remove_mark));
                            return;
                        }
                    }
                    VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(e.j.update_mark_failed));
                }
            });
        }
        this.aCb = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.hLv = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bLx();
        if (Build.VERSION.SDK_INT >= 17) {
            this.hKP.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.hLj && i == 3 && VideoPlayFragment.this.hKQ.getVisibility() == 0) {
                        VideoPlayFragment.this.hKQ.clearAnimation();
                        VideoPlayFragment.this.hKQ.startAnimation(VideoPlayFragment.this.bRS);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.hKP.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.hKP != null) {
                    VideoPlayFragment.this.hKP.seekTo(0);
                    VideoPlayFragment.this.hKP.start();
                    VideoPlayFragment.this.apm();
                    VideoPlayFragment.x(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.bLs();
                    }
                }
            }
        });
        this.hKP.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.hKQ != null) {
                        VideoPlayFragment.this.hKQ.clearAnimation();
                        VideoPlayFragment.this.hKQ.startAnimation(VideoPlayFragment.this.bRS);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLs() {
        if (this.hKX != null && this.hKW != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.hKW.clearAnimation();
            this.hKX.clearAnimation();
            this.hKW.setVisibility(8);
            this.hKX.setVisibility(0);
            this.hKX.startAnimation(scaleAnimation2);
            this.hKW.startAnimation(scaleAnimation);
        }
    }

    private void bLt() {
        if (this.hKX != null && this.hKW != null) {
            this.hKW.clearAnimation();
            this.hKX.clearAnimation();
            this.hKW.setVisibility(0);
            this.hKX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wI(int i) {
        int i2;
        if (ba.bJ(getActivity()) && this.hLh != null) {
            if (i == this.hKN) {
                if ("1".equals(this.hLh.is_agreed)) {
                    i2 = 1;
                    this.hLh.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hLh.agree_num, 0) - 1);
                    this.hLh.is_agreed = "0";
                } else {
                    this.hLh.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hLh.agree_num, 0) + 1);
                    this.hLh.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.hLh.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hLh.agree_num, 0) + 1);
                this.hLh.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.aA("tid", this.hLh.thread_id);
            amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.hKN) {
                amVar.x("obj_type", i2);
            } else {
                amVar.x("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            bLx();
            if (this.hLk != null && i2 == 0) {
                this.hLk.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hLh.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hLh));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hLh != null && !StringUtils.isNull(this.hLh.video_url)) {
            this.UI = true;
            if (this.hLj) {
                apm();
                aYT();
                if (this.hLh != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.aA("tid", this.hLh.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.x("obj_type", 0);
                    TiebaStatic.log(amVar);
                }
            } else {
                pausePlay();
            }
        }
        if (this.hLh != null && !ao.isEmpty(this.hLh.thread_id)) {
            com.baidu.tbadk.BdToken.c.vu().f(com.baidu.tbadk.BdToken.b.ajV, com.baidu.adp.lib.g.b.d(this.hLh.thread_id, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        stopPlay();
        if (this.hLw != null && this.hLw.LX() != null) {
            this.hLw.LX().hide();
            this.hLm.setVisibility(0);
            this.hLn.setText(StringUtils.isNull(((c) this.hLw.LX().fK(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
            com.baidu.tbadk.BdToken.c.vu().vv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.hLw != null) {
            this.hLw.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.hLj = z;
        if (this.UI) {
            if (this.hLj && (!this.hLv || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.hLh != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.aA("tid", this.hLh.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.x("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                bLu();
                this.hLv = false;
                return;
            }
            bLt();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void bLu() {
        if (this.hLh != null) {
            am amVar = new am("c12590");
            amVar.aA("tid", this.hLh.thread_id);
            amVar.aA(ImageViewerConfig.FORUM_ID, this.hLh.forum_id);
            amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.x("obj_locate", this.hLq);
            amVar.aA("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.x("obj_param2", 1);
            amVar.aA("obj_param1", ao.isEmpty(this.hLh.mRecomWeight) ? "0" : this.hLh.mRecomWeight);
            amVar.aA("extra", ao.isEmpty(this.hLh.mRecomExtra) ? "0" : this.hLh.mRecomExtra);
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, this.arh);
            amVar.aA("ab_tag", ao.isEmpty(this.hLh.mRecomAbTag) ? "0" : this.hLh.mRecomAbTag);
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.hLh.mRecomSource) ? "0" : this.hLh.mRecomSource);
            amVar.aA("obj_type", this.bUG);
            amVar.x("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void xe(String str) {
        if (this.hKP != null && str != null && !str.equals(this.aEN)) {
            this.hKP.setRecoveryState(0);
            this.hKP.setVideoPath(str, this.hLh.thread_id);
            this.aEN = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.bHR().bHS() || bLA()) {
            bqY();
            if (this.hLd != null) {
                this.hLd.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hKQ.getVisibility() == 0) {
                this.hKQ.clearAnimation();
                this.hKQ.startAnimation(this.bRS);
            }
            if (this.hKP != null) {
                this.hKP.start();
                apm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apm() {
        if (this.hLh != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.biw = this.hLh.thread_id;
            zVar.cXO = this.hLh.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.hLh.mRecomSource;
            zVar.gEN = this.hLh.mRecomAbTag;
            zVar.gEO = this.hLh.mRecomWeight;
            zVar.gEP = "";
            zVar.arh = "";
            zVar.gER = this.hLh.mMd5;
            if (this.mRect != null) {
                zVar.gES = "1";
            } else {
                zVar.gES = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.gET = "1";
                zVar.mLocate = "auto_midpage";
                zVar.gEP = "index";
            }
            com.baidu.tieba.play.l.a(this.hLh.mMd5, "", "1", zVar);
        }
    }

    private void bqY() {
        if (com.baidu.adp.lib.util.j.kX()) {
            com.baidu.tieba.video.g.bHR().dc(getContext());
        }
    }

    private void pausePlay() {
        if (this.hKP != null) {
            this.hKP.pause();
        }
    }

    private void stopPlay() {
        if (this.hKP != null) {
            this.hKP.setRecoveryState(5);
            this.hKP.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLv() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hLh.thread_id, this.hLh.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hLh.forum_id));
        createNormalCfg.setForumName(this.hLh.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLw() {
        if (this.ane == null) {
            this.cVA = new com.baidu.tieba.view.a(getActivity());
            this.ane = new com.baidu.tieba.person.e(getActivity(), this.cVA.bLZ());
            this.ane.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.hKP.setSystemUiVisibility(4);
                }
            });
        }
        if (this.cVA != null) {
            ArrayList arrayList = new ArrayList();
            a.C0334a c0334a = new a.C0334a(this.cVA);
            c0334a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.ane.dismiss();
                    if (VideoPlayFragment.this.hLh != null) {
                        boolean z = VideoPlayFragment.this.hLh.post_id != null && VideoPlayFragment.this.hLh.post_id.equals(VideoPlayFragment.this.hLh.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.hLh.thread_id);
                        markData.setPostId(VideoPlayFragment.this.hLh.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.hLh.thread_id);
                        markData.setForumId(VideoPlayFragment.this.hLh.forum_id);
                        if (VideoPlayFragment.this.fSW != null) {
                            VideoPlayFragment.this.fSW.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.fSW.ws();
                            } else {
                                VideoPlayFragment.this.fSW.wr();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hLh != null && this.hLh.post_id != null && this.hLh.post_id.equals(this.hLh.mark_id)) {
                z = true;
            }
            if (z) {
                c0334a.setText(getResources().getString(e.j.remove_mark));
            } else {
                c0334a.setText(getResources().getString(e.j.mark));
            }
            arrayList.add(c0334a);
            a.C0334a c0334a2 = new a.C0334a(getActivity().getString(e.j.delete), this.cVA);
            c0334a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.ane.dismiss();
                    if (ba.bJ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hLh != null) {
                        String str = VideoPlayFragment.this.hLh.thread_id;
                        String str2 = VideoPlayFragment.this.hLh.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(e.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.hLh.post_id, true)));
                    }
                }
            });
            c0334a2.setText(getResources().getString(e.j.report_text));
            arrayList.add(c0334a2);
            if (this.eni) {
                a.C0334a c0334a3 = new a.C0334a(getActivity().getString(e.j.delete), this.cVA);
                c0334a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.ane.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.db(e.j.del_thread_confirm);
                        aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.hLh != null) {
                                    VideoPlayFragment.this.cVI.a(VideoPlayFragment.this.hLh.forum_id, VideoPlayFragment.this.hLh.forum_name, VideoPlayFragment.this.hLh.thread_id, VideoPlayFragment.this.hLh.post_id, 0, 0, VideoPlayFragment.this.eni);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                                }
                            }
                        });
                        aVar.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.bf(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.BF();
                    }
                });
                c0334a3.setText(getResources().getString(e.j.delete));
                arrayList.add(c0334a3);
            }
            this.cVA.ed(arrayList);
        }
        this.ane.show();
    }

    private void bLx() {
        if (this.hLh != null) {
            this.hKQ.startLoad(this.hLh.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.hLh.title);
            if (StringUtils.isNull(this.hLh.title) || matcher.matches()) {
                this.hKY.setVisibility(8);
            } else {
                this.hKY.setVisibility(0);
                this.hKY.setText(this.hLh.title);
            }
            this.hLa.setText(ao.W(com.baidu.adp.lib.g.b.d(this.hLh.comment_num, 0L)));
            this.hLb.setText(ao.W(com.baidu.adp.lib.g.b.d(this.hLh.agree_num, 0L)));
            this.hLc.setText(ao.W(com.baidu.adp.lib.g.b.d(this.hLh.share_num, 0L)));
            if (this.hLh.author_info != null) {
                if (!StringUtils.isNull(this.hLh.author_info.portrait) && this.hLh.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.hKR.startLoad(this.hLh.author_info.portrait, 10, false);
                } else {
                    this.hKR.startLoad(this.hLh.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.hLh.author_info.bHN())) {
                    this.hLl.setVisibility(8);
                } else {
                    this.hLl.setVisibility(0);
                    this.hLl.setText("@" + this.hLh.author_info.bHN());
                }
            }
            if ("1".equals(this.hLh.is_private) && this.hLi.getVisibility() != 0) {
                this.hLg.setVisibility(0);
            } else {
                this.hLg.setVisibility(8);
            }
            if ("1".equals(this.hLh.is_agreed)) {
                al.c(this.hLk, e.f.icon_card_like_white_full_s);
            } else {
                al.c(this.hLk, e.f.btn_video_agree);
            }
            if (this.hLh.act_info != null && !StringUtils.isNull(this.hLh.act_info.activity_name) && this.hLi.getVisibility() != 0) {
                this.hLf.setVisibility(0);
                this.hKZ.setText(this.hLh.act_info.activity_name);
            } else {
                this.hLf.setVisibility(8);
            }
            bLy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLy() {
        if (this.eni || (this.hLh.author_info != null && !"0".equals(this.hLh.author_info.is_follow))) {
            this.hKV.setVisibility(4);
            this.hKV.setClickable(false);
            return;
        }
        this.hKV.setVisibility(0);
        this.hKV.setClickable(true);
    }

    private void bLz() {
        if (getActivity() != null) {
            if (this.hLx == null || !this.hLx.isShowing()) {
                this.hLx = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(e.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(e.g.tv_title)).setText(e.j.confirm_title);
                ((TextView) inflate.findViewById(e.g.tv_msg)).setText(e.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(e.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(e.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.hLx.G(inflate);
                this.hLx.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.hLx.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.hLx.dd(1);
                this.hLx.dc(e.d.cp_cont_b);
                this.hLx.bf(true);
                this.hLx.b(getPageContext());
                this.hLx.BF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bLA() {
        if (!com.baidu.adp.lib.util.j.kV() || com.baidu.adp.lib.util.j.kW()) {
            return true;
        }
        if (!this.hLj || com.baidu.tieba.video.g.bHR().bHS()) {
            return false;
        }
        if (this.hLd != null) {
            this.hLd.setVisibility(0);
        }
        pausePlay();
        bLz();
        return false;
    }

    private void aYT() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bLA() || com.baidu.tieba.video.g.bHR().bHS()) && this.hKP != null && this.hLd != null) {
            this.hKP.start();
            this.hLd.setVisibility(8);
            bqY();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.hLr == null) {
            this.hLr = AnimationUtils.loadAnimation(getContext(), e.a.scale_zoom_in_and_out_anim);
        }
        return this.hLr;
    }

    public long bLB() {
        if (this.hLe != null) {
            this.hLe.setVisibility(8);
        }
        if (this.hLi != null) {
            this.hLi.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
    public void TB() {
        if (this.hKP.isPlaying()) {
            this.hKP.pause();
            this.hLd.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bLA() || com.baidu.tieba.video.g.bHR().bHS()) {
            this.hKP.start();
            this.hLd.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
    public void t(float f, float f2) {
        if (ba.bJ(getActivity()) && !this.hLs) {
            bLC();
            if (this.hLh != null && "0".equals(this.hLh.is_agreed)) {
                wI(this.hKO);
            }
        }
    }

    private void bLC() {
        if (this.mRootView != null) {
            this.hLs = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(e.f.icon_video_like);
            if (this.hLu == null) {
                this.hLu = new RelativeLayout.LayoutParams(-2, -2);
                this.hLu.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.hLu);
            }
            if (this.hLt == null) {
                this.hLt = new AnimatorSet();
                this.hLt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.hLs = false;
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
            this.hLt.setTarget(imageView);
            this.hLt.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.hLt.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
    public void TC() {
        if (this.hLh != null && this.hLh.author_info != null) {
            long d = com.baidu.adp.lib.g.b.d(this.hLh.author_info.user_id, 0L);
            long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = d == d2;
            if (d == 0 && d2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(d, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.hKP != null) {
            return this.hKP.getMediaIDs();
        }
        return null;
    }

    public String bLD() {
        if (this.hKP != null) {
            return this.hKP.getMediaId();
        }
        return null;
    }

    public boolean bLE() {
        if (this.hLw == null || this.hLw.LX() == null || !this.hLw.LX().isVisible()) {
            return false;
        }
        this.hLw.LX().hide();
        this.hLm.setVisibility(0);
        if ((this.hLw.LX().fK(28) instanceof c) && ((c) this.hLw.LX().fK(28)).getInputView() != null && ((c) this.hLw.LX().fK(28)).getInputView().getText() != null) {
            this.hLn.setText(StringUtils.isNull(((c) this.hLw.LX().fK(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.hLw != null) {
            this.hLw.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hLw != null && this.hLw.LX() != null) {
            this.hLw.LX().onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }
}
