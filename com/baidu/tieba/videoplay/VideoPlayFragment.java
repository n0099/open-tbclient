package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
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
    private String XM;
    private boolean aOV;
    protected ScaleAnimation apc;
    public ImageView biv;
    private n bkR;
    private e cpy;
    private a cpz;
    private boolean dxu;
    public QuickVideoView gUU;
    private TbImageView gUV;
    public TbImageView gUW;
    public LinearLayout gUX;
    public LinearLayout gUY;
    public LinearLayout gUZ;
    public ImageView gVa;
    public TextView gVb;
    public TextView gVc;
    public TextView gVd;
    public TextView gVe;
    public TextView gVf;
    public ImageView gVg;
    private LinearLayout gVh;
    public LinearLayout gVi;
    public LinearLayout gVj;
    public VideoItemData gVk;
    private TextView gVl;
    private AlphaAnimation gVm;
    public ImageView gVn;
    public TextView gVo;
    private View gVp;
    private TextView gVq;
    private int gVr;
    private int gVs;
    private int gVt;
    private boolean gVu;
    private AnimatorSet gVv;
    private RelativeLayout.LayoutParams gVw;
    private boolean gVx;
    private com.baidu.tieba.videoplay.editor.a gVy;
    com.baidu.tbadk.core.dialog.a gVz;
    public ImageView mBackBtn;
    private String mFrom;
    private boolean mIsVisible;
    private Rect mRect;
    public View mRootView;
    private int gUS = 0;
    private int gUT = 1;
    private ForumManageModel cpH = null;
    private com.baidu.tbadk.baseEditMark.a eGw = null;
    private com.baidu.tbadk.coreExtra.model.a ait = null;
    private BdUniqueId aBK = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.gVk != null && VideoPlayFragment.this.gVk.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.gVk.author_info.user_id) && data != null && VideoPlayFragment.this.gVk.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aBK)) ? false : false;
                    if (data.auo == null) {
                        if (!data.Aj) {
                            if (z && !"0".equals(VideoPlayFragment.this.gVk.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), d.k.attention_fail);
                                VideoPlayFragment.this.gVk.author_info.is_follow = "0";
                                VideoPlayFragment.this.bzF();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), d.k.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.gVk));
                                    return;
                                }
                                VideoPlayFragment.this.gVk.author_info.is_follow = "1";
                                VideoPlayFragment.this.bzF();
                            }
                        } else {
                            VideoPlayFragment.this.gVk.author_info.is_follow = "0";
                            VideoPlayFragment.this.bzF();
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
                VideoPlayFragment.this.bzH();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.gVk = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.gVt = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.gVx = arguments.getBoolean(VideoPlayActivityConfig.PAGE_FIRST_IN);
        this.XM = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.gVk != null && this.gVk.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.gVk.author_info.user_id)) {
            this.dxu = true;
        }
        this.bkR = new n(getActivity());
        this.mRootView = layoutInflater.inflate(d.i.video_play_view, (ViewGroup) null);
        this.gUU = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.gUU.setBusiness(this.bkR);
        if (this.gVk != null) {
            y yVar = new y();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.aNu = this.gVk.thread_id;
            yVar.crJ = this.gVk.forum_id;
            yVar.fQQ = this.gVk.mMd5;
            yVar.XM = "";
            yVar.mSource = this.gVk.mRecomSource;
            yVar.fQP = this.gVk.mRecomAbTag;
            yVar.fQN = this.gVk.mRecomWeight;
            if (this.mRect != null) {
                yVar.fQR = "1";
            } else {
                yVar.fQR = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.fQS = "1";
                yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                yVar.fQO = "index";
                yVar.XM = this.XM;
                yVar.fQM = this.gVk.mRecomWeight;
            } else {
                yVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.bkR.setVideoStatsData(yVar);
        }
        this.gUV = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.gUV.setDefaultBgResource(d.f.icon_play_bg);
        this.gUV.setDefaultErrorResource(d.f.icon_play_bg);
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.biv = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.gUW = (TbImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.gUW.setIsRound(true);
        this.gUW.setDrawerType(1);
        this.gUW.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gUW.setDefaultResource(d.C0126d.transparent);
        this.gUW.setDefaultBgResource(d.C0126d.transparent);
        this.gVa = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.gVn = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.gVb = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.gVc = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.gUY = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.gVd = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.gUX = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.gVe = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.gVf = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.gVg = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.gVh = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.gVi = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.gVj = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.gUZ = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.gVo = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.gVp = this.mRootView.findViewById(d.g.quick_reply_comment_layout);
        this.gVp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.gVp.setVisibility(4);
                    if (VideoPlayFragment.this.gVy != null && VideoPlayFragment.this.gVy.DF() != null) {
                        VideoPlayFragment.this.gVy.DF().lN();
                    }
                    if (VideoPlayFragment.this.gVk != null) {
                        al alVar = new al("c13025");
                        alVar.ac("tid", VideoPlayFragment.this.gVk.thread_id);
                        alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                        alVar.ac(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.gVk.forum_id);
                        TiebaStatic.log(alVar);
                    }
                }
            }
        });
        this.gVq = (TextView) this.mRootView.findViewById(d.g.quick_reply_comment_text);
        this.gVl = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.gVl.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.gVl.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.gVl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(string2)) {
                    ax.wg().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bzE();
        this.gUW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoPlayFragment.this.gVk != null && VideoPlayFragment.this.gVk.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.gVk.author_info.user_id) && VideoPlayFragment.this.gVk != null && VideoPlayFragment.this.gVk.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.gVk.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(c, z, false)));
                    al alVar = new al("c12798");
                    alVar.ac("tid", VideoPlayFragment.this.gVk.thread_id);
                    alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(alVar);
                }
            }
        });
        this.gVi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoPlayFragment.this.gVk != null && VideoPlayFragment.this.gVk.act_info != null) {
                    com.baidu.tbadk.browser.a.N(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.gVk.act_info.link_url);
                    al alVar = new al("c12799");
                    alVar.ac("tid", VideoPlayFragment.this.gVk.thread_id);
                    alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(alVar);
                }
            }
        });
        this.gVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoPlayFragment.this.bzC();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VideoPlayFragment.this.gVk != null && !StringUtils.isNull(VideoPlayFragment.this.gVk.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.gVk.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.biv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoPlayFragment.this.bzD();
            }
        });
        this.gUY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoPlayFragment.this.bzC();
                al alVar = new al("c12796");
                alVar.ac("tid", VideoPlayFragment.this.gVk.thread_id);
                alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(alVar);
            }
        });
        this.gUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoPlayFragment.this.uD(VideoPlayFragment.this.gUS);
            }
        });
        this.gUZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoPlayFragment.this.xd();
                al alVar = new al("c12797");
                alVar.ac("tid", VideoPlayFragment.this.gVk.thread_id);
                alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(alVar);
            }
        });
        this.gVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (az.aK(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.gVk != null && VideoPlayFragment.this.gVk.author_info != null) {
                    VideoPlayFragment.this.ait.a(true, VideoPlayFragment.this.gVk.author_info.portrait, VideoPlayFragment.this.gVk.author_info.user_id, false, "6", VideoPlayFragment.this.aBK, VideoPlayFragment.this.gVk.forum_id, "0");
                    VideoPlayFragment.this.gVk.author_info.is_follow = "1";
                    VideoPlayFragment.this.bzF();
                }
            }
        });
        this.gVm = new AlphaAnimation(1.0f, 0.0f);
        this.gVm.setDuration(100L);
        this.gVm.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.gUV != null) {
                    VideoPlayFragment.this.gUV.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.gVr = this.mRect.right - this.mRect.left;
            this.gVs = this.mRect.bottom - this.mRect.top;
            this.gUV.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.gUV.getWidth();
                    int height = VideoPlayFragment.this.gUV.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.gVk.video_height, 0) > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.gVk.video_width, 0) > 0) {
                        float f3 = width / height;
                        float b = com.baidu.adp.lib.g.b.b(VideoPlayFragment.this.gVk.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(VideoPlayFragment.this.gVk.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f3) > 0.05d) {
                            if (b > f3) {
                                i = (int) (width / b);
                                i2 = width;
                            } else {
                                i2 = (int) (height * b);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.gVr, VideoPlayFragment.this.gVs);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.gUV.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.gVs > 0 || VideoPlayFragment.this.gVr <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.gVr;
                                f = i / VideoPlayFragment.this.gVs;
                            }
                            VideoPlayFragment.this.gUV.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.gUV.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.mIsVisible) {
                                        if (VideoPlayFragment.this.gVx) {
                                            VideoPlayFragment.this.gVx = b.getInstance().getBoolean("video_play_vertical_first_in", true);
                                        }
                                        if (!VideoPlayFragment.this.gVx) {
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
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.gVr, VideoPlayFragment.this.gVs);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.gUV.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.gVs > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.gUV.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.gUV.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (VideoPlayFragment.this.gVx) {
                                    VideoPlayFragment.this.gVx = b.getInstance().getBoolean("video_play_vertical_first_in", true);
                                }
                                if (!VideoPlayFragment.this.gVx) {
                                    VideoPlayFragment.this.startPlay();
                                }
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.gUV.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.gUV.getWidth();
                    int height = VideoPlayFragment.this.gUV.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.gVk.video_height, 0) > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.gVk.video_width, 0) > 0) {
                        float f = width / height;
                        float b = com.baidu.adp.lib.g.b.b(VideoPlayFragment.this.gVk.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(VideoPlayFragment.this.gVk.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f) > 0.05d) {
                            if (b > f) {
                                height = (int) (width / b);
                            } else {
                                width = (int) (height * b);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.gUV.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.gUV.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.mIsVisible) {
            bzA();
        }
        return this.mRootView;
    }

    private void initEditor() {
        this.gVy = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().aO(getActivity());
        if (this.gVy != null && this.gVk != null) {
            this.gVy.setContext(getPageContext());
            this.gVy.J(this.gVk.thread_id, this.gVk.forum_id, this.gVk.forum_name);
            this.gVy.a(new a.InterfaceC0231a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0231a
                public void ne(boolean z) {
                    VideoPlayFragment.this.gVp.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.gVq.setText(d.k.reply_something);
                    } else {
                        VideoPlayFragment.this.gVq.setText(StringUtils.isNull(((c) VideoPlayFragment.this.gVy.DF().eI(28)).getInputView().getText().toString()) ? d.k.reply_something : d.k.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.gVk != null && z) {
                        VideoPlayFragment.this.gVd.setText(an.B(com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.gVk.comment_num, 0L) + 1));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.gVy.DF(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd() {
        if (this.gVk != null) {
            String str = this.gVk.forum_id;
            String str2 = this.gVk.forum_name;
            String str3 = this.gVk.title;
            String str4 = this.gVk.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.gVk.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.k.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.awY = "";
            dVar.linkUrl = str5;
            dVar.abU = 2;
            dVar.extData = str4;
            dVar.axb = 3;
            dVar.fid = str;
            dVar.awT = str2;
            dVar.tid = str4;
            dVar.awQ = true;
            dVar.axa = 0;
            dVar.axc = 2;
            if (parse != null) {
                dVar.awV = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.gVk.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.gVk.title;
            originalThreadInfo.threadId = this.gVk.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.axb);
            bundle.putInt("obj_type", dVar.axc);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.abU);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.d.d.ahh().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.dxu) {
            this.cpH = new ForumManageModel(getPageContext());
            this.cpH.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.cpH.getLoadDataMode()) {
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
        this.eGw = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.eGw != null) {
            this.eGw.a(new a.InterfaceC0082a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0082a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.eGw != null) {
                            VideoPlayFragment.this.eGw.ae(z2);
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
        this.ait = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        bzE();
        if (Build.VERSION.SDK_INT >= 17) {
            this.gUU.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.tieba.play.g.e
                public boolean a(g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.mIsVisible && i == 3 && VideoPlayFragment.this.gUV.getVisibility() == 0) {
                        VideoPlayFragment.this.gUV.clearAnimation();
                        VideoPlayFragment.this.gUV.startAnimation(VideoPlayFragment.this.gVm);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.gUU.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (VideoPlayFragment.this.gUU != null) {
                    VideoPlayFragment.this.gUU.seekTo(0);
                    VideoPlayFragment.this.gUU.start();
                    VideoPlayFragment.this.afi();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uD(int i) {
        int i2;
        if (az.aK(getActivity()) && this.gVk != null) {
            if (i == this.gUS) {
                if ("1".equals(this.gVk.is_agreed)) {
                    i2 = 1;
                    this.gVk.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.gVk.agree_num, 0) - 1);
                    this.gVk.is_agreed = "0";
                } else {
                    this.gVk.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.gVk.agree_num, 0) + 1);
                    this.gVk.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.gVk.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.gVk.agree_num, 0) + 1);
                this.gVk.is_agreed = "1";
                i2 = 0;
            }
            al alVar = new al("c12795");
            alVar.ac("tid", this.gVk.thread_id);
            alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.gUS) {
                alVar.r("obj_type", i2);
            } else {
                alVar.r("obj_type", 2);
            }
            TiebaStatic.log(alVar);
            bzE();
            if (this.gVn != null && i2 == 0) {
                this.gVn.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.gVk.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.gVk));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.gVk != null && !StringUtils.isNull(this.gVk.video_url)) {
            uq(this.gVk.video_url);
            this.aOV = true;
            if (this.mIsVisible) {
                if (this.gVx) {
                    this.gVx = b.getInstance().getBoolean("video_play_vertical_first_in", true);
                }
                if (!this.gVx) {
                    afi();
                    aLD();
                }
                if (this.gVk != null && this.mRect != null) {
                    al alVar = new al("c12794");
                    alVar.ac("tid", this.gVk.thread_id);
                    alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    alVar.r("obj_type", 0);
                    TiebaStatic.log(alVar);
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
        if (this.gVy != null && this.gVy.DF() != null) {
            this.gVy.DF().hide();
        }
        this.gVp.setVisibility(0);
        this.gVq.setText(StringUtils.isNull(((c) this.gVy.DF().eI(28)).getInputView().getText().toString()) ? d.k.reply_something : d.k.draft_to_replay);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        stopPlay();
        if (this.gVy != null) {
            this.gVy.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisible = z;
        if (this.aOV) {
            if (this.mIsVisible) {
                if (this.gVk != null && this.mRect == null) {
                    al alVar = new al("c12794");
                    alVar.ac("tid", this.gVk.thread_id);
                    alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    alVar.r("obj_type", 1);
                    TiebaStatic.log(alVar);
                }
                if (this.gVx) {
                    this.gVx = b.getInstance().getBoolean("video_play_vertical_first_in", true);
                }
                if (!this.gVx) {
                    startPlay();
                }
                bzA();
                return;
            }
            pausePlay();
        }
    }

    private void bzA() {
        if (this.gVk != null) {
            al alVar = new al("c12590");
            alVar.ac("tid", this.gVk.thread_id);
            alVar.ac(ImageViewerConfig.FORUM_ID, this.gVk.forum_id);
            alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            alVar.r("obj_locate", this.gVt);
            alVar.ac("cuid", TbadkCoreApplication.getInst().getCuid());
            alVar.r("obj_param2", 1);
            alVar.ac("obj_param1", this.gVk.mRecomWeight);
            alVar.ac("extra", this.gVk.mRecomExtra);
            alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.XM);
            alVar.ac("ab_tag", this.gVk.mRecomAbTag);
            alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.gVk.mRecomSource);
            alVar.r("is_vertical", 1);
            TiebaStatic.log(alVar);
        }
    }

    private void uq(String str) {
        if (this.gUU != null) {
            this.gUU.setRecoveryState(0);
            this.gUU.setVideoPath(str, this.gVk.thread_id);
        }
    }

    public void bzB() {
        if (this.gVx) {
            this.gVx = false;
            if (this.mIsVisible) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || f.bvW().bvX() || bzH()) {
            bgc();
            if (this.gVg != null) {
                this.gVg.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.gUV.getVisibility() == 0) {
                this.gUV.clearAnimation();
                this.gUV.startAnimation(this.gVm);
            }
            if (this.gUU != null) {
                this.gUU.seekTo(0);
                this.gUU.start();
                afi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afi() {
        if (this.gVk != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.aNu = this.gVk.thread_id;
            yVar.crJ = this.gVk.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.gVk.mRecomSource;
            yVar.fQM = this.gVk.mRecomAbTag;
            yVar.fQN = this.gVk.mRecomWeight;
            yVar.fQO = "";
            yVar.XM = "";
            yVar.fQQ = this.gVk.mMd5;
            if (this.mRect != null) {
                yVar.fQR = "1";
            } else {
                yVar.fQR = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.fQS = "1";
                yVar.mLocate = "auto_midpage";
                yVar.fQO = "index";
            }
            com.baidu.tieba.play.l.a(this.gVk.mMd5, "", "1", yVar);
        }
    }

    private void bgc() {
        if (j.gR()) {
            f.bvW().cb(getContext());
        }
    }

    private void pausePlay() {
        if (this.gUU != null) {
            this.gUU.pause();
        }
    }

    private void stopPlay() {
        this.gUU.setRecoveryState(5);
        this.gUU.stopPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzC() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.gVk.thread_id, this.gVk.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.gVk.forum_id));
        createNormalCfg.setForumName(this.gVk.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzD() {
        if (this.cpy == null) {
            this.cpz = new com.baidu.tieba.view.a(getActivity());
            ArrayList arrayList = new ArrayList();
            a.C0232a c0232a = new a.C0232a(this.cpz);
            c0232a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.cpy.dismiss();
                    if (VideoPlayFragment.this.gVk != null) {
                        boolean z = VideoPlayFragment.this.gVk.post_id != null && VideoPlayFragment.this.gVk.post_id.equals(VideoPlayFragment.this.gVk.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.gVk.thread_id);
                        markData.setPostId(VideoPlayFragment.this.gVk.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.gVk.thread_id);
                        markData.setForumId(VideoPlayFragment.this.gVk.forum_id);
                        if (VideoPlayFragment.this.eGw != null) {
                            VideoPlayFragment.this.eGw.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.eGw.oK();
                            } else {
                                VideoPlayFragment.this.eGw.oJ();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.gVk != null && this.gVk.post_id != null && this.gVk.post_id.equals(this.gVk.mark_id)) {
                z = true;
            }
            if (z) {
                c0232a.setText(getResources().getString(d.k.remove_mark));
            } else {
                c0232a.setText(getResources().getString(d.k.mark));
            }
            arrayList.add(c0232a);
            a.C0232a c0232a2 = new a.C0232a(getActivity().getString(d.k.delete), this.cpz);
            c0232a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.cpy.dismiss();
                    if (az.aK(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.gVk != null) {
                        String str = VideoPlayFragment.this.gVk.thread_id;
                        String str2 = VideoPlayFragment.this.gVk.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(d.k.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.gVk.post_id, true)));
                    }
                }
            });
            c0232a2.setText(getResources().getString(d.k.report_text));
            arrayList.add(c0232a2);
            if (this.dxu) {
                a.C0232a c0232a3 = new a.C0232a(getActivity().getString(d.k.delete), this.cpz);
                c0232a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.cpy.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.ca(d.k.del_thread_confirm);
                        aVar.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.gVk != null) {
                                    VideoPlayFragment.this.cpH.a(VideoPlayFragment.this.gVk.forum_id, VideoPlayFragment.this.gVk.forum_name, VideoPlayFragment.this.gVk.thread_id, VideoPlayFragment.this.gVk.post_id, 0, 0, VideoPlayFragment.this.dxu);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                                }
                            }
                        });
                        aVar.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.ar(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.tD();
                    }
                });
                c0232a3.setText(getResources().getString(d.k.delete));
                arrayList.add(c0232a3);
            }
            this.cpz.dF(arrayList);
            this.cpy = new e(getActivity(), this.cpz.bAc());
        }
        this.cpy.show();
    }

    private void bzE() {
        if (this.gVk != null) {
            this.gUV.startLoad(this.gVk.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.gVk.title);
            if (StringUtils.isNull(this.gVk.title) || matcher.matches()) {
                this.gVb.setVisibility(8);
            } else {
                this.gVb.setVisibility(0);
                this.gVb.setText(this.gVk.title);
            }
            this.gVd.setText(an.B(com.baidu.adp.lib.g.b.c(this.gVk.comment_num, 0L)));
            this.gVe.setText(an.B(com.baidu.adp.lib.g.b.c(this.gVk.agree_num, 0L)));
            this.gVf.setText(an.B(com.baidu.adp.lib.g.b.c(this.gVk.share_num, 0L)));
            if (this.gVk.author_info != null) {
                if (!StringUtils.isNull(this.gVk.author_info.portrait) && this.gVk.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.gUW.startLoad(this.gVk.author_info.portrait, 10, false);
                } else {
                    this.gUW.startLoad(this.gVk.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.gVk.author_info.bvS())) {
                    this.gVo.setVisibility(8);
                } else {
                    this.gVo.setVisibility(0);
                    this.gVo.setText("@" + this.gVk.author_info.bvS());
                }
            }
            if ("1".equals(this.gVk.is_private) && this.gVl.getVisibility() != 0) {
                this.gVj.setVisibility(0);
            } else {
                this.gVj.setVisibility(8);
            }
            if ("1".equals(this.gVk.is_agreed)) {
                ak.c(this.gVn, d.f.icon_home_card_like_s);
            } else {
                ak.c(this.gVn, d.f.btn_video_agree);
            }
            if (this.gVk.act_info != null && !StringUtils.isNull(this.gVk.act_info.activity_name) && this.gVl.getVisibility() != 0) {
                this.gVi.setVisibility(0);
                this.gVc.setText(this.gVk.act_info.activity_name);
            } else {
                this.gVi.setVisibility(8);
            }
            bzF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzF() {
        if (this.dxu || (this.gVk.author_info != null && !"0".equals(this.gVk.author_info.is_follow))) {
            this.gVa.setVisibility(4);
            this.gVa.setClickable(false);
            return;
        }
        this.gVa.setVisibility(0);
        this.gVa.setClickable(true);
    }

    private void bzG() {
        if (this.gVz == null || !this.gVz.isShowing()) {
            this.gVz = new com.baidu.tbadk.core.dialog.a(getActivity());
            View inflate = LayoutInflater.from(getActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.a(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            this.gVz.w(inflate);
            this.gVz.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                    VideoPlayFragment.this.startPlay();
                }
            });
            this.gVz.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gVz.cc(1);
            this.gVz.cb(d.C0126d.cp_cont_b);
            this.gVz.ar(true);
            this.gVz.b(getPageContext());
            this.gVz.tD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzH() {
        if (!j.gP() || j.gQ()) {
            return true;
        }
        if (!this.mIsVisible || f.bvW().bvX()) {
            return false;
        }
        if (this.gVg != null) {
            this.gVg.setVisibility(0);
        }
        pausePlay();
        bzG();
        return false;
    }

    private void aLD() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bzH() || f.bvW().bvX()) && this.gUU != null && this.gVg != null) {
            this.gUU.start();
            this.gVg.setVisibility(8);
            bgc();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.apc == null) {
            this.apc = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.apc.setDuration(200L);
        }
        return this.apc;
    }

    public long bzI() {
        if (this.gVh != null) {
            this.gVh.setVisibility(8);
        }
        if (this.gVl != null) {
            this.gVl.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }

    @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
    public void bzv() {
        if (this.gUU.isPlaying()) {
            this.gUU.pause();
            this.gVg.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bzH() || f.bvW().bvX()) {
            this.gUU.start();
            this.gVg.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
    public void n(float f, float f2) {
        if (az.aK(getActivity()) && !this.gVu) {
            bzJ();
            if (this.gVk != null && "0".equals(this.gVk.is_agreed)) {
                uD(this.gUT);
            }
        }
    }

    private void bzJ() {
        if (this.mRootView != null) {
            this.gVu = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(d.f.icon_video_like);
            if (this.gVw == null) {
                this.gVw = new RelativeLayout.LayoutParams(-2, -2);
                this.gVw.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.gVw);
            }
            if (this.gVv == null) {
                this.gVv = new AnimatorSet();
                this.gVv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.gVu = false;
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
            this.gVv.setTarget(imageView);
            this.gVv.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.gVv.start();
        }
    }

    @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
    public void bzx() {
        if (this.gVk != null && this.gVk.author_info != null) {
            long c = com.baidu.adp.lib.g.b.c(this.gVk.author_info.user_id, 0L);
            long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = c == c2;
            if (c == 0 && c2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(c, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.gUU != null) {
            return this.gUU.getMediaIDs();
        }
        return null;
    }

    public String bzK() {
        if (this.gUU != null) {
            return this.gUU.getMediaId();
        }
        return null;
    }

    public boolean bzL() {
        if (this.gVy == null || this.gVy.DF() == null || !this.gVy.DF().isVisible()) {
            return false;
        }
        this.gVy.DF().hide();
        this.gVp.setVisibility(0);
        if ((this.gVy.DF().eI(28) instanceof c) && ((c) this.gVy.DF().eI(28)).getInputView() != null && ((c) this.gVy.DF().eI(28)).getInputView().getText() != null) {
            this.gVq.setText(StringUtils.isNull(((c) this.gVy.DF().eI(28)).getInputView().getText().toString()) ? d.k.reply_something : d.k.draft_to_replay);
        }
        return true;
    }

    public void b(int i, int i2, Intent intent) {
        if (this.gVy != null) {
            this.gVy.onActivityResult(i, i2, intent);
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
        if (this.gVy != null && this.gVy.DF() != null) {
            this.gVy.DF().onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.k.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
