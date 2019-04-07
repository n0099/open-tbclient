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
    private String bNn;
    private e buv;
    private String byD;
    public ImageView cYP;
    private boolean cvj;
    private n dbh;
    private AlphaAnimation ddf;
    private String dkx;
    private View eOK;
    private boolean fCT;
    private j.b hVZ;
    private QuickVideoView.c hWq;
    public ImageView jfA;
    public ImageView jfB;
    public ImageView jfC;
    public TextView jfD;
    public TextView jfE;
    public TextView jfF;
    public TextView jfG;
    public TextView jfH;
    public ImageView jfI;
    private LinearLayout jfJ;
    public LinearLayout jfK;
    public LinearLayout jfL;
    public VideoItemData jfM;
    private TextView jfN;
    private boolean jfO;
    public ImageView jfP;
    public TextView jfQ;
    private View jfR;
    private TextView jfS;
    private int jfT;
    private int jfU;
    private int jfV;
    private com.baidu.tieba.view.a jfW;
    protected Animation jfX;
    private boolean jfY;
    private AnimatorSet jfZ;
    public QuickVideoView jfu;
    private TbImageView jfv;
    public HeadImageView jfw;
    public LinearLayout jfx;
    public LinearLayout jfy;
    public LinearLayout jfz;
    private RelativeLayout.LayoutParams jga;
    private com.baidu.tieba.videoplay.editor.a jgc;
    com.baidu.tbadk.core.dialog.a jgd;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int jfs = 0;
    private int jft = 1;
    private ForumManageModel eiI = null;
    private com.baidu.tbadk.baseEditMark.a hmI = null;
    private com.baidu.tbadk.coreExtra.model.a bKA = null;
    private BdUniqueId Zr = BdUniqueId.gen();
    private boolean jgb = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.jfM != null && VideoPlayFragment.this.jfM.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jfM.author_info.user_id) && data != null && VideoPlayFragment.this.jfM.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.Zr)) ? false : false;
                    if (data.bYB == null) {
                        if (!data.Jy) {
                            if (z && !"0".equals(VideoPlayFragment.this.jfM.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), d.j.attention_fail);
                                VideoPlayFragment.this.jfM.author_info.is_follow = "0";
                                VideoPlayFragment.this.cmy();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.jfO) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), d.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.jfM));
                                    return;
                                }
                                VideoPlayFragment.this.jfM.author_info.is_follow = "1";
                                VideoPlayFragment.this.cmy();
                            }
                        } else {
                            VideoPlayFragment.this.jfM.author_info.is_follow = "0";
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
        this.jfM = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.jfV = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.dkx = arguments.getString("from");
        this.byD = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.jfM != null && this.jfM.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.jfM.author_info.user_id)) {
            this.fCT = true;
        }
        this.dbh = new n(getActivity());
        this.dbh.a(this.jfM);
        this.dbh.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void aW(int i, int i2) {
                if (VideoPlayFragment.this.hVZ != null) {
                    VideoPlayFragment.this.hVZ.aW(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(d.h.video_play_view, (ViewGroup) null);
        this.jfu = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.jfu.setPlayerReuseEnable(true);
        this.jfu.setContinuePlayEnable(true);
        this.jfu.setBusiness(this.dbh);
        this.jfu.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.hWq != null) {
                    VideoPlayFragment.this.hWq.onStart();
                }
            }
        });
        this.jfu.setNeedRecovery(true);
        if (this.jfM != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.ctw = this.jfM.thread_id;
            zVar.ekM = this.jfM.forum_id;
            zVar.hYB = this.jfM.mMd5;
            zVar.byD = "";
            zVar.mSource = this.jfM.mRecomSource;
            zVar.hYA = this.jfM.mRecomAbTag;
            zVar.hYy = this.jfM.mRecomWeight;
            if (this.mRect != null) {
                zVar.hYC = "1";
            } else {
                zVar.hYC = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.hYD = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.hYz = this.dkx;
                zVar.byD = this.byD;
                zVar.hYx = this.jfM.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.dbh.setVideoStatsData(zVar);
        }
        this.jfv = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.jfv.setDefaultBgResource(d.f.icon_play_bg);
        this.jfv.setDefaultErrorResource(d.f.icon_play_bg);
        if (g.abZ()) {
            this.eOK = this.mRootView.findViewById(d.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.eOK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.eOK.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.cYP = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.jfw = (HeadImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.jfw.setDefaultResource(17170445);
        this.jfw.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.jfw.setIsRound(true);
        this.jfA = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.jfP = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.jfD = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.jfE = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.jfy = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.jfF = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.jfx = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.jfG = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.jfH = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.jfB = (ImageView) this.mRootView.findViewById(d.g.share_img);
        this.jfC = (ImageView) this.mRootView.findViewById(d.g.share_img_changed);
        cmt();
        this.jfI = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.jfJ = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.jfK = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.jfL = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.jfz = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.jfQ = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.jfR = this.mRootView.findViewById(d.g.quick_reply_comment_layout);
        this.jfR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.jfR.setVisibility(4);
                    if (VideoPlayFragment.this.jgc != null && VideoPlayFragment.this.jgc.alP() != null) {
                        VideoPlayFragment.this.jgc.alP().qT();
                    }
                    if (VideoPlayFragment.this.jfM != null) {
                        am amVar = new am("c13025");
                        amVar.bJ("tid", VideoPlayFragment.this.jfM.thread_id);
                        amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.bJ(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.jfM.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.jfS = (TextView) this.mRootView.findViewById(d.g.quick_reply_comment_text);
        this.jfN = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.jfN.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jfN.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.jfN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.adA().a((TbPageContext) i.aK(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cmx();
        this.jfw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jfM != null && VideoPlayFragment.this.jfM.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jfM.author_info.user_id) && VideoPlayFragment.this.jfM != null && VideoPlayFragment.this.jfM.author_info != null) {
                    long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.jfM.author_info.user_id, 0L);
                    long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = d == d2;
                    if (d == 0 && d2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(d, z, false)));
                    am amVar = new am("c12798");
                    amVar.bJ("tid", VideoPlayFragment.this.jfM.thread_id);
                    amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.jfK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jfM != null && VideoPlayFragment.this.jfM.act_info != null) {
                    com.baidu.tbadk.browser.a.as(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.jfM.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.bJ("tid", VideoPlayFragment.this.jfM.thread_id);
                    amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.jfD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cmv();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jfM != null && !StringUtils.isNull(VideoPlayFragment.this.jfM.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.jfM.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.cYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cmw();
            }
        });
        this.jfy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cmv();
                am amVar = new am("c12796");
                amVar.bJ("tid", VideoPlayFragment.this.jfM.thread_id);
                amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.jfx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.AG(VideoPlayFragment.this.jfs);
            }
        });
        this.jfz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aeU();
                am amVar = new am("c12797");
                amVar.bJ("tid", VideoPlayFragment.this.jfM.thread_id);
                amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.jfA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cZ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jfM != null && VideoPlayFragment.this.jfM.author_info != null) {
                    VideoPlayFragment.this.bKA.a(true, VideoPlayFragment.this.jfM.author_info.portrait, VideoPlayFragment.this.jfM.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.Zr, VideoPlayFragment.this.jfM.forum_id, "0");
                    VideoPlayFragment.this.jfM.author_info.is_follow = "1";
                    VideoPlayFragment.this.cmy();
                }
            }
        });
        this.ddf = new AlphaAnimation(1.0f, 0.0f);
        this.ddf.setDuration(100L);
        this.ddf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.jfv != null) {
                    VideoPlayFragment.this.jfv.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.jfT = this.mRect.right - this.mRect.left;
            this.jfU = this.mRect.bottom - this.mRect.top;
            this.jfv.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.jfv.getWidth();
                    int height = VideoPlayFragment.this.jfv.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.jfM.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.jfM.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jfM.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jfM.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jfT, VideoPlayFragment.this.jfU);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.jfv.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jfU > 0 || VideoPlayFragment.this.jfT <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.jfT;
                                f = i / VideoPlayFragment.this.jfU;
                            }
                            VideoPlayFragment.this.jfv.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.jfv.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.jfO) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jfT, VideoPlayFragment.this.jfU);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.jfv.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jfU > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.jfv.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.jfv.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.jfO) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.jfv.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.jfv.getWidth();
                    int height = VideoPlayFragment.this.jfv.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.jfM.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.jfM.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jfM.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jfM.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.jfv.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.jfv.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.jfO) {
            cmu();
        }
        if (this.jfM != null && !StringUtils.isNull(this.jfM.video_url)) {
            DX(this.jfM.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.hVZ = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.hWq = cVar;
    }

    private void initEditor() {
        this.jgc = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dd(getActivity());
        if (this.jgc != null && this.jfM != null) {
            this.jgc.a(getPageContext());
            this.jgc.ad(this.jfM.thread_id, this.jfM.forum_id, this.jfM.forum_name);
            this.jgc.a(new a.InterfaceC0406a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0406a
                public void qN(boolean z) {
                    VideoPlayFragment.this.jfR.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.jfS.setText(d.j.reply_something);
                    } else {
                        VideoPlayFragment.this.jfS.setText(StringUtils.isNull(((c) VideoPlayFragment.this.jgc.alP().jv(28)).getInputView().getText().toString()) ? d.j.reply_something : d.j.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.jfM != null && z) {
                        long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.jfM.comment_num, 0L) + 1;
                        VideoPlayFragment.this.jfM.comment_num = String.valueOf(d);
                        VideoPlayFragment.this.jfF.setText(ap.az(d));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.jgc.alP(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeU() {
        if (this.jfM != null) {
            String str = this.jfM.forum_id;
            String str2 = this.jfM.forum_name;
            String str3 = this.jfM.title;
            String str4 = this.jfM.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.jfM.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.cbA = "";
            dVar.linkUrl = str5;
            dVar.bDY = 2;
            dVar.extData = str4;
            dVar.cbD = 3;
            dVar.fid = str;
            dVar.cbu = str2;
            dVar.tid = str4;
            dVar.cbo = true;
            dVar.cbC = 0;
            dVar.cbH = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.jfM.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.jfM.title;
            originalThreadInfo.threadId = this.jfM.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.cbD);
            bundle.putInt("obj_type", dVar.cbH);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.bDY);
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
            this.eiI = new ForumManageModel(getPageContext());
            this.eiI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.eiI.getLoadDataMode()) {
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
        this.hmI = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.hmI != null) {
            this.hmI.a(new a.InterfaceC0221a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0221a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.hmI != null) {
                            VideoPlayFragment.this.hmI.cZ(z2);
                        }
                        if (VideoPlayFragment.this.jfM != null) {
                            if (z2) {
                                VideoPlayFragment.this.jfM.mark_id = VideoPlayFragment.this.jfM.post_id;
                            } else {
                                VideoPlayFragment.this.jfM.mark_id = null;
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
        this.bKA = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.jgb = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cmx();
        if (Build.VERSION.SDK_INT >= 17) {
            this.jfu.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.jfO && i == 3 && VideoPlayFragment.this.jfv.getVisibility() == 0) {
                        VideoPlayFragment.this.jfv.clearAnimation();
                        VideoPlayFragment.this.jfv.startAnimation(VideoPlayFragment.this.ddf);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.jfu.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.jfu != null) {
                    VideoPlayFragment.this.jfu.seekTo(0);
                    VideoPlayFragment.this.jfu.start();
                    VideoPlayFragment.this.aQm();
                    VideoPlayFragment.x(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.cms();
                    }
                }
            }
        });
        this.jfu.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.jfv != null) {
                        VideoPlayFragment.this.jfv.clearAnimation();
                        VideoPlayFragment.this.jfv.startAnimation(VideoPlayFragment.this.ddf);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cms() {
        if (this.jfC != null && this.jfB != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.jfB.clearAnimation();
            this.jfC.clearAnimation();
            this.jfB.setVisibility(8);
            this.jfC.setVisibility(0);
            this.jfC.startAnimation(scaleAnimation2);
            this.jfB.startAnimation(scaleAnimation);
        }
    }

    private void cmt() {
        if (this.jfC != null && this.jfB != null) {
            this.jfB.clearAnimation();
            this.jfC.clearAnimation();
            this.jfB.setVisibility(0);
            this.jfC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AG(int i) {
        int i2;
        if (bc.cZ(getActivity()) && this.jfM != null) {
            if (i == this.jfs) {
                if ("1".equals(this.jfM.is_agreed)) {
                    i2 = 1;
                    this.jfM.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.jfM.agree_num, 0) - 1);
                    this.jfM.is_agreed = "0";
                } else {
                    this.jfM.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.jfM.agree_num, 0) + 1);
                    this.jfM.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.jfM.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.jfM.agree_num, 0) + 1);
                this.jfM.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.bJ("tid", this.jfM.thread_id);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.jfs) {
                amVar.T("obj_type", i2);
            } else {
                amVar.T("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            cmx();
            if (this.jfP != null && i2 == 0) {
                this.jfP.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.jfM.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.jfM));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.jfM != null && !StringUtils.isNull(this.jfM.video_url)) {
            this.cvj = true;
            if (this.jfO) {
                aQm();
                bAH();
                if (this.jfM != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.bJ("tid", this.jfM.thread_id);
                    amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.T("obj_type", 0);
                    TiebaStatic.log(amVar);
                }
            } else {
                pausePlay();
            }
        }
        if (this.jfM != null && !ap.isEmpty(this.jfM.thread_id)) {
            com.baidu.tbadk.BdToken.c.TX().f(com.baidu.tbadk.BdToken.b.bqN, com.baidu.adp.lib.g.b.d(this.jfM.thread_id, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        stopPlay();
        if (this.jgc != null && this.jgc.alP() != null) {
            this.jgc.alP().hide();
            this.jfR.setVisibility(0);
            this.jfS.setText(StringUtils.isNull(((c) this.jgc.alP().jv(28)).getInputView().getText().toString()) ? d.j.reply_something : d.j.draft_to_replay);
            com.baidu.tbadk.BdToken.c.TX().TY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.jgc != null) {
            this.jgc.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.jfO = z;
        if (this.cvj) {
            if (this.jfO && (!this.jgb || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.jfM != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.bJ("tid", this.jfM.thread_id);
                    amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.T("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                cmu();
                this.jgb = false;
                return;
            }
            cmt();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cmu() {
        if (this.jfM != null) {
            am amVar = new am("c12590");
            amVar.bJ("tid", this.jfM.thread_id);
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.jfM.forum_id);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.T("obj_locate", this.jfV);
            amVar.bJ("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.T("obj_param2", 1);
            amVar.bJ("obj_param1", ap.isEmpty(this.jfM.mRecomWeight) ? "0" : this.jfM.mRecomWeight);
            amVar.bJ("extra", ap.isEmpty(this.jfM.mRecomExtra) ? "0" : this.jfM.mRecomExtra);
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.byD);
            amVar.bJ("ab_tag", ap.isEmpty(this.jfM.mRecomAbTag) ? "0" : this.jfM.mRecomAbTag);
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ap.isEmpty(this.jfM.mRecomSource) ? "0" : this.jfM.mRecomSource);
            amVar.bJ("obj_type", this.dkx);
            amVar.T("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void DX(String str) {
        if (this.jfu != null && str != null && !str.equals(this.bNn)) {
            this.jfu.setRecoveryState(0);
            this.jfu.setVideoPath(str, this.jfM.thread_id);
            this.bNn = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.ciN().ciO() || cmA()) {
            bSL();
            if (this.jfI != null) {
                this.jfI.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.jfv.getVisibility() == 0) {
                this.jfv.clearAnimation();
                this.jfv.startAnimation(this.ddf);
            }
            if (this.jfu != null) {
                this.jfu.start();
                aQm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQm() {
        if (this.jfM != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.ctw = this.jfM.thread_id;
            zVar.ekM = this.jfM.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.jfM.mRecomSource;
            zVar.hYx = this.jfM.mRecomAbTag;
            zVar.hYy = this.jfM.mRecomWeight;
            zVar.hYz = "";
            zVar.byD = "";
            zVar.hYB = this.jfM.mMd5;
            if (this.mRect != null) {
                zVar.hYC = "1";
            } else {
                zVar.hYC = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.hYD = "1";
                zVar.mLocate = "auto_midpage";
                zVar.hYz = "index";
            }
            com.baidu.tieba.play.l.a(this.jfM.mMd5, "", "1", zVar);
        }
    }

    private void bSL() {
        if (com.baidu.adp.lib.util.j.la()) {
            com.baidu.tieba.video.g.ciN().ex(getContext());
        }
    }

    private void pausePlay() {
        if (this.jfu != null) {
            this.jfu.pause();
        }
    }

    private void stopPlay() {
        if (this.jfu != null) {
            this.jfu.setRecoveryState(5);
            this.jfu.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmv() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.jfM.thread_id, this.jfM.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.jfM.forum_id));
        createNormalCfg.setForumName(this.jfM.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmw() {
        if (this.buv == null) {
            this.jfW = new com.baidu.tieba.view.a(getActivity());
            this.buv = new e(getActivity(), this.jfW.abh());
            this.buv.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.jfu.setSystemUiVisibility(4);
                }
            });
        }
        if (this.jfW != null) {
            ArrayList arrayList = new ArrayList();
            a.C0407a c0407a = new a.C0407a(this.jfW);
            c0407a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.buv.dismiss();
                    if (VideoPlayFragment.this.jfM != null) {
                        boolean z = VideoPlayFragment.this.jfM.post_id != null && VideoPlayFragment.this.jfM.post_id.equals(VideoPlayFragment.this.jfM.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.jfM.thread_id);
                        markData.setPostId(VideoPlayFragment.this.jfM.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.jfM.thread_id);
                        markData.setForumId(VideoPlayFragment.this.jfM.forum_id);
                        if (VideoPlayFragment.this.hmI != null) {
                            VideoPlayFragment.this.hmI.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.hmI.Va();
                            } else {
                                VideoPlayFragment.this.hmI.UZ();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.jfM != null && this.jfM.post_id != null && this.jfM.post_id.equals(this.jfM.mark_id)) {
                z = true;
            }
            if (z) {
                c0407a.setText(getResources().getString(d.j.remove_mark));
            } else {
                c0407a.setText(getResources().getString(d.j.mark));
            }
            arrayList.add(c0407a);
            a.C0407a c0407a2 = new a.C0407a(getActivity().getString(d.j.delete), this.jfW);
            c0407a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.buv.dismiss();
                    if (bc.cZ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jfM != null) {
                        String str = VideoPlayFragment.this.jfM.thread_id;
                        String str2 = VideoPlayFragment.this.jfM.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(d.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.jfM.post_id, true)));
                    }
                }
            });
            c0407a2.setText(getResources().getString(d.j.report_text));
            arrayList.add(c0407a2);
            if (this.fCT) {
                a.C0407a c0407a3 = new a.C0407a(getActivity().getString(d.j.delete), this.jfW);
                c0407a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.buv.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.gC(d.j.del_thread_confirm);
                        aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.jfM != null) {
                                    VideoPlayFragment.this.eiI.a(VideoPlayFragment.this.jfM.forum_id, VideoPlayFragment.this.jfM.forum_name, VideoPlayFragment.this.jfM.thread_id, VideoPlayFragment.this.jfM.post_id, 0, 0, VideoPlayFragment.this.fCT);
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
            this.jfW.P(arrayList);
        }
        this.buv.show();
    }

    private void cmx() {
        if (this.jfM != null) {
            this.jfv.startLoad(this.jfM.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.jfM.title);
            if (StringUtils.isNull(this.jfM.title) || matcher.matches()) {
                this.jfD.setVisibility(8);
            } else {
                this.jfD.setVisibility(0);
                this.jfD.setText(this.jfM.title);
            }
            this.jfF.setText(ap.az(com.baidu.adp.lib.g.b.d(this.jfM.comment_num, 0L)));
            this.jfG.setText(ap.az(com.baidu.adp.lib.g.b.d(this.jfM.agree_num, 0L)));
            this.jfH.setText(ap.az(com.baidu.adp.lib.g.b.d(this.jfM.share_num, 0L)));
            if (this.jfM.author_info != null) {
                if (!StringUtils.isNull(this.jfM.author_info.portrait) && this.jfM.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.jfw.startLoad(this.jfM.author_info.portrait, 10, false);
                } else {
                    this.jfw.startLoad(this.jfM.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.jfM.author_info.ciJ())) {
                    this.jfQ.setVisibility(8);
                } else {
                    this.jfQ.setVisibility(0);
                    this.jfQ.setText("@" + this.jfM.author_info.ciJ());
                }
            }
            if ("1".equals(this.jfM.is_private) && this.jfN.getVisibility() != 0) {
                this.jfL.setVisibility(0);
            } else {
                this.jfL.setVisibility(8);
            }
            if ("1".equals(this.jfM.is_agreed)) {
                al.c(this.jfP, d.f.icon_card_like_white_full_s);
            } else {
                al.c(this.jfP, d.f.btn_video_agree);
            }
            if (this.jfM.act_info != null && !StringUtils.isNull(this.jfM.act_info.activity_name) && this.jfN.getVisibility() != 0) {
                this.jfK.setVisibility(0);
                this.jfE.setText(this.jfM.act_info.activity_name);
            } else {
                this.jfK.setVisibility(8);
            }
            cmy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmy() {
        if (this.fCT || (this.jfM.author_info != null && !"0".equals(this.jfM.author_info.is_follow))) {
            this.jfA.setVisibility(4);
            this.jfA.setClickable(false);
            return;
        }
        this.jfA.setVisibility(0);
        this.jfA.setClickable(true);
    }

    private void cmz() {
        if (getActivity() != null) {
            if (this.jgd == null || !this.jgd.isShowing()) {
                this.jgd = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(d.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.j.confirm_title);
                ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.jgd.az(inflate);
                this.jgd.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.jgd.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.jgd.gE(1);
                this.jgd.gD(d.C0277d.cp_cont_b);
                this.jgd.dq(true);
                this.jgd.b(getPageContext());
                this.jgd.aaW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cmA() {
        if (!com.baidu.adp.lib.util.j.kY() || com.baidu.adp.lib.util.j.kZ()) {
            return true;
        }
        if (!this.jfO || com.baidu.tieba.video.g.ciN().ciO()) {
            return false;
        }
        if (this.jfI != null) {
            this.jfI.setVisibility(0);
        }
        pausePlay();
        cmz();
        return false;
    }

    private void bAH() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cmA() || com.baidu.tieba.video.g.ciN().ciO()) && this.jfu != null && this.jfI != null) {
            this.jfu.start();
            this.jfI.setVisibility(8);
            bSL();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.jfX == null) {
            this.jfX = AnimationUtils.loadAnimation(getContext(), d.a.scale_zoom_in_and_out_anim);
        }
        return this.jfX;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
    public void atV() {
        if (this.jfu.isPlaying()) {
            this.jfu.pause();
            this.jfI.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cmA() || com.baidu.tieba.video.g.ciN().ciO()) {
            this.jfu.start();
            this.jfI.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
    public void w(float f, float f2) {
        if (bc.cZ(getActivity()) && !this.jfY) {
            cmB();
            if (this.jfM != null && "0".equals(this.jfM.is_agreed)) {
                AG(this.jft);
            }
        }
    }

    private void cmB() {
        if (this.mRootView != null) {
            this.jfY = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(d.f.icon_video_like);
            if (this.jga == null) {
                this.jga = new RelativeLayout.LayoutParams(-2, -2);
                this.jga.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.jga);
            }
            if (this.jfZ == null) {
                this.jfZ = new AnimatorSet();
                this.jfZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.jfY = false;
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
            this.jfZ.setTarget(imageView);
            this.jfZ.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.jfZ.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
    public void atW() {
        if (this.jfM != null && this.jfM.author_info != null) {
            long d = com.baidu.adp.lib.g.b.d(this.jfM.author_info.user_id, 0L);
            long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = d == d2;
            if (d == 0 && d2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(d, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.jfu != null) {
            return this.jfu.getMediaIDs();
        }
        return null;
    }

    public String cmC() {
        if (this.jfu != null) {
            return this.jfu.getMediaId();
        }
        return null;
    }

    public boolean cmD() {
        if (this.jgc == null || this.jgc.alP() == null || !this.jgc.alP().isVisible()) {
            return false;
        }
        this.jgc.alP().hide();
        this.jfR.setVisibility(0);
        if ((this.jgc.alP().jv(28) instanceof c) && ((c) this.jgc.alP().jv(28)).getInputView() != null && ((c) this.jgc.alP().jv(28)).getInputView().getText() != null) {
            this.jfS.setText(StringUtils.isNull(((c) this.jgc.alP().jv(28)).getInputView().getText().toString()) ? d.j.reply_something : d.j.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.jgc != null) {
            this.jgc.onActivityResult(i, i2, intent);
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
        if (this.jgc != null && this.jgc.alP() != null) {
            this.jgc.alP().onChangeSkinType(i);
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
