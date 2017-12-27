package com.baidu.tieba.videoplay;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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
    private boolean bCn;
    public ImageView bWg;
    private n bYC;
    protected ScaleAnimation bbV;
    private com.baidu.tieba.d.c bbW;
    private e cQh;
    private com.baidu.tieba.view.c cQi;
    private boolean dWS;
    public QuickVideoView hHC;
    private TbImageView hHD;
    public TbImageView hHE;
    public LinearLayout hHF;
    public LinearLayout hHG;
    public LinearLayout hHH;
    public ImageView hHI;
    public TextView hHJ;
    public TextView hHK;
    public TextView hHL;
    public TextView hHM;
    public TextView hHN;
    public ImageView hHO;
    public LinearLayout hHP;
    public LinearLayout hHQ;
    public VideoItemData hHR;
    private AlphaAnimation hHS;
    public ImageView hHT;
    public TextView hHU;
    private int hHV;
    private int hHW;
    private VideoPlayModel hHX;
    private int hHY;
    com.baidu.tbadk.core.dialog.a hHZ;
    private Rect lQ;
    public ImageView mBackBtn;
    private String mFrom;
    private boolean mIsVisible;
    public View mRootView;
    private ForumManageModel cQq = null;
    private com.baidu.tbadk.baseEditMark.a fgs = null;
    private com.baidu.tbadk.coreExtra.model.a bdv = null;
    private BdUniqueId boP = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (a.this.hHR != null && a.this.hHR.author_info != null && !StringUtils.isNull(a.this.hHR.author_info.user_id) && data != null && a.this.hHR.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(a.this.boP)) ? false : false;
                    if (data.bgt == null) {
                        if (!data.apO) {
                            if (z && !"0".equals(a.this.hHR.author_info.is_follow)) {
                                l.showToast(a.this.getActivity(), d.j.attention_fail);
                                a.this.hHR.author_info.is_follow = "0";
                                a.this.bKn();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (a.this.mIsVisible) {
                                if (z) {
                                    l.showToast(a.this.getActivity(), d.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, a.this.hHR));
                                    return;
                                }
                                a.this.hHR.author_info.is_follow = "1";
                                a.this.bKn();
                            }
                        } else {
                            a.this.hHR.author_info.is_follow = "0";
                            a.this.bKn();
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
                a.this.bKp();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.hHR = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.lQ = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hHY = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        if (this.hHR != null && this.hHR.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hHR.author_info.user_id)) {
            this.dWS = true;
        }
        this.hHX = new VideoPlayModel((VideoPlayActivity) getActivity());
        this.bYC = new n(getActivity());
        this.mRootView = layoutInflater.inflate(d.h.video_play_view, (ViewGroup) null);
        this.hHC = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.hHC.setBusiness(this.bYC);
        if (this.hHR != null) {
            aa aaVar = new aa();
            aaVar.mLocate = "14";
            aaVar.bAK = this.hHR.thread_id;
            aaVar.cSk = this.hHR.forum_id;
            aaVar.gES = this.hHR.mMd5;
            aaVar.aLg = "";
            aaVar.mSource = this.hHR.mRecomSource;
            aaVar.gER = this.hHR.mRecomAbTag;
            aaVar.gEP = this.hHR.mRecomWeight;
            this.bYC.setVideoStatsData(aaVar);
        }
        this.hHD = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.hHD.setDefaultBgResource(d.f.icon_play_bg);
        this.hHD.setDefaultErrorResource(d.f.icon_play_bg);
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.bWg = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.hHE = (TbImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.hHE.setIsRound(true);
        this.hHE.setDrawerType(1);
        this.hHE.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.hHE.setDefaultResource(d.C0108d.transparent);
        this.hHE.setDefaultBgResource(d.C0108d.transparent);
        this.hHI = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.hHT = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.hHJ = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.hHK = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.hHG = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.hHL = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.hHF = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.hHM = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.hHN = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.hHO = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.hHP = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.hHQ = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.hHH = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.hHU = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        bKm();
        this.hHC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hHC.isPlaying()) {
                    a.this.hHC.pause();
                    a.this.hHO.setVisibility(0);
                } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || a.this.bKp()) {
                    a.this.hHC.start();
                    a.this.hHO.setVisibility(8);
                }
            }
        });
        this.hHE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hHR != null && a.this.hHR.author_info != null && !StringUtils.isNull(a.this.hHR.author_info.user_id) && a.this.hHR != null && a.this.hHR.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(a.this.hHR.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.getActivity()).createNormalConfig(c, z, false)));
                    ak akVar = new ak("c12798");
                    akVar.ab("tid", a.this.hHR.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(akVar);
                }
            }
        });
        this.hHP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hHR != null && a.this.hHR.act_info != null) {
                    com.baidu.tbadk.browser.a.S(a.this.getActivity(), a.this.hHR.act_info.link_url);
                    ak akVar = new ak("c12799");
                    akVar.ab("tid", a.this.hHR.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(akVar);
                }
            }
        });
        this.hHJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bKk();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hHR != null && !StringUtils.isNull(a.this.hHR.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, a.this.hHR.thread_id));
                }
                a.this.getActivity().finish();
            }
        });
        this.bWg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bKl();
            }
        });
        this.hHG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bKk();
                ak akVar = new ak("c12796");
                akVar.ab("tid", a.this.hHR.thread_id);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(akVar);
            }
        });
        this.hHF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.aZZ();
            }
        });
        this.hHH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Ef();
                ak akVar = new ak("c12797");
                akVar.ab("tid", a.this.hHR.thread_id);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(akVar);
            }
        });
        this.hHI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ax.be(a.this.getActivity()) && a.this.hHR != null && a.this.hHR.author_info != null) {
                    a.this.bdv.a(true, a.this.hHR.author_info.portrait, a.this.hHR.author_info.user_id, false, "6", a.this.boP, a.this.hHR.forum_id, "0");
                    a.this.hHR.author_info.is_follow = "1";
                    a.this.bKn();
                }
            }
        });
        this.hHS = new AlphaAnimation(1.0f, 0.0f);
        this.hHS.setDuration(100L);
        this.hHS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.a.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hHD != null) {
                    a.this.hHD.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.lQ != null) {
            this.hHV = this.lQ.right - this.lQ.left;
            this.hHW = this.lQ.bottom - this.lQ.top;
            this.hHD.post(new Runnable() { // from class: com.baidu.tieba.videoplay.a.6
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = a.this.hHD.getWidth();
                    int height = a.this.hHD.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.h(a.this.hHR.video_height, 0) > 0 && com.baidu.adp.lib.g.b.h(a.this.hHR.video_width, 0) > 0) {
                        float f3 = width / height;
                        float b = com.baidu.adp.lib.g.b.b(a.this.hHR.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(a.this.hHR.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f3) > 0.05d) {
                            if (b > f3) {
                                i = (int) (width / b);
                                i2 = width;
                            } else {
                                i2 = (int) (height * b);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.this.hHV, a.this.hHW);
                            layoutParams.leftMargin = a.this.lQ.left;
                            layoutParams.topMargin = a.this.lQ.top;
                            a.this.hHD.setLayoutParams(layoutParams);
                            if (a.this.hHW > 0 || a.this.hHV <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / a.this.hHV;
                                f = i / a.this.hHW;
                            }
                            a.this.hHD.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (a.this.lQ.left + ((a.this.lQ.right - a.this.lQ.left) / 2))).translationY((height / 2.0f) - (a.this.lQ.top + ((a.this.lQ.bottom - a.this.lQ.top) / 2))).start();
                            a.this.hHD.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.a.6.1
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
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a.this.hHV, a.this.hHW);
                    layoutParams2.leftMargin = a.this.lQ.left;
                    layoutParams2.topMargin = a.this.lQ.top;
                    a.this.hHD.setLayoutParams(layoutParams2);
                    if (a.this.hHW > 0) {
                    }
                    f = 1.0f;
                    a.this.hHD.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (a.this.lQ.left + ((a.this.lQ.right - a.this.lQ.left) / 2))).translationY((height / 2.0f) - (a.this.lQ.top + ((a.this.lQ.bottom - a.this.lQ.top) / 2))).start();
                    a.this.hHD.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.a.6.1
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
            this.hHD.post(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7
                @Override // java.lang.Runnable
                public void run() {
                    int width = a.this.hHD.getWidth();
                    int height = a.this.hHD.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.h(a.this.hHR.video_height, 0) > 0 && com.baidu.adp.lib.g.b.h(a.this.hHR.video_width, 0) > 0) {
                        float f = width / height;
                        float b = com.baidu.adp.lib.g.b.b(a.this.hHR.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(a.this.hHR.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f) > 0.05d) {
                            if (b > f) {
                                height = (int) (width / b);
                            } else {
                                width = (int) (height * b);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = a.this.hHD.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        a.this.hHD.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ef() {
        if (this.hHR != null) {
            String str = this.hHR.forum_id;
            String str2 = this.hHR.forum_name;
            String str3 = this.hHR.title;
            String str4 = this.hHR.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hHR.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.biQ = "";
            dVar.linkUrl = str5;
            dVar.aPf = 2;
            dVar.extData = str4;
            dVar.biT = 3;
            dVar.fid = str;
            dVar.biL = str2;
            dVar.tid = str4;
            dVar.biI = true;
            dVar.biS = 0;
            dVar.biU = 2;
            if (parse != null) {
                dVar.biN = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hHR.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hHR.title;
            originalThreadInfo.threadId = this.hHR.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.biT);
            bundle.putInt("obj_type", dVar.biU);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aPf);
            dVar.h(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            if (this.bbW == null) {
                this.bbW = new com.baidu.tieba.d.c(getActivity());
            }
            this.bbW.a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.dWS) {
            this.cQq = new ForumManageModel(getPageContext());
            this.cQq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.a.8
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    if (obj != null) {
                        switch (a.this.cQq.getLoadDataMode()) {
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
        this.fgs = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.fgs != null) {
            this.fgs.a(new a.InterfaceC0070a() { // from class: com.baidu.tieba.videoplay.a.9
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0070a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (a.this.fgs != null) {
                            a.this.fgs.aH(z2);
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
        this.bdv = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bKm();
        this.hHC.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.a.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                gVar.setLooping(true);
            }
        });
        if (Build.VERSION.SDK_INT >= 17) {
            this.hHC.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.a.11
                @Override // com.baidu.tieba.play.g.e
                public boolean a(g gVar, int i, int i2) {
                    if (a.this.mIsVisible && i == 3 && a.this.hHD.getVisibility() == 0) {
                        a.this.hHD.clearAnimation();
                        a.this.hHD.startAnimation(a.this.hHS);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZZ() {
        int i;
        if (ax.be(getActivity()) && this.hHR != null) {
            if ("1".equals(this.hHR.is_agreed)) {
                i = 1;
                this.hHR.agree_num = String.valueOf(com.baidu.adp.lib.g.b.h(this.hHR.agree_num, 0) - 1);
                this.hHR.is_agreed = "0";
            } else {
                this.hHR.agree_num = String.valueOf(com.baidu.adp.lib.g.b.h(this.hHR.agree_num, 0) + 1);
                this.hHR.is_agreed = "1";
                i = 0;
            }
            ak akVar = new ak("c12795");
            akVar.ab("tid", this.hHR.thread_id);
            akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            akVar.s("obj_type", i);
            TiebaStatic.log(akVar);
            bKm();
            if (this.hHT != null && i == 0) {
                this.hHT.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hHR.thread_id);
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.hHR));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hHR != null && !StringUtils.isNull(this.hHR.video_url)) {
            uy(this.hHR.video_url);
            this.bCn = true;
            if (this.mIsVisible) {
                aOH();
                if (this.hHR != null && this.lQ != null) {
                    ak akVar = new ak("c12794");
                    akVar.ab("tid", this.hHR.thread_id);
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
        if (this.bCn) {
            if (this.mIsVisible) {
                if (this.hHR != null && this.lQ == null) {
                    ak akVar = new ak("c12794");
                    akVar.ab("tid", this.hHR.thread_id);
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

    private void uy(String str) {
        if (this.hHC != null) {
            this.hHC.setRecoveryState(0);
            this.hHC.bS(str, this.hHR.thread_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bKp()) {
            if (this.hHO != null) {
                this.hHO.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hHD.getVisibility() == 0) {
                this.hHD.clearAnimation();
                this.hHD.startAnimation(this.hHS);
            }
            if (this.hHC != null) {
                this.hHC.seekTo(0);
                this.hHC.start();
                if (this.hHR != null) {
                    aa aaVar = new aa();
                    aaVar.mLocate = "nani_midpage";
                    aaVar.bAK = this.hHR.thread_id;
                    aaVar.cSk = this.hHR.forum_id + "";
                    aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    aaVar.mSource = this.hHR.mRecomSource;
                    aaVar.gEO = this.hHR.mRecomAbTag;
                    aaVar.gEP = this.hHR.mRecomWeight;
                    aaVar.gEQ = "";
                    aaVar.aLg = "";
                    aaVar.gES = this.hHR.mMd5;
                    com.baidu.tieba.play.l.a(this.hHR.mMd5, "", "1", aaVar);
                }
            }
        }
    }

    private void pausePlay() {
        if (this.hHC != null) {
            this.hHC.pause();
        }
    }

    private void stopPlay() {
        this.hHC.setRecoveryState(5);
        this.hHC.stopPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKk() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hHR.thread_id, this.hHR.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hHR.forum_id));
        createNormalCfg.setForumName(this.hHR.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKl() {
        if (this.cQh == null) {
            this.cQi = new com.baidu.tieba.view.c(getActivity());
            ArrayList arrayList = new ArrayList();
            c.a aVar = new c.a(this.cQi);
            aVar.a(new c.InterfaceC0168c() { // from class: com.baidu.tieba.videoplay.a.13
                @Override // com.baidu.tieba.view.c.InterfaceC0168c
                public void onClick() {
                    a.this.cQh.dismiss();
                    if (a.this.hHR != null) {
                        boolean z = a.this.hHR.post_id != null && a.this.hHR.post_id.equals(a.this.hHR.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(a.this.hHR.thread_id);
                        markData.setPostId(a.this.hHR.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(a.this.hHR.thread_id);
                        markData.setForumId(a.this.hHR.forum_id);
                        if (a.this.fgs != null) {
                            a.this.fgs.a(markData);
                            if (!z) {
                                a.this.fgs.vm();
                            } else {
                                a.this.fgs.vl();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hHR != null && this.hHR.post_id != null && this.hHR.post_id.equals(this.hHR.mark_id)) {
                z = true;
            }
            if (z) {
                aVar.setText(getResources().getString(d.j.remove_mark));
            } else {
                aVar.setText(getResources().getString(d.j.mark));
            }
            arrayList.add(aVar);
            c.a aVar2 = new c.a(getActivity().getString(d.j.delete), this.cQi);
            aVar2.a(new c.InterfaceC0168c() { // from class: com.baidu.tieba.videoplay.a.14
                @Override // com.baidu.tieba.view.c.InterfaceC0168c
                public void onClick() {
                    a.this.cQh.dismiss();
                    if (ax.be(a.this.getActivity()) && a.this.hHR != null) {
                        String str = a.this.hHR.thread_id;
                        String str2 = a.this.hHR.forum_id;
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(a.this.getPageContext().getPageActivity(), a.this.getResources().getString(d.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + a.this.hHR.post_id, true)));
                    }
                }
            });
            aVar2.setText(getResources().getString(d.j.report_text));
            arrayList.add(aVar2);
            if (this.dWS) {
                c.a aVar3 = new c.a(getActivity().getString(d.j.delete), this.cQi);
                aVar3.a(new c.InterfaceC0168c() { // from class: com.baidu.tieba.videoplay.a.15
                    @Override // com.baidu.tieba.view.c.InterfaceC0168c
                    public void onClick() {
                        a.this.cQh.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar4 = new com.baidu.tbadk.core.dialog.a(a.this.getActivity());
                        aVar4.fd(d.j.del_thread_confirm);
                        aVar4.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.a.15.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar5) {
                                aVar4.dismiss();
                                if (a.this.hHR != null) {
                                    a.this.cQq.a(a.this.hHR.forum_id, a.this.hHR.forum_name, a.this.hHR.thread_id, a.this.hHR.post_id, 0, 0, a.this.dWS);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                                }
                            }
                        });
                        aVar4.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.a.15.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar5) {
                                aVar4.dismiss();
                            }
                        });
                        aVar4.aV(true);
                        aVar4.b(a.this.getPageContext());
                        aVar4.AI();
                    }
                });
                aVar3.setText(getResources().getString(d.j.delete));
                arrayList.add(aVar3);
            }
            this.cQi.dZ(arrayList);
            this.cQh = new e(getActivity(), this.cQi.bKt());
        }
        this.cQh.show();
    }

    private void bKm() {
        if (this.hHR != null) {
            this.hHD.startLoad(this.hHR.thumbnail_url, 10, false);
            this.hHJ.setText(this.hHR.title);
            this.hHL.setText(am.I(com.baidu.adp.lib.g.b.c(this.hHR.comment_num, 0L)));
            this.hHM.setText(am.I(com.baidu.adp.lib.g.b.c(this.hHR.agree_num, 0L)));
            this.hHN.setText(am.I(com.baidu.adp.lib.g.b.c(this.hHR.share_num, 0L)));
            if (this.hHR.author_info != null) {
                this.hHE.startLoad(this.hHR.author_info.portrait, 12, false);
                if (StringUtils.isNull(this.hHR.author_info.bGE())) {
                    this.hHU.setVisibility(8);
                } else {
                    this.hHU.setVisibility(0);
                    this.hHU.setText("@" + this.hHR.author_info.bGE());
                }
            }
            if ("1".equals(this.hHR.is_private)) {
                this.hHQ.setVisibility(0);
            } else {
                this.hHQ.setVisibility(8);
            }
            if ("1".equals(this.hHR.is_agreed)) {
                aj.c(this.hHT, d.f.icon_home_card_like_s);
            } else {
                aj.c(this.hHT, d.f.btn_video_agree);
            }
            if (this.hHR.act_info != null && !StringUtils.isNull(this.hHR.act_info.activity_name)) {
                this.hHP.setVisibility(0);
                this.hHK.setText(this.hHR.act_info.activity_name);
            } else {
                this.hHP.setVisibility(8);
            }
            bKn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKn() {
        if (this.dWS || (this.hHR.author_info != null && !"0".equals(this.hHR.author_info.is_follow))) {
            this.hHI.setVisibility(4);
            this.hHI.setClickable(false);
            return;
        }
        this.hHI.setVisibility(0);
        this.hHI.setClickable(true);
    }

    private void bKo() {
        if (this.hHZ == null || !this.hHZ.isShowing()) {
            this.hHZ = new com.baidu.tbadk.core.dialog.a(getActivity());
            this.hHZ.fc(d.j.net_change_title);
            this.hHZ.fd(d.j.net_change_tip);
            this.hHZ.a(d.j.video_continue, new a.b() { // from class: com.baidu.tieba.videoplay.a.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                    a.this.startPlay();
                }
            });
            this.hHZ.b(d.j.pause, new a.b() { // from class: com.baidu.tieba.videoplay.a.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hHZ.aV(true);
            this.hHZ.b(getPageContext());
            this.hHZ.AI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKp() {
        if (!j.oI() || j.oJ()) {
            return true;
        }
        if (this.mIsVisible) {
            if (this.hHO != null) {
                this.hHO.setVisibility(0);
            }
            pausePlay();
            bKo();
            return false;
        }
        return false;
    }

    private void aOH() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bKp()) && this.hHC != null && this.hHO != null) {
            this.hHC.start();
            this.hHO.setVisibility(8);
        }
    }

    protected Animation getScaleAnimation() {
        if (this.bbV == null) {
            this.bbV = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bbV.setDuration(200L);
        }
        return this.bbV;
    }
}
