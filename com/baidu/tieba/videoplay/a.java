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
    private boolean bEI;
    public ImageView bYE;
    protected ScaleAnimation bdU;
    private e cXP;
    private com.baidu.tieba.view.c cXQ;
    private n cba;
    private boolean ecK;
    public QuickVideoView hyN;
    private TbImageView hyO;
    public TbImageView hyP;
    public LinearLayout hyQ;
    public LinearLayout hyR;
    public LinearLayout hyS;
    public ImageView hyT;
    public TextView hyU;
    public TextView hyV;
    public TextView hyW;
    public TextView hyX;
    public TextView hyY;
    public ImageView hyZ;
    private LinearLayout hza;
    public LinearLayout hzb;
    public LinearLayout hzc;
    public VideoItemData hzd;
    private TextView hze;
    private AlphaAnimation hzf;
    public ImageView hzg;
    public TextView hzh;
    private int hzi;
    private int hzj;
    private VideoPlayModel hzk;
    private int hzl;
    com.baidu.tbadk.core.dialog.a hzm;
    private Rect lQ;
    public ImageView mBackBtn;
    private String mFrom;
    private boolean mIsVisible;
    public View mRootView;
    private ForumManageModel cXY = null;
    private com.baidu.tbadk.baseEditMark.a flP = null;
    private com.baidu.tbadk.coreExtra.model.a bfC = null;
    private BdUniqueId brv = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (a.this.hzd != null && a.this.hzd.author_info != null && !StringUtils.isNull(a.this.hzd.author_info.user_id) && data != null && a.this.hzd.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(a.this.brv)) ? false : false;
                    if (data.biU == null) {
                        if (!data.apP) {
                            if (z && !"0".equals(a.this.hzd.author_info.is_follow)) {
                                l.showToast(a.this.getActivity(), d.j.attention_fail);
                                a.this.hzd.author_info.is_follow = "0";
                                a.this.bEv();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (a.this.mIsVisible) {
                                if (z) {
                                    l.showToast(a.this.getActivity(), d.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, a.this.hzd));
                                    return;
                                }
                                a.this.hzd.author_info.is_follow = "1";
                                a.this.bEv();
                            }
                        } else {
                            a.this.hzd.author_info.is_follow = "0";
                            a.this.bEv();
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
                a.this.bEx();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.hzd = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.lQ = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hzl = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        if (this.hzd != null && this.hzd.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hzd.author_info.user_id)) {
            this.ecK = true;
        }
        this.hzk = new VideoPlayModel((VideoPlayActivity) getActivity());
        this.cba = new n(getActivity());
        this.mRootView = layoutInflater.inflate(d.h.video_play_view, (ViewGroup) null);
        this.hyN = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.hyN.setBusiness(this.cba);
        if (this.hzd != null) {
            aa aaVar = new aa();
            aaVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            aaVar.bDf = this.hzd.thread_id;
            aaVar.cZU = this.hzd.forum_id;
            aaVar.gwa = this.hzd.mMd5;
            aaVar.aMB = "";
            aaVar.mSource = this.hzd.mRecomSource;
            aaVar.gvZ = this.hzd.mRecomAbTag;
            aaVar.gvX = this.hzd.mRecomWeight;
            if (this.lQ != null) {
                aaVar.gwb = "1";
            } else {
                aaVar.gwb = "2";
            }
            this.cba.setVideoStatsData(aaVar);
        }
        this.hyO = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.hyO.setDefaultBgResource(d.f.icon_play_bg);
        this.hyO.setDefaultErrorResource(d.f.icon_play_bg);
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.bYE = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.hyP = (TbImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.hyP.setIsRound(true);
        this.hyP.setDrawerType(1);
        this.hyP.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.hyP.setDefaultResource(d.C0140d.transparent);
        this.hyP.setDefaultBgResource(d.C0140d.transparent);
        this.hyT = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.hzg = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.hyU = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.hyV = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.hyR = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.hyW = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.hyQ = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.hyX = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.hyY = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.hyZ = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.hza = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.hzb = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.hzc = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.hyS = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.hzh = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.hze = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.hze.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hze.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.hze.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    aw.Du().a((TbPageContext) i.ak(a.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bEu();
        this.hyN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hyN.isPlaying()) {
                    a.this.hyN.pause();
                    a.this.hyZ.setVisibility(0);
                } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || a.this.bEx()) {
                    a.this.hyN.start();
                    a.this.hyZ.setVisibility(8);
                }
            }
        });
        this.hyP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hzd != null && a.this.hzd.author_info != null && !StringUtils.isNull(a.this.hzd.author_info.user_id) && a.this.hzd != null && a.this.hzd.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(a.this.hzd.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.getActivity()).createNormalConfig(c, z, false)));
                    ak akVar = new ak("c12798");
                    akVar.ab("tid", a.this.hzd.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(akVar);
                }
            }
        });
        this.hzb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hzd != null && a.this.hzd.act_info != null) {
                    com.baidu.tbadk.browser.b.S(a.this.getActivity(), a.this.hzd.act_info.link_url);
                    ak akVar = new ak("c12799");
                    akVar.ab("tid", a.this.hzd.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(akVar);
                }
            }
        });
        this.hyU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bEs();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hzd != null && !StringUtils.isNull(a.this.hzd.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, a.this.hzd.thread_id));
                }
                a.this.getActivity().finish();
            }
        });
        this.bYE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bEt();
            }
        });
        this.hyR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bEs();
                ak akVar = new ak("c12796");
                akVar.ab("tid", a.this.hzd.thread_id);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(akVar);
            }
        });
        this.hyQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bbN();
            }
        });
        this.hyS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Es();
                ak akVar = new ak("c12797");
                akVar.ab("tid", a.this.hzd.thread_id);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(akVar);
            }
        });
        this.hyT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ay.ba(a.this.getActivity()) && a.this.hzd != null && a.this.hzd.author_info != null) {
                    a.this.bfC.a(true, a.this.hzd.author_info.portrait, a.this.hzd.author_info.user_id, false, "6", a.this.brv, a.this.hzd.forum_id, "0");
                    a.this.hzd.author_info.is_follow = "1";
                    a.this.bEv();
                }
            }
        });
        this.hzf = new AlphaAnimation(1.0f, 0.0f);
        this.hzf.setDuration(100L);
        this.hzf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hyO != null) {
                    a.this.hyO.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.lQ != null) {
            this.hzi = this.lQ.right - this.lQ.left;
            this.hzj = this.lQ.bottom - this.lQ.top;
            this.hyO.post(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = a.this.hyO.getWidth();
                    int height = a.this.hyO.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.h(a.this.hzd.video_height, 0) > 0 && com.baidu.adp.lib.g.b.h(a.this.hzd.video_width, 0) > 0) {
                        float f3 = width / height;
                        float b = com.baidu.adp.lib.g.b.b(a.this.hzd.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(a.this.hzd.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f3) > 0.05d) {
                            if (b > f3) {
                                i = (int) (width / b);
                                i2 = width;
                            } else {
                                i2 = (int) (height * b);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.this.hzi, a.this.hzj);
                            layoutParams.leftMargin = a.this.lQ.left;
                            layoutParams.topMargin = a.this.lQ.top;
                            a.this.hyO.setLayoutParams(layoutParams);
                            if (a.this.hzj > 0 || a.this.hzi <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / a.this.hzi;
                                f = i / a.this.hzj;
                            }
                            a.this.hyO.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (a.this.lQ.left + ((a.this.lQ.right - a.this.lQ.left) / 2))).translationY((height / 2.0f) - (a.this.lQ.top + ((a.this.lQ.bottom - a.this.lQ.top) / 2))).start();
                            a.this.hyO.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7.1
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
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a.this.hzi, a.this.hzj);
                    layoutParams2.leftMargin = a.this.lQ.left;
                    layoutParams2.topMargin = a.this.lQ.top;
                    a.this.hyO.setLayoutParams(layoutParams2);
                    if (a.this.hzj > 0) {
                    }
                    f = 1.0f;
                    a.this.hyO.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (a.this.lQ.left + ((a.this.lQ.right - a.this.lQ.left) / 2))).translationY((height / 2.0f) - (a.this.lQ.top + ((a.this.lQ.bottom - a.this.lQ.top) / 2))).start();
                    a.this.hyO.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7.1
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
            this.hyO.post(new Runnable() { // from class: com.baidu.tieba.videoplay.a.8
                @Override // java.lang.Runnable
                public void run() {
                    int width = a.this.hyO.getWidth();
                    int height = a.this.hyO.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.h(a.this.hzd.video_height, 0) > 0 && com.baidu.adp.lib.g.b.h(a.this.hzd.video_width, 0) > 0) {
                        float f = width / height;
                        float b = com.baidu.adp.lib.g.b.b(a.this.hzd.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(a.this.hzd.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f) > 0.05d) {
                            if (b > f) {
                                height = (int) (width / b);
                            } else {
                                width = (int) (height * b);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = a.this.hyO.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        a.this.hyO.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Es() {
        if (this.hzd != null) {
            String str = this.hzd.forum_id;
            String str2 = this.hzd.forum_name;
            String str3 = this.hzd.title;
            String str4 = this.hzd.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hzd.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.blE = "";
            dVar.linkUrl = str5;
            dVar.aQD = 2;
            dVar.extData = str4;
            dVar.blH = 3;
            dVar.fid = str;
            dVar.blz = str2;
            dVar.tid = str4;
            dVar.blw = true;
            dVar.blG = 0;
            dVar.blI = 2;
            if (parse != null) {
                dVar.blB = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hzd.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hzd.title;
            originalThreadInfo.threadId = this.hzd.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.blH);
            bundle.putInt("obj_type", dVar.blI);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aQD);
            dVar.i(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.d.d.anj().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.ecK) {
            this.cXY = new ForumManageModel(getPageContext());
            this.cXY.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.a.9
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    if (obj != null) {
                        switch (a.this.cXY.getLoadDataMode()) {
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
        this.flP = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.flP != null) {
            this.flP.a(new a.InterfaceC0092a() { // from class: com.baidu.tieba.videoplay.a.10
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0092a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (a.this.flP != null) {
                            a.this.flP.aL(z2);
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
        this.bfC = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bEu();
        this.hyN.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.a.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                gVar.setLooping(true);
            }
        });
        if (Build.VERSION.SDK_INT >= 17) {
            this.hyN.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.a.13
                @Override // com.baidu.tieba.play.g.e
                public boolean a(g gVar, int i, int i2) {
                    if (a.this.mIsVisible && i == 3 && a.this.hyO.getVisibility() == 0) {
                        a.this.hyO.clearAnimation();
                        a.this.hyO.startAnimation(a.this.hzf);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbN() {
        int i;
        if (ay.ba(getActivity()) && this.hzd != null) {
            if ("1".equals(this.hzd.is_agreed)) {
                i = 1;
                this.hzd.agree_num = String.valueOf(com.baidu.adp.lib.g.b.h(this.hzd.agree_num, 0) - 1);
                this.hzd.is_agreed = "0";
            } else {
                this.hzd.agree_num = String.valueOf(com.baidu.adp.lib.g.b.h(this.hzd.agree_num, 0) + 1);
                this.hzd.is_agreed = "1";
                i = 0;
            }
            ak akVar = new ak("c12795");
            akVar.ab("tid", this.hzd.thread_id);
            akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            akVar.s("obj_type", i);
            TiebaStatic.log(akVar);
            bEu();
            if (this.hzg != null && i == 0) {
                this.hzg.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hzd.thread_id);
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hzd));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hzd != null && !StringUtils.isNull(this.hzd.video_url)) {
            uf(this.hzd.video_url);
            this.bEI = true;
            if (this.mIsVisible) {
                aQE();
                if (this.hzd != null && this.lQ != null) {
                    ak akVar = new ak("c12794");
                    akVar.ab("tid", this.hzd.thread_id);
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
        if (this.bEI) {
            if (this.mIsVisible) {
                if (this.hzd != null && this.lQ == null) {
                    ak akVar = new ak("c12794");
                    akVar.ab("tid", this.hzd.thread_id);
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
        if (this.hyN != null) {
            this.hyN.setRecoveryState(0);
            this.hyN.bN(str, this.hzd.thread_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bEx()) {
            if (this.hyZ != null) {
                this.hyZ.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hyO.getVisibility() == 0) {
                this.hyO.clearAnimation();
                this.hyO.startAnimation(this.hzf);
            }
            if (this.hyN != null) {
                this.hyN.seekTo(0);
                this.hyN.start();
                if (this.hzd != null) {
                    aa aaVar = new aa();
                    aaVar.mLocate = "nani_midpage";
                    aaVar.bDf = this.hzd.thread_id;
                    aaVar.cZU = this.hzd.forum_id + "";
                    aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    aaVar.mSource = this.hzd.mRecomSource;
                    aaVar.gvW = this.hzd.mRecomAbTag;
                    aaVar.gvX = this.hzd.mRecomWeight;
                    aaVar.gvY = "";
                    aaVar.aMB = "";
                    aaVar.gwa = this.hzd.mMd5;
                    if (this.lQ != null) {
                        aaVar.gwb = "1";
                    } else {
                        aaVar.gwb = "2";
                    }
                    com.baidu.tieba.play.l.a(this.hzd.mMd5, "", "1", aaVar);
                }
            }
        }
    }

    private void pausePlay() {
        if (this.hyN != null) {
            this.hyN.pause();
        }
    }

    private void stopPlay() {
        this.hyN.setRecoveryState(5);
        this.hyN.stopPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEs() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hzd.thread_id, this.hzd.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hzd.forum_id));
        createNormalCfg.setForumName(this.hzd.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEt() {
        if (this.cXP == null) {
            this.cXQ = new com.baidu.tieba.view.c(getActivity());
            ArrayList arrayList = new ArrayList();
            c.a aVar = new c.a(this.cXQ);
            aVar.a(new c.InterfaceC0250c() { // from class: com.baidu.tieba.videoplay.a.14
                @Override // com.baidu.tieba.view.c.InterfaceC0250c
                public void onClick() {
                    a.this.cXP.dismiss();
                    if (a.this.hzd != null) {
                        boolean z = a.this.hzd.post_id != null && a.this.hzd.post_id.equals(a.this.hzd.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(a.this.hzd.thread_id);
                        markData.setPostId(a.this.hzd.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(a.this.hzd.thread_id);
                        markData.setForumId(a.this.hzd.forum_id);
                        if (a.this.flP != null) {
                            a.this.flP.a(markData);
                            if (!z) {
                                a.this.flP.vZ();
                            } else {
                                a.this.flP.vY();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hzd != null && this.hzd.post_id != null && this.hzd.post_id.equals(this.hzd.mark_id)) {
                z = true;
            }
            if (z) {
                aVar.setText(getResources().getString(d.j.remove_mark));
            } else {
                aVar.setText(getResources().getString(d.j.mark));
            }
            arrayList.add(aVar);
            c.a aVar2 = new c.a(getActivity().getString(d.j.delete), this.cXQ);
            aVar2.a(new c.InterfaceC0250c() { // from class: com.baidu.tieba.videoplay.a.15
                @Override // com.baidu.tieba.view.c.InterfaceC0250c
                public void onClick() {
                    a.this.cXP.dismiss();
                    if (ay.ba(a.this.getActivity()) && a.this.hzd != null) {
                        String str = a.this.hzd.thread_id;
                        String str2 = a.this.hzd.forum_id;
                        a.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(a.this.getPageContext().getPageActivity(), a.this.getResources().getString(d.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + a.this.hzd.post_id, true)));
                    }
                }
            });
            aVar2.setText(getResources().getString(d.j.report_text));
            arrayList.add(aVar2);
            if (this.ecK) {
                c.a aVar3 = new c.a(getActivity().getString(d.j.delete), this.cXQ);
                aVar3.a(new c.InterfaceC0250c() { // from class: com.baidu.tieba.videoplay.a.16
                    @Override // com.baidu.tieba.view.c.InterfaceC0250c
                    public void onClick() {
                        a.this.cXP.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar4 = new com.baidu.tbadk.core.dialog.a(a.this.getActivity());
                        aVar4.fb(d.j.del_thread_confirm);
                        aVar4.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.a.16.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar5) {
                                aVar4.dismiss();
                                if (a.this.hzd != null) {
                                    a.this.cXY.a(a.this.hzd.forum_id, a.this.hzd.forum_name, a.this.hzd.thread_id, a.this.hzd.post_id, 0, 0, a.this.ecK);
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
            this.cXQ.dO(arrayList);
            this.cXP = new e(getActivity(), this.cXQ.bEL());
        }
        this.cXP.show();
    }

    private void bEu() {
        if (this.hzd != null) {
            this.hyO.startLoad(this.hzd.thumbnail_url, 10, false);
            this.hyU.setText(this.hzd.title);
            this.hyW.setText(am.J(com.baidu.adp.lib.g.b.c(this.hzd.comment_num, 0L)));
            this.hyX.setText(am.J(com.baidu.adp.lib.g.b.c(this.hzd.agree_num, 0L)));
            this.hyY.setText(am.J(com.baidu.adp.lib.g.b.c(this.hzd.share_num, 0L)));
            if (this.hzd.author_info != null) {
                this.hyP.startLoad(this.hzd.author_info.portrait, 12, false);
                if (StringUtils.isNull(this.hzd.author_info.bAN())) {
                    this.hzh.setVisibility(8);
                } else {
                    this.hzh.setVisibility(0);
                    this.hzh.setText("@" + this.hzd.author_info.bAN());
                }
            }
            if ("1".equals(this.hzd.is_private) && this.hze.getVisibility() != 0) {
                this.hzc.setVisibility(0);
            } else {
                this.hzc.setVisibility(8);
            }
            if ("1".equals(this.hzd.is_agreed)) {
                aj.c(this.hzg, d.f.icon_home_card_like_s);
            } else {
                aj.c(this.hzg, d.f.btn_video_agree);
            }
            if (this.hzd.act_info != null && !StringUtils.isNull(this.hzd.act_info.activity_name) && this.hze.getVisibility() != 0) {
                this.hzb.setVisibility(0);
                this.hyV.setText(this.hzd.act_info.activity_name);
            } else {
                this.hzb.setVisibility(8);
            }
            bEv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEv() {
        if (this.ecK || (this.hzd.author_info != null && !"0".equals(this.hzd.author_info.is_follow))) {
            this.hyT.setVisibility(4);
            this.hyT.setClickable(false);
            return;
        }
        this.hyT.setVisibility(0);
        this.hyT.setClickable(true);
    }

    private void bEw() {
        if (this.hzm == null || !this.hzm.isShowing()) {
            this.hzm = new com.baidu.tbadk.core.dialog.a(getActivity());
            this.hzm.fa(d.j.net_change_title);
            this.hzm.fb(d.j.net_change_tip);
            this.hzm.a(d.j.video_continue, new a.b() { // from class: com.baidu.tieba.videoplay.a.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                    a.this.startPlay();
                }
            });
            this.hzm.b(d.j.pause, new a.b() { // from class: com.baidu.tieba.videoplay.a.18
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hzm.aZ(true);
            this.hzm.b(getPageContext());
            this.hzm.AU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEx() {
        if (!j.oJ() || j.oK()) {
            return true;
        }
        if (this.mIsVisible) {
            if (this.hyZ != null) {
                this.hyZ.setVisibility(0);
            }
            pausePlay();
            bEw();
            return false;
        }
        return false;
    }

    private void aQE() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bEx()) && this.hyN != null && this.hyZ != null) {
            this.hyN.start();
            this.hyZ.setVisibility(8);
        }
    }

    protected Animation getScaleAnimation() {
        if (this.bdU == null) {
            this.bdU = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bdU.setDuration(200L);
        }
        return this.bdU;
    }

    public long bEy() {
        if (this.hza != null) {
            this.hza.setVisibility(8);
        }
        if (this.hze != null) {
            this.hze.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }
}
