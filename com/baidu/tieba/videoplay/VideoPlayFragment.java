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
/* loaded from: classes7.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0591a {
    public ImageView aCK;
    private e eFI;
    private String eLs;
    private boolean eqJ;
    private AlphaAnimation gAq;
    public TbCyberVideoView gxn;
    private boolean hgB;
    private View iBw;
    private int jcR;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private f.b myb;
    private TbImageView nKN;
    public ImageView nKO;
    public HeadImageView nKP;
    public LinearLayout nKQ;
    public LinearLayout nKR;
    public LinearLayout nKS;
    public ImageView nKT;
    public ImageView nKU;
    public ImageView nKV;
    public ExpandableTextView nKW;
    public TextView nKX;
    public TextView nKY;
    public TextView nKZ;
    public TextView nLa;
    public ImageView nLb;
    private LinearLayout nLc;
    public LinearLayout nLd;
    public LinearLayout nLe;
    public VideoItemData nLf;
    private TextView nLg;
    public ImageView nLh;
    public TextView nLi;
    private View nLj;
    private TextView nLk;
    private int nLl;
    private int nLm;
    private com.baidu.tieba.view.a nLn;
    protected Animation nLo;
    private boolean nLp;
    private AnimatorSet nLq;
    private RelativeLayout.LayoutParams nLr;
    private com.baidu.tieba.videoplay.editor.a nLt;
    private a nLu;
    com.baidu.tbadk.core.dialog.a nLv;
    private int nKL = 0;
    private int nKM = 1;
    private ForumManageModel gca = null;
    private com.baidu.tbadk.baseEditMark.a lIE = null;
    private com.baidu.tbadk.coreExtra.model.a eYq = null;
    private BdUniqueId agN = BdUniqueId.gen();
    private boolean nLs = false;
    private int playTime = 1;
    private CustomMessageListener eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.nLf != null && VideoPlayFragment.this.nLf.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nLf.author_info.user_id) && data != null && VideoPlayFragment.this.nLf.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.agN)) ? false : false;
                    if (data.fqk == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.nLf.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.nLf.author_info.is_follow = "0";
                                VideoPlayFragment.this.dTd();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.eqJ) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.nLf));
                                } else {
                                    VideoPlayFragment.this.nLf.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dTd();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.nLf.author_info.is_follow = "0";
                            VideoPlayFragment.this.dTd();
                        }
                        aq aqVar = new aq("c13570");
                        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        if ("index".equals(VideoPlayFragment.this.mFromPage)) {
                            aqVar.dW("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                            aqVar.dW("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
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
                VideoPlayFragment.this.dTf();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.nLf != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.nLf.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.nLf.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.nLf.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.nLf.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dTc();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.nLf.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.nLf.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.nLf.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dTc();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnInfoListener mzL = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.eqJ) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.nKN.getVisibility() == 0) {
                    VideoPlayFragment.this.nKN.clearAnimation();
                    VideoPlayFragment.this.nKN.startAnimation(VideoPlayFragment.this.gAq);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener mzJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.gxn != null) {
                VideoPlayFragment.this.gxn.dyl();
                VideoPlayFragment.this.gxn.seekTo(0);
                VideoPlayFragment.this.gxn.start();
                VideoPlayFragment.this.cqR();
                VideoPlayFragment.A(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dSW();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener nLw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.gxn != null) {
                VideoPlayFragment.this.gxn.setVolume(1.0f, 1.0f);
            }
        }
    };

    /* loaded from: classes7.dex */
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
        this.nLf = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.nLm = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.eLs = arguments.getString("obj_id");
        if (this.nLf != null && this.nLf.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.nLf.author_info.user_id)) {
            this.hgB = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.gxn = new TbCyberVideoView(getContext());
        this.gxn.setStageType("2005");
        this.gxn.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.f.b
            public void ch(int i, int i2) {
                if (VideoPlayFragment.this.myb != null) {
                    VideoPlayFragment.this.myb.ch(i, i2);
                }
            }
        });
        dTk();
        this.nKN = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.nKN.setPlaceHolder(4);
        if (g.brH()) {
            this.iBw = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.iBw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.iBw.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aCK = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.nKO = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.nKP = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.nKP.setDefaultResource(17170445);
        this.nKP.setPlaceHolder(2);
        this.nKP.setIsRound(true);
        this.nKT = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.nLh = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.nKW = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.nKX = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.nKR = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.nKY = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.nKQ = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.nKZ = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.nLa = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.nKU = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nKV = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dSX();
        this.nLb = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.nLc = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.nLd = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.nLe = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.nKS = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.nLi = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.nLj = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.nLj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.nLj.setVisibility(4);
                    if (VideoPlayFragment.this.nLt != null && VideoPlayFragment.this.nLt.bAP() != null) {
                        VideoPlayFragment.this.nLt.bAP().rV();
                        if (VideoPlayFragment.this.nLf != null) {
                            VideoPlayFragment.this.nLt.c(VideoPlayFragment.this.nLf);
                        }
                    }
                    if (VideoPlayFragment.this.nLf != null) {
                        aq aqVar = new aq("c13025");
                        aqVar.dW("tid", VideoPlayFragment.this.nLf.thread_id);
                        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar.dW("fid", VideoPlayFragment.this.nLf.forum_id);
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        });
        this.nLk = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.nLg = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.nLg.setVisibility(8);
        String string = b.brx().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.nLg.setText(string);
        }
        final String string2 = b.brx().getString("nani_key_download_link_url", null);
        this.nLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    be.bsB().a((TbPageContext) j.K(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dTb();
        this.nKP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nLf != null && VideoPlayFragment.this.nLf.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nLf.author_info.user_id) && VideoPlayFragment.this.nLf != null && VideoPlayFragment.this.nLf.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nLf.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    aq aqVar = new aq("c12798");
                    aqVar.dW("tid", VideoPlayFragment.this.nLf.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.nLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nLf != null && VideoPlayFragment.this.nLf.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.nLf.act_info.link_url);
                    aq aqVar = new aq("c12799");
                    aqVar.dW("tid", VideoPlayFragment.this.nLf.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.nKW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dSZ();
            }
        });
        this.aCK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nLf != null && !StringUtils.isNull(VideoPlayFragment.this.nLf.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.nLf.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.nKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dTa();
            }
        });
        this.nKR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.nLf)) {
                    VideoPlayFragment.this.dSZ();
                    aq aqVar = new aq("c12796");
                    aqVar.dW("tid", VideoPlayFragment.this.nLf.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.nKQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Ky(VideoPlayFragment.this.nKL);
            }
        });
        this.nKS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bul();
                aq aqVar = new aq("c12797");
                aqVar.dW("tid", VideoPlayFragment.this.nLf.thread_id);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar);
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dW("tid", VideoPlayFragment.this.nLf.thread_id);
                aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.an("obj_locate", 19);
                aqVar2.dW(IntentConfig.NID, VideoPlayFragment.this.nLf.nid);
                if (VideoPlayFragment.this.nLf.baijiahaoData != null && !at.isEmpty(VideoPlayFragment.this.nLf.baijiahaoData.oriUgcVid)) {
                    aqVar2.dW("obj_param6", VideoPlayFragment.this.nLf.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.nLf.getVideoType() == 1) {
                    aqVar2.an(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.nLf.getVideoType() == 2) {
                    aqVar2.an(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.nLf.getVideoType() == 3) {
                    aqVar2.an(IntentConfig.CARD_TYPE, 6);
                }
                aqVar2.dW(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.nLf.mRecomSource);
                aqVar2.dW("ab_tag", VideoPlayFragment.this.nLf.mRecomAbTag);
                aqVar2.dW("weight", VideoPlayFragment.this.nLf.mRecomWeight);
                aqVar2.dW("extra", VideoPlayFragment.this.nLf.mRecomExtra);
                aqVar2.dW("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.fs(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.fs(VideoPlayFragment.this.getBaseFragmentActivity()).bDx() != null && c.fs(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.fs(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    aqVar2.dW("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    aqVar2.dW("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(aqVar2);
            }
        });
        this.nKT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nLf != null && VideoPlayFragment.this.nLf.author_info != null) {
                    VideoPlayFragment.this.eYq.a(true, VideoPlayFragment.this.nLf.author_info.portrait, VideoPlayFragment.this.nLf.author_info.user_id, false, "6", VideoPlayFragment.this.agN, VideoPlayFragment.this.nLf.forum_id, "0");
                    VideoPlayFragment.this.nLf.author_info.is_follow = "1";
                    VideoPlayFragment.this.dTd();
                }
            }
        });
        this.gAq = new AlphaAnimation(1.0f, 0.0f);
        this.gAq.setDuration(100L);
        this.gAq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.nKN != null) {
                    VideoPlayFragment.this.nKN.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.nLl = this.mRect.right - this.mRect.left;
            this.jcR = this.mRect.bottom - this.mRect.top;
            this.nKN.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2;
                    int width = VideoPlayFragment.this.nKN.getWidth();
                    int height = VideoPlayFragment.this.nKN.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nLf.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nLf.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nLf.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nLf.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nLl, VideoPlayFragment.this.jcR);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.nKN.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.jcR > 0 || VideoPlayFragment.this.nLl <= 0) {
                                f = 1.0f;
                                f2 = 1.0f;
                            } else {
                                f = i / VideoPlayFragment.this.jcR;
                                f2 = i2 / VideoPlayFragment.this.nLl;
                            }
                            VideoPlayFragment.this.nKN.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.nKN.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.eqJ) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nLl, VideoPlayFragment.this.jcR);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.nKN.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.jcR > 0) {
                    }
                    f = 1.0f;
                    f2 = 1.0f;
                    VideoPlayFragment.this.nKN.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.nKN.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.eqJ) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.nKN.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.nKN.getWidth();
                    int height = VideoPlayFragment.this.nKN.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nLf.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nLf.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nLf.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nLf.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.nKN.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.nKN.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cXZ();
        if (this.eqJ) {
            dSY();
        }
        if (this.nLf != null && !StringUtils.isNull(this.nLf.video_url)) {
            TI(this.nLf.video_url);
        }
        return this.mRootView;
    }

    public void a(f.b bVar) {
        this.myb = bVar;
    }

    public void a(a aVar) {
        this.nLu = aVar;
    }

    private void cXZ() {
        this.nLt = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().fh(getActivity());
        if (this.nLt != null && this.nLf != null) {
            this.nLt.a(getPageContext());
            this.nLt.aO(this.nLf.thread_id, this.nLf.forum_id, this.nLf.forum_name);
            this.nLt.a(new a.InterfaceC0891a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0891a
                public void yQ(boolean z) {
                    VideoPlayFragment.this.nLj.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.nLk.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.nLk.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.nLt.bAP().qP(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.nLf != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nLf.comment_num, 0L) + 1;
                        VideoPlayFragment.this.nLf.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.nKY.setText(at.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.nLt.bAP(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bul() {
        String str;
        String str2;
        if (this.nLf != null) {
            String str3 = this.nLf.forum_id;
            String str4 = this.nLf.forum_name;
            String str5 = this.nLf.title;
            if (this.nLf.baijiahaoData != null) {
                str = this.nLf.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.nLf.baijiahaoData.oriUgcType + "&dvid=" + this.nLf.baijiahaoData.oriUgcVid + "&nid=" + this.nLf.baijiahaoData.oriUgcNid;
            } else {
                str = this.nLf.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str7 = this.nLf.thumbnail_url;
            String format = (!this.nLf.isBjhVideo || this.nLf.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.nLf.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.nLf.baijiahaoData == null) {
                shareItem.readCount = this.nLf.play_count;
            }
            if (this.nLf.isBjhVideo) {
                shareItem.fsD = format;
            } else {
                shareItem.fsD = "";
            }
            shareItem.linkUrl = str6;
            shareItem.eRW = 2;
            shareItem.extData = str;
            shareItem.fsG = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.fss = true;
            shareItem.fsF = 12;
            if (this.nLf.getVideoType() == 1) {
                shareItem.fsK = 2;
            } else if (this.nLf.getVideoType() == 2) {
                shareItem.fsK = 8;
            } else if (this.nLf.getVideoType() == 3) {
                shareItem.fsK = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.nLf.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.nLf.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.nLf.title;
            originalThreadInfo.threadId = this.nLf.thread_id;
            originalThreadInfo.oriUgcInfo = this.nLf.baijiahaoData;
            shareItem.fsN = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fsG);
            bundle.putInt("obj_type", shareItem.fsK);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eRW);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.f.csn().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.hgB) {
            this.gca = new ForumManageModel(getPageContext());
            this.gca.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.gca.getLoadDataMode()) {
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
        this.lIE = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.lIE != null) {
            this.lIE.a(new a.InterfaceC0557a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0557a
                public void g(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.lIE != null) {
                            VideoPlayFragment.this.lIE.iY(z2);
                        }
                        if (VideoPlayFragment.this.nLf != null) {
                            if (z2) {
                                VideoPlayFragment.this.nLf.mark_id = VideoPlayFragment.this.nLf.post_id;
                            } else {
                                VideoPlayFragment.this.nLf.mark_id = null;
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
        this.eYq = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.eYu);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.nLs = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dTb();
        dTl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSW() {
        if (this.nKV != null && this.nKU != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.nKU.clearAnimation();
            this.nKV.clearAnimation();
            this.nKU.setVisibility(8);
            this.nKV.setVisibility(0);
            this.nKV.startAnimation(scaleAnimation2);
            this.nKU.startAnimation(scaleAnimation);
        }
    }

    private void dSX() {
        if (this.nKV != null && this.nKU != null) {
            this.nKU.clearAnimation();
            this.nKV.clearAnimation();
            this.nKU.setVisibility(0);
            this.nKV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ky(int i) {
        int i2;
        if (bg.checkUpIsLogin(getActivity()) && this.nLf != null) {
            if (i == this.nKL) {
                if ("1".equals(this.nLf.is_agreed)) {
                    i2 = 1;
                    this.nLf.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nLf.agree_num, 0) - 1);
                    this.nLf.is_agreed = "0";
                } else {
                    this.nLf.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nLf.agree_num, 0) + 1);
                    this.nLf.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.nLf.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nLf.agree_num, 0) + 1);
                this.nLf.is_agreed = "1";
                i2 = 0;
            }
            aq aqVar = new aq("c12795");
            aqVar.dW("tid", this.nLf.thread_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nKL) {
                aqVar.an("obj_type", i2);
            } else {
                aqVar.an("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12003");
            aqVar2.dW("tid", this.nLf.thread_id);
            aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nKL) {
                aqVar2.an("obj_type", i2);
            } else {
                aqVar2.an("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                aqVar2.dW("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                aqVar2.dW("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            com.baidu.tbadk.pageExtra.c fr = d.fr(getContext());
            if (fr != null) {
                aqVar2.dW("obj_cur_page", fr.getCurrentPageKey());
            }
            if (d.bDu() != null) {
                aqVar2.dW("obj_pre_page", d.bDu());
            }
            TiebaStatic.log(aqVar2);
            dTb();
            if (this.nLh != null && i2 == 0) {
                this.nLh.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.nLf.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.nLf.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.nLf.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.nLf.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.nLf.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.nLf.baijiahaoData.oriUgcType);
            }
            if (fr != null) {
                httpMessage.addParam("obj_source", fr.getCurrentPageKey());
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.nLf.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.nLf.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.nLf));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.nLf != null && !StringUtils.isNull(this.nLf.video_url)) {
            this.mHasInit = true;
            if (this.eqJ) {
                cqR();
                aQK();
                if (this.nLf != null && this.mRect != null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dW("tid", this.nLf.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.an("obj_type", 0);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            aQJ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        aQJ();
        if (this.nLt != null && this.nLt.bAP() != null) {
            this.nLt.bAP().hide();
            this.nLj.setVisibility(0);
            this.nLk.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nLt.bAP().qP(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.nLt != null) {
            this.nLt.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.eqJ = z;
        if (!z && this.nLt != null) {
            this.nLk.setText(R.string.reply_something);
            this.nLt.cFB();
        }
        if (this.mHasInit) {
            if (this.eqJ && (!this.nLs || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.nLf != null && this.mRect == null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dW("tid", this.nLf.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.an("obj_type", 1);
                    TiebaStatic.log(aqVar);
                }
                startPlay();
                dSY();
                this.nLs = false;
                return;
            }
            dSX();
            this.playTime = 1;
            aQJ();
        }
    }

    private void dSY() {
        if (this.nLf != null) {
            aq aqVar = new aq("c12590");
            aqVar.dW("tid", this.nLf.thread_id);
            aqVar.dW(IntentConfig.NID, this.nLf.nid);
            aqVar.dW("fid", this.nLf.forum_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.an("obj_locate", this.nLm);
            aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dW("obj_param1", at.isEmpty(this.nLf.mRecomWeight) ? "0" : this.nLf.mRecomWeight);
            aqVar.dW("extra", at.isEmpty(this.nLf.mRecomExtra) ? "0" : this.nLf.mRecomExtra);
            aqVar.dW("obj_id", this.eLs);
            aqVar.dW("ab_tag", at.isEmpty(this.nLf.mRecomAbTag) ? "0" : this.nLf.mRecomAbTag);
            aqVar.dW("obj_source", at.isEmpty(this.nLf.mRecomSource) ? "0" : this.nLf.mRecomSource);
            aqVar.dW("obj_type", this.mFromPage);
            aqVar.an("is_vertical", 1);
            if (this.nLf.baijiahaoData != null) {
                aqVar.dW("obj_param4", this.nLf.baijiahaoData.oriUgcNid);
                aqVar.dW("obj_param6", this.nLf.baijiahaoData.oriUgcVid);
                if (this.nLf.baijiahaoData.oriUgcType == 4) {
                    aqVar.an("obj_param5", 2);
                } else if (this.nLf.baijiahaoData.oriUgcType == 2) {
                    aqVar.an("obj_param5", 3);
                }
            } else {
                aqVar.an("obj_param5", 1);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void TI(String str) {
        if (this.gxn != null && str != null && !str.equals(this.mVideoUrl)) {
            this.gxn.setVideoPath(str, this.nLf.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dTf()) {
            dxx();
            if (this.nLb != null) {
                this.nLb.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.nKN.getVisibility() == 0) {
                this.nKN.clearAnimation();
                this.nKN.startAnimation(this.gAq);
            }
            if (this.gxn != null) {
                if (TbVideoViewSet.dym().PO(this.mVideoUrl) == null || TbVideoViewSet.dym().PO(this.mVideoUrl) != this.gxn) {
                    this.gxn.setVideoPath(this.mVideoUrl, this.nLf.thread_id);
                }
                this.gxn.start();
                cqR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqR() {
        if (this.nLf != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.amM = this.nLf.thread_id;
            oVar.eRn = this.nLf.nid;
            oVar.fKR = this.nLf.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.nLf.mRecomSource;
            oVar.myX = this.nLf.mRecomAbTag;
            oVar.myY = this.nLf.mRecomWeight;
            oVar.myZ = "";
            oVar.eLs = "";
            oVar.mzc = this.nLf.mMd5;
            if (this.mRect != null) {
                oVar.mzd = "1";
            } else {
                oVar.mzd = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.mze = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.myZ = "index";
            }
            h.a(this.nLf.mMd5, "", "1", oVar, this.gxn.getPcdnState());
        }
    }

    private void dxx() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.f.dPM().gW(getContext());
        }
    }

    private void aQJ() {
        if (this.gxn != null) {
            this.gxn.pause();
        }
    }

    private void stopPlay() {
        if (this.gxn != null) {
            this.gxn.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSZ() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.nLf.thread_id, this.nLf.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.nLf.forum_id));
        createNormalCfg.setForumName(this.nLf.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.nLf.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTa() {
        if (this.eFI == null) {
            this.nLn = new com.baidu.tieba.view.a(getActivity());
            this.eFI = new e(getActivity(), this.nLn.bqy());
            this.eFI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.gxn.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.nLn != null) {
            ArrayList arrayList = new ArrayList();
            a.C0892a c0892a = new a.C0892a(this.nLn);
            c0892a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bg.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.eFI.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.eFI.dismiss();
                    if (VideoPlayFragment.this.nLf != null) {
                        boolean z = VideoPlayFragment.this.nLf.post_id != null && VideoPlayFragment.this.nLf.post_id.equals(VideoPlayFragment.this.nLf.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.nLf.thread_id);
                        markData.setPostId(VideoPlayFragment.this.nLf.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.nLf.thread_id);
                        markData.setForumId(VideoPlayFragment.this.nLf.forum_id);
                        if (VideoPlayFragment.this.lIE != null) {
                            VideoPlayFragment.this.lIE.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.lIE.bjG();
                            } else {
                                VideoPlayFragment.this.lIE.bjF();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.nLf != null && this.nLf.post_id != null && this.nLf.post_id.equals(this.nLf.mark_id)) {
                z = true;
            }
            if (z) {
                c0892a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0892a.setText(getResources().getString(R.string.mark));
            }
            if (this.nLf != null && !this.nLf.isBjhVideo) {
                arrayList.add(c0892a);
            }
            a.C0892a c0892a2 = new a.C0892a(getActivity().getString(R.string.delete), this.nLn);
            c0892a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.eFI.dismiss();
                    if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nLf != null) {
                        String str = VideoPlayFragment.this.nLf.thread_id;
                        String str2 = VideoPlayFragment.this.nLf.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.nLf.post_id;
                        if (VideoPlayFragment.this.nLf.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.nLf.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.nLf.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0892a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0892a2);
            if (this.hgB) {
                a.C0892a c0892a3 = new a.C0892a(getActivity().getString(R.string.delete), this.nLn);
                c0892a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.eFI.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.nu(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.nLf != null) {
                                    VideoPlayFragment.this.gca.a(VideoPlayFragment.this.nLf.forum_id, VideoPlayFragment.this.nLf.forum_name, VideoPlayFragment.this.nLf.thread_id, VideoPlayFragment.this.nLf.post_id, 0, 0, VideoPlayFragment.this.hgB, null);
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
                        aVar.jD(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.bqe();
                    }
                });
                c0892a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0892a3);
            }
            this.nLn.bB(arrayList);
        }
        this.eFI.show();
    }

    private void dTb() {
        if (this.nLf != null) {
            this.nKN.startLoad(this.nLf.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.nLf.title);
            if (StringUtils.isNull(this.nLf.title) || matcher.matches()) {
                this.nKW.setVisibility(8);
            } else {
                this.nKW.setVisibility(0);
                this.nKW.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.nKW.setTextColor(R.color.CAM_X0101);
                this.nKW.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.nKW.setExpandable(true);
                this.nKW.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void rz(boolean z) {
                        VideoPlayFragment.this.nLf.isTitleExpanded = z;
                    }
                });
                this.nKW.setData(this.nLf.title, this.nLf.isTitleExpanded);
            }
            this.nKY.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nLf.comment_num, 0L)));
            this.nKZ.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nLf.agree_num, 0L)));
            this.nLa.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nLf.share_num, 0L)));
            if (this.nLf.author_info != null) {
                if (!TextUtils.isEmpty(this.nLf.author_info.bjhAvatar)) {
                    this.nKP.startLoad(this.nLf.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.nLf.author_info.portrait) && this.nLf.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.nKP.startLoad(this.nLf.author_info.portrait, 10, false);
                } else {
                    this.nKP.startLoad(this.nLf.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.nLf.author_info.dPH())) {
                    this.nLi.setVisibility(8);
                } else {
                    this.nLi.setVisibility(0);
                    this.nLi.setText("@" + this.nLf.author_info.dPH());
                }
            }
            if ("1".equals(this.nLf.is_private) && this.nLg.getVisibility() != 0) {
                this.nLe.setVisibility(0);
            } else {
                this.nLe.setVisibility(8);
            }
            if ("1".equals(this.nLf.is_agreed)) {
                ao.setImageResource(this.nLh, R.drawable.icon_card_like_white_full_s);
            } else {
                ao.setImageResource(this.nLh, R.drawable.btn_video_agree);
            }
            if (this.nLf.act_info != null && !StringUtils.isNull(this.nLf.act_info.activity_name) && this.nLg.getVisibility() != 0) {
                this.nLd.setVisibility(0);
                this.nKX.setText(this.nLf.act_info.activity_name);
            } else {
                this.nLd.setVisibility(8);
            }
            dTd();
            if (this.nLf.isBjhVideo) {
                this.nKO.setVisibility(8);
            } else {
                this.nKO.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTc() {
        if (this.nLf != null) {
            if ("1".equals(this.nLf.is_agreed)) {
                ao.setImageResource(this.nLh, R.drawable.icon_card_like_white_full_s);
            } else {
                ao.setImageResource(this.nLh, R.drawable.btn_video_agree);
            }
            this.nKZ.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nLf.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTd() {
        if (this.hgB || (this.nLf.author_info != null && "1".equals(this.nLf.author_info.is_follow))) {
            this.nKT.setVisibility(4);
            this.nKT.setClickable(false);
            return;
        }
        this.nKT.setVisibility(0);
        this.nKT.setClickable(true);
    }

    private void dTe() {
        if (getActivity() != null) {
            if (this.nLv == null || !this.nLv.isShowing()) {
                this.nLv = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.bsx().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
                this.nLv.br(inflate);
                this.nLv.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.nLv.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.nLv.nx(1);
                this.nLv.nv(R.color.CAM_X0105);
                this.nLv.jD(true);
                this.nLv.b(getPageContext());
                this.nLv.bqe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dTf() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.f.dPM().dPN() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !com.baidu.adp.lib.util.j.isMobileNet() || !this.eqJ) {
            return false;
        }
        if (this.nLb != null) {
            this.nLb.setVisibility(0);
        }
        aQJ();
        dTe();
        return true;
    }

    private void aQK() {
        if (!dTf() && this.gxn != null && this.nLb != null && this.nLf != null) {
            if (this.gxn.getParent() == null) {
                dTk();
                dTl();
            }
            if (TbVideoViewSet.dym().PO(this.mVideoUrl) == null || TbVideoViewSet.dym().PO(this.mVideoUrl) != this.gxn) {
                this.gxn.setVideoPath(this.mVideoUrl, this.nLf.thread_id);
            }
            this.gxn.a((TbVideoViewSet.a) null);
            this.nLb.setVisibility(8);
            dxx();
            if (this.nLu != null) {
                this.nLu.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.nLo == null) {
            this.nLo = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.nLo;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0591a
    public void bIz() {
        if (this.gxn.isPlaying()) {
            this.gxn.pause();
            this.nLb.setVisibility(0);
        } else if (!dTf()) {
            this.gxn.start();
            this.nLb.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0591a
    public void z(float f, float f2) {
        if (bg.checkUpIsLogin(getActivity()) && !this.nLp) {
            dTg();
            if (this.nLf != null && "0".equals(this.nLf.is_agreed)) {
                Ky(this.nKM);
            }
        }
    }

    private void dTg() {
        if (this.mRootView != null) {
            this.nLp = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.nLr == null) {
                this.nLr = new RelativeLayout.LayoutParams(-2, -2);
                this.nLr.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.nLr);
            }
            if (this.nLq == null) {
                this.nLq = new AnimatorSet();
                this.nLq.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.nLp = false;
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
            this.nLq.setTarget(imageView);
            this.nLq.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.nLq.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0591a
    public void bIA() {
        if (this.nLf != null && this.nLf.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.nLf.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dTh() {
        return null;
    }

    public String dTi() {
        return null;
    }

    public boolean dTj() {
        if (this.nLt == null || this.nLt.bAP() == null || !this.nLt.bAP().isVisible()) {
            return false;
        }
        this.nLt.bAP().hide();
        this.nLj.setVisibility(0);
        if ((this.nLt.bAP().qP(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.nLt.bAP().qP(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.nLt.bAP().qP(28)).getInputView().getText() != null) {
            this.nLk.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nLt.bAP().qP(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.nLt != null) {
            this.nLt.onActivityResult(i, i2, intent);
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
        if (this.nLt != null && this.nLt.bAP() != null) {
            this.nLt.bAP().onChangeSkinType(i);
        }
        SvgManager.bsx().a(this.aCK, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dTk() {
        if (this.gxn != null && this.gxn.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.gxn.getView(), 0);
            this.gxn.getView().setLayoutParams(layoutParams);
            if (this.nLf != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.amM = this.nLf.thread_id;
                oVar.eRn = this.nLf.nid;
                oVar.fKR = this.nLf.forum_id;
                oVar.mzc = this.nLf.mMd5;
                oVar.eLs = "";
                oVar.mSource = this.nLf.mRecomSource;
                oVar.mzb = this.nLf.mRecomAbTag;
                oVar.mza = 1;
                if (this.nLf.baijiahaoData != null) {
                    if (this.nLf.baijiahaoData.oriUgcType == 2) {
                        oVar.mza = 3;
                    } else if (this.nLf.baijiahaoData.oriUgcType == 4) {
                        oVar.mza = 2;
                    }
                }
                oVar.myY = this.nLf.mRecomWeight;
                if (this.mRect != null) {
                    oVar.mzd = "1";
                } else {
                    oVar.mzd = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.mze = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.myZ = this.mFromPage;
                    oVar.eLs = this.eLs;
                    oVar.myX = this.nLf.mRecomWeight;
                } else {
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
                }
                this.gxn.setVideoStatData(oVar);
                this.gxn.setLocateSource("v_mid_page");
            }
            this.gxn.setContinuePlayEnable(true);
        }
    }

    private void dTl() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.gxn.setOnPreparedListener(this.nLw);
        }
        this.gxn.setOnCompletionListener(this.mzJ);
        this.gxn.setOnInfoListener(this.mzL);
    }
}
