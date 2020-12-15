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
    private boolean gZt;
    public TbCyberVideoView gqV;
    private AlphaAnimation gtY;
    private int iVm;
    private View itQ;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private f.b mxt;
    private TbImageView nLX;
    public ImageView nLY;
    public HeadImageView nLZ;
    private AnimatorSet nMA;
    private RelativeLayout.LayoutParams nMB;
    private com.baidu.tieba.videoplay.editor.a nMD;
    private a nME;
    com.baidu.tbadk.core.dialog.a nMF;
    public LinearLayout nMa;
    public LinearLayout nMb;
    public LinearLayout nMc;
    public ImageView nMd;
    public ImageView nMe;
    public ImageView nMf;
    public ExpandableTextView nMg;
    public TextView nMh;
    public TextView nMi;
    public TextView nMj;
    public TextView nMk;
    public ImageView nMl;
    private LinearLayout nMm;
    public LinearLayout nMn;
    public LinearLayout nMo;
    public VideoItemData nMp;
    private TextView nMq;
    public ImageView nMr;
    public TextView nMs;
    private View nMt;
    private TextView nMu;
    private int nMv;
    private int nMw;
    private com.baidu.tieba.view.a nMx;
    protected Animation nMy;
    private boolean nMz;
    private int nLV = 0;
    private int nLW = 1;
    private ForumManageModel fXd = null;
    private com.baidu.tbadk.baseEditMark.a lHU = null;
    private com.baidu.tbadk.coreExtra.model.a eTC = null;
    private BdUniqueId ajD = BdUniqueId.gen();
    private boolean nMC = false;
    private int playTime = 1;
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.nMp != null && VideoPlayFragment.this.nMp.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nMp.author_info.user_id) && data != null && VideoPlayFragment.this.nMp.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.ajD)) ? false : false;
                    if (data.flk == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.nMp.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.nMp.author_info.is_follow = "0";
                                VideoPlayFragment.this.dXr();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.elQ) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.nMp));
                                } else {
                                    VideoPlayFragment.this.nMp.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dXr();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.nMp.author_info.is_follow = "0";
                            VideoPlayFragment.this.dXr();
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
                VideoPlayFragment.this.dXt();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.nMp != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.nMp.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.nMp.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.nMp.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.nMp.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dXq();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.nMp.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.nMp.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.nMp.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dXq();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnInfoListener mzf = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.elQ) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.nLX.getVisibility() == 0) {
                    VideoPlayFragment.this.nLX.clearAnimation();
                    VideoPlayFragment.this.nLX.startAnimation(VideoPlayFragment.this.gtY);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener mzd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.gqV != null) {
                VideoPlayFragment.this.gqV.dCn();
                VideoPlayFragment.this.gqV.seekTo(0);
                VideoPlayFragment.this.gqV.start();
                VideoPlayFragment.this.crP();
                VideoPlayFragment.A(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dXk();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener nMG = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.gqV != null) {
                VideoPlayFragment.this.gqV.setVolume(1.0f, 1.0f);
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
        this.nMp = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.nMw = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.eGn = arguments.getString("obj_id");
        if (this.nMp != null && this.nMp.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.nMp.author_info.user_id)) {
            this.gZt = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.gqV = new TbCyberVideoView(getContext());
        this.gqV.setStageType("2005");
        this.gqV.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.f.b
            public void ci(int i, int i2) {
                if (VideoPlayFragment.this.mxt != null) {
                    VideoPlayFragment.this.mxt.ci(i, i2);
                }
            }
        });
        dXy();
        this.nLX = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.nLX.setPlaceHolder(4);
        this.nLX.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.bsY()) {
            this.itQ = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.itQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.itQ.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aHg = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.nLY = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.nLZ = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.nLZ.setDefaultResource(17170445);
        this.nLZ.setPlaceHolder(2);
        this.nLZ.setIsRound(true);
        this.nMd = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.nMr = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.nMg = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.nMh = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.nMb = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.nMi = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.nMa = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.nMj = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.nMk = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.nMe = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nMf = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dXl();
        this.nMl = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.nMm = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.nMn = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.nMo = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.nMc = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.nMs = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.nMt = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.nMt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.nMt.setVisibility(4);
                    if (VideoPlayFragment.this.nMD != null && VideoPlayFragment.this.nMD.bCn() != null) {
                        VideoPlayFragment.this.nMD.bCn().su();
                        if (VideoPlayFragment.this.nMp != null) {
                            VideoPlayFragment.this.nMD.c(VideoPlayFragment.this.nMp);
                        }
                    }
                    if (VideoPlayFragment.this.nMp != null) {
                        ar arVar = new ar("c13025");
                        arVar.dY("tid", VideoPlayFragment.this.nMp.thread_id);
                        arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        arVar.dY("fid", VideoPlayFragment.this.nMp.forum_id);
                        TiebaStatic.log(arVar);
                    }
                }
            }
        });
        this.nMu = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.nMq = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.nMq.setVisibility(8);
        String string = b.bsO().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.nMq.setText(string);
        }
        final String string2 = b.bsO().getString("nani_key_download_link_url", null);
        this.nMq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    bf.bua().a((TbPageContext) i.J(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dXp();
        this.nLZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nMp != null && VideoPlayFragment.this.nMp.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.nMp.author_info.user_id) && VideoPlayFragment.this.nMp != null && VideoPlayFragment.this.nMp.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nMp.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    ar arVar = new ar("c12798");
                    arVar.dY("tid", VideoPlayFragment.this.nMp.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nMn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nMp != null && VideoPlayFragment.this.nMp.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.nMp.act_info.link_url);
                    ar arVar = new ar("c12799");
                    arVar.dY("tid", VideoPlayFragment.this.nMp.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nMg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dXn();
            }
        });
        this.aHg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.nMp != null && !StringUtils.isNull(VideoPlayFragment.this.nMp.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.nMp.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.nLY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dXo();
            }
        });
        this.nMb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.nMp)) {
                    VideoPlayFragment.this.dXn();
                    ar arVar = new ar("c12796");
                    arVar.dY("tid", VideoPlayFragment.this.nMp.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        this.nMa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Ms(VideoPlayFragment.this.nLV);
            }
        });
        this.nMc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.bvJ();
                ar arVar = new ar("c12797");
                arVar.dY("tid", VideoPlayFragment.this.nMp.thread_id);
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar);
                ar arVar2 = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar2.dY("tid", VideoPlayFragment.this.nMp.thread_id);
                arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar2.al("obj_locate", 19);
                arVar2.dY("nid", VideoPlayFragment.this.nMp.nid);
                if (VideoPlayFragment.this.nMp.baijiahaoData != null && !au.isEmpty(VideoPlayFragment.this.nMp.baijiahaoData.oriUgcVid)) {
                    arVar2.dY("obj_param6", VideoPlayFragment.this.nMp.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.nMp.getVideoType() == 1) {
                    arVar2.al(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.nMp.getVideoType() == 2) {
                    arVar2.al(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.nMp.getVideoType() == 3) {
                    arVar2.al(IntentConfig.CARD_TYPE, 6);
                }
                arVar2.dY(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.nMp.mRecomSource);
                arVar2.dY("ab_tag", VideoPlayFragment.this.nMp.mRecomAbTag);
                arVar2.dY("weight", VideoPlayFragment.this.nMp.mRecomWeight);
                arVar2.dY("extra", VideoPlayFragment.this.nMp.mRecomExtra);
                arVar2.dY("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.eY(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.eY(VideoPlayFragment.this.getBaseFragmentActivity()).bEW() != null && c.eY(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.eY(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    arVar2.dY("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    arVar2.dY("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(arVar2);
            }
        });
        this.nMd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nMp != null && VideoPlayFragment.this.nMp.author_info != null) {
                    VideoPlayFragment.this.eTC.a(true, VideoPlayFragment.this.nMp.author_info.portrait, VideoPlayFragment.this.nMp.author_info.user_id, false, "6", VideoPlayFragment.this.ajD, VideoPlayFragment.this.nMp.forum_id, "0");
                    VideoPlayFragment.this.nMp.author_info.is_follow = "1";
                    VideoPlayFragment.this.dXr();
                }
            }
        });
        this.gtY = new AlphaAnimation(1.0f, 0.0f);
        this.gtY.setDuration(100L);
        this.gtY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.nLX != null) {
                    VideoPlayFragment.this.nLX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.nMv = this.mRect.right - this.mRect.left;
            this.iVm = this.mRect.bottom - this.mRect.top;
            this.nLX.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.nLX.getWidth();
                    int height = VideoPlayFragment.this.nLX.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nMp.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nMp.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nMp.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nMp.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nMv, VideoPlayFragment.this.iVm);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.nLX.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.iVm > 0 || VideoPlayFragment.this.nMv <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.nMv;
                                f = i / VideoPlayFragment.this.iVm;
                            }
                            VideoPlayFragment.this.nLX.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.nLX.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
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
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.nMv, VideoPlayFragment.this.iVm);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.nLX.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.iVm > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.nLX.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.nLX.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
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
            this.nLX.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.nLX.getWidth();
                    int height = VideoPlayFragment.this.nLX.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nMp.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.nMp.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nMp.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.nMp.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.nLX.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.nLX.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        dcj();
        if (this.elQ) {
            dXm();
        }
        if (this.nMp != null && !StringUtils.isNull(this.nMp.video_url)) {
            setVideoInfo(this.nMp.video_url);
        }
        return this.mRootView;
    }

    public void a(f.b bVar) {
        this.mxt = bVar;
    }

    public void a(a aVar) {
        this.nME = aVar;
    }

    private void dcj() {
        this.nMD = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().eN(getActivity());
        if (this.nMD != null && this.nMp != null) {
            this.nMD.a(getPageContext());
            this.nMD.aM(this.nMp.thread_id, this.nMp.forum_id, this.nMp.forum_name);
            this.nMD.a(new a.InterfaceC0887a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0887a
                public void yU(boolean z) {
                    VideoPlayFragment.this.nMt.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.nMu.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.nMu.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.nMD.bCn().sj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.nMp != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.nMp.comment_num, 0L) + 1;
                        VideoPlayFragment.this.nMp.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.nMi.setText(au.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.nMD.bCn(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvJ() {
        String str;
        String str2;
        if (this.nMp != null) {
            String str3 = this.nMp.forum_id;
            String str4 = this.nMp.forum_name;
            String str5 = this.nMp.title;
            if (this.nMp.baijiahaoData != null) {
                str = this.nMp.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.nMp.baijiahaoData.oriUgcType + "&dvid=" + this.nMp.baijiahaoData.oriUgcVid + "&nid=" + this.nMp.baijiahaoData.oriUgcNid;
            } else {
                str = this.nMp.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str7 = this.nMp.thumbnail_url;
            String format = (!this.nMp.isBjhVideo || this.nMp.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.nMp.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.nMp.baijiahaoData == null) {
                shareItem.readCount = this.nMp.play_count;
            }
            if (this.nMp.isBjhVideo) {
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
            if (this.nMp.getVideoType() == 1) {
                shareItem.fnJ = 2;
            } else if (this.nMp.getVideoType() == 2) {
                shareItem.fnJ = 8;
            } else if (this.nMp.getVideoType() == 3) {
                shareItem.fnJ = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.nMp.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.nMp.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.nMp.title;
            originalThreadInfo.threadId = this.nMp.thread_id;
            originalThreadInfo.oriUgcInfo = this.nMp.baijiahaoData;
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
            com.baidu.tieba.d.f.ctl().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gZt) {
            this.fXd = new ForumManageModel(getPageContext());
            this.fXd.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.fXd.getLoadDataMode()) {
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
        this.lHU = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.lHU != null) {
            this.lHU.a(new a.InterfaceC0583a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0583a
                public void d(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.lHU != null) {
                            VideoPlayFragment.this.lHU.iH(z2);
                        }
                        if (VideoPlayFragment.this.nMp != null) {
                            if (z2) {
                                VideoPlayFragment.this.nMp.mark_id = VideoPlayFragment.this.nMp.post_id;
                            } else {
                                VideoPlayFragment.this.nMp.mark_id = null;
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
            this.nMC = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dXp();
        dXz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXk() {
        if (this.nMf != null && this.nMe != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.nMe.clearAnimation();
            this.nMf.clearAnimation();
            this.nMe.setVisibility(8);
            this.nMf.setVisibility(0);
            this.nMf.startAnimation(scaleAnimation2);
            this.nMe.startAnimation(scaleAnimation);
        }
    }

    private void dXl() {
        if (this.nMf != null && this.nMe != null) {
            this.nMe.clearAnimation();
            this.nMf.clearAnimation();
            this.nMe.setVisibility(0);
            this.nMf.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ms(int i) {
        int i2;
        if (bh.checkUpIsLogin(getActivity()) && this.nMp != null) {
            if (i == this.nLV) {
                if ("1".equals(this.nMp.is_agreed)) {
                    i2 = 1;
                    this.nMp.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nMp.agree_num, 0) - 1);
                    this.nMp.is_agreed = "0";
                } else {
                    this.nMp.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nMp.agree_num, 0) + 1);
                    this.nMp.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.nMp.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.nMp.agree_num, 0) + 1);
                this.nMp.is_agreed = "1";
                i2 = 0;
            }
            ar arVar = new ar("c12795");
            arVar.dY("tid", this.nMp.thread_id);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nLV) {
                arVar.al("obj_type", i2);
            } else {
                arVar.al("obj_type", 2);
            }
            TiebaStatic.log(arVar);
            ar arVar2 = new ar("c12003");
            arVar2.dY("tid", this.nMp.thread_id);
            arVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.nLV) {
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
            dXp();
            if (this.nMr != null && i2 == 0) {
                this.nMr.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.nMp.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.nMp.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.nMp.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.nMp.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.nMp.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.nMp.baijiahaoData.oriUgcType);
            }
            if (eX != null) {
                httpMessage.addParam("obj_source", eX.getCurrentPageKey());
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.nMp.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.nMp.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.nMp));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.nMp != null && !StringUtils.isNull(this.nMp.video_url)) {
            this.mHasInit = true;
            if (this.elQ) {
                crP();
                aSj();
                if (this.nMp != null && this.mRect != null) {
                    ar arVar = new ar("c12794");
                    arVar.dY("tid", this.nMp.thread_id);
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
        if (this.nMD != null && this.nMD.bCn() != null) {
            this.nMD.bCn().hide();
            this.nMt.setVisibility(0);
            this.nMu.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nMD.bCn().sj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.nMD != null) {
            this.nMD.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.elQ = z;
        if (!z && this.nMD != null) {
            this.nMu.setText(R.string.reply_something);
            this.nMD.cGt();
        }
        if (this.mHasInit) {
            if (this.elQ && (!this.nMC || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.nMp != null && this.mRect == null) {
                    ar arVar = new ar("c12794");
                    arVar.dY("tid", this.nMp.thread_id);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.al("obj_type", 1);
                    TiebaStatic.log(arVar);
                }
                startPlay();
                dXm();
                this.nMC = false;
                return;
            }
            dXl();
            this.playTime = 1;
            aSi();
        }
    }

    private void dXm() {
        if (this.nMp != null) {
            ar arVar = new ar("c12590");
            arVar.dY("tid", this.nMp.thread_id);
            arVar.dY("nid", this.nMp.nid);
            arVar.dY("fid", this.nMp.forum_id);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.al("obj_locate", this.nMw);
            arVar.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
            arVar.dY("obj_param1", au.isEmpty(this.nMp.mRecomWeight) ? "0" : this.nMp.mRecomWeight);
            arVar.dY("extra", au.isEmpty(this.nMp.mRecomExtra) ? "0" : this.nMp.mRecomExtra);
            arVar.dY("obj_id", this.eGn);
            arVar.dY("ab_tag", au.isEmpty(this.nMp.mRecomAbTag) ? "0" : this.nMp.mRecomAbTag);
            arVar.dY("obj_source", au.isEmpty(this.nMp.mRecomSource) ? "0" : this.nMp.mRecomSource);
            arVar.dY("obj_type", this.mFromPage);
            arVar.al("is_vertical", 1);
            if (this.nMp.baijiahaoData != null) {
                arVar.dY("obj_param4", this.nMp.baijiahaoData.oriUgcNid);
                arVar.dY("obj_param6", this.nMp.baijiahaoData.oriUgcVid);
                if (this.nMp.baijiahaoData.oriUgcType == 4) {
                    arVar.al("obj_param5", 2);
                } else if (this.nMp.baijiahaoData.oriUgcType == 2) {
                    arVar.al("obj_param5", 3);
                }
            } else {
                arVar.al("obj_param5", 1);
            }
            TiebaStatic.log(arVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.gqV != null && str != null && !str.equals(this.mVideoUrl)) {
            this.gqV.setVideoPath(str, this.nMp.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dXt()) {
            dBz();
            if (this.nMl != null) {
                this.nMl.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.nLX.getVisibility() == 0) {
                this.nLX.clearAnimation();
                this.nLX.startAnimation(this.gtY);
            }
            if (this.gqV != null) {
                if (TbVideoViewSet.dCo().Rq(this.mVideoUrl) == null || TbVideoViewSet.dCo().Rq(this.mVideoUrl) != this.gqV) {
                    this.gqV.setVideoPath(this.mVideoUrl, this.nMp.thread_id);
                }
                this.gqV.start();
                crP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crP() {
        if (this.nMp != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.amY = this.nMp.thread_id;
            oVar.mNid = this.nMp.nid;
            oVar.fFV = this.nMp.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.nMp.mRecomSource;
            oVar.myq = this.nMp.mRecomAbTag;
            oVar.myr = this.nMp.mRecomWeight;
            oVar.mys = "";
            oVar.eGn = "";
            oVar.myv = this.nMp.mMd5;
            if (this.mRect != null) {
                oVar.myw = "1";
            } else {
                oVar.myw = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.myx = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.mys = "index";
            }
            h.a(this.nMp.mMd5, "", "1", oVar, this.gqV.getPcdnState());
        }
    }

    private void dBz() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dTM().gG(getContext());
        }
    }

    private void aSi() {
        if (this.gqV != null) {
            this.gqV.pause();
        }
    }

    private void stopPlay() {
        if (this.gqV != null) {
            this.gqV.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXn() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.nMp.thread_id, this.nMp.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.nMp.forum_id));
        createNormalCfg.setForumName(this.nMp.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.nMp.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXo() {
        if (this.eAQ == null) {
            this.nMx = new com.baidu.tieba.view.a(getActivity());
            this.eAQ = new e(getActivity(), this.nMx.brP());
            this.eAQ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.gqV.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.nMx != null) {
            ArrayList arrayList = new ArrayList();
            a.C0889a c0889a = new a.C0889a(this.nMx);
            c0889a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bh.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.eAQ.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.eAQ.dismiss();
                    if (VideoPlayFragment.this.nMp != null) {
                        boolean z = VideoPlayFragment.this.nMp.post_id != null && VideoPlayFragment.this.nMp.post_id.equals(VideoPlayFragment.this.nMp.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.nMp.thread_id);
                        markData.setPostId(VideoPlayFragment.this.nMp.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.nMp.thread_id);
                        markData.setForumId(VideoPlayFragment.this.nMp.forum_id);
                        if (VideoPlayFragment.this.lHU != null) {
                            VideoPlayFragment.this.lHU.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.lHU.bla();
                            } else {
                                VideoPlayFragment.this.lHU.bkZ();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.nMp != null && this.nMp.post_id != null && this.nMp.post_id.equals(this.nMp.mark_id)) {
                z = true;
            }
            if (z) {
                c0889a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0889a.setText(getResources().getString(R.string.mark));
            }
            if (this.nMp != null && !this.nMp.isBjhVideo) {
                arrayList.add(c0889a);
            }
            a.C0889a c0889a2 = new a.C0889a(getActivity().getString(R.string.delete), this.nMx);
            c0889a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.eAQ.dismiss();
                    if (bh.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.nMp != null) {
                        String str = VideoPlayFragment.this.nMp.thread_id;
                        String str2 = VideoPlayFragment.this.nMp.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.nMp.post_id;
                        if (VideoPlayFragment.this.nMp.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.nMp.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.nMp.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0889a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0889a2);
            if (this.gZt) {
                a.C0889a c0889a3 = new a.C0889a(getActivity().getString(R.string.delete), this.nMx);
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
                                if (VideoPlayFragment.this.nMp != null) {
                                    VideoPlayFragment.this.fXd.a(VideoPlayFragment.this.nMp.forum_id, VideoPlayFragment.this.nMp.forum_name, VideoPlayFragment.this.nMp.thread_id, VideoPlayFragment.this.nMp.post_id, 0, 0, VideoPlayFragment.this.gZt, null);
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
            this.nMx.bu(arrayList);
        }
        this.eAQ.show();
    }

    private void dXp() {
        if (this.nMp != null) {
            this.nLX.startLoad(this.nMp.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.nMp.title);
            if (StringUtils.isNull(this.nMp.title) || matcher.matches()) {
                this.nMg.setVisibility(8);
            } else {
                this.nMg.setVisibility(0);
                this.nMg.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.nMg.setTextColor(R.color.CAM_X0101);
                this.nMg.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.nMg.setExpandable(true);
                this.nMg.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void re(boolean z) {
                        VideoPlayFragment.this.nMp.isTitleExpanded = z;
                    }
                });
                this.nMg.setData(this.nMp.title, this.nMp.isTitleExpanded);
            }
            this.nMi.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nMp.comment_num, 0L)));
            this.nMj.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nMp.agree_num, 0L)));
            this.nMk.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nMp.share_num, 0L)));
            if (this.nMp.author_info != null) {
                if (!TextUtils.isEmpty(this.nMp.author_info.bjhAvatar)) {
                    this.nLZ.startLoad(this.nMp.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.nMp.author_info.portrait) && this.nMp.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.nLZ.startLoad(this.nMp.author_info.portrait, 10, false);
                } else {
                    this.nLZ.startLoad(this.nMp.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.nMp.author_info.dTH())) {
                    this.nMs.setVisibility(8);
                } else {
                    this.nMs.setVisibility(0);
                    this.nMs.setText(UgcConstant.AT_RULE_TAG + this.nMp.author_info.dTH());
                }
            }
            if ("1".equals(this.nMp.is_private) && this.nMq.getVisibility() != 0) {
                this.nMo.setVisibility(0);
            } else {
                this.nMo.setVisibility(8);
            }
            if ("1".equals(this.nMp.is_agreed)) {
                ap.setImageResource(this.nMr, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.nMr, R.drawable.btn_video_agree);
            }
            if (this.nMp.act_info != null && !StringUtils.isNull(this.nMp.act_info.activity_name) && this.nMq.getVisibility() != 0) {
                this.nMn.setVisibility(0);
                this.nMh.setText(this.nMp.act_info.activity_name);
            } else {
                this.nMn.setVisibility(8);
            }
            dXr();
            if (this.nMp.isBjhVideo) {
                this.nLY.setVisibility(8);
            } else {
                this.nLY.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXq() {
        if (this.nMp != null) {
            if ("1".equals(this.nMp.is_agreed)) {
                ap.setImageResource(this.nMr, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.nMr, R.drawable.btn_video_agree);
            }
            this.nMj.setText(au.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.nMp.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXr() {
        if (this.gZt || (this.nMp.author_info != null && "1".equals(this.nMp.author_info.is_follow))) {
            this.nMd.setVisibility(4);
            this.nMd.setClickable(false);
            return;
        }
        this.nMd.setVisibility(0);
        this.nMd.setClickable(true);
    }

    private void dXs() {
        if (getActivity() != null) {
            if (this.nMF == null || !this.nMF.isShowing()) {
                this.nMF = new com.baidu.tbadk.core.dialog.a(getActivity());
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
                this.nMF.bi(inflate);
                this.nMF.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.nMF.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.nMF.oT(1);
                this.nMF.oR(R.color.CAM_X0105);
                this.nMF.jl(true);
                this.nMF.b(getPageContext());
                this.nMF.brv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dXt() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dTM().dTN() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet() || !this.elQ) {
            return false;
        }
        if (this.nMl != null) {
            this.nMl.setVisibility(0);
        }
        aSi();
        dXs();
        return true;
    }

    private void aSj() {
        if (!dXt() && this.gqV != null && this.nMl != null && this.nMp != null) {
            if (this.gqV.getParent() == null) {
                dXy();
                dXz();
            }
            if (TbVideoViewSet.dCo().Rq(this.mVideoUrl) == null || TbVideoViewSet.dCo().Rq(this.mVideoUrl) != this.gqV) {
                this.gqV.setVideoPath(this.mVideoUrl, this.nMp.thread_id);
            }
            this.gqV.a((TbVideoViewSet.a) null);
            this.nMl.setVisibility(8);
            dBz();
            if (this.nME != null) {
                this.nME.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.nMy == null) {
            this.nMy = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.nMy;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0617a
    public void bJY() {
        if (this.gqV.isPlaying()) {
            this.gqV.pause();
            this.nMl.setVisibility(0);
        } else if (!dXt()) {
            this.gqV.start();
            this.nMl.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0617a
    public void y(float f, float f2) {
        if (bh.checkUpIsLogin(getActivity()) && !this.nMz) {
            dXu();
            if (this.nMp != null && "0".equals(this.nMp.is_agreed)) {
                Ms(this.nLW);
            }
        }
    }

    private void dXu() {
        if (this.mRootView != null) {
            this.nMz = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.nMB == null) {
                this.nMB = new RelativeLayout.LayoutParams(-2, -2);
                this.nMB.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.nMB);
            }
            if (this.nMA == null) {
                this.nMA = new AnimatorSet();
                this.nMA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.nMz = false;
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
            this.nMA.setTarget(imageView);
            this.nMA.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.nMA.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0617a
    public void bJZ() {
        if (this.nMp != null && this.nMp.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.nMp.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dXv() {
        return null;
    }

    public String dXw() {
        return null;
    }

    public boolean dXx() {
        if (this.nMD == null || this.nMD.bCn() == null || !this.nMD.bCn().isVisible()) {
            return false;
        }
        this.nMD.bCn().hide();
        this.nMt.setVisibility(0);
        if ((this.nMD.bCn().sj(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.nMD.bCn().sj(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.nMD.bCn().sj(28)).getInputView().getText() != null) {
            this.nMu.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.nMD.bCn().sj(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.nMD != null) {
            this.nMD.onActivityResult(i, i2, intent);
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
        if (this.nMD != null && this.nMD.bCn() != null) {
            this.nMD.bCn().onChangeSkinType(i);
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

    public void dXy() {
        if (this.gqV != null && this.gqV.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.gqV.getView(), 0);
            this.gqV.getView().setLayoutParams(layoutParams);
            if (this.nMp != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.amY = this.nMp.thread_id;
                oVar.mNid = this.nMp.nid;
                oVar.fFV = this.nMp.forum_id;
                oVar.myv = this.nMp.mMd5;
                oVar.eGn = "";
                oVar.mSource = this.nMp.mRecomSource;
                oVar.myu = this.nMp.mRecomAbTag;
                oVar.myt = 1;
                if (this.nMp.baijiahaoData != null) {
                    if (this.nMp.baijiahaoData.oriUgcType == 2) {
                        oVar.myt = 3;
                    } else if (this.nMp.baijiahaoData.oriUgcType == 4) {
                        oVar.myt = 2;
                    }
                }
                oVar.myr = this.nMp.mRecomWeight;
                if (this.mRect != null) {
                    oVar.myw = "1";
                } else {
                    oVar.myw = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.myx = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.mys = this.mFromPage;
                    oVar.eGn = this.eGn;
                    oVar.myq = this.nMp.mRecomWeight;
                } else {
                    oVar.mLocate = "14";
                }
                this.gqV.setVideoStatData(oVar);
                this.gqV.setLocateSource("v_mid_page");
            }
            this.gqV.setContinuePlayEnable(true);
        }
    }

    private void dXz() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.gqV.setOnPreparedListener(this.nMG);
        }
        this.gqV.setOnCompletionListener(this.mzd);
        this.gqV.setOnInfoListener(this.mzf);
    }
}
