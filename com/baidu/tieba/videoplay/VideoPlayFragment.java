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
    public ImageView mfA;
    public HeadImageView mfB;
    public LinearLayout mfC;
    public LinearLayout mfD;
    public LinearLayout mfE;
    public ImageView mfF;
    public ImageView mfG;
    public ImageView mfH;
    public ExpandableTextView mfI;
    public TextView mfJ;
    public TextView mfK;
    public TextView mfL;
    public TextView mfM;
    public ImageView mfN;
    private LinearLayout mfO;
    public LinearLayout mfP;
    public LinearLayout mfQ;
    public VideoItemData mfR;
    private TextView mfS;
    public ImageView mfT;
    public TextView mfU;
    private View mfV;
    private TextView mfW;
    private int mfX;
    private int mfY;
    private com.baidu.tieba.view.a mfZ;
    private TbImageView mfz;
    protected Animation mga;
    private boolean mgb;
    private AnimatorSet mgc;
    private RelativeLayout.LayoutParams mgd;
    private com.baidu.tieba.videoplay.editor.a mgf;
    com.baidu.tbadk.core.dialog.a mgg;
    private int mfx = 0;
    private int mfy = 1;
    private ForumManageModel gRX = null;
    private com.baidu.tbadk.baseEditMark.a kfo = null;
    private com.baidu.tbadk.coreExtra.model.a dUB = null;
    private BdUniqueId agK = BdUniqueId.gen();
    private boolean mge = false;
    private int playTime = 1;
    private CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.mfR != null && VideoPlayFragment.this.mfR.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.mfR.author_info.user_id) && data != null && VideoPlayFragment.this.mfR.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.agK)) ? false : false;
                    if (data.els == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.mfR.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.mfR.author_info.is_follow = "0";
                                VideoPlayFragment.this.dpQ();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.doj) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.mfR));
                                    return;
                                }
                                VideoPlayFragment.this.mfR.author_info.is_follow = "1";
                                VideoPlayFragment.this.dpQ();
                            }
                        } else {
                            VideoPlayFragment.this.mfR.author_info.is_follow = "0";
                            VideoPlayFragment.this.dpQ();
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
                VideoPlayFragment.this.dpS();
            }
        }
    };
    private CustomMessageListener dYC = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.mfR != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.mfR.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.mfR.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.mfR.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.mfR.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dpP();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.mfR.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.mfR.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.mfR.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dpP();
                    }
                }
            }
        }
    };
    private g.e mgh = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.doj) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.mfz.getVisibility() == 0) {
                    VideoPlayFragment.this.mfz.clearAnimation();
                    VideoPlayFragment.this.mfz.startAnimation(VideoPlayFragment.this.fqe);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a mgi = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.kRW != null) {
                VideoPlayFragment.this.kRW.cVq();
                VideoPlayFragment.this.kRW.seekTo(0);
                VideoPlayFragment.this.kRW.start();
                VideoPlayFragment.this.bOi();
                VideoPlayFragment.z(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.dpJ();
                }
            }
        }
    };
    private g.f mgj = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
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
        this.mfR = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.mfY = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.dIK = arguments.getString("obj_id");
        if (this.mfR != null && this.mfR.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.mfR.author_info.user_id)) {
            this.fPZ = true;
        }
        this.fnj = new n(getActivity());
        this.fnj.a(this.mfR);
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
        dpW();
        this.mfz = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.mfz.setPlaceHolder(4);
        this.mfz.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aVZ()) {
            this.hbf = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.hbf.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.hbf.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.avt = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.mfA = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.mfB = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.mfB.setDefaultResource(17170445);
        this.mfB.setPlaceHolder(2);
        this.mfB.setIsRound(true);
        this.mfF = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.mfT = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.mfI = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.mfJ = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.mfD = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.mfK = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.mfC = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.mfL = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.mfM = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.mfG = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.mfH = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        dpK();
        this.mfN = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.mfO = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.mfP = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.mfQ = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.mfE = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.mfU = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.mfV = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.mfV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.mfV.setVisibility(4);
                    if (VideoPlayFragment.this.mgf != null && VideoPlayFragment.this.mgf.bfa() != null) {
                        VideoPlayFragment.this.mgf.bfa().display();
                        if (VideoPlayFragment.this.mfR != null) {
                            VideoPlayFragment.this.mgf.c(VideoPlayFragment.this.mfR);
                        }
                    }
                    if (VideoPlayFragment.this.mfR != null) {
                        ao aoVar = new ao("c13025");
                        aoVar.dk("tid", VideoPlayFragment.this.mfR.thread_id);
                        aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        aoVar.dk("fid", VideoPlayFragment.this.mfR.forum_id);
                        TiebaStatic.log(aoVar);
                    }
                }
            }
        });
        this.mfW = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.mfS = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.mfS.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.mfS.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aVP().getString("nani_key_download_link_url", null);
        this.mfS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    bc.aWU().a((TbPageContext) i.G(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        dpO();
        this.mfB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mfR != null && VideoPlayFragment.this.mfR.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.mfR.author_info.user_id) && VideoPlayFragment.this.mfR != null && VideoPlayFragment.this.mfR.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.mfR.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    ao aoVar = new ao("c12798");
                    aoVar.dk("tid", VideoPlayFragment.this.mfR.thread_id);
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aoVar);
                }
            }
        });
        this.mfP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mfR != null && VideoPlayFragment.this.mfR.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.mfR.act_info.link_url);
                    ao aoVar = new ao("c12799");
                    aoVar.dk("tid", VideoPlayFragment.this.mfR.thread_id);
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aoVar);
                }
            }
        });
        this.mfI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dpM();
            }
        });
        this.avt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.mfR != null && !StringUtils.isNull(VideoPlayFragment.this.mfR.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.mfR.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.mfA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dpN();
            }
        });
        this.mfD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.mfR)) {
                    VideoPlayFragment.this.dpM();
                    ao aoVar = new ao("c12796");
                    aoVar.dk("tid", VideoPlayFragment.this.mfR.thread_id);
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aoVar);
                }
            }
        });
        this.mfC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Gq(VideoPlayFragment.this.mfx);
            }
        });
        this.mfE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aYB();
                ao aoVar = new ao("c12797");
                aoVar.dk("tid", VideoPlayFragment.this.mfR.thread_id);
                aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aoVar);
                ao aoVar2 = new ao(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aoVar2.dk("tid", VideoPlayFragment.this.mfR.thread_id);
                aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
                aoVar2.ag("obj_locate", 19);
                aoVar2.dk("nid", VideoPlayFragment.this.mfR.nid);
                if (VideoPlayFragment.this.mfR.baijiahaoData != null && !ar.isEmpty(VideoPlayFragment.this.mfR.baijiahaoData.oriUgcVid)) {
                    aoVar2.dk("obj_param6", VideoPlayFragment.this.mfR.baijiahaoData.oriUgcVid);
                }
                if (VideoPlayFragment.this.mfR.getVideoType() == 1) {
                    aoVar2.ag(IntentConfig.CARD_TYPE, 2);
                } else if (VideoPlayFragment.this.mfR.getVideoType() == 2) {
                    aoVar2.ag(IntentConfig.CARD_TYPE, 8);
                } else if (VideoPlayFragment.this.mfR.getVideoType() == 3) {
                    aoVar2.ag(IntentConfig.CARD_TYPE, 6);
                }
                aoVar2.dk(IntentConfig.RECOM_SOURCE, VideoPlayFragment.this.mfR.mRecomSource);
                aoVar2.dk("ab_tag", VideoPlayFragment.this.mfR.mRecomAbTag);
                aoVar2.dk("weight", VideoPlayFragment.this.mfR.mRecomWeight);
                aoVar2.dk("extra", VideoPlayFragment.this.mfR.mRecomExtra);
                aoVar2.dk("obj_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                TiebaStatic.log(aoVar2);
            }
        });
        this.mfF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (be.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.mfR != null && VideoPlayFragment.this.mfR.author_info != null) {
                    VideoPlayFragment.this.dUB.a(true, VideoPlayFragment.this.mfR.author_info.portrait, VideoPlayFragment.this.mfR.author_info.user_id, false, "6", VideoPlayFragment.this.agK, VideoPlayFragment.this.mfR.forum_id, "0");
                    VideoPlayFragment.this.mfR.author_info.is_follow = "1";
                    VideoPlayFragment.this.dpQ();
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
                if (VideoPlayFragment.this.mfz != null) {
                    VideoPlayFragment.this.mfz.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mfX = this.mRect.right - this.mRect.left;
            this.hBQ = this.mRect.bottom - this.mRect.top;
            this.mfz.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.mfz.getWidth();
                    int height = VideoPlayFragment.this.mfz.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mfR.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mfR.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mfR.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mfR.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mfX, VideoPlayFragment.this.hBQ);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.mfz.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hBQ > 0 || VideoPlayFragment.this.mfX <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mfX;
                                f = i / VideoPlayFragment.this.hBQ;
                            }
                            VideoPlayFragment.this.mfz.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.mfz.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
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
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.mfX, VideoPlayFragment.this.hBQ);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.mfz.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hBQ > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.mfz.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.mfz.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
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
            this.mfz.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.mfz.getWidth();
                    int height = VideoPlayFragment.this.mfz.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mfR.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.mfR.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mfR.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.mfR.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.mfz.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.mfz.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cBv();
        if (this.doj) {
            dpL();
        }
        if (this.mfR != null && !StringUtils.isNull(this.mfR.video_url)) {
            setVideoInfo(this.mfR.video_url);
        }
        return this.mRootView;
    }

    public boolean cUz() {
        return !this.isNewPlayer && (this.kRW instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.kSS = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.kTk = cVar;
    }

    private void cBv() {
        this.mgf = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dO(getActivity());
        if (this.mgf != null && this.mfR != null) {
            this.mgf.a(getPageContext());
            this.mgf.aA(this.mfR.thread_id, this.mfR.forum_id, this.mfR.forum_name);
            this.mgf.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0760a
                public void vx(boolean z) {
                    VideoPlayFragment.this.mfV.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.mfW.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.mfW.setText(StringUtils.isNull(((c) VideoPlayFragment.this.mgf.bfa().nB(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.mfR != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.mfR.comment_num, 0L) + 1;
                        VideoPlayFragment.this.mfR.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.mfK.setText(ar.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.mgf.bfa(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYB() {
        String str;
        String str2;
        if (this.mfR != null) {
            String str3 = this.mfR.forum_id;
            String str4 = this.mfR.forum_name;
            String str5 = this.mfR.title;
            if (this.mfR.baijiahaoData != null) {
                str = this.mfR.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.mfR.baijiahaoData.oriUgcType + "&dvid=" + this.mfR.baijiahaoData.oriUgcVid + "&nid=" + this.mfR.baijiahaoData.oriUgcNid;
            } else {
                str = this.mfR.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.mfR.thumbnail_url;
            String format = (!this.mfR.isBjhVideo || this.mfR.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.mfR.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.mfR.baijiahaoData == null) {
                shareItem.readCount = this.mfR.play_count;
            }
            if (this.mfR.isBjhVideo) {
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
            if (this.mfR.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.mfR.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.mfR.title;
            originalThreadInfo.threadId = this.mfR.thread_id;
            originalThreadInfo.oriUgcInfo = this.mfR.baijiahaoData;
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
            f.bPD().b(shareDialogConfig);
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
                        if (VideoPlayFragment.this.mfR != null) {
                            if (z2) {
                                VideoPlayFragment.this.mfR.mark_id = VideoPlayFragment.this.mfR.post_id;
                            } else {
                                VideoPlayFragment.this.mfR.mark_id = null;
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
            this.mge = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        dpO();
        dpX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpJ() {
        if (this.mfH != null && this.mfG != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.mfG.clearAnimation();
            this.mfH.clearAnimation();
            this.mfG.setVisibility(8);
            this.mfH.setVisibility(0);
            this.mfH.startAnimation(scaleAnimation2);
            this.mfG.startAnimation(scaleAnimation);
        }
    }

    private void dpK() {
        if (this.mfH != null && this.mfG != null) {
            this.mfG.clearAnimation();
            this.mfH.clearAnimation();
            this.mfG.setVisibility(0);
            this.mfH.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(int i) {
        int i2;
        if (be.checkUpIsLogin(getActivity()) && this.mfR != null) {
            if (i == this.mfx) {
                if ("1".equals(this.mfR.is_agreed)) {
                    i2 = 1;
                    this.mfR.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mfR.agree_num, 0) - 1);
                    this.mfR.is_agreed = "0";
                } else {
                    this.mfR.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mfR.agree_num, 0) + 1);
                    this.mfR.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.mfR.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.mfR.agree_num, 0) + 1);
                this.mfR.is_agreed = "1";
                i2 = 0;
            }
            ao aoVar = new ao("c12795");
            aoVar.dk("tid", this.mfR.thread_id);
            aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.mfx) {
                aoVar.ag("obj_type", i2);
            } else {
                aoVar.ag("obj_type", 2);
            }
            TiebaStatic.log(aoVar);
            dpO();
            if (this.mfT != null && i2 == 0) {
                this.mfT.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.mfR.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.mfR.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.mfR.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.mfR.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.mfR.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.mfR.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.mfR.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.mfR.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.mfR));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.mfR != null && !StringUtils.isNull(this.mfR.video_url)) {
            this.mHasInit = true;
            if (this.doj) {
                bOi();
                axa();
                if (this.mfR != null && this.mRect != null) {
                    ao aoVar = new ao("c12794");
                    aoVar.dk("tid", this.mfR.thread_id);
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
        if (this.mgf != null && this.mgf.bfa() != null) {
            this.mgf.bfa().hide();
            this.mfV.setVisibility(0);
            this.mfW.setText(StringUtils.isNull(((c) this.mgf.bfa().nB(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.mgf != null) {
            this.mgf.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.doj = z;
        if (!z && this.mgf != null) {
            this.mfW.setText(R.string.reply_something);
            this.mgf.cbY();
        }
        if (this.mHasInit) {
            if (this.doj && (!this.mge || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.mfR != null && this.mRect == null) {
                    ao aoVar = new ao("c12794");
                    aoVar.dk("tid", this.mfR.thread_id);
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    aoVar.ag("obj_type", 1);
                    TiebaStatic.log(aoVar);
                }
                startPlay();
                dpL();
                this.mge = false;
                return;
            }
            dpK();
            this.playTime = 1;
            awZ();
        }
    }

    private void dpL() {
        if (this.mfR != null) {
            ao aoVar = new ao("c12590");
            aoVar.dk("tid", this.mfR.thread_id);
            aoVar.dk("nid", this.mfR.nid);
            aoVar.dk("fid", this.mfR.forum_id);
            aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            aoVar.ag("obj_locate", this.mfY);
            aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
            aoVar.dk("obj_param1", ar.isEmpty(this.mfR.mRecomWeight) ? "0" : this.mfR.mRecomWeight);
            aoVar.dk("extra", ar.isEmpty(this.mfR.mRecomExtra) ? "0" : this.mfR.mRecomExtra);
            aoVar.dk("obj_id", this.dIK);
            aoVar.dk("ab_tag", ar.isEmpty(this.mfR.mRecomAbTag) ? "0" : this.mfR.mRecomAbTag);
            aoVar.dk("obj_source", ar.isEmpty(this.mfR.mRecomSource) ? "0" : this.mfR.mRecomSource);
            aoVar.dk("obj_type", this.mFromPage);
            aoVar.ag("is_vertical", 1);
            if (this.mfR.baijiahaoData != null) {
                aoVar.dk("obj_param4", this.mfR.baijiahaoData.oriUgcNid);
                aoVar.dk("obj_param6", this.mfR.baijiahaoData.oriUgcVid);
                if (this.mfR.baijiahaoData.oriUgcType == 4) {
                    aoVar.ag("obj_param5", 2);
                } else if (this.mfR.baijiahaoData.oriUgcType == 2) {
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
            if (cUz()) {
                ((QuickVideoView) this.kRW).setRecoveryState(0);
            }
            this.kRW.setVideoPath(str, this.mfR.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dpS()) {
            cUL();
            if (this.mfN != null) {
                this.mfN.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.mfz.getVisibility() == 0) {
                this.mfz.clearAnimation();
                this.mfz.startAnimation(this.fqe);
            }
            if (this.kRW != null) {
                if (TbVideoViewSet.cWa().Ld(this.mVideoUrl) == null || TbVideoViewSet.cWa().Ld(this.mVideoUrl) != this.kRW) {
                    this.kRW.setVideoPath(this.mVideoUrl, this.mfR.thread_id);
                }
                this.kRW.start();
                bOi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOi() {
        if (this.mfR != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.ajO = this.mfR.thread_id;
            yVar.mNid = this.mfR.nid;
            yVar.eEs = this.mfR.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.mfR.mRecomSource;
            yVar.kVo = this.mfR.mRecomAbTag;
            yVar.kVp = this.mfR.mRecomWeight;
            yVar.kVq = "";
            yVar.dIK = "";
            yVar.kVt = this.mfR.mMd5;
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
            com.baidu.tieba.play.l.a(this.mfR.mMd5, "", "1", yVar, this.kRW.getPcdnState());
        }
    }

    private void cUL() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            h.dmk().fs(getContext());
        }
    }

    private void awZ() {
        if (this.kRW != null) {
            this.kRW.pause();
        }
    }

    private void stopPlay() {
        if (this.kRW != null) {
            if (cUz()) {
                ((QuickVideoView) this.kRW).setRecoveryState(5);
            }
            this.kRW.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpM() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.mfR.thread_id, this.mfR.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.mfR.forum_id));
        createNormalCfg.setForumName(this.mfR.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.mfR.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpN() {
        if (this.dDL == null) {
            this.mfZ = new com.baidu.tieba.view.a(getActivity());
            this.dDL = new e(getActivity(), this.mfZ.aVb());
            this.dDL.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.kRW.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.mfZ != null) {
            ArrayList arrayList = new ArrayList();
            a.C0761a c0761a = new a.C0761a(this.mfZ);
            c0761a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!be.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.dDL.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.dDL.dismiss();
                    if (VideoPlayFragment.this.mfR != null) {
                        boolean z = VideoPlayFragment.this.mfR.post_id != null && VideoPlayFragment.this.mfR.post_id.equals(VideoPlayFragment.this.mfR.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.mfR.thread_id);
                        markData.setPostId(VideoPlayFragment.this.mfR.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.mfR.thread_id);
                        markData.setForumId(VideoPlayFragment.this.mfR.forum_id);
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
            if (this.mfR != null && this.mfR.post_id != null && this.mfR.post_id.equals(this.mfR.mark_id)) {
                z = true;
            }
            if (z) {
                c0761a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0761a.setText(getResources().getString(R.string.mark));
            }
            if (this.mfR != null && !this.mfR.isBjhVideo) {
                arrayList.add(c0761a);
            }
            a.C0761a c0761a2 = new a.C0761a(getActivity().getString(R.string.delete), this.mfZ);
            c0761a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.dDL.dismiss();
                    if (be.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.mfR != null) {
                        String str = VideoPlayFragment.this.mfR.thread_id;
                        String str2 = VideoPlayFragment.this.mfR.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.mfR.post_id;
                        if (VideoPlayFragment.this.mfR.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.mfR.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.mfR.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0761a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0761a2);
            if (this.fPZ) {
                a.C0761a c0761a3 = new a.C0761a(getActivity().getString(R.string.delete), this.mfZ);
                c0761a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.dDL.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.kT(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.mfR != null) {
                                    VideoPlayFragment.this.gRX.a(VideoPlayFragment.this.mfR.forum_id, VideoPlayFragment.this.mfR.forum_name, VideoPlayFragment.this.mfR.thread_id, VideoPlayFragment.this.mfR.post_id, 0, 0, VideoPlayFragment.this.fPZ, null);
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
                c0761a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0761a3);
            }
            this.mfZ.aL(arrayList);
        }
        this.dDL.show();
    }

    private void dpO() {
        if (this.mfR != null) {
            this.mfz.startLoad(this.mfR.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.mfR.title);
            if (StringUtils.isNull(this.mfR.title) || matcher.matches()) {
                this.mfI.setVisibility(8);
            } else {
                this.mfI.setVisibility(0);
                this.mfI.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.mfI.setTextColor(R.color.cp_cont_a);
                this.mfI.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.mfI.setExpandable(true);
                this.mfI.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void od(boolean z) {
                        VideoPlayFragment.this.mfR.isTitleExpanded = z;
                    }
                });
                this.mfI.setData(this.mfR.title, this.mfR.isTitleExpanded);
            }
            this.mfK.setText(ar.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mfR.comment_num, 0L)));
            this.mfL.setText(ar.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mfR.agree_num, 0L)));
            this.mfM.setText(ar.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mfR.share_num, 0L)));
            if (this.mfR.author_info != null) {
                if (!TextUtils.isEmpty(this.mfR.author_info.bjhAvatar)) {
                    this.mfB.startLoad(this.mfR.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.mfR.author_info.portrait) && this.mfR.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.mfB.startLoad(this.mfR.author_info.portrait, 10, false);
                } else {
                    this.mfB.startLoad(this.mfR.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.mfR.author_info.dmg())) {
                    this.mfU.setVisibility(8);
                } else {
                    this.mfU.setVisibility(0);
                    this.mfU.setText(UgcConstant.AT_RULE_TAG + this.mfR.author_info.dmg());
                }
            }
            if ("1".equals(this.mfR.is_private) && this.mfS.getVisibility() != 0) {
                this.mfQ.setVisibility(0);
            } else {
                this.mfQ.setVisibility(8);
            }
            if ("1".equals(this.mfR.is_agreed)) {
                an.setImageResource(this.mfT, R.drawable.icon_card_like_white_full_s);
            } else {
                an.setImageResource(this.mfT, R.drawable.btn_video_agree);
            }
            if (this.mfR.act_info != null && !StringUtils.isNull(this.mfR.act_info.activity_name) && this.mfS.getVisibility() != 0) {
                this.mfP.setVisibility(0);
                this.mfJ.setText(this.mfR.act_info.activity_name);
            } else {
                this.mfP.setVisibility(8);
            }
            dpQ();
            if (this.mfR.isBjhVideo) {
                this.mfA.setVisibility(8);
            } else {
                this.mfA.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpP() {
        if (this.mfR != null) {
            if ("1".equals(this.mfR.is_agreed)) {
                an.setImageResource(this.mfT, R.drawable.icon_card_like_white_full_s);
            } else {
                an.setImageResource(this.mfT, R.drawable.btn_video_agree);
            }
            this.mfL.setText(ar.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.mfR.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpQ() {
        if (this.fPZ || (this.mfR.author_info != null && !"0".equals(this.mfR.author_info.is_follow))) {
            this.mfF.setVisibility(4);
            this.mfF.setClickable(false);
            return;
        }
        this.mfF.setVisibility(0);
        this.mfF.setClickable(true);
    }

    private void dpR() {
        if (getActivity() != null) {
            if (this.mgg == null || !this.mgg.isShowing()) {
                this.mgg = new com.baidu.tbadk.core.dialog.a(getActivity());
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
                this.mgg.aP(inflate);
                this.mgg.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.mgg.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.mgg.kW(1);
                this.mgg.kU(R.color.cp_cont_b);
                this.mgg.hf(true);
                this.mgg.b(getPageContext());
                this.mgg.aUN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dpS() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || h.dmk().dml() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !com.baidu.adp.lib.util.j.isMobileNet() || !this.doj) {
            return false;
        }
        if (this.mfN != null) {
            this.mfN.setVisibility(0);
        }
        awZ();
        dpR();
        return true;
    }

    private void axa() {
        if (!dpS() && this.kRW != null && this.mfN != null && this.mfR != null) {
            if (this.kRW.getParent() == null) {
                dpW();
                dpX();
            }
            if (TbVideoViewSet.cWa().Ld(this.mVideoUrl) == null || TbVideoViewSet.cWa().Ld(this.mVideoUrl) != this.kRW) {
                this.kRW.setVideoPath(this.mVideoUrl, this.mfR.thread_id);
            }
            this.kRW.b(null);
            this.mfN.setVisibility(8);
            cUL();
            if (this.kTk != null) {
                this.kTk.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.mga == null) {
            this.mga = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.mga;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0508a
    public void bmk() {
        if (this.kRW.isPlaying()) {
            this.kRW.pause();
            this.mfN.setVisibility(0);
        } else if (!dpS()) {
            this.kRW.start();
            this.mfN.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0508a
    public void t(float f, float f2) {
        if (be.checkUpIsLogin(getActivity()) && !this.mgb) {
            dpT();
            if (this.mfR != null && "0".equals(this.mfR.is_agreed)) {
                Gq(this.mfy);
            }
        }
    }

    private void dpT() {
        if (this.mRootView != null) {
            this.mgb = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.mgd == null) {
                this.mgd = new RelativeLayout.LayoutParams(-2, -2);
                this.mgd.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.mgd);
            }
            if (this.mgc == null) {
                this.mgc = new AnimatorSet();
                this.mgc.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.mgb = false;
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
            this.mgc.setTarget(imageView);
            this.mgc.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.mgc.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0508a
    public void bml() {
        if (this.mfR != null && this.mfR.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.mfR.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cUz()) {
            return ((QuickVideoView) this.kRW).getMediaIDs();
        }
        return null;
    }

    public String dpU() {
        if (cUz()) {
            return ((QuickVideoView) this.kRW).getMediaId();
        }
        return null;
    }

    public boolean dpV() {
        if (this.mgf == null || this.mgf.bfa() == null || !this.mgf.bfa().isVisible()) {
            return false;
        }
        this.mgf.bfa().hide();
        this.mfV.setVisibility(0);
        if ((this.mgf.bfa().nB(28) instanceof c) && ((c) this.mgf.bfa().nB(28)).getInputView() != null && ((c) this.mgf.bfa().nB(28)).getInputView().getText() != null) {
            this.mfW.setText(StringUtils.isNull(((c) this.mgf.bfa().nB(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.mgf != null) {
            this.mgf.onActivityResult(i, i2, intent);
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
        if (this.mgf != null && this.mgf.bfa() != null) {
            this.mgf.bfa().onChangeSkinType(i);
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

    public void dpW() {
        if (this.kRW != null && this.kRW.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.kRW.getView(), 0);
            this.kRW.getView().setLayoutParams(layoutParams);
            if (cUz()) {
                ((QuickVideoView) this.kRW).setNeedRecovery(true);
            }
            if (this.mfR != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.ajO = this.mfR.thread_id;
                yVar.mNid = this.mfR.nid;
                yVar.eEs = this.mfR.forum_id;
                yVar.kVt = this.mfR.mMd5;
                yVar.dIK = "";
                yVar.mSource = this.mfR.mRecomSource;
                yVar.kVs = this.mfR.mRecomAbTag;
                yVar.kVr = 1;
                if (this.mfR.baijiahaoData != null) {
                    if (this.mfR.baijiahaoData.oriUgcType == 2) {
                        yVar.kVr = 3;
                    } else if (this.mfR.baijiahaoData.oriUgcType == 4) {
                        yVar.kVr = 2;
                    }
                }
                yVar.kVp = this.mfR.mRecomWeight;
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
                    yVar.kVo = this.mfR.mRecomWeight;
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

    private void dpX() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.kRW.setOnPreparedListener(this.mgj);
        }
        this.kRW.setOnCompletionListener(this.mgi);
        this.kRW.setOnOutInfoListener(this.mgh);
    }
}
