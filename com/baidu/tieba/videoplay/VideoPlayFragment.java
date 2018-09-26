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
import com.baidu.tieba.play.x;
import com.baidu.tieba.play.y;
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
/* loaded from: classes2.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0122a {
    private e adS;
    private String ahY;
    private String avN;
    private n bBi;
    private AlphaAnimation bEN;
    private String bHC;
    private boolean bbm;
    public ImageView byO;
    private com.baidu.tieba.view.a cFt;
    private boolean dXb;
    private View diD;
    private QuickVideoView.c gmN;
    private j.b gmx;
    public QuickVideoView huG;
    private TbImageView huH;
    public HeadImageView huI;
    public LinearLayout huJ;
    public LinearLayout huK;
    public LinearLayout huL;
    public ImageView huM;
    public ImageView huN;
    public ImageView huO;
    public TextView huP;
    public TextView huQ;
    public TextView huR;
    public TextView huS;
    public TextView huT;
    public ImageView huU;
    private LinearLayout huV;
    public LinearLayout huW;
    public LinearLayout huX;
    public VideoItemData huY;
    private TextView huZ;
    private boolean hva;
    public ImageView hvb;
    public TextView hvc;
    private View hvd;
    private TextView hve;
    private int hvf;
    private int hvg;
    private int hvh;
    protected Animation hvi;
    private boolean hvj;
    private AnimatorSet hvk;
    private RelativeLayout.LayoutParams hvl;
    private com.baidu.tieba.videoplay.editor.a hvn;
    com.baidu.tbadk.core.dialog.a hvo;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int huE = 0;
    private int huF = 1;
    private ForumManageModel cFB = null;
    private com.baidu.tbadk.baseEditMark.a fDf = null;
    private com.baidu.tbadk.coreExtra.model.a atd = null;
    private BdUniqueId asU = BdUniqueId.gen();
    private boolean hvm = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.huY != null && VideoPlayFragment.this.huY.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.huY.author_info.user_id) && data != null && VideoPlayFragment.this.huY.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.asU)) ? false : false;
                    if (data.aGz == null) {
                        if (!data.IM) {
                            if (z && !"0".equals(VideoPlayFragment.this.huY.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_fail);
                                VideoPlayFragment.this.huY.author_info.is_follow = "0";
                                VideoPlayFragment.this.bGI();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.hva) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), e.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.huY));
                                    return;
                                }
                                VideoPlayFragment.this.huY.author_info.is_follow = "1";
                                VideoPlayFragment.this.bGI();
                            }
                        } else {
                            VideoPlayFragment.this.huY.author_info.is_follow = "0";
                            VideoPlayFragment.this.bGI();
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
                VideoPlayFragment.this.bGK();
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
        this.huY = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hvh = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.bHC = arguments.getString("from");
        this.ahY = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.huY != null && this.huY.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.huY.author_info.user_id)) {
            this.dXb = true;
        }
        this.bBi = new n(getActivity());
        this.bBi.a(this.huY);
        this.bBi.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bz(int i, int i2) {
                if (VideoPlayFragment.this.gmx != null) {
                    VideoPlayFragment.this.gmx.bz(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(e.h.video_play_view, (ViewGroup) null);
        this.huG = (QuickVideoView) this.mRootView.findViewById(e.g.videoView);
        this.huG.setPlayerReuseEnable(true);
        this.huG.setContinuePlayEnable(true);
        this.huG.setBusiness(this.bBi);
        this.huG.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.gmN != null) {
                    VideoPlayFragment.this.gmN.onStart();
                }
            }
        });
        this.huG.setNeedRecovery(true);
        if (this.huY != null) {
            y yVar = new y();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.aZG = this.huY.thread_id;
            yVar.cHI = this.huY.forum_id;
            yVar.goY = this.huY.mMd5;
            yVar.ahY = "";
            yVar.mSource = this.huY.mRecomSource;
            yVar.goX = this.huY.mRecomAbTag;
            yVar.goV = this.huY.mRecomWeight;
            if (this.mRect != null) {
                yVar.goZ = "1";
            } else {
                yVar.goZ = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.gpa = "1";
                yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                yVar.goW = this.bHC;
                yVar.ahY = this.ahY;
                yVar.goU = this.huY.mRecomWeight;
            } else {
                yVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.bBi.setVideoStatsData(yVar);
        }
        this.huH = (TbImageView) this.mRootView.findViewById(e.g.video_cover);
        this.huH.setDefaultBgResource(e.f.icon_play_bg);
        this.huH.setDefaultErrorResource(e.f.icon_play_bg);
        if (g.zm()) {
            this.diD = this.mRootView.findViewById(e.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.diD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.diD.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(e.g.back_btn);
        this.byO = (ImageView) this.mRootView.findViewById(e.g.more_btn);
        this.huI = (HeadImageView) this.mRootView.findViewById(e.g.author_portrait);
        this.huI.setDefaultResource(17170445);
        this.huI.setDefaultBgResource(e.d.cp_bg_line_e);
        this.huI.setIsRound(true);
        this.huM = (ImageView) this.mRootView.findViewById(e.g.love_btn);
        this.hvb = (ImageView) this.mRootView.findViewById(e.g.agree_img);
        this.huP = (TextView) this.mRootView.findViewById(e.g.video_title);
        this.huQ = (TextView) this.mRootView.findViewById(e.g.video_activity);
        this.huK = (LinearLayout) this.mRootView.findViewById(e.g.comment_container);
        this.huR = (TextView) this.mRootView.findViewById(e.g.comment_num);
        this.huJ = (LinearLayout) this.mRootView.findViewById(e.g.agree_container);
        this.huS = (TextView) this.mRootView.findViewById(e.g.agree_num);
        this.huT = (TextView) this.mRootView.findViewById(e.g.share_num);
        this.huN = (ImageView) this.mRootView.findViewById(e.g.share_img);
        this.huO = (ImageView) this.mRootView.findViewById(e.g.share_img_changed);
        bGD();
        this.huU = (ImageView) this.mRootView.findViewById(e.g.play_btn);
        this.huV = (LinearLayout) this.mRootView.findViewById(e.g.video_act_private_container);
        this.huW = (LinearLayout) this.mRootView.findViewById(e.g.video_activity_container);
        this.huX = (LinearLayout) this.mRootView.findViewById(e.g.video_private);
        this.huL = (LinearLayout) this.mRootView.findViewById(e.g.share_container);
        this.hvc = (TextView) this.mRootView.findViewById(e.g.video_author_name);
        this.hvd = this.mRootView.findViewById(e.g.quick_reply_comment_layout);
        this.hvd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.hvd.setVisibility(4);
                    if (VideoPlayFragment.this.hvn != null && VideoPlayFragment.this.hvn.IJ() != null) {
                        VideoPlayFragment.this.hvn.IJ().pI();
                    }
                    if (VideoPlayFragment.this.huY != null) {
                        am amVar = new am("c13025");
                        amVar.al("tid", VideoPlayFragment.this.huY.thread_id);
                        amVar.g("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.al(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.huY.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.hve = (TextView) this.mRootView.findViewById(e.g.quick_reply_comment_text);
        this.huZ = (TextView) this.mRootView.findViewById(e.g.download_nani_guide_txt);
        this.huZ.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.huZ.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.huZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.AN().a((TbPageContext) i.aK(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bGH();
        this.huI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.huY != null && VideoPlayFragment.this.huY.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.huY.author_info.user_id) && VideoPlayFragment.this.huY != null && VideoPlayFragment.this.huY.author_info != null) {
                    long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.huY.author_info.user_id, 0L);
                    long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = d == d2;
                    if (d == 0 && d2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(d, z, false)));
                    am amVar = new am("c12798");
                    amVar.al("tid", VideoPlayFragment.this.huY.thread_id);
                    amVar.g("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.huW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.huY != null && VideoPlayFragment.this.huY.act_info != null) {
                    com.baidu.tbadk.browser.a.ag(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.huY.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.al("tid", VideoPlayFragment.this.huY.thread_id);
                    amVar.g("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.huP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bGF();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.huY != null && !StringUtils.isNull(VideoPlayFragment.this.huY.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.huY.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.byO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bGG();
            }
        });
        this.huK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bGF();
                am amVar = new am("c12796");
                amVar.al("tid", VideoPlayFragment.this.huY.thread_id);
                amVar.g("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.huJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.vv(VideoPlayFragment.this.huE);
            }
        });
        this.huL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.BW();
                am amVar = new am("c12797");
                amVar.al("tid", VideoPlayFragment.this.huY.thread_id);
                amVar.g("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.huM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bA(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.huY != null && VideoPlayFragment.this.huY.author_info != null) {
                    VideoPlayFragment.this.atd.a(true, VideoPlayFragment.this.huY.author_info.portrait, VideoPlayFragment.this.huY.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.asU, VideoPlayFragment.this.huY.forum_id, "0");
                    VideoPlayFragment.this.huY.author_info.is_follow = "1";
                    VideoPlayFragment.this.bGI();
                }
            }
        });
        this.bEN = new AlphaAnimation(1.0f, 0.0f);
        this.bEN.setDuration(100L);
        this.bEN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.huH != null) {
                    VideoPlayFragment.this.huH.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.hvf = this.mRect.right - this.mRect.left;
            this.hvg = this.mRect.bottom - this.mRect.top;
            this.huH.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.huH.getWidth();
                    int height = VideoPlayFragment.this.huH.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.huY.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.huY.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.huY.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.huY.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hvf, VideoPlayFragment.this.hvg);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.huH.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hvg > 0 || VideoPlayFragment.this.hvf <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.hvf;
                                f = i / VideoPlayFragment.this.hvg;
                            }
                            VideoPlayFragment.this.huH.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.huH.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.hva) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hvf, VideoPlayFragment.this.hvg);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.huH.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hvg > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.huH.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.huH.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.hva) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.huH.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.huH.getWidth();
                    int height = VideoPlayFragment.this.huH.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.huY.video_height, 0) > 0 && com.baidu.adp.lib.g.b.l(VideoPlayFragment.this.huY.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.huY.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.huY.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.huH.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.huH.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.hva) {
            bGE();
        }
        if (this.huY != null && !StringUtils.isNull(this.huY.video_url)) {
            vV(this.huY.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.gmx = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gmN = cVar;
    }

    private void initEditor() {
        this.hvn = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().bE(getActivity());
        if (this.hvn != null && this.huY != null) {
            this.hvn.setContext(getPageContext());
            this.hvn.J(this.huY.thread_id, this.huY.forum_id, this.huY.forum_name);
            this.hvn.a(new a.InterfaceC0256a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0256a
                public void nD(boolean z) {
                    VideoPlayFragment.this.hvd.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.hve.setText(e.j.reply_something);
                    } else {
                        VideoPlayFragment.this.hve.setText(StringUtils.isNull(((c) VideoPlayFragment.this.hvn.IJ().eZ(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.huY != null && z) {
                        long d = com.baidu.adp.lib.g.b.d(VideoPlayFragment.this.huY.comment_num, 0L) + 1;
                        VideoPlayFragment.this.huY.comment_num = String.valueOf(d);
                        VideoPlayFragment.this.huR.setText(ao.L(d));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.hvn.IJ(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BW() {
        if (this.huY != null) {
            String str = this.huY.forum_id;
            String str2 = this.huY.forum_name;
            String str3 = this.huY.title;
            String str4 = this.huY.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.huY.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            d dVar = new d();
            dVar.title = str3;
            dVar.content = format;
            dVar.aJs = "";
            dVar.linkUrl = str5;
            dVar.amC = 2;
            dVar.extData = str4;
            dVar.aJv = 3;
            dVar.fid = str;
            dVar.aJo = str2;
            dVar.tid = str4;
            dVar.aJk = true;
            dVar.aJu = 0;
            dVar.aJw = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.huY.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.huY.title;
            originalThreadInfo.threadId = this.huY.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aJv);
            bundle.putInt("obj_type", dVar.aJw);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.amC);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.amB().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.dXb) {
            this.cFB = new ForumManageModel(getPageContext());
            this.cFB.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void j(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.cFB.getLoadDataMode()) {
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
        this.fDf = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.fDf != null) {
            this.fDf.a(new a.InterfaceC0096a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0096a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.fDf != null) {
                            VideoPlayFragment.this.fDf.an(z2);
                        }
                        if (VideoPlayFragment.this.huY != null) {
                            if (z2) {
                                VideoPlayFragment.this.huY.mark_id = VideoPlayFragment.this.huY.post_id;
                            } else {
                                VideoPlayFragment.this.huY.mark_id = null;
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
        this.atd = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.hvm = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bGH();
        if (Build.VERSION.SDK_INT >= 17) {
            this.huG.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.hva && i == 3 && VideoPlayFragment.this.huH.getVisibility() == 0) {
                        VideoPlayFragment.this.huH.clearAnimation();
                        VideoPlayFragment.this.huH.startAnimation(VideoPlayFragment.this.bEN);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.huG.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.huG != null) {
                    VideoPlayFragment.this.huG.seekTo(0);
                    x.bnz().remove(VideoPlayFragment.this.avN);
                    VideoPlayFragment.this.huG.start();
                    VideoPlayFragment.this.akv();
                    VideoPlayFragment.y(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.bGC();
                    }
                }
            }
        });
        this.huG.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    if (gVar.isPlayerReuse() && VideoPlayFragment.this.huH != null) {
                        VideoPlayFragment.this.huH.clearAnimation();
                        VideoPlayFragment.this.huH.startAnimation(VideoPlayFragment.this.bEN);
                    }
                    gVar.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGC() {
        if (this.huO != null && this.huN != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.huN.clearAnimation();
            this.huO.clearAnimation();
            this.huN.setVisibility(8);
            this.huO.setVisibility(0);
            this.huO.startAnimation(scaleAnimation2);
            this.huN.startAnimation(scaleAnimation);
        }
    }

    private void bGD() {
        if (this.huO != null && this.huN != null) {
            this.huN.clearAnimation();
            this.huO.clearAnimation();
            this.huN.setVisibility(0);
            this.huO.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vv(int i) {
        int i2;
        if (ba.bA(getActivity()) && this.huY != null) {
            if (i == this.huE) {
                if ("1".equals(this.huY.is_agreed)) {
                    i2 = 1;
                    this.huY.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.huY.agree_num, 0) - 1);
                    this.huY.is_agreed = "0";
                } else {
                    this.huY.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.huY.agree_num, 0) + 1);
                    this.huY.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.huY.agree_num = String.valueOf(com.baidu.adp.lib.g.b.l(this.huY.agree_num, 0) + 1);
                this.huY.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.al("tid", this.huY.thread_id);
            amVar.g("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.huE) {
                amVar.w("obj_type", i2);
            } else {
                amVar.w("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            bGH();
            if (this.hvb != null && i2 == 0) {
                this.hvb.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.huY.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.huY));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.huY != null && !StringUtils.isNull(this.huY.video_url)) {
            this.bbm = true;
            if (this.hva) {
                akv();
                aUr();
                if (this.huY != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.al("tid", this.huY.thread_id);
                    amVar.g("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.w("obj_type", 0);
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
        if (this.hvn != null && this.hvn.IJ() != null) {
            this.hvn.IJ().hide();
            this.hvd.setVisibility(0);
            this.hve.setText(StringUtils.isNull(((c) this.hvn.IJ().eZ(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.hvn != null) {
            this.hvn.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.hva = z;
        if (this.bbm) {
            if (this.hva && (!this.hvm || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.huY != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.al("tid", this.huY.thread_id);
                    amVar.g("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.w("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                startPlay();
                bGE();
                this.hvm = false;
                return;
            }
            bGD();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void bGE() {
        if (this.huY != null) {
            am amVar = new am("c12590");
            amVar.al("tid", this.huY.thread_id);
            amVar.al(ImageViewerConfig.FORUM_ID, this.huY.forum_id);
            amVar.g("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.w("obj_locate", this.hvh);
            amVar.al("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.w("obj_param2", 1);
            amVar.al("obj_param1", ao.isEmpty(this.huY.mRecomWeight) ? "0" : this.huY.mRecomWeight);
            amVar.al("extra", ao.isEmpty(this.huY.mRecomExtra) ? "0" : this.huY.mRecomExtra);
            amVar.al(VideoPlayActivityConfig.OBJ_ID, this.ahY);
            amVar.al("ab_tag", ao.isEmpty(this.huY.mRecomAbTag) ? "0" : this.huY.mRecomAbTag);
            amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ao.isEmpty(this.huY.mRecomSource) ? "0" : this.huY.mRecomSource);
            amVar.al("obj_type", this.bHC);
            amVar.w("is_vertical", 1);
            TiebaStatic.log(amVar);
        }
    }

    private void vV(String str) {
        if (this.huG != null && str != null && !str.equals(this.avN)) {
            this.huG.setRecoveryState(0);
            this.huG.setVideoPath(str, this.huY.thread_id);
            this.avN = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.bCZ().bDa() || bGK()) {
            bmw();
            if (this.huU != null) {
                this.huU.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.huH.getVisibility() == 0) {
                this.huH.clearAnimation();
                this.huH.startAnimation(this.bEN);
            }
            if (this.huG != null) {
                this.huG.start();
                akv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        if (this.huY != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.aZG = this.huY.thread_id;
            yVar.cHI = this.huY.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.huY.mRecomSource;
            yVar.goU = this.huY.mRecomAbTag;
            yVar.goV = this.huY.mRecomWeight;
            yVar.goW = "";
            yVar.ahY = "";
            yVar.goY = this.huY.mMd5;
            if (this.mRect != null) {
                yVar.goZ = "1";
            } else {
                yVar.goZ = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.gpa = "1";
                yVar.mLocate = "auto_midpage";
                yVar.goW = "index";
            }
            com.baidu.tieba.play.l.a(this.huY.mMd5, "", "1", yVar);
        }
    }

    private void bmw() {
        if (com.baidu.adp.lib.util.j.kM()) {
            com.baidu.tieba.video.g.bCZ().cR(getContext());
        }
    }

    private void pausePlay() {
        if (this.huG != null) {
            this.huG.pause();
        }
    }

    private void stopPlay() {
        if (this.huG != null) {
            this.huG.setRecoveryState(5);
            this.huG.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGF() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.huY.thread_id, this.huY.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.huY.forum_id));
        createNormalCfg.setForumName(this.huY.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGG() {
        if (this.adS == null) {
            this.cFt = new com.baidu.tieba.view.a(getActivity());
            this.adS = new com.baidu.tieba.person.e(getActivity(), this.cFt.bHj());
            this.adS.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.huG.setSystemUiVisibility(4);
                }
            });
        }
        if (this.cFt != null) {
            ArrayList arrayList = new ArrayList();
            a.C0257a c0257a = new a.C0257a(this.cFt);
            c0257a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.adS.dismiss();
                    if (VideoPlayFragment.this.huY != null) {
                        boolean z = VideoPlayFragment.this.huY.post_id != null && VideoPlayFragment.this.huY.post_id.equals(VideoPlayFragment.this.huY.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.huY.thread_id);
                        markData.setPostId(VideoPlayFragment.this.huY.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.huY.thread_id);
                        markData.setForumId(VideoPlayFragment.this.huY.forum_id);
                        if (VideoPlayFragment.this.fDf != null) {
                            VideoPlayFragment.this.fDf.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.fDf.sT();
                            } else {
                                VideoPlayFragment.this.fDf.sS();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.huY != null && this.huY.post_id != null && this.huY.post_id.equals(this.huY.mark_id)) {
                z = true;
            }
            if (z) {
                c0257a.setText(getResources().getString(e.j.remove_mark));
            } else {
                c0257a.setText(getResources().getString(e.j.mark));
            }
            arrayList.add(c0257a);
            a.C0257a c0257a2 = new a.C0257a(getActivity().getString(e.j.delete), this.cFt);
            c0257a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.adS.dismiss();
                    if (ba.bA(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.huY != null) {
                        String str = VideoPlayFragment.this.huY.thread_id;
                        String str2 = VideoPlayFragment.this.huY.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(e.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.huY.post_id, true)));
                    }
                }
            });
            c0257a2.setText(getResources().getString(e.j.report_text));
            arrayList.add(c0257a2);
            if (this.dXb) {
                a.C0257a c0257a3 = new a.C0257a(getActivity().getString(e.j.delete), this.cFt);
                c0257a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.adS.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.cp(e.j.del_thread_confirm);
                        aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.huY != null) {
                                    VideoPlayFragment.this.cFB.a(VideoPlayFragment.this.huY.forum_id, VideoPlayFragment.this.huY.forum_name, VideoPlayFragment.this.huY.thread_id, VideoPlayFragment.this.huY.post_id, 0, 0, VideoPlayFragment.this.dXb);
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
                        aVar.aE(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.yl();
                    }
                });
                c0257a3.setText(getResources().getString(e.j.delete));
                arrayList.add(c0257a3);
            }
            this.cFt.dN(arrayList);
        }
        this.adS.show();
    }

    private void bGH() {
        if (this.huY != null) {
            this.huH.startLoad(this.huY.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.huY.title);
            if (StringUtils.isNull(this.huY.title) || matcher.matches()) {
                this.huP.setVisibility(8);
            } else {
                this.huP.setVisibility(0);
                this.huP.setText(this.huY.title);
            }
            this.huR.setText(ao.L(com.baidu.adp.lib.g.b.d(this.huY.comment_num, 0L)));
            this.huS.setText(ao.L(com.baidu.adp.lib.g.b.d(this.huY.agree_num, 0L)));
            this.huT.setText(ao.L(com.baidu.adp.lib.g.b.d(this.huY.share_num, 0L)));
            if (this.huY.author_info != null) {
                if (!StringUtils.isNull(this.huY.author_info.portrait) && this.huY.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.huI.startLoad(this.huY.author_info.portrait, 10, false);
                } else {
                    this.huI.startLoad(this.huY.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.huY.author_info.bCV())) {
                    this.hvc.setVisibility(8);
                } else {
                    this.hvc.setVisibility(0);
                    this.hvc.setText("@" + this.huY.author_info.bCV());
                }
            }
            if ("1".equals(this.huY.is_private) && this.huZ.getVisibility() != 0) {
                this.huX.setVisibility(0);
            } else {
                this.huX.setVisibility(8);
            }
            if ("1".equals(this.huY.is_agreed)) {
                al.c(this.hvb, e.f.icon_card_like_white_full_s);
            } else {
                al.c(this.hvb, e.f.btn_video_agree);
            }
            if (this.huY.act_info != null && !StringUtils.isNull(this.huY.act_info.activity_name) && this.huZ.getVisibility() != 0) {
                this.huW.setVisibility(0);
                this.huQ.setText(this.huY.act_info.activity_name);
            } else {
                this.huW.setVisibility(8);
            }
            bGI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGI() {
        if (this.dXb || (this.huY.author_info != null && !"0".equals(this.huY.author_info.is_follow))) {
            this.huM.setVisibility(4);
            this.huM.setClickable(false);
            return;
        }
        this.huM.setVisibility(0);
        this.huM.setClickable(true);
    }

    private void bGJ() {
        if (getActivity() != null) {
            if (this.hvo == null || !this.hvo.isShowing()) {
                this.hvo = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(e.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(e.g.tv_title)).setText(e.j.confirm_title);
                ((TextView) inflate.findViewById(e.g.tv_msg)).setText(e.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(e.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(e.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.hvo.G(inflate);
                this.hvo.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.hvo.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.hvo.cr(1);
                this.hvo.cq(e.d.cp_cont_b);
                this.hvo.aE(true);
                this.hvo.b(getPageContext());
                this.hvo.yl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bGK() {
        if (!com.baidu.adp.lib.util.j.kK() || com.baidu.adp.lib.util.j.kL()) {
            return true;
        }
        if (!this.hva || com.baidu.tieba.video.g.bCZ().bDa()) {
            return false;
        }
        if (this.huU != null) {
            this.huU.setVisibility(0);
        }
        pausePlay();
        bGJ();
        return false;
    }

    private void aUr() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bGK() || com.baidu.tieba.video.g.bCZ().bDa()) && this.huG != null && this.huU != null) {
            this.huG.start();
            this.huU.setVisibility(8);
            bmw();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.hvi == null) {
            this.hvi = AnimationUtils.loadAnimation(getContext(), e.a.scale_zoom_in_and_out_anim);
        }
        return this.hvi;
    }

    public long bGL() {
        if (this.huV != null) {
            this.huV.setVisibility(8);
        }
        if (this.huZ != null) {
            this.huZ.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
    public void Qs() {
        if (this.huG.isPlaying()) {
            this.huG.pause();
            this.huU.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bGK() || com.baidu.tieba.video.g.bCZ().bDa()) {
            this.huG.start();
            this.huU.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
    public void q(float f, float f2) {
        if (ba.bA(getActivity()) && !this.hvj) {
            bGM();
            if (this.huY != null && "0".equals(this.huY.is_agreed)) {
                vv(this.huF);
            }
        }
    }

    private void bGM() {
        if (this.mRootView != null) {
            this.hvj = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(e.f.icon_video_like);
            if (this.hvl == null) {
                this.hvl = new RelativeLayout.LayoutParams(-2, -2);
                this.hvl.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.hvl);
            }
            if (this.hvk == null) {
                this.hvk = new AnimatorSet();
                this.hvk.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.hvj = false;
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
            this.hvk.setTarget(imageView);
            this.hvk.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.hvk.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
    public void Qt() {
        if (this.huY != null && this.huY.author_info != null) {
            long d = com.baidu.adp.lib.g.b.d(this.huY.author_info.user_id, 0L);
            long d2 = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = d == d2;
            if (d == 0 && d2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(d, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.huG != null) {
            return this.huG.getMediaIDs();
        }
        return null;
    }

    public String bGN() {
        if (this.huG != null) {
            return this.huG.getMediaId();
        }
        return null;
    }

    public boolean bGO() {
        if (this.hvn == null || this.hvn.IJ() == null || !this.hvn.IJ().isVisible()) {
            return false;
        }
        this.hvn.IJ().hide();
        this.hvd.setVisibility(0);
        if ((this.hvn.IJ().eZ(28) instanceof c) && ((c) this.hvn.IJ().eZ(28)).getInputView() != null && ((c) this.hvn.IJ().eZ(28)).getInputView().getText() != null) {
            this.hve.setText(StringUtils.isNull(((c) this.hvn.IJ().eZ(28)).getInputView().getText().toString()) ? e.j.reply_something : e.j.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.hvn != null) {
            this.hvn.onActivityResult(i, i2, intent);
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
        if (this.hvn != null && this.hvn.IJ() != null) {
            this.hvn.IJ().onChangeSkinType(i);
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
