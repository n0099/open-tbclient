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
    private String aEO;
    private e ane;
    private String arh;
    public ImageView bLZ;
    private n bOs;
    private AlphaAnimation bRV;
    private String bUJ;
    private com.baidu.tieba.view.a cYq;
    private View dAY;
    private boolean epZ;
    private j.b gFh;
    private QuickVideoView.c gFx;
    private int hOA;
    private int hOB;
    protected Animation hOC;
    private boolean hOD;
    private AnimatorSet hOE;
    private RelativeLayout.LayoutParams hOF;
    private com.baidu.tieba.videoplay.editor.a hOH;
    com.baidu.tbadk.core.dialog.a hOI;
    public QuickVideoView hOa;
    private TbImageView hOb;
    public HeadImageView hOc;
    public LinearLayout hOd;
    public LinearLayout hOe;
    public LinearLayout hOf;
    public ImageView hOg;
    public ImageView hOh;
    public ImageView hOi;
    public TextView hOj;
    public TextView hOk;
    public TextView hOl;
    public TextView hOm;
    public TextView hOn;
    public ImageView hOo;
    private LinearLayout hOp;
    public LinearLayout hOq;
    public LinearLayout hOr;
    public VideoItemData hOs;
    private TextView hOt;
    private boolean hOu;
    public ImageView hOv;
    public TextView hOw;
    private View hOx;
    private TextView hOy;
    private int hOz;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int hNY = 0;
    private int hNZ = 1;
    private ForumManageModel cYy = null;
    private com.baidu.tbadk.baseEditMark.a fVO = null;
    private com.baidu.tbadk.coreExtra.model.a aCb = null;
    private BdUniqueId aBS = BdUniqueId.gen();
    private boolean hOG = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.hOs != null && VideoPlayFragment.this.hOs.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hOs.author_info.user_id) && data != null && VideoPlayFragment.this.hOs.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aBS)) ? false : false;
                    if (data.aPt == null) {
                        if (!data.Jr) {
                            if (z && !"0".equals(VideoPlayFragment.this.hOs.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_fail);
                                VideoPlayFragment.this.hOs.author_info.is_follow = "0";
                                VideoPlayFragment.this.bMn();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.hOu) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.hOs));
                                    return;
                                }
                                VideoPlayFragment.this.hOs.author_info.is_follow = "1";
                                VideoPlayFragment.this.bMn();
                            }
                        } else {
                            VideoPlayFragment.this.hOs.author_info.is_follow = "0";
                            VideoPlayFragment.this.bMn();
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
                VideoPlayFragment.this.bMp();
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
        this.hOs = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hOB = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.bUJ = arguments.getString("from");
        this.arh = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.hOs != null && this.hOs.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hOs.author_info.user_id)) {
            this.epZ = true;
        }
        this.bOs = new n(getActivity());
        this.bOs.a(this.hOs);
        this.bOs.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bD(int i, int i2) {
                if (VideoPlayFragment.this.gFh != null) {
                    VideoPlayFragment.this.gFh.bD(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(e.h.video_play_view, (ViewGroup) null);
        this.hOa = (QuickVideoView) this.mRootView.findViewById(e.g.videoView);
        this.hOa.setPlayerReuseEnable(true);
        this.hOa.setContinuePlayEnable(true);
        this.hOa.setBusiness(this.bOs);
        this.hOa.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.gFx != null) {
                    VideoPlayFragment.this.gFx.onStart();
                }
            }
        });
        this.hOa.setNeedRecovery(true);
        if (this.hOs != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.biz = this.hOs.thread_id;
            zVar.daG = this.hOs.forum_id;
            zVar.gHI = this.hOs.mMd5;
            zVar.arh = "";
            zVar.mSource = this.hOs.mRecomSource;
            zVar.gHH = this.hOs.mRecomAbTag;
            zVar.gHF = this.hOs.mRecomWeight;
            if (this.mRect != null) {
                zVar.gHJ = "1";
            } else {
                zVar.gHJ = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.gHK = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.gHG = this.bUJ;
                zVar.arh = this.arh;
                zVar.gHE = this.hOs.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.bOs.setVideoStatsData(zVar);
        }
        this.hOb = (TbImageView) this.mRootView.findViewById(e.g.video_cover);
        this.hOb.setDefaultBgResource(e.f.icon_play_bg);
        this.hOb.setDefaultErrorResource(e.f.icon_play_bg);
        if (g.CF()) {
            this.dAY = this.mRootView.findViewById(e.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.dAY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dAY.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(e.g.back_btn);
        this.bLZ = (ImageView) this.mRootView.findViewById(e.g.more_btn);
        this.hOc = (HeadImageView) this.mRootView.findViewById(e.g.author_portrait);
        this.hOc.setDefaultResource(17170445);
        this.hOc.setDefaultBgResource(e.d.cp_bg_line_e);
        this.hOc.setIsRound(true);
        this.hOg = (ImageView) this.mRootView.findViewById(e.g.love_btn);
        this.hOv = (ImageView) this.mRootView.findViewById(e.g.agree_img);
        this.hOj = (TextView) this.mRootView.findViewById(e.g.video_title);
        this.hOk = (TextView) this.mRootView.findViewById(e.g.video_activity);
        this.hOe = (LinearLayout) this.mRootView.findViewById(e.g.comment_container);
        this.hOl = (TextView) this.mRootView.findViewById(e.g.comment_num);
        this.hOd = (LinearLayout) this.mRootView.findViewById(e.g.agree_container);
        this.hOm = (TextView) this.mRootView.findViewById(e.g.agree_num);
        this.hOn = (TextView) this.mRootView.findViewById(e.g.share_num);
        this.hOh = (ImageView) this.mRootView.findViewById(e.g.share_img);
        this.hOi = (ImageView) this.mRootView.findViewById(e.g.share_img_changed);
        bMi();
        this.hOo = (ImageView) this.mRootView.findViewById(e.g.play_btn);
        this.hOp = (LinearLayout) this.mRootView.findViewById(e.g.video_act_private_container);
        this.hOq = (LinearLayout) this.mRootView.findViewById(e.g.video_activity_container);
        this.hOr = (LinearLayout) this.mRootView.findViewById(e.g.video_private);
        this.hOf = (LinearLayout) this.mRootView.findViewById(e.g.share_container);
        this.hOw = (TextView) this.mRootView.findViewById(e.g.video_author_name);
        this.hOx = this.mRootView.findViewById(e.g.quick_reply_comment_layout);
        this.hOx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.hOx.setVisibility(4);
                    if (VideoPlayFragment.this.hOH != null && VideoPlayFragment.this.hOH.LY() != null) {
                        VideoPlayFragment.this.hOH.LY().pN();
                    }
                    if (VideoPlayFragment.this.hOs != null) {
                        am amVar = new am("c13025");
                        amVar.aA("tid", VideoPlayFragment.this.hOs.thread_id);
                        amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.aA(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.hOs.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.hOy = (TextView) this.mRootView.findViewById(e.g.quick_reply_comment_text);
        this.hOt = (TextView) this.mRootView.findViewById(e.g.download_nani_guide_txt);
        this.hOt.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hOt.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.hOt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.Ef().a((TbPageContext) i.aK(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bMm();
        this.hOc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hOs != null && VideoPlayFragment.this.hOs.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hOs.author_info.user_id) && VideoPlayFragment.this.hOs != null && VideoPlayFragment.this.hOs.author_info != null) {
                    long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.hOs.author_info.user_id, 0L);
                    long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = d == d2;
                    if (d == 0 && d2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(d, z, false)));
                    am amVar = new am("c12798");
                    amVar.aA("tid", VideoPlayFragment.this.hOs.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hOq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hOs != null && VideoPlayFragment.this.hOs.act_info != null) {
                    com.baidu.tbadk.browser.a.af(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.hOs.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.aA("tid", VideoPlayFragment.this.hOs.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hOj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bMk();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hOs != null && !StringUtils.isNull(VideoPlayFragment.this.hOs.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.hOs.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.bLZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bMl();
            }
        });
        this.hOe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bMk();
                am amVar = new am("c12796");
                amVar.aA("tid", VideoPlayFragment.this.hOs.thread_id);
                amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hOd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.wV(VideoPlayFragment.this.hNY);
            }
        });
        this.hOf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Fq();
                am amVar = new am("c12797");
                amVar.aA("tid", VideoPlayFragment.this.hOs.thread_id);
                amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hOg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hOs != null && VideoPlayFragment.this.hOs.author_info != null) {
                    VideoPlayFragment.this.aCb.a(true, VideoPlayFragment.this.hOs.author_info.portrait, VideoPlayFragment.this.hOs.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.aBS, VideoPlayFragment.this.hOs.forum_id, "0");
                    VideoPlayFragment.this.hOs.author_info.is_follow = "1";
                    VideoPlayFragment.this.bMn();
                }
            }
        });
        this.bRV = new AlphaAnimation(1.0f, 0.0f);
        this.bRV.setDuration(100L);
        this.bRV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.hOb != null) {
                    VideoPlayFragment.this.hOb.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.hOz = this.mRect.right - this.mRect.left;
            this.hOA = this.mRect.bottom - this.mRect.top;
            this.hOb.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.hOb.getWidth();
                    int height = VideoPlayFragment.this.hOb.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hOs.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hOs.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hOs.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hOs.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hOz, VideoPlayFragment.this.hOA);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.hOb.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hOA > 0 || VideoPlayFragment.this.hOz <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.hOz;
                                f = i / VideoPlayFragment.this.hOA;
                            }
                            VideoPlayFragment.this.hOb.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.hOb.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.hOu) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hOz, VideoPlayFragment.this.hOA);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.hOb.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hOA > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.hOb.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.hOb.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.hOu) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.hOb.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.hOb.getWidth();
                    int height = VideoPlayFragment.this.hOb.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hOs.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hOs.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hOs.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hOs.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.hOb.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.hOb.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.hOu) {
            bMj();
        }
        if (this.hOs != null && !StringUtils.isNull(this.hOs.video_url)) {
            xh(this.hOs.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.gFh = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gFx = cVar;
    }

    private void initEditor() {
        this.hOH = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().bM(getActivity());
        if (this.hOH != null && this.hOs != null) {
            this.hOH.setContext(getPageContext());
            this.hOH.R(this.hOs.thread_id, this.hOs.forum_id, this.hOs.forum_name);
            this.hOH.a(new a.InterfaceC0333a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0333a
                public void om(boolean z) {
                    VideoPlayFragment.this.hOx.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.hOy.setText(e.j.reply_something);
                    } else {
                        VideoPlayFragment.this.hOy.setText(StringUtils.isNull(((c) VideoPlayFragment.this.hOH.LY().fL(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.hOs != null && z) {
                        long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.hOs.comment_num, 0L) + 1;
                        VideoPlayFragment.this.hOs.comment_num = String.valueOf(d);
                        VideoPlayFragment.this.hOl.setText(ao.X(d));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.hOH.LY(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fq() {
        if (this.hOs != null) {
            String str = this.hOs.forum_id;
            String str2 = this.hOs.forum_name;
            String str3 = this.hOs.title;
            String str4 = this.hOs.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hOs.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            d dVar = new d();
            dVar.title = str3;
            dVar.content = format;
            dVar.aSl = "";
            dVar.linkUrl = str5;
            dVar.avL = 2;
            dVar.extData = str4;
            dVar.aSo = 3;
            dVar.fid = str;
            dVar.aSh = str2;
            dVar.tid = str4;
            dVar.aSd = true;
            dVar.aSn = 0;
            dVar.aSp = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hOs.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hOs.title;
            originalThreadInfo.threadId = this.hOs.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aSo);
            bundle.putInt("obj_type", dVar.aSp);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.avL);
            dVar.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.asd().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.epZ) {
            this.cYy = new ForumManageModel(getPageContext());
            this.cYy.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.cYy.getLoadDataMode()) {
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
        this.fVO = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.fVO != null) {
            this.fVO.a(new a.InterfaceC0154a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0154a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.fVO != null) {
                            VideoPlayFragment.this.fVO.aP(z2);
                        }
                        if (VideoPlayFragment.this.hOs != null) {
                            if (z2) {
                                VideoPlayFragment.this.hOs.mark_id = VideoPlayFragment.this.hOs.post_id;
                            } else {
                                VideoPlayFragment.this.hOs.mark_id = null;
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
            this.hOG = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bMm();
        if (Build.VERSION.SDK_INT >= 17) {
            this.hOa.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.hOu && i == 3 && VideoPlayFragment.this.hOb.getVisibility() == 0) {
                        VideoPlayFragment.this.hOb.clearAnimation();
                        VideoPlayFragment.this.hOb.startAnimation(VideoPlayFragment.this.bRV);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.hOa.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.hOa != null) {
                    VideoPlayFragment.this.hOa.seekTo(0);
                    VideoPlayFragment.this.hOa.start();
                    VideoPlayFragment.this.aqb();
                    VideoPlayFragment.x(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.bMh();
                    }
                }
            }
        });
        this.hOa.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.hOb != null) {
                        VideoPlayFragment.this.hOb.clearAnimation();
                        VideoPlayFragment.this.hOb.startAnimation(VideoPlayFragment.this.bRV);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMh() {
        if (this.hOi != null && this.hOh != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.hOh.clearAnimation();
            this.hOi.clearAnimation();
            this.hOh.setVisibility(8);
            this.hOi.setVisibility(0);
            this.hOi.startAnimation(scaleAnimation2);
            this.hOh.startAnimation(scaleAnimation);
        }
    }

    private void bMi() {
        if (this.hOi != null && this.hOh != null) {
            this.hOh.clearAnimation();
            this.hOi.clearAnimation();
            this.hOh.setVisibility(0);
            this.hOi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(int i) {
        int i2;
        if (ba.bJ(getActivity()) && this.hOs != null) {
            if (i == this.hNY) {
                if ("1".equals(this.hOs.is_agreed)) {
                    i2 = 1;
                    this.hOs.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hOs.agree_num, 0) - 1);
                    this.hOs.is_agreed = "0";
                } else {
                    this.hOs.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hOs.agree_num, 0) + 1);
                    this.hOs.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.hOs.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hOs.agree_num, 0) + 1);
                this.hOs.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.aA("tid", this.hOs.thread_id);
            amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.hNY) {
                amVar.x("obj_type", i2);
            } else {
                amVar.x("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            bMm();
            if (this.hOv != null && i2 == 0) {
                this.hOv.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hOs.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hOs));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hOs != null && !StringUtils.isNull(this.hOs.video_url)) {
            this.UI = true;
            if (this.hOu) {
                aqb();
                aZG();
                if (this.hOs != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.aA("tid", this.hOs.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.x("obj_type", 0);
                    TiebaStatic.log(amVar);
                }
            } else {
                pausePlay();
            }
        }
        if (this.hOs != null && !ao.isEmpty(this.hOs.thread_id)) {
            com.baidu.tbadk.BdToken.c.vu().f(com.baidu.tbadk.BdToken.b.ajV, com.baidu.adp.lib.g.b.d(this.hOs.thread_id, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        stopPlay();
        if (this.hOH != null && this.hOH.LY() != null) {
            this.hOH.LY().hide();
            this.hOx.setVisibility(0);
            this.hOy.setText(StringUtils.isNull(((c) this.hOH.LY().fL(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
            com.baidu.tbadk.BdToken.c.vu().vv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.hOH != null) {
            this.hOH.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.hOu = z;
        if (this.UI) {
            if (this.hOu && (!this.hOG || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.hOs != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.aA("tid", this.hOs.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.x("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                bMj();
                this.hOG = false;
                return;
            }
            bMi();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void bMj() {
        if (this.hOs != null) {
            am amVar = new am("c12590");
            amVar.aA("tid", this.hOs.thread_id);
            amVar.aA(ImageViewerConfig.FORUM_ID, this.hOs.forum_id);
            amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.x("obj_locate", this.hOB);
            amVar.aA("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.x("obj_param2", 1);
            amVar.aA("obj_param1", ao.isEmpty(this.hOs.mRecomWeight) ? "0" : this.hOs.mRecomWeight);
            amVar.aA("extra", ao.isEmpty(this.hOs.mRecomExtra) ? "0" : this.hOs.mRecomExtra);
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, this.arh);
            amVar.aA("ab_tag", ao.isEmpty(this.hOs.mRecomAbTag) ? "0" : this.hOs.mRecomAbTag);
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.hOs.mRecomSource) ? "0" : this.hOs.mRecomSource);
            amVar.aA("obj_type", this.bUJ);
            amVar.x("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void xh(String str) {
        if (this.hOa != null && str != null && !str.equals(this.aEO)) {
            this.hOa.setRecoveryState(0);
            this.hOa.setVideoPath(str, this.hOs.thread_id);
            this.aEO = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.bIG().bIH() || bMp()) {
            brJ();
            if (this.hOo != null) {
                this.hOo.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hOb.getVisibility() == 0) {
                this.hOb.clearAnimation();
                this.hOb.startAnimation(this.bRV);
            }
            if (this.hOa != null) {
                this.hOa.start();
                aqb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqb() {
        if (this.hOs != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.biz = this.hOs.thread_id;
            zVar.daG = this.hOs.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.hOs.mRecomSource;
            zVar.gHE = this.hOs.mRecomAbTag;
            zVar.gHF = this.hOs.mRecomWeight;
            zVar.gHG = "";
            zVar.arh = "";
            zVar.gHI = this.hOs.mMd5;
            if (this.mRect != null) {
                zVar.gHJ = "1";
            } else {
                zVar.gHJ = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.gHK = "1";
                zVar.mLocate = "auto_midpage";
                zVar.gHG = "index";
            }
            com.baidu.tieba.play.l.a(this.hOs.mMd5, "", "1", zVar);
        }
    }

    private void brJ() {
        if (com.baidu.adp.lib.util.j.kX()) {
            com.baidu.tieba.video.g.bIG().dc(getContext());
        }
    }

    private void pausePlay() {
        if (this.hOa != null) {
            this.hOa.pause();
        }
    }

    private void stopPlay() {
        if (this.hOa != null) {
            this.hOa.setRecoveryState(5);
            this.hOa.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMk() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hOs.thread_id, this.hOs.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hOs.forum_id));
        createNormalCfg.setForumName(this.hOs.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMl() {
        if (this.ane == null) {
            this.cYq = new com.baidu.tieba.view.a(getActivity());
            this.ane = new com.baidu.tieba.person.e(getActivity(), this.cYq.bMO());
            this.ane.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.hOa.setSystemUiVisibility(4);
                }
            });
        }
        if (this.cYq != null) {
            ArrayList arrayList = new ArrayList();
            a.C0334a c0334a = new a.C0334a(this.cYq);
            c0334a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.ane.dismiss();
                    if (VideoPlayFragment.this.hOs != null) {
                        boolean z = VideoPlayFragment.this.hOs.post_id != null && VideoPlayFragment.this.hOs.post_id.equals(VideoPlayFragment.this.hOs.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.hOs.thread_id);
                        markData.setPostId(VideoPlayFragment.this.hOs.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.hOs.thread_id);
                        markData.setForumId(VideoPlayFragment.this.hOs.forum_id);
                        if (VideoPlayFragment.this.fVO != null) {
                            VideoPlayFragment.this.fVO.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.fVO.ws();
                            } else {
                                VideoPlayFragment.this.fVO.wr();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hOs != null && this.hOs.post_id != null && this.hOs.post_id.equals(this.hOs.mark_id)) {
                z = true;
            }
            if (z) {
                c0334a.setText(getResources().getString(e.j.remove_mark));
            } else {
                c0334a.setText(getResources().getString(e.j.mark));
            }
            arrayList.add(c0334a);
            a.C0334a c0334a2 = new a.C0334a(getActivity().getString(e.j.delete), this.cYq);
            c0334a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.ane.dismiss();
                    if (ba.bJ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hOs != null) {
                        String str = VideoPlayFragment.this.hOs.thread_id;
                        String str2 = VideoPlayFragment.this.hOs.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(e.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.hOs.post_id, true)));
                    }
                }
            });
            c0334a2.setText(getResources().getString(e.j.report_text));
            arrayList.add(c0334a2);
            if (this.epZ) {
                a.C0334a c0334a3 = new a.C0334a(getActivity().getString(e.j.delete), this.cYq);
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
                                if (VideoPlayFragment.this.hOs != null) {
                                    VideoPlayFragment.this.cYy.a(VideoPlayFragment.this.hOs.forum_id, VideoPlayFragment.this.hOs.forum_name, VideoPlayFragment.this.hOs.thread_id, VideoPlayFragment.this.hOs.post_id, 0, 0, VideoPlayFragment.this.epZ);
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
            this.cYq.ee(arrayList);
        }
        this.ane.show();
    }

    private void bMm() {
        if (this.hOs != null) {
            this.hOb.startLoad(this.hOs.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.hOs.title);
            if (StringUtils.isNull(this.hOs.title) || matcher.matches()) {
                this.hOj.setVisibility(8);
            } else {
                this.hOj.setVisibility(0);
                this.hOj.setText(this.hOs.title);
            }
            this.hOl.setText(ao.X(com.baidu.adp.lib.g.b.d(this.hOs.comment_num, 0L)));
            this.hOm.setText(ao.X(com.baidu.adp.lib.g.b.d(this.hOs.agree_num, 0L)));
            this.hOn.setText(ao.X(com.baidu.adp.lib.g.b.d(this.hOs.share_num, 0L)));
            if (this.hOs.author_info != null) {
                if (!StringUtils.isNull(this.hOs.author_info.portrait) && this.hOs.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.hOc.startLoad(this.hOs.author_info.portrait, 10, false);
                } else {
                    this.hOc.startLoad(this.hOs.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.hOs.author_info.bIC())) {
                    this.hOw.setVisibility(8);
                } else {
                    this.hOw.setVisibility(0);
                    this.hOw.setText("@" + this.hOs.author_info.bIC());
                }
            }
            if ("1".equals(this.hOs.is_private) && this.hOt.getVisibility() != 0) {
                this.hOr.setVisibility(0);
            } else {
                this.hOr.setVisibility(8);
            }
            if ("1".equals(this.hOs.is_agreed)) {
                al.c(this.hOv, e.f.icon_card_like_white_full_s);
            } else {
                al.c(this.hOv, e.f.btn_video_agree);
            }
            if (this.hOs.act_info != null && !StringUtils.isNull(this.hOs.act_info.activity_name) && this.hOt.getVisibility() != 0) {
                this.hOq.setVisibility(0);
                this.hOk.setText(this.hOs.act_info.activity_name);
            } else {
                this.hOq.setVisibility(8);
            }
            bMn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMn() {
        if (this.epZ || (this.hOs.author_info != null && !"0".equals(this.hOs.author_info.is_follow))) {
            this.hOg.setVisibility(4);
            this.hOg.setClickable(false);
            return;
        }
        this.hOg.setVisibility(0);
        this.hOg.setClickable(true);
    }

    private void bMo() {
        if (getActivity() != null) {
            if (this.hOI == null || !this.hOI.isShowing()) {
                this.hOI = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(e.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(e.g.tv_title)).setText(e.j.confirm_title);
                ((TextView) inflate.findViewById(e.g.tv_msg)).setText(e.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(e.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(e.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.hOI.G(inflate);
                this.hOI.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.hOI.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.hOI.dd(1);
                this.hOI.dc(e.d.cp_cont_b);
                this.hOI.bf(true);
                this.hOI.b(getPageContext());
                this.hOI.BF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bMp() {
        if (!com.baidu.adp.lib.util.j.kV() || com.baidu.adp.lib.util.j.kW()) {
            return true;
        }
        if (!this.hOu || com.baidu.tieba.video.g.bIG().bIH()) {
            return false;
        }
        if (this.hOo != null) {
            this.hOo.setVisibility(0);
        }
        pausePlay();
        bMo();
        return false;
    }

    private void aZG() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bMp() || com.baidu.tieba.video.g.bIG().bIH()) && this.hOa != null && this.hOo != null) {
            this.hOa.start();
            this.hOo.setVisibility(8);
            brJ();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.hOC == null) {
            this.hOC = AnimationUtils.loadAnimation(getContext(), e.a.scale_zoom_in_and_out_anim);
        }
        return this.hOC;
    }

    public long bMq() {
        if (this.hOp != null) {
            this.hOp.setVisibility(8);
        }
        if (this.hOt != null) {
            this.hOt.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
    public void TD() {
        if (this.hOa.isPlaying()) {
            this.hOa.pause();
            this.hOo.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bMp() || com.baidu.tieba.video.g.bIG().bIH()) {
            this.hOa.start();
            this.hOo.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
    public void t(float f, float f2) {
        if (ba.bJ(getActivity()) && !this.hOD) {
            bMr();
            if (this.hOs != null && "0".equals(this.hOs.is_agreed)) {
                wV(this.hNZ);
            }
        }
    }

    private void bMr() {
        if (this.mRootView != null) {
            this.hOD = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(e.f.icon_video_like);
            if (this.hOF == null) {
                this.hOF = new RelativeLayout.LayoutParams(-2, -2);
                this.hOF.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.hOF);
            }
            if (this.hOE == null) {
                this.hOE = new AnimatorSet();
                this.hOE.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.hOD = false;
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
            this.hOE.setTarget(imageView);
            this.hOE.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.hOE.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
    public void TE() {
        if (this.hOs != null && this.hOs.author_info != null) {
            long d = com.baidu.adp.lib.g.b.d(this.hOs.author_info.user_id, 0L);
            long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = d == d2;
            if (d == 0 && d2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(d, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.hOa != null) {
            return this.hOa.getMediaIDs();
        }
        return null;
    }

    public String bMs() {
        if (this.hOa != null) {
            return this.hOa.getMediaId();
        }
        return null;
    }

    public boolean bMt() {
        if (this.hOH == null || this.hOH.LY() == null || !this.hOH.LY().isVisible()) {
            return false;
        }
        this.hOH.LY().hide();
        this.hOx.setVisibility(0);
        if ((this.hOH.LY().fL(28) instanceof c) && ((c) this.hOH.LY().fL(28)).getInputView() != null && ((c) this.hOH.LY().fL(28)).getInputView().getText() != null) {
            this.hOy.setText(StringUtils.isNull(((c) this.hOH.LY().fL(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.hOH != null) {
            this.hOH.onActivityResult(i, i2, intent);
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
        if (this.hOH != null && this.hOH.LY() != null) {
            this.hOH.LY().onChangeSkinType(i);
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
