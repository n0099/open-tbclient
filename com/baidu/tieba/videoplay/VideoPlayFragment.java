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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0170a {
    private boolean UI;
    private String aBn;
    private e ajC;
    private String anG;
    public ImageView bIh;
    private n bKA;
    private AlphaAnimation bOb;
    private String bQP;
    private com.baidu.tieba.view.a cOT;
    private View drL;
    private boolean egp;
    private j.b gvA;
    private QuickVideoView.c gvQ;
    public QuickVideoView hDD;
    private TbImageView hDE;
    public HeadImageView hDF;
    public LinearLayout hDG;
    public LinearLayout hDH;
    public LinearLayout hDI;
    public ImageView hDJ;
    public ImageView hDK;
    public ImageView hDL;
    public TextView hDM;
    public TextView hDN;
    public TextView hDO;
    public TextView hDP;
    public TextView hDQ;
    public ImageView hDR;
    private LinearLayout hDS;
    public LinearLayout hDT;
    public LinearLayout hDU;
    public VideoItemData hDV;
    private TextView hDW;
    private boolean hDX;
    public ImageView hDY;
    public TextView hDZ;
    private View hEa;
    private TextView hEb;
    private int hEc;
    private int hEd;
    private int hEe;
    protected Animation hEf;
    private boolean hEg;
    private AnimatorSet hEh;
    private RelativeLayout.LayoutParams hEi;
    private com.baidu.tieba.videoplay.editor.a hEk;
    com.baidu.tbadk.core.dialog.a hEl;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int hDB = 0;
    private int hDC = 1;
    private ForumManageModel cPb = null;
    private com.baidu.tbadk.baseEditMark.a fMg = null;
    private com.baidu.tbadk.coreExtra.model.a ayB = null;
    private BdUniqueId ays = BdUniqueId.gen();
    private boolean hEj = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.hDV != null && VideoPlayFragment.this.hDV.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hDV.author_info.user_id) && data != null && VideoPlayFragment.this.hDV.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.ays)) ? false : false;
                    if (data.aLS == null) {
                        if (!data.Jr) {
                            if (z && !"0".equals(VideoPlayFragment.this.hDV.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_fail);
                                VideoPlayFragment.this.hDV.author_info.is_follow = "0";
                                VideoPlayFragment.this.bJt();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.hDX) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.hDV));
                                    return;
                                }
                                VideoPlayFragment.this.hDV.author_info.is_follow = "1";
                                VideoPlayFragment.this.bJt();
                            }
                        } else {
                            VideoPlayFragment.this.hDV.author_info.is_follow = "0";
                            VideoPlayFragment.this.bJt();
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
                VideoPlayFragment.this.bJv();
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
        this.hDV = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hEe = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.bQP = arguments.getString("from");
        this.anG = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.hDV != null && this.hDV.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hDV.author_info.user_id)) {
            this.egp = true;
        }
        this.bKA = new n(getActivity());
        this.bKA.a(this.hDV);
        this.bKA.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bE(int i, int i2) {
                if (VideoPlayFragment.this.gvA != null) {
                    VideoPlayFragment.this.gvA.bE(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(e.h.video_play_view, (ViewGroup) null);
        this.hDD = (QuickVideoView) this.mRootView.findViewById(e.g.videoView);
        this.hDD.setPlayerReuseEnable(true);
        this.hDD.setContinuePlayEnable(true);
        this.hDD.setBusiness(this.bKA);
        this.hDD.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.gvQ != null) {
                    VideoPlayFragment.this.gvQ.onStart();
                }
            }
        });
        this.hDD.setNeedRecovery(true);
        if (this.hDV != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.beV = this.hDV.thread_id;
            zVar.cRh = this.hDV.forum_id;
            zVar.gyb = this.hDV.mMd5;
            zVar.anG = "";
            zVar.mSource = this.hDV.mRecomSource;
            zVar.gya = this.hDV.mRecomAbTag;
            zVar.gxY = this.hDV.mRecomWeight;
            if (this.mRect != null) {
                zVar.gyc = "1";
            } else {
                zVar.gyc = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.gyd = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.gxZ = this.bQP;
                zVar.anG = this.anG;
                zVar.gxX = this.hDV.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.bKA.setVideoStatsData(zVar);
        }
        this.hDE = (TbImageView) this.mRootView.findViewById(e.g.video_cover);
        this.hDE.setDefaultBgResource(e.f.icon_play_bg);
        this.hDE.setDefaultErrorResource(e.f.icon_play_bg);
        if (g.BB()) {
            this.drL = this.mRootView.findViewById(e.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.drL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.drL.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(e.g.back_btn);
        this.bIh = (ImageView) this.mRootView.findViewById(e.g.more_btn);
        this.hDF = (HeadImageView) this.mRootView.findViewById(e.g.author_portrait);
        this.hDF.setDefaultResource(17170445);
        this.hDF.setDefaultBgResource(e.d.cp_bg_line_e);
        this.hDF.setIsRound(true);
        this.hDJ = (ImageView) this.mRootView.findViewById(e.g.love_btn);
        this.hDY = (ImageView) this.mRootView.findViewById(e.g.agree_img);
        this.hDM = (TextView) this.mRootView.findViewById(e.g.video_title);
        this.hDN = (TextView) this.mRootView.findViewById(e.g.video_activity);
        this.hDH = (LinearLayout) this.mRootView.findViewById(e.g.comment_container);
        this.hDO = (TextView) this.mRootView.findViewById(e.g.comment_num);
        this.hDG = (LinearLayout) this.mRootView.findViewById(e.g.agree_container);
        this.hDP = (TextView) this.mRootView.findViewById(e.g.agree_num);
        this.hDQ = (TextView) this.mRootView.findViewById(e.g.share_num);
        this.hDK = (ImageView) this.mRootView.findViewById(e.g.share_img);
        this.hDL = (ImageView) this.mRootView.findViewById(e.g.share_img_changed);
        bJo();
        this.hDR = (ImageView) this.mRootView.findViewById(e.g.play_btn);
        this.hDS = (LinearLayout) this.mRootView.findViewById(e.g.video_act_private_container);
        this.hDT = (LinearLayout) this.mRootView.findViewById(e.g.video_activity_container);
        this.hDU = (LinearLayout) this.mRootView.findViewById(e.g.video_private);
        this.hDI = (LinearLayout) this.mRootView.findViewById(e.g.share_container);
        this.hDZ = (TextView) this.mRootView.findViewById(e.g.video_author_name);
        this.hEa = this.mRootView.findViewById(e.g.quick_reply_comment_layout);
        this.hEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.hEa.setVisibility(4);
                    if (VideoPlayFragment.this.hEk != null && VideoPlayFragment.this.hEk.KT() != null) {
                        VideoPlayFragment.this.hEk.KT().pO();
                    }
                    if (VideoPlayFragment.this.hDV != null) {
                        am amVar = new am("c13025");
                        amVar.ax("tid", VideoPlayFragment.this.hDV.thread_id);
                        amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.ax(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.hDV.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.hEb = (TextView) this.mRootView.findViewById(e.g.quick_reply_comment_text);
        this.hDW = (TextView) this.mRootView.findViewById(e.g.download_nani_guide_txt);
        this.hDW.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hDW.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.hDW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.Db().a((TbPageContext) i.aK(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bJs();
        this.hDF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hDV != null && VideoPlayFragment.this.hDV.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hDV.author_info.user_id) && VideoPlayFragment.this.hDV != null && VideoPlayFragment.this.hDV.author_info != null) {
                    long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.hDV.author_info.user_id, 0L);
                    long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = d == d2;
                    if (d == 0 && d2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(d, z, false)));
                    am amVar = new am("c12798");
                    amVar.ax("tid", VideoPlayFragment.this.hDV.thread_id);
                    amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hDT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hDV != null && VideoPlayFragment.this.hDV.act_info != null) {
                    com.baidu.tbadk.browser.a.ae(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.hDV.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.ax("tid", VideoPlayFragment.this.hDV.thread_id);
                    amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bJq();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hDV != null && !StringUtils.isNull(VideoPlayFragment.this.hDV.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.hDV.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.bIh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bJr();
            }
        });
        this.hDH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bJq();
                am amVar = new am("c12796");
                amVar.ax("tid", VideoPlayFragment.this.hDV.thread_id);
                amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hDG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.wl(VideoPlayFragment.this.hDB);
            }
        });
        this.hDI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.El();
                am amVar = new am("c12797");
                amVar.ax("tid", VideoPlayFragment.this.hDV.thread_id);
                amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hDJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bG(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hDV != null && VideoPlayFragment.this.hDV.author_info != null) {
                    VideoPlayFragment.this.ayB.a(true, VideoPlayFragment.this.hDV.author_info.portrait, VideoPlayFragment.this.hDV.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.ays, VideoPlayFragment.this.hDV.forum_id, "0");
                    VideoPlayFragment.this.hDV.author_info.is_follow = "1";
                    VideoPlayFragment.this.bJt();
                }
            }
        });
        this.bOb = new AlphaAnimation(1.0f, 0.0f);
        this.bOb.setDuration(100L);
        this.bOb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.hDE != null) {
                    VideoPlayFragment.this.hDE.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.hEc = this.mRect.right - this.mRect.left;
            this.hEd = this.mRect.bottom - this.mRect.top;
            this.hDE.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.hDE.getWidth();
                    int height = VideoPlayFragment.this.hDE.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hDV.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hDV.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hDV.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hDV.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hEc, VideoPlayFragment.this.hEd);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.hDE.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hEd > 0 || VideoPlayFragment.this.hEc <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.hEc;
                                f = i / VideoPlayFragment.this.hEd;
                            }
                            VideoPlayFragment.this.hDE.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.hDE.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.hDX) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hEc, VideoPlayFragment.this.hEd);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.hDE.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hEd > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.hDE.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.hDE.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.hDX) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.hDE.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.hDE.getWidth();
                    int height = VideoPlayFragment.this.hDE.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hDV.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.hDV.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hDV.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hDV.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.hDE.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.hDE.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.hDX) {
            bJp();
        }
        if (this.hDV != null && !StringUtils.isNull(this.hDV.video_url)) {
            wB(this.hDV.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.gvA = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gvQ = cVar;
    }

    private void initEditor() {
        this.hEk = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().bJ(getActivity());
        if (this.hEk != null && this.hDV != null) {
            this.hEk.setContext(getPageContext());
            this.hEk.Q(this.hDV.thread_id, this.hDV.forum_id, this.hDV.forum_name);
            this.hEk.a(new a.InterfaceC0319a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0319a
                public void oh(boolean z) {
                    VideoPlayFragment.this.hEa.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.hEb.setText(e.j.reply_something);
                    } else {
                        VideoPlayFragment.this.hEb.setText(StringUtils.isNull(((c) VideoPlayFragment.this.hEk.KT().fw(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.hDV != null && z) {
                        long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.hDV.comment_num, 0L) + 1;
                        VideoPlayFragment.this.hDV.comment_num = String.valueOf(d);
                        VideoPlayFragment.this.hDO.setText(ao.P(d));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.hEk.KT(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void El() {
        if (this.hDV != null) {
            String str = this.hDV.forum_id;
            String str2 = this.hDV.forum_name;
            String str3 = this.hDV.title;
            String str4 = this.hDV.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hDV.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            d dVar = new d();
            dVar.title = str3;
            dVar.content = format;
            dVar.aOK = "";
            dVar.linkUrl = str5;
            dVar.ask = 2;
            dVar.extData = str4;
            dVar.aON = 3;
            dVar.fid = str;
            dVar.aOG = str2;
            dVar.tid = str4;
            dVar.aOC = true;
            dVar.aOM = 0;
            dVar.aOO = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hDV.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hDV.title;
            originalThreadInfo.threadId = this.hDV.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aON);
            bundle.putInt("obj_type", dVar.aOO);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ask);
            dVar.i(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.apC().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.egp) {
            this.cPb = new ForumManageModel(getPageContext());
            this.cPb.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.cPb.getLoadDataMode()) {
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
        this.fMg = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.fMg != null) {
            this.fMg.a(new a.InterfaceC0144a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0144a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.fMg != null) {
                            VideoPlayFragment.this.fMg.aO(z2);
                        }
                        if (VideoPlayFragment.this.hDV != null) {
                            if (z2) {
                                VideoPlayFragment.this.hDV.mark_id = VideoPlayFragment.this.hDV.post_id;
                            } else {
                                VideoPlayFragment.this.hDV.mark_id = null;
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
        this.ayB = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.hEj = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bJs();
        if (Build.VERSION.SDK_INT >= 17) {
            this.hDD.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.hDX && i == 3 && VideoPlayFragment.this.hDE.getVisibility() == 0) {
                        VideoPlayFragment.this.hDE.clearAnimation();
                        VideoPlayFragment.this.hDE.startAnimation(VideoPlayFragment.this.bOb);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.hDD.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.hDD != null) {
                    VideoPlayFragment.this.hDD.seekTo(0);
                    y.bqk().remove(VideoPlayFragment.this.aBn);
                    VideoPlayFragment.this.hDD.start();
                    VideoPlayFragment.this.anz();
                    VideoPlayFragment.y(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.bJn();
                    }
                }
            }
        });
        this.hDD.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.hDE != null) {
                        VideoPlayFragment.this.hDE.clearAnimation();
                        VideoPlayFragment.this.hDE.startAnimation(VideoPlayFragment.this.bOb);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJn() {
        if (this.hDL != null && this.hDK != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.hDK.clearAnimation();
            this.hDL.clearAnimation();
            this.hDK.setVisibility(8);
            this.hDL.setVisibility(0);
            this.hDL.startAnimation(scaleAnimation2);
            this.hDK.startAnimation(scaleAnimation);
        }
    }

    private void bJo() {
        if (this.hDL != null && this.hDK != null) {
            this.hDK.clearAnimation();
            this.hDL.clearAnimation();
            this.hDK.setVisibility(0);
            this.hDL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl(int i) {
        int i2;
        if (ba.bG(getActivity()) && this.hDV != null) {
            if (i == this.hDB) {
                if ("1".equals(this.hDV.is_agreed)) {
                    i2 = 1;
                    this.hDV.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hDV.agree_num, 0) - 1);
                    this.hDV.is_agreed = "0";
                } else {
                    this.hDV.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hDV.agree_num, 0) + 1);
                    this.hDV.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.hDV.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.hDV.agree_num, 0) + 1);
                this.hDV.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.ax("tid", this.hDV.thread_id);
            amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.hDB) {
                amVar.x("obj_type", i2);
            } else {
                amVar.x("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            bJs();
            if (this.hDY != null && i2 == 0) {
                this.hDY.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hDV.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hDV));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hDV != null && !StringUtils.isNull(this.hDV.video_url)) {
            this.UI = true;
            if (this.hDX) {
                anz();
                aXb();
                if (this.hDV != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.ax("tid", this.hDV.thread_id);
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
        if (this.hEk != null && this.hEk.KT() != null) {
            this.hEk.KT().hide();
            this.hEa.setVisibility(0);
            this.hEb.setText(StringUtils.isNull(((c) this.hEk.KT().fw(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.hEk != null) {
            this.hEk.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.hDX = z;
        if (this.UI) {
            if (this.hDX && (!this.hEj || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.hDV != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.ax("tid", this.hDV.thread_id);
                    amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.x("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                bJp();
                this.hEj = false;
                return;
            }
            bJo();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void bJp() {
        if (this.hDV != null) {
            am amVar = new am("c12590");
            amVar.ax("tid", this.hDV.thread_id);
            amVar.ax(ImageViewerConfig.FORUM_ID, this.hDV.forum_id);
            amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.x("obj_locate", this.hEe);
            amVar.ax("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.x("obj_param2", 1);
            amVar.ax("obj_param1", ao.isEmpty(this.hDV.mRecomWeight) ? "0" : this.hDV.mRecomWeight);
            amVar.ax("extra", ao.isEmpty(this.hDV.mRecomExtra) ? "0" : this.hDV.mRecomExtra);
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, this.anG);
            amVar.ax("ab_tag", ao.isEmpty(this.hDV.mRecomAbTag) ? "0" : this.hDV.mRecomAbTag);
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.hDV.mRecomSource) ? "0" : this.hDV.mRecomSource);
            amVar.ax("obj_type", this.bQP);
            amVar.x("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void wB(String str) {
        if (this.hDD != null && str != null && !str.equals(this.aBn)) {
            this.hDD.setRecoveryState(0);
            this.hDD.setVideoPath(str, this.hDV.thread_id);
            this.aBn = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.bFM().bFN() || bJv()) {
            bpf();
            if (this.hDR != null) {
                this.hDR.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hDE.getVisibility() == 0) {
                this.hDE.clearAnimation();
                this.hDE.startAnimation(this.bOb);
            }
            if (this.hDD != null) {
                this.hDD.start();
                anz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anz() {
        if (this.hDV != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.beV = this.hDV.thread_id;
            zVar.cRh = this.hDV.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.hDV.mRecomSource;
            zVar.gxX = this.hDV.mRecomAbTag;
            zVar.gxY = this.hDV.mRecomWeight;
            zVar.gxZ = "";
            zVar.anG = "";
            zVar.gyb = this.hDV.mMd5;
            if (this.mRect != null) {
                zVar.gyc = "1";
            } else {
                zVar.gyc = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.gyd = "1";
                zVar.mLocate = "auto_midpage";
                zVar.gxZ = "index";
            }
            com.baidu.tieba.play.l.a(this.hDV.mMd5, "", "1", zVar);
        }
    }

    private void bpf() {
        if (com.baidu.adp.lib.util.j.kX()) {
            com.baidu.tieba.video.g.bFM().cY(getContext());
        }
    }

    private void pausePlay() {
        if (this.hDD != null) {
            this.hDD.pause();
        }
    }

    private void stopPlay() {
        if (this.hDD != null) {
            this.hDD.setRecoveryState(5);
            this.hDD.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJq() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hDV.thread_id, this.hDV.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hDV.forum_id));
        createNormalCfg.setForumName(this.hDV.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJr() {
        if (this.ajC == null) {
            this.cOT = new com.baidu.tieba.view.a(getActivity());
            this.ajC = new com.baidu.tieba.person.e(getActivity(), this.cOT.bJU());
            this.ajC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.hDD.setSystemUiVisibility(4);
                }
            });
        }
        if (this.cOT != null) {
            ArrayList arrayList = new ArrayList();
            a.C0320a c0320a = new a.C0320a(this.cOT);
            c0320a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.ajC.dismiss();
                    if (VideoPlayFragment.this.hDV != null) {
                        boolean z = VideoPlayFragment.this.hDV.post_id != null && VideoPlayFragment.this.hDV.post_id.equals(VideoPlayFragment.this.hDV.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.hDV.thread_id);
                        markData.setPostId(VideoPlayFragment.this.hDV.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.hDV.thread_id);
                        markData.setForumId(VideoPlayFragment.this.hDV.forum_id);
                        if (VideoPlayFragment.this.fMg != null) {
                            VideoPlayFragment.this.fMg.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.fMg.vo();
                            } else {
                                VideoPlayFragment.this.fMg.vn();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hDV != null && this.hDV.post_id != null && this.hDV.post_id.equals(this.hDV.mark_id)) {
                z = true;
            }
            if (z) {
                c0320a.setText(getResources().getString(e.j.remove_mark));
            } else {
                c0320a.setText(getResources().getString(e.j.mark));
            }
            arrayList.add(c0320a);
            a.C0320a c0320a2 = new a.C0320a(getActivity().getString(e.j.delete), this.cOT);
            c0320a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.ajC.dismiss();
                    if (ba.bG(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hDV != null) {
                        String str = VideoPlayFragment.this.hDV.thread_id;
                        String str2 = VideoPlayFragment.this.hDV.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(e.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.hDV.post_id, true)));
                    }
                }
            });
            c0320a2.setText(getResources().getString(e.j.report_text));
            arrayList.add(c0320a2);
            if (this.egp) {
                a.C0320a c0320a3 = new a.C0320a(getActivity().getString(e.j.delete), this.cOT);
                c0320a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.ajC.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.cN(e.j.del_thread_confirm);
                        aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.hDV != null) {
                                    VideoPlayFragment.this.cPb.a(VideoPlayFragment.this.hDV.forum_id, VideoPlayFragment.this.hDV.forum_name, VideoPlayFragment.this.hDV.thread_id, VideoPlayFragment.this.hDV.post_id, 0, 0, VideoPlayFragment.this.egp);
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
                        aVar.be(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.AB();
                    }
                });
                c0320a3.setText(getResources().getString(e.j.delete));
                arrayList.add(c0320a3);
            }
            this.cOT.dZ(arrayList);
        }
        this.ajC.show();
    }

    private void bJs() {
        if (this.hDV != null) {
            this.hDE.startLoad(this.hDV.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.hDV.title);
            if (StringUtils.isNull(this.hDV.title) || matcher.matches()) {
                this.hDM.setVisibility(8);
            } else {
                this.hDM.setVisibility(0);
                this.hDM.setText(this.hDV.title);
            }
            this.hDO.setText(ao.P(com.baidu.adp.lib.g.b.d(this.hDV.comment_num, 0L)));
            this.hDP.setText(ao.P(com.baidu.adp.lib.g.b.d(this.hDV.agree_num, 0L)));
            this.hDQ.setText(ao.P(com.baidu.adp.lib.g.b.d(this.hDV.share_num, 0L)));
            if (this.hDV.author_info != null) {
                if (!StringUtils.isNull(this.hDV.author_info.portrait) && this.hDV.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.hDF.startLoad(this.hDV.author_info.portrait, 10, false);
                } else {
                    this.hDF.startLoad(this.hDV.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.hDV.author_info.bFI())) {
                    this.hDZ.setVisibility(8);
                } else {
                    this.hDZ.setVisibility(0);
                    this.hDZ.setText("@" + this.hDV.author_info.bFI());
                }
            }
            if ("1".equals(this.hDV.is_private) && this.hDW.getVisibility() != 0) {
                this.hDU.setVisibility(0);
            } else {
                this.hDU.setVisibility(8);
            }
            if ("1".equals(this.hDV.is_agreed)) {
                al.c(this.hDY, e.f.icon_card_like_white_full_s);
            } else {
                al.c(this.hDY, e.f.btn_video_agree);
            }
            if (this.hDV.act_info != null && !StringUtils.isNull(this.hDV.act_info.activity_name) && this.hDW.getVisibility() != 0) {
                this.hDT.setVisibility(0);
                this.hDN.setText(this.hDV.act_info.activity_name);
            } else {
                this.hDT.setVisibility(8);
            }
            bJt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJt() {
        if (this.egp || (this.hDV.author_info != null && !"0".equals(this.hDV.author_info.is_follow))) {
            this.hDJ.setVisibility(4);
            this.hDJ.setClickable(false);
            return;
        }
        this.hDJ.setVisibility(0);
        this.hDJ.setClickable(true);
    }

    private void bJu() {
        if (getActivity() != null) {
            if (this.hEl == null || !this.hEl.isShowing()) {
                this.hEl = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(e.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(e.g.tv_title)).setText(e.j.confirm_title);
                ((TextView) inflate.findViewById(e.g.tv_msg)).setText(e.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(e.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(e.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.hEl.G(inflate);
                this.hEl.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.hEl.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.hEl.cP(1);
                this.hEl.cO(e.d.cp_cont_b);
                this.hEl.be(true);
                this.hEl.b(getPageContext());
                this.hEl.AB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJv() {
        if (!com.baidu.adp.lib.util.j.kV() || com.baidu.adp.lib.util.j.kW()) {
            return true;
        }
        if (!this.hDX || com.baidu.tieba.video.g.bFM().bFN()) {
            return false;
        }
        if (this.hDR != null) {
            this.hDR.setVisibility(0);
        }
        pausePlay();
        bJu();
        return false;
    }

    private void aXb() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bJv() || com.baidu.tieba.video.g.bFM().bFN()) && this.hDD != null && this.hDR != null) {
            this.hDD.start();
            this.hDR.setVisibility(8);
            bpf();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.hEf == null) {
            this.hEf = AnimationUtils.loadAnimation(getContext(), e.a.scale_zoom_in_and_out_anim);
        }
        return this.hEf;
    }

    public long bJw() {
        if (this.hDS != null) {
            this.hDS.setVisibility(8);
        }
        if (this.hDW != null) {
            this.hDW.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0170a
    public void Sv() {
        if (this.hDD.isPlaying()) {
            this.hDD.pause();
            this.hDR.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bJv() || com.baidu.tieba.video.g.bFM().bFN()) {
            this.hDD.start();
            this.hDR.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0170a
    public void t(float f, float f2) {
        if (ba.bG(getActivity()) && !this.hEg) {
            bJx();
            if (this.hDV != null && "0".equals(this.hDV.is_agreed)) {
                wl(this.hDC);
            }
        }
    }

    private void bJx() {
        if (this.mRootView != null) {
            this.hEg = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(e.f.icon_video_like);
            if (this.hEi == null) {
                this.hEi = new RelativeLayout.LayoutParams(-2, -2);
                this.hEi.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.hEi);
            }
            if (this.hEh == null) {
                this.hEh = new AnimatorSet();
                this.hEh.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.hEg = false;
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
            this.hEh.setTarget(imageView);
            this.hEh.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.hEh.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0170a
    public void Sw() {
        if (this.hDV != null && this.hDV.author_info != null) {
            long d = com.baidu.adp.lib.g.b.d(this.hDV.author_info.user_id, 0L);
            long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = d == d2;
            if (d == 0 && d2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(d, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.hDD != null) {
            return this.hDD.getMediaIDs();
        }
        return null;
    }

    public String bJy() {
        if (this.hDD != null) {
            return this.hDD.getMediaId();
        }
        return null;
    }

    public boolean bJz() {
        if (this.hEk == null || this.hEk.KT() == null || !this.hEk.KT().isVisible()) {
            return false;
        }
        this.hEk.KT().hide();
        this.hEa.setVisibility(0);
        if ((this.hEk.KT().fw(28) instanceof c) && ((c) this.hEk.KT().fw(28)).getInputView() != null && ((c) this.hEk.KT().fw(28)).getInputView().getText() != null) {
            this.hEb.setText(StringUtils.isNull(((c) this.hEk.KT().fw(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.hEk != null) {
            this.hEk.onActivityResult(i, i2, intent);
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
        if (this.hEk != null && this.hEk.KT() != null) {
            this.hEk.KT().onChangeSkinType(i);
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
