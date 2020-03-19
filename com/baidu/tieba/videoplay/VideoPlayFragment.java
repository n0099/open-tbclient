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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0400a {
    public ImageView Wq;
    private e cLt;
    private String cPf;
    private boolean eMo;
    private n elC;
    private AlphaAnimation eoy;
    private View fUC;
    private boolean isNewPlayer;
    public com.baidu.tieba.play.a.a jvf;
    private j.b jwb;
    private QuickVideoView.c jwt;
    private TbImageView kHL;
    public ImageView kHM;
    public HeadImageView kHN;
    public LinearLayout kHO;
    public LinearLayout kHP;
    public LinearLayout kHQ;
    public ImageView kHR;
    public ImageView kHS;
    public ImageView kHT;
    public ExpandableTextView kHU;
    public TextView kHV;
    public TextView kHW;
    public TextView kHX;
    public TextView kHY;
    public ImageView kHZ;
    private LinearLayout kIa;
    public LinearLayout kIb;
    public LinearLayout kIc;
    public VideoItemData kId;
    private TextView kIe;
    public ImageView kIf;
    public TextView kIg;
    private View kIh;
    private TextView kIi;
    private int kIj;
    private com.baidu.tieba.view.a kIk;
    protected Animation kIl;
    private boolean kIm;
    private AnimatorSet kIn;
    private RelativeLayout.LayoutParams kIo;
    private com.baidu.tieba.videoplay.editor.a kIq;
    com.baidu.tbadk.core.dialog.a kIr;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private boolean mIsVisible;
    private int mOriginHeight;
    private int mOriginWidth;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int kHJ = 0;
    private int kHK = 1;
    private ForumManageModel fLt = null;
    private com.baidu.tbadk.baseEditMark.a iJo = null;
    private com.baidu.tbadk.coreExtra.model.a dap = null;
    private BdUniqueId MP = BdUniqueId.gen();
    private boolean kIp = false;
    private int playTime = 1;
    private CustomMessageListener dat = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.kId != null && VideoPlayFragment.this.kId.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kId.author_info.user_id) && data != null && VideoPlayFragment.this.kId.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.MP)) ? false : false;
                    if (data.dow == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.kId.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.kId.author_info.is_follow = "0";
                                VideoPlayFragment.this.cTq();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.kId));
                                    return;
                                }
                                VideoPlayFragment.this.kId.author_info.is_follow = "1";
                                VideoPlayFragment.this.cTq();
                            }
                        } else {
                            VideoPlayFragment.this.kId.author_info.is_follow = "0";
                            VideoPlayFragment.this.cTq();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener cLK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.cTr();
            }
        }
    };
    private CustomMessageListener ddV = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.kId != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.kId.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.kId.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.kId.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.kId.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.cTp();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.kId.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.kId.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.kId.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.cTp();
                    }
                }
            }
        }
    };
    private g.e kIs = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.mIsVisible) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.kHL.getVisibility() == 0) {
                    VideoPlayFragment.this.kHL.clearAnimation();
                    VideoPlayFragment.this.kHL.startAnimation(VideoPlayFragment.this.eoy);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a kIt = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.jvf != null) {
                VideoPlayFragment.this.jvf.czh();
                VideoPlayFragment.this.jvf.seekTo(0);
                VideoPlayFragment.this.jvf.start();
                VideoPlayFragment.this.buU();
                VideoPlayFragment.z(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.cTj();
                }
            }
        }
    };
    private g.f kIu = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            if (VideoPlayFragment.this.jvf != null) {
                VideoPlayFragment.this.jvf.setVolume(1.0f, 1.0f);
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
        registerListener(this.ddV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.kId = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.kIj = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.cPf = arguments.getString("obj_id");
        if (this.kId != null && this.kId.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.kId.author_info.user_id)) {
            this.eMo = true;
        }
        this.elC = new n(getActivity());
        this.elC.a(this.kId);
        this.elC.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.j.b
            public void bz(int i, int i2) {
                if (VideoPlayFragment.this.jwb != null) {
                    VideoPlayFragment.this.jwb.bz(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.rH("cyber_player_test") || b.rG("cyber_player_test");
        this.jvf = com.baidu.tieba.play.a.b.F(getContext(), this.isNewPlayer ? 1 : 0);
        cTv();
        this.kHL = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.kHL.setPlaceHolder(4);
        this.kHL.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aFR()) {
            this.fUC = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.fUC.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.fUC.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.Wq = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.kHM = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.kHN = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.kHN.setDefaultResource(17170445);
        this.kHN.setPlaceHolder(2);
        this.kHN.setIsRound(true);
        this.kHR = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.kIf = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.kHU = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.kHV = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.kHP = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.kHW = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.kHO = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.kHX = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.kHY = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.kHS = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.kHT = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cTk();
        this.kHZ = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.kIa = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.kIb = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.kIc = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.kHQ = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.kIg = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.kIh = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.kIh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.kIh.setVisibility(4);
                    if (VideoPlayFragment.this.kIq != null && VideoPlayFragment.this.kIq.aOy() != null) {
                        VideoPlayFragment.this.kIq.aOy().display();
                        if (VideoPlayFragment.this.kId != null) {
                            VideoPlayFragment.this.kIq.c(VideoPlayFragment.this.kId);
                        }
                    }
                    if (VideoPlayFragment.this.kId != null) {
                        an anVar = new an("c13025");
                        anVar.cx("tid", VideoPlayFragment.this.kId.thread_id);
                        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.cx("fid", VideoPlayFragment.this.kId.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.kIi = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.kIe = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.kIe.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.kIe.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aFH().getString("nani_key_download_link_url", null);
        this.kIe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aGK().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cTo();
        this.kHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kId != null && VideoPlayFragment.this.kId.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kId.author_info.user_id) && VideoPlayFragment.this.kId != null && VideoPlayFragment.this.kId.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kId.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.cx("tid", VideoPlayFragment.this.kId.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kIb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kId != null && VideoPlayFragment.this.kId.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.kId.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.cx("tid", VideoPlayFragment.this.kId.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kHU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cTm();
            }
        });
        this.Wq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kId != null && !StringUtils.isNull(VideoPlayFragment.this.kId.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.kId.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.kHM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cTn();
            }
        });
        this.kHP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.kId)) {
                    VideoPlayFragment.this.cTm();
                    an anVar = new an("c12796");
                    anVar.cx("tid", VideoPlayFragment.this.kId.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kHO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.DX(VideoPlayFragment.this.kHJ);
            }
        });
        this.kHQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aIh();
                an anVar = new an("c12797");
                anVar.cx("tid", VideoPlayFragment.this.kId.thread_id);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cx("tid", VideoPlayFragment.this.kId.thread_id);
                anVar2.cx("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.X("obj_locate", 19);
                TiebaStatic.log(anVar2);
            }
        });
        this.kHR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kId != null && VideoPlayFragment.this.kId.author_info != null) {
                    VideoPlayFragment.this.dap.a(true, VideoPlayFragment.this.kId.author_info.portrait, VideoPlayFragment.this.kId.author_info.user_id, false, "6", VideoPlayFragment.this.MP, VideoPlayFragment.this.kId.forum_id, "0");
                    VideoPlayFragment.this.kId.author_info.is_follow = "1";
                    VideoPlayFragment.this.cTq();
                }
            }
        });
        this.eoy = new AlphaAnimation(1.0f, 0.0f);
        this.eoy.setDuration(100L);
        this.eoy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.kHL != null) {
                    VideoPlayFragment.this.kHL.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mOriginWidth = this.mRect.right - this.mRect.left;
            this.mOriginHeight = this.mRect.bottom - this.mRect.top;
            this.kHL.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.kHL.getWidth();
                    int height = VideoPlayFragment.this.kHL.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kId.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kId.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kId.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kId.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mOriginWidth, VideoPlayFragment.this.mOriginHeight);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.kHL.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.mOriginHeight > 0 || VideoPlayFragment.this.mOriginWidth <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mOriginWidth;
                                f = i / VideoPlayFragment.this.mOriginHeight;
                            }
                            VideoPlayFragment.this.kHL.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.kHL.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.mIsVisible) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mOriginWidth, VideoPlayFragment.this.mOriginHeight);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.kHL.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.mOriginHeight > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.kHL.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.kHL.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.mIsVisible) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.kHL.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.kHL.getWidth();
                    int height = VideoPlayFragment.this.kHL.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kId.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kId.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kId.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kId.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.kHL.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.kHL.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cgh();
        if (this.mIsVisible) {
            cTl();
        }
        if (this.kId != null && !StringUtils.isNull(this.kId.video_url)) {
            KD(this.kId.video_url);
        }
        return this.mRootView;
    }

    public boolean cyq() {
        return !this.isNewPlayer && (this.jvf instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.jwb = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.jwt = cVar;
    }

    private void cgh() {
        this.kIq = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dU(getActivity());
        if (this.kIq != null && this.kId != null) {
            this.kIq.a(getPageContext());
            this.kIq.aw(this.kId.thread_id, this.kId.forum_id, this.kId.forum_name);
            this.kIq.a(new a.InterfaceC0629a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0629a
                public void tF(boolean z) {
                    VideoPlayFragment.this.kIh.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.kIi.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.kIi.setText(StringUtils.isNull(((c) VideoPlayFragment.this.kIq.aOy().mr(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.kId != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kId.comment_num, 0L) + 1;
                        VideoPlayFragment.this.kId.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.kHW.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.kIq.aOy(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIh() {
        String str;
        String str2;
        if (this.kId != null) {
            String str3 = this.kId.forum_id;
            String str4 = this.kId.forum_name;
            String str5 = this.kId.title;
            if (this.kId.baijiahaoData != null) {
                str = this.kId.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.kId.baijiahaoData.oriUgcType + "&dvid=" + this.kId.baijiahaoData.oriUgcVid + "&nid=" + this.kId.baijiahaoData.oriUgcNid;
            } else {
                str = this.kId.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.kId.thumbnail_url;
            String format = (!this.kId.isBjhVideo || this.kId.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.kId.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.kId.baijiahaoData == null) {
                shareItem.readCount = this.kId.play_count;
            }
            if (this.kId.isBjhVideo) {
                shareItem.dqC = format;
            } else {
                shareItem.dqC = "";
            }
            shareItem.linkUrl = str6;
            shareItem.cUP = 2;
            shareItem.extData = str;
            shareItem.dqF = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.dqs = true;
            shareItem.dqE = 12;
            shareItem.dqJ = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.kId.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.kId.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.kId.title;
            originalThreadInfo.threadId = this.kId.thread_id;
            originalThreadInfo.oriUgcInfo = this.kId.baijiahaoData;
            shareItem.dqM = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqF);
            bundle.putInt("obj_type", shareItem.dqJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUP);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.e.bws().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eMo) {
            this.fLt = new ForumManageModel(getPageContext());
            this.fLt.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.fLt.getLoadDataMode()) {
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
        this.iJo = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.iJo != null) {
            this.iJo.a(new a.InterfaceC0374a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.iJo != null) {
                            VideoPlayFragment.this.iJo.fn(z2);
                        }
                        if (VideoPlayFragment.this.kId != null) {
                            if (z2) {
                                VideoPlayFragment.this.kId.mark_id = VideoPlayFragment.this.kId.post_id;
                            } else {
                                VideoPlayFragment.this.kId.mark_id = null;
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
        this.dap = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.dat);
        registerListener(this.cLK);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.kIp = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cTo();
        cTw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTj() {
        if (this.kHT != null && this.kHS != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.kHS.clearAnimation();
            this.kHT.clearAnimation();
            this.kHS.setVisibility(8);
            this.kHT.setVisibility(0);
            this.kHT.startAnimation(scaleAnimation2);
            this.kHS.startAnimation(scaleAnimation);
        }
    }

    private void cTk() {
        if (this.kHT != null && this.kHS != null) {
            this.kHS.clearAnimation();
            this.kHT.clearAnimation();
            this.kHS.setVisibility(0);
            this.kHT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DX(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.kId != null) {
            if (i == this.kHJ) {
                if ("1".equals(this.kId.is_agreed)) {
                    i2 = 1;
                    this.kId.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kId.agree_num, 0) - 1);
                    this.kId.is_agreed = "0";
                } else {
                    this.kId.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kId.agree_num, 0) + 1);
                    this.kId.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.kId.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kId.agree_num, 0) + 1);
                this.kId.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.cx("tid", this.kId.thread_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.kHJ) {
                anVar.X("obj_type", i2);
            } else {
                anVar.X("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            cTo();
            if (this.kIf != null && i2 == 0) {
                this.kIf.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.kId.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.kId.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.kId.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.kId.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.kId.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.kId.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.kId.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.kId.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.kId));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.kId != null && !StringUtils.isNull(this.kId.video_url)) {
            this.mHasInit = true;
            if (this.mIsVisible) {
                buU();
                akd();
                if (this.kId != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.cx("tid", this.kId.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.X("obj_type", 0);
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            pausePlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        pausePlay();
        if (this.kIq != null && this.kIq.aOy() != null) {
            this.kIq.aOy().hide();
            this.kIh.setVisibility(0);
            this.kIi.setText(StringUtils.isNull(((c) this.kIq.aOy().mr(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        MessageManager.getInstance().unRegisterListener(this.ddV);
        if (this.kIq != null) {
            this.kIq.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisible = z;
        if (!z && this.kIq != null) {
            this.kIi.setText(R.string.reply_something);
            this.kIq.cTF();
        }
        if (this.mHasInit) {
            if (this.mIsVisible && (!this.kIp || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.kId != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.cx("tid", this.kId.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.X("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                cTl();
                this.kIp = false;
                return;
            }
            cTk();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cTl() {
        if (this.kId != null) {
            an anVar = new an("c12590");
            anVar.cx("tid", this.kId.thread_id);
            anVar.cx("fid", this.kId.forum_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.X("obj_locate", this.kIj);
            anVar.X(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cx("obj_param1", aq.isEmpty(this.kId.mRecomWeight) ? "0" : this.kId.mRecomWeight);
            anVar.cx("extra", aq.isEmpty(this.kId.mRecomExtra) ? "0" : this.kId.mRecomExtra);
            anVar.cx("obj_id", this.cPf);
            anVar.cx(TiebaInitialize.Params.AB_TAG, aq.isEmpty(this.kId.mRecomAbTag) ? "0" : this.kId.mRecomAbTag);
            anVar.cx("obj_source", aq.isEmpty(this.kId.mRecomSource) ? "0" : this.kId.mRecomSource);
            anVar.cx("obj_type", this.mFromPage);
            anVar.X("is_vertical", 1);
            if (this.kId.baijiahaoData != null) {
                anVar.cx("obj_param4", this.kId.baijiahaoData.oriUgcNid);
                anVar.cx("obj_param6", this.kId.baijiahaoData.oriUgcVid);
                if (this.kId.baijiahaoData.oriUgcType == 4) {
                    anVar.X("obj_param5", 2);
                } else if (this.kId.baijiahaoData.oriUgcType == 2) {
                    anVar.X("obj_param5", 3);
                }
            } else {
                anVar.X("obj_param5", 1);
            }
            TiebaStatic.log(anVar);
        }
    }

    private void KD(String str) {
        if (this.jvf != null && str != null && !str.equals(this.mVideoUrl)) {
            if (cyq()) {
                ((QuickVideoView) this.jvf).setRecoveryState(0);
            }
            this.jvf.setVideoPath(str, this.kId.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!cTr()) {
            cyC();
            if (this.kHZ != null) {
                this.kHZ.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.kHL.getVisibility() == 0) {
                this.kHL.clearAnimation();
                this.kHL.startAnimation(this.eoy);
            }
            if (this.jvf != null) {
                this.jvf.start();
                buU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        if (this.kId != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.Pk = this.kId.thread_id;
            yVar.emF = this.kId.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.kId.mRecomSource;
            yVar.jyr = this.kId.mRecomAbTag;
            yVar.jys = this.kId.mRecomWeight;
            yVar.jyt = "";
            yVar.cPf = "";
            yVar.jyv = this.kId.mMd5;
            if (this.mRect != null) {
                yVar.jyw = "1";
            } else {
                yVar.jyw = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.jyx = "1";
                yVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                yVar.jyt = "index";
            }
            com.baidu.tieba.play.l.a(this.kId.mMd5, "", "1", yVar);
        }
    }

    private void cyC() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cPC().fx(getContext());
        }
    }

    private void pausePlay() {
        if (this.jvf != null) {
            this.jvf.pause();
        }
    }

    private void stopPlay() {
        if (this.jvf != null) {
            if (cyq()) {
                ((QuickVideoView) this.jvf).setRecoveryState(5);
            }
            this.jvf.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTm() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.kId.thread_id, this.kId.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.kId.forum_id));
        createNormalCfg.setForumName(this.kId.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.kId.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTn() {
        if (this.cLt == null) {
            this.kIk = new com.baidu.tieba.view.a(getActivity());
            this.cLt = new e(getActivity(), this.kIk.aEV());
            this.cLt.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.jvf.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.kIk != null) {
            ArrayList arrayList = new ArrayList();
            a.C0630a c0630a = new a.C0630a(this.kIk);
            c0630a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bc.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.cLt.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.cLt.dismiss();
                    if (VideoPlayFragment.this.kId != null) {
                        boolean z = VideoPlayFragment.this.kId.post_id != null && VideoPlayFragment.this.kId.post_id.equals(VideoPlayFragment.this.kId.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.kId.thread_id);
                        markData.setPostId(VideoPlayFragment.this.kId.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.kId.thread_id);
                        markData.setForumId(VideoPlayFragment.this.kId.forum_id);
                        if (VideoPlayFragment.this.iJo != null) {
                            VideoPlayFragment.this.iJo.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.iJo.ayQ();
                            } else {
                                VideoPlayFragment.this.iJo.ayP();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.kId != null && this.kId.post_id != null && this.kId.post_id.equals(this.kId.mark_id)) {
                z = true;
            }
            if (z) {
                c0630a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0630a.setText(getResources().getString(R.string.mark));
            }
            if (this.kId != null && !this.kId.isBjhVideo) {
                arrayList.add(c0630a);
            }
            a.C0630a c0630a2 = new a.C0630a(getActivity().getString(R.string.delete), this.kIk);
            c0630a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.cLt.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kId != null) {
                        String str = VideoPlayFragment.this.kId.thread_id;
                        String str2 = VideoPlayFragment.this.kId.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.kId.post_id;
                        if (VideoPlayFragment.this.kId.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.kId.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.kId.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0630a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0630a2);
            if (this.eMo) {
                a.C0630a c0630a3 = new a.C0630a(getActivity().getString(R.string.delete), this.kIk);
                c0630a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.cLt.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.jW(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.kId != null) {
                                    VideoPlayFragment.this.fLt.a(VideoPlayFragment.this.kId.forum_id, VideoPlayFragment.this.kId.forum_name, VideoPlayFragment.this.kId.thread_id, VideoPlayFragment.this.kId.post_id, 0, 0, VideoPlayFragment.this.eMo, null);
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
                        aVar.fH(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.aEG();
                    }
                });
                c0630a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0630a3);
            }
            this.kIk.az(arrayList);
        }
        this.cLt.show();
    }

    private void cTo() {
        if (this.kId != null) {
            this.kHL.startLoad(this.kId.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.kId.title);
            if (StringUtils.isNull(this.kId.title) || matcher.matches()) {
                this.kHU.setVisibility(8);
            } else {
                this.kHU.setVisibility(0);
                this.kHU.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.kHU.setTextColor(R.color.cp_cont_a);
                this.kHU.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.kHU.setExpandable(true);
                this.kHU.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void ms(boolean z) {
                        VideoPlayFragment.this.kId.isTitleExpanded = z;
                    }
                });
                this.kHU.setData(this.kId.title, this.kId.isTitleExpanded);
            }
            this.kHW.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kId.comment_num, 0L)));
            this.kHX.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kId.agree_num, 0L)));
            this.kHY.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kId.share_num, 0L)));
            if (this.kId.author_info != null) {
                if (!TextUtils.isEmpty(this.kId.author_info.bjhAvatar)) {
                    this.kHN.startLoad(this.kId.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.kId.author_info.portrait) && this.kId.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.kHN.startLoad(this.kId.author_info.portrait, 10, false);
                } else {
                    this.kHN.startLoad(this.kId.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.kId.author_info.cPy())) {
                    this.kIg.setVisibility(8);
                } else {
                    this.kIg.setVisibility(0);
                    this.kIg.setText("@" + this.kId.author_info.cPy());
                }
            }
            if ("1".equals(this.kId.is_private) && this.kIe.getVisibility() != 0) {
                this.kIc.setVisibility(0);
            } else {
                this.kIc.setVisibility(8);
            }
            if ("1".equals(this.kId.is_agreed)) {
                am.setImageResource(this.kIf, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.kIf, R.drawable.btn_video_agree);
            }
            if (this.kId.act_info != null && !StringUtils.isNull(this.kId.act_info.activity_name) && this.kIe.getVisibility() != 0) {
                this.kIb.setVisibility(0);
                this.kHV.setText(this.kId.act_info.activity_name);
            } else {
                this.kIb.setVisibility(8);
            }
            cTq();
            if (this.kId.isBjhVideo) {
                this.kHM.setVisibility(8);
            } else {
                this.kHM.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTp() {
        if (this.kId != null) {
            if ("1".equals(this.kId.is_agreed)) {
                am.setImageResource(this.kIf, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.kIf, R.drawable.btn_video_agree);
            }
            this.kHX.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kId.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTq() {
        if (this.eMo || (this.kId.author_info != null && !"0".equals(this.kId.author_info.is_follow))) {
            this.kHR.setVisibility(4);
            this.kHR.setClickable(false);
            return;
        }
        this.kHR.setVisibility(0);
        this.kHR.setClickable(true);
    }

    private void btn() {
        if (getActivity() != null) {
            if (this.kIr == null || !this.kIr.isShowing()) {
                this.kIr = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.aGG().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.kIr.aO(inflate);
                this.kIr.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.kIr.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.kIr.jZ(1);
                this.kIr.jX(R.color.cp_cont_b);
                this.kIr.fH(true);
                this.kIr.b(getPageContext());
                this.kIr.aEG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cTr() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.cPC().cPD() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !com.baidu.adp.lib.util.j.isMobileNet() || !this.mIsVisible) {
            return false;
        }
        if (this.kHZ != null) {
            this.kHZ.setVisibility(0);
        }
        pausePlay();
        btn();
        return true;
    }

    private void akd() {
        if (!cTr() && this.jvf != null && this.kHZ != null) {
            if (this.jvf.getParent() == null) {
                cTv();
                cTw();
            }
            this.jvf.b(null);
            this.kHZ.setVisibility(8);
            cyC();
            if (this.jwt != null) {
                this.jwt.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.kIl == null) {
            this.kIl = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.kIl;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
    public void aVq() {
        if (this.jvf.isPlaying()) {
            this.jvf.pause();
            this.kHZ.setVisibility(0);
        } else if (!cTr()) {
            this.jvf.start();
            this.kHZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
    public void u(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.kIm) {
            cTs();
            if (this.kId != null && "0".equals(this.kId.is_agreed)) {
                DX(this.kHK);
            }
        }
    }

    private void cTs() {
        if (this.mRootView != null) {
            this.kIm = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.kIo == null) {
                this.kIo = new RelativeLayout.LayoutParams(-2, -2);
                this.kIo.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.kIo);
            }
            if (this.kIn == null) {
                this.kIn = new AnimatorSet();
                this.kIn.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.kIm = false;
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
            this.kIn.setTarget(imageView);
            this.kIn.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.kIn.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
    public void aVr() {
        if (this.kId != null && this.kId.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.kId.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cyq()) {
            return ((QuickVideoView) this.jvf).getMediaIDs();
        }
        return null;
    }

    public String cTt() {
        if (cyq()) {
            return ((QuickVideoView) this.jvf).getMediaId();
        }
        return null;
    }

    public boolean cTu() {
        if (this.kIq == null || this.kIq.aOy() == null || !this.kIq.aOy().isVisible()) {
            return false;
        }
        this.kIq.aOy().hide();
        this.kIh.setVisibility(0);
        if ((this.kIq.aOy().mr(28) instanceof c) && ((c) this.kIq.aOy().mr(28)).getInputView() != null && ((c) this.kIq.aOy().mr(28)).getInputView().getText() != null) {
            this.kIi.setText(StringUtils.isNull(((c) this.kIq.aOy().mr(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.kIq != null) {
            this.kIq.onActivityResult(i, i2, intent);
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
        if (this.kIq != null && this.kIq.aOy() != null) {
            this.kIq.aOy().onChangeSkinType(i);
        }
        SvgManager.aGG().a(this.Wq, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void cTv() {
        if (this.jvf != null && this.jvf.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.jvf.getView(), 0);
            this.jvf.getView().setLayoutParams(layoutParams);
            if (cyq()) {
                ((QuickVideoView) this.jvf).setPlayerReuseEnable(true);
                ((QuickVideoView) this.jvf).setNeedRecovery(true);
            }
            if (this.kId != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.Pk = this.kId.thread_id;
                yVar.emF = this.kId.forum_id;
                yVar.jyv = this.kId.mMd5;
                yVar.cPf = "";
                yVar.mSource = this.kId.mRecomSource;
                yVar.mAbTag = this.kId.mRecomAbTag;
                yVar.jyu = 1;
                if (this.kId.baijiahaoData != null) {
                    if (this.kId.baijiahaoData.oriUgcType == 2) {
                        yVar.jyu = 3;
                    } else if (this.kId.baijiahaoData.oriUgcType == 4) {
                        yVar.jyu = 2;
                    }
                }
                yVar.jys = this.kId.mRecomWeight;
                if (this.mRect != null) {
                    yVar.jyw = "1";
                } else {
                    yVar.jyw = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    yVar.jyx = "1";
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    yVar.jyt = this.mFromPage;
                    yVar.cPf = this.cPf;
                    yVar.jyr = this.kId.mRecomWeight;
                } else {
                    yVar.mLocate = "14";
                }
                this.elC.setVideoStatsData(yVar);
                this.elC.jxt = true;
            }
            this.jvf.setContinuePlayEnable(true);
            this.jvf.setBusiness(this.elC);
        }
    }

    private void cTw() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.jvf.setOnPreparedListener(this.kIu);
        }
        this.jvf.setOnCompletionListener(this.kIt);
        this.jvf.setOnOutInfoListener(this.kIs);
    }
}
