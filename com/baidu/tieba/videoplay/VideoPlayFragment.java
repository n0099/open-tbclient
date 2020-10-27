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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
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
/* loaded from: classes24.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0593a {
    public ImageView aFv;
    private boolean eaF;
    private e epE;
    private String eve;
    private boolean gKL;
    public TbCyberVideoView gdn;
    private AlphaAnimation ggs;
    private int iDH;
    private View icg;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private f.b mcV;
    private TbImageView nqS;
    public ImageView nqT;
    public HeadImageView nqU;
    public LinearLayout nqV;
    public LinearLayout nqW;
    public LinearLayout nqX;
    public ImageView nqY;
    public ImageView nqZ;
    com.baidu.tbadk.core.dialog.a nrA;
    public ImageView nra;
    public ExpandableTextView nrb;
    public TextView nrc;
    public TextView nrd;
    public TextView nre;
    public TextView nrf;
    public ImageView nrg;
    private LinearLayout nrh;
    public LinearLayout nri;
    public LinearLayout nrj;
    public VideoItemData nrk;
    private TextView nrl;
    public ImageView nrm;
    public TextView nrn;
    private View nro;
    private TextView nrp;
    private int nrq;
    private int nrr;
    private com.baidu.tieba.view.a nrs;
    protected Animation nrt;
    private boolean nru;
    private AnimatorSet nrv;
    private RelativeLayout.LayoutParams nrw;
    private com.baidu.tieba.videoplay.editor.a nry;
    private a nrz;
    private int nqQ = 0;
    private int nqR = 1;
    private ForumManageModel hST = null;
    private com.baidu.tbadk.baseEditMark.a lnO = null;
    private com.baidu.tbadk.coreExtra.model.a eHC = null;
    private BdUniqueId aiz = BdUniqueId.gen();
    private boolean nrx = false;
    private int playTime = 1;
    private CustomMessageListener eHG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.nrk != null && VideoPlayFragment.this.nrk.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nrk.author_info.user_id) && data != null && VideoPlayFragment.this.nrk.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aiz)) ? false : false;
                    if (data.eYM == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.nrk.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.nrk.author_info.is_follow = "0";
                                VideoPlayFragment.this.dPv();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.eaF) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.nrk));
                                } else {
                                    VideoPlayFragment.this.nrk.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dPv();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.nrk.author_info.is_follow = "0";
                            VideoPlayFragment.this.dPv();
                        }
                        aq aqVar = new aq("c13570");
                        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        if ("index".equals(VideoPlayFragment.this.mFromPage)) {
                            aqVar.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                            aqVar.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        }
    };
    private final CustomMessageListener eri = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.dPx();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.nrk != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.nrk.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.nrk.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.nrk.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.nrk.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dPu();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.nrk.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.nrk.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.nrk.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dPu();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnInfoListener meH = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.eaF) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.nqS.getVisibility() == 0) {
                    VideoPlayFragment.this.nqS.clearAnimation();
                    VideoPlayFragment.this.nqS.startAnimation(VideoPlayFragment.this.ggs);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener meF = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.gdn != null) {
                VideoPlayFragment.this.gdn.duS();
                VideoPlayFragment.this.gdn.seekTo(0);
                VideoPlayFragment.this.gdn.start();
                VideoPlayFragment.this.cly();
                VideoPlayFragment.A(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dPo();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener nrB = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.gdn != null) {
                VideoPlayFragment.this.gdn.setVolume(1.0f, 1.0f);
            }
        }
    };

    /* loaded from: classes24.dex */
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
        this.nrk = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.nrr = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.eve = arguments.getString("obj_id");
        if (this.nrk != null && this.nrk.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.nrk.author_info.user_id)) {
            this.gKL = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.gdn = new TbCyberVideoView(getContext());
        this.gdn.setStageType("2005");
        this.gdn.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.f.b
            public void cc(int i, int i2) {
                if (VideoPlayFragment.this.mcV != null) {
                    VideoPlayFragment.this.mcV.cc(i, i2);
                }
            }
        });
        dPC();
        this.nqS = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.nqS.setPlaceHolder(4);
        this.nqS.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.bnR()) {
            this.icg = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.icg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.icg.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aFv = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.nqT = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.nqU = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.nqU.setDefaultResource(17170445);
        this.nqU.setPlaceHolder(2);
        this.nqU.setIsRound(true);
        this.nqY = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.nrm = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.nrb = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.nrc = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.nqW = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.nrd = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.nqV = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.nre = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.nrf = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.nqZ = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nra = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dPp();
        this.nrg = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.nrh = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.nri = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.nrj = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.nqX = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.nrn = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.nro = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.nro.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.nro.setVisibility(4);
                    if (VideoPlayFragment.this.nry != null && VideoPlayFragment.this.nry.bwY() != null) {
                        VideoPlayFragment.this.nry.bwY().display();
                        if (VideoPlayFragment.this.nrk != null) {
                            VideoPlayFragment.this.nry.c(VideoPlayFragment.this.nrk);
                        }
                    }
                    if (VideoPlayFragment.this.nrk != null) {
                        aq aqVar = new aq("c13025");
                        aqVar.dR("tid", VideoPlayFragment.this.nrk.thread_id);
                        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar.dR("fid", VideoPlayFragment.this.nrk.forum_id);
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        });
        this.nrp = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.nrl = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.nrl.setVisibility(8);
        String string = b.bnH().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.nrl.setText(string);
        }
        final String string2 = b.bnH().getString("nani_key_download_link_url", null);
        this.nrl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    be.boR().a((TbPageContext) i.I(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dPt();
        this.nqU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nrk != null && VideoPlayFragment.this.nrk.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nrk.author_info.user_id) && VideoPlayFragment.this.nrk != null && VideoPlayFragment.this.nrk.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nrk.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    aq aqVar = new aq("c12798");
                    aqVar.dR("tid", VideoPlayFragment.this.nrk.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.nri.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nrk != null && VideoPlayFragment.this.nrk.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.nrk.act_info.link_url);
                    aq aqVar = new aq("c12799");
                    aqVar.dR("tid", VideoPlayFragment.this.nrk.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.nrb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dPr();
            }
        });
        this.aFv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nrk != null && !StringUtils.isNull(VideoPlayFragment.this.nrk.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.nrk.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.nqT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dPs();
            }
        });
        this.nqW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.nrk)) {
                    VideoPlayFragment.this.dPr();
                    aq aqVar = new aq("c12796");
                    aqVar.dR("tid", VideoPlayFragment.this.nrk.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.nqV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.KK(VideoPlayFragment.this.nqQ);
            }
        });
        this.nqX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bqt();
                aq aqVar = new aq("c12797");
                aqVar.dR("tid", VideoPlayFragment.this.nrk.thread_id);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar);
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dR("tid", VideoPlayFragment.this.nrk.thread_id);
                aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.aj("obj_locate", 19);
                aqVar2.dR("nid", VideoPlayFragment.this.nrk.nid);
                if (VideoPlayFragment.this.nrk.baijiahaoData != null && !at.isEmpty(VideoPlayFragment.this.nrk.baijiahaoData.oriUgcVid)) {
                    aqVar2.dR("obj_param6", VideoPlayFragment.this.nrk.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.nrk.getVideoType() == 1) {
                    aqVar2.aj(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.nrk.getVideoType() == 2) {
                    aqVar2.aj(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.nrk.getVideoType() == 3) {
                    aqVar2.aj(IntentConfig.CARD_TYPE, 6);
                }
                aqVar2.dR(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.nrk.mRecomSource);
                aqVar2.dR("ab_tag", VideoPlayFragment.this.nrk.mRecomAbTag);
                aqVar2.dR("weight", VideoPlayFragment.this.nrk.mRecomWeight);
                aqVar2.dR("extra", VideoPlayFragment.this.nrk.mRecomExtra);
                aqVar2.dR("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.es(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.es(VideoPlayFragment.this.getBaseFragmentActivity()).bzE() != null && c.es(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.es(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    aqVar2.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    aqVar2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(aqVar2);
            }
        });
        this.nqY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nrk != null && VideoPlayFragment.this.nrk.author_info != null) {
                    VideoPlayFragment.this.eHC.a(true, VideoPlayFragment.this.nrk.author_info.portrait, VideoPlayFragment.this.nrk.author_info.user_id, false, "6", VideoPlayFragment.this.aiz, VideoPlayFragment.this.nrk.forum_id, "0");
                    VideoPlayFragment.this.nrk.author_info.is_follow = "1";
                    VideoPlayFragment.this.dPv();
                }
            }
        });
        this.ggs = new AlphaAnimation(1.0f, 0.0f);
        this.ggs.setDuration(100L);
        this.ggs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.nqS != null) {
                    VideoPlayFragment.this.nqS.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.nrq = this.mRect.right - this.mRect.left;
            this.iDH = this.mRect.bottom - this.mRect.top;
            this.nqS.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.nqS.getWidth();
                    int height = VideoPlayFragment.this.nqS.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nrk.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nrk.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nrk.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nrk.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nrq, VideoPlayFragment.this.iDH);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.nqS.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.iDH > 0 || VideoPlayFragment.this.nrq <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.nrq;
                                f = i / VideoPlayFragment.this.iDH;
                            }
                            VideoPlayFragment.this.nqS.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.nqS.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.eaF) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nrq, VideoPlayFragment.this.iDH);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.nqS.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.iDH > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.nqS.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.nqS.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.eaF) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.nqS.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.nqS.getWidth();
                    int height = VideoPlayFragment.this.nqS.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nrk.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nrk.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nrk.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nrk.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.nqS.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.nqS.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cVa();
        if (this.eaF) {
            dPq();
        }
        if (this.nrk != null && !StringUtils.isNull(this.nrk.video_url)) {
            setVideoInfo(this.nrk.video_url);
        }
        return this.mRootView;
    }

    public void a(f.b bVar) {
        this.mcV = bVar;
    }

    public void a(a aVar) {
        this.nrz = aVar;
    }

    private void cVa() {
        this.nry = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().ei(getActivity());
        if (this.nry != null && this.nrk != null) {
            this.nry.a(getPageContext());
            this.nry.aI(this.nrk.thread_id, this.nrk.forum_id, this.nrk.forum_name);
            this.nry.a(new a.InterfaceC0853a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0853a
                public void xZ(boolean z) {
                    VideoPlayFragment.this.nro.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.nrp.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.nrp.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.nry.bwY().ra(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.nrk != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nrk.comment_num, 0L) + 1;
                        VideoPlayFragment.this.nrk.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.nrd.setText(at.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.nry.bwY(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqt() {
        String str;
        String str2;
        if (this.nrk != null) {
            String str3 = this.nrk.forum_id;
            String str4 = this.nrk.forum_name;
            String str5 = this.nrk.title;
            if (this.nrk.baijiahaoData != null) {
                str = this.nrk.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.nrk.baijiahaoData.oriUgcType + "&dvid=" + this.nrk.baijiahaoData.oriUgcVid + "&nid=" + this.nrk.baijiahaoData.oriUgcNid;
            } else {
                str = this.nrk.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str7 = this.nrk.thumbnail_url;
            String format = (!this.nrk.isBjhVideo || this.nrk.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.nrk.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.nrk.baijiahaoData == null) {
                shareItem.readCount = this.nrk.play_count;
            }
            if (this.nrk.isBjhVideo) {
                shareItem.fbd = format;
            } else {
                shareItem.fbd = "";
            }
            shareItem.linkUrl = str6;
            shareItem.eBz = 2;
            shareItem.extData = str;
            shareItem.fbg = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.faS = true;
            shareItem.fbf = 12;
            if (this.nrk.getVideoType() == 1) {
                shareItem.fbk = 2;
            } else if (this.nrk.getVideoType() == 2) {
                shareItem.fbk = 8;
            } else if (this.nrk.getVideoType() == 3) {
                shareItem.fbk = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.nrk.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.nrk.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.nrk.title;
            originalThreadInfo.threadId = this.nrk.thread_id;
            originalThreadInfo.oriUgcInfo = this.nrk.baijiahaoData;
            shareItem.fbn = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fbg);
            bundle.putInt("obj_type", shareItem.fbk);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eBz);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.f.cmU().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gKL) {
            this.hST = new ForumManageModel(getPageContext());
            this.hST.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.hST.getLoadDataMode()) {
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
        this.lnO = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.lnO != null) {
            this.lnO.a(new a.InterfaceC0561a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0561a
                public void d(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.lnO != null) {
                            VideoPlayFragment.this.lnO.ih(z2);
                        }
                        if (VideoPlayFragment.this.nrk != null) {
                            if (z2) {
                                VideoPlayFragment.this.nrk.mark_id = VideoPlayFragment.this.nrk.post_id;
                            } else {
                                VideoPlayFragment.this.nrk.mark_id = null;
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
        this.eHC = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.eHG);
        registerListener(this.eri);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.nrx = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dPt();
        dPD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPo() {
        if (this.nra != null && this.nqZ != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.nqZ.clearAnimation();
            this.nra.clearAnimation();
            this.nqZ.setVisibility(8);
            this.nra.setVisibility(0);
            this.nra.startAnimation(scaleAnimation2);
            this.nqZ.startAnimation(scaleAnimation);
        }
    }

    private void dPp() {
        if (this.nra != null && this.nqZ != null) {
            this.nqZ.clearAnimation();
            this.nra.clearAnimation();
            this.nqZ.setVisibility(0);
            this.nra.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KK(int i) {
        int i2;
        if (bg.checkUpIsLogin(getActivity()) && this.nrk != null) {
            if (i == this.nqQ) {
                if ("1".equals(this.nrk.is_agreed)) {
                    i2 = 1;
                    this.nrk.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nrk.agree_num, 0) - 1);
                    this.nrk.is_agreed = "0";
                } else {
                    this.nrk.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nrk.agree_num, 0) + 1);
                    this.nrk.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.nrk.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nrk.agree_num, 0) + 1);
                this.nrk.is_agreed = "1";
                i2 = 0;
            }
            aq aqVar = new aq("c12795");
            aqVar.dR("tid", this.nrk.thread_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nqQ) {
                aqVar.aj("obj_type", i2);
            } else {
                aqVar.aj("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12003");
            aqVar2.dR("tid", this.nrk.thread_id);
            aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nqQ) {
                aqVar2.aj("obj_type", i2);
            } else {
                aqVar2.aj("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                aqVar2.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                aqVar2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            TiebaStatic.log(aqVar2);
            dPt();
            if (this.nrm != null && i2 == 0) {
                this.nrm.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.nrk.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.nrk.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.nrk.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.nrk.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.nrk.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.nrk.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.nrk.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.nrk.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.nrk));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.nrk != null && !StringUtils.isNull(this.nrk.video_url)) {
            this.mHasInit = true;
            if (this.eaF) {
                cly();
                aNm();
                if (this.nrk != null && this.mRect != null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dR("tid", this.nrk.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.aj("obj_type", 0);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            aNl();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        aNl();
        if (this.nry != null && this.nry.bwY() != null) {
            this.nry.bwY().hide();
            this.nro.setVisibility(0);
            this.nrp.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nry.bwY().ra(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.nry != null) {
            this.nry.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.eaF = z;
        if (!z && this.nry != null) {
            this.nrp.setText(R.string.reply_something);
            this.nry.czU();
        }
        if (this.mHasInit) {
            if (this.eaF && (!this.nrx || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.nrk != null && this.mRect == null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dR("tid", this.nrk.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.aj("obj_type", 1);
                    TiebaStatic.log(aqVar);
                }
                startPlay();
                dPq();
                this.nrx = false;
                return;
            }
            dPp();
            this.playTime = 1;
            aNl();
        }
    }

    private void dPq() {
        if (this.nrk != null) {
            aq aqVar = new aq("c12590");
            aqVar.dR("tid", this.nrk.thread_id);
            aqVar.dR("nid", this.nrk.nid);
            aqVar.dR("fid", this.nrk.forum_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.aj("obj_locate", this.nrr);
            aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dR("obj_param1", at.isEmpty(this.nrk.mRecomWeight) ? "0" : this.nrk.mRecomWeight);
            aqVar.dR("extra", at.isEmpty(this.nrk.mRecomExtra) ? "0" : this.nrk.mRecomExtra);
            aqVar.dR("obj_id", this.eve);
            aqVar.dR("ab_tag", at.isEmpty(this.nrk.mRecomAbTag) ? "0" : this.nrk.mRecomAbTag);
            aqVar.dR("obj_source", at.isEmpty(this.nrk.mRecomSource) ? "0" : this.nrk.mRecomSource);
            aqVar.dR("obj_type", this.mFromPage);
            aqVar.aj("is_vertical", 1);
            if (this.nrk.baijiahaoData != null) {
                aqVar.dR("obj_param4", this.nrk.baijiahaoData.oriUgcNid);
                aqVar.dR("obj_param6", this.nrk.baijiahaoData.oriUgcVid);
                if (this.nrk.baijiahaoData.oriUgcType == 4) {
                    aqVar.aj("obj_param5", 2);
                } else if (this.nrk.baijiahaoData.oriUgcType == 2) {
                    aqVar.aj("obj_param5", 3);
                }
            } else {
                aqVar.aj("obj_param5", 1);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.gdn != null && str != null && !str.equals(this.mVideoUrl)) {
            this.gdn.setVideoPath(str, this.nrk.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dPx()) {
            due();
            if (this.nrg != null) {
                this.nrg.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.nqS.getVisibility() == 0) {
                this.nqS.clearAnimation();
                this.nqS.startAnimation(this.ggs);
            }
            if (this.gdn != null) {
                if (TbVideoViewSet.duT().Qv(this.mVideoUrl) == null || TbVideoViewSet.duT().Qv(this.mVideoUrl) != this.gdn) {
                    this.gdn.setVideoPath(this.mVideoUrl, this.nrk.thread_id);
                }
                this.gdn.start();
                cly();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cly() {
        if (this.nrk != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.alT = this.nrk.thread_id;
            oVar.mNid = this.nrk.nid;
            oVar.fsZ = this.nrk.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.nrk.mRecomSource;
            oVar.mdS = this.nrk.mRecomAbTag;
            oVar.mdT = this.nrk.mRecomWeight;
            oVar.mdU = "";
            oVar.eve = "";
            oVar.mdX = this.nrk.mMd5;
            if (this.mRect != null) {
                oVar.mdY = "1";
            } else {
                oVar.mdY = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.mdZ = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.mdU = "index";
            }
            h.a(this.nrk.mMd5, "", "1", oVar, this.gdn.getPcdnState());
        }
    }

    private void due() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dLS().fW(getContext());
        }
    }

    private void aNl() {
        if (this.gdn != null) {
            this.gdn.pause();
        }
    }

    private void stopPlay() {
        if (this.gdn != null) {
            this.gdn.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPr() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.nrk.thread_id, this.nrk.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.nrk.forum_id));
        createNormalCfg.setForumName(this.nrk.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.nrk.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPs() {
        if (this.epE == null) {
            this.nrs = new com.baidu.tieba.view.a(getActivity());
            this.epE = new e(getActivity(), this.nrs.bmS());
            this.epE.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.gdn.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.nrs != null) {
            ArrayList arrayList = new ArrayList();
            a.C0855a c0855a = new a.C0855a(this.nrs);
            c0855a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bg.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.epE.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.epE.dismiss();
                    if (VideoPlayFragment.this.nrk != null) {
                        boolean z = VideoPlayFragment.this.nrk.post_id != null && VideoPlayFragment.this.nrk.post_id.equals(VideoPlayFragment.this.nrk.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.nrk.thread_id);
                        markData.setPostId(VideoPlayFragment.this.nrk.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.nrk.thread_id);
                        markData.setForumId(VideoPlayFragment.this.nrk.forum_id);
                        if (VideoPlayFragment.this.lnO != null) {
                            VideoPlayFragment.this.lnO.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.lnO.bfX();
                            } else {
                                VideoPlayFragment.this.lnO.bfW();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.nrk != null && this.nrk.post_id != null && this.nrk.post_id.equals(this.nrk.mark_id)) {
                z = true;
            }
            if (z) {
                c0855a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0855a.setText(getResources().getString(R.string.mark));
            }
            if (this.nrk != null && !this.nrk.isBjhVideo) {
                arrayList.add(c0855a);
            }
            a.C0855a c0855a2 = new a.C0855a(getActivity().getString(R.string.delete), this.nrs);
            c0855a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.epE.dismiss();
                    if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nrk != null) {
                        String str = VideoPlayFragment.this.nrk.thread_id;
                        String str2 = VideoPlayFragment.this.nrk.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.nrk.post_id;
                        if (VideoPlayFragment.this.nrk.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.nrk.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.nrk.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0855a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0855a2);
            if (this.gKL) {
                a.C0855a c0855a3 = new a.C0855a(getActivity().getString(R.string.delete), this.nrs);
                c0855a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.epE.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.om(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.nrk != null) {
                                    VideoPlayFragment.this.hST.a(VideoPlayFragment.this.nrk.forum_id, VideoPlayFragment.this.nrk.forum_name, VideoPlayFragment.this.nrk.thread_id, VideoPlayFragment.this.nrk.post_id, 0, 0, VideoPlayFragment.this.gKL, null);
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
                        aVar.iM(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.bmC();
                    }
                });
                c0855a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0855a3);
            }
            this.nrs.bk(arrayList);
        }
        this.epE.show();
    }

    private void dPt() {
        if (this.nrk != null) {
            this.nqS.startLoad(this.nrk.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.nrk.title);
            if (StringUtils.isNull(this.nrk.title) || matcher.matches()) {
                this.nrb.setVisibility(8);
            } else {
                this.nrb.setVisibility(0);
                this.nrb.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.nrb.setTextColor(R.color.cp_cont_a);
                this.nrb.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.nrb.setExpandable(true);
                this.nrb.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void qr(boolean z) {
                        VideoPlayFragment.this.nrk.isTitleExpanded = z;
                    }
                });
                this.nrb.setData(this.nrk.title, this.nrk.isTitleExpanded);
            }
            this.nrd.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nrk.comment_num, 0L)));
            this.nre.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nrk.agree_num, 0L)));
            this.nrf.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nrk.share_num, 0L)));
            if (this.nrk.author_info != null) {
                if (!TextUtils.isEmpty(this.nrk.author_info.bjhAvatar)) {
                    this.nqU.startLoad(this.nrk.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.nrk.author_info.portrait) && this.nrk.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.nqU.startLoad(this.nrk.author_info.portrait, 10, false);
                } else {
                    this.nqU.startLoad(this.nrk.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.nrk.author_info.dLN())) {
                    this.nrn.setVisibility(8);
                } else {
                    this.nrn.setVisibility(0);
                    this.nrn.setText(UgcConstant.AT_RULE_TAG + this.nrk.author_info.dLN());
                }
            }
            if ("1".equals(this.nrk.is_private) && this.nrl.getVisibility() != 0) {
                this.nrj.setVisibility(0);
            } else {
                this.nrj.setVisibility(8);
            }
            if ("1".equals(this.nrk.is_agreed)) {
                ap.setImageResource(this.nrm, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.nrm, R.drawable.btn_video_agree);
            }
            if (this.nrk.act_info != null && !StringUtils.isNull(this.nrk.act_info.activity_name) && this.nrl.getVisibility() != 0) {
                this.nri.setVisibility(0);
                this.nrc.setText(this.nrk.act_info.activity_name);
            } else {
                this.nri.setVisibility(8);
            }
            dPv();
            if (this.nrk.isBjhVideo) {
                this.nqT.setVisibility(8);
            } else {
                this.nqT.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPu() {
        if (this.nrk != null) {
            if ("1".equals(this.nrk.is_agreed)) {
                ap.setImageResource(this.nrm, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.nrm, R.drawable.btn_video_agree);
            }
            this.nre.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nrk.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPv() {
        if (this.gKL || (this.nrk.author_info != null && !"0".equals(this.nrk.author_info.is_follow))) {
            this.nqY.setVisibility(4);
            this.nqY.setClickable(false);
            return;
        }
        this.nqY.setVisibility(0);
        this.nqY.setClickable(true);
    }

    private void dPw() {
        if (getActivity() != null) {
            if (this.nrA == null || !this.nrA.isShowing()) {
                this.nrA = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.boN().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.nrA.bb(inflate);
                this.nrA.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.nrA.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.nrA.op(1);
                this.nrA.on(R.color.cp_cont_b);
                this.nrA.iM(true);
                this.nrA.b(getPageContext());
                this.nrA.bmC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dPx() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dLS().dLT() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet() || !this.eaF) {
            return false;
        }
        if (this.nrg != null) {
            this.nrg.setVisibility(0);
        }
        aNl();
        dPw();
        return true;
    }

    private void aNm() {
        if (!dPx() && this.gdn != null && this.nrg != null && this.nrk != null) {
            if (this.gdn.getParent() == null) {
                dPC();
                dPD();
            }
            if (TbVideoViewSet.duT().Qv(this.mVideoUrl) == null || TbVideoViewSet.duT().Qv(this.mVideoUrl) != this.gdn) {
                this.gdn.setVideoPath(this.mVideoUrl, this.nrk.thread_id);
            }
            this.gdn.a((TbVideoViewSet.a) null);
            this.nrg.setVisibility(8);
            due();
            if (this.nrz != null) {
                this.nrz.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.nrt == null) {
            this.nrt = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.nrt;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0593a
    public void bEG() {
        if (this.gdn.isPlaying()) {
            this.gdn.pause();
            this.nrg.setVisibility(0);
        } else if (!dPx()) {
            this.gdn.start();
            this.nrg.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0593a
    public void y(float f, float f2) {
        if (bg.checkUpIsLogin(getActivity()) && !this.nru) {
            dPy();
            if (this.nrk != null && "0".equals(this.nrk.is_agreed)) {
                KK(this.nqR);
            }
        }
    }

    private void dPy() {
        if (this.mRootView != null) {
            this.nru = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.nrw == null) {
                this.nrw = new RelativeLayout.LayoutParams(-2, -2);
                this.nrw.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.nrw);
            }
            if (this.nrv == null) {
                this.nrv = new AnimatorSet();
                this.nrv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.nru = false;
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
            this.nrv.setTarget(imageView);
            this.nrv.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.nrv.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0593a
    public void bEH() {
        if (this.nrk != null && this.nrk.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.nrk.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dPz() {
        return null;
    }

    public String dPA() {
        return null;
    }

    public boolean dPB() {
        if (this.nry == null || this.nry.bwY() == null || !this.nry.bwY().isVisible()) {
            return false;
        }
        this.nry.bwY().hide();
        this.nro.setVisibility(0);
        if ((this.nry.bwY().ra(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.nry.bwY().ra(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.nry.bwY().ra(28)).getInputView().getText() != null) {
            this.nrp.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nry.bwY().ra(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.nry != null) {
            this.nry.onActivityResult(i, i2, intent);
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
        if (this.nry != null && this.nry.bwY() != null) {
            this.nry.bwY().onChangeSkinType(i);
        }
        SvgManager.boN().a(this.aFv, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dPC() {
        if (this.gdn != null && this.gdn.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.gdn.getView(), 0);
            this.gdn.getView().setLayoutParams(layoutParams);
            if (this.nrk != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.alT = this.nrk.thread_id;
                oVar.mNid = this.nrk.nid;
                oVar.fsZ = this.nrk.forum_id;
                oVar.mdX = this.nrk.mMd5;
                oVar.eve = "";
                oVar.mSource = this.nrk.mRecomSource;
                oVar.mdW = this.nrk.mRecomAbTag;
                oVar.mdV = 1;
                if (this.nrk.baijiahaoData != null) {
                    if (this.nrk.baijiahaoData.oriUgcType == 2) {
                        oVar.mdV = 3;
                    } else if (this.nrk.baijiahaoData.oriUgcType == 4) {
                        oVar.mdV = 2;
                    }
                }
                oVar.mdT = this.nrk.mRecomWeight;
                if (this.mRect != null) {
                    oVar.mdY = "1";
                } else {
                    oVar.mdY = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.mdZ = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.mdU = this.mFromPage;
                    oVar.eve = this.eve;
                    oVar.mdS = this.nrk.mRecomWeight;
                } else {
                    oVar.mLocate = "14";
                }
                this.gdn.setVideoStatData(oVar);
                this.gdn.setLocateSource("v_mid_page");
            }
            this.gdn.setContinuePlayEnable(true);
        }
    }

    private void dPD() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.gdn.setOnPreparedListener(this.nrB);
        }
        this.gdn.setOnCompletionListener(this.meF);
        this.gdn.setOnInfoListener(this.meH);
    }
}
