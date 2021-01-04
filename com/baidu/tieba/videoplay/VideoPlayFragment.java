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
import com.baidu.adp.base.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.pageExtra.d;
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
/* loaded from: classes8.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0608a {
    public ImageView aHx;
    private e eKt;
    private String eQd;
    private boolean evx;
    public TbCyberVideoView gBU;
    private AlphaAnimation gEX;
    private boolean hli;
    private View iGd;
    private int jhy;
    private f.b mCI;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    public ImageView nPA;
    public ExpandableTextView nPB;
    public TextView nPC;
    public TextView nPD;
    public TextView nPE;
    public TextView nPF;
    public ImageView nPG;
    private LinearLayout nPH;
    public LinearLayout nPI;
    public LinearLayout nPJ;
    public VideoItemData nPK;
    private TextView nPL;
    public ImageView nPM;
    public TextView nPN;
    private View nPO;
    private TextView nPP;
    private int nPQ;
    private int nPR;
    private com.baidu.tieba.view.a nPS;
    protected Animation nPT;
    private boolean nPU;
    private AnimatorSet nPV;
    private RelativeLayout.LayoutParams nPW;
    private com.baidu.tieba.videoplay.editor.a nPY;
    private a nPZ;
    private TbImageView nPs;
    public ImageView nPt;
    public HeadImageView nPu;
    public LinearLayout nPv;
    public LinearLayout nPw;
    public LinearLayout nPx;
    public ImageView nPy;
    public ImageView nPz;
    com.baidu.tbadk.core.dialog.a nQa;
    private int nPq = 0;
    private int nPr = 1;
    private ForumManageModel ggJ = null;
    private com.baidu.tbadk.baseEditMark.a lNj = null;
    private com.baidu.tbadk.coreExtra.model.a fcZ = null;
    private BdUniqueId ahE = BdUniqueId.gen();
    private boolean nPX = false;
    private int playTime = 1;
    private CustomMessageListener fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.nPK != null && VideoPlayFragment.this.nPK.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nPK.author_info.user_id) && data != null && VideoPlayFragment.this.nPK.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.ahE)) ? false : false;
                    if (data.fuV == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.nPK.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.nPK.author_info.is_follow = "0";
                                VideoPlayFragment.this.dWU();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.evx) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.nPK));
                                } else {
                                    VideoPlayFragment.this.nPK.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dWU();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.nPK.author_info.is_follow = "0";
                            VideoPlayFragment.this.dWU();
                        }
                        aq aqVar = new aq("c13570");
                        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        if ("index".equals(VideoPlayFragment.this.mFromPage)) {
                            aqVar.dX("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                            aqVar.dX("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.dWW();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.nPK != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.nPK.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.nPK.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.nPK.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.nPK.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dWT();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.nPK.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.nPK.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.nPK.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dWT();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnInfoListener mEv = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.evx) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.nPs.getVisibility() == 0) {
                    VideoPlayFragment.this.nPs.clearAnimation();
                    VideoPlayFragment.this.nPs.startAnimation(VideoPlayFragment.this.gEX);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener mEt = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.gBU != null) {
                VideoPlayFragment.this.gBU.dCc();
                VideoPlayFragment.this.gBU.seekTo(0);
                VideoPlayFragment.this.gBU.start();
                VideoPlayFragment.this.cuI();
                VideoPlayFragment.A(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dWN();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener nQb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.gBU != null) {
                VideoPlayFragment.this.gBU.setVolume(1.0f, 1.0f);
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void onStart();
    }

    static /* synthetic */ int A(VideoPlayFragment videoPlayFragment) {
        int i = videoPlayFragment.playTime;
        videoPlayFragment.playTime = i + 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mThreadAgreeChangedListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.nPK = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.nPR = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.eQd = arguments.getString("obj_id");
        if (this.nPK != null && this.nPK.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.nPK.author_info.user_id)) {
            this.hli = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.gBU = new TbCyberVideoView(getContext());
        this.gBU.setStageType("2005");
        this.gBU.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.f.b
            public void ch(int i, int i2) {
                if (VideoPlayFragment.this.mCI != null) {
                    VideoPlayFragment.this.mCI.ch(i, i2);
                }
            }
        });
        dXb();
        this.nPs = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.nPs.setPlaceHolder(4);
        if (g.bvA()) {
            this.iGd = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.iGd.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.iGd.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aHx = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.nPt = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.nPu = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.nPu.setDefaultResource(17170445);
        this.nPu.setPlaceHolder(2);
        this.nPu.setIsRound(true);
        this.nPy = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.nPM = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.nPB = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.nPC = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.nPw = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.nPD = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.nPv = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.nPE = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.nPF = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.nPz = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nPA = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dWO();
        this.nPG = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.nPH = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.nPI = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.nPJ = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.nPx = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.nPN = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.nPO = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.nPO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.nPO.setVisibility(4);
                    if (VideoPlayFragment.this.nPY != null && VideoPlayFragment.this.nPY.bEI() != null) {
                        VideoPlayFragment.this.nPY.bEI().rV();
                        if (VideoPlayFragment.this.nPK != null) {
                            VideoPlayFragment.this.nPY.c(VideoPlayFragment.this.nPK);
                        }
                    }
                    if (VideoPlayFragment.this.nPK != null) {
                        aq aqVar = new aq("c13025");
                        aqVar.dX("tid", VideoPlayFragment.this.nPK.thread_id);
                        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar.dX("fid", VideoPlayFragment.this.nPK.forum_id);
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        });
        this.nPP = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.nPL = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.nPL.setVisibility(8);
        String string = b.bvq().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.nPL.setText(string);
        }
        final String string2 = b.bvq().getString("nani_key_download_link_url", null);
        this.nPL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    be.bwu().a((TbPageContext) j.K(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dWS();
        this.nPu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nPK != null && VideoPlayFragment.this.nPK.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nPK.author_info.user_id) && VideoPlayFragment.this.nPK != null && VideoPlayFragment.this.nPK.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nPK.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    aq aqVar = new aq("c12798");
                    aqVar.dX("tid", VideoPlayFragment.this.nPK.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.nPI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nPK != null && VideoPlayFragment.this.nPK.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.nPK.act_info.link_url);
                    aq aqVar = new aq("c12799");
                    aqVar.dX("tid", VideoPlayFragment.this.nPK.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.nPB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dWQ();
            }
        });
        this.aHx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nPK != null && !StringUtils.isNull(VideoPlayFragment.this.nPK.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.nPK.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.nPt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dWR();
            }
        });
        this.nPw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.nPK)) {
                    VideoPlayFragment.this.dWQ();
                    aq aqVar = new aq("c12796");
                    aqVar.dX("tid", VideoPlayFragment.this.nPK.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.nPv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Mf(VideoPlayFragment.this.nPq);
            }
        });
        this.nPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bye();
                aq aqVar = new aq("c12797");
                aqVar.dX("tid", VideoPlayFragment.this.nPK.thread_id);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar);
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dX("tid", VideoPlayFragment.this.nPK.thread_id);
                aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.an("obj_locate", 19);
                aqVar2.dX(IntentConfig.NID, VideoPlayFragment.this.nPK.nid);
                if (VideoPlayFragment.this.nPK.baijiahaoData != null && !at.isEmpty(VideoPlayFragment.this.nPK.baijiahaoData.oriUgcVid)) {
                    aqVar2.dX("obj_param6", VideoPlayFragment.this.nPK.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.nPK.getVideoType() == 1) {
                    aqVar2.an(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.nPK.getVideoType() == 2) {
                    aqVar2.an(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.nPK.getVideoType() == 3) {
                    aqVar2.an(IntentConfig.CARD_TYPE, 6);
                }
                aqVar2.dX(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.nPK.mRecomSource);
                aqVar2.dX("ab_tag", VideoPlayFragment.this.nPK.mRecomAbTag);
                aqVar2.dX("weight", VideoPlayFragment.this.nPK.mRecomWeight);
                aqVar2.dX("extra", VideoPlayFragment.this.nPK.mRecomExtra);
                aqVar2.dX("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.fu(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.fu(VideoPlayFragment.this.getBaseFragmentActivity()).bHp() != null && c.fu(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.fu(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    aqVar2.dX("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    aqVar2.dX("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(aqVar2);
            }
        });
        this.nPy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nPK != null && VideoPlayFragment.this.nPK.author_info != null) {
                    VideoPlayFragment.this.fcZ.a(true, VideoPlayFragment.this.nPK.author_info.portrait, VideoPlayFragment.this.nPK.author_info.user_id, false, "6", VideoPlayFragment.this.ahE, VideoPlayFragment.this.nPK.forum_id, "0");
                    VideoPlayFragment.this.nPK.author_info.is_follow = "1";
                    VideoPlayFragment.this.dWU();
                }
            }
        });
        this.gEX = new AlphaAnimation(1.0f, 0.0f);
        this.gEX.setDuration(100L);
        this.gEX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.nPs != null) {
                    VideoPlayFragment.this.nPs.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.nPQ = this.mRect.right - this.mRect.left;
            this.jhy = this.mRect.bottom - this.mRect.top;
            this.nPs.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2;
                    int width = VideoPlayFragment.this.nPs.getWidth();
                    int height = VideoPlayFragment.this.nPs.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nPK.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nPK.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nPK.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nPK.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nPQ, VideoPlayFragment.this.jhy);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.nPs.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jhy > 0 || VideoPlayFragment.this.nPQ <= 0) {
                                f = 1.0f;
                                f2 = 1.0f;
                            } else {
                                f = i / VideoPlayFragment.this.jhy;
                                f2 = i2 / VideoPlayFragment.this.nPQ;
                            }
                            VideoPlayFragment.this.nPs.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.nPs.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.evx) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nPQ, VideoPlayFragment.this.jhy);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.nPs.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jhy > 0) {
                    }
                    f = 1.0f;
                    f2 = 1.0f;
                    VideoPlayFragment.this.nPs.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.nPs.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.evx) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.nPs.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.nPs.getWidth();
                    int height = VideoPlayFragment.this.nPs.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nPK.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nPK.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nPK.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nPK.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.nPs.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.nPs.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        dbQ();
        if (this.evx) {
            dWP();
        }
        if (this.nPK != null && !StringUtils.isNull(this.nPK.video_url)) {
            UQ(this.nPK.video_url);
        }
        return this.mRootView;
    }

    public void a(f.b bVar) {
        this.mCI = bVar;
    }

    public void a(a aVar) {
        this.nPZ = aVar;
    }

    private void dbQ() {
        this.nPY = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().fj(getActivity());
        if (this.nPY != null && this.nPK != null) {
            this.nPY.a(getPageContext());
            this.nPY.aP(this.nPK.thread_id, this.nPK.forum_id, this.nPK.forum_name);
            this.nPY.a(new a.InterfaceC0870a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0870a
                public void yU(boolean z) {
                    VideoPlayFragment.this.nPO.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.nPP.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.nPP.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.nPY.bEI().sv(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.nPK != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nPK.comment_num, 0L) + 1;
                        VideoPlayFragment.this.nPK.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.nPD.setText(at.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.nPY.bEI(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bye() {
        String str;
        String str2;
        if (this.nPK != null) {
            String str3 = this.nPK.forum_id;
            String str4 = this.nPK.forum_name;
            String str5 = this.nPK.title;
            if (this.nPK.baijiahaoData != null) {
                str = this.nPK.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.nPK.baijiahaoData.oriUgcType + "&dvid=" + this.nPK.baijiahaoData.oriUgcVid + "&nid=" + this.nPK.baijiahaoData.oriUgcNid;
            } else {
                str = this.nPK.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str7 = this.nPK.thumbnail_url;
            String format = (!this.nPK.isBjhVideo || this.nPK.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.nPK.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.nPK.baijiahaoData == null) {
                shareItem.readCount = this.nPK.play_count;
            }
            if (this.nPK.isBjhVideo) {
                shareItem.fxm = format;
            } else {
                shareItem.fxm = "";
            }
            shareItem.linkUrl = str6;
            shareItem.eWH = 2;
            shareItem.extData = str;
            shareItem.fxp = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.fxb = true;
            shareItem.fxo = 12;
            if (this.nPK.getVideoType() == 1) {
                shareItem.fxt = 2;
            } else if (this.nPK.getVideoType() == 2) {
                shareItem.fxt = 8;
            } else if (this.nPK.getVideoType() == 3) {
                shareItem.fxt = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.nPK.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.nPK.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.nPK.title;
            originalThreadInfo.threadId = this.nPK.thread_id;
            originalThreadInfo.oriUgcInfo = this.nPK.baijiahaoData;
            shareItem.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fxp);
            bundle.putInt("obj_type", shareItem.fxt);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eWH);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.f.cwe().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.hli) {
            this.ggJ = new ForumManageModel(getPageContext());
            this.ggJ.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.ggJ.getLoadDataMode()) {
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
        this.lNj = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.lNj != null) {
            this.lNj.a(new a.InterfaceC0574a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0574a
                public void g(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.lNj != null) {
                            VideoPlayFragment.this.lNj.jc(z2);
                        }
                        if (VideoPlayFragment.this.nPK != null) {
                            if (z2) {
                                VideoPlayFragment.this.nPK.mark_id = VideoPlayFragment.this.nPK.post_id;
                            } else {
                                VideoPlayFragment.this.nPK.mark_id = null;
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
        this.fcZ = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.fdd);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.nPX = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dWS();
        dXc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWN() {
        if (this.nPA != null && this.nPz != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.nPz.clearAnimation();
            this.nPA.clearAnimation();
            this.nPz.setVisibility(8);
            this.nPA.setVisibility(0);
            this.nPA.startAnimation(scaleAnimation2);
            this.nPz.startAnimation(scaleAnimation);
        }
    }

    private void dWO() {
        if (this.nPA != null && this.nPz != null) {
            this.nPz.clearAnimation();
            this.nPA.clearAnimation();
            this.nPz.setVisibility(0);
            this.nPA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mf(int i) {
        int i2;
        if (bg.checkUpIsLogin(getActivity()) && this.nPK != null) {
            if (i == this.nPq) {
                if ("1".equals(this.nPK.is_agreed)) {
                    i2 = 1;
                    this.nPK.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nPK.agree_num, 0) - 1);
                    this.nPK.is_agreed = "0";
                } else {
                    this.nPK.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nPK.agree_num, 0) + 1);
                    this.nPK.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.nPK.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nPK.agree_num, 0) + 1);
                this.nPK.is_agreed = "1";
                i2 = 0;
            }
            aq aqVar = new aq("c12795");
            aqVar.dX("tid", this.nPK.thread_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nPq) {
                aqVar.an("obj_type", i2);
            } else {
                aqVar.an("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12003");
            aqVar2.dX("tid", this.nPK.thread_id);
            aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nPq) {
                aqVar2.an("obj_type", i2);
            } else {
                aqVar2.an("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                aqVar2.dX("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                aqVar2.dX("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            com.baidu.tbadk.pageExtra.c ft = d.ft(getContext());
            if (ft != null) {
                aqVar2.dX("obj_cur_page", ft.getCurrentPageKey());
            }
            if (d.bHm() != null) {
                aqVar2.dX("obj_pre_page", d.bHm());
            }
            TiebaStatic.log(aqVar2);
            dWS();
            if (this.nPM != null && i2 == 0) {
                this.nPM.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.nPK.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.nPK.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.nPK.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.nPK.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.nPK.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.nPK.baijiahaoData.oriUgcType);
            }
            if (ft != null) {
                httpMessage.addParam("obj_source", ft.getCurrentPageKey());
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.nPK.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.nPK.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.nPK));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.nPK != null && !StringUtils.isNull(this.nPK.video_url)) {
            this.mHasInit = true;
            if (this.evx) {
                cuI();
                aUD();
                if (this.nPK != null && this.mRect != null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dX("tid", this.nPK.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.an("obj_type", 0);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            aUC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        aUC();
        if (this.nPY != null && this.nPY.bEI() != null) {
            this.nPY.bEI().hide();
            this.nPO.setVisibility(0);
            this.nPP.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nPY.bEI().sv(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        stopPlay();
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        if (this.nPY != null) {
            this.nPY.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.evx = z;
        if (!z && this.nPY != null) {
            this.nPP.setText(R.string.reply_something);
            this.nPY.cJs();
        }
        if (this.mHasInit) {
            if (this.evx && (!this.nPX || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.nPK != null && this.mRect == null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dX("tid", this.nPK.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.an("obj_type", 1);
                    TiebaStatic.log(aqVar);
                }
                startPlay();
                dWP();
                this.nPX = false;
                return;
            }
            dWO();
            this.playTime = 1;
            aUC();
        }
    }

    private void dWP() {
        if (this.nPK != null) {
            aq aqVar = new aq("c12590");
            aqVar.dX("tid", this.nPK.thread_id);
            aqVar.dX(IntentConfig.NID, this.nPK.nid);
            aqVar.dX("fid", this.nPK.forum_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.an("obj_locate", this.nPR);
            aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dX("obj_param1", at.isEmpty(this.nPK.mRecomWeight) ? "0" : this.nPK.mRecomWeight);
            aqVar.dX("extra", at.isEmpty(this.nPK.mRecomExtra) ? "0" : this.nPK.mRecomExtra);
            aqVar.dX("obj_id", this.eQd);
            aqVar.dX("ab_tag", at.isEmpty(this.nPK.mRecomAbTag) ? "0" : this.nPK.mRecomAbTag);
            aqVar.dX("obj_source", at.isEmpty(this.nPK.mRecomSource) ? "0" : this.nPK.mRecomSource);
            aqVar.dX("obj_type", this.mFromPage);
            aqVar.an("is_vertical", 1);
            if (this.nPK.baijiahaoData != null) {
                aqVar.dX("obj_param4", this.nPK.baijiahaoData.oriUgcNid);
                aqVar.dX("obj_param6", this.nPK.baijiahaoData.oriUgcVid);
                if (this.nPK.baijiahaoData.oriUgcType == 4) {
                    aqVar.an("obj_param5", 2);
                } else if (this.nPK.baijiahaoData.oriUgcType == 2) {
                    aqVar.an("obj_param5", 3);
                }
            } else {
                aqVar.an("obj_param5", 1);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void UQ(String str) {
        if (this.gBU != null && str != null && !str.equals(this.mVideoUrl)) {
            this.gBU.setVideoPath(str, this.nPK.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dWW()) {
            dBo();
            if (this.nPG != null) {
                this.nPG.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.nPs.getVisibility() == 0) {
                this.nPs.clearAnimation();
                this.nPs.startAnimation(this.gEX);
            }
            if (this.gBU != null) {
                if (TbVideoViewSet.dCd().QW(this.mVideoUrl) == null || TbVideoViewSet.dCd().QW(this.mVideoUrl) != this.gBU) {
                    this.gBU.setVideoPath(this.mVideoUrl, this.nPK.thread_id);
                }
                this.gBU.start();
                cuI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuI() {
        if (this.nPK != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.anD = this.nPK.thread_id;
            oVar.eVY = this.nPK.nid;
            oVar.fPy = this.nPK.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.nPK.mRecomSource;
            oVar.mDH = this.nPK.mRecomAbTag;
            oVar.mDI = this.nPK.mRecomWeight;
            oVar.mDJ = "";
            oVar.eQd = "";
            oVar.mDM = this.nPK.mMd5;
            if (this.mRect != null) {
                oVar.mDN = "1";
            } else {
                oVar.mDN = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.mDO = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.mDJ = "index";
            }
            h.a(this.nPK.mMd5, "", "1", oVar, this.gBU.getPcdnState());
        }
    }

    private void dBo() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.f.dTD().gY(getContext());
        }
    }

    private void aUC() {
        if (this.gBU != null) {
            this.gBU.pause();
        }
    }

    private void stopPlay() {
        if (this.gBU != null) {
            this.gBU.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWQ() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.nPK.thread_id, this.nPK.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.nPK.forum_id));
        createNormalCfg.setForumName(this.nPK.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.nPK.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWR() {
        if (this.eKt == null) {
            this.nPS = new com.baidu.tieba.view.a(getActivity());
            this.eKt = new e(getActivity(), this.nPS.bur());
            this.eKt.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.gBU.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.nPS != null) {
            ArrayList arrayList = new ArrayList();
            a.C0871a c0871a = new a.C0871a(this.nPS);
            c0871a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bg.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.eKt.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.eKt.dismiss();
                    if (VideoPlayFragment.this.nPK != null) {
                        boolean z = VideoPlayFragment.this.nPK.post_id != null && VideoPlayFragment.this.nPK.post_id.equals(VideoPlayFragment.this.nPK.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.nPK.thread_id);
                        markData.setPostId(VideoPlayFragment.this.nPK.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.nPK.thread_id);
                        markData.setForumId(VideoPlayFragment.this.nPK.forum_id);
                        if (VideoPlayFragment.this.lNj != null) {
                            VideoPlayFragment.this.lNj.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.lNj.bnz();
                            } else {
                                VideoPlayFragment.this.lNj.bny();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.nPK != null && this.nPK.post_id != null && this.nPK.post_id.equals(this.nPK.mark_id)) {
                z = true;
            }
            if (z) {
                c0871a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0871a.setText(getResources().getString(R.string.mark));
            }
            if (this.nPK != null && !this.nPK.isBjhVideo) {
                arrayList.add(c0871a);
            }
            a.C0871a c0871a2 = new a.C0871a(getActivity().getString(R.string.delete), this.nPS);
            c0871a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.eKt.dismiss();
                    if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nPK != null) {
                        String str = VideoPlayFragment.this.nPK.thread_id;
                        String str2 = VideoPlayFragment.this.nPK.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.nPK.post_id;
                        if (VideoPlayFragment.this.nPK.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.nPK.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.nPK.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0871a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0871a2);
            if (this.hli) {
                a.C0871a c0871a3 = new a.C0871a(getActivity().getString(R.string.delete), this.nPS);
                c0871a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.eKt.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.pa(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.nPK != null) {
                                    VideoPlayFragment.this.ggJ.a(VideoPlayFragment.this.nPK.forum_id, VideoPlayFragment.this.nPK.forum_name, VideoPlayFragment.this.nPK.thread_id, VideoPlayFragment.this.nPK.post_id, 0, 0, VideoPlayFragment.this.hli, null);
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
                        aVar.jH(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.btX();
                    }
                });
                c0871a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0871a3);
            }
            this.nPS.bB(arrayList);
        }
        this.eKt.show();
    }

    private void dWS() {
        if (this.nPK != null) {
            this.nPs.startLoad(this.nPK.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.nPK.title);
            if (StringUtils.isNull(this.nPK.title) || matcher.matches()) {
                this.nPB.setVisibility(8);
            } else {
                this.nPB.setVisibility(0);
                this.nPB.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.nPB.setTextColor(R.color.CAM_X0101);
                this.nPB.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.nPB.setExpandable(true);
                this.nPB.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void rD(boolean z) {
                        VideoPlayFragment.this.nPK.isTitleExpanded = z;
                    }
                });
                this.nPB.setData(this.nPK.title, this.nPK.isTitleExpanded);
            }
            this.nPD.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nPK.comment_num, 0L)));
            this.nPE.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nPK.agree_num, 0L)));
            this.nPF.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nPK.share_num, 0L)));
            if (this.nPK.author_info != null) {
                if (!TextUtils.isEmpty(this.nPK.author_info.bjhAvatar)) {
                    this.nPu.startLoad(this.nPK.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.nPK.author_info.portrait) && this.nPK.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.nPu.startLoad(this.nPK.author_info.portrait, 10, false);
                } else {
                    this.nPu.startLoad(this.nPK.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.nPK.author_info.dTy())) {
                    this.nPN.setVisibility(8);
                } else {
                    this.nPN.setVisibility(0);
                    this.nPN.setText("@" + this.nPK.author_info.dTy());
                }
            }
            if ("1".equals(this.nPK.is_private) && this.nPL.getVisibility() != 0) {
                this.nPJ.setVisibility(0);
            } else {
                this.nPJ.setVisibility(8);
            }
            if ("1".equals(this.nPK.is_agreed)) {
                ao.setImageResource(this.nPM, R.drawable.icon_card_like_white_full_s);
            } else {
                ao.setImageResource(this.nPM, R.drawable.btn_video_agree);
            }
            if (this.nPK.act_info != null && !StringUtils.isNull(this.nPK.act_info.activity_name) && this.nPL.getVisibility() != 0) {
                this.nPI.setVisibility(0);
                this.nPC.setText(this.nPK.act_info.activity_name);
            } else {
                this.nPI.setVisibility(8);
            }
            dWU();
            if (this.nPK.isBjhVideo) {
                this.nPt.setVisibility(8);
            } else {
                this.nPt.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWT() {
        if (this.nPK != null) {
            if ("1".equals(this.nPK.is_agreed)) {
                ao.setImageResource(this.nPM, R.drawable.icon_card_like_white_full_s);
            } else {
                ao.setImageResource(this.nPM, R.drawable.btn_video_agree);
            }
            this.nPE.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nPK.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWU() {
        if (this.hli || (this.nPK.author_info != null && "1".equals(this.nPK.author_info.is_follow))) {
            this.nPy.setVisibility(4);
            this.nPy.setClickable(false);
            return;
        }
        this.nPy.setVisibility(0);
        this.nPy.setClickable(true);
    }

    private void dWV() {
        if (getActivity() != null) {
            if (this.nQa == null || !this.nQa.isShowing()) {
                this.nQa = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.bwq().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
                this.nQa.br(inflate);
                this.nQa.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.nQa.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.nQa.pd(1);
                this.nQa.pb(R.color.CAM_X0105);
                this.nQa.jH(true);
                this.nQa.b(getPageContext());
                this.nQa.btX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dWW() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.f.dTD().dTE() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !com.baidu.adp.lib.util.j.isMobileNet() || !this.evx) {
            return false;
        }
        if (this.nPG != null) {
            this.nPG.setVisibility(0);
        }
        aUC();
        dWV();
        return true;
    }

    private void aUD() {
        if (!dWW() && this.gBU != null && this.nPG != null && this.nPK != null) {
            if (this.gBU.getParent() == null) {
                dXb();
                dXc();
            }
            if (TbVideoViewSet.dCd().QW(this.mVideoUrl) == null || TbVideoViewSet.dCd().QW(this.mVideoUrl) != this.gBU) {
                this.gBU.setVideoPath(this.mVideoUrl, this.nPK.thread_id);
            }
            this.gBU.a((TbVideoViewSet.a) null);
            this.nPG.setVisibility(8);
            dBo();
            if (this.nPZ != null) {
                this.nPZ.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.nPT == null) {
            this.nPT = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.nPT;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0608a
    public void bMq() {
        if (this.gBU.isPlaying()) {
            this.gBU.pause();
            this.nPG.setVisibility(0);
        } else if (!dWW()) {
            this.gBU.start();
            this.nPG.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0608a
    public void y(float f, float f2) {
        if (bg.checkUpIsLogin(getActivity()) && !this.nPU) {
            dWX();
            if (this.nPK != null && "0".equals(this.nPK.is_agreed)) {
                Mf(this.nPr);
            }
        }
    }

    private void dWX() {
        if (this.mRootView != null) {
            this.nPU = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.nPW == null) {
                this.nPW = new RelativeLayout.LayoutParams(-2, -2);
                this.nPW.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.nPW);
            }
            if (this.nPV == null) {
                this.nPV = new AnimatorSet();
                this.nPV.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.nPU = false;
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
            this.nPV.setTarget(imageView);
            this.nPV.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.nPV.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0608a
    public void bMr() {
        if (this.nPK != null && this.nPK.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.nPK.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dWY() {
        return null;
    }

    public String dWZ() {
        return null;
    }

    public boolean dXa() {
        if (this.nPY == null || this.nPY.bEI() == null || !this.nPY.bEI().isVisible()) {
            return false;
        }
        this.nPY.bEI().hide();
        this.nPO.setVisibility(0);
        if ((this.nPY.bEI().sv(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.nPY.bEI().sv(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.nPY.bEI().sv(28)).getInputView().getText() != null) {
            this.nPP.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nPY.bEI().sv(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.nPY != null) {
            this.nPY.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        c(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nPY != null && this.nPY.bEI() != null) {
            this.nPY.bEI().onChangeSkinType(i);
        }
        SvgManager.bwq().a(this.aHx, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dXb() {
        if (this.gBU != null && this.gBU.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.gBU.getView(), 0);
            this.gBU.getView().setLayoutParams(layoutParams);
            if (this.nPK != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.anD = this.nPK.thread_id;
                oVar.eVY = this.nPK.nid;
                oVar.fPy = this.nPK.forum_id;
                oVar.mDM = this.nPK.mMd5;
                oVar.eQd = "";
                oVar.mSource = this.nPK.mRecomSource;
                oVar.mDL = this.nPK.mRecomAbTag;
                oVar.mDK = 1;
                if (this.nPK.baijiahaoData != null) {
                    if (this.nPK.baijiahaoData.oriUgcType == 2) {
                        oVar.mDK = 3;
                    } else if (this.nPK.baijiahaoData.oriUgcType == 4) {
                        oVar.mDK = 2;
                    }
                }
                oVar.mDI = this.nPK.mRecomWeight;
                if (this.mRect != null) {
                    oVar.mDN = "1";
                } else {
                    oVar.mDN = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.mDO = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.mDJ = this.mFromPage;
                    oVar.eQd = this.eQd;
                    oVar.mDH = this.nPK.mRecomWeight;
                } else {
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
                }
                this.gBU.setVideoStatData(oVar);
                this.gBU.setLocateSource("v_mid_page");
            }
            this.gBU.setContinuePlayEnable(true);
        }
    }

    private void dXc() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.gBU.setOnPreparedListener(this.nQb);
        }
        this.gBU.setOnCompletionListener(this.mEt);
        this.gBU.setOnInfoListener(this.mEv);
    }
}
