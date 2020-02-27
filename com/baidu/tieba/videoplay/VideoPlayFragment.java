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
    private e cLg;
    private String cOQ;
    private boolean eLE;
    private n ekY;
    private AlphaAnimation enS;
    private View fTE;
    private boolean isNewPlayer;
    public com.baidu.tieba.play.a.a jts;
    private QuickVideoView.c juG;
    private j.b juo;
    private TbImageView kFQ;
    public ImageView kFR;
    public HeadImageView kFS;
    public LinearLayout kFT;
    public LinearLayout kFU;
    public LinearLayout kFV;
    public ImageView kFW;
    public ImageView kFX;
    public ImageView kFY;
    public ExpandableTextView kFZ;
    public TextView kGa;
    public TextView kGb;
    public TextView kGc;
    public TextView kGd;
    public ImageView kGe;
    private LinearLayout kGf;
    public LinearLayout kGg;
    public LinearLayout kGh;
    public VideoItemData kGi;
    private TextView kGj;
    public ImageView kGk;
    public TextView kGl;
    private View kGm;
    private TextView kGn;
    private int kGo;
    private com.baidu.tieba.view.a kGp;
    protected Animation kGq;
    private boolean kGr;
    private AnimatorSet kGs;
    private RelativeLayout.LayoutParams kGt;
    private com.baidu.tieba.videoplay.editor.a kGv;
    com.baidu.tbadk.core.dialog.a kGw;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private boolean mIsVisible;
    private int mOriginHeight;
    private int mOriginWidth;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int kFO = 0;
    private int kFP = 1;
    private ForumManageModel fKw = null;
    private com.baidu.tbadk.baseEditMark.a iHz = null;
    private com.baidu.tbadk.coreExtra.model.a daa = null;
    private BdUniqueId MO = BdUniqueId.gen();
    private boolean kGu = false;
    private int playTime = 1;
    private CustomMessageListener dae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.kGi != null && VideoPlayFragment.this.kGi.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kGi.author_info.user_id) && data != null && VideoPlayFragment.this.kGi.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.MO)) ? false : false;
                    if (data.dnT == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.kGi.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.kGi.author_info.is_follow = "0";
                                VideoPlayFragment.this.cST();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.kGi));
                                    return;
                                }
                                VideoPlayFragment.this.kGi.author_info.is_follow = "1";
                                VideoPlayFragment.this.cST();
                            }
                        } else {
                            VideoPlayFragment.this.kGi.author_info.is_follow = "0";
                            VideoPlayFragment.this.cST();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener cLx = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.cSU();
            }
        }
    };
    private CustomMessageListener ddt = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.kGi != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.kGi.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.kGi.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.kGi.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.kGi.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.cSS();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.kGi.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.kGi.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.kGi.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.cSS();
                    }
                }
            }
        }
    };
    private g.e kGx = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.mIsVisible) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.kFQ.getVisibility() == 0) {
                    VideoPlayFragment.this.kFQ.clearAnimation();
                    VideoPlayFragment.this.kFQ.startAnimation(VideoPlayFragment.this.enS);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a kGy = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.jts != null) {
                VideoPlayFragment.this.jts.cyL();
                VideoPlayFragment.this.jts.seekTo(0);
                VideoPlayFragment.this.jts.start();
                VideoPlayFragment.this.buM();
                VideoPlayFragment.z(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.cSM();
                }
            }
        }
    };
    private g.f kGz = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            if (VideoPlayFragment.this.jts != null) {
                VideoPlayFragment.this.jts.setVolume(1.0f, 1.0f);
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
        registerListener(this.ddt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.kGi = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.kGo = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.cOQ = arguments.getString("obj_id");
        if (this.kGi != null && this.kGi.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.kGi.author_info.user_id)) {
            this.eLE = true;
        }
        this.ekY = new n(getActivity());
        this.ekY.a(this.kGi);
        this.ekY.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.j.b
            public void by(int i, int i2) {
                if (VideoPlayFragment.this.juo != null) {
                    VideoPlayFragment.this.juo.by(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.rH("cyber_player_test");
        this.jts = com.baidu.tieba.play.a.b.F(getContext(), this.isNewPlayer ? 1 : 0);
        cSY();
        this.kFQ = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.kFQ.setPlaceHolder(4);
        this.kFQ.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aFL()) {
            this.fTE = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.fTE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.fTE.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.Wg = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.kFR = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.kFS = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.kFS.setDefaultResource(17170445);
        this.kFS.setPlaceHolder(2);
        this.kFS.setIsRound(true);
        this.kFW = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.kGk = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.kFZ = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.kGa = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.kFU = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.kGb = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.kFT = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.kGc = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.kGd = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.kFX = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.kFY = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cSN();
        this.kGe = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.kGf = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.kGg = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.kGh = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.kFV = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.kGl = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.kGm = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.kGm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.kGm.setVisibility(4);
                    if (VideoPlayFragment.this.kGv != null && VideoPlayFragment.this.kGv.aOr() != null) {
                        VideoPlayFragment.this.kGv.aOr().display();
                        if (VideoPlayFragment.this.kGi != null) {
                            VideoPlayFragment.this.kGv.c(VideoPlayFragment.this.kGi);
                        }
                    }
                    if (VideoPlayFragment.this.kGi != null) {
                        an anVar = new an("c13025");
                        anVar.cy("tid", VideoPlayFragment.this.kGi.thread_id);
                        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.cy("fid", VideoPlayFragment.this.kGi.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.kGn = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.kGj = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.kGj.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.kGj.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aFB().getString("nani_key_download_link_url", null);
        this.kGj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aGE().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cSR();
        this.kFS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kGi != null && VideoPlayFragment.this.kGi.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kGi.author_info.user_id) && VideoPlayFragment.this.kGi != null && VideoPlayFragment.this.kGi.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kGi.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.cy("tid", VideoPlayFragment.this.kGi.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kGg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kGi != null && VideoPlayFragment.this.kGi.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.kGi.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.cy("tid", VideoPlayFragment.this.kGi.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kFZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cSP();
            }
        });
        this.Wg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kGi != null && !StringUtils.isNull(VideoPlayFragment.this.kGi.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.kGi.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.kFR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cSQ();
            }
        });
        this.kFU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.kGi)) {
                    VideoPlayFragment.this.cSP();
                    an anVar = new an("c12796");
                    anVar.cy("tid", VideoPlayFragment.this.kGi.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kFT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.DP(VideoPlayFragment.this.kFO);
            }
        });
        this.kFV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aIa();
                an anVar = new an("c12797");
                anVar.cy("tid", VideoPlayFragment.this.kGi.thread_id);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cy("tid", VideoPlayFragment.this.kGi.thread_id);
                anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.X("obj_locate", 19);
                TiebaStatic.log(anVar2);
            }
        });
        this.kFW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kGi != null && VideoPlayFragment.this.kGi.author_info != null) {
                    VideoPlayFragment.this.daa.a(true, VideoPlayFragment.this.kGi.author_info.portrait, VideoPlayFragment.this.kGi.author_info.user_id, false, "6", VideoPlayFragment.this.MO, VideoPlayFragment.this.kGi.forum_id, "0");
                    VideoPlayFragment.this.kGi.author_info.is_follow = "1";
                    VideoPlayFragment.this.cST();
                }
            }
        });
        this.enS = new AlphaAnimation(1.0f, 0.0f);
        this.enS.setDuration(100L);
        this.enS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.kFQ != null) {
                    VideoPlayFragment.this.kFQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mOriginWidth = this.mRect.right - this.mRect.left;
            this.mOriginHeight = this.mRect.bottom - this.mRect.top;
            this.kFQ.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.kFQ.getWidth();
                    int height = VideoPlayFragment.this.kFQ.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kGi.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kGi.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kGi.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kGi.video_height, 0.0f);
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
                            VideoPlayFragment.this.kFQ.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.mOriginHeight > 0 || VideoPlayFragment.this.mOriginWidth <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mOriginWidth;
                                f = i / VideoPlayFragment.this.mOriginHeight;
                            }
                            VideoPlayFragment.this.kFQ.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.kFQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
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
                    VideoPlayFragment.this.kFQ.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.mOriginHeight > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.kFQ.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.kFQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
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
            this.kFQ.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.kFQ.getWidth();
                    int height = VideoPlayFragment.this.kFQ.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kGi.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kGi.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kGi.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kGi.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.kFQ.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.kFQ.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cfK();
        if (this.mIsVisible) {
            cSO();
        }
        if (this.kGi != null && !StringUtils.isNull(this.kGi.video_url)) {
            KC(this.kGi.video_url);
        }
        return this.mRootView;
    }

    public boolean cxU() {
        return !this.isNewPlayer && (this.jts instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.juo = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.juG = cVar;
    }

    private void cfK() {
        this.kGv = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dV(getActivity());
        if (this.kGv != null && this.kGi != null) {
            this.kGv.a(getPageContext());
            this.kGv.aw(this.kGi.thread_id, this.kGi.forum_id, this.kGi.forum_name);
            this.kGv.a(new a.InterfaceC0628a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0628a
                public void tz(boolean z) {
                    VideoPlayFragment.this.kGm.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.kGn.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.kGn.setText(StringUtils.isNull(((c) VideoPlayFragment.this.kGv.aOr().mp(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.kGi != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kGi.comment_num, 0L) + 1;
                        VideoPlayFragment.this.kGi.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.kGb.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.kGv.aOr(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIa() {
        String str;
        String str2;
        if (this.kGi != null) {
            String str3 = this.kGi.forum_id;
            String str4 = this.kGi.forum_name;
            String str5 = this.kGi.title;
            if (this.kGi.baijiahaoData != null) {
                str = this.kGi.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.kGi.baijiahaoData.oriUgcType + "&dvid=" + this.kGi.baijiahaoData.oriUgcVid + "&nid=" + this.kGi.baijiahaoData.oriUgcNid;
            } else {
                str = this.kGi.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.kGi.thumbnail_url;
            String format = (!this.kGi.isBjhVideo || this.kGi.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.kGi.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.kGi.baijiahaoData == null) {
                shareItem.readCount = this.kGi.play_count;
            }
            if (this.kGi.isBjhVideo) {
                shareItem.dqb = format;
            } else {
                shareItem.dqb = "";
            }
            shareItem.linkUrl = str6;
            shareItem.cUA = 2;
            shareItem.extData = str;
            shareItem.dqe = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.dpR = true;
            shareItem.dqd = 12;
            shareItem.dqi = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.kGi.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.kGi.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.kGi.title;
            originalThreadInfo.threadId = this.kGi.thread_id;
            originalThreadInfo.oriUgcInfo = this.kGi.baijiahaoData;
            shareItem.dql = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqe);
            bundle.putInt("obj_type", shareItem.dqi);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUA);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.e.bwk().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eLE) {
            this.fKw = new ForumManageModel(getPageContext());
            this.fKw.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.fKw.getLoadDataMode()) {
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
        this.iHz = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.iHz != null) {
            this.iHz.a(new a.InterfaceC0374a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.iHz != null) {
                            VideoPlayFragment.this.iHz.fm(z2);
                        }
                        if (VideoPlayFragment.this.kGi != null) {
                            if (z2) {
                                VideoPlayFragment.this.kGi.mark_id = VideoPlayFragment.this.kGi.post_id;
                            } else {
                                VideoPlayFragment.this.kGi.mark_id = null;
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
        this.daa = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.dae);
        registerListener(this.cLx);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.kGu = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cSR();
        cSZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSM() {
        if (this.kFY != null && this.kFX != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.kFX.clearAnimation();
            this.kFY.clearAnimation();
            this.kFX.setVisibility(8);
            this.kFY.setVisibility(0);
            this.kFY.startAnimation(scaleAnimation2);
            this.kFX.startAnimation(scaleAnimation);
        }
    }

    private void cSN() {
        if (this.kFY != null && this.kFX != null) {
            this.kFX.clearAnimation();
            this.kFY.clearAnimation();
            this.kFX.setVisibility(0);
            this.kFY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DP(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.kGi != null) {
            if (i == this.kFO) {
                if ("1".equals(this.kGi.is_agreed)) {
                    i2 = 1;
                    this.kGi.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kGi.agree_num, 0) - 1);
                    this.kGi.is_agreed = "0";
                } else {
                    this.kGi.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kGi.agree_num, 0) + 1);
                    this.kGi.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.kGi.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kGi.agree_num, 0) + 1);
                this.kGi.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.cy("tid", this.kGi.thread_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.kFO) {
                anVar.X("obj_type", i2);
            } else {
                anVar.X("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            cSR();
            if (this.kGk != null && i2 == 0) {
                this.kGk.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.kGi.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.kGi.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.kGi.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.kGi.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.kGi.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.kGi.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.kGi.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.kGi.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.kGi));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.kGi != null && !StringUtils.isNull(this.kGi.video_url)) {
            this.mHasInit = true;
            if (this.mIsVisible) {
                buM();
                ajY();
                if (this.kGi != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.cy("tid", this.kGi.thread_id);
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
        if (this.kGv != null && this.kGv.aOr() != null) {
            this.kGv.aOr().hide();
            this.kGm.setVisibility(0);
            this.kGn.setText(StringUtils.isNull(((c) this.kGv.aOr().mp(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        MessageManager.getInstance().unRegisterListener(this.ddt);
        if (this.kGv != null) {
            this.kGv.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisible = z;
        if (!z && this.kGv != null) {
            this.kGn.setText(R.string.reply_something);
            this.kGv.cTi();
        }
        if (this.mHasInit) {
            if (this.mIsVisible && (!this.kGu || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.kGi != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.cy("tid", this.kGi.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.X("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                cSO();
                this.kGu = false;
                return;
            }
            cSN();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cSO() {
        if (this.kGi != null) {
            an anVar = new an("c12590");
            anVar.cy("tid", this.kGi.thread_id);
            anVar.cy("fid", this.kGi.forum_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.X("obj_locate", this.kGo);
            anVar.X(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cy("obj_param1", aq.isEmpty(this.kGi.mRecomWeight) ? "0" : this.kGi.mRecomWeight);
            anVar.cy("extra", aq.isEmpty(this.kGi.mRecomExtra) ? "0" : this.kGi.mRecomExtra);
            anVar.cy("obj_id", this.cOQ);
            anVar.cy(TiebaInitialize.Params.AB_TAG, aq.isEmpty(this.kGi.mRecomAbTag) ? "0" : this.kGi.mRecomAbTag);
            anVar.cy("obj_source", aq.isEmpty(this.kGi.mRecomSource) ? "0" : this.kGi.mRecomSource);
            anVar.cy("obj_type", this.mFromPage);
            anVar.X("is_vertical", 1);
            if (this.kGi.baijiahaoData != null) {
                anVar.cy("obj_param4", this.kGi.baijiahaoData.oriUgcNid);
                anVar.cy("obj_param6", this.kGi.baijiahaoData.oriUgcVid);
                if (this.kGi.baijiahaoData.oriUgcType == 4) {
                    anVar.X("obj_param5", 2);
                } else if (this.kGi.baijiahaoData.oriUgcType == 2) {
                    anVar.X("obj_param5", 3);
                }
            } else {
                anVar.X("obj_param5", 1);
            }
            TiebaStatic.log(anVar);
        }
    }

    private void KC(String str) {
        if (this.jts != null && str != null && !str.equals(this.mVideoUrl)) {
            if (cxU()) {
                ((QuickVideoView) this.jts).setRecoveryState(0);
            }
            this.jts.setVideoPath(str, this.kGi.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.cPf().cPg() || cSU()) {
            cyg();
            if (this.kGe != null) {
                this.kGe.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.kFQ.getVisibility() == 0) {
                this.kFQ.clearAnimation();
                this.kFQ.startAnimation(this.enS);
            }
            if (this.jts != null) {
                this.jts.start();
                buM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buM() {
        if (this.kGi != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.Pj = this.kGi.thread_id;
            yVar.ema = this.kGi.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.kGi.mRecomSource;
            yVar.jwE = this.kGi.mRecomAbTag;
            yVar.jwF = this.kGi.mRecomWeight;
            yVar.jwG = "";
            yVar.cOQ = "";
            yVar.jwI = this.kGi.mMd5;
            if (this.mRect != null) {
                yVar.jwJ = "1";
            } else {
                yVar.jwJ = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.jwK = "1";
                yVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                yVar.jwG = "index";
            }
            com.baidu.tieba.play.l.a(this.kGi.mMd5, "", "1", yVar);
        }
    }

    private void cyg() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cPf().fy(getContext());
        }
    }

    private void pausePlay() {
        if (this.jts != null) {
            this.jts.pause();
        }
    }

    private void stopPlay() {
        if (this.jts != null) {
            if (cxU()) {
                ((QuickVideoView) this.jts).setRecoveryState(5);
            }
            this.jts.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSP() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.kGi.thread_id, this.kGi.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.kGi.forum_id));
        createNormalCfg.setForumName(this.kGi.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.kGi.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSQ() {
        if (this.cLg == null) {
            this.kGp = new com.baidu.tieba.view.a(getActivity());
            this.cLg = new e(getActivity(), this.kGp.aEP());
            this.cLg.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.jts.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.kGp != null) {
            ArrayList arrayList = new ArrayList();
            a.C0629a c0629a = new a.C0629a(this.kGp);
            c0629a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bc.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.cLg.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.cLg.dismiss();
                    if (VideoPlayFragment.this.kGi != null) {
                        boolean z = VideoPlayFragment.this.kGi.post_id != null && VideoPlayFragment.this.kGi.post_id.equals(VideoPlayFragment.this.kGi.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.kGi.thread_id);
                        markData.setPostId(VideoPlayFragment.this.kGi.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.kGi.thread_id);
                        markData.setForumId(VideoPlayFragment.this.kGi.forum_id);
                        if (VideoPlayFragment.this.iHz != null) {
                            VideoPlayFragment.this.iHz.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.iHz.ayL();
                            } else {
                                VideoPlayFragment.this.iHz.ayK();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.kGi != null && this.kGi.post_id != null && this.kGi.post_id.equals(this.kGi.mark_id)) {
                z = true;
            }
            if (z) {
                c0629a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0629a.setText(getResources().getString(R.string.mark));
            }
            if (this.kGi != null && !this.kGi.isBjhVideo) {
                arrayList.add(c0629a);
            }
            a.C0629a c0629a2 = new a.C0629a(getActivity().getString(R.string.delete), this.kGp);
            c0629a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.cLg.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kGi != null) {
                        String str = VideoPlayFragment.this.kGi.thread_id;
                        String str2 = VideoPlayFragment.this.kGi.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.kGi.post_id;
                        if (VideoPlayFragment.this.kGi.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.kGi.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.kGi.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0629a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0629a2);
            if (this.eLE) {
                a.C0629a c0629a3 = new a.C0629a(getActivity().getString(R.string.delete), this.kGp);
                c0629a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.cLg.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.jW(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.kGi != null) {
                                    VideoPlayFragment.this.fKw.a(VideoPlayFragment.this.kGi.forum_id, VideoPlayFragment.this.kGi.forum_name, VideoPlayFragment.this.kGi.thread_id, VideoPlayFragment.this.kGi.post_id, 0, 0, VideoPlayFragment.this.eLE, null);
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
                        aVar.aEA();
                    }
                });
                c0629a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0629a3);
            }
            this.kGp.az(arrayList);
        }
        this.cLg.show();
    }

    private void cSR() {
        if (this.kGi != null) {
            this.kFQ.startLoad(this.kGi.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.kGi.title);
            if (StringUtils.isNull(this.kGi.title) || matcher.matches()) {
                this.kFZ.setVisibility(8);
            } else {
                this.kFZ.setVisibility(0);
                this.kFZ.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.kFZ.setTextColor(R.color.cp_cont_a);
                this.kFZ.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.kFZ.setExpandable(true);
                this.kFZ.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void mm(boolean z) {
                        VideoPlayFragment.this.kGi.isTitleExpanded = z;
                    }
                });
                this.kFZ.setData(this.kGi.title, this.kGi.isTitleExpanded);
            }
            this.kGb.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kGi.comment_num, 0L)));
            this.kGc.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kGi.agree_num, 0L)));
            this.kGd.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kGi.share_num, 0L)));
            if (this.kGi.author_info != null) {
                if (!TextUtils.isEmpty(this.kGi.author_info.bjhAvatar)) {
                    this.kFS.startLoad(this.kGi.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.kGi.author_info.portrait) && this.kGi.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.kFS.startLoad(this.kGi.author_info.portrait, 10, false);
                } else {
                    this.kFS.startLoad(this.kGi.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.kGi.author_info.cPb())) {
                    this.kGl.setVisibility(8);
                } else {
                    this.kGl.setVisibility(0);
                    this.kGl.setText("@" + this.kGi.author_info.cPb());
                }
            }
            if ("1".equals(this.kGi.is_private) && this.kGj.getVisibility() != 0) {
                this.kGh.setVisibility(0);
            } else {
                this.kGh.setVisibility(8);
            }
            if ("1".equals(this.kGi.is_agreed)) {
                am.setImageResource(this.kGk, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.kGk, R.drawable.btn_video_agree);
            }
            if (this.kGi.act_info != null && !StringUtils.isNull(this.kGi.act_info.activity_name) && this.kGj.getVisibility() != 0) {
                this.kGg.setVisibility(0);
                this.kGa.setText(this.kGi.act_info.activity_name);
            } else {
                this.kGg.setVisibility(8);
            }
            cST();
            if (this.kGi.isBjhVideo) {
                this.kFR.setVisibility(8);
            } else {
                this.kFR.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSS() {
        if (this.kGi != null) {
            if ("1".equals(this.kGi.is_agreed)) {
                am.setImageResource(this.kGk, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.kGk, R.drawable.btn_video_agree);
            }
            this.kGc.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kGi.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cST() {
        if (this.eLE || (this.kGi.author_info != null && !"0".equals(this.kGi.author_info.is_follow))) {
            this.kFW.setVisibility(4);
            this.kFW.setClickable(false);
            return;
        }
        this.kFW.setVisibility(0);
        this.kFW.setClickable(true);
    }

    private void btf() {
        if (getActivity() != null) {
            if (this.kGw == null || !this.kGw.isShowing()) {
                this.kGw = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.aGA().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.kGw.aO(inflate);
                this.kGw.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.kGw.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.kGw.jZ(1);
                this.kGw.jX(R.color.cp_cont_b);
                this.kGw.fG(true);
                this.kGw.b(getPageContext());
                this.kGw.aEA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cSU() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
            return true;
        }
        if (!this.mIsVisible || com.baidu.tieba.video.g.cPf().cPg()) {
            return false;
        }
        if (this.kGe != null) {
            this.kGe.setVisibility(0);
        }
        pausePlay();
        btf();
        return false;
    }

    private void ajY() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cSU() || com.baidu.tieba.video.g.cPf().cPg()) && this.jts != null && this.kGe != null) {
            if (this.jts.getParent() == null) {
                cSY();
                cSZ();
            }
            this.jts.b(null);
            this.kGe.setVisibility(8);
            cyg();
            if (this.juG != null) {
                this.juG.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.kGq == null) {
            this.kGq = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.kGq;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
    public void aVj() {
        if (this.jts.isPlaying()) {
            this.jts.pause();
            this.kGe.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cSU() || com.baidu.tieba.video.g.cPf().cPg()) {
            this.jts.start();
            this.kGe.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
    public void u(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.kGr) {
            cSV();
            if (this.kGi != null && "0".equals(this.kGi.is_agreed)) {
                DP(this.kFP);
            }
        }
    }

    private void cSV() {
        if (this.mRootView != null) {
            this.kGr = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.kGt == null) {
                this.kGt = new RelativeLayout.LayoutParams(-2, -2);
                this.kGt.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.kGt);
            }
            if (this.kGs == null) {
                this.kGs = new AnimatorSet();
                this.kGs.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.kGr = false;
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
            this.kGs.setTarget(imageView);
            this.kGs.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.kGs.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
    public void aVk() {
        if (this.kGi != null && this.kGi.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.kGi.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cxU()) {
            return ((QuickVideoView) this.jts).getMediaIDs();
        }
        return null;
    }

    public String cSW() {
        if (cxU()) {
            return ((QuickVideoView) this.jts).getMediaId();
        }
        return null;
    }

    public boolean cSX() {
        if (this.kGv == null || this.kGv.aOr() == null || !this.kGv.aOr().isVisible()) {
            return false;
        }
        this.kGv.aOr().hide();
        this.kGm.setVisibility(0);
        if ((this.kGv.aOr().mp(28) instanceof c) && ((c) this.kGv.aOr().mp(28)).getInputView() != null && ((c) this.kGv.aOr().mp(28)).getInputView().getText() != null) {
            this.kGn.setText(StringUtils.isNull(((c) this.kGv.aOr().mp(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.kGv != null) {
            this.kGv.onActivityResult(i, i2, intent);
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
        if (this.kGv != null && this.kGv.aOr() != null) {
            this.kGv.aOr().onChangeSkinType(i);
        }
        SvgManager.aGA().a(this.Wg, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void cSY() {
        if (this.jts != null && this.jts.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.jts.getView(), 0);
            this.jts.getView().setLayoutParams(layoutParams);
            if (cxU()) {
                ((QuickVideoView) this.jts).setPlayerReuseEnable(true);
                ((QuickVideoView) this.jts).setNeedRecovery(true);
            }
            if (this.kGi != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.Pj = this.kGi.thread_id;
                yVar.ema = this.kGi.forum_id;
                yVar.jwI = this.kGi.mMd5;
                yVar.cOQ = "";
                yVar.mSource = this.kGi.mRecomSource;
                yVar.mAbTag = this.kGi.mRecomAbTag;
                yVar.jwH = 1;
                if (this.kGi.baijiahaoData != null) {
                    if (this.kGi.baijiahaoData.oriUgcType == 2) {
                        yVar.jwH = 3;
                    } else if (this.kGi.baijiahaoData.oriUgcType == 4) {
                        yVar.jwH = 2;
                    }
                }
                yVar.jwF = this.kGi.mRecomWeight;
                if (this.mRect != null) {
                    yVar.jwJ = "1";
                } else {
                    yVar.jwJ = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    yVar.jwK = "1";
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    yVar.jwG = this.mFromPage;
                    yVar.cOQ = this.cOQ;
                    yVar.jwE = this.kGi.mRecomWeight;
                } else {
                    yVar.mLocate = "14";
                }
                this.ekY.setVideoStatsData(yVar);
                this.ekY.jvG = true;
            }
            this.jts.setContinuePlayEnable(true);
            this.jts.setBusiness(this.ekY);
        }
    }

    private void cSZ() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.jts.setOnPreparedListener(this.kGz);
        }
        this.jts.setOnCompletionListener(this.kGy);
        this.jts.setOnOutInfoListener(this.kGx);
    }
}
