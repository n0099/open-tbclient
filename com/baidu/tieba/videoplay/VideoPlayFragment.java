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
    private AlphaAnimation gDa;
    public TbCyberVideoView gzX;
    public ImageView hHr;
    private boolean hkR;
    private View iHg;
    private i ixB;
    private k izn;
    private int jiy;
    public ImageView jnn;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private f.b mHh;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    public ImageView nUA;
    public ImageView nUB;
    public ImageView nUC;
    public ImageView nUD;
    public ExpandableTextView nUE;
    public EMTextView nUF;
    public EMTextView nUG;
    public EMTextView nUH;
    public EMTextView nUI;
    public EMTextView nUJ;
    private TextView nUK;
    private FrameLayout nUL;
    private LinearLayout nUM;
    public LinearLayout nUN;
    public LinearLayout nUO;
    public VideoItemData nUP;
    private TextView nUQ;
    private VideoMiddleNiaiControllerView nUR;
    public ImageView nUS;
    public TextView nUT;
    private View nUU;
    private TextView nUV;
    private int nUW;
    private int nUX;
    private RelativeLayout.LayoutParams nUZ;
    private TbImageView nUt;
    public ImageView nUu;
    public HeadImageView nUv;
    public LinearLayout nUw;
    public LinearLayout nUx;
    public LinearLayout nUy;
    public LinearLayout nUz;
    private TBLottieAnimationView nVa;
    private com.baidu.tieba.videoplay.editor.a nVc;
    private a nVd;
    com.baidu.tbadk.core.dialog.a nVh;
    private int nUr = 0;
    private int nUs = 1;
    private ForumManageModel geq = null;
    private com.baidu.tbadk.baseEditMark.a lRB = null;
    private com.baidu.tbadk.coreExtra.model.a faF = null;
    private BdUniqueId agC = BdUniqueId.gen();
    private boolean nUY = false;
    private boolean nVb = false;
    private int playTime = 1;
    private CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.nUP != null && VideoPlayFragment.this.nUP.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nUP.author_info.user_id) && data != null && VideoPlayFragment.this.nUP.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.agC)) ? false : false;
                    if (data.fsD == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.nUP.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.nUP.author_info.is_follow = "0";
                                VideoPlayFragment.this.dVo();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.esQ) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.nUP));
                                } else {
                                    VideoPlayFragment.this.nUP.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dVo();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.nUP.author_info.is_follow = "0";
                            VideoPlayFragment.this.dVo();
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
                VideoPlayFragment.this.dVq();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                AgreeData agreeData = ((e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.nUP != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.nUP.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.nUP.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.nUP.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.nUP.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dVn();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.nUP.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.nUP.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.nUP.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dVn();
                    }
                }
            }
        }
    };
    private k.b nVe = new k.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!bh.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                VideoPlayFragment.this.ixB.dismiss();
                return;
            }
            VideoPlayFragment.this.ixB.dismiss();
            if (VideoPlayFragment.this.nUP != null) {
                boolean z = VideoPlayFragment.this.nUP.post_id != null && VideoPlayFragment.this.nUP.post_id.equals(VideoPlayFragment.this.nUP.mark_id);
                MarkData markData = new MarkData();
                Date date = new Date();
                markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                markData.setThreadId(VideoPlayFragment.this.nUP.thread_id);
                markData.setPostId(VideoPlayFragment.this.nUP.post_id);
                markData.setTime(date.getTime());
                markData.setHostMode(false);
                markData.setId(VideoPlayFragment.this.nUP.thread_id);
                markData.setForumId(VideoPlayFragment.this.nUP.forum_id);
                if (VideoPlayFragment.this.lRB != null) {
                    VideoPlayFragment.this.lRB.a(markData);
                    if (!z) {
                        VideoPlayFragment.this.lRB.bkb();
                    } else {
                        VideoPlayFragment.this.lRB.bka();
                    }
                }
            }
        }
    };
    private k.b nVf = new k.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            VideoPlayFragment.this.ixB.dismiss();
            if (bh.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nUP != null) {
                String str = VideoPlayFragment.this.nUP.thread_id;
                String str2 = VideoPlayFragment.this.nUP.forum_id;
                String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.nUP.post_id;
                if (VideoPlayFragment.this.nUP.isBjhVideo) {
                    str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.nUP.post_id) + "&channelid=33840";
                    string = "";
                }
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                if (VideoPlayFragment.this.nUP.isBjhVideo) {
                    tbWebViewActivityConfig.setFixTitle(true);
                }
                VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
            }
        }
    };
    private k.b nVg = new k.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            VideoPlayFragment.this.ixB.dismiss();
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
            aVar.nx(R.string.del_thread_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (VideoPlayFragment.this.nUP != null) {
                        VideoPlayFragment.this.geq.a(VideoPlayFragment.this.nUP.forum_id, VideoPlayFragment.this.nUP.forum_name, VideoPlayFragment.this.nUP.thread_id, VideoPlayFragment.this.nUP.post_id, 0, 0, VideoPlayFragment.this.hkR, null);
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
    private Runnable nVi = new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // java.lang.Runnable
        public void run() {
            if (!VideoPlayFragment.this.fyn) {
                VideoPlayFragment.this.zk(true);
            }
        }
    };
    private CyberPlayerManager.OnInfoListener mIW = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.esQ) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.nUt.getVisibility() == 0) {
                    VideoPlayFragment.this.nUt.clearAnimation();
                    VideoPlayFragment.this.nUt.startAnimation(VideoPlayFragment.this.gDa);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener mIU = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.gzX != null) {
                VideoPlayFragment.this.gzX.dAt();
                VideoPlayFragment.this.gzX.seekTo(0);
                VideoPlayFragment.this.gzX.start();
                VideoPlayFragment.this.csb();
                VideoPlayFragment.D(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dVh();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener nVj = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.gzX != null) {
                VideoPlayFragment.this.gzX.setVolume(1.0f, 1.0f);
                if (VideoPlayFragment.this.gzX.getDuration() < 15000 || VideoPlayFragment.this.nUR == null) {
                    VideoPlayFragment.this.nUR.setVisibility(8);
                    return;
                }
                VideoPlayFragment.this.nUR.setVisibility(0);
                if (VideoPlayFragment.this.nUR.getCurProgress() == 0) {
                    VideoPlayFragment.this.nUR.showProgress();
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
        this.nUP = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.nUX = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.eNE = arguments.getString("obj_id");
        if (this.nUP != null && this.nUP.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.nUP.author_info.user_id)) {
            this.hkR = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.gzX = new TbCyberVideoView(getContext());
        this.gzX.setStageType("2005");
        this.gzX.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // com.baidu.tieba.play.f.b
            public void ce(int i, int i2) {
                if (VideoPlayFragment.this.mHh != null) {
                    VideoPlayFragment.this.mHh.ce(i, i2);
                }
            }
        });
        dVv();
        this.nUt = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.nUt.setPlaceHolder(4);
        if (g.bsa() || (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity()))) {
            this.iHg = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.iHg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.iHg.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aEx = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.nUu = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.nUv = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.nUv.setDefaultResource(17170445);
        this.nUv.setPlaceHolder(2);
        this.nUv.setIsRound(true);
        this.nUL = (FrameLayout) this.mRootView.findViewById(R.id.author_info_container);
        this.bwE = (LinearLayout) this.mRootView.findViewById(R.id.bottom_container);
        this.nUA = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.nUS = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.nUE = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.nUR = (VideoMiddleNiaiControllerView) this.mRootView.findViewById(R.id.media_controller);
        this.nUK = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.nUx = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.nUF = (EMTextView) this.mRootView.findViewById(R.id.comment_num);
        this.jnn = (ImageView) this.mRootView.findViewById(R.id.comment_img);
        this.nUw = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.nUz = (LinearLayout) this.mRootView.findViewById(R.id.ll_drag_container);
        this.nUG = (EMTextView) this.mRootView.findViewById(R.id.agree_num);
        this.hHr = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nUH = (EMTextView) this.mRootView.findViewById(R.id.share_num);
        this.nUI = (EMTextView) this.mRootView.findViewById(R.id.drag_cur_time);
        this.nUJ = (EMTextView) this.mRootView.findViewById(R.id.drag_total_time);
        this.nUB = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nUC = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dVi();
        this.nUD = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.nUM = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.nUN = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.nUO = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.nUy = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.nUT = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.nUU = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.nUU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.nUU.setVisibility(4);
                    if (VideoPlayFragment.this.nVc != null && VideoPlayFragment.this.nVc.bBh() != null) {
                        VideoPlayFragment.this.nVc.bBh().display();
                        if (VideoPlayFragment.this.nUP != null) {
                            VideoPlayFragment.this.nVc.c(VideoPlayFragment.this.nUP);
                        }
                    }
                    if (VideoPlayFragment.this.nUP != null) {
                        ar arVar = new ar("c13025");
                        arVar.dR("tid", VideoPlayFragment.this.nUP.thread_id);
                        arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                        arVar.dR("fid", VideoPlayFragment.this.nUP.forum_id);
                        TiebaStatic.log(arVar);
                    }
                }
            }
        });
        if (this.nUP != null) {
            if (this.nUP.video_duration > 15) {
                this.nUR.setVisibility(0);
            } else {
                this.nUR.setVisibility(8);
            }
        }
        this.nUR.setPlayer(this.gzX);
        this.nUR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoPlayFragment.this.zj(true);
                    if (VideoPlayFragment.this.nUI != null) {
                        VideoPlayFragment.this.nUI.setText(au.stringForVideoTime(i));
                    }
                    if (VideoPlayFragment.this.nUJ != null) {
                        VideoPlayFragment.this.nUJ.setText("/" + au.stringForVideoTime(VideoPlayFragment.this.gzX.getDuration()));
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
                    if (!VideoPlayFragment.this.gzX.isPlaying()) {
                        VideoPlayFragment.this.gzX.start();
                        VideoPlayFragment.this.nUD.setVisibility(8);
                    }
                    com.baidu.adp.lib.f.e.mA().postDelayed(VideoPlayFragment.this.nVi, IMConnection.RETRY_DELAY_TIMES);
                }
            }
        });
        this.nUV = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.nUQ = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.nUQ.setVisibility(8);
        String string = b.brQ().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.nUQ.setText(string);
        }
        final String string2 = b.brQ().getString("nani_key_download_link_url", null);
        this.nUQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    bf.bsV().a((TbPageContext) j.K(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dVm();
        this.nUv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nUP != null && VideoPlayFragment.this.nUP.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nUP.author_info.user_id) && VideoPlayFragment.this.nUP != null && VideoPlayFragment.this.nUP.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nUP.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    ar arVar = new ar("c12798");
                    arVar.dR("tid", VideoPlayFragment.this.nUP.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nUN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nUP != null && VideoPlayFragment.this.nUP.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.nUP.act_info.link_url);
                    ar arVar = new ar("c12799");
                    arVar.dR("tid", VideoPlayFragment.this.nUP.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nUE.setHasDown();
        this.nUE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dVk();
            }
        });
        this.aEx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nUP != null && !StringUtils.isNull(VideoPlayFragment.this.nUP.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.nUP.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.nUu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dVl();
            }
        });
        this.nUx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.nUP)) {
                    VideoPlayFragment.this.dVk();
                    ar arVar = new ar("c12796");
                    arVar.dR("tid", VideoPlayFragment.this.nUP.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nUw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.KS(VideoPlayFragment.this.nUr);
            }
        });
        this.nUy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.buF();
                ar arVar = new ar("c12797");
                arVar.dR("tid", VideoPlayFragment.this.nUP.thread_id);
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar);
                ar arVar2 = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar2.dR("tid", VideoPlayFragment.this.nUP.thread_id);
                arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar2.ap("obj_locate", 19);
                arVar2.dR(IntentConfig.NID, VideoPlayFragment.this.nUP.nid);
                if (VideoPlayFragment.this.nUP.baijiahaoData != null && !au.isEmpty(VideoPlayFragment.this.nUP.baijiahaoData.oriUgcVid)) {
                    arVar2.dR("obj_param6", VideoPlayFragment.this.nUP.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.nUP.getVideoType() == 1) {
                    arVar2.ap(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.nUP.getVideoType() == 2) {
                    arVar2.ap(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.nUP.getVideoType() == 3) {
                    arVar2.ap(IntentConfig.CARD_TYPE, 6);
                }
                arVar2.dR(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.nUP.mRecomSource);
                arVar2.dR("ab_tag", VideoPlayFragment.this.nUP.mRecomAbTag);
                arVar2.dR("weight", VideoPlayFragment.this.nUP.mRecomWeight);
                arVar2.dR("extra", VideoPlayFragment.this.nUP.mRecomExtra);
                arVar2.dR("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.fr(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.fr(VideoPlayFragment.this.getBaseFragmentActivity()).bDP() != null && c.fr(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.fr(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    arVar2.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    arVar2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(arVar2);
            }
        });
        this.nUA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nUA != null && VideoPlayFragment.this.nUP != null && VideoPlayFragment.this.nUP.author_info != null) {
                    VideoPlayFragment.this.faF.a(true, VideoPlayFragment.this.nUP.author_info.portrait, VideoPlayFragment.this.nUP.author_info.user_id, false, "6", VideoPlayFragment.this.agC, VideoPlayFragment.this.nUP.forum_id, "0");
                    VideoPlayFragment.this.nUP.author_info.is_follow = "1";
                    VideoPlayFragment.this.dVo();
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(300L);
                    VideoPlayFragment.this.nUA.startAnimation(scaleAnimation);
                }
            }
        });
        this.gDa = new AlphaAnimation(1.0f, 0.0f);
        this.gDa.setDuration(100L);
        this.gDa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.nUt != null) {
                    VideoPlayFragment.this.nUt.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.nUW = this.mRect.right - this.mRect.left;
            this.jiy = this.mRect.bottom - this.mRect.top;
            this.nUt.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2;
                    int width = VideoPlayFragment.this.nUt.getWidth();
                    int height = VideoPlayFragment.this.nUt.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nUP.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nUP.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nUP.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nUP.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nUW, VideoPlayFragment.this.jiy);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.nUt.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jiy > 0 || VideoPlayFragment.this.nUW <= 0) {
                                f = 1.0f;
                                f2 = 1.0f;
                            } else {
                                f = i / VideoPlayFragment.this.jiy;
                                f2 = i2 / VideoPlayFragment.this.nUW;
                            }
                            VideoPlayFragment.this.nUt.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.nUt.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10.1
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
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nUW, VideoPlayFragment.this.jiy);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.nUt.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jiy > 0) {
                    }
                    f = 1.0f;
                    f2 = 1.0f;
                    VideoPlayFragment.this.nUt.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.nUt.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10.1
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
            this.nUt.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.nUt.getWidth();
                    int height = VideoPlayFragment.this.nUt.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nUP.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nUP.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nUP.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nUP.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.nUt.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.nUt.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cZX();
        if (this.esQ) {
            dVj();
        }
        if (this.nUP != null && !StringUtils.isNull(this.nUP.video_url)) {
            UF(this.nUP.video_url);
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(boolean z) {
        if (z) {
            this.nUw.setVisibility(8);
            this.nUL.setVisibility(8);
            this.nUx.setVisibility(8);
            this.nUy.setVisibility(8);
            this.bwE.setVisibility(8);
            this.nUz.setVisibility(0);
            return;
        }
        this.nUw.setVisibility(0);
        this.nUL.setVisibility(0);
        this.nUx.setVisibility(0);
        this.nUy.setVisibility(0);
        this.bwE.setVisibility(0);
        this.nUz.setVisibility(8);
    }

    public void a(f.b bVar) {
        this.mHh = bVar;
    }

    public void a(a aVar) {
        this.nVd = aVar;
    }

    private void cZX() {
        this.nVc = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().fg(getActivity());
        if (this.nVc != null && this.nUP != null) {
            this.nVc.a(getPageContext());
            this.nVc.aQ(this.nUP.thread_id, this.nUP.forum_id, this.nUP.forum_name);
            this.nVc.a(new a.InterfaceC0894a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0894a
                public void zl(boolean z) {
                    VideoPlayFragment.this.nUU.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.nUV.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.nUV.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.nVc.bBh().qU(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.nUP != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nUP.comment_num, 0L) + 1;
                        VideoPlayFragment.this.nUP.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.nUF.setText(au.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.nVc.bBh(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buF() {
        String str;
        String str2;
        if (this.nUP != null) {
            String str3 = this.nUP.forum_id;
            String str4 = this.nUP.forum_name;
            String str5 = this.nUP.title;
            if (this.nUP.baijiahaoData != null) {
                str = this.nUP.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.nUP.baijiahaoData.oriUgcType + "&dvid=" + this.nUP.baijiahaoData.oriUgcVid + "&nid=" + this.nUP.baijiahaoData.oriUgcNid;
            } else {
                str = this.nUP.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str7 = this.nUP.thumbnail_url;
            String format = (!this.nUP.isBjhVideo || this.nUP.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.nUP.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.nUP.baijiahaoData == null) {
                shareItem.readCount = this.nUP.play_count;
            }
            if (this.nUP.isBjhVideo) {
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
            if (this.nUP.getVideoType() == 1) {
                shareItem.fvc = 2;
            } else if (this.nUP.getVideoType() == 2) {
                shareItem.fvc = 8;
            } else if (this.nUP.getVideoType() == 3) {
                shareItem.fvc = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.nUP.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.nUP.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.nUP.title;
            originalThreadInfo.threadId = this.nUP.thread_id;
            originalThreadInfo.oriUgcInfo = this.nUP.baijiahaoData;
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
            com.baidu.tieba.c.f.ctz().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.hkR) {
            this.geq = new ForumManageModel(getPageContext());
            this.geq.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.geq.getLoadDataMode()) {
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
        this.lRB = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.lRB != null) {
            this.lRB.a(new a.InterfaceC0554a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0554a
                public void g(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.lRB != null) {
                            VideoPlayFragment.this.lRB.ja(z2);
                        }
                        if (VideoPlayFragment.this.nUP != null) {
                            if (z2) {
                                VideoPlayFragment.this.nUP.mark_id = VideoPlayFragment.this.nUP.post_id;
                            } else {
                                VideoPlayFragment.this.nUP.mark_id = null;
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
            this.nVb = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dVm();
        dVw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVh() {
        if (this.nUC != null && this.nUB != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.nUB.clearAnimation();
            this.nUC.clearAnimation();
            this.nUB.setVisibility(8);
            this.nUC.setVisibility(0);
            this.nUC.startAnimation(scaleAnimation2);
            this.nUB.startAnimation(scaleAnimation);
        }
    }

    private void dVi() {
        if (this.nUC != null && this.nUB != null) {
            this.nUB.clearAnimation();
            this.nUC.clearAnimation();
            this.nUB.setVisibility(0);
            this.nUC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KS(int i) {
        int i2;
        if (bh.checkUpIsLogin(getActivity()) && this.nUP != null) {
            if (i == this.nUr) {
                if ("1".equals(this.nUP.is_agreed)) {
                    i2 = 1;
                    this.nUP.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nUP.agree_num, 0) - 1);
                    this.nUP.is_agreed = "0";
                } else {
                    this.nUP.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nUP.agree_num, 0) + 1);
                    this.nUP.is_agreed = "1";
                    dVr();
                    i2 = 0;
                }
            } else {
                this.nUP.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nUP.agree_num, 0) + 1);
                this.nUP.is_agreed = "1";
                i2 = 0;
            }
            ar arVar = new ar("c12795");
            arVar.dR("tid", this.nUP.thread_id);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nUr) {
                arVar.ap("obj_type", i2);
            } else {
                arVar.ap("obj_type", 2);
            }
            TiebaStatic.log(arVar);
            ar arVar2 = new ar("c12003");
            arVar2.dR("tid", this.nUP.thread_id);
            arVar2.v("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nUr) {
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
            dVm();
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.nUP.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.nUP.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.nUP.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.nUP.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.nUP.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.nUP.baijiahaoData.oriUgcType);
            }
            if (fq != null) {
                httpMessage.addParam("obj_source", fq.getCurrentPageKey());
            }
            sendMessage(httpMessage);
            e eVar = new e();
            AgreeData agreeData = new AgreeData();
            if (this.nUP.thread_id != null) {
                agreeData.threadId = this.nUP.thread_id;
            }
            agreeData.agreeNum = Long.valueOf(this.nUP.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.nUP.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.nUP));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (TbSingleton.getInstance().isNotchScreen(getActivity()) || !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
        }
        if (this.nUP != null && !StringUtils.isNull(this.nUP.video_url)) {
            this.mHasInit = true;
            if (this.esQ) {
                csb();
                resumePlay();
                if (this.nUP != null && this.mRect != null) {
                    ar arVar = new ar("c12794");
                    arVar.dR("tid", this.nUP.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.ap("obj_type", 0);
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
        if (this.nVc != null && this.nVc.bBh() != null) {
            this.nVc.bBh().hide();
            this.nUU.setVisibility(0);
            this.nUV.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nVc.bBh().qU(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.nVc != null) {
            this.nVc.onDestroy();
        }
        if (this.nVi != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nVi);
            this.nVi = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.esQ = z;
        if (!z && this.nVc != null) {
            this.nUV.setText(R.string.reply_something);
            this.nVc.cGO();
        }
        if (this.mHasInit) {
            if (this.esQ && (!this.nVb || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.nUP != null && this.mRect == null) {
                    ar arVar = new ar("c12794");
                    arVar.dR("tid", this.nUP.thread_id);
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.ap("obj_type", 1);
                    TiebaStatic.log(arVar);
                }
                startPlay();
                dVj();
                this.nVb = false;
                return;
            }
            dVi();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void dVj() {
        if (this.nUP != null) {
            ar arVar = new ar("c12590");
            arVar.dR("tid", this.nUP.thread_id);
            arVar.dR(IntentConfig.NID, this.nUP.nid);
            arVar.dR("fid", this.nUP.forum_id);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.ap("obj_locate", this.nUX);
            arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, 1);
            arVar.dR("obj_param1", au.isEmpty(this.nUP.mRecomWeight) ? "0" : this.nUP.mRecomWeight);
            arVar.dR("extra", au.isEmpty(this.nUP.mRecomExtra) ? "0" : this.nUP.mRecomExtra);
            arVar.dR("obj_id", this.eNE);
            arVar.dR("ab_tag", au.isEmpty(this.nUP.mRecomAbTag) ? "0" : this.nUP.mRecomAbTag);
            arVar.dR("obj_source", au.isEmpty(this.nUP.mRecomSource) ? "0" : this.nUP.mRecomSource);
            arVar.dR("obj_type", this.mFromPage);
            arVar.ap("is_vertical", 1);
            if (this.nUP.baijiahaoData != null) {
                arVar.dR("obj_param4", this.nUP.baijiahaoData.oriUgcNid);
                arVar.dR("obj_param6", this.nUP.baijiahaoData.oriUgcVid);
                if (this.nUP.baijiahaoData.oriUgcType == 4) {
                    arVar.ap("obj_param5", 2);
                } else if (this.nUP.baijiahaoData.oriUgcType == 2) {
                    arVar.ap("obj_param5", 3);
                }
            } else {
                arVar.ap("obj_param5", 1);
            }
            TiebaStatic.log(arVar);
        }
    }

    private void UF(String str) {
        if (this.gzX != null && str != null && !str.equals(this.mVideoUrl)) {
            this.gzX.setVideoPath(str, this.nUP.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dVq()) {
            dzG();
            if (this.nUD != null) {
                this.nUD.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.nUt.getVisibility() == 0) {
                this.nUt.clearAnimation();
                this.nUt.startAnimation(this.gDa);
            }
            if (this.gzX != null) {
                if (TbVideoViewSet.dAu().QF(this.mVideoUrl) == null || TbVideoViewSet.dAu().QF(this.mVideoUrl) != this.gzX) {
                    this.gzX.setVideoPath(this.mVideoUrl, this.nUP.thread_id);
                }
                this.gzX.start();
                this.nUR.showProgress();
                csb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csb() {
        if (this.nUP != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.amC = this.nUP.thread_id;
            oVar.eTz = this.nUP.nid;
            oVar.fNd = this.nUP.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.nUP.mRecomSource;
            oVar.mIe = this.nUP.mRecomAbTag;
            oVar.mIf = this.nUP.mRecomWeight;
            oVar.mIg = "";
            oVar.eNE = "";
            oVar.mIj = this.nUP.mMd5;
            if (this.mRect != null) {
                oVar.mIk = "1";
            } else {
                oVar.mIk = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.mIl = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.mIg = "index";
            }
            h.a(this.nUP.mMd5, "", "1", oVar, this.gzX.getPcdnState());
        }
    }

    private void dzG() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.f.dRX().gZ(getContext());
        }
    }

    private void pausePlay() {
        if (this.gzX != null) {
            this.gzX.pause();
        }
    }

    private void stopPlay() {
        if (this.gzX != null) {
            this.gzX.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVk() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.nUP.thread_id, this.nUP.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.nUP.forum_id));
        createNormalCfg.setForumName(this.nUP.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(false);
        createNormalCfg.setBjhData(this.nUP.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVl() {
        if (this.ixB == null) {
            this.izn = new k(getActivity());
            this.ixB = new i(getPageContext(), this.izn);
            ArrayList arrayList = new ArrayList();
            com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getActivity().getString(R.string.mark), this.izn);
            boolean z = false;
            if (this.nUP != null && this.nUP.post_id != null && this.nUP.post_id.equals(this.nUP.mark_id)) {
                z = true;
            }
            if (z) {
                gVar.setText(getResources().getString(R.string.remove_mark));
            } else {
                gVar.setText(getResources().getString(R.string.mark));
            }
            gVar.a(this.nVe);
            if (this.nUP != null && !this.nUP.isBjhVideo) {
                arrayList.add(gVar);
            }
            com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(getActivity().getString(R.string.report_text), this.izn);
            gVar2.a(this.nVf);
            arrayList.add(gVar2);
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(getActivity().getString(R.string.delete), this.izn);
            gVar3.a(this.nVg);
            if (this.hkR) {
                arrayList.add(gVar3);
            }
            this.izn.a(new k.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    VideoPlayFragment.this.cHw();
                }
            });
            this.ixB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    VideoPlayFragment.this.ixB = null;
                    VideoPlayFragment.this.izn = null;
                    if (TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) || !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                    }
                }
            });
            this.izn.bw(arrayList);
        }
        cHx();
    }

    public void cHw() {
        if (this.ixB != null && this.ixB.isShowing()) {
            this.ixB.dismiss();
        }
    }

    public void cHx() {
        if (this.ixB != null && getActivity() != null && !getActivity().isFinishing()) {
            this.ixB.QE();
        }
    }

    private void dVm() {
        if (this.nUP != null) {
            this.nUt.startLoad(this.nUP.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.nUP.title);
            if (StringUtils.isNull(this.nUP.title) || matcher.matches()) {
                this.nUE.setVisibility(8);
            } else {
                this.nUE.setVisibility(0);
                this.nUE.setTextSize(l.getDimens(getContext(), R.dimen.T_X07));
                this.nUE.setTextColor(R.color.CAM_X0101);
                this.nUE.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds2));
                this.nUE.setExpandable(true);
                this.nUE.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void rJ(boolean z) {
                        VideoPlayFragment.this.nUP.isTitleExpanded = z;
                    }
                });
                this.nUE.setData(this.nUP.title, this.nUP.isTitleExpanded);
            }
            this.nUF.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nUP.comment_num, 0L)));
            this.nUG.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nUP.agree_num, 0L)));
            this.nUH.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nUP.share_num, 0L)));
            if (this.nUP.author_info != null) {
                if (!TextUtils.isEmpty(this.nUP.author_info.bjhAvatar)) {
                    this.nUv.startLoad(this.nUP.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.nUP.author_info.portrait) && this.nUP.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.nUv.startLoad(this.nUP.author_info.portrait, 10, false);
                } else {
                    this.nUv.startLoad(this.nUP.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.nUP.author_info.dRS())) {
                    this.nUT.setVisibility(8);
                } else {
                    this.nUT.setVisibility(0);
                    this.nUT.setText("@" + this.nUP.author_info.dRS());
                }
            }
            if ("1".equals(this.nUP.is_private) && this.nUQ.getVisibility() != 0) {
                this.nUO.setVisibility(0);
            } else {
                this.nUO.setVisibility(8);
            }
            if ("1".equals(this.nUP.is_agreed)) {
                this.nUS.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
            } else {
                this.nUS.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
            }
            if (this.nUP.act_info != null && !StringUtils.isNull(this.nUP.act_info.activity_name) && this.nUQ.getVisibility() != 0) {
                this.nUN.setVisibility(0);
                this.nUK.setText(this.nUP.act_info.activity_name);
            } else {
                this.nUN.setVisibility(8);
            }
            dVo();
            if (this.nUP.isBjhVideo) {
                this.nUu.setVisibility(8);
            } else {
                this.nUu.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVn() {
        if (this.nUP != null) {
            if ("1".equals(this.nUP.is_agreed)) {
                this.nUS.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
            } else {
                this.nUS.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
            }
            this.nUG.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nUP.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVo() {
        if (this.hkR || (this.nUP.author_info != null && "1".equals(this.nUP.author_info.is_follow))) {
            this.nUA.setVisibility(4);
            this.nUA.setClickable(false);
            return;
        }
        this.nUA.setVisibility(0);
        this.nUA.setClickable(true);
    }

    private void dVp() {
        if (getActivity() != null) {
            if (this.nVh == null || !this.nVh.isShowing()) {
                this.nVh = new com.baidu.tbadk.core.dialog.a(getActivity());
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
                this.nVh.bn(inflate);
                this.nVh.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.nVh.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.nVh.nA(1);
                this.nVh.ny(R.color.CAM_X0105);
                this.nVh.jF(true);
                this.nVh.b(getPageContext());
                this.nVh.bqx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dVq() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.f.dRX().dRY() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !com.baidu.adp.lib.util.j.isMobileNet() || !this.esQ) {
            return false;
        }
        if (this.nUD != null) {
            this.nUD.setVisibility(0);
        }
        pausePlay();
        dVp();
        return true;
    }

    private void resumePlay() {
        if (!dVq() && this.gzX != null && this.nUD != null && this.nUP != null) {
            if (this.gzX.getParent() == null) {
                dVv();
                dVw();
            }
            if (TbVideoViewSet.dAu().QF(this.mVideoUrl) == null || TbVideoViewSet.dAu().QF(this.mVideoUrl) != this.gzX) {
                this.gzX.setVideoPath(this.mVideoUrl, this.nUP.thread_id);
            }
            this.gzX.a((TbVideoViewSet.a) null);
            this.nUR.showProgress();
            this.nUD.setVisibility(8);
            dzG();
            if (this.nVd != null) {
                this.nVd.onStart();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0588a
    public void bIS() {
        if (this.gzX.isPlaying()) {
            this.gzX.pause();
            this.nUD.setVisibility(0);
            zk(false);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nVi);
        } else if (!dVq()) {
            this.gzX.start();
            this.nUD.setVisibility(8);
            zk(true);
            this.nUR.showProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(boolean z) {
        if (this.nUR != null) {
            this.nUR.setBottomBarShow(z);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0588a
    public void z(float f, float f2) {
        if (bh.checkUpIsLogin(getActivity())) {
            dVr();
            if (this.nUP != null && "0".equals(this.nUP.is_agreed)) {
                KS(this.nUs);
            }
        }
    }

    private void dVr() {
        if (this.mRootView != null && !this.nUY) {
            this.nUY = true;
            this.nVa = new TBLottieAnimationView(this.mRootView.getContext());
            if (this.nUZ == null) {
                this.nUZ = new RelativeLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396), TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396));
                this.nUZ.addRule(13);
            }
            ap.a(this.nVa, R.raw.lottie_agree_big_photo);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.nVa, this.nUZ);
            }
            this.nVa.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoPlayFragment.this.mRootView instanceof RelativeLayout) {
                        ((RelativeLayout) VideoPlayFragment.this.mRootView).removeView(VideoPlayFragment.this.nVa);
                    }
                    VideoPlayFragment.this.nUY = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.nVa.playAnimation();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0588a
    public void bIT() {
        if (this.nUP != null && this.nUP.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.nUP.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dVs() {
        return null;
    }

    public String dVt() {
        return null;
    }

    public boolean dVu() {
        if (this.nVc == null || this.nVc.bBh() == null || !this.nVc.bBh().isVisible()) {
            return false;
        }
        this.nVc.bBh().hide();
        this.nUU.setVisibility(0);
        if ((this.nVc.bBh().qU(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.nVc.bBh().qU(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.nVc.bBh().qU(28)).getInputView().getText() != null) {
            this.nUV.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nVc.bBh().qU(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.nVc != null) {
            this.nVc.onActivityResult(i, i2, intent);
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
        if (this.nVc != null && this.nVc.bBh() != null) {
            this.nVc.bBh().onChangeSkinType(i);
        }
        if (this.izn != null) {
            this.izn.onChangeSkinType();
        }
        if (this.mRootView != null) {
            this.jnn.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_reply120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.hHr.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_share120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.nUC.setImageDrawable(WebPManager.a(R.drawable.icon_share_wechat120, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.nUA.setImageDrawable(WebPManager.a(R.drawable.icon_mask_video_follow24, WebPManager.ResourceStateType.NORMAL_PRESS));
            this.nUD.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
            com.baidu.tbadk.core.elementsMaven.c.br(this.nUU).og(R.string.J_X01).setBackGroundColor(R.color.CAM_X0614);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nUI).oa(R.string.F_X02).nY(R.color.CAM_X0101);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nUJ).oa(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nUH).nZ(R.dimen.T_X09).oa(R.string.F_X02).oi(R.array.S_O_X001);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nUG).nZ(R.dimen.T_X09).oa(R.string.F_X02).oi(R.array.S_O_X001);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nUF).nZ(R.dimen.T_X09).oa(R.string.F_X02).oi(R.array.S_O_X001);
            com.baidu.tbadk.core.elementsMaven.c.br(this.nUT).nZ(R.dimen.T_X06).oa(R.string.F_X02).oi(R.array.S_O_X001);
            this.nUJ.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0101), com.baidu.tbadk.core.elementsMaven.a.nM(R.string.A_X08)));
            this.nUG.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0101), com.baidu.tbadk.core.elementsMaven.a.nM(R.string.A_X03)));
            this.nUH.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0101), com.baidu.tbadk.core.elementsMaven.a.nM(R.string.A_X03)));
            this.nUF.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0101), com.baidu.tbadk.core.elementsMaven.a.nM(R.string.A_X03)));
        }
        WebPManager.a(this.aEx, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.nUu, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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

    public void dVv() {
        if (this.gzX != null && this.gzX.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.gzX.getView(), 0);
            this.gzX.getView().setLayoutParams(layoutParams);
            if (this.nUP != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.amC = this.nUP.thread_id;
                oVar.eTz = this.nUP.nid;
                oVar.fNd = this.nUP.forum_id;
                oVar.mIj = this.nUP.mMd5;
                oVar.eNE = "";
                oVar.mSource = this.nUP.mRecomSource;
                oVar.mIi = this.nUP.mRecomAbTag;
                oVar.mIh = 1;
                if (this.nUP.baijiahaoData != null) {
                    if (this.nUP.baijiahaoData.oriUgcType == 2) {
                        oVar.mIh = 3;
                    } else if (this.nUP.baijiahaoData.oriUgcType == 4) {
                        oVar.mIh = 2;
                    }
                }
                oVar.mIf = this.nUP.mRecomWeight;
                if (this.mRect != null) {
                    oVar.mIk = "1";
                } else {
                    oVar.mIk = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.mIl = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.mIg = this.mFromPage;
                    oVar.eNE = this.eNE;
                    oVar.mIe = this.nUP.mRecomWeight;
                } else {
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
                }
                this.gzX.setVideoStatData(oVar);
                this.gzX.setLocateSource("v_mid_page");
            }
            this.gzX.setContinuePlayEnable(true);
        }
    }

    private void dVw() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.gzX.setOnPreparedListener(this.nVj);
        }
        this.gzX.setOnCompletionListener(this.mIU);
        this.gzX.setOnInfoListener(this.mIW);
    }
}
