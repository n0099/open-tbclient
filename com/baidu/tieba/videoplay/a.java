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
    private boolean bCw;
    public ImageView bWn;
    private n bYJ;
    protected ScaleAnimation bbV;
    private com.baidu.tieba.d.c bbW;
    private e cUJ;
    private com.baidu.tieba.view.c cUK;
    private boolean dYd;
    private int hxA;
    private int hxB;
    private VideoPlayModel hxC;
    private int hxD;
    com.baidu.tbadk.core.dialog.a hxE;
    public QuickVideoView hxf;
    private TbImageView hxg;
    public TbImageView hxh;
    public LinearLayout hxi;
    public LinearLayout hxj;
    public LinearLayout hxk;
    public ImageView hxl;
    public TextView hxm;
    public TextView hxn;
    public TextView hxo;
    public TextView hxp;
    public TextView hxq;
    public ImageView hxr;
    private LinearLayout hxs;
    public LinearLayout hxt;
    public LinearLayout hxu;
    public VideoItemData hxv;
    private TextView hxw;
    private AlphaAnimation hxx;
    public ImageView hxy;
    public TextView hxz;
    private Rect lQ;
    public ImageView mBackBtn;
    private String mFrom;
    private boolean mIsVisible;
    public View mRootView;
    private ForumManageModel cUS = null;
    private com.baidu.tbadk.baseEditMark.a fhR = null;
    private com.baidu.tbadk.coreExtra.model.a bdB = null;
    private BdUniqueId boY = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (a.this.hxv != null && a.this.hxv.author_info != null && !StringUtils.isNull(a.this.hxv.author_info.user_id) && data != null && a.this.hxv.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(a.this.boY)) ? false : false;
                    if (data.bgK == null) {
                        if (!data.apN) {
                            if (z && !"0".equals(a.this.hxv.author_info.is_follow)) {
                                l.showToast(a.this.getActivity(), d.j.attention_fail);
                                a.this.hxv.author_info.is_follow = "0";
                                a.this.bDL();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (a.this.mIsVisible) {
                                if (z) {
                                    l.showToast(a.this.getActivity(), d.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, a.this.hxv));
                                    return;
                                }
                                a.this.hxv.author_info.is_follow = "1";
                                a.this.bDL();
                            }
                        } else {
                            a.this.hxv.author_info.is_follow = "0";
                            a.this.bDL();
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
                a.this.bDN();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.hxv = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.lQ = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hxD = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        if (this.hxv != null && this.hxv.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hxv.author_info.user_id)) {
            this.dYd = true;
        }
        this.hxC = new VideoPlayModel((VideoPlayActivity) getActivity());
        this.bYJ = new n(getActivity());
        this.mRootView = layoutInflater.inflate(d.h.video_play_view, (ViewGroup) null);
        this.hxf = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.hxf.setBusiness(this.bYJ);
        if (this.hxv != null) {
            aa aaVar = new aa();
            aaVar.mLocate = "14";
            aaVar.bAT = this.hxv.thread_id;
            aaVar.cWM = this.hxv.forum_id;
            aaVar.gtZ = this.hxv.mMd5;
            aaVar.aLe = "";
            aaVar.mSource = this.hxv.mRecomSource;
            aaVar.gtY = this.hxv.mRecomAbTag;
            aaVar.gtW = this.hxv.mRecomWeight;
            if (this.lQ != null) {
                aaVar.gua = "1";
            } else {
                aaVar.gua = "2";
            }
            this.bYJ.setVideoStatsData(aaVar);
        }
        this.hxg = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.hxg.setDefaultBgResource(d.f.icon_play_bg);
        this.hxg.setDefaultErrorResource(d.f.icon_play_bg);
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.bWn = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.hxh = (TbImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.hxh.setIsRound(true);
        this.hxh.setDrawerType(1);
        this.hxh.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.hxh.setDefaultResource(d.C0107d.transparent);
        this.hxh.setDefaultBgResource(d.C0107d.transparent);
        this.hxl = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.hxy = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.hxm = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.hxn = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.hxj = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.hxo = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.hxi = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.hxp = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.hxq = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.hxr = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.hxs = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.hxt = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.hxu = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.hxk = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.hxz = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.hxw = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.hxw.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hxw.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.hxw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    av.CZ().a((TbPageContext) i.ak(a.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bDK();
        this.hxf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hxf.isPlaying()) {
                    a.this.hxf.pause();
                    a.this.hxr.setVisibility(0);
                } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || a.this.bDN()) {
                    a.this.hxf.start();
                    a.this.hxr.setVisibility(8);
                }
            }
        });
        this.hxh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hxv != null && a.this.hxv.author_info != null && !StringUtils.isNull(a.this.hxv.author_info.user_id) && a.this.hxv != null && a.this.hxv.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(a.this.hxv.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.getActivity()).createNormalConfig(c, z, false)));
                    ak akVar = new ak("c12798");
                    akVar.ab("tid", a.this.hxv.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(akVar);
                }
            }
        });
        this.hxt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hxv != null && a.this.hxv.act_info != null) {
                    com.baidu.tbadk.browser.a.R(a.this.getActivity(), a.this.hxv.act_info.link_url);
                    ak akVar = new ak("c12799");
                    akVar.ab("tid", a.this.hxv.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(akVar);
                }
            }
        });
        this.hxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bDI();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hxv != null && !StringUtils.isNull(a.this.hxv.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, a.this.hxv.thread_id));
                }
                a.this.getActivity().finish();
            }
        });
        this.bWn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bDJ();
            }
        });
        this.hxj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bDI();
                ak akVar = new ak("c12796");
                akVar.ab("tid", a.this.hxv.thread_id);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(akVar);
            }
        });
        this.hxi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bad();
            }
        });
        this.hxk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.DW();
                ak akVar = new ak("c12797");
                akVar.ab("tid", a.this.hxv.thread_id);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(akVar);
            }
        });
        this.hxl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ax.be(a.this.getActivity()) && a.this.hxv != null && a.this.hxv.author_info != null) {
                    a.this.bdB.a(true, a.this.hxv.author_info.portrait, a.this.hxv.author_info.user_id, false, "6", a.this.boY, a.this.hxv.forum_id, "0");
                    a.this.hxv.author_info.is_follow = "1";
                    a.this.bDL();
                }
            }
        });
        this.hxx = new AlphaAnimation(1.0f, 0.0f);
        this.hxx.setDuration(100L);
        this.hxx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hxg != null) {
                    a.this.hxg.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.lQ != null) {
            this.hxA = this.lQ.right - this.lQ.left;
            this.hxB = this.lQ.bottom - this.lQ.top;
            this.hxg.post(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = a.this.hxg.getWidth();
                    int height = a.this.hxg.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.h(a.this.hxv.video_height, 0) > 0 && com.baidu.adp.lib.g.b.h(a.this.hxv.video_width, 0) > 0) {
                        float f3 = width / height;
                        float b = com.baidu.adp.lib.g.b.b(a.this.hxv.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(a.this.hxv.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f3) > 0.05d) {
                            if (b > f3) {
                                i = (int) (width / b);
                                i2 = width;
                            } else {
                                i2 = (int) (height * b);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.this.hxA, a.this.hxB);
                            layoutParams.leftMargin = a.this.lQ.left;
                            layoutParams.topMargin = a.this.lQ.top;
                            a.this.hxg.setLayoutParams(layoutParams);
                            if (a.this.hxB > 0 || a.this.hxA <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / a.this.hxA;
                                f = i / a.this.hxB;
                            }
                            a.this.hxg.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (a.this.lQ.left + ((a.this.lQ.right - a.this.lQ.left) / 2))).translationY((height / 2.0f) - (a.this.lQ.top + ((a.this.lQ.bottom - a.this.lQ.top) / 2))).start();
                            a.this.hxg.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7.1
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
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a.this.hxA, a.this.hxB);
                    layoutParams2.leftMargin = a.this.lQ.left;
                    layoutParams2.topMargin = a.this.lQ.top;
                    a.this.hxg.setLayoutParams(layoutParams2);
                    if (a.this.hxB > 0) {
                    }
                    f = 1.0f;
                    a.this.hxg.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (a.this.lQ.left + ((a.this.lQ.right - a.this.lQ.left) / 2))).translationY((height / 2.0f) - (a.this.lQ.top + ((a.this.lQ.bottom - a.this.lQ.top) / 2))).start();
                    a.this.hxg.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7.1
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
            this.hxg.post(new Runnable() { // from class: com.baidu.tieba.videoplay.a.8
                @Override // java.lang.Runnable
                public void run() {
                    int width = a.this.hxg.getWidth();
                    int height = a.this.hxg.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.h(a.this.hxv.video_height, 0) > 0 && com.baidu.adp.lib.g.b.h(a.this.hxv.video_width, 0) > 0) {
                        float f = width / height;
                        float b = com.baidu.adp.lib.g.b.b(a.this.hxv.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(a.this.hxv.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f) > 0.05d) {
                            if (b > f) {
                                height = (int) (width / b);
                            } else {
                                width = (int) (height * b);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = a.this.hxg.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        a.this.hxg.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DW() {
        if (this.hxv != null) {
            String str = this.hxv.forum_id;
            String str2 = this.hxv.forum_name;
            String str3 = this.hxv.title;
            String str4 = this.hxv.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hxv.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.bjh = "";
            dVar.linkUrl = str5;
            dVar.aPe = 2;
            dVar.extData = str4;
            dVar.bjk = 3;
            dVar.fid = str;
            dVar.bjc = str2;
            dVar.tid = str4;
            dVar.biZ = true;
            dVar.bjj = 0;
            dVar.bjl = 2;
            if (parse != null) {
                dVar.bje = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hxv.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hxv.title;
            originalThreadInfo.threadId = this.hxv.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.bjk);
            bundle.putInt("obj_type", dVar.bjl);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aPe);
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
        if (this.dYd) {
            this.cUS = new ForumManageModel(getPageContext());
            this.cUS.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.a.9
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    if (obj != null) {
                        switch (a.this.cUS.getLoadDataMode()) {
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
        this.fhR = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.fhR != null) {
            this.fhR.a(new a.InterfaceC0069a() { // from class: com.baidu.tieba.videoplay.a.10
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0069a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (a.this.fhR != null) {
                            a.this.fhR.aH(z2);
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
        this.bdB = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bDK();
        this.hxf.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.a.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                gVar.setLooping(true);
            }
        });
        if (Build.VERSION.SDK_INT >= 17) {
            this.hxf.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.a.13
                @Override // com.baidu.tieba.play.g.e
                public boolean a(g gVar, int i, int i2) {
                    if (a.this.mIsVisible && i == 3 && a.this.hxg.getVisibility() == 0) {
                        a.this.hxg.clearAnimation();
                        a.this.hxg.startAnimation(a.this.hxx);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bad() {
        int i;
        if (ax.be(getActivity()) && this.hxv != null) {
            if ("1".equals(this.hxv.is_agreed)) {
                i = 1;
                this.hxv.agree_num = String.valueOf(com.baidu.adp.lib.g.b.h(this.hxv.agree_num, 0) - 1);
                this.hxv.is_agreed = "0";
            } else {
                this.hxv.agree_num = String.valueOf(com.baidu.adp.lib.g.b.h(this.hxv.agree_num, 0) + 1);
                this.hxv.is_agreed = "1";
                i = 0;
            }
            ak akVar = new ak("c12795");
            akVar.ab("tid", this.hxv.thread_id);
            akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            akVar.s("obj_type", i);
            TiebaStatic.log(akVar);
            bDK();
            if (this.hxy != null && i == 0) {
                this.hxy.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hxv.thread_id);
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.hxv));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hxv != null && !StringUtils.isNull(this.hxv.video_url)) {
            tT(this.hxv.video_url);
            this.bCw = true;
            if (this.mIsVisible) {
                aOM();
                if (this.hxv != null && this.lQ != null) {
                    ak akVar = new ak("c12794");
                    akVar.ab("tid", this.hxv.thread_id);
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
        if (this.bCw) {
            if (this.mIsVisible) {
                if (this.hxv != null && this.lQ == null) {
                    ak akVar = new ak("c12794");
                    akVar.ab("tid", this.hxv.thread_id);
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

    private void tT(String str) {
        if (this.hxf != null) {
            this.hxf.setRecoveryState(0);
            this.hxf.bO(str, this.hxv.thread_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bDN()) {
            if (this.hxr != null) {
                this.hxr.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hxg.getVisibility() == 0) {
                this.hxg.clearAnimation();
                this.hxg.startAnimation(this.hxx);
            }
            if (this.hxf != null) {
                this.hxf.seekTo(0);
                this.hxf.start();
                if (this.hxv != null) {
                    aa aaVar = new aa();
                    aaVar.mLocate = "nani_midpage";
                    aaVar.bAT = this.hxv.thread_id;
                    aaVar.cWM = this.hxv.forum_id + "";
                    aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    aaVar.mSource = this.hxv.mRecomSource;
                    aaVar.gtV = this.hxv.mRecomAbTag;
                    aaVar.gtW = this.hxv.mRecomWeight;
                    aaVar.gtX = "";
                    aaVar.aLe = "";
                    aaVar.gtZ = this.hxv.mMd5;
                    com.baidu.tieba.play.l.a(this.hxv.mMd5, "", "1", aaVar);
                }
            }
        }
    }

    private void pausePlay() {
        if (this.hxf != null) {
            this.hxf.pause();
        }
    }

    private void stopPlay() {
        this.hxf.setRecoveryState(5);
        this.hxf.stopPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDI() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hxv.thread_id, this.hxv.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hxv.forum_id));
        createNormalCfg.setForumName(this.hxv.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDJ() {
        if (this.cUJ == null) {
            this.cUK = new com.baidu.tieba.view.c(getActivity());
            ArrayList arrayList = new ArrayList();
            c.a aVar = new c.a(this.cUK);
            aVar.a(new c.InterfaceC0167c() { // from class: com.baidu.tieba.videoplay.a.14
                @Override // com.baidu.tieba.view.c.InterfaceC0167c
                public void onClick() {
                    a.this.cUJ.dismiss();
                    if (a.this.hxv != null) {
                        boolean z = a.this.hxv.post_id != null && a.this.hxv.post_id.equals(a.this.hxv.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(a.this.hxv.thread_id);
                        markData.setPostId(a.this.hxv.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(a.this.hxv.thread_id);
                        markData.setForumId(a.this.hxv.forum_id);
                        if (a.this.fhR != null) {
                            a.this.fhR.a(markData);
                            if (!z) {
                                a.this.fhR.vm();
                            } else {
                                a.this.fhR.vl();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hxv != null && this.hxv.post_id != null && this.hxv.post_id.equals(this.hxv.mark_id)) {
                z = true;
            }
            if (z) {
                aVar.setText(getResources().getString(d.j.remove_mark));
            } else {
                aVar.setText(getResources().getString(d.j.mark));
            }
            arrayList.add(aVar);
            c.a aVar2 = new c.a(getActivity().getString(d.j.delete), this.cUK);
            aVar2.a(new c.InterfaceC0167c() { // from class: com.baidu.tieba.videoplay.a.15
                @Override // com.baidu.tieba.view.c.InterfaceC0167c
                public void onClick() {
                    a.this.cUJ.dismiss();
                    if (ax.be(a.this.getActivity()) && a.this.hxv != null) {
                        String str = a.this.hxv.thread_id;
                        String str2 = a.this.hxv.forum_id;
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(a.this.getPageContext().getPageActivity(), a.this.getResources().getString(d.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + a.this.hxv.post_id, true)));
                    }
                }
            });
            aVar2.setText(getResources().getString(d.j.report_text));
            arrayList.add(aVar2);
            if (this.dYd) {
                c.a aVar3 = new c.a(getActivity().getString(d.j.delete), this.cUK);
                aVar3.a(new c.InterfaceC0167c() { // from class: com.baidu.tieba.videoplay.a.16
                    @Override // com.baidu.tieba.view.c.InterfaceC0167c
                    public void onClick() {
                        a.this.cUJ.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar4 = new com.baidu.tbadk.core.dialog.a(a.this.getActivity());
                        aVar4.fb(d.j.del_thread_confirm);
                        aVar4.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.a.16.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar5) {
                                aVar4.dismiss();
                                if (a.this.hxv != null) {
                                    a.this.cUS.a(a.this.hxv.forum_id, a.this.hxv.forum_name, a.this.hxv.thread_id, a.this.hxv.post_id, 0, 0, a.this.dYd);
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
                        aVar4.aV(true);
                        aVar4.b(a.this.getPageContext());
                        aVar4.AA();
                    }
                });
                aVar3.setText(getResources().getString(d.j.delete));
                arrayList.add(aVar3);
            }
            this.cUK.dI(arrayList);
            this.cUJ = new e(getActivity(), this.cUK.bDT());
        }
        this.cUJ.show();
    }

    private void bDK() {
        if (this.hxv != null) {
            this.hxg.startLoad(this.hxv.thumbnail_url, 10, false);
            this.hxm.setText(this.hxv.title);
            this.hxo.setText(am.J(com.baidu.adp.lib.g.b.c(this.hxv.comment_num, 0L)));
            this.hxp.setText(am.J(com.baidu.adp.lib.g.b.c(this.hxv.agree_num, 0L)));
            this.hxq.setText(am.J(com.baidu.adp.lib.g.b.c(this.hxv.share_num, 0L)));
            if (this.hxv.author_info != null) {
                this.hxh.startLoad(this.hxv.author_info.portrait, 12, false);
                if (StringUtils.isNull(this.hxv.author_info.bAb())) {
                    this.hxz.setVisibility(8);
                } else {
                    this.hxz.setVisibility(0);
                    this.hxz.setText("@" + this.hxv.author_info.bAb());
                }
            }
            if ("1".equals(this.hxv.is_private) && this.hxw.getVisibility() != 0) {
                this.hxu.setVisibility(0);
            } else {
                this.hxu.setVisibility(8);
            }
            if ("1".equals(this.hxv.is_agreed)) {
                aj.c(this.hxy, d.f.icon_home_card_like_s);
            } else {
                aj.c(this.hxy, d.f.btn_video_agree);
            }
            if (this.hxv.act_info != null && !StringUtils.isNull(this.hxv.act_info.activity_name) && this.hxw.getVisibility() != 0) {
                this.hxt.setVisibility(0);
                this.hxn.setText(this.hxv.act_info.activity_name);
            } else {
                this.hxt.setVisibility(8);
            }
            bDL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDL() {
        if (this.dYd || (this.hxv.author_info != null && !"0".equals(this.hxv.author_info.is_follow))) {
            this.hxl.setVisibility(4);
            this.hxl.setClickable(false);
            return;
        }
        this.hxl.setVisibility(0);
        this.hxl.setClickable(true);
    }

    private void bDM() {
        if (this.hxE == null || !this.hxE.isShowing()) {
            this.hxE = new com.baidu.tbadk.core.dialog.a(getActivity());
            this.hxE.fa(d.j.net_change_title);
            this.hxE.fb(d.j.net_change_tip);
            this.hxE.a(d.j.video_continue, new a.b() { // from class: com.baidu.tieba.videoplay.a.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                    a.this.startPlay();
                }
            });
            this.hxE.b(d.j.pause, new a.b() { // from class: com.baidu.tieba.videoplay.a.18
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hxE.aV(true);
            this.hxE.b(getPageContext());
            this.hxE.AA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDN() {
        if (!j.oI() || j.oJ()) {
            return true;
        }
        if (this.mIsVisible) {
            if (this.hxr != null) {
                this.hxr.setVisibility(0);
            }
            pausePlay();
            bDM();
            return false;
        }
        return false;
    }

    private void aOM() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bDN()) && this.hxf != null && this.hxr != null) {
            this.hxf.start();
            this.hxr.setVisibility(8);
        }
    }

    protected Animation getScaleAnimation() {
        if (this.bbV == null) {
            this.bbV = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bbV.setDuration(200L);
        }
        return this.bbV;
    }

    public long bDO() {
        if (this.hxs != null) {
            this.hxs.setVisibility(8);
        }
        if (this.hxw != null) {
            this.hxw.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }
}
