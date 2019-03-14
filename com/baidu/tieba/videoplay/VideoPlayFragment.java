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
    private String bNl;
    private e bus;
    private String byA;
    public ImageView cYM;
    private boolean cvh;
    private n dbe;
    private AlphaAnimation ddb;
    private String dku;
    private View eOY;
    private boolean fDf;
    private QuickVideoView.c hWE;
    private j.b hWn;
    public QuickVideoView jfG;
    private TbImageView jfH;
    public HeadImageView jfI;
    public LinearLayout jfJ;
    public LinearLayout jfK;
    public LinearLayout jfL;
    public ImageView jfM;
    public ImageView jfN;
    public ImageView jfO;
    public TextView jfP;
    public TextView jfQ;
    public TextView jfR;
    public TextView jfS;
    public TextView jfT;
    public ImageView jfU;
    private LinearLayout jfV;
    public LinearLayout jfW;
    public LinearLayout jfX;
    public VideoItemData jfY;
    private TextView jfZ;
    private boolean jga;
    public ImageView jgb;
    public TextView jgc;
    private View jgd;
    private TextView jge;
    private int jgf;
    private int jgg;
    private int jgh;
    private com.baidu.tieba.view.a jgi;
    protected Animation jgj;
    private boolean jgk;
    private AnimatorSet jgl;
    private RelativeLayout.LayoutParams jgm;
    private com.baidu.tieba.videoplay.editor.a jgo;
    com.baidu.tbadk.core.dialog.a jgp;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int jfE = 0;
    private int jfF = 1;
    private ForumManageModel eiW = null;
    private com.baidu.tbadk.baseEditMark.a hmV = null;
    private com.baidu.tbadk.coreExtra.model.a bKy = null;
    private BdUniqueId Zr = BdUniqueId.gen();
    private boolean jgn = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.jfY != null && VideoPlayFragment.this.jfY.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jfY.author_info.user_id) && data != null && VideoPlayFragment.this.jfY.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.Zr)) ? false : false;
                    if (data.bYz == null) {
                        if (!data.Jy) {
                            if (z && !"0".equals(VideoPlayFragment.this.jfY.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), d.j.attention_fail);
                                VideoPlayFragment.this.jfY.author_info.is_follow = "0";
                                VideoPlayFragment.this.cmA();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.jga) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), d.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.jfY));
                                    return;
                                }
                                VideoPlayFragment.this.jfY.author_info.is_follow = "1";
                                VideoPlayFragment.this.cmA();
                            }
                        } else {
                            VideoPlayFragment.this.jfY.author_info.is_follow = "0";
                            VideoPlayFragment.this.cmA();
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
                VideoPlayFragment.this.cmC();
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
        this.jfY = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.jgh = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.dku = arguments.getString("from");
        this.byA = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.jfY != null && this.jfY.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.jfY.author_info.user_id)) {
            this.fDf = true;
        }
        this.dbe = new n(getActivity());
        this.dbe.a(this.jfY);
        this.dbe.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void aW(int i, int i2) {
                if (VideoPlayFragment.this.hWn != null) {
                    VideoPlayFragment.this.hWn.aW(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(d.h.video_play_view, (ViewGroup) null);
        this.jfG = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.jfG.setPlayerReuseEnable(true);
        this.jfG.setContinuePlayEnable(true);
        this.jfG.setBusiness(this.dbe);
        this.jfG.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.hWE != null) {
                    VideoPlayFragment.this.hWE.onStart();
                }
            }
        });
        this.jfG.setNeedRecovery(true);
        if (this.jfY != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.ctu = this.jfY.thread_id;
            zVar.ela = this.jfY.forum_id;
            zVar.hYP = this.jfY.mMd5;
            zVar.byA = "";
            zVar.mSource = this.jfY.mRecomSource;
            zVar.hYO = this.jfY.mRecomAbTag;
            zVar.hYM = this.jfY.mRecomWeight;
            if (this.mRect != null) {
                zVar.hYQ = "1";
            } else {
                zVar.hYQ = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.hYR = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.hYN = this.dku;
                zVar.byA = this.byA;
                zVar.hYL = this.jfY.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.dbe.setVideoStatsData(zVar);
        }
        this.jfH = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.jfH.setDefaultBgResource(d.f.icon_play_bg);
        this.jfH.setDefaultErrorResource(d.f.icon_play_bg);
        if (g.acc()) {
            this.eOY = this.mRootView.findViewById(d.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.eOY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.eOY.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.cYM = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.jfI = (HeadImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.jfI.setDefaultResource(17170445);
        this.jfI.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.jfI.setIsRound(true);
        this.jfM = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.jgb = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.jfP = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.jfQ = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.jfK = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.jfR = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.jfJ = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.jfS = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.jfT = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.jfN = (ImageView) this.mRootView.findViewById(d.g.share_img);
        this.jfO = (ImageView) this.mRootView.findViewById(d.g.share_img_changed);
        cmv();
        this.jfU = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.jfV = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.jfW = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.jfX = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.jfL = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.jgc = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.jgd = this.mRootView.findViewById(d.g.quick_reply_comment_layout);
        this.jgd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.jgd.setVisibility(4);
                    if (VideoPlayFragment.this.jgo != null && VideoPlayFragment.this.jgo.alS() != null) {
                        VideoPlayFragment.this.jgo.alS().qT();
                    }
                    if (VideoPlayFragment.this.jfY != null) {
                        am amVar = new am("c13025");
                        amVar.bJ("tid", VideoPlayFragment.this.jfY.thread_id);
                        amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.bJ(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.jfY.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.jge = (TextView) this.mRootView.findViewById(d.g.quick_reply_comment_text);
        this.jfZ = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.jfZ.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jfZ.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.jfZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.adD().a((TbPageContext) i.aK(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cmz();
        this.jfI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jfY != null && VideoPlayFragment.this.jfY.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jfY.author_info.user_id) && VideoPlayFragment.this.jfY != null && VideoPlayFragment.this.jfY.author_info != null) {
                    long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.jfY.author_info.user_id, 0L);
                    long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = d == d2;
                    if (d == 0 && d2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(d, z, false)));
                    am amVar = new am("c12798");
                    amVar.bJ("tid", VideoPlayFragment.this.jfY.thread_id);
                    amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.jfW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jfY != null && VideoPlayFragment.this.jfY.act_info != null) {
                    com.baidu.tbadk.browser.a.as(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.jfY.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.bJ("tid", VideoPlayFragment.this.jfY.thread_id);
                    amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.jfP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cmx();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jfY != null && !StringUtils.isNull(VideoPlayFragment.this.jfY.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.jfY.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.cYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cmy();
            }
        });
        this.jfK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cmx();
                am amVar = new am("c12796");
                amVar.bJ("tid", VideoPlayFragment.this.jfY.thread_id);
                amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.jfJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.AK(VideoPlayFragment.this.jfE);
            }
        });
        this.jfL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aeX();
                am amVar = new am("c12797");
                amVar.bJ("tid", VideoPlayFragment.this.jfY.thread_id);
                amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.jfM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cZ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jfY != null && VideoPlayFragment.this.jfY.author_info != null) {
                    VideoPlayFragment.this.bKy.a(true, VideoPlayFragment.this.jfY.author_info.portrait, VideoPlayFragment.this.jfY.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.Zr, VideoPlayFragment.this.jfY.forum_id, "0");
                    VideoPlayFragment.this.jfY.author_info.is_follow = "1";
                    VideoPlayFragment.this.cmA();
                }
            }
        });
        this.ddb = new AlphaAnimation(1.0f, 0.0f);
        this.ddb.setDuration(100L);
        this.ddb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.jfH != null) {
                    VideoPlayFragment.this.jfH.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.jgf = this.mRect.right - this.mRect.left;
            this.jgg = this.mRect.bottom - this.mRect.top;
            this.jfH.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.jfH.getWidth();
                    int height = VideoPlayFragment.this.jfH.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.jfY.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.jfY.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jfY.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jfY.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jgf, VideoPlayFragment.this.jgg);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.jfH.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jgg > 0 || VideoPlayFragment.this.jgf <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.jgf;
                                f = i / VideoPlayFragment.this.jgg;
                            }
                            VideoPlayFragment.this.jfH.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.jfH.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.jga) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jgf, VideoPlayFragment.this.jgg);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.jfH.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jgg > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.jfH.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.jfH.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.jga) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.jfH.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.jfH.getWidth();
                    int height = VideoPlayFragment.this.jfH.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.jfY.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.jfY.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jfY.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jfY.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.jfH.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.jfH.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.jga) {
            cmw();
        }
        if (this.jfY != null && !StringUtils.isNull(this.jfY.video_url)) {
            DY(this.jfY.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.hWn = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.hWE = cVar;
    }

    private void initEditor() {
        this.jgo = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dd(getActivity());
        if (this.jgo != null && this.jfY != null) {
            this.jgo.a(getPageContext());
            this.jgo.ad(this.jfY.thread_id, this.jfY.forum_id, this.jfY.forum_name);
            this.jgo.a(new a.InterfaceC0406a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0406a
                public void qN(boolean z) {
                    VideoPlayFragment.this.jgd.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.jge.setText(d.j.reply_something);
                    } else {
                        VideoPlayFragment.this.jge.setText(StringUtils.isNull(((c) VideoPlayFragment.this.jgo.alS().jw(28)).getInputView().getText().toString()) ? d.j.reply_something : d.j.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.jfY != null && z) {
                        long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.jfY.comment_num, 0L) + 1;
                        VideoPlayFragment.this.jfY.comment_num = String.valueOf(d);
                        VideoPlayFragment.this.jfR.setText(ap.az(d));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.jgo.alS(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeX() {
        if (this.jfY != null) {
            String str = this.jfY.forum_id;
            String str2 = this.jfY.forum_name;
            String str3 = this.jfY.title;
            String str4 = this.jfY.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.jfY.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.cby = "";
            dVar.linkUrl = str5;
            dVar.bDV = 2;
            dVar.extData = str4;
            dVar.cbB = 3;
            dVar.fid = str;
            dVar.cbs = str2;
            dVar.tid = str4;
            dVar.cbm = true;
            dVar.cbA = 0;
            dVar.cbF = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.jfY.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.jfY.title;
            originalThreadInfo.threadId = this.jfY.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.cbB);
            bundle.putInt("obj_type", dVar.cbF);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.bDV);
            dVar.D(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.aSt().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fDf) {
            this.eiW = new ForumManageModel(getPageContext());
            this.eiW.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.eiW.getLoadDataMode()) {
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
        this.hmV = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.hmV != null) {
            this.hmV.a(new a.InterfaceC0221a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0221a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.hmV != null) {
                            VideoPlayFragment.this.hmV.cZ(z2);
                        }
                        if (VideoPlayFragment.this.jfY != null) {
                            if (z2) {
                                VideoPlayFragment.this.jfY.mark_id = VideoPlayFragment.this.jfY.post_id;
                            } else {
                                VideoPlayFragment.this.jfY.mark_id = null;
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
        this.bKy = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.jgn = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cmz();
        if (Build.VERSION.SDK_INT >= 17) {
            this.jfG.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.jga && i == 3 && VideoPlayFragment.this.jfH.getVisibility() == 0) {
                        VideoPlayFragment.this.jfH.clearAnimation();
                        VideoPlayFragment.this.jfH.startAnimation(VideoPlayFragment.this.ddb);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.jfG.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.jfG != null) {
                    VideoPlayFragment.this.jfG.seekTo(0);
                    VideoPlayFragment.this.jfG.start();
                    VideoPlayFragment.this.aQo();
                    VideoPlayFragment.x(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.cmu();
                    }
                }
            }
        });
        this.jfG.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.jfH != null) {
                        VideoPlayFragment.this.jfH.clearAnimation();
                        VideoPlayFragment.this.jfH.startAnimation(VideoPlayFragment.this.ddb);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmu() {
        if (this.jfO != null && this.jfN != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.jfN.clearAnimation();
            this.jfO.clearAnimation();
            this.jfN.setVisibility(8);
            this.jfO.setVisibility(0);
            this.jfO.startAnimation(scaleAnimation2);
            this.jfN.startAnimation(scaleAnimation);
        }
    }

    private void cmv() {
        if (this.jfO != null && this.jfN != null) {
            this.jfN.clearAnimation();
            this.jfO.clearAnimation();
            this.jfN.setVisibility(0);
            this.jfO.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AK(int i) {
        int i2;
        if (bc.cZ(getActivity()) && this.jfY != null) {
            if (i == this.jfE) {
                if ("1".equals(this.jfY.is_agreed)) {
                    i2 = 1;
                    this.jfY.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.jfY.agree_num, 0) - 1);
                    this.jfY.is_agreed = "0";
                } else {
                    this.jfY.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.jfY.agree_num, 0) + 1);
                    this.jfY.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.jfY.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.jfY.agree_num, 0) + 1);
                this.jfY.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.bJ("tid", this.jfY.thread_id);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.jfE) {
                amVar.T("obj_type", i2);
            } else {
                amVar.T("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            cmz();
            if (this.jgb != null && i2 == 0) {
                this.jgb.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.jfY.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.jfY));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.jfY != null && !StringUtils.isNull(this.jfY.video_url)) {
            this.cvh = true;
            if (this.jga) {
                aQo();
                bAK();
                if (this.jfY != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.bJ("tid", this.jfY.thread_id);
                    amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.T("obj_type", 0);
                    TiebaStatic.log(amVar);
                }
            } else {
                pausePlay();
            }
        }
        if (this.jfY != null && !ap.isEmpty(this.jfY.thread_id)) {
            com.baidu.tbadk.BdToken.c.TZ().f(com.baidu.tbadk.BdToken.b.bqK, com.baidu.adp.lib.g.b.d(this.jfY.thread_id, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        stopPlay();
        if (this.jgo != null && this.jgo.alS() != null) {
            this.jgo.alS().hide();
            this.jgd.setVisibility(0);
            this.jge.setText(StringUtils.isNull(((c) this.jgo.alS().jw(28)).getInputView().getText().toString()) ? d.j.reply_something : d.j.draft_to_replay);
            com.baidu.tbadk.BdToken.c.TZ().Ua();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.jgo != null) {
            this.jgo.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.jga = z;
        if (this.cvh) {
            if (this.jga && (!this.jgn || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.jfY != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.bJ("tid", this.jfY.thread_id);
                    amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.T("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                cmw();
                this.jgn = false;
                return;
            }
            cmv();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cmw() {
        if (this.jfY != null) {
            am amVar = new am("c12590");
            amVar.bJ("tid", this.jfY.thread_id);
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.jfY.forum_id);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.T("obj_locate", this.jgh);
            amVar.bJ("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.T("obj_param2", 1);
            amVar.bJ("obj_param1", ap.isEmpty(this.jfY.mRecomWeight) ? "0" : this.jfY.mRecomWeight);
            amVar.bJ("extra", ap.isEmpty(this.jfY.mRecomExtra) ? "0" : this.jfY.mRecomExtra);
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.byA);
            amVar.bJ("ab_tag", ap.isEmpty(this.jfY.mRecomAbTag) ? "0" : this.jfY.mRecomAbTag);
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ap.isEmpty(this.jfY.mRecomSource) ? "0" : this.jfY.mRecomSource);
            amVar.bJ("obj_type", this.dku);
            amVar.T("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void DY(String str) {
        if (this.jfG != null && str != null && !str.equals(this.bNl)) {
            this.jfG.setRecoveryState(0);
            this.jfG.setVideoPath(str, this.jfY.thread_id);
            this.bNl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.ciP().ciQ() || cmC()) {
            bSP();
            if (this.jfU != null) {
                this.jfU.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.jfH.getVisibility() == 0) {
                this.jfH.clearAnimation();
                this.jfH.startAnimation(this.ddb);
            }
            if (this.jfG != null) {
                this.jfG.start();
                aQo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQo() {
        if (this.jfY != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.ctu = this.jfY.thread_id;
            zVar.ela = this.jfY.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.jfY.mRecomSource;
            zVar.hYL = this.jfY.mRecomAbTag;
            zVar.hYM = this.jfY.mRecomWeight;
            zVar.hYN = "";
            zVar.byA = "";
            zVar.hYP = this.jfY.mMd5;
            if (this.mRect != null) {
                zVar.hYQ = "1";
            } else {
                zVar.hYQ = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.hYR = "1";
                zVar.mLocate = "auto_midpage";
                zVar.hYN = "index";
            }
            com.baidu.tieba.play.l.a(this.jfY.mMd5, "", "1", zVar);
        }
    }

    private void bSP() {
        if (com.baidu.adp.lib.util.j.la()) {
            com.baidu.tieba.video.g.ciP().ex(getContext());
        }
    }

    private void pausePlay() {
        if (this.jfG != null) {
            this.jfG.pause();
        }
    }

    private void stopPlay() {
        if (this.jfG != null) {
            this.jfG.setRecoveryState(5);
            this.jfG.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmx() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.jfY.thread_id, this.jfY.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.jfY.forum_id));
        createNormalCfg.setForumName(this.jfY.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmy() {
        if (this.bus == null) {
            this.jgi = new com.baidu.tieba.view.a(getActivity());
            this.bus = new e(getActivity(), this.jgi.abk());
            this.bus.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.jfG.setSystemUiVisibility(4);
                }
            });
        }
        if (this.jgi != null) {
            ArrayList arrayList = new ArrayList();
            a.C0407a c0407a = new a.C0407a(this.jgi);
            c0407a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bus.dismiss();
                    if (VideoPlayFragment.this.jfY != null) {
                        boolean z = VideoPlayFragment.this.jfY.post_id != null && VideoPlayFragment.this.jfY.post_id.equals(VideoPlayFragment.this.jfY.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.jfY.thread_id);
                        markData.setPostId(VideoPlayFragment.this.jfY.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.jfY.thread_id);
                        markData.setForumId(VideoPlayFragment.this.jfY.forum_id);
                        if (VideoPlayFragment.this.hmV != null) {
                            VideoPlayFragment.this.hmV.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.hmV.Vd();
                            } else {
                                VideoPlayFragment.this.hmV.Vc();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.jfY != null && this.jfY.post_id != null && this.jfY.post_id.equals(this.jfY.mark_id)) {
                z = true;
            }
            if (z) {
                c0407a.setText(getResources().getString(d.j.remove_mark));
            } else {
                c0407a.setText(getResources().getString(d.j.mark));
            }
            arrayList.add(c0407a);
            a.C0407a c0407a2 = new a.C0407a(getActivity().getString(d.j.delete), this.jgi);
            c0407a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bus.dismiss();
                    if (bc.cZ(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jfY != null) {
                        String str = VideoPlayFragment.this.jfY.thread_id;
                        String str2 = VideoPlayFragment.this.jfY.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(d.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.jfY.post_id, true)));
                    }
                }
            });
            c0407a2.setText(getResources().getString(d.j.report_text));
            arrayList.add(c0407a2);
            if (this.fDf) {
                a.C0407a c0407a3 = new a.C0407a(getActivity().getString(d.j.delete), this.jgi);
                c0407a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.bus.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.gD(d.j.del_thread_confirm);
                        aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.jfY != null) {
                                    VideoPlayFragment.this.eiW.a(VideoPlayFragment.this.jfY.forum_id, VideoPlayFragment.this.jfY.forum_name, VideoPlayFragment.this.jfY.thread_id, VideoPlayFragment.this.jfY.post_id, 0, 0, VideoPlayFragment.this.fDf);
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
                        aVar.aaZ();
                    }
                });
                c0407a3.setText(getResources().getString(d.j.delete));
                arrayList.add(c0407a3);
            }
            this.jgi.P(arrayList);
        }
        this.bus.show();
    }

    private void cmz() {
        if (this.jfY != null) {
            this.jfH.startLoad(this.jfY.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.jfY.title);
            if (StringUtils.isNull(this.jfY.title) || matcher.matches()) {
                this.jfP.setVisibility(8);
            } else {
                this.jfP.setVisibility(0);
                this.jfP.setText(this.jfY.title);
            }
            this.jfR.setText(ap.az(com.baidu.adp.lib.g.b.d(this.jfY.comment_num, 0L)));
            this.jfS.setText(ap.az(com.baidu.adp.lib.g.b.d(this.jfY.agree_num, 0L)));
            this.jfT.setText(ap.az(com.baidu.adp.lib.g.b.d(this.jfY.share_num, 0L)));
            if (this.jfY.author_info != null) {
                if (!StringUtils.isNull(this.jfY.author_info.portrait) && this.jfY.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.jfI.startLoad(this.jfY.author_info.portrait, 10, false);
                } else {
                    this.jfI.startLoad(this.jfY.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.jfY.author_info.ciL())) {
                    this.jgc.setVisibility(8);
                } else {
                    this.jgc.setVisibility(0);
                    this.jgc.setText("@" + this.jfY.author_info.ciL());
                }
            }
            if ("1".equals(this.jfY.is_private) && this.jfZ.getVisibility() != 0) {
                this.jfX.setVisibility(0);
            } else {
                this.jfX.setVisibility(8);
            }
            if ("1".equals(this.jfY.is_agreed)) {
                al.c(this.jgb, d.f.icon_card_like_white_full_s);
            } else {
                al.c(this.jgb, d.f.btn_video_agree);
            }
            if (this.jfY.act_info != null && !StringUtils.isNull(this.jfY.act_info.activity_name) && this.jfZ.getVisibility() != 0) {
                this.jfW.setVisibility(0);
                this.jfQ.setText(this.jfY.act_info.activity_name);
            } else {
                this.jfW.setVisibility(8);
            }
            cmA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmA() {
        if (this.fDf || (this.jfY.author_info != null && !"0".equals(this.jfY.author_info.is_follow))) {
            this.jfM.setVisibility(4);
            this.jfM.setClickable(false);
            return;
        }
        this.jfM.setVisibility(0);
        this.jfM.setClickable(true);
    }

    private void cmB() {
        if (getActivity() != null) {
            if (this.jgp == null || !this.jgp.isShowing()) {
                this.jgp = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(d.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.j.confirm_title);
                ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.jgp.az(inflate);
                this.jgp.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.jgp.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.jgp.gF(1);
                this.jgp.gE(d.C0277d.cp_cont_b);
                this.jgp.dq(true);
                this.jgp.b(getPageContext());
                this.jgp.aaZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cmC() {
        if (!com.baidu.adp.lib.util.j.kY() || com.baidu.adp.lib.util.j.kZ()) {
            return true;
        }
        if (!this.jga || com.baidu.tieba.video.g.ciP().ciQ()) {
            return false;
        }
        if (this.jfU != null) {
            this.jfU.setVisibility(0);
        }
        pausePlay();
        cmB();
        return false;
    }

    private void bAK() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cmC() || com.baidu.tieba.video.g.ciP().ciQ()) && this.jfG != null && this.jfU != null) {
            this.jfG.start();
            this.jfU.setVisibility(8);
            bSP();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.jgj == null) {
            this.jgj = AnimationUtils.loadAnimation(getContext(), d.a.scale_zoom_in_and_out_anim);
        }
        return this.jgj;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
    public void atY() {
        if (this.jfG.isPlaying()) {
            this.jfG.pause();
            this.jfU.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cmC() || com.baidu.tieba.video.g.ciP().ciQ()) {
            this.jfG.start();
            this.jfU.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
    public void w(float f, float f2) {
        if (bc.cZ(getActivity()) && !this.jgk) {
            cmD();
            if (this.jfY != null && "0".equals(this.jfY.is_agreed)) {
                AK(this.jfF);
            }
        }
    }

    private void cmD() {
        if (this.mRootView != null) {
            this.jgk = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(d.f.icon_video_like);
            if (this.jgm == null) {
                this.jgm = new RelativeLayout.LayoutParams(-2, -2);
                this.jgm.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.jgm);
            }
            if (this.jgl == null) {
                this.jgl = new AnimatorSet();
                this.jgl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.jgk = false;
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
            this.jgl.setTarget(imageView);
            this.jgl.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.jgl.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
    public void atZ() {
        if (this.jfY != null && this.jfY.author_info != null) {
            long d = com.baidu.adp.lib.g.b.d(this.jfY.author_info.user_id, 0L);
            long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = d == d2;
            if (d == 0 && d2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(d, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.jfG != null) {
            return this.jfG.getMediaIDs();
        }
        return null;
    }

    public String cmE() {
        if (this.jfG != null) {
            return this.jfG.getMediaId();
        }
        return null;
    }

    public boolean cmF() {
        if (this.jgo == null || this.jgo.alS() == null || !this.jgo.alS().isVisible()) {
            return false;
        }
        this.jgo.alS().hide();
        this.jgd.setVisibility(0);
        if ((this.jgo.alS().jw(28) instanceof c) && ((c) this.jgo.alS().jw(28)).getInputView() != null && ((c) this.jgo.alS().jw(28)).getInputView().getText() != null) {
            this.jge.setText(StringUtils.isNull(((c) this.jgo.alS().jw(28)).getInputView().getText().toString()) ? d.j.reply_something : d.j.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.jgo != null) {
            this.jgo.onActivityResult(i, i2, intent);
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
        if (this.jgo != null && this.jgo.alS() != null) {
            this.jgo.alS().onChangeSkinType(i);
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
