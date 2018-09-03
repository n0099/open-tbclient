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
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.f;
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
    private boolean aXT;
    private e abp;
    private String afx;
    protected ScaleAnimation axA;
    private String bBN;
    private String bdb;
    public ImageView bsX;
    private n bvt;
    private AlphaAnimation byY;
    private com.baidu.tieba.view.a czB;
    private boolean dPJ;
    private View dcJ;
    private j.b gff;
    private QuickVideoView.c gfv;
    public QuickVideoView hmR;
    private TbImageView hmS;
    public HeadImageView hmT;
    public LinearLayout hmU;
    public LinearLayout hmV;
    public LinearLayout hmW;
    public ImageView hmX;
    public TextView hmY;
    public TextView hmZ;
    public TextView hna;
    public TextView hnb;
    public TextView hnc;
    public ImageView hnd;
    private LinearLayout hne;
    public LinearLayout hnf;
    public LinearLayout hng;
    public VideoItemData hnh;
    private TextView hni;
    private boolean hnj;
    public ImageView hnk;
    public TextView hnl;
    private View hnm;
    private TextView hnn;
    private int hno;
    private int hnp;
    private int hnq;
    private boolean hnr;
    private AnimatorSet hns;
    private RelativeLayout.LayoutParams hnt;
    private com.baidu.tieba.videoplay.editor.a hnv;
    com.baidu.tbadk.core.dialog.a hnw;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int hmP = 0;
    private int hmQ = 1;
    private ForumManageModel czJ = null;
    private com.baidu.tbadk.baseEditMark.a fvn = null;
    private com.baidu.tbadk.coreExtra.model.a aqF = null;
    private BdUniqueId aqw = BdUniqueId.gen();
    private boolean hnu = false;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.hnh != null && VideoPlayFragment.this.hnh.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hnh.author_info.user_id) && data != null && VideoPlayFragment.this.hnh.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aqw)) ? false : false;
                    if (data.aDt == null) {
                        if (!data.Gp) {
                            if (z && !"0".equals(VideoPlayFragment.this.hnh.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), f.j.attention_fail);
                                VideoPlayFragment.this.hnh.author_info.is_follow = "0";
                                VideoPlayFragment.this.bDR();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.hnj) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), f.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.hnh));
                                    return;
                                }
                                VideoPlayFragment.this.hnh.author_info.is_follow = "1";
                                VideoPlayFragment.this.bDR();
                            }
                        } else {
                            VideoPlayFragment.this.hnh.author_info.is_follow = "0";
                            VideoPlayFragment.this.bDR();
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
                VideoPlayFragment.this.bDT();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.hnh = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hnq = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.bBN = arguments.getString("from");
        this.afx = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.hnh != null && this.hnh.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hnh.author_info.user_id)) {
            this.dPJ = true;
        }
        this.bvt = new n(getActivity());
        this.bvt.a(this.hnh);
        this.bvt.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bx(int i, int i2) {
                if (VideoPlayFragment.this.gff != null) {
                    VideoPlayFragment.this.gff.bx(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(f.h.video_play_view, (ViewGroup) null);
        this.hmR = (QuickVideoView) this.mRootView.findViewById(f.g.videoView);
        this.hmR.setBusiness(this.bvt);
        this.hmR.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                if (VideoPlayFragment.this.gfv != null) {
                    VideoPlayFragment.this.gfv.onStart();
                }
            }
        });
        this.hmR.setNeedRecovery(true);
        if (this.hnh != null) {
            y yVar = new y();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.aWq = this.hnh.thread_id;
            yVar.cBR = this.hnh.forum_id;
            yVar.ghF = this.hnh.mMd5;
            yVar.afx = "";
            yVar.mSource = this.hnh.mRecomSource;
            yVar.ghE = this.hnh.mRecomAbTag;
            yVar.ghC = this.hnh.mRecomWeight;
            if (this.mRect != null) {
                yVar.ghG = "1";
            } else {
                yVar.ghG = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.ghH = "1";
                yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                yVar.ghD = this.bBN;
                yVar.afx = this.afx;
                yVar.ghB = this.hnh.mRecomWeight;
            } else {
                yVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.bvt.setVideoStatsData(yVar);
        }
        this.hmS = (TbImageView) this.mRootView.findViewById(f.g.video_cover);
        this.hmS.setDefaultBgResource(f.C0146f.icon_play_bg);
        this.hmS.setDefaultErrorResource(f.C0146f.icon_play_bg);
        if (g.yf()) {
            this.dcJ = this.mRootView.findViewById(f.g.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.dcJ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dcJ.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(f.g.back_btn);
        this.bsX = (ImageView) this.mRootView.findViewById(f.g.more_btn);
        this.hmT = (HeadImageView) this.mRootView.findViewById(f.g.author_portrait);
        this.hmT.setDefaultResource(17170445);
        this.hmT.setDefaultBgResource(f.d.cp_bg_line_e);
        this.hmT.setIsRound(true);
        this.hmX = (ImageView) this.mRootView.findViewById(f.g.love_btn);
        this.hnk = (ImageView) this.mRootView.findViewById(f.g.agree_img);
        this.hmY = (TextView) this.mRootView.findViewById(f.g.video_title);
        this.hmZ = (TextView) this.mRootView.findViewById(f.g.video_activity);
        this.hmV = (LinearLayout) this.mRootView.findViewById(f.g.comment_container);
        this.hna = (TextView) this.mRootView.findViewById(f.g.comment_num);
        this.hmU = (LinearLayout) this.mRootView.findViewById(f.g.agree_container);
        this.hnb = (TextView) this.mRootView.findViewById(f.g.agree_num);
        this.hnc = (TextView) this.mRootView.findViewById(f.g.share_num);
        this.hnd = (ImageView) this.mRootView.findViewById(f.g.play_btn);
        this.hne = (LinearLayout) this.mRootView.findViewById(f.g.video_act_private_container);
        this.hnf = (LinearLayout) this.mRootView.findViewById(f.g.video_activity_container);
        this.hng = (LinearLayout) this.mRootView.findViewById(f.g.video_private);
        this.hmW = (LinearLayout) this.mRootView.findViewById(f.g.share_container);
        this.hnl = (TextView) this.mRootView.findViewById(f.g.video_author_name);
        this.hnm = this.mRootView.findViewById(f.g.quick_reply_comment_layout);
        this.hnm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.hnm.setVisibility(4);
                    if (VideoPlayFragment.this.hnv != null && VideoPlayFragment.this.hnv.Ht() != null) {
                        VideoPlayFragment.this.hnv.Ht().oC();
                    }
                    if (VideoPlayFragment.this.hnh != null) {
                        an anVar = new an("c13025");
                        anVar.ae("tid", VideoPlayFragment.this.hnh.thread_id);
                        anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.ae(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.hnh.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.hnn = (TextView) this.mRootView.findViewById(f.g.quick_reply_comment_text);
        this.hni = (TextView) this.mRootView.findViewById(f.g.download_nani_guide_txt);
        this.hni.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hni.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.hni.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    az.zI().a((TbPageContext) i.ad(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bDQ();
        this.hmT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hnh != null && VideoPlayFragment.this.hnh.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hnh.author_info.user_id) && VideoPlayFragment.this.hnh != null && VideoPlayFragment.this.hnh.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hnh.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(c, z, false)));
                    an anVar = new an("c12798");
                    anVar.ae("tid", VideoPlayFragment.this.hnh.thread_id);
                    anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.hnf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hnh != null && VideoPlayFragment.this.hnh.act_info != null) {
                    com.baidu.tbadk.browser.a.S(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.hnh.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.ae("tid", VideoPlayFragment.this.hnh.thread_id);
                    anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.hmY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bDO();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hnh != null && !StringUtils.isNull(VideoPlayFragment.this.hnh.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.hnh.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.bsX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bDP();
            }
        });
        this.hmV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bDO();
                an anVar = new an("c12796");
                anVar.ae("tid", VideoPlayFragment.this.hnh.thread_id);
                anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.hmU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.uV(VideoPlayFragment.this.hmP);
            }
        });
        this.hmW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.AJ();
                an anVar = new an("c12797");
                anVar.ae("tid", VideoPlayFragment.this.hnh.thread_id);
                anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.hmX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bb.aU(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hnh != null && VideoPlayFragment.this.hnh.author_info != null) {
                    VideoPlayFragment.this.aqF.a(true, VideoPlayFragment.this.hnh.author_info.portrait, VideoPlayFragment.this.hnh.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.aqw, VideoPlayFragment.this.hnh.forum_id, "0");
                    VideoPlayFragment.this.hnh.author_info.is_follow = "1";
                    VideoPlayFragment.this.bDR();
                }
            }
        });
        this.byY = new AlphaAnimation(1.0f, 0.0f);
        this.byY.setDuration(100L);
        this.byY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.hmS != null) {
                    VideoPlayFragment.this.hmS.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.hno = this.mRect.right - this.mRect.left;
            this.hnp = this.mRect.bottom - this.mRect.top;
            this.hmS.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.hmS.getWidth();
                    int height = VideoPlayFragment.this.hmS.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hnh.video_height, 0) > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hnh.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hnh.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hnh.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hno, VideoPlayFragment.this.hnp);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.hmS.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hnp > 0 || VideoPlayFragment.this.hno <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.hno;
                                f = i / VideoPlayFragment.this.hnp;
                            }
                            VideoPlayFragment.this.hmS.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.hmS.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.hnj) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hno, VideoPlayFragment.this.hnp);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.hmS.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hnp > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.hmS.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.hmS.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.hnj) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.hmS.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.hmS.getWidth();
                    int height = VideoPlayFragment.this.hmS.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hnh.video_height, 0) > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hnh.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hnh.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hnh.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.hmS.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.hmS.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.hnj) {
            bDN();
        }
        if (this.hnh != null && !StringUtils.isNull(this.hnh.video_url)) {
            vm(this.hnh.video_url);
        }
        return this.mRootView;
    }

    public void a(j.b bVar) {
        this.gff = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gfv = cVar;
    }

    private void initEditor() {
        this.hnv = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().aY(getActivity());
        if (this.hnv != null && this.hnh != null) {
            this.hnv.setContext(getPageContext());
            this.hnv.J(this.hnh.thread_id, this.hnh.forum_id, this.hnh.forum_name);
            this.hnv.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0250a
                public void ng(boolean z) {
                    VideoPlayFragment.this.hnm.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.hnn.setText(f.j.reply_something);
                    } else {
                        VideoPlayFragment.this.hnn.setText(StringUtils.isNull(((c) VideoPlayFragment.this.hnv.Ht().eN(28)).getInputView().getText().toString()) ? f.j.reply_something : f.j.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.hnh != null && z) {
                        VideoPlayFragment.this.hna.setText(ap.H(com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hnh.comment_num, 0L) + 1));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.hnv.Ht(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ() {
        if (this.hnh != null) {
            String str = this.hnh.forum_id;
            String str2 = this.hnh.forum_name;
            String str3 = this.hnh.title;
            String str4 = this.hnh.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hnh.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(f.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            d dVar = new d();
            dVar.title = str3;
            dVar.content = format;
            dVar.aGe = "";
            dVar.linkUrl = str5;
            dVar.ajX = 2;
            dVar.extData = str4;
            dVar.aGh = 3;
            dVar.fid = str;
            dVar.aGa = str2;
            dVar.tid = str4;
            dVar.aFW = true;
            dVar.aGg = 0;
            dVar.aGi = 2;
            if (parse != null) {
                dVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hnh.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hnh.title;
            originalThreadInfo.threadId = this.hnh.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aGh);
            bundle.putInt("obj_type", dVar.aGi);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ajX);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.akQ().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.dPJ) {
            this.czJ = new ForumManageModel(getPageContext());
            this.czJ.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.czJ.getLoadDataMode()) {
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
        this.fvn = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.fvn != null) {
            this.fvn.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0097a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.fvn != null) {
                            VideoPlayFragment.this.fvn.ae(z2);
                        }
                        if (VideoPlayFragment.this.hnh != null) {
                            if (z2) {
                                VideoPlayFragment.this.hnh.mark_id = VideoPlayFragment.this.hnh.post_id;
                            } else {
                                VideoPlayFragment.this.hnh.mark_id = null;
                            }
                        }
                        if (z2) {
                            VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(f.j.add_mark));
                            return;
                        } else {
                            VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(f.j.remove_mark));
                            return;
                        }
                    }
                    VideoPlayFragment.this.showToast(VideoPlayFragment.this.getPageContext().getString(f.j.update_mark_failed));
                }
            });
        }
        this.aqF = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.hnu = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bDQ();
        if (Build.VERSION.SDK_INT >= 17) {
            this.hmR.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.play.g.e
                public boolean a(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.hnj && i == 3 && VideoPlayFragment.this.hmS.getVisibility() == 0) {
                        VideoPlayFragment.this.hmS.clearAnimation();
                        VideoPlayFragment.this.hmS.startAnimation(VideoPlayFragment.this.byY);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.hmR.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.hmR != null) {
                    VideoPlayFragment.this.hmR.seekTo(0);
                    x.bkT().remove(VideoPlayFragment.this.bdb);
                    VideoPlayFragment.this.hmR.start();
                    VideoPlayFragment.this.aiL();
                }
            }
        });
        this.hmR.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                int sh = x.bkT().sh(VideoPlayFragment.this.bdb);
                if (sh != 0) {
                    VideoPlayFragment.this.hmR.rH(sh);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uV(int i) {
        int i2;
        if (bb.aU(getActivity()) && this.hnh != null) {
            if (i == this.hmP) {
                if ("1".equals(this.hnh.is_agreed)) {
                    i2 = 1;
                    this.hnh.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.hnh.agree_num, 0) - 1);
                    this.hnh.is_agreed = "0";
                } else {
                    this.hnh.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.hnh.agree_num, 0) + 1);
                    this.hnh.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.hnh.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.hnh.agree_num, 0) + 1);
                this.hnh.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.ae("tid", this.hnh.thread_id);
            anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.hmP) {
                anVar.r("obj_type", i2);
            } else {
                anVar.r("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            bDQ();
            if (this.hnk != null && i2 == 0) {
                this.hnk.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hnh.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hnh));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hnh != null && !StringUtils.isNull(this.hnh.video_url)) {
            this.aXT = true;
            if (this.hnj) {
                aiL();
                aSd();
                if (this.hnh != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.ae("tid", this.hnh.thread_id);
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
        if (this.hnv != null && this.hnv.Ht() != null) {
            this.hnv.Ht().hide();
        }
        this.hnm.setVisibility(0);
        this.hnn.setText(StringUtils.isNull(((c) this.hnv.Ht().eN(28)).getInputView().getText().toString()) ? f.j.reply_something : f.j.draft_to_replay);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        if (this.hnv != null) {
            this.hnv.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.hnj = z;
        if (this.aXT) {
            if (this.hnj && (!this.hnu || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.hnh != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.ae("tid", this.hnh.thread_id);
                    anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.r("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                bDN();
                this.hnu = false;
                return;
            }
            pausePlay();
        }
    }

    private void bDN() {
        if (this.hnh != null) {
            an anVar = new an("c12590");
            anVar.ae("tid", this.hnh.thread_id);
            anVar.ae(ImageViewerConfig.FORUM_ID, this.hnh.forum_id);
            anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.r("obj_locate", this.hnq);
            anVar.ae("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.r("obj_param2", 1);
            anVar.ae("obj_param1", this.hnh.mRecomWeight);
            anVar.ae("extra", this.hnh.mRecomExtra);
            anVar.ae(VideoPlayActivityConfig.OBJ_ID, this.afx);
            anVar.ae("ab_tag", this.hnh.mRecomAbTag);
            anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hnh.mRecomSource);
            anVar.ae("obj_type", this.bBN);
            anVar.r("is_vertical", 1);
            TiebaStatic.log(anVar);
        }
    }

    private void vm(String str) {
        if (this.hmR != null && str != null && !str.equals(this.bdb)) {
            this.hmR.setRecoveryState(0);
            this.hmR.setVideoPath(str, this.hnh.thread_id);
            this.bdb = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.bAk().bAl() || bDT()) {
            bjT();
            if (this.hnd != null) {
                this.hnd.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hmS.getVisibility() == 0) {
                this.hmS.clearAnimation();
                this.hmS.startAnimation(this.byY);
            }
            if (this.hmR != null) {
                this.hmR.start();
                int sh = x.bkT().sh(this.bdb);
                if (sh != 0) {
                    this.hmR.rH(sh);
                }
                aiL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiL() {
        if (this.hnh != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.aWq = this.hnh.thread_id;
            yVar.cBR = this.hnh.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.hnh.mRecomSource;
            yVar.ghB = this.hnh.mRecomAbTag;
            yVar.ghC = this.hnh.mRecomWeight;
            yVar.ghD = "";
            yVar.afx = "";
            yVar.ghF = this.hnh.mMd5;
            if (this.mRect != null) {
                yVar.ghG = "1";
            } else {
                yVar.ghG = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.ghH = "1";
                yVar.mLocate = "auto_midpage";
                yVar.ghD = "index";
            }
            com.baidu.tieba.play.l.a(this.hnh.mMd5, "", "1", yVar);
        }
    }

    private void bjT() {
        if (com.baidu.adp.lib.util.j.jG()) {
            com.baidu.tieba.video.g.bAk().ck(getContext());
        }
    }

    private void pausePlay() {
        if (this.hmR != null) {
            if (this.hmR.isPlaying()) {
                x.bkT().aD(this.bdb, this.hmR.getCurrentPosition());
            }
            this.hmR.pause();
        }
    }

    private void stopPlay() {
        if (this.hmR != null) {
            if (this.hmR.isPlaying()) {
                x.bkT().aD(this.bdb, this.hmR.getCurrentPosition());
            }
            this.hmR.setRecoveryState(5);
            this.hmR.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDO() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hnh.thread_id, this.hnh.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hnh.forum_id));
        createNormalCfg.setForumName(this.hnh.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDP() {
        if (this.abp == null) {
            this.czB = new com.baidu.tieba.view.a(getActivity());
            this.abp = new e(getActivity(), this.czB.bEs());
            this.abp.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.hmR.setSystemUiVisibility(4);
                }
            });
        }
        if (this.czB != null) {
            ArrayList arrayList = new ArrayList();
            a.C0251a c0251a = new a.C0251a(this.czB);
            c0251a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.abp.dismiss();
                    if (VideoPlayFragment.this.hnh != null) {
                        boolean z = VideoPlayFragment.this.hnh.post_id != null && VideoPlayFragment.this.hnh.post_id.equals(VideoPlayFragment.this.hnh.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.hnh.thread_id);
                        markData.setPostId(VideoPlayFragment.this.hnh.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.hnh.thread_id);
                        markData.setForumId(VideoPlayFragment.this.hnh.forum_id);
                        if (VideoPlayFragment.this.fvn != null) {
                            VideoPlayFragment.this.fvn.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.fvn.rN();
                            } else {
                                VideoPlayFragment.this.fvn.rM();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hnh != null && this.hnh.post_id != null && this.hnh.post_id.equals(this.hnh.mark_id)) {
                z = true;
            }
            if (z) {
                c0251a.setText(getResources().getString(f.j.remove_mark));
            } else {
                c0251a.setText(getResources().getString(f.j.mark));
            }
            arrayList.add(c0251a);
            a.C0251a c0251a2 = new a.C0251a(getActivity().getString(f.j.delete), this.czB);
            c0251a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.abp.dismiss();
                    if (bb.aU(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hnh != null) {
                        String str = VideoPlayFragment.this.hnh.thread_id;
                        String str2 = VideoPlayFragment.this.hnh.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(f.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.hnh.post_id, true)));
                    }
                }
            });
            c0251a2.setText(getResources().getString(f.j.report_text));
            arrayList.add(c0251a2);
            if (this.dPJ) {
                a.C0251a c0251a3 = new a.C0251a(getActivity().getString(f.j.delete), this.czB);
                c0251a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.abp.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.cf(f.j.del_thread_confirm);
                        aVar.a(f.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.hnh != null) {
                                    VideoPlayFragment.this.czJ.a(VideoPlayFragment.this.hnh.forum_id, VideoPlayFragment.this.hnh.forum_name, VideoPlayFragment.this.hnh.thread_id, VideoPlayFragment.this.hnh.post_id, 0, 0, VideoPlayFragment.this.dPJ);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                                }
                            }
                        });
                        aVar.b(f.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.av(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.xe();
                    }
                });
                c0251a3.setText(getResources().getString(f.j.delete));
                arrayList.add(c0251a3);
            }
            this.czB.dM(arrayList);
        }
        this.abp.show();
    }

    private void bDQ() {
        if (this.hnh != null) {
            this.hmS.startLoad(this.hnh.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.hnh.title);
            if (StringUtils.isNull(this.hnh.title) || matcher.matches()) {
                this.hmY.setVisibility(8);
            } else {
                this.hmY.setVisibility(0);
                this.hmY.setText(this.hnh.title);
            }
            this.hna.setText(ap.H(com.baidu.adp.lib.g.b.c(this.hnh.comment_num, 0L)));
            this.hnb.setText(ap.H(com.baidu.adp.lib.g.b.c(this.hnh.agree_num, 0L)));
            this.hnc.setText(ap.H(com.baidu.adp.lib.g.b.c(this.hnh.share_num, 0L)));
            if (this.hnh.author_info != null) {
                if (!StringUtils.isNull(this.hnh.author_info.portrait) && this.hnh.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.hmT.startLoad(this.hnh.author_info.portrait, 10, false);
                } else {
                    this.hmT.startLoad(this.hnh.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.hnh.author_info.bAg())) {
                    this.hnl.setVisibility(8);
                } else {
                    this.hnl.setVisibility(0);
                    this.hnl.setText("@" + this.hnh.author_info.bAg());
                }
            }
            if ("1".equals(this.hnh.is_private) && this.hni.getVisibility() != 0) {
                this.hng.setVisibility(0);
            } else {
                this.hng.setVisibility(8);
            }
            if ("1".equals(this.hnh.is_agreed)) {
                am.c(this.hnk, f.C0146f.icon_home_card_like_s);
            } else {
                am.c(this.hnk, f.C0146f.btn_video_agree);
            }
            if (this.hnh.act_info != null && !StringUtils.isNull(this.hnh.act_info.activity_name) && this.hni.getVisibility() != 0) {
                this.hnf.setVisibility(0);
                this.hmZ.setText(this.hnh.act_info.activity_name);
            } else {
                this.hnf.setVisibility(8);
            }
            bDR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDR() {
        if (this.dPJ || (this.hnh.author_info != null && !"0".equals(this.hnh.author_info.is_follow))) {
            this.hmX.setVisibility(4);
            this.hmX.setClickable(false);
            return;
        }
        this.hmX.setVisibility(0);
        this.hmX.setClickable(true);
    }

    private void bDS() {
        if (getActivity() != null) {
            if (this.hnw == null || !this.hnw.isShowing()) {
                this.hnw = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(f.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(f.g.tv_title)).setText(f.j.confirm_title);
                ((TextView) inflate.findViewById(f.g.tv_msg)).setText(f.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(f.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(f.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                this.hnw.w(inflate);
                this.hnw.a(f.j.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.hnw.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.hnw.ch(1);
                this.hnw.cg(f.d.cp_cont_b);
                this.hnw.av(true);
                this.hnw.b(getPageContext());
                this.hnw.xe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDT() {
        if (!com.baidu.adp.lib.util.j.jE() || com.baidu.adp.lib.util.j.jF()) {
            return true;
        }
        if (!this.hnj || com.baidu.tieba.video.g.bAk().bAl()) {
            return false;
        }
        if (this.hnd != null) {
            this.hnd.setVisibility(0);
        }
        pausePlay();
        bDS();
        return false;
    }

    private void aSd() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bDT() || com.baidu.tieba.video.g.bAk().bAl()) && this.hmR != null && this.hnd != null) {
            this.hmR.start();
            int sh = x.bkT().sh(this.bdb);
            if (sh != 0) {
                this.hmR.rH(sh);
            }
            this.hnd.setVisibility(8);
            bjT();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.axA == null) {
            this.axA = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axA.setDuration(200L);
        }
        return this.axA;
    }

    public long bDU() {
        if (this.hne != null) {
            this.hne.setVisibility(8);
        }
        if (this.hni != null) {
            this.hni.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
    public void Oy() {
        if (this.hmR.isPlaying()) {
            x.bkT().aD(this.bdb, this.hmR.getCurrentPosition());
            this.hmR.pause();
            this.hnd.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bDT() || com.baidu.tieba.video.g.bAk().bAl()) {
            this.hmR.start();
            this.hnd.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
    public void q(float f, float f2) {
        if (bb.aU(getActivity()) && !this.hnr) {
            bDV();
            if (this.hnh != null && "0".equals(this.hnh.is_agreed)) {
                uV(this.hmQ);
            }
        }
    }

    private void bDV() {
        if (this.mRootView != null) {
            this.hnr = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(f.C0146f.icon_video_like);
            if (this.hnt == null) {
                this.hnt = new RelativeLayout.LayoutParams(-2, -2);
                this.hnt.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.hnt);
            }
            if (this.hns == null) {
                this.hns = new AnimatorSet();
                this.hns.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.hnr = false;
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
            this.hns.setTarget(imageView);
            this.hns.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.hns.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
    public void Oz() {
        if (this.hnh != null && this.hnh.author_info != null) {
            long c = com.baidu.adp.lib.g.b.c(this.hnh.author_info.user_id, 0L);
            long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = c == c2;
            if (c == 0 && c2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(c, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.hmR != null) {
            return this.hmR.getMediaIDs();
        }
        return null;
    }

    public String bDW() {
        if (this.hmR != null) {
            return this.hmR.getMediaId();
        }
        return null;
    }

    public boolean bDX() {
        if (this.hnv == null || this.hnv.Ht() == null || !this.hnv.Ht().isVisible()) {
            return false;
        }
        this.hnv.Ht().hide();
        this.hnm.setVisibility(0);
        if ((this.hnv.Ht().eN(28) instanceof c) && ((c) this.hnv.Ht().eN(28)).getInputView() != null && ((c) this.hnv.Ht().eN(28)).getInputView().getText() != null) {
            this.hnn.setText(StringUtils.isNull(((c) this.hnv.Ht().eN(28)).getInputView().getText().toString()) ? f.j.reply_something : f.j.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.hnv != null) {
            this.hnv.onActivityResult(i, i2, intent);
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
        if (this.hnv != null && this.hnv.Ht() != null) {
            this.hnv.Ht().onChangeSkinType(i);
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
