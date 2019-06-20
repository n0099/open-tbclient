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
    private e bBB;
    private String bFQ;
    private String bVa;
    private boolean cDu;
    public ImageView djy;
    private n dlO;
    private AlphaAnimation dnJ;
    private String dvf;
    private boolean fTT;
    private View feU;
    private j.b ioQ;
    private QuickVideoView.c iph;
    public ImageView jyA;
    public ImageView jyB;
    public TextView jyC;
    public TextView jyD;
    public TextView jyE;
    public TextView jyF;
    public TextView jyG;
    public ImageView jyH;
    private LinearLayout jyI;
    public LinearLayout jyJ;
    public LinearLayout jyK;
    public VideoItemData jyL;
    private TextView jyM;
    private boolean jyN;
    public ImageView jyO;
    public TextView jyP;
    private View jyQ;
    private TextView jyR;
    private int jyS;
    private int jyT;
    private int jyU;
    private com.baidu.tieba.view.a jyV;
    protected Animation jyW;
    private boolean jyX;
    private AnimatorSet jyY;
    private RelativeLayout.LayoutParams jyZ;
    public QuickVideoView jyt;
    private TbImageView jyu;
    public HeadImageView jyv;
    public LinearLayout jyw;
    public LinearLayout jyx;
    public LinearLayout jyy;
    public ImageView jyz;
    private com.baidu.tieba.videoplay.editor.a jzb;
    com.baidu.tbadk.core.dialog.a jzc;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int jyr = 0;
    private int jys = 1;
    private ForumManageModel eyy = null;
    private com.baidu.tbadk.baseEditMark.a hEn = null;
    private com.baidu.tbadk.coreExtra.model.a bSm = null;
    private BdUniqueId Xj = BdUniqueId.gen();
    private boolean jza = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.jyL != null && VideoPlayFragment.this.jyL.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jyL.author_info.user_id) && data != null && VideoPlayFragment.this.jyL.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.Xj)) ? false : false;
                    if (data.cgA == null) {
                        if (!data.Hh) {
                            if (z && !"0".equals(VideoPlayFragment.this.jyL.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.jyL.author_info.is_follow = "0";
                                VideoPlayFragment.this.cuC();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.jyN) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.jyL));
                                    return;
                                }
                                VideoPlayFragment.this.jyL.author_info.is_follow = "1";
                                VideoPlayFragment.this.cuC();
                            }
                        } else {
                            VideoPlayFragment.this.jyL.author_info.is_follow = "0";
                            VideoPlayFragment.this.cuC();
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
                VideoPlayFragment.this.cuE();
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
        this.jyL = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.jyU = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.dvf = arguments.getString("from");
        this.bFQ = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.jyL != null && this.jyL.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.jyL.author_info.user_id)) {
            this.fTT = true;
        }
        this.dlO = new n(getActivity());
        this.dlO.a(this.jyL);
        this.dlO.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bc(int i, int i2) {
                if (VideoPlayFragment.this.ioQ != null) {
                    VideoPlayFragment.this.ioQ.bc(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.jyt = (QuickVideoView) this.mRootView.findViewById(R.id.videoView);
        this.jyt.setPlayerReuseEnable(true);
        this.jyt.setContinuePlayEnable(true);
        this.jyt.setBusiness(this.dlO);
        this.jyt.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.iph != null) {
                    VideoPlayFragment.this.iph.onStart();
                }
            }
        });
        this.jyt.setNeedRecovery(true);
        if (this.jyL != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.bVM = this.jyL.thread_id;
            zVar.eAC = this.jyL.forum_id;
            zVar.irm = this.jyL.mMd5;
            zVar.bFQ = "";
            zVar.mSource = this.jyL.mRecomSource;
            zVar.irl = this.jyL.mRecomAbTag;
            zVar.irj = this.jyL.mRecomWeight;
            if (this.mRect != null) {
                zVar.irn = "1";
            } else {
                zVar.irn = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.iro = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.irk = this.dvf;
                zVar.bFQ = this.bFQ;
                zVar.iri = this.jyL.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.dlO.setVideoStatsData(zVar);
        }
        this.jyu = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.jyu.setDefaultBgResource(R.drawable.icon_play_bg);
        this.jyu.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.agW()) {
            this.feU = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.feU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.feU.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.djy = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.jyv = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.jyv.setDefaultResource(17170445);
        this.jyv.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jyv.setIsRound(true);
        this.jyz = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.jyO = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.jyC = (TextView) this.mRootView.findViewById(R.id.video_title);
        this.jyD = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.jyx = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.jyE = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.jyw = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.jyF = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.jyG = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.jyA = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.jyB = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cux();
        this.jyH = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.jyI = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.jyJ = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.jyK = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.jyy = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.jyP = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.jyQ = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.jyQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.jyQ.setVisibility(4);
                    if (VideoPlayFragment.this.jzb != null && VideoPlayFragment.this.jzb.aqS() != null) {
                        VideoPlayFragment.this.jzb.aqS().pO();
                    }
                    if (VideoPlayFragment.this.jyL != null) {
                        am amVar = new am("c13025");
                        amVar.bT("tid", VideoPlayFragment.this.jyL.thread_id);
                        amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.bT("fid", VideoPlayFragment.this.jyL.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.jyR = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.jyM = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.jyM.setVisibility(8);
        String string = b.agM().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jyM.setText(string);
        }
        final String string2 = b.agM().getString("nani_key_download_link_url", null);
        this.jyM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aiz().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cuB();
        this.jyv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jyL != null && VideoPlayFragment.this.jyL.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jyL.author_info.user_id) && VideoPlayFragment.this.jyL != null && VideoPlayFragment.this.jyL.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyL.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(c, z, false)));
                    am amVar = new am("c12798");
                    amVar.bT("tid", VideoPlayFragment.this.jyL.thread_id);
                    amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.jyJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jyL != null && VideoPlayFragment.this.jyL.act_info != null) {
                    com.baidu.tbadk.browser.a.ag(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.jyL.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.bT("tid", VideoPlayFragment.this.jyL.thread_id);
                    amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.jyC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cuz();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jyL != null && !StringUtils.isNull(VideoPlayFragment.this.jyL.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.jyL.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.djy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cuA();
            }
        });
        this.jyx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cuz();
                am amVar = new am("c12796");
                amVar.bT("tid", VideoPlayFragment.this.jyL.thread_id);
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.jyw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.BO(VideoPlayFragment.this.jyr);
            }
        });
        this.jyy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.ajT();
                am amVar = new am("c12797");
                amVar.bT("tid", VideoPlayFragment.this.jyL.thread_id);
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.jyz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cE(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jyL != null && VideoPlayFragment.this.jyL.author_info != null) {
                    VideoPlayFragment.this.bSm.a(true, VideoPlayFragment.this.jyL.author_info.portrait, VideoPlayFragment.this.jyL.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.Xj, VideoPlayFragment.this.jyL.forum_id, "0");
                    VideoPlayFragment.this.jyL.author_info.is_follow = "1";
                    VideoPlayFragment.this.cuC();
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
                if (VideoPlayFragment.this.jyu != null) {
                    VideoPlayFragment.this.jyu.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.jyS = this.mRect.right - this.mRect.left;
            this.jyT = this.mRect.bottom - this.mRect.top;
            this.jyu.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.jyu.getWidth();
                    int height = VideoPlayFragment.this.jyu.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jyL.video_height, 0) > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jyL.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyL.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyL.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jyS, VideoPlayFragment.this.jyT);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.jyu.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jyT > 0 || VideoPlayFragment.this.jyS <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.jyS;
                                f = i / VideoPlayFragment.this.jyT;
                            }
                            VideoPlayFragment.this.jyu.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.jyu.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.jyN) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jyS, VideoPlayFragment.this.jyT);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.jyu.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jyT > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.jyu.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.jyu.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.jyN) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.jyu.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.jyu.getWidth();
                    int height = VideoPlayFragment.this.jyu.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jyL.video_height, 0) > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jyL.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyL.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyL.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.jyu.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.jyu.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.jyN) {
            cuy();
        }
        if (this.jyL != null && !StringUtils.isNull(this.jyL.video_url)) {
            Fv(this.jyL.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.ioQ = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.iph = cVar;
    }

    private void initEditor() {
        this.jzb = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().cJ(getActivity());
        if (this.jzb != null && this.jyL != null) {
            this.jzb.a(getPageContext());
            this.jzb.ad(this.jyL.thread_id, this.jyL.forum_id, this.jyL.forum_name);
            this.jzb.a(new a.InterfaceC0425a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0425a
                public void rD(boolean z) {
                    VideoPlayFragment.this.jyQ.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.jyR.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.jyR.setText(StringUtils.isNull(((c) VideoPlayFragment.this.jzb.aqS().kj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.jyL != null && z) {
                        long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jyL.comment_num, 0L) + 1;
                        VideoPlayFragment.this.jyL.comment_num = String.valueOf(c);
                        VideoPlayFragment.this.jyE.setText(ap.aN(c));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.jzb.aqS(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajT() {
        if (this.jyL != null) {
            String str = this.jyL.forum_id;
            String str2 = this.jyL.forum_name;
            String str3 = this.jyL.title;
            String str4 = this.jyL.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.jyL.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str3;
            eVar.content = format;
            eVar.cjD = "";
            eVar.linkUrl = str5;
            eVar.bLt = 2;
            eVar.extData = str4;
            eVar.cjG = 3;
            eVar.fid = str;
            eVar.cjx = str2;
            eVar.tid = str4;
            eVar.cjq = true;
            eVar.cjF = 0;
            eVar.cjK = 2;
            if (parse != null) {
                eVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.jyL.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.jyL.title;
            originalThreadInfo.threadId = this.jyL.thread_id;
            eVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.cjG);
            bundle.putInt("obj_type", eVar.cjK);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bLt);
            eVar.E(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), eVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.aZC().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fTT) {
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
        this.hEn = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.hEn != null) {
            this.hEn.a(new a.InterfaceC0236a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0236a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.hEn != null) {
                            VideoPlayFragment.this.hEn.ds(z2);
                        }
                        if (VideoPlayFragment.this.jyL != null) {
                            if (z2) {
                                VideoPlayFragment.this.jyL.mark_id = VideoPlayFragment.this.jyL.post_id;
                            } else {
                                VideoPlayFragment.this.jyL.mark_id = null;
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
        this.bSm = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.jza = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cuB();
        if (Build.VERSION.SDK_INT >= 17) {
            this.jyt.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.jyN && i == 3 && VideoPlayFragment.this.jyu.getVisibility() == 0) {
                        VideoPlayFragment.this.jyu.clearAnimation();
                        VideoPlayFragment.this.jyu.startAnimation(VideoPlayFragment.this.dnJ);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.jyt.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.jyt != null) {
                    VideoPlayFragment.this.jyt.seekTo(0);
                    VideoPlayFragment.this.jyt.start();
                    VideoPlayFragment.this.aXy();
                    VideoPlayFragment.x(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.cuw();
                    }
                }
            }
        });
        this.jyt.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.jyu != null) {
                        VideoPlayFragment.this.jyu.clearAnimation();
                        VideoPlayFragment.this.jyu.startAnimation(VideoPlayFragment.this.dnJ);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuw() {
        if (this.jyB != null && this.jyA != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.jyA.clearAnimation();
            this.jyB.clearAnimation();
            this.jyA.setVisibility(8);
            this.jyB.setVisibility(0);
            this.jyB.startAnimation(scaleAnimation2);
            this.jyA.startAnimation(scaleAnimation);
        }
    }

    private void cux() {
        if (this.jyB != null && this.jyA != null) {
            this.jyA.clearAnimation();
            this.jyB.clearAnimation();
            this.jyA.setVisibility(0);
            this.jyB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BO(int i) {
        int i2;
        if (bc.cE(getActivity()) && this.jyL != null) {
            if (i == this.jyr) {
                if ("1".equals(this.jyL.is_agreed)) {
                    i2 = 1;
                    this.jyL.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jyL.agree_num, 0) - 1);
                    this.jyL.is_agreed = "0";
                } else {
                    this.jyL.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jyL.agree_num, 0) + 1);
                    this.jyL.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.jyL.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jyL.agree_num, 0) + 1);
                this.jyL.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.bT("tid", this.jyL.thread_id);
            amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.jyr) {
                amVar.P("obj_type", i2);
            } else {
                amVar.P("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            cuB();
            if (this.jyO != null && i2 == 0) {
                this.jyO.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.jyL.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.jyL));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.jyL != null && !StringUtils.isNull(this.jyL.video_url)) {
            this.cDu = true;
            if (this.jyN) {
                aXy();
                bIv();
                if (this.jyL != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.bT("tid", this.jyL.thread_id);
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
        if (this.jzb != null && this.jzb.aqS() != null) {
            this.jzb.aqS().hide();
            this.jyQ.setVisibility(0);
            this.jyR.setText(StringUtils.isNull(((c) this.jzb.aqS().kj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.jzb != null) {
            this.jzb.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.jyN = z;
        if (this.cDu) {
            if (this.jyN && (!this.jza || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.jyL != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.bT("tid", this.jyL.thread_id);
                    amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.P("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                cuy();
                this.jza = false;
                return;
            }
            cux();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cuy() {
        if (this.jyL != null) {
            am amVar = new am("c12590");
            amVar.bT("tid", this.jyL.thread_id);
            amVar.bT("fid", this.jyL.forum_id);
            amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.P("obj_locate", this.jyU);
            amVar.bT("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.P("obj_param2", 1);
            amVar.bT("obj_param1", ap.isEmpty(this.jyL.mRecomWeight) ? "0" : this.jyL.mRecomWeight);
            amVar.bT("extra", ap.isEmpty(this.jyL.mRecomExtra) ? "0" : this.jyL.mRecomExtra);
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bFQ);
            amVar.bT("ab_tag", ap.isEmpty(this.jyL.mRecomAbTag) ? "0" : this.jyL.mRecomAbTag);
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ap.isEmpty(this.jyL.mRecomSource) ? "0" : this.jyL.mRecomSource);
            amVar.bT("obj_type", this.dvf);
            amVar.P("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void Fv(String str) {
        if (this.jyt != null && str != null && !str.equals(this.bVa)) {
            this.jyt.setRecoveryState(0);
            this.jyt.setVideoPath(str, this.jyL.thread_id);
            this.bVa = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.cqT().cqU() || cuE()) {
            caP();
            if (this.jyH != null) {
                this.jyH.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.jyu.getVisibility() == 0) {
                this.jyu.clearAnimation();
                this.jyu.startAnimation(this.dnJ);
            }
            if (this.jyt != null) {
                this.jyt.start();
                aXy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        if (this.jyL != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.bVM = this.jyL.thread_id;
            zVar.eAC = this.jyL.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.jyL.mRecomSource;
            zVar.iri = this.jyL.mRecomAbTag;
            zVar.irj = this.jyL.mRecomWeight;
            zVar.irk = "";
            zVar.bFQ = "";
            zVar.irm = this.jyL.mMd5;
            if (this.mRect != null) {
                zVar.irn = "1";
            } else {
                zVar.irn = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.iro = "1";
                zVar.mLocate = "auto_midpage";
                zVar.irk = "index";
            }
            com.baidu.tieba.play.l.a(this.jyL.mMd5, "", "1", zVar);
        }
    }

    private void caP() {
        if (com.baidu.adp.lib.util.j.jU()) {
            com.baidu.tieba.video.g.cqT().en(getContext());
        }
    }

    private void pausePlay() {
        if (this.jyt != null) {
            this.jyt.pause();
        }
    }

    private void stopPlay() {
        if (this.jyt != null) {
            this.jyt.setRecoveryState(5);
            this.jyt.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuz() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.jyL.thread_id, this.jyL.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.jyL.forum_id));
        createNormalCfg.setForumName(this.jyL.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuA() {
        if (this.bBB == null) {
            this.jyV = new com.baidu.tieba.view.a(getActivity());
            this.bBB = new e(getActivity(), this.jyV.afZ());
            this.bBB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.jyt.setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.jyV != null) {
            ArrayList arrayList = new ArrayList();
            a.C0426a c0426a = new a.C0426a(this.jyV);
            c0426a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bBB.dismiss();
                    if (VideoPlayFragment.this.jyL != null) {
                        boolean z = VideoPlayFragment.this.jyL.post_id != null && VideoPlayFragment.this.jyL.post_id.equals(VideoPlayFragment.this.jyL.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.jyL.thread_id);
                        markData.setPostId(VideoPlayFragment.this.jyL.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.jyL.thread_id);
                        markData.setForumId(VideoPlayFragment.this.jyL.forum_id);
                        if (VideoPlayFragment.this.hEn != null) {
                            VideoPlayFragment.this.hEn.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.hEn.ZE();
                            } else {
                                VideoPlayFragment.this.hEn.ZD();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.jyL != null && this.jyL.post_id != null && this.jyL.post_id.equals(this.jyL.mark_id)) {
                z = true;
            }
            if (z) {
                c0426a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0426a.setText(getResources().getString(R.string.mark));
            }
            arrayList.add(c0426a);
            a.C0426a c0426a2 = new a.C0426a(getActivity().getString(R.string.delete), this.jyV);
            c0426a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bBB.dismiss();
                    if (bc.cE(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jyL != null) {
                        String str = VideoPlayFragment.this.jyL.thread_id;
                        String str2 = VideoPlayFragment.this.jyL.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.jyL.post_id, true)));
                    }
                }
            });
            c0426a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0426a2);
            if (this.fTT) {
                a.C0426a c0426a3 = new a.C0426a(getActivity().getString(R.string.delete), this.jyV);
                c0426a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.bBB.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.ho(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.jyL != null) {
                                    VideoPlayFragment.this.eyy.a(VideoPlayFragment.this.jyL.forum_id, VideoPlayFragment.this.jyL.forum_name, VideoPlayFragment.this.jyL.thread_id, VideoPlayFragment.this.jyL.post_id, 0, 0, VideoPlayFragment.this.fTT);
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
            this.jyV.W(arrayList);
        }
        this.bBB.show();
    }

    private void cuB() {
        if (this.jyL != null) {
            this.jyu.startLoad(this.jyL.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.jyL.title);
            if (StringUtils.isNull(this.jyL.title) || matcher.matches()) {
                this.jyC.setVisibility(8);
            } else {
                this.jyC.setVisibility(0);
                this.jyC.setText(this.jyL.title);
            }
            this.jyE.setText(ap.aN(com.baidu.adp.lib.g.b.c(this.jyL.comment_num, 0L)));
            this.jyF.setText(ap.aN(com.baidu.adp.lib.g.b.c(this.jyL.agree_num, 0L)));
            this.jyG.setText(ap.aN(com.baidu.adp.lib.g.b.c(this.jyL.share_num, 0L)));
            if (this.jyL.author_info != null) {
                if (!StringUtils.isNull(this.jyL.author_info.portrait) && this.jyL.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.jyv.startLoad(this.jyL.author_info.portrait, 10, false);
                } else {
                    this.jyv.startLoad(this.jyL.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.jyL.author_info.cqP())) {
                    this.jyP.setVisibility(8);
                } else {
                    this.jyP.setVisibility(0);
                    this.jyP.setText("@" + this.jyL.author_info.cqP());
                }
            }
            if ("1".equals(this.jyL.is_private) && this.jyM.getVisibility() != 0) {
                this.jyK.setVisibility(0);
            } else {
                this.jyK.setVisibility(8);
            }
            if ("1".equals(this.jyL.is_agreed)) {
                al.c(this.jyO, (int) R.drawable.icon_card_like_white_full_s);
            } else {
                al.c(this.jyO, (int) R.drawable.btn_video_agree);
            }
            if (this.jyL.act_info != null && !StringUtils.isNull(this.jyL.act_info.activity_name) && this.jyM.getVisibility() != 0) {
                this.jyJ.setVisibility(0);
                this.jyD.setText(this.jyL.act_info.activity_name);
            } else {
                this.jyJ.setVisibility(8);
            }
            cuC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuC() {
        if (this.fTT || (this.jyL.author_info != null && !"0".equals(this.jyL.author_info.is_follow))) {
            this.jyz.setVisibility(4);
            this.jyz.setClickable(false);
            return;
        }
        this.jyz.setVisibility(0);
        this.jyz.setClickable(true);
    }

    private void cuD() {
        if (getActivity() != null) {
            if (this.jzc == null || !this.jzc.isShowing()) {
                this.jzc = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.jzc.aF(inflate);
                this.jzc.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.jzc.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.jzc.hr(1);
                this.jzc.hp(R.color.cp_cont_b);
                this.jzc.dM(true);
                this.jzc.b(getPageContext());
                this.jzc.afG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cuE() {
        if (!com.baidu.adp.lib.util.j.jS() || com.baidu.adp.lib.util.j.jT()) {
            return true;
        }
        if (!this.jyN || com.baidu.tieba.video.g.cqT().cqU()) {
            return false;
        }
        if (this.jyH != null) {
            this.jyH.setVisibility(0);
        }
        pausePlay();
        cuD();
        return false;
    }

    private void bIv() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cuE() || com.baidu.tieba.video.g.cqT().cqU()) && this.jyt != null && this.jyH != null) {
            this.jyt.start();
            this.jyH.setVisibility(8);
            caP();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.jyW == null) {
            this.jyW = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.jyW;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
    public void azb() {
        if (this.jyt.isPlaying()) {
            this.jyt.pause();
            this.jyH.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cuE() || com.baidu.tieba.video.g.cqT().cqU()) {
            this.jyt.start();
            this.jyH.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
    public void w(float f, float f2) {
        if (bc.cE(getActivity()) && !this.jyX) {
            cuF();
            if (this.jyL != null && "0".equals(this.jyL.is_agreed)) {
                BO(this.jys);
            }
        }
    }

    private void cuF() {
        if (this.mRootView != null) {
            this.jyX = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.jyZ == null) {
                this.jyZ = new RelativeLayout.LayoutParams(-2, -2);
                this.jyZ.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.jyZ);
            }
            if (this.jyY == null) {
                this.jyY = new AnimatorSet();
                this.jyY.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.jyX = false;
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
            this.jyY.setTarget(imageView);
            this.jyY.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.jyY.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
    public void azc() {
        if (this.jyL != null && this.jyL.author_info != null) {
            long c = com.baidu.adp.lib.g.b.c(this.jyL.author_info.user_id, 0L);
            long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = c == c2;
            if (c == 0 && c2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(c, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.jyt != null) {
            return this.jyt.getMediaIDs();
        }
        return null;
    }

    public String cuG() {
        if (this.jyt != null) {
            return this.jyt.getMediaId();
        }
        return null;
    }

    public boolean cuH() {
        if (this.jzb == null || this.jzb.aqS() == null || !this.jzb.aqS().isVisible()) {
            return false;
        }
        this.jzb.aqS().hide();
        this.jyQ.setVisibility(0);
        if ((this.jzb.aqS().kj(28) instanceof c) && ((c) this.jzb.aqS().kj(28)).getInputView() != null && ((c) this.jzb.aqS().kj(28)).getInputView().getText() != null) {
            this.jyR.setText(StringUtils.isNull(((c) this.jzb.aqS().kj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.jzb != null) {
            this.jzb.onActivityResult(i, i2, intent);
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
        if (this.jzb != null && this.jzb.aqS() != null) {
            this.jzb.aqS().onChangeSkinType(i);
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
