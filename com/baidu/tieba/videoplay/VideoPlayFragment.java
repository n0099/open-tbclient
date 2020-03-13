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
    private e cLi;
    private String cOS;
    private boolean eLS;
    private n elm;
    private AlphaAnimation eoh;
    private View fTT;
    private boolean isNewPlayer;
    public com.baidu.tieba.play.a.a jtG;
    private j.b juC;
    private QuickVideoView.c juU;
    private View kGA;
    private TextView kGB;
    private int kGC;
    private com.baidu.tieba.view.a kGD;
    protected Animation kGE;
    private boolean kGF;
    private AnimatorSet kGG;
    private RelativeLayout.LayoutParams kGH;
    private com.baidu.tieba.videoplay.editor.a kGJ;
    com.baidu.tbadk.core.dialog.a kGK;
    private TbImageView kGe;
    public ImageView kGf;
    public HeadImageView kGg;
    public LinearLayout kGh;
    public LinearLayout kGi;
    public LinearLayout kGj;
    public ImageView kGk;
    public ImageView kGl;
    public ImageView kGm;
    public ExpandableTextView kGn;
    public TextView kGo;
    public TextView kGp;
    public TextView kGq;
    public TextView kGr;
    public ImageView kGs;
    private LinearLayout kGt;
    public LinearLayout kGu;
    public LinearLayout kGv;
    public VideoItemData kGw;
    private TextView kGx;
    public ImageView kGy;
    public TextView kGz;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private boolean mIsVisible;
    private int mOriginHeight;
    private int mOriginWidth;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int kGc = 0;
    private int kGd = 1;
    private ForumManageModel fKL = null;
    private com.baidu.tbadk.baseEditMark.a iHN = null;
    private com.baidu.tbadk.coreExtra.model.a dac = null;
    private BdUniqueId MO = BdUniqueId.gen();
    private boolean kGI = false;
    private int playTime = 1;
    private CustomMessageListener dag = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.kGw != null && VideoPlayFragment.this.kGw.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kGw.author_info.user_id) && data != null && VideoPlayFragment.this.kGw.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.MO)) ? false : false;
                    if (data.doi == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.kGw.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.kGw.author_info.is_follow = "0";
                                VideoPlayFragment.this.cSW();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.kGw));
                                    return;
                                }
                                VideoPlayFragment.this.kGw.author_info.is_follow = "1";
                                VideoPlayFragment.this.cSW();
                            }
                        } else {
                            VideoPlayFragment.this.kGw.author_info.is_follow = "0";
                            VideoPlayFragment.this.cSW();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener cLz = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.cSX();
            }
        }
    };
    private CustomMessageListener ddI = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.kGw != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.kGw.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.kGw.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.kGw.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.kGw.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.cSV();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.kGw.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.kGw.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.kGw.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.cSV();
                    }
                }
            }
        }
    };
    private g.e kGL = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.mIsVisible) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.kGe.getVisibility() == 0) {
                    VideoPlayFragment.this.kGe.clearAnimation();
                    VideoPlayFragment.this.kGe.startAnimation(VideoPlayFragment.this.eoh);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a kGM = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.jtG != null) {
                VideoPlayFragment.this.jtG.cyO();
                VideoPlayFragment.this.jtG.seekTo(0);
                VideoPlayFragment.this.jtG.start();
                VideoPlayFragment.this.buP();
                VideoPlayFragment.z(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.cSP();
                }
            }
        }
    };
    private g.f kGN = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            if (VideoPlayFragment.this.jtG != null) {
                VideoPlayFragment.this.jtG.setVolume(1.0f, 1.0f);
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
        registerListener(this.ddI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.kGw = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.kGC = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.cOS = arguments.getString("obj_id");
        if (this.kGw != null && this.kGw.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.kGw.author_info.user_id)) {
            this.eLS = true;
        }
        this.elm = new n(getActivity());
        this.elm.a(this.kGw);
        this.elm.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.j.b
            public void by(int i, int i2) {
                if (VideoPlayFragment.this.juC != null) {
                    VideoPlayFragment.this.juC.by(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.rH("cyber_player_test");
        this.jtG = com.baidu.tieba.play.a.b.F(getContext(), this.isNewPlayer ? 1 : 0);
        cTb();
        this.kGe = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.kGe.setPlaceHolder(4);
        this.kGe.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aFN()) {
            this.fTT = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.fTT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.fTT.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.Wg = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.kGf = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.kGg = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.kGg.setDefaultResource(17170445);
        this.kGg.setPlaceHolder(2);
        this.kGg.setIsRound(true);
        this.kGk = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.kGy = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.kGn = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.kGo = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.kGi = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.kGp = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.kGh = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.kGq = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.kGr = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.kGl = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.kGm = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cSQ();
        this.kGs = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.kGt = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.kGu = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.kGv = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.kGj = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.kGz = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.kGA = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.kGA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.kGA.setVisibility(4);
                    if (VideoPlayFragment.this.kGJ != null && VideoPlayFragment.this.kGJ.aOu() != null) {
                        VideoPlayFragment.this.kGJ.aOu().display();
                        if (VideoPlayFragment.this.kGw != null) {
                            VideoPlayFragment.this.kGJ.c(VideoPlayFragment.this.kGw);
                        }
                    }
                    if (VideoPlayFragment.this.kGw != null) {
                        an anVar = new an("c13025");
                        anVar.cy("tid", VideoPlayFragment.this.kGw.thread_id);
                        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.cy("fid", VideoPlayFragment.this.kGw.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.kGB = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.kGx = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.kGx.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.kGx.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_download_link_url", null);
        this.kGx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aGG().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cSU();
        this.kGg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kGw != null && VideoPlayFragment.this.kGw.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kGw.author_info.user_id) && VideoPlayFragment.this.kGw != null && VideoPlayFragment.this.kGw.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kGw.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.cy("tid", VideoPlayFragment.this.kGw.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kGw != null && VideoPlayFragment.this.kGw.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.kGw.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.cy("tid", VideoPlayFragment.this.kGw.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kGn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cSS();
            }
        });
        this.Wg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kGw != null && !StringUtils.isNull(VideoPlayFragment.this.kGw.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.kGw.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.kGf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cST();
            }
        });
        this.kGi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.kGw)) {
                    VideoPlayFragment.this.cSS();
                    an anVar = new an("c12796");
                    anVar.cy("tid", VideoPlayFragment.this.kGw.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kGh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.DP(VideoPlayFragment.this.kGc);
            }
        });
        this.kGj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aId();
                an anVar = new an("c12797");
                anVar.cy("tid", VideoPlayFragment.this.kGw.thread_id);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cy("tid", VideoPlayFragment.this.kGw.thread_id);
                anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.X("obj_locate", 19);
                TiebaStatic.log(anVar2);
            }
        });
        this.kGk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kGw != null && VideoPlayFragment.this.kGw.author_info != null) {
                    VideoPlayFragment.this.dac.a(true, VideoPlayFragment.this.kGw.author_info.portrait, VideoPlayFragment.this.kGw.author_info.user_id, false, "6", VideoPlayFragment.this.MO, VideoPlayFragment.this.kGw.forum_id, "0");
                    VideoPlayFragment.this.kGw.author_info.is_follow = "1";
                    VideoPlayFragment.this.cSW();
                }
            }
        });
        this.eoh = new AlphaAnimation(1.0f, 0.0f);
        this.eoh.setDuration(100L);
        this.eoh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.kGe != null) {
                    VideoPlayFragment.this.kGe.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mOriginWidth = this.mRect.right - this.mRect.left;
            this.mOriginHeight = this.mRect.bottom - this.mRect.top;
            this.kGe.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.kGe.getWidth();
                    int height = VideoPlayFragment.this.kGe.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kGw.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kGw.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kGw.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kGw.video_height, 0.0f);
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
                            VideoPlayFragment.this.kGe.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.mOriginHeight > 0 || VideoPlayFragment.this.mOriginWidth <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mOriginWidth;
                                f = i / VideoPlayFragment.this.mOriginHeight;
                            }
                            VideoPlayFragment.this.kGe.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.kGe.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
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
                    VideoPlayFragment.this.kGe.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.mOriginHeight > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.kGe.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.kGe.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
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
            this.kGe.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.kGe.getWidth();
                    int height = VideoPlayFragment.this.kGe.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kGw.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kGw.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kGw.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kGw.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.kGe.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.kGe.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cfN();
        if (this.mIsVisible) {
            cSR();
        }
        if (this.kGw != null && !StringUtils.isNull(this.kGw.video_url)) {
            KD(this.kGw.video_url);
        }
        return this.mRootView;
    }

    public boolean cxX() {
        return !this.isNewPlayer && (this.jtG instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.juC = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.juU = cVar;
    }

    private void cfN() {
        this.kGJ = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dV(getActivity());
        if (this.kGJ != null && this.kGw != null) {
            this.kGJ.a(getPageContext());
            this.kGJ.aw(this.kGw.thread_id, this.kGw.forum_id, this.kGw.forum_name);
            this.kGJ.a(new a.InterfaceC0628a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0628a
                public void tz(boolean z) {
                    VideoPlayFragment.this.kGA.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.kGB.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.kGB.setText(StringUtils.isNull(((c) VideoPlayFragment.this.kGJ.aOu().mp(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.kGw != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kGw.comment_num, 0L) + 1;
                        VideoPlayFragment.this.kGw.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.kGp.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.kGJ.aOu(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aId() {
        String str;
        String str2;
        if (this.kGw != null) {
            String str3 = this.kGw.forum_id;
            String str4 = this.kGw.forum_name;
            String str5 = this.kGw.title;
            if (this.kGw.baijiahaoData != null) {
                str = this.kGw.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.kGw.baijiahaoData.oriUgcType + "&dvid=" + this.kGw.baijiahaoData.oriUgcVid + "&nid=" + this.kGw.baijiahaoData.oriUgcNid;
            } else {
                str = this.kGw.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.kGw.thumbnail_url;
            String format = (!this.kGw.isBjhVideo || this.kGw.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.kGw.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.kGw.baijiahaoData == null) {
                shareItem.readCount = this.kGw.play_count;
            }
            if (this.kGw.isBjhVideo) {
                shareItem.dqp = format;
            } else {
                shareItem.dqp = "";
            }
            shareItem.linkUrl = str6;
            shareItem.cUC = 2;
            shareItem.extData = str;
            shareItem.dqs = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.dqf = true;
            shareItem.dqr = 12;
            shareItem.dqw = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.kGw.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.kGw.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.kGw.title;
            originalThreadInfo.threadId = this.kGw.thread_id;
            originalThreadInfo.oriUgcInfo = this.kGw.baijiahaoData;
            shareItem.dqz = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqs);
            bundle.putInt("obj_type", shareItem.dqw);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUC);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.e.bwn().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eLS) {
            this.fKL = new ForumManageModel(getPageContext());
            this.fKL.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.fKL.getLoadDataMode()) {
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
        this.iHN = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.iHN != null) {
            this.iHN.a(new a.InterfaceC0374a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.iHN != null) {
                            VideoPlayFragment.this.iHN.fm(z2);
                        }
                        if (VideoPlayFragment.this.kGw != null) {
                            if (z2) {
                                VideoPlayFragment.this.kGw.mark_id = VideoPlayFragment.this.kGw.post_id;
                            } else {
                                VideoPlayFragment.this.kGw.mark_id = null;
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
        this.dac = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.dag);
        registerListener(this.cLz);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.kGI = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cSU();
        cTc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSP() {
        if (this.kGm != null && this.kGl != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.kGl.clearAnimation();
            this.kGm.clearAnimation();
            this.kGl.setVisibility(8);
            this.kGm.setVisibility(0);
            this.kGm.startAnimation(scaleAnimation2);
            this.kGl.startAnimation(scaleAnimation);
        }
    }

    private void cSQ() {
        if (this.kGm != null && this.kGl != null) {
            this.kGl.clearAnimation();
            this.kGm.clearAnimation();
            this.kGl.setVisibility(0);
            this.kGm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DP(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.kGw != null) {
            if (i == this.kGc) {
                if ("1".equals(this.kGw.is_agreed)) {
                    i2 = 1;
                    this.kGw.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kGw.agree_num, 0) - 1);
                    this.kGw.is_agreed = "0";
                } else {
                    this.kGw.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kGw.agree_num, 0) + 1);
                    this.kGw.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.kGw.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kGw.agree_num, 0) + 1);
                this.kGw.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.cy("tid", this.kGw.thread_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.kGc) {
                anVar.X("obj_type", i2);
            } else {
                anVar.X("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            cSU();
            if (this.kGy != null && i2 == 0) {
                this.kGy.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.kGw.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.kGw.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.kGw.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.kGw.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.kGw.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.kGw.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.kGw.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.kGw.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.kGw));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.kGw != null && !StringUtils.isNull(this.kGw.video_url)) {
            this.mHasInit = true;
            if (this.mIsVisible) {
                buP();
                aka();
                if (this.kGw != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.cy("tid", this.kGw.thread_id);
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
        if (this.kGJ != null && this.kGJ.aOu() != null) {
            this.kGJ.aOu().hide();
            this.kGA.setVisibility(0);
            this.kGB.setText(StringUtils.isNull(((c) this.kGJ.aOu().mp(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        MessageManager.getInstance().unRegisterListener(this.ddI);
        if (this.kGJ != null) {
            this.kGJ.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisible = z;
        if (!z && this.kGJ != null) {
            this.kGB.setText(R.string.reply_something);
            this.kGJ.cTl();
        }
        if (this.mHasInit) {
            if (this.mIsVisible && (!this.kGI || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.kGw != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.cy("tid", this.kGw.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.X("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                cSR();
                this.kGI = false;
                return;
            }
            cSQ();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cSR() {
        if (this.kGw != null) {
            an anVar = new an("c12590");
            anVar.cy("tid", this.kGw.thread_id);
            anVar.cy("fid", this.kGw.forum_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.X("obj_locate", this.kGC);
            anVar.X(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cy("obj_param1", aq.isEmpty(this.kGw.mRecomWeight) ? "0" : this.kGw.mRecomWeight);
            anVar.cy("extra", aq.isEmpty(this.kGw.mRecomExtra) ? "0" : this.kGw.mRecomExtra);
            anVar.cy("obj_id", this.cOS);
            anVar.cy(TiebaInitialize.Params.AB_TAG, aq.isEmpty(this.kGw.mRecomAbTag) ? "0" : this.kGw.mRecomAbTag);
            anVar.cy("obj_source", aq.isEmpty(this.kGw.mRecomSource) ? "0" : this.kGw.mRecomSource);
            anVar.cy("obj_type", this.mFromPage);
            anVar.X("is_vertical", 1);
            if (this.kGw.baijiahaoData != null) {
                anVar.cy("obj_param4", this.kGw.baijiahaoData.oriUgcNid);
                anVar.cy("obj_param6", this.kGw.baijiahaoData.oriUgcVid);
                if (this.kGw.baijiahaoData.oriUgcType == 4) {
                    anVar.X("obj_param5", 2);
                } else if (this.kGw.baijiahaoData.oriUgcType == 2) {
                    anVar.X("obj_param5", 3);
                }
            } else {
                anVar.X("obj_param5", 1);
            }
            TiebaStatic.log(anVar);
        }
    }

    private void KD(String str) {
        if (this.jtG != null && str != null && !str.equals(this.mVideoUrl)) {
            if (cxX()) {
                ((QuickVideoView) this.jtG).setRecoveryState(0);
            }
            this.jtG.setVideoPath(str, this.kGw.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.cPi().cPj() || cSX()) {
            cyj();
            if (this.kGs != null) {
                this.kGs.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.kGe.getVisibility() == 0) {
                this.kGe.clearAnimation();
                this.kGe.startAnimation(this.eoh);
            }
            if (this.jtG != null) {
                this.jtG.start();
                buP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buP() {
        if (this.kGw != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.Pj = this.kGw.thread_id;
            yVar.emo = this.kGw.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.kGw.mRecomSource;
            yVar.jwS = this.kGw.mRecomAbTag;
            yVar.jwT = this.kGw.mRecomWeight;
            yVar.jwU = "";
            yVar.cOS = "";
            yVar.jwW = this.kGw.mMd5;
            if (this.mRect != null) {
                yVar.jwX = "1";
            } else {
                yVar.jwX = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.jwY = "1";
                yVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                yVar.jwU = "index";
            }
            com.baidu.tieba.play.l.a(this.kGw.mMd5, "", "1", yVar);
        }
    }

    private void cyj() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cPi().fy(getContext());
        }
    }

    private void pausePlay() {
        if (this.jtG != null) {
            this.jtG.pause();
        }
    }

    private void stopPlay() {
        if (this.jtG != null) {
            if (cxX()) {
                ((QuickVideoView) this.jtG).setRecoveryState(5);
            }
            this.jtG.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSS() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.kGw.thread_id, this.kGw.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.kGw.forum_id));
        createNormalCfg.setForumName(this.kGw.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.kGw.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cST() {
        if (this.cLi == null) {
            this.kGD = new com.baidu.tieba.view.a(getActivity());
            this.cLi = new e(getActivity(), this.kGD.aER());
            this.cLi.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.jtG.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.kGD != null) {
            ArrayList arrayList = new ArrayList();
            a.C0629a c0629a = new a.C0629a(this.kGD);
            c0629a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bc.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.cLi.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.cLi.dismiss();
                    if (VideoPlayFragment.this.kGw != null) {
                        boolean z = VideoPlayFragment.this.kGw.post_id != null && VideoPlayFragment.this.kGw.post_id.equals(VideoPlayFragment.this.kGw.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.kGw.thread_id);
                        markData.setPostId(VideoPlayFragment.this.kGw.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.kGw.thread_id);
                        markData.setForumId(VideoPlayFragment.this.kGw.forum_id);
                        if (VideoPlayFragment.this.iHN != null) {
                            VideoPlayFragment.this.iHN.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.iHN.ayN();
                            } else {
                                VideoPlayFragment.this.iHN.ayM();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.kGw != null && this.kGw.post_id != null && this.kGw.post_id.equals(this.kGw.mark_id)) {
                z = true;
            }
            if (z) {
                c0629a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0629a.setText(getResources().getString(R.string.mark));
            }
            if (this.kGw != null && !this.kGw.isBjhVideo) {
                arrayList.add(c0629a);
            }
            a.C0629a c0629a2 = new a.C0629a(getActivity().getString(R.string.delete), this.kGD);
            c0629a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.cLi.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kGw != null) {
                        String str = VideoPlayFragment.this.kGw.thread_id;
                        String str2 = VideoPlayFragment.this.kGw.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.kGw.post_id;
                        if (VideoPlayFragment.this.kGw.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.kGw.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.kGw.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0629a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0629a2);
            if (this.eLS) {
                a.C0629a c0629a3 = new a.C0629a(getActivity().getString(R.string.delete), this.kGD);
                c0629a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.cLi.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.jW(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.kGw != null) {
                                    VideoPlayFragment.this.fKL.a(VideoPlayFragment.this.kGw.forum_id, VideoPlayFragment.this.kGw.forum_name, VideoPlayFragment.this.kGw.thread_id, VideoPlayFragment.this.kGw.post_id, 0, 0, VideoPlayFragment.this.eLS, null);
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
            this.kGD.az(arrayList);
        }
        this.cLi.show();
    }

    private void cSU() {
        if (this.kGw != null) {
            this.kGe.startLoad(this.kGw.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.kGw.title);
            if (StringUtils.isNull(this.kGw.title) || matcher.matches()) {
                this.kGn.setVisibility(8);
            } else {
                this.kGn.setVisibility(0);
                this.kGn.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.kGn.setTextColor(R.color.cp_cont_a);
                this.kGn.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.kGn.setExpandable(true);
                this.kGn.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void mm(boolean z) {
                        VideoPlayFragment.this.kGw.isTitleExpanded = z;
                    }
                });
                this.kGn.setData(this.kGw.title, this.kGw.isTitleExpanded);
            }
            this.kGp.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kGw.comment_num, 0L)));
            this.kGq.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kGw.agree_num, 0L)));
            this.kGr.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kGw.share_num, 0L)));
            if (this.kGw.author_info != null) {
                if (!TextUtils.isEmpty(this.kGw.author_info.bjhAvatar)) {
                    this.kGg.startLoad(this.kGw.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.kGw.author_info.portrait) && this.kGw.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.kGg.startLoad(this.kGw.author_info.portrait, 10, false);
                } else {
                    this.kGg.startLoad(this.kGw.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.kGw.author_info.cPe())) {
                    this.kGz.setVisibility(8);
                } else {
                    this.kGz.setVisibility(0);
                    this.kGz.setText("@" + this.kGw.author_info.cPe());
                }
            }
            if ("1".equals(this.kGw.is_private) && this.kGx.getVisibility() != 0) {
                this.kGv.setVisibility(0);
            } else {
                this.kGv.setVisibility(8);
            }
            if ("1".equals(this.kGw.is_agreed)) {
                am.setImageResource(this.kGy, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.kGy, R.drawable.btn_video_agree);
            }
            if (this.kGw.act_info != null && !StringUtils.isNull(this.kGw.act_info.activity_name) && this.kGx.getVisibility() != 0) {
                this.kGu.setVisibility(0);
                this.kGo.setText(this.kGw.act_info.activity_name);
            } else {
                this.kGu.setVisibility(8);
            }
            cSW();
            if (this.kGw.isBjhVideo) {
                this.kGf.setVisibility(8);
            } else {
                this.kGf.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSV() {
        if (this.kGw != null) {
            if ("1".equals(this.kGw.is_agreed)) {
                am.setImageResource(this.kGy, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.kGy, R.drawable.btn_video_agree);
            }
            this.kGq.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kGw.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSW() {
        if (this.eLS || (this.kGw.author_info != null && !"0".equals(this.kGw.author_info.is_follow))) {
            this.kGk.setVisibility(4);
            this.kGk.setClickable(false);
            return;
        }
        this.kGk.setVisibility(0);
        this.kGk.setClickable(true);
    }

    private void bti() {
        if (getActivity() != null) {
            if (this.kGK == null || !this.kGK.isShowing()) {
                this.kGK = new com.baidu.tbadk.core.dialog.a(getActivity());
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
                this.kGK.aO(inflate);
                this.kGK.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.kGK.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.kGK.jZ(1);
                this.kGK.jX(R.color.cp_cont_b);
                this.kGK.fG(true);
                this.kGK.b(getPageContext());
                this.kGK.aEC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cSX() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
            return true;
        }
        if (!this.mIsVisible || com.baidu.tieba.video.g.cPi().cPj()) {
            return false;
        }
        if (this.kGs != null) {
            this.kGs.setVisibility(0);
        }
        pausePlay();
        bti();
        return false;
    }

    private void aka() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cSX() || com.baidu.tieba.video.g.cPi().cPj()) && this.jtG != null && this.kGs != null) {
            if (this.jtG.getParent() == null) {
                cTb();
                cTc();
            }
            this.jtG.b(null);
            this.kGs.setVisibility(8);
            cyj();
            if (this.juU != null) {
                this.juU.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.kGE == null) {
            this.kGE = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.kGE;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
    public void aVm() {
        if (this.jtG.isPlaying()) {
            this.jtG.pause();
            this.kGs.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cSX() || com.baidu.tieba.video.g.cPi().cPj()) {
            this.jtG.start();
            this.kGs.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
    public void u(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.kGF) {
            cSY();
            if (this.kGw != null && "0".equals(this.kGw.is_agreed)) {
                DP(this.kGd);
            }
        }
    }

    private void cSY() {
        if (this.mRootView != null) {
            this.kGF = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.kGH == null) {
                this.kGH = new RelativeLayout.LayoutParams(-2, -2);
                this.kGH.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.kGH);
            }
            if (this.kGG == null) {
                this.kGG = new AnimatorSet();
                this.kGG.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.kGF = false;
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
            this.kGG.setTarget(imageView);
            this.kGG.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.kGG.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
    public void aVn() {
        if (this.kGw != null && this.kGw.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.kGw.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cxX()) {
            return ((QuickVideoView) this.jtG).getMediaIDs();
        }
        return null;
    }

    public String cSZ() {
        if (cxX()) {
            return ((QuickVideoView) this.jtG).getMediaId();
        }
        return null;
    }

    public boolean cTa() {
        if (this.kGJ == null || this.kGJ.aOu() == null || !this.kGJ.aOu().isVisible()) {
            return false;
        }
        this.kGJ.aOu().hide();
        this.kGA.setVisibility(0);
        if ((this.kGJ.aOu().mp(28) instanceof c) && ((c) this.kGJ.aOu().mp(28)).getInputView() != null && ((c) this.kGJ.aOu().mp(28)).getInputView().getText() != null) {
            this.kGB.setText(StringUtils.isNull(((c) this.kGJ.aOu().mp(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.kGJ != null) {
            this.kGJ.onActivityResult(i, i2, intent);
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
        if (this.kGJ != null && this.kGJ.aOu() != null) {
            this.kGJ.aOu().onChangeSkinType(i);
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

    public void cTb() {
        if (this.jtG != null && this.jtG.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.jtG.getView(), 0);
            this.jtG.getView().setLayoutParams(layoutParams);
            if (cxX()) {
                ((QuickVideoView) this.jtG).setPlayerReuseEnable(true);
                ((QuickVideoView) this.jtG).setNeedRecovery(true);
            }
            if (this.kGw != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.Pj = this.kGw.thread_id;
                yVar.emo = this.kGw.forum_id;
                yVar.jwW = this.kGw.mMd5;
                yVar.cOS = "";
                yVar.mSource = this.kGw.mRecomSource;
                yVar.mAbTag = this.kGw.mRecomAbTag;
                yVar.jwV = 1;
                if (this.kGw.baijiahaoData != null) {
                    if (this.kGw.baijiahaoData.oriUgcType == 2) {
                        yVar.jwV = 3;
                    } else if (this.kGw.baijiahaoData.oriUgcType == 4) {
                        yVar.jwV = 2;
                    }
                }
                yVar.jwT = this.kGw.mRecomWeight;
                if (this.mRect != null) {
                    yVar.jwX = "1";
                } else {
                    yVar.jwX = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    yVar.jwY = "1";
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    yVar.jwU = this.mFromPage;
                    yVar.cOS = this.cOS;
                    yVar.jwS = this.kGw.mRecomWeight;
                } else {
                    yVar.mLocate = "14";
                }
                this.elm.setVideoStatsData(yVar);
                this.elm.jvU = true;
            }
            this.jtG.setContinuePlayEnable(true);
            this.jtG.setBusiness(this.elm);
        }
    }

    private void cTc() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.jtG.setOnPreparedListener(this.kGN);
        }
        this.jtG.setOnCompletionListener(this.kGM);
        this.jtG.setOnOutInfoListener(this.kGL);
    }
}
