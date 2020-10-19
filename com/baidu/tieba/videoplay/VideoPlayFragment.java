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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0579a {
    public ImageView aFn;
    private boolean dSj;
    private e ehg;
    private String emE;
    public TbCyberVideoView fTk;
    private AlphaAnimation fWo;
    private boolean gyX;
    private View hPJ;
    private int irl;
    private f.b lQx;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    public ExpandableTextView neA;
    public TextView neB;
    public TextView neC;
    public TextView neD;
    public TextView neE;
    public ImageView neF;
    private LinearLayout neG;
    public LinearLayout neH;
    public LinearLayout neI;
    public VideoItemData neJ;
    private TextView neK;
    public ImageView neL;
    public TextView neM;
    private View neN;
    private TextView neO;
    private int neP;
    private int neQ;
    private com.baidu.tieba.view.a neR;
    protected Animation neS;
    private boolean neT;
    private AnimatorSet neU;
    private RelativeLayout.LayoutParams neV;
    private com.baidu.tieba.videoplay.editor.a neX;
    private a neY;
    com.baidu.tbadk.core.dialog.a neZ;
    private TbImageView neq;
    public ImageView ner;
    public HeadImageView nes;
    public LinearLayout neu;
    public LinearLayout nev;

    /* renamed from: new  reason: not valid java name */
    public LinearLayout f6new;
    public ImageView nex;
    public ImageView ney;
    public ImageView nez;
    private int neo = 0;
    private int nep = 1;
    private ForumManageModel hGw = null;
    private com.baidu.tbadk.baseEditMark.a lbp = null;
    private com.baidu.tbadk.coreExtra.model.a ezg = null;
    private BdUniqueId aiy = BdUniqueId.gen();
    private boolean neW = false;
    private int playTime = 1;
    private CustomMessageListener ezk = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.neJ != null && VideoPlayFragment.this.neJ.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.neJ.author_info.user_id) && data != null && VideoPlayFragment.this.neJ.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.aiy)) ? false : false;
                    if (data.eQq == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.neJ.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_fail);
                                VideoPlayFragment.this.neJ.author_info.is_follow = "0";
                                VideoPlayFragment.this.dMn();
                                return;
                            }
                            return;
                        }
                        if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.dSj) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.neJ));
                                } else {
                                    VideoPlayFragment.this.neJ.author_info.is_follow = "1";
                                    VideoPlayFragment.this.dMn();
                                }
                            }
                        } else {
                            VideoPlayFragment.this.neJ.author_info.is_follow = "0";
                            VideoPlayFragment.this.dMn();
                        }
                        aq aqVar = new aq("c13570");
                        aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                        if ("index".equals(VideoPlayFragment.this.mFromPage)) {
                            aqVar.dK("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                            aqVar.dK("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        }
    };
    private final CustomMessageListener eiK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.dMp();
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.neJ != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.neJ.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.neJ.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.neJ.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.neJ.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dMm();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.neJ.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.neJ.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.neJ.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dMm();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnInfoListener lSi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (VideoPlayFragment.this.dSj) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.neq.getVisibility() == 0) {
                    VideoPlayFragment.this.neq.clearAnimation();
                    VideoPlayFragment.this.neq.startAnimation(VideoPlayFragment.this.fWo);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private CyberPlayerManager.OnCompletionListener lSg = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (VideoPlayFragment.this.fTk != null) {
                VideoPlayFragment.this.fTk.drL();
                VideoPlayFragment.this.fTk.seekTo(0);
                VideoPlayFragment.this.fTk.start();
                VideoPlayFragment.this.cir();
                VideoPlayFragment.A(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dMg();
                }
            }
        }
    };
    private CyberPlayerManager.OnPreparedListener nfa = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPlayFragment.this.fTk != null) {
                VideoPlayFragment.this.fTk.setVolume(1.0f, 1.0f);
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
        this.neJ = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.neQ = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString("page_from");
        this.mFromPage = arguments.getString("from");
        this.emE = arguments.getString("obj_id");
        if (this.neJ != null && this.neJ.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.neJ.author_info.user_id)) {
            this.gyX = true;
        }
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.fTk = new TbCyberVideoView(getContext());
        this.fTk.setStageType("2005");
        this.fTk.getMediaProgressObserver().a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.f.b
            public void ca(int i, int i2) {
                if (VideoPlayFragment.this.lQx != null) {
                    VideoPlayFragment.this.lQx.ca(i, i2);
                }
            }
        });
        dMu();
        this.neq = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.neq.setPlaceHolder(4);
        this.neq.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (g.blY()) {
            this.hPJ = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.hPJ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.hPJ.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aFn = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.ner = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.nes = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.nes.setDefaultResource(17170445);
        this.nes.setPlaceHolder(2);
        this.nes.setIsRound(true);
        this.nex = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.neL = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.neA = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.neB = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.nev = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.neC = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.neu = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.neD = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.neE = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.ney = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.nez = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dMh();
        this.neF = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.neG = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.neH = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.neI = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.f6new = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.neM = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.neN = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.neN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                    VideoPlayFragment.this.neN.setVisibility(4);
                    if (VideoPlayFragment.this.neX != null && VideoPlayFragment.this.neX.bvf() != null) {
                        VideoPlayFragment.this.neX.bvf().display();
                        if (VideoPlayFragment.this.neJ != null) {
                            VideoPlayFragment.this.neX.c(VideoPlayFragment.this.neJ);
                        }
                    }
                    if (VideoPlayFragment.this.neJ != null) {
                        aq aqVar = new aq("c13025");
                        aqVar.dK("tid", VideoPlayFragment.this.neJ.thread_id);
                        aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar.dK("fid", VideoPlayFragment.this.neJ.forum_id);
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        });
        this.neO = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.neK = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.neK.setVisibility(8);
        String string = b.blO().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.neK.setText(string);
        }
        final String string2 = b.blO().getString("nani_key_download_link_url", null);
        this.neK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    be.bmY().a((TbPageContext) i.I(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dMl();
        this.nes.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.neJ != null && VideoPlayFragment.this.neJ.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.neJ.author_info.user_id) && VideoPlayFragment.this.neJ != null && VideoPlayFragment.this.neJ.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.neJ.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    aq aqVar = new aq("c12798");
                    aqVar.dK("tid", VideoPlayFragment.this.neJ.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.neH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.neJ != null && VideoPlayFragment.this.neJ.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.neJ.act_info.link_url);
                    aq aqVar = new aq("c12799");
                    aqVar.dK("tid", VideoPlayFragment.this.neJ.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.neA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dMj();
            }
        });
        this.aFn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.neJ != null && !StringUtils.isNull(VideoPlayFragment.this.neJ.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.neJ.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.ner.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dMk();
            }
        });
        this.nev.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.neJ)) {
                    VideoPlayFragment.this.dMj();
                    aq aqVar = new aq("c12796");
                    aqVar.dK("tid", VideoPlayFragment.this.neJ.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        this.neu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Ks(VideoPlayFragment.this.neo);
            }
        });
        this.f6new.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.boA();
                aq aqVar = new aq("c12797");
                aqVar.dK("tid", VideoPlayFragment.this.neJ.thread_id);
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar);
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dK("tid", VideoPlayFragment.this.neJ.thread_id);
                aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.aj("obj_locate", 19);
                aqVar2.dK("nid", VideoPlayFragment.this.neJ.nid);
                if (VideoPlayFragment.this.neJ.baijiahaoData != null && !at.isEmpty(VideoPlayFragment.this.neJ.baijiahaoData.oriUgcVid)) {
                    aqVar2.dK("obj_param6", VideoPlayFragment.this.neJ.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.neJ.getVideoType() == 1) {
                    aqVar2.aj(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.neJ.getVideoType() == 2) {
                    aqVar2.aj(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.neJ.getVideoType() == 3) {
                    aqVar2.aj(IntentConfig.CARD_TYPE, 6);
                }
                aqVar2.dK(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.neJ.mRecomSource);
                aqVar2.dK("ab_tag", VideoPlayFragment.this.neJ.mRecomAbTag);
                aqVar2.dK("weight", VideoPlayFragment.this.neJ.mRecomWeight);
                aqVar2.dK("extra", VideoPlayFragment.this.neJ.mRecomExtra);
                aqVar2.dK("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                if (c.es(VideoPlayFragment.this.getBaseFragmentActivity()) != null && c.es(VideoPlayFragment.this.getBaseFragmentActivity()).bxL() != null && c.es(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(c.es(VideoPlayFragment.this.getBaseFragmentActivity()).getPrePageTag().locatePage)) {
                    aqVar2.dK("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    aqVar2.dK("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(aqVar2);
            }
        });
        this.nex.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.neJ != null && VideoPlayFragment.this.neJ.author_info != null) {
                    VideoPlayFragment.this.ezg.a(true, VideoPlayFragment.this.neJ.author_info.portrait, VideoPlayFragment.this.neJ.author_info.user_id, false, "6", VideoPlayFragment.this.aiy, VideoPlayFragment.this.neJ.forum_id, "0");
                    VideoPlayFragment.this.neJ.author_info.is_follow = "1";
                    VideoPlayFragment.this.dMn();
                }
            }
        });
        this.fWo = new AlphaAnimation(1.0f, 0.0f);
        this.fWo.setDuration(100L);
        this.fWo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.neq != null) {
                    VideoPlayFragment.this.neq.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.neP = this.mRect.right - this.mRect.left;
            this.irl = this.mRect.bottom - this.mRect.top;
            this.neq.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.neq.getWidth();
                    int height = VideoPlayFragment.this.neq.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.neJ.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.neJ.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.neJ.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.neJ.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.neP, VideoPlayFragment.this.irl);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.neq.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.irl > 0 || VideoPlayFragment.this.neP <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.neP;
                                f = i / VideoPlayFragment.this.irl;
                            }
                            VideoPlayFragment.this.neq.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.neq.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.dSj) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.neP, VideoPlayFragment.this.irl);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.neq.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.irl > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.neq.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.neq.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.dSj) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.neq.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.neq.getWidth();
                    int height = VideoPlayFragment.this.neq.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.neJ.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.neJ.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.neJ.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.neJ.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.neq.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.neq.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cRT();
        if (this.dSj) {
            dMi();
        }
        if (this.neJ != null && !StringUtils.isNull(this.neJ.video_url)) {
            setVideoInfo(this.neJ.video_url);
        }
        return this.mRootView;
    }

    public void a(f.b bVar) {
        this.lQx = bVar;
    }

    public void a(a aVar) {
        this.neY = aVar;
    }

    private void cRT() {
        this.neX = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().ei(getActivity());
        if (this.neX != null && this.neJ != null) {
            this.neX.a(getPageContext());
            this.neX.aB(this.neJ.thread_id, this.neJ.forum_id, this.neJ.forum_name);
            this.neX.a(new a.InterfaceC0838a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0838a
                public void xI(boolean z) {
                    VideoPlayFragment.this.neN.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.neO.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.neO.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) VideoPlayFragment.this.neX.bvf().qP(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.neJ != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.neJ.comment_num, 0L) + 1;
                        VideoPlayFragment.this.neJ.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.neC.setText(at.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.neX.bvf(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boA() {
        String str;
        String str2;
        if (this.neJ != null) {
            String str3 = this.neJ.forum_id;
            String str4 = this.neJ.forum_name;
            String str5 = this.neJ.title;
            if (this.neJ.baijiahaoData != null) {
                str = this.neJ.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.neJ.baijiahaoData.oriUgcType + "&dvid=" + this.neJ.baijiahaoData.oriUgcVid + "&nid=" + this.neJ.baijiahaoData.oriUgcNid;
            } else {
                str = this.neJ.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
            String str7 = this.neJ.thumbnail_url;
            String format = (!this.neJ.isBjhVideo || this.neJ.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.neJ.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.neJ.baijiahaoData == null) {
                shareItem.readCount = this.neJ.play_count;
            }
            if (this.neJ.isBjhVideo) {
                shareItem.eSH = format;
            } else {
                shareItem.eSH = "";
            }
            shareItem.linkUrl = str6;
            shareItem.esZ = 2;
            shareItem.extData = str;
            shareItem.eSK = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.eSw = true;
            shareItem.eSJ = 12;
            if (this.neJ.getVideoType() == 1) {
                shareItem.eSO = 2;
            } else if (this.neJ.getVideoType() == 2) {
                shareItem.eSO = 8;
            } else if (this.neJ.getVideoType() == 3) {
                shareItem.eSO = 6;
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.neJ.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.neJ.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.neJ.title;
            originalThreadInfo.threadId = this.neJ.thread_id;
            originalThreadInfo.oriUgcInfo = this.neJ.baijiahaoData;
            shareItem.eSR = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eSK);
            bundle.putInt("obj_type", shareItem.eSO);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.esZ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.f.cjN().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gyX) {
            this.hGw = new ForumManageModel(getPageContext());
            this.hGw.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.hGw.getLoadDataMode()) {
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
        this.lbp = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.lbp != null) {
            this.lbp.a(new a.InterfaceC0547a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0547a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.lbp != null) {
                            VideoPlayFragment.this.lbp.hU(z2);
                        }
                        if (VideoPlayFragment.this.neJ != null) {
                            if (z2) {
                                VideoPlayFragment.this.neJ.mark_id = VideoPlayFragment.this.neJ.post_id;
                            } else {
                                VideoPlayFragment.this.neJ.mark_id = null;
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
        this.ezg = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.ezk);
        registerListener(this.eiK);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.neW = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dMl();
        dMv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMg() {
        if (this.nez != null && this.ney != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.ney.clearAnimation();
            this.nez.clearAnimation();
            this.ney.setVisibility(8);
            this.nez.setVisibility(0);
            this.nez.startAnimation(scaleAnimation2);
            this.ney.startAnimation(scaleAnimation);
        }
    }

    private void dMh() {
        if (this.nez != null && this.ney != null) {
            this.ney.clearAnimation();
            this.nez.clearAnimation();
            this.ney.setVisibility(0);
            this.nez.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ks(int i) {
        int i2;
        if (bg.checkUpIsLogin(getActivity()) && this.neJ != null) {
            if (i == this.neo) {
                if ("1".equals(this.neJ.is_agreed)) {
                    i2 = 1;
                    this.neJ.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.neJ.agree_num, 0) - 1);
                    this.neJ.is_agreed = "0";
                } else {
                    this.neJ.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.neJ.agree_num, 0) + 1);
                    this.neJ.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.neJ.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.neJ.agree_num, 0) + 1);
                this.neJ.is_agreed = "1";
                i2 = 0;
            }
            aq aqVar = new aq("c12795");
            aqVar.dK("tid", this.neJ.thread_id);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.neo) {
                aqVar.aj("obj_type", i2);
            } else {
                aqVar.aj("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12003");
            aqVar2.dK("tid", this.neJ.thread_id);
            aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.neo) {
                aqVar2.aj("obj_type", i2);
            } else {
                aqVar2.aj("obj_type", 2);
            }
            if ("index".equals(this.mFromPage)) {
                aqVar2.dK("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                aqVar2.dK("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            TiebaStatic.log(aqVar2);
            dMl();
            if (this.neL != null && i2 == 0) {
                this.neL.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.neJ.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.neJ.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.neJ.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.neJ.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.neJ.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.neJ.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.neJ.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.neJ.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.neJ));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.neJ != null && !StringUtils.isNull(this.neJ.video_url)) {
            this.mHasInit = true;
            if (this.dSj) {
                cir();
                aLs();
                if (this.neJ != null && this.mRect != null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dK("tid", this.neJ.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.aj("obj_type", 0);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            aLr();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        aLr();
        if (this.neX != null && this.neX.bvf() != null) {
            this.neX.bvf().hide();
            this.neN.setVisibility(0);
            this.neO.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.neX.bvf().qP(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.neX != null) {
            this.neX.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.dSj = z;
        if (!z && this.neX != null) {
            this.neO.setText(R.string.reply_something);
            this.neX.cwN();
        }
        if (this.mHasInit) {
            if (this.dSj && (!this.neW || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.neJ != null && this.mRect == null) {
                    aq aqVar = new aq("c12794");
                    aqVar.dK("tid", this.neJ.thread_id);
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.aj("obj_type", 1);
                    TiebaStatic.log(aqVar);
                }
                startPlay();
                dMi();
                this.neW = false;
                return;
            }
            dMh();
            this.playTime = 1;
            aLr();
        }
    }

    private void dMi() {
        if (this.neJ != null) {
            aq aqVar = new aq("c12590");
            aqVar.dK("tid", this.neJ.thread_id);
            aqVar.dK("nid", this.neJ.nid);
            aqVar.dK("fid", this.neJ.forum_id);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.aj("obj_locate", this.neQ);
            aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aqVar.dK("obj_param1", at.isEmpty(this.neJ.mRecomWeight) ? "0" : this.neJ.mRecomWeight);
            aqVar.dK("extra", at.isEmpty(this.neJ.mRecomExtra) ? "0" : this.neJ.mRecomExtra);
            aqVar.dK("obj_id", this.emE);
            aqVar.dK("ab_tag", at.isEmpty(this.neJ.mRecomAbTag) ? "0" : this.neJ.mRecomAbTag);
            aqVar.dK("obj_source", at.isEmpty(this.neJ.mRecomSource) ? "0" : this.neJ.mRecomSource);
            aqVar.dK("obj_type", this.mFromPage);
            aqVar.aj("is_vertical", 1);
            if (this.neJ.baijiahaoData != null) {
                aqVar.dK("obj_param4", this.neJ.baijiahaoData.oriUgcNid);
                aqVar.dK("obj_param6", this.neJ.baijiahaoData.oriUgcVid);
                if (this.neJ.baijiahaoData.oriUgcType == 4) {
                    aqVar.aj("obj_param5", 2);
                } else if (this.neJ.baijiahaoData.oriUgcType == 2) {
                    aqVar.aj("obj_param5", 3);
                }
            } else {
                aqVar.aj("obj_param5", 1);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.fTk != null && str != null && !str.equals(this.mVideoUrl)) {
            this.fTk.setVideoPath(str, this.neJ.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dMp()) {
            dqX();
            if (this.neF != null) {
                this.neF.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.neq.getVisibility() == 0) {
                this.neq.clearAnimation();
                this.neq.startAnimation(this.fWo);
            }
            if (this.fTk != null) {
                if (TbVideoViewSet.drM().PX(this.mVideoUrl) == null || TbVideoViewSet.drM().PX(this.mVideoUrl) != this.fTk) {
                    this.fTk.setVideoPath(this.mVideoUrl, this.neJ.thread_id);
                }
                this.fTk.start();
                cir();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cir() {
        if (this.neJ != null) {
            o oVar = new o();
            oVar.mLocate = "nani_midpage";
            oVar.alS = this.neJ.thread_id;
            oVar.mNid = this.neJ.nid;
            oVar.fkA = this.neJ.forum_id + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.neJ.mRecomSource;
            oVar.lRu = this.neJ.mRecomAbTag;
            oVar.lRv = this.neJ.mRecomWeight;
            oVar.lRw = "";
            oVar.emE = "";
            oVar.lRz = this.neJ.mMd5;
            if (this.mRect != null) {
                oVar.lRA = "1";
            } else {
                oVar.lRA = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                oVar.lRB = "1";
                oVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                oVar.lRw = "index";
            }
            h.a(this.neJ.mMd5, "", "1", oVar, this.fTk.getPcdnState());
        }
    }

    private void dqX() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.dIK().fV(getContext());
        }
    }

    private void aLr() {
        if (this.fTk != null) {
            this.fTk.pause();
        }
    }

    private void stopPlay() {
        if (this.fTk != null) {
            this.fTk.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMj() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.neJ.thread_id, this.neJ.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.neJ.forum_id));
        createNormalCfg.setForumName(this.neJ.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.neJ.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMk() {
        if (this.ehg == null) {
            this.neR = new com.baidu.tieba.view.a(getActivity());
            this.ehg = new e(getActivity(), this.neR.bkZ());
            this.ehg.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.fTk.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.neR != null) {
            ArrayList arrayList = new ArrayList();
            a.C0840a c0840a = new a.C0840a(this.neR);
            c0840a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bg.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.ehg.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.ehg.dismiss();
                    if (VideoPlayFragment.this.neJ != null) {
                        boolean z = VideoPlayFragment.this.neJ.post_id != null && VideoPlayFragment.this.neJ.post_id.equals(VideoPlayFragment.this.neJ.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.neJ.thread_id);
                        markData.setPostId(VideoPlayFragment.this.neJ.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.neJ.thread_id);
                        markData.setForumId(VideoPlayFragment.this.neJ.forum_id);
                        if (VideoPlayFragment.this.lbp != null) {
                            VideoPlayFragment.this.lbp.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.lbp.bee();
                            } else {
                                VideoPlayFragment.this.lbp.bed();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.neJ != null && this.neJ.post_id != null && this.neJ.post_id.equals(this.neJ.mark_id)) {
                z = true;
            }
            if (z) {
                c0840a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0840a.setText(getResources().getString(R.string.mark));
            }
            if (this.neJ != null && !this.neJ.isBjhVideo) {
                arrayList.add(c0840a);
            }
            a.C0840a c0840a2 = new a.C0840a(getActivity().getString(R.string.delete), this.neR);
            c0840a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.ehg.dismiss();
                    if (bg.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.neJ != null) {
                        String str = VideoPlayFragment.this.neJ.thread_id;
                        String str2 = VideoPlayFragment.this.neJ.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.neJ.post_id;
                        if (VideoPlayFragment.this.neJ.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.neJ.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.neJ.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0840a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0840a2);
            if (this.gyX) {
                a.C0840a c0840a3 = new a.C0840a(getActivity().getString(R.string.delete), this.neR);
                c0840a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.ehg.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.ob(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.neJ != null) {
                                    VideoPlayFragment.this.hGw.a(VideoPlayFragment.this.neJ.forum_id, VideoPlayFragment.this.neJ.forum_name, VideoPlayFragment.this.neJ.thread_id, VideoPlayFragment.this.neJ.post_id, 0, 0, VideoPlayFragment.this.gyX, null);
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
                        aVar.iz(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.bkJ();
                    }
                });
                c0840a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0840a3);
            }
            this.neR.ba(arrayList);
        }
        this.ehg.show();
    }

    private void dMl() {
        if (this.neJ != null) {
            this.neq.startLoad(this.neJ.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.neJ.title);
            if (StringUtils.isNull(this.neJ.title) || matcher.matches()) {
                this.neA.setVisibility(8);
            } else {
                this.neA.setVisibility(0);
                this.neA.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.neA.setTextColor(R.color.cp_cont_a);
                this.neA.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.neA.setExpandable(true);
                this.neA.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void pZ(boolean z) {
                        VideoPlayFragment.this.neJ.isTitleExpanded = z;
                    }
                });
                this.neA.setData(this.neJ.title, this.neJ.isTitleExpanded);
            }
            this.neC.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.neJ.comment_num, 0L)));
            this.neD.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.neJ.agree_num, 0L)));
            this.neE.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.neJ.share_num, 0L)));
            if (this.neJ.author_info != null) {
                if (!TextUtils.isEmpty(this.neJ.author_info.bjhAvatar)) {
                    this.nes.startLoad(this.neJ.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.neJ.author_info.portrait) && this.neJ.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.nes.startLoad(this.neJ.author_info.portrait, 10, false);
                } else {
                    this.nes.startLoad(this.neJ.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.neJ.author_info.dIF())) {
                    this.neM.setVisibility(8);
                } else {
                    this.neM.setVisibility(0);
                    this.neM.setText(UgcConstant.AT_RULE_TAG + this.neJ.author_info.dIF());
                }
            }
            if ("1".equals(this.neJ.is_private) && this.neK.getVisibility() != 0) {
                this.neI.setVisibility(0);
            } else {
                this.neI.setVisibility(8);
            }
            if ("1".equals(this.neJ.is_agreed)) {
                ap.setImageResource(this.neL, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.neL, R.drawable.btn_video_agree);
            }
            if (this.neJ.act_info != null && !StringUtils.isNull(this.neJ.act_info.activity_name) && this.neK.getVisibility() != 0) {
                this.neH.setVisibility(0);
                this.neB.setText(this.neJ.act_info.activity_name);
            } else {
                this.neH.setVisibility(8);
            }
            dMn();
            if (this.neJ.isBjhVideo) {
                this.ner.setVisibility(8);
            } else {
                this.ner.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMm() {
        if (this.neJ != null) {
            if ("1".equals(this.neJ.is_agreed)) {
                ap.setImageResource(this.neL, R.drawable.icon_card_like_white_full_s);
            } else {
                ap.setImageResource(this.neL, R.drawable.btn_video_agree);
            }
            this.neD.setText(at.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.neJ.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMn() {
        if (this.gyX || (this.neJ.author_info != null && !"0".equals(this.neJ.author_info.is_follow))) {
            this.nex.setVisibility(4);
            this.nex.setClickable(false);
            return;
        }
        this.nex.setVisibility(0);
        this.nex.setClickable(true);
    }

    private void dMo() {
        if (getActivity() != null) {
            if (this.neZ == null || !this.neZ.isShowing()) {
                this.neZ = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.bmU().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.neZ.ba(inflate);
                this.neZ.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.neZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.neZ.oe(1);
                this.neZ.oc(R.color.cp_cont_b);
                this.neZ.iz(true);
                this.neZ.b(getPageContext());
                this.neZ.bkJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dMp() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dIK().dIL() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet() || !this.dSj) {
            return false;
        }
        if (this.neF != null) {
            this.neF.setVisibility(0);
        }
        aLr();
        dMo();
        return true;
    }

    private void aLs() {
        if (!dMp() && this.fTk != null && this.neF != null && this.neJ != null) {
            if (this.fTk.getParent() == null) {
                dMu();
                dMv();
            }
            if (TbVideoViewSet.drM().PX(this.mVideoUrl) == null || TbVideoViewSet.drM().PX(this.mVideoUrl) != this.fTk) {
                this.fTk.setVideoPath(this.mVideoUrl, this.neJ.thread_id);
            }
            this.fTk.a((TbVideoViewSet.a) null);
            this.neF.setVisibility(8);
            dqX();
            if (this.neY != null) {
                this.neY.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.neS == null) {
            this.neS = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.neS;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0579a
    public void bCN() {
        if (this.fTk.isPlaying()) {
            this.fTk.pause();
            this.neF.setVisibility(0);
        } else if (!dMp()) {
            this.fTk.start();
            this.neF.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0579a
    public void y(float f, float f2) {
        if (bg.checkUpIsLogin(getActivity()) && !this.neT) {
            dMq();
            if (this.neJ != null && "0".equals(this.neJ.is_agreed)) {
                Ks(this.nep);
            }
        }
    }

    private void dMq() {
        if (this.mRootView != null) {
            this.neT = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.neV == null) {
                this.neV = new RelativeLayout.LayoutParams(-2, -2);
                this.neV.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.neV);
            }
            if (this.neU == null) {
                this.neU = new AnimatorSet();
                this.neU.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.neT = false;
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
            this.neU.setTarget(imageView);
            this.neU.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.neU.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0579a
    public void bCO() {
        if (this.neJ != null && this.neJ.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.neJ.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> dMr() {
        return null;
    }

    public String dMs() {
        return null;
    }

    public boolean dMt() {
        if (this.neX == null || this.neX.bvf() == null || !this.neX.bvf().isVisible()) {
            return false;
        }
        this.neX.bvf().hide();
        this.neN.setVisibility(0);
        if ((this.neX.bvf().qP(28) instanceof com.baidu.tieba.videoplay.editor.c) && ((com.baidu.tieba.videoplay.editor.c) this.neX.bvf().qP(28)).getInputView() != null && ((com.baidu.tieba.videoplay.editor.c) this.neX.bvf().qP(28)).getInputView().getText() != null) {
            this.neO.setText(StringUtils.isNull(((com.baidu.tieba.videoplay.editor.c) this.neX.bvf().qP(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.neX != null) {
            this.neX.onActivityResult(i, i2, intent);
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
        if (this.neX != null && this.neX.bvf() != null) {
            this.neX.bvf().onChangeSkinType(i);
        }
        SvgManager.bmU().a(this.aFn, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dMu() {
        if (this.fTk != null && this.fTk.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.fTk.getView(), 0);
            this.fTk.getView().setLayoutParams(layoutParams);
            if (this.neJ != null) {
                o oVar = new o();
                oVar.mUid = TbadkCoreApplication.getCurrentAccount();
                oVar.alS = this.neJ.thread_id;
                oVar.mNid = this.neJ.nid;
                oVar.fkA = this.neJ.forum_id;
                oVar.lRz = this.neJ.mMd5;
                oVar.emE = "";
                oVar.mSource = this.neJ.mRecomSource;
                oVar.lRy = this.neJ.mRecomAbTag;
                oVar.lRx = 1;
                if (this.neJ.baijiahaoData != null) {
                    if (this.neJ.baijiahaoData.oriUgcType == 2) {
                        oVar.lRx = 3;
                    } else if (this.neJ.baijiahaoData.oriUgcType == 4) {
                        oVar.lRx = 2;
                    }
                }
                oVar.lRv = this.neJ.mRecomWeight;
                if (this.mRect != null) {
                    oVar.lRA = "1";
                } else {
                    oVar.lRA = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    oVar.lRB = "1";
                    oVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    oVar.lRw = this.mFromPage;
                    oVar.emE = this.emE;
                    oVar.lRu = this.neJ.mRecomWeight;
                } else {
                    oVar.mLocate = "14";
                }
                this.fTk.setVideoStatData(oVar);
                this.fTk.setLocateSource("v_mid_page");
            }
            this.fTk.setContinuePlayEnable(true);
        }
    }

    private void dMv() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.fTk.setOnPreparedListener(this.nfa);
        }
        this.fTk.setOnCompletionListener(this.lSg);
        this.fTk.setOnInfoListener(this.lSi);
    }
}
