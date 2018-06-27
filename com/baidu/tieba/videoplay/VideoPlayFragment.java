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
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.f;
import com.baidu.tieba.videoplay.editor.a;
import com.baidu.tieba.videoplay.editor.c;
import com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager;
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
public class VideoPlayFragment extends BaseFragment implements VerticalViewPager.a {
    private boolean aXN;
    private e abL;
    private String agd;
    protected ScaleAnimation axX;
    private String bBe;
    public ImageView bsp;
    private n buL;
    private AlphaAnimation byq;
    private View cZT;
    private a cxb;
    private boolean dNa;
    public QuickVideoView hlD;
    private TbImageView hlE;
    public TbImageView hlF;
    public LinearLayout hlG;
    public LinearLayout hlH;
    public LinearLayout hlI;
    public ImageView hlJ;
    public TextView hlK;
    public TextView hlL;
    public TextView hlM;
    public TextView hlN;
    public TextView hlO;
    public ImageView hlP;
    private LinearLayout hlQ;
    public LinearLayout hlR;
    public LinearLayout hlS;
    public VideoItemData hlT;
    private TextView hlU;
    public ImageView hlV;
    public TextView hlW;
    private View hlX;
    private TextView hlY;
    private int hlZ;
    private int hma;
    private int hmb;
    private boolean hmc;
    private AnimatorSet hmd;
    private RelativeLayout.LayoutParams hme;
    private boolean hmf;
    private com.baidu.tieba.videoplay.editor.a hmg;
    com.baidu.tbadk.core.dialog.a hmh;
    public ImageView mBackBtn;
    private String mFrom;
    private boolean mIsVisible;
    private Rect mRect;
    public View mRootView;
    private int hlB = 0;
    private int hlC = 1;
    private ForumManageModel cxj = null;
    private com.baidu.tbadk.baseEditMark.a eWM = null;
    private com.baidu.tbadk.coreExtra.model.a ard = null;
    private BdUniqueId aqU = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.hlT != null && VideoPlayFragment.this.hlT.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hlT.author_info.user_id) && data != null && VideoPlayFragment.this.hlT.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aqU)) ? false : false;
                    if (data.aDu == null) {
                        if (!data.Gr) {
                            if (z && !"0".equals(VideoPlayFragment.this.hlT.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), d.k.attention_fail);
                                VideoPlayFragment.this.hlT.author_info.is_follow = "0";
                                VideoPlayFragment.this.bFi();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), d.k.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.hlT));
                                    return;
                                }
                                VideoPlayFragment.this.hlT.author_info.is_follow = "1";
                                VideoPlayFragment.this.bFi();
                            }
                        } else {
                            VideoPlayFragment.this.hlT.author_info.is_follow = "0";
                            VideoPlayFragment.this.bFi();
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
                VideoPlayFragment.this.bFk();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.hlT = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hmb = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.bBe = arguments.getString("from");
        this.hmf = arguments.getBoolean(VideoPlayActivityConfig.PAGE_FIRST_IN);
        this.agd = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.hlT != null && this.hlT.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hlT.author_info.user_id)) {
            this.dNa = true;
        }
        this.buL = new n(getActivity());
        this.mRootView = layoutInflater.inflate(d.i.video_play_view, (ViewGroup) null);
        this.hlD = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.hlD.setBusiness(this.buL);
        if (this.hlT != null) {
            y yVar = new y();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.aWo = this.hlT.thread_id;
            yVar.czo = this.hlT.forum_id;
            yVar.ghg = this.hlT.mMd5;
            yVar.agd = "";
            yVar.mSource = this.hlT.mRecomSource;
            yVar.ghf = this.hlT.mRecomAbTag;
            yVar.ghd = this.hlT.mRecomWeight;
            if (this.mRect != null) {
                yVar.ghh = "1";
            } else {
                yVar.ghh = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.ghi = "1";
                yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                yVar.ghe = "index";
                yVar.agd = this.agd;
                yVar.ghc = this.hlT.mRecomWeight;
            } else {
                yVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.buL.setVideoStatsData(yVar);
        }
        this.hlE = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.hlE.setDefaultBgResource(d.f.icon_play_bg);
        this.hlE.setDefaultErrorResource(d.f.icon_play_bg);
        if (g.yo()) {
            this.cZT = this.mRootView.findViewById(d.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.cZT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cZT.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.bsp = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.hlF = (TbImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.hlF.setIsRound(true);
        this.hlF.setDrawerType(1);
        this.hlF.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.hlF.setDefaultResource(d.C0142d.transparent);
        this.hlF.setDefaultBgResource(d.C0142d.transparent);
        this.hlJ = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.hlV = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.hlK = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.hlL = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.hlH = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.hlM = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.hlG = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.hlN = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.hlO = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.hlP = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.hlQ = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.hlR = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.hlS = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.hlI = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.hlW = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.hlX = this.mRootView.findViewById(d.g.quick_reply_comment_layout);
        this.hlX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.hlX.setVisibility(4);
                    if (VideoPlayFragment.this.hmg != null && VideoPlayFragment.this.hmg.Hy() != null) {
                        VideoPlayFragment.this.hmg.Hy().oD();
                    }
                    if (VideoPlayFragment.this.hlT != null) {
                        an anVar = new an("c13025");
                        anVar.ah("tid", VideoPlayFragment.this.hlT.thread_id);
                        anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.ah(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.hlT.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.hlY = (TextView) this.mRootView.findViewById(d.g.quick_reply_comment_text);
        this.hlU = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.hlU.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hlU.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.hlU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    az.zV().a((TbPageContext) i.ad(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bFh();
        this.hlF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hlT != null && VideoPlayFragment.this.hlT.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hlT.author_info.user_id) && VideoPlayFragment.this.hlT != null && VideoPlayFragment.this.hlT.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hlT.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(c, z, false)));
                    an anVar = new an("c12798");
                    anVar.ah("tid", VideoPlayFragment.this.hlT.thread_id);
                    anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.hlR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hlT != null && VideoPlayFragment.this.hlT.act_info != null) {
                    com.baidu.tbadk.browser.a.Q(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.hlT.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.ah("tid", VideoPlayFragment.this.hlT.thread_id);
                    anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.hlK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bFf();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hlT != null && !StringUtils.isNull(VideoPlayFragment.this.hlT.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.hlT.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.bsp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bFg();
            }
        });
        this.hlH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bFf();
                an anVar = new an("c12796");
                anVar.ah("tid", VideoPlayFragment.this.hlT.thread_id);
                anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.hlG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.uW(VideoPlayFragment.this.hlB);
            }
        });
        this.hlI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.AV();
                an anVar = new an("c12797");
                anVar.ah("tid", VideoPlayFragment.this.hlT.thread_id);
                anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.hlJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bb.aU(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hlT != null && VideoPlayFragment.this.hlT.author_info != null) {
                    VideoPlayFragment.this.ard.a(true, VideoPlayFragment.this.hlT.author_info.portrait, VideoPlayFragment.this.hlT.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.aqU, VideoPlayFragment.this.hlT.forum_id, "0");
                    VideoPlayFragment.this.hlT.author_info.is_follow = "1";
                    VideoPlayFragment.this.bFi();
                }
            }
        });
        this.byq = new AlphaAnimation(1.0f, 0.0f);
        this.byq.setDuration(100L);
        this.byq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.hlE != null) {
                    VideoPlayFragment.this.hlE.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.hlZ = this.mRect.right - this.mRect.left;
            this.hma = this.mRect.bottom - this.mRect.top;
            this.hlE.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.hlE.getWidth();
                    int height = VideoPlayFragment.this.hlE.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hlT.video_height, 0) > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hlT.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hlT.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hlT.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hlZ, VideoPlayFragment.this.hma);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.hlE.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hma > 0 || VideoPlayFragment.this.hlZ <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.hlZ;
                                f = i / VideoPlayFragment.this.hma;
                            }
                            VideoPlayFragment.this.hlE.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.hlE.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.mIsVisible) {
                                        if (VideoPlayFragment.this.hmf) {
                                            VideoPlayFragment.this.hmf = b.getInstance().getBoolean("video_play_vertical_first_in" + VideoPlayFragment.this.bBe, true);
                                        }
                                        if (!VideoPlayFragment.this.hmf) {
                                            VideoPlayFragment.this.startPlay();
                                        }
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hlZ, VideoPlayFragment.this.hma);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.hlE.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hma > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.hlE.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.hlE.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (VideoPlayFragment.this.hmf) {
                                    VideoPlayFragment.this.hmf = b.getInstance().getBoolean("video_play_vertical_first_in" + VideoPlayFragment.this.bBe, true);
                                }
                                if (!VideoPlayFragment.this.hmf) {
                                    VideoPlayFragment.this.startPlay();
                                }
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.hlE.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.hlE.getWidth();
                    int height = VideoPlayFragment.this.hlE.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hlT.video_height, 0) > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hlT.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hlT.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hlT.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.hlE.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.hlE.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.mIsVisible) {
            bFd();
        }
        return this.mRootView;
    }

    private void initEditor() {
        this.hmg = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().aY(getActivity());
        if (this.hmg != null && this.hlT != null) {
            this.hmg.setContext(getPageContext());
            this.hmg.I(this.hlT.thread_id, this.hlT.forum_id, this.hlT.forum_name);
            this.hmg.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0250a
                public void nt(boolean z) {
                    VideoPlayFragment.this.hlX.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.hlY.setText(d.k.reply_something);
                    } else {
                        VideoPlayFragment.this.hlY.setText(StringUtils.isNull(((c) VideoPlayFragment.this.hmg.Hy().eN(28)).getInputView().getText().toString()) ? d.k.reply_something : d.k.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.hlT != null && z) {
                        VideoPlayFragment.this.hlM.setText(ap.F(com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hlT.comment_num, 0L) + 1));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.hmg.Hy(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AV() {
        if (this.hlT != null) {
            String str = this.hlT.forum_id;
            String str2 = this.hlT.forum_name;
            String str3 = this.hlT.title;
            String str4 = this.hlT.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hlT.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.k.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.aGf = "";
            dVar.linkUrl = str5;
            dVar.aky = 2;
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
            originalThreadInfo.showPicUrl = this.hlT.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hlT.title;
            originalThreadInfo.threadId = this.hlT.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aGi);
            bundle.putInt("obj_type", dVar.aGj);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aky);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.akp().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.dNa) {
            this.cxj = new ForumManageModel(getPageContext());
            this.cxj.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.cxj.getLoadDataMode()) {
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
        this.eWM = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.eWM != null) {
            this.eWM.a(new a.InterfaceC0100a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0100a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.eWM != null) {
                            VideoPlayFragment.this.eWM.ah(z2);
                        }
                        if (VideoPlayFragment.this.hlT != null) {
                            if (z2) {
                                VideoPlayFragment.this.hlT.mark_id = VideoPlayFragment.this.hlT.post_id;
                            } else {
                                VideoPlayFragment.this.hlT.mark_id = null;
                            }
                        }
                        if (z2) {
                            VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(d.k.add_mark));
                            return;
                        } else {
                            VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(d.k.remove_mark));
                            return;
                        }
                    }
                    VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(d.k.update_mark_failed));
                }
            });
        }
        this.ard = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bFh();
        if (Build.VERSION.SDK_INT >= 17) {
            this.hlD.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.tieba.play.g.e
                public boolean a(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.mIsVisible && i == 3 && VideoPlayFragment.this.hlE.getVisibility() == 0) {
                        VideoPlayFragment.this.hlE.clearAnimation();
                        VideoPlayFragment.this.hlE.startAnimation(VideoPlayFragment.this.byq);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.hlD.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.hlD != null) {
                    VideoPlayFragment.this.hlD.seekTo(0);
                    VideoPlayFragment.this.hlD.start();
                    VideoPlayFragment.this.aij();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uW(int i) {
        int i2;
        if (bb.aU(getActivity()) && this.hlT != null) {
            if (i == this.hlB) {
                if ("1".equals(this.hlT.is_agreed)) {
                    i2 = 1;
                    this.hlT.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.hlT.agree_num, 0) - 1);
                    this.hlT.is_agreed = "0";
                } else {
                    this.hlT.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.hlT.agree_num, 0) + 1);
                    this.hlT.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.hlT.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.hlT.agree_num, 0) + 1);
                this.hlT.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.ah("tid", this.hlT.thread_id);
            anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.hlB) {
                anVar.r("obj_type", i2);
            } else {
                anVar.r("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            bFh();
            if (this.hlV != null && i2 == 0) {
                this.hlV.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hlT.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hlT));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hlT != null && !StringUtils.isNull(this.hlT.video_url)) {
            vj(this.hlT.video_url);
            this.aXN = true;
            if (this.mIsVisible) {
                if (this.hmf) {
                    this.hmf = b.getInstance().getBoolean("video_play_vertical_first_in" + this.bBe, true);
                }
                if (!this.hmf) {
                    aij();
                    aRf();
                }
                if (this.hlT != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.ah("tid", this.hlT.thread_id);
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
        if (this.hmg != null && this.hmg.Hy() != null) {
            this.hmg.Hy().hide();
        }
        this.hlX.setVisibility(0);
        this.hlY.setText(StringUtils.isNull(((c) this.hmg.Hy().eN(28)).getInputView().getText().toString()) ? d.k.reply_something : d.k.draft_to_replay);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        stopPlay();
        if (this.hmg != null) {
            this.hmg.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisible = z;
        if (this.aXN) {
            if (this.mIsVisible) {
                if (this.hlT != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.ah("tid", this.hlT.thread_id);
                    anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.r("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                if (this.hmf) {
                    this.hmf = b.getInstance().getBoolean("video_play_vertical_first_in" + this.bBe, true);
                }
                if (!this.hmf) {
                    startPlay();
                }
                bFd();
                return;
            }
            pausePlay();
        }
    }

    private void bFd() {
        if (this.hlT != null) {
            an anVar = new an("c12590");
            anVar.ah("tid", this.hlT.thread_id);
            anVar.ah(ImageViewerConfig.FORUM_ID, this.hlT.forum_id);
            anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.r("obj_locate", this.hmb);
            anVar.ah("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.r("obj_param2", 1);
            anVar.ah("obj_param1", this.hlT.mRecomWeight);
            anVar.ah("extra", this.hlT.mRecomExtra);
            anVar.ah(VideoPlayActivityConfig.OBJ_ID, this.agd);
            anVar.ah("ab_tag", this.hlT.mRecomAbTag);
            anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hlT.mRecomSource);
            anVar.r("is_vertical", 1);
            TiebaStatic.log(anVar);
        }
    }

    private void vj(String str) {
        if (this.hlD != null) {
            this.hlD.setRecoveryState(0);
            this.hlD.setVideoPath(str, this.hlT.thread_id);
        }
    }

    public void bFe() {
        if (this.hmf) {
            this.hmf = false;
            if (this.mIsVisible) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || f.bBB().bBC() || bFk()) {
            blE();
            if (this.hlP != null) {
                this.hlP.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hlE.getVisibility() == 0) {
                this.hlE.clearAnimation();
                this.hlE.startAnimation(this.byq);
            }
            if (this.hlD != null) {
                this.hlD.seekTo(0);
                this.hlD.start();
                aij();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aij() {
        if (this.hlT != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.aWo = this.hlT.thread_id;
            yVar.czo = this.hlT.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.hlT.mRecomSource;
            yVar.ghc = this.hlT.mRecomAbTag;
            yVar.ghd = this.hlT.mRecomWeight;
            yVar.ghe = "";
            yVar.agd = "";
            yVar.ghg = this.hlT.mMd5;
            if (this.mRect != null) {
                yVar.ghh = "1";
            } else {
                yVar.ghh = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.ghi = "1";
                yVar.mLocate = "auto_midpage";
                yVar.ghe = "index";
            }
            com.baidu.tieba.play.l.a(this.hlT.mMd5, "", "1", yVar);
        }
    }

    private void blE() {
        if (j.jF()) {
            f.bBB().ck(getContext());
        }
    }

    private void pausePlay() {
        if (this.hlD != null) {
            this.hlD.pause();
        }
    }

    private void stopPlay() {
        this.hlD.setRecoveryState(5);
        this.hlD.stopPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFf() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hlT.thread_id, this.hlT.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hlT.forum_id));
        createNormalCfg.setForumName(this.hlT.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFg() {
        if (this.abL == null) {
            this.cxb = new com.baidu.tieba.view.a(getActivity());
            this.abL = new e(getActivity(), this.cxb.bFF());
            this.abL.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.hlD.setSystemUiVisibility(4);
                }
            });
        }
        if (this.cxb != null) {
            ArrayList arrayList = new ArrayList();
            a.C0251a c0251a = new a.C0251a(this.cxb);
            c0251a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.abL.dismiss();
                    if (VideoPlayFragment.this.hlT != null) {
                        boolean z = VideoPlayFragment.this.hlT.post_id != null && VideoPlayFragment.this.hlT.post_id.equals(VideoPlayFragment.this.hlT.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.hlT.thread_id);
                        markData.setPostId(VideoPlayFragment.this.hlT.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.hlT.thread_id);
                        markData.setForumId(VideoPlayFragment.this.hlT.forum_id);
                        if (VideoPlayFragment.this.eWM != null) {
                            VideoPlayFragment.this.eWM.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.eWM.se();
                            } else {
                                VideoPlayFragment.this.eWM.sd();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hlT != null && this.hlT.post_id != null && this.hlT.post_id.equals(this.hlT.mark_id)) {
                z = true;
            }
            if (z) {
                c0251a.setText(getResources().getString(d.k.remove_mark));
            } else {
                c0251a.setText(getResources().getString(d.k.mark));
            }
            arrayList.add(c0251a);
            a.C0251a c0251a2 = new a.C0251a(getActivity().getString(d.k.delete), this.cxb);
            c0251a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.abL.dismiss();
                    if (bb.aU(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hlT != null) {
                        String str = VideoPlayFragment.this.hlT.thread_id;
                        String str2 = VideoPlayFragment.this.hlT.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(d.k.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.hlT.post_id, true)));
                    }
                }
            });
            c0251a2.setText(getResources().getString(d.k.report_text));
            arrayList.add(c0251a2);
            if (this.dNa) {
                a.C0251a c0251a3 = new a.C0251a(getActivity().getString(d.k.delete), this.cxb);
                c0251a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.abL.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.cd(d.k.del_thread_confirm);
                        aVar.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.hlT != null) {
                                    VideoPlayFragment.this.cxj.a(VideoPlayFragment.this.hlT.forum_id, VideoPlayFragment.this.hlT.forum_name, VideoPlayFragment.this.hlT.thread_id, VideoPlayFragment.this.hlT.post_id, 0, 0, VideoPlayFragment.this.dNa);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                                }
                            }
                        });
                        aVar.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.aw(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.xn();
                    }
                });
                c0251a3.setText(getResources().getString(d.k.delete));
                arrayList.add(c0251a3);
            }
            this.cxb.dQ(arrayList);
        }
        this.abL.show();
    }

    private void bFh() {
        if (this.hlT != null) {
            this.hlE.startLoad(this.hlT.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.hlT.title);
            if (StringUtils.isNull(this.hlT.title) || matcher.matches()) {
                this.hlK.setVisibility(8);
            } else {
                this.hlK.setVisibility(0);
                this.hlK.setText(this.hlT.title);
            }
            this.hlM.setText(ap.F(com.baidu.adp.lib.g.b.c(this.hlT.comment_num, 0L)));
            this.hlN.setText(ap.F(com.baidu.adp.lib.g.b.c(this.hlT.agree_num, 0L)));
            this.hlO.setText(ap.F(com.baidu.adp.lib.g.b.c(this.hlT.share_num, 0L)));
            if (this.hlT.author_info != null) {
                if (!StringUtils.isNull(this.hlT.author_info.portrait) && this.hlT.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.hlF.startLoad(this.hlT.author_info.portrait, 10, false);
                } else {
                    this.hlF.startLoad(this.hlT.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.hlT.author_info.bBx())) {
                    this.hlW.setVisibility(8);
                } else {
                    this.hlW.setVisibility(0);
                    this.hlW.setText("@" + this.hlT.author_info.bBx());
                }
            }
            if ("1".equals(this.hlT.is_private) && this.hlU.getVisibility() != 0) {
                this.hlS.setVisibility(0);
            } else {
                this.hlS.setVisibility(8);
            }
            if ("1".equals(this.hlT.is_agreed)) {
                am.c(this.hlV, d.f.icon_home_card_like_s);
            } else {
                am.c(this.hlV, d.f.btn_video_agree);
            }
            if (this.hlT.act_info != null && !StringUtils.isNull(this.hlT.act_info.activity_name) && this.hlU.getVisibility() != 0) {
                this.hlR.setVisibility(0);
                this.hlL.setText(this.hlT.act_info.activity_name);
            } else {
                this.hlR.setVisibility(8);
            }
            bFi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFi() {
        if (this.dNa || (this.hlT.author_info != null && !"0".equals(this.hlT.author_info.is_follow))) {
            this.hlJ.setVisibility(4);
            this.hlJ.setClickable(false);
            return;
        }
        this.hlJ.setVisibility(0);
        this.hlJ.setClickable(true);
    }

    private void bFj() {
        if (getActivity() != null) {
            if (this.hmh == null || !this.hmh.isShowing()) {
                this.hmh = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
                ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.hmh.w(inflate);
                this.hmh.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.hmh.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.hmh.cf(1);
                this.hmh.ce(d.C0142d.cp_cont_b);
                this.hmh.aw(true);
                this.hmh.b(getPageContext());
                this.hmh.xn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bFk() {
        if (!j.jD() || j.jE()) {
            return true;
        }
        if (!this.mIsVisible || f.bBB().bBC()) {
            return false;
        }
        if (this.hlP != null) {
            this.hlP.setVisibility(0);
        }
        pausePlay();
        bFj();
        return false;
    }

    private void aRf() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bFk() || f.bBB().bBC()) && this.hlD != null && this.hlP != null) {
            this.hlD.start();
            this.hlP.setVisibility(8);
            blE();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.axX == null) {
            this.axX = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axX.setDuration(200L);
        }
        return this.axX;
    }

    public long bFl() {
        if (this.hlQ != null) {
            this.hlQ.setVisibility(8);
        }
        if (this.hlU != null) {
            this.hlU.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }

    @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
    public void bEZ() {
        if (this.hlD.isPlaying()) {
            this.hlD.pause();
            this.hlP.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bFk() || f.bBB().bBC()) {
            this.hlD.start();
            this.hlP.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
    public void u(float f, float f2) {
        if (bb.aU(getActivity()) && !this.hmc) {
            bFm();
            if (this.hlT != null && "0".equals(this.hlT.is_agreed)) {
                uW(this.hlC);
            }
        }
    }

    private void bFm() {
        if (this.mRootView != null) {
            this.hmc = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(d.f.icon_video_like);
            if (this.hme == null) {
                this.hme = new RelativeLayout.LayoutParams(-2, -2);
                this.hme.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.hme);
            }
            if (this.hmd == null) {
                this.hmd = new AnimatorSet();
                this.hmd.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.hmc = false;
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
            this.hmd.setTarget(imageView);
            this.hmd.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.hmd.start();
        }
    }

    @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
    public void bFb() {
        if (this.hlT != null && this.hlT.author_info != null) {
            long c = com.baidu.adp.lib.g.b.c(this.hlT.author_info.user_id, 0L);
            long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = c == c2;
            if (c == 0 && c2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(c, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.hlD != null) {
            return this.hlD.getMediaIDs();
        }
        return null;
    }

    public String bFn() {
        if (this.hlD != null) {
            return this.hlD.getMediaId();
        }
        return null;
    }

    public boolean bFo() {
        if (this.hmg == null || this.hmg.Hy() == null || !this.hmg.Hy().isVisible()) {
            return false;
        }
        this.hmg.Hy().hide();
        this.hlX.setVisibility(0);
        if ((this.hmg.Hy().eN(28) instanceof c) && ((c) this.hmg.Hy().eN(28)).getInputView() != null && ((c) this.hmg.Hy().eN(28)).getInputView().getText() != null) {
            this.hlY.setText(StringUtils.isNull(((c) this.hmg.Hy().eN(28)).getInputView().getText().toString()) ? d.k.reply_something : d.k.draft_to_replay);
        }
        return true;
    }

    public void b(int i, int i2, Intent intent) {
        if (this.hmg != null) {
            this.hmg.onActivityResult(i, i2, intent);
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
        if (this.hmg != null && this.hmg.Hy() != null) {
            this.hmg.Hy().onChangeSkinType(i);
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
