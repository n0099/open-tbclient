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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0306a {
    public ImageView NK;
    private e bVq;
    private String bZb;
    private boolean cPV;
    private String cmf;
    private boolean dRK;
    private n dwz;
    private AlphaAnimation dyJ;
    private View faj;
    private String hcu;
    private boolean isNewPlayer;
    public com.baidu.tieba.play.a.a ivR;
    private j.b iwM;
    private QuickVideoView.c ixd;
    private TbImageView jHW;
    public ImageView jHX;
    public HeadImageView jHY;
    public LinearLayout jHZ;
    private boolean jIA;
    private AnimatorSet jIB;
    private RelativeLayout.LayoutParams jIC;
    private com.baidu.tieba.videoplay.editor.a jIE;
    com.baidu.tbadk.core.dialog.a jIF;
    public LinearLayout jIa;
    public LinearLayout jIb;
    public ImageView jIc;
    public ImageView jId;
    public ImageView jIe;
    public TextView jIf;
    public TextView jIg;
    public TextView jIh;
    public TextView jIi;
    public TextView jIj;
    public ImageView jIk;
    private LinearLayout jIl;
    public LinearLayout jIm;
    public LinearLayout jIn;
    public VideoItemData jIo;
    private TextView jIp;
    private boolean jIq;
    public ImageView jIr;
    public TextView jIs;
    private View jIt;
    private TextView jIu;
    private int jIv;
    private int jIw;
    private int jIx;
    private com.baidu.tieba.view.a jIy;
    protected Animation jIz;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int jHU = 0;
    private int jHV = 1;
    private ForumManageModel eNS = null;
    private com.baidu.tbadk.baseEditMark.a hLU = null;
    private com.baidu.tbadk.coreExtra.model.a cjV = null;
    private BdUniqueId Hx = BdUniqueId.gen();
    private boolean jID = false;
    private int playTime = 1;
    private CustomMessageListener cjZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.jIo != null && VideoPlayFragment.this.jIo.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jIo.author_info.user_id) && data != null && VideoPlayFragment.this.jIo.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.Hx)) ? false : false;
                    if (data.cwD == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.jIo.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.jIo.author_info.is_follow = "0";
                                VideoPlayFragment.this.cwq();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.jIq) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.jIo));
                                    return;
                                }
                                VideoPlayFragment.this.jIo.author_info.is_follow = "1";
                                VideoPlayFragment.this.cwq();
                            }
                        } else {
                            VideoPlayFragment.this.jIo.author_info.is_follow = "0";
                            VideoPlayFragment.this.cwq();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener bVI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.cws();
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
        this.jIo = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.jIx = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.hcu = arguments.getString("from");
        this.bZb = arguments.getString("obj_id");
        if (this.jIo != null && this.jIo.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.jIo.author_info.user_id)) {
            this.dRK = true;
        }
        this.dwz = new n(getActivity());
        this.dwz.a(this.jIo);
        this.dwz.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bj(int i, int i2) {
                if (VideoPlayFragment.this.iwM != null) {
                    VideoPlayFragment.this.iwM.bj(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.mb("cyber_player_test");
        this.ivR = com.baidu.tieba.play.a.b.x(getContext(), this.isNewPlayer ? 1 : 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.mRootView).addView(this.ivR.getView(), 0);
        this.ivR.getView().setLayoutParams(layoutParams);
        this.ivR.setPageTypeForPerfStat("v_mid_page");
        if (cbA()) {
            ((QuickVideoView) this.ivR).setPlayerReuseEnable(true);
            ((QuickVideoView) this.ivR).setNeedRecovery(true);
        }
        this.ivR.setContinuePlayEnable(true);
        this.ivR.setBusiness(this.dwz);
        if (this.jIo != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.cmS = this.jIo.thread_id;
            zVar.ePT = this.jIo.forum_id;
            zVar.ize = this.jIo.mMd5;
            zVar.bZb = "";
            zVar.mSource = this.jIo.mRecomSource;
            zVar.izd = this.jIo.mRecomAbTag;
            zVar.izb = this.jIo.mRecomWeight;
            if (this.mRect != null) {
                zVar.izf = "1";
            } else {
                zVar.izf = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.izg = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.izc = this.hcu;
                zVar.bZb = this.bZb;
                zVar.iza = this.jIo.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.dwz.setVideoStatsData(zVar);
        }
        this.ivR.setBusiness(this.dwz);
        this.jHW = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.jHW.setDefaultBgResource(R.drawable.icon_play_bg);
        this.jHW.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.alY()) {
            this.faj = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.faj.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.faj.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.NK = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.jHX = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.jHY = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.jHY.setDefaultResource(17170445);
        this.jHY.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jHY.setIsRound(true);
        this.jIc = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.jIr = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.jIf = (TextView) this.mRootView.findViewById(R.id.video_title);
        this.jIg = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.jIa = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.jIh = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.jHZ = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.jIi = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.jIj = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.jId = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.jIe = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cwl();
        this.jIk = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.jIl = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.jIm = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.jIn = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.jIb = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.jIs = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.jIt = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.jIt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.jIt.setVisibility(4);
                    if (VideoPlayFragment.this.jIE != null && VideoPlayFragment.this.jIE.atZ() != null) {
                        VideoPlayFragment.this.jIE.atZ().le();
                    }
                    if (VideoPlayFragment.this.jIo != null) {
                        an anVar = new an("c13025");
                        anVar.bS("tid", VideoPlayFragment.this.jIo.thread_id);
                        anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.bS("fid", VideoPlayFragment.this.jIo.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.jIu = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.jIp = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.jIp.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.alR().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jIp.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.alR().getString("nani_key_download_link_url", null);
        this.jIp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.amQ().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cwp();
        this.jHY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jIo != null && VideoPlayFragment.this.jIo.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jIo.author_info.user_id) && VideoPlayFragment.this.jIo != null && VideoPlayFragment.this.jIo.author_info != null) {
                    long j = com.baidu.adp.lib.g.b.toLong(VideoPlayFragment.this.jIo.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.bS("tid", VideoPlayFragment.this.jIo.thread_id);
                    anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.jIm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jIo != null && VideoPlayFragment.this.jIo.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.jIo.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.bS("tid", VideoPlayFragment.this.jIo.thread_id);
                    anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.jIf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cwn();
            }
        });
        this.NK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jIo != null && !StringUtils.isNull(VideoPlayFragment.this.jIo.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.jIo.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.jHX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cwo();
            }
        });
        this.jIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cwn();
                an anVar = new an("c12796");
                anVar.bS("tid", VideoPlayFragment.this.jIo.thread_id);
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.jHZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Bh(VideoPlayFragment.this.jHU);
            }
        });
        this.jIb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aoa();
                an anVar = new an("c12797");
                anVar.bS("tid", VideoPlayFragment.this.jIo.thread_id);
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.jIc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jIo != null && VideoPlayFragment.this.jIo.author_info != null) {
                    VideoPlayFragment.this.cjV.a(true, VideoPlayFragment.this.jIo.author_info.portrait, VideoPlayFragment.this.jIo.author_info.user_id, false, "6", VideoPlayFragment.this.Hx, VideoPlayFragment.this.jIo.forum_id, "0");
                    VideoPlayFragment.this.jIo.author_info.is_follow = "1";
                    VideoPlayFragment.this.cwq();
                }
            }
        });
        this.dyJ = new AlphaAnimation(1.0f, 0.0f);
        this.dyJ.setDuration(100L);
        this.dyJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.jHW != null) {
                    VideoPlayFragment.this.jHW.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.jIv = this.mRect.right - this.mRect.left;
            this.jIw = this.mRect.bottom - this.mRect.top;
            this.jHW.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.jHW.getWidth();
                    int height = VideoPlayFragment.this.jHW.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.toInt(VideoPlayFragment.this.jIo.video_height, 0) > 0 && com.baidu.adp.lib.g.b.toInt(VideoPlayFragment.this.jIo.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.g.b.toFloat(VideoPlayFragment.this.jIo.video_width, 0.0f) / com.baidu.adp.lib.g.b.toFloat(VideoPlayFragment.this.jIo.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jIv, VideoPlayFragment.this.jIw);
                            layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.jHW.setLayoutParams(layoutParams2);
                            if (VideoPlayFragment.this.jIw > 0 || VideoPlayFragment.this.jIv <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.jIv;
                                f = i / VideoPlayFragment.this.jIw;
                            }
                            VideoPlayFragment.this.jHW.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.jHW.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.jIq) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jIv, VideoPlayFragment.this.jIw);
                    layoutParams22.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams22.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.jHW.setLayoutParams(layoutParams22);
                    if (VideoPlayFragment.this.jIw > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.jHW.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.jHW.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.jIq) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.jHW.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.jHW.getWidth();
                    int height = VideoPlayFragment.this.jHW.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.toInt(VideoPlayFragment.this.jIo.video_height, 0) > 0 && com.baidu.adp.lib.g.b.toInt(VideoPlayFragment.this.jIo.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.g.b.toFloat(VideoPlayFragment.this.jIo.video_width, 0.0f) / com.baidu.adp.lib.g.b.toFloat(VideoPlayFragment.this.jIo.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams2 = VideoPlayFragment.this.jHW.getLayoutParams();
                        layoutParams2.height = height;
                        layoutParams2.width = width;
                        VideoPlayFragment.this.jHW.setLayoutParams(layoutParams2);
                    }
                }
            });
        }
        bLM();
        if (this.jIq) {
            cwm();
        }
        if (this.jIo != null && !StringUtils.isNull(this.jIo.video_url)) {
            Fn(this.jIo.video_url);
        }
        return this.mRootView;
    }

    public boolean cbA() {
        return !this.isNewPlayer && (this.ivR instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.iwM = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.ixd = cVar;
    }

    private void bLM() {
        this.jIE = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().cw(getActivity());
        if (this.jIE != null && this.jIo != null) {
            this.jIE.a(getPageContext());
            this.jIE.ah(this.jIo.thread_id, this.jIo.forum_id, this.jIo.forum_name);
            this.jIE.a(new a.InterfaceC0536a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0536a
                public void rD(boolean z) {
                    VideoPlayFragment.this.jIt.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.jIu.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.jIu.setText(StringUtils.isNull(((c) VideoPlayFragment.this.jIE.atZ().jL(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.jIo != null && z) {
                        long j = com.baidu.adp.lib.g.b.toLong(VideoPlayFragment.this.jIo.comment_num, 0L) + 1;
                        VideoPlayFragment.this.jIo.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.jIh.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.jIE.atZ(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoa() {
        if (this.jIo != null) {
            String str = this.jIo.forum_id;
            String str2 = this.jIo.forum_name;
            String str3 = this.jIo.title;
            String str4 = this.jIo.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.jIo.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str3;
            eVar.content = format;
            eVar.cyK = "";
            eVar.linkUrl = str5;
            eVar.ceG = 2;
            eVar.extData = str4;
            eVar.cyN = 3;
            eVar.fid = str;
            eVar.cyE = str2;
            eVar.tid = str4;
            eVar.cyx = true;
            eVar.cyM = 0;
            eVar.cyR = 2;
            if (parse != null) {
                eVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.jIo.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.jIo.title;
            originalThreadInfo.threadId = this.jIo.thread_id;
            eVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.cyN);
            bundle.putInt("obj_type", eVar.cyR);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt("obj_source", eVar.ceG);
            eVar.E(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), eVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.bcj().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.dRK) {
            this.eNS = new ForumManageModel(getPageContext());
            this.eNS.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.eNS.getLoadDataMode()) {
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
        this.hLU = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.hLU != null) {
            this.hLU.a(new a.InterfaceC0279a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0279a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.hLU != null) {
                            VideoPlayFragment.this.hLU.dO(z2);
                        }
                        if (VideoPlayFragment.this.jIo != null) {
                            if (z2) {
                                VideoPlayFragment.this.jIo.mark_id = VideoPlayFragment.this.jIo.post_id;
                            } else {
                                VideoPlayFragment.this.jIo.mark_id = null;
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
        this.cjV = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.cjZ);
        registerListener(this.bVI);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.jID = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cwp();
        if (Build.VERSION.SDK_INT >= 17) {
            this.ivR.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.jIq) {
                        if ((i == 3 || i == 904) && VideoPlayFragment.this.jHW.getVisibility() == 0) {
                            VideoPlayFragment.this.jHW.clearAnimation();
                            VideoPlayFragment.this.jHW.startAnimation(VideoPlayFragment.this.dyJ);
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
            });
        }
        this.ivR.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.ivR != null) {
                    VideoPlayFragment.this.ivR.seekTo(0);
                    VideoPlayFragment.this.ivR.start();
                    VideoPlayFragment.this.bae();
                    VideoPlayFragment.w(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.cwk();
                    }
                }
            }
        });
        this.ivR.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.ivR != null) {
                    VideoPlayFragment.this.ivR.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwk() {
        if (this.jIe != null && this.jId != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.jId.clearAnimation();
            this.jIe.clearAnimation();
            this.jId.setVisibility(8);
            this.jIe.setVisibility(0);
            this.jIe.startAnimation(scaleAnimation2);
            this.jId.startAnimation(scaleAnimation);
        }
    }

    private void cwl() {
        if (this.jIe != null && this.jId != null) {
            this.jId.clearAnimation();
            this.jIe.clearAnimation();
            this.jId.setVisibility(0);
            this.jIe.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.jIo != null) {
            if (i == this.jHU) {
                if ("1".equals(this.jIo.is_agreed)) {
                    i2 = 1;
                    this.jIo.agree_num = String.valueOf(com.baidu.adp.lib.g.b.toInt(this.jIo.agree_num, 0) - 1);
                    this.jIo.is_agreed = "0";
                } else {
                    this.jIo.agree_num = String.valueOf(com.baidu.adp.lib.g.b.toInt(this.jIo.agree_num, 0) + 1);
                    this.jIo.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.jIo.agree_num = String.valueOf(com.baidu.adp.lib.g.b.toInt(this.jIo.agree_num, 0) + 1);
                this.jIo.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.bS("tid", this.jIo.thread_id);
            anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.jHU) {
                anVar.O("obj_type", i2);
            } else {
                anVar.O("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            cwp();
            if (this.jIr != null && i2 == 0) {
                this.jIr.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.jIo.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.jIo));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.jIo != null && !StringUtils.isNull(this.jIo.video_url)) {
            this.cPV = true;
            if (this.jIq) {
                bae();
                bIM();
                if (this.jIo != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.bS("tid", this.jIo.thread_id);
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
        if (this.jIE != null && this.jIE.atZ() != null) {
            this.jIE.atZ().hide();
            this.jIt.setVisibility(0);
            this.jIu.setText(StringUtils.isNull(((c) this.jIE.atZ().jL(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.jIE != null) {
            this.jIE.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.jIq = z;
        if (this.cPV) {
            if (this.jIq && (!this.jID || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.jIo != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.bS("tid", this.jIo.thread_id);
                    anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.O("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                cwm();
                this.jID = false;
                return;
            }
            cwl();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cwm() {
        if (this.jIo != null) {
            an anVar = new an("c12590");
            anVar.bS("tid", this.jIo.thread_id);
            anVar.bS("fid", this.jIo.forum_id);
            anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.O("obj_locate", this.jIx);
            anVar.O(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.bS("obj_param1", aq.isEmpty(this.jIo.mRecomWeight) ? "0" : this.jIo.mRecomWeight);
            anVar.bS("extra", aq.isEmpty(this.jIo.mRecomExtra) ? "0" : this.jIo.mRecomExtra);
            anVar.bS("obj_id", this.bZb);
            anVar.bS(TiebaInitialize.Params.AB_TAG, aq.isEmpty(this.jIo.mRecomAbTag) ? "0" : this.jIo.mRecomAbTag);
            anVar.bS("obj_source", aq.isEmpty(this.jIo.mRecomSource) ? "0" : this.jIo.mRecomSource);
            anVar.bS("obj_type", this.hcu);
            anVar.O("is_vertical", 1);
            TiebaStatic.log(anVar);
        }
    }

    private void Fn(String str) {
        if (this.ivR != null && str != null && !str.equals(this.cmf)) {
            if (cbA()) {
                ((QuickVideoView) this.ivR).setRecoveryState(0);
            }
            this.ivR.setVideoPath(str, this.jIo.thread_id);
            this.cmf = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.csD().csE() || cws()) {
            cbO();
            if (this.jIk != null) {
                this.jIk.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.jHW.getVisibility() == 0) {
                this.jHW.clearAnimation();
                this.jHW.startAnimation(this.dyJ);
            }
            if (this.ivR != null) {
                this.ivR.start();
                bae();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bae() {
        if (this.jIo != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.cmS = this.jIo.thread_id;
            zVar.ePT = this.jIo.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.jIo.mRecomSource;
            zVar.iza = this.jIo.mRecomAbTag;
            zVar.izb = this.jIo.mRecomWeight;
            zVar.izc = "";
            zVar.bZb = "";
            zVar.ize = this.jIo.mMd5;
            if (this.mRect != null) {
                zVar.izf = "1";
            } else {
                zVar.izf = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.izg = "1";
                zVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                zVar.izc = "index";
            }
            com.baidu.tieba.play.l.a(this.jIo.mMd5, "", "1", zVar);
        }
    }

    private void cbO() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.csD().ef(getContext());
        }
    }

    private void pausePlay() {
        if (this.ivR != null) {
            this.ivR.pause();
        }
    }

    private void stopPlay() {
        if (this.ivR != null) {
            if (cbA()) {
                ((QuickVideoView) this.ivR).setRecoveryState(5);
            }
            this.ivR.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwn() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.jIo.thread_id, this.jIo.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.jIo.forum_id));
        createNormalCfg.setForumName(this.jIo.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwo() {
        if (this.bVq == null) {
            this.jIy = new com.baidu.tieba.view.a(getActivity());
            this.bVq = new e(getActivity(), this.jIy.ale());
            this.bVq.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.ivR.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.jIy != null) {
            ArrayList arrayList = new ArrayList();
            a.C0537a c0537a = new a.C0537a(this.jIy);
            c0537a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bVq.dismiss();
                    if (VideoPlayFragment.this.jIo != null) {
                        boolean z = VideoPlayFragment.this.jIo.post_id != null && VideoPlayFragment.this.jIo.post_id.equals(VideoPlayFragment.this.jIo.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.jIo.thread_id);
                        markData.setPostId(VideoPlayFragment.this.jIo.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.jIo.thread_id);
                        markData.setForumId(VideoPlayFragment.this.jIo.forum_id);
                        if (VideoPlayFragment.this.hLU != null) {
                            VideoPlayFragment.this.hLU.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.hLU.afo();
                            } else {
                                VideoPlayFragment.this.hLU.afn();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.jIo != null && this.jIo.post_id != null && this.jIo.post_id.equals(this.jIo.mark_id)) {
                z = true;
            }
            if (z) {
                c0537a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0537a.setText(getResources().getString(R.string.mark));
            }
            arrayList.add(c0537a);
            a.C0537a c0537a2 = new a.C0537a(getActivity().getString(R.string.delete), this.jIy);
            c0537a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bVq.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jIo != null) {
                        String str = VideoPlayFragment.this.jIo.thread_id;
                        String str2 = VideoPlayFragment.this.jIo.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.jIo.post_id, true)));
                    }
                }
            });
            c0537a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0537a2);
            if (this.dRK) {
                a.C0537a c0537a3 = new a.C0537a(getActivity().getString(R.string.delete), this.jIy);
                c0537a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.bVq.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.hU(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.jIo != null) {
                                    VideoPlayFragment.this.eNS.a(VideoPlayFragment.this.jIo.forum_id, VideoPlayFragment.this.jIo.forum_name, VideoPlayFragment.this.jIo.thread_id, VideoPlayFragment.this.jIo.post_id, 0, 0, VideoPlayFragment.this.dRK);
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
                        aVar.akO();
                    }
                });
                c0537a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0537a3);
            }
            this.jIy.at(arrayList);
        }
        this.bVq.show();
    }

    private void cwp() {
        if (this.jIo != null) {
            this.jHW.startLoad(this.jIo.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.jIo.title);
            if (StringUtils.isNull(this.jIo.title) || matcher.matches()) {
                this.jIf.setVisibility(8);
            } else {
                this.jIf.setVisibility(0);
                this.jIf.setText(this.jIo.title);
            }
            this.jIh.setText(aq.numFormatOverWan(com.baidu.adp.lib.g.b.toLong(this.jIo.comment_num, 0L)));
            this.jIi.setText(aq.numFormatOverWan(com.baidu.adp.lib.g.b.toLong(this.jIo.agree_num, 0L)));
            this.jIj.setText(aq.numFormatOverWan(com.baidu.adp.lib.g.b.toLong(this.jIo.share_num, 0L)));
            if (this.jIo.author_info != null) {
                if (!StringUtils.isNull(this.jIo.author_info.portrait) && this.jIo.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.jHY.startLoad(this.jIo.author_info.portrait, 10, false);
                } else {
                    this.jHY.startLoad(this.jIo.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.jIo.author_info.csz())) {
                    this.jIs.setVisibility(8);
                } else {
                    this.jIs.setVisibility(0);
                    this.jIs.setText("@" + this.jIo.author_info.csz());
                }
            }
            if ("1".equals(this.jIo.is_private) && this.jIp.getVisibility() != 0) {
                this.jIn.setVisibility(0);
            } else {
                this.jIn.setVisibility(8);
            }
            if ("1".equals(this.jIo.is_agreed)) {
                am.setImageResource(this.jIr, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.jIr, R.drawable.btn_video_agree);
            }
            if (this.jIo.act_info != null && !StringUtils.isNull(this.jIo.act_info.activity_name) && this.jIp.getVisibility() != 0) {
                this.jIm.setVisibility(0);
                this.jIg.setText(this.jIo.act_info.activity_name);
            } else {
                this.jIm.setVisibility(8);
            }
            cwq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwq() {
        if (this.dRK || (this.jIo.author_info != null && !"0".equals(this.jIo.author_info.is_follow))) {
            this.jIc.setVisibility(4);
            this.jIc.setClickable(false);
            return;
        }
        this.jIc.setVisibility(0);
        this.jIc.setClickable(true);
    }

    private void cwr() {
        if (getActivity() != null) {
            if (this.jIF == null || !this.jIF.isShowing()) {
                this.jIF = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.amN().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, null);
                this.jIF.aM(inflate);
                this.jIF.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.jIF.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.jIF.hX(1);
                this.jIF.hV(R.color.cp_cont_b);
                this.jIF.eg(true);
                this.jIF.b(getPageContext());
                this.jIF.akO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cws() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
            return true;
        }
        if (!this.jIq || com.baidu.tieba.video.g.csD().csE()) {
            return false;
        }
        if (this.jIk != null) {
            this.jIk.setVisibility(0);
        }
        pausePlay();
        cwr();
        return false;
    }

    private void bIM() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cws() || com.baidu.tieba.video.g.csD().csE()) && this.ivR != null && this.jIk != null) {
            this.ivR.bIM();
            this.jIk.setVisibility(8);
            cbO();
            if (this.ixd != null) {
                this.ixd.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.jIz == null) {
            this.jIz = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.jIz;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0306a
    public void aAM() {
        if (this.ivR.isPlaying()) {
            this.ivR.pause();
            this.jIk.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cws() || com.baidu.tieba.video.g.csD().csE()) {
            this.ivR.start();
            this.jIk.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0306a
    public void s(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.jIA) {
            cwt();
            if (this.jIo != null && "0".equals(this.jIo.is_agreed)) {
                Bh(this.jHV);
            }
        }
    }

    private void cwt() {
        if (this.mRootView != null) {
            this.jIA = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.jIC == null) {
                this.jIC = new RelativeLayout.LayoutParams(-2, -2);
                this.jIC.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.jIC);
            }
            if (this.jIB == null) {
                this.jIB = new AnimatorSet();
                this.jIB.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.jIA = false;
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
            this.jIB.setTarget(imageView);
            this.jIB.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.jIB.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0306a
    public void aAN() {
        if (this.jIo != null && this.jIo.author_info != null) {
            long j = com.baidu.adp.lib.g.b.toLong(this.jIo.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cbA()) {
            return ((QuickVideoView) this.ivR).getMediaIDs();
        }
        return null;
    }

    public String cwu() {
        if (cbA()) {
            return ((QuickVideoView) this.ivR).getMediaId();
        }
        return null;
    }

    public boolean cwv() {
        if (this.jIE == null || this.jIE.atZ() == null || !this.jIE.atZ().isVisible()) {
            return false;
        }
        this.jIE.atZ().hide();
        this.jIt.setVisibility(0);
        if ((this.jIE.atZ().jL(28) instanceof c) && ((c) this.jIE.atZ().jL(28)).getInputView() != null && ((c) this.jIE.atZ().jL(28)).getInputView().getText() != null) {
            this.jIu.setText(StringUtils.isNull(((c) this.jIE.atZ().jL(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void b(int i, int i2, Intent intent) {
        if (this.jIE != null) {
            this.jIE.onActivityResult(i, i2, intent);
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
        if (this.jIE != null && this.jIE.atZ() != null) {
            this.jIE.atZ().onChangeSkinType(i);
        }
        SvgManager.amN().a(this.NK, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
