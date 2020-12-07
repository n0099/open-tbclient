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
/* loaded from: classes24.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0617a {
    public ImageView aHg;
    private e eAQ;
    private String eGn;
    private boolean elQ;
    private boolean gZr;
    public TbCyberVideoView gqT;
    private AlphaAnimation gtW;
    private int iVk;
    private View itO;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private f.b mxr;
    private TbImageView nLV;
    public ImageView nLW;
    public HeadImageView nLX;
    public LinearLayout nLY;
    public LinearLayout nLZ;
    private com.baidu.tieba.videoplay.editor.a nMB;
    private a nMC;
    com.baidu.tbadk.core.dialog.a nMD;
    public LinearLayout nMa;
    public ImageView nMb;
    public ImageView nMc;
    public ImageView nMd;
    public ExpandableTextView nMe;
    public TextView nMf;
    public TextView nMg;
    public TextView nMh;
    public TextView nMi;
    public ImageView nMj;
    private LinearLayout nMk;
    public LinearLayout nMl;
    public LinearLayout nMm;
    public VideoItemData nMn;
    private TextView nMo;
    public ImageView nMp;
    public TextView nMq;
    private View nMr;
    private TextView nMs;
    private int nMt;
    private int nMu;
    private com.baidu.tieba.view.a nMv;
    protected Animation nMw;
    private boolean nMx;
    private AnimatorSet nMy;
    private RelativeLayout.LayoutParams nMz;
    private int nLT = 0;
    private int nLU = 1;
    private ForumManageModel fXb = null;
    private com.baidu.tbadk.baseEditMark.a lHS = null;
    private com.baidu.tbadk.coreExtra.model.a eTC = null;
    private BdUniqueId ajD = BdUniqueId.gen();
    private boolean nMA = false;
    private int playTime = 1;
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.nMn != null && VideoPlayFragment.this.nMn.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nMn.author_info.user_id) && data != null && VideoPlayFragment.this.nMn.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.ajD)) ? false : false;
                    if (data.flk == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.nMn.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.nMn.author_info.is_follow = "0";
                                VideoPlayFragment.this.dXq();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.elQ) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.nMn));
                                } else {
                                    VideoPlayFragment.this.nMn.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dXq();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.nMn.author_info.is_follow = "0";
                            VideoPlayFragment.this.dXq();
                        }
                        ar arVar = new ar("c13570");
                        arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        if ("index".equals(VideoPlayFragment.this.mFromPage)) {
                            arVar.dY("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                            arVar.dY("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
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
                VideoPlayFragment.this.dXs();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.nMn != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.nMn.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.nMn.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.nMn.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.nMn.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dXp();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.nMn.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.nMn.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.nMn.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dXp();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnInfoListener mzd = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.elQ) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.nLV.getVisibility() == 0) {
                    VideoPlayFragment.this.nLV.clearAnimation();
                    VideoPlayFragment.this.nLV.startAnimation(VideoPlayFragment.this.gtW);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener mzb = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.gqT != null) {
                VideoPlayFragment.this.gqT.dCm();
                VideoPlayFragment.this.gqT.seekTo(0);
                VideoPlayFragment.this.gqT.start();
                VideoPlayFragment.this.crO();
                VideoPlayFragment.A(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dXj();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener nME = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.gqT != null) {
                VideoPlayFragment.this.gqT.setVolume(1.0f, 1.0f);
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
        this.nMn = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.nMu = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.eGn = arguments.getString("obj_id");
        if (this.nMn != null && this.nMn.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.nMn.author_info.user_id)) {
            this.gZr = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.gqT = new TbCyberVideoView(getContext());
        this.gqT.setStageType("2005");
        this.gqT.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.f.b
            public void ci(int i, int i2) {
                if (VideoPlayFragment.this.mxr != null) {
                    VideoPlayFragment.this.mxr.ci(i, i2);
                }
            }
        });
        dXx();
        this.nLV = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.nLV.setPlaceHolder(4);
        this.nLV.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.bsY()) {
            this.itO = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.itO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.itO.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aHg = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.nLW = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.nLX = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.nLX.setDefaultResource(17170445);
        this.nLX.setPlaceHolder(2);
        this.nLX.setIsRound(true);
        this.nMb = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.nMp = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.nMe = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.nMf = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.nLZ = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.nMg = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.nLY = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.nMh = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.nMi = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.nMc = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nMd = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dXk();
        this.nMj = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.nMk = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.nMl = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.nMm = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.nMa = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.nMq = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.nMr = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.nMr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.nMr.setVisibility(4);
                    if (VideoPlayFragment.this.nMB != null && VideoPlayFragment.this.nMB.bCn() != null) {
                        VideoPlayFragment.this.nMB.bCn().su();
                        if (VideoPlayFragment.this.nMn != null) {
                            VideoPlayFragment.this.nMB.c(VideoPlayFragment.this.nMn);
                        }
                    }
                    if (VideoPlayFragment.this.nMn != null) {
                        ar arVar = new ar("c13025");
                        arVar.dY("tid", VideoPlayFragment.this.nMn.thread_id);
                        arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        arVar.dY("fid", VideoPlayFragment.this.nMn.forum_id);
                        TiebaStatic.log(arVar);
                    }
                }
            }
        });
        this.nMs = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.nMo = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.nMo.setVisibility(8);
        String string = b.bsO().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.nMo.setText(string);
        }
        final String string2 = b.bsO().getString("nani_key_download_link_url", null);
        this.nMo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    bf.bua().a((TbPageContext) i.J(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dXo();
        this.nLX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nMn != null && VideoPlayFragment.this.nMn.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nMn.author_info.user_id) && VideoPlayFragment.this.nMn != null && VideoPlayFragment.this.nMn.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nMn.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    ar arVar = new ar("c12798");
                    arVar.dY("tid", VideoPlayFragment.this.nMn.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nMl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nMn != null && VideoPlayFragment.this.nMn.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.nMn.act_info.link_url);
                    ar arVar = new ar("c12799");
                    arVar.dY("tid", VideoPlayFragment.this.nMn.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nMe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dXm();
            }
        });
        this.aHg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nMn != null && !StringUtils.isNull(VideoPlayFragment.this.nMn.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.nMn.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.nLW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dXn();
            }
        });
        this.nLZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.nMn)) {
                    VideoPlayFragment.this.dXm();
                    ar arVar = new ar("c12796");
                    arVar.dY("tid", VideoPlayFragment.this.nMn.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nLY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Ms(VideoPlayFragment.this.nLT);
            }
        });
        this.nMa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bvJ();
                ar arVar = new ar("c12797");
                arVar.dY("tid", VideoPlayFragment.this.nMn.thread_id);
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar);
                ar arVar2 = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar2.dY("tid", VideoPlayFragment.this.nMn.thread_id);
                arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar2.al("obj_locate", 19);
                arVar2.dY("nid", VideoPlayFragment.this.nMn.nid);
                if (VideoPlayFragment.this.nMn.baijiahaoData != null && !au.isEmpty(VideoPlayFragment.this.nMn.baijiahaoData.oriUgcVid)) {
                    arVar2.dY("obj_param6", VideoPlayFragment.this.nMn.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.nMn.getVideoType() == 1) {
                    arVar2.al(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.nMn.getVideoType() == 2) {
                    arVar2.al(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.nMn.getVideoType() == 3) {
                    arVar2.al(IntentConfig.CARD_TYPE, 6);
                }
                arVar2.dY(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.nMn.mRecomSource);
                arVar2.dY("ab_tag", VideoPlayFragment.this.nMn.mRecomAbTag);
                arVar2.dY("weight", VideoPlayFragment.this.nMn.mRecomWeight);
                arVar2.dY("extra", VideoPlayFragment.this.nMn.mRecomExtra);
                arVar2.dY("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.eY(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.eY(VideoPlayFragment.this.getBaseFragmentActivity()).bEW() != null && c.eY(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.eY(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    arVar2.dY("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    arVar2.dY("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(arVar2);
            }
        });
        this.nMb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nMn != null && VideoPlayFragment.this.nMn.author_info != null) {
                    VideoPlayFragment.this.eTC.a(true, VideoPlayFragment.this.nMn.author_info.portrait, VideoPlayFragment.this.nMn.author_info.user_id, false, "6", VideoPlayFragment.this.ajD, VideoPlayFragment.this.nMn.forum_id, "0");
                    VideoPlayFragment.this.nMn.author_info.is_follow = "1";
                    VideoPlayFragment.this.dXq();
                }
            }
        });
        this.gtW = new AlphaAnimation(1.0f, 0.0f);
        this.gtW.setDuration(100L);
        this.gtW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.nLV != null) {
                    VideoPlayFragment.this.nLV.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.nMt = this.mRect.right - this.mRect.left;
            this.iVk = this.mRect.bottom - this.mRect.top;
            this.nLV.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.nLV.getWidth();
                    int height = VideoPlayFragment.this.nLV.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nMn.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nMn.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nMn.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nMn.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nMt, VideoPlayFragment.this.iVk);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.nLV.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.iVk > 0 || VideoPlayFragment.this.nMt <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.nMt;
                                f = i / VideoPlayFragment.this.iVk;
                            }
                            VideoPlayFragment.this.nLV.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.nLV.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.elQ) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nMt, VideoPlayFragment.this.iVk);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.nLV.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.iVk > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.nLV.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.nLV.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.elQ) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.nLV.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.nLV.getWidth();
                    int height = VideoPlayFragment.this.nLV.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nMn.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nMn.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nMn.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nMn.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.nLV.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.nLV.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        dci();
        if (this.elQ) {
            dXl();
        }
        if (this.nMn != null && !StringUtils.isNull(this.nMn.video_url)) {
            setVideoInfo(this.nMn.video_url);
        }
        return this.mRootView;
    }

    public void a(f.b bVar) {
        this.mxr = bVar;
    }

    public void a(a aVar) {
        this.nMC = aVar;
    }

    private void dci() {
        this.nMB = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().eN(getActivity());
        if (this.nMB != null && this.nMn != null) {
            this.nMB.a(getPageContext());
            this.nMB.aM(this.nMn.thread_id, this.nMn.forum_id, this.nMn.forum_name);
            this.nMB.a(new a.InterfaceC0887a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0887a
                public void yU(boolean z) {
                    VideoPlayFragment.this.nMr.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.nMs.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.nMs.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.nMB.bCn().sj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.nMn != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nMn.comment_num, 0L) + 1;
                        VideoPlayFragment.this.nMn.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.nMg.setText(au.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.nMB.bCn(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvJ() {
        String str;
        String str2;
        if (this.nMn != null) {
            String str3 = this.nMn.forum_id;
            String str4 = this.nMn.forum_name;
            String str5 = this.nMn.title;
            if (this.nMn.baijiahaoData != null) {
                str = this.nMn.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.nMn.baijiahaoData.oriUgcType + "&dvid=" + this.nMn.baijiahaoData.oriUgcVid + "&nid=" + this.nMn.baijiahaoData.oriUgcNid;
            } else {
                str = this.nMn.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str7 = this.nMn.thumbnail_url;
            String format = (!this.nMn.isBjhVideo || this.nMn.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.nMn.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.nMn.baijiahaoData == null) {
                shareItem.readCount = this.nMn.play_count;
            }
            if (this.nMn.isBjhVideo) {
                shareItem.fnC = format;
            } else {
                shareItem.fnC = "";
            }
            shareItem.linkUrl = str6;
            shareItem.eMJ = 2;
            shareItem.extData = str;
            shareItem.fnF = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.fnr = true;
            shareItem.fnE = 12;
            if (this.nMn.getVideoType() == 1) {
                shareItem.fnJ = 2;
            } else if (this.nMn.getVideoType() == 2) {
                shareItem.fnJ = 8;
            } else if (this.nMn.getVideoType() == 3) {
                shareItem.fnJ = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.nMn.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.nMn.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.nMn.title;
            originalThreadInfo.threadId = this.nMn.thread_id;
            originalThreadInfo.oriUgcInfo = this.nMn.baijiahaoData;
            shareItem.fnM = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fnF);
            bundle.putInt("obj_type", shareItem.fnJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eMJ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.d.f.ctk().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gZr) {
            this.fXb = new ForumManageModel(getPageContext());
            this.fXb.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.fXb.getLoadDataMode()) {
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
        this.lHS = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.lHS != null) {
            this.lHS.a(new a.InterfaceC0583a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0583a
                public void d(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.lHS != null) {
                            VideoPlayFragment.this.lHS.iH(z2);
                        }
                        if (VideoPlayFragment.this.nMn != null) {
                            if (z2) {
                                VideoPlayFragment.this.nMn.mark_id = VideoPlayFragment.this.nMn.post_id;
                            } else {
                                VideoPlayFragment.this.nMn.mark_id = null;
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
        this.eTC = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.eTG);
        registerListener(this.mNetworkChangedMessageListener);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.nMA = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dXo();
        dXy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXj() {
        if (this.nMd != null && this.nMc != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.nMc.clearAnimation();
            this.nMd.clearAnimation();
            this.nMc.setVisibility(8);
            this.nMd.setVisibility(0);
            this.nMd.startAnimation(scaleAnimation2);
            this.nMc.startAnimation(scaleAnimation);
        }
    }

    private void dXk() {
        if (this.nMd != null && this.nMc != null) {
            this.nMc.clearAnimation();
            this.nMd.clearAnimation();
            this.nMc.setVisibility(0);
            this.nMd.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ms(int i) {
        int i2;
        if (bh.checkUpIsLogin(getActivity()) && this.nMn != null) {
            if (i == this.nLT) {
                if ("1".equals(this.nMn.is_agreed)) {
                    i2 = 1;
                    this.nMn.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nMn.agree_num, 0) - 1);
                    this.nMn.is_agreed = "0";
                } else {
                    this.nMn.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nMn.agree_num, 0) + 1);
                    this.nMn.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.nMn.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nMn.agree_num, 0) + 1);
                this.nMn.is_agreed = "1";
                i2 = 0;
            }
            ar arVar = new ar("c12795");
            arVar.dY("tid", this.nMn.thread_id);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nLT) {
                arVar.al("obj_type", i2);
            } else {
                arVar.al("obj_type", 2);
            }
            TiebaStatic.log(arVar);
            ar arVar2 = new ar("c12003");
            arVar2.dY("tid", this.nMn.thread_id);
            arVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nLT) {
                arVar2.al("obj_type", i2);
            } else {
                arVar2.al("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                arVar2.dY("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                arVar2.dY("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            com.baidu.tbadk.pageExtra.c eX = com.baidu.tbadk.pageExtra.d.eX(getContext());
            if (eX != null) {
                arVar2.dY("obj_cur_page", eX.getCurrentPageKey());
            }
            if (com.baidu.tbadk.pageExtra.d.bET() != null) {
                arVar2.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
            }
            TiebaStatic.log(arVar2);
            dXo();
            if (this.nMp != null && i2 == 0) {
                this.nMp.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.nMn.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.nMn.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.nMn.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.nMn.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.nMn.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.nMn.baijiahaoData.oriUgcType);
            }
            if (eX != null) {
                httpMessage.addParam("obj_source", eX.getCurrentPageKey());
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.nMn.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.nMn.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.nMn));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.nMn != null && !StringUtils.isNull(this.nMn.video_url)) {
            this.mHasInit = true;
            if (this.elQ) {
                crO();
                aSj();
                if (this.nMn != null && this.mRect != null) {
                    ar arVar = new ar("c12794");
                    arVar.dY("tid", this.nMn.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.al("obj_type", 0);
                    TiebaStatic.log(arVar);
                    return;
                }
                return;
            }
            aSi();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        aSi();
        if (this.nMB != null && this.nMB.bCn() != null) {
            this.nMB.bCn().hide();
            this.nMr.setVisibility(0);
            this.nMs.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nMB.bCn().sj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.nMB != null) {
            this.nMB.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.elQ = z;
        if (!z && this.nMB != null) {
            this.nMs.setText(R.string.reply_something);
            this.nMB.cGs();
        }
        if (this.mHasInit) {
            if (this.elQ && (!this.nMA || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.nMn != null && this.mRect == null) {
                    ar arVar = new ar("c12794");
                    arVar.dY("tid", this.nMn.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.al("obj_type", 1);
                    TiebaStatic.log(arVar);
                }
                startPlay();
                dXl();
                this.nMA = false;
                return;
            }
            dXk();
            this.playTime = 1;
            aSi();
        }
    }

    private void dXl() {
        if (this.nMn != null) {
            ar arVar = new ar("c12590");
            arVar.dY("tid", this.nMn.thread_id);
            arVar.dY("nid", this.nMn.nid);
            arVar.dY("fid", this.nMn.forum_id);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.al("obj_locate", this.nMu);
            arVar.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
            arVar.dY("obj_param1", au.isEmpty(this.nMn.mRecomWeight) ? "0" : this.nMn.mRecomWeight);
            arVar.dY("extra", au.isEmpty(this.nMn.mRecomExtra) ? "0" : this.nMn.mRecomExtra);
            arVar.dY("obj_id", this.eGn);
            arVar.dY("ab_tag", au.isEmpty(this.nMn.mRecomAbTag) ? "0" : this.nMn.mRecomAbTag);
            arVar.dY("obj_source", au.isEmpty(this.nMn.mRecomSource) ? "0" : this.nMn.mRecomSource);
            arVar.dY("obj_type", this.mFromPage);
            arVar.al("is_vertical", 1);
            if (this.nMn.baijiahaoData != null) {
                arVar.dY("obj_param4", this.nMn.baijiahaoData.oriUgcNid);
                arVar.dY("obj_param6", this.nMn.baijiahaoData.oriUgcVid);
                if (this.nMn.baijiahaoData.oriUgcType == 4) {
                    arVar.al("obj_param5", 2);
                } else if (this.nMn.baijiahaoData.oriUgcType == 2) {
                    arVar.al("obj_param5", 3);
                }
            } else {
                arVar.al("obj_param5", 1);
            }
            TiebaStatic.log(arVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.gqT != null && str != null && !str.equals(this.mVideoUrl)) {
            this.gqT.setVideoPath(str, this.nMn.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dXs()) {
            dBy();
            if (this.nMj != null) {
                this.nMj.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.nLV.getVisibility() == 0) {
                this.nLV.clearAnimation();
                this.nLV.startAnimation(this.gtW);
            }
            if (this.gqT != null) {
                if (TbVideoViewSet.dCn().Rq(this.mVideoUrl) == null || TbVideoViewSet.dCn().Rq(this.mVideoUrl) != this.gqT) {
                    this.gqT.setVideoPath(this.mVideoUrl, this.nMn.thread_id);
                }
                this.gqT.start();
                crO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crO() {
        if (this.nMn != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.amY = this.nMn.thread_id;
            oVar.mNid = this.nMn.nid;
            oVar.fFV = this.nMn.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.nMn.mRecomSource;
            oVar.myo = this.nMn.mRecomAbTag;
            oVar.myp = this.nMn.mRecomWeight;
            oVar.myq = "";
            oVar.eGn = "";
            oVar.myt = this.nMn.mMd5;
            if (this.mRect != null) {
                oVar.myu = "1";
            } else {
                oVar.myu = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.myv = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.myq = "index";
            }
            h.a(this.nMn.mMd5, "", "1", oVar, this.gqT.getPcdnState());
        }
    }

    private void dBy() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dTL().gG(getContext());
        }
    }

    private void aSi() {
        if (this.gqT != null) {
            this.gqT.pause();
        }
    }

    private void stopPlay() {
        if (this.gqT != null) {
            this.gqT.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXm() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.nMn.thread_id, this.nMn.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.nMn.forum_id));
        createNormalCfg.setForumName(this.nMn.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.nMn.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXn() {
        if (this.eAQ == null) {
            this.nMv = new com.baidu.tieba.view.a(getActivity());
            this.eAQ = new e(getActivity(), this.nMv.brP());
            this.eAQ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.gqT.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.nMv != null) {
            ArrayList arrayList = new ArrayList();
            a.C0889a c0889a = new a.C0889a(this.nMv);
            c0889a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bh.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.eAQ.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.eAQ.dismiss();
                    if (VideoPlayFragment.this.nMn != null) {
                        boolean z = VideoPlayFragment.this.nMn.post_id != null && VideoPlayFragment.this.nMn.post_id.equals(VideoPlayFragment.this.nMn.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.nMn.thread_id);
                        markData.setPostId(VideoPlayFragment.this.nMn.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.nMn.thread_id);
                        markData.setForumId(VideoPlayFragment.this.nMn.forum_id);
                        if (VideoPlayFragment.this.lHS != null) {
                            VideoPlayFragment.this.lHS.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.lHS.bla();
                            } else {
                                VideoPlayFragment.this.lHS.bkZ();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.nMn != null && this.nMn.post_id != null && this.nMn.post_id.equals(this.nMn.mark_id)) {
                z = true;
            }
            if (z) {
                c0889a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0889a.setText(getResources().getString(R.string.mark));
            }
            if (this.nMn != null && !this.nMn.isBjhVideo) {
                arrayList.add(c0889a);
            }
            a.C0889a c0889a2 = new a.C0889a(getActivity().getString(R.string.delete), this.nMv);
            c0889a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.eAQ.dismiss();
                    if (bh.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nMn != null) {
                        String str = VideoPlayFragment.this.nMn.thread_id;
                        String str2 = VideoPlayFragment.this.nMn.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.nMn.post_id;
                        if (VideoPlayFragment.this.nMn.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.nMn.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.nMn.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0889a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0889a2);
            if (this.gZr) {
                a.C0889a c0889a3 = new a.C0889a(getActivity().getString(R.string.delete), this.nMv);
                c0889a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.eAQ.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.oQ(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.nMn != null) {
                                    VideoPlayFragment.this.fXb.a(VideoPlayFragment.this.nMn.forum_id, VideoPlayFragment.this.nMn.forum_name, VideoPlayFragment.this.nMn.thread_id, VideoPlayFragment.this.nMn.post_id, 0, 0, VideoPlayFragment.this.gZr, null);
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
                        aVar.jl(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.brv();
                    }
                });
                c0889a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0889a3);
            }
            this.nMv.bu(arrayList);
        }
        this.eAQ.show();
    }

    private void dXo() {
        if (this.nMn != null) {
            this.nLV.startLoad(this.nMn.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.nMn.title);
            if (StringUtils.isNull(this.nMn.title) || matcher.matches()) {
                this.nMe.setVisibility(8);
            } else {
                this.nMe.setVisibility(0);
                this.nMe.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.nMe.setTextColor(R.color.CAM_X0101);
                this.nMe.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.nMe.setExpandable(true);
                this.nMe.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void re(boolean z) {
                        VideoPlayFragment.this.nMn.isTitleExpanded = z;
                    }
                });
                this.nMe.setData(this.nMn.title, this.nMn.isTitleExpanded);
            }
            this.nMg.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nMn.comment_num, 0L)));
            this.nMh.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nMn.agree_num, 0L)));
            this.nMi.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nMn.share_num, 0L)));
            if (this.nMn.author_info != null) {
                if (!TextUtils.isEmpty(this.nMn.author_info.bjhAvatar)) {
                    this.nLX.startLoad(this.nMn.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.nMn.author_info.portrait) && this.nMn.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.nLX.startLoad(this.nMn.author_info.portrait, 10, false);
                } else {
                    this.nLX.startLoad(this.nMn.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.nMn.author_info.dTG())) {
                    this.nMq.setVisibility(8);
                } else {
                    this.nMq.setVisibility(0);
                    this.nMq.setText(UgcConstant.AT_RULE_TAG + this.nMn.author_info.dTG());
                }
            }
            if ("1".equals(this.nMn.is_private) && this.nMo.getVisibility() != 0) {
                this.nMm.setVisibility(0);
            } else {
                this.nMm.setVisibility(8);
            }
            if ("1".equals(this.nMn.is_agreed)) {
                ap.setImageResource(this.nMp, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.nMp, R.drawable.btn_video_agree);
            }
            if (this.nMn.act_info != null && !StringUtils.isNull(this.nMn.act_info.activity_name) && this.nMo.getVisibility() != 0) {
                this.nMl.setVisibility(0);
                this.nMf.setText(this.nMn.act_info.activity_name);
            } else {
                this.nMl.setVisibility(8);
            }
            dXq();
            if (this.nMn.isBjhVideo) {
                this.nLW.setVisibility(8);
            } else {
                this.nLW.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXp() {
        if (this.nMn != null) {
            if ("1".equals(this.nMn.is_agreed)) {
                ap.setImageResource(this.nMp, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.nMp, R.drawable.btn_video_agree);
            }
            this.nMh.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nMn.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXq() {
        if (this.gZr || (this.nMn.author_info != null && "1".equals(this.nMn.author_info.is_follow))) {
            this.nMb.setVisibility(4);
            this.nMb.setClickable(false);
            return;
        }
        this.nMb.setVisibility(0);
        this.nMb.setClickable(true);
    }

    private void dXr() {
        if (getActivity() != null) {
            if (this.nMD == null || !this.nMD.isShowing()) {
                this.nMD = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.btW().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
                this.nMD.bi(inflate);
                this.nMD.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.nMD.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.nMD.oT(1);
                this.nMD.oR(R.color.CAM_X0105);
                this.nMD.jl(true);
                this.nMD.b(getPageContext());
                this.nMD.brv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dXs() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dTL().dTM() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet() || !this.elQ) {
            return false;
        }
        if (this.nMj != null) {
            this.nMj.setVisibility(0);
        }
        aSi();
        dXr();
        return true;
    }

    private void aSj() {
        if (!dXs() && this.gqT != null && this.nMj != null && this.nMn != null) {
            if (this.gqT.getParent() == null) {
                dXx();
                dXy();
            }
            if (TbVideoViewSet.dCn().Rq(this.mVideoUrl) == null || TbVideoViewSet.dCn().Rq(this.mVideoUrl) != this.gqT) {
                this.gqT.setVideoPath(this.mVideoUrl, this.nMn.thread_id);
            }
            this.gqT.a((TbVideoViewSet.a) null);
            this.nMj.setVisibility(8);
            dBy();
            if (this.nMC != null) {
                this.nMC.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.nMw == null) {
            this.nMw = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.nMw;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0617a
    public void bJY() {
        if (this.gqT.isPlaying()) {
            this.gqT.pause();
            this.nMj.setVisibility(0);
        } else if (!dXs()) {
            this.gqT.start();
            this.nMj.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0617a
    public void y(float f, float f2) {
        if (bh.checkUpIsLogin(getActivity()) && !this.nMx) {
            dXt();
            if (this.nMn != null && "0".equals(this.nMn.is_agreed)) {
                Ms(this.nLU);
            }
        }
    }

    private void dXt() {
        if (this.mRootView != null) {
            this.nMx = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.nMz == null) {
                this.nMz = new RelativeLayout.LayoutParams(-2, -2);
                this.nMz.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.nMz);
            }
            if (this.nMy == null) {
                this.nMy = new AnimatorSet();
                this.nMy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.nMx = false;
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
            this.nMy.setTarget(imageView);
            this.nMy.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.nMy.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0617a
    public void bJZ() {
        if (this.nMn != null && this.nMn.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.nMn.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dXu() {
        return null;
    }

    public String dXv() {
        return null;
    }

    public boolean dXw() {
        if (this.nMB == null || this.nMB.bCn() == null || !this.nMB.bCn().isVisible()) {
            return false;
        }
        this.nMB.bCn().hide();
        this.nMr.setVisibility(0);
        if ((this.nMB.bCn().sj(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.nMB.bCn().sj(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.nMB.bCn().sj(28)).getInputView().getText() != null) {
            this.nMs.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nMB.bCn().sj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.nMB != null) {
            this.nMB.onActivityResult(i, i2, intent);
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
        if (this.nMB != null && this.nMB.bCn() != null) {
            this.nMB.bCn().onChangeSkinType(i);
        }
        SvgManager.btW().a(this.aHg, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dXx() {
        if (this.gqT != null && this.gqT.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.gqT.getView(), 0);
            this.gqT.getView().setLayoutParams(layoutParams);
            if (this.nMn != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.amY = this.nMn.thread_id;
                oVar.mNid = this.nMn.nid;
                oVar.fFV = this.nMn.forum_id;
                oVar.myt = this.nMn.mMd5;
                oVar.eGn = "";
                oVar.mSource = this.nMn.mRecomSource;
                oVar.mys = this.nMn.mRecomAbTag;
                oVar.myr = 1;
                if (this.nMn.baijiahaoData != null) {
                    if (this.nMn.baijiahaoData.oriUgcType == 2) {
                        oVar.myr = 3;
                    } else if (this.nMn.baijiahaoData.oriUgcType == 4) {
                        oVar.myr = 2;
                    }
                }
                oVar.myp = this.nMn.mRecomWeight;
                if (this.mRect != null) {
                    oVar.myu = "1";
                } else {
                    oVar.myu = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.myv = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.myq = this.mFromPage;
                    oVar.eGn = this.eGn;
                    oVar.myo = this.nMn.mRecomWeight;
                } else {
                    oVar.mLocate = "14";
                }
                this.gqT.setVideoStatData(oVar);
                this.gqT.setLocateSource("v_mid_page");
            }
            this.gqT.setContinuePlayEnable(true);
        }
    }

    private void dXy() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.gqT.setOnPreparedListener(this.nME);
        }
        this.gqT.setOnCompletionListener(this.mzb);
        this.gqT.setOnInfoListener(this.mzd);
    }
}
