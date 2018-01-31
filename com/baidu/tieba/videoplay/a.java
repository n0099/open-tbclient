package com.baidu.tieba.videoplay;

import android.content.Context;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.c;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class a extends BaseFragment {
    private boolean bCE;
    public ImageView bWv;
    private n bYR;
    protected ScaleAnimation bcd;
    private com.baidu.tieba.d.c bce;
    private e cVe;
    private com.baidu.tieba.view.c cVf;
    private boolean dYy;
    private TbImageView hxA;
    public TbImageView hxB;
    public LinearLayout hxC;
    public LinearLayout hxD;
    public LinearLayout hxE;
    public ImageView hxF;
    public TextView hxG;
    public TextView hxH;
    public TextView hxI;
    public TextView hxJ;
    public TextView hxK;
    public ImageView hxL;
    private LinearLayout hxM;
    public LinearLayout hxN;
    public LinearLayout hxO;
    public VideoItemData hxP;
    private TextView hxQ;
    private AlphaAnimation hxR;
    public ImageView hxS;
    public TextView hxT;
    private int hxU;
    private int hxV;
    private VideoPlayModel hxW;
    private int hxX;
    com.baidu.tbadk.core.dialog.a hxY;
    public QuickVideoView hxz;
    private Rect lQ;
    public ImageView mBackBtn;
    private String mFrom;
    private boolean mIsVisible;
    public View mRootView;
    private ForumManageModel cVn = null;
    private com.baidu.tbadk.baseEditMark.a fin = null;
    private com.baidu.tbadk.coreExtra.model.a bdJ = null;
    private BdUniqueId bph = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (a.this.hxP != null && a.this.hxP.author_info != null && !StringUtils.isNull(a.this.hxP.author_info.user_id) && data != null && a.this.hxP.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(a.this.bph)) ? false : false;
                    if (data.bgS == null) {
                        if (!data.apQ) {
                            if (z && !"0".equals(a.this.hxP.author_info.is_follow)) {
                                l.showToast(a.this.getActivity(), d.j.attention_fail);
                                a.this.hxP.author_info.is_follow = "0";
                                a.this.bDN();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (a.this.mIsVisible) {
                                if (z) {
                                    l.showToast(a.this.getActivity(), d.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, a.this.hxP));
                                    return;
                                }
                                a.this.hxP.author_info.is_follow = "1";
                                a.this.bDN();
                            }
                        } else {
                            a.this.hxP.author_info.is_follow = "0";
                            a.this.bDN();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.videoplay.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                a.this.bDP();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.hxP = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.lQ = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hxX = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        if (this.hxP != null && this.hxP.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hxP.author_info.user_id)) {
            this.dYy = true;
        }
        this.hxW = new VideoPlayModel((VideoPlayActivity) getActivity());
        this.bYR = new n(getActivity());
        this.mRootView = layoutInflater.inflate(d.h.video_play_view, (ViewGroup) null);
        this.hxz = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.hxz.setBusiness(this.bYR);
        if (this.hxP != null) {
            aa aaVar = new aa();
            aaVar.mLocate = "14";
            aaVar.bBb = this.hxP.thread_id;
            aaVar.cXh = this.hxP.forum_id;
            aaVar.guu = this.hxP.mMd5;
            aaVar.aLh = "";
            aaVar.mSource = this.hxP.mRecomSource;
            aaVar.gut = this.hxP.mRecomAbTag;
            aaVar.gur = this.hxP.mRecomWeight;
            if (this.lQ != null) {
                aaVar.guv = "1";
            } else {
                aaVar.guv = "2";
            }
            this.bYR.setVideoStatsData(aaVar);
        }
        this.hxA = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.hxA.setDefaultBgResource(d.f.icon_play_bg);
        this.hxA.setDefaultErrorResource(d.f.icon_play_bg);
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.bWv = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.hxB = (TbImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.hxB.setIsRound(true);
        this.hxB.setDrawerType(1);
        this.hxB.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.hxB.setDefaultResource(d.C0108d.transparent);
        this.hxB.setDefaultBgResource(d.C0108d.transparent);
        this.hxF = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.hxS = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.hxG = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.hxH = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.hxD = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.hxI = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.hxC = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.hxJ = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.hxK = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.hxL = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.hxM = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.hxN = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.hxO = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.hxE = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.hxT = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.hxQ = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.hxQ.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hxQ.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.hxQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    av.Da().a((TbPageContext) i.ak(a.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bDM();
        this.hxz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hxz.isPlaying()) {
                    a.this.hxz.pause();
                    a.this.hxL.setVisibility(0);
                } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || a.this.bDP()) {
                    a.this.hxz.start();
                    a.this.hxL.setVisibility(8);
                }
            }
        });
        this.hxB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hxP != null && a.this.hxP.author_info != null && !StringUtils.isNull(a.this.hxP.author_info.user_id) && a.this.hxP != null && a.this.hxP.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(a.this.hxP.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.getActivity()).createNormalConfig(c, z, false)));
                    ak akVar = new ak("c12798");
                    akVar.aa("tid", a.this.hxP.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(akVar);
                }
            }
        });
        this.hxN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hxP != null && a.this.hxP.act_info != null) {
                    com.baidu.tbadk.browser.a.Q(a.this.getActivity(), a.this.hxP.act_info.link_url);
                    ak akVar = new ak("c12799");
                    akVar.aa("tid", a.this.hxP.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(akVar);
                }
            }
        });
        this.hxG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bDK();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hxP != null && !StringUtils.isNull(a.this.hxP.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, a.this.hxP.thread_id));
                }
                a.this.getActivity().finish();
            }
        });
        this.bWv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bDL();
            }
        });
        this.hxD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bDK();
                ak akVar = new ak("c12796");
                akVar.aa("tid", a.this.hxP.thread_id);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(akVar);
            }
        });
        this.hxC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bai();
            }
        });
        this.hxE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.DY();
                ak akVar = new ak("c12797");
                akVar.aa("tid", a.this.hxP.thread_id);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(akVar);
            }
        });
        this.hxF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ax.bb(a.this.getActivity()) && a.this.hxP != null && a.this.hxP.author_info != null) {
                    a.this.bdJ.a(true, a.this.hxP.author_info.portrait, a.this.hxP.author_info.user_id, false, "6", a.this.bph, a.this.hxP.forum_id, "0");
                    a.this.hxP.author_info.is_follow = "1";
                    a.this.bDN();
                }
            }
        });
        this.hxR = new AlphaAnimation(1.0f, 0.0f);
        this.hxR.setDuration(100L);
        this.hxR.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hxA != null) {
                    a.this.hxA.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.lQ != null) {
            this.hxU = this.lQ.right - this.lQ.left;
            this.hxV = this.lQ.bottom - this.lQ.top;
            this.hxA.post(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = a.this.hxA.getWidth();
                    int height = a.this.hxA.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.h(a.this.hxP.video_height, 0) > 0 && com.baidu.adp.lib.g.b.h(a.this.hxP.video_width, 0) > 0) {
                        float f3 = width / height;
                        float b = com.baidu.adp.lib.g.b.b(a.this.hxP.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(a.this.hxP.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f3) > 0.05d) {
                            if (b > f3) {
                                i = (int) (width / b);
                                i2 = width;
                            } else {
                                i2 = (int) (height * b);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.this.hxU, a.this.hxV);
                            layoutParams.leftMargin = a.this.lQ.left;
                            layoutParams.topMargin = a.this.lQ.top;
                            a.this.hxA.setLayoutParams(layoutParams);
                            if (a.this.hxV > 0 || a.this.hxU <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / a.this.hxU;
                                f = i / a.this.hxV;
                            }
                            a.this.hxA.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (a.this.lQ.left + ((a.this.lQ.right - a.this.lQ.left) / 2))).translationY((height / 2.0f) - (a.this.lQ.top + ((a.this.lQ.bottom - a.this.lQ.top) / 2))).start();
                            a.this.hxA.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (a.this.mIsVisible) {
                                        a.this.startPlay();
                                        a.this.lQ = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a.this.hxU, a.this.hxV);
                    layoutParams2.leftMargin = a.this.lQ.left;
                    layoutParams2.topMargin = a.this.lQ.top;
                    a.this.hxA.setLayoutParams(layoutParams2);
                    if (a.this.hxV > 0) {
                    }
                    f = 1.0f;
                    a.this.hxA.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (a.this.lQ.left + ((a.this.lQ.right - a.this.lQ.left) / 2))).translationY((height / 2.0f) - (a.this.lQ.top + ((a.this.lQ.bottom - a.this.lQ.top) / 2))).start();
                    a.this.hxA.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.mIsVisible) {
                                a.this.startPlay();
                                a.this.lQ = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.hxA.post(new Runnable() { // from class: com.baidu.tieba.videoplay.a.8
                @Override // java.lang.Runnable
                public void run() {
                    int width = a.this.hxA.getWidth();
                    int height = a.this.hxA.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.h(a.this.hxP.video_height, 0) > 0 && com.baidu.adp.lib.g.b.h(a.this.hxP.video_width, 0) > 0) {
                        float f = width / height;
                        float b = com.baidu.adp.lib.g.b.b(a.this.hxP.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(a.this.hxP.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f) > 0.05d) {
                            if (b > f) {
                                height = (int) (width / b);
                            } else {
                                width = (int) (height * b);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = a.this.hxA.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        a.this.hxA.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DY() {
        if (this.hxP != null) {
            String str = this.hxP.forum_id;
            String str2 = this.hxP.forum_name;
            String str3 = this.hxP.title;
            String str4 = this.hxP.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hxP.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.bjp = "";
            dVar.linkUrl = str5;
            dVar.aPh = 2;
            dVar.extData = str4;
            dVar.bjs = 3;
            dVar.fid = str;
            dVar.bjk = str2;
            dVar.tid = str4;
            dVar.bjh = true;
            dVar.bjr = 0;
            dVar.bjt = 2;
            if (parse != null) {
                dVar.bjm = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hxP.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hxP.title;
            originalThreadInfo.threadId = this.hxP.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.bjs);
            bundle.putInt("obj_type", dVar.bjt);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aPh);
            dVar.h(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            if (this.bce == null) {
                this.bce = new com.baidu.tieba.d.c(getActivity());
            }
            this.bce.a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.dYy) {
            this.cVn = new ForumManageModel(getPageContext());
            this.cVn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.a.9
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    if (obj != null) {
                        switch (a.this.cVn.getLoadDataMode()) {
                            case 0:
                                a.this.getActivity().finish();
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
        this.fin = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.fin != null) {
            this.fin.a(new a.InterfaceC0069a() { // from class: com.baidu.tieba.videoplay.a.10
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0069a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (a.this.fin != null) {
                            a.this.fin.aI(z2);
                        }
                        if (z2) {
                            a.this.showToast(a.this.getPageContext().getString(d.j.add_mark));
                            return;
                        } else {
                            a.this.showToast(a.this.getPageContext().getString(d.j.remove_mark));
                            return;
                        }
                    }
                    a.this.showToast(a.this.getPageContext().getString(d.j.update_mark_failed));
                }
            });
        }
        this.bdJ = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bDM();
        this.hxz.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.a.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                gVar.setLooping(true);
            }
        });
        if (Build.VERSION.SDK_INT >= 17) {
            this.hxz.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.a.13
                @Override // com.baidu.tieba.play.g.e
                public boolean a(g gVar, int i, int i2) {
                    if (a.this.mIsVisible && i == 3 && a.this.hxA.getVisibility() == 0) {
                        a.this.hxA.clearAnimation();
                        a.this.hxA.startAnimation(a.this.hxR);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bai() {
        int i;
        if (ax.bb(getActivity()) && this.hxP != null) {
            if ("1".equals(this.hxP.is_agreed)) {
                i = 1;
                this.hxP.agree_num = String.valueOf(com.baidu.adp.lib.g.b.h(this.hxP.agree_num, 0) - 1);
                this.hxP.is_agreed = "0";
            } else {
                this.hxP.agree_num = String.valueOf(com.baidu.adp.lib.g.b.h(this.hxP.agree_num, 0) + 1);
                this.hxP.is_agreed = "1";
                i = 0;
            }
            ak akVar = new ak("c12795");
            akVar.aa("tid", this.hxP.thread_id);
            akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            akVar.s("obj_type", i);
            TiebaStatic.log(akVar);
            bDM();
            if (this.hxS != null && i == 0) {
                this.hxS.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hxP.thread_id);
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.hxP));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hxP != null && !StringUtils.isNull(this.hxP.video_url)) {
            ua(this.hxP.video_url);
            this.bCE = true;
            if (this.mIsVisible) {
                aOR();
                if (this.hxP != null && this.lQ != null) {
                    ak akVar = new ak("c12794");
                    akVar.aa("tid", this.hxP.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    akVar.s("obj_type", 0);
                    TiebaStatic.log(akVar);
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
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        stopPlay();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisible = z;
        if (this.bCE) {
            if (this.mIsVisible) {
                if (this.hxP != null && this.lQ == null) {
                    ak akVar = new ak("c12794");
                    akVar.aa("tid", this.hxP.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    akVar.s("obj_type", 1);
                    TiebaStatic.log(akVar);
                }
                startPlay();
                return;
            }
            pausePlay();
        }
    }

    private void ua(String str) {
        if (this.hxz != null) {
            this.hxz.setRecoveryState(0);
            this.hxz.bN(str, this.hxP.thread_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bDP()) {
            if (this.hxL != null) {
                this.hxL.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hxA.getVisibility() == 0) {
                this.hxA.clearAnimation();
                this.hxA.startAnimation(this.hxR);
            }
            if (this.hxz != null) {
                this.hxz.seekTo(0);
                this.hxz.start();
                if (this.hxP != null) {
                    aa aaVar = new aa();
                    aaVar.mLocate = "nani_midpage";
                    aaVar.bBb = this.hxP.thread_id;
                    aaVar.cXh = this.hxP.forum_id + "";
                    aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    aaVar.mSource = this.hxP.mRecomSource;
                    aaVar.guq = this.hxP.mRecomAbTag;
                    aaVar.gur = this.hxP.mRecomWeight;
                    aaVar.gus = "";
                    aaVar.aLh = "";
                    aaVar.guu = this.hxP.mMd5;
                    com.baidu.tieba.play.l.a(this.hxP.mMd5, "", "1", aaVar);
                }
            }
        }
    }

    private void pausePlay() {
        if (this.hxz != null) {
            this.hxz.pause();
        }
    }

    private void stopPlay() {
        this.hxz.setRecoveryState(5);
        this.hxz.stopPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDK() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hxP.thread_id, this.hxP.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hxP.forum_id));
        createNormalCfg.setForumName(this.hxP.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDL() {
        if (this.cVe == null) {
            this.cVf = new com.baidu.tieba.view.c(getActivity());
            ArrayList arrayList = new ArrayList();
            c.a aVar = new c.a(this.cVf);
            aVar.a(new c.InterfaceC0168c() { // from class: com.baidu.tieba.videoplay.a.14
                @Override // com.baidu.tieba.view.c.InterfaceC0168c
                public void onClick() {
                    a.this.cVe.dismiss();
                    if (a.this.hxP != null) {
                        boolean z = a.this.hxP.post_id != null && a.this.hxP.post_id.equals(a.this.hxP.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(a.this.hxP.thread_id);
                        markData.setPostId(a.this.hxP.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(a.this.hxP.thread_id);
                        markData.setForumId(a.this.hxP.forum_id);
                        if (a.this.fin != null) {
                            a.this.fin.a(markData);
                            if (!z) {
                                a.this.fin.vn();
                            } else {
                                a.this.fin.vm();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hxP != null && this.hxP.post_id != null && this.hxP.post_id.equals(this.hxP.mark_id)) {
                z = true;
            }
            if (z) {
                aVar.setText(getResources().getString(d.j.remove_mark));
            } else {
                aVar.setText(getResources().getString(d.j.mark));
            }
            arrayList.add(aVar);
            c.a aVar2 = new c.a(getActivity().getString(d.j.delete), this.cVf);
            aVar2.a(new c.InterfaceC0168c() { // from class: com.baidu.tieba.videoplay.a.15
                @Override // com.baidu.tieba.view.c.InterfaceC0168c
                public void onClick() {
                    a.this.cVe.dismiss();
                    if (ax.bb(a.this.getActivity()) && a.this.hxP != null) {
                        String str = a.this.hxP.thread_id;
                        String str2 = a.this.hxP.forum_id;
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(a.this.getPageContext().getPageActivity(), a.this.getResources().getString(d.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + a.this.hxP.post_id, true)));
                    }
                }
            });
            aVar2.setText(getResources().getString(d.j.report_text));
            arrayList.add(aVar2);
            if (this.dYy) {
                c.a aVar3 = new c.a(getActivity().getString(d.j.delete), this.cVf);
                aVar3.a(new c.InterfaceC0168c() { // from class: com.baidu.tieba.videoplay.a.16
                    @Override // com.baidu.tieba.view.c.InterfaceC0168c
                    public void onClick() {
                        a.this.cVe.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar4 = new com.baidu.tbadk.core.dialog.a(a.this.getActivity());
                        aVar4.fb(d.j.del_thread_confirm);
                        aVar4.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.a.16.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar5) {
                                aVar4.dismiss();
                                if (a.this.hxP != null) {
                                    a.this.cVn.a(a.this.hxP.forum_id, a.this.hxP.forum_name, a.this.hxP.thread_id, a.this.hxP.post_id, 0, 0, a.this.dYy);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                                }
                            }
                        });
                        aVar4.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.a.16.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar5) {
                                aVar4.dismiss();
                            }
                        });
                        aVar4.aW(true);
                        aVar4.b(a.this.getPageContext());
                        aVar4.AB();
                    }
                });
                aVar3.setText(getResources().getString(d.j.delete));
                arrayList.add(aVar3);
            }
            this.cVf.dI(arrayList);
            this.cVe = new e(getActivity(), this.cVf.bDV());
        }
        this.cVe.show();
    }

    private void bDM() {
        if (this.hxP != null) {
            this.hxA.startLoad(this.hxP.thumbnail_url, 10, false);
            this.hxG.setText(this.hxP.title);
            this.hxI.setText(am.J(com.baidu.adp.lib.g.b.c(this.hxP.comment_num, 0L)));
            this.hxJ.setText(am.J(com.baidu.adp.lib.g.b.c(this.hxP.agree_num, 0L)));
            this.hxK.setText(am.J(com.baidu.adp.lib.g.b.c(this.hxP.share_num, 0L)));
            if (this.hxP.author_info != null) {
                this.hxB.startLoad(this.hxP.author_info.portrait, 12, false);
                if (StringUtils.isNull(this.hxP.author_info.bAd())) {
                    this.hxT.setVisibility(8);
                } else {
                    this.hxT.setVisibility(0);
                    this.hxT.setText("@" + this.hxP.author_info.bAd());
                }
            }
            if ("1".equals(this.hxP.is_private) && this.hxQ.getVisibility() != 0) {
                this.hxO.setVisibility(0);
            } else {
                this.hxO.setVisibility(8);
            }
            if ("1".equals(this.hxP.is_agreed)) {
                aj.c(this.hxS, d.f.icon_home_card_like_s);
            } else {
                aj.c(this.hxS, d.f.btn_video_agree);
            }
            if (this.hxP.act_info != null && !StringUtils.isNull(this.hxP.act_info.activity_name) && this.hxQ.getVisibility() != 0) {
                this.hxN.setVisibility(0);
                this.hxH.setText(this.hxP.act_info.activity_name);
            } else {
                this.hxN.setVisibility(8);
            }
            bDN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDN() {
        if (this.dYy || (this.hxP.author_info != null && !"0".equals(this.hxP.author_info.is_follow))) {
            this.hxF.setVisibility(4);
            this.hxF.setClickable(false);
            return;
        }
        this.hxF.setVisibility(0);
        this.hxF.setClickable(true);
    }

    private void bDO() {
        if (this.hxY == null || !this.hxY.isShowing()) {
            this.hxY = new com.baidu.tbadk.core.dialog.a(getActivity());
            this.hxY.fa(d.j.net_change_title);
            this.hxY.fb(d.j.net_change_tip);
            this.hxY.a(d.j.video_continue, new a.b() { // from class: com.baidu.tieba.videoplay.a.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                    a.this.startPlay();
                }
            });
            this.hxY.b(d.j.pause, new a.b() { // from class: com.baidu.tieba.videoplay.a.18
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hxY.aW(true);
            this.hxY.b(getPageContext());
            this.hxY.AB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDP() {
        if (!j.oJ() || j.oK()) {
            return true;
        }
        if (this.mIsVisible) {
            if (this.hxL != null) {
                this.hxL.setVisibility(0);
            }
            pausePlay();
            bDO();
            return false;
        }
        return false;
    }

    private void aOR() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bDP()) && this.hxz != null && this.hxL != null) {
            this.hxz.start();
            this.hxL.setVisibility(8);
        }
    }

    protected Animation getScaleAnimation() {
        if (this.bcd == null) {
            this.bcd = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bcd.setDuration(200L);
        }
        return this.bcd;
    }

    public long bDQ() {
        if (this.hxM != null) {
            this.hxM.setVisibility(8);
        }
        if (this.hxQ != null) {
            this.hxQ.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }
}
