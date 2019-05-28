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
    public ImageView djy;
    private n dlO;
    private AlphaAnimation dnJ;
    private String dvf;
    private boolean fTR;
    private View feU;
    private j.b ioP;
    private QuickVideoView.c ipg;
    public TextView jyA;
    public TextView jyB;
    public TextView jyC;
    public TextView jyD;
    public ImageView jyE;
    private LinearLayout jyF;
    public LinearLayout jyG;
    public LinearLayout jyH;
    public VideoItemData jyI;
    private TextView jyJ;
    private boolean jyK;
    public ImageView jyL;
    public TextView jyM;
    private View jyN;
    private TextView jyO;
    private int jyP;
    private int jyQ;
    private int jyR;
    private com.baidu.tieba.view.a jyS;
    protected Animation jyT;
    private boolean jyU;
    private AnimatorSet jyV;
    private RelativeLayout.LayoutParams jyW;
    private com.baidu.tieba.videoplay.editor.a jyY;
    com.baidu.tbadk.core.dialog.a jyZ;
    public QuickVideoView jyq;
    private TbImageView jyr;
    public HeadImageView jys;
    public LinearLayout jyt;
    public LinearLayout jyu;
    public LinearLayout jyv;
    public ImageView jyw;
    public ImageView jyx;
    public ImageView jyy;
    public TextView jyz;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int jyo = 0;
    private int jyp = 1;
    private ForumManageModel eyy = null;
    private com.baidu.tbadk.baseEditMark.a hEm = null;
    private com.baidu.tbadk.coreExtra.model.a bSl = null;
    private BdUniqueId Xk = BdUniqueId.gen();
    private boolean jyX = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.jyI != null && VideoPlayFragment.this.jyI.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jyI.author_info.user_id) && data != null && VideoPlayFragment.this.jyI.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.Xk)) ? false : false;
                    if (data.cgz == null) {
                        if (!data.Hi) {
                            if (z && !"0".equals(VideoPlayFragment.this.jyI.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.jyI.author_info.is_follow = "0";
                                VideoPlayFragment.this.cuD();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.jyK) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.jyI));
                                    return;
                                }
                                VideoPlayFragment.this.jyI.author_info.is_follow = "1";
                                VideoPlayFragment.this.cuD();
                            }
                        } else {
                            VideoPlayFragment.this.jyI.author_info.is_follow = "0";
                            VideoPlayFragment.this.cuD();
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
                VideoPlayFragment.this.cuF();
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
        this.jyI = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.jyR = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.dvf = arguments.getString("from");
        this.bFP = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.jyI != null && this.jyI.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.jyI.author_info.user_id)) {
            this.fTR = true;
        }
        this.dlO = new n(getActivity());
        this.dlO.a(this.jyI);
        this.dlO.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bc(int i, int i2) {
                if (VideoPlayFragment.this.ioP != null) {
                    VideoPlayFragment.this.ioP.bc(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.jyq = (QuickVideoView) this.mRootView.findViewById(R.id.videoView);
        this.jyq.setPlayerReuseEnable(true);
        this.jyq.setContinuePlayEnable(true);
        this.jyq.setBusiness(this.dlO);
        this.jyq.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.ipg != null) {
                    VideoPlayFragment.this.ipg.onStart();
                }
            }
        });
        this.jyq.setNeedRecovery(true);
        if (this.jyI != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.bVL = this.jyI.thread_id;
            zVar.eAC = this.jyI.forum_id;
            zVar.irl = this.jyI.mMd5;
            zVar.bFP = "";
            zVar.mSource = this.jyI.mRecomSource;
            zVar.irk = this.jyI.mRecomAbTag;
            zVar.iri = this.jyI.mRecomWeight;
            if (this.mRect != null) {
                zVar.irm = "1";
            } else {
                zVar.irm = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.irn = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.irj = this.dvf;
                zVar.bFP = this.bFP;
                zVar.irh = this.jyI.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.dlO.setVideoStatsData(zVar);
        }
        this.jyr = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.jyr.setDefaultBgResource(R.drawable.icon_play_bg);
        this.jyr.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.agW()) {
            this.feU = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.feU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.feU.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.djy = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.jys = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.jys.setDefaultResource(17170445);
        this.jys.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jys.setIsRound(true);
        this.jyw = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.jyL = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.jyz = (TextView) this.mRootView.findViewById(R.id.video_title);
        this.jyA = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.jyu = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.jyB = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.jyt = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.jyC = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.jyD = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.jyx = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.jyy = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cuy();
        this.jyE = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.jyF = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.jyG = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.jyH = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.jyv = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.jyM = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.jyN = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.jyN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.jyN.setVisibility(4);
                    if (VideoPlayFragment.this.jyY != null && VideoPlayFragment.this.jyY.aqS() != null) {
                        VideoPlayFragment.this.jyY.aqS().pO();
                    }
                    if (VideoPlayFragment.this.jyI != null) {
                        am amVar = new am("c13025");
                        amVar.bT("tid", VideoPlayFragment.this.jyI.thread_id);
                        amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.bT("fid", VideoPlayFragment.this.jyI.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.jyO = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.jyJ = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.jyJ.setVisibility(8);
        String string = b.agM().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jyJ.setText(string);
        }
        final String string2 = b.agM().getString("nani_key_download_link_url", null);
        this.jyJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aiz().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cuC();
        this.jys.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jyI != null && VideoPlayFragment.this.jyI.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jyI.author_info.user_id) && VideoPlayFragment.this.jyI != null && VideoPlayFragment.this.jyI.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyI.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(c, z, false)));
                    am amVar = new am("c12798");
                    amVar.bT("tid", VideoPlayFragment.this.jyI.thread_id);
                    amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.jyG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jyI != null && VideoPlayFragment.this.jyI.act_info != null) {
                    com.baidu.tbadk.browser.a.ag(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.jyI.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.bT("tid", VideoPlayFragment.this.jyI.thread_id);
                    amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.jyz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cuA();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jyI != null && !StringUtils.isNull(VideoPlayFragment.this.jyI.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.jyI.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.djy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cuB();
            }
        });
        this.jyu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cuA();
                am amVar = new am("c12796");
                amVar.bT("tid", VideoPlayFragment.this.jyI.thread_id);
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.jyt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.BO(VideoPlayFragment.this.jyo);
            }
        });
        this.jyv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.ajT();
                am amVar = new am("c12797");
                amVar.bT("tid", VideoPlayFragment.this.jyI.thread_id);
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.jyw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cE(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jyI != null && VideoPlayFragment.this.jyI.author_info != null) {
                    VideoPlayFragment.this.bSl.a(true, VideoPlayFragment.this.jyI.author_info.portrait, VideoPlayFragment.this.jyI.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.Xk, VideoPlayFragment.this.jyI.forum_id, "0");
                    VideoPlayFragment.this.jyI.author_info.is_follow = "1";
                    VideoPlayFragment.this.cuD();
                }
            }
        });
        this.dnJ = new AlphaAnimation(1.0f, 0.0f);
        this.dnJ.setDuration(100L);
        this.dnJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.jyr != null) {
                    VideoPlayFragment.this.jyr.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.jyP = this.mRect.right - this.mRect.left;
            this.jyQ = this.mRect.bottom - this.mRect.top;
            this.jyr.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.jyr.getWidth();
                    int height = VideoPlayFragment.this.jyr.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jyI.video_height, 0) > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jyI.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyI.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyI.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jyP, VideoPlayFragment.this.jyQ);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.jyr.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jyQ > 0 || VideoPlayFragment.this.jyP <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.jyP;
                                f = i / VideoPlayFragment.this.jyQ;
                            }
                            VideoPlayFragment.this.jyr.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.jyr.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.jyK) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jyP, VideoPlayFragment.this.jyQ);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.jyr.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jyQ > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.jyr.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.jyr.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.jyK) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.jyr.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.jyr.getWidth();
                    int height = VideoPlayFragment.this.jyr.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jyI.video_height, 0) > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jyI.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyI.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyI.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.jyr.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.jyr.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.jyK) {
            cuz();
        }
        if (this.jyI != null && !StringUtils.isNull(this.jyI.video_url)) {
            Ft(this.jyI.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.ioP = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.ipg = cVar;
    }

    private void initEditor() {
        this.jyY = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().cJ(getActivity());
        if (this.jyY != null && this.jyI != null) {
            this.jyY.a(getPageContext());
            this.jyY.ad(this.jyI.thread_id, this.jyI.forum_id, this.jyI.forum_name);
            this.jyY.a(new a.InterfaceC0425a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0425a
                public void rC(boolean z) {
                    VideoPlayFragment.this.jyN.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.jyO.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.jyO.setText(StringUtils.isNull(((c) VideoPlayFragment.this.jyY.aqS().kj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.jyI != null && z) {
                        long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyI.comment_num, 0L) + 1;
                        VideoPlayFragment.this.jyI.comment_num = String.valueOf(c);
                        VideoPlayFragment.this.jyB.setText(ap.aN(c));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.jyY.aqS(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajT() {
        if (this.jyI != null) {
            String str = this.jyI.forum_id;
            String str2 = this.jyI.forum_name;
            String str3 = this.jyI.title;
            String str4 = this.jyI.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.jyI.thumbnail_url;
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
            originalThreadInfo.showPicUrl = this.jyI.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.jyI.title;
            originalThreadInfo.threadId = this.jyI.thread_id;
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
            com.baidu.tieba.c.e.aZC().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fTR) {
            this.eyy = new ForumManageModel(getPageContext());
            this.eyy.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.eyy.getLoadDataMode()) {
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
        this.hEm = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.hEm != null) {
            this.hEm.a(new a.InterfaceC0236a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0236a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.hEm != null) {
                            VideoPlayFragment.this.hEm.ds(z2);
                        }
                        if (VideoPlayFragment.this.jyI != null) {
                            if (z2) {
                                VideoPlayFragment.this.jyI.mark_id = VideoPlayFragment.this.jyI.post_id;
                            } else {
                                VideoPlayFragment.this.jyI.mark_id = null;
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
            this.jyX = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cuC();
        if (Build.VERSION.SDK_INT >= 17) {
            this.jyq.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.jyK && i == 3 && VideoPlayFragment.this.jyr.getVisibility() == 0) {
                        VideoPlayFragment.this.jyr.clearAnimation();
                        VideoPlayFragment.this.jyr.startAnimation(VideoPlayFragment.this.dnJ);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.jyq.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.jyq != null) {
                    VideoPlayFragment.this.jyq.seekTo(0);
                    VideoPlayFragment.this.jyq.start();
                    VideoPlayFragment.this.aXy();
                    VideoPlayFragment.x(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.cux();
                    }
                }
            }
        });
        this.jyq.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.jyr != null) {
                        VideoPlayFragment.this.jyr.clearAnimation();
                        VideoPlayFragment.this.jyr.startAnimation(VideoPlayFragment.this.dnJ);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cux() {
        if (this.jyy != null && this.jyx != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.jyx.clearAnimation();
            this.jyy.clearAnimation();
            this.jyx.setVisibility(8);
            this.jyy.setVisibility(0);
            this.jyy.startAnimation(scaleAnimation2);
            this.jyx.startAnimation(scaleAnimation);
        }
    }

    private void cuy() {
        if (this.jyy != null && this.jyx != null) {
            this.jyx.clearAnimation();
            this.jyy.clearAnimation();
            this.jyx.setVisibility(0);
            this.jyy.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BO(int i) {
        int i2;
        if (bc.cE(getActivity()) && this.jyI != null) {
            if (i == this.jyo) {
                if ("1".equals(this.jyI.is_agreed)) {
                    i2 = 1;
                    this.jyI.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jyI.agree_num, 0) - 1);
                    this.jyI.is_agreed = "0";
                } else {
                    this.jyI.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jyI.agree_num, 0) + 1);
                    this.jyI.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.jyI.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jyI.agree_num, 0) + 1);
                this.jyI.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.bT("tid", this.jyI.thread_id);
            amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.jyo) {
                amVar.P("obj_type", i2);
            } else {
                amVar.P("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            cuC();
            if (this.jyL != null && i2 == 0) {
                this.jyL.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.jyI.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.jyI));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.jyI != null && !StringUtils.isNull(this.jyI.video_url)) {
            this.cDt = true;
            if (this.jyK) {
                aXy();
                bIu();
                if (this.jyI != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.bT("tid", this.jyI.thread_id);
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
        if (this.jyY != null && this.jyY.aqS() != null) {
            this.jyY.aqS().hide();
            this.jyN.setVisibility(0);
            this.jyO.setText(StringUtils.isNull(((c) this.jyY.aqS().kj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.jyY != null) {
            this.jyY.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.jyK = z;
        if (this.cDt) {
            if (this.jyK && (!this.jyX || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.jyI != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.bT("tid", this.jyI.thread_id);
                    amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.P("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                cuz();
                this.jyX = false;
                return;
            }
            cuy();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cuz() {
        if (this.jyI != null) {
            am amVar = new am("c12590");
            amVar.bT("tid", this.jyI.thread_id);
            amVar.bT("fid", this.jyI.forum_id);
            amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.P("obj_locate", this.jyR);
            amVar.bT("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.P("obj_param2", 1);
            amVar.bT("obj_param1", ap.isEmpty(this.jyI.mRecomWeight) ? "0" : this.jyI.mRecomWeight);
            amVar.bT("extra", ap.isEmpty(this.jyI.mRecomExtra) ? "0" : this.jyI.mRecomExtra);
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bFP);
            amVar.bT("ab_tag", ap.isEmpty(this.jyI.mRecomAbTag) ? "0" : this.jyI.mRecomAbTag);
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ap.isEmpty(this.jyI.mRecomSource) ? "0" : this.jyI.mRecomSource);
            amVar.bT("obj_type", this.dvf);
            amVar.P("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void Ft(String str) {
        if (this.jyq != null && str != null && !str.equals(this.bUZ)) {
            this.jyq.setRecoveryState(0);
            this.jyq.setVideoPath(str, this.jyI.thread_id);
            this.bUZ = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.cqS().cqT() || cuF()) {
            caO();
            if (this.jyE != null) {
                this.jyE.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.jyr.getVisibility() == 0) {
                this.jyr.clearAnimation();
                this.jyr.startAnimation(this.dnJ);
            }
            if (this.jyq != null) {
                this.jyq.start();
                aXy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        if (this.jyI != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.bVL = this.jyI.thread_id;
            zVar.eAC = this.jyI.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.jyI.mRecomSource;
            zVar.irh = this.jyI.mRecomAbTag;
            zVar.iri = this.jyI.mRecomWeight;
            zVar.irj = "";
            zVar.bFP = "";
            zVar.irl = this.jyI.mMd5;
            if (this.mRect != null) {
                zVar.irm = "1";
            } else {
                zVar.irm = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.irn = "1";
                zVar.mLocate = "auto_midpage";
                zVar.irj = "index";
            }
            com.baidu.tieba.play.l.a(this.jyI.mMd5, "", "1", zVar);
        }
    }

    private void caO() {
        if (com.baidu.adp.lib.util.j.jU()) {
            com.baidu.tieba.video.g.cqS().en(getContext());
        }
    }

    private void pausePlay() {
        if (this.jyq != null) {
            this.jyq.pause();
        }
    }

    private void stopPlay() {
        if (this.jyq != null) {
            this.jyq.setRecoveryState(5);
            this.jyq.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuA() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.jyI.thread_id, this.jyI.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.jyI.forum_id));
        createNormalCfg.setForumName(this.jyI.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuB() {
        if (this.bBz == null) {
            this.jyS = new com.baidu.tieba.view.a(getActivity());
            this.bBz = new e(getActivity(), this.jyS.afZ());
            this.bBz.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.jyq.setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.jyS != null) {
            ArrayList arrayList = new ArrayList();
            a.C0426a c0426a = new a.C0426a(this.jyS);
            c0426a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bBz.dismiss();
                    if (VideoPlayFragment.this.jyI != null) {
                        boolean z = VideoPlayFragment.this.jyI.post_id != null && VideoPlayFragment.this.jyI.post_id.equals(VideoPlayFragment.this.jyI.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.jyI.thread_id);
                        markData.setPostId(VideoPlayFragment.this.jyI.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.jyI.thread_id);
                        markData.setForumId(VideoPlayFragment.this.jyI.forum_id);
                        if (VideoPlayFragment.this.hEm != null) {
                            VideoPlayFragment.this.hEm.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.hEm.ZE();
                            } else {
                                VideoPlayFragment.this.hEm.ZD();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.jyI != null && this.jyI.post_id != null && this.jyI.post_id.equals(this.jyI.mark_id)) {
                z = true;
            }
            if (z) {
                c0426a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0426a.setText(getResources().getString(R.string.mark));
            }
            arrayList.add(c0426a);
            a.C0426a c0426a2 = new a.C0426a(getActivity().getString(R.string.delete), this.jyS);
            c0426a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bBz.dismiss();
                    if (bc.cE(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jyI != null) {
                        String str = VideoPlayFragment.this.jyI.thread_id;
                        String str2 = VideoPlayFragment.this.jyI.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.jyI.post_id, true)));
                    }
                }
            });
            c0426a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0426a2);
            if (this.fTR) {
                a.C0426a c0426a3 = new a.C0426a(getActivity().getString(R.string.delete), this.jyS);
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
                                if (VideoPlayFragment.this.jyI != null) {
                                    VideoPlayFragment.this.eyy.a(VideoPlayFragment.this.jyI.forum_id, VideoPlayFragment.this.jyI.forum_name, VideoPlayFragment.this.jyI.thread_id, VideoPlayFragment.this.jyI.post_id, 0, 0, VideoPlayFragment.this.fTR);
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
            this.jyS.W(arrayList);
        }
        this.bBz.show();
    }

    private void cuC() {
        if (this.jyI != null) {
            this.jyr.startLoad(this.jyI.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.jyI.title);
            if (StringUtils.isNull(this.jyI.title) || matcher.matches()) {
                this.jyz.setVisibility(8);
            } else {
                this.jyz.setVisibility(0);
                this.jyz.setText(this.jyI.title);
            }
            this.jyB.setText(ap.aN(com.baidu.adp.lib.g.b.c(this.jyI.comment_num, 0L)));
            this.jyC.setText(ap.aN(com.baidu.adp.lib.g.b.c(this.jyI.agree_num, 0L)));
            this.jyD.setText(ap.aN(com.baidu.adp.lib.g.b.c(this.jyI.share_num, 0L)));
            if (this.jyI.author_info != null) {
                if (!StringUtils.isNull(this.jyI.author_info.portrait) && this.jyI.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.jys.startLoad(this.jyI.author_info.portrait, 10, false);
                } else {
                    this.jys.startLoad(this.jyI.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.jyI.author_info.cqO())) {
                    this.jyM.setVisibility(8);
                } else {
                    this.jyM.setVisibility(0);
                    this.jyM.setText("@" + this.jyI.author_info.cqO());
                }
            }
            if ("1".equals(this.jyI.is_private) && this.jyJ.getVisibility() != 0) {
                this.jyH.setVisibility(0);
            } else {
                this.jyH.setVisibility(8);
            }
            if ("1".equals(this.jyI.is_agreed)) {
                al.c(this.jyL, (int) R.drawable.icon_card_like_white_full_s);
            } else {
                al.c(this.jyL, (int) R.drawable.btn_video_agree);
            }
            if (this.jyI.act_info != null && !StringUtils.isNull(this.jyI.act_info.activity_name) && this.jyJ.getVisibility() != 0) {
                this.jyG.setVisibility(0);
                this.jyA.setText(this.jyI.act_info.activity_name);
            } else {
                this.jyG.setVisibility(8);
            }
            cuD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuD() {
        if (this.fTR || (this.jyI.author_info != null && !"0".equals(this.jyI.author_info.is_follow))) {
            this.jyw.setVisibility(4);
            this.jyw.setClickable(false);
            return;
        }
        this.jyw.setVisibility(0);
        this.jyw.setClickable(true);
    }

    private void cuE() {
        if (getActivity() != null) {
            if (this.jyZ == null || !this.jyZ.isShowing()) {
                this.jyZ = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.jyZ.aF(inflate);
                this.jyZ.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.jyZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.jyZ.hr(1);
                this.jyZ.hp(R.color.cp_cont_b);
                this.jyZ.dM(true);
                this.jyZ.b(getPageContext());
                this.jyZ.afG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cuF() {
        if (!com.baidu.adp.lib.util.j.jS() || com.baidu.adp.lib.util.j.jT()) {
            return true;
        }
        if (!this.jyK || com.baidu.tieba.video.g.cqS().cqT()) {
            return false;
        }
        if (this.jyE != null) {
            this.jyE.setVisibility(0);
        }
        pausePlay();
        cuE();
        return false;
    }

    private void bIu() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cuF() || com.baidu.tieba.video.g.cqS().cqT()) && this.jyq != null && this.jyE != null) {
            this.jyq.start();
            this.jyE.setVisibility(8);
            caO();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.jyT == null) {
            this.jyT = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.jyT;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
    public void azb() {
        if (this.jyq.isPlaying()) {
            this.jyq.pause();
            this.jyE.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cuF() || com.baidu.tieba.video.g.cqS().cqT()) {
            this.jyq.start();
            this.jyE.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
    public void w(float f, float f2) {
        if (bc.cE(getActivity()) && !this.jyU) {
            cuG();
            if (this.jyI != null && "0".equals(this.jyI.is_agreed)) {
                BO(this.jyp);
            }
        }
    }

    private void cuG() {
        if (this.mRootView != null) {
            this.jyU = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.jyW == null) {
                this.jyW = new RelativeLayout.LayoutParams(-2, -2);
                this.jyW.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.jyW);
            }
            if (this.jyV == null) {
                this.jyV = new AnimatorSet();
                this.jyV.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.jyU = false;
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
            this.jyV.setTarget(imageView);
            this.jyV.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.jyV.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
    public void azc() {
        if (this.jyI != null && this.jyI.author_info != null) {
            long c = com.baidu.adp.lib.g.b.c(this.jyI.author_info.user_id, 0L);
            long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = c == c2;
            if (c == 0 && c2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(c, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.jyq != null) {
            return this.jyq.getMediaIDs();
        }
        return null;
    }

    public String cuH() {
        if (this.jyq != null) {
            return this.jyq.getMediaId();
        }
        return null;
    }

    public boolean cuI() {
        if (this.jyY == null || this.jyY.aqS() == null || !this.jyY.aqS().isVisible()) {
            return false;
        }
        this.jyY.aqS().hide();
        this.jyN.setVisibility(0);
        if ((this.jyY.aqS().kj(28) instanceof c) && ((c) this.jyY.aqS().kj(28)).getInputView() != null && ((c) this.jyY.aqS().kj(28)).getInputView().getText() != null) {
            this.jyO.setText(StringUtils.isNull(((c) this.jyY.aqS().kj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.jyY != null) {
            this.jyY.onActivityResult(i, i2, intent);
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
        if (this.jyY != null && this.jyY.aqS() != null) {
            this.jyY.aqS().onChangeSkinType(i);
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
