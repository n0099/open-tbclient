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
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.a.b;
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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.person.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.editor.a;
import com.baidu.tieba.videoplay.editor.c;
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
/* loaded from: classes11.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0500a {
    public ImageView atr;
    private String dCp;
    private boolean djy;
    private e dyF;
    private boolean fEF;
    private n fbO;
    private AlphaAnimation feI;
    private View gOh;
    private int hoV;
    private boolean isNewPlayer;
    public com.baidu.tieba.play.a.a kwT;
    private j.b kxP;
    private QuickVideoView.c kyh;
    private TbImageView lKA;
    public ImageView lKB;
    public HeadImageView lKC;
    public LinearLayout lKD;
    public LinearLayout lKE;
    public LinearLayout lKF;
    public ImageView lKG;
    public ImageView lKH;
    public ImageView lKI;
    public ExpandableTextView lKJ;
    public TextView lKK;
    public TextView lKL;
    public TextView lKM;
    public TextView lKN;
    public ImageView lKO;
    private LinearLayout lKP;
    public LinearLayout lKQ;
    public LinearLayout lKR;
    public VideoItemData lKS;
    private TextView lKT;
    public ImageView lKU;
    public TextView lKV;
    private View lKW;
    private TextView lKX;
    private int lKY;
    private int lKZ;
    private com.baidu.tieba.view.a lLa;
    protected Animation lLb;
    private boolean lLc;
    private AnimatorSet lLd;
    private RelativeLayout.LayoutParams lLe;
    private com.baidu.tieba.videoplay.editor.a lLg;
    com.baidu.tbadk.core.dialog.a lLh;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int lKy = 0;
    private int lKz = 1;
    private ForumManageModel gEV = null;
    private com.baidu.tbadk.baseEditMark.a jKx = null;
    private com.baidu.tbadk.coreExtra.model.a dNL = null;
    private BdUniqueId afZ = BdUniqueId.gen();
    private boolean lLf = false;
    private int playTime = 1;
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.lKS != null && VideoPlayFragment.this.lKS.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.lKS.author_info.user_id) && data != null && VideoPlayFragment.this.lKS.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.afZ)) ? false : false;
                    if (data.ecK == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.lKS.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.lKS.author_info.is_follow = "0";
                                VideoPlayFragment.this.dlp();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.djy) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.lKS));
                                    return;
                                }
                                VideoPlayFragment.this.lKS.author_info.is_follow = "1";
                                VideoPlayFragment.this.dlp();
                            }
                        } else {
                            VideoPlayFragment.this.lKS.author_info.is_follow = "0";
                            VideoPlayFragment.this.dlp();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.dlr();
            }
        }
    };
    private CustomMessageListener dRK = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.lKS != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.lKS.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.lKS.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.lKS.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.lKS.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dlo();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.lKS.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.lKS.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.lKS.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dlo();
                    }
                }
            }
        }
    };
    private g.e lLi = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.djy) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.lKA.getVisibility() == 0) {
                    VideoPlayFragment.this.lKA.clearAnimation();
                    VideoPlayFragment.this.lKA.startAnimation(VideoPlayFragment.this.feI);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a lLj = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.kwT != null) {
                VideoPlayFragment.this.kwT.cQJ();
                VideoPlayFragment.this.kwT.seekTo(0);
                VideoPlayFragment.this.kwT.start();
                VideoPlayFragment.this.bKY();
                VideoPlayFragment.z(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dli();
                }
            }
        }
    };
    private g.f lLk = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            if (VideoPlayFragment.this.kwT != null) {
                VideoPlayFragment.this.kwT.setVolume(1.0f, 1.0f);
            }
        }
    };

    static /* synthetic */ int z(VideoPlayFragment videoPlayFragment) {
        int i = videoPlayFragment.playTime;
        videoPlayFragment.playTime = i + 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dRK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.lKS = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.lKZ = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.dCp = arguments.getString("obj_id");
        if (this.lKS != null && this.lKS.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.lKS.author_info.user_id)) {
            this.fEF = true;
        }
        this.fbO = new n(getActivity());
        this.fbO.a(this.lKS);
        this.fbO.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.j.b
            public void bI(int i, int i2) {
                if (VideoPlayFragment.this.kxP != null) {
                    VideoPlayFragment.this.kxP.bI(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.uD("cyber_player_test") || b.uC("cyber_player_test");
        this.kwT = com.baidu.tieba.play.a.b.A(getContext(), this.isNewPlayer ? 1 : 0);
        dlv();
        this.lKA = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.lKA.setPlaceHolder(4);
        this.lKA.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aUh()) {
            this.gOh = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.gOh.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.gOh.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.atr = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.lKB = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.lKC = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.lKC.setDefaultResource(17170445);
        this.lKC.setPlaceHolder(2);
        this.lKC.setIsRound(true);
        this.lKG = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.lKU = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.lKJ = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.lKK = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.lKE = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.lKL = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.lKD = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.lKM = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.lKN = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.lKH = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.lKI = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dlj();
        this.lKO = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.lKP = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.lKQ = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.lKR = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.lKF = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.lKV = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.lKW = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.lKW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.lKW.setVisibility(4);
                    if (VideoPlayFragment.this.lLg != null && VideoPlayFragment.this.lLg.bcW() != null) {
                        VideoPlayFragment.this.lLg.bcW().display();
                        if (VideoPlayFragment.this.lKS != null) {
                            VideoPlayFragment.this.lLg.c(VideoPlayFragment.this.lKS);
                        }
                    }
                    if (VideoPlayFragment.this.lKS != null) {
                        an anVar = new an("c13025");
                        anVar.dh("tid", VideoPlayFragment.this.lKS.thread_id);
                        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.dh("fid", VideoPlayFragment.this.lKS.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.lKX = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.lKT = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.lKT.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.lKT.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_download_link_url", null);
        this.lKT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aUZ().a((TbPageContext) i.G(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dln();
        this.lKC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.lKS != null && VideoPlayFragment.this.lKS.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.lKS.author_info.user_id) && VideoPlayFragment.this.lKS != null && VideoPlayFragment.this.lKS.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.lKS.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.dh("tid", VideoPlayFragment.this.lKS.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.lKQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.lKS != null && VideoPlayFragment.this.lKS.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.lKS.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.dh("tid", VideoPlayFragment.this.lKS.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.lKJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dll();
            }
        });
        this.atr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.lKS != null && !StringUtils.isNull(VideoPlayFragment.this.lKS.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.lKS.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.lKB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dlm();
            }
        });
        this.lKE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.lKS)) {
                    VideoPlayFragment.this.dll();
                    an anVar = new an("c12796");
                    anVar.dh("tid", VideoPlayFragment.this.lKS.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.lKD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Fk(VideoPlayFragment.this.lKy);
            }
        });
        this.lKF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aWI();
                an anVar = new an("c12797");
                anVar.dh("tid", VideoPlayFragment.this.lKS.thread_id);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.dh("tid", VideoPlayFragment.this.lKS.thread_id);
                anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.ag("obj_locate", 19);
                anVar2.dh("nid", VideoPlayFragment.this.lKS.nid);
                if (VideoPlayFragment.this.lKS.baijiahaoData != null && !aq.isEmpty(VideoPlayFragment.this.lKS.baijiahaoData.oriUgcVid)) {
                    anVar2.dh("obj_param6", VideoPlayFragment.this.lKS.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.lKS.getVideoType() == 1) {
                    anVar2.ag(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.lKS.getVideoType() == 2) {
                    anVar2.ag(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.lKS.getVideoType() == 3) {
                    anVar2.ag(IntentConfig.CARD_TYPE, 6);
                }
                anVar2.dh(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.lKS.mRecomSource);
                anVar2.dh("ab_tag", VideoPlayFragment.this.lKS.mRecomAbTag);
                anVar2.dh("weight", VideoPlayFragment.this.lKS.mRecomWeight);
                anVar2.dh("extra", VideoPlayFragment.this.lKS.mRecomExtra);
                anVar2.dh("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                TiebaStatic.log(anVar2);
            }
        });
        this.lKG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.lKS != null && VideoPlayFragment.this.lKS.author_info != null) {
                    VideoPlayFragment.this.dNL.a(true, VideoPlayFragment.this.lKS.author_info.portrait, VideoPlayFragment.this.lKS.author_info.user_id, false, "6", VideoPlayFragment.this.afZ, VideoPlayFragment.this.lKS.forum_id, "0");
                    VideoPlayFragment.this.lKS.author_info.is_follow = "1";
                    VideoPlayFragment.this.dlp();
                }
            }
        });
        this.feI = new AlphaAnimation(1.0f, 0.0f);
        this.feI.setDuration(100L);
        this.feI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.lKA != null) {
                    VideoPlayFragment.this.lKA.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.lKY = this.mRect.right - this.mRect.left;
            this.hoV = this.mRect.bottom - this.mRect.top;
            this.lKA.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.lKA.getWidth();
                    int height = VideoPlayFragment.this.lKA.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lKS.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lKS.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lKS.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lKS.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.lKY, VideoPlayFragment.this.hoV);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.lKA.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hoV > 0 || VideoPlayFragment.this.lKY <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.lKY;
                                f = i / VideoPlayFragment.this.hoV;
                            }
                            VideoPlayFragment.this.lKA.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.lKA.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.djy) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.lKY, VideoPlayFragment.this.hoV);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.lKA.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hoV > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.lKA.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.lKA.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.djy) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.lKA.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.lKA.getWidth();
                    int height = VideoPlayFragment.this.lKA.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lKS.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lKS.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lKS.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lKS.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.lKA.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.lKA.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cxp();
        if (this.djy) {
            dlk();
        }
        if (this.lKS != null && !StringUtils.isNull(this.lKS.video_url)) {
            setVideoInfo(this.lKS.video_url);
        }
        return this.mRootView;
    }

    public boolean cPS() {
        return !this.isNewPlayer && (this.kwT instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.kxP = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.kyh = cVar;
    }

    private void cxp() {
        this.lLg = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dN(getActivity());
        if (this.lLg != null && this.lKS != null) {
            this.lLg.a(getPageContext());
            this.lLg.az(this.lKS.thread_id, this.lKS.forum_id, this.lKS.forum_name);
            this.lLg.a(new a.InterfaceC0744a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0744a
                public void vf(boolean z) {
                    VideoPlayFragment.this.lKW.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.lKX.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.lKX.setText(StringUtils.isNull(((c) VideoPlayFragment.this.lLg.bcW().nf(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.lKS != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.lKS.comment_num, 0L) + 1;
                        VideoPlayFragment.this.lKS.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.lKL.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.lLg.bcW(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWI() {
        String str;
        String str2;
        if (this.lKS != null) {
            String str3 = this.lKS.forum_id;
            String str4 = this.lKS.forum_name;
            String str5 = this.lKS.title;
            if (this.lKS.baijiahaoData != null) {
                str = this.lKS.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.lKS.baijiahaoData.oriUgcType + "&dvid=" + this.lKS.baijiahaoData.oriUgcVid + "&nid=" + this.lKS.baijiahaoData.oriUgcNid;
            } else {
                str = this.lKS.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.lKS.thumbnail_url;
            String format = (!this.lKS.isBjhVideo || this.lKS.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.lKS.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.lKS.baijiahaoData == null) {
                shareItem.readCount = this.lKS.play_count;
            }
            if (this.lKS.isBjhVideo) {
                shareItem.eeT = format;
            } else {
                shareItem.eeT = "";
            }
            shareItem.linkUrl = str6;
            shareItem.dHZ = 2;
            shareItem.extData = str;
            shareItem.eeW = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.eeK = true;
            shareItem.eeV = 12;
            shareItem.efa = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.lKS.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.lKS.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.lKS.title;
            originalThreadInfo.threadId = this.lKS.thread_id;
            originalThreadInfo.oriUgcInfo = this.lKS.baijiahaoData;
            shareItem.efd = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eeW);
            bundle.putInt("obj_type", shareItem.efa);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dHZ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.e.bMw().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fEF) {
            this.gEV = new ForumManageModel(getPageContext());
            this.gEV.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.gEV.getLoadDataMode()) {
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
        this.jKx = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.jKx != null) {
            this.jKx.a(new a.InterfaceC0471a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0471a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.jKx != null) {
                            VideoPlayFragment.this.jKx.gC(z2);
                        }
                        if (VideoPlayFragment.this.lKS != null) {
                            if (z2) {
                                VideoPlayFragment.this.lKS.mark_id = VideoPlayFragment.this.lKS.post_id;
                            } else {
                                VideoPlayFragment.this.lKS.mark_id = null;
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
        this.dNL = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.dNP);
        registerListener(this.dyW);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.lLf = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dln();
        dlw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dli() {
        if (this.lKI != null && this.lKH != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.lKH.clearAnimation();
            this.lKI.clearAnimation();
            this.lKH.setVisibility(8);
            this.lKI.setVisibility(0);
            this.lKI.startAnimation(scaleAnimation2);
            this.lKH.startAnimation(scaleAnimation);
        }
    }

    private void dlj() {
        if (this.lKI != null && this.lKH != null) {
            this.lKH.clearAnimation();
            this.lKI.clearAnimation();
            this.lKH.setVisibility(0);
            this.lKI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fk(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.lKS != null) {
            if (i == this.lKy) {
                if ("1".equals(this.lKS.is_agreed)) {
                    i2 = 1;
                    this.lKS.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.lKS.agree_num, 0) - 1);
                    this.lKS.is_agreed = "0";
                } else {
                    this.lKS.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.lKS.agree_num, 0) + 1);
                    this.lKS.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.lKS.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.lKS.agree_num, 0) + 1);
                this.lKS.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.dh("tid", this.lKS.thread_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.lKy) {
                anVar.ag("obj_type", i2);
            } else {
                anVar.ag("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            dln();
            if (this.lKU != null && i2 == 0) {
                this.lKU.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.lKS.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.lKS.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.lKS.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.lKS.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.lKS.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.lKS.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.lKS.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.lKS.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.lKS));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.lKS != null && !StringUtils.isNull(this.lKS.video_url)) {
            this.mHasInit = true;
            if (this.djy) {
                bKY();
                avU();
                if (this.lKS != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.dh("tid", this.lKS.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.ag("obj_type", 0);
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            avT();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        avT();
        if (this.lLg != null && this.lLg.bcW() != null) {
            this.lLg.bcW().hide();
            this.lKW.setVisibility(0);
            this.lKX.setText(StringUtils.isNull(((c) this.lLg.bcW().nf(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        MessageManager.getInstance().unRegisterListener(this.dRK);
        if (this.lLg != null) {
            this.lLg.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.djy = z;
        if (!z && this.lLg != null) {
            this.lKX.setText(R.string.reply_something);
            this.lLg.dlF();
        }
        if (this.mHasInit) {
            if (this.djy && (!this.lLf || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.lKS != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.dh("tid", this.lKS.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.ag("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                dlk();
                this.lLf = false;
                return;
            }
            dlj();
            this.playTime = 1;
            avT();
        }
    }

    private void dlk() {
        if (this.lKS != null) {
            an anVar = new an("c12590");
            anVar.dh("tid", this.lKS.thread_id);
            anVar.dh("nid", this.lKS.nid);
            anVar.dh("fid", this.lKS.forum_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.ag("obj_locate", this.lKZ);
            anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.dh("obj_param1", aq.isEmpty(this.lKS.mRecomWeight) ? "0" : this.lKS.mRecomWeight);
            anVar.dh("extra", aq.isEmpty(this.lKS.mRecomExtra) ? "0" : this.lKS.mRecomExtra);
            anVar.dh("obj_id", this.dCp);
            anVar.dh("ab_tag", aq.isEmpty(this.lKS.mRecomAbTag) ? "0" : this.lKS.mRecomAbTag);
            anVar.dh("obj_source", aq.isEmpty(this.lKS.mRecomSource) ? "0" : this.lKS.mRecomSource);
            anVar.dh("obj_type", this.mFromPage);
            anVar.ag("is_vertical", 1);
            if (this.lKS.baijiahaoData != null) {
                anVar.dh("obj_param4", this.lKS.baijiahaoData.oriUgcNid);
                anVar.dh("obj_param6", this.lKS.baijiahaoData.oriUgcVid);
                if (this.lKS.baijiahaoData.oriUgcType == 4) {
                    anVar.ag("obj_param5", 2);
                } else if (this.lKS.baijiahaoData.oriUgcType == 2) {
                    anVar.ag("obj_param5", 3);
                }
            } else {
                anVar.ag("obj_param5", 1);
            }
            TiebaStatic.log(anVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.kwT != null && str != null && !str.equals(this.mVideoUrl)) {
            if (cPS()) {
                ((QuickVideoView) this.kwT).setRecoveryState(0);
            }
            this.kwT.setVideoPath(str, this.lKS.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dlr()) {
            cQe();
            if (this.lKO != null) {
                this.lKO.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.lKA.getVisibility() == 0) {
                this.lKA.clearAnimation();
                this.lKA.startAnimation(this.feI);
            }
            if (this.kwT != null) {
                if (TbVideoViewSet.cRt().KB(this.mVideoUrl) == null || TbVideoViewSet.cRt().KB(this.mVideoUrl) != this.kwT) {
                    this.kwT.setVideoPath(this.mVideoUrl, this.lKS.thread_id);
                }
                this.kwT.start();
                bKY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKY() {
        if (this.lKS != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.ais = this.lKS.thread_id;
            yVar.mNid = this.lKS.nid;
            yVar.evm = this.lKS.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.lKS.mRecomSource;
            yVar.kAl = this.lKS.mRecomAbTag;
            yVar.kAm = this.lKS.mRecomWeight;
            yVar.kAn = "";
            yVar.dCp = "";
            yVar.kAq = this.lKS.mMd5;
            if (this.mRect != null) {
                yVar.kAr = "1";
            } else {
                yVar.kAr = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.kAs = "1";
                yVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                yVar.kAn = "index";
            }
            com.baidu.tieba.play.l.a(this.lKS.mMd5, "", "1", yVar);
        }
    }

    private void cQe() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dhK().fs(getContext());
        }
    }

    private void avT() {
        if (this.kwT != null) {
            this.kwT.pause();
        }
    }

    private void stopPlay() {
        if (this.kwT != null) {
            if (cPS()) {
                ((QuickVideoView) this.kwT).setRecoveryState(5);
            }
            this.kwT.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dll() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.lKS.thread_id, this.lKS.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.lKS.forum_id));
        createNormalCfg.setForumName(this.lKS.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.lKS.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlm() {
        if (this.dyF == null) {
            this.lLa = new com.baidu.tieba.view.a(getActivity());
            this.dyF = new e(getActivity(), this.lLa.aTh());
            this.dyF.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.kwT.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.lLa != null) {
            ArrayList arrayList = new ArrayList();
            a.C0745a c0745a = new a.C0745a(this.lLa);
            c0745a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bc.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.dyF.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.dyF.dismiss();
                    if (VideoPlayFragment.this.lKS != null) {
                        boolean z = VideoPlayFragment.this.lKS.post_id != null && VideoPlayFragment.this.lKS.post_id.equals(VideoPlayFragment.this.lKS.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.lKS.thread_id);
                        markData.setPostId(VideoPlayFragment.this.lKS.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.lKS.thread_id);
                        markData.setForumId(VideoPlayFragment.this.lKS.forum_id);
                        if (VideoPlayFragment.this.jKx != null) {
                            VideoPlayFragment.this.jKx.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.jKx.aMN();
                            } else {
                                VideoPlayFragment.this.jKx.aMM();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.lKS != null && this.lKS.post_id != null && this.lKS.post_id.equals(this.lKS.mark_id)) {
                z = true;
            }
            if (z) {
                c0745a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0745a.setText(getResources().getString(R.string.mark));
            }
            if (this.lKS != null && !this.lKS.isBjhVideo) {
                arrayList.add(c0745a);
            }
            a.C0745a c0745a2 = new a.C0745a(getActivity().getString(R.string.delete), this.lLa);
            c0745a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.dyF.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.lKS != null) {
                        String str = VideoPlayFragment.this.lKS.thread_id;
                        String str2 = VideoPlayFragment.this.lKS.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.lKS.post_id;
                        if (VideoPlayFragment.this.lKS.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.lKS.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.lKS.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0745a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0745a2);
            if (this.fEF) {
                a.C0745a c0745a3 = new a.C0745a(getActivity().getString(R.string.delete), this.lLa);
                c0745a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.dyF.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.kD(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.lKS != null) {
                                    VideoPlayFragment.this.gEV.a(VideoPlayFragment.this.lKS.forum_id, VideoPlayFragment.this.lKS.forum_name, VideoPlayFragment.this.lKS.thread_id, VideoPlayFragment.this.lKS.post_id, 0, 0, VideoPlayFragment.this.fEF, null);
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
                        aVar.gW(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.aST();
                    }
                });
                c0745a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0745a3);
            }
            this.lLa.aD(arrayList);
        }
        this.dyF.show();
    }

    private void dln() {
        if (this.lKS != null) {
            this.lKA.startLoad(this.lKS.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.lKS.title);
            if (StringUtils.isNull(this.lKS.title) || matcher.matches()) {
                this.lKJ.setVisibility(8);
            } else {
                this.lKJ.setVisibility(0);
                this.lKJ.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.lKJ.setTextColor(R.color.cp_cont_a);
                this.lKJ.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.lKJ.setExpandable(true);
                this.lKJ.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void nR(boolean z) {
                        VideoPlayFragment.this.lKS.isTitleExpanded = z;
                    }
                });
                this.lKJ.setData(this.lKS.title, this.lKS.isTitleExpanded);
            }
            this.lKL.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lKS.comment_num, 0L)));
            this.lKM.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lKS.agree_num, 0L)));
            this.lKN.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lKS.share_num, 0L)));
            if (this.lKS.author_info != null) {
                if (!TextUtils.isEmpty(this.lKS.author_info.bjhAvatar)) {
                    this.lKC.startLoad(this.lKS.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.lKS.author_info.portrait) && this.lKS.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.lKC.startLoad(this.lKS.author_info.portrait, 10, false);
                } else {
                    this.lKC.startLoad(this.lKS.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.lKS.author_info.dhG())) {
                    this.lKV.setVisibility(8);
                } else {
                    this.lKV.setVisibility(0);
                    this.lKV.setText(UgcConstant.AT_RULE_TAG + this.lKS.author_info.dhG());
                }
            }
            if ("1".equals(this.lKS.is_private) && this.lKT.getVisibility() != 0) {
                this.lKR.setVisibility(0);
            } else {
                this.lKR.setVisibility(8);
            }
            if ("1".equals(this.lKS.is_agreed)) {
                am.setImageResource(this.lKU, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.lKU, R.drawable.btn_video_agree);
            }
            if (this.lKS.act_info != null && !StringUtils.isNull(this.lKS.act_info.activity_name) && this.lKT.getVisibility() != 0) {
                this.lKQ.setVisibility(0);
                this.lKK.setText(this.lKS.act_info.activity_name);
            } else {
                this.lKQ.setVisibility(8);
            }
            dlp();
            if (this.lKS.isBjhVideo) {
                this.lKB.setVisibility(8);
            } else {
                this.lKB.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlo() {
        if (this.lKS != null) {
            if ("1".equals(this.lKS.is_agreed)) {
                am.setImageResource(this.lKU, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.lKU, R.drawable.btn_video_agree);
            }
            this.lKM.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lKS.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlp() {
        if (this.fEF || (this.lKS.author_info != null && !"0".equals(this.lKS.author_info.is_follow))) {
            this.lKG.setVisibility(4);
            this.lKG.setClickable(false);
            return;
        }
        this.lKG.setVisibility(0);
        this.lKG.setClickable(true);
    }

    private void dlq() {
        if (getActivity() != null) {
            if (this.lLh == null || !this.lLh.isShowing()) {
                this.lLh = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.aUV().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.lLh.aP(inflate);
                this.lLh.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.lLh.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.lLh.kG(1);
                this.lLh.kE(R.color.cp_cont_b);
                this.lLh.gW(true);
                this.lLh.b(getPageContext());
                this.lLh.aST();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dlr() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dhK().dhL() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !com.baidu.adp.lib.util.j.isMobileNet() || !this.djy) {
            return false;
        }
        if (this.lKO != null) {
            this.lKO.setVisibility(0);
        }
        avT();
        dlq();
        return true;
    }

    private void avU() {
        if (!dlr() && this.kwT != null && this.lKO != null && this.lKS != null) {
            if (this.kwT.getParent() == null) {
                dlv();
                dlw();
            }
            if (TbVideoViewSet.cRt().KB(this.mVideoUrl) == null || TbVideoViewSet.cRt().KB(this.mVideoUrl) != this.kwT) {
                this.kwT.setVideoPath(this.mVideoUrl, this.lKS.thread_id);
            }
            this.kwT.b(null);
            this.lKO.setVisibility(8);
            cQe();
            if (this.kyh != null) {
                this.kyh.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.lLb == null) {
            this.lLb = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.lLb;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0500a
    public void bjJ() {
        if (this.kwT.isPlaying()) {
            this.kwT.pause();
            this.lKO.setVisibility(0);
        } else if (!dlr()) {
            this.kwT.start();
            this.lKO.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0500a
    public void t(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.lLc) {
            dls();
            if (this.lKS != null && "0".equals(this.lKS.is_agreed)) {
                Fk(this.lKz);
            }
        }
    }

    private void dls() {
        if (this.mRootView != null) {
            this.lLc = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.lLe == null) {
                this.lLe = new RelativeLayout.LayoutParams(-2, -2);
                this.lLe.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.lLe);
            }
            if (this.lLd == null) {
                this.lLd = new AnimatorSet();
                this.lLd.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.lLc = false;
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
            this.lLd.setTarget(imageView);
            this.lLd.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.lLd.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0500a
    public void bjK() {
        if (this.lKS != null && this.lKS.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.lKS.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cPS()) {
            return ((QuickVideoView) this.kwT).getMediaIDs();
        }
        return null;
    }

    public String dlt() {
        if (cPS()) {
            return ((QuickVideoView) this.kwT).getMediaId();
        }
        return null;
    }

    public boolean dlu() {
        if (this.lLg == null || this.lLg.bcW() == null || !this.lLg.bcW().isVisible()) {
            return false;
        }
        this.lLg.bcW().hide();
        this.lKW.setVisibility(0);
        if ((this.lLg.bcW().nf(28) instanceof c) && ((c) this.lLg.bcW().nf(28)).getInputView() != null && ((c) this.lLg.bcW().nf(28)).getInputView().getText() != null) {
            this.lKX.setText(StringUtils.isNull(((c) this.lLg.bcW().nf(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.lLg != null) {
            this.lLg.onActivityResult(i, i2, intent);
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
        if (this.lLg != null && this.lLg.bcW() != null) {
            this.lLg.bcW().onChangeSkinType(i);
        }
        SvgManager.aUV().a(this.atr, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dlv() {
        if (this.kwT != null && this.kwT.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.kwT.getView(), 0);
            this.kwT.getView().setLayoutParams(layoutParams);
            if (cPS()) {
                ((QuickVideoView) this.kwT).setNeedRecovery(true);
            }
            if (this.lKS != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.ais = this.lKS.thread_id;
                yVar.mNid = this.lKS.nid;
                yVar.evm = this.lKS.forum_id;
                yVar.kAq = this.lKS.mMd5;
                yVar.dCp = "";
                yVar.mSource = this.lKS.mRecomSource;
                yVar.kAp = this.lKS.mRecomAbTag;
                yVar.kAo = 1;
                if (this.lKS.baijiahaoData != null) {
                    if (this.lKS.baijiahaoData.oriUgcType == 2) {
                        yVar.kAo = 3;
                    } else if (this.lKS.baijiahaoData.oriUgcType == 4) {
                        yVar.kAo = 2;
                    }
                }
                yVar.kAm = this.lKS.mRecomWeight;
                if (this.mRect != null) {
                    yVar.kAr = "1";
                } else {
                    yVar.kAr = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    yVar.kAs = "1";
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    yVar.kAn = this.mFromPage;
                    yVar.dCp = this.dCp;
                    yVar.kAl = this.lKS.mRecomWeight;
                } else {
                    yVar.mLocate = "14";
                }
                this.fbO.setVideoStatsData(yVar);
                this.fbO.kzn = true;
            }
            this.kwT.setContinuePlayEnable(true);
            this.kwT.setBusiness(this.fbO);
        }
    }

    private void dlw() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.kwT.setOnPreparedListener(this.lLk);
        }
        this.kwT.setOnCompletionListener(this.lLj);
        this.kwT.setOnOutInfoListener(this.lLi);
    }
}
