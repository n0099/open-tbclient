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
import com.baidu.sapi2.utils.SapiGIDEvent;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.d;
import com.baidu.tieba.person.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
import com.baidu.tieba.play.y;
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
/* loaded from: classes2.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0122a {
    private boolean aXT;
    private e abo;
    private String afx;
    protected ScaleAnimation axD;
    private String bBL;
    private String bdb;
    public ImageView bsV;
    private n bvr;
    private AlphaAnimation byW;
    private com.baidu.tieba.view.a czE;
    private boolean dPN;
    private View dcL;
    private j.b gfg;
    private QuickVideoView.c gfw;
    public QuickVideoView hmQ;
    private TbImageView hmR;
    public HeadImageView hmS;
    public LinearLayout hmT;
    public LinearLayout hmU;
    public LinearLayout hmV;
    public ImageView hmW;
    public TextView hmX;
    public TextView hmY;
    public TextView hmZ;
    public TextView hna;
    public TextView hnb;
    public ImageView hnc;
    private LinearLayout hnd;
    public LinearLayout hne;
    public LinearLayout hnf;
    public VideoItemData hng;
    private TextView hnh;
    private boolean hni;
    public ImageView hnj;
    public TextView hnk;
    private View hnl;
    private TextView hnm;
    private int hnn;
    private int hno;
    private int hnp;
    private boolean hnq;
    private AnimatorSet hnr;
    private RelativeLayout.LayoutParams hns;
    private com.baidu.tieba.videoplay.editor.a hnu;
    com.baidu.tbadk.core.dialog.a hnv;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int hmO = 0;
    private int hmP = 1;
    private ForumManageModel czM = null;
    private com.baidu.tbadk.baseEditMark.a fvu = null;
    private com.baidu.tbadk.coreExtra.model.a aqE = null;
    private BdUniqueId aqv = BdUniqueId.gen();
    private boolean hnt = false;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.hng != null && VideoPlayFragment.this.hng.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hng.author_info.user_id) && data != null && VideoPlayFragment.this.hng.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aqv)) ? false : false;
                    if (data.aDu == null) {
                        if (!data.Gp) {
                            if (z && !"0".equals(VideoPlayFragment.this.hng.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), d.j.attention_fail);
                                VideoPlayFragment.this.hng.author_info.is_follow = "0";
                                VideoPlayFragment.this.bDP();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.hni) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), d.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.hng));
                                    return;
                                }
                                VideoPlayFragment.this.hng.author_info.is_follow = "1";
                                VideoPlayFragment.this.bDP();
                            }
                        } else {
                            VideoPlayFragment.this.hng.author_info.is_follow = "0";
                            VideoPlayFragment.this.bDP();
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
                VideoPlayFragment.this.bDR();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.hng = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hnp = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.bBL = arguments.getString("from");
        this.afx = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.hng != null && this.hng.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hng.author_info.user_id)) {
            this.dPN = true;
        }
        this.bvr = new n(getActivity());
        this.bvr.a(this.hng);
        this.bvr.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bx(int i, int i2) {
                if (VideoPlayFragment.this.gfg != null) {
                    VideoPlayFragment.this.gfg.bx(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(d.h.video_play_view, (ViewGroup) null);
        this.hmQ = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.hmQ.setBusiness(this.bvr);
        this.hmQ.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.gfw != null) {
                    VideoPlayFragment.this.gfw.onStart();
                }
            }
        });
        this.hmQ.setNeedRecovery(true);
        if (this.hng != null) {
            y yVar = new y();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.aWq = this.hng.thread_id;
            yVar.cBU = this.hng.forum_id;
            yVar.ghG = this.hng.mMd5;
            yVar.afx = "";
            yVar.mSource = this.hng.mRecomSource;
            yVar.ghF = this.hng.mRecomAbTag;
            yVar.ghD = this.hng.mRecomWeight;
            if (this.mRect != null) {
                yVar.ghH = "1";
            } else {
                yVar.ghH = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.ghI = "1";
                yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                yVar.ghE = this.bBL;
                yVar.afx = this.afx;
                yVar.ghC = this.hng.mRecomWeight;
            } else {
                yVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.bvr.setVideoStatsData(yVar);
        }
        this.hmR = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.hmR.setDefaultBgResource(d.f.icon_play_bg);
        this.hmR.setDefaultErrorResource(d.f.icon_play_bg);
        if (g.yg()) {
            this.dcL = this.mRootView.findViewById(d.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.dcL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dcL.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.bsV = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.hmS = (HeadImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.hmS.setDefaultResource(17170445);
        this.hmS.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.hmS.setIsRound(true);
        this.hmW = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.hnj = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.hmX = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.hmY = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.hmU = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.hmZ = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.hmT = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.hna = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.hnb = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.hnc = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.hnd = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.hne = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.hnf = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.hmV = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.hnk = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.hnl = this.mRootView.findViewById(d.g.quick_reply_comment_layout);
        this.hnl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.hnl.setVisibility(4);
                    if (VideoPlayFragment.this.hnu != null && VideoPlayFragment.this.hnu.Ht() != null) {
                        VideoPlayFragment.this.hnu.Ht().oF();
                    }
                    if (VideoPlayFragment.this.hng != null) {
                        an anVar = new an("c13025");
                        anVar.af("tid", VideoPlayFragment.this.hng.thread_id);
                        anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.af(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.hng.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.hnm = (TextView) this.mRootView.findViewById(d.g.quick_reply_comment_text);
        this.hnh = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.hnh.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hnh.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.hnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.zK().a((TbPageContext) i.ad(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bDO();
        this.hmS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hng != null && VideoPlayFragment.this.hng.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hng.author_info.user_id) && VideoPlayFragment.this.hng != null && VideoPlayFragment.this.hng.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hng.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(c, z, false)));
                    an anVar = new an("c12798");
                    anVar.af("tid", VideoPlayFragment.this.hng.thread_id);
                    anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.hne.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hng != null && VideoPlayFragment.this.hng.act_info != null) {
                    com.baidu.tbadk.browser.a.S(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.hng.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.af("tid", VideoPlayFragment.this.hng.thread_id);
                    anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.hmX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bDM();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hng != null && !StringUtils.isNull(VideoPlayFragment.this.hng.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.hng.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.bsV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bDN();
            }
        });
        this.hmU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bDM();
                an anVar = new an("c12796");
                anVar.af("tid", VideoPlayFragment.this.hng.thread_id);
                anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.hmT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.uV(VideoPlayFragment.this.hmO);
            }
        });
        this.hmV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.AM();
                an anVar = new an("c12797");
                anVar.af("tid", VideoPlayFragment.this.hng.thread_id);
                anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.hmW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.aV(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hng != null && VideoPlayFragment.this.hng.author_info != null) {
                    VideoPlayFragment.this.aqE.a(true, VideoPlayFragment.this.hng.author_info.portrait, VideoPlayFragment.this.hng.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.aqv, VideoPlayFragment.this.hng.forum_id, "0");
                    VideoPlayFragment.this.hng.author_info.is_follow = "1";
                    VideoPlayFragment.this.bDP();
                }
            }
        });
        this.byW = new AlphaAnimation(1.0f, 0.0f);
        this.byW.setDuration(100L);
        this.byW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.hmR != null) {
                    VideoPlayFragment.this.hmR.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.hnn = this.mRect.right - this.mRect.left;
            this.hno = this.mRect.bottom - this.mRect.top;
            this.hmR.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.hmR.getWidth();
                    int height = VideoPlayFragment.this.hmR.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hng.video_height, 0) > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hng.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hng.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hng.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hnn, VideoPlayFragment.this.hno);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.hmR.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hno > 0 || VideoPlayFragment.this.hnn <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.hnn;
                                f = i / VideoPlayFragment.this.hno;
                            }
                            VideoPlayFragment.this.hmR.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.hmR.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.hni) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hnn, VideoPlayFragment.this.hno);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.hmR.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hno > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.hmR.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.hmR.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.hni) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.hmR.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.hmR.getWidth();
                    int height = VideoPlayFragment.this.hmR.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hng.video_height, 0) > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hng.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hng.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hng.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.hmR.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.hmR.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.hni) {
            bDL();
        }
        if (this.hng != null && !StringUtils.isNull(this.hng.video_url)) {
            vi(this.hng.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.gfg = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gfw = cVar;
    }

    private void initEditor() {
        this.hnu = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().aZ(getActivity());
        if (this.hnu != null && this.hng != null) {
            this.hnu.setContext(getPageContext());
            this.hnu.J(this.hng.thread_id, this.hng.forum_id, this.hng.forum_name);
            this.hnu.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0250a
                public void ng(boolean z) {
                    VideoPlayFragment.this.hnl.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.hnm.setText(d.j.reply_something);
                    } else {
                        VideoPlayFragment.this.hnm.setText(StringUtils.isNull(((c) VideoPlayFragment.this.hnu.Ht().eO(28)).getInputView().getText().toString()) ? d.j.reply_something : d.j.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.hng != null && z) {
                        VideoPlayFragment.this.hmZ.setText(ap.H(com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hng.comment_num, 0L) + 1));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.hnu.Ht(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AM() {
        if (this.hng != null) {
            String str = this.hng.forum_id;
            String str2 = this.hng.forum_name;
            String str3 = this.hng.title;
            String str4 = this.hng.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hng.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.aGf = "";
            dVar.linkUrl = str5;
            dVar.ajX = 2;
            dVar.extData = str4;
            dVar.aGi = 3;
            dVar.fid = str;
            dVar.aGb = str2;
            dVar.tid = str4;
            dVar.aFX = true;
            dVar.aGh = 0;
            dVar.aGj = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hng.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hng.title;
            originalThreadInfo.threadId = this.hng.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aGi);
            bundle.putInt("obj_type", dVar.aGj);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ajX);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.akO().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.dPN) {
            this.czM = new ForumManageModel(getPageContext());
            this.czM.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.czM.getLoadDataMode()) {
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
        this.fvu = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.fvu != null) {
            this.fvu.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0097a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.fvu != null) {
                            VideoPlayFragment.this.fvu.ad(z2);
                        }
                        if (VideoPlayFragment.this.hng != null) {
                            if (z2) {
                                VideoPlayFragment.this.hng.mark_id = VideoPlayFragment.this.hng.post_id;
                            } else {
                                VideoPlayFragment.this.hng.mark_id = null;
                            }
                        }
                        if (z2) {
                            VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(d.j.add_mark));
                            return;
                        } else {
                            VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(d.j.remove_mark));
                            return;
                        }
                    }
                    VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(d.j.update_mark_failed));
                }
            });
        }
        this.aqE = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.hnt = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bDO();
        if (Build.VERSION.SDK_INT >= 17) {
            this.hmQ.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean a(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.hni && i == 3 && VideoPlayFragment.this.hmR.getVisibility() == 0) {
                        VideoPlayFragment.this.hmR.clearAnimation();
                        VideoPlayFragment.this.hmR.startAnimation(VideoPlayFragment.this.byW);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.hmQ.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.hmQ != null) {
                    VideoPlayFragment.this.hmQ.seekTo(0);
                    x.bkW().remove(VideoPlayFragment.this.bdb);
                    VideoPlayFragment.this.hmQ.start();
                    VideoPlayFragment.this.aiI();
                }
            }
        });
        this.hmQ.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                int se = x.bkW().se(VideoPlayFragment.this.bdb);
                if (se != 0) {
                    VideoPlayFragment.this.hmQ.rH(se);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uV(int i) {
        int i2;
        if (ba.aV(getActivity()) && this.hng != null) {
            if (i == this.hmO) {
                if ("1".equals(this.hng.is_agreed)) {
                    i2 = 1;
                    this.hng.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.hng.agree_num, 0) - 1);
                    this.hng.is_agreed = "0";
                } else {
                    this.hng.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.hng.agree_num, 0) + 1);
                    this.hng.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.hng.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.hng.agree_num, 0) + 1);
                this.hng.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.af("tid", this.hng.thread_id);
            anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.hmO) {
                anVar.r("obj_type", i2);
            } else {
                anVar.r("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            bDO();
            if (this.hnj != null && i2 == 0) {
                this.hnj.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hng.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hng));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hng != null && !StringUtils.isNull(this.hng.video_url)) {
            this.aXT = true;
            if (this.hni) {
                aiI();
                aSg();
                if (this.hng != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.af("tid", this.hng.thread_id);
                    anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.r("obj_type", 0);
                    TiebaStatic.log(anVar);
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
        if (this.hnu != null && this.hnu.Ht() != null) {
            this.hnu.Ht().hide();
        }
        this.hnl.setVisibility(0);
        this.hnm.setText(StringUtils.isNull(((c) this.hnu.Ht().eO(28)).getInputView().getText().toString()) ? d.j.reply_something : d.j.draft_to_replay);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.hnu != null) {
            this.hnu.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.hni = z;
        if (this.aXT) {
            if (this.hni && (!this.hnt || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.hng != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.af("tid", this.hng.thread_id);
                    anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.r("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                bDL();
                this.hnt = false;
                return;
            }
            pausePlay();
        }
    }

    private void bDL() {
        if (this.hng != null) {
            an anVar = new an("c12590");
            anVar.af("tid", this.hng.thread_id);
            anVar.af(ImageViewerConfig.FORUM_ID, this.hng.forum_id);
            anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.r("obj_locate", this.hnp);
            anVar.af("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.r("obj_param2", 1);
            anVar.af("obj_param1", this.hng.mRecomWeight);
            anVar.af("extra", this.hng.mRecomExtra);
            anVar.af(VideoPlayActivityConfig.OBJ_ID, this.afx);
            anVar.af("ab_tag", this.hng.mRecomAbTag);
            anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hng.mRecomSource);
            anVar.af("obj_type", this.bBL);
            anVar.r("is_vertical", 1);
            TiebaStatic.log(anVar);
        }
    }

    private void vi(String str) {
        if (this.hmQ != null && str != null && !str.equals(this.bdb)) {
            this.hmQ.setRecoveryState(0);
            this.hmQ.setVideoPath(str, this.hng.thread_id);
            this.bdb = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.bAi().bAj() || bDR()) {
            bjW();
            if (this.hnc != null) {
                this.hnc.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hmR.getVisibility() == 0) {
                this.hmR.clearAnimation();
                this.hmR.startAnimation(this.byW);
            }
            if (this.hmQ != null) {
                this.hmQ.start();
                int se = x.bkW().se(this.bdb);
                if (se != 0) {
                    this.hmQ.rH(se);
                }
                aiI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiI() {
        if (this.hng != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.aWq = this.hng.thread_id;
            yVar.cBU = this.hng.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.hng.mRecomSource;
            yVar.ghC = this.hng.mRecomAbTag;
            yVar.ghD = this.hng.mRecomWeight;
            yVar.ghE = "";
            yVar.afx = "";
            yVar.ghG = this.hng.mMd5;
            if (this.mRect != null) {
                yVar.ghH = "1";
            } else {
                yVar.ghH = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.ghI = "1";
                yVar.mLocate = "auto_midpage";
                yVar.ghE = "index";
            }
            com.baidu.tieba.play.l.a(this.hng.mMd5, "", "1", yVar);
        }
    }

    private void bjW() {
        if (com.baidu.adp.lib.util.j.jG()) {
            com.baidu.tieba.video.g.bAi().cl(getContext());
        }
    }

    private void pausePlay() {
        if (this.hmQ != null) {
            if (this.hmQ.isPlaying()) {
                x.bkW().aD(this.bdb, this.hmQ.getCurrentPosition());
            }
            this.hmQ.pause();
        }
    }

    private void stopPlay() {
        if (this.hmQ != null) {
            if (this.hmQ.isPlaying()) {
                x.bkW().aD(this.bdb, this.hmQ.getCurrentPosition());
            }
            this.hmQ.setRecoveryState(5);
            this.hmQ.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDM() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hng.thread_id, this.hng.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hng.forum_id));
        createNormalCfg.setForumName(this.hng.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDN() {
        if (this.abo == null) {
            this.czE = new com.baidu.tieba.view.a(getActivity());
            this.abo = new e(getActivity(), this.czE.bEq());
            this.abo.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.hmQ.setSystemUiVisibility(4);
                }
            });
        }
        if (this.czE != null) {
            ArrayList arrayList = new ArrayList();
            a.C0251a c0251a = new a.C0251a(this.czE);
            c0251a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.abo.dismiss();
                    if (VideoPlayFragment.this.hng != null) {
                        boolean z = VideoPlayFragment.this.hng.post_id != null && VideoPlayFragment.this.hng.post_id.equals(VideoPlayFragment.this.hng.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.hng.thread_id);
                        markData.setPostId(VideoPlayFragment.this.hng.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.hng.thread_id);
                        markData.setForumId(VideoPlayFragment.this.hng.forum_id);
                        if (VideoPlayFragment.this.fvu != null) {
                            VideoPlayFragment.this.fvu.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.fvu.rP();
                            } else {
                                VideoPlayFragment.this.fvu.rO();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hng != null && this.hng.post_id != null && this.hng.post_id.equals(this.hng.mark_id)) {
                z = true;
            }
            if (z) {
                c0251a.setText(getResources().getString(d.j.remove_mark));
            } else {
                c0251a.setText(getResources().getString(d.j.mark));
            }
            arrayList.add(c0251a);
            a.C0251a c0251a2 = new a.C0251a(getActivity().getString(d.j.delete), this.czE);
            c0251a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.abo.dismiss();
                    if (ba.aV(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hng != null) {
                        String str = VideoPlayFragment.this.hng.thread_id;
                        String str2 = VideoPlayFragment.this.hng.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(d.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.hng.post_id, true)));
                    }
                }
            });
            c0251a2.setText(getResources().getString(d.j.report_text));
            arrayList.add(c0251a2);
            if (this.dPN) {
                a.C0251a c0251a3 = new a.C0251a(getActivity().getString(d.j.delete), this.czE);
                c0251a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.abo.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.cf(d.j.del_thread_confirm);
                        aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.hng != null) {
                                    VideoPlayFragment.this.czM.a(VideoPlayFragment.this.hng.forum_id, VideoPlayFragment.this.hng.forum_name, VideoPlayFragment.this.hng.thread_id, VideoPlayFragment.this.hng.post_id, 0, 0, VideoPlayFragment.this.dPN);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                                }
                            }
                        });
                        aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.au(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.xf();
                    }
                });
                c0251a3.setText(getResources().getString(d.j.delete));
                arrayList.add(c0251a3);
            }
            this.czE.dM(arrayList);
        }
        this.abo.show();
    }

    private void bDO() {
        if (this.hng != null) {
            this.hmR.startLoad(this.hng.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.hng.title);
            if (StringUtils.isNull(this.hng.title) || matcher.matches()) {
                this.hmX.setVisibility(8);
            } else {
                this.hmX.setVisibility(0);
                this.hmX.setText(this.hng.title);
            }
            this.hmZ.setText(ap.H(com.baidu.adp.lib.g.b.c(this.hng.comment_num, 0L)));
            this.hna.setText(ap.H(com.baidu.adp.lib.g.b.c(this.hng.agree_num, 0L)));
            this.hnb.setText(ap.H(com.baidu.adp.lib.g.b.c(this.hng.share_num, 0L)));
            if (this.hng.author_info != null) {
                if (!StringUtils.isNull(this.hng.author_info.portrait) && this.hng.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.hmS.startLoad(this.hng.author_info.portrait, 10, false);
                } else {
                    this.hmS.startLoad(this.hng.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.hng.author_info.bAe())) {
                    this.hnk.setVisibility(8);
                } else {
                    this.hnk.setVisibility(0);
                    this.hnk.setText("@" + this.hng.author_info.bAe());
                }
            }
            if ("1".equals(this.hng.is_private) && this.hnh.getVisibility() != 0) {
                this.hnf.setVisibility(0);
            } else {
                this.hnf.setVisibility(8);
            }
            if ("1".equals(this.hng.is_agreed)) {
                am.c(this.hnj, d.f.icon_home_card_like_s);
            } else {
                am.c(this.hnj, d.f.btn_video_agree);
            }
            if (this.hng.act_info != null && !StringUtils.isNull(this.hng.act_info.activity_name) && this.hnh.getVisibility() != 0) {
                this.hne.setVisibility(0);
                this.hmY.setText(this.hng.act_info.activity_name);
            } else {
                this.hne.setVisibility(8);
            }
            bDP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDP() {
        if (this.dPN || (this.hng.author_info != null && !"0".equals(this.hng.author_info.is_follow))) {
            this.hmW.setVisibility(4);
            this.hmW.setClickable(false);
            return;
        }
        this.hmW.setVisibility(0);
        this.hmW.setClickable(true);
    }

    private void bDQ() {
        if (getActivity() != null) {
            if (this.hnv == null || !this.hnv.isShowing()) {
                this.hnv = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(d.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.j.confirm_title);
                ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.hnv.w(inflate);
                this.hnv.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.hnv.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.hnv.ch(1);
                this.hnv.cg(d.C0140d.cp_cont_b);
                this.hnv.au(true);
                this.hnv.b(getPageContext());
                this.hnv.xf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDR() {
        if (!com.baidu.adp.lib.util.j.jE() || com.baidu.adp.lib.util.j.jF()) {
            return true;
        }
        if (!this.hni || com.baidu.tieba.video.g.bAi().bAj()) {
            return false;
        }
        if (this.hnc != null) {
            this.hnc.setVisibility(0);
        }
        pausePlay();
        bDQ();
        return false;
    }

    private void aSg() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bDR() || com.baidu.tieba.video.g.bAi().bAj()) && this.hmQ != null && this.hnc != null) {
            this.hmQ.start();
            int se = x.bkW().se(this.bdb);
            if (se != 0) {
                this.hmQ.rH(se);
            }
            this.hnc.setVisibility(8);
            bjW();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.axD == null) {
            this.axD = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axD.setDuration(200L);
        }
        return this.axD;
    }

    public long bDS() {
        if (this.hnd != null) {
            this.hnd.setVisibility(8);
        }
        if (this.hnh != null) {
            this.hnh.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
    public void Oz() {
        if (this.hmQ.isPlaying()) {
            x.bkW().aD(this.bdb, this.hmQ.getCurrentPosition());
            this.hmQ.pause();
            this.hnc.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bDR() || com.baidu.tieba.video.g.bAi().bAj()) {
            this.hmQ.start();
            this.hnc.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
    public void q(float f, float f2) {
        if (ba.aV(getActivity()) && !this.hnq) {
            bDT();
            if (this.hng != null && "0".equals(this.hng.is_agreed)) {
                uV(this.hmP);
            }
        }
    }

    private void bDT() {
        if (this.mRootView != null) {
            this.hnq = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(d.f.icon_video_like);
            if (this.hns == null) {
                this.hns = new RelativeLayout.LayoutParams(-2, -2);
                this.hns.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.hns);
            }
            if (this.hnr == null) {
                this.hnr = new AnimatorSet();
                this.hnr.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.hnq = false;
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
            this.hnr.setTarget(imageView);
            this.hnr.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.hnr.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
    public void OA() {
        if (this.hng != null && this.hng.author_info != null) {
            long c = com.baidu.adp.lib.g.b.c(this.hng.author_info.user_id, 0L);
            long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = c == c2;
            if (c == 0 && c2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(c, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.hmQ != null) {
            return this.hmQ.getMediaIDs();
        }
        return null;
    }

    public String bDU() {
        if (this.hmQ != null) {
            return this.hmQ.getMediaId();
        }
        return null;
    }

    public boolean bDV() {
        if (this.hnu == null || this.hnu.Ht() == null || !this.hnu.Ht().isVisible()) {
            return false;
        }
        this.hnu.Ht().hide();
        this.hnl.setVisibility(0);
        if ((this.hnu.Ht().eO(28) instanceof c) && ((c) this.hnu.Ht().eO(28)).getInputView() != null && ((c) this.hnu.Ht().eO(28)).getInputView().getText() != null) {
            this.hnm.setText(StringUtils.isNull(((c) this.hnu.Ht().eO(28)).getInputView().getText().toString()) ? d.j.reply_something : d.j.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.hnu != null) {
            this.hnu.onActivityResult(i, i2, intent);
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
        if (this.hnu != null && this.hnu.Ht() != null) {
            this.hnu.Ht().onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }
}
