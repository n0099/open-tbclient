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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0248a {
    private String bNo;
    private e buw;
    private String byE;
    public ImageView cYQ;
    private boolean cvk;
    private n dbi;
    private AlphaAnimation ddg;
    private String dky;
    private View eOL;
    private boolean fCT;
    private j.b hWa;
    private QuickVideoView.c hWr;
    public LinearLayout jfA;
    public ImageView jfB;
    public ImageView jfC;
    public ImageView jfD;
    public TextView jfE;
    public TextView jfF;
    public TextView jfG;
    public TextView jfH;
    public TextView jfI;
    public ImageView jfJ;
    private LinearLayout jfK;
    public LinearLayout jfL;
    public LinearLayout jfM;
    public VideoItemData jfN;
    private TextView jfO;
    private boolean jfP;
    public ImageView jfQ;
    public TextView jfR;
    private View jfS;
    private TextView jfT;
    private int jfU;
    private int jfV;
    private int jfW;
    private com.baidu.tieba.view.a jfX;
    protected Animation jfY;
    private boolean jfZ;
    public QuickVideoView jfv;
    private TbImageView jfw;
    public HeadImageView jfx;
    public LinearLayout jfy;
    public LinearLayout jfz;
    private AnimatorSet jga;
    private RelativeLayout.LayoutParams jgb;
    private com.baidu.tieba.videoplay.editor.a jgd;
    com.baidu.tbadk.core.dialog.a jge;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int jft = 0;
    private int jfu = 1;
    private ForumManageModel eiJ = null;
    private com.baidu.tbadk.baseEditMark.a hmJ = null;
    private com.baidu.tbadk.coreExtra.model.a bKB = null;
    private BdUniqueId Zs = BdUniqueId.gen();
    private boolean jgc = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.jfN != null && VideoPlayFragment.this.jfN.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jfN.author_info.user_id) && data != null && VideoPlayFragment.this.jfN.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.Zs)) ? false : false;
                    if (data.bYC == null) {
                        if (!data.Jy) {
                            if (z && !"0".equals(VideoPlayFragment.this.jfN.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), d.j.attention_fail);
                                VideoPlayFragment.this.jfN.author_info.is_follow = "0";
                                VideoPlayFragment.this.cmy();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.jfP) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), d.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.jfN));
                                    return;
                                }
                                VideoPlayFragment.this.jfN.author_info.is_follow = "1";
                                VideoPlayFragment.this.cmy();
                            }
                        } else {
                            VideoPlayFragment.this.jfN.author_info.is_follow = "0";
                            VideoPlayFragment.this.cmy();
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
                VideoPlayFragment.this.cmA();
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
        this.jfN = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.jfW = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.dky = arguments.getString("from");
        this.byE = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.jfN != null && this.jfN.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.jfN.author_info.user_id)) {
            this.fCT = true;
        }
        this.dbi = new n(getActivity());
        this.dbi.a(this.jfN);
        this.dbi.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void aW(int i, int i2) {
                if (VideoPlayFragment.this.hWa != null) {
                    VideoPlayFragment.this.hWa.aW(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(d.h.video_play_view, (ViewGroup) null);
        this.jfv = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.jfv.setPlayerReuseEnable(true);
        this.jfv.setContinuePlayEnable(true);
        this.jfv.setBusiness(this.dbi);
        this.jfv.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.hWr != null) {
                    VideoPlayFragment.this.hWr.onStart();
                }
            }
        });
        this.jfv.setNeedRecovery(true);
        if (this.jfN != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.ctx = this.jfN.thread_id;
            zVar.ekN = this.jfN.forum_id;
            zVar.hYC = this.jfN.mMd5;
            zVar.byE = "";
            zVar.mSource = this.jfN.mRecomSource;
            zVar.hYB = this.jfN.mRecomAbTag;
            zVar.hYz = this.jfN.mRecomWeight;
            if (this.mRect != null) {
                zVar.hYD = "1";
            } else {
                zVar.hYD = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.hYE = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.hYA = this.dky;
                zVar.byE = this.byE;
                zVar.hYy = this.jfN.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.dbi.setVideoStatsData(zVar);
        }
        this.jfw = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.jfw.setDefaultBgResource(d.f.icon_play_bg);
        this.jfw.setDefaultErrorResource(d.f.icon_play_bg);
        if (g.abZ()) {
            this.eOL = this.mRootView.findViewById(d.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.eOL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.eOL.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.cYQ = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.jfx = (HeadImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.jfx.setDefaultResource(17170445);
        this.jfx.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.jfx.setIsRound(true);
        this.jfB = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.jfQ = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.jfE = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.jfF = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.jfz = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.jfG = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.jfy = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.jfH = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.jfI = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.jfC = (ImageView) this.mRootView.findViewById(d.g.share_img);
        this.jfD = (ImageView) this.mRootView.findViewById(d.g.share_img_changed);
        cmt();
        this.jfJ = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.jfK = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.jfL = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.jfM = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.jfA = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.jfR = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.jfS = this.mRootView.findViewById(d.g.quick_reply_comment_layout);
        this.jfS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.jfS.setVisibility(4);
                    if (VideoPlayFragment.this.jgd != null && VideoPlayFragment.this.jgd.alP() != null) {
                        VideoPlayFragment.this.jgd.alP().qT();
                    }
                    if (VideoPlayFragment.this.jfN != null) {
                        am amVar = new am("c13025");
                        amVar.bJ("tid", VideoPlayFragment.this.jfN.thread_id);
                        amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.bJ(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.jfN.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.jfT = (TextView) this.mRootView.findViewById(d.g.quick_reply_comment_text);
        this.jfO = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.jfO.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jfO.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.jfO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.adA().a((TbPageContext) i.aK(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cmx();
        this.jfx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jfN != null && VideoPlayFragment.this.jfN.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jfN.author_info.user_id) && VideoPlayFragment.this.jfN != null && VideoPlayFragment.this.jfN.author_info != null) {
                    long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.jfN.author_info.user_id, 0L);
                    long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = d == d2;
                    if (d == 0 && d2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(d, z, false)));
                    am amVar = new am("c12798");
                    amVar.bJ("tid", VideoPlayFragment.this.jfN.thread_id);
                    amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.jfL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jfN != null && VideoPlayFragment.this.jfN.act_info != null) {
                    com.baidu.tbadk.browser.a.as(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.jfN.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.bJ("tid", VideoPlayFragment.this.jfN.thread_id);
                    amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.jfE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cmv();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jfN != null && !StringUtils.isNull(VideoPlayFragment.this.jfN.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.jfN.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.cYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cmw();
            }
        });
        this.jfz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cmv();
                am amVar = new am("c12796");
                amVar.bJ("tid", VideoPlayFragment.this.jfN.thread_id);
                amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.jfy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.AG(VideoPlayFragment.this.jft);
            }
        });
        this.jfA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aeU();
                am amVar = new am("c12797");
                amVar.bJ("tid", VideoPlayFragment.this.jfN.thread_id);
                amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.jfB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cZ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jfN != null && VideoPlayFragment.this.jfN.author_info != null) {
                    VideoPlayFragment.this.bKB.a(true, VideoPlayFragment.this.jfN.author_info.portrait, VideoPlayFragment.this.jfN.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.Zs, VideoPlayFragment.this.jfN.forum_id, "0");
                    VideoPlayFragment.this.jfN.author_info.is_follow = "1";
                    VideoPlayFragment.this.cmy();
                }
            }
        });
        this.ddg = new AlphaAnimation(1.0f, 0.0f);
        this.ddg.setDuration(100L);
        this.ddg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.jfw != null) {
                    VideoPlayFragment.this.jfw.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.jfU = this.mRect.right - this.mRect.left;
            this.jfV = this.mRect.bottom - this.mRect.top;
            this.jfw.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.jfw.getWidth();
                    int height = VideoPlayFragment.this.jfw.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.jfN.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.jfN.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jfN.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jfN.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jfU, VideoPlayFragment.this.jfV);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.jfw.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jfV > 0 || VideoPlayFragment.this.jfU <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.jfU;
                                f = i / VideoPlayFragment.this.jfV;
                            }
                            VideoPlayFragment.this.jfw.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.jfw.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.jfP) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jfU, VideoPlayFragment.this.jfV);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.jfw.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jfV > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.jfw.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.jfw.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.jfP) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.jfw.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.jfw.getWidth();
                    int height = VideoPlayFragment.this.jfw.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.jfN.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.jfN.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jfN.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jfN.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.jfw.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.jfw.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.jfP) {
            cmu();
        }
        if (this.jfN != null && !StringUtils.isNull(this.jfN.video_url)) {
            DX(this.jfN.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.hWa = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.hWr = cVar;
    }

    private void initEditor() {
        this.jgd = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dd(getActivity());
        if (this.jgd != null && this.jfN != null) {
            this.jgd.a(getPageContext());
            this.jgd.ad(this.jfN.thread_id, this.jfN.forum_id, this.jfN.forum_name);
            this.jgd.a(new a.InterfaceC0406a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0406a
                public void qN(boolean z) {
                    VideoPlayFragment.this.jfS.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.jfT.setText(d.j.reply_something);
                    } else {
                        VideoPlayFragment.this.jfT.setText(StringUtils.isNull(((c) VideoPlayFragment.this.jgd.alP().jv(28)).getInputView().getText().toString()) ? d.j.reply_something : d.j.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.jfN != null && z) {
                        long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.jfN.comment_num, 0L) + 1;
                        VideoPlayFragment.this.jfN.comment_num = String.valueOf(d);
                        VideoPlayFragment.this.jfG.setText(ap.az(d));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.jgd.alP(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeU() {
        if (this.jfN != null) {
            String str = this.jfN.forum_id;
            String str2 = this.jfN.forum_name;
            String str3 = this.jfN.title;
            String str4 = this.jfN.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.jfN.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.cbB = "";
            dVar.linkUrl = str5;
            dVar.bDZ = 2;
            dVar.extData = str4;
            dVar.cbE = 3;
            dVar.fid = str;
            dVar.cbv = str2;
            dVar.tid = str4;
            dVar.cbp = true;
            dVar.cbD = 0;
            dVar.cbI = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.jfN.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.jfN.title;
            originalThreadInfo.threadId = this.jfN.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.cbE);
            bundle.putInt("obj_type", dVar.cbI);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.bDZ);
            dVar.D(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.aSr().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fCT) {
            this.eiJ = new ForumManageModel(getPageContext());
            this.eiJ.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.eiJ.getLoadDataMode()) {
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
        this.hmJ = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.hmJ != null) {
            this.hmJ.a(new a.InterfaceC0221a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0221a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.hmJ != null) {
                            VideoPlayFragment.this.hmJ.cZ(z2);
                        }
                        if (VideoPlayFragment.this.jfN != null) {
                            if (z2) {
                                VideoPlayFragment.this.jfN.mark_id = VideoPlayFragment.this.jfN.post_id;
                            } else {
                                VideoPlayFragment.this.jfN.mark_id = null;
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
        this.bKB = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.jgc = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cmx();
        if (Build.VERSION.SDK_INT >= 17) {
            this.jfv.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.jfP && i == 3 && VideoPlayFragment.this.jfw.getVisibility() == 0) {
                        VideoPlayFragment.this.jfw.clearAnimation();
                        VideoPlayFragment.this.jfw.startAnimation(VideoPlayFragment.this.ddg);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.jfv.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.jfv != null) {
                    VideoPlayFragment.this.jfv.seekTo(0);
                    VideoPlayFragment.this.jfv.start();
                    VideoPlayFragment.this.aQm();
                    VideoPlayFragment.x(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.cms();
                    }
                }
            }
        });
        this.jfv.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.jfw != null) {
                        VideoPlayFragment.this.jfw.clearAnimation();
                        VideoPlayFragment.this.jfw.startAnimation(VideoPlayFragment.this.ddg);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cms() {
        if (this.jfD != null && this.jfC != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.jfC.clearAnimation();
            this.jfD.clearAnimation();
            this.jfC.setVisibility(8);
            this.jfD.setVisibility(0);
            this.jfD.startAnimation(scaleAnimation2);
            this.jfC.startAnimation(scaleAnimation);
        }
    }

    private void cmt() {
        if (this.jfD != null && this.jfC != null) {
            this.jfC.clearAnimation();
            this.jfD.clearAnimation();
            this.jfC.setVisibility(0);
            this.jfD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AG(int i) {
        int i2;
        if (bc.cZ(getActivity()) && this.jfN != null) {
            if (i == this.jft) {
                if ("1".equals(this.jfN.is_agreed)) {
                    i2 = 1;
                    this.jfN.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.jfN.agree_num, 0) - 1);
                    this.jfN.is_agreed = "0";
                } else {
                    this.jfN.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.jfN.agree_num, 0) + 1);
                    this.jfN.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.jfN.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.jfN.agree_num, 0) + 1);
                this.jfN.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.bJ("tid", this.jfN.thread_id);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.jft) {
                amVar.T("obj_type", i2);
            } else {
                amVar.T("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            cmx();
            if (this.jfQ != null && i2 == 0) {
                this.jfQ.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.jfN.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.jfN));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.jfN != null && !StringUtils.isNull(this.jfN.video_url)) {
            this.cvk = true;
            if (this.jfP) {
                aQm();
                bAH();
                if (this.jfN != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.bJ("tid", this.jfN.thread_id);
                    amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.T("obj_type", 0);
                    TiebaStatic.log(amVar);
                }
            } else {
                pausePlay();
            }
        }
        if (this.jfN != null && !ap.isEmpty(this.jfN.thread_id)) {
            com.baidu.tbadk.BdToken.c.TX().f(com.baidu.tbadk.BdToken.b.bqO, com.baidu.adp.lib.g.b.d(this.jfN.thread_id, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        stopPlay();
        if (this.jgd != null && this.jgd.alP() != null) {
            this.jgd.alP().hide();
            this.jfS.setVisibility(0);
            this.jfT.setText(StringUtils.isNull(((c) this.jgd.alP().jv(28)).getInputView().getText().toString()) ? d.j.reply_something : d.j.draft_to_replay);
            com.baidu.tbadk.BdToken.c.TX().TY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.jgd != null) {
            this.jgd.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.jfP = z;
        if (this.cvk) {
            if (this.jfP && (!this.jgc || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.jfN != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.bJ("tid", this.jfN.thread_id);
                    amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.T("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                cmu();
                this.jgc = false;
                return;
            }
            cmt();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cmu() {
        if (this.jfN != null) {
            am amVar = new am("c12590");
            amVar.bJ("tid", this.jfN.thread_id);
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.jfN.forum_id);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.T("obj_locate", this.jfW);
            amVar.bJ("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.T("obj_param2", 1);
            amVar.bJ("obj_param1", ap.isEmpty(this.jfN.mRecomWeight) ? "0" : this.jfN.mRecomWeight);
            amVar.bJ("extra", ap.isEmpty(this.jfN.mRecomExtra) ? "0" : this.jfN.mRecomExtra);
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.byE);
            amVar.bJ("ab_tag", ap.isEmpty(this.jfN.mRecomAbTag) ? "0" : this.jfN.mRecomAbTag);
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ap.isEmpty(this.jfN.mRecomSource) ? "0" : this.jfN.mRecomSource);
            amVar.bJ("obj_type", this.dky);
            amVar.T("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void DX(String str) {
        if (this.jfv != null && str != null && !str.equals(this.bNo)) {
            this.jfv.setRecoveryState(0);
            this.jfv.setVideoPath(str, this.jfN.thread_id);
            this.bNo = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.ciN().ciO() || cmA()) {
            bSL();
            if (this.jfJ != null) {
                this.jfJ.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.jfw.getVisibility() == 0) {
                this.jfw.clearAnimation();
                this.jfw.startAnimation(this.ddg);
            }
            if (this.jfv != null) {
                this.jfv.start();
                aQm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQm() {
        if (this.jfN != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.ctx = this.jfN.thread_id;
            zVar.ekN = this.jfN.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.jfN.mRecomSource;
            zVar.hYy = this.jfN.mRecomAbTag;
            zVar.hYz = this.jfN.mRecomWeight;
            zVar.hYA = "";
            zVar.byE = "";
            zVar.hYC = this.jfN.mMd5;
            if (this.mRect != null) {
                zVar.hYD = "1";
            } else {
                zVar.hYD = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.hYE = "1";
                zVar.mLocate = "auto_midpage";
                zVar.hYA = "index";
            }
            com.baidu.tieba.play.l.a(this.jfN.mMd5, "", "1", zVar);
        }
    }

    private void bSL() {
        if (com.baidu.adp.lib.util.j.la()) {
            com.baidu.tieba.video.g.ciN().ex(getContext());
        }
    }

    private void pausePlay() {
        if (this.jfv != null) {
            this.jfv.pause();
        }
    }

    private void stopPlay() {
        if (this.jfv != null) {
            this.jfv.setRecoveryState(5);
            this.jfv.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmv() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.jfN.thread_id, this.jfN.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.jfN.forum_id));
        createNormalCfg.setForumName(this.jfN.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmw() {
        if (this.buw == null) {
            this.jfX = new com.baidu.tieba.view.a(getActivity());
            this.buw = new e(getActivity(), this.jfX.abh());
            this.buw.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.jfv.setSystemUiVisibility(4);
                }
            });
        }
        if (this.jfX != null) {
            ArrayList arrayList = new ArrayList();
            a.C0407a c0407a = new a.C0407a(this.jfX);
            c0407a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.buw.dismiss();
                    if (VideoPlayFragment.this.jfN != null) {
                        boolean z = VideoPlayFragment.this.jfN.post_id != null && VideoPlayFragment.this.jfN.post_id.equals(VideoPlayFragment.this.jfN.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.jfN.thread_id);
                        markData.setPostId(VideoPlayFragment.this.jfN.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.jfN.thread_id);
                        markData.setForumId(VideoPlayFragment.this.jfN.forum_id);
                        if (VideoPlayFragment.this.hmJ != null) {
                            VideoPlayFragment.this.hmJ.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.hmJ.Va();
                            } else {
                                VideoPlayFragment.this.hmJ.UZ();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.jfN != null && this.jfN.post_id != null && this.jfN.post_id.equals(this.jfN.mark_id)) {
                z = true;
            }
            if (z) {
                c0407a.setText(getResources().getString(d.j.remove_mark));
            } else {
                c0407a.setText(getResources().getString(d.j.mark));
            }
            arrayList.add(c0407a);
            a.C0407a c0407a2 = new a.C0407a(getActivity().getString(d.j.delete), this.jfX);
            c0407a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.buw.dismiss();
                    if (bc.cZ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jfN != null) {
                        String str = VideoPlayFragment.this.jfN.thread_id;
                        String str2 = VideoPlayFragment.this.jfN.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(d.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.jfN.post_id, true)));
                    }
                }
            });
            c0407a2.setText(getResources().getString(d.j.report_text));
            arrayList.add(c0407a2);
            if (this.fCT) {
                a.C0407a c0407a3 = new a.C0407a(getActivity().getString(d.j.delete), this.jfX);
                c0407a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.buw.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.gC(d.j.del_thread_confirm);
                        aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.jfN != null) {
                                    VideoPlayFragment.this.eiJ.a(VideoPlayFragment.this.jfN.forum_id, VideoPlayFragment.this.jfN.forum_name, VideoPlayFragment.this.jfN.thread_id, VideoPlayFragment.this.jfN.post_id, 0, 0, VideoPlayFragment.this.fCT);
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
                        aVar.dq(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.aaW();
                    }
                });
                c0407a3.setText(getResources().getString(d.j.delete));
                arrayList.add(c0407a3);
            }
            this.jfX.P(arrayList);
        }
        this.buw.show();
    }

    private void cmx() {
        if (this.jfN != null) {
            this.jfw.startLoad(this.jfN.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.jfN.title);
            if (StringUtils.isNull(this.jfN.title) || matcher.matches()) {
                this.jfE.setVisibility(8);
            } else {
                this.jfE.setVisibility(0);
                this.jfE.setText(this.jfN.title);
            }
            this.jfG.setText(ap.az(com.baidu.adp.lib.g.b.d(this.jfN.comment_num, 0L)));
            this.jfH.setText(ap.az(com.baidu.adp.lib.g.b.d(this.jfN.agree_num, 0L)));
            this.jfI.setText(ap.az(com.baidu.adp.lib.g.b.d(this.jfN.share_num, 0L)));
            if (this.jfN.author_info != null) {
                if (!StringUtils.isNull(this.jfN.author_info.portrait) && this.jfN.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.jfx.startLoad(this.jfN.author_info.portrait, 10, false);
                } else {
                    this.jfx.startLoad(this.jfN.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.jfN.author_info.ciJ())) {
                    this.jfR.setVisibility(8);
                } else {
                    this.jfR.setVisibility(0);
                    this.jfR.setText("@" + this.jfN.author_info.ciJ());
                }
            }
            if ("1".equals(this.jfN.is_private) && this.jfO.getVisibility() != 0) {
                this.jfM.setVisibility(0);
            } else {
                this.jfM.setVisibility(8);
            }
            if ("1".equals(this.jfN.is_agreed)) {
                al.c(this.jfQ, d.f.icon_card_like_white_full_s);
            } else {
                al.c(this.jfQ, d.f.btn_video_agree);
            }
            if (this.jfN.act_info != null && !StringUtils.isNull(this.jfN.act_info.activity_name) && this.jfO.getVisibility() != 0) {
                this.jfL.setVisibility(0);
                this.jfF.setText(this.jfN.act_info.activity_name);
            } else {
                this.jfL.setVisibility(8);
            }
            cmy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmy() {
        if (this.fCT || (this.jfN.author_info != null && !"0".equals(this.jfN.author_info.is_follow))) {
            this.jfB.setVisibility(4);
            this.jfB.setClickable(false);
            return;
        }
        this.jfB.setVisibility(0);
        this.jfB.setClickable(true);
    }

    private void cmz() {
        if (getActivity() != null) {
            if (this.jge == null || !this.jge.isShowing()) {
                this.jge = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(d.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.j.confirm_title);
                ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.jge.az(inflate);
                this.jge.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.jge.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.jge.gE(1);
                this.jge.gD(d.C0277d.cp_cont_b);
                this.jge.dq(true);
                this.jge.b(getPageContext());
                this.jge.aaW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cmA() {
        if (!com.baidu.adp.lib.util.j.kY() || com.baidu.adp.lib.util.j.kZ()) {
            return true;
        }
        if (!this.jfP || com.baidu.tieba.video.g.ciN().ciO()) {
            return false;
        }
        if (this.jfJ != null) {
            this.jfJ.setVisibility(0);
        }
        pausePlay();
        cmz();
        return false;
    }

    private void bAH() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cmA() || com.baidu.tieba.video.g.ciN().ciO()) && this.jfv != null && this.jfJ != null) {
            this.jfv.start();
            this.jfJ.setVisibility(8);
            bSL();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.jfY == null) {
            this.jfY = AnimationUtils.loadAnimation(getContext(), d.a.scale_zoom_in_and_out_anim);
        }
        return this.jfY;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
    public void atV() {
        if (this.jfv.isPlaying()) {
            this.jfv.pause();
            this.jfJ.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cmA() || com.baidu.tieba.video.g.ciN().ciO()) {
            this.jfv.start();
            this.jfJ.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
    public void w(float f, float f2) {
        if (bc.cZ(getActivity()) && !this.jfZ) {
            cmB();
            if (this.jfN != null && "0".equals(this.jfN.is_agreed)) {
                AG(this.jfu);
            }
        }
    }

    private void cmB() {
        if (this.mRootView != null) {
            this.jfZ = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(d.f.icon_video_like);
            if (this.jgb == null) {
                this.jgb = new RelativeLayout.LayoutParams(-2, -2);
                this.jgb.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.jgb);
            }
            if (this.jga == null) {
                this.jga = new AnimatorSet();
                this.jga.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.jfZ = false;
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
            this.jga.setTarget(imageView);
            this.jga.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.jga.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
    public void atW() {
        if (this.jfN != null && this.jfN.author_info != null) {
            long d = com.baidu.adp.lib.g.b.d(this.jfN.author_info.user_id, 0L);
            long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = d == d2;
            if (d == 0 && d2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(d, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.jfv != null) {
            return this.jfv.getMediaIDs();
        }
        return null;
    }

    public String cmC() {
        if (this.jfv != null) {
            return this.jfv.getMediaId();
        }
        return null;
    }

    public boolean cmD() {
        if (this.jgd == null || this.jgd.alP() == null || !this.jgd.alP().isVisible()) {
            return false;
        }
        this.jgd.alP().hide();
        this.jfS.setVisibility(0);
        if ((this.jgd.alP().jv(28) instanceof c) && ((c) this.jgd.alP().jv(28)).getInputView() != null && ((c) this.jgd.alP().jv(28)).getInputView().getText() != null) {
            this.jfT.setText(StringUtils.isNull(((c) this.jgd.alP().jv(28)).getInputView().getText().toString()) ? d.j.reply_something : d.j.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.jgd != null) {
            this.jgd.onActivityResult(i, i2, intent);
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
        if (this.jgd != null && this.jgd.alP() != null) {
            this.jgd.alP().onChangeSkinType(i);
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
