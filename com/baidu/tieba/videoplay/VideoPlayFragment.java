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
    public ImageView aBC;
    private boolean dEh;
    private e dSU;
    private String dYs;
    public TbCyberVideoView fDP;
    private AlphaAnimation fGL;
    private boolean ghv;
    private int hVk;
    private View htJ;
    private f.b lsq;
    private TbImageView mEZ;
    private com.baidu.tieba.view.a mFA;
    protected Animation mFB;
    private boolean mFC;
    private AnimatorSet mFD;
    private RelativeLayout.LayoutParams mFE;
    private com.baidu.tieba.videoplay.editor.a mFG;
    private a mFH;
    com.baidu.tbadk.core.dialog.a mFI;
    public ImageView mFa;
    public HeadImageView mFb;
    public LinearLayout mFc;
    public LinearLayout mFe;
    public LinearLayout mFf;
    public ImageView mFg;
    public ImageView mFh;
    public ImageView mFi;
    public ExpandableTextView mFj;
    public TextView mFk;
    public TextView mFl;
    public TextView mFm;
    public TextView mFn;
    public ImageView mFo;
    private LinearLayout mFp;
    public LinearLayout mFq;
    public LinearLayout mFr;
    private String mFrom;
    private String mFromPage;
    public VideoItemData mFs;
    private TextView mFt;
    public ImageView mFu;
    public TextView mFv;
    private View mFw;
    private TextView mFx;
    private int mFy;
    private int mFz;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int mEX = 0;
    private int mEY = 1;
    private ForumManageModel hkz = null;
    private com.baidu.tbadk.baseEditMark.a kDE = null;
    private com.baidu.tbadk.coreExtra.model.a ekH = null;
    private BdUniqueId ahM = BdUniqueId.gen();
    private boolean mFF = false;
    private int playTime = 1;
    private CustomMessageListener ekL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.mFs != null && VideoPlayFragment.this.mFs.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.mFs.author_info.user_id) && data != null && VideoPlayFragment.this.mFs.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.ahM)) ? false : false;
                    if (data.eCe == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.mFs.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.mFs.author_info.is_follow = "0";
                                VideoPlayFragment.this.dEH();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.dEh) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.mFs));
                                } else {
                                    VideoPlayFragment.this.mFs.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dEH();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.mFs.author_info.is_follow = "0";
                            VideoPlayFragment.this.dEH();
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
    private final CustomMessageListener dUy = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.dEJ();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.mFs != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.mFs.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.mFs.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.mFs.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.mFs.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dEG();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.mFs.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.mFs.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.mFs.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dEG();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnInfoListener luc = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.dEh) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.mEZ.getVisibility() == 0) {
                    VideoPlayFragment.this.mEZ.clearAnimation();
                    VideoPlayFragment.this.mEZ.startAnimation(VideoPlayFragment.this.fGL);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener lua = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.fDP != null) {
                VideoPlayFragment.this.fDP.dkt();
                VideoPlayFragment.this.fDP.seekTo(0);
                VideoPlayFragment.this.fDP.start();
                VideoPlayFragment.this.cbG();
                VideoPlayFragment.A(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dEA();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener mFJ = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.fDP != null) {
                VideoPlayFragment.this.fDP.setVolume(1.0f, 1.0f);
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
        this.mFs = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.mFz = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.dYs = arguments.getString("obj_id");
        if (this.mFs != null && this.mFs.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.mFs.author_info.user_id)) {
            this.ghv = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.fDP = new TbCyberVideoView(getContext());
        this.fDP.setStageType("2005");
        this.fDP.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.f.b
            public void bX(int i, int i2) {
                if (VideoPlayFragment.this.lsq != null) {
                    VideoPlayFragment.this.lsq.bX(i, i2);
                }
            }
        });
        dEO();
        this.mEZ = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.mEZ.setPlaceHolder(4);
        this.mEZ.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.biu()) {
            this.htJ = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.htJ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.htJ.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aBC = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.mFa = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.mFb = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.mFb.setDefaultResource(17170445);
        this.mFb.setPlaceHolder(2);
        this.mFb.setIsRound(true);
        this.mFg = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.mFu = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.mFj = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.mFk = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.mFe = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.mFl = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.mFc = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.mFm = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.mFn = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.mFh = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.mFi = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dEB();
        this.mFo = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.mFp = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.mFq = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.mFr = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.mFf = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.mFv = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.mFw = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.mFw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.mFw.setVisibility(4);
                    if (VideoPlayFragment.this.mFG != null && VideoPlayFragment.this.mFG.brw() != null) {
                        VideoPlayFragment.this.mFG.brw().display();
                        if (VideoPlayFragment.this.mFs != null) {
                            VideoPlayFragment.this.mFG.c(VideoPlayFragment.this.mFs);
                        }
                    }
                    if (VideoPlayFragment.this.mFs != null) {
                        aq aqVar = new aq("c13025");
                        aqVar.dD("tid", VideoPlayFragment.this.mFs.thread_id);
                        aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar.dD("fid", VideoPlayFragment.this.mFs.forum_id);
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        });
        this.mFx = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.mFt = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.mFt.setVisibility(8);
        String string = b.bik().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.mFt.setText(string);
        }
        final String string2 = b.bik().getString("nani_key_download_link_url", null);
        this.mFt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    be.bju().a((TbPageContext) i.I(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dEF();
        this.mFb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mFs != null && VideoPlayFragment.this.mFs.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.mFs.author_info.user_id) && VideoPlayFragment.this.mFs != null && VideoPlayFragment.this.mFs.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.mFs.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    aq aqVar = new aq("c12798");
                    aqVar.dD("tid", VideoPlayFragment.this.mFs.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.mFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mFs != null && VideoPlayFragment.this.mFs.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.mFs.act_info.link_url);
                    aq aqVar = new aq("c12799");
                    aqVar.dD("tid", VideoPlayFragment.this.mFs.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.mFj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dED();
            }
        });
        this.aBC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mFs != null && !StringUtils.isNull(VideoPlayFragment.this.mFs.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.mFs.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.mFa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dEE();
            }
        });
        this.mFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.mFs)) {
                    VideoPlayFragment.this.dED();
                    aq aqVar = new aq("c12796");
                    aqVar.dD("tid", VideoPlayFragment.this.mFs.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.mFc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Ji(VideoPlayFragment.this.mEX);
            }
        });
        this.mFf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bkV();
                aq aqVar = new aq("c12797");
                aqVar.dD("tid", VideoPlayFragment.this.mFs.thread_id);
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar);
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dD("tid", VideoPlayFragment.this.mFs.thread_id);
                aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.ai("obj_locate", 19);
                aqVar2.dD("nid", VideoPlayFragment.this.mFs.nid);
                if (VideoPlayFragment.this.mFs.baijiahaoData != null && !at.isEmpty(VideoPlayFragment.this.mFs.baijiahaoData.oriUgcVid)) {
                    aqVar2.dD("obj_param6", VideoPlayFragment.this.mFs.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.mFs.getVideoType() == 1) {
                    aqVar2.ai(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.mFs.getVideoType() == 2) {
                    aqVar2.ai(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.mFs.getVideoType() == 3) {
                    aqVar2.ai(IntentConfig.CARD_TYPE, 6);
                }
                aqVar2.dD(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.mFs.mRecomSource);
                aqVar2.dD("ab_tag", VideoPlayFragment.this.mFs.mRecomAbTag);
                aqVar2.dD("weight", VideoPlayFragment.this.mFs.mRecomWeight);
                aqVar2.dD("extra", VideoPlayFragment.this.mFs.mRecomExtra);
                aqVar2.dD("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.ej(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.ej(VideoPlayFragment.this.getBaseFragmentActivity()).btX() != null && c.ej(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.ej(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    aqVar2.dD("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    aqVar2.dD("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(aqVar2);
            }
        });
        this.mFg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.mFs != null && VideoPlayFragment.this.mFs.author_info != null) {
                    VideoPlayFragment.this.ekH.a(true, VideoPlayFragment.this.mFs.author_info.portrait, VideoPlayFragment.this.mFs.author_info.user_id, false, "6", VideoPlayFragment.this.ahM, VideoPlayFragment.this.mFs.forum_id, "0");
                    VideoPlayFragment.this.mFs.author_info.is_follow = "1";
                    VideoPlayFragment.this.dEH();
                }
            }
        });
        this.fGL = new AlphaAnimation(1.0f, 0.0f);
        this.fGL.setDuration(100L);
        this.fGL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.mEZ != null) {
                    VideoPlayFragment.this.mEZ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mFy = this.mRect.right - this.mRect.left;
            this.hVk = this.mRect.bottom - this.mRect.top;
            this.mEZ.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.mEZ.getWidth();
                    int height = VideoPlayFragment.this.mEZ.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mFs.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mFs.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mFs.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mFs.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mFy, VideoPlayFragment.this.hVk);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.mEZ.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hVk > 0 || VideoPlayFragment.this.mFy <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mFy;
                                f = i / VideoPlayFragment.this.hVk;
                            }
                            VideoPlayFragment.this.mEZ.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.mEZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.dEh) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mFy, VideoPlayFragment.this.hVk);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.mEZ.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hVk > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.mEZ.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.mEZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.dEh) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.mEZ.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.mEZ.getWidth();
                    int height = VideoPlayFragment.this.mEZ.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mFs.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mFs.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mFs.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mFs.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.mEZ.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.mEZ.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cKF();
        if (this.dEh) {
            dEC();
        }
        if (this.mFs != null && !StringUtils.isNull(this.mFs.video_url)) {
            setVideoInfo(this.mFs.video_url);
        }
        return this.mRootView;
    }

    public void a(f.b bVar) {
        this.lsq = bVar;
    }

    public void a(a aVar) {
        this.mFH = aVar;
    }

    private void cKF() {
        this.mFG = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().ec(getActivity());
        if (this.mFG != null && this.mFs != null) {
            this.mFG.a(getPageContext());
            this.mFG.az(this.mFs.thread_id, this.mFs.forum_id, this.mFs.forum_name);
            this.mFG.a(new a.InterfaceC0823a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0823a
                public void wS(boolean z) {
                    VideoPlayFragment.this.mFw.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.mFx.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.mFx.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.mFG.brw().qe(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.mFs != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.mFs.comment_num, 0L) + 1;
                        VideoPlayFragment.this.mFs.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.mFl.setText(at.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.mFG.brw(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkV() {
        String str;
        String str2;
        if (this.mFs != null) {
            String str3 = this.mFs.forum_id;
            String str4 = this.mFs.forum_name;
            String str5 = this.mFs.title;
            if (this.mFs.baijiahaoData != null) {
                str = this.mFs.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.mFs.baijiahaoData.oriUgcType + "&dvid=" + this.mFs.baijiahaoData.oriUgcVid + "&nid=" + this.mFs.baijiahaoData.oriUgcNid;
            } else {
                str = this.mFs.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.mFs.thumbnail_url;
            String format = (!this.mFs.isBjhVideo || this.mFs.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.mFs.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.mFs.baijiahaoData == null) {
                shareItem.readCount = this.mFs.play_count;
            }
            if (this.mFs.isBjhVideo) {
                shareItem.eEu = format;
            } else {
                shareItem.eEu = "";
            }
            shareItem.linkUrl = str6;
            shareItem.eeF = 2;
            shareItem.extData = str;
            shareItem.eEx = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.eEj = true;
            shareItem.eEw = 12;
            if (this.mFs.getVideoType() == 1) {
                shareItem.eEB = 2;
            } else if (this.mFs.getVideoType() == 2) {
                shareItem.eEB = 8;
            } else if (this.mFs.getVideoType() == 3) {
                shareItem.eEB = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.mFs.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.mFs.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.mFs.title;
            originalThreadInfo.threadId = this.mFs.thread_id;
            originalThreadInfo.oriUgcInfo = this.mFs.baijiahaoData;
            shareItem.eEE = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eEx);
            bundle.putInt("obj_type", shareItem.eEB);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eeF);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.f.cdc().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.ghv) {
            this.hkz = new ForumManageModel(getPageContext());
            this.hkz.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.hkz.getLoadDataMode()) {
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
        this.kDE = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.kDE != null) {
            this.kDE.a(new a.InterfaceC0535a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0535a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.kDE != null) {
                            VideoPlayFragment.this.kDE.hB(z2);
                        }
                        if (VideoPlayFragment.this.mFs != null) {
                            if (z2) {
                                VideoPlayFragment.this.mFs.mark_id = VideoPlayFragment.this.mFs.post_id;
                            } else {
                                VideoPlayFragment.this.mFs.mark_id = null;
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
        this.ekH = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.ekL);
        registerListener(this.dUy);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.mFF = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dEF();
        dEP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEA() {
        if (this.mFi != null && this.mFh != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.mFh.clearAnimation();
            this.mFi.clearAnimation();
            this.mFh.setVisibility(8);
            this.mFi.setVisibility(0);
            this.mFi.startAnimation(scaleAnimation2);
            this.mFh.startAnimation(scaleAnimation);
        }
    }

    private void dEB() {
        if (this.mFi != null && this.mFh != null) {
            this.mFh.clearAnimation();
            this.mFi.clearAnimation();
            this.mFh.setVisibility(0);
            this.mFi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ji(int i) {
        int i2;
        if (bg.checkUpIsLogin(getActivity()) && this.mFs != null) {
            if (i == this.mEX) {
                if ("1".equals(this.mFs.is_agreed)) {
                    i2 = 1;
                    this.mFs.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mFs.agree_num, 0) - 1);
                    this.mFs.is_agreed = "0";
                } else {
                    this.mFs.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mFs.agree_num, 0) + 1);
                    this.mFs.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.mFs.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mFs.agree_num, 0) + 1);
                this.mFs.is_agreed = "1";
                i2 = 0;
            }
            aq aqVar = new aq("c12795");
            aqVar.dD("tid", this.mFs.thread_id);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.mEX) {
                aqVar.ai("obj_type", i2);
            } else {
                aqVar.ai("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12003");
            aqVar2.dD("tid", this.mFs.thread_id);
            aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.mEX) {
                aqVar2.ai("obj_type", i2);
            } else {
                aqVar2.ai("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                aqVar2.dD("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                aqVar2.dD("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            TiebaStatic.log(aqVar2);
            dEF();
            if (this.mFu != null && i2 == 0) {
                this.mFu.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.mFs.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.mFs.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.mFs.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.mFs.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.mFs.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.mFs.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.mFs.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.mFs.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.mFs));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.mFs != null && !StringUtils.isNull(this.mFs.video_url)) {
            this.mHasInit = true;
            if (this.dEh) {
                cbG();
                aHY();
                if (this.mFs != null && this.mRect != null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dD("tid", this.mFs.thread_id);
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
        if (this.mFG != null && this.mFG.brw() != null) {
            this.mFG.brw().hide();
            this.mFw.setVisibility(0);
            this.mFx.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.mFG.brw().qe(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.mFG != null) {
            this.mFG.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.dEh = z;
        if (!z && this.mFG != null) {
            this.mFx.setText(R.string.reply_something);
            this.mFG.cqd();
        }
        if (this.mHasInit) {
            if (this.dEh && (!this.mFF || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.mFs != null && this.mRect == null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dD("tid", this.mFs.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.ai("obj_type", 1);
                    TiebaStatic.log(aqVar);
                }
                startPlay();
                dEC();
                this.mFF = false;
                return;
            }
            dEB();
            this.playTime = 1;
            aHX();
        }
    }

    private void dEC() {
        if (this.mFs != null) {
            aq aqVar = new aq("c12590");
            aqVar.dD("tid", this.mFs.thread_id);
            aqVar.dD("nid", this.mFs.nid);
            aqVar.dD("fid", this.mFs.forum_id);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.ai("obj_locate", this.mFz);
            aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dD("obj_param1", at.isEmpty(this.mFs.mRecomWeight) ? "0" : this.mFs.mRecomWeight);
            aqVar.dD("extra", at.isEmpty(this.mFs.mRecomExtra) ? "0" : this.mFs.mRecomExtra);
            aqVar.dD("obj_id", this.dYs);
            aqVar.dD("ab_tag", at.isEmpty(this.mFs.mRecomAbTag) ? "0" : this.mFs.mRecomAbTag);
            aqVar.dD("obj_source", at.isEmpty(this.mFs.mRecomSource) ? "0" : this.mFs.mRecomSource);
            aqVar.dD("obj_type", this.mFromPage);
            aqVar.ai("is_vertical", 1);
            if (this.mFs.baijiahaoData != null) {
                aqVar.dD("obj_param4", this.mFs.baijiahaoData.oriUgcNid);
                aqVar.dD("obj_param6", this.mFs.baijiahaoData.oriUgcVid);
                if (this.mFs.baijiahaoData.oriUgcType == 4) {
                    aqVar.ai("obj_param5", 2);
                } else if (this.mFs.baijiahaoData.oriUgcType == 2) {
                    aqVar.ai("obj_param5", 3);
                }
            } else {
                aqVar.ai("obj_param5", 1);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.fDP != null && str != null && !str.equals(this.mVideoUrl)) {
            this.fDP.setVideoPath(str, this.mFs.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dEJ()) {
            djG();
            if (this.mFo != null) {
                this.mFo.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.mEZ.getVisibility() == 0) {
                this.mEZ.clearAnimation();
                this.mEZ.startAnimation(this.fGL);
            }
            if (this.fDP != null) {
                if (TbVideoViewSet.dku().OH(this.mVideoUrl) == null || TbVideoViewSet.dku().OH(this.mVideoUrl) != this.fDP) {
                    this.fDP.setVideoPath(this.mVideoUrl, this.mFs.thread_id);
                }
                this.fDP.start();
                cbG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbG() {
        if (this.mFs != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.ala = this.mFs.thread_id;
            oVar.mNid = this.mFs.nid;
            oVar.eVx = this.mFs.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.mFs.mRecomSource;
            oVar.ltn = this.mFs.mRecomAbTag;
            oVar.lto = this.mFs.mRecomWeight;
            oVar.ltp = "";
            oVar.dYs = "";
            oVar.ltt = this.mFs.mMd5;
            if (this.mRect != null) {
                oVar.ltu = "1";
            } else {
                oVar.ltu = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.ltv = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.ltp = "index";
            }
            h.a(this.mFs.mMd5, "", "1", oVar, this.fDP.getPcdnState());
        }
    }

    private void djG() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dBe().fI(getContext());
        }
    }

    private void aHX() {
        if (this.fDP != null) {
            this.fDP.pause();
        }
    }

    private void stopPlay() {
        if (this.fDP != null) {
            this.fDP.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dED() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.mFs.thread_id, this.mFs.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.mFs.forum_id));
        createNormalCfg.setForumName(this.mFs.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.mFs.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEE() {
        if (this.dSU == null) {
            this.mFA = new com.baidu.tieba.view.a(getActivity());
            this.dSU = new e(getActivity(), this.mFA.bhw());
            this.dSU.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.fDP.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.mFA != null) {
            ArrayList arrayList = new ArrayList();
            a.C0825a c0825a = new a.C0825a(this.mFA);
            c0825a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bg.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.dSU.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.dSU.dismiss();
                    if (VideoPlayFragment.this.mFs != null) {
                        boolean z = VideoPlayFragment.this.mFs.post_id != null && VideoPlayFragment.this.mFs.post_id.equals(VideoPlayFragment.this.mFs.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.mFs.thread_id);
                        markData.setPostId(VideoPlayFragment.this.mFs.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.mFs.thread_id);
                        markData.setForumId(VideoPlayFragment.this.mFs.forum_id);
                        if (VideoPlayFragment.this.kDE != null) {
                            VideoPlayFragment.this.kDE.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.kDE.baC();
                            } else {
                                VideoPlayFragment.this.kDE.baB();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.mFs != null && this.mFs.post_id != null && this.mFs.post_id.equals(this.mFs.mark_id)) {
                z = true;
            }
            if (z) {
                c0825a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0825a.setText(getResources().getString(R.string.mark));
            }
            if (this.mFs != null && !this.mFs.isBjhVideo) {
                arrayList.add(c0825a);
            }
            a.C0825a c0825a2 = new a.C0825a(getActivity().getString(R.string.delete), this.mFA);
            c0825a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.dSU.dismiss();
                    if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.mFs != null) {
                        String str = VideoPlayFragment.this.mFs.thread_id;
                        String str2 = VideoPlayFragment.this.mFs.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.mFs.post_id;
                        if (VideoPlayFragment.this.mFs.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.mFs.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.mFs.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0825a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0825a2);
            if (this.ghv) {
                a.C0825a c0825a3 = new a.C0825a(getActivity().getString(R.string.delete), this.mFA);
                c0825a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.dSU.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.nt(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.mFs != null) {
                                    VideoPlayFragment.this.hkz.a(VideoPlayFragment.this.mFs.forum_id, VideoPlayFragment.this.mFs.forum_name, VideoPlayFragment.this.mFs.thread_id, VideoPlayFragment.this.mFs.post_id, 0, 0, VideoPlayFragment.this.ghv, null);
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
                        aVar.ig(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.bhg();
                    }
                });
                c0825a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0825a3);
            }
            this.mFA.aT(arrayList);
        }
        this.dSU.show();
    }

    private void dEF() {
        if (this.mFs != null) {
            this.mEZ.startLoad(this.mFs.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.mFs.title);
            if (StringUtils.isNull(this.mFs.title) || matcher.matches()) {
                this.mFj.setVisibility(8);
            } else {
                this.mFj.setVisibility(0);
                this.mFj.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.mFj.setTextColor(R.color.cp_cont_a);
                this.mFj.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.mFj.setExpandable(true);
                this.mFj.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void po(boolean z) {
                        VideoPlayFragment.this.mFs.isTitleExpanded = z;
                    }
                });
                this.mFj.setData(this.mFs.title, this.mFs.isTitleExpanded);
            }
            this.mFl.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mFs.comment_num, 0L)));
            this.mFm.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mFs.agree_num, 0L)));
            this.mFn.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mFs.share_num, 0L)));
            if (this.mFs.author_info != null) {
                if (!TextUtils.isEmpty(this.mFs.author_info.bjhAvatar)) {
                    this.mFb.startLoad(this.mFs.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.mFs.author_info.portrait) && this.mFs.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.mFb.startLoad(this.mFs.author_info.portrait, 10, false);
                } else {
                    this.mFb.startLoad(this.mFs.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.mFs.author_info.dAZ())) {
                    this.mFv.setVisibility(8);
                } else {
                    this.mFv.setVisibility(0);
                    this.mFv.setText(UgcConstant.AT_RULE_TAG + this.mFs.author_info.dAZ());
                }
            }
            if ("1".equals(this.mFs.is_private) && this.mFt.getVisibility() != 0) {
                this.mFr.setVisibility(0);
            } else {
                this.mFr.setVisibility(8);
            }
            if ("1".equals(this.mFs.is_agreed)) {
                ap.setImageResource(this.mFu, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.mFu, R.drawable.btn_video_agree);
            }
            if (this.mFs.act_info != null && !StringUtils.isNull(this.mFs.act_info.activity_name) && this.mFt.getVisibility() != 0) {
                this.mFq.setVisibility(0);
                this.mFk.setText(this.mFs.act_info.activity_name);
            } else {
                this.mFq.setVisibility(8);
            }
            dEH();
            if (this.mFs.isBjhVideo) {
                this.mFa.setVisibility(8);
            } else {
                this.mFa.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEG() {
        if (this.mFs != null) {
            if ("1".equals(this.mFs.is_agreed)) {
                ap.setImageResource(this.mFu, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.mFu, R.drawable.btn_video_agree);
            }
            this.mFm.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mFs.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEH() {
        if (this.ghv || (this.mFs.author_info != null && !"0".equals(this.mFs.author_info.is_follow))) {
            this.mFg.setVisibility(4);
            this.mFg.setClickable(false);
            return;
        }
        this.mFg.setVisibility(0);
        this.mFg.setClickable(true);
    }

    private void dEI() {
        if (getActivity() != null) {
            if (this.mFI == null || !this.mFI.isShowing()) {
                this.mFI = new com.baidu.tbadk.core.dialog.a(getActivity());
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
                this.mFI.aX(inflate);
                this.mFI.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.mFI.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.mFI.nw(1);
                this.mFI.nu(R.color.cp_cont_b);
                this.mFI.ig(true);
                this.mFI.b(getPageContext());
                this.mFI.bhg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dEJ() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dBe().dBf() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet() || !this.dEh) {
            return false;
        }
        if (this.mFo != null) {
            this.mFo.setVisibility(0);
        }
        aHX();
        dEI();
        return true;
    }

    private void aHY() {
        if (!dEJ() && this.fDP != null && this.mFo != null && this.mFs != null) {
            if (this.fDP.getParent() == null) {
                dEO();
                dEP();
            }
            if (TbVideoViewSet.dku().OH(this.mVideoUrl) == null || TbVideoViewSet.dku().OH(this.mVideoUrl) != this.fDP) {
                this.fDP.setVideoPath(this.mVideoUrl, this.mFs.thread_id);
            }
            this.fDP.a((TbVideoViewSet.a) null);
            this.mFo.setVisibility(8);
            djG();
            if (this.mFH != null) {
                this.mFH.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.mFB == null) {
            this.mFB = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.mFB;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0566a
    public void byU() {
        if (this.fDP.isPlaying()) {
            this.fDP.pause();
            this.mFo.setVisibility(0);
        } else if (!dEJ()) {
            this.fDP.start();
            this.mFo.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0566a
    public void x(float f, float f2) {
        if (bg.checkUpIsLogin(getActivity()) && !this.mFC) {
            dEK();
            if (this.mFs != null && "0".equals(this.mFs.is_agreed)) {
                Ji(this.mEY);
            }
        }
    }

    private void dEK() {
        if (this.mRootView != null) {
            this.mFC = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.mFE == null) {
                this.mFE = new RelativeLayout.LayoutParams(-2, -2);
                this.mFE.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.mFE);
            }
            if (this.mFD == null) {
                this.mFD = new AnimatorSet();
                this.mFD.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.mFC = false;
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
            this.mFD.setTarget(imageView);
            this.mFD.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.mFD.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0566a
    public void byV() {
        if (this.mFs != null && this.mFs.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.mFs.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dEL() {
        return null;
    }

    public String dEM() {
        return null;
    }

    public boolean dEN() {
        if (this.mFG == null || this.mFG.brw() == null || !this.mFG.brw().isVisible()) {
            return false;
        }
        this.mFG.brw().hide();
        this.mFw.setVisibility(0);
        if ((this.mFG.brw().qe(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.mFG.brw().qe(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.mFG.brw().qe(28)).getInputView().getText() != null) {
            this.mFx.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.mFG.brw().qe(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.mFG != null) {
            this.mFG.onActivityResult(i, i2, intent);
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
        if (this.mFG != null && this.mFG.brw() != null) {
            this.mFG.brw().onChangeSkinType(i);
        }
        SvgManager.bjq().a(this.aBC, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dEO() {
        if (this.fDP != null && this.fDP.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.fDP.getView(), 0);
            this.fDP.getView().setLayoutParams(layoutParams);
            if (this.mFs != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.ala = this.mFs.thread_id;
                oVar.mNid = this.mFs.nid;
                oVar.eVx = this.mFs.forum_id;
                oVar.ltt = this.mFs.mMd5;
                oVar.dYs = "";
                oVar.mSource = this.mFs.mRecomSource;
                oVar.lts = this.mFs.mRecomAbTag;
                oVar.ltq = 1;
                if (this.mFs.baijiahaoData != null) {
                    if (this.mFs.baijiahaoData.oriUgcType == 2) {
                        oVar.ltq = 3;
                    } else if (this.mFs.baijiahaoData.oriUgcType == 4) {
                        oVar.ltq = 2;
                    }
                }
                oVar.lto = this.mFs.mRecomWeight;
                if (this.mRect != null) {
                    oVar.ltu = "1";
                } else {
                    oVar.ltu = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.ltv = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.ltp = this.mFromPage;
                    oVar.dYs = this.dYs;
                    oVar.ltn = this.mFs.mRecomWeight;
                } else {
                    oVar.mLocate = "14";
                }
                this.fDP.setVideoStatData(oVar);
                this.fDP.setLocateSource("v_mid_page");
            }
            this.fDP.setContinuePlayEnable(true);
        }
    }

    private void dEP() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.fDP.setOnPreparedListener(this.mFJ);
        }
        this.fDP.setOnCompletionListener(this.lua);
        this.fDP.setOnInfoListener(this.luc);
    }
}
