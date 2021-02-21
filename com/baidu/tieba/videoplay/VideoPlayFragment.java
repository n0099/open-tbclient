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
/* loaded from: classes8.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0588a {
    public ImageView aEx;
    public LinearLayout bwE;
    private String eNE;
    private boolean esQ;
    private boolean fyn;
    public TbCyberVideoView gAl;
    private AlphaAnimation gDo;
    public ImageView hHF;
    private boolean hlf;
    private View iHu;
    private i ixP;
    private k izB;
    private int jiM;
    public ImageView jnB;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private f.b mHw;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private TbImageView nUT;
    public ImageView nUU;
    public HeadImageView nUV;
    public LinearLayout nUW;
    public LinearLayout nUX;
    public LinearLayout nUY;
    public LinearLayout nUZ;
    private TBLottieAnimationView nVA;
    private com.baidu.tieba.videoplay.editor.a nVC;
    private a nVD;
    com.baidu.tbadk.core.dialog.a nVH;
    public ImageView nVa;
    public ImageView nVb;
    public ImageView nVc;
    public ImageView nVd;
    public ExpandableTextView nVe;
    public EMTextView nVf;
    public EMTextView nVg;
    public EMTextView nVh;
    public EMTextView nVi;
    public EMTextView nVj;
    private TextView nVk;
    private FrameLayout nVl;
    private LinearLayout nVm;
    public LinearLayout nVn;
    public LinearLayout nVo;
    public VideoItemData nVp;
    private TextView nVq;
    private VideoMiddleNiaiControllerView nVr;
    public ImageView nVs;
    public TextView nVt;
    private View nVu;
    private TextView nVv;
    private int nVw;
    private int nVx;
    private RelativeLayout.LayoutParams nVz;
    private int nUR = 0;
    private int nUS = 1;
    private ForumManageModel gev = null;
    private com.baidu.tbadk.baseEditMark.a lRQ = null;
    private com.baidu.tbadk.coreExtra.model.a faF = null;
    private BdUniqueId agC = BdUniqueId.gen();
    private boolean nVy = false;
    private boolean nVB = false;
    private int playTime = 1;
    private CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.nVp != null && VideoPlayFragment.this.nVp.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nVp.author_info.user_id) && data != null && VideoPlayFragment.this.nVp.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.agC)) ? false : false;
                    if (data.fsD == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.nVp.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.nVp.author_info.is_follow = "0";
                                VideoPlayFragment.this.dVw();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.esQ) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.nVp));
                                } else {
                                    VideoPlayFragment.this.nVp.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dVw();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.nVp.author_info.is_follow = "0";
                            VideoPlayFragment.this.dVw();
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
                VideoPlayFragment.this.dVy();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.nVp != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.nVp.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.nVp.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.nVp.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.nVp.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dVv();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.nVp.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.nVp.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.nVp.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dVv();
                    }
                }
            }
        }
    };
    private k.b nVE = new k.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!bh.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                VideoPlayFragment.this.ixP.dismiss();
                return;
            }
            VideoPlayFragment.this.ixP.dismiss();
            if (VideoPlayFragment.this.nVp != null) {
                boolean z = VideoPlayFragment.this.nVp.post_id != null && VideoPlayFragment.this.nVp.post_id.equals(VideoPlayFragment.this.nVp.mark_id);
                MarkData markData = new MarkData();
                Date date = new Date();
                markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                markData.setThreadId(VideoPlayFragment.this.nVp.thread_id);
                markData.setPostId(VideoPlayFragment.this.nVp.post_id);
                markData.setTime(date.getTime());
                markData.setHostMode(false);
                markData.setId(VideoPlayFragment.this.nVp.thread_id);
                markData.setForumId(VideoPlayFragment.this.nVp.forum_id);
                if (VideoPlayFragment.this.lRQ != null) {
                    VideoPlayFragment.this.lRQ.a(markData);
                    if (!z) {
                        VideoPlayFragment.this.lRQ.bkb();
                    } else {
                        VideoPlayFragment.this.lRQ.bka();
                    }
                }
            }
        }
    };
    private k.b nVF = new k.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            VideoPlayFragment.this.ixP.dismiss();
            if (bh.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nVp != null) {
                String str = VideoPlayFragment.this.nVp.thread_id;
                String str2 = VideoPlayFragment.this.nVp.forum_id;
                String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.nVp.post_id;
                if (VideoPlayFragment.this.nVp.isBjhVideo) {
                    str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.nVp.post_id) + "&channelid=33840";
                    string = "";
                }
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                if (VideoPlayFragment.this.nVp.isBjhVideo) {
                    tbWebViewActivityConfig.setFixTitle(true);
                }
                VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
            }
        }
    };
    private k.b nVG = new k.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            VideoPlayFragment.this.ixP.dismiss();
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
            aVar.nx(R.string.del_thread_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (VideoPlayFragment.this.nVp != null) {
                        VideoPlayFragment.this.gev.a(VideoPlayFragment.this.nVp.forum_id, VideoPlayFragment.this.nVp.forum_name, VideoPlayFragment.this.nVp.thread_id, VideoPlayFragment.this.nVp.post_id, 0, 0, VideoPlayFragment.this.hlf, null);
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
            aVar.bqx();
        }
    };
    private Runnable nVI = new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // java.lang.Runnable
        public void run() {
            if (!VideoPlayFragment.this.fyn) {
                VideoPlayFragment.this.zk(true);
            }
        }
    };
    private CyberPlayerManager.OnInfoListener mJl = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.esQ) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.nUT.getVisibility() == 0) {
                    VideoPlayFragment.this.nUT.clearAnimation();
                    VideoPlayFragment.this.nUT.startAnimation(VideoPlayFragment.this.gDo);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener mJj = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.gAl != null) {
                VideoPlayFragment.this.gAl.dAA();
                VideoPlayFragment.this.gAl.seekTo(0);
                VideoPlayFragment.this.gAl.start();
                VideoPlayFragment.this.csi();
                VideoPlayFragment.D(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dVp();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener nVJ = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.gAl != null) {
                VideoPlayFragment.this.gAl.setVolume(1.0f, 1.0f);
                if (VideoPlayFragment.this.gAl.getDuration() < 15000 || VideoPlayFragment.this.nVr == null) {
                    VideoPlayFragment.this.nVr.setVisibility(8);
                    return;
                }
                VideoPlayFragment.this.nVr.setVisibility(0);
                if (VideoPlayFragment.this.nVr.getCurProgress() == 0) {
                    VideoPlayFragment.this.nVr.showProgress();
                }
            }
        }
    };

    /* loaded from: classes8.dex */
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
        this.nVp = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.nVx = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.eNE = arguments.getString("obj_id");
        if (this.nVp != null && this.nVp.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.nVp.author_info.user_id)) {
            this.hlf = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.gAl = new TbCyberVideoView(getContext());
        this.gAl.setStageType("2005");
        this.gAl.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // com.baidu.tieba.play.f.b
            public void cf(int i, int i2) {
                if (VideoPlayFragment.this.mHw != null) {
                    VideoPlayFragment.this.mHw.cf(i, i2);
                }
            }
        });
        dVD();
        this.nUT = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.nUT.setPlaceHolder(4);
        if (g.bsa() || (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity()))) {
            this.iHu = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.iHu.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.iHu.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aEx = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.nUU = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.nUV = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.nUV.setDefaultResource(17170445);
        this.nUV.setPlaceHolder(2);
        this.nUV.setIsRound(true);
        this.nVl = (FrameLayout) this.mRootView.findViewById(R.id.author_info_container);
        this.bwE = (LinearLayout) this.mRootView.findViewById(R.id.bottom_container);
        this.nVa = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.nVs = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.nVe = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.nVr = (VideoMiddleNiaiControllerView) this.mRootView.findViewById(R.id.media_controller);
        this.nVk = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.nUX = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.nVf = (EMTextView) this.mRootView.findViewById(R.id.comment_num);
        this.jnB = (ImageView) this.mRootView.findViewById(R.id.comment_img);
        this.nUW = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.nUZ = (LinearLayout) this.mRootView.findViewById(R.id.ll_drag_container);
        this.nVg = (EMTextView) this.mRootView.findViewById(R.id.agree_num);
        this.hHF = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nVh = (EMTextView) this.mRootView.findViewById(R.id.share_num);
        this.nVi = (EMTextView) this.mRootView.findViewById(R.id.drag_cur_time);
        this.nVj = (EMTextView) this.mRootView.findViewById(R.id.drag_total_time);
        this.nVb = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nVc = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dVq();
        this.nVd = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.nVm = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.nVn = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.nVo = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.nUY = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.nVt = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.nVu = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.nVu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.nVu.setVisibility(4);
                    if (VideoPlayFragment.this.nVC != null && VideoPlayFragment.this.nVC.bBh() != null) {
                        VideoPlayFragment.this.nVC.bBh().display();
                        if (VideoPlayFragment.this.nVp != null) {
                            VideoPlayFragment.this.nVC.c(VideoPlayFragment.this.nVp);
                        }
                    }
                    if (VideoPlayFragment.this.nVp != null) {
                        ar arVar = new ar("c13025");
                        arVar.dR("tid", VideoPlayFragment.this.nVp.thread_id);
                        arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                        arVar.dR("fid", VideoPlayFragment.this.nVp.forum_id);
                        TiebaStatic.log(arVar);
                    }
                }
            }
        });
        if (this.nVp != null) {
            if (this.nVp.video_duration > 15) {
                this.nVr.setVisibility(0);
            } else {
                this.nVr.setVisibility(8);
            }
        }
        this.nVr.setPlayer(this.gAl);
        this.nVr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoPlayFragment.this.zj(true);
                    if (VideoPlayFragment.this.nVi != null) {
                        VideoPlayFragment.this.nVi.setText(au.stringForVideoTime(i));
                    }
                    if (VideoPlayFragment.this.nVj != null) {
                        VideoPlayFragment.this.nVj.setText("/" + au.stringForVideoTime(VideoPlayFragment.this.gAl.getDuration()));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoPlayFragment.this.fyn = true;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                    seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_navi_seekbar_thumb_pressed));
                    seekBar.setProgressDrawable(TbadkCoreApplication.getInst().getDrawable(R.drawable.video_navi_video_eight_width_seekbar));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoPlayFragment.this.fyn = false;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                    seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                    VideoPlayFragment.this.zj(false);
                    if (!VideoPlayFragment.this.gAl.isPlaying()) {
                        VideoPlayFragment.this.gAl.start();
                        VideoPlayFragment.this.nVd.setVisibility(8);
                    }
                    com.baidu.adp.lib.f.e.mA().postDelayed(VideoPlayFragment.this.nVI, IMConnection.RETRY_DELAY_TIMES);
                }
            }
        });
        this.nVv = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.nVq = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.nVq.setVisibility(8);
        String string = b.brQ().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.nVq.setText(string);
        }
        final String string2 = b.brQ().getString("nani_key_download_link_url", null);
        this.nVq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    bf.bsV().a((TbPageContext) j.K(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dVu();
        this.nUV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nVp != null && VideoPlayFragment.this.nVp.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nVp.author_info.user_id) && VideoPlayFragment.this.nVp != null && VideoPlayFragment.this.nVp.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nVp.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    ar arVar = new ar("c12798");
                    arVar.dR("tid", VideoPlayFragment.this.nVp.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nVn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nVp != null && VideoPlayFragment.this.nVp.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.nVp.act_info.link_url);
                    ar arVar = new ar("c12799");
                    arVar.dR("tid", VideoPlayFragment.this.nVp.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nVe.setHasDown();
        this.nVe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dVs();
            }
        });
        this.aEx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nVp != null && !StringUtils.isNull(VideoPlayFragment.this.nVp.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.nVp.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.nUU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dVt();
            }
        });
        this.nUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.nVp)) {
                    VideoPlayFragment.this.dVs();
                    ar arVar = new ar("c12796");
                    arVar.dR("tid", VideoPlayFragment.this.nVp.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nUW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.KS(VideoPlayFragment.this.nUR);
            }
        });
        this.nUY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.buF();
                ar arVar = new ar("c12797");
                arVar.dR("tid", VideoPlayFragment.this.nVp.thread_id);
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar);
                ar arVar2 = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar2.dR("tid", VideoPlayFragment.this.nVp.thread_id);
                arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar2.ap("obj_locate", 19);
                arVar2.dR(IntentConfig.NID, VideoPlayFragment.this.nVp.nid);
                if (VideoPlayFragment.this.nVp.baijiahaoData != null && !au.isEmpty(VideoPlayFragment.this.nVp.baijiahaoData.oriUgcVid)) {
                    arVar2.dR("obj_param6", VideoPlayFragment.this.nVp.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.nVp.getVideoType() == 1) {
                    arVar2.ap(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.nVp.getVideoType() == 2) {
                    arVar2.ap(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.nVp.getVideoType() == 3) {
                    arVar2.ap(IntentConfig.CARD_TYPE, 6);
                }
                arVar2.dR(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.nVp.mRecomSource);
                arVar2.dR("ab_tag", VideoPlayFragment.this.nVp.mRecomAbTag);
                arVar2.dR("weight", VideoPlayFragment.this.nVp.mRecomWeight);
                arVar2.dR("extra", VideoPlayFragment.this.nVp.mRecomExtra);
                arVar2.dR("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.fr(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.fr(VideoPlayFragment.this.getBaseFragmentActivity()).bDP() != null && c.fr(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.fr(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    arVar2.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    arVar2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(arVar2);
            }
        });
        this.nVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nVa != null && VideoPlayFragment.this.nVp != null && VideoPlayFragment.this.nVp.author_info != null) {
                    VideoPlayFragment.this.faF.a(true, VideoPlayFragment.this.nVp.author_info.portrait, VideoPlayFragment.this.nVp.author_info.user_id, false, "6", VideoPlayFragment.this.agC, VideoPlayFragment.this.nVp.forum_id, "0");
                    VideoPlayFragment.this.nVp.author_info.is_follow = "1";
                    VideoPlayFragment.this.dVw();
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(300L);
                    VideoPlayFragment.this.nVa.startAnimation(scaleAnimation);
                }
            }
        });
        this.gDo = new AlphaAnimation(1.0f, 0.0f);
        this.gDo.setDuration(100L);
        this.gDo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.nUT != null) {
                    VideoPlayFragment.this.nUT.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.nVw = this.mRect.right - this.mRect.left;
            this.jiM = this.mRect.bottom - this.mRect.top;
            this.nUT.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2;
                    int width = VideoPlayFragment.this.nUT.getWidth();
                    int height = VideoPlayFragment.this.nUT.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nVp.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nVp.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nVp.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nVp.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nVw, VideoPlayFragment.this.jiM);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.nUT.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jiM > 0 || VideoPlayFragment.this.nVw <= 0) {
                                f = 1.0f;
                                f2 = 1.0f;
                            } else {
                                f = i / VideoPlayFragment.this.jiM;
                                f2 = i2 / VideoPlayFragment.this.nVw;
                            }
                            VideoPlayFragment.this.nUT.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.nUT.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.esQ) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nVw, VideoPlayFragment.this.jiM);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.nUT.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jiM > 0) {
                    }
                    f = 1.0f;
                    f2 = 1.0f;
                    VideoPlayFragment.this.nUT.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.nUT.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.esQ) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.nUT.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.nUT.getWidth();
                    int height = VideoPlayFragment.this.nUT.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nVp.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nVp.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nVp.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nVp.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.nUT.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.nUT.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        dae();
        if (this.esQ) {
            dVr();
        }
        if (this.nVp != null && !StringUtils.isNull(this.nVp.video_url)) {
            UR(this.nVp.video_url);
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(boolean z) {
        if (z) {
            this.nUW.setVisibility(8);
            this.nVl.setVisibility(8);
            this.nUX.setVisibility(8);
            this.nUY.setVisibility(8);
            this.bwE.setVisibility(8);
            this.nUZ.setVisibility(0);
            return;
        }
        this.nUW.setVisibility(0);
        this.nVl.setVisibility(0);
        this.nUX.setVisibility(0);
        this.nUY.setVisibility(0);
        this.bwE.setVisibility(0);
        this.nUZ.setVisibility(8);
    }

    public void a(f.b bVar) {
        this.mHw = bVar;
    }

    public void a(a aVar) {
        this.nVD = aVar;
    }

    private void dae() {
        this.nVC = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().fg(getActivity());
        if (this.nVC != null && this.nVp != null) {
            this.nVC.a(getPageContext());
            this.nVC.aQ(this.nVp.thread_id, this.nVp.forum_id, this.nVp.forum_name);
            this.nVC.a(new a.InterfaceC0896a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0896a
                public void zl(boolean z) {
                    VideoPlayFragment.this.nVu.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.nVv.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.nVv.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.nVC.bBh().qU(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.nVp != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nVp.comment_num, 0L) + 1;
                        VideoPlayFragment.this.nVp.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.nVf.setText(au.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.nVC.bBh(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buF() {
        String str;
        String str2;
        if (this.nVp != null) {
            String str3 = this.nVp.forum_id;
            String str4 = this.nVp.forum_name;
            String str5 = this.nVp.title;
            if (this.nVp.baijiahaoData != null) {
                str = this.nVp.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.nVp.baijiahaoData.oriUgcType + "&dvid=" + this.nVp.baijiahaoData.oriUgcVid + "&nid=" + this.nVp.baijiahaoData.oriUgcNid;
            } else {
                str = this.nVp.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str7 = this.nVp.thumbnail_url;
            String format = (!this.nVp.isBjhVideo || this.nVp.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.nVp.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.nVp.baijiahaoData == null) {
                shareItem.readCount = this.nVp.play_count;
            }
            if (this.nVp.isBjhVideo) {
                shareItem.fuV = format;
            } else {
                shareItem.fuV = "";
            }
            shareItem.linkUrl = str6;
            shareItem.eUk = 2;
            shareItem.extData = str;
            shareItem.fuY = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.fuK = true;
            shareItem.fuX = 12;
            if (this.nVp.getVideoType() == 1) {
                shareItem.fvc = 2;
            } else if (this.nVp.getVideoType() == 2) {
                shareItem.fvc = 8;
            } else if (this.nVp.getVideoType() == 3) {
                shareItem.fvc = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.nVp.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.nVp.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.nVp.title;
            originalThreadInfo.threadId = this.nVp.thread_id;
            originalThreadInfo.oriUgcInfo = this.nVp.baijiahaoData;
            shareItem.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fuY);
            bundle.putInt("obj_type", shareItem.fvc);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eUk);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.f.ctG().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.hlf) {
            this.gev = new ForumManageModel(getPageContext());
            this.gev.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.gev.getLoadDataMode()) {
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
        this.lRQ = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.lRQ != null) {
            this.lRQ.a(new a.InterfaceC0554a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0554a
                public void g(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.lRQ != null) {
                            VideoPlayFragment.this.lRQ.ja(z2);
                        }
                        if (VideoPlayFragment.this.nVp != null) {
                            if (z2) {
                                VideoPlayFragment.this.nVp.mark_id = VideoPlayFragment.this.nVp.post_id;
                            } else {
                                VideoPlayFragment.this.nVp.mark_id = null;
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
        this.faF = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.faJ);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.nVB = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dVu();
        dVE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVp() {
        if (this.nVc != null && this.nVb != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.nVb.clearAnimation();
            this.nVc.clearAnimation();
            this.nVb.setVisibility(8);
            this.nVc.setVisibility(0);
            this.nVc.startAnimation(scaleAnimation2);
            this.nVb.startAnimation(scaleAnimation);
        }
    }

    private void dVq() {
        if (this.nVc != null && this.nVb != null) {
            this.nVb.clearAnimation();
            this.nVc.clearAnimation();
            this.nVb.setVisibility(0);
            this.nVc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KS(int i) {
        int i2;
        if (bh.checkUpIsLogin(getActivity()) && this.nVp != null) {
            if (i == this.nUR) {
                if ("1".equals(this.nVp.is_agreed)) {
                    i2 = 1;
                    this.nVp.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nVp.agree_num, 0) - 1);
                    this.nVp.is_agreed = "0";
                } else {
                    this.nVp.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nVp.agree_num, 0) + 1);
                    this.nVp.is_agreed = "1";
                    dVz();
                    i2 = 0;
                }
            } else {
                this.nVp.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nVp.agree_num, 0) + 1);
                this.nVp.is_agreed = "1";
                i2 = 0;
            }
            ar arVar = new ar("c12795");
            arVar.dR("tid", this.nVp.thread_id);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nUR) {
                arVar.ap("obj_type", i2);
            } else {
                arVar.ap("obj_type", 2);
            }
            TiebaStatic.log(arVar);
            ar arVar2 = new ar("c12003");
            arVar2.dR("tid", this.nVp.thread_id);
            arVar2.v("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nUR) {
                arVar2.ap("obj_type", i2);
            } else {
                arVar2.ap("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                arVar2.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                arVar2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            com.baidu.tbadk.pageExtra.c fq = d.fq(getContext());
            if (fq != null) {
                arVar2.dR("obj_cur_page", fq.getCurrentPageKey());
            }
            if (d.bDM() != null) {
                arVar2.dR("obj_pre_page", d.bDM());
            }
            TiebaStatic.log(arVar2);
            dVu();
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.nVp.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.nVp.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.nVp.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.nVp.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.nVp.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.nVp.baijiahaoData.oriUgcType);
            }
            if (fq != null) {
                httpMessage.addParam("obj_source", fq.getCurrentPageKey());
            }
            sendMessage(httpMessage);
            e eVar = new e();
            AgreeData agreeData = new AgreeData();
            if (this.nVp.thread_id != null) {
                agreeData.threadId = this.nVp.thread_id;
            }
            agreeData.agreeNum = Long.valueOf(this.nVp.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.nVp.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.nVp));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (TbSingleton.getInstance().isNotchScreen(getActivity()) || !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
        }
        if (this.nVp != null && !StringUtils.isNull(this.nVp.video_url)) {
            this.mHasInit = true;
            if (this.esQ) {
                csi();
                resumePlay();
                KT(0);
                return;
            }
            pausePlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        pausePlay();
        if (this.nVC != null && this.nVC.bBh() != null) {
            this.nVC.bBh().hide();
            this.nVu.setVisibility(0);
            this.nVv.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nVC.bBh().qU(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.nVC != null) {
            this.nVC.onDestroy();
        }
        if (this.nVI != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nVI);
            this.nVI = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.esQ = z;
        if (!z && this.nVC != null) {
            this.nVv.setText(R.string.reply_something);
            this.nVC.cGV();
        }
        if (this.mHasInit) {
            if (this.esQ && (!this.nVB || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                KT(1);
                startPlay();
                dVr();
                this.nVB = false;
                return;
            }
            dVq();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void dVr() {
        if (this.nVp != null) {
            ar arVar = new ar("c12590");
            arVar.dR("tid", this.nVp.thread_id);
            arVar.dR(IntentConfig.NID, this.nVp.nid);
            arVar.dR("fid", this.nVp.forum_id);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.ap("obj_locate", this.nVx);
            arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, 1);
            arVar.dR("obj_param1", au.isEmpty(this.nVp.mRecomWeight) ? "0" : this.nVp.mRecomWeight);
            arVar.dR("extra", au.isEmpty(this.nVp.mRecomExtra) ? "0" : this.nVp.mRecomExtra);
            arVar.dR("obj_id", this.eNE);
            arVar.dR("ab_tag", au.isEmpty(this.nVp.mRecomAbTag) ? "0" : this.nVp.mRecomAbTag);
            arVar.dR("obj_source", au.isEmpty(this.nVp.mRecomSource) ? "0" : this.nVp.mRecomSource);
            arVar.dR("obj_type", this.mFromPage);
            arVar.ap("is_vertical", 1);
            if (this.nVp.baijiahaoData != null) {
                arVar.dR("obj_param4", this.nVp.baijiahaoData.oriUgcNid);
                arVar.dR("obj_param6", this.nVp.baijiahaoData.oriUgcVid);
                if (this.nVp.baijiahaoData.oriUgcType == 4) {
                    arVar.ap("obj_param5", 2);
                } else if (this.nVp.baijiahaoData.oriUgcType == 2) {
                    arVar.ap("obj_param5", 3);
                }
            } else {
                arVar.ap("obj_param5", 1);
            }
            TiebaStatic.log(arVar);
        }
    }

    private void KT(int i) {
        if (this.nVp != null && this.mRect == null) {
            ar arVar = new ar("c12794");
            arVar.dR("tid", this.nVp.thread_id);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.ap("obj_type", i);
            TiebaStatic.log(arVar);
            ar arVar2 = new ar("common_exp");
            arVar2.dR("tid", this.nVp.thread_id);
            arVar2.v("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar2.ap("obj_type", i);
            arVar2.dR("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            arVar2.dR("page_type", PageStayDurationConstants.PageName.VIDEO_LIST);
            arVar2.ap("is_vertical", 1);
            TiebaStatic.log(arVar2);
        }
    }

    private void UR(String str) {
        if (this.gAl != null && str != null && !str.equals(this.mVideoUrl)) {
            this.gAl.setVideoPath(str, this.nVp.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dVy()) {
            dzN();
            if (this.nVd != null) {
                this.nVd.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.nUT.getVisibility() == 0) {
                this.nUT.clearAnimation();
                this.nUT.startAnimation(this.gDo);
            }
            if (this.gAl != null) {
                if (TbVideoViewSet.dAB().QG(this.mVideoUrl) == null || TbVideoViewSet.dAB().QG(this.mVideoUrl) != this.gAl) {
                    this.gAl.setVideoPath(this.mVideoUrl, this.nVp.thread_id);
                }
                this.gAl.start();
                this.nVr.showProgress();
                csi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csi() {
        if (this.nVp != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.amC = this.nVp.thread_id;
            oVar.eTz = this.nVp.nid;
            oVar.fNd = this.nVp.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.nVp.mRecomSource;
            oVar.mIv = this.nVp.mRecomAbTag;
            oVar.mIw = this.nVp.mRecomWeight;
            oVar.mIx = "";
            oVar.eNE = "";
            oVar.mIA = this.nVp.mMd5;
            if (this.mRect != null) {
                oVar.mIB = "1";
            } else {
                oVar.mIB = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.mIC = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.mIx = "index";
            }
            h.a(this.nVp.mMd5, "", "1", oVar, this.gAl.getPcdnState());
        }
    }

    private void dzN() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.f.dSf().gZ(getContext());
        }
    }

    private void pausePlay() {
        if (this.gAl != null) {
            this.gAl.pause();
        }
    }

    private void stopPlay() {
        if (this.gAl != null) {
            this.gAl.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVs() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.nVp.thread_id, this.nVp.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.nVp.forum_id));
        createNormalCfg.setForumName(this.nVp.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(false);
        createNormalCfg.setBjhData(this.nVp.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVt() {
        if (this.ixP == null) {
            this.izB = new k(getActivity());
            this.ixP = new i(getPageContext(), this.izB);
            ArrayList arrayList = new ArrayList();
            com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getActivity().getString(R.string.mark), this.izB);
            boolean z = false;
            if (this.nVp != null && this.nVp.post_id != null && this.nVp.post_id.equals(this.nVp.mark_id)) {
                z = true;
            }
            if (z) {
                gVar.setText(getResources().getString(R.string.remove_mark));
            } else {
                gVar.setText(getResources().getString(R.string.mark));
            }
            gVar.a(this.nVE);
            if (this.nVp != null && !this.nVp.isBjhVideo) {
                arrayList.add(gVar);
            }
            com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(getActivity().getString(R.string.report_text), this.izB);
            gVar2.a(this.nVF);
            arrayList.add(gVar2);
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(getActivity().getString(R.string.delete), this.izB);
            gVar3.a(this.nVG);
            if (this.hlf) {
                arrayList.add(gVar3);
            }
            this.izB.a(new k.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    VideoPlayFragment.this.cHD();
                }
            });
            this.ixP.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.ixP = null;
                    VideoPlayFragment.this.izB = null;
                    if (TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) || !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                    }
                }
            });
            this.izB.bw(arrayList);
        }
        cHE();
    }

    public void cHD() {
        if (this.ixP != null && this.ixP.isShowing()) {
            this.ixP.dismiss();
        }
    }

    public void cHE() {
        if (this.ixP != null && getActivity() != null && !getActivity().isFinishing()) {
            this.ixP.QE();
        }
    }

    private void dVu() {
        if (this.nVp != null) {
            this.nUT.startLoad(this.nVp.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.nVp.title);
            if (StringUtils.isNull(this.nVp.title) || matcher.matches()) {
                this.nVe.setVisibility(8);
            } else {
                this.nVe.setVisibility(0);
                this.nVe.setTextSize(l.getDimens(getContext(), R.dimen.T_X07));
                this.nVe.setTextColor(R.color.CAM_X0101);
                this.nVe.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds2));
                this.nVe.setExpandable(true);
                this.nVe.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void rJ(boolean z) {
                        VideoPlayFragment.this.nVp.isTitleExpanded = z;
                    }
                });
                this.nVe.setData(this.nVp.title, this.nVp.isTitleExpanded);
            }
            this.nVf.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nVp.comment_num, 0L)));
            this.nVg.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nVp.agree_num, 0L)));
            this.nVh.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nVp.share_num, 0L)));
            if (this.nVp.author_info != null) {
                if (!TextUtils.isEmpty(this.nVp.author_info.bjhAvatar)) {
                    this.nUV.startLoad(this.nVp.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.nVp.author_info.portrait) && this.nVp.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.nUV.startLoad(this.nVp.author_info.portrait, 10, false);
                } else {
                    this.nUV.startLoad(this.nVp.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.nVp.author_info.dSa())) {
                    this.nVt.setVisibility(8);
                } else {
                    this.nVt.setVisibility(0);
                    this.nVt.setText("@" + this.nVp.author_info.dSa());
                }
            }
            if ("1".equals(this.nVp.is_private) && this.nVq.getVisibility() != 0) {
                this.nVo.setVisibility(0);
            } else {
                this.nVo.setVisibility(8);
            }
            if ("1".equals(this.nVp.is_agreed)) {
                this.nVs.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
            } else {
                this.nVs.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
            }
            if (this.nVp.act_info != null && !StringUtils.isNull(this.nVp.act_info.activity_name) && this.nVq.getVisibility() != 0) {
                this.nVn.setVisibility(0);
                this.nVk.setText(this.nVp.act_info.activity_name);
            } else {
                this.nVn.setVisibility(8);
            }
            dVw();
            if (this.nVp.isBjhVideo) {
                this.nUU.setVisibility(8);
            } else {
                this.nUU.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVv() {
        if (this.nVp != null) {
            if ("1".equals(this.nVp.is_agreed)) {
                this.nVs.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
            } else {
                this.nVs.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
            }
            this.nVg.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nVp.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVw() {
        if (this.hlf || (this.nVp.author_info != null && "1".equals(this.nVp.author_info.is_follow))) {
            this.nVa.setVisibility(4);
            this.nVa.setClickable(false);
            return;
        }
        this.nVa.setVisibility(0);
        this.nVa.setClickable(true);
    }

    private void dVx() {
        if (getActivity() != null) {
            if (this.nVH == null || !this.nVH.isShowing()) {
                this.nVH = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.bsR().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
                this.nVH.bn(inflate);
                this.nVH.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.nVH.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.nVH.nA(1);
                this.nVH.ny(R.color.CAM_X0105);
                this.nVH.jF(true);
                this.nVH.b(getPageContext());
                this.nVH.bqx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dVy() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.f.dSf().dSg() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !com.baidu.adp.lib.util.j.isMobileNet() || !this.esQ) {
            return false;
        }
        if (this.nVd != null) {
            this.nVd.setVisibility(0);
        }
        pausePlay();
        dVx();
        return true;
    }

    private void resumePlay() {
        if (!dVy() && this.gAl != null && this.nVd != null && this.nVp != null) {
            if (this.gAl.getParent() == null) {
                dVD();
                dVE();
            }
            if (TbVideoViewSet.dAB().QG(this.mVideoUrl) == null || TbVideoViewSet.dAB().QG(this.mVideoUrl) != this.gAl) {
                this.gAl.setVideoPath(this.mVideoUrl, this.nVp.thread_id);
            }
            this.gAl.a((TbVideoViewSet.a) null);
            this.nVr.showProgress();
            this.nVd.setVisibility(8);
            dzN();
            if (this.nVD != null) {
                this.nVD.onStart();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0588a
    public void bIS() {
        if (this.gAl.isPlaying()) {
            this.gAl.pause();
            this.nVd.setVisibility(0);
            zk(false);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nVI);
        } else if (!dVy()) {
            this.gAl.start();
            this.nVd.setVisibility(8);
            zk(true);
            this.nVr.showProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(boolean z) {
        if (this.nVr != null) {
            this.nVr.setBottomBarShow(z);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0588a
    public void z(float f, float f2) {
        if (bh.checkUpIsLogin(getActivity())) {
            dVz();
            if (this.nVp != null && "0".equals(this.nVp.is_agreed)) {
                KS(this.nUS);
            }
        }
    }

    private void dVz() {
        if (this.mRootView != null && !this.nVy) {
            this.nVy = true;
            this.nVA = new TBLottieAnimationView(this.mRootView.getContext());
            if (this.nVz == null) {
                this.nVz = new RelativeLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396), TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396));
                this.nVz.addRule(13);
            }
            ap.a(this.nVA, R.raw.lottie_agree_big_photo);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.nVA, this.nVz);
            }
            this.nVA.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoPlayFragment.this.mRootView instanceof RelativeLayout) {
                        ((RelativeLayout) VideoPlayFragment.this.mRootView).removeView(VideoPlayFragment.this.nVA);
                    }
                    VideoPlayFragment.this.nVy = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.nVA.playAnimation();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0588a
    public void bIT() {
        if (this.nVp != null && this.nVp.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.nVp.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dVA() {
        return null;
    }

    public String dVB() {
        return null;
    }

    public boolean dVC() {
        if (this.nVC == null || this.nVC.bBh() == null || !this.nVC.bBh().isVisible()) {
            return false;
        }
        this.nVC.bBh().hide();
        this.nVu.setVisibility(0);
        if ((this.nVC.bBh().qU(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.nVC.bBh().qU(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.nVC.bBh().qU(28)).getInputView().getText() != null) {
            this.nVv.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nVC.bBh().qU(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.nVC != null) {
            this.nVC.onActivityResult(i, i2, intent);
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
        if (this.nVC != null && this.nVC.bBh() != null) {
            this.nVC.bBh().onChangeSkinType(i);
        }
        if (this.izB != null) {
            this.izB.onChangeSkinType();
        }
        if (this.mRootView != null) {
            this.jnB.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_reply120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.hHF.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_share120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.nVc.setImageDrawable(WebPManager.a(R.drawable.icon_share_wechat120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.nVa.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_follow24, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.nVd.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
            com.baidu.tbadk.core.elementsMaven.c.br(this.nVu).og(R.string.J_X01).setBackGroundColor(R.color.CAM_X0614);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nVi).oa(R.string.F_X02).nY(R.color.CAM_X0101);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nVj).oa(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nVh).nZ(R.dimen.T_X09).oa(R.string.F_X02).oi(R.array.S_O_X001);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nVg).nZ(R.dimen.T_X09).oa(R.string.F_X02).oi(R.array.S_O_X001);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nVf).nZ(R.dimen.T_X09).oa(R.string.F_X02).oi(R.array.S_O_X001);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nVt).nZ(R.dimen.T_X06).oa(R.string.F_X02).oi(R.array.S_O_X001);
            this.nVj.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0101), com.baidu.tbadk.core.elementsMaven.a.nM(R.string.A_X08)));
            this.nVg.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0101), com.baidu.tbadk.core.elementsMaven.a.nM(R.string.A_X03)));
            this.nVh.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0101), com.baidu.tbadk.core.elementsMaven.a.nM(R.string.A_X03)));
            this.nVf.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0101), com.baidu.tbadk.core.elementsMaven.a.nM(R.string.A_X03)));
        }
        WebPManager.a(this.aEx, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.nUU, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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

    public void dVD() {
        if (this.gAl != null && this.gAl.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.gAl.getView(), 0);
            this.gAl.getView().setLayoutParams(layoutParams);
            if (this.nVp != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.amC = this.nVp.thread_id;
                oVar.eTz = this.nVp.nid;
                oVar.fNd = this.nVp.forum_id;
                oVar.mIA = this.nVp.mMd5;
                oVar.eNE = "";
                oVar.mSource = this.nVp.mRecomSource;
                oVar.mIz = this.nVp.mRecomAbTag;
                oVar.mIy = 1;
                if (this.nVp.baijiahaoData != null) {
                    if (this.nVp.baijiahaoData.oriUgcType == 2) {
                        oVar.mIy = 3;
                    } else if (this.nVp.baijiahaoData.oriUgcType == 4) {
                        oVar.mIy = 2;
                    }
                }
                oVar.mIw = this.nVp.mRecomWeight;
                if (this.mRect != null) {
                    oVar.mIB = "1";
                } else {
                    oVar.mIB = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.mIC = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.mIx = this.mFromPage;
                    oVar.eNE = this.eNE;
                    oVar.mIv = this.nVp.mRecomWeight;
                } else {
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
                }
                this.gAl.setVideoStatData(oVar);
                this.gAl.setLocateSource("v_mid_page");
            }
            this.gAl.setContinuePlayEnable(true);
        }
    }

    private void dVE() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.gAl.setOnPreparedListener(this.nVJ);
        }
        this.gAl.setOnCompletionListener(this.mJj);
        this.gAl.setOnInfoListener(this.mJl);
    }
}
