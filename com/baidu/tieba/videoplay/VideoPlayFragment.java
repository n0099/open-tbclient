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
/* loaded from: classes23.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0562a {
    public ImageView aCi;
    private boolean dGi;
    private e dVe;
    private String eaC;
    public TbCyberVideoView fHb;
    private AlphaAnimation fJX;
    private boolean gkE;
    private View hAO;
    private int ick;
    private f.b lBi;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private TbImageView mOK;
    public ImageView mOL;
    public HeadImageView mOM;
    public LinearLayout mON;
    public LinearLayout mOO;
    public LinearLayout mOP;
    public ImageView mOQ;
    public ImageView mOR;
    public ImageView mOS;
    public ExpandableTextView mOT;
    public TextView mOU;
    public TextView mOV;
    public TextView mOW;
    public TextView mOX;
    public ImageView mOY;
    private LinearLayout mOZ;
    public LinearLayout mPa;
    public LinearLayout mPb;
    public VideoItemData mPc;
    private TextView mPd;
    public ImageView mPe;
    public TextView mPf;
    private View mPg;
    private TextView mPh;
    private int mPi;
    private int mPj;
    private com.baidu.tieba.view.a mPk;
    protected Animation mPl;
    private boolean mPo;
    private AnimatorSet mPp;
    private RelativeLayout.LayoutParams mPq;
    private com.baidu.tieba.videoplay.editor.a mPs;
    private a mPt;
    com.baidu.tbadk.core.dialog.a mPu;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int mOI = 0;
    private int mOJ = 1;
    private ForumManageModel hrC = null;
    private com.baidu.tbadk.baseEditMark.a kMd = null;
    private com.baidu.tbadk.coreExtra.model.a emW = null;
    private BdUniqueId aih = BdUniqueId.gen();
    private boolean mPr = false;
    private int playTime = 1;
    private CustomMessageListener ena = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.mPc != null && VideoPlayFragment.this.mPc.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.mPc.author_info.user_id) && data != null && VideoPlayFragment.this.mPc.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aih)) ? false : false;
                    if (data.eEj == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.mPc.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.mPc.author_info.is_follow = "0";
                                VideoPlayFragment.this.dIB();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.dGi) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.mPc));
                                } else {
                                    VideoPlayFragment.this.mPc.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dIB();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.mPc.author_info.is_follow = "0";
                            VideoPlayFragment.this.dIB();
                        }
                        aq aqVar = new aq("c13570");
                        aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                        if ("index".equals(VideoPlayFragment.this.mFromPage)) {
                            aqVar.dF("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                            aqVar.dF("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        }
    };
    private final CustomMessageListener dWI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.dID();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.mPc != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.mPc.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.mPc.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.mPc.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.mPc.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dIA();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.mPc.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.mPc.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.mPc.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dIA();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnInfoListener lCT = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.dGi) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.mOK.getVisibility() == 0) {
                    VideoPlayFragment.this.mOK.clearAnimation();
                    VideoPlayFragment.this.mOK.startAnimation(VideoPlayFragment.this.fJX);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener lCR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.fHb != null) {
                VideoPlayFragment.this.fHb.doa();
                VideoPlayFragment.this.fHb.seekTo(0);
                VideoPlayFragment.this.fHb.start();
                VideoPlayFragment.this.ceV();
                VideoPlayFragment.A(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dIu();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener mPv = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.fHb != null) {
                VideoPlayFragment.this.fHb.setVolume(1.0f, 1.0f);
            }
        }
    };

    /* loaded from: classes23.dex */
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
        this.mPc = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.mPj = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.eaC = arguments.getString("obj_id");
        if (this.mPc != null && this.mPc.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.mPc.author_info.user_id)) {
            this.gkE = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.fHb = new TbCyberVideoView(getContext());
        this.fHb.setStageType("2005");
        this.fHb.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.f.b
            public void ca(int i, int i2) {
                if (VideoPlayFragment.this.lBi != null) {
                    VideoPlayFragment.this.lBi.ca(i, i2);
                }
            }
        });
        dII();
        this.mOK = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.mOK.setPlaceHolder(4);
        this.mOK.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.bjp()) {
            this.hAO = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.hAO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.hAO.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aCi = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.mOL = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.mOM = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.mOM.setDefaultResource(17170445);
        this.mOM.setPlaceHolder(2);
        this.mOM.setIsRound(true);
        this.mOQ = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.mPe = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.mOT = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.mOU = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.mOO = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.mOV = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.mON = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.mOW = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.mOX = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.mOR = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.mOS = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dIv();
        this.mOY = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.mOZ = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.mPa = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.mPb = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.mOP = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.mPf = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.mPg = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.mPg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.mPg.setVisibility(4);
                    if (VideoPlayFragment.this.mPs != null && VideoPlayFragment.this.mPs.bsv() != null) {
                        VideoPlayFragment.this.mPs.bsv().display();
                        if (VideoPlayFragment.this.mPc != null) {
                            VideoPlayFragment.this.mPs.c(VideoPlayFragment.this.mPc);
                        }
                    }
                    if (VideoPlayFragment.this.mPc != null) {
                        aq aqVar = new aq("c13025");
                        aqVar.dF("tid", VideoPlayFragment.this.mPc.thread_id);
                        aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar.dF("fid", VideoPlayFragment.this.mPc.forum_id);
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        });
        this.mPh = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.mPd = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.mPd.setVisibility(8);
        String string = b.bjf().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.mPd.setText(string);
        }
        final String string2 = b.bjf().getString("nani_key_download_link_url", null);
        this.mPd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    be.bkp().a((TbPageContext) i.I(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dIz();
        this.mOM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mPc != null && VideoPlayFragment.this.mPc.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.mPc.author_info.user_id) && VideoPlayFragment.this.mPc != null && VideoPlayFragment.this.mPc.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.mPc.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    aq aqVar = new aq("c12798");
                    aqVar.dF("tid", VideoPlayFragment.this.mPc.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.mPa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mPc != null && VideoPlayFragment.this.mPc.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.mPc.act_info.link_url);
                    aq aqVar = new aq("c12799");
                    aqVar.dF("tid", VideoPlayFragment.this.mPc.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.mOT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dIx();
            }
        });
        this.aCi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mPc != null && !StringUtils.isNull(VideoPlayFragment.this.mPc.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.mPc.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.mOL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dIy();
            }
        });
        this.mOO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.mPc)) {
                    VideoPlayFragment.this.dIx();
                    aq aqVar = new aq("c12796");
                    aqVar.dF("tid", VideoPlayFragment.this.mPc.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.mON.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.JM(VideoPlayFragment.this.mOI);
            }
        });
        this.mOP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.blQ();
                aq aqVar = new aq("c12797");
                aqVar.dF("tid", VideoPlayFragment.this.mPc.thread_id);
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar);
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dF("tid", VideoPlayFragment.this.mPc.thread_id);
                aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.ai("obj_locate", 19);
                aqVar2.dF("nid", VideoPlayFragment.this.mPc.nid);
                if (VideoPlayFragment.this.mPc.baijiahaoData != null && !at.isEmpty(VideoPlayFragment.this.mPc.baijiahaoData.oriUgcVid)) {
                    aqVar2.dF("obj_param6", VideoPlayFragment.this.mPc.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.mPc.getVideoType() == 1) {
                    aqVar2.ai(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.mPc.getVideoType() == 2) {
                    aqVar2.ai(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.mPc.getVideoType() == 3) {
                    aqVar2.ai(IntentConfig.CARD_TYPE, 6);
                }
                aqVar2.dF(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.mPc.mRecomSource);
                aqVar2.dF("ab_tag", VideoPlayFragment.this.mPc.mRecomAbTag);
                aqVar2.dF("weight", VideoPlayFragment.this.mPc.mRecomWeight);
                aqVar2.dF("extra", VideoPlayFragment.this.mPc.mRecomExtra);
                aqVar2.dF("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.el(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.el(VideoPlayFragment.this.getBaseFragmentActivity()).bvb() != null && c.el(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.el(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    aqVar2.dF("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    aqVar2.dF("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(aqVar2);
            }
        });
        this.mOQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.mPc != null && VideoPlayFragment.this.mPc.author_info != null) {
                    VideoPlayFragment.this.emW.a(true, VideoPlayFragment.this.mPc.author_info.portrait, VideoPlayFragment.this.mPc.author_info.user_id, false, "6", VideoPlayFragment.this.aih, VideoPlayFragment.this.mPc.forum_id, "0");
                    VideoPlayFragment.this.mPc.author_info.is_follow = "1";
                    VideoPlayFragment.this.dIB();
                }
            }
        });
        this.fJX = new AlphaAnimation(1.0f, 0.0f);
        this.fJX.setDuration(100L);
        this.fJX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.mOK != null) {
                    VideoPlayFragment.this.mOK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mPi = this.mRect.right - this.mRect.left;
            this.ick = this.mRect.bottom - this.mRect.top;
            this.mOK.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.mOK.getWidth();
                    int height = VideoPlayFragment.this.mOK.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mPc.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mPc.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mPc.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mPc.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mPi, VideoPlayFragment.this.ick);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.mOK.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.ick > 0 || VideoPlayFragment.this.mPi <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mPi;
                                f = i / VideoPlayFragment.this.ick;
                            }
                            VideoPlayFragment.this.mOK.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.mOK.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.dGi) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mPi, VideoPlayFragment.this.ick);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.mOK.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.ick > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.mOK.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.mOK.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.dGi) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.mOK.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.mOK.getWidth();
                    int height = VideoPlayFragment.this.mOK.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mPc.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mPc.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mPc.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mPc.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.mOK.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.mOK.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cOl();
        if (this.dGi) {
            dIw();
        }
        if (this.mPc != null && !StringUtils.isNull(this.mPc.video_url)) {
            setVideoInfo(this.mPc.video_url);
        }
        return this.mRootView;
    }

    public void a(f.b bVar) {
        this.lBi = bVar;
    }

    public void a(a aVar) {
        this.mPt = aVar;
    }

    private void cOl() {
        this.mPs = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().eb(getActivity());
        if (this.mPs != null && this.mPc != null) {
            this.mPs.a(getPageContext());
            this.mPs.az(this.mPc.thread_id, this.mPc.forum_id, this.mPc.forum_name);
            this.mPs.a(new a.InterfaceC0820a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0820a
                public void xb(boolean z) {
                    VideoPlayFragment.this.mPg.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.mPh.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.mPh.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.mPs.bsv().qr(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.mPc != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.mPc.comment_num, 0L) + 1;
                        VideoPlayFragment.this.mPc.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.mOV.setText(at.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.mPs.bsv(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blQ() {
        String str;
        String str2;
        if (this.mPc != null) {
            String str3 = this.mPc.forum_id;
            String str4 = this.mPc.forum_name;
            String str5 = this.mPc.title;
            if (this.mPc.baijiahaoData != null) {
                str = this.mPc.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.mPc.baijiahaoData.oriUgcType + "&dvid=" + this.mPc.baijiahaoData.oriUgcVid + "&nid=" + this.mPc.baijiahaoData.oriUgcNid;
            } else {
                str = this.mPc.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str7 = this.mPc.thumbnail_url;
            String format = (!this.mPc.isBjhVideo || this.mPc.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.mPc.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.mPc.baijiahaoData == null) {
                shareItem.readCount = this.mPc.play_count;
            }
            if (this.mPc.isBjhVideo) {
                shareItem.eGA = format;
            } else {
                shareItem.eGA = "";
            }
            shareItem.linkUrl = str6;
            shareItem.egT = 2;
            shareItem.extData = str;
            shareItem.eGD = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.eGp = true;
            shareItem.eGC = 12;
            if (this.mPc.getVideoType() == 1) {
                shareItem.eGH = 2;
            } else if (this.mPc.getVideoType() == 2) {
                shareItem.eGH = 8;
            } else if (this.mPc.getVideoType() == 3) {
                shareItem.eGH = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.mPc.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.mPc.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.mPc.title;
            originalThreadInfo.threadId = this.mPc.thread_id;
            originalThreadInfo.oriUgcInfo = this.mPc.baijiahaoData;
            shareItem.eGK = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eGD);
            bundle.putInt("obj_type", shareItem.eGH);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.egT);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.f.cgr().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gkE) {
            this.hrC = new ForumManageModel(getPageContext());
            this.hrC.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.hrC.getLoadDataMode()) {
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
        this.kMd = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.kMd != null) {
            this.kMd.a(new a.InterfaceC0530a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0530a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.kMd != null) {
                            VideoPlayFragment.this.kMd.hy(z2);
                        }
                        if (VideoPlayFragment.this.mPc != null) {
                            if (z2) {
                                VideoPlayFragment.this.mPc.mark_id = VideoPlayFragment.this.mPc.post_id;
                            } else {
                                VideoPlayFragment.this.mPc.mark_id = null;
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
        this.emW = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.ena);
        registerListener(this.dWI);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.mPr = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dIz();
        dIJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIu() {
        if (this.mOS != null && this.mOR != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.mOR.clearAnimation();
            this.mOS.clearAnimation();
            this.mOR.setVisibility(8);
            this.mOS.setVisibility(0);
            this.mOS.startAnimation(scaleAnimation2);
            this.mOR.startAnimation(scaleAnimation);
        }
    }

    private void dIv() {
        if (this.mOS != null && this.mOR != null) {
            this.mOR.clearAnimation();
            this.mOS.clearAnimation();
            this.mOR.setVisibility(0);
            this.mOS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JM(int i) {
        int i2;
        if (bg.checkUpIsLogin(getActivity()) && this.mPc != null) {
            if (i == this.mOI) {
                if ("1".equals(this.mPc.is_agreed)) {
                    i2 = 1;
                    this.mPc.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mPc.agree_num, 0) - 1);
                    this.mPc.is_agreed = "0";
                } else {
                    this.mPc.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mPc.agree_num, 0) + 1);
                    this.mPc.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.mPc.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mPc.agree_num, 0) + 1);
                this.mPc.is_agreed = "1";
                i2 = 0;
            }
            aq aqVar = new aq("c12795");
            aqVar.dF("tid", this.mPc.thread_id);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.mOI) {
                aqVar.ai("obj_type", i2);
            } else {
                aqVar.ai("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12003");
            aqVar2.dF("tid", this.mPc.thread_id);
            aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.mOI) {
                aqVar2.ai("obj_type", i2);
            } else {
                aqVar2.ai("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                aqVar2.dF("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                aqVar2.dF("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            TiebaStatic.log(aqVar2);
            dIz();
            if (this.mPe != null && i2 == 0) {
                this.mPe.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.mPc.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.mPc.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.mPc.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.mPc.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.mPc.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.mPc.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.mPc.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.mPc.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.mPc));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.mPc != null && !StringUtils.isNull(this.mPc.video_url)) {
            this.mHasInit = true;
            if (this.dGi) {
                ceV();
                aIJ();
                if (this.mPc != null && this.mRect != null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dF("tid", this.mPc.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.ai("obj_type", 0);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            aII();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        aII();
        if (this.mPs != null && this.mPs.bsv() != null) {
            this.mPs.bsv().hide();
            this.mPg.setVisibility(0);
            this.mPh.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.mPs.bsv().qr(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.mPs != null) {
            this.mPs.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.dGi = z;
        if (!z && this.mPs != null) {
            this.mPh.setText(R.string.reply_something);
            this.mPs.ctq();
        }
        if (this.mHasInit) {
            if (this.dGi && (!this.mPr || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.mPc != null && this.mRect == null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dF("tid", this.mPc.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.ai("obj_type", 1);
                    TiebaStatic.log(aqVar);
                }
                startPlay();
                dIw();
                this.mPr = false;
                return;
            }
            dIv();
            this.playTime = 1;
            aII();
        }
    }

    private void dIw() {
        if (this.mPc != null) {
            aq aqVar = new aq("c12590");
            aqVar.dF("tid", this.mPc.thread_id);
            aqVar.dF("nid", this.mPc.nid);
            aqVar.dF("fid", this.mPc.forum_id);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.ai("obj_locate", this.mPj);
            aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dF("obj_param1", at.isEmpty(this.mPc.mRecomWeight) ? "0" : this.mPc.mRecomWeight);
            aqVar.dF("extra", at.isEmpty(this.mPc.mRecomExtra) ? "0" : this.mPc.mRecomExtra);
            aqVar.dF("obj_id", this.eaC);
            aqVar.dF("ab_tag", at.isEmpty(this.mPc.mRecomAbTag) ? "0" : this.mPc.mRecomAbTag);
            aqVar.dF("obj_source", at.isEmpty(this.mPc.mRecomSource) ? "0" : this.mPc.mRecomSource);
            aqVar.dF("obj_type", this.mFromPage);
            aqVar.ai("is_vertical", 1);
            if (this.mPc.baijiahaoData != null) {
                aqVar.dF("obj_param4", this.mPc.baijiahaoData.oriUgcNid);
                aqVar.dF("obj_param6", this.mPc.baijiahaoData.oriUgcVid);
                if (this.mPc.baijiahaoData.oriUgcType == 4) {
                    aqVar.ai("obj_param5", 2);
                } else if (this.mPc.baijiahaoData.oriUgcType == 2) {
                    aqVar.ai("obj_param5", 3);
                }
            } else {
                aqVar.ai("obj_param5", 1);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.fHb != null && str != null && !str.equals(this.mVideoUrl)) {
            this.fHb.setVideoPath(str, this.mPc.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dID()) {
            dnl();
            if (this.mOY != null) {
                this.mOY.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.mOK.getVisibility() == 0) {
                this.mOK.clearAnimation();
                this.mOK.startAnimation(this.fJX);
            }
            if (this.fHb != null) {
                if (TbVideoViewSet.dob().Pi(this.mVideoUrl) == null || TbVideoViewSet.dob().Pi(this.mVideoUrl) != this.fHb) {
                    this.fHb.setVideoPath(this.mVideoUrl, this.mPc.thread_id);
                }
                this.fHb.start();
                ceV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceV() {
        if (this.mPc != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.alA = this.mPc.thread_id;
            oVar.mNid = this.mPc.nid;
            oVar.eYo = this.mPc.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.mPc.mRecomSource;
            oVar.lCf = this.mPc.mRecomAbTag;
            oVar.lCg = this.mPc.mRecomWeight;
            oVar.lCh = "";
            oVar.eaC = "";
            oVar.lCk = this.mPc.mMd5;
            if (this.mRect != null) {
                oVar.lCl = "1";
            } else {
                oVar.lCl = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.lCm = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.lCh = "index";
            }
            h.a(this.mPc.mMd5, "", "1", oVar, this.fHb.getPcdnState());
        }
    }

    private void dnl() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dEY().fO(getContext());
        }
    }

    private void aII() {
        if (this.fHb != null) {
            this.fHb.pause();
        }
    }

    private void stopPlay() {
        if (this.fHb != null) {
            this.fHb.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIx() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.mPc.thread_id, this.mPc.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.mPc.forum_id));
        createNormalCfg.setForumName(this.mPc.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.mPc.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIy() {
        if (this.dVe == null) {
            this.mPk = new com.baidu.tieba.view.a(getActivity());
            this.dVe = new e(getActivity(), this.mPk.biq());
            this.dVe.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.fHb.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.mPk != null) {
            ArrayList arrayList = new ArrayList();
            a.C0822a c0822a = new a.C0822a(this.mPk);
            c0822a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bg.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.dVe.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.dVe.dismiss();
                    if (VideoPlayFragment.this.mPc != null) {
                        boolean z = VideoPlayFragment.this.mPc.post_id != null && VideoPlayFragment.this.mPc.post_id.equals(VideoPlayFragment.this.mPc.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.mPc.thread_id);
                        markData.setPostId(VideoPlayFragment.this.mPc.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.mPc.thread_id);
                        markData.setForumId(VideoPlayFragment.this.mPc.forum_id);
                        if (VideoPlayFragment.this.kMd != null) {
                            VideoPlayFragment.this.kMd.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.kMd.bbw();
                            } else {
                                VideoPlayFragment.this.kMd.bbv();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.mPc != null && this.mPc.post_id != null && this.mPc.post_id.equals(this.mPc.mark_id)) {
                z = true;
            }
            if (z) {
                c0822a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0822a.setText(getResources().getString(R.string.mark));
            }
            if (this.mPc != null && !this.mPc.isBjhVideo) {
                arrayList.add(c0822a);
            }
            a.C0822a c0822a2 = new a.C0822a(getActivity().getString(R.string.delete), this.mPk);
            c0822a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.dVe.dismiss();
                    if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.mPc != null) {
                        String str = VideoPlayFragment.this.mPc.thread_id;
                        String str2 = VideoPlayFragment.this.mPc.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.mPc.post_id;
                        if (VideoPlayFragment.this.mPc.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.mPc.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.mPc.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0822a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0822a2);
            if (this.gkE) {
                a.C0822a c0822a3 = new a.C0822a(getActivity().getString(R.string.delete), this.mPk);
                c0822a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.dVe.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.nE(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.mPc != null) {
                                    VideoPlayFragment.this.hrC.a(VideoPlayFragment.this.mPc.forum_id, VideoPlayFragment.this.mPc.forum_name, VideoPlayFragment.this.mPc.thread_id, VideoPlayFragment.this.mPc.post_id, 0, 0, VideoPlayFragment.this.gkE, null);
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
                        aVar.id(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.bia();
                    }
                });
                c0822a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0822a3);
            }
            this.mPk.aX(arrayList);
        }
        this.dVe.show();
    }

    private void dIz() {
        if (this.mPc != null) {
            this.mOK.startLoad(this.mPc.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.mPc.title);
            if (StringUtils.isNull(this.mPc.title) || matcher.matches()) {
                this.mOT.setVisibility(8);
            } else {
                this.mOT.setVisibility(0);
                this.mOT.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.mOT.setTextColor(R.color.cp_cont_a);
                this.mOT.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.mOT.setExpandable(true);
                this.mOT.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void pu(boolean z) {
                        VideoPlayFragment.this.mPc.isTitleExpanded = z;
                    }
                });
                this.mOT.setData(this.mPc.title, this.mPc.isTitleExpanded);
            }
            this.mOV.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mPc.comment_num, 0L)));
            this.mOW.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mPc.agree_num, 0L)));
            this.mOX.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mPc.share_num, 0L)));
            if (this.mPc.author_info != null) {
                if (!TextUtils.isEmpty(this.mPc.author_info.bjhAvatar)) {
                    this.mOM.startLoad(this.mPc.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.mPc.author_info.portrait) && this.mPc.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.mOM.startLoad(this.mPc.author_info.portrait, 10, false);
                } else {
                    this.mOM.startLoad(this.mPc.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.mPc.author_info.dET())) {
                    this.mPf.setVisibility(8);
                } else {
                    this.mPf.setVisibility(0);
                    this.mPf.setText(UgcConstant.AT_RULE_TAG + this.mPc.author_info.dET());
                }
            }
            if ("1".equals(this.mPc.is_private) && this.mPd.getVisibility() != 0) {
                this.mPb.setVisibility(0);
            } else {
                this.mPb.setVisibility(8);
            }
            if ("1".equals(this.mPc.is_agreed)) {
                ap.setImageResource(this.mPe, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.mPe, R.drawable.btn_video_agree);
            }
            if (this.mPc.act_info != null && !StringUtils.isNull(this.mPc.act_info.activity_name) && this.mPd.getVisibility() != 0) {
                this.mPa.setVisibility(0);
                this.mOU.setText(this.mPc.act_info.activity_name);
            } else {
                this.mPa.setVisibility(8);
            }
            dIB();
            if (this.mPc.isBjhVideo) {
                this.mOL.setVisibility(8);
            } else {
                this.mOL.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIA() {
        if (this.mPc != null) {
            if ("1".equals(this.mPc.is_agreed)) {
                ap.setImageResource(this.mPe, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.mPe, R.drawable.btn_video_agree);
            }
            this.mOW.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mPc.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIB() {
        if (this.gkE || (this.mPc.author_info != null && !"0".equals(this.mPc.author_info.is_follow))) {
            this.mOQ.setVisibility(4);
            this.mOQ.setClickable(false);
            return;
        }
        this.mOQ.setVisibility(0);
        this.mOQ.setClickable(true);
    }

    private void dIC() {
        if (getActivity() != null) {
            if (this.mPu == null || !this.mPu.isShowing()) {
                this.mPu = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.bkl().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.mPu.aZ(inflate);
                this.mPu.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.mPu.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.mPu.nH(1);
                this.mPu.nF(R.color.cp_cont_b);
                this.mPu.id(true);
                this.mPu.b(getPageContext());
                this.mPu.bia();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dID() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dEY().dEZ() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet() || !this.dGi) {
            return false;
        }
        if (this.mOY != null) {
            this.mOY.setVisibility(0);
        }
        aII();
        dIC();
        return true;
    }

    private void aIJ() {
        if (!dID() && this.fHb != null && this.mOY != null && this.mPc != null) {
            if (this.fHb.getParent() == null) {
                dII();
                dIJ();
            }
            if (TbVideoViewSet.dob().Pi(this.mVideoUrl) == null || TbVideoViewSet.dob().Pi(this.mVideoUrl) != this.fHb) {
                this.fHb.setVideoPath(this.mVideoUrl, this.mPc.thread_id);
            }
            this.fHb.a((TbVideoViewSet.a) null);
            this.mOY.setVisibility(8);
            dnl();
            if (this.mPt != null) {
                this.mPt.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.mPl == null) {
            this.mPl = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.mPl;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0562a
    public void bAd() {
        if (this.fHb.isPlaying()) {
            this.fHb.pause();
            this.mOY.setVisibility(0);
        } else if (!dID()) {
            this.fHb.start();
            this.mOY.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0562a
    public void y(float f, float f2) {
        if (bg.checkUpIsLogin(getActivity()) && !this.mPo) {
            dIE();
            if (this.mPc != null && "0".equals(this.mPc.is_agreed)) {
                JM(this.mOJ);
            }
        }
    }

    private void dIE() {
        if (this.mRootView != null) {
            this.mPo = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.mPq == null) {
                this.mPq = new RelativeLayout.LayoutParams(-2, -2);
                this.mPq.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.mPq);
            }
            if (this.mPp == null) {
                this.mPp = new AnimatorSet();
                this.mPp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.mPo = false;
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
            this.mPp.setTarget(imageView);
            this.mPp.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.mPp.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0562a
    public void bAe() {
        if (this.mPc != null && this.mPc.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.mPc.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dIF() {
        return null;
    }

    public String dIG() {
        return null;
    }

    public boolean dIH() {
        if (this.mPs == null || this.mPs.bsv() == null || !this.mPs.bsv().isVisible()) {
            return false;
        }
        this.mPs.bsv().hide();
        this.mPg.setVisibility(0);
        if ((this.mPs.bsv().qr(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.mPs.bsv().qr(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.mPs.bsv().qr(28)).getInputView().getText() != null) {
            this.mPh.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.mPs.bsv().qr(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.mPs != null) {
            this.mPs.onActivityResult(i, i2, intent);
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
        if (this.mPs != null && this.mPs.bsv() != null) {
            this.mPs.bsv().onChangeSkinType(i);
        }
        SvgManager.bkl().a(this.aCi, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dII() {
        if (this.fHb != null && this.fHb.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.fHb.getView(), 0);
            this.fHb.getView().setLayoutParams(layoutParams);
            if (this.mPc != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.alA = this.mPc.thread_id;
                oVar.mNid = this.mPc.nid;
                oVar.eYo = this.mPc.forum_id;
                oVar.lCk = this.mPc.mMd5;
                oVar.eaC = "";
                oVar.mSource = this.mPc.mRecomSource;
                oVar.lCj = this.mPc.mRecomAbTag;
                oVar.lCi = 1;
                if (this.mPc.baijiahaoData != null) {
                    if (this.mPc.baijiahaoData.oriUgcType == 2) {
                        oVar.lCi = 3;
                    } else if (this.mPc.baijiahaoData.oriUgcType == 4) {
                        oVar.lCi = 2;
                    }
                }
                oVar.lCg = this.mPc.mRecomWeight;
                if (this.mRect != null) {
                    oVar.lCl = "1";
                } else {
                    oVar.lCl = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.lCm = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.lCh = this.mFromPage;
                    oVar.eaC = this.eaC;
                    oVar.lCf = this.mPc.mRecomWeight;
                } else {
                    oVar.mLocate = "14";
                }
                this.fHb.setVideoStatData(oVar);
                this.fHb.setLocateSource("v_mid_page");
            }
            this.fHb.setContinuePlayEnable(true);
        }
    }

    private void dIJ() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.fHb.setOnPreparedListener(this.mPv);
        }
        this.fHb.setOnCompletionListener(this.lCR);
        this.fHb.setOnInfoListener(this.lCT);
    }
}
