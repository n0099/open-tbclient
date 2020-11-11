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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0605a {
    public ImageView aGl;
    private String eAX;
    private boolean egx;
    private e evx;
    private boolean gQx;
    public TbCyberVideoView gjd;
    private AlphaAnimation gmg;
    private int iJE;
    private View iih;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private f.b miU;
    private TbImageView nwN;
    public ImageView nwO;
    public HeadImageView nwP;
    public LinearLayout nwQ;
    public LinearLayout nwR;
    public LinearLayout nwS;
    public ImageView nwT;
    public ImageView nwU;
    public ImageView nwV;
    public ExpandableTextView nwW;
    public TextView nwX;
    public TextView nwY;
    public TextView nwZ;
    public TextView nxa;
    public ImageView nxb;
    private LinearLayout nxc;
    public LinearLayout nxd;
    public LinearLayout nxe;
    public VideoItemData nxf;
    private TextView nxg;
    public ImageView nxh;
    public TextView nxi;
    private View nxj;
    private TextView nxk;
    private int nxl;
    private int nxm;
    private com.baidu.tieba.view.a nxn;
    protected Animation nxo;
    private boolean nxp;
    private AnimatorSet nxq;
    private RelativeLayout.LayoutParams nxr;
    private com.baidu.tieba.videoplay.editor.a nxt;
    private a nxu;
    com.baidu.tbadk.core.dialog.a nxv;
    private int nwL = 0;
    private int nwM = 1;
    private ForumManageModel hYQ = null;
    private com.baidu.tbadk.baseEditMark.a ltP = null;
    private com.baidu.tbadk.coreExtra.model.a eNr = null;
    private BdUniqueId aiz = BdUniqueId.gen();
    private boolean nxs = false;
    private int playTime = 1;
    private CustomMessageListener eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.nxf != null && VideoPlayFragment.this.nxf.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nxf.author_info.user_id) && data != null && VideoPlayFragment.this.nxf.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aiz)) ? false : false;
                    if (data.feD == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.nxf.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.nxf.author_info.is_follow = "0";
                                VideoPlayFragment.this.dRX();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.egx) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.nxf));
                                } else {
                                    VideoPlayFragment.this.nxf.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dRX();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.nxf.author_info.is_follow = "0";
                            VideoPlayFragment.this.dRX();
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
    private final CustomMessageListener exb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.dRZ();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.nxf != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.nxf.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.nxf.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.nxf.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.nxf.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dRW();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.nxf.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.nxf.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.nxf.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dRW();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnInfoListener mkF = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.egx) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.nwN.getVisibility() == 0) {
                    VideoPlayFragment.this.nwN.clearAnimation();
                    VideoPlayFragment.this.nwN.startAnimation(VideoPlayFragment.this.gmg);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener mkD = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.gjd != null) {
                VideoPlayFragment.this.gjd.dxu();
                VideoPlayFragment.this.gjd.seekTo(0);
                VideoPlayFragment.this.gjd.start();
                VideoPlayFragment.this.cnZ();
                VideoPlayFragment.A(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dRQ();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener nxw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.gjd != null) {
                VideoPlayFragment.this.gjd.setVolume(1.0f, 1.0f);
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
        this.nxf = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.nxm = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.eAX = arguments.getString("obj_id");
        if (this.nxf != null && this.nxf.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.nxf.author_info.user_id)) {
            this.gQx = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.gjd = new TbCyberVideoView(getContext());
        this.gjd.setStageType("2005");
        this.gjd.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.f.b
            public void ce(int i, int i2) {
                if (VideoPlayFragment.this.miU != null) {
                    VideoPlayFragment.this.miU.ce(i, i2);
                }
            }
        });
        dSe();
        this.nwN = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.nwN.setPlaceHolder(4);
        this.nwN.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.bqr()) {
            this.iih = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.iih.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.iih.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aGl = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.nwO = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.nwP = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.nwP.setDefaultResource(17170445);
        this.nwP.setPlaceHolder(2);
        this.nwP.setIsRound(true);
        this.nwT = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.nxh = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.nwW = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.nwX = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.nwR = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.nwY = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.nwQ = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.nwZ = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.nxa = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.nwU = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nwV = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dRR();
        this.nxb = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.nxc = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.nxd = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.nxe = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.nwS = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.nxi = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.nxj = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.nxj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.nxj.setVisibility(4);
                    if (VideoPlayFragment.this.nxt != null && VideoPlayFragment.this.nxt.bzx() != null) {
                        VideoPlayFragment.this.nxt.bzx().display();
                        if (VideoPlayFragment.this.nxf != null) {
                            VideoPlayFragment.this.nxt.c(VideoPlayFragment.this.nxf);
                        }
                    }
                    if (VideoPlayFragment.this.nxf != null) {
                        aq aqVar = new aq("c13025");
                        aqVar.dR("tid", VideoPlayFragment.this.nxf.thread_id);
                        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar.dR("fid", VideoPlayFragment.this.nxf.forum_id);
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        });
        this.nxk = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.nxg = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.nxg.setVisibility(8);
        String string = b.bqh().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.nxg.setText(string);
        }
        final String string2 = b.bqh().getString("nani_key_download_link_url", null);
        this.nxg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    be.brr().a((TbPageContext) i.I(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dRV();
        this.nwP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nxf != null && VideoPlayFragment.this.nxf.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nxf.author_info.user_id) && VideoPlayFragment.this.nxf != null && VideoPlayFragment.this.nxf.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nxf.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    aq aqVar = new aq("c12798");
                    aqVar.dR("tid", VideoPlayFragment.this.nxf.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.nxd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nxf != null && VideoPlayFragment.this.nxf.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.nxf.act_info.link_url);
                    aq aqVar = new aq("c12799");
                    aqVar.dR("tid", VideoPlayFragment.this.nxf.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.nwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dRT();
            }
        });
        this.aGl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nxf != null && !StringUtils.isNull(VideoPlayFragment.this.nxf.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.nxf.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.nwO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dRU();
            }
        });
        this.nwR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.nxf)) {
                    VideoPlayFragment.this.dRT();
                    aq aqVar = new aq("c12796");
                    aqVar.dR("tid", VideoPlayFragment.this.nxf.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.nwQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.KX(VideoPlayFragment.this.nwL);
            }
        });
        this.nwS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bsT();
                aq aqVar = new aq("c12797");
                aqVar.dR("tid", VideoPlayFragment.this.nxf.thread_id);
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar);
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dR("tid", VideoPlayFragment.this.nxf.thread_id);
                aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.al("obj_locate", 19);
                aqVar2.dR("nid", VideoPlayFragment.this.nxf.nid);
                if (VideoPlayFragment.this.nxf.baijiahaoData != null && !at.isEmpty(VideoPlayFragment.this.nxf.baijiahaoData.oriUgcVid)) {
                    aqVar2.dR("obj_param6", VideoPlayFragment.this.nxf.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.nxf.getVideoType() == 1) {
                    aqVar2.al(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.nxf.getVideoType() == 2) {
                    aqVar2.al(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.nxf.getVideoType() == 3) {
                    aqVar2.al(IntentConfig.CARD_TYPE, 6);
                }
                aqVar2.dR(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.nxf.mRecomSource);
                aqVar2.dR("ab_tag", VideoPlayFragment.this.nxf.mRecomAbTag);
                aqVar2.dR("weight", VideoPlayFragment.this.nxf.mRecomWeight);
                aqVar2.dR("extra", VideoPlayFragment.this.nxf.mRecomExtra);
                aqVar2.dR("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.es(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.es(VideoPlayFragment.this.getBaseFragmentActivity()).bCd() != null && c.es(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.es(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    aqVar2.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    aqVar2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(aqVar2);
            }
        });
        this.nwT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nxf != null && VideoPlayFragment.this.nxf.author_info != null) {
                    VideoPlayFragment.this.eNr.a(true, VideoPlayFragment.this.nxf.author_info.portrait, VideoPlayFragment.this.nxf.author_info.user_id, false, "6", VideoPlayFragment.this.aiz, VideoPlayFragment.this.nxf.forum_id, "0");
                    VideoPlayFragment.this.nxf.author_info.is_follow = "1";
                    VideoPlayFragment.this.dRX();
                }
            }
        });
        this.gmg = new AlphaAnimation(1.0f, 0.0f);
        this.gmg.setDuration(100L);
        this.gmg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.nwN != null) {
                    VideoPlayFragment.this.nwN.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.nxl = this.mRect.right - this.mRect.left;
            this.iJE = this.mRect.bottom - this.mRect.top;
            this.nwN.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.nwN.getWidth();
                    int height = VideoPlayFragment.this.nwN.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nxf.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nxf.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nxf.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nxf.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nxl, VideoPlayFragment.this.iJE);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.nwN.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.iJE > 0 || VideoPlayFragment.this.nxl <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.nxl;
                                f = i / VideoPlayFragment.this.iJE;
                            }
                            VideoPlayFragment.this.nwN.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.nwN.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.egx) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nxl, VideoPlayFragment.this.iJE);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.nwN.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.iJE > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.nwN.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.nwN.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.egx) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.nwN.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.nwN.getWidth();
                    int height = VideoPlayFragment.this.nwN.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nxf.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nxf.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nxf.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nxf.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.nwN.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.nwN.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cXB();
        if (this.egx) {
            dRS();
        }
        if (this.nxf != null && !StringUtils.isNull(this.nxf.video_url)) {
            setVideoInfo(this.nxf.video_url);
        }
        return this.mRootView;
    }

    public void a(f.b bVar) {
        this.miU = bVar;
    }

    public void a(a aVar) {
        this.nxu = aVar;
    }

    private void cXB() {
        this.nxt = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().ei(getActivity());
        if (this.nxt != null && this.nxf != null) {
            this.nxt.a(getPageContext());
            this.nxt.aJ(this.nxf.thread_id, this.nxf.forum_id, this.nxf.forum_name);
            this.nxt.a(new a.InterfaceC0868a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0868a
                public void yi(boolean z) {
                    VideoPlayFragment.this.nxj.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.nxk.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.nxk.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.nxt.bzx().rk(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.nxf != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nxf.comment_num, 0L) + 1;
                        VideoPlayFragment.this.nxf.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.nwY.setText(at.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.nxt.bzx(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsT() {
        String str;
        String str2;
        if (this.nxf != null) {
            String str3 = this.nxf.forum_id;
            String str4 = this.nxf.forum_name;
            String str5 = this.nxf.title;
            if (this.nxf.baijiahaoData != null) {
                str = this.nxf.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.nxf.baijiahaoData.oriUgcType + "&dvid=" + this.nxf.baijiahaoData.oriUgcVid + "&nid=" + this.nxf.baijiahaoData.oriUgcNid;
            } else {
                str = this.nxf.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str7 = this.nxf.thumbnail_url;
            String format = (!this.nxf.isBjhVideo || this.nxf.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.nxf.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.nxf.baijiahaoData == null) {
                shareItem.readCount = this.nxf.play_count;
            }
            if (this.nxf.isBjhVideo) {
                shareItem.fgU = format;
            } else {
                shareItem.fgU = "";
            }
            shareItem.linkUrl = str6;
            shareItem.eHo = 2;
            shareItem.extData = str;
            shareItem.fgX = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.fgJ = true;
            shareItem.fgW = 12;
            if (this.nxf.getVideoType() == 1) {
                shareItem.fhb = 2;
            } else if (this.nxf.getVideoType() == 2) {
                shareItem.fhb = 8;
            } else if (this.nxf.getVideoType() == 3) {
                shareItem.fhb = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.nxf.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.nxf.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.nxf.title;
            originalThreadInfo.threadId = this.nxf.thread_id;
            originalThreadInfo.oriUgcInfo = this.nxf.baijiahaoData;
            shareItem.fhe = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fgX);
            bundle.putInt("obj_type", shareItem.fhb);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eHo);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.f.cpv().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gQx) {
            this.hYQ = new ForumManageModel(getPageContext());
            this.hYQ.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.hYQ.getLoadDataMode()) {
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
        this.ltP = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.ltP != null) {
            this.ltP.a(new a.InterfaceC0573a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0573a
                public void d(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.ltP != null) {
                            VideoPlayFragment.this.ltP.iq(z2);
                        }
                        if (VideoPlayFragment.this.nxf != null) {
                            if (z2) {
                                VideoPlayFragment.this.nxf.mark_id = VideoPlayFragment.this.nxf.post_id;
                            } else {
                                VideoPlayFragment.this.nxf.mark_id = null;
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
        this.eNr = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.eNv);
        registerListener(this.exb);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.nxs = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dRV();
        dSf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRQ() {
        if (this.nwV != null && this.nwU != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.nwU.clearAnimation();
            this.nwV.clearAnimation();
            this.nwU.setVisibility(8);
            this.nwV.setVisibility(0);
            this.nwV.startAnimation(scaleAnimation2);
            this.nwU.startAnimation(scaleAnimation);
        }
    }

    private void dRR() {
        if (this.nwV != null && this.nwU != null) {
            this.nwU.clearAnimation();
            this.nwV.clearAnimation();
            this.nwU.setVisibility(0);
            this.nwV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KX(int i) {
        int i2;
        if (bg.checkUpIsLogin(getActivity()) && this.nxf != null) {
            if (i == this.nwL) {
                if ("1".equals(this.nxf.is_agreed)) {
                    i2 = 1;
                    this.nxf.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nxf.agree_num, 0) - 1);
                    this.nxf.is_agreed = "0";
                } else {
                    this.nxf.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nxf.agree_num, 0) + 1);
                    this.nxf.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.nxf.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nxf.agree_num, 0) + 1);
                this.nxf.is_agreed = "1";
                i2 = 0;
            }
            aq aqVar = new aq("c12795");
            aqVar.dR("tid", this.nxf.thread_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nwL) {
                aqVar.al("obj_type", i2);
            } else {
                aqVar.al("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12003");
            aqVar2.dR("tid", this.nxf.thread_id);
            aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nwL) {
                aqVar2.al("obj_type", i2);
            } else {
                aqVar2.al("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                aqVar2.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                aqVar2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            TiebaStatic.log(aqVar2);
            dRV();
            if (this.nxh != null && i2 == 0) {
                this.nxh.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.nxf.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.nxf.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.nxf.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.nxf.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.nxf.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.nxf.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.nxf.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.nxf.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.nxf));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.nxf != null && !StringUtils.isNull(this.nxf.video_url)) {
            this.mHasInit = true;
            if (this.egx) {
                cnZ();
                aPM();
                if (this.nxf != null && this.mRect != null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dR("tid", this.nxf.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.al("obj_type", 0);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            aPL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        aPL();
        if (this.nxt != null && this.nxt.bzx() != null) {
            this.nxt.bzx().hide();
            this.nxj.setVisibility(0);
            this.nxk.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nxt.bzx().rk(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.nxt != null) {
            this.nxt.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.egx = z;
        if (!z && this.nxt != null) {
            this.nxk.setText(R.string.reply_something);
            this.nxt.cCv();
        }
        if (this.mHasInit) {
            if (this.egx && (!this.nxs || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.nxf != null && this.mRect == null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dR("tid", this.nxf.thread_id);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.al("obj_type", 1);
                    TiebaStatic.log(aqVar);
                }
                startPlay();
                dRS();
                this.nxs = false;
                return;
            }
            dRR();
            this.playTime = 1;
            aPL();
        }
    }

    private void dRS() {
        if (this.nxf != null) {
            aq aqVar = new aq("c12590");
            aqVar.dR("tid", this.nxf.thread_id);
            aqVar.dR("nid", this.nxf.nid);
            aqVar.dR("fid", this.nxf.forum_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.al("obj_locate", this.nxm);
            aqVar.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dR("obj_param1", at.isEmpty(this.nxf.mRecomWeight) ? "0" : this.nxf.mRecomWeight);
            aqVar.dR("extra", at.isEmpty(this.nxf.mRecomExtra) ? "0" : this.nxf.mRecomExtra);
            aqVar.dR("obj_id", this.eAX);
            aqVar.dR("ab_tag", at.isEmpty(this.nxf.mRecomAbTag) ? "0" : this.nxf.mRecomAbTag);
            aqVar.dR("obj_source", at.isEmpty(this.nxf.mRecomSource) ? "0" : this.nxf.mRecomSource);
            aqVar.dR("obj_type", this.mFromPage);
            aqVar.al("is_vertical", 1);
            if (this.nxf.baijiahaoData != null) {
                aqVar.dR("obj_param4", this.nxf.baijiahaoData.oriUgcNid);
                aqVar.dR("obj_param6", this.nxf.baijiahaoData.oriUgcVid);
                if (this.nxf.baijiahaoData.oriUgcType == 4) {
                    aqVar.al("obj_param5", 2);
                } else if (this.nxf.baijiahaoData.oriUgcType == 2) {
                    aqVar.al("obj_param5", 3);
                }
            } else {
                aqVar.al("obj_param5", 1);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.gjd != null && str != null && !str.equals(this.mVideoUrl)) {
            this.gjd.setVideoPath(str, this.nxf.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dRZ()) {
            dwG();
            if (this.nxb != null) {
                this.nxb.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.nwN.getVisibility() == 0) {
                this.nwN.clearAnimation();
                this.nwN.startAnimation(this.gmg);
            }
            if (this.gjd != null) {
                if (TbVideoViewSet.dxv().QM(this.mVideoUrl) == null || TbVideoViewSet.dxv().QM(this.mVideoUrl) != this.gjd) {
                    this.gjd.setVideoPath(this.mVideoUrl, this.nxf.thread_id);
                }
                this.gjd.start();
                cnZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnZ() {
        if (this.nxf != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.alT = this.nxf.thread_id;
            oVar.mNid = this.nxf.nid;
            oVar.fyR = this.nxf.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.nxf.mRecomSource;
            oVar.mjR = this.nxf.mRecomAbTag;
            oVar.mjS = this.nxf.mRecomWeight;
            oVar.mjT = "";
            oVar.eAX = "";
            oVar.mjW = this.nxf.mMd5;
            if (this.mRect != null) {
                oVar.mjX = "1";
            } else {
                oVar.mjX = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.mjY = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.mjT = "index";
            }
            h.a(this.nxf.mMd5, "", "1", oVar, this.gjd.getPcdnState());
        }
    }

    private void dwG() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dOu().fW(getContext());
        }
    }

    private void aPL() {
        if (this.gjd != null) {
            this.gjd.pause();
        }
    }

    private void stopPlay() {
        if (this.gjd != null) {
            this.gjd.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRT() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.nxf.thread_id, this.nxf.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.nxf.forum_id));
        createNormalCfg.setForumName(this.nxf.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.nxf.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRU() {
        if (this.evx == null) {
            this.nxn = new com.baidu.tieba.view.a(getActivity());
            this.evx = new e(getActivity(), this.nxn.bps());
            this.evx.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.gjd.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.nxn != null) {
            ArrayList arrayList = new ArrayList();
            a.C0870a c0870a = new a.C0870a(this.nxn);
            c0870a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bg.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.evx.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.evx.dismiss();
                    if (VideoPlayFragment.this.nxf != null) {
                        boolean z = VideoPlayFragment.this.nxf.post_id != null && VideoPlayFragment.this.nxf.post_id.equals(VideoPlayFragment.this.nxf.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.nxf.thread_id);
                        markData.setPostId(VideoPlayFragment.this.nxf.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.nxf.thread_id);
                        markData.setForumId(VideoPlayFragment.this.nxf.forum_id);
                        if (VideoPlayFragment.this.ltP != null) {
                            VideoPlayFragment.this.ltP.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.ltP.bix();
                            } else {
                                VideoPlayFragment.this.ltP.biw();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.nxf != null && this.nxf.post_id != null && this.nxf.post_id.equals(this.nxf.mark_id)) {
                z = true;
            }
            if (z) {
                c0870a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0870a.setText(getResources().getString(R.string.mark));
            }
            if (this.nxf != null && !this.nxf.isBjhVideo) {
                arrayList.add(c0870a);
            }
            a.C0870a c0870a2 = new a.C0870a(getActivity().getString(R.string.delete), this.nxn);
            c0870a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.evx.dismiss();
                    if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nxf != null) {
                        String str = VideoPlayFragment.this.nxf.thread_id;
                        String str2 = VideoPlayFragment.this.nxf.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.nxf.post_id;
                        if (VideoPlayFragment.this.nxf.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.nxf.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.nxf.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0870a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0870a2);
            if (this.gQx) {
                a.C0870a c0870a3 = new a.C0870a(getActivity().getString(R.string.delete), this.nxn);
                c0870a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.evx.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.ow(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.nxf != null) {
                                    VideoPlayFragment.this.hYQ.a(VideoPlayFragment.this.nxf.forum_id, VideoPlayFragment.this.nxf.forum_name, VideoPlayFragment.this.nxf.thread_id, VideoPlayFragment.this.nxf.post_id, 0, 0, VideoPlayFragment.this.gQx, null);
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
                        aVar.iV(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.bpc();
                    }
                });
                c0870a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0870a3);
            }
            this.nxn.br(arrayList);
        }
        this.evx.show();
    }

    private void dRV() {
        if (this.nxf != null) {
            this.nwN.startLoad(this.nxf.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.nxf.title);
            if (StringUtils.isNull(this.nxf.title) || matcher.matches()) {
                this.nwW.setVisibility(8);
            } else {
                this.nwW.setVisibility(0);
                this.nwW.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.nwW.setTextColor(R.color.cp_cont_a);
                this.nwW.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.nwW.setExpandable(true);
                this.nwW.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void qA(boolean z) {
                        VideoPlayFragment.this.nxf.isTitleExpanded = z;
                    }
                });
                this.nwW.setData(this.nxf.title, this.nxf.isTitleExpanded);
            }
            this.nwY.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nxf.comment_num, 0L)));
            this.nwZ.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nxf.agree_num, 0L)));
            this.nxa.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nxf.share_num, 0L)));
            if (this.nxf.author_info != null) {
                if (!TextUtils.isEmpty(this.nxf.author_info.bjhAvatar)) {
                    this.nwP.startLoad(this.nxf.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.nxf.author_info.portrait) && this.nxf.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.nwP.startLoad(this.nxf.author_info.portrait, 10, false);
                } else {
                    this.nwP.startLoad(this.nxf.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.nxf.author_info.dOp())) {
                    this.nxi.setVisibility(8);
                } else {
                    this.nxi.setVisibility(0);
                    this.nxi.setText(UgcConstant.AT_RULE_TAG + this.nxf.author_info.dOp());
                }
            }
            if ("1".equals(this.nxf.is_private) && this.nxg.getVisibility() != 0) {
                this.nxe.setVisibility(0);
            } else {
                this.nxe.setVisibility(8);
            }
            if ("1".equals(this.nxf.is_agreed)) {
                ap.setImageResource(this.nxh, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.nxh, R.drawable.btn_video_agree);
            }
            if (this.nxf.act_info != null && !StringUtils.isNull(this.nxf.act_info.activity_name) && this.nxg.getVisibility() != 0) {
                this.nxd.setVisibility(0);
                this.nwX.setText(this.nxf.act_info.activity_name);
            } else {
                this.nxd.setVisibility(8);
            }
            dRX();
            if (this.nxf.isBjhVideo) {
                this.nwO.setVisibility(8);
            } else {
                this.nwO.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRW() {
        if (this.nxf != null) {
            if ("1".equals(this.nxf.is_agreed)) {
                ap.setImageResource(this.nxh, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.nxh, R.drawable.btn_video_agree);
            }
            this.nwZ.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nxf.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRX() {
        if (this.gQx || (this.nxf.author_info != null && !"0".equals(this.nxf.author_info.is_follow))) {
            this.nwT.setVisibility(4);
            this.nwT.setClickable(false);
            return;
        }
        this.nwT.setVisibility(0);
        this.nwT.setClickable(true);
    }

    private void dRY() {
        if (getActivity() != null) {
            if (this.nxv == null || !this.nxv.isShowing()) {
                this.nxv = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.brn().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.nxv.bf(inflate);
                this.nxv.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.nxv.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.nxv.oz(1);
                this.nxv.ox(R.color.cp_cont_b);
                this.nxv.iV(true);
                this.nxv.b(getPageContext());
                this.nxv.bpc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dRZ() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dOu().dOv() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet() || !this.egx) {
            return false;
        }
        if (this.nxb != null) {
            this.nxb.setVisibility(0);
        }
        aPL();
        dRY();
        return true;
    }

    private void aPM() {
        if (!dRZ() && this.gjd != null && this.nxb != null && this.nxf != null) {
            if (this.gjd.getParent() == null) {
                dSe();
                dSf();
            }
            if (TbVideoViewSet.dxv().QM(this.mVideoUrl) == null || TbVideoViewSet.dxv().QM(this.mVideoUrl) != this.gjd) {
                this.gjd.setVideoPath(this.mVideoUrl, this.nxf.thread_id);
            }
            this.gjd.a((TbVideoViewSet.a) null);
            this.nxb.setVisibility(8);
            dwG();
            if (this.nxu != null) {
                this.nxu.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.nxo == null) {
            this.nxo = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.nxo;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0605a
    public void bHf() {
        if (this.gjd.isPlaying()) {
            this.gjd.pause();
            this.nxb.setVisibility(0);
        } else if (!dRZ()) {
            this.gjd.start();
            this.nxb.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0605a
    public void y(float f, float f2) {
        if (bg.checkUpIsLogin(getActivity()) && !this.nxp) {
            dSa();
            if (this.nxf != null && "0".equals(this.nxf.is_agreed)) {
                KX(this.nwM);
            }
        }
    }

    private void dSa() {
        if (this.mRootView != null) {
            this.nxp = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.nxr == null) {
                this.nxr = new RelativeLayout.LayoutParams(-2, -2);
                this.nxr.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.nxr);
            }
            if (this.nxq == null) {
                this.nxq = new AnimatorSet();
                this.nxq.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.nxp = false;
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
            this.nxq.setTarget(imageView);
            this.nxq.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.nxq.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0605a
    public void bHg() {
        if (this.nxf != null && this.nxf.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.nxf.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dSb() {
        return null;
    }

    public String dSc() {
        return null;
    }

    public boolean dSd() {
        if (this.nxt == null || this.nxt.bzx() == null || !this.nxt.bzx().isVisible()) {
            return false;
        }
        this.nxt.bzx().hide();
        this.nxj.setVisibility(0);
        if ((this.nxt.bzx().rk(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.nxt.bzx().rk(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.nxt.bzx().rk(28)).getInputView().getText() != null) {
            this.nxk.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nxt.bzx().rk(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.nxt != null) {
            this.nxt.onActivityResult(i, i2, intent);
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
        if (this.nxt != null && this.nxt.bzx() != null) {
            this.nxt.bzx().onChangeSkinType(i);
        }
        SvgManager.brn().a(this.aGl, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dSe() {
        if (this.gjd != null && this.gjd.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.gjd.getView(), 0);
            this.gjd.getView().setLayoutParams(layoutParams);
            if (this.nxf != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.alT = this.nxf.thread_id;
                oVar.mNid = this.nxf.nid;
                oVar.fyR = this.nxf.forum_id;
                oVar.mjW = this.nxf.mMd5;
                oVar.eAX = "";
                oVar.mSource = this.nxf.mRecomSource;
                oVar.mjV = this.nxf.mRecomAbTag;
                oVar.mjU = 1;
                if (this.nxf.baijiahaoData != null) {
                    if (this.nxf.baijiahaoData.oriUgcType == 2) {
                        oVar.mjU = 3;
                    } else if (this.nxf.baijiahaoData.oriUgcType == 4) {
                        oVar.mjU = 2;
                    }
                }
                oVar.mjS = this.nxf.mRecomWeight;
                if (this.mRect != null) {
                    oVar.mjX = "1";
                } else {
                    oVar.mjX = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.mjY = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.mjT = this.mFromPage;
                    oVar.eAX = this.eAX;
                    oVar.mjR = this.nxf.mRecomWeight;
                } else {
                    oVar.mLocate = "14";
                }
                this.gjd.setVideoStatData(oVar);
                this.gjd.setLocateSource("v_mid_page");
            }
            this.gjd.setContinuePlayEnable(true);
        }
    }

    private void dSf() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.gjd.setOnPreparedListener(this.nxw);
        }
        this.gjd.setOnCompletionListener(this.mkD);
        this.gjd.setOnInfoListener(this.mkF);
    }
}
