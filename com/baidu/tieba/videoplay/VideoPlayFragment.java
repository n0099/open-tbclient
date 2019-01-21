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
    private String aFr;
    private e anH;
    private String arK;
    public ImageView bMN;
    private n bPe;
    private AlphaAnimation bSH;
    private String bVv;
    private com.baidu.tieba.view.a cZc;
    private View dBI;
    private boolean eqG;
    private QuickVideoView.c gGC;
    private j.b gGm;
    public VideoItemData hPA;
    private TextView hPB;
    private boolean hPC;
    public ImageView hPD;
    public TextView hPE;
    private View hPF;
    private TextView hPG;
    private int hPH;
    private int hPI;
    private int hPJ;
    protected Animation hPK;
    private boolean hPL;
    private AnimatorSet hPM;
    private RelativeLayout.LayoutParams hPN;
    private com.baidu.tieba.videoplay.editor.a hPP;
    com.baidu.tbadk.core.dialog.a hPQ;
    public QuickVideoView hPi;
    private TbImageView hPj;
    public HeadImageView hPk;
    public LinearLayout hPl;
    public LinearLayout hPm;
    public LinearLayout hPn;
    public ImageView hPo;
    public ImageView hPp;
    public ImageView hPq;
    public TextView hPr;
    public TextView hPs;
    public TextView hPt;
    public TextView hPu;
    public TextView hPv;
    public ImageView hPw;
    private LinearLayout hPx;
    public LinearLayout hPy;
    public LinearLayout hPz;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int hPg = 0;
    private int hPh = 1;
    private ForumManageModel cZk = null;
    private com.baidu.tbadk.baseEditMark.a fWM = null;
    private com.baidu.tbadk.coreExtra.model.a aCE = null;
    private BdUniqueId aCv = BdUniqueId.gen();
    private boolean hPO = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.hPA != null && VideoPlayFragment.this.hPA.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hPA.author_info.user_id) && data != null && VideoPlayFragment.this.hPA.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aCv)) ? false : false;
                    if (data.aPY == null) {
                        if (!data.Jr) {
                            if (z && !"0".equals(VideoPlayFragment.this.hPA.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_fail);
                                VideoPlayFragment.this.hPA.author_info.is_follow = "0";
                                VideoPlayFragment.this.bMW();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.hPC) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.hPA));
                                    return;
                                }
                                VideoPlayFragment.this.hPA.author_info.is_follow = "1";
                                VideoPlayFragment.this.bMW();
                            }
                        } else {
                            VideoPlayFragment.this.hPA.author_info.is_follow = "0";
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
        this.hPA = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hPJ = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.bVv = arguments.getString("from");
        this.arK = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.hPA != null && this.hPA.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hPA.author_info.user_id)) {
            this.eqG = true;
        }
        this.bPe = new n(getActivity());
        this.bPe.a(this.hPA);
        this.bPe.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bD(int i, int i2) {
                if (VideoPlayFragment.this.gGm != null) {
                    VideoPlayFragment.this.gGm.bD(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(e.h.video_play_view, (ViewGroup) null);
        this.hPi = (QuickVideoView) this.mRootView.findViewById(e.g.videoView);
        this.hPi.setPlayerReuseEnable(true);
        this.hPi.setContinuePlayEnable(true);
        this.hPi.setBusiness(this.bPe);
        this.hPi.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.gGC != null) {
                    VideoPlayFragment.this.gGC.onStart();
                }
            }
        });
        this.hPi.setNeedRecovery(true);
        if (this.hPA != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.bjn = this.hPA.thread_id;
            zVar.dbs = this.hPA.forum_id;
            zVar.gIN = this.hPA.mMd5;
            zVar.arK = "";
            zVar.mSource = this.hPA.mRecomSource;
            zVar.gIM = this.hPA.mRecomAbTag;
            zVar.gIK = this.hPA.mRecomWeight;
            if (this.mRect != null) {
                zVar.gIO = "1";
            } else {
                zVar.gIO = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.gIP = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.gIL = this.bVv;
                zVar.arK = this.arK;
                zVar.gIJ = this.hPA.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.bPe.setVideoStatsData(zVar);
        }
        this.hPj = (TbImageView) this.mRootView.findViewById(e.g.video_cover);
        this.hPj.setDefaultBgResource(e.f.icon_play_bg);
        this.hPj.setDefaultErrorResource(e.f.icon_play_bg);
        if (g.CS()) {
            this.dBI = this.mRootView.findViewById(e.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.dBI.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dBI.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(e.g.back_btn);
        this.bMN = (ImageView) this.mRootView.findViewById(e.g.more_btn);
        this.hPk = (HeadImageView) this.mRootView.findViewById(e.g.author_portrait);
        this.hPk.setDefaultResource(17170445);
        this.hPk.setDefaultBgResource(e.d.cp_bg_line_e);
        this.hPk.setIsRound(true);
        this.hPo = (ImageView) this.mRootView.findViewById(e.g.love_btn);
        this.hPD = (ImageView) this.mRootView.findViewById(e.g.agree_img);
        this.hPr = (TextView) this.mRootView.findViewById(e.g.video_title);
        this.hPs = (TextView) this.mRootView.findViewById(e.g.video_activity);
        this.hPm = (LinearLayout) this.mRootView.findViewById(e.g.comment_container);
        this.hPt = (TextView) this.mRootView.findViewById(e.g.comment_num);
        this.hPl = (LinearLayout) this.mRootView.findViewById(e.g.agree_container);
        this.hPu = (TextView) this.mRootView.findViewById(e.g.agree_num);
        this.hPv = (TextView) this.mRootView.findViewById(e.g.share_num);
        this.hPp = (ImageView) this.mRootView.findViewById(e.g.share_img);
        this.hPq = (ImageView) this.mRootView.findViewById(e.g.share_img_changed);
        bMR();
        this.hPw = (ImageView) this.mRootView.findViewById(e.g.play_btn);
        this.hPx = (LinearLayout) this.mRootView.findViewById(e.g.video_act_private_container);
        this.hPy = (LinearLayout) this.mRootView.findViewById(e.g.video_activity_container);
        this.hPz = (LinearLayout) this.mRootView.findViewById(e.g.video_private);
        this.hPn = (LinearLayout) this.mRootView.findViewById(e.g.share_container);
        this.hPE = (TextView) this.mRootView.findViewById(e.g.video_author_name);
        this.hPF = this.mRootView.findViewById(e.g.quick_reply_comment_layout);
        this.hPF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.hPF.setVisibility(4);
                    if (VideoPlayFragment.this.hPP != null && VideoPlayFragment.this.hPP.Mp() != null) {
                        VideoPlayFragment.this.hPP.Mp().pR();
                    }
                    if (VideoPlayFragment.this.hPA != null) {
                        am amVar = new am("c13025");
                        amVar.aB("tid", VideoPlayFragment.this.hPA.thread_id);
                        amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.aB(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.hPA.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.hPG = (TextView) this.mRootView.findViewById(e.g.quick_reply_comment_text);
        this.hPB = (TextView) this.mRootView.findViewById(e.g.download_nani_guide_txt);
        this.hPB.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hPB.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.hPB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.Es().a((TbPageContext) i.aK(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bMV();
        this.hPk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hPA != null && VideoPlayFragment.this.hPA.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hPA.author_info.user_id) && VideoPlayFragment.this.hPA != null && VideoPlayFragment.this.hPA.author_info != null) {
                    long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.hPA.author_info.user_id, 0L);
                    long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = d == d2;
                    if (d == 0 && d2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(d, z, false)));
                    am amVar = new am("c12798");
                    amVar.aB("tid", VideoPlayFragment.this.hPA.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hPy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hPA != null && VideoPlayFragment.this.hPA.act_info != null) {
                    com.baidu.tbadk.browser.a.af(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.hPA.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.aB("tid", VideoPlayFragment.this.hPA.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hPr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bMT();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hPA != null && !StringUtils.isNull(VideoPlayFragment.this.hPA.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.hPA.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.bMN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bMU();
            }
        });
        this.hPm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bMT();
                am amVar = new am("c12796");
                amVar.aB("tid", VideoPlayFragment.this.hPA.thread_id);
                amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.wY(VideoPlayFragment.this.hPg);
            }
        });
        this.hPn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.FD();
                am amVar = new am("c12797");
                amVar.aB("tid", VideoPlayFragment.this.hPA.thread_id);
                amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hPo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hPA != null && VideoPlayFragment.this.hPA.author_info != null) {
                    VideoPlayFragment.this.aCE.a(true, VideoPlayFragment.this.hPA.author_info.portrait, VideoPlayFragment.this.hPA.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.aCv, VideoPlayFragment.this.hPA.forum_id, "0");
                    VideoPlayFragment.this.hPA.author_info.is_follow = "1";
                    VideoPlayFragment.this.bMW();
                }
            }
        });
        this.bSH = new AlphaAnimation(1.0f, 0.0f);
        this.bSH.setDuration(100L);
        this.bSH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.hPj != null) {
                    VideoPlayFragment.this.hPj.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.hPH = this.mRect.right - this.mRect.left;
            this.hPI = this.mRect.bottom - this.mRect.top;
            this.hPj.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.hPj.getWidth();
                    int height = VideoPlayFragment.this.hPj.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hPA.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hPA.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hPA.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hPA.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hPH, VideoPlayFragment.this.hPI);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.hPj.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hPI > 0 || VideoPlayFragment.this.hPH <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.hPH;
                                f = i / VideoPlayFragment.this.hPI;
                            }
                            VideoPlayFragment.this.hPj.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.hPj.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.hPC) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hPH, VideoPlayFragment.this.hPI);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.hPj.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hPI > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.hPj.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.hPj.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.hPC) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.hPj.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.hPj.getWidth();
                    int height = VideoPlayFragment.this.hPj.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hPA.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hPA.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hPA.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hPA.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.hPj.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.hPj.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.hPC) {
            bMS();
        }
        if (this.hPA != null && !StringUtils.isNull(this.hPA.video_url)) {
            xx(this.hPA.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.gGm = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gGC = cVar;
    }

    private void initEditor() {
        this.hPP = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().bM(getActivity());
        if (this.hPP != null && this.hPA != null) {
            this.hPP.setContext(getPageContext());
            this.hPP.R(this.hPA.thread_id, this.hPA.forum_id, this.hPA.forum_name);
            this.hPP.a(new a.InterfaceC0332a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0332a
                public void on(boolean z) {
                    VideoPlayFragment.this.hPF.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.hPG.setText(e.j.reply_something);
                    } else {
                        VideoPlayFragment.this.hPG.setText(StringUtils.isNull(((c) VideoPlayFragment.this.hPP.Mp().fL(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.hPA != null && z) {
                        long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.hPA.comment_num, 0L) + 1;
                        VideoPlayFragment.this.hPA.comment_num = String.valueOf(d);
                        VideoPlayFragment.this.hPt.setText(ao.X(d));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.hPP.Mp(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        if (this.hPA != null) {
            String str = this.hPA.forum_id;
            String str2 = this.hPA.forum_name;
            String str3 = this.hPA.title;
            String str4 = this.hPA.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hPA.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            d dVar = new d();
            dVar.title = str3;
            dVar.content = format;
            dVar.aSR = "";
            dVar.linkUrl = str5;
            dVar.awo = 2;
            dVar.extData = str4;
            dVar.aSU = 3;
            dVar.fid = str;
            dVar.aSM = str2;
            dVar.tid = str4;
            dVar.aSI = true;
            dVar.aST = 0;
            dVar.aSV = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hPA.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hPA.title;
            originalThreadInfo.threadId = this.hPA.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aSU);
            bundle.putInt("obj_type", dVar.aSV);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.awo);
            dVar.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.asB().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eqG) {
            this.cZk = new ForumManageModel(getPageContext());
            this.cZk.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.cZk.getLoadDataMode()) {
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
        this.fWM = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.fWM != null) {
            this.fWM.a(new a.InterfaceC0154a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0154a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.fWM != null) {
                            VideoPlayFragment.this.fWM.aQ(z2);
                        }
                        if (VideoPlayFragment.this.hPA != null) {
                            if (z2) {
                                VideoPlayFragment.this.hPA.mark_id = VideoPlayFragment.this.hPA.post_id;
                            } else {
                                VideoPlayFragment.this.hPA.mark_id = null;
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
        this.aCE = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.hPO = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bMV();
        if (Build.VERSION.SDK_INT >= 17) {
            this.hPi.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.hPC && i == 3 && VideoPlayFragment.this.hPj.getVisibility() == 0) {
                        VideoPlayFragment.this.hPj.clearAnimation();
                        VideoPlayFragment.this.hPj.startAnimation(VideoPlayFragment.this.bSH);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.hPi.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.hPi != null) {
                    VideoPlayFragment.this.hPi.seekTo(0);
                    VideoPlayFragment.this.hPi.start();
                    VideoPlayFragment.this.aqy();
                    VideoPlayFragment.x(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.bMQ();
                    }
                }
            }
        });
        this.hPi.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.hPj != null) {
                        VideoPlayFragment.this.hPj.clearAnimation();
                        VideoPlayFragment.this.hPj.startAnimation(VideoPlayFragment.this.bSH);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMQ() {
        if (this.hPq != null && this.hPp != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.hPp.clearAnimation();
            this.hPq.clearAnimation();
            this.hPp.setVisibility(8);
            this.hPq.setVisibility(0);
            this.hPq.startAnimation(scaleAnimation2);
            this.hPp.startAnimation(scaleAnimation);
        }
    }

    private void bMR() {
        if (this.hPq != null && this.hPp != null) {
            this.hPp.clearAnimation();
            this.hPq.clearAnimation();
            this.hPp.setVisibility(0);
            this.hPq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wY(int i) {
        int i2;
        if (ba.bJ(getActivity()) && this.hPA != null) {
            if (i == this.hPg) {
                if ("1".equals(this.hPA.is_agreed)) {
                    i2 = 1;
                    this.hPA.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hPA.agree_num, 0) - 1);
                    this.hPA.is_agreed = "0";
                } else {
                    this.hPA.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hPA.agree_num, 0) + 1);
                    this.hPA.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.hPA.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hPA.agree_num, 0) + 1);
                this.hPA.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.aB("tid", this.hPA.thread_id);
            amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.hPg) {
                amVar.y("obj_type", i2);
            } else {
                amVar.y("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            bMV();
            if (this.hPD != null && i2 == 0) {
                this.hPD.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hPA.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hPA));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hPA != null && !StringUtils.isNull(this.hPA.video_url)) {
            this.US = true;
            if (this.hPC) {
                aqy();
                bag();
                if (this.hPA != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.aB("tid", this.hPA.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.y("obj_type", 0);
                    TiebaStatic.log(amVar);
                }
            } else {
                pausePlay();
            }
        }
        if (this.hPA != null && !ao.isEmpty(this.hPA.thread_id)) {
            com.baidu.tbadk.BdToken.c.vy().f(com.baidu.tbadk.BdToken.b.ake, com.baidu.adp.lib.g.b.d(this.hPA.thread_id, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        stopPlay();
        if (this.hPP != null && this.hPP.Mp() != null) {
            this.hPP.Mp().hide();
            this.hPF.setVisibility(0);
            this.hPG.setText(StringUtils.isNull(((c) this.hPP.Mp().fL(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
            com.baidu.tbadk.BdToken.c.vy().vz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.hPP != null) {
            this.hPP.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.hPC = z;
        if (this.US) {
            if (this.hPC && (!this.hPO || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.hPA != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.aB("tid", this.hPA.thread_id);
                    amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.y("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                bMS();
                this.hPO = false;
                return;
            }
            bMR();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void bMS() {
        if (this.hPA != null) {
            am amVar = new am("c12590");
            amVar.aB("tid", this.hPA.thread_id);
            amVar.aB(ImageViewerConfig.FORUM_ID, this.hPA.forum_id);
            amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.y("obj_locate", this.hPJ);
            amVar.aB("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.y("obj_param2", 1);
            amVar.aB("obj_param1", ao.isEmpty(this.hPA.mRecomWeight) ? "0" : this.hPA.mRecomWeight);
            amVar.aB("extra", ao.isEmpty(this.hPA.mRecomExtra) ? "0" : this.hPA.mRecomExtra);
            amVar.aB(VideoPlayActivityConfig.OBJ_ID, this.arK);
            amVar.aB("ab_tag", ao.isEmpty(this.hPA.mRecomAbTag) ? "0" : this.hPA.mRecomAbTag);
            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.hPA.mRecomSource) ? "0" : this.hPA.mRecomSource);
            amVar.aB("obj_type", this.bVv);
            amVar.y("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void xx(String str) {
        if (this.hPi != null && str != null && !str.equals(this.aFr)) {
            this.hPi.setRecoveryState(0);
            this.hPi.setVideoPath(str, this.hPA.thread_id);
            this.aFr = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.bJp().bJq() || bMY()) {
            bss();
            if (this.hPw != null) {
                this.hPw.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hPj.getVisibility() == 0) {
                this.hPj.clearAnimation();
                this.hPj.startAnimation(this.bSH);
            }
            if (this.hPi != null) {
                this.hPi.start();
                aqy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqy() {
        if (this.hPA != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.bjn = this.hPA.thread_id;
            zVar.dbs = this.hPA.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.hPA.mRecomSource;
            zVar.gIJ = this.hPA.mRecomAbTag;
            zVar.gIK = this.hPA.mRecomWeight;
            zVar.gIL = "";
            zVar.arK = "";
            zVar.gIN = this.hPA.mMd5;
            if (this.mRect != null) {
                zVar.gIO = "1";
            } else {
                zVar.gIO = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.gIP = "1";
                zVar.mLocate = "auto_midpage";
                zVar.gIL = "index";
            }
            com.baidu.tieba.play.l.a(this.hPA.mMd5, "", "1", zVar);
        }
    }

    private void bss() {
        if (com.baidu.adp.lib.util.j.kX()) {
            com.baidu.tieba.video.g.bJp().dc(getContext());
        }
    }

    private void pausePlay() {
        if (this.hPi != null) {
            this.hPi.pause();
        }
    }

    private void stopPlay() {
        if (this.hPi != null) {
            this.hPi.setRecoveryState(5);
            this.hPi.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMT() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hPA.thread_id, this.hPA.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hPA.forum_id));
        createNormalCfg.setForumName(this.hPA.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMU() {
        if (this.anH == null) {
            this.cZc = new com.baidu.tieba.view.a(getActivity());
            this.anH = new com.baidu.tieba.person.e(getActivity(), this.cZc.bNw());
            this.anH.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.hPi.setSystemUiVisibility(4);
                }
            });
        }
        if (this.cZc != null) {
            ArrayList arrayList = new ArrayList();
            a.C0333a c0333a = new a.C0333a(this.cZc);
            c0333a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.anH.dismiss();
                    if (VideoPlayFragment.this.hPA != null) {
                        boolean z = VideoPlayFragment.this.hPA.post_id != null && VideoPlayFragment.this.hPA.post_id.equals(VideoPlayFragment.this.hPA.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.hPA.thread_id);
                        markData.setPostId(VideoPlayFragment.this.hPA.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.hPA.thread_id);
                        markData.setForumId(VideoPlayFragment.this.hPA.forum_id);
                        if (VideoPlayFragment.this.fWM != null) {
                            VideoPlayFragment.this.fWM.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.fWM.wz();
                            } else {
                                VideoPlayFragment.this.fWM.wy();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hPA != null && this.hPA.post_id != null && this.hPA.post_id.equals(this.hPA.mark_id)) {
                z = true;
            }
            if (z) {
                c0333a.setText(getResources().getString(e.j.remove_mark));
            } else {
                c0333a.setText(getResources().getString(e.j.mark));
            }
            arrayList.add(c0333a);
            a.C0333a c0333a2 = new a.C0333a(getActivity().getString(e.j.delete), this.cZc);
            c0333a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.anH.dismiss();
                    if (ba.bJ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hPA != null) {
                        String str = VideoPlayFragment.this.hPA.thread_id;
                        String str2 = VideoPlayFragment.this.hPA.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(e.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.hPA.post_id, true)));
                    }
                }
            });
            c0333a2.setText(getResources().getString(e.j.report_text));
            arrayList.add(c0333a2);
            if (this.eqG) {
                a.C0333a c0333a3 = new a.C0333a(getActivity().getString(e.j.delete), this.cZc);
                c0333a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.anH.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.db(e.j.del_thread_confirm);
                        aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.hPA != null) {
                                    VideoPlayFragment.this.cZk.a(VideoPlayFragment.this.hPA.forum_id, VideoPlayFragment.this.hPA.forum_name, VideoPlayFragment.this.hPA.thread_id, VideoPlayFragment.this.hPA.post_id, 0, 0, VideoPlayFragment.this.eqG);
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
            this.cZc.ef(arrayList);
        }
        this.anH.show();
    }

    private void bMV() {
        if (this.hPA != null) {
            this.hPj.startLoad(this.hPA.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.hPA.title);
            if (StringUtils.isNull(this.hPA.title) || matcher.matches()) {
                this.hPr.setVisibility(8);
            } else {
                this.hPr.setVisibility(0);
                this.hPr.setText(this.hPA.title);
            }
            this.hPt.setText(ao.X(com.baidu.adp.lib.g.b.d(this.hPA.comment_num, 0L)));
            this.hPu.setText(ao.X(com.baidu.adp.lib.g.b.d(this.hPA.agree_num, 0L)));
            this.hPv.setText(ao.X(com.baidu.adp.lib.g.b.d(this.hPA.share_num, 0L)));
            if (this.hPA.author_info != null) {
                if (!StringUtils.isNull(this.hPA.author_info.portrait) && this.hPA.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.hPk.startLoad(this.hPA.author_info.portrait, 10, false);
                } else {
                    this.hPk.startLoad(this.hPA.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.hPA.author_info.bJl())) {
                    this.hPE.setVisibility(8);
                } else {
                    this.hPE.setVisibility(0);
                    this.hPE.setText("@" + this.hPA.author_info.bJl());
                }
            }
            if ("1".equals(this.hPA.is_private) && this.hPB.getVisibility() != 0) {
                this.hPz.setVisibility(0);
            } else {
                this.hPz.setVisibility(8);
            }
            if ("1".equals(this.hPA.is_agreed)) {
                al.c(this.hPD, e.f.icon_card_like_white_full_s);
            } else {
                al.c(this.hPD, e.f.btn_video_agree);
            }
            if (this.hPA.act_info != null && !StringUtils.isNull(this.hPA.act_info.activity_name) && this.hPB.getVisibility() != 0) {
                this.hPy.setVisibility(0);
                this.hPs.setText(this.hPA.act_info.activity_name);
            } else {
                this.hPy.setVisibility(8);
            }
            bMW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMW() {
        if (this.eqG || (this.hPA.author_info != null && !"0".equals(this.hPA.author_info.is_follow))) {
            this.hPo.setVisibility(4);
            this.hPo.setClickable(false);
            return;
        }
        this.hPo.setVisibility(0);
        this.hPo.setClickable(true);
    }

    private void bMX() {
        if (getActivity() != null) {
            if (this.hPQ == null || !this.hPQ.isShowing()) {
                this.hPQ = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(e.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(e.g.tv_title)).setText(e.j.confirm_title);
                ((TextView) inflate.findViewById(e.g.tv_msg)).setText(e.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(e.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(e.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.hPQ.G(inflate);
                this.hPQ.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.hPQ.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.hPQ.dd(1);
                this.hPQ.dc(e.d.cp_cont_b);
                this.hPQ.bg(true);
                this.hPQ.b(getPageContext());
                this.hPQ.BS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bMY() {
        if (!com.baidu.adp.lib.util.j.kV() || com.baidu.adp.lib.util.j.kW()) {
            return true;
        }
        if (!this.hPC || com.baidu.tieba.video.g.bJp().bJq()) {
            return false;
        }
        if (this.hPw != null) {
            this.hPw.setVisibility(0);
        }
        pausePlay();
        bMX();
        return false;
    }

    private void bag() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bMY() || com.baidu.tieba.video.g.bJp().bJq()) && this.hPi != null && this.hPw != null) {
            this.hPi.start();
            this.hPw.setVisibility(8);
            bss();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.hPK == null) {
            this.hPK = AnimationUtils.loadAnimation(getContext(), e.a.scale_zoom_in_and_out_anim);
        }
        return this.hPK;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
    public void TZ() {
        if (this.hPi.isPlaying()) {
            this.hPi.pause();
            this.hPw.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bMY() || com.baidu.tieba.video.g.bJp().bJq()) {
            this.hPi.start();
            this.hPw.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
    public void t(float f, float f2) {
        if (ba.bJ(getActivity()) && !this.hPL) {
            bMZ();
            if (this.hPA != null && "0".equals(this.hPA.is_agreed)) {
                wY(this.hPh);
            }
        }
    }

    private void bMZ() {
        if (this.mRootView != null) {
            this.hPL = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(e.f.icon_video_like);
            if (this.hPN == null) {
                this.hPN = new RelativeLayout.LayoutParams(-2, -2);
                this.hPN.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.hPN);
            }
            if (this.hPM == null) {
                this.hPM = new AnimatorSet();
                this.hPM.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.hPL = false;
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
            this.hPM.setTarget(imageView);
            this.hPM.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.hPM.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
    public void Ua() {
        if (this.hPA != null && this.hPA.author_info != null) {
            long d = com.baidu.adp.lib.g.b.d(this.hPA.author_info.user_id, 0L);
            long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = d == d2;
            if (d == 0 && d2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(d, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.hPi != null) {
            return this.hPi.getMediaIDs();
        }
        return null;
    }

    public String bNa() {
        if (this.hPi != null) {
            return this.hPi.getMediaId();
        }
        return null;
    }

    public boolean bNb() {
        if (this.hPP == null || this.hPP.Mp() == null || !this.hPP.Mp().isVisible()) {
            return false;
        }
        this.hPP.Mp().hide();
        this.hPF.setVisibility(0);
        if ((this.hPP.Mp().fL(28) instanceof c) && ((c) this.hPP.Mp().fL(28)).getInputView() != null && ((c) this.hPP.Mp().fL(28)).getInputView().getText() != null) {
            this.hPG.setText(StringUtils.isNull(((c) this.hPP.Mp().fL(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.hPP != null) {
            this.hPP.onActivityResult(i, i2, intent);
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
        if (this.hPP != null && this.hPP.Mp() != null) {
            this.hPP.Mp().onChangeSkinType(i);
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
