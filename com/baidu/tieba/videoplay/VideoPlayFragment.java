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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
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
    private boolean aWS;
    private String afO;
    protected ScaleAnimation axk;
    public ImageView bqP;
    private n btk;
    private e czh;
    private a czi;
    private boolean dJI;
    public LinearLayout hhA;
    public LinearLayout hhB;
    public ImageView hhC;
    public TextView hhD;
    public TextView hhE;
    public TextView hhF;
    public TextView hhG;
    public TextView hhH;
    public ImageView hhI;
    private LinearLayout hhJ;
    public LinearLayout hhK;
    public LinearLayout hhL;
    public VideoItemData hhM;
    private TextView hhN;
    private AlphaAnimation hhO;
    public ImageView hhP;
    public TextView hhQ;
    private View hhR;
    private TextView hhS;
    private int hhT;
    private int hhU;
    private int hhV;
    private boolean hhW;
    private AnimatorSet hhX;
    private RelativeLayout.LayoutParams hhY;
    private boolean hhZ;
    public QuickVideoView hhw;
    private TbImageView hhx;
    public TbImageView hhy;
    public LinearLayout hhz;
    private com.baidu.tieba.videoplay.editor.a hia;
    com.baidu.tbadk.core.dialog.a hib;
    public ImageView mBackBtn;
    private String mFrom;
    private boolean mIsVisible;
    private Rect mRect;
    public View mRootView;
    private int hhu = 0;
    private int hhv = 1;
    private ForumManageModel czq = null;
    private com.baidu.tbadk.baseEditMark.a eSU = null;
    private com.baidu.tbadk.coreExtra.model.a aqA = null;
    private BdUniqueId aKh = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.hhM != null && VideoPlayFragment.this.hhM.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hhM.author_info.user_id) && data != null && VideoPlayFragment.this.hhM.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aKh)) ? false : false;
                    if (data.aCA == null) {
                        if (!data.Gp) {
                            if (z && !"0".equals(VideoPlayFragment.this.hhM.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), d.k.attention_fail);
                                VideoPlayFragment.this.hhM.author_info.is_follow = "0";
                                VideoPlayFragment.this.bEI();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), d.k.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, VideoPlayFragment.this.hhM));
                                    return;
                                }
                                VideoPlayFragment.this.hhM.author_info.is_follow = "1";
                                VideoPlayFragment.this.bEI();
                            }
                        } else {
                            VideoPlayFragment.this.hhM.author_info.is_follow = "0";
                            VideoPlayFragment.this.bEI();
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
                VideoPlayFragment.this.bEK();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.hhM = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hhV = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.hhZ = arguments.getBoolean(VideoPlayActivityConfig.PAGE_FIRST_IN);
        this.afO = arguments.getString(VideoPlayActivityConfig.OBJ_ID);
        if (this.hhM != null && this.hhM.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hhM.author_info.user_id)) {
            this.dJI = true;
        }
        this.btk = new n(getActivity());
        this.mRootView = layoutInflater.inflate(d.i.video_play_view, (ViewGroup) null);
        this.hhw = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.hhw.setBusiness(this.btk);
        if (this.hhM != null) {
            y yVar = new y();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.aVt = this.hhM.thread_id;
            yVar.cBu = this.hhM.forum_id;
            yVar.gdf = this.hhM.mMd5;
            yVar.afO = "";
            yVar.mSource = this.hhM.mRecomSource;
            yVar.gde = this.hhM.mRecomAbTag;
            yVar.gdc = this.hhM.mRecomWeight;
            if (this.mRect != null) {
                yVar.gdg = "1";
            } else {
                yVar.gdg = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.gdh = "1";
                yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                yVar.gdd = "index";
                yVar.afO = this.afO;
                yVar.gdb = this.hhM.mRecomWeight;
            } else {
                yVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
            this.btk.setVideoStatsData(yVar);
        }
        this.hhx = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.hhx.setDefaultBgResource(d.f.icon_play_bg);
        this.hhx.setDefaultErrorResource(d.f.icon_play_bg);
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.bqP = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.hhy = (TbImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.hhy.setIsRound(true);
        this.hhy.setDrawerType(1);
        this.hhy.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.hhy.setDefaultResource(d.C0141d.transparent);
        this.hhy.setDefaultBgResource(d.C0141d.transparent);
        this.hhC = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.hhP = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.hhD = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.hhE = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.hhA = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.hhF = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.hhz = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.hhG = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.hhH = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.hhI = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.hhJ = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.hhK = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.hhL = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.hhB = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.hhQ = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.hhR = this.mRootView.findViewById(d.g.quick_reply_comment_layout);
        this.hhR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.hhR.setVisibility(4);
                    if (VideoPlayFragment.this.hia != null && VideoPlayFragment.this.hia.Hg() != null) {
                        VideoPlayFragment.this.hia.Hg().oD();
                    }
                    if (VideoPlayFragment.this.hhM != null) {
                        am amVar = new am("c13025");
                        amVar.ah("tid", VideoPlayFragment.this.hhM.thread_id);
                        amVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                        amVar.ah(ImageViewerConfig.FORUM_ID, VideoPlayFragment.this.hhM.forum_id);
                        TiebaStatic.log(amVar);
                    }
                }
            }
        });
        this.hhS = (TextView) this.mRootView.findViewById(d.g.quick_reply_comment_text);
        this.hhN = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.hhN.setVisibility(8);
        String string = b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hhN.setText(string);
        }
        final String string2 = b.getInstance().getString("nani_key_download_link_url", null);
        this.hhN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ay.zG().a((TbPageContext) i.ad(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bEH();
        this.hhy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hhM != null && VideoPlayFragment.this.hhM.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.hhM.author_info.user_id) && VideoPlayFragment.this.hhM != null && VideoPlayFragment.this.hhM.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hhM.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(c, z, false)));
                    am amVar = new am("c12798");
                    amVar.ah("tid", VideoPlayFragment.this.hhM.thread_id);
                    amVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hhK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hhM != null && VideoPlayFragment.this.hhM.act_info != null) {
                    com.baidu.tbadk.browser.a.Q(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.hhM.act_info.link_url);
                    am amVar = new am("c12799");
                    amVar.ah("tid", VideoPlayFragment.this.hhM.thread_id);
                    amVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(amVar);
                }
            }
        });
        this.hhD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bEF();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.hhM != null && !StringUtils.isNull(VideoPlayFragment.this.hhM.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, VideoPlayFragment.this.hhM.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.bqP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bEG();
            }
        });
        this.hhA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bEF();
                am amVar = new am("c12796");
                amVar.ah("tid", VideoPlayFragment.this.hhM.thread_id);
                amVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hhz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.uO(VideoPlayFragment.this.hhu);
            }
        });
        this.hhB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.AD();
                am amVar = new am("c12797");
                amVar.ah("tid", VideoPlayFragment.this.hhM.thread_id);
                amVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(amVar);
            }
        });
        this.hhC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.aU(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hhM != null && VideoPlayFragment.this.hhM.author_info != null) {
                    VideoPlayFragment.this.aqA.a(true, VideoPlayFragment.this.hhM.author_info.portrait, VideoPlayFragment.this.hhM.author_info.user_id, false, Constants.VIA_SHARE_TYPE_INFO, VideoPlayFragment.this.aKh, VideoPlayFragment.this.hhM.forum_id, "0");
                    VideoPlayFragment.this.hhM.author_info.is_follow = "1";
                    VideoPlayFragment.this.bEI();
                }
            }
        });
        this.hhO = new AlphaAnimation(1.0f, 0.0f);
        this.hhO.setDuration(100L);
        this.hhO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.hhx != null) {
                    VideoPlayFragment.this.hhx.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.hhT = this.mRect.right - this.mRect.left;
            this.hhU = this.mRect.bottom - this.mRect.top;
            this.hhx.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.hhx.getWidth();
                    int height = VideoPlayFragment.this.hhx.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hhM.video_height, 0) > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hhM.video_width, 0) > 0) {
                        float f3 = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hhM.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hhM.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f3) > 0.05d) {
                            if (c > f3) {
                                i = (int) (width / c);
                                i2 = width;
                            } else {
                                i2 = (int) (height * c);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hhT, VideoPlayFragment.this.hhU);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.hhx.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hhU > 0 || VideoPlayFragment.this.hhT <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.hhT;
                                f = i / VideoPlayFragment.this.hhU;
                            }
                            VideoPlayFragment.this.hhx.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.hhx.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.mIsVisible) {
                                        if (VideoPlayFragment.this.hhZ) {
                                            VideoPlayFragment.this.hhZ = b.getInstance().getBoolean("video_play_vertical_first_in", true);
                                        }
                                        if (!VideoPlayFragment.this.hhZ) {
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
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.hhT, VideoPlayFragment.this.hhU);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.hhx.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hhU > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.hhx.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.hhx.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (VideoPlayFragment.this.hhZ) {
                                    VideoPlayFragment.this.hhZ = b.getInstance().getBoolean("video_play_vertical_first_in", true);
                                }
                                if (!VideoPlayFragment.this.hhZ) {
                                    VideoPlayFragment.this.startPlay();
                                }
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.hhx.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.hhx.getWidth();
                    int height = VideoPlayFragment.this.hhx.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hhM.video_height, 0) > 0 && com.baidu.adp.lib.g.b.g(VideoPlayFragment.this.hhM.video_width, 0) > 0) {
                        float f = width / height;
                        float c = com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hhM.video_width, 0.0f) / com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hhM.video_height, 0.0f);
                        if (c > 0.0f && Math.abs(c - f) > 0.05d) {
                            if (c > f) {
                                height = (int) (width / c);
                            } else {
                                width = (int) (height * c);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.hhx.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.hhx.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        initEditor();
        if (this.mIsVisible) {
            bED();
        }
        return this.mRootView;
    }

    private void initEditor() {
        this.hia = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().aY(getActivity());
        if (this.hia != null && this.hhM != null) {
            this.hia.setContext(getPageContext());
            this.hia.K(this.hhM.thread_id, this.hhM.forum_id, this.hhM.forum_name);
            this.hia.a(new a.InterfaceC0248a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0248a
                public void nl(boolean z) {
                    VideoPlayFragment.this.hhR.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.hhS.setText(d.k.reply_something);
                    } else {
                        VideoPlayFragment.this.hhS.setText(StringUtils.isNull(((c) VideoPlayFragment.this.hia.Hg().eM(28)).getInputView().getText().toString()) ? d.k.reply_something : d.k.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.hhM != null && z) {
                        VideoPlayFragment.this.hhF.setText(ao.E(com.baidu.adp.lib.g.b.c(VideoPlayFragment.this.hhM.comment_num, 0L) + 1));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.hia.Hg(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AD() {
        if (this.hhM != null) {
            String str = this.hhM.forum_id;
            String str2 = this.hhM.forum_name;
            String str3 = this.hhM.title;
            String str4 = this.hhM.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hhM.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.k.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.aFm = "";
            dVar.linkUrl = str5;
            dVar.ajZ = 2;
            dVar.extData = str4;
            dVar.aFp = 3;
            dVar.fid = str;
            dVar.aFh = str2;
            dVar.tid = str4;
            dVar.aFd = true;
            dVar.aFo = 0;
            dVar.aFq = 2;
            if (parse != null) {
                dVar.aFj = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hhM.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hhM.title;
            originalThreadInfo.threadId = this.hhM.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aFp);
            bundle.putInt("obj_type", dVar.aFq);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ajZ);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.akV().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.dJI) {
            this.czq = new ForumManageModel(getPageContext());
            this.czq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.czq.getLoadDataMode()) {
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
        this.eSU = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.eSU != null) {
            this.eSU.a(new a.InterfaceC0099a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0099a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.eSU != null) {
                            VideoPlayFragment.this.eSU.ah(z2);
                        }
                        if (VideoPlayFragment.this.hhM != null) {
                            if (z2) {
                                VideoPlayFragment.this.hhM.mark_id = VideoPlayFragment.this.hhM.post_id;
                            } else {
                                VideoPlayFragment.this.hhM.mark_id = null;
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
        this.aqA = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bEH();
        if (Build.VERSION.SDK_INT >= 17) {
            this.hhw.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.tieba.play.g.e
                public boolean a(g gVar, int i, int i2) {
                    if (VideoPlayFragment.this.mIsVisible && i == 3 && VideoPlayFragment.this.hhx.getVisibility() == 0) {
                        VideoPlayFragment.this.hhx.clearAnimation();
                        VideoPlayFragment.this.hhx.startAnimation(VideoPlayFragment.this.hhO);
                        return true;
                    }
                    return true;
                }
            });
        }
        this.hhw.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (VideoPlayFragment.this.hhw != null) {
                    VideoPlayFragment.this.hhw.seekTo(0);
                    VideoPlayFragment.this.hhw.start();
                    VideoPlayFragment.this.aiR();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uO(int i) {
        int i2;
        if (ba.aU(getActivity()) && this.hhM != null) {
            if (i == this.hhu) {
                if ("1".equals(this.hhM.is_agreed)) {
                    i2 = 1;
                    this.hhM.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.hhM.agree_num, 0) - 1);
                    this.hhM.is_agreed = "0";
                } else {
                    this.hhM.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.hhM.agree_num, 0) + 1);
                    this.hhM.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.hhM.agree_num = String.valueOf(com.baidu.adp.lib.g.b.g(this.hhM.agree_num, 0) + 1);
                this.hhM.is_agreed = "1";
                i2 = 0;
            }
            am amVar = new am("c12795");
            amVar.ah("tid", this.hhM.thread_id);
            amVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.hhu) {
                amVar.r("obj_type", i2);
            } else {
                amVar.r("obj_type", 2);
            }
            TiebaStatic.log(amVar);
            bEH();
            if (this.hhP != null && i2 == 0) {
                this.hhP.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hhM.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hhM));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hhM != null && !StringUtils.isNull(this.hhM.video_url)) {
            vn(this.hhM.video_url);
            this.aWS = true;
            if (this.mIsVisible) {
                if (this.hhZ) {
                    this.hhZ = b.getInstance().getBoolean("video_play_vertical_first_in", true);
                }
                if (!this.hhZ) {
                    aiR();
                    aQz();
                }
                if (this.hhM != null && this.mRect != null) {
                    am amVar = new am("c12794");
                    amVar.ah("tid", this.hhM.thread_id);
                    amVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.r("obj_type", 0);
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
        pausePlay();
        if (this.hia != null && this.hia.Hg() != null) {
            this.hia.Hg().hide();
        }
        this.hhR.setVisibility(0);
        this.hhS.setText(StringUtils.isNull(((c) this.hia.Hg().eM(28)).getInputView().getText().toString()) ? d.k.reply_something : d.k.draft_to_replay);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        stopPlay();
        if (this.hia != null) {
            this.hia.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisible = z;
        if (this.aWS) {
            if (this.mIsVisible) {
                if (this.hhM != null && this.mRect == null) {
                    am amVar = new am("c12794");
                    amVar.ah("tid", this.hhM.thread_id);
                    amVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    amVar.r("obj_type", 1);
                    TiebaStatic.log(amVar);
                }
                if (this.hhZ) {
                    this.hhZ = b.getInstance().getBoolean("video_play_vertical_first_in", true);
                }
                if (!this.hhZ) {
                    startPlay();
                }
                bED();
                return;
            }
            pausePlay();
        }
    }

    private void bED() {
        if (this.hhM != null) {
            String str = "";
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                str = "index";
            }
            am amVar = new am("c12590");
            amVar.ah("tid", this.hhM.thread_id);
            amVar.ah(ImageViewerConfig.FORUM_ID, this.hhM.forum_id);
            amVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.r("obj_locate", this.hhV);
            amVar.ah("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.r("obj_param2", 1);
            amVar.ah("obj_param1", this.hhM.mRecomWeight);
            amVar.ah("extra", this.hhM.mRecomExtra);
            amVar.ah(VideoPlayActivityConfig.OBJ_ID, this.afO);
            amVar.ah("ab_tag", this.hhM.mRecomAbTag);
            amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hhM.mRecomSource);
            amVar.r("is_vertical", 1);
            amVar.ah("obj_type", str);
            TiebaStatic.log(amVar);
        }
    }

    private void vn(String str) {
        if (this.hhw != null) {
            this.hhw.setRecoveryState(0);
            this.hhw.setVideoPath(str, this.hhM.thread_id);
        }
    }

    public void bEE() {
        if (this.hhZ) {
            this.hhZ = false;
            if (this.mIsVisible) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || f.bBb().bBc() || bEK()) {
            bla();
            if (this.hhI != null) {
                this.hhI.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hhx.getVisibility() == 0) {
                this.hhx.clearAnimation();
                this.hhx.startAnimation(this.hhO);
            }
            if (this.hhw != null) {
                this.hhw.seekTo(0);
                this.hhw.start();
                aiR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiR() {
        if (this.hhM != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.aVt = this.hhM.thread_id;
            yVar.cBu = this.hhM.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.hhM.mRecomSource;
            yVar.gdb = this.hhM.mRecomAbTag;
            yVar.gdc = this.hhM.mRecomWeight;
            yVar.gdd = "";
            yVar.afO = "";
            yVar.gdf = this.hhM.mMd5;
            if (this.mRect != null) {
                yVar.gdg = "1";
            } else {
                yVar.gdg = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.gdh = "1";
                yVar.mLocate = "auto_midpage";
                yVar.gdd = "index";
            }
            com.baidu.tieba.play.l.a(this.hhM.mMd5, "", "1", yVar);
        }
    }

    private void bla() {
        if (j.jF()) {
            f.bBb().cm(getContext());
        }
    }

    private void pausePlay() {
        if (this.hhw != null) {
            this.hhw.pause();
        }
    }

    private void stopPlay() {
        this.hhw.setRecoveryState(5);
        this.hhw.stopPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEF() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hhM.thread_id, this.hhM.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hhM.forum_id));
        createNormalCfg.setForumName(this.hhM.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEG() {
        if (this.czh == null) {
            this.czi = new com.baidu.tieba.view.a(getActivity());
            this.czh = new e(getActivity(), this.czi.bFf());
        }
        if (this.czi != null) {
            ArrayList arrayList = new ArrayList();
            a.C0249a c0249a = new a.C0249a(this.czi);
            c0249a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.czh.dismiss();
                    if (VideoPlayFragment.this.hhM != null) {
                        boolean z = VideoPlayFragment.this.hhM.post_id != null && VideoPlayFragment.this.hhM.post_id.equals(VideoPlayFragment.this.hhM.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.hhM.thread_id);
                        markData.setPostId(VideoPlayFragment.this.hhM.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.hhM.thread_id);
                        markData.setForumId(VideoPlayFragment.this.hhM.forum_id);
                        if (VideoPlayFragment.this.eSU != null) {
                            VideoPlayFragment.this.eSU.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.eSU.se();
                            } else {
                                VideoPlayFragment.this.eSU.sd();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hhM != null && this.hhM.post_id != null && this.hhM.post_id.equals(this.hhM.mark_id)) {
                z = true;
            }
            if (z) {
                c0249a.setText(getResources().getString(d.k.remove_mark));
            } else {
                c0249a.setText(getResources().getString(d.k.mark));
            }
            arrayList.add(c0249a);
            a.C0249a c0249a2 = new a.C0249a(getActivity().getString(d.k.delete), this.czi);
            c0249a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.czh.dismiss();
                    if (ba.aU(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.hhM != null) {
                        String str = VideoPlayFragment.this.hhM.thread_id;
                        String str2 = VideoPlayFragment.this.hhM.forum_id;
                        VideoPlayFragment.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), VideoPlayFragment.this.getResources().getString(d.k.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.hhM.post_id, true)));
                    }
                }
            });
            c0249a2.setText(getResources().getString(d.k.report_text));
            arrayList.add(c0249a2);
            if (this.dJI) {
                a.C0249a c0249a3 = new a.C0249a(getActivity().getString(d.k.delete), this.czi);
                c0249a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.czh.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.cc(d.k.del_thread_confirm);
                        aVar.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.hhM != null) {
                                    VideoPlayFragment.this.czq.a(VideoPlayFragment.this.hhM.forum_id, VideoPlayFragment.this.hhM.forum_name, VideoPlayFragment.this.hhM.thread_id, VideoPlayFragment.this.hhM.post_id, 0, 0, VideoPlayFragment.this.dJI);
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
                        aVar.au(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.xa();
                    }
                });
                c0249a3.setText(getResources().getString(d.k.delete));
                arrayList.add(c0249a3);
            }
            this.czi.dN(arrayList);
        }
        this.czh.show();
    }

    private void bEH() {
        if (this.hhM != null) {
            this.hhx.startLoad(this.hhM.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.hhM.title);
            if (StringUtils.isNull(this.hhM.title) || matcher.matches()) {
                this.hhD.setVisibility(8);
            } else {
                this.hhD.setVisibility(0);
                this.hhD.setText(this.hhM.title);
            }
            this.hhF.setText(ao.E(com.baidu.adp.lib.g.b.c(this.hhM.comment_num, 0L)));
            this.hhG.setText(ao.E(com.baidu.adp.lib.g.b.c(this.hhM.agree_num, 0L)));
            this.hhH.setText(ao.E(com.baidu.adp.lib.g.b.c(this.hhM.share_num, 0L)));
            if (this.hhM.author_info != null) {
                if (!StringUtils.isNull(this.hhM.author_info.portrait) && this.hhM.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.hhy.startLoad(this.hhM.author_info.portrait, 10, false);
                } else {
                    this.hhy.startLoad(this.hhM.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.hhM.author_info.bAX())) {
                    this.hhQ.setVisibility(8);
                } else {
                    this.hhQ.setVisibility(0);
                    this.hhQ.setText("@" + this.hhM.author_info.bAX());
                }
            }
            if ("1".equals(this.hhM.is_private) && this.hhN.getVisibility() != 0) {
                this.hhL.setVisibility(0);
            } else {
                this.hhL.setVisibility(8);
            }
            if ("1".equals(this.hhM.is_agreed)) {
                al.c(this.hhP, d.f.icon_home_card_like_s);
            } else {
                al.c(this.hhP, d.f.btn_video_agree);
            }
            if (this.hhM.act_info != null && !StringUtils.isNull(this.hhM.act_info.activity_name) && this.hhN.getVisibility() != 0) {
                this.hhK.setVisibility(0);
                this.hhE.setText(this.hhM.act_info.activity_name);
            } else {
                this.hhK.setVisibility(8);
            }
            bEI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEI() {
        if (this.dJI || (this.hhM.author_info != null && !"0".equals(this.hhM.author_info.is_follow))) {
            this.hhC.setVisibility(4);
            this.hhC.setClickable(false);
            return;
        }
        this.hhC.setVisibility(0);
        this.hhC.setClickable(true);
    }

    private void bEJ() {
        if (this.hib == null || !this.hib.isShowing()) {
            this.hib = new com.baidu.tbadk.core.dialog.a(getActivity());
            View inflate = LayoutInflater.from(getActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.a(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            this.hib.w(inflate);
            this.hib.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                    VideoPlayFragment.this.startPlay();
                }
            });
            this.hib.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hib.ce(1);
            this.hib.cd(d.C0141d.cp_cont_b);
            this.hib.au(true);
            this.hib.b(getPageContext());
            this.hib.xa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEK() {
        if (!j.jD() || j.jE()) {
            return true;
        }
        if (!this.mIsVisible || f.bBb().bBc()) {
            return false;
        }
        if (this.hhI != null) {
            this.hhI.setVisibility(0);
        }
        pausePlay();
        bEJ();
        return false;
    }

    private void aQz() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bEK() || f.bBb().bBc()) && this.hhw != null && this.hhI != null) {
            this.hhw.start();
            this.hhI.setVisibility(8);
            bla();
        }
    }

    protected Animation getScaleAnimation() {
        if (this.axk == null) {
            this.axk = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axk.setDuration(200L);
        }
        return this.axk;
    }

    public long bEL() {
        if (this.hhJ != null) {
            this.hhJ.setVisibility(8);
        }
        if (this.hhN != null) {
            this.hhN.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }

    @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
    public void bEz() {
        if (this.hhw.isPlaying()) {
            this.hhw.pause();
            this.hhI.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bEK() || f.bBb().bBc()) {
            this.hhw.start();
            this.hhI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
    public void u(float f, float f2) {
        if (ba.aU(getActivity()) && !this.hhW) {
            bEM();
            if (this.hhM != null && "0".equals(this.hhM.is_agreed)) {
                uO(this.hhv);
            }
        }
    }

    private void bEM() {
        if (this.mRootView != null) {
            this.hhW = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(d.f.icon_video_like);
            if (this.hhY == null) {
                this.hhY = new RelativeLayout.LayoutParams(-2, -2);
                this.hhY.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.hhY);
            }
            if (this.hhX == null) {
                this.hhX = new AnimatorSet();
                this.hhX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.hhW = false;
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
            this.hhX.setTarget(imageView);
            this.hhX.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.hhX.start();
        }
    }

    @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
    public void bEB() {
        if (this.hhM != null && this.hhM.author_info != null) {
            long c = com.baidu.adp.lib.g.b.c(this.hhM.author_info.user_id, 0L);
            long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = c == c2;
            if (c == 0 && c2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(c, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (this.hhw != null) {
            return this.hhw.getMediaIDs();
        }
        return null;
    }

    public String bEN() {
        if (this.hhw != null) {
            return this.hhw.getMediaId();
        }
        return null;
    }

    public boolean bEO() {
        if (this.hia == null || this.hia.Hg() == null || !this.hia.Hg().isVisible()) {
            return false;
        }
        this.hia.Hg().hide();
        this.hhR.setVisibility(0);
        if ((this.hia.Hg().eM(28) instanceof c) && ((c) this.hia.Hg().eM(28)).getInputView() != null && ((c) this.hia.Hg().eM(28)).getInputView().getText() != null) {
            this.hhS.setText(StringUtils.isNull(((c) this.hia.Hg().eM(28)).getInputView().getText().toString()) ? d.k.reply_something : d.k.draft_to_replay);
        }
        return true;
    }

    public void b(int i, int i2, Intent intent) {
        if (this.hia != null) {
            this.hia.onActivityResult(i, i2, intent);
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
        if (this.hia != null && this.hia.Hg() != null) {
            this.hia.Hg().onChangeSkinType(i);
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
