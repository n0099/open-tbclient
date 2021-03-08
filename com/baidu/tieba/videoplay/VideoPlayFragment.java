package com.baidu.tieba.videoplay;

import android.animation.Animator;
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
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
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
import com.baidu.android.imsdk.internal.IMConnection;
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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.pageExtra.d;
import com.baidu.tbadk.pageInfo.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoMiddleNiaiControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.o;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.editor.a;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.tencent.connect.common.Constants;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
/* loaded from: classes7.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0594a {
    public ImageView aFX;
    public LinearLayout bye;
    private String ePf;
    private boolean eus;
    private boolean fzM;
    public TbCyberVideoView gBU;
    private AlphaAnimation gEX;
    public ImageView hJo;
    private boolean hmO;
    private k iBk;
    private View iJd;
    private i izy;
    private int jkv;
    public ImageView jpk;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private f.b mJD;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private TbImageView nWX;
    public ImageView nWY;
    public HeadImageView nWZ;
    private int nXA;
    private int nXB;
    private RelativeLayout.LayoutParams nXD;
    private TBLottieAnimationView nXE;
    private com.baidu.tieba.videoplay.editor.a nXG;
    private a nXH;
    com.baidu.tbadk.core.dialog.a nXL;
    public LinearLayout nXa;
    public LinearLayout nXb;
    public LinearLayout nXc;
    public LinearLayout nXd;
    public ImageView nXe;
    public ImageView nXf;
    public ImageView nXg;
    public ImageView nXh;
    public ExpandableTextView nXi;
    public EMTextView nXj;
    public EMTextView nXk;
    public EMTextView nXl;
    public EMTextView nXm;
    public EMTextView nXn;
    private TextView nXo;
    private FrameLayout nXp;
    private LinearLayout nXq;
    public LinearLayout nXr;
    public LinearLayout nXs;
    public VideoItemData nXt;
    private TextView nXu;
    private VideoMiddleNiaiControllerView nXv;
    public ImageView nXw;
    public TextView nXx;
    private View nXy;
    private TextView nXz;
    private int nWV = 0;
    private int nWW = 1;
    private ForumManageModel gfY = null;
    private com.baidu.tbadk.baseEditMark.a lTS = null;
    private com.baidu.tbadk.coreExtra.model.a fce = null;
    private BdUniqueId ahU = BdUniqueId.gen();
    private boolean nXC = false;
    private boolean nXF = false;
    private int playTime = 1;
    private CustomMessageListener fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.nXt != null && VideoPlayFragment.this.nXt.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nXt.author_info.user_id) && data != null && VideoPlayFragment.this.nXt.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.ahU)) ? false : false;
                    if (data.fud == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.nXt.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.nXt.author_info.is_follow = "0";
                                VideoPlayFragment.this.dVE();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.eus) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.nXt));
                                } else {
                                    VideoPlayFragment.this.nXt.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dVE();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.nXt.author_info.is_follow = "0";
                            VideoPlayFragment.this.dVE();
                        }
                        ar arVar = new ar("c13570");
                        arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                        if ("index".equals(VideoPlayFragment.this.mFromPage)) {
                            arVar.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                            arVar.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                        TiebaStatic.log(arVar);
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
                VideoPlayFragment.this.dVG();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.nXt != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.nXt.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.nXt.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.nXt.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.nXt.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dVD();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.nXt.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.nXt.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.nXt.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dVD();
                    }
                }
            }
        }
    };
    private k.b nXI = new k.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!bh.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                VideoPlayFragment.this.izy.dismiss();
                return;
            }
            VideoPlayFragment.this.izy.dismiss();
            if (VideoPlayFragment.this.nXt != null) {
                boolean z = VideoPlayFragment.this.nXt.post_id != null && VideoPlayFragment.this.nXt.post_id.equals(VideoPlayFragment.this.nXt.mark_id);
                MarkData markData = new MarkData();
                Date date = new Date();
                markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                markData.setThreadId(VideoPlayFragment.this.nXt.thread_id);
                markData.setPostId(VideoPlayFragment.this.nXt.post_id);
                markData.setTime(date.getTime());
                markData.setHostMode(false);
                markData.setId(VideoPlayFragment.this.nXt.thread_id);
                markData.setForumId(VideoPlayFragment.this.nXt.forum_id);
                if (VideoPlayFragment.this.lTS != null) {
                    VideoPlayFragment.this.lTS.a(markData);
                    if (!z) {
                        VideoPlayFragment.this.lTS.bkd();
                    } else {
                        VideoPlayFragment.this.lTS.bkc();
                    }
                }
            }
        }
    };
    private k.b nXJ = new k.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            VideoPlayFragment.this.izy.dismiss();
            if (bh.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nXt != null) {
                String str = VideoPlayFragment.this.nXt.thread_id;
                String str2 = VideoPlayFragment.this.nXt.forum_id;
                String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.nXt.post_id;
                if (VideoPlayFragment.this.nXt.isBjhVideo) {
                    str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.nXt.post_id) + "&channelid=33840";
                    string = "";
                }
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                if (VideoPlayFragment.this.nXt.isBjhVideo) {
                    tbWebViewActivityConfig.setFixTitle(true);
                }
                VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
            }
        }
    };
    private k.b nXK = new k.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            VideoPlayFragment.this.izy.dismiss();
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
            aVar.ny(R.string.del_thread_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (VideoPlayFragment.this.nXt != null) {
                        VideoPlayFragment.this.gfY.a(VideoPlayFragment.this.nXt.forum_id, VideoPlayFragment.this.nXt.forum_name, VideoPlayFragment.this.nXt.thread_id, VideoPlayFragment.this.nXt.post_id, 0, 0, VideoPlayFragment.this.hmO, null);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.jF(true);
            aVar.b(VideoPlayFragment.this.getPageContext());
            aVar.bqz();
        }
    };
    private Runnable nXM = new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // java.lang.Runnable
        public void run() {
            if (!VideoPlayFragment.this.fzM) {
                VideoPlayFragment.this.zj(true);
            }
        }
    };
    private CyberPlayerManager.OnInfoListener mLn = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.eus) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.nWX.getVisibility() == 0) {
                    VideoPlayFragment.this.nWX.clearAnimation();
                    VideoPlayFragment.this.nWX.startAnimation(VideoPlayFragment.this.gEX);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener mLl = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.gBU != null) {
                VideoPlayFragment.this.gBU.dAI();
                VideoPlayFragment.this.gBU.seekTo(0);
                VideoPlayFragment.this.gBU.start();
                VideoPlayFragment.this.cso();
                VideoPlayFragment.D(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dVx();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener nXN = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.gBU != null) {
                VideoPlayFragment.this.gBU.setVolume(1.0f, 1.0f);
                if (VideoPlayFragment.this.gBU.getDuration() < 15000 || VideoPlayFragment.this.nXv == null) {
                    VideoPlayFragment.this.nXv.setVisibility(8);
                    return;
                }
                VideoPlayFragment.this.nXv.setVisibility(0);
                if (VideoPlayFragment.this.nXv.getCurProgress() == 0) {
                    VideoPlayFragment.this.nXv.showProgress();
                }
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void onStart();
    }

    static /* synthetic */ int D(VideoPlayFragment videoPlayFragment) {
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
        this.nXt = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.nXB = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.ePf = arguments.getString("obj_id");
        if (this.nXt != null && this.nXt.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.nXt.author_info.user_id)) {
            this.hmO = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.gBU = new TbCyberVideoView(getContext());
        this.gBU.setStageType("2005");
        this.gBU.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // com.baidu.tieba.play.f.b
            public void cf(int i, int i2) {
                if (VideoPlayFragment.this.mJD != null) {
                    VideoPlayFragment.this.mJD.cf(i, i2);
                }
            }
        });
        dVL();
        this.nWX = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.nWX.setPlaceHolder(4);
        if (g.bsb() || (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity()))) {
            this.iJd = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.iJd.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.iJd.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aFX = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.nWY = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.nWZ = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.nWZ.setDefaultResource(17170445);
        this.nWZ.setPlaceHolder(2);
        this.nWZ.setIsRound(true);
        this.nXp = (FrameLayout) this.mRootView.findViewById(R.id.author_info_container);
        this.bye = (LinearLayout) this.mRootView.findViewById(R.id.bottom_container);
        this.nXe = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.nXw = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.nXi = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.nXv = (VideoMiddleNiaiControllerView) this.mRootView.findViewById(R.id.media_controller);
        this.nXo = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.nXb = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.nXj = (EMTextView) this.mRootView.findViewById(R.id.comment_num);
        this.jpk = (ImageView) this.mRootView.findViewById(R.id.comment_img);
        this.nXa = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.nXd = (LinearLayout) this.mRootView.findViewById(R.id.ll_drag_container);
        this.nXk = (EMTextView) this.mRootView.findViewById(R.id.agree_num);
        this.hJo = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nXl = (EMTextView) this.mRootView.findViewById(R.id.share_num);
        this.nXm = (EMTextView) this.mRootView.findViewById(R.id.drag_cur_time);
        this.nXn = (EMTextView) this.mRootView.findViewById(R.id.drag_total_time);
        this.nXf = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nXg = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dVy();
        this.nXh = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.nXq = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.nXr = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.nXs = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.nXc = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.nXx = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.nXy = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.nXy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.nXy.setVisibility(4);
                    if (VideoPlayFragment.this.nXG != null && VideoPlayFragment.this.nXG.bBk() != null) {
                        VideoPlayFragment.this.nXG.bBk().display();
                        if (VideoPlayFragment.this.nXt != null) {
                            VideoPlayFragment.this.nXG.c(VideoPlayFragment.this.nXt);
                        }
                    }
                    if (VideoPlayFragment.this.nXt != null) {
                        ar arVar = new ar("c13025");
                        arVar.dR("tid", VideoPlayFragment.this.nXt.thread_id);
                        arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                        arVar.dR("fid", VideoPlayFragment.this.nXt.forum_id);
                        TiebaStatic.log(arVar);
                    }
                }
            }
        });
        if (this.nXt != null) {
            if (this.nXt.video_duration > 15) {
                this.nXv.setVisibility(0);
            } else {
                this.nXv.setVisibility(8);
            }
        }
        this.nXv.setPlayer(this.gBU);
        this.nXv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoPlayFragment.this.zi(true);
                    if (VideoPlayFragment.this.nXm != null) {
                        VideoPlayFragment.this.nXm.setText(au.stringForVideoTime(i));
                    }
                    if (VideoPlayFragment.this.nXn != null) {
                        VideoPlayFragment.this.nXn.setText("/" + au.stringForVideoTime(VideoPlayFragment.this.gBU.getDuration()));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoPlayFragment.this.fzM = true;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                    seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_navi_seekbar_thumb_pressed));
                    seekBar.setProgressDrawable(TbadkCoreApplication.getInst().getDrawable(R.drawable.video_navi_video_eight_width_seekbar));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoPlayFragment.this.fzM = false;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                    seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                    VideoPlayFragment.this.zi(false);
                    if (!VideoPlayFragment.this.gBU.isPlaying()) {
                        VideoPlayFragment.this.gBU.start();
                        VideoPlayFragment.this.nXh.setVisibility(8);
                    }
                    com.baidu.adp.lib.f.e.mA().postDelayed(VideoPlayFragment.this.nXM, IMConnection.RETRY_DELAY_TIMES);
                }
            }
        });
        this.nXz = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.nXu = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.nXu.setVisibility(8);
        String string = b.brR().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.nXu.setText(string);
        }
        final String string2 = b.brR().getString("nani_key_download_link_url", null);
        this.nXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    bf.bsY().a((TbPageContext) j.J(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dVC();
        this.nWZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nXt != null && VideoPlayFragment.this.nXt.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nXt.author_info.user_id) && VideoPlayFragment.this.nXt != null && VideoPlayFragment.this.nXt.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nXt.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    ar arVar = new ar("c12798");
                    arVar.dR("tid", VideoPlayFragment.this.nXt.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nXr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nXt != null && VideoPlayFragment.this.nXt.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.nXt.act_info.link_url);
                    ar arVar = new ar("c12799");
                    arVar.dR("tid", VideoPlayFragment.this.nXt.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nXi.setHasDown();
        this.nXi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dVA();
            }
        });
        this.aFX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nXt != null && !StringUtils.isNull(VideoPlayFragment.this.nXt.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.nXt.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.nWY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dVB();
            }
        });
        this.nXb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.nXt)) {
                    VideoPlayFragment.this.dVA();
                    ar arVar = new ar("c12796");
                    arVar.dR("tid", VideoPlayFragment.this.nXt.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nXa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.KX(VideoPlayFragment.this.nWV);
            }
        });
        this.nXc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.buI();
                ar arVar = new ar("c12797");
                arVar.dR("tid", VideoPlayFragment.this.nXt.thread_id);
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar);
                ar arVar2 = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar2.dR("tid", VideoPlayFragment.this.nXt.thread_id);
                arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar2.aq("obj_locate", 19);
                arVar2.dR(IntentConfig.NID, VideoPlayFragment.this.nXt.nid);
                if (VideoPlayFragment.this.nXt.baijiahaoData != null && !au.isEmpty(VideoPlayFragment.this.nXt.baijiahaoData.oriUgcVid)) {
                    arVar2.dR("obj_param6", VideoPlayFragment.this.nXt.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.nXt.getVideoType() == 1) {
                    arVar2.aq(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.nXt.getVideoType() == 2) {
                    arVar2.aq(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.nXt.getVideoType() == 3) {
                    arVar2.aq(IntentConfig.CARD_TYPE, 6);
                }
                arVar2.dR(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.nXt.mRecomSource);
                arVar2.dR("ab_tag", VideoPlayFragment.this.nXt.mRecomAbTag);
                arVar2.dR("weight", VideoPlayFragment.this.nXt.mRecomWeight);
                arVar2.dR("extra", VideoPlayFragment.this.nXt.mRecomExtra);
                arVar2.dR("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.fq(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.fq(VideoPlayFragment.this.getBaseFragmentActivity()).bDS() != null && c.fq(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.fq(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    arVar2.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    arVar2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(arVar2);
            }
        });
        this.nXe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nXe != null && VideoPlayFragment.this.nXt != null && VideoPlayFragment.this.nXt.author_info != null) {
                    VideoPlayFragment.this.fce.a(true, VideoPlayFragment.this.nXt.author_info.portrait, VideoPlayFragment.this.nXt.author_info.user_id, false, "6", VideoPlayFragment.this.ahU, VideoPlayFragment.this.nXt.forum_id, "0");
                    VideoPlayFragment.this.nXt.author_info.is_follow = "1";
                    VideoPlayFragment.this.dVE();
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(300L);
                    VideoPlayFragment.this.nXe.startAnimation(scaleAnimation);
                }
            }
        });
        this.gEX = new AlphaAnimation(1.0f, 0.0f);
        this.gEX.setDuration(100L);
        this.gEX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.nWX != null) {
                    VideoPlayFragment.this.nWX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.nXA = this.mRect.right - this.mRect.left;
            this.jkv = this.mRect.bottom - this.mRect.top;
            this.nWX.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2;
                    int width = VideoPlayFragment.this.nWX.getWidth();
                    int height = VideoPlayFragment.this.nWX.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nXt.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nXt.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nXt.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nXt.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nXA, VideoPlayFragment.this.jkv);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.nWX.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jkv > 0 || VideoPlayFragment.this.nXA <= 0) {
                                f = 1.0f;
                                f2 = 1.0f;
                            } else {
                                f = i / VideoPlayFragment.this.jkv;
                                f2 = i2 / VideoPlayFragment.this.nXA;
                            }
                            VideoPlayFragment.this.nWX.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.nWX.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.eus) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nXA, VideoPlayFragment.this.jkv);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.nWX.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jkv > 0) {
                    }
                    f = 1.0f;
                    f2 = 1.0f;
                    VideoPlayFragment.this.nWX.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.nWX.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.eus) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.nWX.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.nWX.getWidth();
                    int height = VideoPlayFragment.this.nWX.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nXt.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nXt.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nXt.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nXt.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.nWX.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.nWX.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        dan();
        if (this.eus) {
            dVz();
        }
        if (this.nXt != null && !StringUtils.isNull(this.nXt.video_url)) {
            UY(this.nXt.video_url);
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi(boolean z) {
        if (z) {
            this.nXa.setVisibility(8);
            this.nXp.setVisibility(8);
            this.nXb.setVisibility(8);
            this.nXc.setVisibility(8);
            this.bye.setVisibility(8);
            this.nXd.setVisibility(0);
            return;
        }
        this.nXa.setVisibility(0);
        this.nXp.setVisibility(0);
        this.nXb.setVisibility(0);
        this.nXc.setVisibility(0);
        this.bye.setVisibility(0);
        this.nXd.setVisibility(8);
    }

    public void a(f.b bVar) {
        this.mJD = bVar;
    }

    public void a(a aVar) {
        this.nXH = aVar;
    }

    private void dan() {
        this.nXG = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().ff(getActivity());
        if (this.nXG != null && this.nXt != null) {
            this.nXG.a(getPageContext());
            this.nXG.aQ(this.nXt.thread_id, this.nXt.forum_id, this.nXt.forum_name);
            this.nXG.a(new a.InterfaceC0902a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0902a
                public void zk(boolean z) {
                    VideoPlayFragment.this.nXy.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.nXz.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.nXz.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.nXG.bBk().qV(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.nXt != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nXt.comment_num, 0L) + 1;
                        VideoPlayFragment.this.nXt.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.nXj.setText(au.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.nXG.bBk(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buI() {
        String str;
        String str2;
        if (this.nXt != null) {
            String str3 = this.nXt.forum_id;
            String str4 = this.nXt.forum_name;
            String str5 = this.nXt.title;
            if (this.nXt.baijiahaoData != null) {
                str = this.nXt.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.nXt.baijiahaoData.oriUgcType + "&dvid=" + this.nXt.baijiahaoData.oriUgcVid + "&nid=" + this.nXt.baijiahaoData.oriUgcNid;
            } else {
                str = this.nXt.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str7 = this.nXt.thumbnail_url;
            String format = (!this.nXt.isBjhVideo || this.nXt.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.nXt.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.nXt.baijiahaoData == null) {
                shareItem.readCount = this.nXt.play_count;
            }
            if (this.nXt.isBjhVideo) {
                shareItem.fwu = format;
            } else {
                shareItem.fwu = "";
            }
            shareItem.linkUrl = str6;
            shareItem.eVJ = 2;
            shareItem.extData = str;
            shareItem.fwx = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.fwj = true;
            shareItem.fww = 12;
            if (this.nXt.getVideoType() == 1) {
                shareItem.fwB = 2;
            } else if (this.nXt.getVideoType() == 2) {
                shareItem.fwB = 8;
            } else if (this.nXt.getVideoType() == 3) {
                shareItem.fwB = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.nXt.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.nXt.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.nXt.title;
            originalThreadInfo.threadId = this.nXt.thread_id;
            originalThreadInfo.oriUgcInfo = this.nXt.baijiahaoData;
            shareItem.fwE = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fwx);
            bundle.putInt("obj_type", shareItem.fwB);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eVJ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.f.ctM().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.hmO) {
            this.gfY = new ForumManageModel(getPageContext());
            this.gfY.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.gfY.getLoadDataMode()) {
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
        this.lTS = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.lTS != null) {
            this.lTS.a(new a.InterfaceC0560a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0560a
                public void e(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.lTS != null) {
                            VideoPlayFragment.this.lTS.ja(z2);
                        }
                        if (VideoPlayFragment.this.nXt != null) {
                            if (z2) {
                                VideoPlayFragment.this.nXt.mark_id = VideoPlayFragment.this.nXt.post_id;
                            } else {
                                VideoPlayFragment.this.nXt.mark_id = null;
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
        this.fce = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.fci);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.nXF = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dVC();
        dVM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVx() {
        if (this.nXg != null && this.nXf != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.nXf.clearAnimation();
            this.nXg.clearAnimation();
            this.nXf.setVisibility(8);
            this.nXg.setVisibility(0);
            this.nXg.startAnimation(scaleAnimation2);
            this.nXf.startAnimation(scaleAnimation);
        }
    }

    private void dVy() {
        if (this.nXg != null && this.nXf != null) {
            this.nXf.clearAnimation();
            this.nXg.clearAnimation();
            this.nXf.setVisibility(0);
            this.nXg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KX(int i) {
        int i2;
        if (bh.checkUpIsLogin(getActivity()) && this.nXt != null) {
            if (i == this.nWV) {
                if ("1".equals(this.nXt.is_agreed)) {
                    i2 = 1;
                    this.nXt.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nXt.agree_num, 0) - 1);
                    this.nXt.is_agreed = "0";
                } else {
                    this.nXt.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nXt.agree_num, 0) + 1);
                    this.nXt.is_agreed = "1";
                    dVH();
                    i2 = 0;
                }
            } else {
                this.nXt.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nXt.agree_num, 0) + 1);
                this.nXt.is_agreed = "1";
                i2 = 0;
            }
            ar arVar = new ar("c12795");
            arVar.dR("tid", this.nXt.thread_id);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nWV) {
                arVar.aq("obj_type", i2);
            } else {
                arVar.aq("obj_type", 2);
            }
            TiebaStatic.log(arVar);
            ar arVar2 = new ar("c12003");
            arVar2.dR("tid", this.nXt.thread_id);
            arVar2.v("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nWV) {
                arVar2.aq("obj_type", i2);
            } else {
                arVar2.aq("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                arVar2.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                arVar2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            com.baidu.tbadk.pageExtra.c fp = d.fp(getContext());
            if (fp != null) {
                arVar2.dR("obj_cur_page", fp.getCurrentPageKey());
            }
            if (d.bDP() != null) {
                arVar2.dR("obj_pre_page", d.bDP());
            }
            TiebaStatic.log(arVar2);
            dVC();
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.nXt.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.nXt.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.nXt.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.nXt.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.nXt.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.nXt.baijiahaoData.oriUgcType);
            }
            if (fp != null) {
                httpMessage.addParam("obj_source", fp.getCurrentPageKey());
            }
            sendMessage(httpMessage);
            e eVar = new e();
            AgreeData agreeData = new AgreeData();
            if (this.nXt.thread_id != null) {
                agreeData.threadId = this.nXt.thread_id;
            }
            agreeData.agreeNum = Long.valueOf(this.nXt.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.nXt.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.nXt));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (TbSingleton.getInstance().isNotchScreen(getActivity()) || !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
        }
        if (this.nXt != null && !StringUtils.isNull(this.nXt.video_url)) {
            this.mHasInit = true;
            if (this.eus) {
                cso();
                resumePlay();
                if (this.nXt != null && this.mRect != null) {
                    ar arVar = new ar("c12794");
                    arVar.dR("tid", this.nXt.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.aq("obj_type", 0);
                    TiebaStatic.log(arVar);
                    return;
                }
                return;
            }
            pausePlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        pausePlay();
        if (this.nXG != null && this.nXG.bBk() != null) {
            this.nXG.bBk().hide();
            this.nXy.setVisibility(0);
            this.nXz.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nXG.bBk().qV(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.nXG != null) {
            this.nXG.onDestroy();
        }
        if (this.nXM != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nXM);
            this.nXM = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.eus = z;
        if (!z && this.nXG != null) {
            this.nXz.setText(R.string.reply_something);
            this.nXG.cHb();
        }
        if (this.mHasInit) {
            if (this.eus && (!this.nXF || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.nXt != null && this.mRect == null) {
                    ar arVar = new ar("c12794");
                    arVar.dR("tid", this.nXt.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.aq("obj_type", 1);
                    TiebaStatic.log(arVar);
                }
                startPlay();
                dVz();
                this.nXF = false;
                return;
            }
            dVy();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void dVz() {
        if (this.nXt != null) {
            ar arVar = new ar("c12590");
            arVar.dR("tid", this.nXt.thread_id);
            arVar.dR(IntentConfig.NID, this.nXt.nid);
            arVar.dR("fid", this.nXt.forum_id);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.aq("obj_locate", this.nXB);
            arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, 1);
            arVar.dR("obj_param1", au.isEmpty(this.nXt.mRecomWeight) ? "0" : this.nXt.mRecomWeight);
            arVar.dR("extra", au.isEmpty(this.nXt.mRecomExtra) ? "0" : this.nXt.mRecomExtra);
            arVar.dR("obj_id", this.ePf);
            arVar.dR("ab_tag", au.isEmpty(this.nXt.mRecomAbTag) ? "0" : this.nXt.mRecomAbTag);
            arVar.dR("obj_source", au.isEmpty(this.nXt.mRecomSource) ? "0" : this.nXt.mRecomSource);
            arVar.dR("obj_type", this.mFromPage);
            arVar.aq("is_vertical", 1);
            if (this.nXt.baijiahaoData != null) {
                arVar.dR("obj_param4", this.nXt.baijiahaoData.oriUgcNid);
                arVar.dR("obj_param6", this.nXt.baijiahaoData.oriUgcVid);
                if (this.nXt.baijiahaoData.oriUgcType == 4) {
                    arVar.aq("obj_param5", 2);
                } else if (this.nXt.baijiahaoData.oriUgcType == 2) {
                    arVar.aq("obj_param5", 3);
                }
            } else {
                arVar.aq("obj_param5", 1);
            }
            TiebaStatic.log(arVar);
        }
    }

    private void UY(String str) {
        if (this.gBU != null && str != null && !str.equals(this.mVideoUrl)) {
            this.gBU.setVideoPath(str, this.nXt.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dVG()) {
            dzW();
            if (this.nXh != null) {
                this.nXh.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.nWX.getVisibility() == 0) {
                this.nWX.clearAnimation();
                this.nWX.startAnimation(this.gEX);
            }
            if (this.gBU != null) {
                if (TbVideoViewSet.dAJ().QM(this.mVideoUrl) == null || TbVideoViewSet.dAJ().QM(this.mVideoUrl) != this.gBU) {
                    this.gBU.setVideoPath(this.mVideoUrl, this.nXt.thread_id);
                }
                this.gBU.start();
                this.nXv.showProgress();
                cso();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cso() {
        if (this.nXt != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.anU = this.nXt.thread_id;
            oVar.eVa = this.nXt.nid;
            oVar.fOD = this.nXt.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.nXt.mRecomSource;
            oVar.mKz = this.nXt.mRecomAbTag;
            oVar.mKA = this.nXt.mRecomWeight;
            oVar.mKB = "";
            oVar.ePf = "";
            oVar.mKE = this.nXt.mMd5;
            if (this.mRect != null) {
                oVar.mKF = "1";
            } else {
                oVar.mKF = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.mKG = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.mKB = "index";
            }
            h.a(this.nXt.mMd5, "", "1", oVar, this.gBU.getPcdnState());
        }
    }

    private void dzW() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.f.dSn().gY(getContext());
        }
    }

    private void pausePlay() {
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
    public void dVA() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.nXt.thread_id, this.nXt.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.nXt.forum_id));
        createNormalCfg.setForumName(this.nXt.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(false);
        createNormalCfg.setBjhData(this.nXt.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVB() {
        if (this.izy == null) {
            this.iBk = new k(getActivity());
            this.izy = new i(getPageContext(), this.iBk);
            ArrayList arrayList = new ArrayList();
            com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getActivity().getString(R.string.mark), this.iBk);
            boolean z = false;
            if (this.nXt != null && this.nXt.post_id != null && this.nXt.post_id.equals(this.nXt.mark_id)) {
                z = true;
            }
            if (z) {
                gVar.setText(getResources().getString(R.string.remove_mark));
            } else {
                gVar.setText(getResources().getString(R.string.mark));
            }
            gVar.a(this.nXI);
            if (this.nXt != null && !this.nXt.isBjhVideo) {
                arrayList.add(gVar);
            }
            com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(getActivity().getString(R.string.report_text), this.iBk);
            gVar2.a(this.nXJ);
            arrayList.add(gVar2);
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(getActivity().getString(R.string.delete), this.iBk);
            gVar3.a(this.nXK);
            if (this.hmO) {
                arrayList.add(gVar3);
            }
            this.iBk.a(new k.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    VideoPlayFragment.this.cHJ();
                }
            });
            this.izy.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.izy = null;
                    VideoPlayFragment.this.iBk = null;
                    if (TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) || !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                    }
                }
            });
            this.iBk.bw(arrayList);
        }
        cHK();
    }

    public void cHJ() {
        if (this.izy != null && this.izy.isShowing()) {
            this.izy.dismiss();
        }
    }

    public void cHK() {
        if (this.izy != null && getActivity() != null && !getActivity().isFinishing()) {
            this.izy.QH();
        }
    }

    private void dVC() {
        if (this.nXt != null) {
            this.nWX.startLoad(this.nXt.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.nXt.title);
            if (StringUtils.isNull(this.nXt.title) || matcher.matches()) {
                this.nXi.setVisibility(8);
            } else {
                this.nXi.setVisibility(0);
                this.nXi.setTextSize(l.getDimens(getContext(), R.dimen.T_X07));
                this.nXi.setTextColor(R.color.CAM_X0101);
                this.nXi.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds2));
                this.nXi.setExpandable(true);
                this.nXi.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void rJ(boolean z) {
                        VideoPlayFragment.this.nXt.isTitleExpanded = z;
                    }
                });
                this.nXi.setData(this.nXt.title, this.nXt.isTitleExpanded);
            }
            this.nXj.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nXt.comment_num, 0L)));
            this.nXk.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nXt.agree_num, 0L)));
            this.nXl.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nXt.share_num, 0L)));
            if (this.nXt.author_info != null) {
                if (!TextUtils.isEmpty(this.nXt.author_info.bjhAvatar)) {
                    this.nWZ.startLoad(this.nXt.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.nXt.author_info.portrait) && this.nXt.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.nWZ.startLoad(this.nXt.author_info.portrait, 10, false);
                } else {
                    this.nWZ.startLoad(this.nXt.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.nXt.author_info.dSi())) {
                    this.nXx.setVisibility(8);
                } else {
                    this.nXx.setVisibility(0);
                    this.nXx.setText("@" + this.nXt.author_info.dSi());
                }
            }
            if ("1".equals(this.nXt.is_private) && this.nXu.getVisibility() != 0) {
                this.nXs.setVisibility(0);
            } else {
                this.nXs.setVisibility(8);
            }
            if ("1".equals(this.nXt.is_agreed)) {
                this.nXw.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
            } else {
                this.nXw.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
            }
            if (this.nXt.act_info != null && !StringUtils.isNull(this.nXt.act_info.activity_name) && this.nXu.getVisibility() != 0) {
                this.nXr.setVisibility(0);
                this.nXo.setText(this.nXt.act_info.activity_name);
            } else {
                this.nXr.setVisibility(8);
            }
            dVE();
            if (this.nXt.isBjhVideo) {
                this.nWY.setVisibility(8);
            } else {
                this.nWY.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVD() {
        if (this.nXt != null) {
            if ("1".equals(this.nXt.is_agreed)) {
                this.nXw.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
            } else {
                this.nXw.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
            }
            this.nXk.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nXt.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVE() {
        if (this.hmO || (this.nXt.author_info != null && "1".equals(this.nXt.author_info.is_follow))) {
            this.nXe.setVisibility(4);
            this.nXe.setClickable(false);
            return;
        }
        this.nXe.setVisibility(0);
        this.nXe.setClickable(true);
    }

    private void dVF() {
        if (getActivity() != null) {
            if (this.nXL == null || !this.nXL.isShowing()) {
                this.nXL = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.bsU().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
                this.nXL.bn(inflate);
                this.nXL.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.nXL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.nXL.nB(1);
                this.nXL.nz(R.color.CAM_X0105);
                this.nXL.jF(true);
                this.nXL.b(getPageContext());
                this.nXL.bqz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dVG() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.f.dSn().dSo() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !com.baidu.adp.lib.util.j.isMobileNet() || !this.eus) {
            return false;
        }
        if (this.nXh != null) {
            this.nXh.setVisibility(0);
        }
        pausePlay();
        dVF();
        return true;
    }

    private void resumePlay() {
        if (!dVG() && this.gBU != null && this.nXh != null && this.nXt != null) {
            if (this.gBU.getParent() == null) {
                dVL();
                dVM();
            }
            if (TbVideoViewSet.dAJ().QM(this.mVideoUrl) == null || TbVideoViewSet.dAJ().QM(this.mVideoUrl) != this.gBU) {
                this.gBU.setVideoPath(this.mVideoUrl, this.nXt.thread_id);
            }
            this.gBU.a((TbVideoViewSet.a) null);
            this.nXv.showProgress();
            this.nXh.setVisibility(8);
            dzW();
            if (this.nXH != null) {
                this.nXH.onStart();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0594a
    public void bIW() {
        if (this.gBU.isPlaying()) {
            this.gBU.pause();
            this.nXh.setVisibility(0);
            zj(false);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nXM);
        } else if (!dVG()) {
            this.gBU.start();
            this.nXh.setVisibility(8);
            zj(true);
            this.nXv.showProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(boolean z) {
        if (this.nXv != null) {
            this.nXv.setBottomBarShow(z);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0594a
    public void z(float f, float f2) {
        if (bh.checkUpIsLogin(getActivity())) {
            dVH();
            if (this.nXt != null && "0".equals(this.nXt.is_agreed)) {
                KX(this.nWW);
            }
        }
    }

    private void dVH() {
        if (this.mRootView != null && !this.nXC) {
            this.nXC = true;
            this.nXE = new TBLottieAnimationView(this.mRootView.getContext());
            if (this.nXD == null) {
                this.nXD = new RelativeLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396), TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396));
                this.nXD.addRule(13);
            }
            ap.a(this.nXE, R.raw.lottie_agree_big_photo);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.nXE, this.nXD);
            }
            this.nXE.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoPlayFragment.this.mRootView instanceof RelativeLayout) {
                        ((RelativeLayout) VideoPlayFragment.this.mRootView).removeView(VideoPlayFragment.this.nXE);
                    }
                    VideoPlayFragment.this.nXC = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.nXE.playAnimation();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0594a
    public void bIX() {
        if (this.nXt != null && this.nXt.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.nXt.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dVI() {
        return null;
    }

    public String dVJ() {
        return null;
    }

    public boolean dVK() {
        if (this.nXG == null || this.nXG.bBk() == null || !this.nXG.bBk().isVisible()) {
            return false;
        }
        this.nXG.bBk().hide();
        this.nXy.setVisibility(0);
        if ((this.nXG.bBk().qV(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.nXG.bBk().qV(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.nXG.bBk().qV(28)).getInputView().getText() != null) {
            this.nXz.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nXG.bBk().qV(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.nXG != null) {
            this.nXG.onActivityResult(i, i2, intent);
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
        if (this.nXG != null && this.nXG.bBk() != null) {
            this.nXG.bBk().onChangeSkinType(i);
        }
        if (this.iBk != null) {
            this.iBk.onChangeSkinType();
        }
        if (this.mRootView != null) {
            this.jpk.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_reply120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.hJo.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_share120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.nXg.setImageDrawable(WebPManager.a(R.drawable.icon_share_wechat120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.nXe.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_follow24, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.nXh.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
            com.baidu.tbadk.core.elementsMaven.c.br(this.nXy).oh(R.string.J_X01).setBackGroundColor(R.color.CAM_X0614);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nXm).ob(R.string.F_X02).nZ(R.color.CAM_X0101);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nXn).ob(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nXl).oa(R.dimen.T_X09).ob(R.string.F_X02).oj(R.array.S_O_X001);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nXk).oa(R.dimen.T_X09).ob(R.string.F_X02).oj(R.array.S_O_X001);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nXj).oa(R.dimen.T_X09).ob(R.string.F_X02).oj(R.array.S_O_X001);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nXx).oa(R.dimen.T_X06).ob(R.string.F_X02).oj(R.array.S_O_X001);
            this.nXn.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0101), com.baidu.tbadk.core.elementsMaven.a.nN(R.string.A_X08)));
            this.nXk.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0101), com.baidu.tbadk.core.elementsMaven.a.nN(R.string.A_X03)));
            this.nXl.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0101), com.baidu.tbadk.core.elementsMaven.a.nN(R.string.A_X03)));
            this.nXj.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0101), com.baidu.tbadk.core.elementsMaven.a.nN(R.string.A_X03)));
        }
        WebPManager.a(this.aFX, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.nWY, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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

    public void dVL() {
        if (this.gBU != null && this.gBU.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.gBU.getView(), 0);
            this.gBU.getView().setLayoutParams(layoutParams);
            if (this.nXt != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.anU = this.nXt.thread_id;
                oVar.eVa = this.nXt.nid;
                oVar.fOD = this.nXt.forum_id;
                oVar.mKE = this.nXt.mMd5;
                oVar.ePf = "";
                oVar.mSource = this.nXt.mRecomSource;
                oVar.mKD = this.nXt.mRecomAbTag;
                oVar.mKC = 1;
                if (this.nXt.baijiahaoData != null) {
                    if (this.nXt.baijiahaoData.oriUgcType == 2) {
                        oVar.mKC = 3;
                    } else if (this.nXt.baijiahaoData.oriUgcType == 4) {
                        oVar.mKC = 2;
                    }
                }
                oVar.mKA = this.nXt.mRecomWeight;
                if (this.mRect != null) {
                    oVar.mKF = "1";
                } else {
                    oVar.mKF = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.mKG = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.mKB = this.mFromPage;
                    oVar.ePf = this.ePf;
                    oVar.mKz = this.nXt.mRecomWeight;
                } else {
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
                }
                this.gBU.setVideoStatData(oVar);
                this.gBU.setLocateSource("v_mid_page");
            }
            this.gBU.setContinuePlayEnable(true);
        }
    }

    private void dVM() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.gBU.setOnPreparedListener(this.nXN);
        }
        this.gBU.setOnCompletionListener(this.mLl);
        this.gBU.setOnInfoListener(this.mLn);
    }
}
