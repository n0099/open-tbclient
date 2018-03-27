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
    private boolean bEy;
    public ImageView bYv;
    protected ScaleAnimation bdK;
    private e cXG;
    private com.baidu.tieba.view.c cXH;
    private n caR;
    private boolean ecO;
    public QuickVideoView hyY;
    private TbImageView hyZ;
    public TbImageView hza;
    public LinearLayout hzb;
    public LinearLayout hzc;
    public LinearLayout hzd;
    public ImageView hze;
    public TextView hzf;
    public TextView hzg;
    public TextView hzh;
    public TextView hzi;
    public TextView hzj;
    public ImageView hzk;
    private LinearLayout hzl;
    public LinearLayout hzm;
    public LinearLayout hzn;
    public VideoItemData hzo;
    private TextView hzp;
    private AlphaAnimation hzq;
    public ImageView hzr;
    public TextView hzs;
    private int hzt;
    private int hzu;
    private VideoPlayModel hzv;
    private int hzw;
    com.baidu.tbadk.core.dialog.a hzx;
    private Rect lQ;
    public ImageView mBackBtn;
    private String mFrom;
    private boolean mIsVisible;
    public View mRootView;
    private ForumManageModel cXP = null;
    private com.baidu.tbadk.baseEditMark.a flT = null;
    private com.baidu.tbadk.coreExtra.model.a bft = null;
    private BdUniqueId brl = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.videoplay.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (a.this.hzo != null && a.this.hzo.author_info != null && !StringUtils.isNull(a.this.hzo.author_info.user_id) && data != null && a.this.hzo.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(a.this.brl)) ? false : false;
                    if (data.biK == null) {
                        if (!data.apH) {
                            if (z && !"0".equals(a.this.hzo.author_info.is_follow)) {
                                l.showToast(a.this.getActivity(), d.j.attention_fail);
                                a.this.hzo.author_info.is_follow = "0";
                                a.this.bEz();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (a.this.mIsVisible) {
                                if (z) {
                                    l.showToast(a.this.getActivity(), d.j.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, a.this.hzo));
                                    return;
                                }
                                a.this.hzo.author_info.is_follow = "1";
                                a.this.bEz();
                            }
                        } else {
                            a.this.hzo.author_info.is_follow = "0";
                            a.this.bEz();
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
                a.this.bEB();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.hzo = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.lQ = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.hzw = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        if (this.hzo != null && this.hzo.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.hzo.author_info.user_id)) {
            this.ecO = true;
        }
        this.hzv = new VideoPlayModel((VideoPlayActivity) getActivity());
        this.caR = new n(getActivity());
        this.mRootView = layoutInflater.inflate(d.h.video_play_view, (ViewGroup) null);
        this.hyY = (QuickVideoView) this.mRootView.findViewById(d.g.videoView);
        this.hyY.setBusiness(this.caR);
        if (this.hzo != null) {
            aa aaVar = new aa();
            aaVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            aaVar.bCV = this.hzo.thread_id;
            aaVar.cZL = this.hzo.forum_id;
            aaVar.gwf = this.hzo.mMd5;
            aaVar.aMr = "";
            aaVar.mSource = this.hzo.mRecomSource;
            aaVar.gwe = this.hzo.mRecomAbTag;
            aaVar.gwc = this.hzo.mRecomWeight;
            if (this.lQ != null) {
                aaVar.gwg = "1";
            } else {
                aaVar.gwg = "2";
            }
            this.caR.setVideoStatsData(aaVar);
        }
        this.hyZ = (TbImageView) this.mRootView.findViewById(d.g.video_cover);
        this.hyZ.setDefaultBgResource(d.f.icon_play_bg);
        this.hyZ.setDefaultErrorResource(d.f.icon_play_bg);
        this.mBackBtn = (ImageView) this.mRootView.findViewById(d.g.back_btn);
        this.bYv = (ImageView) this.mRootView.findViewById(d.g.more_btn);
        this.hza = (TbImageView) this.mRootView.findViewById(d.g.author_portrait);
        this.hza.setIsRound(true);
        this.hza.setDrawerType(1);
        this.hza.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.hza.setDefaultResource(d.C0141d.transparent);
        this.hza.setDefaultBgResource(d.C0141d.transparent);
        this.hze = (ImageView) this.mRootView.findViewById(d.g.love_btn);
        this.hzr = (ImageView) this.mRootView.findViewById(d.g.agree_img);
        this.hzf = (TextView) this.mRootView.findViewById(d.g.video_title);
        this.hzg = (TextView) this.mRootView.findViewById(d.g.video_activity);
        this.hzc = (LinearLayout) this.mRootView.findViewById(d.g.comment_container);
        this.hzh = (TextView) this.mRootView.findViewById(d.g.comment_num);
        this.hzb = (LinearLayout) this.mRootView.findViewById(d.g.agree_container);
        this.hzi = (TextView) this.mRootView.findViewById(d.g.agree_num);
        this.hzj = (TextView) this.mRootView.findViewById(d.g.share_num);
        this.hzk = (ImageView) this.mRootView.findViewById(d.g.play_btn);
        this.hzl = (LinearLayout) this.mRootView.findViewById(d.g.video_act_private_container);
        this.hzm = (LinearLayout) this.mRootView.findViewById(d.g.video_activity_container);
        this.hzn = (LinearLayout) this.mRootView.findViewById(d.g.video_private);
        this.hzd = (LinearLayout) this.mRootView.findViewById(d.g.share_container);
        this.hzs = (TextView) this.mRootView.findViewById(d.g.video_author_name);
        this.hzp = (TextView) this.mRootView.findViewById(d.g.download_nani_guide_txt);
        this.hzp.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.hzp.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_download_link_url", null);
        this.hzp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    aw.Du().a((TbPageContext) i.ak(a.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        bEy();
        this.hyY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hyY.isPlaying()) {
                    a.this.hyY.pause();
                    a.this.hzk.setVisibility(0);
                } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || a.this.bEB()) {
                    a.this.hyY.start();
                    a.this.hzk.setVisibility(8);
                }
            }
        });
        this.hza.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hzo != null && a.this.hzo.author_info != null && !StringUtils.isNull(a.this.hzo.author_info.user_id) && a.this.hzo != null && a.this.hzo.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(a.this.hzo.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.getActivity()).createNormalConfig(c, z, false)));
                    ak akVar = new ak("c12798");
                    akVar.ab("tid", a.this.hzo.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(akVar);
                }
            }
        });
        this.hzm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hzo != null && a.this.hzo.act_info != null) {
                    com.baidu.tbadk.browser.b.S(a.this.getActivity(), a.this.hzo.act_info.link_url);
                    ak akVar = new ak("c12799");
                    akVar.ab("tid", a.this.hzo.thread_id);
                    akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(akVar);
                }
            }
        });
        this.hzf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bEw();
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hzo != null && !StringUtils.isNull(a.this.hzo.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, a.this.hzo.thread_id));
                }
                a.this.getActivity().finish();
            }
        });
        this.bYv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bEx();
            }
        });
        this.hzc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bEw();
                ak akVar = new ak("c12796");
                akVar.ab("tid", a.this.hzo.thread_id);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(akVar);
            }
        });
        this.hzb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bbN();
            }
        });
        this.hzd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Es();
                ak akVar = new ak("c12797");
                akVar.ab("tid", a.this.hzo.thread_id);
                akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(akVar);
            }
        });
        this.hze.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ay.ba(a.this.getActivity()) && a.this.hzo != null && a.this.hzo.author_info != null) {
                    a.this.bft.a(true, a.this.hzo.author_info.portrait, a.this.hzo.author_info.user_id, false, "6", a.this.brl, a.this.hzo.forum_id, "0");
                    a.this.hzo.author_info.is_follow = "1";
                    a.this.bEz();
                }
            }
        });
        this.hzq = new AlphaAnimation(1.0f, 0.0f);
        this.hzq.setDuration(100L);
        this.hzq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.hyZ != null) {
                    a.this.hyZ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.lQ != null) {
            this.hzt = this.lQ.right - this.lQ.left;
            this.hzu = this.lQ.bottom - this.lQ.top;
            this.hyZ.post(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = a.this.hyZ.getWidth();
                    int height = a.this.hyZ.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.h(a.this.hzo.video_height, 0) > 0 && com.baidu.adp.lib.g.b.h(a.this.hzo.video_width, 0) > 0) {
                        float f3 = width / height;
                        float b = com.baidu.adp.lib.g.b.b(a.this.hzo.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(a.this.hzo.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f3) > 0.05d) {
                            if (b > f3) {
                                i = (int) (width / b);
                                i2 = width;
                            } else {
                                i2 = (int) (height * b);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.this.hzt, a.this.hzu);
                            layoutParams.leftMargin = a.this.lQ.left;
                            layoutParams.topMargin = a.this.lQ.top;
                            a.this.hyZ.setLayoutParams(layoutParams);
                            if (a.this.hzu > 0 || a.this.hzt <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / a.this.hzt;
                                f = i / a.this.hzu;
                            }
                            a.this.hyZ.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (a.this.lQ.left + ((a.this.lQ.right - a.this.lQ.left) / 2))).translationY((height / 2.0f) - (a.this.lQ.top + ((a.this.lQ.bottom - a.this.lQ.top) / 2))).start();
                            a.this.hyZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7.1
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
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a.this.hzt, a.this.hzu);
                    layoutParams2.leftMargin = a.this.lQ.left;
                    layoutParams2.topMargin = a.this.lQ.top;
                    a.this.hyZ.setLayoutParams(layoutParams2);
                    if (a.this.hzu > 0) {
                    }
                    f = 1.0f;
                    a.this.hyZ.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (a.this.lQ.left + ((a.this.lQ.right - a.this.lQ.left) / 2))).translationY((height / 2.0f) - (a.this.lQ.top + ((a.this.lQ.bottom - a.this.lQ.top) / 2))).start();
                    a.this.hyZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.a.7.1
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
            this.hyZ.post(new Runnable() { // from class: com.baidu.tieba.videoplay.a.8
                @Override // java.lang.Runnable
                public void run() {
                    int width = a.this.hyZ.getWidth();
                    int height = a.this.hyZ.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.g.b.h(a.this.hzo.video_height, 0) > 0 && com.baidu.adp.lib.g.b.h(a.this.hzo.video_width, 0) > 0) {
                        float f = width / height;
                        float b = com.baidu.adp.lib.g.b.b(a.this.hzo.video_width, 0.0f) / com.baidu.adp.lib.g.b.b(a.this.hzo.video_height, 0.0f);
                        if (b > 0.0f && Math.abs(b - f) > 0.05d) {
                            if (b > f) {
                                height = (int) (width / b);
                            } else {
                                width = (int) (height * b);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = a.this.hyZ.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        a.this.hyZ.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Es() {
        if (this.hzo != null) {
            String str = this.hzo.forum_id;
            String str2 = this.hzo.forum_name;
            String str3 = this.hzo.title;
            String str4 = this.hzo.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.hzo.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str3;
            dVar.content = format;
            dVar.blu = "";
            dVar.linkUrl = str5;
            dVar.aQu = 2;
            dVar.extData = str4;
            dVar.blx = 3;
            dVar.fid = str;
            dVar.blp = str2;
            dVar.tid = str4;
            dVar.blm = true;
            dVar.blw = 0;
            dVar.bly = 2;
            if (parse != null) {
                dVar.blr = parse;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.hzo.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.hzo.title;
            originalThreadInfo.threadId = this.hzo.thread_id;
            dVar.originalThreadInfo = originalThreadInfo;
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.blx);
            bundle.putInt("obj_type", dVar.bly);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aQu);
            dVar.i(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), dVar, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.d.d.anj().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.ecO) {
            this.cXP = new ForumManageModel(getPageContext());
            this.cXP.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.videoplay.a.9
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    if (obj != null) {
                        switch (a.this.cXP.getLoadDataMode()) {
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
        this.flT = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.flT != null) {
            this.flT.a(new a.InterfaceC0093a() { // from class: com.baidu.tieba.videoplay.a.10
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0093a
                public void a(boolean z, boolean z2, String str) {
                    if (z) {
                        if (a.this.flT != null) {
                            a.this.flT.aL(z2);
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
        this.bft = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.mAttentionListener);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bEy();
        this.hyY.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.videoplay.a.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                gVar.setLooping(true);
            }
        });
        if (Build.VERSION.SDK_INT >= 17) {
            this.hyY.setOnOutInfoListener(new g.e() { // from class: com.baidu.tieba.videoplay.a.13
                @Override // com.baidu.tieba.play.g.e
                public boolean a(g gVar, int i, int i2) {
                    if (a.this.mIsVisible && i == 3 && a.this.hyZ.getVisibility() == 0) {
                        a.this.hyZ.clearAnimation();
                        a.this.hyZ.startAnimation(a.this.hzq);
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
        if (ay.ba(getActivity()) && this.hzo != null) {
            if ("1".equals(this.hzo.is_agreed)) {
                i = 1;
                this.hzo.agree_num = String.valueOf(com.baidu.adp.lib.g.b.h(this.hzo.agree_num, 0) - 1);
                this.hzo.is_agreed = "0";
            } else {
                this.hzo.agree_num = String.valueOf(com.baidu.adp.lib.g.b.h(this.hzo.agree_num, 0) + 1);
                this.hzo.is_agreed = "1";
                i = 0;
            }
            ak akVar = new ak("c12795");
            akVar.ab("tid", this.hzo.thread_id);
            akVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
            akVar.s("obj_type", i);
            TiebaStatic.log(akVar);
            bEy();
            if (this.hzr != null && i == 0) {
                this.hzr.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.hzo.thread_id);
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.hzo));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRootView.setSystemUiVisibility(4);
        if (this.hzo != null && !StringUtils.isNull(this.hzo.video_url)) {
            uf(this.hzo.video_url);
            this.bEy = true;
            if (this.mIsVisible) {
                aQE();
                if (this.hzo != null && this.lQ != null) {
                    ak akVar = new ak("c12794");
                    akVar.ab("tid", this.hzo.thread_id);
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
        if (this.bEy) {
            if (this.mIsVisible) {
                if (this.hzo != null && this.lQ == null) {
                    ak akVar = new ak("c12794");
                    akVar.ab("tid", this.hzo.thread_id);
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
        if (this.hyY != null) {
            this.hyY.setRecoveryState(0);
            this.hyY.bN(str, this.hzo.thread_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bEB()) {
            if (this.hzk != null) {
                this.hzk.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.hyZ.getVisibility() == 0) {
                this.hyZ.clearAnimation();
                this.hyZ.startAnimation(this.hzq);
            }
            if (this.hyY != null) {
                this.hyY.seekTo(0);
                this.hyY.start();
                if (this.hzo != null) {
                    aa aaVar = new aa();
                    aaVar.mLocate = "nani_midpage";
                    aaVar.bCV = this.hzo.thread_id;
                    aaVar.cZL = this.hzo.forum_id + "";
                    aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    aaVar.mSource = this.hzo.mRecomSource;
                    aaVar.gwb = this.hzo.mRecomAbTag;
                    aaVar.gwc = this.hzo.mRecomWeight;
                    aaVar.gwd = "";
                    aaVar.aMr = "";
                    aaVar.gwf = this.hzo.mMd5;
                    if (this.lQ != null) {
                        aaVar.gwg = "1";
                    } else {
                        aaVar.gwg = "2";
                    }
                    com.baidu.tieba.play.l.a(this.hzo.mMd5, "", "1", aaVar);
                }
            }
        }
    }

    private void pausePlay() {
        if (this.hyY != null) {
            this.hyY.pause();
        }
    }

    private void stopPlay() {
        this.hyY.setRecoveryState(5);
        this.hyY.stopPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEw() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.hzo.thread_id, this.hzo.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.hzo.forum_id));
        createNormalCfg.setForumName(this.hzo.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEx() {
        if (this.cXG == null) {
            this.cXH = new com.baidu.tieba.view.c(getActivity());
            ArrayList arrayList = new ArrayList();
            c.a aVar = new c.a(this.cXH);
            aVar.a(new c.InterfaceC0251c() { // from class: com.baidu.tieba.videoplay.a.14
                @Override // com.baidu.tieba.view.c.InterfaceC0251c
                public void onClick() {
                    a.this.cXG.dismiss();
                    if (a.this.hzo != null) {
                        boolean z = a.this.hzo.post_id != null && a.this.hzo.post_id.equals(a.this.hzo.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(a.this.hzo.thread_id);
                        markData.setPostId(a.this.hzo.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(a.this.hzo.thread_id);
                        markData.setForumId(a.this.hzo.forum_id);
                        if (a.this.flT != null) {
                            a.this.flT.a(markData);
                            if (!z) {
                                a.this.flT.vZ();
                            } else {
                                a.this.flT.vY();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.hzo != null && this.hzo.post_id != null && this.hzo.post_id.equals(this.hzo.mark_id)) {
                z = true;
            }
            if (z) {
                aVar.setText(getResources().getString(d.j.remove_mark));
            } else {
                aVar.setText(getResources().getString(d.j.mark));
            }
            arrayList.add(aVar);
            c.a aVar2 = new c.a(getActivity().getString(d.j.delete), this.cXH);
            aVar2.a(new c.InterfaceC0251c() { // from class: com.baidu.tieba.videoplay.a.15
                @Override // com.baidu.tieba.view.c.InterfaceC0251c
                public void onClick() {
                    a.this.cXG.dismiss();
                    if (ay.ba(a.this.getActivity()) && a.this.hzo != null) {
                        String str = a.this.hzo.thread_id;
                        String str2 = a.this.hzo.forum_id;
                        a.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(a.this.getPageContext().getPageActivity(), a.this.getResources().getString(d.j.web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + a.this.hzo.post_id, true)));
                    }
                }
            });
            aVar2.setText(getResources().getString(d.j.report_text));
            arrayList.add(aVar2);
            if (this.ecO) {
                c.a aVar3 = new c.a(getActivity().getString(d.j.delete), this.cXH);
                aVar3.a(new c.InterfaceC0251c() { // from class: com.baidu.tieba.videoplay.a.16
                    @Override // com.baidu.tieba.view.c.InterfaceC0251c
                    public void onClick() {
                        a.this.cXG.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar4 = new com.baidu.tbadk.core.dialog.a(a.this.getActivity());
                        aVar4.fb(d.j.del_thread_confirm);
                        aVar4.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.a.16.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar5) {
                                aVar4.dismiss();
                                if (a.this.hzo != null) {
                                    a.this.cXP.a(a.this.hzo.forum_id, a.this.hzo.forum_name, a.this.hzo.thread_id, a.this.hzo.post_id, 0, 0, a.this.ecO);
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
                        aVar4.AV();
                    }
                });
                aVar3.setText(getResources().getString(d.j.delete));
                arrayList.add(aVar3);
            }
            this.cXH.dO(arrayList);
            this.cXG = new e(getActivity(), this.cXH.bEP());
        }
        this.cXG.show();
    }

    private void bEy() {
        if (this.hzo != null) {
            this.hyZ.startLoad(this.hzo.thumbnail_url, 10, false);
            this.hzf.setText(this.hzo.title);
            this.hzh.setText(am.J(com.baidu.adp.lib.g.b.c(this.hzo.comment_num, 0L)));
            this.hzi.setText(am.J(com.baidu.adp.lib.g.b.c(this.hzo.agree_num, 0L)));
            this.hzj.setText(am.J(com.baidu.adp.lib.g.b.c(this.hzo.share_num, 0L)));
            if (this.hzo.author_info != null) {
                this.hza.startLoad(this.hzo.author_info.portrait, 12, false);
                if (StringUtils.isNull(this.hzo.author_info.bAR())) {
                    this.hzs.setVisibility(8);
                } else {
                    this.hzs.setVisibility(0);
                    this.hzs.setText("@" + this.hzo.author_info.bAR());
                }
            }
            if ("1".equals(this.hzo.is_private) && this.hzp.getVisibility() != 0) {
                this.hzn.setVisibility(0);
            } else {
                this.hzn.setVisibility(8);
            }
            if ("1".equals(this.hzo.is_agreed)) {
                aj.c(this.hzr, d.f.icon_home_card_like_s);
            } else {
                aj.c(this.hzr, d.f.btn_video_agree);
            }
            if (this.hzo.act_info != null && !StringUtils.isNull(this.hzo.act_info.activity_name) && this.hzp.getVisibility() != 0) {
                this.hzm.setVisibility(0);
                this.hzg.setText(this.hzo.act_info.activity_name);
            } else {
                this.hzm.setVisibility(8);
            }
            bEz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEz() {
        if (this.ecO || (this.hzo.author_info != null && !"0".equals(this.hzo.author_info.is_follow))) {
            this.hze.setVisibility(4);
            this.hze.setClickable(false);
            return;
        }
        this.hze.setVisibility(0);
        this.hze.setClickable(true);
    }

    private void bEA() {
        if (this.hzx == null || !this.hzx.isShowing()) {
            this.hzx = new com.baidu.tbadk.core.dialog.a(getActivity());
            this.hzx.fa(d.j.net_change_title);
            this.hzx.fb(d.j.net_change_tip);
            this.hzx.a(d.j.video_continue, new a.b() { // from class: com.baidu.tieba.videoplay.a.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                    a.this.startPlay();
                }
            });
            this.hzx.b(d.j.pause, new a.b() { // from class: com.baidu.tieba.videoplay.a.18
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hzx.aZ(true);
            this.hzx.b(getPageContext());
            this.hzx.AV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEB() {
        if (!j.oJ() || j.oK()) {
            return true;
        }
        if (this.mIsVisible) {
            if (this.hzk != null) {
                this.hzk.setVisibility(0);
            }
            pausePlay();
            bEA();
            return false;
        }
        return false;
    }

    private void aQE() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || bEB()) && this.hyY != null && this.hzk != null) {
            this.hyY.start();
            this.hzk.setVisibility(8);
        }
    }

    protected Animation getScaleAnimation() {
        if (this.bdK == null) {
            this.bdK = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bdK.setDuration(200L);
        }
        return this.bdK;
    }

    public long bEC() {
        if (this.hzl != null) {
            this.hzl.setVisibility(8);
        }
        if (this.hzp != null) {
            this.hzp.setVisibility(0);
            return System.currentTimeMillis();
        }
        return -1L;
    }
}
