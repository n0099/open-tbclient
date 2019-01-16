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
    private boolean US;
    private String aFq;
    private e anG;
    private String arJ;
    public ImageView bMM;
    private n bPd;
    private AlphaAnimation bSG;
    private String bVu;
    private com.baidu.tieba.view.a cZb;
    private View dBH;
    private boolean eqF;
    private QuickVideoView.c gGB;
    private j.b gGl;
    private TextView hPA;
    private boolean hPB;
    public ImageView hPC;
    public TextView hPD;
    private View hPE;
    private TextView hPF;
    private int hPG;
    private int hPH;
    private int hPI;
    protected Animation hPJ;
    private boolean hPK;
    private AnimatorSet hPL;
    private RelativeLayout.LayoutParams hPM;
    private com.baidu.tieba.videoplay.editor.a hPO;
    com.baidu.tbadk.core.dialog.a hPP;
    public QuickVideoView hPh;
    private TbImageView hPi;
    public HeadImageView hPj;
    public LinearLayout hPk;
    public LinearLayout hPl;
    public LinearLayout hPm;
    public ImageView hPn;
    public ImageView hPo;
    public ImageView hPp;
    public TextView hPq;
    public TextView hPr;
    public TextView hPs;
    public TextView hPt;
    public TextView hPu;
    public ImageView hPv;
    private LinearLayout hPw;
    public LinearLayout hPx;
    public LinearLayout hPy;
    public VideoItemData hPz;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int hPf = 0;
    private int hPg = 1;
    private ForumManageModel cZj = null;
    private com.baidu.tbadk.baseEditMark.a fWL = null;
    private com.baidu.tbadk.coreExtra.model.a aCD = null;
    private BdUniqueId aCu = BdUniqueId.gen();
    private boolean hPN = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.hPz != null && VideoPlayFragment.this.hPz.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hPz.author_info.user_id) && data != null && VideoPlayFragment.this.hPz.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aCu)) ? false : false;
                    if (data.aPX == null) {
                        if (!data.Jr) {
                            if (z && !"0".equals(VideoPlayFragment.this.hPz.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_fail);
                                VideoPlayFragment.this.hPz.author_info.is_follow = "0";
                                VideoPlayFragment.this.bMW();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.hPB) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.hPz));
                                    return;
                                }
                                VideoPlayFragment.this.hPz.author_info.is_follow = "1";
                                VideoPlayFragment.this.bMW();
                            }
                        } else {
                            VideoPlayFragment.this.hPz.author_info.is_follow = "0";
                            VideoPlayFragment.this.bMW();
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
                VideoPlayFragment.this.bMY();
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
        this.hPz = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hPI = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.bVu = arguments.getString("from");
        this.arJ = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.hPz != null && this.hPz.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hPz.author_info.user_id)) {
            this.eqF = true;
        }
        this.bPd = new n(getActivity());
        this.bPd.a(this.hPz);
        this.bPd.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bD(int i, int i2) {
                if (VideoPlayFragment.this.gGl != null) {
                    VideoPlayFragment.this.gGl.bD(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(e.h.video_play_view, (ViewGroup) null);
        this.hPh = (QuickVideoView) this.mRootView.findViewById(e.g.videoView);
        this.hPh.setPlayerReuseEnable(true);
        this.hPh.setContinuePlayEnable(true);
        this.hPh.setBusiness(this.bPd);
        this.hPh.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.gGB != null) {
                    VideoPlayFragment.this.gGB.onStart();
                }
            }
        });
        this.hPh.setNeedRecovery(true);
        if (this.hPz != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.bjm = this.hPz.thread_id;
            zVar.dbr = this.hPz.forum_id;
            zVar.gIM = this.hPz.mMd5;
            zVar.arJ = "";
            zVar.mSource = this.hPz.mRecomSource;
            zVar.gIL = this.hPz.mRecomAbTag;
            zVar.gIJ = this.hPz.mRecomWeight;
            if (this.mRect != null) {
                zVar.gIN = "1";
            } else {
                zVar.gIN = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.gIO = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.gIK = this.bVu;
                zVar.arJ = this.arJ;
                zVar.gII = this.hPz.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.bPd.setVideoStatsData(zVar);
        }
        this.hPi = (TbImageView) this.mRootView.findViewById(e.g.video_cover);
        this.hPi.setDefaultBgResource(e.f.icon_play_bg);
        this.hPi.setDefaultErrorResource(e.f.icon_play_bg);
        if (g.CS()) {
            this.dBH = this.mRootView.findViewById(e.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.dBH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dBH.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(e.g.back_btn);
        this.bMM = (ImageView) this.mRootView.findViewById(e.g.more_btn);
        this.hPj = (HeadImageView) this.mRootView.findViewById(e.g.author_portrait);
        this.hPj.setDefaultResource(17170445);
        this.hPj.setDefaultBgResource(e.d.cp_bg_line_e);
        this.hPj.setIsRound(true);
        this.hPn = (ImageView) this.mRootView.findViewById(e.g.love_btn);
        this.hPC = (ImageView) this.mRootView.findViewById(e.g.agree_img);
        this.hPq = (TextView) this.mRootView.findViewById(e.g.video_title);
        this.hPr = (TextView) this.mRootView.findViewById(e.g.video_activity);
        this.hPl = (LinearLayout) this.mRootView.findViewById(e.g.comment_container);
        this.hPs = (TextView) this.mRootView.findViewById(e.g.comment_num);
        this.hPk = (LinearLayout) this.mRootView.findViewById(e.g.agree_container);
        this.hPt = (TextView) this.mRootView.findViewById(e.g.agree_num);
        this.hPu = (TextView) this.mRootView.findViewById(e.g.share_num);
        this.hPo = (ImageView) this.mRootView.findViewById(e.g.share_img);
        this.hPp = (ImageView) this.mRootView.findViewById(e.g.share_img_changed);
        bMR();
        this.hPv = (ImageView) this.mRootView.findViewById(e.g.play_btn);
        this.hPw = (LinearLayout) this.mRootView.findViewById(e.g.video_act_private_container);
        this.hPx = (LinearLayout) this.mRootView.findViewById(e.g.video_activity_container);
        this.hPy = (LinearLayout) this.mRootView.findViewById(e.g.video_private);
        this.hPm = (LinearLayout) this.mRootView.findViewById(e.g.share_container);
        this.hPD = (TextView) this.mRootView.findViewById(e.g.video_author_name);
        this.hPE = this.mRootView.findViewById(e.g.quick_reply_comment_layout);
        this.hPE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.hPE.setVisibility(4);
                    if (VideoPlayFragment.this.hPO != null && VideoPlayFragment.this.hPO.Mp() != null) {
                        VideoPlayFragment.this.hPO.Mp().pR();
                    }
                    if (VideoPlayFragment.this.hPz != null) {
                        am amVar = new am("c13025");
                        amVar.aB("tid", VideoPlayFragment.this.hPz.thread_id);
                        amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.aB(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.hPz.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.hPF = (TextView) this.mRootView.findViewById(e.g.quick_reply_comment_text);
        this.hPA = (TextView) this.mRootView.findViewById(e.g.download_nani_guide_txt);
        this.hPA.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hPA.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.hPA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.Es().a((TbPageContext) i.aK(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bMV();
        this.hPj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hPz != null && VideoPlayFragment.this.hPz.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hPz.author_info.user_id) && VideoPlayFragment.this.hPz != null && VideoPlayFragment.this.hPz.author_info != null) {
                    long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.hPz.author_info.user_id, 0L);
                    long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = d == d2;
                    if (d == 0 && d2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(d, z, false)));
                    am amVar = new am("c12798");
                    amVar.aB("tid", VideoPlayFragment.this.hPz.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hPz != null && VideoPlayFragment.this.hPz.act_info != null) {
                    com.baidu.tbadk.browser.a.af(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.hPz.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.aB("tid", VideoPlayFragment.this.hPz.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hPq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bMT();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hPz != null && !StringUtils.isNull(VideoPlayFragment.this.hPz.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.hPz.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.bMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bMU();
            }
        });
        this.hPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bMT();
                am amVar = new am("c12796");
                amVar.aB("tid", VideoPlayFragment.this.hPz.thread_id);
                amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hPk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.wY(VideoPlayFragment.this.hPf);
            }
        });
        this.hPm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.FD();
                am amVar = new am("c12797");
                amVar.aB("tid", VideoPlayFragment.this.hPz.thread_id);
                amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hPn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hPz != null && VideoPlayFragment.this.hPz.author_info != null) {
                    VideoPlayFragment.this.aCD.a(true, VideoPlayFragment.this.hPz.author_info.portrait, VideoPlayFragment.this.hPz.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.aCu, VideoPlayFragment.this.hPz.forum_id, "0");
                    VideoPlayFragment.this.hPz.author_info.is_follow = "1";
                    VideoPlayFragment.this.bMW();
                }
            }
        });
        this.bSG = new AlphaAnimation(1.0f, 0.0f);
        this.bSG.setDuration(100L);
        this.bSG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.hPi != null) {
                    VideoPlayFragment.this.hPi.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.hPG = this.mRect.right - this.mRect.left;
            this.hPH = this.mRect.bottom - this.mRect.top;
            this.hPi.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.hPi.getWidth();
                    int height = VideoPlayFragment.this.hPi.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hPz.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hPz.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hPz.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hPz.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hPG, VideoPlayFragment.this.hPH);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.hPi.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hPH > 0 || VideoPlayFragment.this.hPG <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.hPG;
                                f = i / VideoPlayFragment.this.hPH;
                            }
                            VideoPlayFragment.this.hPi.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.hPi.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.hPB) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hPG, VideoPlayFragment.this.hPH);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.hPi.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hPH > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.hPi.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.hPi.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.hPB) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.hPi.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.hPi.getWidth();
                    int height = VideoPlayFragment.this.hPi.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hPz.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hPz.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hPz.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hPz.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.hPi.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.hPi.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.hPB) {
            bMS();
        }
        if (this.hPz != null && !StringUtils.isNull(this.hPz.video_url)) {
            xx(this.hPz.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.gGl = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gGB = cVar;
    }

    private void initEditor() {
        this.hPO = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().bM(getActivity());
        if (this.hPO != null && this.hPz != null) {
            this.hPO.setContext(getPageContext());
            this.hPO.R(this.hPz.thread_id, this.hPz.forum_id, this.hPz.forum_name);
            this.hPO.a(new a.InterfaceC0332a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0332a
                public void on(boolean z) {
                    VideoPlayFragment.this.hPE.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.hPF.setText(e.j.reply_something);
                    } else {
                        VideoPlayFragment.this.hPF.setText(StringUtils.isNull(((c) VideoPlayFragment.this.hPO.Mp().fL(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.hPz != null && z) {
                        long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.hPz.comment_num, 0L) + 1;
                        VideoPlayFragment.this.hPz.comment_num = String.valueOf(d);
                        VideoPlayFragment.this.hPs.setText(ao.X(d));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.hPO.Mp(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        if (this.hPz != null) {
            String str = this.hPz.forum_id;
            String str2 = this.hPz.forum_name;
            String str3 = this.hPz.title;
            String str4 = this.hPz.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hPz.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            d dVar = new d();
            dVar.title = str3;
            dVar.content = format;
            dVar.aSQ = "";
            dVar.linkUrl = str5;
            dVar.awn = 2;
            dVar.extData = str4;
            dVar.aST = 3;
            dVar.fid = str;
            dVar.aSL = str2;
            dVar.tid = str4;
            dVar.aSH = true;
            dVar.aSS = 0;
            dVar.aSU = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hPz.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hPz.title;
            originalThreadInfo.threadId = this.hPz.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aST);
            bundle.putInt("obj_type", dVar.aSU);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.awn);
            dVar.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.asB().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eqF) {
            this.cZj = new ForumManageModel(getPageContext());
            this.cZj.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.cZj.getLoadDataMode()) {
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
        this.fWL = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.fWL != null) {
            this.fWL.a(new a.InterfaceC0154a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0154a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.fWL != null) {
                            VideoPlayFragment.this.fWL.aQ(z2);
                        }
                        if (VideoPlayFragment.this.hPz != null) {
                            if (z2) {
                                VideoPlayFragment.this.hPz.mark_id = VideoPlayFragment.this.hPz.post_id;
                            } else {
                                VideoPlayFragment.this.hPz.mark_id = null;
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
        this.aCD = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.hPN = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bMV();
        if (Build.VERSION.SDK_INT >= 17) {
            this.hPh.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.hPB && i == 3 && VideoPlayFragment.this.hPi.getVisibility() == 0) {
                        VideoPlayFragment.this.hPi.clearAnimation();
                        VideoPlayFragment.this.hPi.startAnimation(VideoPlayFragment.this.bSG);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.hPh.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.hPh != null) {
                    VideoPlayFragment.this.hPh.seekTo(0);
                    VideoPlayFragment.this.hPh.start();
                    VideoPlayFragment.this.aqy();
                    VideoPlayFragment.x(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.bMQ();
                    }
                }
            }
        });
        this.hPh.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.hPi != null) {
                        VideoPlayFragment.this.hPi.clearAnimation();
                        VideoPlayFragment.this.hPi.startAnimation(VideoPlayFragment.this.bSG);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMQ() {
        if (this.hPp != null && this.hPo != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.hPo.clearAnimation();
            this.hPp.clearAnimation();
            this.hPo.setVisibility(8);
            this.hPp.setVisibility(0);
            this.hPp.startAnimation(scaleAnimation2);
            this.hPo.startAnimation(scaleAnimation);
        }
    }

    private void bMR() {
        if (this.hPp != null && this.hPo != null) {
            this.hPo.clearAnimation();
            this.hPp.clearAnimation();
            this.hPo.setVisibility(0);
            this.hPp.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wY(int i) {
        int i2;
        if (ba.bJ(getActivity()) && this.hPz != null) {
            if (i == this.hPf) {
                if ("1".equals(this.hPz.is_agreed)) {
                    i2 = 1;
                    this.hPz.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hPz.agree_num, 0) - 1);
                    this.hPz.is_agreed = "0";
                } else {
                    this.hPz.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hPz.agree_num, 0) + 1);
                    this.hPz.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.hPz.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hPz.agree_num, 0) + 1);
                this.hPz.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.aB("tid", this.hPz.thread_id);
            amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.hPf) {
                amVar.y("obj_type", i2);
            } else {
                amVar.y("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            bMV();
            if (this.hPC != null && i2 == 0) {
                this.hPC.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hPz.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hPz));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hPz != null && !StringUtils.isNull(this.hPz.video_url)) {
            this.US = true;
            if (this.hPB) {
                aqy();
                bag();
                if (this.hPz != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.aB("tid", this.hPz.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.y("obj_type", 0);
                    TiebaStatic.log(amVar);
                }
            } else {
                pausePlay();
            }
        }
        if (this.hPz != null && !ao.isEmpty(this.hPz.thread_id)) {
            com.baidu.tbadk.BdToken.c.vy().f(com.baidu.tbadk.BdToken.b.ake, com.baidu.adp.lib.g.b.d(this.hPz.thread_id, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        stopPlay();
        if (this.hPO != null && this.hPO.Mp() != null) {
            this.hPO.Mp().hide();
            this.hPE.setVisibility(0);
            this.hPF.setText(StringUtils.isNull(((c) this.hPO.Mp().fL(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
            com.baidu.tbadk.BdToken.c.vy().vz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.hPO != null) {
            this.hPO.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.hPB = z;
        if (this.US) {
            if (this.hPB && (!this.hPN || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.hPz != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.aB("tid", this.hPz.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.y("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                bMS();
                this.hPN = false;
                return;
            }
            bMR();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void bMS() {
        if (this.hPz != null) {
            am amVar = new am("c12590");
            amVar.aB("tid", this.hPz.thread_id);
            amVar.aB(ImageViewerConfig.FORUM_ID, this.hPz.forum_id);
            amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.y("obj_locate", this.hPI);
            amVar.aB("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.y("obj_param2", 1);
            amVar.aB("obj_param1", ao.isEmpty(this.hPz.mRecomWeight) ? "0" : this.hPz.mRecomWeight);
            amVar.aB("extra", ao.isEmpty(this.hPz.mRecomExtra) ? "0" : this.hPz.mRecomExtra);
            amVar.aB(VideoPlayActivityConfig.OBJ_ID, this.arJ);
            amVar.aB("ab_tag", ao.isEmpty(this.hPz.mRecomAbTag) ? "0" : this.hPz.mRecomAbTag);
            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.hPz.mRecomSource) ? "0" : this.hPz.mRecomSource);
            amVar.aB("obj_type", this.bVu);
            amVar.y("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void xx(String str) {
        if (this.hPh != null && str != null && !str.equals(this.aFq)) {
            this.hPh.setRecoveryState(0);
            this.hPh.setVideoPath(str, this.hPz.thread_id);
            this.aFq = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.bJp().bJq() || bMY()) {
            bss();
            if (this.hPv != null) {
                this.hPv.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hPi.getVisibility() == 0) {
                this.hPi.clearAnimation();
                this.hPi.startAnimation(this.bSG);
            }
            if (this.hPh != null) {
                this.hPh.start();
                aqy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqy() {
        if (this.hPz != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.bjm = this.hPz.thread_id;
            zVar.dbr = this.hPz.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.hPz.mRecomSource;
            zVar.gII = this.hPz.mRecomAbTag;
            zVar.gIJ = this.hPz.mRecomWeight;
            zVar.gIK = "";
            zVar.arJ = "";
            zVar.gIM = this.hPz.mMd5;
            if (this.mRect != null) {
                zVar.gIN = "1";
            } else {
                zVar.gIN = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.gIO = "1";
                zVar.mLocate = "auto_midpage";
                zVar.gIK = "index";
            }
            com.baidu.tieba.play.l.a(this.hPz.mMd5, "", "1", zVar);
        }
    }

    private void bss() {
        if (com.baidu.adp.lib.util.j.kX()) {
            com.baidu.tieba.video.g.bJp().dc(getContext());
        }
    }

    private void pausePlay() {
        if (this.hPh != null) {
            this.hPh.pause();
        }
    }

    private void stopPlay() {
        if (this.hPh != null) {
            this.hPh.setRecoveryState(5);
            this.hPh.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMT() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hPz.thread_id, this.hPz.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hPz.forum_id));
        createNormalCfg.setForumName(this.hPz.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMU() {
        if (this.anG == null) {
            this.cZb = new com.baidu.tieba.view.a(getActivity());
            this.anG = new com.baidu.tieba.person.e(getActivity(), this.cZb.bNw());
            this.anG.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.hPh.setSystemUiVisibility(4);
                }
            });
        }
        if (this.cZb != null) {
            ArrayList arrayList = new ArrayList();
            a.C0333a c0333a = new a.C0333a(this.cZb);
            c0333a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.anG.dismiss();
                    if (VideoPlayFragment.this.hPz != null) {
                        boolean z = VideoPlayFragment.this.hPz.post_id != null && VideoPlayFragment.this.hPz.post_id.equals(VideoPlayFragment.this.hPz.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.hPz.thread_id);
                        markData.setPostId(VideoPlayFragment.this.hPz.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.hPz.thread_id);
                        markData.setForumId(VideoPlayFragment.this.hPz.forum_id);
                        if (VideoPlayFragment.this.fWL != null) {
                            VideoPlayFragment.this.fWL.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.fWL.wz();
                            } else {
                                VideoPlayFragment.this.fWL.wy();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hPz != null && this.hPz.post_id != null && this.hPz.post_id.equals(this.hPz.mark_id)) {
                z = true;
            }
            if (z) {
                c0333a.setText(getResources().getString(e.j.remove_mark));
            } else {
                c0333a.setText(getResources().getString(e.j.mark));
            }
            arrayList.add(c0333a);
            a.C0333a c0333a2 = new a.C0333a(getActivity().getString(e.j.delete), this.cZb);
            c0333a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.anG.dismiss();
                    if (ba.bJ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hPz != null) {
                        String str = VideoPlayFragment.this.hPz.thread_id;
                        String str2 = VideoPlayFragment.this.hPz.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(e.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.hPz.post_id, true)));
                    }
                }
            });
            c0333a2.setText(getResources().getString(e.j.report_text));
            arrayList.add(c0333a2);
            if (this.eqF) {
                a.C0333a c0333a3 = new a.C0333a(getActivity().getString(e.j.delete), this.cZb);
                c0333a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.anG.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.db(e.j.del_thread_confirm);
                        aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.hPz != null) {
                                    VideoPlayFragment.this.cZj.a(VideoPlayFragment.this.hPz.forum_id, VideoPlayFragment.this.hPz.forum_name, VideoPlayFragment.this.hPz.thread_id, VideoPlayFragment.this.hPz.post_id, 0, 0, VideoPlayFragment.this.eqF);
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
                        aVar.bg(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.BS();
                    }
                });
                c0333a3.setText(getResources().getString(e.j.delete));
                arrayList.add(c0333a3);
            }
            this.cZb.ef(arrayList);
        }
        this.anG.show();
    }

    private void bMV() {
        if (this.hPz != null) {
            this.hPi.startLoad(this.hPz.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.hPz.title);
            if (StringUtils.isNull(this.hPz.title) || matcher.matches()) {
                this.hPq.setVisibility(8);
            } else {
                this.hPq.setVisibility(0);
                this.hPq.setText(this.hPz.title);
            }
            this.hPs.setText(ao.X(com.baidu.adp.lib.g.b.d(this.hPz.comment_num, 0L)));
            this.hPt.setText(ao.X(com.baidu.adp.lib.g.b.d(this.hPz.agree_num, 0L)));
            this.hPu.setText(ao.X(com.baidu.adp.lib.g.b.d(this.hPz.share_num, 0L)));
            if (this.hPz.author_info != null) {
                if (!StringUtils.isNull(this.hPz.author_info.portrait) && this.hPz.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.hPj.startLoad(this.hPz.author_info.portrait, 10, false);
                } else {
                    this.hPj.startLoad(this.hPz.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.hPz.author_info.bJl())) {
                    this.hPD.setVisibility(8);
                } else {
                    this.hPD.setVisibility(0);
                    this.hPD.setText("@" + this.hPz.author_info.bJl());
                }
            }
            if ("1".equals(this.hPz.is_private) && this.hPA.getVisibility() != 0) {
                this.hPy.setVisibility(0);
            } else {
                this.hPy.setVisibility(8);
            }
            if ("1".equals(this.hPz.is_agreed)) {
                al.c(this.hPC, e.f.icon_card_like_white_full_s);
            } else {
                al.c(this.hPC, e.f.btn_video_agree);
            }
            if (this.hPz.act_info != null && !StringUtils.isNull(this.hPz.act_info.activity_name) && this.hPA.getVisibility() != 0) {
                this.hPx.setVisibility(0);
                this.hPr.setText(this.hPz.act_info.activity_name);
            } else {
                this.hPx.setVisibility(8);
            }
            bMW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMW() {
        if (this.eqF || (this.hPz.author_info != null && !"0".equals(this.hPz.author_info.is_follow))) {
            this.hPn.setVisibility(4);
            this.hPn.setClickable(false);
            return;
        }
        this.hPn.setVisibility(0);
        this.hPn.setClickable(true);
    }

    private void bMX() {
        if (getActivity() != null) {
            if (this.hPP == null || !this.hPP.isShowing()) {
                this.hPP = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(e.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(e.g.tv_title)).setText(e.j.confirm_title);
                ((TextView) inflate.findViewById(e.g.tv_msg)).setText(e.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(e.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(e.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.hPP.G(inflate);
                this.hPP.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.hPP.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.hPP.dd(1);
                this.hPP.dc(e.d.cp_cont_b);
                this.hPP.bg(true);
                this.hPP.b(getPageContext());
                this.hPP.BS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bMY() {
        if (!com.baidu.adp.lib.util.j.kV() || com.baidu.adp.lib.util.j.kW()) {
            return true;
        }
        if (!this.hPB || com.baidu.tieba.video.g.bJp().bJq()) {
            return false;
        }
        if (this.hPv != null) {
            this.hPv.setVisibility(0);
        }
        pausePlay();
        bMX();
        return false;
    }

    private void bag() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bMY() || com.baidu.tieba.video.g.bJp().bJq()) && this.hPh != null && this.hPv != null) {
            this.hPh.start();
            this.hPv.setVisibility(8);
            bss();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.hPJ == null) {
            this.hPJ = AnimationUtils.loadAnimation(getContext(), e.a.scale_zoom_in_and_out_anim);
        }
        return this.hPJ;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
    public void TZ() {
        if (this.hPh.isPlaying()) {
            this.hPh.pause();
            this.hPv.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bMY() || com.baidu.tieba.video.g.bJp().bJq()) {
            this.hPh.start();
            this.hPv.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
    public void t(float f, float f2) {
        if (ba.bJ(getActivity()) && !this.hPK) {
            bMZ();
            if (this.hPz != null && "0".equals(this.hPz.is_agreed)) {
                wY(this.hPg);
            }
        }
    }

    private void bMZ() {
        if (this.mRootView != null) {
            this.hPK = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(e.f.icon_video_like);
            if (this.hPM == null) {
                this.hPM = new RelativeLayout.LayoutParams(-2, -2);
                this.hPM.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.hPM);
            }
            if (this.hPL == null) {
                this.hPL = new AnimatorSet();
                this.hPL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.hPK = false;
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
            this.hPL.setTarget(imageView);
            this.hPL.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.hPL.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
    public void Ua() {
        if (this.hPz != null && this.hPz.author_info != null) {
            long d = com.baidu.adp.lib.g.b.d(this.hPz.author_info.user_id, 0L);
            long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = d == d2;
            if (d == 0 && d2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(d, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.hPh != null) {
            return this.hPh.getMediaIDs();
        }
        return null;
    }

    public String bNa() {
        if (this.hPh != null) {
            return this.hPh.getMediaId();
        }
        return null;
    }

    public boolean bNb() {
        if (this.hPO == null || this.hPO.Mp() == null || !this.hPO.Mp().isVisible()) {
            return false;
        }
        this.hPO.Mp().hide();
        this.hPE.setVisibility(0);
        if ((this.hPO.Mp().fL(28) instanceof c) && ((c) this.hPO.Mp().fL(28)).getInputView() != null && ((c) this.hPO.Mp().fL(28)).getInputView().getText() != null) {
            this.hPF.setText(StringUtils.isNull(((c) this.hPO.Mp().fL(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.hPO != null) {
            this.hPO.onActivityResult(i, i2, intent);
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
        if (this.hPO != null && this.hPO.Mp() != null) {
            this.hPO.Mp().onChangeSkinType(i);
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
