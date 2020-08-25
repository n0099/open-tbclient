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
/* loaded from: classes18.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0566a {
    public ImageView aBA;
    private boolean dEd;
    private e dSQ;
    private String dYo;
    public TbCyberVideoView fDL;
    private AlphaAnimation fGH;
    private boolean ghr;
    private int hVe;
    private View htD;
    private f.b lsf;
    private TbImageView mEH;
    public ImageView mEI;
    public HeadImageView mEJ;
    public LinearLayout mEK;
    public LinearLayout mEL;
    public LinearLayout mEM;
    public ImageView mEN;
    public ImageView mEO;
    public ImageView mEP;
    public ExpandableTextView mEQ;
    public TextView mER;
    public TextView mES;
    public TextView mET;
    public TextView mEU;
    public ImageView mEV;
    private LinearLayout mEW;
    public LinearLayout mEX;
    public LinearLayout mEY;
    public VideoItemData mEZ;
    private TextView mFa;
    public ImageView mFb;
    public TextView mFc;
    private View mFe;
    private TextView mFf;
    private int mFg;
    private int mFh;
    private com.baidu.tieba.view.a mFi;
    protected Animation mFj;
    private boolean mFk;
    private AnimatorSet mFl;
    private RelativeLayout.LayoutParams mFm;
    private com.baidu.tieba.videoplay.editor.a mFo;
    private a mFp;
    com.baidu.tbadk.core.dialog.a mFq;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int mEF = 0;
    private int mEG = 1;
    private ForumManageModel hkv = null;
    private com.baidu.tbadk.baseEditMark.a kDx = null;
    private com.baidu.tbadk.coreExtra.model.a ekD = null;
    private BdUniqueId ahK = BdUniqueId.gen();
    private boolean mFn = false;
    private int playTime = 1;
    private CustomMessageListener ekH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.mEZ != null && VideoPlayFragment.this.mEZ.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.mEZ.author_info.user_id) && data != null && VideoPlayFragment.this.mEZ.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.ahK)) ? false : false;
                    if (data.eCa == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.mEZ.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.mEZ.author_info.is_follow = "0";
                                VideoPlayFragment.this.dEy();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.dEd) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.mEZ));
                                } else {
                                    VideoPlayFragment.this.mEZ.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dEy();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.mEZ.author_info.is_follow = "0";
                            VideoPlayFragment.this.dEy();
                        }
                        aq aqVar = new aq("c13570");
                        aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                        if ("index".equals(VideoPlayFragment.this.mFromPage)) {
                            aqVar.dD("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                            aqVar.dD("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        }
    };
    private final CustomMessageListener dUu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.dEA();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.mEZ != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.mEZ.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.mEZ.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.mEZ.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.mEZ.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dEx();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.mEZ.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.mEZ.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.mEZ.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dEx();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnInfoListener ltR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.dEd) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.mEH.getVisibility() == 0) {
                    VideoPlayFragment.this.mEH.clearAnimation();
                    VideoPlayFragment.this.mEH.startAnimation(VideoPlayFragment.this.fGH);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener ltP = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.fDL != null) {
                VideoPlayFragment.this.fDL.dkq();
                VideoPlayFragment.this.fDL.seekTo(0);
                VideoPlayFragment.this.fDL.start();
                VideoPlayFragment.this.cbF();
                VideoPlayFragment.A(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dEr();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener mFr = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.fDL != null) {
                VideoPlayFragment.this.fDL.setVolume(1.0f, 1.0f);
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
        this.mEZ = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.mFh = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.dYo = arguments.getString("obj_id");
        if (this.mEZ != null && this.mEZ.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.mEZ.author_info.user_id)) {
            this.ghr = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.fDL = new TbCyberVideoView(getContext());
        this.fDL.setStageType("2005");
        this.fDL.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.f.b
            public void bX(int i, int i2) {
                if (VideoPlayFragment.this.lsf != null) {
                    VideoPlayFragment.this.lsf.bX(i, i2);
                }
            }
        });
        dEF();
        this.mEH = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.mEH.setPlaceHolder(4);
        this.mEH.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.biu()) {
            this.htD = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.htD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.htD.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aBA = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.mEI = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.mEJ = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.mEJ.setDefaultResource(17170445);
        this.mEJ.setPlaceHolder(2);
        this.mEJ.setIsRound(true);
        this.mEN = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.mFb = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.mEQ = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.mER = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.mEL = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.mES = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.mEK = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.mET = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.mEU = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.mEO = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.mEP = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dEs();
        this.mEV = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.mEW = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.mEX = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.mEY = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.mEM = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.mFc = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.mFe = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.mFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.mFe.setVisibility(4);
                    if (VideoPlayFragment.this.mFo != null && VideoPlayFragment.this.mFo.brv() != null) {
                        VideoPlayFragment.this.mFo.brv().display();
                        if (VideoPlayFragment.this.mEZ != null) {
                            VideoPlayFragment.this.mFo.c(VideoPlayFragment.this.mEZ);
                        }
                    }
                    if (VideoPlayFragment.this.mEZ != null) {
                        aq aqVar = new aq("c13025");
                        aqVar.dD("tid", VideoPlayFragment.this.mEZ.thread_id);
                        aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar.dD("fid", VideoPlayFragment.this.mEZ.forum_id);
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        });
        this.mFf = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.mFa = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.mFa.setVisibility(8);
        String string = b.bik().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.mFa.setText(string);
        }
        final String string2 = b.bik().getString("nani_key_download_link_url", null);
        this.mFa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    be.bju().a((TbPageContext) i.I(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dEw();
        this.mEJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mEZ != null && VideoPlayFragment.this.mEZ.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.mEZ.author_info.user_id) && VideoPlayFragment.this.mEZ != null && VideoPlayFragment.this.mEZ.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.mEZ.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    aq aqVar = new aq("c12798");
                    aqVar.dD("tid", VideoPlayFragment.this.mEZ.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.mEX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mEZ != null && VideoPlayFragment.this.mEZ.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.mEZ.act_info.link_url);
                    aq aqVar = new aq("c12799");
                    aqVar.dD("tid", VideoPlayFragment.this.mEZ.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.mEQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dEu();
            }
        });
        this.aBA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mEZ != null && !StringUtils.isNull(VideoPlayFragment.this.mEZ.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.mEZ.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.mEI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dEv();
            }
        });
        this.mEL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.mEZ)) {
                    VideoPlayFragment.this.dEu();
                    aq aqVar = new aq("c12796");
                    aqVar.dD("tid", VideoPlayFragment.this.mEZ.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.mEK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Ji(VideoPlayFragment.this.mEF);
            }
        });
        this.mEM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bkV();
                aq aqVar = new aq("c12797");
                aqVar.dD("tid", VideoPlayFragment.this.mEZ.thread_id);
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar);
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dD("tid", VideoPlayFragment.this.mEZ.thread_id);
                aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.ai("obj_locate", 19);
                aqVar2.dD("nid", VideoPlayFragment.this.mEZ.nid);
                if (VideoPlayFragment.this.mEZ.baijiahaoData != null && !at.isEmpty(VideoPlayFragment.this.mEZ.baijiahaoData.oriUgcVid)) {
                    aqVar2.dD("obj_param6", VideoPlayFragment.this.mEZ.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.mEZ.getVideoType() == 1) {
                    aqVar2.ai(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.mEZ.getVideoType() == 2) {
                    aqVar2.ai(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.mEZ.getVideoType() == 3) {
                    aqVar2.ai(IntentConfig.CARD_TYPE, 6);
                }
                aqVar2.dD(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.mEZ.mRecomSource);
                aqVar2.dD("ab_tag", VideoPlayFragment.this.mEZ.mRecomAbTag);
                aqVar2.dD("weight", VideoPlayFragment.this.mEZ.mRecomWeight);
                aqVar2.dD("extra", VideoPlayFragment.this.mEZ.mRecomExtra);
                aqVar2.dD("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.ej(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.ej(VideoPlayFragment.this.getBaseFragmentActivity()).btW() != null && c.ej(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.ej(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    aqVar2.dD("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    aqVar2.dD("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(aqVar2);
            }
        });
        this.mEN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.mEZ != null && VideoPlayFragment.this.mEZ.author_info != null) {
                    VideoPlayFragment.this.ekD.a(true, VideoPlayFragment.this.mEZ.author_info.portrait, VideoPlayFragment.this.mEZ.author_info.user_id, false, "6", VideoPlayFragment.this.ahK, VideoPlayFragment.this.mEZ.forum_id, "0");
                    VideoPlayFragment.this.mEZ.author_info.is_follow = "1";
                    VideoPlayFragment.this.dEy();
                }
            }
        });
        this.fGH = new AlphaAnimation(1.0f, 0.0f);
        this.fGH.setDuration(100L);
        this.fGH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.mEH != null) {
                    VideoPlayFragment.this.mEH.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mFg = this.mRect.right - this.mRect.left;
            this.hVe = this.mRect.bottom - this.mRect.top;
            this.mEH.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.mEH.getWidth();
                    int height = VideoPlayFragment.this.mEH.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mEZ.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mEZ.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mEZ.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mEZ.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mFg, VideoPlayFragment.this.hVe);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.mEH.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hVe > 0 || VideoPlayFragment.this.mFg <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mFg;
                                f = i / VideoPlayFragment.this.hVe;
                            }
                            VideoPlayFragment.this.mEH.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.mEH.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.dEd) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mFg, VideoPlayFragment.this.hVe);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.mEH.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hVe > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.mEH.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.mEH.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.dEd) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.mEH.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.mEH.getWidth();
                    int height = VideoPlayFragment.this.mEH.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mEZ.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mEZ.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mEZ.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mEZ.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.mEH.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.mEH.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cKE();
        if (this.dEd) {
            dEt();
        }
        if (this.mEZ != null && !StringUtils.isNull(this.mEZ.video_url)) {
            setVideoInfo(this.mEZ.video_url);
        }
        return this.mRootView;
    }

    public void a(f.b bVar) {
        this.lsf = bVar;
    }

    public void a(a aVar) {
        this.mFp = aVar;
    }

    private void cKE() {
        this.mFo = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().ec(getActivity());
        if (this.mFo != null && this.mEZ != null) {
            this.mFo.a(getPageContext());
            this.mFo.az(this.mEZ.thread_id, this.mEZ.forum_id, this.mEZ.forum_name);
            this.mFo.a(new a.InterfaceC0823a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0823a
                public void wQ(boolean z) {
                    VideoPlayFragment.this.mFe.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.mFf.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.mFf.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.mFo.brv().qe(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.mEZ != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.mEZ.comment_num, 0L) + 1;
                        VideoPlayFragment.this.mEZ.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.mES.setText(at.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.mFo.brv(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkV() {
        String str;
        String str2;
        if (this.mEZ != null) {
            String str3 = this.mEZ.forum_id;
            String str4 = this.mEZ.forum_name;
            String str5 = this.mEZ.title;
            if (this.mEZ.baijiahaoData != null) {
                str = this.mEZ.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.mEZ.baijiahaoData.oriUgcType + "&dvid=" + this.mEZ.baijiahaoData.oriUgcVid + "&nid=" + this.mEZ.baijiahaoData.oriUgcNid;
            } else {
                str = this.mEZ.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.mEZ.thumbnail_url;
            String format = (!this.mEZ.isBjhVideo || this.mEZ.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.mEZ.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.mEZ.baijiahaoData == null) {
                shareItem.readCount = this.mEZ.play_count;
            }
            if (this.mEZ.isBjhVideo) {
                shareItem.eEq = format;
            } else {
                shareItem.eEq = "";
            }
            shareItem.linkUrl = str6;
            shareItem.eeB = 2;
            shareItem.extData = str;
            shareItem.eEt = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.eEf = true;
            shareItem.eEs = 12;
            if (this.mEZ.getVideoType() == 1) {
                shareItem.eEx = 2;
            } else if (this.mEZ.getVideoType() == 2) {
                shareItem.eEx = 8;
            } else if (this.mEZ.getVideoType() == 3) {
                shareItem.eEx = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.mEZ.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.mEZ.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.mEZ.title;
            originalThreadInfo.threadId = this.mEZ.thread_id;
            originalThreadInfo.oriUgcInfo = this.mEZ.baijiahaoData;
            shareItem.eEA = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eEt);
            bundle.putInt("obj_type", shareItem.eEx);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eeB);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.f.cdb().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.ghr) {
            this.hkv = new ForumManageModel(getPageContext());
            this.hkv.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.hkv.getLoadDataMode()) {
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
        this.kDx = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.kDx != null) {
            this.kDx.a(new a.InterfaceC0535a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0535a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.kDx != null) {
                            VideoPlayFragment.this.kDx.hA(z2);
                        }
                        if (VideoPlayFragment.this.mEZ != null) {
                            if (z2) {
                                VideoPlayFragment.this.mEZ.mark_id = VideoPlayFragment.this.mEZ.post_id;
                            } else {
                                VideoPlayFragment.this.mEZ.mark_id = null;
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
        this.ekD = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.ekH);
        registerListener(this.dUu);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.mFn = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dEw();
        dEG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEr() {
        if (this.mEP != null && this.mEO != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.mEO.clearAnimation();
            this.mEP.clearAnimation();
            this.mEO.setVisibility(8);
            this.mEP.setVisibility(0);
            this.mEP.startAnimation(scaleAnimation2);
            this.mEO.startAnimation(scaleAnimation);
        }
    }

    private void dEs() {
        if (this.mEP != null && this.mEO != null) {
            this.mEO.clearAnimation();
            this.mEP.clearAnimation();
            this.mEO.setVisibility(0);
            this.mEP.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ji(int i) {
        int i2;
        if (bg.checkUpIsLogin(getActivity()) && this.mEZ != null) {
            if (i == this.mEF) {
                if ("1".equals(this.mEZ.is_agreed)) {
                    i2 = 1;
                    this.mEZ.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mEZ.agree_num, 0) - 1);
                    this.mEZ.is_agreed = "0";
                } else {
                    this.mEZ.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mEZ.agree_num, 0) + 1);
                    this.mEZ.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.mEZ.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mEZ.agree_num, 0) + 1);
                this.mEZ.is_agreed = "1";
                i2 = 0;
            }
            aq aqVar = new aq("c12795");
            aqVar.dD("tid", this.mEZ.thread_id);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.mEF) {
                aqVar.ai("obj_type", i2);
            } else {
                aqVar.ai("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12003");
            aqVar2.dD("tid", this.mEZ.thread_id);
            aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.mEF) {
                aqVar2.ai("obj_type", i2);
            } else {
                aqVar2.ai("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                aqVar2.dD("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                aqVar2.dD("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            TiebaStatic.log(aqVar2);
            dEw();
            if (this.mFb != null && i2 == 0) {
                this.mFb.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.mEZ.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.mEZ.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.mEZ.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.mEZ.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.mEZ.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.mEZ.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.mEZ.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.mEZ.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.mEZ));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.mEZ != null && !StringUtils.isNull(this.mEZ.video_url)) {
            this.mHasInit = true;
            if (this.dEd) {
                cbF();
                aHY();
                if (this.mEZ != null && this.mRect != null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dD("tid", this.mEZ.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.ai("obj_type", 0);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            aHX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        aHX();
        if (this.mFo != null && this.mFo.brv() != null) {
            this.mFo.brv().hide();
            this.mFe.setVisibility(0);
            this.mFf.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.mFo.brv().qe(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.mFo != null) {
            this.mFo.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.dEd = z;
        if (!z && this.mFo != null) {
            this.mFf.setText(R.string.reply_something);
            this.mFo.cqc();
        }
        if (this.mHasInit) {
            if (this.dEd && (!this.mFn || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.mEZ != null && this.mRect == null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dD("tid", this.mEZ.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.ai("obj_type", 1);
                    TiebaStatic.log(aqVar);
                }
                startPlay();
                dEt();
                this.mFn = false;
                return;
            }
            dEs();
            this.playTime = 1;
            aHX();
        }
    }

    private void dEt() {
        if (this.mEZ != null) {
            aq aqVar = new aq("c12590");
            aqVar.dD("tid", this.mEZ.thread_id);
            aqVar.dD("nid", this.mEZ.nid);
            aqVar.dD("fid", this.mEZ.forum_id);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.ai("obj_locate", this.mFh);
            aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dD("obj_param1", at.isEmpty(this.mEZ.mRecomWeight) ? "0" : this.mEZ.mRecomWeight);
            aqVar.dD("extra", at.isEmpty(this.mEZ.mRecomExtra) ? "0" : this.mEZ.mRecomExtra);
            aqVar.dD("obj_id", this.dYo);
            aqVar.dD("ab_tag", at.isEmpty(this.mEZ.mRecomAbTag) ? "0" : this.mEZ.mRecomAbTag);
            aqVar.dD("obj_source", at.isEmpty(this.mEZ.mRecomSource) ? "0" : this.mEZ.mRecomSource);
            aqVar.dD("obj_type", this.mFromPage);
            aqVar.ai("is_vertical", 1);
            if (this.mEZ.baijiahaoData != null) {
                aqVar.dD("obj_param4", this.mEZ.baijiahaoData.oriUgcNid);
                aqVar.dD("obj_param6", this.mEZ.baijiahaoData.oriUgcVid);
                if (this.mEZ.baijiahaoData.oriUgcType == 4) {
                    aqVar.ai("obj_param5", 2);
                } else if (this.mEZ.baijiahaoData.oriUgcType == 2) {
                    aqVar.ai("obj_param5", 3);
                }
            } else {
                aqVar.ai("obj_param5", 1);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.fDL != null && str != null && !str.equals(this.mVideoUrl)) {
            this.fDL.setVideoPath(str, this.mEZ.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dEA()) {
            djD();
            if (this.mEV != null) {
                this.mEV.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.mEH.getVisibility() == 0) {
                this.mEH.clearAnimation();
                this.mEH.startAnimation(this.fGH);
            }
            if (this.fDL != null) {
                if (TbVideoViewSet.dkr().OG(this.mVideoUrl) == null || TbVideoViewSet.dkr().OG(this.mVideoUrl) != this.fDL) {
                    this.fDL.setVideoPath(this.mVideoUrl, this.mEZ.thread_id);
                }
                this.fDL.start();
                cbF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbF() {
        if (this.mEZ != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.akY = this.mEZ.thread_id;
            oVar.mNid = this.mEZ.nid;
            oVar.eVt = this.mEZ.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.mEZ.mRecomSource;
            oVar.ltc = this.mEZ.mRecomAbTag;
            oVar.ltd = this.mEZ.mRecomWeight;
            oVar.lte = "";
            oVar.dYo = "";
            oVar.lth = this.mEZ.mMd5;
            if (this.mRect != null) {
                oVar.lti = "1";
            } else {
                oVar.lti = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.ltj = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.lte = "index";
            }
            h.a(this.mEZ.mMd5, "", "1", oVar, this.fDL.getPcdnState());
        }
    }

    private void djD() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dAV().fI(getContext());
        }
    }

    private void aHX() {
        if (this.fDL != null) {
            this.fDL.pause();
        }
    }

    private void stopPlay() {
        if (this.fDL != null) {
            this.fDL.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEu() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.mEZ.thread_id, this.mEZ.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.mEZ.forum_id));
        createNormalCfg.setForumName(this.mEZ.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.mEZ.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEv() {
        if (this.dSQ == null) {
            this.mFi = new com.baidu.tieba.view.a(getActivity());
            this.dSQ = new e(getActivity(), this.mFi.bhw());
            this.dSQ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.fDL.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.mFi != null) {
            ArrayList arrayList = new ArrayList();
            a.C0825a c0825a = new a.C0825a(this.mFi);
            c0825a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bg.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.dSQ.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.dSQ.dismiss();
                    if (VideoPlayFragment.this.mEZ != null) {
                        boolean z = VideoPlayFragment.this.mEZ.post_id != null && VideoPlayFragment.this.mEZ.post_id.equals(VideoPlayFragment.this.mEZ.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.mEZ.thread_id);
                        markData.setPostId(VideoPlayFragment.this.mEZ.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.mEZ.thread_id);
                        markData.setForumId(VideoPlayFragment.this.mEZ.forum_id);
                        if (VideoPlayFragment.this.kDx != null) {
                            VideoPlayFragment.this.kDx.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.kDx.baC();
                            } else {
                                VideoPlayFragment.this.kDx.baB();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.mEZ != null && this.mEZ.post_id != null && this.mEZ.post_id.equals(this.mEZ.mark_id)) {
                z = true;
            }
            if (z) {
                c0825a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0825a.setText(getResources().getString(R.string.mark));
            }
            if (this.mEZ != null && !this.mEZ.isBjhVideo) {
                arrayList.add(c0825a);
            }
            a.C0825a c0825a2 = new a.C0825a(getActivity().getString(R.string.delete), this.mFi);
            c0825a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.dSQ.dismiss();
                    if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.mEZ != null) {
                        String str = VideoPlayFragment.this.mEZ.thread_id;
                        String str2 = VideoPlayFragment.this.mEZ.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.mEZ.post_id;
                        if (VideoPlayFragment.this.mEZ.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.mEZ.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.mEZ.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0825a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0825a2);
            if (this.ghr) {
                a.C0825a c0825a3 = new a.C0825a(getActivity().getString(R.string.delete), this.mFi);
                c0825a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.dSQ.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.nt(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.mEZ != null) {
                                    VideoPlayFragment.this.hkv.a(VideoPlayFragment.this.mEZ.forum_id, VideoPlayFragment.this.mEZ.forum_name, VideoPlayFragment.this.mEZ.thread_id, VideoPlayFragment.this.mEZ.post_id, 0, 0, VideoPlayFragment.this.ghr, null);
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
                        aVar.m39if(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.bhg();
                    }
                });
                c0825a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0825a3);
            }
            this.mFi.aT(arrayList);
        }
        this.dSQ.show();
    }

    private void dEw() {
        if (this.mEZ != null) {
            this.mEH.startLoad(this.mEZ.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.mEZ.title);
            if (StringUtils.isNull(this.mEZ.title) || matcher.matches()) {
                this.mEQ.setVisibility(8);
            } else {
                this.mEQ.setVisibility(0);
                this.mEQ.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.mEQ.setTextColor(R.color.cp_cont_a);
                this.mEQ.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.mEQ.setExpandable(true);
                this.mEQ.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void pm(boolean z) {
                        VideoPlayFragment.this.mEZ.isTitleExpanded = z;
                    }
                });
                this.mEQ.setData(this.mEZ.title, this.mEZ.isTitleExpanded);
            }
            this.mES.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mEZ.comment_num, 0L)));
            this.mET.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mEZ.agree_num, 0L)));
            this.mEU.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mEZ.share_num, 0L)));
            if (this.mEZ.author_info != null) {
                if (!TextUtils.isEmpty(this.mEZ.author_info.bjhAvatar)) {
                    this.mEJ.startLoad(this.mEZ.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.mEZ.author_info.portrait) && this.mEZ.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.mEJ.startLoad(this.mEZ.author_info.portrait, 10, false);
                } else {
                    this.mEJ.startLoad(this.mEZ.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.mEZ.author_info.dAQ())) {
                    this.mFc.setVisibility(8);
                } else {
                    this.mFc.setVisibility(0);
                    this.mFc.setText(UgcConstant.AT_RULE_TAG + this.mEZ.author_info.dAQ());
                }
            }
            if ("1".equals(this.mEZ.is_private) && this.mFa.getVisibility() != 0) {
                this.mEY.setVisibility(0);
            } else {
                this.mEY.setVisibility(8);
            }
            if ("1".equals(this.mEZ.is_agreed)) {
                ap.setImageResource(this.mFb, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.mFb, R.drawable.btn_video_agree);
            }
            if (this.mEZ.act_info != null && !StringUtils.isNull(this.mEZ.act_info.activity_name) && this.mFa.getVisibility() != 0) {
                this.mEX.setVisibility(0);
                this.mER.setText(this.mEZ.act_info.activity_name);
            } else {
                this.mEX.setVisibility(8);
            }
            dEy();
            if (this.mEZ.isBjhVideo) {
                this.mEI.setVisibility(8);
            } else {
                this.mEI.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEx() {
        if (this.mEZ != null) {
            if ("1".equals(this.mEZ.is_agreed)) {
                ap.setImageResource(this.mFb, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.mFb, R.drawable.btn_video_agree);
            }
            this.mET.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mEZ.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEy() {
        if (this.ghr || (this.mEZ.author_info != null && !"0".equals(this.mEZ.author_info.is_follow))) {
            this.mEN.setVisibility(4);
            this.mEN.setClickable(false);
            return;
        }
        this.mEN.setVisibility(0);
        this.mEN.setClickable(true);
    }

    private void dEz() {
        if (getActivity() != null) {
            if (this.mFq == null || !this.mFq.isShowing()) {
                this.mFq = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.bjq().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.mFq.aX(inflate);
                this.mFq.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.mFq.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.mFq.nw(1);
                this.mFq.nu(R.color.cp_cont_b);
                this.mFq.m39if(true);
                this.mFq.b(getPageContext());
                this.mFq.bhg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dEA() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dAV().dAW() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet() || !this.dEd) {
            return false;
        }
        if (this.mEV != null) {
            this.mEV.setVisibility(0);
        }
        aHX();
        dEz();
        return true;
    }

    private void aHY() {
        if (!dEA() && this.fDL != null && this.mEV != null && this.mEZ != null) {
            if (this.fDL.getParent() == null) {
                dEF();
                dEG();
            }
            if (TbVideoViewSet.dkr().OG(this.mVideoUrl) == null || TbVideoViewSet.dkr().OG(this.mVideoUrl) != this.fDL) {
                this.fDL.setVideoPath(this.mVideoUrl, this.mEZ.thread_id);
            }
            this.fDL.a((TbVideoViewSet.a) null);
            this.mEV.setVisibility(8);
            djD();
            if (this.mFp != null) {
                this.mFp.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.mFj == null) {
            this.mFj = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.mFj;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0566a
    public void byT() {
        if (this.fDL.isPlaying()) {
            this.fDL.pause();
            this.mEV.setVisibility(0);
        } else if (!dEA()) {
            this.fDL.start();
            this.mEV.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0566a
    public void x(float f, float f2) {
        if (bg.checkUpIsLogin(getActivity()) && !this.mFk) {
            dEB();
            if (this.mEZ != null && "0".equals(this.mEZ.is_agreed)) {
                Ji(this.mEG);
            }
        }
    }

    private void dEB() {
        if (this.mRootView != null) {
            this.mFk = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.mFm == null) {
                this.mFm = new RelativeLayout.LayoutParams(-2, -2);
                this.mFm.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.mFm);
            }
            if (this.mFl == null) {
                this.mFl = new AnimatorSet();
                this.mFl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.mFk = false;
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
            this.mFl.setTarget(imageView);
            this.mFl.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.mFl.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0566a
    public void byU() {
        if (this.mEZ != null && this.mEZ.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.mEZ.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dEC() {
        return null;
    }

    public String dED() {
        return null;
    }

    public boolean dEE() {
        if (this.mFo == null || this.mFo.brv() == null || !this.mFo.brv().isVisible()) {
            return false;
        }
        this.mFo.brv().hide();
        this.mFe.setVisibility(0);
        if ((this.mFo.brv().qe(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.mFo.brv().qe(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.mFo.brv().qe(28)).getInputView().getText() != null) {
            this.mFf.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.mFo.brv().qe(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.mFo != null) {
            this.mFo.onActivityResult(i, i2, intent);
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
        if (this.mFo != null && this.mFo.brv() != null) {
            this.mFo.brv().onChangeSkinType(i);
        }
        SvgManager.bjq().a(this.aBA, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dEF() {
        if (this.fDL != null && this.fDL.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.fDL.getView(), 0);
            this.fDL.getView().setLayoutParams(layoutParams);
            if (this.mEZ != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.akY = this.mEZ.thread_id;
                oVar.mNid = this.mEZ.nid;
                oVar.eVt = this.mEZ.forum_id;
                oVar.lth = this.mEZ.mMd5;
                oVar.dYo = "";
                oVar.mSource = this.mEZ.mRecomSource;
                oVar.ltg = this.mEZ.mRecomAbTag;
                oVar.ltf = 1;
                if (this.mEZ.baijiahaoData != null) {
                    if (this.mEZ.baijiahaoData.oriUgcType == 2) {
                        oVar.ltf = 3;
                    } else if (this.mEZ.baijiahaoData.oriUgcType == 4) {
                        oVar.ltf = 2;
                    }
                }
                oVar.ltd = this.mEZ.mRecomWeight;
                if (this.mRect != null) {
                    oVar.lti = "1";
                } else {
                    oVar.lti = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.ltj = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.lte = this.mFromPage;
                    oVar.dYo = this.dYo;
                    oVar.ltc = this.mEZ.mRecomWeight;
                } else {
                    oVar.mLocate = "14";
                }
                this.fDL.setVideoStatData(oVar);
                this.fDL.setLocateSource("v_mid_page");
            }
            this.fDL.setContinuePlayEnable(true);
        }
    }

    private void dEG() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.fDL.setOnPreparedListener(this.mFr);
        }
        this.fDL.setOnCompletionListener(this.ltP);
        this.fDL.setOnInfoListener(this.ltR);
    }
}
