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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.a.b;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0301a {
    public ImageView Nj;
    private e bUz;
    private String bYk;
    private boolean cPe;
    private String cln;
    private boolean dQT;
    private n dvI;
    private AlphaAnimation dxS;
    private View eZs;
    private String hbD;
    private boolean isNewPlayer;
    private j.b ivV;
    public com.baidu.tieba.play.a.a iva;
    private QuickVideoView.c iwm;
    public ImageView jHA;
    public TextView jHB;
    private View jHC;
    private TextView jHD;
    private int jHE;
    private int jHF;
    private int jHG;
    private com.baidu.tieba.view.a jHH;
    protected Animation jHI;
    private boolean jHJ;
    private AnimatorSet jHK;
    private RelativeLayout.LayoutParams jHL;
    private com.baidu.tieba.videoplay.editor.a jHN;
    com.baidu.tbadk.core.dialog.a jHO;
    private TbImageView jHf;
    public ImageView jHg;
    public HeadImageView jHh;
    public LinearLayout jHi;
    public LinearLayout jHj;
    public LinearLayout jHk;
    public ImageView jHl;
    public ImageView jHm;
    public ImageView jHn;
    public TextView jHo;
    public TextView jHp;
    public TextView jHq;
    public TextView jHr;
    public TextView jHs;
    public ImageView jHt;
    private LinearLayout jHu;
    public LinearLayout jHv;
    public LinearLayout jHw;
    public VideoItemData jHx;
    private TextView jHy;
    private boolean jHz;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int jHd = 0;
    private int jHe = 1;
    private ForumManageModel eNb = null;
    private com.baidu.tbadk.baseEditMark.a hLd = null;
    private com.baidu.tbadk.coreExtra.model.a cje = null;
    private BdUniqueId GX = BdUniqueId.gen();
    private boolean jHM = false;
    private int playTime = 1;
    private CustomMessageListener cji = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.jHx != null && VideoPlayFragment.this.jHx.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jHx.author_info.user_id) && data != null && VideoPlayFragment.this.jHx.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.GX)) ? false : false;
                    if (data.cvM == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.jHx.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.jHx.author_info.is_follow = "0";
                                VideoPlayFragment.this.cwo();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.jHz) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.jHx));
                                    return;
                                }
                                VideoPlayFragment.this.jHx.author_info.is_follow = "1";
                                VideoPlayFragment.this.cwo();
                            }
                        } else {
                            VideoPlayFragment.this.jHx.author_info.is_follow = "0";
                            VideoPlayFragment.this.cwo();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener bUR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.cwq();
            }
        }
    };

    static /* synthetic */ int w(VideoPlayFragment videoPlayFragment) {
        int i = videoPlayFragment.playTime;
        videoPlayFragment.playTime = i + 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.jHx = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.jHG = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.hbD = arguments.getString("from");
        this.bYk = arguments.getString("obj_id");
        if (this.jHx != null && this.jHx.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.jHx.author_info.user_id)) {
            this.dQT = true;
        }
        this.dvI = new n(getActivity());
        this.dvI.a(this.jHx);
        this.dvI.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bh(int i, int i2) {
                if (VideoPlayFragment.this.ivV != null) {
                    VideoPlayFragment.this.ivV.bh(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.mb("cyber_player_test");
        this.iva = com.baidu.tieba.play.a.b.x(getContext(), this.isNewPlayer ? 1 : 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.mRootView).addView(this.iva.getView(), 0);
        this.iva.getView().setLayoutParams(layoutParams);
        this.iva.setPageTypeForPerfStat("v_mid_page");
        if (cby()) {
            ((QuickVideoView) this.iva).setPlayerReuseEnable(true);
            ((QuickVideoView) this.iva).setNeedRecovery(true);
        }
        this.iva.setContinuePlayEnable(true);
        this.iva.setBusiness(this.dvI);
        if (this.jHx != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.cma = this.jHx.thread_id;
            zVar.ePc = this.jHx.forum_id;
            zVar.iyn = this.jHx.mMd5;
            zVar.bYk = "";
            zVar.mSource = this.jHx.mRecomSource;
            zVar.iym = this.jHx.mRecomAbTag;
            zVar.iyk = this.jHx.mRecomWeight;
            if (this.mRect != null) {
                zVar.iyo = "1";
            } else {
                zVar.iyo = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.iyp = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.iyl = this.hbD;
                zVar.bYk = this.bYk;
                zVar.iyj = this.jHx.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.dvI.setVideoStatsData(zVar);
        }
        this.iva.setBusiness(this.dvI);
        this.jHf = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.jHf.setDefaultBgResource(R.drawable.icon_play_bg);
        this.jHf.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.alW()) {
            this.eZs = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.eZs.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.eZs.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.Nj = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.jHg = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.jHh = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.jHh.setDefaultResource(17170445);
        this.jHh.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jHh.setIsRound(true);
        this.jHl = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.jHA = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.jHo = (TextView) this.mRootView.findViewById(R.id.video_title);
        this.jHp = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.jHj = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.jHq = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.jHi = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.jHr = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.jHs = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.jHm = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.jHn = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cwj();
        this.jHt = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.jHu = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.jHv = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.jHw = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.jHk = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.jHB = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.jHC = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.jHC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.jHC.setVisibility(4);
                    if (VideoPlayFragment.this.jHN != null && VideoPlayFragment.this.jHN.atX() != null) {
                        VideoPlayFragment.this.jHN.atX().le();
                    }
                    if (VideoPlayFragment.this.jHx != null) {
                        an anVar = new an("c13025");
                        anVar.bS("tid", VideoPlayFragment.this.jHx.thread_id);
                        anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.bS("fid", VideoPlayFragment.this.jHx.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.jHD = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.jHy = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.jHy.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.alP().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jHy.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.alP().getString("nani_key_download_link_url", null);
        this.jHy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.amO().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cwn();
        this.jHh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jHx != null && VideoPlayFragment.this.jHx.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jHx.author_info.user_id) && VideoPlayFragment.this.jHx != null && VideoPlayFragment.this.jHx.author_info != null) {
                    long j = com.baidu.adp.lib.g.b.toLong(VideoPlayFragment.this.jHx.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.bS("tid", VideoPlayFragment.this.jHx.thread_id);
                    anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.jHv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jHx != null && VideoPlayFragment.this.jHx.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.jHx.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.bS("tid", VideoPlayFragment.this.jHx.thread_id);
                    anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.jHo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cwl();
            }
        });
        this.Nj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jHx != null && !StringUtils.isNull(VideoPlayFragment.this.jHx.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.jHx.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.jHg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cwm();
            }
        });
        this.jHj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cwl();
                an anVar = new an("c12796");
                anVar.bS("tid", VideoPlayFragment.this.jHx.thread_id);
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.jHi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Bg(VideoPlayFragment.this.jHd);
            }
        });
        this.jHk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.anY();
                an anVar = new an("c12797");
                anVar.bS("tid", VideoPlayFragment.this.jHx.thread_id);
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.jHl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jHx != null && VideoPlayFragment.this.jHx.author_info != null) {
                    VideoPlayFragment.this.cje.a(true, VideoPlayFragment.this.jHx.author_info.portrait, VideoPlayFragment.this.jHx.author_info.user_id, false, "6", VideoPlayFragment.this.GX, VideoPlayFragment.this.jHx.forum_id, "0");
                    VideoPlayFragment.this.jHx.author_info.is_follow = "1";
                    VideoPlayFragment.this.cwo();
                }
            }
        });
        this.dxS = new AlphaAnimation(1.0f, 0.0f);
        this.dxS.setDuration(100L);
        this.dxS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.jHf != null) {
                    VideoPlayFragment.this.jHf.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.jHE = this.mRect.right - this.mRect.left;
            this.jHF = this.mRect.bottom - this.mRect.top;
            this.jHf.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.jHf.getWidth();
                    int height = VideoPlayFragment.this.jHf.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.toInt(VideoPlayFragment.this.jHx.video_height, 0) > 0 && com.baidu.adp.lib.g.b.toInt(VideoPlayFragment.this.jHx.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.g.b.toFloat(VideoPlayFragment.this.jHx.video_width, 0.0f) / com.baidu.adp.lib.g.b.toFloat(VideoPlayFragment.this.jHx.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jHE, VideoPlayFragment.this.jHF);
                            layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.jHf.setLayoutParams(layoutParams2);
                            if (VideoPlayFragment.this.jHF > 0 || VideoPlayFragment.this.jHE <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.jHE;
                                f = i / VideoPlayFragment.this.jHF;
                            }
                            VideoPlayFragment.this.jHf.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.jHf.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.jHz) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jHE, VideoPlayFragment.this.jHF);
                    layoutParams22.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams22.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.jHf.setLayoutParams(layoutParams22);
                    if (VideoPlayFragment.this.jHF > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.jHf.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.jHf.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.jHz) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.jHf.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.jHf.getWidth();
                    int height = VideoPlayFragment.this.jHf.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.toInt(VideoPlayFragment.this.jHx.video_height, 0) > 0 && com.baidu.adp.lib.g.b.toInt(VideoPlayFragment.this.jHx.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.g.b.toFloat(VideoPlayFragment.this.jHx.video_width, 0.0f) / com.baidu.adp.lib.g.b.toFloat(VideoPlayFragment.this.jHx.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams2 = VideoPlayFragment.this.jHf.getLayoutParams();
                        layoutParams2.height = height;
                        layoutParams2.width = width;
                        VideoPlayFragment.this.jHf.setLayoutParams(layoutParams2);
                    }
                }
            });
        }
        bLK();
        if (this.jHz) {
            cwk();
        }
        if (this.jHx != null && !StringUtils.isNull(this.jHx.video_url)) {
            Fn(this.jHx.video_url);
        }
        return this.mRootView;
    }

    public boolean cby() {
        return !this.isNewPlayer && (this.iva instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.ivV = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.iwm = cVar;
    }

    private void bLK() {
        this.jHN = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().cw(getActivity());
        if (this.jHN != null && this.jHx != null) {
            this.jHN.a(getPageContext());
            this.jHN.ah(this.jHx.thread_id, this.jHx.forum_id, this.jHx.forum_name);
            this.jHN.a(new a.InterfaceC0531a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0531a
                public void rD(boolean z) {
                    VideoPlayFragment.this.jHC.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.jHD.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.jHD.setText(StringUtils.isNull(((c) VideoPlayFragment.this.jHN.atX().jK(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.jHx != null && z) {
                        long j = com.baidu.adp.lib.g.b.toLong(VideoPlayFragment.this.jHx.comment_num, 0L) + 1;
                        VideoPlayFragment.this.jHx.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.jHq.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.jHN.atX(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anY() {
        if (this.jHx != null) {
            String str = this.jHx.forum_id;
            String str2 = this.jHx.forum_name;
            String str3 = this.jHx.title;
            String str4 = this.jHx.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.jHx.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str3;
            eVar.content = format;
            eVar.cxT = "";
            eVar.linkUrl = str5;
            eVar.cdP = 2;
            eVar.extData = str4;
            eVar.cxW = 3;
            eVar.fid = str;
            eVar.cxN = str2;
            eVar.tid = str4;
            eVar.cxG = true;
            eVar.cxV = 0;
            eVar.cya = 2;
            if (parse != null) {
                eVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.jHx.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.jHx.title;
            originalThreadInfo.threadId = this.jHx.thread_id;
            eVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.cxW);
            bundle.putInt("obj_type", eVar.cya);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt("obj_source", eVar.cdP);
            eVar.E(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), eVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.bch().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.dQT) {
            this.eNb = new ForumManageModel(getPageContext());
            this.eNb.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.eNb.getLoadDataMode()) {
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
        this.hLd = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.hLd != null) {
            this.hLd.a(new a.InterfaceC0274a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0274a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.hLd != null) {
                            VideoPlayFragment.this.hLd.dO(z2);
                        }
                        if (VideoPlayFragment.this.jHx != null) {
                            if (z2) {
                                VideoPlayFragment.this.jHx.mark_id = VideoPlayFragment.this.jHx.post_id;
                            } else {
                                VideoPlayFragment.this.jHx.mark_id = null;
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
        this.cje = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.cji);
        registerListener(this.bUR);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.jHM = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cwn();
        if (Build.VERSION.SDK_INT >= 17) {
            this.iva.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.jHz) {
                        if ((i == 3 || i == 904) && VideoPlayFragment.this.jHf.getVisibility() == 0) {
                            VideoPlayFragment.this.jHf.clearAnimation();
                            VideoPlayFragment.this.jHf.startAnimation(VideoPlayFragment.this.dxS);
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
            });
        }
        this.iva.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.iva != null) {
                    VideoPlayFragment.this.iva.seekTo(0);
                    VideoPlayFragment.this.iva.start();
                    VideoPlayFragment.this.bac();
                    VideoPlayFragment.w(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.cwi();
                    }
                }
            }
        });
        this.iva.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.iva != null) {
                    VideoPlayFragment.this.iva.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwi() {
        if (this.jHn != null && this.jHm != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.jHm.clearAnimation();
            this.jHn.clearAnimation();
            this.jHm.setVisibility(8);
            this.jHn.setVisibility(0);
            this.jHn.startAnimation(scaleAnimation2);
            this.jHm.startAnimation(scaleAnimation);
        }
    }

    private void cwj() {
        if (this.jHn != null && this.jHm != null) {
            this.jHm.clearAnimation();
            this.jHn.clearAnimation();
            this.jHm.setVisibility(0);
            this.jHn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bg(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.jHx != null) {
            if (i == this.jHd) {
                if ("1".equals(this.jHx.is_agreed)) {
                    i2 = 1;
                    this.jHx.agree_num = String.valueOf(com.baidu.adp.lib.g.b.toInt(this.jHx.agree_num, 0) - 1);
                    this.jHx.is_agreed = "0";
                } else {
                    this.jHx.agree_num = String.valueOf(com.baidu.adp.lib.g.b.toInt(this.jHx.agree_num, 0) + 1);
                    this.jHx.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.jHx.agree_num = String.valueOf(com.baidu.adp.lib.g.b.toInt(this.jHx.agree_num, 0) + 1);
                this.jHx.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.bS("tid", this.jHx.thread_id);
            anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.jHd) {
                anVar.O("obj_type", i2);
            } else {
                anVar.O("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            cwn();
            if (this.jHA != null && i2 == 0) {
                this.jHA.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.jHx.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.jHx));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.jHx != null && !StringUtils.isNull(this.jHx.video_url)) {
            this.cPe = true;
            if (this.jHz) {
                bac();
                bIK();
                if (this.jHx != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.bS("tid", this.jHx.thread_id);
                    anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.O("obj_type", 0);
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
        if (this.jHN != null && this.jHN.atX() != null) {
            this.jHN.atX().hide();
            this.jHC.setVisibility(0);
            this.jHD.setText(StringUtils.isNull(((c) this.jHN.atX().jK(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.jHN != null) {
            this.jHN.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.jHz = z;
        if (this.cPe) {
            if (this.jHz && (!this.jHM || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.jHx != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.bS("tid", this.jHx.thread_id);
                    anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.O("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                cwk();
                this.jHM = false;
                return;
            }
            cwj();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cwk() {
        if (this.jHx != null) {
            an anVar = new an("c12590");
            anVar.bS("tid", this.jHx.thread_id);
            anVar.bS("fid", this.jHx.forum_id);
            anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.O("obj_locate", this.jHG);
            anVar.O(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.bS("obj_param1", aq.isEmpty(this.jHx.mRecomWeight) ? "0" : this.jHx.mRecomWeight);
            anVar.bS("extra", aq.isEmpty(this.jHx.mRecomExtra) ? "0" : this.jHx.mRecomExtra);
            anVar.bS("obj_id", this.bYk);
            anVar.bS(TiebaInitialize.Params.AB_TAG, aq.isEmpty(this.jHx.mRecomAbTag) ? "0" : this.jHx.mRecomAbTag);
            anVar.bS("obj_source", aq.isEmpty(this.jHx.mRecomSource) ? "0" : this.jHx.mRecomSource);
            anVar.bS("obj_type", this.hbD);
            anVar.O("is_vertical", 1);
            TiebaStatic.log(anVar);
        }
    }

    private void Fn(String str) {
        if (this.iva != null && str != null && !str.equals(this.cln)) {
            if (cby()) {
                ((QuickVideoView) this.iva).setRecoveryState(0);
            }
            this.iva.setVideoPath(str, this.jHx.thread_id);
            this.cln = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.csB().csC() || cwq()) {
            cbM();
            if (this.jHt != null) {
                this.jHt.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.jHf.getVisibility() == 0) {
                this.jHf.clearAnimation();
                this.jHf.startAnimation(this.dxS);
            }
            if (this.iva != null) {
                this.iva.start();
                bac();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bac() {
        if (this.jHx != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.cma = this.jHx.thread_id;
            zVar.ePc = this.jHx.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.jHx.mRecomSource;
            zVar.iyj = this.jHx.mRecomAbTag;
            zVar.iyk = this.jHx.mRecomWeight;
            zVar.iyl = "";
            zVar.bYk = "";
            zVar.iyn = this.jHx.mMd5;
            if (this.mRect != null) {
                zVar.iyo = "1";
            } else {
                zVar.iyo = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.iyp = "1";
                zVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                zVar.iyl = "index";
            }
            com.baidu.tieba.play.l.a(this.jHx.mMd5, "", "1", zVar);
        }
    }

    private void cbM() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.csB().ef(getContext());
        }
    }

    private void pausePlay() {
        if (this.iva != null) {
            this.iva.pause();
        }
    }

    private void stopPlay() {
        if (this.iva != null) {
            if (cby()) {
                ((QuickVideoView) this.iva).setRecoveryState(5);
            }
            this.iva.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwl() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.jHx.thread_id, this.jHx.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.jHx.forum_id));
        createNormalCfg.setForumName(this.jHx.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwm() {
        if (this.bUz == null) {
            this.jHH = new com.baidu.tieba.view.a(getActivity());
            this.bUz = new e(getActivity(), this.jHH.alc());
            this.bUz.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.iva.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.jHH != null) {
            ArrayList arrayList = new ArrayList();
            a.C0532a c0532a = new a.C0532a(this.jHH);
            c0532a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bUz.dismiss();
                    if (VideoPlayFragment.this.jHx != null) {
                        boolean z = VideoPlayFragment.this.jHx.post_id != null && VideoPlayFragment.this.jHx.post_id.equals(VideoPlayFragment.this.jHx.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.jHx.thread_id);
                        markData.setPostId(VideoPlayFragment.this.jHx.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.jHx.thread_id);
                        markData.setForumId(VideoPlayFragment.this.jHx.forum_id);
                        if (VideoPlayFragment.this.hLd != null) {
                            VideoPlayFragment.this.hLd.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.hLd.afm();
                            } else {
                                VideoPlayFragment.this.hLd.afl();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.jHx != null && this.jHx.post_id != null && this.jHx.post_id.equals(this.jHx.mark_id)) {
                z = true;
            }
            if (z) {
                c0532a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0532a.setText(getResources().getString(R.string.mark));
            }
            arrayList.add(c0532a);
            a.C0532a c0532a2 = new a.C0532a(getActivity().getString(R.string.delete), this.jHH);
            c0532a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bUz.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jHx != null) {
                        String str = VideoPlayFragment.this.jHx.thread_id;
                        String str2 = VideoPlayFragment.this.jHx.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.jHx.post_id, true)));
                    }
                }
            });
            c0532a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0532a2);
            if (this.dQT) {
                a.C0532a c0532a3 = new a.C0532a(getActivity().getString(R.string.delete), this.jHH);
                c0532a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.bUz.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.hT(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.jHx != null) {
                                    VideoPlayFragment.this.eNb.a(VideoPlayFragment.this.jHx.forum_id, VideoPlayFragment.this.jHx.forum_name, VideoPlayFragment.this.jHx.thread_id, VideoPlayFragment.this.jHx.post_id, 0, 0, VideoPlayFragment.this.dQT);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                                }
                            }
                        });
                        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.eg(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.akM();
                    }
                });
                c0532a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0532a3);
            }
            this.jHH.at(arrayList);
        }
        this.bUz.show();
    }

    private void cwn() {
        if (this.jHx != null) {
            this.jHf.startLoad(this.jHx.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.jHx.title);
            if (StringUtils.isNull(this.jHx.title) || matcher.matches()) {
                this.jHo.setVisibility(8);
            } else {
                this.jHo.setVisibility(0);
                this.jHo.setText(this.jHx.title);
            }
            this.jHq.setText(aq.numFormatOverWan(com.baidu.adp.lib.g.b.toLong(this.jHx.comment_num, 0L)));
            this.jHr.setText(aq.numFormatOverWan(com.baidu.adp.lib.g.b.toLong(this.jHx.agree_num, 0L)));
            this.jHs.setText(aq.numFormatOverWan(com.baidu.adp.lib.g.b.toLong(this.jHx.share_num, 0L)));
            if (this.jHx.author_info != null) {
                if (!StringUtils.isNull(this.jHx.author_info.portrait) && this.jHx.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.jHh.startLoad(this.jHx.author_info.portrait, 10, false);
                } else {
                    this.jHh.startLoad(this.jHx.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.jHx.author_info.csx())) {
                    this.jHB.setVisibility(8);
                } else {
                    this.jHB.setVisibility(0);
                    this.jHB.setText("@" + this.jHx.author_info.csx());
                }
            }
            if ("1".equals(this.jHx.is_private) && this.jHy.getVisibility() != 0) {
                this.jHw.setVisibility(0);
            } else {
                this.jHw.setVisibility(8);
            }
            if ("1".equals(this.jHx.is_agreed)) {
                am.setImageResource(this.jHA, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.jHA, R.drawable.btn_video_agree);
            }
            if (this.jHx.act_info != null && !StringUtils.isNull(this.jHx.act_info.activity_name) && this.jHy.getVisibility() != 0) {
                this.jHv.setVisibility(0);
                this.jHp.setText(this.jHx.act_info.activity_name);
            } else {
                this.jHv.setVisibility(8);
            }
            cwo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwo() {
        if (this.dQT || (this.jHx.author_info != null && !"0".equals(this.jHx.author_info.is_follow))) {
            this.jHl.setVisibility(4);
            this.jHl.setClickable(false);
            return;
        }
        this.jHl.setVisibility(0);
        this.jHl.setClickable(true);
    }

    private void cwp() {
        if (getActivity() != null) {
            if (this.jHO == null || !this.jHO.isShowing()) {
                this.jHO = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.amL().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, null);
                this.jHO.aM(inflate);
                this.jHO.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.jHO.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.jHO.hW(1);
                this.jHO.hU(R.color.cp_cont_b);
                this.jHO.eg(true);
                this.jHO.b(getPageContext());
                this.jHO.akM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cwq() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
            return true;
        }
        if (!this.jHz || com.baidu.tieba.video.g.csB().csC()) {
            return false;
        }
        if (this.jHt != null) {
            this.jHt.setVisibility(0);
        }
        pausePlay();
        cwp();
        return false;
    }

    private void bIK() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cwq() || com.baidu.tieba.video.g.csB().csC()) && this.iva != null && this.jHt != null) {
            this.iva.bIK();
            this.jHt.setVisibility(8);
            cbM();
            if (this.iwm != null) {
                this.iwm.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.jHI == null) {
            this.jHI = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.jHI;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0301a
    public void aAK() {
        if (this.iva.isPlaying()) {
            this.iva.pause();
            this.jHt.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cwq() || com.baidu.tieba.video.g.csB().csC()) {
            this.iva.start();
            this.jHt.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0301a
    public void s(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.jHJ) {
            cwr();
            if (this.jHx != null && "0".equals(this.jHx.is_agreed)) {
                Bg(this.jHe);
            }
        }
    }

    private void cwr() {
        if (this.mRootView != null) {
            this.jHJ = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.jHL == null) {
                this.jHL = new RelativeLayout.LayoutParams(-2, -2);
                this.jHL.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.jHL);
            }
            if (this.jHK == null) {
                this.jHK = new AnimatorSet();
                this.jHK.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.jHJ = false;
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
            this.jHK.setTarget(imageView);
            this.jHK.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.jHK.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0301a
    public void aAL() {
        if (this.jHx != null && this.jHx.author_info != null) {
            long j = com.baidu.adp.lib.g.b.toLong(this.jHx.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cby()) {
            return ((QuickVideoView) this.iva).getMediaIDs();
        }
        return null;
    }

    public String cws() {
        if (cby()) {
            return ((QuickVideoView) this.iva).getMediaId();
        }
        return null;
    }

    public boolean cwt() {
        if (this.jHN == null || this.jHN.atX() == null || !this.jHN.atX().isVisible()) {
            return false;
        }
        this.jHN.atX().hide();
        this.jHC.setVisibility(0);
        if ((this.jHN.atX().jK(28) instanceof c) && ((c) this.jHN.atX().jK(28)).getInputView() != null && ((c) this.jHN.atX().jK(28)).getInputView().getText() != null) {
            this.jHD.setText(StringUtils.isNull(((c) this.jHN.atX().jK(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void b(int i, int i2, Intent intent) {
        if (this.jHN != null) {
            this.jHN.onActivityResult(i, i2, intent);
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
        if (this.jHN != null && this.jHN.atX() != null) {
            this.jHN.atX().onChangeSkinType(i);
        }
        SvgManager.amL().a(this.Nj, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }
}
