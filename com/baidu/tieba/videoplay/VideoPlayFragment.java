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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0604a {
    public ImageView aEA;
    private boolean eeP;
    private e etO;
    private String ezo;
    private boolean gQe;
    public TbCyberVideoView giK;
    private AlphaAnimation glN;
    private int iKr;
    private View iiV;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private f.b mjn;
    private TbImageView nxU;
    public ImageView nxV;
    public HeadImageView nxW;
    public LinearLayout nxX;
    public LinearLayout nxY;
    public LinearLayout nxZ;
    private com.baidu.tieba.videoplay.editor.a nyA;
    private a nyB;
    com.baidu.tbadk.core.dialog.a nyC;
    public ImageView nya;
    public ImageView nyb;
    public ImageView nyc;
    public ExpandableTextView nyd;
    public TextView nye;
    public TextView nyf;
    public TextView nyg;
    public TextView nyh;
    public ImageView nyi;
    private LinearLayout nyj;
    public LinearLayout nyk;
    public LinearLayout nyl;
    public VideoItemData nym;
    private TextView nyn;
    public ImageView nyo;
    public TextView nyp;
    private View nyq;
    private TextView nyr;
    private int nys;
    private int nyt;
    private com.baidu.tieba.view.a nyu;
    protected Animation nyv;
    private boolean nyw;
    private AnimatorSet nyx;
    private RelativeLayout.LayoutParams nyy;
    private int nxS = 0;
    private int nxT = 1;
    private ForumManageModel hZq = null;
    private com.baidu.tbadk.baseEditMark.a luf = null;
    private com.baidu.tbadk.coreExtra.model.a eMq = null;
    private BdUniqueId aiE = BdUniqueId.gen();
    private boolean nyz = false;
    private int playTime = 1;
    private CustomMessageListener eMu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.nym != null && VideoPlayFragment.this.nym.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nym.author_info.user_id) && data != null && VideoPlayFragment.this.nym.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aiE)) ? false : false;
                    if (data.fdL == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.nym.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.nym.author_info.is_follow = "0";
                                VideoPlayFragment.this.dRW();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.eeP) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.nym));
                                } else {
                                    VideoPlayFragment.this.nym.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dRW();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.nym.author_info.is_follow = "0";
                            VideoPlayFragment.this.dRW();
                        }
                        ar arVar = new ar("c13570");
                        arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
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
    private final CustomMessageListener evs = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.dRY();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.nym != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.nym.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.nym.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.nym.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.nym.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dRV();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.nym.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.nym.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.nym.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dRV();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnInfoListener mkZ = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.eeP) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.nxU.getVisibility() == 0) {
                    VideoPlayFragment.this.nxU.clearAnimation();
                    VideoPlayFragment.this.nxU.startAnimation(VideoPlayFragment.this.glN);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener mkX = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.giK != null) {
                VideoPlayFragment.this.giK.dwU();
                VideoPlayFragment.this.giK.seekTo(0);
                VideoPlayFragment.this.giK.start();
                VideoPlayFragment.this.cnB();
                VideoPlayFragment.A(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dRP();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener nyD = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.giK != null) {
                VideoPlayFragment.this.giK.setVolume(1.0f, 1.0f);
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
        this.nym = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.nyt = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.ezo = arguments.getString("obj_id");
        if (this.nym != null && this.nym.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.nym.author_info.user_id)) {
            this.gQe = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.giK = new TbCyberVideoView(getContext());
        this.giK.setStageType("2005");
        this.giK.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.f.b
            public void ce(int i, int i2) {
                if (VideoPlayFragment.this.mjn != null) {
                    VideoPlayFragment.this.mjn.ce(i, i2);
                }
            }
        });
        dSd();
        this.nxU = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.nxU.setPlaceHolder(4);
        this.nxU.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.bpE()) {
            this.iiV = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.iiV.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.iiV.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aEA = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.nxV = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.nxW = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.nxW.setDefaultResource(17170445);
        this.nxW.setPlaceHolder(2);
        this.nxW.setIsRound(true);
        this.nya = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.nyo = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.nyd = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.nye = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.nxY = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.nyf = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.nxX = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.nyg = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.nyh = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.nyb = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nyc = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dRQ();
        this.nyi = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.nyj = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.nyk = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.nyl = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.nxZ = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.nyp = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.nyq = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.nyq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.nyq.setVisibility(4);
                    if (VideoPlayFragment.this.nyA != null && VideoPlayFragment.this.nyA.byN() != null) {
                        VideoPlayFragment.this.nyA.byN().display();
                        if (VideoPlayFragment.this.nym != null) {
                            VideoPlayFragment.this.nyA.c(VideoPlayFragment.this.nym);
                        }
                    }
                    if (VideoPlayFragment.this.nym != null) {
                        ar arVar = new ar("c13025");
                        arVar.dR("tid", VideoPlayFragment.this.nym.thread_id);
                        arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        arVar.dR("fid", VideoPlayFragment.this.nym.forum_id);
                        TiebaStatic.log(arVar);
                    }
                }
            }
        });
        this.nyr = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.nyn = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.nyn.setVisibility(8);
        String string = b.bpu().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.nyn.setText(string);
        }
        final String string2 = b.bpu().getString("nani_key_download_link_url", null);
        this.nyn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    bf.bqF().a((TbPageContext) i.I(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dRU();
        this.nxW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nym != null && VideoPlayFragment.this.nym.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nym.author_info.user_id) && VideoPlayFragment.this.nym != null && VideoPlayFragment.this.nym.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nym.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    ar arVar = new ar("c12798");
                    arVar.dR("tid", VideoPlayFragment.this.nym.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nyk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nym != null && VideoPlayFragment.this.nym.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.nym.act_info.link_url);
                    ar arVar = new ar("c12799");
                    arVar.dR("tid", VideoPlayFragment.this.nym.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nyd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dRS();
            }
        });
        this.aEA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nym != null && !StringUtils.isNull(VideoPlayFragment.this.nym.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.nym.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.nxV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dRT();
            }
        });
        this.nxY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.nym)) {
                    VideoPlayFragment.this.dRS();
                    ar arVar = new ar("c12796");
                    arVar.dR("tid", VideoPlayFragment.this.nym.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nxX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.LA(VideoPlayFragment.this.nxS);
            }
        });
        this.nxZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bsj();
                ar arVar = new ar("c12797");
                arVar.dR("tid", VideoPlayFragment.this.nym.thread_id);
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar);
                ar arVar2 = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar2.dR("tid", VideoPlayFragment.this.nym.thread_id);
                arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar2.ak("obj_locate", 19);
                arVar2.dR("nid", VideoPlayFragment.this.nym.nid);
                if (VideoPlayFragment.this.nym.baijiahaoData != null && !au.isEmpty(VideoPlayFragment.this.nym.baijiahaoData.oriUgcVid)) {
                    arVar2.dR("obj_param6", VideoPlayFragment.this.nym.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.nym.getVideoType() == 1) {
                    arVar2.ak(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.nym.getVideoType() == 2) {
                    arVar2.ak(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.nym.getVideoType() == 3) {
                    arVar2.ak(IntentConfig.CARD_TYPE, 6);
                }
                arVar2.dR(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.nym.mRecomSource);
                arVar2.dR("ab_tag", VideoPlayFragment.this.nym.mRecomAbTag);
                arVar2.dR("weight", VideoPlayFragment.this.nym.mRecomWeight);
                arVar2.dR("extra", VideoPlayFragment.this.nym.mRecomExtra);
                arVar2.dR("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.es(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.es(VideoPlayFragment.this.getBaseFragmentActivity()).bBt() != null && c.es(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.es(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    arVar2.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    arVar2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(arVar2);
            }
        });
        this.nya.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nym != null && VideoPlayFragment.this.nym.author_info != null) {
                    VideoPlayFragment.this.eMq.a(true, VideoPlayFragment.this.nym.author_info.portrait, VideoPlayFragment.this.nym.author_info.user_id, false, "6", VideoPlayFragment.this.aiE, VideoPlayFragment.this.nym.forum_id, "0");
                    VideoPlayFragment.this.nym.author_info.is_follow = "1";
                    VideoPlayFragment.this.dRW();
                }
            }
        });
        this.glN = new AlphaAnimation(1.0f, 0.0f);
        this.glN.setDuration(100L);
        this.glN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.nxU != null) {
                    VideoPlayFragment.this.nxU.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.nys = this.mRect.right - this.mRect.left;
            this.iKr = this.mRect.bottom - this.mRect.top;
            this.nxU.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.nxU.getWidth();
                    int height = VideoPlayFragment.this.nxU.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nym.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nym.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nym.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nym.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nys, VideoPlayFragment.this.iKr);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.nxU.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.iKr > 0 || VideoPlayFragment.this.nys <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.nys;
                                f = i / VideoPlayFragment.this.iKr;
                            }
                            VideoPlayFragment.this.nxU.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.nxU.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.eeP) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nys, VideoPlayFragment.this.iKr);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.nxU.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.iKr > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.nxU.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.nxU.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.eeP) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.nxU.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.nxU.getWidth();
                    int height = VideoPlayFragment.this.nxU.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nym.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nym.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nym.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nym.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.nxU.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.nxU.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cWX();
        if (this.eeP) {
            dRR();
        }
        if (this.nym != null && !StringUtils.isNull(this.nym.video_url)) {
            setVideoInfo(this.nym.video_url);
        }
        return this.mRootView;
    }

    public void a(f.b bVar) {
        this.mjn = bVar;
    }

    public void a(a aVar) {
        this.nyB = aVar;
    }

    private void cWX() {
        this.nyA = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().ei(getActivity());
        if (this.nyA != null && this.nym != null) {
            this.nyA.a(getPageContext());
            this.nyA.aJ(this.nym.thread_id, this.nym.forum_id, this.nym.forum_name);
            this.nyA.a(new a.InterfaceC0871a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0871a
                public void yp(boolean z) {
                    VideoPlayFragment.this.nyq.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.nyr.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.nyr.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.nyA.byN().rI(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.nym != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nym.comment_num, 0L) + 1;
                        VideoPlayFragment.this.nym.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.nyf.setText(au.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.nyA.byN(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsj() {
        String str;
        String str2;
        if (this.nym != null) {
            String str3 = this.nym.forum_id;
            String str4 = this.nym.forum_name;
            String str5 = this.nym.title;
            if (this.nym.baijiahaoData != null) {
                str = this.nym.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.nym.baijiahaoData.oriUgcType + "&dvid=" + this.nym.baijiahaoData.oriUgcVid + "&nid=" + this.nym.baijiahaoData.oriUgcNid;
            } else {
                str = this.nym.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str7 = this.nym.thumbnail_url;
            String format = (!this.nym.isBjhVideo || this.nym.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.nym.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.nym.baijiahaoData == null) {
                shareItem.readCount = this.nym.play_count;
            }
            if (this.nym.isBjhVideo) {
                shareItem.fgc = format;
            } else {
                shareItem.fgc = "";
            }
            shareItem.linkUrl = str6;
            shareItem.eFG = 2;
            shareItem.extData = str;
            shareItem.fgf = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.ffR = true;
            shareItem.fge = 12;
            if (this.nym.getVideoType() == 1) {
                shareItem.fgj = 2;
            } else if (this.nym.getVideoType() == 2) {
                shareItem.fgj = 8;
            } else if (this.nym.getVideoType() == 3) {
                shareItem.fgj = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.nym.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.nym.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.nym.title;
            originalThreadInfo.threadId = this.nym.thread_id;
            originalThreadInfo.oriUgcInfo = this.nym.baijiahaoData;
            shareItem.fgm = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fgf);
            bundle.putInt("obj_type", shareItem.fgj);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eFG);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.d.f.coW().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gQe) {
            this.hZq = new ForumManageModel(getPageContext());
            this.hZq.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.hZq.getLoadDataMode()) {
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
        this.luf = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.luf != null) {
            this.luf.a(new a.InterfaceC0571a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0571a
                public void d(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.luf != null) {
                            VideoPlayFragment.this.luf.is(z2);
                        }
                        if (VideoPlayFragment.this.nym != null) {
                            if (z2) {
                                VideoPlayFragment.this.nym.mark_id = VideoPlayFragment.this.nym.post_id;
                            } else {
                                VideoPlayFragment.this.nym.mark_id = null;
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
        this.eMq = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.eMu);
        registerListener(this.evs);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.nyz = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dRU();
        dSe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRP() {
        if (this.nyc != null && this.nyb != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.nyb.clearAnimation();
            this.nyc.clearAnimation();
            this.nyb.setVisibility(8);
            this.nyc.setVisibility(0);
            this.nyc.startAnimation(scaleAnimation2);
            this.nyb.startAnimation(scaleAnimation);
        }
    }

    private void dRQ() {
        if (this.nyc != null && this.nyb != null) {
            this.nyb.clearAnimation();
            this.nyc.clearAnimation();
            this.nyb.setVisibility(0);
            this.nyc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LA(int i) {
        int i2;
        if (bh.checkUpIsLogin(getActivity()) && this.nym != null) {
            if (i == this.nxS) {
                if ("1".equals(this.nym.is_agreed)) {
                    i2 = 1;
                    this.nym.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nym.agree_num, 0) - 1);
                    this.nym.is_agreed = "0";
                } else {
                    this.nym.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nym.agree_num, 0) + 1);
                    this.nym.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.nym.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nym.agree_num, 0) + 1);
                this.nym.is_agreed = "1";
                i2 = 0;
            }
            ar arVar = new ar("c12795");
            arVar.dR("tid", this.nym.thread_id);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nxS) {
                arVar.ak("obj_type", i2);
            } else {
                arVar.ak("obj_type", 2);
            }
            TiebaStatic.log(arVar);
            ar arVar2 = new ar("c12003");
            arVar2.dR("tid", this.nym.thread_id);
            arVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nxS) {
                arVar2.ak("obj_type", i2);
            } else {
                arVar2.ak("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                arVar2.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                arVar2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            TiebaStatic.log(arVar2);
            dRU();
            if (this.nyo != null && i2 == 0) {
                this.nyo.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.nym.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.nym.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.nym.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.nym.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.nym.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.nym.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.nym.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.nym.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.nym));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.nym != null && !StringUtils.isNull(this.nym.video_url)) {
            this.mHasInit = true;
            if (this.eeP) {
                cnB();
                aPe();
                if (this.nym != null && this.mRect != null) {
                    ar arVar = new ar("c12794");
                    arVar.dR("tid", this.nym.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.ak("obj_type", 0);
                    TiebaStatic.log(arVar);
                    return;
                }
                return;
            }
            aPd();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        aPd();
        if (this.nyA != null && this.nyA.byN() != null) {
            this.nyA.byN().hide();
            this.nyq.setVisibility(0);
            this.nyr.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nyA.byN().rI(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.nyA != null) {
            this.nyA.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.eeP = z;
        if (!z && this.nyA != null) {
            this.nyr.setText(R.string.reply_something);
            this.nyA.cBZ();
        }
        if (this.mHasInit) {
            if (this.eeP && (!this.nyz || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.nym != null && this.mRect == null) {
                    ar arVar = new ar("c12794");
                    arVar.dR("tid", this.nym.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.ak("obj_type", 1);
                    TiebaStatic.log(arVar);
                }
                startPlay();
                dRR();
                this.nyz = false;
                return;
            }
            dRQ();
            this.playTime = 1;
            aPd();
        }
    }

    private void dRR() {
        if (this.nym != null) {
            ar arVar = new ar("c12590");
            arVar.dR("tid", this.nym.thread_id);
            arVar.dR("nid", this.nym.nid);
            arVar.dR("fid", this.nym.forum_id);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.ak("obj_locate", this.nyt);
            arVar.ak(TiebaInitialize.Params.OBJ_PARAM2, 1);
            arVar.dR("obj_param1", au.isEmpty(this.nym.mRecomWeight) ? "0" : this.nym.mRecomWeight);
            arVar.dR("extra", au.isEmpty(this.nym.mRecomExtra) ? "0" : this.nym.mRecomExtra);
            arVar.dR("obj_id", this.ezo);
            arVar.dR("ab_tag", au.isEmpty(this.nym.mRecomAbTag) ? "0" : this.nym.mRecomAbTag);
            arVar.dR("obj_source", au.isEmpty(this.nym.mRecomSource) ? "0" : this.nym.mRecomSource);
            arVar.dR("obj_type", this.mFromPage);
            arVar.ak("is_vertical", 1);
            if (this.nym.baijiahaoData != null) {
                arVar.dR("obj_param4", this.nym.baijiahaoData.oriUgcNid);
                arVar.dR("obj_param6", this.nym.baijiahaoData.oriUgcVid);
                if (this.nym.baijiahaoData.oriUgcType == 4) {
                    arVar.ak("obj_param5", 2);
                } else if (this.nym.baijiahaoData.oriUgcType == 2) {
                    arVar.ak("obj_param5", 3);
                }
            } else {
                arVar.ak("obj_param5", 1);
            }
            TiebaStatic.log(arVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.giK != null && str != null && !str.equals(this.mVideoUrl)) {
            this.giK.setVideoPath(str, this.nym.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dRY()) {
            dwg();
            if (this.nyi != null) {
                this.nyi.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.nxU.getVisibility() == 0) {
                this.nxU.clearAnimation();
                this.nxU.startAnimation(this.glN);
            }
            if (this.giK != null) {
                if (TbVideoViewSet.dwV().Qh(this.mVideoUrl) == null || TbVideoViewSet.dwV().Qh(this.mVideoUrl) != this.giK) {
                    this.giK.setVideoPath(this.mVideoUrl, this.nym.thread_id);
                }
                this.giK.start();
                cnB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnB() {
        if (this.nym != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.alZ = this.nym.thread_id;
            oVar.mNid = this.nym.nid;
            oVar.fyg = this.nym.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.nym.mRecomSource;
            oVar.mkk = this.nym.mRecomAbTag;
            oVar.mkl = this.nym.mRecomWeight;
            oVar.mkm = "";
            oVar.ezo = "";
            oVar.mkp = this.nym.mMd5;
            if (this.mRect != null) {
                oVar.mkq = "1";
            } else {
                oVar.mkq = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.mkr = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.mkm = "index";
            }
            h.a(this.nym.mMd5, "", "1", oVar, this.giK.getPcdnState());
        }
    }

    private void dwg() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dOt().fV(getContext());
        }
    }

    private void aPd() {
        if (this.giK != null) {
            this.giK.pause();
        }
    }

    private void stopPlay() {
        if (this.giK != null) {
            this.giK.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRS() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.nym.thread_id, this.nym.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.nym.forum_id));
        createNormalCfg.setForumName(this.nym.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.nym.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRT() {
        if (this.etO == null) {
            this.nyu = new com.baidu.tieba.view.a(getActivity());
            this.etO = new e(getActivity(), this.nyu.bow());
            this.etO.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.giK.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.nyu != null) {
            ArrayList arrayList = new ArrayList();
            a.C0873a c0873a = new a.C0873a(this.nyu);
            c0873a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bh.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.etO.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.etO.dismiss();
                    if (VideoPlayFragment.this.nym != null) {
                        boolean z = VideoPlayFragment.this.nym.post_id != null && VideoPlayFragment.this.nym.post_id.equals(VideoPlayFragment.this.nym.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.nym.thread_id);
                        markData.setPostId(VideoPlayFragment.this.nym.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.nym.thread_id);
                        markData.setForumId(VideoPlayFragment.this.nym.forum_id);
                        if (VideoPlayFragment.this.luf != null) {
                            VideoPlayFragment.this.luf.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.luf.bhR();
                            } else {
                                VideoPlayFragment.this.luf.bhQ();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.nym != null && this.nym.post_id != null && this.nym.post_id.equals(this.nym.mark_id)) {
                z = true;
            }
            if (z) {
                c0873a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0873a.setText(getResources().getString(R.string.mark));
            }
            if (this.nym != null && !this.nym.isBjhVideo) {
                arrayList.add(c0873a);
            }
            a.C0873a c0873a2 = new a.C0873a(getActivity().getString(R.string.delete), this.nyu);
            c0873a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.etO.dismiss();
                    if (bh.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nym != null) {
                        String str = VideoPlayFragment.this.nym.thread_id;
                        String str2 = VideoPlayFragment.this.nym.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.nym.post_id;
                        if (VideoPlayFragment.this.nym.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.nym.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.nym.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0873a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0873a2);
            if (this.gQe) {
                a.C0873a c0873a3 = new a.C0873a(getActivity().getString(R.string.delete), this.nyu);
                c0873a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.etO.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.os(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.nym != null) {
                                    VideoPlayFragment.this.hZq.a(VideoPlayFragment.this.nym.forum_id, VideoPlayFragment.this.nym.forum_name, VideoPlayFragment.this.nym.thread_id, VideoPlayFragment.this.nym.post_id, 0, 0, VideoPlayFragment.this.gQe, null);
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
                        aVar.iW(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.bog();
                    }
                });
                c0873a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0873a3);
            }
            this.nyu.br(arrayList);
        }
        this.etO.show();
    }

    private void dRU() {
        if (this.nym != null) {
            this.nxU.startLoad(this.nym.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.nym.title);
            if (StringUtils.isNull(this.nym.title) || matcher.matches()) {
                this.nyd.setVisibility(8);
            } else {
                this.nyd.setVisibility(0);
                this.nyd.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.nyd.setTextColor(R.color.CAM_X0101);
                this.nyd.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.nyd.setExpandable(true);
                this.nyd.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void qD(boolean z) {
                        VideoPlayFragment.this.nym.isTitleExpanded = z;
                    }
                });
                this.nyd.setData(this.nym.title, this.nym.isTitleExpanded);
            }
            this.nyf.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nym.comment_num, 0L)));
            this.nyg.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nym.agree_num, 0L)));
            this.nyh.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nym.share_num, 0L)));
            if (this.nym.author_info != null) {
                if (!TextUtils.isEmpty(this.nym.author_info.bjhAvatar)) {
                    this.nxW.startLoad(this.nym.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.nym.author_info.portrait) && this.nym.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.nxW.startLoad(this.nym.author_info.portrait, 10, false);
                } else {
                    this.nxW.startLoad(this.nym.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.nym.author_info.dOo())) {
                    this.nyp.setVisibility(8);
                } else {
                    this.nyp.setVisibility(0);
                    this.nyp.setText(UgcConstant.AT_RULE_TAG + this.nym.author_info.dOo());
                }
            }
            if ("1".equals(this.nym.is_private) && this.nyn.getVisibility() != 0) {
                this.nyl.setVisibility(0);
            } else {
                this.nyl.setVisibility(8);
            }
            if ("1".equals(this.nym.is_agreed)) {
                ap.setImageResource(this.nyo, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.nyo, R.drawable.btn_video_agree);
            }
            if (this.nym.act_info != null && !StringUtils.isNull(this.nym.act_info.activity_name) && this.nyn.getVisibility() != 0) {
                this.nyk.setVisibility(0);
                this.nye.setText(this.nym.act_info.activity_name);
            } else {
                this.nyk.setVisibility(8);
            }
            dRW();
            if (this.nym.isBjhVideo) {
                this.nxV.setVisibility(8);
            } else {
                this.nxV.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRV() {
        if (this.nym != null) {
            if ("1".equals(this.nym.is_agreed)) {
                ap.setImageResource(this.nyo, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.nyo, R.drawable.btn_video_agree);
            }
            this.nyg.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nym.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRW() {
        if (this.gQe || (this.nym.author_info != null && !"0".equals(this.nym.author_info.is_follow))) {
            this.nya.setVisibility(4);
            this.nya.setClickable(false);
            return;
        }
        this.nya.setVisibility(0);
        this.nya.setClickable(true);
    }

    private void dRX() {
        if (getActivity() != null) {
            if (this.nyC == null || !this.nyC.isShowing()) {
                this.nyC = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.bqB().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
                this.nyC.bg(inflate);
                this.nyC.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.nyC.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.nyC.ov(1);
                this.nyC.ot(R.color.CAM_X0105);
                this.nyC.iW(true);
                this.nyC.b(getPageContext());
                this.nyC.bog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dRY() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dOt().dOu() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet() || !this.eeP) {
            return false;
        }
        if (this.nyi != null) {
            this.nyi.setVisibility(0);
        }
        aPd();
        dRX();
        return true;
    }

    private void aPe() {
        if (!dRY() && this.giK != null && this.nyi != null && this.nym != null) {
            if (this.giK.getParent() == null) {
                dSd();
                dSe();
            }
            if (TbVideoViewSet.dwV().Qh(this.mVideoUrl) == null || TbVideoViewSet.dwV().Qh(this.mVideoUrl) != this.giK) {
                this.giK.setVideoPath(this.mVideoUrl, this.nym.thread_id);
            }
            this.giK.a((TbVideoViewSet.a) null);
            this.nyi.setVisibility(8);
            dwg();
            if (this.nyB != null) {
                this.nyB.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.nyv == null) {
            this.nyv = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.nyv;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0604a
    public void bGy() {
        if (this.giK.isPlaying()) {
            this.giK.pause();
            this.nyi.setVisibility(0);
        } else if (!dRY()) {
            this.giK.start();
            this.nyi.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0604a
    public void y(float f, float f2) {
        if (bh.checkUpIsLogin(getActivity()) && !this.nyw) {
            dRZ();
            if (this.nym != null && "0".equals(this.nym.is_agreed)) {
                LA(this.nxT);
            }
        }
    }

    private void dRZ() {
        if (this.mRootView != null) {
            this.nyw = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.nyy == null) {
                this.nyy = new RelativeLayout.LayoutParams(-2, -2);
                this.nyy.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.nyy);
            }
            if (this.nyx == null) {
                this.nyx = new AnimatorSet();
                this.nyx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.nyw = false;
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
            this.nyx.setTarget(imageView);
            this.nyx.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.nyx.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0604a
    public void bGz() {
        if (this.nym != null && this.nym.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.nym.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dSa() {
        return null;
    }

    public String dSb() {
        return null;
    }

    public boolean dSc() {
        if (this.nyA == null || this.nyA.byN() == null || !this.nyA.byN().isVisible()) {
            return false;
        }
        this.nyA.byN().hide();
        this.nyq.setVisibility(0);
        if ((this.nyA.byN().rI(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.nyA.byN().rI(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.nyA.byN().rI(28)).getInputView().getText() != null) {
            this.nyr.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nyA.byN().rI(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.nyA != null) {
            this.nyA.onActivityResult(i, i2, intent);
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
        if (this.nyA != null && this.nyA.byN() != null) {
            this.nyA.byN().onChangeSkinType(i);
        }
        SvgManager.bqB().a(this.aEA, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dSd() {
        if (this.giK != null && this.giK.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.giK.getView(), 0);
            this.giK.getView().setLayoutParams(layoutParams);
            if (this.nym != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.alZ = this.nym.thread_id;
                oVar.mNid = this.nym.nid;
                oVar.fyg = this.nym.forum_id;
                oVar.mkp = this.nym.mMd5;
                oVar.ezo = "";
                oVar.mSource = this.nym.mRecomSource;
                oVar.mko = this.nym.mRecomAbTag;
                oVar.mkn = 1;
                if (this.nym.baijiahaoData != null) {
                    if (this.nym.baijiahaoData.oriUgcType == 2) {
                        oVar.mkn = 3;
                    } else if (this.nym.baijiahaoData.oriUgcType == 4) {
                        oVar.mkn = 2;
                    }
                }
                oVar.mkl = this.nym.mRecomWeight;
                if (this.mRect != null) {
                    oVar.mkq = "1";
                } else {
                    oVar.mkq = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.mkr = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.mkm = this.mFromPage;
                    oVar.ezo = this.ezo;
                    oVar.mkk = this.nym.mRecomWeight;
                } else {
                    oVar.mLocate = "14";
                }
                this.giK.setVideoStatData(oVar);
                this.giK.setLocateSource("v_mid_page");
            }
            this.giK.setContinuePlayEnable(true);
        }
    }

    private void dSe() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.giK.setOnPreparedListener(this.nyD);
        }
        this.giK.setOnCompletionListener(this.mkX);
        this.giK.setOnInfoListener(this.mkZ);
    }
}
