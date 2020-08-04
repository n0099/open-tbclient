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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.pageInfo.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.person.e;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.o;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.editor.a;
import com.baidu.tieba.view.a;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
/* loaded from: classes18.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0520a {
    public ImageView awy;
    private e dJI;
    private String dOV;
    private boolean due;
    private boolean fVs;
    public TbCyberVideoView fsr;
    private AlphaAnimation fvo;
    private int hHO;
    private View hgK;
    private f.b lbP;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private TbImageView mmU;
    public ImageView mmV;
    public HeadImageView mmW;
    public LinearLayout mmX;
    public LinearLayout mmY;
    public LinearLayout mmZ;
    private com.baidu.tieba.videoplay.editor.a mnA;
    private a mnB;
    com.baidu.tbadk.core.dialog.a mnC;
    public ImageView mna;
    public ImageView mnb;
    public ImageView mnc;
    public ExpandableTextView mnd;
    public TextView mne;
    public TextView mnf;
    public TextView mng;
    public TextView mnh;
    public ImageView mni;
    private LinearLayout mnj;
    public LinearLayout mnk;
    public LinearLayout mnl;
    public VideoItemData mnm;
    private TextView mnn;
    public ImageView mno;
    public TextView mnp;
    private View mnq;
    private TextView mnr;
    private int mns;
    private int mnt;
    private com.baidu.tieba.view.a mnu;
    protected Animation mnv;
    private boolean mnw;
    private AnimatorSet mnx;
    private RelativeLayout.LayoutParams mny;
    private int mmS = 0;
    private int mmT = 1;
    private ForumManageModel gXC = null;
    private com.baidu.tbadk.baseEditMark.a kof = null;
    private com.baidu.tbadk.coreExtra.model.a eaU = null;
    private BdUniqueId agB = BdUniqueId.gen();
    private boolean mnz = false;
    private int playTime = 1;
    private CustomMessageListener eaY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.mnm != null && VideoPlayFragment.this.mnm.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.mnm.author_info.user_id) && data != null && VideoPlayFragment.this.mnm.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.agB)) ? false : false;
                    if (data.erH == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.mnm.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.mnm.author_info.is_follow = "0";
                                VideoPlayFragment.this.dtd();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.due) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.mnm));
                                } else {
                                    VideoPlayFragment.this.mnm.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dtd();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.mnm.author_info.is_follow = "0";
                            VideoPlayFragment.this.dtd();
                        }
                        ap apVar = new ap("c13570");
                        apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                        if ("index".equals(VideoPlayFragment.this.mFromPage)) {
                            apVar.dn("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                            apVar.dn("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                        TiebaStatic.log(apVar);
                    }
                }
            }
        }
    };
    private final CustomMessageListener dLm = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.dtf();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.mnm != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.mnm.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.mnm.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.mnm.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.mnm.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dtc();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.mnm.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.mnm.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.mnm.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dtc();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnInfoListener ldx = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.due) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.mmU.getVisibility() == 0) {
                    VideoPlayFragment.this.mmU.clearAnimation();
                    VideoPlayFragment.this.mmU.startAnimation(VideoPlayFragment.this.fvo);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener ldv = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.fsr != null) {
                VideoPlayFragment.this.fsr.cZm();
                VideoPlayFragment.this.fsr.seekTo(0);
                VideoPlayFragment.this.fsr.start();
                VideoPlayFragment.this.bRt();
                VideoPlayFragment.A(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dsW();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener mnD = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.fsr != null) {
                VideoPlayFragment.this.fsr.setVolume(1.0f, 1.0f);
            }
        }
    };

    /* loaded from: classes18.dex */
    public interface a {
        void onStart();
    }

    static /* synthetic */ int A(VideoPlayFragment videoPlayFragment) {
        int i = videoPlayFragment.playTime;
        videoPlayFragment.playTime = i + 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mThreadAgreeChangedListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.mnm = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.mnt = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.dOV = arguments.getString("obj_id");
        if (this.mnm != null && this.mnm.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.mnm.author_info.user_id)) {
            this.fVs = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.fsr = new TbCyberVideoView(getContext());
        this.fsr.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.f.b
            public void bP(int i, int i2) {
                if (VideoPlayFragment.this.lbP != null) {
                    VideoPlayFragment.this.lbP.bP(i, i2);
                }
            }
        });
        dtk();
        this.mmU = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.mmU.setPlaceHolder(4);
        this.mmU.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.aZZ()) {
            this.hgK = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.hgK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.hgK.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.awy = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.mmV = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.mmW = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.mmW.setDefaultResource(17170445);
        this.mmW.setPlaceHolder(2);
        this.mmW.setIsRound(true);
        this.mna = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.mno = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.mnd = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.mne = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.mmY = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.mnf = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.mmX = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.mng = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.mnh = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.mnb = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.mnc = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dsX();
        this.mni = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.mnj = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.mnk = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.mnl = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.mmZ = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.mnp = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.mnq = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.mnq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.mnq.setVisibility(4);
                    if (VideoPlayFragment.this.mnA != null && VideoPlayFragment.this.mnA.biJ() != null) {
                        VideoPlayFragment.this.mnA.biJ().display();
                        if (VideoPlayFragment.this.mnm != null) {
                            VideoPlayFragment.this.mnA.c(VideoPlayFragment.this.mnm);
                        }
                    }
                    if (VideoPlayFragment.this.mnm != null) {
                        ap apVar = new ap("c13025");
                        apVar.dn("tid", VideoPlayFragment.this.mnm.thread_id);
                        apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                        apVar.dn("fid", VideoPlayFragment.this.mnm.forum_id);
                        TiebaStatic.log(apVar);
                    }
                }
            }
        });
        this.mnr = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.mnn = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.mnn.setVisibility(8);
        String string = b.aZP().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.mnn.setText(string);
        }
        final String string2 = b.aZP().getString("nani_key_download_link_url", null);
        this.mnn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    bd.baV().a((TbPageContext) i.G(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dtb();
        this.mmW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mnm != null && VideoPlayFragment.this.mnm.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.mnm.author_info.user_id) && VideoPlayFragment.this.mnm != null && VideoPlayFragment.this.mnm.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.mnm.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    ap apVar = new ap("c12798");
                    apVar.dn("tid", VideoPlayFragment.this.mnm.thread_id);
                    apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(apVar);
                }
            }
        });
        this.mnk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mnm != null && VideoPlayFragment.this.mnm.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.mnm.act_info.link_url);
                    ap apVar = new ap("c12799");
                    apVar.dn("tid", VideoPlayFragment.this.mnm.thread_id);
                    apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(apVar);
                }
            }
        });
        this.mnd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dsZ();
            }
        });
        this.awy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mnm != null && !StringUtils.isNull(VideoPlayFragment.this.mnm.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.mnm.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.mmV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dta();
            }
        });
        this.mmY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.mnm)) {
                    VideoPlayFragment.this.dsZ();
                    ap apVar = new ap("c12796");
                    apVar.dn("tid", VideoPlayFragment.this.mnm.thread_id);
                    apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(apVar);
                }
            }
        });
        this.mmX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.GM(VideoPlayFragment.this.mmS);
            }
        });
        this.mmZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bcy();
                ap apVar = new ap("c12797");
                apVar.dn("tid", VideoPlayFragment.this.mnm.thread_id);
                apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(apVar);
                ap apVar2 = new ap(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                apVar2.dn("tid", VideoPlayFragment.this.mnm.thread_id);
                apVar2.dn("uid", TbadkCoreApplication.getCurrentAccount());
                apVar2.ah("obj_locate", 19);
                apVar2.dn("nid", VideoPlayFragment.this.mnm.nid);
                if (VideoPlayFragment.this.mnm.baijiahaoData != null && !as.isEmpty(VideoPlayFragment.this.mnm.baijiahaoData.oriUgcVid)) {
                    apVar2.dn("obj_param6", VideoPlayFragment.this.mnm.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.mnm.getVideoType() == 1) {
                    apVar2.ah(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.mnm.getVideoType() == 2) {
                    apVar2.ah(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.mnm.getVideoType() == 3) {
                    apVar2.ah(IntentConfig.CARD_TYPE, 6);
                }
                apVar2.dn(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.mnm.mRecomSource);
                apVar2.dn("ab_tag", VideoPlayFragment.this.mnm.mRecomAbTag);
                apVar2.dn("weight", VideoPlayFragment.this.mnm.mRecomWeight);
                apVar2.dn("extra", VideoPlayFragment.this.mnm.mRecomExtra);
                apVar2.dn("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.ea(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.ea(VideoPlayFragment.this.getBaseFragmentActivity()).blj() != null && c.ea(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.ea(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    apVar2.dn("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    apVar2.dn("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(apVar2);
            }
        });
        this.mna.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bf.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.mnm != null && VideoPlayFragment.this.mnm.author_info != null) {
                    VideoPlayFragment.this.eaU.a(true, VideoPlayFragment.this.mnm.author_info.portrait, VideoPlayFragment.this.mnm.author_info.user_id, false, "6", VideoPlayFragment.this.agB, VideoPlayFragment.this.mnm.forum_id, "0");
                    VideoPlayFragment.this.mnm.author_info.is_follow = "1";
                    VideoPlayFragment.this.dtd();
                }
            }
        });
        this.fvo = new AlphaAnimation(1.0f, 0.0f);
        this.fvo.setDuration(100L);
        this.fvo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.mmU != null) {
                    VideoPlayFragment.this.mmU.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mns = this.mRect.right - this.mRect.left;
            this.hHO = this.mRect.bottom - this.mRect.top;
            this.mmU.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.mmU.getWidth();
                    int height = VideoPlayFragment.this.mmU.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mnm.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mnm.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mnm.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mnm.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mns, VideoPlayFragment.this.hHO);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.mmU.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hHO > 0 || VideoPlayFragment.this.mns <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mns;
                                f = i / VideoPlayFragment.this.hHO;
                            }
                            VideoPlayFragment.this.mmU.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.mmU.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.due) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mns, VideoPlayFragment.this.hHO);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.mmU.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hHO > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.mmU.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.mmU.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.due) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.mmU.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.mmU.getWidth();
                    int height = VideoPlayFragment.this.mmU.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mnm.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mnm.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mnm.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mnm.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.mmU.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.mmU.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cFt();
        if (this.due) {
            dsY();
        }
        if (this.mnm != null && !StringUtils.isNull(this.mnm.video_url)) {
            setVideoInfo(this.mnm.video_url);
        }
        return this.mRootView;
    }

    public void a(f.b bVar) {
        this.lbP = bVar;
    }

    public void a(a aVar) {
        this.mnB = aVar;
    }

    private void cFt() {
        this.mnA = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dT(getActivity());
        if (this.mnA != null && this.mnm != null) {
            this.mnA.a(getPageContext());
            this.mnA.az(this.mnm.thread_id, this.mnm.forum_id, this.mnm.forum_name);
            this.mnA.a(new a.InterfaceC0771a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0771a
                public void wb(boolean z) {
                    VideoPlayFragment.this.mnq.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.mnr.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.mnr.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.mnA.biJ().nT(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.mnm != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.mnm.comment_num, 0L) + 1;
                        VideoPlayFragment.this.mnm.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.mnf.setText(as.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.mnA.biJ(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        String str;
        String str2;
        if (this.mnm != null) {
            String str3 = this.mnm.forum_id;
            String str4 = this.mnm.forum_name;
            String str5 = this.mnm.title;
            if (this.mnm.baijiahaoData != null) {
                str = this.mnm.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.mnm.baijiahaoData.oriUgcType + "&dvid=" + this.mnm.baijiahaoData.oriUgcVid + "&nid=" + this.mnm.baijiahaoData.oriUgcNid;
            } else {
                str = this.mnm.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.mnm.thumbnail_url;
            String format = (!this.mnm.isBjhVideo || this.mnm.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.mnm.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.mnm.baijiahaoData == null) {
                shareItem.readCount = this.mnm.play_count;
            }
            if (this.mnm.isBjhVideo) {
                shareItem.etQ = format;
            } else {
                shareItem.etQ = "";
            }
            shareItem.linkUrl = str6;
            shareItem.dVb = 2;
            shareItem.extData = str;
            shareItem.etT = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.etH = true;
            shareItem.etS = 12;
            shareItem.etX = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.mnm.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.mnm.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.mnm.title;
            originalThreadInfo.threadId = this.mnm.thread_id;
            originalThreadInfo.oriUgcInfo = this.mnm.baijiahaoData;
            shareItem.eua = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.etT);
            bundle.putInt("obj_type", shareItem.etX);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dVb);
            shareItem.af(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.f.bSP().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fVs) {
            this.gXC = new ForumManageModel(getPageContext());
            this.gXC.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.gXC.getLoadDataMode()) {
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
        this.kof = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.kof != null) {
            this.kof.a(new a.InterfaceC0489a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0489a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.kof != null) {
                            VideoPlayFragment.this.kof.he(z2);
                        }
                        if (VideoPlayFragment.this.mnm != null) {
                            if (z2) {
                                VideoPlayFragment.this.mnm.mark_id = VideoPlayFragment.this.mnm.post_id;
                            } else {
                                VideoPlayFragment.this.mnm.mark_id = null;
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
        this.eaU = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.eaY);
        registerListener(this.dLm);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.mnz = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dtb();
        dtl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsW() {
        if (this.mnc != null && this.mnb != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.mnb.clearAnimation();
            this.mnc.clearAnimation();
            this.mnb.setVisibility(8);
            this.mnc.setVisibility(0);
            this.mnc.startAnimation(scaleAnimation2);
            this.mnb.startAnimation(scaleAnimation);
        }
    }

    private void dsX() {
        if (this.mnc != null && this.mnb != null) {
            this.mnb.clearAnimation();
            this.mnc.clearAnimation();
            this.mnb.setVisibility(0);
            this.mnc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GM(int i) {
        int i2;
        if (bf.checkUpIsLogin(getActivity()) && this.mnm != null) {
            if (i == this.mmS) {
                if ("1".equals(this.mnm.is_agreed)) {
                    i2 = 1;
                    this.mnm.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mnm.agree_num, 0) - 1);
                    this.mnm.is_agreed = "0";
                } else {
                    this.mnm.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mnm.agree_num, 0) + 1);
                    this.mnm.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.mnm.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mnm.agree_num, 0) + 1);
                this.mnm.is_agreed = "1";
                i2 = 0;
            }
            ap apVar = new ap("c12795");
            apVar.dn("tid", this.mnm.thread_id);
            apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.mmS) {
                apVar.ah("obj_type", i2);
            } else {
                apVar.ah("obj_type", 2);
            }
            TiebaStatic.log(apVar);
            ap apVar2 = new ap("c12003");
            apVar2.dn("tid", this.mnm.thread_id);
            apVar2.t("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.mmS) {
                apVar2.ah("obj_type", i2);
            } else {
                apVar2.ah("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                apVar2.dn("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                apVar2.dn("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            TiebaStatic.log(apVar2);
            dtb();
            if (this.mno != null && i2 == 0) {
                this.mno.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.mnm.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.mnm.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.mnm.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.mnm.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.mnm.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.mnm.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.mnm.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.mnm.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.mnm));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.mnm != null && !StringUtils.isNull(this.mnm.video_url)) {
            this.mHasInit = true;
            if (this.due) {
                bRt();
                azO();
                if (this.mnm != null && this.mRect != null) {
                    ap apVar = new ap("c12794");
                    apVar.dn("tid", this.mnm.thread_id);
                    apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    apVar.ah("obj_type", 0);
                    TiebaStatic.log(apVar);
                    return;
                }
                return;
            }
            azN();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        azN();
        if (this.mnA != null && this.mnA.biJ() != null) {
            this.mnA.biJ().hide();
            this.mnq.setVisibility(0);
            this.mnr.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.mnA.biJ().nT(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        if (this.mnA != null) {
            this.mnA.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.due = z;
        if (!z && this.mnA != null) {
            this.mnr.setText(R.string.reply_something);
            this.mnA.cfx();
        }
        if (this.mHasInit) {
            if (this.due && (!this.mnz || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.mnm != null && this.mRect == null) {
                    ap apVar = new ap("c12794");
                    apVar.dn("tid", this.mnm.thread_id);
                    apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    apVar.ah("obj_type", 1);
                    TiebaStatic.log(apVar);
                }
                startPlay();
                dsY();
                this.mnz = false;
                return;
            }
            dsX();
            this.playTime = 1;
            azN();
        }
    }

    private void dsY() {
        if (this.mnm != null) {
            ap apVar = new ap("c12590");
            apVar.dn("tid", this.mnm.thread_id);
            apVar.dn("nid", this.mnm.nid);
            apVar.dn("fid", this.mnm.forum_id);
            apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            apVar.ah("obj_locate", this.mnt);
            apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, 1);
            apVar.dn("obj_param1", as.isEmpty(this.mnm.mRecomWeight) ? "0" : this.mnm.mRecomWeight);
            apVar.dn("extra", as.isEmpty(this.mnm.mRecomExtra) ? "0" : this.mnm.mRecomExtra);
            apVar.dn("obj_id", this.dOV);
            apVar.dn("ab_tag", as.isEmpty(this.mnm.mRecomAbTag) ? "0" : this.mnm.mRecomAbTag);
            apVar.dn("obj_source", as.isEmpty(this.mnm.mRecomSource) ? "0" : this.mnm.mRecomSource);
            apVar.dn("obj_type", this.mFromPage);
            apVar.ah("is_vertical", 1);
            if (this.mnm.baijiahaoData != null) {
                apVar.dn("obj_param4", this.mnm.baijiahaoData.oriUgcNid);
                apVar.dn("obj_param6", this.mnm.baijiahaoData.oriUgcVid);
                if (this.mnm.baijiahaoData.oriUgcType == 4) {
                    apVar.ah("obj_param5", 2);
                } else if (this.mnm.baijiahaoData.oriUgcType == 2) {
                    apVar.ah("obj_param5", 3);
                }
            } else {
                apVar.ah("obj_param5", 1);
            }
            TiebaStatic.log(apVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.fsr != null && str != null && !str.equals(this.mVideoUrl)) {
            this.fsr.setVideoPath(str, this.mnm.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dtf()) {
            cYA();
            if (this.mni != null) {
                this.mni.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.mmU.getVisibility() == 0) {
                this.mmU.clearAnimation();
                this.mmU.startAnimation(this.fvo);
            }
            if (this.fsr != null) {
                if (TbVideoViewSet.cZn().LN(this.mVideoUrl) == null || TbVideoViewSet.cZn().LN(this.mVideoUrl) != this.fsr) {
                    this.fsr.setVideoPath(this.mVideoUrl, this.mnm.thread_id);
                }
                this.fsr.start();
                bRt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRt() {
        if (this.mnm != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.ajJ = this.mnm.thread_id;
            oVar.mNid = this.mnm.nid;
            oVar.eKO = this.mnm.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.mnm.mRecomSource;
            oVar.lcJ = this.mnm.mRecomAbTag;
            oVar.lcK = this.mnm.mRecomWeight;
            oVar.lcL = "";
            oVar.dOV = "";
            oVar.lcO = this.mnm.mMd5;
            if (this.mRect != null) {
                oVar.lcP = "1";
            } else {
                oVar.lcP = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.lcQ = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.lcL = "index";
            }
            h.a(this.mnm.mMd5, "", "1", oVar, this.fsr.getPcdnState());
        }
    }

    private void cYA() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dpA().fv(getContext());
        }
    }

    private void azN() {
        if (this.fsr != null) {
            this.fsr.pause();
        }
    }

    private void stopPlay() {
        if (this.fsr != null) {
            this.fsr.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsZ() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.mnm.thread_id, this.mnm.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.mnm.forum_id));
        createNormalCfg.setForumName(this.mnm.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.mnm.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dta() {
        if (this.dJI == null) {
            this.mnu = new com.baidu.tieba.view.a(getActivity());
            this.dJI = new e(getActivity(), this.mnu.aZb());
            this.dJI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.fsr.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.mnu != null) {
            ArrayList arrayList = new ArrayList();
            a.C0772a c0772a = new a.C0772a(this.mnu);
            c0772a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bf.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.dJI.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.dJI.dismiss();
                    if (VideoPlayFragment.this.mnm != null) {
                        boolean z = VideoPlayFragment.this.mnm.post_id != null && VideoPlayFragment.this.mnm.post_id.equals(VideoPlayFragment.this.mnm.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.mnm.thread_id);
                        markData.setPostId(VideoPlayFragment.this.mnm.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.mnm.thread_id);
                        markData.setForumId(VideoPlayFragment.this.mnm.forum_id);
                        if (VideoPlayFragment.this.kof != null) {
                            VideoPlayFragment.this.kof.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.kof.aSl();
                            } else {
                                VideoPlayFragment.this.kof.aSk();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.mnm != null && this.mnm.post_id != null && this.mnm.post_id.equals(this.mnm.mark_id)) {
                z = true;
            }
            if (z) {
                c0772a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0772a.setText(getResources().getString(R.string.mark));
            }
            if (this.mnm != null && !this.mnm.isBjhVideo) {
                arrayList.add(c0772a);
            }
            a.C0772a c0772a2 = new a.C0772a(getActivity().getString(R.string.delete), this.mnu);
            c0772a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.dJI.dismiss();
                    if (bf.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.mnm != null) {
                        String str = VideoPlayFragment.this.mnm.thread_id;
                        String str2 = VideoPlayFragment.this.mnm.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.mnm.post_id;
                        if (VideoPlayFragment.this.mnm.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.mnm.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.mnm.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0772a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0772a2);
            if (this.fVs) {
                a.C0772a c0772a3 = new a.C0772a(getActivity().getString(R.string.delete), this.mnu);
                c0772a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.dJI.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.ln(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.mnm != null) {
                                    VideoPlayFragment.this.gXC.a(VideoPlayFragment.this.mnm.forum_id, VideoPlayFragment.this.mnm.forum_name, VideoPlayFragment.this.mnm.thread_id, VideoPlayFragment.this.mnm.post_id, 0, 0, VideoPlayFragment.this.fVs, null);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                                }
                            }
                        });
                        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.hJ(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.aYL();
                    }
                });
                c0772a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0772a3);
            }
            this.mnu.aS(arrayList);
        }
        this.dJI.show();
    }

    private void dtb() {
        if (this.mnm != null) {
            this.mmU.startLoad(this.mnm.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.mnm.title);
            if (StringUtils.isNull(this.mnm.title) || matcher.matches()) {
                this.mnd.setVisibility(8);
            } else {
                this.mnd.setVisibility(0);
                this.mnd.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.mnd.setTextColor(R.color.cp_cont_a);
                this.mnd.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.mnd.setExpandable(true);
                this.mnd.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void oI(boolean z) {
                        VideoPlayFragment.this.mnm.isTitleExpanded = z;
                    }
                });
                this.mnd.setData(this.mnm.title, this.mnm.isTitleExpanded);
            }
            this.mnf.setText(as.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mnm.comment_num, 0L)));
            this.mng.setText(as.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mnm.agree_num, 0L)));
            this.mnh.setText(as.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mnm.share_num, 0L)));
            if (this.mnm.author_info != null) {
                if (!TextUtils.isEmpty(this.mnm.author_info.bjhAvatar)) {
                    this.mmW.startLoad(this.mnm.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.mnm.author_info.portrait) && this.mnm.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.mmW.startLoad(this.mnm.author_info.portrait, 10, false);
                } else {
                    this.mmW.startLoad(this.mnm.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.mnm.author_info.dpv())) {
                    this.mnp.setVisibility(8);
                } else {
                    this.mnp.setVisibility(0);
                    this.mnp.setText(UgcConstant.AT_RULE_TAG + this.mnm.author_info.dpv());
                }
            }
            if ("1".equals(this.mnm.is_private) && this.mnn.getVisibility() != 0) {
                this.mnl.setVisibility(0);
            } else {
                this.mnl.setVisibility(8);
            }
            if ("1".equals(this.mnm.is_agreed)) {
                ao.setImageResource(this.mno, R.drawable.icon_card_like_white_full_s);
            } else {
                ao.setImageResource(this.mno, R.drawable.btn_video_agree);
            }
            if (this.mnm.act_info != null && !StringUtils.isNull(this.mnm.act_info.activity_name) && this.mnn.getVisibility() != 0) {
                this.mnk.setVisibility(0);
                this.mne.setText(this.mnm.act_info.activity_name);
            } else {
                this.mnk.setVisibility(8);
            }
            dtd();
            if (this.mnm.isBjhVideo) {
                this.mmV.setVisibility(8);
            } else {
                this.mmV.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtc() {
        if (this.mnm != null) {
            if ("1".equals(this.mnm.is_agreed)) {
                ao.setImageResource(this.mno, R.drawable.icon_card_like_white_full_s);
            } else {
                ao.setImageResource(this.mno, R.drawable.btn_video_agree);
            }
            this.mng.setText(as.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mnm.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtd() {
        if (this.fVs || (this.mnm.author_info != null && !"0".equals(this.mnm.author_info.is_follow))) {
            this.mna.setVisibility(4);
            this.mna.setClickable(false);
            return;
        }
        this.mna.setVisibility(0);
        this.mna.setClickable(true);
    }

    private void dte() {
        if (getActivity() != null) {
            if (this.mnC == null || !this.mnC.isShowing()) {
                this.mnC = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.baR().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.mnC.aV(inflate);
                this.mnC.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.mnC.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.mnC.lq(1);
                this.mnC.lo(R.color.cp_cont_b);
                this.mnC.hJ(true);
                this.mnC.b(getPageContext());
                this.mnC.aYL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dtf() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dpA().dpB() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet() || !this.due) {
            return false;
        }
        if (this.mni != null) {
            this.mni.setVisibility(0);
        }
        azN();
        dte();
        return true;
    }

    private void azO() {
        if (!dtf() && this.fsr != null && this.mni != null && this.mnm != null) {
            if (this.fsr.getParent() == null) {
                dtk();
                dtl();
            }
            if (TbVideoViewSet.cZn().LN(this.mVideoUrl) == null || TbVideoViewSet.cZn().LN(this.mVideoUrl) != this.fsr) {
                this.fsr.setVideoPath(this.mVideoUrl, this.mnm.thread_id);
            }
            this.fsr.a((TbVideoViewSet.a) null);
            this.mni.setVisibility(8);
            cYA();
            if (this.mnB != null) {
                this.mnB.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.mnv == null) {
            this.mnv = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.mnv;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0520a
    public void bqf() {
        if (this.fsr.isPlaying()) {
            this.fsr.pause();
            this.mni.setVisibility(0);
        } else if (!dtf()) {
            this.fsr.start();
            this.mni.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0520a
    public void t(float f, float f2) {
        if (bf.checkUpIsLogin(getActivity()) && !this.mnw) {
            dtg();
            if (this.mnm != null && "0".equals(this.mnm.is_agreed)) {
                GM(this.mmT);
            }
        }
    }

    private void dtg() {
        if (this.mRootView != null) {
            this.mnw = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.mny == null) {
                this.mny = new RelativeLayout.LayoutParams(-2, -2);
                this.mny.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.mny);
            }
            if (this.mnx == null) {
                this.mnx = new AnimatorSet();
                this.mnx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.mnw = false;
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
            this.mnx.setTarget(imageView);
            this.mnx.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.mnx.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0520a
    public void bqg() {
        if (this.mnm != null && this.mnm.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.mnm.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dth() {
        return null;
    }

    public String dti() {
        return null;
    }

    public boolean dtj() {
        if (this.mnA == null || this.mnA.biJ() == null || !this.mnA.biJ().isVisible()) {
            return false;
        }
        this.mnA.biJ().hide();
        this.mnq.setVisibility(0);
        if ((this.mnA.biJ().nT(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.mnA.biJ().nT(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.mnA.biJ().nT(28)).getInputView().getText() != null) {
            this.mnr.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.mnA.biJ().nT(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.mnA != null) {
            this.mnA.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        c(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mnA != null && this.mnA.biJ() != null) {
            this.mnA.biJ().onChangeSkinType(i);
        }
        SvgManager.baR().a(this.awy, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    public void dtk() {
        if (this.fsr != null && this.fsr.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.fsr.getView(), 0);
            this.fsr.getView().setLayoutParams(layoutParams);
            if (this.mnm != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.ajJ = this.mnm.thread_id;
                oVar.mNid = this.mnm.nid;
                oVar.eKO = this.mnm.forum_id;
                oVar.lcO = this.mnm.mMd5;
                oVar.dOV = "";
                oVar.mSource = this.mnm.mRecomSource;
                oVar.lcN = this.mnm.mRecomAbTag;
                oVar.lcM = 1;
                if (this.mnm.baijiahaoData != null) {
                    if (this.mnm.baijiahaoData.oriUgcType == 2) {
                        oVar.lcM = 3;
                    } else if (this.mnm.baijiahaoData.oriUgcType == 4) {
                        oVar.lcM = 2;
                    }
                }
                oVar.lcK = this.mnm.mRecomWeight;
                if (this.mRect != null) {
                    oVar.lcP = "1";
                } else {
                    oVar.lcP = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.lcQ = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.lcL = this.mFromPage;
                    oVar.dOV = this.dOV;
                    oVar.lcJ = this.mnm.mRecomWeight;
                } else {
                    oVar.mLocate = "14";
                }
                this.fsr.setVideoStatData(oVar);
                this.fsr.setLocateSource("v_mid_page");
            }
            this.fsr.setContinuePlayEnable(true);
        }
    }

    private void dtl() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.fsr.setOnPreparedListener(this.mnD);
        }
        this.fsr.setOnCompletionListener(this.ldv);
        this.fsr.setOnInfoListener(this.ldx);
    }
}
