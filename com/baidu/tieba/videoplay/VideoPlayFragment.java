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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0265a {
    private e bCx;
    private String bGS;
    private String bWh;
    private boolean cEV;
    public ImageView dln;
    private n dnD;
    private AlphaAnimation dpO;
    private String dxu;
    private View eVR;
    private boolean fZG;
    private QuickVideoView.c iwA;
    private j.b iwj;
    public QuickVideoView jFJ;
    private TbImageView jFK;
    public HeadImageView jFL;
    public LinearLayout jFM;
    public LinearLayout jFN;
    public LinearLayout jFO;
    public ImageView jFP;
    public ImageView jFQ;
    public ImageView jFR;
    public TextView jFS;
    public TextView jFT;
    public TextView jFU;
    public TextView jFV;
    public TextView jFW;
    public ImageView jFX;
    private LinearLayout jFY;
    public LinearLayout jFZ;
    public LinearLayout jGa;
    public VideoItemData jGb;
    private TextView jGc;
    private boolean jGd;
    public ImageView jGe;
    public TextView jGf;
    private View jGg;
    private TextView jGh;
    private int jGi;
    private int jGj;
    private int jGk;
    private com.baidu.tieba.view.a jGl;
    protected Animation jGm;
    private boolean jGn;
    private AnimatorSet jGo;
    private RelativeLayout.LayoutParams jGp;
    private com.baidu.tieba.videoplay.editor.a jGr;
    com.baidu.tbadk.core.dialog.a jGs;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int jFH = 0;
    private int jFI = 1;
    private ForumManageModel eDC = null;
    private com.baidu.tbadk.baseEditMark.a hLu = null;
    private com.baidu.tbadk.coreExtra.model.a bTs = null;
    private BdUniqueId XE = BdUniqueId.gen();
    private boolean jGq = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.jGb != null && VideoPlayFragment.this.jGb.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jGb.author_info.user_id) && data != null && VideoPlayFragment.this.jGb.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.XE)) ? false : false;
                    if (data.chM == null) {
                        if (!data.Hs) {
                            if (z && !"0".equals(VideoPlayFragment.this.jGb.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.jGb.author_info.is_follow = "0";
                                VideoPlayFragment.this.cxN();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.jGd) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.jGb));
                                    return;
                                }
                                VideoPlayFragment.this.jGb.author_info.is_follow = "1";
                                VideoPlayFragment.this.cxN();
                            }
                        } else {
                            VideoPlayFragment.this.jGb.author_info.is_follow = "0";
                            VideoPlayFragment.this.cxN();
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
                VideoPlayFragment.this.cxP();
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
        this.jGb = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.jGk = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.dxu = arguments.getString("from");
        this.bGS = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.jGb != null && this.jGb.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.jGb.author_info.user_id)) {
            this.fZG = true;
        }
        this.dnD = new n(getActivity());
        this.dnD.a(this.jGb);
        this.dnD.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bh(int i, int i2) {
                if (VideoPlayFragment.this.iwj != null) {
                    VideoPlayFragment.this.iwj.bh(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.jFJ = (QuickVideoView) this.mRootView.findViewById(R.id.videoView);
        this.jFJ.setPlayerReuseEnable(true);
        this.jFJ.setContinuePlayEnable(true);
        this.jFJ.setBusiness(this.dnD);
        this.jFJ.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.iwA != null) {
                    VideoPlayFragment.this.iwA.onStart();
                }
            }
        });
        this.jFJ.setNeedRecovery(true);
        if (this.jGb != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.bWU = this.jGb.thread_id;
            zVar.eFF = this.jGb.forum_id;
            zVar.iyF = this.jGb.mMd5;
            zVar.bGS = "";
            zVar.mSource = this.jGb.mRecomSource;
            zVar.iyE = this.jGb.mRecomAbTag;
            zVar.iyC = this.jGb.mRecomWeight;
            if (this.mRect != null) {
                zVar.iyG = "1";
            } else {
                zVar.iyG = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.iyH = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.iyD = this.dxu;
                zVar.bGS = this.bGS;
                zVar.iyB = this.jGb.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.dnD.setVideoStatsData(zVar);
        }
        this.jFK = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.jFK.setDefaultBgResource(R.drawable.icon_play_bg);
        this.jFK.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.aia()) {
            this.eVR = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.eVR.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.eVR.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.dln = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.jFL = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.jFL.setDefaultResource(17170445);
        this.jFL.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jFL.setIsRound(true);
        this.jFP = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.jGe = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.jFS = (TextView) this.mRootView.findViewById(R.id.video_title);
        this.jFT = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.jFN = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.jFU = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.jFM = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.jFV = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.jFW = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.jFQ = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.jFR = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cxI();
        this.jFX = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.jFY = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.jFZ = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.jGa = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.jFO = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.jGf = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.jGg = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.jGg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.jGg.setVisibility(4);
                    if (VideoPlayFragment.this.jGr != null && VideoPlayFragment.this.jGr.asa() != null) {
                        VideoPlayFragment.this.jGr.asa().qk();
                    }
                    if (VideoPlayFragment.this.jGb != null) {
                        an anVar = new an("c13025");
                        anVar.bT("tid", VideoPlayFragment.this.jGb.thread_id);
                        anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.bT("fid", VideoPlayFragment.this.jGb.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.jGh = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.jGc = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.jGc.setVisibility(8);
        String string = b.ahQ().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jGc.setText(string);
        }
        final String string2 = b.ahQ().getString("nani_key_download_link_url", null);
        this.jGc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    bb.ajE().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cxM();
        this.jFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jGb != null && VideoPlayFragment.this.jGb.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jGb.author_info.user_id) && VideoPlayFragment.this.jGb != null && VideoPlayFragment.this.jGb.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jGb.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(c, z, false)));
                    an anVar = new an("c12798");
                    anVar.bT("tid", VideoPlayFragment.this.jGb.thread_id);
                    anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.jFZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jGb != null && VideoPlayFragment.this.jGb.act_info != null) {
                    com.baidu.tbadk.browser.a.af(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.jGb.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.bT("tid", VideoPlayFragment.this.jGb.thread_id);
                    anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.jFS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cxK();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jGb != null && !StringUtils.isNull(VideoPlayFragment.this.jGb.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.jGb.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.dln.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cxL();
            }
        });
        this.jFN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cxK();
                an anVar = new an("c12796");
                anVar.bT("tid", VideoPlayFragment.this.jGb.thread_id);
                anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.jFM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Cx(VideoPlayFragment.this.jFH);
            }
        });
        this.jFO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.ala();
                an anVar = new an("c12797");
                anVar.bT("tid", VideoPlayFragment.this.jGb.thread_id);
                anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.jFP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bd.cF(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jGb != null && VideoPlayFragment.this.jGb.author_info != null) {
                    VideoPlayFragment.this.bTs.a(true, VideoPlayFragment.this.jGb.author_info.portrait, VideoPlayFragment.this.jGb.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.XE, VideoPlayFragment.this.jGb.forum_id, "0");
                    VideoPlayFragment.this.jGb.author_info.is_follow = "1";
                    VideoPlayFragment.this.cxN();
                }
            }
        });
        this.dpO = new AlphaAnimation(1.0f, 0.0f);
        this.dpO.setDuration(100L);
        this.dpO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.jFK != null) {
                    VideoPlayFragment.this.jFK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.jGi = this.mRect.right - this.mRect.left;
            this.jGj = this.mRect.bottom - this.mRect.top;
            this.jFK.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.jFK.getWidth();
                    int height = VideoPlayFragment.this.jFK.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jGb.video_height, 0) > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jGb.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jGb.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jGb.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jGi, VideoPlayFragment.this.jGj);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.jFK.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jGj > 0 || VideoPlayFragment.this.jGi <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.jGi;
                                f = i / VideoPlayFragment.this.jGj;
                            }
                            VideoPlayFragment.this.jFK.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.jFK.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.jGd) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jGi, VideoPlayFragment.this.jGj);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.jFK.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jGj > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.jFK.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.jFK.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.jGd) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.jFK.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.jFK.getWidth();
                    int height = VideoPlayFragment.this.jFK.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jGb.video_height, 0) > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jGb.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jGb.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jGb.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.jFK.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.jFK.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.jGd) {
            cxJ();
        }
        if (this.jGb != null && !StringUtils.isNull(this.jGb.video_url)) {
            Gl(this.jGb.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.iwj = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.iwA = cVar;
    }

    private void initEditor() {
        this.jGr = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().cK(getActivity());
        if (this.jGr != null && this.jGb != null) {
            this.jGr.a(getPageContext());
            this.jGr.ad(this.jGb.thread_id, this.jGb.forum_id, this.jGb.forum_name);
            this.jGr.a(new a.InterfaceC0430a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0430a
                public void rR(boolean z) {
                    VideoPlayFragment.this.jGg.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.jGh.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.jGh.setText(StringUtils.isNull(((c) VideoPlayFragment.this.jGr.asa().kq(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.jGb != null && z) {
                        long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jGb.comment_num, 0L) + 1;
                        VideoPlayFragment.this.jGb.comment_num = String.valueOf(c);
                        VideoPlayFragment.this.jFU.setText(aq.aO(c));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.jGr.asa(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ala() {
        if (this.jGb != null) {
            String str = this.jGb.forum_id;
            String str2 = this.jGb.forum_name;
            String str3 = this.jGb.title;
            String str4 = this.jGb.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.jGb.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str3;
            eVar.content = format;
            eVar.ckP = "";
            eVar.linkUrl = str5;
            eVar.bMy = 2;
            eVar.extData = str4;
            eVar.ckS = 3;
            eVar.fid = str;
            eVar.ckJ = str2;
            eVar.tid = str4;
            eVar.ckC = true;
            eVar.ckR = 0;
            eVar.ckW = 2;
            if (parse != null) {
                eVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.jGb.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.jGb.title;
            originalThreadInfo.threadId = this.jGb.thread_id;
            eVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.ckS);
            bundle.putInt("obj_type", eVar.ckW);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMy);
            eVar.E(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), eVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.bbD().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fZG) {
            this.eDC = new ForumManageModel(getPageContext());
            this.eDC.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.eDC.getLoadDataMode()) {
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
        this.hLu = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.hLu != null) {
            this.hLu.a(new a.InterfaceC0238a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0238a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.hLu != null) {
                            VideoPlayFragment.this.hLu.dx(z2);
                        }
                        if (VideoPlayFragment.this.jGb != null) {
                            if (z2) {
                                VideoPlayFragment.this.jGb.mark_id = VideoPlayFragment.this.jGb.post_id;
                            } else {
                                VideoPlayFragment.this.jGb.mark_id = null;
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
        this.bTs = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.jGq = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cxM();
        if (Build.VERSION.SDK_INT >= 17) {
            this.jFJ.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.jGd && i == 3 && VideoPlayFragment.this.jFK.getVisibility() == 0) {
                        VideoPlayFragment.this.jFK.clearAnimation();
                        VideoPlayFragment.this.jFK.startAnimation(VideoPlayFragment.this.dpO);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.jFJ.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.jFJ != null) {
                    VideoPlayFragment.this.jFJ.seekTo(0);
                    VideoPlayFragment.this.jFJ.start();
                    VideoPlayFragment.this.aZx();
                    VideoPlayFragment.x(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.cxH();
                    }
                }
            }
        });
        this.jFJ.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.jFK != null) {
                        VideoPlayFragment.this.jFK.clearAnimation();
                        VideoPlayFragment.this.jFK.startAnimation(VideoPlayFragment.this.dpO);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxH() {
        if (this.jFR != null && this.jFQ != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.jFQ.clearAnimation();
            this.jFR.clearAnimation();
            this.jFQ.setVisibility(8);
            this.jFR.setVisibility(0);
            this.jFR.startAnimation(scaleAnimation2);
            this.jFQ.startAnimation(scaleAnimation);
        }
    }

    private void cxI() {
        if (this.jFR != null && this.jFQ != null) {
            this.jFQ.clearAnimation();
            this.jFR.clearAnimation();
            this.jFQ.setVisibility(0);
            this.jFR.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cx(int i) {
        int i2;
        if (bd.cF(getActivity()) && this.jGb != null) {
            if (i == this.jFH) {
                if ("1".equals(this.jGb.is_agreed)) {
                    i2 = 1;
                    this.jGb.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jGb.agree_num, 0) - 1);
                    this.jGb.is_agreed = "0";
                } else {
                    this.jGb.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jGb.agree_num, 0) + 1);
                    this.jGb.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.jGb.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jGb.agree_num, 0) + 1);
                this.jGb.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.bT("tid", this.jGb.thread_id);
            anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.jFH) {
                anVar.P("obj_type", i2);
            } else {
                anVar.P("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            cxM();
            if (this.jGe != null && i2 == 0) {
                this.jGe.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.jGb.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.jGb));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.jGb != null && !StringUtils.isNull(this.jGb.video_url)) {
            this.cEV = true;
            if (this.jGd) {
                aZx();
                bLq();
                if (this.jGb != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.bT("tid", this.jGb.thread_id);
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
        if (this.jGr != null && this.jGr.asa() != null) {
            this.jGr.asa().hide();
            this.jGg.setVisibility(0);
            this.jGh.setText(StringUtils.isNull(((c) this.jGr.asa().kq(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.jGr != null) {
            this.jGr.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.jGd = z;
        if (this.cEV) {
            if (this.jGd && (!this.jGq || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.jGb != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.bT("tid", this.jGb.thread_id);
                    anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.P("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                cxJ();
                this.jGq = false;
                return;
            }
            cxI();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cxJ() {
        if (this.jGb != null) {
            an anVar = new an("c12590");
            anVar.bT("tid", this.jGb.thread_id);
            anVar.bT("fid", this.jGb.forum_id);
            anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.P("obj_locate", this.jGk);
            anVar.P("obj_param2", 1);
            anVar.bT("obj_param1", aq.isEmpty(this.jGb.mRecomWeight) ? "0" : this.jGb.mRecomWeight);
            anVar.bT("extra", aq.isEmpty(this.jGb.mRecomExtra) ? "0" : this.jGb.mRecomExtra);
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bGS);
            anVar.bT("ab_tag", aq.isEmpty(this.jGb.mRecomAbTag) ? "0" : this.jGb.mRecomAbTag);
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aq.isEmpty(this.jGb.mRecomSource) ? "0" : this.jGb.mRecomSource);
            anVar.bT("obj_type", this.dxu);
            anVar.P("is_vertical", 1);
            TiebaStatic.log(anVar);
        }
    }

    private void Gl(String str) {
        if (this.jFJ != null && str != null && !str.equals(this.bWh)) {
            this.jFJ.setRecoveryState(0);
            this.jFJ.setVideoPath(str, this.jGb.thread_id);
            this.bWh = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.cua().cub() || cxP()) {
            cdW();
            if (this.jFX != null) {
                this.jFX.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.jFK.getVisibility() == 0) {
                this.jFK.clearAnimation();
                this.jFK.startAnimation(this.dpO);
            }
            if (this.jFJ != null) {
                this.jFJ.start();
                aZx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZx() {
        if (this.jGb != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.bWU = this.jGb.thread_id;
            zVar.eFF = this.jGb.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.jGb.mRecomSource;
            zVar.iyB = this.jGb.mRecomAbTag;
            zVar.iyC = this.jGb.mRecomWeight;
            zVar.iyD = "";
            zVar.bGS = "";
            zVar.iyF = this.jGb.mMd5;
            if (this.mRect != null) {
                zVar.iyG = "1";
            } else {
                zVar.iyG = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.iyH = "1";
                zVar.mLocate = "auto_midpage";
                zVar.iyD = "index";
            }
            com.baidu.tieba.play.l.a(this.jGb.mMd5, "", "1", zVar);
        }
    }

    private void cdW() {
        if (com.baidu.adp.lib.util.j.ke()) {
            com.baidu.tieba.video.g.cua().ep(getContext());
        }
    }

    private void pausePlay() {
        if (this.jFJ != null) {
            this.jFJ.pause();
        }
    }

    private void stopPlay() {
        if (this.jFJ != null) {
            this.jFJ.setRecoveryState(5);
            this.jFJ.cey();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxK() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.jGb.thread_id, this.jGb.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.jGb.forum_id));
        createNormalCfg.setForumName(this.jGb.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxL() {
        if (this.bCx == null) {
            this.jGl = new com.baidu.tieba.view.a(getActivity());
            this.bCx = new e(getActivity(), this.jGl.ahd());
            this.bCx.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.jFJ.setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.jGl != null) {
            ArrayList arrayList = new ArrayList();
            a.C0431a c0431a = new a.C0431a(this.jGl);
            c0431a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bCx.dismiss();
                    if (VideoPlayFragment.this.jGb != null) {
                        boolean z = VideoPlayFragment.this.jGb.post_id != null && VideoPlayFragment.this.jGb.post_id.equals(VideoPlayFragment.this.jGb.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.jGb.thread_id);
                        markData.setPostId(VideoPlayFragment.this.jGb.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.jGb.thread_id);
                        markData.setForumId(VideoPlayFragment.this.jGb.forum_id);
                        if (VideoPlayFragment.this.hLu != null) {
                            VideoPlayFragment.this.hLu.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.hLu.aaD();
                            } else {
                                VideoPlayFragment.this.hLu.aaC();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.jGb != null && this.jGb.post_id != null && this.jGb.post_id.equals(this.jGb.mark_id)) {
                z = true;
            }
            if (z) {
                c0431a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0431a.setText(getResources().getString(R.string.mark));
            }
            arrayList.add(c0431a);
            a.C0431a c0431a2 = new a.C0431a(getActivity().getString(R.string.delete), this.jGl);
            c0431a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bCx.dismiss();
                    if (bd.cF(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jGb != null) {
                        String str = VideoPlayFragment.this.jGb.thread_id;
                        String str2 = VideoPlayFragment.this.jGb.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.jGb.post_id, true)));
                    }
                }
            });
            c0431a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0431a2);
            if (this.fZG) {
                a.C0431a c0431a3 = new a.C0431a(getActivity().getString(R.string.delete), this.jGl);
                c0431a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.bCx.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.hu(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.jGb != null) {
                                    VideoPlayFragment.this.eDC.a(VideoPlayFragment.this.jGb.forum_id, VideoPlayFragment.this.jGb.forum_name, VideoPlayFragment.this.jGb.thread_id, VideoPlayFragment.this.jGb.post_id, 0, 0, VideoPlayFragment.this.fZG);
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
                        aVar.agK();
                    }
                });
                c0431a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0431a3);
            }
            this.jGl.W(arrayList);
        }
        this.bCx.show();
    }

    private void cxM() {
        if (this.jGb != null) {
            this.jFK.startLoad(this.jGb.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.jGb.title);
            if (StringUtils.isNull(this.jGb.title) || matcher.matches()) {
                this.jFS.setVisibility(8);
            } else {
                this.jFS.setVisibility(0);
                this.jFS.setText(this.jGb.title);
            }
            this.jFU.setText(aq.aO(com.baidu.adp.lib.g.b.c(this.jGb.comment_num, 0L)));
            this.jFV.setText(aq.aO(com.baidu.adp.lib.g.b.c(this.jGb.agree_num, 0L)));
            this.jFW.setText(aq.aO(com.baidu.adp.lib.g.b.c(this.jGb.share_num, 0L)));
            if (this.jGb.author_info != null) {
                if (!StringUtils.isNull(this.jGb.author_info.portrait) && this.jGb.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.jFL.startLoad(this.jGb.author_info.portrait, 10, false);
                } else {
                    this.jFL.startLoad(this.jGb.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.jGb.author_info.ctW())) {
                    this.jGf.setVisibility(8);
                } else {
                    this.jGf.setVisibility(0);
                    this.jGf.setText("@" + this.jGb.author_info.ctW());
                }
            }
            if ("1".equals(this.jGb.is_private) && this.jGc.getVisibility() != 0) {
                this.jGa.setVisibility(0);
            } else {
                this.jGa.setVisibility(8);
            }
            if ("1".equals(this.jGb.is_agreed)) {
                am.c(this.jGe, (int) R.drawable.icon_card_like_white_full_s);
            } else {
                am.c(this.jGe, (int) R.drawable.btn_video_agree);
            }
            if (this.jGb.act_info != null && !StringUtils.isNull(this.jGb.act_info.activity_name) && this.jGc.getVisibility() != 0) {
                this.jFZ.setVisibility(0);
                this.jFT.setText(this.jGb.act_info.activity_name);
            } else {
                this.jFZ.setVisibility(8);
            }
            cxN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxN() {
        if (this.fZG || (this.jGb.author_info != null && !"0".equals(this.jGb.author_info.is_follow))) {
            this.jFP.setVisibility(4);
            this.jFP.setClickable(false);
            return;
        }
        this.jFP.setVisibility(0);
        this.jFP.setClickable(true);
    }

    private void cxO() {
        if (getActivity() != null) {
            if (this.jGs == null || !this.jGs.isShowing()) {
                this.jGs = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.jGs.aH(inflate);
                this.jGs.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.jGs.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.jGs.hx(1);
                this.jGs.hv(R.color.cp_cont_b);
                this.jGs.dQ(true);
                this.jGs.b(getPageContext());
                this.jGs.agK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxP() {
        if (!com.baidu.adp.lib.util.j.kc() || com.baidu.adp.lib.util.j.kd()) {
            return true;
        }
        if (!this.jGd || com.baidu.tieba.video.g.cua().cub()) {
            return false;
        }
        if (this.jFX != null) {
            this.jFX.setVisibility(0);
        }
        pausePlay();
        cxO();
        return false;
    }

    private void bLq() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cxP() || com.baidu.tieba.video.g.cua().cub()) && this.jFJ != null && this.jFX != null) {
            this.jFJ.start();
            this.jFX.setVisibility(8);
            cdW();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.jGm == null) {
            this.jGm = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.jGm;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0265a
    public void aAr() {
        if (this.jFJ.isPlaying()) {
            this.jFJ.pause();
            this.jFX.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cxP() || com.baidu.tieba.video.g.cua().cub()) {
            this.jFJ.start();
            this.jFX.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0265a
    public void x(float f, float f2) {
        if (bd.cF(getActivity()) && !this.jGn) {
            cxQ();
            if (this.jGb != null && "0".equals(this.jGb.is_agreed)) {
                Cx(this.jFI);
            }
        }
    }

    private void cxQ() {
        if (this.mRootView != null) {
            this.jGn = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.jGp == null) {
                this.jGp = new RelativeLayout.LayoutParams(-2, -2);
                this.jGp.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.jGp);
            }
            if (this.jGo == null) {
                this.jGo = new AnimatorSet();
                this.jGo.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.jGn = false;
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
            this.jGo.setTarget(imageView);
            this.jGo.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.jGo.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0265a
    public void aAs() {
        if (this.jGb != null && this.jGb.author_info != null) {
            long c = com.baidu.adp.lib.g.b.c(this.jGb.author_info.user_id, 0L);
            long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = c == c2;
            if (c == 0 && c2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(c, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.jFJ != null) {
            return this.jFJ.getMediaIDs();
        }
        return null;
    }

    public String cxR() {
        if (this.jFJ != null) {
            return this.jFJ.getMediaId();
        }
        return null;
    }

    public boolean cxS() {
        if (this.jGr == null || this.jGr.asa() == null || !this.jGr.asa().isVisible()) {
            return false;
        }
        this.jGr.asa().hide();
        this.jGg.setVisibility(0);
        if ((this.jGr.asa().kq(28) instanceof c) && ((c) this.jGr.asa().kq(28)).getInputView() != null && ((c) this.jGr.asa().kq(28)).getInputView().getText() != null) {
            this.jGh.setText(StringUtils.isNull(((c) this.jGr.asa().kq(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.jGr != null) {
            this.jGr.onActivityResult(i, i2, intent);
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
        if (this.jGr != null && this.jGr.asa() != null) {
            this.jGr.asa().onChangeSkinType(i);
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
