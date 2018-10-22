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
import com.baidu.tieba.play.y;
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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0146a {
    private boolean UG;
    private String aAy;
    private e aiP;
    private String amT;
    public ImageView bHw;
    private n bJP;
    private AlphaAnimation bNq;
    private String bQf;
    private com.baidu.tieba.view.a cNN;
    private View dqH;
    private boolean eeV;
    private j.b gua;
    private QuickVideoView.c guq;
    public QuickVideoView hBT;
    private TbImageView hBU;
    public HeadImageView hBV;
    public LinearLayout hBW;
    public LinearLayout hBX;
    public LinearLayout hBY;
    public ImageView hBZ;
    private com.baidu.tieba.videoplay.editor.a hCA;
    com.baidu.tbadk.core.dialog.a hCB;
    public ImageView hCa;
    public ImageView hCb;
    public TextView hCc;
    public TextView hCd;
    public TextView hCe;
    public TextView hCf;
    public TextView hCg;
    public ImageView hCh;
    private LinearLayout hCi;
    public LinearLayout hCj;
    public LinearLayout hCk;
    public VideoItemData hCl;
    private TextView hCm;
    private boolean hCn;
    public ImageView hCo;
    public TextView hCp;
    private View hCq;
    private TextView hCr;
    private int hCs;
    private int hCt;
    private int hCu;
    protected Animation hCv;
    private boolean hCw;
    private AnimatorSet hCx;
    private RelativeLayout.LayoutParams hCy;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int hBR = 0;
    private int hBS = 1;
    private ForumManageModel cNV = null;
    private com.baidu.tbadk.baseEditMark.a fKH = null;
    private com.baidu.tbadk.coreExtra.model.a axO = null;
    private BdUniqueId axF = BdUniqueId.gen();
    private boolean hCz = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.hCl != null && VideoPlayFragment.this.hCl.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hCl.author_info.user_id) && data != null && VideoPlayFragment.this.hCl.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.axF)) ? false : false;
                    if (data.aLc == null) {
                        if (!data.Jo) {
                            if (z && !"0".equals(VideoPlayFragment.this.hCl.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_fail);
                                VideoPlayFragment.this.hCl.author_info.is_follow = "0";
                                VideoPlayFragment.this.bJU();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.hCn) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.hCl));
                                    return;
                                }
                                VideoPlayFragment.this.hCl.author_info.is_follow = "1";
                                VideoPlayFragment.this.bJU();
                            }
                        } else {
                            VideoPlayFragment.this.hCl.author_info.is_follow = "0";
                            VideoPlayFragment.this.bJU();
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
                VideoPlayFragment.this.bJW();
            }
        }
    };

    static /* synthetic */ int y(VideoPlayFragment videoPlayFragment) {
        int i = videoPlayFragment.playTime;
        videoPlayFragment.playTime = i + 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.hCl = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hCu = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.bQf = arguments.getString("from");
        this.amT = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.hCl != null && this.hCl.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hCl.author_info.user_id)) {
            this.eeV = true;
        }
        this.bJP = new n(getActivity());
        this.bJP.a(this.hCl);
        this.bJP.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bC(int i, int i2) {
                if (VideoPlayFragment.this.gua != null) {
                    VideoPlayFragment.this.gua.bC(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(e.h.video_play_view, (ViewGroup) null);
        this.hBT = (QuickVideoView) this.mRootView.findViewById(e.g.videoView);
        this.hBT.setPlayerReuseEnable(true);
        this.hBT.setContinuePlayEnable(true);
        this.hBT.setBusiness(this.bJP);
        this.hBT.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.guq != null) {
                    VideoPlayFragment.this.guq.onStart();
                }
            }
        });
        this.hBT.setNeedRecovery(true);
        if (this.hCl != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.beh = this.hCl.thread_id;
            zVar.cQb = this.hCl.forum_id;
            zVar.gwA = this.hCl.mMd5;
            zVar.amT = "";
            zVar.mSource = this.hCl.mRecomSource;
            zVar.gwz = this.hCl.mRecomAbTag;
            zVar.gwx = this.hCl.mRecomWeight;
            if (this.mRect != null) {
                zVar.gwB = "1";
            } else {
                zVar.gwB = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.gwC = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.gwy = this.bQf;
                zVar.amT = this.amT;
                zVar.gww = this.hCl.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.bJP.setVideoStatsData(zVar);
        }
        this.hBU = (TbImageView) this.mRootView.findViewById(e.g.video_cover);
        this.hBU.setDefaultBgResource(e.f.icon_play_bg);
        this.hBU.setDefaultErrorResource(e.f.icon_play_bg);
        if (g.Bu()) {
            this.dqH = this.mRootView.findViewById(e.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.dqH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dqH.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(e.g.back_btn);
        this.bHw = (ImageView) this.mRootView.findViewById(e.g.more_btn);
        this.hBV = (HeadImageView) this.mRootView.findViewById(e.g.author_portrait);
        this.hBV.setDefaultResource(17170445);
        this.hBV.setDefaultBgResource(e.d.cp_bg_line_e);
        this.hBV.setIsRound(true);
        this.hBZ = (ImageView) this.mRootView.findViewById(e.g.love_btn);
        this.hCo = (ImageView) this.mRootView.findViewById(e.g.agree_img);
        this.hCc = (TextView) this.mRootView.findViewById(e.g.video_title);
        this.hCd = (TextView) this.mRootView.findViewById(e.g.video_activity);
        this.hBX = (LinearLayout) this.mRootView.findViewById(e.g.comment_container);
        this.hCe = (TextView) this.mRootView.findViewById(e.g.comment_num);
        this.hBW = (LinearLayout) this.mRootView.findViewById(e.g.agree_container);
        this.hCf = (TextView) this.mRootView.findViewById(e.g.agree_num);
        this.hCg = (TextView) this.mRootView.findViewById(e.g.share_num);
        this.hCa = (ImageView) this.mRootView.findViewById(e.g.share_img);
        this.hCb = (ImageView) this.mRootView.findViewById(e.g.share_img_changed);
        bJP();
        this.hCh = (ImageView) this.mRootView.findViewById(e.g.play_btn);
        this.hCi = (LinearLayout) this.mRootView.findViewById(e.g.video_act_private_container);
        this.hCj = (LinearLayout) this.mRootView.findViewById(e.g.video_activity_container);
        this.hCk = (LinearLayout) this.mRootView.findViewById(e.g.video_private);
        this.hBY = (LinearLayout) this.mRootView.findViewById(e.g.share_container);
        this.hCp = (TextView) this.mRootView.findViewById(e.g.video_author_name);
        this.hCq = this.mRootView.findViewById(e.g.quick_reply_comment_layout);
        this.hCq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.hCq.setVisibility(4);
                    if (VideoPlayFragment.this.hCA != null && VideoPlayFragment.this.hCA.KH() != null) {
                        VideoPlayFragment.this.hCA.KH().pQ();
                    }
                    if (VideoPlayFragment.this.hCl != null) {
                        am amVar = new am("c13025");
                        amVar.ax("tid", VideoPlayFragment.this.hCl.thread_id);
                        amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.ax(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.hCl.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.hCr = (TextView) this.mRootView.findViewById(e.g.quick_reply_comment_text);
        this.hCm = (TextView) this.mRootView.findViewById(e.g.download_nani_guide_txt);
        this.hCm.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hCm.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.hCm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.CU().a((TbPageContext) i.aK(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bJT();
        this.hBV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hCl != null && VideoPlayFragment.this.hCl.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hCl.author_info.user_id) && VideoPlayFragment.this.hCl != null && VideoPlayFragment.this.hCl.author_info != null) {
                    long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.hCl.author_info.user_id, 0L);
                    long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = d == d2;
                    if (d == 0 && d2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(d, z, false)));
                    am amVar = new am("c12798");
                    amVar.ax("tid", VideoPlayFragment.this.hCl.thread_id);
                    amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hCj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hCl != null && VideoPlayFragment.this.hCl.act_info != null) {
                    com.baidu.tbadk.browser.a.ag(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.hCl.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.ax("tid", VideoPlayFragment.this.hCl.thread_id);
                    amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hCc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bJR();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hCl != null && !StringUtils.isNull(VideoPlayFragment.this.hCl.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.hCl.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.bHw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bJS();
            }
        });
        this.hBX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bJR();
                am amVar = new am("c12796");
                amVar.ax("tid", VideoPlayFragment.this.hCl.thread_id);
                amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hBW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.vS(VideoPlayFragment.this.hBR);
            }
        });
        this.hBY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Eb();
                am amVar = new am("c12797");
                amVar.ax("tid", VideoPlayFragment.this.hCl.thread_id);
                amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hBZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bI(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hCl != null && VideoPlayFragment.this.hCl.author_info != null) {
                    VideoPlayFragment.this.axO.a(true, VideoPlayFragment.this.hCl.author_info.portrait, VideoPlayFragment.this.hCl.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.axF, VideoPlayFragment.this.hCl.forum_id, "0");
                    VideoPlayFragment.this.hCl.author_info.is_follow = "1";
                    VideoPlayFragment.this.bJU();
                }
            }
        });
        this.bNq = new AlphaAnimation(1.0f, 0.0f);
        this.bNq.setDuration(100L);
        this.bNq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.hBU != null) {
                    VideoPlayFragment.this.hBU.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.hCs = this.mRect.right - this.mRect.left;
            this.hCt = this.mRect.bottom - this.mRect.top;
            this.hBU.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.hBU.getWidth();
                    int height = VideoPlayFragment.this.hBU.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hCl.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hCl.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hCl.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hCl.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hCs, VideoPlayFragment.this.hCt);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.hBU.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hCt > 0 || VideoPlayFragment.this.hCs <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.hCs;
                                f = i / VideoPlayFragment.this.hCt;
                            }
                            VideoPlayFragment.this.hBU.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.hBU.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.hCn) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hCs, VideoPlayFragment.this.hCt);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.hBU.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hCt > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.hBU.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.hBU.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.hCn) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.hBU.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.hBU.getWidth();
                    int height = VideoPlayFragment.this.hBU.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hCl.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hCl.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hCl.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hCl.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.hBU.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.hBU.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.hCn) {
            bJQ();
        }
        if (this.hCl != null && !StringUtils.isNull(this.hCl.video_url)) {
            ww(this.hCl.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.gua = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.guq = cVar;
    }

    private void initEditor() {
        this.hCA = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().bM(getActivity());
        if (this.hCA != null && this.hCl != null) {
            this.hCA.setContext(getPageContext());
            this.hCA.Q(this.hCl.thread_id, this.hCl.forum_id, this.hCl.forum_name);
            this.hCA.a(new a.InterfaceC0291a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0291a
                public void nT(boolean z) {
                    VideoPlayFragment.this.hCq.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.hCr.setText(e.j.reply_something);
                    } else {
                        VideoPlayFragment.this.hCr.setText(StringUtils.isNull(((c) VideoPlayFragment.this.hCA.KH().fi(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.hCl != null && z) {
                        long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.hCl.comment_num, 0L) + 1;
                        VideoPlayFragment.this.hCl.comment_num = String.valueOf(d);
                        VideoPlayFragment.this.hCe.setText(ao.N(d));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.hCA.KH(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eb() {
        if (this.hCl != null) {
            String str = this.hCl.forum_id;
            String str2 = this.hCl.forum_name;
            String str3 = this.hCl.title;
            String str4 = this.hCl.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hCl.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            d dVar = new d();
            dVar.title = str3;
            dVar.content = format;
            dVar.aNU = "";
            dVar.linkUrl = str5;
            dVar.arx = 2;
            dVar.extData = str4;
            dVar.aNX = 3;
            dVar.fid = str;
            dVar.aNQ = str2;
            dVar.tid = str4;
            dVar.aNM = true;
            dVar.aNW = 0;
            dVar.aNY = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hCl.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hCl.title;
            originalThreadInfo.threadId = this.hCl.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aNX);
            bundle.putInt("obj_type", dVar.aNY);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.arx);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.aqb().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eeV) {
            this.cNV = new ForumManageModel(getPageContext());
            this.cNV.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.cNV.getLoadDataMode()) {
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
        this.fKH = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.fKH != null) {
            this.fKH.a(new a.InterfaceC0120a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0120a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.fKH != null) {
                            VideoPlayFragment.this.fKH.ay(z2);
                        }
                        if (VideoPlayFragment.this.hCl != null) {
                            if (z2) {
                                VideoPlayFragment.this.hCl.mark_id = VideoPlayFragment.this.hCl.post_id;
                            } else {
                                VideoPlayFragment.this.hCl.mark_id = null;
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
        this.axO = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.hCz = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bJT();
        if (Build.VERSION.SDK_INT >= 17) {
            this.hBT.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.hCn && i == 3 && VideoPlayFragment.this.hBU.getVisibility() == 0) {
                        VideoPlayFragment.this.hBU.clearAnimation();
                        VideoPlayFragment.this.hBU.startAnimation(VideoPlayFragment.this.bNq);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.hBT.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.hBT != null) {
                    VideoPlayFragment.this.hBT.seekTo(0);
                    y.bqO().remove(VideoPlayFragment.this.aAy);
                    VideoPlayFragment.this.hBT.start();
                    VideoPlayFragment.this.anY();
                    VideoPlayFragment.y(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.bJO();
                    }
                }
            }
        });
        this.hBT.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.hBU != null) {
                        VideoPlayFragment.this.hBU.clearAnimation();
                        VideoPlayFragment.this.hBU.startAnimation(VideoPlayFragment.this.bNq);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJO() {
        if (this.hCb != null && this.hCa != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.hCa.clearAnimation();
            this.hCb.clearAnimation();
            this.hCa.setVisibility(8);
            this.hCb.setVisibility(0);
            this.hCb.startAnimation(scaleAnimation2);
            this.hCa.startAnimation(scaleAnimation);
        }
    }

    private void bJP() {
        if (this.hCb != null && this.hCa != null) {
            this.hCa.clearAnimation();
            this.hCb.clearAnimation();
            this.hCa.setVisibility(0);
            this.hCb.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(int i) {
        int i2;
        if (ba.bI(getActivity()) && this.hCl != null) {
            if (i == this.hBR) {
                if ("1".equals(this.hCl.is_agreed)) {
                    i2 = 1;
                    this.hCl.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hCl.agree_num, 0) - 1);
                    this.hCl.is_agreed = "0";
                } else {
                    this.hCl.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hCl.agree_num, 0) + 1);
                    this.hCl.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.hCl.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hCl.agree_num, 0) + 1);
                this.hCl.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.ax("tid", this.hCl.thread_id);
            amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.hBR) {
                amVar.x("obj_type", i2);
            } else {
                amVar.x("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            bJT();
            if (this.hCo != null && i2 == 0) {
                this.hCo.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hCl.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hCl));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hCl != null && !StringUtils.isNull(this.hCl.video_url)) {
            this.UG = true;
            if (this.hCn) {
                anY();
                aXE();
                if (this.hCl != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.ax("tid", this.hCl.thread_id);
                    amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.x("obj_type", 0);
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
        if (this.hCA != null && this.hCA.KH() != null) {
            this.hCA.KH().hide();
            this.hCq.setVisibility(0);
            this.hCr.setText(StringUtils.isNull(((c) this.hCA.KH().fi(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.hCA != null) {
            this.hCA.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.hCn = z;
        if (this.UG) {
            if (this.hCn && (!this.hCz || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.hCl != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.ax("tid", this.hCl.thread_id);
                    amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.x("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                bJQ();
                this.hCz = false;
                return;
            }
            bJP();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void bJQ() {
        if (this.hCl != null) {
            am amVar = new am("c12590");
            amVar.ax("tid", this.hCl.thread_id);
            amVar.ax(ImageViewerConfig.FORUM_ID, this.hCl.forum_id);
            amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.x("obj_locate", this.hCu);
            amVar.ax("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.x("obj_param2", 1);
            amVar.ax("obj_param1", ao.isEmpty(this.hCl.mRecomWeight) ? "0" : this.hCl.mRecomWeight);
            amVar.ax("extra", ao.isEmpty(this.hCl.mRecomExtra) ? "0" : this.hCl.mRecomExtra);
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, this.amT);
            amVar.ax("ab_tag", ao.isEmpty(this.hCl.mRecomAbTag) ? "0" : this.hCl.mRecomAbTag);
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.hCl.mRecomSource) ? "0" : this.hCl.mRecomSource);
            amVar.ax("obj_type", this.bQf);
            amVar.x("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void ww(String str) {
        if (this.hBT != null && str != null && !str.equals(this.aAy)) {
            this.hBT.setRecoveryState(0);
            this.hBT.setVideoPath(str, this.hCl.thread_id);
            this.aAy = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.bGn().bGo() || bJW()) {
            bpJ();
            if (this.hCh != null) {
                this.hCh.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hBU.getVisibility() == 0) {
                this.hBU.clearAnimation();
                this.hBU.startAnimation(this.bNq);
            }
            if (this.hBT != null) {
                this.hBT.start();
                anY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anY() {
        if (this.hCl != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.beh = this.hCl.thread_id;
            zVar.cQb = this.hCl.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.hCl.mRecomSource;
            zVar.gww = this.hCl.mRecomAbTag;
            zVar.gwx = this.hCl.mRecomWeight;
            zVar.gwy = "";
            zVar.amT = "";
            zVar.gwA = this.hCl.mMd5;
            if (this.mRect != null) {
                zVar.gwB = "1";
            } else {
                zVar.gwB = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.gwC = "1";
                zVar.mLocate = "auto_midpage";
                zVar.gwy = "index";
            }
            com.baidu.tieba.play.l.a(this.hCl.mMd5, "", "1", zVar);
        }
    }

    private void bpJ() {
        if (com.baidu.adp.lib.util.j.kZ()) {
            com.baidu.tieba.video.g.bGn().dd(getContext());
        }
    }

    private void pausePlay() {
        if (this.hBT != null) {
            this.hBT.pause();
        }
    }

    private void stopPlay() {
        if (this.hBT != null) {
            this.hBT.setRecoveryState(5);
            this.hBT.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJR() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hCl.thread_id, this.hCl.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hCl.forum_id));
        createNormalCfg.setForumName(this.hCl.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJS() {
        if (this.aiP == null) {
            this.cNN = new com.baidu.tieba.view.a(getActivity());
            this.aiP = new com.baidu.tieba.person.e(getActivity(), this.cNN.bKv());
            this.aiP.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.hBT.setSystemUiVisibility(4);
                }
            });
        }
        if (this.cNN != null) {
            ArrayList arrayList = new ArrayList();
            a.C0292a c0292a = new a.C0292a(this.cNN);
            c0292a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.aiP.dismiss();
                    if (VideoPlayFragment.this.hCl != null) {
                        boolean z = VideoPlayFragment.this.hCl.post_id != null && VideoPlayFragment.this.hCl.post_id.equals(VideoPlayFragment.this.hCl.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.hCl.thread_id);
                        markData.setPostId(VideoPlayFragment.this.hCl.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.hCl.thread_id);
                        markData.setForumId(VideoPlayFragment.this.hCl.forum_id);
                        if (VideoPlayFragment.this.fKH != null) {
                            VideoPlayFragment.this.fKH.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.fKH.ve();
                            } else {
                                VideoPlayFragment.this.fKH.vd();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hCl != null && this.hCl.post_id != null && this.hCl.post_id.equals(this.hCl.mark_id)) {
                z = true;
            }
            if (z) {
                c0292a.setText(getResources().getString(e.j.remove_mark));
            } else {
                c0292a.setText(getResources().getString(e.j.mark));
            }
            arrayList.add(c0292a);
            a.C0292a c0292a2 = new a.C0292a(getActivity().getString(e.j.delete), this.cNN);
            c0292a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.aiP.dismiss();
                    if (ba.bI(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hCl != null) {
                        String str = VideoPlayFragment.this.hCl.thread_id;
                        String str2 = VideoPlayFragment.this.hCl.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(e.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.hCl.post_id, true)));
                    }
                }
            });
            c0292a2.setText(getResources().getString(e.j.report_text));
            arrayList.add(c0292a2);
            if (this.eeV) {
                a.C0292a c0292a3 = new a.C0292a(getActivity().getString(e.j.delete), this.cNN);
                c0292a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.aiP.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.cz(e.j.del_thread_confirm);
                        aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.hCl != null) {
                                    VideoPlayFragment.this.cNV.a(VideoPlayFragment.this.hCl.forum_id, VideoPlayFragment.this.hCl.forum_name, VideoPlayFragment.this.hCl.thread_id, VideoPlayFragment.this.hCl.post_id, 0, 0, VideoPlayFragment.this.eeV);
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
                        aVar.aO(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.Au();
                    }
                });
                c0292a3.setText(getResources().getString(e.j.delete));
                arrayList.add(c0292a3);
            }
            this.cNN.eb(arrayList);
        }
        this.aiP.show();
    }

    private void bJT() {
        if (this.hCl != null) {
            this.hBU.startLoad(this.hCl.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.hCl.title);
            if (StringUtils.isNull(this.hCl.title) || matcher.matches()) {
                this.hCc.setVisibility(8);
            } else {
                this.hCc.setVisibility(0);
                this.hCc.setText(this.hCl.title);
            }
            this.hCe.setText(ao.N(com.baidu.adp.lib.g.b.d(this.hCl.comment_num, 0L)));
            this.hCf.setText(ao.N(com.baidu.adp.lib.g.b.d(this.hCl.agree_num, 0L)));
            this.hCg.setText(ao.N(com.baidu.adp.lib.g.b.d(this.hCl.share_num, 0L)));
            if (this.hCl.author_info != null) {
                if (!StringUtils.isNull(this.hCl.author_info.portrait) && this.hCl.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.hBV.startLoad(this.hCl.author_info.portrait, 10, false);
                } else {
                    this.hBV.startLoad(this.hCl.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.hCl.author_info.bGj())) {
                    this.hCp.setVisibility(8);
                } else {
                    this.hCp.setVisibility(0);
                    this.hCp.setText("@" + this.hCl.author_info.bGj());
                }
            }
            if ("1".equals(this.hCl.is_private) && this.hCm.getVisibility() != 0) {
                this.hCk.setVisibility(0);
            } else {
                this.hCk.setVisibility(8);
            }
            if ("1".equals(this.hCl.is_agreed)) {
                al.c(this.hCo, e.f.icon_card_like_white_full_s);
            } else {
                al.c(this.hCo, e.f.btn_video_agree);
            }
            if (this.hCl.act_info != null && !StringUtils.isNull(this.hCl.act_info.activity_name) && this.hCm.getVisibility() != 0) {
                this.hCj.setVisibility(0);
                this.hCd.setText(this.hCl.act_info.activity_name);
            } else {
                this.hCj.setVisibility(8);
            }
            bJU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJU() {
        if (this.eeV || (this.hCl.author_info != null && !"0".equals(this.hCl.author_info.is_follow))) {
            this.hBZ.setVisibility(4);
            this.hBZ.setClickable(false);
            return;
        }
        this.hBZ.setVisibility(0);
        this.hBZ.setClickable(true);
    }

    private void bJV() {
        if (getActivity() != null) {
            if (this.hCB == null || !this.hCB.isShowing()) {
                this.hCB = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(e.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(e.g.tv_title)).setText(e.j.confirm_title);
                ((TextView) inflate.findViewById(e.g.tv_msg)).setText(e.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(e.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(e.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.hCB.G(inflate);
                this.hCB.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.hCB.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.hCB.cB(1);
                this.hCB.cA(e.d.cp_cont_b);
                this.hCB.aO(true);
                this.hCB.b(getPageContext());
                this.hCB.Au();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJW() {
        if (!com.baidu.adp.lib.util.j.kX() || com.baidu.adp.lib.util.j.kY()) {
            return true;
        }
        if (!this.hCn || com.baidu.tieba.video.g.bGn().bGo()) {
            return false;
        }
        if (this.hCh != null) {
            this.hCh.setVisibility(0);
        }
        pausePlay();
        bJV();
        return false;
    }

    private void aXE() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bJW() || com.baidu.tieba.video.g.bGn().bGo()) && this.hBT != null && this.hCh != null) {
            this.hBT.start();
            this.hCh.setVisibility(8);
            bpJ();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.hCv == null) {
            this.hCv = AnimationUtils.loadAnimation(getContext(), e.a.scale_zoom_in_and_out_anim);
        }
        return this.hCv;
    }

    public long bJX() {
        if (this.hCi != null) {
            this.hCi.setVisibility(8);
        }
        if (this.hCm != null) {
            this.hCm.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0146a
    public void Sm() {
        if (this.hBT.isPlaying()) {
            this.hBT.pause();
            this.hCh.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bJW() || com.baidu.tieba.video.g.bGn().bGo()) {
            this.hBT.start();
            this.hCh.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0146a
    public void q(float f, float f2) {
        if (ba.bI(getActivity()) && !this.hCw) {
            bJY();
            if (this.hCl != null && "0".equals(this.hCl.is_agreed)) {
                vS(this.hBS);
            }
        }
    }

    private void bJY() {
        if (this.mRootView != null) {
            this.hCw = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(e.f.icon_video_like);
            if (this.hCy == null) {
                this.hCy = new RelativeLayout.LayoutParams(-2, -2);
                this.hCy.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.hCy);
            }
            if (this.hCx == null) {
                this.hCx = new AnimatorSet();
                this.hCx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.hCw = false;
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
            this.hCx.setTarget(imageView);
            this.hCx.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.hCx.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0146a
    public void Sn() {
        if (this.hCl != null && this.hCl.author_info != null) {
            long d = com.baidu.adp.lib.g.b.d(this.hCl.author_info.user_id, 0L);
            long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = d == d2;
            if (d == 0 && d2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(d, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.hBT != null) {
            return this.hBT.getMediaIDs();
        }
        return null;
    }

    public String bJZ() {
        if (this.hBT != null) {
            return this.hBT.getMediaId();
        }
        return null;
    }

    public boolean bKa() {
        if (this.hCA == null || this.hCA.KH() == null || !this.hCA.KH().isVisible()) {
            return false;
        }
        this.hCA.KH().hide();
        this.hCq.setVisibility(0);
        if ((this.hCA.KH().fi(28) instanceof c) && ((c) this.hCA.KH().fi(28)).getInputView() != null && ((c) this.hCA.KH().fi(28)).getInputView().getText() != null) {
            this.hCr.setText(StringUtils.isNull(((c) this.hCA.KH().fi(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.hCA != null) {
            this.hCA.onActivityResult(i, i2, intent);
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
        if (this.hCA != null && this.hCA.KH() != null) {
            this.hCA.KH().onChangeSkinType(i);
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
