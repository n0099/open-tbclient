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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0263a {
    private e bBz;
    private String bFP;
    private String bUZ;
    private boolean cDt;
    public ImageView djx;
    private n dlN;
    private AlphaAnimation dnI;
    private String dve;
    private boolean fTQ;
    private View feT;
    private j.b ioM;
    private QuickVideoView.c ipd;
    public TextView jyA;
    public TextView jyB;
    public TextView jyC;
    public ImageView jyD;
    private LinearLayout jyE;
    public LinearLayout jyF;
    public LinearLayout jyG;
    public VideoItemData jyH;
    private TextView jyI;
    private boolean jyJ;
    public ImageView jyK;
    public TextView jyL;
    private View jyM;
    private TextView jyN;
    private int jyO;
    private int jyP;
    private int jyQ;
    private com.baidu.tieba.view.a jyR;
    protected Animation jyS;
    private boolean jyT;
    private AnimatorSet jyU;
    private RelativeLayout.LayoutParams jyV;
    private com.baidu.tieba.videoplay.editor.a jyX;
    com.baidu.tbadk.core.dialog.a jyY;
    public QuickVideoView jyp;
    private TbImageView jyq;
    public HeadImageView jyr;
    public LinearLayout jys;
    public LinearLayout jyt;
    public LinearLayout jyu;
    public ImageView jyv;
    public ImageView jyw;
    public ImageView jyx;
    public TextView jyy;
    public TextView jyz;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int jyn = 0;
    private int jyo = 1;
    private ForumManageModel eyx = null;
    private com.baidu.tbadk.baseEditMark.a hEj = null;
    private com.baidu.tbadk.coreExtra.model.a bSl = null;
    private BdUniqueId Xk = BdUniqueId.gen();
    private boolean jyW = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.jyH != null && VideoPlayFragment.this.jyH.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jyH.author_info.user_id) && data != null && VideoPlayFragment.this.jyH.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.Xk)) ? false : false;
                    if (data.cgz == null) {
                        if (!data.Hi) {
                            if (z && !"0".equals(VideoPlayFragment.this.jyH.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.jyH.author_info.is_follow = "0";
                                VideoPlayFragment.this.cuB();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.jyJ) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.jyH));
                                    return;
                                }
                                VideoPlayFragment.this.jyH.author_info.is_follow = "1";
                                VideoPlayFragment.this.cuB();
                            }
                        } else {
                            VideoPlayFragment.this.jyH.author_info.is_follow = "0";
                            VideoPlayFragment.this.cuB();
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
                VideoPlayFragment.this.cuD();
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
        this.jyH = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.jyQ = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.dve = arguments.getString("from");
        this.bFP = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.jyH != null && this.jyH.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.jyH.author_info.user_id)) {
            this.fTQ = true;
        }
        this.dlN = new n(getActivity());
        this.dlN.a(this.jyH);
        this.dlN.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bc(int i, int i2) {
                if (VideoPlayFragment.this.ioM != null) {
                    VideoPlayFragment.this.ioM.bc(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.jyp = (QuickVideoView) this.mRootView.findViewById(R.id.videoView);
        this.jyp.setPlayerReuseEnable(true);
        this.jyp.setContinuePlayEnable(true);
        this.jyp.setBusiness(this.dlN);
        this.jyp.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.ipd != null) {
                    VideoPlayFragment.this.ipd.onStart();
                }
            }
        });
        this.jyp.setNeedRecovery(true);
        if (this.jyH != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.bVL = this.jyH.thread_id;
            zVar.eAB = this.jyH.forum_id;
            zVar.iri = this.jyH.mMd5;
            zVar.bFP = "";
            zVar.mSource = this.jyH.mRecomSource;
            zVar.irh = this.jyH.mRecomAbTag;
            zVar.irf = this.jyH.mRecomWeight;
            if (this.mRect != null) {
                zVar.irj = "1";
            } else {
                zVar.irj = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.irk = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.irg = this.dve;
                zVar.bFP = this.bFP;
                zVar.ire = this.jyH.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.dlN.setVideoStatsData(zVar);
        }
        this.jyq = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.jyq.setDefaultBgResource(R.drawable.icon_play_bg);
        this.jyq.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.agW()) {
            this.feT = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.feT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.feT.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.djx = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.jyr = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.jyr.setDefaultResource(17170445);
        this.jyr.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jyr.setIsRound(true);
        this.jyv = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.jyK = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.jyy = (TextView) this.mRootView.findViewById(R.id.video_title);
        this.jyz = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.jyt = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.jyA = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.jys = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.jyB = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.jyC = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.jyw = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.jyx = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cuw();
        this.jyD = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.jyE = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.jyF = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.jyG = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.jyu = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.jyL = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.jyM = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.jyM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.jyM.setVisibility(4);
                    if (VideoPlayFragment.this.jyX != null && VideoPlayFragment.this.jyX.aqS() != null) {
                        VideoPlayFragment.this.jyX.aqS().pO();
                    }
                    if (VideoPlayFragment.this.jyH != null) {
                        am amVar = new am("c13025");
                        amVar.bT("tid", VideoPlayFragment.this.jyH.thread_id);
                        amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.bT("fid", VideoPlayFragment.this.jyH.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.jyN = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.jyI = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.jyI.setVisibility(8);
        String string = b.agM().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jyI.setText(string);
        }
        final String string2 = b.agM().getString("nani_key_download_link_url", null);
        this.jyI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aiz().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cuA();
        this.jyr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jyH != null && VideoPlayFragment.this.jyH.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jyH.author_info.user_id) && VideoPlayFragment.this.jyH != null && VideoPlayFragment.this.jyH.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyH.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(c, z, false)));
                    am amVar = new am("c12798");
                    amVar.bT("tid", VideoPlayFragment.this.jyH.thread_id);
                    amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.jyF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jyH != null && VideoPlayFragment.this.jyH.act_info != null) {
                    com.baidu.tbadk.browser.a.ag(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.jyH.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.bT("tid", VideoPlayFragment.this.jyH.thread_id);
                    amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.jyy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cuy();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jyH != null && !StringUtils.isNull(VideoPlayFragment.this.jyH.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.jyH.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.djx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cuz();
            }
        });
        this.jyt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cuy();
                am amVar = new am("c12796");
                amVar.bT("tid", VideoPlayFragment.this.jyH.thread_id);
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.jys.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.BO(VideoPlayFragment.this.jyn);
            }
        });
        this.jyu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.ajT();
                am amVar = new am("c12797");
                amVar.bT("tid", VideoPlayFragment.this.jyH.thread_id);
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.jyv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cE(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jyH != null && VideoPlayFragment.this.jyH.author_info != null) {
                    VideoPlayFragment.this.bSl.a(true, VideoPlayFragment.this.jyH.author_info.portrait, VideoPlayFragment.this.jyH.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.Xk, VideoPlayFragment.this.jyH.forum_id, "0");
                    VideoPlayFragment.this.jyH.author_info.is_follow = "1";
                    VideoPlayFragment.this.cuB();
                }
            }
        });
        this.dnI = new AlphaAnimation(1.0f, 0.0f);
        this.dnI.setDuration(100L);
        this.dnI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.jyq != null) {
                    VideoPlayFragment.this.jyq.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.jyO = this.mRect.right - this.mRect.left;
            this.jyP = this.mRect.bottom - this.mRect.top;
            this.jyq.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.jyq.getWidth();
                    int height = VideoPlayFragment.this.jyq.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jyH.video_height, 0) > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jyH.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyH.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyH.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jyO, VideoPlayFragment.this.jyP);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.jyq.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jyP > 0 || VideoPlayFragment.this.jyO <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.jyO;
                                f = i / VideoPlayFragment.this.jyP;
                            }
                            VideoPlayFragment.this.jyq.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.jyq.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.jyJ) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jyO, VideoPlayFragment.this.jyP);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.jyq.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jyP > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.jyq.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.jyq.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.jyJ) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.jyq.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.jyq.getWidth();
                    int height = VideoPlayFragment.this.jyq.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jyH.video_height, 0) > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jyH.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyH.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyH.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.jyq.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.jyq.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.jyJ) {
            cux();
        }
        if (this.jyH != null && !StringUtils.isNull(this.jyH.video_url)) {
            Ft(this.jyH.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.ioM = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.ipd = cVar;
    }

    private void initEditor() {
        this.jyX = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().cJ(getActivity());
        if (this.jyX != null && this.jyH != null) {
            this.jyX.a(getPageContext());
            this.jyX.ad(this.jyH.thread_id, this.jyH.forum_id, this.jyH.forum_name);
            this.jyX.a(new a.InterfaceC0425a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0425a
                public void rC(boolean z) {
                    VideoPlayFragment.this.jyM.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.jyN.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.jyN.setText(StringUtils.isNull(((c) VideoPlayFragment.this.jyX.aqS().kj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.jyH != null && z) {
                        long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyH.comment_num, 0L) + 1;
                        VideoPlayFragment.this.jyH.comment_num = String.valueOf(c);
                        VideoPlayFragment.this.jyA.setText(ap.aN(c));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.jyX.aqS(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajT() {
        if (this.jyH != null) {
            String str = this.jyH.forum_id;
            String str2 = this.jyH.forum_name;
            String str3 = this.jyH.title;
            String str4 = this.jyH.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.jyH.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str3;
            eVar.content = format;
            eVar.cjC = "";
            eVar.linkUrl = str5;
            eVar.bLs = 2;
            eVar.extData = str4;
            eVar.cjF = 3;
            eVar.fid = str;
            eVar.cjw = str2;
            eVar.tid = str4;
            eVar.cjp = true;
            eVar.cjE = 0;
            eVar.cjJ = 2;
            if (parse != null) {
                eVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.jyH.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.jyH.title;
            originalThreadInfo.threadId = this.jyH.thread_id;
            eVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.cjF);
            bundle.putInt("obj_type", eVar.cjJ);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bLs);
            eVar.E(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), eVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.aZz().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fTQ) {
            this.eyx = new ForumManageModel(getPageContext());
            this.eyx.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.eyx.getLoadDataMode()) {
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
        this.hEj = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.hEj != null) {
            this.hEj.a(new a.InterfaceC0236a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0236a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.hEj != null) {
                            VideoPlayFragment.this.hEj.ds(z2);
                        }
                        if (VideoPlayFragment.this.jyH != null) {
                            if (z2) {
                                VideoPlayFragment.this.jyH.mark_id = VideoPlayFragment.this.jyH.post_id;
                            } else {
                                VideoPlayFragment.this.jyH.mark_id = null;
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
        this.bSl = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.jyW = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cuA();
        if (Build.VERSION.SDK_INT >= 17) {
            this.jyp.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.jyJ && i == 3 && VideoPlayFragment.this.jyq.getVisibility() == 0) {
                        VideoPlayFragment.this.jyq.clearAnimation();
                        VideoPlayFragment.this.jyq.startAnimation(VideoPlayFragment.this.dnI);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.jyp.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.jyp != null) {
                    VideoPlayFragment.this.jyp.seekTo(0);
                    VideoPlayFragment.this.jyp.start();
                    VideoPlayFragment.this.aXv();
                    VideoPlayFragment.x(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.cuv();
                    }
                }
            }
        });
        this.jyp.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.jyq != null) {
                        VideoPlayFragment.this.jyq.clearAnimation();
                        VideoPlayFragment.this.jyq.startAnimation(VideoPlayFragment.this.dnI);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuv() {
        if (this.jyx != null && this.jyw != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.jyw.clearAnimation();
            this.jyx.clearAnimation();
            this.jyw.setVisibility(8);
            this.jyx.setVisibility(0);
            this.jyx.startAnimation(scaleAnimation2);
            this.jyw.startAnimation(scaleAnimation);
        }
    }

    private void cuw() {
        if (this.jyx != null && this.jyw != null) {
            this.jyw.clearAnimation();
            this.jyx.clearAnimation();
            this.jyw.setVisibility(0);
            this.jyx.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BO(int i) {
        int i2;
        if (bc.cE(getActivity()) && this.jyH != null) {
            if (i == this.jyn) {
                if ("1".equals(this.jyH.is_agreed)) {
                    i2 = 1;
                    this.jyH.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jyH.agree_num, 0) - 1);
                    this.jyH.is_agreed = "0";
                } else {
                    this.jyH.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jyH.agree_num, 0) + 1);
                    this.jyH.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.jyH.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jyH.agree_num, 0) + 1);
                this.jyH.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.bT("tid", this.jyH.thread_id);
            amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.jyn) {
                amVar.P("obj_type", i2);
            } else {
                amVar.P("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            cuA();
            if (this.jyK != null && i2 == 0) {
                this.jyK.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.jyH.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.jyH));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.jyH != null && !StringUtils.isNull(this.jyH.video_url)) {
            this.cDt = true;
            if (this.jyJ) {
                aXv();
                bIr();
                if (this.jyH != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.bT("tid", this.jyH.thread_id);
                    amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.P("obj_type", 0);
                    TiebaStatic.log(amVar);
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
        if (this.jyX != null && this.jyX.aqS() != null) {
            this.jyX.aqS().hide();
            this.jyM.setVisibility(0);
            this.jyN.setText(StringUtils.isNull(((c) this.jyX.aqS().kj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.jyX != null) {
            this.jyX.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.jyJ = z;
        if (this.cDt) {
            if (this.jyJ && (!this.jyW || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.jyH != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.bT("tid", this.jyH.thread_id);
                    amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.P("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                cux();
                this.jyW = false;
                return;
            }
            cuw();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cux() {
        if (this.jyH != null) {
            am amVar = new am("c12590");
            amVar.bT("tid", this.jyH.thread_id);
            amVar.bT("fid", this.jyH.forum_id);
            amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.P("obj_locate", this.jyQ);
            amVar.bT("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.P("obj_param2", 1);
            amVar.bT("obj_param1", ap.isEmpty(this.jyH.mRecomWeight) ? "0" : this.jyH.mRecomWeight);
            amVar.bT("extra", ap.isEmpty(this.jyH.mRecomExtra) ? "0" : this.jyH.mRecomExtra);
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bFP);
            amVar.bT("ab_tag", ap.isEmpty(this.jyH.mRecomAbTag) ? "0" : this.jyH.mRecomAbTag);
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ap.isEmpty(this.jyH.mRecomSource) ? "0" : this.jyH.mRecomSource);
            amVar.bT("obj_type", this.dve);
            amVar.P("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void Ft(String str) {
        if (this.jyp != null && str != null && !str.equals(this.bUZ)) {
            this.jyp.setRecoveryState(0);
            this.jyp.setVideoPath(str, this.jyH.thread_id);
            this.bUZ = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.cqQ().cqR() || cuD()) {
            caL();
            if (this.jyD != null) {
                this.jyD.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.jyq.getVisibility() == 0) {
                this.jyq.clearAnimation();
                this.jyq.startAnimation(this.dnI);
            }
            if (this.jyp != null) {
                this.jyp.start();
                aXv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXv() {
        if (this.jyH != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.bVL = this.jyH.thread_id;
            zVar.eAB = this.jyH.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.jyH.mRecomSource;
            zVar.ire = this.jyH.mRecomAbTag;
            zVar.irf = this.jyH.mRecomWeight;
            zVar.irg = "";
            zVar.bFP = "";
            zVar.iri = this.jyH.mMd5;
            if (this.mRect != null) {
                zVar.irj = "1";
            } else {
                zVar.irj = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.irk = "1";
                zVar.mLocate = "auto_midpage";
                zVar.irg = "index";
            }
            com.baidu.tieba.play.l.a(this.jyH.mMd5, "", "1", zVar);
        }
    }

    private void caL() {
        if (com.baidu.adp.lib.util.j.jU()) {
            com.baidu.tieba.video.g.cqQ().en(getContext());
        }
    }

    private void pausePlay() {
        if (this.jyp != null) {
            this.jyp.pause();
        }
    }

    private void stopPlay() {
        if (this.jyp != null) {
            this.jyp.setRecoveryState(5);
            this.jyp.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuy() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.jyH.thread_id, this.jyH.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.jyH.forum_id));
        createNormalCfg.setForumName(this.jyH.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuz() {
        if (this.bBz == null) {
            this.jyR = new com.baidu.tieba.view.a(getActivity());
            this.bBz = new e(getActivity(), this.jyR.afZ());
            this.bBz.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.jyp.setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.jyR != null) {
            ArrayList arrayList = new ArrayList();
            a.C0426a c0426a = new a.C0426a(this.jyR);
            c0426a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bBz.dismiss();
                    if (VideoPlayFragment.this.jyH != null) {
                        boolean z = VideoPlayFragment.this.jyH.post_id != null && VideoPlayFragment.this.jyH.post_id.equals(VideoPlayFragment.this.jyH.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.jyH.thread_id);
                        markData.setPostId(VideoPlayFragment.this.jyH.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.jyH.thread_id);
                        markData.setForumId(VideoPlayFragment.this.jyH.forum_id);
                        if (VideoPlayFragment.this.hEj != null) {
                            VideoPlayFragment.this.hEj.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.hEj.ZE();
                            } else {
                                VideoPlayFragment.this.hEj.ZD();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.jyH != null && this.jyH.post_id != null && this.jyH.post_id.equals(this.jyH.mark_id)) {
                z = true;
            }
            if (z) {
                c0426a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0426a.setText(getResources().getString(R.string.mark));
            }
            arrayList.add(c0426a);
            a.C0426a c0426a2 = new a.C0426a(getActivity().getString(R.string.delete), this.jyR);
            c0426a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bBz.dismiss();
                    if (bc.cE(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jyH != null) {
                        String str = VideoPlayFragment.this.jyH.thread_id;
                        String str2 = VideoPlayFragment.this.jyH.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.jyH.post_id, true)));
                    }
                }
            });
            c0426a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0426a2);
            if (this.fTQ) {
                a.C0426a c0426a3 = new a.C0426a(getActivity().getString(R.string.delete), this.jyR);
                c0426a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.bBz.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.ho(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.jyH != null) {
                                    VideoPlayFragment.this.eyx.a(VideoPlayFragment.this.jyH.forum_id, VideoPlayFragment.this.jyH.forum_name, VideoPlayFragment.this.jyH.thread_id, VideoPlayFragment.this.jyH.post_id, 0, 0, VideoPlayFragment.this.fTQ);
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
                        aVar.dM(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.afG();
                    }
                });
                c0426a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0426a3);
            }
            this.jyR.W(arrayList);
        }
        this.bBz.show();
    }

    private void cuA() {
        if (this.jyH != null) {
            this.jyq.startLoad(this.jyH.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.jyH.title);
            if (StringUtils.isNull(this.jyH.title) || matcher.matches()) {
                this.jyy.setVisibility(8);
            } else {
                this.jyy.setVisibility(0);
                this.jyy.setText(this.jyH.title);
            }
            this.jyA.setText(ap.aN(com.baidu.adp.lib.g.b.c(this.jyH.comment_num, 0L)));
            this.jyB.setText(ap.aN(com.baidu.adp.lib.g.b.c(this.jyH.agree_num, 0L)));
            this.jyC.setText(ap.aN(com.baidu.adp.lib.g.b.c(this.jyH.share_num, 0L)));
            if (this.jyH.author_info != null) {
                if (!StringUtils.isNull(this.jyH.author_info.portrait) && this.jyH.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.jyr.startLoad(this.jyH.author_info.portrait, 10, false);
                } else {
                    this.jyr.startLoad(this.jyH.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.jyH.author_info.cqM())) {
                    this.jyL.setVisibility(8);
                } else {
                    this.jyL.setVisibility(0);
                    this.jyL.setText("@" + this.jyH.author_info.cqM());
                }
            }
            if ("1".equals(this.jyH.is_private) && this.jyI.getVisibility() != 0) {
                this.jyG.setVisibility(0);
            } else {
                this.jyG.setVisibility(8);
            }
            if ("1".equals(this.jyH.is_agreed)) {
                al.c(this.jyK, (int) R.drawable.icon_card_like_white_full_s);
            } else {
                al.c(this.jyK, (int) R.drawable.btn_video_agree);
            }
            if (this.jyH.act_info != null && !StringUtils.isNull(this.jyH.act_info.activity_name) && this.jyI.getVisibility() != 0) {
                this.jyF.setVisibility(0);
                this.jyz.setText(this.jyH.act_info.activity_name);
            } else {
                this.jyF.setVisibility(8);
            }
            cuB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuB() {
        if (this.fTQ || (this.jyH.author_info != null && !"0".equals(this.jyH.author_info.is_follow))) {
            this.jyv.setVisibility(4);
            this.jyv.setClickable(false);
            return;
        }
        this.jyv.setVisibility(0);
        this.jyv.setClickable(true);
    }

    private void cuC() {
        if (getActivity() != null) {
            if (this.jyY == null || !this.jyY.isShowing()) {
                this.jyY = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.jyY.aF(inflate);
                this.jyY.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.jyY.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.jyY.hr(1);
                this.jyY.hp(R.color.cp_cont_b);
                this.jyY.dM(true);
                this.jyY.b(getPageContext());
                this.jyY.afG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cuD() {
        if (!com.baidu.adp.lib.util.j.jS() || com.baidu.adp.lib.util.j.jT()) {
            return true;
        }
        if (!this.jyJ || com.baidu.tieba.video.g.cqQ().cqR()) {
            return false;
        }
        if (this.jyD != null) {
            this.jyD.setVisibility(0);
        }
        pausePlay();
        cuC();
        return false;
    }

    private void bIr() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cuD() || com.baidu.tieba.video.g.cqQ().cqR()) && this.jyp != null && this.jyD != null) {
            this.jyp.start();
            this.jyD.setVisibility(8);
            caL();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.jyS == null) {
            this.jyS = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.jyS;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
    public void aza() {
        if (this.jyp.isPlaying()) {
            this.jyp.pause();
            this.jyD.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cuD() || com.baidu.tieba.video.g.cqQ().cqR()) {
            this.jyp.start();
            this.jyD.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
    public void w(float f, float f2) {
        if (bc.cE(getActivity()) && !this.jyT) {
            cuE();
            if (this.jyH != null && "0".equals(this.jyH.is_agreed)) {
                BO(this.jyo);
            }
        }
    }

    private void cuE() {
        if (this.mRootView != null) {
            this.jyT = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.jyV == null) {
                this.jyV = new RelativeLayout.LayoutParams(-2, -2);
                this.jyV.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.jyV);
            }
            if (this.jyU == null) {
                this.jyU = new AnimatorSet();
                this.jyU.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.jyT = false;
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
            this.jyU.setTarget(imageView);
            this.jyU.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.jyU.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
    public void azb() {
        if (this.jyH != null && this.jyH.author_info != null) {
            long c = com.baidu.adp.lib.g.b.c(this.jyH.author_info.user_id, 0L);
            long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = c == c2;
            if (c == 0 && c2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(c, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.jyp != null) {
            return this.jyp.getMediaIDs();
        }
        return null;
    }

    public String cuF() {
        if (this.jyp != null) {
            return this.jyp.getMediaId();
        }
        return null;
    }

    public boolean cuG() {
        if (this.jyX == null || this.jyX.aqS() == null || !this.jyX.aqS().isVisible()) {
            return false;
        }
        this.jyX.aqS().hide();
        this.jyM.setVisibility(0);
        if ((this.jyX.aqS().kj(28) instanceof c) && ((c) this.jyX.aqS().kj(28)).getInputView() != null && ((c) this.jyX.aqS().kj(28)).getInputView().getText() != null) {
            this.jyN.setText(StringUtils.isNull(((c) this.jyX.aqS().kj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.jyX != null) {
            this.jyX.onActivityResult(i, i2, intent);
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
        if (this.jyX != null && this.jyX.aqS() != null) {
            this.jyX.aqS().onChangeSkinType(i);
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
