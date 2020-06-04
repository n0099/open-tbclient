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
    private boolean fEQ;
    private n fbZ;
    private AlphaAnimation feT;
    private View gOs;
    private int hpg;
    private boolean isNewPlayer;
    public com.baidu.tieba.play.a.a kxZ;
    private j.b kyV;
    private QuickVideoView.c kzn;
    private TbImageView lLI;
    public ImageView lLJ;
    public HeadImageView lLK;
    public LinearLayout lLL;
    public LinearLayout lLM;
    public LinearLayout lLN;
    public ImageView lLO;
    public ImageView lLP;
    public ImageView lLQ;
    public ExpandableTextView lLR;
    public TextView lLS;
    public TextView lLT;
    public TextView lLU;
    public TextView lLV;
    public ImageView lLW;
    private LinearLayout lLX;
    public LinearLayout lLY;
    public LinearLayout lLZ;
    public VideoItemData lMa;
    private TextView lMb;
    public ImageView lMc;
    public TextView lMd;
    private View lMe;
    private TextView lMf;
    private int lMg;
    private int lMh;
    private com.baidu.tieba.view.a lMi;
    protected Animation lMj;
    private boolean lMk;
    private AnimatorSet lMl;
    private RelativeLayout.LayoutParams lMm;
    private com.baidu.tieba.videoplay.editor.a lMo;
    com.baidu.tbadk.core.dialog.a lMp;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int lLG = 0;
    private int lLH = 1;
    private ForumManageModel gFg = null;
    private com.baidu.tbadk.baseEditMark.a jLD = null;
    private com.baidu.tbadk.coreExtra.model.a dNL = null;
    private BdUniqueId afZ = BdUniqueId.gen();
    private boolean lMn = false;
    private int playTime = 1;
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.lMa != null && VideoPlayFragment.this.lMa.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.lMa.author_info.user_id) && data != null && VideoPlayFragment.this.lMa.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.afZ)) ? false : false;
                    if (data.ecK == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.lMa.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.lMa.author_info.is_follow = "0";
                                VideoPlayFragment.this.dlE();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.djy) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.lMa));
                                    return;
                                }
                                VideoPlayFragment.this.lMa.author_info.is_follow = "1";
                                VideoPlayFragment.this.dlE();
                            }
                        } else {
                            VideoPlayFragment.this.lMa.author_info.is_follow = "0";
                            VideoPlayFragment.this.dlE();
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
                VideoPlayFragment.this.dlG();
            }
        }
    };
    private CustomMessageListener dRK = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.lMa != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.lMa.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.lMa.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.lMa.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.lMa.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dlD();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.lMa.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.lMa.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.lMa.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dlD();
                    }
                }
            }
        }
    };
    private g.e lMq = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.djy) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.lLI.getVisibility() == 0) {
                    VideoPlayFragment.this.lLI.clearAnimation();
                    VideoPlayFragment.this.lLI.startAnimation(VideoPlayFragment.this.feT);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a lMr = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.kxZ != null) {
                VideoPlayFragment.this.kxZ.cQZ();
                VideoPlayFragment.this.kxZ.seekTo(0);
                VideoPlayFragment.this.kxZ.start();
                VideoPlayFragment.this.bLa();
                VideoPlayFragment.z(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dlx();
                }
            }
        }
    };
    private g.f lMs = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            if (VideoPlayFragment.this.kxZ != null) {
                VideoPlayFragment.this.kxZ.setVolume(1.0f, 1.0f);
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
        this.lMa = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.lMh = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.dCp = arguments.getString("obj_id");
        if (this.lMa != null && this.lMa.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.lMa.author_info.user_id)) {
            this.fEQ = true;
        }
        this.fbZ = new n(getActivity());
        this.fbZ.a(this.lMa);
        this.fbZ.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.j.b
            public void bI(int i, int i2) {
                if (VideoPlayFragment.this.kyV != null) {
                    VideoPlayFragment.this.kyV.bI(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.uD("cyber_player_test") || b.uC("cyber_player_test");
        this.kxZ = com.baidu.tieba.play.a.b.A(getContext(), this.isNewPlayer ? 1 : 0);
        dlK();
        this.lLI = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.lLI.setPlaceHolder(4);
        this.lLI.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aUh()) {
            this.gOs = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.gOs.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.gOs.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.atr = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.lLJ = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.lLK = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.lLK.setDefaultResource(17170445);
        this.lLK.setPlaceHolder(2);
        this.lLK.setIsRound(true);
        this.lLO = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.lMc = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.lLR = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.lLS = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.lLM = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.lLT = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.lLL = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.lLU = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.lLV = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.lLP = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.lLQ = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dly();
        this.lLW = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.lLX = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.lLY = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.lLZ = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.lLN = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.lMd = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.lMe = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.lMe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.lMe.setVisibility(4);
                    if (VideoPlayFragment.this.lMo != null && VideoPlayFragment.this.lMo.bcX() != null) {
                        VideoPlayFragment.this.lMo.bcX().display();
                        if (VideoPlayFragment.this.lMa != null) {
                            VideoPlayFragment.this.lMo.c(VideoPlayFragment.this.lMa);
                        }
                    }
                    if (VideoPlayFragment.this.lMa != null) {
                        an anVar = new an("c13025");
                        anVar.dh("tid", VideoPlayFragment.this.lMa.thread_id);
                        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.dh("fid", VideoPlayFragment.this.lMa.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.lMf = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.lMb = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.lMb.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.lMb.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_download_link_url", null);
        this.lMb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aVa().a((TbPageContext) i.G(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dlC();
        this.lLK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.lMa != null && VideoPlayFragment.this.lMa.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.lMa.author_info.user_id) && VideoPlayFragment.this.lMa != null && VideoPlayFragment.this.lMa.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.lMa.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.dh("tid", VideoPlayFragment.this.lMa.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.lLY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.lMa != null && VideoPlayFragment.this.lMa.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.lMa.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.dh("tid", VideoPlayFragment.this.lMa.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.lLR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dlA();
            }
        });
        this.atr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.lMa != null && !StringUtils.isNull(VideoPlayFragment.this.lMa.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.lMa.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.lLJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dlB();
            }
        });
        this.lLM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.lMa)) {
                    VideoPlayFragment.this.dlA();
                    an anVar = new an("c12796");
                    anVar.dh("tid", VideoPlayFragment.this.lMa.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.lLL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Fm(VideoPlayFragment.this.lLG);
            }
        });
        this.lLN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aWJ();
                an anVar = new an("c12797");
                anVar.dh("tid", VideoPlayFragment.this.lMa.thread_id);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.dh("tid", VideoPlayFragment.this.lMa.thread_id);
                anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.ag("obj_locate", 19);
                anVar2.dh("nid", VideoPlayFragment.this.lMa.nid);
                if (VideoPlayFragment.this.lMa.baijiahaoData != null && !aq.isEmpty(VideoPlayFragment.this.lMa.baijiahaoData.oriUgcVid)) {
                    anVar2.dh("obj_param6", VideoPlayFragment.this.lMa.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.lMa.getVideoType() == 1) {
                    anVar2.ag(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.lMa.getVideoType() == 2) {
                    anVar2.ag(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.lMa.getVideoType() == 3) {
                    anVar2.ag(IntentConfig.CARD_TYPE, 6);
                }
                anVar2.dh(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.lMa.mRecomSource);
                anVar2.dh("ab_tag", VideoPlayFragment.this.lMa.mRecomAbTag);
                anVar2.dh("weight", VideoPlayFragment.this.lMa.mRecomWeight);
                anVar2.dh("extra", VideoPlayFragment.this.lMa.mRecomExtra);
                anVar2.dh("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                TiebaStatic.log(anVar2);
            }
        });
        this.lLO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.lMa != null && VideoPlayFragment.this.lMa.author_info != null) {
                    VideoPlayFragment.this.dNL.a(true, VideoPlayFragment.this.lMa.author_info.portrait, VideoPlayFragment.this.lMa.author_info.user_id, false, "6", VideoPlayFragment.this.afZ, VideoPlayFragment.this.lMa.forum_id, "0");
                    VideoPlayFragment.this.lMa.author_info.is_follow = "1";
                    VideoPlayFragment.this.dlE();
                }
            }
        });
        this.feT = new AlphaAnimation(1.0f, 0.0f);
        this.feT.setDuration(100L);
        this.feT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.lLI != null) {
                    VideoPlayFragment.this.lLI.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.lMg = this.mRect.right - this.mRect.left;
            this.hpg = this.mRect.bottom - this.mRect.top;
            this.lLI.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.lLI.getWidth();
                    int height = VideoPlayFragment.this.lLI.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lMa.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lMa.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lMa.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lMa.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.lMg, VideoPlayFragment.this.hpg);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.lLI.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hpg > 0 || VideoPlayFragment.this.lMg <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.lMg;
                                f = i / VideoPlayFragment.this.hpg;
                            }
                            VideoPlayFragment.this.lLI.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.lLI.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
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
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.lMg, VideoPlayFragment.this.hpg);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.lLI.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hpg > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.lLI.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.lLI.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
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
            this.lLI.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.lLI.getWidth();
                    int height = VideoPlayFragment.this.lLI.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lMa.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lMa.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lMa.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lMa.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.lLI.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.lLI.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cxG();
        if (this.djy) {
            dlz();
        }
        if (this.lMa != null && !StringUtils.isNull(this.lMa.video_url)) {
            setVideoInfo(this.lMa.video_url);
        }
        return this.mRootView;
    }

    public boolean cQi() {
        return !this.isNewPlayer && (this.kxZ instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.kyV = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.kzn = cVar;
    }

    private void cxG() {
        this.lMo = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dN(getActivity());
        if (this.lMo != null && this.lMa != null) {
            this.lMo.a(getPageContext());
            this.lMo.az(this.lMa.thread_id, this.lMa.forum_id, this.lMa.forum_name);
            this.lMo.a(new a.InterfaceC0745a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0745a
                public void vf(boolean z) {
                    VideoPlayFragment.this.lMe.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.lMf.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.lMf.setText(StringUtils.isNull(((c) VideoPlayFragment.this.lMo.bcX().nh(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.lMa != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.lMa.comment_num, 0L) + 1;
                        VideoPlayFragment.this.lMa.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.lLT.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.lMo.bcX(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWJ() {
        String str;
        String str2;
        if (this.lMa != null) {
            String str3 = this.lMa.forum_id;
            String str4 = this.lMa.forum_name;
            String str5 = this.lMa.title;
            if (this.lMa.baijiahaoData != null) {
                str = this.lMa.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.lMa.baijiahaoData.oriUgcType + "&dvid=" + this.lMa.baijiahaoData.oriUgcVid + "&nid=" + this.lMa.baijiahaoData.oriUgcNid;
            } else {
                str = this.lMa.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.lMa.thumbnail_url;
            String format = (!this.lMa.isBjhVideo || this.lMa.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.lMa.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.lMa.baijiahaoData == null) {
                shareItem.readCount = this.lMa.play_count;
            }
            if (this.lMa.isBjhVideo) {
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
            if (this.lMa.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.lMa.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.lMa.title;
            originalThreadInfo.threadId = this.lMa.thread_id;
            originalThreadInfo.oriUgcInfo = this.lMa.baijiahaoData;
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
            com.baidu.tieba.c.e.bMy().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fEQ) {
            this.gFg = new ForumManageModel(getPageContext());
            this.gFg.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.gFg.getLoadDataMode()) {
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
        this.jLD = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.jLD != null) {
            this.jLD.a(new a.InterfaceC0471a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0471a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.jLD != null) {
                            VideoPlayFragment.this.jLD.gC(z2);
                        }
                        if (VideoPlayFragment.this.lMa != null) {
                            if (z2) {
                                VideoPlayFragment.this.lMa.mark_id = VideoPlayFragment.this.lMa.post_id;
                            } else {
                                VideoPlayFragment.this.lMa.mark_id = null;
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
            this.lMn = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dlC();
        dlL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlx() {
        if (this.lLQ != null && this.lLP != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.lLP.clearAnimation();
            this.lLQ.clearAnimation();
            this.lLP.setVisibility(8);
            this.lLQ.setVisibility(0);
            this.lLQ.startAnimation(scaleAnimation2);
            this.lLP.startAnimation(scaleAnimation);
        }
    }

    private void dly() {
        if (this.lLQ != null && this.lLP != null) {
            this.lLP.clearAnimation();
            this.lLQ.clearAnimation();
            this.lLP.setVisibility(0);
            this.lLQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.lMa != null) {
            if (i == this.lLG) {
                if ("1".equals(this.lMa.is_agreed)) {
                    i2 = 1;
                    this.lMa.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.lMa.agree_num, 0) - 1);
                    this.lMa.is_agreed = "0";
                } else {
                    this.lMa.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.lMa.agree_num, 0) + 1);
                    this.lMa.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.lMa.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.lMa.agree_num, 0) + 1);
                this.lMa.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.dh("tid", this.lMa.thread_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.lLG) {
                anVar.ag("obj_type", i2);
            } else {
                anVar.ag("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            dlC();
            if (this.lMc != null && i2 == 0) {
                this.lMc.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.lMa.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.lMa.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.lMa.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.lMa.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.lMa.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.lMa.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.lMa.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.lMa.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.lMa));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.lMa != null && !StringUtils.isNull(this.lMa.video_url)) {
            this.mHasInit = true;
            if (this.djy) {
                bLa();
                avU();
                if (this.lMa != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.dh("tid", this.lMa.thread_id);
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
        if (this.lMo != null && this.lMo.bcX() != null) {
            this.lMo.bcX().hide();
            this.lMe.setVisibility(0);
            this.lMf.setText(StringUtils.isNull(((c) this.lMo.bcX().nh(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.lMo != null) {
            this.lMo.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.djy = z;
        if (!z && this.lMo != null) {
            this.lMf.setText(R.string.reply_something);
            this.lMo.dlU();
        }
        if (this.mHasInit) {
            if (this.djy && (!this.lMn || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.lMa != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.dh("tid", this.lMa.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.ag("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                dlz();
                this.lMn = false;
                return;
            }
            dly();
            this.playTime = 1;
            avT();
        }
    }

    private void dlz() {
        if (this.lMa != null) {
            an anVar = new an("c12590");
            anVar.dh("tid", this.lMa.thread_id);
            anVar.dh("nid", this.lMa.nid);
            anVar.dh("fid", this.lMa.forum_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.ag("obj_locate", this.lMh);
            anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.dh("obj_param1", aq.isEmpty(this.lMa.mRecomWeight) ? "0" : this.lMa.mRecomWeight);
            anVar.dh("extra", aq.isEmpty(this.lMa.mRecomExtra) ? "0" : this.lMa.mRecomExtra);
            anVar.dh("obj_id", this.dCp);
            anVar.dh("ab_tag", aq.isEmpty(this.lMa.mRecomAbTag) ? "0" : this.lMa.mRecomAbTag);
            anVar.dh("obj_source", aq.isEmpty(this.lMa.mRecomSource) ? "0" : this.lMa.mRecomSource);
            anVar.dh("obj_type", this.mFromPage);
            anVar.ag("is_vertical", 1);
            if (this.lMa.baijiahaoData != null) {
                anVar.dh("obj_param4", this.lMa.baijiahaoData.oriUgcNid);
                anVar.dh("obj_param6", this.lMa.baijiahaoData.oriUgcVid);
                if (this.lMa.baijiahaoData.oriUgcType == 4) {
                    anVar.ag("obj_param5", 2);
                } else if (this.lMa.baijiahaoData.oriUgcType == 2) {
                    anVar.ag("obj_param5", 3);
                }
            } else {
                anVar.ag("obj_param5", 1);
            }
            TiebaStatic.log(anVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.kxZ != null && str != null && !str.equals(this.mVideoUrl)) {
            if (cQi()) {
                ((QuickVideoView) this.kxZ).setRecoveryState(0);
            }
            this.kxZ.setVideoPath(str, this.lMa.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dlG()) {
            cQu();
            if (this.lLW != null) {
                this.lLW.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.lLI.getVisibility() == 0) {
                this.lLI.clearAnimation();
                this.lLI.startAnimation(this.feT);
            }
            if (this.kxZ != null) {
                if (TbVideoViewSet.cRJ().KC(this.mVideoUrl) == null || TbVideoViewSet.cRJ().KC(this.mVideoUrl) != this.kxZ) {
                    this.kxZ.setVideoPath(this.mVideoUrl, this.lMa.thread_id);
                }
                this.kxZ.start();
                bLa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLa() {
        if (this.lMa != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.ais = this.lMa.thread_id;
            yVar.mNid = this.lMa.nid;
            yVar.evm = this.lMa.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.lMa.mRecomSource;
            yVar.kBr = this.lMa.mRecomAbTag;
            yVar.kBs = this.lMa.mRecomWeight;
            yVar.kBt = "";
            yVar.dCp = "";
            yVar.kBw = this.lMa.mMd5;
            if (this.mRect != null) {
                yVar.kBx = "1";
            } else {
                yVar.kBx = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.kBy = "1";
                yVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                yVar.kBt = "index";
            }
            com.baidu.tieba.play.l.a(this.lMa.mMd5, "", "1", yVar, this.kxZ.getPcdnState());
        }
    }

    private void cQu() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dhZ().fs(getContext());
        }
    }

    private void avT() {
        if (this.kxZ != null) {
            this.kxZ.pause();
        }
    }

    private void stopPlay() {
        if (this.kxZ != null) {
            if (cQi()) {
                ((QuickVideoView) this.kxZ).setRecoveryState(5);
            }
            this.kxZ.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlA() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.lMa.thread_id, this.lMa.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.lMa.forum_id));
        createNormalCfg.setForumName(this.lMa.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.lMa.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlB() {
        if (this.dyF == null) {
            this.lMi = new com.baidu.tieba.view.a(getActivity());
            this.dyF = new e(getActivity(), this.lMi.aTh());
            this.dyF.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.kxZ.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.lMi != null) {
            ArrayList arrayList = new ArrayList();
            a.C0746a c0746a = new a.C0746a(this.lMi);
            c0746a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bc.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.dyF.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.dyF.dismiss();
                    if (VideoPlayFragment.this.lMa != null) {
                        boolean z = VideoPlayFragment.this.lMa.post_id != null && VideoPlayFragment.this.lMa.post_id.equals(VideoPlayFragment.this.lMa.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.lMa.thread_id);
                        markData.setPostId(VideoPlayFragment.this.lMa.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.lMa.thread_id);
                        markData.setForumId(VideoPlayFragment.this.lMa.forum_id);
                        if (VideoPlayFragment.this.jLD != null) {
                            VideoPlayFragment.this.jLD.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.jLD.aMN();
                            } else {
                                VideoPlayFragment.this.jLD.aMM();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.lMa != null && this.lMa.post_id != null && this.lMa.post_id.equals(this.lMa.mark_id)) {
                z = true;
            }
            if (z) {
                c0746a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0746a.setText(getResources().getString(R.string.mark));
            }
            if (this.lMa != null && !this.lMa.isBjhVideo) {
                arrayList.add(c0746a);
            }
            a.C0746a c0746a2 = new a.C0746a(getActivity().getString(R.string.delete), this.lMi);
            c0746a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.dyF.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.lMa != null) {
                        String str = VideoPlayFragment.this.lMa.thread_id;
                        String str2 = VideoPlayFragment.this.lMa.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.lMa.post_id;
                        if (VideoPlayFragment.this.lMa.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.lMa.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.lMa.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0746a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0746a2);
            if (this.fEQ) {
                a.C0746a c0746a3 = new a.C0746a(getActivity().getString(R.string.delete), this.lMi);
                c0746a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.dyF.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.kF(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.lMa != null) {
                                    VideoPlayFragment.this.gFg.a(VideoPlayFragment.this.lMa.forum_id, VideoPlayFragment.this.lMa.forum_name, VideoPlayFragment.this.lMa.thread_id, VideoPlayFragment.this.lMa.post_id, 0, 0, VideoPlayFragment.this.fEQ, null);
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
                c0746a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0746a3);
            }
            this.lMi.aD(arrayList);
        }
        this.dyF.show();
    }

    private void dlC() {
        if (this.lMa != null) {
            this.lLI.startLoad(this.lMa.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.lMa.title);
            if (StringUtils.isNull(this.lMa.title) || matcher.matches()) {
                this.lLR.setVisibility(8);
            } else {
                this.lLR.setVisibility(0);
                this.lLR.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.lLR.setTextColor(R.color.cp_cont_a);
                this.lLR.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.lLR.setExpandable(true);
                this.lLR.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void nR(boolean z) {
                        VideoPlayFragment.this.lMa.isTitleExpanded = z;
                    }
                });
                this.lLR.setData(this.lMa.title, this.lMa.isTitleExpanded);
            }
            this.lLT.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lMa.comment_num, 0L)));
            this.lLU.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lMa.agree_num, 0L)));
            this.lLV.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lMa.share_num, 0L)));
            if (this.lMa.author_info != null) {
                if (!TextUtils.isEmpty(this.lMa.author_info.bjhAvatar)) {
                    this.lLK.startLoad(this.lMa.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.lMa.author_info.portrait) && this.lMa.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.lLK.startLoad(this.lMa.author_info.portrait, 10, false);
                } else {
                    this.lLK.startLoad(this.lMa.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.lMa.author_info.dhV())) {
                    this.lMd.setVisibility(8);
                } else {
                    this.lMd.setVisibility(0);
                    this.lMd.setText(UgcConstant.AT_RULE_TAG + this.lMa.author_info.dhV());
                }
            }
            if ("1".equals(this.lMa.is_private) && this.lMb.getVisibility() != 0) {
                this.lLZ.setVisibility(0);
            } else {
                this.lLZ.setVisibility(8);
            }
            if ("1".equals(this.lMa.is_agreed)) {
                am.setImageResource(this.lMc, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.lMc, R.drawable.btn_video_agree);
            }
            if (this.lMa.act_info != null && !StringUtils.isNull(this.lMa.act_info.activity_name) && this.lMb.getVisibility() != 0) {
                this.lLY.setVisibility(0);
                this.lLS.setText(this.lMa.act_info.activity_name);
            } else {
                this.lLY.setVisibility(8);
            }
            dlE();
            if (this.lMa.isBjhVideo) {
                this.lLJ.setVisibility(8);
            } else {
                this.lLJ.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlD() {
        if (this.lMa != null) {
            if ("1".equals(this.lMa.is_agreed)) {
                am.setImageResource(this.lMc, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.lMc, R.drawable.btn_video_agree);
            }
            this.lLU.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lMa.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlE() {
        if (this.fEQ || (this.lMa.author_info != null && !"0".equals(this.lMa.author_info.is_follow))) {
            this.lLO.setVisibility(4);
            this.lLO.setClickable(false);
            return;
        }
        this.lLO.setVisibility(0);
        this.lLO.setClickable(true);
    }

    private void dlF() {
        if (getActivity() != null) {
            if (this.lMp == null || !this.lMp.isShowing()) {
                this.lMp = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.aUW().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.lMp.aP(inflate);
                this.lMp.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.lMp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.lMp.kI(1);
                this.lMp.kG(R.color.cp_cont_b);
                this.lMp.gW(true);
                this.lMp.b(getPageContext());
                this.lMp.aST();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dlG() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dhZ().dia() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !com.baidu.adp.lib.util.j.isMobileNet() || !this.djy) {
            return false;
        }
        if (this.lLW != null) {
            this.lLW.setVisibility(0);
        }
        avT();
        dlF();
        return true;
    }

    private void avU() {
        if (!dlG() && this.kxZ != null && this.lLW != null && this.lMa != null) {
            if (this.kxZ.getParent() == null) {
                dlK();
                dlL();
            }
            if (TbVideoViewSet.cRJ().KC(this.mVideoUrl) == null || TbVideoViewSet.cRJ().KC(this.mVideoUrl) != this.kxZ) {
                this.kxZ.setVideoPath(this.mVideoUrl, this.lMa.thread_id);
            }
            this.kxZ.b(null);
            this.lLW.setVisibility(8);
            cQu();
            if (this.kzn != null) {
                this.kzn.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.lMj == null) {
            this.lMj = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.lMj;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0500a
    public void bjL() {
        if (this.kxZ.isPlaying()) {
            this.kxZ.pause();
            this.lLW.setVisibility(0);
        } else if (!dlG()) {
            this.kxZ.start();
            this.lLW.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0500a
    public void t(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.lMk) {
            dlH();
            if (this.lMa != null && "0".equals(this.lMa.is_agreed)) {
                Fm(this.lLH);
            }
        }
    }

    private void dlH() {
        if (this.mRootView != null) {
            this.lMk = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.lMm == null) {
                this.lMm = new RelativeLayout.LayoutParams(-2, -2);
                this.lMm.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.lMm);
            }
            if (this.lMl == null) {
                this.lMl = new AnimatorSet();
                this.lMl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.lMk = false;
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
            this.lMl.setTarget(imageView);
            this.lMl.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.lMl.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0500a
    public void bjM() {
        if (this.lMa != null && this.lMa.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.lMa.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cQi()) {
            return ((QuickVideoView) this.kxZ).getMediaIDs();
        }
        return null;
    }

    public String dlI() {
        if (cQi()) {
            return ((QuickVideoView) this.kxZ).getMediaId();
        }
        return null;
    }

    public boolean dlJ() {
        if (this.lMo == null || this.lMo.bcX() == null || !this.lMo.bcX().isVisible()) {
            return false;
        }
        this.lMo.bcX().hide();
        this.lMe.setVisibility(0);
        if ((this.lMo.bcX().nh(28) instanceof c) && ((c) this.lMo.bcX().nh(28)).getInputView() != null && ((c) this.lMo.bcX().nh(28)).getInputView().getText() != null) {
            this.lMf.setText(StringUtils.isNull(((c) this.lMo.bcX().nh(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.lMo != null) {
            this.lMo.onActivityResult(i, i2, intent);
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
        if (this.lMo != null && this.lMo.bcX() != null) {
            this.lMo.bcX().onChangeSkinType(i);
        }
        SvgManager.aUW().a(this.atr, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dlK() {
        if (this.kxZ != null && this.kxZ.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.kxZ.getView(), 0);
            this.kxZ.getView().setLayoutParams(layoutParams);
            if (cQi()) {
                ((QuickVideoView) this.kxZ).setNeedRecovery(true);
            }
            if (this.lMa != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.ais = this.lMa.thread_id;
                yVar.mNid = this.lMa.nid;
                yVar.evm = this.lMa.forum_id;
                yVar.kBw = this.lMa.mMd5;
                yVar.dCp = "";
                yVar.mSource = this.lMa.mRecomSource;
                yVar.kBv = this.lMa.mRecomAbTag;
                yVar.kBu = 1;
                if (this.lMa.baijiahaoData != null) {
                    if (this.lMa.baijiahaoData.oriUgcType == 2) {
                        yVar.kBu = 3;
                    } else if (this.lMa.baijiahaoData.oriUgcType == 4) {
                        yVar.kBu = 2;
                    }
                }
                yVar.kBs = this.lMa.mRecomWeight;
                if (this.mRect != null) {
                    yVar.kBx = "1";
                } else {
                    yVar.kBx = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    yVar.kBy = "1";
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    yVar.kBt = this.mFromPage;
                    yVar.dCp = this.dCp;
                    yVar.kBr = this.lMa.mRecomWeight;
                } else {
                    yVar.mLocate = "14";
                }
                this.fbZ.setVideoStatsData(yVar);
                this.fbZ.kAt = true;
            }
            this.kxZ.setContinuePlayEnable(true);
            this.kxZ.setBusiness(this.fbZ);
        }
    }

    private void dlL() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.kxZ.setOnPreparedListener(this.lMs);
        }
        this.kxZ.setOnCompletionListener(this.lMr);
        this.kxZ.setOnOutInfoListener(this.lMq);
    }
}
