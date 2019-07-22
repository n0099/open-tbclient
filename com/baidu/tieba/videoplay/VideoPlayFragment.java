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
import com.baidu.adp.base.d;
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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
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
/* loaded from: classes6.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0260a {
    private e bCx;
    private String bGR;
    private String bWb;
    private boolean cEO;
    public ImageView dlg;
    private n dnw;
    private AlphaAnimation dpH;
    private String dxn;
    private boolean fYQ;
    private View fjW;
    private j.b ivg;
    private QuickVideoView.c ivx;
    public QuickVideoView jEC;
    private TbImageView jED;
    public HeadImageView jEE;
    public LinearLayout jEF;
    public LinearLayout jEG;
    public LinearLayout jEH;
    public ImageView jEI;
    public ImageView jEJ;
    public ImageView jEK;
    public TextView jEL;
    public TextView jEM;
    public TextView jEN;
    public TextView jEO;
    public TextView jEP;
    public ImageView jEQ;
    private LinearLayout jER;
    public LinearLayout jES;
    public LinearLayout jET;
    public VideoItemData jEU;
    private TextView jEV;
    private boolean jEW;
    public ImageView jEX;
    public TextView jEY;
    private View jEZ;
    private TextView jFa;
    private int jFb;
    private int jFc;
    private int jFd;
    private com.baidu.tieba.view.a jFe;
    protected Animation jFf;
    private boolean jFg;
    private AnimatorSet jFh;
    private RelativeLayout.LayoutParams jFi;
    private com.baidu.tieba.videoplay.editor.a jFk;
    com.baidu.tbadk.core.dialog.a jFl;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int jEA = 0;
    private int jEB = 1;
    private ForumManageModel eDv = null;
    private com.baidu.tbadk.baseEditMark.a hKA = null;
    private com.baidu.tbadk.coreExtra.model.a bTm = null;
    private BdUniqueId XE = BdUniqueId.gen();
    private boolean jFj = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.jEU != null && VideoPlayFragment.this.jEU.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jEU.author_info.user_id) && data != null && VideoPlayFragment.this.jEU.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.XE)) ? false : false;
                    if (data.chF == null) {
                        if (!data.Hs) {
                            if (z && !"0".equals(VideoPlayFragment.this.jEU.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.jEU.author_info.is_follow = "0";
                                VideoPlayFragment.this.cxr();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.jEW) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.jEU));
                                    return;
                                }
                                VideoPlayFragment.this.jEU.author_info.is_follow = "1";
                                VideoPlayFragment.this.cxr();
                            }
                        } else {
                            VideoPlayFragment.this.jEU.author_info.is_follow = "0";
                            VideoPlayFragment.this.cxr();
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
                VideoPlayFragment.this.cxt();
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
        this.jEU = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.jFd = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.dxn = arguments.getString("from");
        this.bGR = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.jEU != null && this.jEU.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.jEU.author_info.user_id)) {
            this.fYQ = true;
        }
        this.dnw = new n(getActivity());
        this.dnw.a(this.jEU);
        this.dnw.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bh(int i, int i2) {
                if (VideoPlayFragment.this.ivg != null) {
                    VideoPlayFragment.this.ivg.bh(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.jEC = (QuickVideoView) this.mRootView.findViewById(R.id.videoView);
        this.jEC.setPlayerReuseEnable(true);
        this.jEC.setContinuePlayEnable(true);
        this.jEC.setBusiness(this.dnw);
        this.jEC.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.ivx != null) {
                    VideoPlayFragment.this.ivx.onStart();
                }
            }
        });
        this.jEC.setNeedRecovery(true);
        if (this.jEU != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.bWO = this.jEU.thread_id;
            zVar.eFy = this.jEU.forum_id;
            zVar.ixC = this.jEU.mMd5;
            zVar.bGR = "";
            zVar.mSource = this.jEU.mRecomSource;
            zVar.ixB = this.jEU.mRecomAbTag;
            zVar.ixz = this.jEU.mRecomWeight;
            if (this.mRect != null) {
                zVar.ixD = "1";
            } else {
                zVar.ixD = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.ixE = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.ixA = this.dxn;
                zVar.bGR = this.bGR;
                zVar.ixy = this.jEU.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.dnw.setVideoStatsData(zVar);
        }
        this.jED = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.jED.setDefaultBgResource(R.drawable.icon_play_bg);
        this.jED.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.ahY()) {
            this.fjW = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.fjW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.fjW.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.dlg = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.jEE = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.jEE.setDefaultResource(17170445);
        this.jEE.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jEE.setIsRound(true);
        this.jEI = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.jEX = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.jEL = (TextView) this.mRootView.findViewById(R.id.video_title);
        this.jEM = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.jEG = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.jEN = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.jEF = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.jEO = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.jEP = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.jEJ = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.jEK = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cxm();
        this.jEQ = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.jER = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.jES = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.jET = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.jEH = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.jEY = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.jEZ = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.jEZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.jEZ.setVisibility(4);
                    if (VideoPlayFragment.this.jFk != null && VideoPlayFragment.this.jFk.arY() != null) {
                        VideoPlayFragment.this.jFk.arY().qk();
                    }
                    if (VideoPlayFragment.this.jEU != null) {
                        an anVar = new an("c13025");
                        anVar.bT("tid", VideoPlayFragment.this.jEU.thread_id);
                        anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.bT("fid", VideoPlayFragment.this.jEU.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.jFa = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.jEV = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.jEV.setVisibility(8);
        String string = b.ahO().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jEV.setText(string);
        }
        final String string2 = b.ahO().getString("nani_key_download_link_url", null);
        this.jEV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    bb.ajC().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cxq();
        this.jEE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jEU != null && VideoPlayFragment.this.jEU.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jEU.author_info.user_id) && VideoPlayFragment.this.jEU != null && VideoPlayFragment.this.jEU.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jEU.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(c, z, false)));
                    an anVar = new an("c12798");
                    anVar.bT("tid", VideoPlayFragment.this.jEU.thread_id);
                    anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.jES.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jEU != null && VideoPlayFragment.this.jEU.act_info != null) {
                    com.baidu.tbadk.browser.a.af(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.jEU.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.bT("tid", VideoPlayFragment.this.jEU.thread_id);
                    anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.jEL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cxo();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jEU != null && !StringUtils.isNull(VideoPlayFragment.this.jEU.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.jEU.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.dlg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cxp();
            }
        });
        this.jEG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cxo();
                an anVar = new an("c12796");
                anVar.bT("tid", VideoPlayFragment.this.jEU.thread_id);
                anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.jEF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Cv(VideoPlayFragment.this.jEA);
            }
        });
        this.jEH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.akY();
                an anVar = new an("c12797");
                anVar.bT("tid", VideoPlayFragment.this.jEU.thread_id);
                anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.jEI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bd.cF(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jEU != null && VideoPlayFragment.this.jEU.author_info != null) {
                    VideoPlayFragment.this.bTm.a(true, VideoPlayFragment.this.jEU.author_info.portrait, VideoPlayFragment.this.jEU.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.XE, VideoPlayFragment.this.jEU.forum_id, "0");
                    VideoPlayFragment.this.jEU.author_info.is_follow = "1";
                    VideoPlayFragment.this.cxr();
                }
            }
        });
        this.dpH = new AlphaAnimation(1.0f, 0.0f);
        this.dpH.setDuration(100L);
        this.dpH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.jED != null) {
                    VideoPlayFragment.this.jED.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.jFb = this.mRect.right - this.mRect.left;
            this.jFc = this.mRect.bottom - this.mRect.top;
            this.jED.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.jED.getWidth();
                    int height = VideoPlayFragment.this.jED.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jEU.video_height, 0) > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jEU.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jEU.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jEU.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jFb, VideoPlayFragment.this.jFc);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.jED.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jFc > 0 || VideoPlayFragment.this.jFb <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.jFb;
                                f = i / VideoPlayFragment.this.jFc;
                            }
                            VideoPlayFragment.this.jED.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.jED.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.jEW) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jFb, VideoPlayFragment.this.jFc);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.jED.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jFc > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.jED.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.jED.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.jEW) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.jED.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.jED.getWidth();
                    int height = VideoPlayFragment.this.jED.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jEU.video_height, 0) > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jEU.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jEU.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jEU.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.jED.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.jED.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.jEW) {
            cxn();
        }
        if (this.jEU != null && !StringUtils.isNull(this.jEU.video_url)) {
            Gk(this.jEU.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.ivg = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.ivx = cVar;
    }

    private void initEditor() {
        this.jFk = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().cK(getActivity());
        if (this.jFk != null && this.jEU != null) {
            this.jFk.a(getPageContext());
            this.jFk.ad(this.jEU.thread_id, this.jEU.forum_id, this.jEU.forum_name);
            this.jFk.a(new a.InterfaceC0424a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0424a
                public void rQ(boolean z) {
                    VideoPlayFragment.this.jEZ.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.jFa.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.jFa.setText(StringUtils.isNull(((c) VideoPlayFragment.this.jFk.arY().kp(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.jEU != null && z) {
                        long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jEU.comment_num, 0L) + 1;
                        VideoPlayFragment.this.jEU.comment_num = String.valueOf(c);
                        VideoPlayFragment.this.jEN.setText(aq.aO(c));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.jFk.arY(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        if (this.jEU != null) {
            String str = this.jEU.forum_id;
            String str2 = this.jEU.forum_name;
            String str3 = this.jEU.title;
            String str4 = this.jEU.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.jEU.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str3;
            eVar.content = format;
            eVar.ckI = "";
            eVar.linkUrl = str5;
            eVar.bMt = 2;
            eVar.extData = str4;
            eVar.ckL = 3;
            eVar.fid = str;
            eVar.ckC = str2;
            eVar.tid = str4;
            eVar.ckv = true;
            eVar.ckK = 0;
            eVar.ckP = 2;
            if (parse != null) {
                eVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.jEU.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.jEU.title;
            originalThreadInfo.threadId = this.jEU.thread_id;
            eVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.ckL);
            bundle.putInt("obj_type", eVar.ckP);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMt);
            eVar.E(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), eVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.bbB().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fYQ) {
            this.eDv = new ForumManageModel(getPageContext());
            this.eDv.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.eDv.getLoadDataMode()) {
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
        this.hKA = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.hKA != null) {
            this.hKA.a(new a.InterfaceC0233a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0233a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.hKA != null) {
                            VideoPlayFragment.this.hKA.dx(z2);
                        }
                        if (VideoPlayFragment.this.jEU != null) {
                            if (z2) {
                                VideoPlayFragment.this.jEU.mark_id = VideoPlayFragment.this.jEU.post_id;
                            } else {
                                VideoPlayFragment.this.jEU.mark_id = null;
                            }
                        }
                        if (z2) {
                            VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(R.string.add_mark));
                            return;
                        } else {
                            VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(R.string.remove_mark));
                            return;
                        }
                    }
                    VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(R.string.update_mark_failed));
                }
            });
        }
        this.bTm = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.jFj = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cxq();
        if (Build.VERSION.SDK_INT >= 17) {
            this.jEC.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.jEW && i == 3 && VideoPlayFragment.this.jED.getVisibility() == 0) {
                        VideoPlayFragment.this.jED.clearAnimation();
                        VideoPlayFragment.this.jED.startAnimation(VideoPlayFragment.this.dpH);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.jEC.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.jEC != null) {
                    VideoPlayFragment.this.jEC.seekTo(0);
                    VideoPlayFragment.this.jEC.start();
                    VideoPlayFragment.this.aZv();
                    VideoPlayFragment.x(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.cxl();
                    }
                }
            }
        });
        this.jEC.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.jED != null) {
                        VideoPlayFragment.this.jED.clearAnimation();
                        VideoPlayFragment.this.jED.startAnimation(VideoPlayFragment.this.dpH);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxl() {
        if (this.jEK != null && this.jEJ != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.jEJ.clearAnimation();
            this.jEK.clearAnimation();
            this.jEJ.setVisibility(8);
            this.jEK.setVisibility(0);
            this.jEK.startAnimation(scaleAnimation2);
            this.jEJ.startAnimation(scaleAnimation);
        }
    }

    private void cxm() {
        if (this.jEK != null && this.jEJ != null) {
            this.jEJ.clearAnimation();
            this.jEK.clearAnimation();
            this.jEJ.setVisibility(0);
            this.jEK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cv(int i) {
        int i2;
        if (bd.cF(getActivity()) && this.jEU != null) {
            if (i == this.jEA) {
                if ("1".equals(this.jEU.is_agreed)) {
                    i2 = 1;
                    this.jEU.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jEU.agree_num, 0) - 1);
                    this.jEU.is_agreed = "0";
                } else {
                    this.jEU.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jEU.agree_num, 0) + 1);
                    this.jEU.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.jEU.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jEU.agree_num, 0) + 1);
                this.jEU.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.bT("tid", this.jEU.thread_id);
            anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.jEA) {
                anVar.P("obj_type", i2);
            } else {
                anVar.P("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            cxq();
            if (this.jEX != null && i2 == 0) {
                this.jEX.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.jEU.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.jEU));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.jEU != null && !StringUtils.isNull(this.jEU.video_url)) {
            this.cEO = true;
            if (this.jEW) {
                aZv();
                bLc();
                if (this.jEU != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.bT("tid", this.jEU.thread_id);
                    anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.P("obj_type", 0);
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
        stopPlay();
        if (this.jFk != null && this.jFk.arY() != null) {
            this.jFk.arY().hide();
            this.jEZ.setVisibility(0);
            this.jFa.setText(StringUtils.isNull(((c) this.jFk.arY().kp(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.jFk != null) {
            this.jFk.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.jEW = z;
        if (this.cEO) {
            if (this.jEW && (!this.jFj || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.jEU != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.bT("tid", this.jEU.thread_id);
                    anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.P("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                cxn();
                this.jFj = false;
                return;
            }
            cxm();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cxn() {
        if (this.jEU != null) {
            an anVar = new an("c12590");
            anVar.bT("tid", this.jEU.thread_id);
            anVar.bT("fid", this.jEU.forum_id);
            anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.P("obj_locate", this.jFd);
            anVar.P("obj_param2", 1);
            anVar.bT("obj_param1", aq.isEmpty(this.jEU.mRecomWeight) ? "0" : this.jEU.mRecomWeight);
            anVar.bT("extra", aq.isEmpty(this.jEU.mRecomExtra) ? "0" : this.jEU.mRecomExtra);
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bGR);
            anVar.bT("ab_tag", aq.isEmpty(this.jEU.mRecomAbTag) ? "0" : this.jEU.mRecomAbTag);
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aq.isEmpty(this.jEU.mRecomSource) ? "0" : this.jEU.mRecomSource);
            anVar.bT("obj_type", this.dxn);
            anVar.P("is_vertical", 1);
            TiebaStatic.log(anVar);
        }
    }

    private void Gk(String str) {
        if (this.jEC != null && str != null && !str.equals(this.bWb)) {
            this.jEC.setRecoveryState(0);
            this.jEC.setVideoPath(str, this.jEU.thread_id);
            this.bWb = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.ctE().ctF() || cxt()) {
            cdE();
            if (this.jEQ != null) {
                this.jEQ.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.jED.getVisibility() == 0) {
                this.jED.clearAnimation();
                this.jED.startAnimation(this.dpH);
            }
            if (this.jEC != null) {
                this.jEC.start();
                aZv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZv() {
        if (this.jEU != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.bWO = this.jEU.thread_id;
            zVar.eFy = this.jEU.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.jEU.mRecomSource;
            zVar.ixy = this.jEU.mRecomAbTag;
            zVar.ixz = this.jEU.mRecomWeight;
            zVar.ixA = "";
            zVar.bGR = "";
            zVar.ixC = this.jEU.mMd5;
            if (this.mRect != null) {
                zVar.ixD = "1";
            } else {
                zVar.ixD = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.ixE = "1";
                zVar.mLocate = "auto_midpage";
                zVar.ixA = "index";
            }
            com.baidu.tieba.play.l.a(this.jEU.mMd5, "", "1", zVar);
        }
    }

    private void cdE() {
        if (com.baidu.adp.lib.util.j.ke()) {
            com.baidu.tieba.video.g.ctE().eo(getContext());
        }
    }

    private void pausePlay() {
        if (this.jEC != null) {
            this.jEC.pause();
        }
    }

    private void stopPlay() {
        if (this.jEC != null) {
            this.jEC.setRecoveryState(5);
            this.jEC.ceg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxo() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.jEU.thread_id, this.jEU.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.jEU.forum_id));
        createNormalCfg.setForumName(this.jEU.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxp() {
        if (this.bCx == null) {
            this.jFe = new com.baidu.tieba.view.a(getActivity());
            this.bCx = new e(getActivity(), this.jFe.ahb());
            this.bCx.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.jEC.setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.jFe != null) {
            ArrayList arrayList = new ArrayList();
            a.C0425a c0425a = new a.C0425a(this.jFe);
            c0425a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bCx.dismiss();
                    if (VideoPlayFragment.this.jEU != null) {
                        boolean z = VideoPlayFragment.this.jEU.post_id != null && VideoPlayFragment.this.jEU.post_id.equals(VideoPlayFragment.this.jEU.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.jEU.thread_id);
                        markData.setPostId(VideoPlayFragment.this.jEU.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.jEU.thread_id);
                        markData.setForumId(VideoPlayFragment.this.jEU.forum_id);
                        if (VideoPlayFragment.this.hKA != null) {
                            VideoPlayFragment.this.hKA.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.hKA.aaD();
                            } else {
                                VideoPlayFragment.this.hKA.aaC();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.jEU != null && this.jEU.post_id != null && this.jEU.post_id.equals(this.jEU.mark_id)) {
                z = true;
            }
            if (z) {
                c0425a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0425a.setText(getResources().getString(R.string.mark));
            }
            arrayList.add(c0425a);
            a.C0425a c0425a2 = new a.C0425a(getActivity().getString(R.string.delete), this.jFe);
            c0425a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bCx.dismiss();
                    if (bd.cF(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jEU != null) {
                        String str = VideoPlayFragment.this.jEU.thread_id;
                        String str2 = VideoPlayFragment.this.jEU.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.jEU.post_id, true)));
                    }
                }
            });
            c0425a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0425a2);
            if (this.fYQ) {
                a.C0425a c0425a3 = new a.C0425a(getActivity().getString(R.string.delete), this.jFe);
                c0425a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.bCx.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.hu(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.jEU != null) {
                                    VideoPlayFragment.this.eDv.a(VideoPlayFragment.this.jEU.forum_id, VideoPlayFragment.this.jEU.forum_name, VideoPlayFragment.this.jEU.thread_id, VideoPlayFragment.this.jEU.post_id, 0, 0, VideoPlayFragment.this.fYQ);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                                }
                            }
                        });
                        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.dQ(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.agI();
                    }
                });
                c0425a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0425a3);
            }
            this.jFe.W(arrayList);
        }
        this.bCx.show();
    }

    private void cxq() {
        if (this.jEU != null) {
            this.jED.startLoad(this.jEU.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.jEU.title);
            if (StringUtils.isNull(this.jEU.title) || matcher.matches()) {
                this.jEL.setVisibility(8);
            } else {
                this.jEL.setVisibility(0);
                this.jEL.setText(this.jEU.title);
            }
            this.jEN.setText(aq.aO(com.baidu.adp.lib.g.b.c(this.jEU.comment_num, 0L)));
            this.jEO.setText(aq.aO(com.baidu.adp.lib.g.b.c(this.jEU.agree_num, 0L)));
            this.jEP.setText(aq.aO(com.baidu.adp.lib.g.b.c(this.jEU.share_num, 0L)));
            if (this.jEU.author_info != null) {
                if (!StringUtils.isNull(this.jEU.author_info.portrait) && this.jEU.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.jEE.startLoad(this.jEU.author_info.portrait, 10, false);
                } else {
                    this.jEE.startLoad(this.jEU.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.jEU.author_info.ctA())) {
                    this.jEY.setVisibility(8);
                } else {
                    this.jEY.setVisibility(0);
                    this.jEY.setText("@" + this.jEU.author_info.ctA());
                }
            }
            if ("1".equals(this.jEU.is_private) && this.jEV.getVisibility() != 0) {
                this.jET.setVisibility(0);
            } else {
                this.jET.setVisibility(8);
            }
            if ("1".equals(this.jEU.is_agreed)) {
                am.c(this.jEX, (int) R.drawable.icon_card_like_white_full_s);
            } else {
                am.c(this.jEX, (int) R.drawable.btn_video_agree);
            }
            if (this.jEU.act_info != null && !StringUtils.isNull(this.jEU.act_info.activity_name) && this.jEV.getVisibility() != 0) {
                this.jES.setVisibility(0);
                this.jEM.setText(this.jEU.act_info.activity_name);
            } else {
                this.jES.setVisibility(8);
            }
            cxr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxr() {
        if (this.fYQ || (this.jEU.author_info != null && !"0".equals(this.jEU.author_info.is_follow))) {
            this.jEI.setVisibility(4);
            this.jEI.setClickable(false);
            return;
        }
        this.jEI.setVisibility(0);
        this.jEI.setClickable(true);
    }

    private void cxs() {
        if (getActivity() != null) {
            if (this.jFl == null || !this.jFl.isShowing()) {
                this.jFl = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.jFl.aH(inflate);
                this.jFl.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.jFl.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.jFl.hx(1);
                this.jFl.hv(R.color.cp_cont_b);
                this.jFl.dQ(true);
                this.jFl.b(getPageContext());
                this.jFl.agI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxt() {
        if (!com.baidu.adp.lib.util.j.kc() || com.baidu.adp.lib.util.j.kd()) {
            return true;
        }
        if (!this.jEW || com.baidu.tieba.video.g.ctE().ctF()) {
            return false;
        }
        if (this.jEQ != null) {
            this.jEQ.setVisibility(0);
        }
        pausePlay();
        cxs();
        return false;
    }

    private void bLc() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cxt() || com.baidu.tieba.video.g.ctE().ctF()) && this.jEC != null && this.jEQ != null) {
            this.jEC.start();
            this.jEQ.setVisibility(8);
            cdE();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.jFf == null) {
            this.jFf = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.jFf;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0260a
    public void aAp() {
        if (this.jEC.isPlaying()) {
            this.jEC.pause();
            this.jEQ.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cxt() || com.baidu.tieba.video.g.ctE().ctF()) {
            this.jEC.start();
            this.jEQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0260a
    public void x(float f, float f2) {
        if (bd.cF(getActivity()) && !this.jFg) {
            cxu();
            if (this.jEU != null && "0".equals(this.jEU.is_agreed)) {
                Cv(this.jEB);
            }
        }
    }

    private void cxu() {
        if (this.mRootView != null) {
            this.jFg = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.jFi == null) {
                this.jFi = new RelativeLayout.LayoutParams(-2, -2);
                this.jFi.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.jFi);
            }
            if (this.jFh == null) {
                this.jFh = new AnimatorSet();
                this.jFh.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.jFg = false;
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
            this.jFh.setTarget(imageView);
            this.jFh.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.jFh.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0260a
    public void aAq() {
        if (this.jEU != null && this.jEU.author_info != null) {
            long c = com.baidu.adp.lib.g.b.c(this.jEU.author_info.user_id, 0L);
            long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = c == c2;
            if (c == 0 && c2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(c, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.jEC != null) {
            return this.jEC.getMediaIDs();
        }
        return null;
    }

    public String cxv() {
        if (this.jEC != null) {
            return this.jEC.getMediaId();
        }
        return null;
    }

    public boolean cxw() {
        if (this.jFk == null || this.jFk.arY() == null || !this.jFk.arY().isVisible()) {
            return false;
        }
        this.jFk.arY().hide();
        this.jEZ.setVisibility(0);
        if ((this.jFk.arY().kp(28) instanceof c) && ((c) this.jFk.arY().kp(28)).getInputView() != null && ((c) this.jFk.arY().kp(28)).getInputView().getText() != null) {
            this.jFa.setText(StringUtils.isNull(((c) this.jFk.arY().kp(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.jFk != null) {
            this.jFk.onActivityResult(i, i2, intent);
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
        if (this.jFk != null && this.jFk.arY() != null) {
            this.jFk.arY().onChangeSkinType(i);
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
