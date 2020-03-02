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
    public ImageView Wg;
    private e cLh;
    private String cOR;
    private boolean eLF;
    private n ekZ;
    private AlphaAnimation enT;
    private View fTG;
    private boolean isNewPlayer;
    public com.baidu.tieba.play.a.a jtu;
    private QuickVideoView.c juI;
    private j.b juq;
    private TbImageView kFS;
    public ImageView kFT;
    public HeadImageView kFU;
    public LinearLayout kFV;
    public LinearLayout kFW;
    public LinearLayout kFX;
    public ImageView kFY;
    public ImageView kFZ;
    public ImageView kGa;
    public ExpandableTextView kGb;
    public TextView kGc;
    public TextView kGd;
    public TextView kGe;
    public TextView kGf;
    public ImageView kGg;
    private LinearLayout kGh;
    public LinearLayout kGi;
    public LinearLayout kGj;
    public VideoItemData kGk;
    private TextView kGl;
    public ImageView kGm;
    public TextView kGn;
    private View kGo;
    private TextView kGp;
    private int kGq;
    private com.baidu.tieba.view.a kGr;
    protected Animation kGs;
    private boolean kGt;
    private AnimatorSet kGu;
    private RelativeLayout.LayoutParams kGv;
    private com.baidu.tieba.videoplay.editor.a kGx;
    com.baidu.tbadk.core.dialog.a kGy;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private boolean mIsVisible;
    private int mOriginHeight;
    private int mOriginWidth;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int kFQ = 0;
    private int kFR = 1;
    private ForumManageModel fKy = null;
    private com.baidu.tbadk.baseEditMark.a iHB = null;
    private com.baidu.tbadk.coreExtra.model.a dab = null;
    private BdUniqueId MO = BdUniqueId.gen();
    private boolean kGw = false;
    private int playTime = 1;
    private CustomMessageListener daf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.kGk != null && VideoPlayFragment.this.kGk.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kGk.author_info.user_id) && data != null && VideoPlayFragment.this.kGk.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.MO)) ? false : false;
                    if (data.dnU == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.kGk.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.kGk.author_info.is_follow = "0";
                                VideoPlayFragment.this.cSV();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.kGk));
                                    return;
                                }
                                VideoPlayFragment.this.kGk.author_info.is_follow = "1";
                                VideoPlayFragment.this.cSV();
                            }
                        } else {
                            VideoPlayFragment.this.kGk.author_info.is_follow = "0";
                            VideoPlayFragment.this.cSV();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener cLy = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.cSW();
            }
        }
    };
    private CustomMessageListener ddv = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.kGk != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.kGk.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.kGk.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.kGk.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.kGk.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.cSU();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.kGk.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.kGk.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.kGk.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.cSU();
                    }
                }
            }
        }
    };
    private g.e kGz = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.mIsVisible) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.kFS.getVisibility() == 0) {
                    VideoPlayFragment.this.kFS.clearAnimation();
                    VideoPlayFragment.this.kFS.startAnimation(VideoPlayFragment.this.enT);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a kGA = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.jtu != null) {
                VideoPlayFragment.this.jtu.cyN();
                VideoPlayFragment.this.jtu.seekTo(0);
                VideoPlayFragment.this.jtu.start();
                VideoPlayFragment.this.buO();
                VideoPlayFragment.z(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.cSO();
                }
            }
        }
    };
    private g.f kGB = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            if (VideoPlayFragment.this.jtu != null) {
                VideoPlayFragment.this.jtu.setVolume(1.0f, 1.0f);
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
        registerListener(this.ddv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.kGk = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.kGq = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.cOR = arguments.getString("obj_id");
        if (this.kGk != null && this.kGk.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.kGk.author_info.user_id)) {
            this.eLF = true;
        }
        this.ekZ = new n(getActivity());
        this.ekZ.a(this.kGk);
        this.ekZ.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.j.b
            public void by(int i, int i2) {
                if (VideoPlayFragment.this.juq != null) {
                    VideoPlayFragment.this.juq.by(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.rH("cyber_player_test");
        this.jtu = com.baidu.tieba.play.a.b.F(getContext(), this.isNewPlayer ? 1 : 0);
        cTa();
        this.kFS = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.kFS.setPlaceHolder(4);
        this.kFS.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aFN()) {
            this.fTG = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.fTG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.fTG.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.Wg = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.kFT = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.kFU = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.kFU.setDefaultResource(17170445);
        this.kFU.setPlaceHolder(2);
        this.kFU.setIsRound(true);
        this.kFY = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.kGm = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.kGb = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.kGc = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.kFW = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.kGd = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.kFV = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.kGe = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.kGf = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.kFZ = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.kGa = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cSP();
        this.kGg = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.kGh = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.kGi = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.kGj = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.kFX = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.kGn = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.kGo = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.kGo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.kGo.setVisibility(4);
                    if (VideoPlayFragment.this.kGx != null && VideoPlayFragment.this.kGx.aOt() != null) {
                        VideoPlayFragment.this.kGx.aOt().display();
                        if (VideoPlayFragment.this.kGk != null) {
                            VideoPlayFragment.this.kGx.c(VideoPlayFragment.this.kGk);
                        }
                    }
                    if (VideoPlayFragment.this.kGk != null) {
                        an anVar = new an("c13025");
                        anVar.cy("tid", VideoPlayFragment.this.kGk.thread_id);
                        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.cy("fid", VideoPlayFragment.this.kGk.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.kGp = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.kGl = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.kGl.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.kGl.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_download_link_url", null);
        this.kGl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aGG().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cST();
        this.kFU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kGk != null && VideoPlayFragment.this.kGk.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kGk.author_info.user_id) && VideoPlayFragment.this.kGk != null && VideoPlayFragment.this.kGk.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kGk.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.cy("tid", VideoPlayFragment.this.kGk.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kGi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kGk != null && VideoPlayFragment.this.kGk.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.kGk.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.cy("tid", VideoPlayFragment.this.kGk.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kGb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cSR();
            }
        });
        this.Wg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kGk != null && !StringUtils.isNull(VideoPlayFragment.this.kGk.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.kGk.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.kFT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cSS();
            }
        });
        this.kFW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.kGk)) {
                    VideoPlayFragment.this.cSR();
                    an anVar = new an("c12796");
                    anVar.cy("tid", VideoPlayFragment.this.kGk.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kFV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.DP(VideoPlayFragment.this.kFQ);
            }
        });
        this.kFX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aIc();
                an anVar = new an("c12797");
                anVar.cy("tid", VideoPlayFragment.this.kGk.thread_id);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cy("tid", VideoPlayFragment.this.kGk.thread_id);
                anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.X("obj_locate", 19);
                TiebaStatic.log(anVar2);
            }
        });
        this.kFY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kGk != null && VideoPlayFragment.this.kGk.author_info != null) {
                    VideoPlayFragment.this.dab.a(true, VideoPlayFragment.this.kGk.author_info.portrait, VideoPlayFragment.this.kGk.author_info.user_id, false, "6", VideoPlayFragment.this.MO, VideoPlayFragment.this.kGk.forum_id, "0");
                    VideoPlayFragment.this.kGk.author_info.is_follow = "1";
                    VideoPlayFragment.this.cSV();
                }
            }
        });
        this.enT = new AlphaAnimation(1.0f, 0.0f);
        this.enT.setDuration(100L);
        this.enT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.kFS != null) {
                    VideoPlayFragment.this.kFS.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mOriginWidth = this.mRect.right - this.mRect.left;
            this.mOriginHeight = this.mRect.bottom - this.mRect.top;
            this.kFS.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.kFS.getWidth();
                    int height = VideoPlayFragment.this.kFS.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kGk.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kGk.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kGk.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kGk.video_height, 0.0f);
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
                            VideoPlayFragment.this.kFS.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.mOriginHeight > 0 || VideoPlayFragment.this.mOriginWidth <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mOriginWidth;
                                f = i / VideoPlayFragment.this.mOriginHeight;
                            }
                            VideoPlayFragment.this.kFS.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.kFS.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
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
                    VideoPlayFragment.this.kFS.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.mOriginHeight > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.kFS.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.kFS.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
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
            this.kFS.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.kFS.getWidth();
                    int height = VideoPlayFragment.this.kFS.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kGk.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kGk.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kGk.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kGk.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.kFS.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.kFS.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cfM();
        if (this.mIsVisible) {
            cSQ();
        }
        if (this.kGk != null && !StringUtils.isNull(this.kGk.video_url)) {
            KC(this.kGk.video_url);
        }
        return this.mRootView;
    }

    public boolean cxW() {
        return !this.isNewPlayer && (this.jtu instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.juq = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.juI = cVar;
    }

    private void cfM() {
        this.kGx = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dV(getActivity());
        if (this.kGx != null && this.kGk != null) {
            this.kGx.a(getPageContext());
            this.kGx.aw(this.kGk.thread_id, this.kGk.forum_id, this.kGk.forum_name);
            this.kGx.a(new a.InterfaceC0628a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0628a
                public void tz(boolean z) {
                    VideoPlayFragment.this.kGo.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.kGp.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.kGp.setText(StringUtils.isNull(((c) VideoPlayFragment.this.kGx.aOt().mp(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.kGk != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kGk.comment_num, 0L) + 1;
                        VideoPlayFragment.this.kGk.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.kGd.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.kGx.aOt(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIc() {
        String str;
        String str2;
        if (this.kGk != null) {
            String str3 = this.kGk.forum_id;
            String str4 = this.kGk.forum_name;
            String str5 = this.kGk.title;
            if (this.kGk.baijiahaoData != null) {
                str = this.kGk.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.kGk.baijiahaoData.oriUgcType + "&dvid=" + this.kGk.baijiahaoData.oriUgcVid + "&nid=" + this.kGk.baijiahaoData.oriUgcNid;
            } else {
                str = this.kGk.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.kGk.thumbnail_url;
            String format = (!this.kGk.isBjhVideo || this.kGk.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.kGk.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.kGk.baijiahaoData == null) {
                shareItem.readCount = this.kGk.play_count;
            }
            if (this.kGk.isBjhVideo) {
                shareItem.dqc = format;
            } else {
                shareItem.dqc = "";
            }
            shareItem.linkUrl = str6;
            shareItem.cUB = 2;
            shareItem.extData = str;
            shareItem.dqf = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.dpS = true;
            shareItem.dqe = 12;
            shareItem.dqj = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.kGk.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.kGk.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.kGk.title;
            originalThreadInfo.threadId = this.kGk.thread_id;
            originalThreadInfo.oriUgcInfo = this.kGk.baijiahaoData;
            shareItem.dqm = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqf);
            bundle.putInt("obj_type", shareItem.dqj);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUB);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.e.bwm().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eLF) {
            this.fKy = new ForumManageModel(getPageContext());
            this.fKy.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.fKy.getLoadDataMode()) {
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
        this.iHB = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.iHB != null) {
            this.iHB.a(new a.InterfaceC0374a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.iHB != null) {
                            VideoPlayFragment.this.iHB.fm(z2);
                        }
                        if (VideoPlayFragment.this.kGk != null) {
                            if (z2) {
                                VideoPlayFragment.this.kGk.mark_id = VideoPlayFragment.this.kGk.post_id;
                            } else {
                                VideoPlayFragment.this.kGk.mark_id = null;
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
        this.dab = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.daf);
        registerListener(this.cLy);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.kGw = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cST();
        cTb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSO() {
        if (this.kGa != null && this.kFZ != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.kFZ.clearAnimation();
            this.kGa.clearAnimation();
            this.kFZ.setVisibility(8);
            this.kGa.setVisibility(0);
            this.kGa.startAnimation(scaleAnimation2);
            this.kFZ.startAnimation(scaleAnimation);
        }
    }

    private void cSP() {
        if (this.kGa != null && this.kFZ != null) {
            this.kFZ.clearAnimation();
            this.kGa.clearAnimation();
            this.kFZ.setVisibility(0);
            this.kGa.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DP(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.kGk != null) {
            if (i == this.kFQ) {
                if ("1".equals(this.kGk.is_agreed)) {
                    i2 = 1;
                    this.kGk.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kGk.agree_num, 0) - 1);
                    this.kGk.is_agreed = "0";
                } else {
                    this.kGk.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kGk.agree_num, 0) + 1);
                    this.kGk.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.kGk.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kGk.agree_num, 0) + 1);
                this.kGk.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.cy("tid", this.kGk.thread_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.kFQ) {
                anVar.X("obj_type", i2);
            } else {
                anVar.X("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            cST();
            if (this.kGm != null && i2 == 0) {
                this.kGm.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.kGk.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.kGk.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.kGk.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.kGk.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.kGk.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.kGk.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.kGk.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.kGk.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.kGk));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.kGk != null && !StringUtils.isNull(this.kGk.video_url)) {
            this.mHasInit = true;
            if (this.mIsVisible) {
                buO();
                aka();
                if (this.kGk != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.cy("tid", this.kGk.thread_id);
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
        if (this.kGx != null && this.kGx.aOt() != null) {
            this.kGx.aOt().hide();
            this.kGo.setVisibility(0);
            this.kGp.setText(StringUtils.isNull(((c) this.kGx.aOt().mp(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        MessageManager.getInstance().unRegisterListener(this.ddv);
        if (this.kGx != null) {
            this.kGx.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisible = z;
        if (!z && this.kGx != null) {
            this.kGp.setText(R.string.reply_something);
            this.kGx.cTk();
        }
        if (this.mHasInit) {
            if (this.mIsVisible && (!this.kGw || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.kGk != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.cy("tid", this.kGk.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.X("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                cSQ();
                this.kGw = false;
                return;
            }
            cSP();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cSQ() {
        if (this.kGk != null) {
            an anVar = new an("c12590");
            anVar.cy("tid", this.kGk.thread_id);
            anVar.cy("fid", this.kGk.forum_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.X("obj_locate", this.kGq);
            anVar.X(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cy("obj_param1", aq.isEmpty(this.kGk.mRecomWeight) ? "0" : this.kGk.mRecomWeight);
            anVar.cy("extra", aq.isEmpty(this.kGk.mRecomExtra) ? "0" : this.kGk.mRecomExtra);
            anVar.cy("obj_id", this.cOR);
            anVar.cy(TiebaInitialize.Params.AB_TAG, aq.isEmpty(this.kGk.mRecomAbTag) ? "0" : this.kGk.mRecomAbTag);
            anVar.cy("obj_source", aq.isEmpty(this.kGk.mRecomSource) ? "0" : this.kGk.mRecomSource);
            anVar.cy("obj_type", this.mFromPage);
            anVar.X("is_vertical", 1);
            if (this.kGk.baijiahaoData != null) {
                anVar.cy("obj_param4", this.kGk.baijiahaoData.oriUgcNid);
                anVar.cy("obj_param6", this.kGk.baijiahaoData.oriUgcVid);
                if (this.kGk.baijiahaoData.oriUgcType == 4) {
                    anVar.X("obj_param5", 2);
                } else if (this.kGk.baijiahaoData.oriUgcType == 2) {
                    anVar.X("obj_param5", 3);
                }
            } else {
                anVar.X("obj_param5", 1);
            }
            TiebaStatic.log(anVar);
        }
    }

    private void KC(String str) {
        if (this.jtu != null && str != null && !str.equals(this.mVideoUrl)) {
            if (cxW()) {
                ((QuickVideoView) this.jtu).setRecoveryState(0);
            }
            this.jtu.setVideoPath(str, this.kGk.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.cPh().cPi() || cSW()) {
            cyi();
            if (this.kGg != null) {
                this.kGg.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.kFS.getVisibility() == 0) {
                this.kFS.clearAnimation();
                this.kFS.startAnimation(this.enT);
            }
            if (this.jtu != null) {
                this.jtu.start();
                buO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buO() {
        if (this.kGk != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.Pj = this.kGk.thread_id;
            yVar.emb = this.kGk.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.kGk.mRecomSource;
            yVar.jwG = this.kGk.mRecomAbTag;
            yVar.jwH = this.kGk.mRecomWeight;
            yVar.jwI = "";
            yVar.cOR = "";
            yVar.jwK = this.kGk.mMd5;
            if (this.mRect != null) {
                yVar.jwL = "1";
            } else {
                yVar.jwL = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.jwM = "1";
                yVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                yVar.jwI = "index";
            }
            com.baidu.tieba.play.l.a(this.kGk.mMd5, "", "1", yVar);
        }
    }

    private void cyi() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cPh().fy(getContext());
        }
    }

    private void pausePlay() {
        if (this.jtu != null) {
            this.jtu.pause();
        }
    }

    private void stopPlay() {
        if (this.jtu != null) {
            if (cxW()) {
                ((QuickVideoView) this.jtu).setRecoveryState(5);
            }
            this.jtu.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSR() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.kGk.thread_id, this.kGk.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.kGk.forum_id));
        createNormalCfg.setForumName(this.kGk.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.kGk.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSS() {
        if (this.cLh == null) {
            this.kGr = new com.baidu.tieba.view.a(getActivity());
            this.cLh = new e(getActivity(), this.kGr.aER());
            this.cLh.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.jtu.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.kGr != null) {
            ArrayList arrayList = new ArrayList();
            a.C0629a c0629a = new a.C0629a(this.kGr);
            c0629a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bc.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.cLh.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.cLh.dismiss();
                    if (VideoPlayFragment.this.kGk != null) {
                        boolean z = VideoPlayFragment.this.kGk.post_id != null && VideoPlayFragment.this.kGk.post_id.equals(VideoPlayFragment.this.kGk.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.kGk.thread_id);
                        markData.setPostId(VideoPlayFragment.this.kGk.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.kGk.thread_id);
                        markData.setForumId(VideoPlayFragment.this.kGk.forum_id);
                        if (VideoPlayFragment.this.iHB != null) {
                            VideoPlayFragment.this.iHB.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.iHB.ayN();
                            } else {
                                VideoPlayFragment.this.iHB.ayM();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.kGk != null && this.kGk.post_id != null && this.kGk.post_id.equals(this.kGk.mark_id)) {
                z = true;
            }
            if (z) {
                c0629a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0629a.setText(getResources().getString(R.string.mark));
            }
            if (this.kGk != null && !this.kGk.isBjhVideo) {
                arrayList.add(c0629a);
            }
            a.C0629a c0629a2 = new a.C0629a(getActivity().getString(R.string.delete), this.kGr);
            c0629a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.cLh.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kGk != null) {
                        String str = VideoPlayFragment.this.kGk.thread_id;
                        String str2 = VideoPlayFragment.this.kGk.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.kGk.post_id;
                        if (VideoPlayFragment.this.kGk.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.kGk.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.kGk.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0629a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0629a2);
            if (this.eLF) {
                a.C0629a c0629a3 = new a.C0629a(getActivity().getString(R.string.delete), this.kGr);
                c0629a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.cLh.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.jW(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.kGk != null) {
                                    VideoPlayFragment.this.fKy.a(VideoPlayFragment.this.kGk.forum_id, VideoPlayFragment.this.kGk.forum_name, VideoPlayFragment.this.kGk.thread_id, VideoPlayFragment.this.kGk.post_id, 0, 0, VideoPlayFragment.this.eLF, null);
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
                        aVar.fG(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.aEC();
                    }
                });
                c0629a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0629a3);
            }
            this.kGr.az(arrayList);
        }
        this.cLh.show();
    }

    private void cST() {
        if (this.kGk != null) {
            this.kFS.startLoad(this.kGk.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.kGk.title);
            if (StringUtils.isNull(this.kGk.title) || matcher.matches()) {
                this.kGb.setVisibility(8);
            } else {
                this.kGb.setVisibility(0);
                this.kGb.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.kGb.setTextColor(R.color.cp_cont_a);
                this.kGb.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.kGb.setExpandable(true);
                this.kGb.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void mm(boolean z) {
                        VideoPlayFragment.this.kGk.isTitleExpanded = z;
                    }
                });
                this.kGb.setData(this.kGk.title, this.kGk.isTitleExpanded);
            }
            this.kGd.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kGk.comment_num, 0L)));
            this.kGe.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kGk.agree_num, 0L)));
            this.kGf.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kGk.share_num, 0L)));
            if (this.kGk.author_info != null) {
                if (!TextUtils.isEmpty(this.kGk.author_info.bjhAvatar)) {
                    this.kFU.startLoad(this.kGk.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.kGk.author_info.portrait) && this.kGk.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.kFU.startLoad(this.kGk.author_info.portrait, 10, false);
                } else {
                    this.kFU.startLoad(this.kGk.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.kGk.author_info.cPd())) {
                    this.kGn.setVisibility(8);
                } else {
                    this.kGn.setVisibility(0);
                    this.kGn.setText("@" + this.kGk.author_info.cPd());
                }
            }
            if ("1".equals(this.kGk.is_private) && this.kGl.getVisibility() != 0) {
                this.kGj.setVisibility(0);
            } else {
                this.kGj.setVisibility(8);
            }
            if ("1".equals(this.kGk.is_agreed)) {
                am.setImageResource(this.kGm, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.kGm, R.drawable.btn_video_agree);
            }
            if (this.kGk.act_info != null && !StringUtils.isNull(this.kGk.act_info.activity_name) && this.kGl.getVisibility() != 0) {
                this.kGi.setVisibility(0);
                this.kGc.setText(this.kGk.act_info.activity_name);
            } else {
                this.kGi.setVisibility(8);
            }
            cSV();
            if (this.kGk.isBjhVideo) {
                this.kFT.setVisibility(8);
            } else {
                this.kFT.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSU() {
        if (this.kGk != null) {
            if ("1".equals(this.kGk.is_agreed)) {
                am.setImageResource(this.kGm, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.kGm, R.drawable.btn_video_agree);
            }
            this.kGe.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kGk.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSV() {
        if (this.eLF || (this.kGk.author_info != null && !"0".equals(this.kGk.author_info.is_follow))) {
            this.kFY.setVisibility(4);
            this.kFY.setClickable(false);
            return;
        }
        this.kFY.setVisibility(0);
        this.kFY.setClickable(true);
    }

    private void bth() {
        if (getActivity() != null) {
            if (this.kGy == null || !this.kGy.isShowing()) {
                this.kGy = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.aGC().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.kGy.aO(inflate);
                this.kGy.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.kGy.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.kGy.jZ(1);
                this.kGy.jX(R.color.cp_cont_b);
                this.kGy.fG(true);
                this.kGy.b(getPageContext());
                this.kGy.aEC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cSW() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
            return true;
        }
        if (!this.mIsVisible || com.baidu.tieba.video.g.cPh().cPi()) {
            return false;
        }
        if (this.kGg != null) {
            this.kGg.setVisibility(0);
        }
        pausePlay();
        bth();
        return false;
    }

    private void aka() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cSW() || com.baidu.tieba.video.g.cPh().cPi()) && this.jtu != null && this.kGg != null) {
            if (this.jtu.getParent() == null) {
                cTa();
                cTb();
            }
            this.jtu.b(null);
            this.kGg.setVisibility(8);
            cyi();
            if (this.juI != null) {
                this.juI.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.kGs == null) {
            this.kGs = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.kGs;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
    public void aVl() {
        if (this.jtu.isPlaying()) {
            this.jtu.pause();
            this.kGg.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cSW() || com.baidu.tieba.video.g.cPh().cPi()) {
            this.jtu.start();
            this.kGg.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
    public void u(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.kGt) {
            cSX();
            if (this.kGk != null && "0".equals(this.kGk.is_agreed)) {
                DP(this.kFR);
            }
        }
    }

    private void cSX() {
        if (this.mRootView != null) {
            this.kGt = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.kGv == null) {
                this.kGv = new RelativeLayout.LayoutParams(-2, -2);
                this.kGv.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.kGv);
            }
            if (this.kGu == null) {
                this.kGu = new AnimatorSet();
                this.kGu.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.kGt = false;
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
            this.kGu.setTarget(imageView);
            this.kGu.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.kGu.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
    public void aVm() {
        if (this.kGk != null && this.kGk.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.kGk.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cxW()) {
            return ((QuickVideoView) this.jtu).getMediaIDs();
        }
        return null;
    }

    public String cSY() {
        if (cxW()) {
            return ((QuickVideoView) this.jtu).getMediaId();
        }
        return null;
    }

    public boolean cSZ() {
        if (this.kGx == null || this.kGx.aOt() == null || !this.kGx.aOt().isVisible()) {
            return false;
        }
        this.kGx.aOt().hide();
        this.kGo.setVisibility(0);
        if ((this.kGx.aOt().mp(28) instanceof c) && ((c) this.kGx.aOt().mp(28)).getInputView() != null && ((c) this.kGx.aOt().mp(28)).getInputView().getText() != null) {
            this.kGp.setText(StringUtils.isNull(((c) this.kGx.aOt().mp(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.kGx != null) {
            this.kGx.onActivityResult(i, i2, intent);
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
        if (this.kGx != null && this.kGx.aOt() != null) {
            this.kGx.aOt().onChangeSkinType(i);
        }
        SvgManager.aGC().a(this.Wg, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void cTa() {
        if (this.jtu != null && this.jtu.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.jtu.getView(), 0);
            this.jtu.getView().setLayoutParams(layoutParams);
            if (cxW()) {
                ((QuickVideoView) this.jtu).setPlayerReuseEnable(true);
                ((QuickVideoView) this.jtu).setNeedRecovery(true);
            }
            if (this.kGk != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.Pj = this.kGk.thread_id;
                yVar.emb = this.kGk.forum_id;
                yVar.jwK = this.kGk.mMd5;
                yVar.cOR = "";
                yVar.mSource = this.kGk.mRecomSource;
                yVar.mAbTag = this.kGk.mRecomAbTag;
                yVar.jwJ = 1;
                if (this.kGk.baijiahaoData != null) {
                    if (this.kGk.baijiahaoData.oriUgcType == 2) {
                        yVar.jwJ = 3;
                    } else if (this.kGk.baijiahaoData.oriUgcType == 4) {
                        yVar.jwJ = 2;
                    }
                }
                yVar.jwH = this.kGk.mRecomWeight;
                if (this.mRect != null) {
                    yVar.jwL = "1";
                } else {
                    yVar.jwL = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    yVar.jwM = "1";
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    yVar.jwI = this.mFromPage;
                    yVar.cOR = this.cOR;
                    yVar.jwG = this.kGk.mRecomWeight;
                } else {
                    yVar.mLocate = "14";
                }
                this.ekZ.setVideoStatsData(yVar);
                this.ekZ.jvI = true;
            }
            this.jtu.setContinuePlayEnable(true);
            this.jtu.setBusiness(this.ekZ);
        }
    }

    private void cTb() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.jtu.setOnPreparedListener(this.kGB);
        }
        this.jtu.setOnCompletionListener(this.kGA);
        this.jtu.setOnOutInfoListener(this.kGz);
    }
}
