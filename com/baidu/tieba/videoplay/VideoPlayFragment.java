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
import com.baidu.tbadk.a.b;
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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0274a {
    private e bCV;
    private String bHq;
    private String bXa;
    private boolean cFL;
    public ImageView dmY;
    private n dpp;
    private AlphaAnimation drz;
    private String dzf;
    private View eXx;
    private boolean gbx;
    private boolean isNewPlayer;
    public com.baidu.tieba.play.a.a ixp;
    private QuickVideoView.c iyB;
    private j.b iyk;
    public TextView jIA;
    private View jIB;
    private TextView jIC;
    private int jID;
    private int jIE;
    private int jIF;
    private com.baidu.tieba.view.a jIG;
    protected Animation jIH;
    private boolean jII;
    private AnimatorSet jIJ;
    private RelativeLayout.LayoutParams jIK;
    private com.baidu.tieba.videoplay.editor.a jIM;
    com.baidu.tbadk.core.dialog.a jIN;
    private TbImageView jIf;
    public HeadImageView jIg;
    public LinearLayout jIh;
    public LinearLayout jIi;
    public LinearLayout jIj;
    public ImageView jIk;
    public ImageView jIl;
    public ImageView jIm;
    public TextView jIn;
    public TextView jIo;
    public TextView jIp;
    public TextView jIq;
    public TextView jIr;
    public ImageView jIs;
    private LinearLayout jIt;
    public LinearLayout jIu;
    public LinearLayout jIv;
    public VideoItemData jIw;
    private TextView jIx;
    private boolean jIy;
    public ImageView jIz;
    public ImageView mBackBtn;
    private String mFrom;
    private Rect mRect;
    public View mRootView;
    private int jId = 0;
    private int jIe = 1;
    private ForumManageModel eFl = null;
    private com.baidu.tbadk.baseEditMark.a hNr = null;
    private com.baidu.tbadk.coreExtra.model.a bTT = null;
    private BdUniqueId XD = BdUniqueId.gen();
    private boolean jIL = false;
    private int playTime = 1;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.jIw != null && VideoPlayFragment.this.jIw.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jIw.author_info.user_id) && data != null && VideoPlayFragment.this.jIw.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.XD)) ? false : false;
                    if (data.ciI == null) {
                        if (!data.Hs) {
                            if (z && !"0".equals(VideoPlayFragment.this.jIw.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.jIw.author_info.is_follow = "0";
                                VideoPlayFragment.this.cyB();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.jIy) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.jIw));
                                    return;
                                }
                                VideoPlayFragment.this.jIw.author_info.is_follow = "1";
                                VideoPlayFragment.this.cyB();
                            }
                        } else {
                            VideoPlayFragment.this.jIw.author_info.is_follow = "0";
                            VideoPlayFragment.this.cyB();
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
                VideoPlayFragment.this.cyD();
            }
        }
    };

    static /* synthetic */ int w(VideoPlayFragment videoPlayFragment) {
        int i = videoPlayFragment.playTime;
        videoPlayFragment.playTime = i + 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.jIw = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.jIF = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.dzf = arguments.getString("from");
        this.bHq = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.jIw != null && this.jIw.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.jIw.author_info.user_id)) {
            this.gbx = true;
        }
        this.dpp = new n(getActivity());
        this.dpp.a(this.jIw);
        this.dpp.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bh(int i, int i2) {
                if (VideoPlayFragment.this.iyk != null) {
                    VideoPlayFragment.this.iyk.bh(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.ly("cyber_player_test");
        this.ixp = com.baidu.tieba.play.a.b.y(getContext(), this.isNewPlayer ? 1 : 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.mRootView).addView(this.ixp.getView(), 0);
        this.ixp.getView().setLayoutParams(layoutParams);
        this.ixp.setPageTypeForPerfStat("v_mid_page");
        if (cey()) {
            ((QuickVideoView) this.ixp).setPlayerReuseEnable(true);
            ((QuickVideoView) this.ixp).setNeedRecovery(true);
        }
        this.ixp.setContinuePlayEnable(true);
        this.ixp.setBusiness(this.dpp);
        if (this.jIw != null) {
            z zVar = new z();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.bXN = this.jIw.thread_id;
            zVar.eHo = this.jIw.forum_id;
            zVar.iAH = this.jIw.mMd5;
            zVar.bHq = "";
            zVar.mSource = this.jIw.mRecomSource;
            zVar.iAG = this.jIw.mRecomAbTag;
            zVar.iAE = this.jIw.mRecomWeight;
            if (this.mRect != null) {
                zVar.iAI = "1";
            } else {
                zVar.iAI = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.iAJ = "1";
                zVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                zVar.iAF = this.dzf;
                zVar.bHq = this.bHq;
                zVar.iAD = this.jIw.mRecomWeight;
            } else {
                zVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.dpp.setVideoStatsData(zVar);
        }
        this.ixp.setBusiness(this.dpp);
        this.jIf = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.jIf.setDefaultBgResource(R.drawable.icon_play_bg);
        this.jIf.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.aie()) {
            this.eXx = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.eXx.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.eXx.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.mBackBtn = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.dmY = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.jIg = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.jIg.setDefaultResource(17170445);
        this.jIg.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jIg.setIsRound(true);
        this.jIk = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.jIz = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.jIn = (TextView) this.mRootView.findViewById(R.id.video_title);
        this.jIo = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.jIi = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.jIp = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.jIh = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.jIq = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.jIr = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.jIl = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.jIm = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cyw();
        this.jIs = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.jIt = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.jIu = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.jIv = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.jIj = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.jIA = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.jIB = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.jIB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                    VideoPlayFragment.this.jIB.setVisibility(4);
                    if (VideoPlayFragment.this.jIM != null && VideoPlayFragment.this.jIM.asm() != null) {
                        VideoPlayFragment.this.jIM.asm().ql();
                    }
                    if (VideoPlayFragment.this.jIw != null) {
                        an anVar = new an("c13025");
                        anVar.bT("tid", VideoPlayFragment.this.jIw.thread_id);
                        anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.bT("fid", VideoPlayFragment.this.jIw.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.jIC = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.jIx = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.jIx.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.jIx.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.ahU().getString("nani_key_download_link_url", null);
        this.jIx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.ajK().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cyA();
        this.jIg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jIw != null && VideoPlayFragment.this.jIw.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.jIw.author_info.user_id) && VideoPlayFragment.this.jIw != null && VideoPlayFragment.this.jIw.author_info != null) {
                    long e = com.baidu.adp.lib.g.b.e(VideoPlayFragment.this.jIw.author_info.user_id, 0L);
                    long e2 = com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = e == e2;
                    if (e == 0 && e2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(e, z, false)));
                    an anVar = new an("c12798");
                    anVar.bT("tid", VideoPlayFragment.this.jIw.thread_id);
                    anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.jIu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jIw != null && VideoPlayFragment.this.jIw.act_info != null) {
                    com.baidu.tbadk.browser.a.af(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.jIw.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.bT("tid", VideoPlayFragment.this.jIw.thread_id);
                    anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.jIn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cyy();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.jIw != null && !StringUtils.isNull(VideoPlayFragment.this.jIw.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.jIw.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.dmY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cyz();
            }
        });
        this.jIi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cyy();
                an anVar = new an("c12796");
                anVar.bT("tid", VideoPlayFragment.this.jIw.thread_id);
                anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.jIh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.CB(VideoPlayFragment.this.jId);
            }
        });
        this.jIj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.alm();
                an anVar = new an("c12797");
                anVar.bT("tid", VideoPlayFragment.this.jIw.thread_id);
                anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.jIk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cF(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jIw != null && VideoPlayFragment.this.jIw.author_info != null) {
                    VideoPlayFragment.this.bTT.a(true, VideoPlayFragment.this.jIw.author_info.portrait, VideoPlayFragment.this.jIw.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.XD, VideoPlayFragment.this.jIw.forum_id, "0");
                    VideoPlayFragment.this.jIw.author_info.is_follow = "1";
                    VideoPlayFragment.this.cyB();
                }
            }
        });
        this.drz = new AlphaAnimation(1.0f, 0.0f);
        this.drz.setDuration(100L);
        this.drz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.jIf != null) {
                    VideoPlayFragment.this.jIf.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.jID = this.mRect.right - this.mRect.left;
            this.jIE = this.mRect.bottom - this.mRect.top;
            this.jIf.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.jIf.getWidth();
                    int height = VideoPlayFragment.this.jIf.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jIw.video_height, 0) > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jIw.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jIw.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jIw.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jID, VideoPlayFragment.this.jIE);
                            layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.jIf.setLayoutParams(layoutParams2);
                            if (VideoPlayFragment.this.jIE > 0 || VideoPlayFragment.this.jID <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.jID;
                                f = i / VideoPlayFragment.this.jIE;
                            }
                            VideoPlayFragment.this.jIf.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.jIf.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.jIy) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.jID, VideoPlayFragment.this.jIE);
                    layoutParams22.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams22.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.jIf.setLayoutParams(layoutParams22);
                    if (VideoPlayFragment.this.jIE > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.jIf.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.jIf.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.jIy) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.jIf.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.jIf.getWidth();
                    int height = VideoPlayFragment.this.jIf.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jIw.video_height, 0) > 0 && com.baidu.adp.lib.g.b.f(VideoPlayFragment.this.jIw.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jIw.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.jIw.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams2 = VideoPlayFragment.this.jIf.getLayoutParams();
                        layoutParams2.height = height;
                        layoutParams2.width = width;
                        VideoPlayFragment.this.jIf.setLayoutParams(layoutParams2);
                    }
                }
            });
        }
        initEditor();
        if (this.jIy) {
            cyx();
        }
        if (this.jIw != null && !StringUtils.isNull(this.jIw.video_url)) {
            GL(this.jIw.video_url);
        }
        return this.mRootView;
    }

    public boolean cey() {
        return !this.isNewPlayer && (this.ixp instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.iyk = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.iyB = cVar;
    }

    private void initEditor() {
        this.jIM = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().cK(getActivity());
        if (this.jIM != null && this.jIw != null) {
            this.jIM.a(getPageContext());
            this.jIM.af(this.jIw.thread_id, this.jIw.forum_id, this.jIw.forum_name);
            this.jIM.a(new a.InterfaceC0441a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0441a
                public void rU(boolean z) {
                    VideoPlayFragment.this.jIB.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.jIC.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.jIC.setText(StringUtils.isNull(((c) VideoPlayFragment.this.jIM.asm().kt(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.jIw != null && z) {
                        long e = com.baidu.adp.lib.g.b.e(VideoPlayFragment.this.jIw.comment_num, 0L) + 1;
                        VideoPlayFragment.this.jIw.comment_num = String.valueOf(e);
                        VideoPlayFragment.this.jIp.setText(aq.aO(e));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.jIM.asm(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alm() {
        if (this.jIw != null) {
            String str = this.jIw.forum_id;
            String str2 = this.jIw.forum_name;
            String str3 = this.jIw.title;
            String str4 = this.jIw.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.jIw.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str3;
            eVar.content = format;
            eVar.clK = "";
            eVar.linkUrl = str5;
            eVar.bMX = 2;
            eVar.extData = str4;
            eVar.clN = 3;
            eVar.fid = str;
            eVar.clE = str2;
            eVar.tid = str4;
            eVar.clx = true;
            eVar.clM = 0;
            eVar.clR = 2;
            if (parse != null) {
                eVar.imageUri = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.jIw.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.jIw.title;
            originalThreadInfo.threadId = this.jIw.thread_id;
            eVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(eVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.clN);
            bundle.putInt("obj_type", eVar.clR);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMX);
            eVar.E(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), eVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.bch().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gbx) {
            this.eFl = new ForumManageModel(getPageContext());
            this.eFl.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.eFl.getLoadDataMode()) {
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
        this.hNr = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.hNr != null) {
            this.hNr.a(new a.InterfaceC0247a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0247a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.hNr != null) {
                            VideoPlayFragment.this.hNr.dx(z2);
                        }
                        if (VideoPlayFragment.this.jIw != null) {
                            if (z2) {
                                VideoPlayFragment.this.jIw.mark_id = VideoPlayFragment.this.jIw.post_id;
                            } else {
                                VideoPlayFragment.this.jIw.mark_id = null;
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
        this.bTT = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.jIL = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cyA();
        if (Build.VERSION.SDK_INT >= 17) {
            this.ixp.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tieba.play.g.e
                public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.jIy) {
                        if ((i == 3 || i == 904) && VideoPlayFragment.this.jIf.getVisibility() == 0) {
                            VideoPlayFragment.this.jIf.clearAnimation();
                            VideoPlayFragment.this.jIf.startAnimation(VideoPlayFragment.this.drz);
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
            });
        }
        this.ixp.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.ixp != null) {
                    VideoPlayFragment.this.ixp.seekTo(0);
                    VideoPlayFragment.this.ixp.start();
                    VideoPlayFragment.this.bab();
                    VideoPlayFragment.w(VideoPlayFragment.this);
                    if (VideoPlayFragment.this.playTime == 3) {
                        VideoPlayFragment.this.cyv();
                    }
                }
            }
        });
        this.ixp.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (VideoPlayFragment.this.ixp != null) {
                    VideoPlayFragment.this.ixp.setVolume(1.0f, 1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyv() {
        if (this.jIm != null && this.jIl != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.jIl.clearAnimation();
            this.jIm.clearAnimation();
            this.jIl.setVisibility(8);
            this.jIm.setVisibility(0);
            this.jIm.startAnimation(scaleAnimation2);
            this.jIl.startAnimation(scaleAnimation);
        }
    }

    private void cyw() {
        if (this.jIm != null && this.jIl != null) {
            this.jIl.clearAnimation();
            this.jIm.clearAnimation();
            this.jIl.setVisibility(0);
            this.jIm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CB(int i) {
        int i2;
        if (bc.cF(getActivity()) && this.jIw != null) {
            if (i == this.jId) {
                if ("1".equals(this.jIw.is_agreed)) {
                    i2 = 1;
                    this.jIw.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jIw.agree_num, 0) - 1);
                    this.jIw.is_agreed = "0";
                } else {
                    this.jIw.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jIw.agree_num, 0) + 1);
                    this.jIw.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.jIw.agree_num = String.valueOf(com.baidu.adp.lib.g.b.f(this.jIw.agree_num, 0) + 1);
                this.jIw.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.bT("tid", this.jIw.thread_id);
            anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.jId) {
                anVar.P("obj_type", i2);
            } else {
                anVar.P("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            cyA();
            if (this.jIz != null && i2 == 0) {
                this.jIz.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.jIw.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.jIw));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.jIw != null && !StringUtils.isNull(this.jIw.video_url)) {
            this.cFL = true;
            if (this.jIy) {
                bab();
                bMd();
                if (this.jIw != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.bT("tid", this.jIw.thread_id);
                    anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.P("obj_type", 0);
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
        if (this.jIM != null && this.jIM.asm() != null) {
            this.jIM.asm().hide();
            this.jIB.setVisibility(0);
            this.jIC.setText(StringUtils.isNull(((c) this.jIM.asm().kt(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.jIM != null) {
            this.jIM.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.jIy = z;
        if (this.cFL) {
            if (this.jIy && (!this.jIL || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.jIw != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.bT("tid", this.jIw.thread_id);
                    anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.P("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                cyx();
                this.jIL = false;
                return;
            }
            cyw();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cyx() {
        if (this.jIw != null) {
            an anVar = new an("c12590");
            anVar.bT("tid", this.jIw.thread_id);
            anVar.bT("fid", this.jIw.forum_id);
            anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.P("obj_locate", this.jIF);
            anVar.P("obj_param2", 1);
            anVar.bT("obj_param1", aq.isEmpty(this.jIw.mRecomWeight) ? "0" : this.jIw.mRecomWeight);
            anVar.bT("extra", aq.isEmpty(this.jIw.mRecomExtra) ? "0" : this.jIw.mRecomExtra);
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bHq);
            anVar.bT("ab_tag", aq.isEmpty(this.jIw.mRecomAbTag) ? "0" : this.jIw.mRecomAbTag);
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aq.isEmpty(this.jIw.mRecomSource) ? "0" : this.jIw.mRecomSource);
            anVar.bT("obj_type", this.dzf);
            anVar.P("is_vertical", 1);
            TiebaStatic.log(anVar);
        }
    }

    private void GL(String str) {
        if (this.ixp != null && str != null && !str.equals(this.bXa)) {
            if (cey()) {
                ((QuickVideoView) this.ixp).setRecoveryState(0);
            }
            this.ixp.setVideoPath(str, this.jIw.thread_id);
            this.bXa = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.cuO().cuP() || cyD()) {
            ceM();
            if (this.jIs != null) {
                this.jIs.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.jIf.getVisibility() == 0) {
                this.jIf.clearAnimation();
                this.jIf.startAnimation(this.drz);
            }
            if (this.ixp != null) {
                this.ixp.start();
                bab();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bab() {
        if (this.jIw != null) {
            z zVar = new z();
            zVar.mLocate = "nani_midpage";
            zVar.bXN = this.jIw.thread_id;
            zVar.eHo = this.jIw.forum_id + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.jIw.mRecomSource;
            zVar.iAD = this.jIw.mRecomAbTag;
            zVar.iAE = this.jIw.mRecomWeight;
            zVar.iAF = "";
            zVar.bHq = "";
            zVar.iAH = this.jIw.mMd5;
            if (this.mRect != null) {
                zVar.iAI = "1";
            } else {
                zVar.iAI = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                zVar.iAJ = "1";
                zVar.mLocate = "auto_midpage";
                zVar.iAF = "index";
            }
            com.baidu.tieba.play.l.a(this.jIw.mMd5, "", "1", zVar);
        }
    }

    private void ceM() {
        if (com.baidu.adp.lib.util.j.ke()) {
            com.baidu.tieba.video.g.cuO().eq(getContext());
        }
    }

    private void pausePlay() {
        if (this.ixp != null) {
            this.ixp.pause();
        }
    }

    private void stopPlay() {
        if (this.ixp != null) {
            if (cey()) {
                ((QuickVideoView) this.ixp).setRecoveryState(5);
            }
            this.ixp.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyy() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.jIw.thread_id, this.jIw.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.jIw.forum_id));
        createNormalCfg.setForumName(this.jIw.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyz() {
        if (this.bCV == null) {
            this.jIG = new com.baidu.tieba.view.a(getActivity());
            this.bCV = new e(getActivity(), this.jIG.ahh());
            this.bCV.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.ixp.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.jIG != null) {
            ArrayList arrayList = new ArrayList();
            a.C0442a c0442a = new a.C0442a(this.jIG);
            c0442a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bCV.dismiss();
                    if (VideoPlayFragment.this.jIw != null) {
                        boolean z = VideoPlayFragment.this.jIw.post_id != null && VideoPlayFragment.this.jIw.post_id.equals(VideoPlayFragment.this.jIw.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.jIw.thread_id);
                        markData.setPostId(VideoPlayFragment.this.jIw.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.jIw.thread_id);
                        markData.setForumId(VideoPlayFragment.this.jIw.forum_id);
                        if (VideoPlayFragment.this.hNr != null) {
                            VideoPlayFragment.this.hNr.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.hNr.aaH();
                            } else {
                                VideoPlayFragment.this.hNr.aaG();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.jIw != null && this.jIw.post_id != null && this.jIw.post_id.equals(this.jIw.mark_id)) {
                z = true;
            }
            if (z) {
                c0442a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0442a.setText(getResources().getString(R.string.mark));
            }
            arrayList.add(c0442a);
            a.C0442a c0442a2 = new a.C0442a(getActivity().getString(R.string.delete), this.jIG);
            c0442a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.bCV.dismiss();
                    if (bc.cF(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.jIw != null) {
                        String str = VideoPlayFragment.this.jIw.thread_id;
                        String str2 = VideoPlayFragment.this.jIw.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.jIw.post_id, true)));
                    }
                }
            });
            c0442a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0442a2);
            if (this.gbx) {
                a.C0442a c0442a3 = new a.C0442a(getActivity().getString(R.string.delete), this.jIG);
                c0442a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.bCV.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.hv(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.jIw != null) {
                                    VideoPlayFragment.this.eFl.a(VideoPlayFragment.this.jIw.forum_id, VideoPlayFragment.this.jIw.forum_name, VideoPlayFragment.this.jIw.thread_id, VideoPlayFragment.this.jIw.post_id, 0, 0, VideoPlayFragment.this.gbx);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                                }
                            }
                        });
                        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.dQ(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.agO();
                    }
                });
                c0442a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0442a3);
            }
            this.jIG.W(arrayList);
        }
        this.bCV.show();
    }

    private void cyA() {
        if (this.jIw != null) {
            this.jIf.startLoad(this.jIw.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.jIw.title);
            if (StringUtils.isNull(this.jIw.title) || matcher.matches()) {
                this.jIn.setVisibility(8);
            } else {
                this.jIn.setVisibility(0);
                this.jIn.setText(this.jIw.title);
            }
            this.jIp.setText(aq.aO(com.baidu.adp.lib.g.b.e(this.jIw.comment_num, 0L)));
            this.jIq.setText(aq.aO(com.baidu.adp.lib.g.b.e(this.jIw.agree_num, 0L)));
            this.jIr.setText(aq.aO(com.baidu.adp.lib.g.b.e(this.jIw.share_num, 0L)));
            if (this.jIw.author_info != null) {
                if (!StringUtils.isNull(this.jIw.author_info.portrait) && this.jIw.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.jIg.startLoad(this.jIw.author_info.portrait, 10, false);
                } else {
                    this.jIg.startLoad(this.jIw.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.jIw.author_info.cuK())) {
                    this.jIA.setVisibility(8);
                } else {
                    this.jIA.setVisibility(0);
                    this.jIA.setText("@" + this.jIw.author_info.cuK());
                }
            }
            if ("1".equals(this.jIw.is_private) && this.jIx.getVisibility() != 0) {
                this.jIv.setVisibility(0);
            } else {
                this.jIv.setVisibility(8);
            }
            if ("1".equals(this.jIw.is_agreed)) {
                am.c(this.jIz, (int) R.drawable.icon_card_like_white_full_s);
            } else {
                am.c(this.jIz, (int) R.drawable.btn_video_agree);
            }
            if (this.jIw.act_info != null && !StringUtils.isNull(this.jIw.act_info.activity_name) && this.jIx.getVisibility() != 0) {
                this.jIu.setVisibility(0);
                this.jIo.setText(this.jIw.act_info.activity_name);
            } else {
                this.jIu.setVisibility(8);
            }
            cyB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyB() {
        if (this.gbx || (this.jIw.author_info != null && !"0".equals(this.jIw.author_info.is_follow))) {
            this.jIk.setVisibility(4);
            this.jIk.setClickable(false);
            return;
        }
        this.jIk.setVisibility(0);
        this.jIk.setClickable(true);
    }

    private void cyC() {
        if (getActivity() != null) {
            if (this.jIN == null || !this.jIN.isShowing()) {
                this.jIN = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.a(true, VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.ajv().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, null);
                this.jIN.aH(inflate);
                this.jIN.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.jIN.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.jIN.hy(1);
                this.jIN.hw(R.color.cp_cont_b);
                this.jIN.dQ(true);
                this.jIN.b(getPageContext());
                this.jIN.agO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyD() {
        if (!com.baidu.adp.lib.util.j.kc() || com.baidu.adp.lib.util.j.kd()) {
            return true;
        }
        if (!this.jIy || com.baidu.tieba.video.g.cuO().cuP()) {
            return false;
        }
        if (this.jIs != null) {
            this.jIs.setVisibility(0);
        }
        pausePlay();
        cyC();
        return false;
    }

    private void bMd() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cyD() || com.baidu.tieba.video.g.cuO().cuP()) && this.ixp != null && this.jIs != null) {
            this.ixp.bMd();
            this.jIs.setVisibility(8);
            ceM();
            if (this.iyB != null) {
                this.iyB.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.jIH == null) {
            this.jIH = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.jIH;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0274a
    public void aAD() {
        if (this.ixp.isPlaying()) {
            this.ixp.pause();
            this.jIs.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cyD() || com.baidu.tieba.video.g.cuO().cuP()) {
            this.ixp.start();
            this.jIs.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0274a
    public void x(float f, float f2) {
        if (bc.cF(getActivity()) && !this.jII) {
            cyE();
            if (this.jIw != null && "0".equals(this.jIw.is_agreed)) {
                CB(this.jIe);
            }
        }
    }

    private void cyE() {
        if (this.mRootView != null) {
            this.jII = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.jIK == null) {
                this.jIK = new RelativeLayout.LayoutParams(-2, -2);
                this.jIK.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.jIK);
            }
            if (this.jIJ == null) {
                this.jIJ = new AnimatorSet();
                this.jIJ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.jII = false;
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
            this.jIJ.setTarget(imageView);
            this.jIJ.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.jIJ.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0274a
    public void aAE() {
        if (this.jIw != null && this.jIw.author_info != null) {
            long e = com.baidu.adp.lib.g.b.e(this.jIw.author_info.user_id, 0L);
            long e2 = com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = e == e2;
            if (e == 0 && e2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(e, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cey()) {
            return ((QuickVideoView) this.ixp).getMediaIDs();
        }
        return null;
    }

    public String cyF() {
        if (cey()) {
            return ((QuickVideoView) this.ixp).getMediaId();
        }
        return null;
    }

    public boolean cyG() {
        if (this.jIM == null || this.jIM.asm() == null || !this.jIM.asm().isVisible()) {
            return false;
        }
        this.jIM.asm().hide();
        this.jIB.setVisibility(0);
        if ((this.jIM.asm().kt(28) instanceof c) && ((c) this.jIM.asm().kt(28)).getInputView() != null && ((c) this.jIM.asm().kt(28)).getInputView().getText() != null) {
            this.jIC.setText(StringUtils.isNull(((c) this.jIM.asm().kt(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.jIM != null) {
            this.jIM.onActivityResult(i, i2, intent);
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
        if (this.jIM != null && this.jIM.asm() != null) {
            this.jIM.asm().onChangeSkinType(i);
        }
        SvgManager.ajv().a(this.mBackBtn, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
