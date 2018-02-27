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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
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
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class a extends BaseFragment {
    private boolean bEv;
    public ImageView bYs;
    protected ScaleAnimation bdI;
    private e cXD;
    private com.baidu.tieba.view.c cXE;
    private n caO;
    private boolean ecy;
    public QuickVideoView hyA;
    private TbImageView hyB;
    public TbImageView hyC;
    public LinearLayout hyD;
    public LinearLayout hyE;
    public LinearLayout hyF;
    public ImageView hyG;
    public TextView hyH;
    public TextView hyI;
    public TextView hyJ;
    public TextView hyK;
    public TextView hyL;
    public ImageView hyM;
    private LinearLayout hyN;
    public LinearLayout hyO;
    public LinearLayout hyP;
    public VideoItemData hyQ;
    private TextView hyR;
    private AlphaAnimation hyS;
    public ImageView hyT;
    public TextView hyU;
    private int hyV;
    private int hyW;
    private VideoPlayModel hyX;
    private int hyY;
    com.baidu.tbadk.core.dialog.a hyZ;
    private Rect lQ;
    public ImageView mBackBtn;
    private String mFrom;
    private boolean mIsVisible;
    public View mRootView;
    private ForumManageModel cXM = null;
    private com.baidu.tbadk.baseEditMark.a flD = null;
    private com.baidu.tbadk.coreExtra.model.a bfq = null;
    private BdUniqueId bri = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (a.this.hyQ != null && a.this.hyQ.author_info != null && !StringUtils.isNull(a.this.hyQ.author_info.user_id) && data != null && a.this.hyQ.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(a.this.bri)) ? false : false;
                    if (data.biH == null) {
                        if (!data.apG) {
                            if (z && !"0".equals(a.this.hyQ.author_info.is_follow)) {
                                l.showToast(a.this.getActivity(), d.j.attention_fail);
                                a.this.hyQ.author_info.is_follow = "0";
                                a.this.bEu();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (a.this.mIsVisible) {
                                if (z) {
                                    l.showToast(a.this.getActivity(), d.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, a.this.hyQ));
                                    return;
                                }
                                a.this.hyQ.author_info.is_follow = "1";
                                a.this.bEu();
                            }
                        } else {
                            a.this.hyQ.author_info.is_follow = "0";
                            a.this.bEu();
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
                a.this.bEw();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.hyQ = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.lQ = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hyY = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        if (this.hyQ != null && this.hyQ.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hyQ.author_info.user_id)) {
            this.ecy = true;
        }
        this.hyX = new VideoPlayModel((VideoPlayActivity) getActivity());
        this.caO = new n(getActivity());
        this.mRootView = layoutInflater.inflate(d.h.video_play_view, (ViewGroup) null);
        this.hyA = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.hyA.setBusiness(this.caO);
        if (this.hyQ != null) {
            aa aaVar = new aa();
            aaVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            aaVar.bCS = this.hyQ.thread_id;
            aaVar.cZI = this.hyQ.forum_id;
            aaVar.gvP = this.hyQ.mMd5;
            aaVar.aMq = "";
            aaVar.mSource = this.hyQ.mRecomSource;
            aaVar.gvO = this.hyQ.mRecomAbTag;
            aaVar.gvM = this.hyQ.mRecomWeight;
            if (this.lQ != null) {
                aaVar.gvQ = "1";
            } else {
                aaVar.gvQ = "2";
            }
            this.caO.setVideoStatsData(aaVar);
        }
        this.hyB = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.hyB.setDefaultBgResource(d.f.icon_play_bg);
        this.hyB.setDefaultErrorResource(d.f.icon_play_bg);
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.bYs = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.hyC = (TbImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.hyC.setIsRound(true);
        this.hyC.setDrawerType(1);
        this.hyC.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.hyC.setDefaultResource(d.C0141d.transparent);
        this.hyC.setDefaultBgResource(d.C0141d.transparent);
        this.hyG = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.hyT = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.hyH = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.hyI = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.hyE = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.hyJ = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.hyD = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.hyK = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.hyL = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.hyM = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.hyN = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.hyO = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.hyP = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.hyF = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.hyU = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.hyR = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.hyR.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hyR.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.hyR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    aw.Dt().a((TbPageContext) i.ak(a.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bEt();
        this.hyA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hyA.isPlaying()) {
                    a.this.hyA.pause();
                    a.this.hyM.setVisibility(0);
                } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || a.this.bEw()) {
                    a.this.hyA.start();
                    a.this.hyM.setVisibility(8);
                }
            }
        });
        this.hyC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hyQ != null && a.this.hyQ.author_info != null && !StringUtils.isNull(a.this.hyQ.author_info.user_id) && a.this.hyQ != null && a.this.hyQ.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(a.this.hyQ.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.getActivity()).createNormalConfig(c, z, false)));
                    ak akVar = new ak("c12798");
                    akVar.ab("tid", a.this.hyQ.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(akVar);
                }
            }
        });
        this.hyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hyQ != null && a.this.hyQ.act_info != null) {
                    com.baidu.tbadk.browser.b.S(a.this.getActivity(), a.this.hyQ.act_info.link_url);
                    ak akVar = new ak("c12799");
                    akVar.ab("tid", a.this.hyQ.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(akVar);
                }
            }
        });
        this.hyH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bEr();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hyQ != null && !StringUtils.isNull(a.this.hyQ.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, a.this.hyQ.thread_id));
                }
                a.this.getActivity().finish();
            }
        });
        this.bYs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bEs();
            }
        });
        this.hyE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bEr();
                ak akVar = new ak("c12796");
                akVar.ab("tid", a.this.hyQ.thread_id);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(akVar);
            }
        });
        this.hyD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bbM();
            }
        });
        this.hyF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Er();
                ak akVar = new ak("c12797");
                akVar.ab("tid", a.this.hyQ.thread_id);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(akVar);
            }
        });
        this.hyG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ay.ba(a.this.getActivity()) && a.this.hyQ != null && a.this.hyQ.author_info != null) {
                    a.this.bfq.a(true, a.this.hyQ.author_info.portrait, a.this.hyQ.author_info.user_id, false, "6", a.this.bri, a.this.hyQ.forum_id, "0");
                    a.this.hyQ.author_info.is_follow = "1";
                    a.this.bEu();
                }
            }
        });
        this.hyS = new AlphaAnimation(1.0f, 0.0f);
        this.hyS.setDuration(100L);
        this.hyS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hyB != null) {
                    a.this.hyB.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.lQ != null) {
            this.hyV = this.lQ.right - this.lQ.left;
            this.hyW = this.lQ.bottom - this.lQ.top;
            this.hyB.post(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = a.this.hyB.getWidth();
                    int height = a.this.hyB.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.h(a.this.hyQ.video_height, 0) > 0 && com.baidu.adp.lib.g.b.h(a.this.hyQ.video_width, 0) > 0) {
                        float f3 = width / height;
                        float b = com.baidu.adp.lib.g.b.b(a.this.hyQ.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(a.this.hyQ.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f3) > 0.05d) {
                            if (b > f3) {
                                i = (int) (width / b);
                                i2 = width;
                            } else {
                                i2 = (int) (height * b);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.this.hyV, a.this.hyW);
                            layoutParams.leftMargin = a.this.lQ.left;
                            layoutParams.topMargin = a.this.lQ.top;
                            a.this.hyB.setLayoutParams(layoutParams);
                            if (a.this.hyW > 0 || a.this.hyV <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / a.this.hyV;
                                f = i / a.this.hyW;
                            }
                            a.this.hyB.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (a.this.lQ.left + ((a.this.lQ.right - a.this.lQ.left) / 2))).translationY((height / 2.0f) - (a.this.lQ.top + ((a.this.lQ.bottom - a.this.lQ.top) / 2))).start();
                            a.this.hyB.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7.1
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
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a.this.hyV, a.this.hyW);
                    layoutParams2.leftMargin = a.this.lQ.left;
                    layoutParams2.topMargin = a.this.lQ.top;
                    a.this.hyB.setLayoutParams(layoutParams2);
                    if (a.this.hyW > 0) {
                    }
                    f = 1.0f;
                    a.this.hyB.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (a.this.lQ.left + ((a.this.lQ.right - a.this.lQ.left) / 2))).translationY((height / 2.0f) - (a.this.lQ.top + ((a.this.lQ.bottom - a.this.lQ.top) / 2))).start();
                    a.this.hyB.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7.1
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
            this.hyB.post(new Runnable() { // from class: com.baidu.tieba.videoplay.a.8
                @Override // java.lang.Runnable
                public void run() {
                    int width = a.this.hyB.getWidth();
                    int height = a.this.hyB.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.h(a.this.hyQ.video_height, 0) > 0 && com.baidu.adp.lib.g.b.h(a.this.hyQ.video_width, 0) > 0) {
                        float f = width / height;
                        float b = com.baidu.adp.lib.g.b.b(a.this.hyQ.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(a.this.hyQ.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f) > 0.05d) {
                            if (b > f) {
                                height = (int) (width / b);
                            } else {
                                width = (int) (height * b);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = a.this.hyB.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        a.this.hyB.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Er() {
        if (this.hyQ != null) {
            String str = this.hyQ.forum_id;
            String str2 = this.hyQ.forum_name;
            String str3 = this.hyQ.title;
            String str4 = this.hyQ.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hyQ.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.blr = "";
            dVar.linkUrl = str5;
            dVar.aQs = 2;
            dVar.extData = str4;
            dVar.blu = 3;
            dVar.fid = str;
            dVar.blm = str2;
            dVar.tid = str4;
            dVar.blj = true;
            dVar.blt = 0;
            dVar.blv = 2;
            if (parse != null) {
                dVar.blo = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hyQ.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hyQ.title;
            originalThreadInfo.threadId = this.hyQ.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.blu);
            bundle.putInt("obj_type", dVar.blv);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aQs);
            dVar.i(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.d.d.ani().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.ecy) {
            this.cXM = new ForumManageModel(getPageContext());
            this.cXM.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.a.9
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    if (obj != null) {
                        switch (a.this.cXM.getLoadDataMode()) {
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
        this.flD = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.flD != null) {
            this.flD.a(new a.InterfaceC0093a() { // from class: com.baidu.tieba.videoplay.a.10
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0093a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (a.this.flD != null) {
                            a.this.flD.aL(z2);
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
        this.bfq = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bEt();
        this.hyA.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.a.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                gVar.setLooping(true);
            }
        });
        if (Build.VERSION.SDK_INT >= 17) {
            this.hyA.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.a.13
                @Override // com.baidu.tieba.play.g.e
                public boolean a(g gVar, int i, int i2) {
                    if (a.this.mIsVisible && i == 3 && a.this.hyB.getVisibility() == 0) {
                        a.this.hyB.clearAnimation();
                        a.this.hyB.startAnimation(a.this.hyS);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbM() {
        int i;
        if (ay.ba(getActivity()) && this.hyQ != null) {
            if ("1".equals(this.hyQ.is_agreed)) {
                i = 1;
                this.hyQ.agree_num = String.valueOf(com.baidu.adp.lib.g.b.h(this.hyQ.agree_num, 0) - 1);
                this.hyQ.is_agreed = "0";
            } else {
                this.hyQ.agree_num = String.valueOf(com.baidu.adp.lib.g.b.h(this.hyQ.agree_num, 0) + 1);
                this.hyQ.is_agreed = "1";
                i = 0;
            }
            ak akVar = new ak("c12795");
            akVar.ab("tid", this.hyQ.thread_id);
            akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            akVar.s("obj_type", i);
            TiebaStatic.log(akVar);
            bEt();
            if (this.hyT != null && i == 0) {
                this.hyT.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hyQ.thread_id);
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hyQ));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hyQ != null && !StringUtils.isNull(this.hyQ.video_url)) {
            uf(this.hyQ.video_url);
            this.bEv = true;
            if (this.mIsVisible) {
                aQD();
                if (this.hyQ != null && this.lQ != null) {
                    ak akVar = new ak("c12794");
                    akVar.ab("tid", this.hyQ.thread_id);
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
        if (this.bEv) {
            if (this.mIsVisible) {
                if (this.hyQ != null && this.lQ == null) {
                    ak akVar = new ak("c12794");
                    akVar.ab("tid", this.hyQ.thread_id);
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

    private void uf(String str) {
        if (this.hyA != null) {
            this.hyA.setRecoveryState(0);
            this.hyA.bN(str, this.hyQ.thread_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bEw()) {
            if (this.hyM != null) {
                this.hyM.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hyB.getVisibility() == 0) {
                this.hyB.clearAnimation();
                this.hyB.startAnimation(this.hyS);
            }
            if (this.hyA != null) {
                this.hyA.seekTo(0);
                this.hyA.start();
                if (this.hyQ != null) {
                    aa aaVar = new aa();
                    aaVar.mLocate = "nani_midpage";
                    aaVar.bCS = this.hyQ.thread_id;
                    aaVar.cZI = this.hyQ.forum_id + "";
                    aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    aaVar.mSource = this.hyQ.mRecomSource;
                    aaVar.gvL = this.hyQ.mRecomAbTag;
                    aaVar.gvM = this.hyQ.mRecomWeight;
                    aaVar.gvN = "";
                    aaVar.aMq = "";
                    aaVar.gvP = this.hyQ.mMd5;
                    if (this.lQ != null) {
                        aaVar.gvQ = "1";
                    } else {
                        aaVar.gvQ = "2";
                    }
                    com.baidu.tieba.play.l.a(this.hyQ.mMd5, "", "1", aaVar);
                }
            }
        }
    }

    private void pausePlay() {
        if (this.hyA != null) {
            this.hyA.pause();
        }
    }

    private void stopPlay() {
        this.hyA.setRecoveryState(5);
        this.hyA.stopPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEr() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hyQ.thread_id, this.hyQ.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hyQ.forum_id));
        createNormalCfg.setForumName(this.hyQ.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEs() {
        if (this.cXD == null) {
            this.cXE = new com.baidu.tieba.view.c(getActivity());
            ArrayList arrayList = new ArrayList();
            c.a aVar = new c.a(this.cXE);
            aVar.a(new c.InterfaceC0251c() { // from class: com.baidu.tieba.videoplay.a.14
                @Override // com.baidu.tieba.view.c.InterfaceC0251c
                public void onClick() {
                    a.this.cXD.dismiss();
                    if (a.this.hyQ != null) {
                        boolean z = a.this.hyQ.post_id != null && a.this.hyQ.post_id.equals(a.this.hyQ.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(a.this.hyQ.thread_id);
                        markData.setPostId(a.this.hyQ.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(a.this.hyQ.thread_id);
                        markData.setForumId(a.this.hyQ.forum_id);
                        if (a.this.flD != null) {
                            a.this.flD.a(markData);
                            if (!z) {
                                a.this.flD.vZ();
                            } else {
                                a.this.flD.vY();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hyQ != null && this.hyQ.post_id != null && this.hyQ.post_id.equals(this.hyQ.mark_id)) {
                z = true;
            }
            if (z) {
                aVar.setText(getResources().getString(d.j.remove_mark));
            } else {
                aVar.setText(getResources().getString(d.j.mark));
            }
            arrayList.add(aVar);
            c.a aVar2 = new c.a(getActivity().getString(d.j.delete), this.cXE);
            aVar2.a(new c.InterfaceC0251c() { // from class: com.baidu.tieba.videoplay.a.15
                @Override // com.baidu.tieba.view.c.InterfaceC0251c
                public void onClick() {
                    a.this.cXD.dismiss();
                    if (ay.ba(a.this.getActivity()) && a.this.hyQ != null) {
                        String str = a.this.hyQ.thread_id;
                        String str2 = a.this.hyQ.forum_id;
                        a.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(a.this.getPageContext().getPageActivity(), a.this.getResources().getString(d.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + a.this.hyQ.post_id, true)));
                    }
                }
            });
            aVar2.setText(getResources().getString(d.j.report_text));
            arrayList.add(aVar2);
            if (this.ecy) {
                c.a aVar3 = new c.a(getActivity().getString(d.j.delete), this.cXE);
                aVar3.a(new c.InterfaceC0251c() { // from class: com.baidu.tieba.videoplay.a.16
                    @Override // com.baidu.tieba.view.c.InterfaceC0251c
                    public void onClick() {
                        a.this.cXD.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar4 = new com.baidu.tbadk.core.dialog.a(a.this.getActivity());
                        aVar4.fb(d.j.del_thread_confirm);
                        aVar4.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.a.16.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar5) {
                                aVar4.dismiss();
                                if (a.this.hyQ != null) {
                                    a.this.cXM.a(a.this.hyQ.forum_id, a.this.hyQ.forum_name, a.this.hyQ.thread_id, a.this.hyQ.post_id, 0, 0, a.this.ecy);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                                }
                            }
                        });
                        aVar4.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.a.16.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar5) {
                                aVar4.dismiss();
                            }
                        });
                        aVar4.aZ(true);
                        aVar4.b(a.this.getPageContext());
                        aVar4.AU();
                    }
                });
                aVar3.setText(getResources().getString(d.j.delete));
                arrayList.add(aVar3);
            }
            this.cXE.dO(arrayList);
            this.cXD = new e(getActivity(), this.cXE.bEK());
        }
        this.cXD.show();
    }

    private void bEt() {
        if (this.hyQ != null) {
            this.hyB.startLoad(this.hyQ.thumbnail_url, 10, false);
            this.hyH.setText(this.hyQ.title);
            this.hyJ.setText(am.J(com.baidu.adp.lib.g.b.c(this.hyQ.comment_num, 0L)));
            this.hyK.setText(am.J(com.baidu.adp.lib.g.b.c(this.hyQ.agree_num, 0L)));
            this.hyL.setText(am.J(com.baidu.adp.lib.g.b.c(this.hyQ.share_num, 0L)));
            if (this.hyQ.author_info != null) {
                this.hyC.startLoad(this.hyQ.author_info.portrait, 12, false);
                if (StringUtils.isNull(this.hyQ.author_info.bAM())) {
                    this.hyU.setVisibility(8);
                } else {
                    this.hyU.setVisibility(0);
                    this.hyU.setText("@" + this.hyQ.author_info.bAM());
                }
            }
            if ("1".equals(this.hyQ.is_private) && this.hyR.getVisibility() != 0) {
                this.hyP.setVisibility(0);
            } else {
                this.hyP.setVisibility(8);
            }
            if ("1".equals(this.hyQ.is_agreed)) {
                aj.c(this.hyT, d.f.icon_home_card_like_s);
            } else {
                aj.c(this.hyT, d.f.btn_video_agree);
            }
            if (this.hyQ.act_info != null && !StringUtils.isNull(this.hyQ.act_info.activity_name) && this.hyR.getVisibility() != 0) {
                this.hyO.setVisibility(0);
                this.hyI.setText(this.hyQ.act_info.activity_name);
            } else {
                this.hyO.setVisibility(8);
            }
            bEu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEu() {
        if (this.ecy || (this.hyQ.author_info != null && !"0".equals(this.hyQ.author_info.is_follow))) {
            this.hyG.setVisibility(4);
            this.hyG.setClickable(false);
            return;
        }
        this.hyG.setVisibility(0);
        this.hyG.setClickable(true);
    }

    private void bEv() {
        if (this.hyZ == null || !this.hyZ.isShowing()) {
            this.hyZ = new com.baidu.tbadk.core.dialog.a(getActivity());
            this.hyZ.fa(d.j.net_change_title);
            this.hyZ.fb(d.j.net_change_tip);
            this.hyZ.a(d.j.video_continue, new a.b() { // from class: com.baidu.tieba.videoplay.a.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                    a.this.startPlay();
                }
            });
            this.hyZ.b(d.j.pause, new a.b() { // from class: com.baidu.tieba.videoplay.a.18
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hyZ.aZ(true);
            this.hyZ.b(getPageContext());
            this.hyZ.AU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEw() {
        if (!j.oJ() || j.oK()) {
            return true;
        }
        if (this.mIsVisible) {
            if (this.hyM != null) {
                this.hyM.setVisibility(0);
            }
            pausePlay();
            bEv();
            return false;
        }
        return false;
    }

    private void aQD() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bEw()) && this.hyA != null && this.hyM != null) {
            this.hyA.start();
            this.hyM.setVisibility(8);
        }
    }

    protected Animation getScaleAnimation() {
        if (this.bdI == null) {
            this.bdI = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bdI.setDuration(200L);
        }
        return this.bdI;
    }

    public long bEx() {
        if (this.hyN != null) {
            this.hyN.setVisibility(8);
        }
        if (this.hyR != null) {
            this.hyR.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }
}
