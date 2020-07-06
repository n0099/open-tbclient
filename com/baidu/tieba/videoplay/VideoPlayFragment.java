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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.c.f;
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
import com.baidu.tieba.video.h;
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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0508a {
    public ImageView avt;
    private e dDL;
    private String dIK;
    private boolean doj;
    private boolean fPZ;
    private n fnj;
    private AlphaAnimation fqe;
    private int hBQ;
    private View hbf;
    private boolean isNewPlayer;
    public com.baidu.tieba.play.a.a kRW;
    private j.b kSS;
    private QuickVideoView.c kTk;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private TbImageView mfC;
    public ImageView mfD;
    public HeadImageView mfE;
    public LinearLayout mfF;
    public LinearLayout mfG;
    public LinearLayout mfH;
    public ImageView mfI;
    public ImageView mfJ;
    public ImageView mfK;
    public ExpandableTextView mfL;
    public TextView mfM;
    public TextView mfN;
    public TextView mfO;
    public TextView mfP;
    public ImageView mfQ;
    private LinearLayout mfR;
    public LinearLayout mfS;
    public LinearLayout mfT;
    public VideoItemData mfU;
    private TextView mfV;
    public ImageView mfW;
    public TextView mfX;
    private View mfY;
    private TextView mfZ;
    private int mga;
    private int mgb;
    private com.baidu.tieba.view.a mgc;
    protected Animation mgd;
    private boolean mge;
    private AnimatorSet mgf;
    private RelativeLayout.LayoutParams mgg;
    private com.baidu.tieba.videoplay.editor.a mgi;
    com.baidu.tbadk.core.dialog.a mgj;
    private int mfA = 0;
    private int mfB = 1;
    private ForumManageModel gRX = null;
    private com.baidu.tbadk.baseEditMark.a kfo = null;
    private com.baidu.tbadk.coreExtra.model.a dUB = null;
    private BdUniqueId agK = BdUniqueId.gen();
    private boolean mgh = false;
    private int playTime = 1;
    private CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.mfU != null && VideoPlayFragment.this.mfU.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.mfU.author_info.user_id) && data != null && VideoPlayFragment.this.mfU.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.agK)) ? false : false;
                    if (data.els == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.mfU.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.mfU.author_info.is_follow = "0";
                                VideoPlayFragment.this.dpU();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.doj) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.mfU));
                                    return;
                                }
                                VideoPlayFragment.this.mfU.author_info.is_follow = "1";
                                VideoPlayFragment.this.dpU();
                            }
                        } else {
                            VideoPlayFragment.this.mfU.author_info.is_follow = "0";
                            VideoPlayFragment.this.dpU();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener dFp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.dpW();
            }
        }
    };
    private CustomMessageListener dYC = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.mfU != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.mfU.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.mfU.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.mfU.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.mfU.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dpT();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.mfU.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.mfU.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.mfU.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dpT();
                    }
                }
            }
        }
    };
    private g.e mgk = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.doj) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.mfC.getVisibility() == 0) {
                    VideoPlayFragment.this.mfC.clearAnimation();
                    VideoPlayFragment.this.mfC.startAnimation(VideoPlayFragment.this.fqe);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a mgl = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.kRW != null) {
                VideoPlayFragment.this.kRW.cVr();
                VideoPlayFragment.this.kRW.seekTo(0);
                VideoPlayFragment.this.kRW.start();
                VideoPlayFragment.this.bOj();
                VideoPlayFragment.z(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dpN();
                }
            }
        }
    };
    private g.f mgm = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            if (VideoPlayFragment.this.kRW != null) {
                VideoPlayFragment.this.kRW.setVolume(1.0f, 1.0f);
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
        registerListener(this.dYC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.mfU = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.mgb = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.dIK = arguments.getString("obj_id");
        if (this.mfU != null && this.mfU.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.mfU.author_info.user_id)) {
            this.fPZ = true;
        }
        this.fnj = new n(getActivity());
        this.fnj.a(this.mfU);
        this.fnj.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.j.b
            public void bM(int i, int i2) {
                if (VideoPlayFragment.this.kSS != null) {
                    VideoPlayFragment.this.kSS.bM(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.uL("cyber_player_test") || b.uK("cyber_player_test");
        this.kRW = com.baidu.tieba.play.a.b.A(getContext(), this.isNewPlayer ? 1 : 0);
        dqa();
        this.mfC = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.mfC.setPlaceHolder(4);
        this.mfC.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aVZ()) {
            this.hbf = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.hbf.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.hbf.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.avt = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.mfD = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.mfE = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.mfE.setDefaultResource(17170445);
        this.mfE.setPlaceHolder(2);
        this.mfE.setIsRound(true);
        this.mfI = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.mfW = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.mfL = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.mfM = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.mfG = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.mfN = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.mfF = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.mfO = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.mfP = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.mfJ = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.mfK = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dpO();
        this.mfQ = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.mfR = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.mfS = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.mfT = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.mfH = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.mfX = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.mfY = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.mfY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.mfY.setVisibility(4);
                    if (VideoPlayFragment.this.mgi != null && VideoPlayFragment.this.mgi.bfa() != null) {
                        VideoPlayFragment.this.mgi.bfa().display();
                        if (VideoPlayFragment.this.mfU != null) {
                            VideoPlayFragment.this.mgi.c(VideoPlayFragment.this.mfU);
                        }
                    }
                    if (VideoPlayFragment.this.mfU != null) {
                        ao aoVar = new ao("c13025");
                        aoVar.dk("tid", VideoPlayFragment.this.mfU.thread_id);
                        aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        aoVar.dk("fid", VideoPlayFragment.this.mfU.forum_id);
                        TiebaStatic.log(aoVar);
                    }
                }
            }
        });
        this.mfZ = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.mfV = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.mfV.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.mfV.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aVP().getString("nani_key_download_link_url", null);
        this.mfV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    bc.aWU().a((TbPageContext) i.G(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dpS();
        this.mfE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mfU != null && VideoPlayFragment.this.mfU.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.mfU.author_info.user_id) && VideoPlayFragment.this.mfU != null && VideoPlayFragment.this.mfU.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.mfU.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    ao aoVar = new ao("c12798");
                    aoVar.dk("tid", VideoPlayFragment.this.mfU.thread_id);
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aoVar);
                }
            }
        });
        this.mfS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mfU != null && VideoPlayFragment.this.mfU.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.mfU.act_info.link_url);
                    ao aoVar = new ao("c12799");
                    aoVar.dk("tid", VideoPlayFragment.this.mfU.thread_id);
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aoVar);
                }
            }
        });
        this.mfL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dpQ();
            }
        });
        this.avt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mfU != null && !StringUtils.isNull(VideoPlayFragment.this.mfU.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.mfU.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.mfD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dpR();
            }
        });
        this.mfG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.mfU)) {
                    VideoPlayFragment.this.dpQ();
                    ao aoVar = new ao("c12796");
                    aoVar.dk("tid", VideoPlayFragment.this.mfU.thread_id);
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aoVar);
                }
            }
        });
        this.mfF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Gq(VideoPlayFragment.this.mfA);
            }
        });
        this.mfH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aYB();
                ao aoVar = new ao("c12797");
                aoVar.dk("tid", VideoPlayFragment.this.mfU.thread_id);
                aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aoVar);
                ao aoVar2 = new ao(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aoVar2.dk("tid", VideoPlayFragment.this.mfU.thread_id);
                aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
                aoVar2.ag("obj_locate", 19);
                aoVar2.dk("nid", VideoPlayFragment.this.mfU.nid);
                if (VideoPlayFragment.this.mfU.baijiahaoData != null && !ar.isEmpty(VideoPlayFragment.this.mfU.baijiahaoData.oriUgcVid)) {
                    aoVar2.dk("obj_param6", VideoPlayFragment.this.mfU.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.mfU.getVideoType() == 1) {
                    aoVar2.ag(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.mfU.getVideoType() == 2) {
                    aoVar2.ag(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.mfU.getVideoType() == 3) {
                    aoVar2.ag(IntentConfig.CARD_TYPE, 6);
                }
                aoVar2.dk(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.mfU.mRecomSource);
                aoVar2.dk("ab_tag", VideoPlayFragment.this.mfU.mRecomAbTag);
                aoVar2.dk("weight", VideoPlayFragment.this.mfU.mRecomWeight);
                aoVar2.dk("extra", VideoPlayFragment.this.mfU.mRecomExtra);
                aoVar2.dk("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                TiebaStatic.log(aoVar2);
            }
        });
        this.mfI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (be.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.mfU != null && VideoPlayFragment.this.mfU.author_info != null) {
                    VideoPlayFragment.this.dUB.a(true, VideoPlayFragment.this.mfU.author_info.portrait, VideoPlayFragment.this.mfU.author_info.user_id, false, "6", VideoPlayFragment.this.agK, VideoPlayFragment.this.mfU.forum_id, "0");
                    VideoPlayFragment.this.mfU.author_info.is_follow = "1";
                    VideoPlayFragment.this.dpU();
                }
            }
        });
        this.fqe = new AlphaAnimation(1.0f, 0.0f);
        this.fqe.setDuration(100L);
        this.fqe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.mfC != null) {
                    VideoPlayFragment.this.mfC.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mga = this.mRect.right - this.mRect.left;
            this.hBQ = this.mRect.bottom - this.mRect.top;
            this.mfC.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.mfC.getWidth();
                    int height = VideoPlayFragment.this.mfC.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mfU.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mfU.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mfU.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mfU.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mga, VideoPlayFragment.this.hBQ);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.mfC.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hBQ > 0 || VideoPlayFragment.this.mga <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mga;
                                f = i / VideoPlayFragment.this.hBQ;
                            }
                            VideoPlayFragment.this.mfC.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.mfC.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.doj) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mga, VideoPlayFragment.this.hBQ);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.mfC.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hBQ > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.mfC.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.mfC.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.doj) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.mfC.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.mfC.getWidth();
                    int height = VideoPlayFragment.this.mfC.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mfU.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mfU.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mfU.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mfU.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.mfC.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.mfC.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cBw();
        if (this.doj) {
            dpP();
        }
        if (this.mfU != null && !StringUtils.isNull(this.mfU.video_url)) {
            setVideoInfo(this.mfU.video_url);
        }
        return this.mRootView;
    }

    public boolean cUA() {
        return !this.isNewPlayer && (this.kRW instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.kSS = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.kTk = cVar;
    }

    private void cBw() {
        this.mgi = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dO(getActivity());
        if (this.mgi != null && this.mfU != null) {
            this.mgi.a(getPageContext());
            this.mgi.aA(this.mfU.thread_id, this.mfU.forum_id, this.mfU.forum_name);
            this.mgi.a(new a.InterfaceC0761a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0761a
                public void vx(boolean z) {
                    VideoPlayFragment.this.mfY.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.mfZ.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.mfZ.setText(StringUtils.isNull(((c) VideoPlayFragment.this.mgi.bfa().nB(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.mfU != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.mfU.comment_num, 0L) + 1;
                        VideoPlayFragment.this.mfU.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.mfN.setText(ar.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.mgi.bfa(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYB() {
        String str;
        String str2;
        if (this.mfU != null) {
            String str3 = this.mfU.forum_id;
            String str4 = this.mfU.forum_name;
            String str5 = this.mfU.title;
            if (this.mfU.baijiahaoData != null) {
                str = this.mfU.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.mfU.baijiahaoData.oriUgcType + "&dvid=" + this.mfU.baijiahaoData.oriUgcVid + "&nid=" + this.mfU.baijiahaoData.oriUgcNid;
            } else {
                str = this.mfU.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.mfU.thumbnail_url;
            String format = (!this.mfU.isBjhVideo || this.mfU.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.mfU.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.mfU.baijiahaoData == null) {
                shareItem.readCount = this.mfU.play_count;
            }
            if (this.mfU.isBjhVideo) {
                shareItem.enE = format;
            } else {
                shareItem.enE = "";
            }
            shareItem.linkUrl = str6;
            shareItem.dOP = 2;
            shareItem.extData = str;
            shareItem.enH = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.enu = true;
            shareItem.enG = 12;
            shareItem.enL = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.mfU.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.mfU.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.mfU.title;
            originalThreadInfo.threadId = this.mfU.thread_id;
            originalThreadInfo.oriUgcInfo = this.mfU.baijiahaoData;
            shareItem.enO = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.enH);
            bundle.putInt("obj_type", shareItem.enL);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dOP);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            f.bPE().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fPZ) {
            this.gRX = new ForumManageModel(getPageContext());
            this.gRX.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.gRX.getLoadDataMode()) {
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
        this.kfo = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.kfo != null) {
            this.kfo.a(new a.InterfaceC0477a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0477a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.kfo != null) {
                            VideoPlayFragment.this.kfo.gJ(z2);
                        }
                        if (VideoPlayFragment.this.mfU != null) {
                            if (z2) {
                                VideoPlayFragment.this.mfU.mark_id = VideoPlayFragment.this.mfU.post_id;
                            } else {
                                VideoPlayFragment.this.mfU.mark_id = null;
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
        this.dUB = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.dUF);
        registerListener(this.dFp);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.mgh = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dpS();
        dqb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpN() {
        if (this.mfK != null && this.mfJ != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.mfJ.clearAnimation();
            this.mfK.clearAnimation();
            this.mfJ.setVisibility(8);
            this.mfK.setVisibility(0);
            this.mfK.startAnimation(scaleAnimation2);
            this.mfJ.startAnimation(scaleAnimation);
        }
    }

    private void dpO() {
        if (this.mfK != null && this.mfJ != null) {
            this.mfJ.clearAnimation();
            this.mfK.clearAnimation();
            this.mfJ.setVisibility(0);
            this.mfK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(int i) {
        int i2;
        if (be.checkUpIsLogin(getActivity()) && this.mfU != null) {
            if (i == this.mfA) {
                if ("1".equals(this.mfU.is_agreed)) {
                    i2 = 1;
                    this.mfU.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mfU.agree_num, 0) - 1);
                    this.mfU.is_agreed = "0";
                } else {
                    this.mfU.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mfU.agree_num, 0) + 1);
                    this.mfU.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.mfU.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mfU.agree_num, 0) + 1);
                this.mfU.is_agreed = "1";
                i2 = 0;
            }
            ao aoVar = new ao("c12795");
            aoVar.dk("tid", this.mfU.thread_id);
            aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.mfA) {
                aoVar.ag("obj_type", i2);
            } else {
                aoVar.ag("obj_type", 2);
            }
            TiebaStatic.log(aoVar);
            dpS();
            if (this.mfW != null && i2 == 0) {
                this.mfW.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.mfU.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.mfU.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.mfU.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.mfU.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.mfU.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.mfU.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.mfU.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.mfU.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.mfU));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.mfU != null && !StringUtils.isNull(this.mfU.video_url)) {
            this.mHasInit = true;
            if (this.doj) {
                bOj();
                axa();
                if (this.mfU != null && this.mRect != null) {
                    ao aoVar = new ao("c12794");
                    aoVar.dk("tid", this.mfU.thread_id);
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    aoVar.ag("obj_type", 0);
                    TiebaStatic.log(aoVar);
                    return;
                }
                return;
            }
            awZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        awZ();
        if (this.mgi != null && this.mgi.bfa() != null) {
            this.mgi.bfa().hide();
            this.mfY.setVisibility(0);
            this.mfZ.setText(StringUtils.isNull(((c) this.mgi.bfa().nB(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        MessageManager.getInstance().unRegisterListener(this.dYC);
        if (this.mgi != null) {
            this.mgi.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.doj = z;
        if (!z && this.mgi != null) {
            this.mfZ.setText(R.string.reply_something);
            this.mgi.cbZ();
        }
        if (this.mHasInit) {
            if (this.doj && (!this.mgh || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.mfU != null && this.mRect == null) {
                    ao aoVar = new ao("c12794");
                    aoVar.dk("tid", this.mfU.thread_id);
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    aoVar.ag("obj_type", 1);
                    TiebaStatic.log(aoVar);
                }
                startPlay();
                dpP();
                this.mgh = false;
                return;
            }
            dpO();
            this.playTime = 1;
            awZ();
        }
    }

    private void dpP() {
        if (this.mfU != null) {
            ao aoVar = new ao("c12590");
            aoVar.dk("tid", this.mfU.thread_id);
            aoVar.dk("nid", this.mfU.nid);
            aoVar.dk("fid", this.mfU.forum_id);
            aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            aoVar.ag("obj_locate", this.mgb);
            aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aoVar.dk("obj_param1", ar.isEmpty(this.mfU.mRecomWeight) ? "0" : this.mfU.mRecomWeight);
            aoVar.dk("extra", ar.isEmpty(this.mfU.mRecomExtra) ? "0" : this.mfU.mRecomExtra);
            aoVar.dk("obj_id", this.dIK);
            aoVar.dk("ab_tag", ar.isEmpty(this.mfU.mRecomAbTag) ? "0" : this.mfU.mRecomAbTag);
            aoVar.dk("obj_source", ar.isEmpty(this.mfU.mRecomSource) ? "0" : this.mfU.mRecomSource);
            aoVar.dk("obj_type", this.mFromPage);
            aoVar.ag("is_vertical", 1);
            if (this.mfU.baijiahaoData != null) {
                aoVar.dk("obj_param4", this.mfU.baijiahaoData.oriUgcNid);
                aoVar.dk("obj_param6", this.mfU.baijiahaoData.oriUgcVid);
                if (this.mfU.baijiahaoData.oriUgcType == 4) {
                    aoVar.ag("obj_param5", 2);
                } else if (this.mfU.baijiahaoData.oriUgcType == 2) {
                    aoVar.ag("obj_param5", 3);
                }
            } else {
                aoVar.ag("obj_param5", 1);
            }
            TiebaStatic.log(aoVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.kRW != null && str != null && !str.equals(this.mVideoUrl)) {
            if (cUA()) {
                ((QuickVideoView) this.kRW).setRecoveryState(0);
            }
            this.kRW.setVideoPath(str, this.mfU.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dpW()) {
            cUM();
            if (this.mfQ != null) {
                this.mfQ.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.mfC.getVisibility() == 0) {
                this.mfC.clearAnimation();
                this.mfC.startAnimation(this.fqe);
            }
            if (this.kRW != null) {
                if (TbVideoViewSet.cWb().Ld(this.mVideoUrl) == null || TbVideoViewSet.cWb().Ld(this.mVideoUrl) != this.kRW) {
                    this.kRW.setVideoPath(this.mVideoUrl, this.mfU.thread_id);
                }
                this.kRW.start();
                bOj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOj() {
        if (this.mfU != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.ajO = this.mfU.thread_id;
            yVar.mNid = this.mfU.nid;
            yVar.eEs = this.mfU.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.mfU.mRecomSource;
            yVar.kVo = this.mfU.mRecomAbTag;
            yVar.kVp = this.mfU.mRecomWeight;
            yVar.kVq = "";
            yVar.dIK = "";
            yVar.kVt = this.mfU.mMd5;
            if (this.mRect != null) {
                yVar.kVu = "1";
            } else {
                yVar.kVu = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.kVv = "1";
                yVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                yVar.kVq = "index";
            }
            com.baidu.tieba.play.l.a(this.mfU.mMd5, "", "1", yVar, this.kRW.getPcdnState());
        }
    }

    private void cUM() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            h.dmo().fs(getContext());
        }
    }

    private void awZ() {
        if (this.kRW != null) {
            this.kRW.pause();
        }
    }

    private void stopPlay() {
        if (this.kRW != null) {
            if (cUA()) {
                ((QuickVideoView) this.kRW).setRecoveryState(5);
            }
            this.kRW.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpQ() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.mfU.thread_id, this.mfU.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.mfU.forum_id));
        createNormalCfg.setForumName(this.mfU.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.mfU.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpR() {
        if (this.dDL == null) {
            this.mgc = new com.baidu.tieba.view.a(getActivity());
            this.dDL = new e(getActivity(), this.mgc.aVb());
            this.dDL.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.kRW.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.mgc != null) {
            ArrayList arrayList = new ArrayList();
            a.C0762a c0762a = new a.C0762a(this.mgc);
            c0762a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!be.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.dDL.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.dDL.dismiss();
                    if (VideoPlayFragment.this.mfU != null) {
                        boolean z = VideoPlayFragment.this.mfU.post_id != null && VideoPlayFragment.this.mfU.post_id.equals(VideoPlayFragment.this.mfU.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.mfU.thread_id);
                        markData.setPostId(VideoPlayFragment.this.mfU.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.mfU.thread_id);
                        markData.setForumId(VideoPlayFragment.this.mfU.forum_id);
                        if (VideoPlayFragment.this.kfo != null) {
                            VideoPlayFragment.this.kfo.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.kfo.aOq();
                            } else {
                                VideoPlayFragment.this.kfo.aOp();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.mfU != null && this.mfU.post_id != null && this.mfU.post_id.equals(this.mfU.mark_id)) {
                z = true;
            }
            if (z) {
                c0762a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0762a.setText(getResources().getString(R.string.mark));
            }
            if (this.mfU != null && !this.mfU.isBjhVideo) {
                arrayList.add(c0762a);
            }
            a.C0762a c0762a2 = new a.C0762a(getActivity().getString(R.string.delete), this.mgc);
            c0762a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.dDL.dismiss();
                    if (be.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.mfU != null) {
                        String str = VideoPlayFragment.this.mfU.thread_id;
                        String str2 = VideoPlayFragment.this.mfU.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.mfU.post_id;
                        if (VideoPlayFragment.this.mfU.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.mfU.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.mfU.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0762a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0762a2);
            if (this.fPZ) {
                a.C0762a c0762a3 = new a.C0762a(getActivity().getString(R.string.delete), this.mgc);
                c0762a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.dDL.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.kT(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.mfU != null) {
                                    VideoPlayFragment.this.gRX.a(VideoPlayFragment.this.mfU.forum_id, VideoPlayFragment.this.mfU.forum_name, VideoPlayFragment.this.mfU.thread_id, VideoPlayFragment.this.mfU.post_id, 0, 0, VideoPlayFragment.this.fPZ, null);
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
                        aVar.hf(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.aUN();
                    }
                });
                c0762a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0762a3);
            }
            this.mgc.aL(arrayList);
        }
        this.dDL.show();
    }

    private void dpS() {
        if (this.mfU != null) {
            this.mfC.startLoad(this.mfU.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.mfU.title);
            if (StringUtils.isNull(this.mfU.title) || matcher.matches()) {
                this.mfL.setVisibility(8);
            } else {
                this.mfL.setVisibility(0);
                this.mfL.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.mfL.setTextColor(R.color.cp_cont_a);
                this.mfL.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.mfL.setExpandable(true);
                this.mfL.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void od(boolean z) {
                        VideoPlayFragment.this.mfU.isTitleExpanded = z;
                    }
                });
                this.mfL.setData(this.mfU.title, this.mfU.isTitleExpanded);
            }
            this.mfN.setText(ar.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mfU.comment_num, 0L)));
            this.mfO.setText(ar.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mfU.agree_num, 0L)));
            this.mfP.setText(ar.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mfU.share_num, 0L)));
            if (this.mfU.author_info != null) {
                if (!TextUtils.isEmpty(this.mfU.author_info.bjhAvatar)) {
                    this.mfE.startLoad(this.mfU.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.mfU.author_info.portrait) && this.mfU.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.mfE.startLoad(this.mfU.author_info.portrait, 10, false);
                } else {
                    this.mfE.startLoad(this.mfU.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.mfU.author_info.dmk())) {
                    this.mfX.setVisibility(8);
                } else {
                    this.mfX.setVisibility(0);
                    this.mfX.setText(UgcConstant.AT_RULE_TAG + this.mfU.author_info.dmk());
                }
            }
            if ("1".equals(this.mfU.is_private) && this.mfV.getVisibility() != 0) {
                this.mfT.setVisibility(0);
            } else {
                this.mfT.setVisibility(8);
            }
            if ("1".equals(this.mfU.is_agreed)) {
                an.setImageResource(this.mfW, R.drawable.icon_card_like_white_full_s);
            } else {
                an.setImageResource(this.mfW, R.drawable.btn_video_agree);
            }
            if (this.mfU.act_info != null && !StringUtils.isNull(this.mfU.act_info.activity_name) && this.mfV.getVisibility() != 0) {
                this.mfS.setVisibility(0);
                this.mfM.setText(this.mfU.act_info.activity_name);
            } else {
                this.mfS.setVisibility(8);
            }
            dpU();
            if (this.mfU.isBjhVideo) {
                this.mfD.setVisibility(8);
            } else {
                this.mfD.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpT() {
        if (this.mfU != null) {
            if ("1".equals(this.mfU.is_agreed)) {
                an.setImageResource(this.mfW, R.drawable.icon_card_like_white_full_s);
            } else {
                an.setImageResource(this.mfW, R.drawable.btn_video_agree);
            }
            this.mfO.setText(ar.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mfU.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpU() {
        if (this.fPZ || (this.mfU.author_info != null && !"0".equals(this.mfU.author_info.is_follow))) {
            this.mfI.setVisibility(4);
            this.mfI.setClickable(false);
            return;
        }
        this.mfI.setVisibility(0);
        this.mfI.setClickable(true);
    }

    private void dpV() {
        if (getActivity() != null) {
            if (this.mgj == null || !this.mgj.isShowing()) {
                this.mgj = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.aWQ().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.mgj.aP(inflate);
                this.mgj.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.mgj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.mgj.kW(1);
                this.mgj.kU(R.color.cp_cont_b);
                this.mgj.hf(true);
                this.mgj.b(getPageContext());
                this.mgj.aUN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dpW() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || h.dmo().dmp() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !com.baidu.adp.lib.util.j.isMobileNet() || !this.doj) {
            return false;
        }
        if (this.mfQ != null) {
            this.mfQ.setVisibility(0);
        }
        awZ();
        dpV();
        return true;
    }

    private void axa() {
        if (!dpW() && this.kRW != null && this.mfQ != null && this.mfU != null) {
            if (this.kRW.getParent() == null) {
                dqa();
                dqb();
            }
            if (TbVideoViewSet.cWb().Ld(this.mVideoUrl) == null || TbVideoViewSet.cWb().Ld(this.mVideoUrl) != this.kRW) {
                this.kRW.setVideoPath(this.mVideoUrl, this.mfU.thread_id);
            }
            this.kRW.b(null);
            this.mfQ.setVisibility(8);
            cUM();
            if (this.kTk != null) {
                this.kTk.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.mgd == null) {
            this.mgd = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.mgd;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0508a
    public void bml() {
        if (this.kRW.isPlaying()) {
            this.kRW.pause();
            this.mfQ.setVisibility(0);
        } else if (!dpW()) {
            this.kRW.start();
            this.mfQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0508a
    public void t(float f, float f2) {
        if (be.checkUpIsLogin(getActivity()) && !this.mge) {
            dpX();
            if (this.mfU != null && "0".equals(this.mfU.is_agreed)) {
                Gq(this.mfB);
            }
        }
    }

    private void dpX() {
        if (this.mRootView != null) {
            this.mge = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.mgg == null) {
                this.mgg = new RelativeLayout.LayoutParams(-2, -2);
                this.mgg.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.mgg);
            }
            if (this.mgf == null) {
                this.mgf = new AnimatorSet();
                this.mgf.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.mge = false;
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
            this.mgf.setTarget(imageView);
            this.mgf.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.mgf.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0508a
    public void bmm() {
        if (this.mfU != null && this.mfU.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.mfU.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cUA()) {
            return ((QuickVideoView) this.kRW).getMediaIDs();
        }
        return null;
    }

    public String dpY() {
        if (cUA()) {
            return ((QuickVideoView) this.kRW).getMediaId();
        }
        return null;
    }

    public boolean dpZ() {
        if (this.mgi == null || this.mgi.bfa() == null || !this.mgi.bfa().isVisible()) {
            return false;
        }
        this.mgi.bfa().hide();
        this.mfY.setVisibility(0);
        if ((this.mgi.bfa().nB(28) instanceof c) && ((c) this.mgi.bfa().nB(28)).getInputView() != null && ((c) this.mgi.bfa().nB(28)).getInputView().getText() != null) {
            this.mfZ.setText(StringUtils.isNull(((c) this.mgi.bfa().nB(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.mgi != null) {
            this.mgi.onActivityResult(i, i2, intent);
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
        if (this.mgi != null && this.mgi.bfa() != null) {
            this.mgi.bfa().onChangeSkinType(i);
        }
        SvgManager.aWQ().a(this.avt, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dqa() {
        if (this.kRW != null && this.kRW.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.kRW.getView(), 0);
            this.kRW.getView().setLayoutParams(layoutParams);
            if (cUA()) {
                ((QuickVideoView) this.kRW).setNeedRecovery(true);
            }
            if (this.mfU != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.ajO = this.mfU.thread_id;
                yVar.mNid = this.mfU.nid;
                yVar.eEs = this.mfU.forum_id;
                yVar.kVt = this.mfU.mMd5;
                yVar.dIK = "";
                yVar.mSource = this.mfU.mRecomSource;
                yVar.kVs = this.mfU.mRecomAbTag;
                yVar.kVr = 1;
                if (this.mfU.baijiahaoData != null) {
                    if (this.mfU.baijiahaoData.oriUgcType == 2) {
                        yVar.kVr = 3;
                    } else if (this.mfU.baijiahaoData.oriUgcType == 4) {
                        yVar.kVr = 2;
                    }
                }
                yVar.kVp = this.mfU.mRecomWeight;
                if (this.mRect != null) {
                    yVar.kVu = "1";
                } else {
                    yVar.kVu = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    yVar.kVv = "1";
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    yVar.kVq = this.mFromPage;
                    yVar.dIK = this.dIK;
                    yVar.kVo = this.mfU.mRecomWeight;
                } else {
                    yVar.mLocate = "14";
                }
                this.fnj.setVideoStatsData(yVar);
                this.fnj.kUq = true;
            }
            this.kRW.setContinuePlayEnable(true);
            this.kRW.setBusiness(this.fnj);
        }
    }

    private void dqb() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.kRW.setOnPreparedListener(this.mgm);
        }
        this.kRW.setOnCompletionListener(this.mgl);
        this.kRW.setOnOutInfoListener(this.mgk);
    }
}
