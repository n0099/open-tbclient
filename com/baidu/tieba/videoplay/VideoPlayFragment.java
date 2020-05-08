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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0453a {
    public ImageView aox;
    private boolean cYu;
    private e dkF;
    private String dop;
    private n ePh;
    private AlphaAnimation eSa;
    private boolean fqL;
    private View gzx;
    private int hah;
    private boolean isNewPlayer;
    private j.b kfZ;
    public com.baidu.tieba.play.a.a kfd;
    private QuickVideoView.c kgr;
    private TbImageView lrV;
    public ImageView lrW;
    public HeadImageView lrX;
    public LinearLayout lrY;
    public LinearLayout lrZ;
    private com.baidu.tieba.videoplay.editor.a lsB;
    com.baidu.tbadk.core.dialog.a lsC;
    public LinearLayout lsa;
    public ImageView lsb;
    public ImageView lsc;
    public ImageView lsd;
    public ExpandableTextView lse;
    public TextView lsf;
    public TextView lsg;
    public TextView lsh;
    public TextView lsi;
    public ImageView lsj;
    private LinearLayout lsk;
    public LinearLayout lsl;
    public LinearLayout lsm;
    public VideoItemData lsn;
    private TextView lso;
    public ImageView lsp;
    public TextView lsq;
    private View lsr;
    private TextView lss;
    private int lst;
    private int lsu;
    private com.baidu.tieba.view.a lsv;
    protected Animation lsw;
    private boolean lsx;
    private AnimatorSet lsy;
    private RelativeLayout.LayoutParams lsz;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int lrT = 0;
    private int lrU = 1;
    private ForumManageModel gqg = null;
    private com.baidu.tbadk.baseEditMark.a jtz = null;
    private com.baidu.tbadk.coreExtra.model.a dzH = null;
    private BdUniqueId afD = BdUniqueId.gen();
    private boolean lsA = false;
    private int playTime = 1;
    private CustomMessageListener dzL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.lsn != null && VideoPlayFragment.this.lsn.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.lsn.author_info.user_id) && data != null && VideoPlayFragment.this.lsn.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.afD)) ? false : false;
                    if (data.dOt == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.lsn.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.lsn.author_info.is_follow = "0";
                                VideoPlayFragment.this.dea();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.cYu) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.lsn));
                                    return;
                                }
                                VideoPlayFragment.this.lsn.author_info.is_follow = "1";
                                VideoPlayFragment.this.dea();
                            }
                        } else {
                            VideoPlayFragment.this.lsn.author_info.is_follow = "0";
                            VideoPlayFragment.this.dea();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener dkW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.deb();
            }
        }
    };
    private CustomMessageListener dDy = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.lsn != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.lsn.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.lsn.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.lsn.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.lsn.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.ddZ();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.lsn.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.lsn.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.lsn.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.ddZ();
                    }
                }
            }
        }
    };
    private g.e lsD = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.cYu) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.lrV.getVisibility() == 0) {
                    VideoPlayFragment.this.lrV.clearAnimation();
                    VideoPlayFragment.this.lrV.startAnimation(VideoPlayFragment.this.eSa);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a lsE = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.kfd != null) {
                VideoPlayFragment.this.kfd.cJJ();
                VideoPlayFragment.this.kfd.seekTo(0);
                VideoPlayFragment.this.kfd.start();
                VideoPlayFragment.this.bEE();
                VideoPlayFragment.z(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.ddT();
                }
            }
        }
    };
    private g.f lsF = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            if (VideoPlayFragment.this.kfd != null) {
                VideoPlayFragment.this.kfd.setVolume(1.0f, 1.0f);
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
        registerListener(this.dDy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.lsn = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.lsu = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.dop = arguments.getString("obj_id");
        if (this.lsn != null && this.lsn.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.lsn.author_info.user_id)) {
            this.fqL = true;
        }
        this.ePh = new n(getActivity());
        this.ePh.a(this.lsn);
        this.ePh.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.j.b
            public void bE(int i, int i2) {
                if (VideoPlayFragment.this.kfZ != null) {
                    VideoPlayFragment.this.kfZ.bE(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.sY("cyber_player_test") || b.sX("cyber_player_test");
        this.kfd = com.baidu.tieba.play.a.b.A(getContext(), this.isNewPlayer ? 1 : 0);
        def();
        this.lrV = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.lrV.setPlaceHolder(4);
        this.lrV.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aOd()) {
            this.gzx = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.gzx.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.gzx.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aox = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.lrW = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.lrX = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.lrX.setDefaultResource(17170445);
        this.lrX.setPlaceHolder(2);
        this.lrX.setIsRound(true);
        this.lsb = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.lsp = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.lse = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.lsf = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.lrZ = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.lsg = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.lrY = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.lsh = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.lsi = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.lsc = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.lsd = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        ddU();
        this.lsj = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.lsk = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.lsl = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.lsm = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.lsa = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.lsq = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.lsr = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.lsr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.lsr.setVisibility(4);
                    if (VideoPlayFragment.this.lsB != null && VideoPlayFragment.this.lsB.aWN() != null) {
                        VideoPlayFragment.this.lsB.aWN().display();
                        if (VideoPlayFragment.this.lsn != null) {
                            VideoPlayFragment.this.lsB.c(VideoPlayFragment.this.lsn);
                        }
                    }
                    if (VideoPlayFragment.this.lsn != null) {
                        an anVar = new an("c13025");
                        anVar.cI("tid", VideoPlayFragment.this.lsn.thread_id);
                        anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.cI("fid", VideoPlayFragment.this.lsn.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.lss = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.lso = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.lso.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.lso.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aNT().getString("nani_key_download_link_url", null);
        this.lso.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aOV().a((TbPageContext) i.G(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        ddY();
        this.lrX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.lsn != null && VideoPlayFragment.this.lsn.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.lsn.author_info.user_id) && VideoPlayFragment.this.lsn != null && VideoPlayFragment.this.lsn.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.lsn.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.cI("tid", VideoPlayFragment.this.lsn.thread_id);
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.lsl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.lsn != null && VideoPlayFragment.this.lsn.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.lsn.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.cI("tid", VideoPlayFragment.this.lsn.thread_id);
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.lse.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.ddW();
            }
        });
        this.aox.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.lsn != null && !StringUtils.isNull(VideoPlayFragment.this.lsn.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.lsn.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.lrW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.ddX();
            }
        });
        this.lrZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.lsn)) {
                    VideoPlayFragment.this.ddW();
                    an anVar = new an("c12796");
                    anVar.cI("tid", VideoPlayFragment.this.lsn.thread_id);
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.lrY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Ez(VideoPlayFragment.this.lrT);
            }
        });
        this.lsa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aQA();
                an anVar = new an("c12797");
                anVar.cI("tid", VideoPlayFragment.this.lsn.thread_id);
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cI("tid", VideoPlayFragment.this.lsn.thread_id);
                anVar2.cI("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.af("obj_locate", 19);
                TiebaStatic.log(anVar2);
            }
        });
        this.lsb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.lsn != null && VideoPlayFragment.this.lsn.author_info != null) {
                    VideoPlayFragment.this.dzH.a(true, VideoPlayFragment.this.lsn.author_info.portrait, VideoPlayFragment.this.lsn.author_info.user_id, false, "6", VideoPlayFragment.this.afD, VideoPlayFragment.this.lsn.forum_id, "0");
                    VideoPlayFragment.this.lsn.author_info.is_follow = "1";
                    VideoPlayFragment.this.dea();
                }
            }
        });
        this.eSa = new AlphaAnimation(1.0f, 0.0f);
        this.eSa.setDuration(100L);
        this.eSa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.lrV != null) {
                    VideoPlayFragment.this.lrV.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.lst = this.mRect.right - this.mRect.left;
            this.hah = this.mRect.bottom - this.mRect.top;
            this.lrV.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.lrV.getWidth();
                    int height = VideoPlayFragment.this.lrV.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lsn.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lsn.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lsn.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lsn.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.lst, VideoPlayFragment.this.hah);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.lrV.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hah > 0 || VideoPlayFragment.this.lst <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.lst;
                                f = i / VideoPlayFragment.this.hah;
                            }
                            VideoPlayFragment.this.lrV.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.lrV.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.cYu) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.lst, VideoPlayFragment.this.hah);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.lrV.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hah > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.lrV.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.lrV.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.cYu) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.lrV.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.lrV.getWidth();
                    int height = VideoPlayFragment.this.lrV.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lsn.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lsn.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lsn.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lsn.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.lrV.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.lrV.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cqL();
        if (this.cYu) {
            ddV();
        }
        if (this.lsn != null && !StringUtils.isNull(this.lsn.video_url)) {
            setVideoInfo(this.lsn.video_url);
        }
        return this.mRootView;
    }

    public boolean cIS() {
        return !this.isNewPlayer && (this.kfd instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.kfZ = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.kgr = cVar;
    }

    private void cqL() {
        this.lsB = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dw(getActivity());
        if (this.lsB != null && this.lsn != null) {
            this.lsB.a(getPageContext());
            this.lsB.av(this.lsn.thread_id, this.lsn.forum_id, this.lsn.forum_name);
            this.lsB.a(new a.InterfaceC0691a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0691a
                public void uH(boolean z) {
                    VideoPlayFragment.this.lsr.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.lss.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.lss.setText(StringUtils.isNull(((c) VideoPlayFragment.this.lsB.aWN().mD(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.lsn != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.lsn.comment_num, 0L) + 1;
                        VideoPlayFragment.this.lsn.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.lsg.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.lsB.aWN(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQA() {
        String str;
        String str2;
        if (this.lsn != null) {
            String str3 = this.lsn.forum_id;
            String str4 = this.lsn.forum_name;
            String str5 = this.lsn.title;
            if (this.lsn.baijiahaoData != null) {
                str = this.lsn.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.lsn.baijiahaoData.oriUgcType + "&dvid=" + this.lsn.baijiahaoData.oriUgcVid + "&nid=" + this.lsn.baijiahaoData.oriUgcNid;
            } else {
                str = this.lsn.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.lsn.thumbnail_url;
            String format = (!this.lsn.isBjhVideo || this.lsn.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.lsn.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.lsn.baijiahaoData == null) {
                shareItem.readCount = this.lsn.play_count;
            }
            if (this.lsn.isBjhVideo) {
                shareItem.dQA = format;
            } else {
                shareItem.dQA = "";
            }
            shareItem.linkUrl = str6;
            shareItem.due = 2;
            shareItem.extData = str;
            shareItem.dQD = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.dQq = true;
            shareItem.dQC = 12;
            shareItem.dQH = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.lsn.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.lsn.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.lsn.title;
            originalThreadInfo.threadId = this.lsn.thread_id;
            originalThreadInfo.oriUgcInfo = this.lsn.baijiahaoData;
            shareItem.dQK = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dQD);
            bundle.putInt("obj_type", shareItem.dQH);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.due);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.e.bGc().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fqL) {
            this.gqg = new ForumManageModel(getPageContext());
            this.gqg.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.gqg.getLoadDataMode()) {
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
        this.jtz = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.jtz != null) {
            this.jtz.a(new a.InterfaceC0425a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0425a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.jtz != null) {
                            VideoPlayFragment.this.jtz.gk(z2);
                        }
                        if (VideoPlayFragment.this.lsn != null) {
                            if (z2) {
                                VideoPlayFragment.this.lsn.mark_id = VideoPlayFragment.this.lsn.post_id;
                            } else {
                                VideoPlayFragment.this.lsn.mark_id = null;
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
        this.dzH = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.dzL);
        registerListener(this.dkW);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.lsA = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ddY();
        deg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddT() {
        if (this.lsd != null && this.lsc != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.lsc.clearAnimation();
            this.lsd.clearAnimation();
            this.lsc.setVisibility(8);
            this.lsd.setVisibility(0);
            this.lsd.startAnimation(scaleAnimation2);
            this.lsc.startAnimation(scaleAnimation);
        }
    }

    private void ddU() {
        if (this.lsd != null && this.lsc != null) {
            this.lsc.clearAnimation();
            this.lsd.clearAnimation();
            this.lsc.setVisibility(0);
            this.lsd.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ez(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.lsn != null) {
            if (i == this.lrT) {
                if ("1".equals(this.lsn.is_agreed)) {
                    i2 = 1;
                    this.lsn.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.lsn.agree_num, 0) - 1);
                    this.lsn.is_agreed = "0";
                } else {
                    this.lsn.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.lsn.agree_num, 0) + 1);
                    this.lsn.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.lsn.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.lsn.agree_num, 0) + 1);
                this.lsn.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.cI("tid", this.lsn.thread_id);
            anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.lrT) {
                anVar.af("obj_type", i2);
            } else {
                anVar.af("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            ddY();
            if (this.lsp != null && i2 == 0) {
                this.lsp.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.lsn.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.lsn.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.lsn.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.lsn.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.lsn.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.lsn.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.lsn.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.lsn.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.lsn));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.lsn != null && !StringUtils.isNull(this.lsn.video_url)) {
            this.mHasInit = true;
            if (this.cYu) {
                bEE();
                asn();
                if (this.lsn != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.cI("tid", this.lsn.thread_id);
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.af("obj_type", 0);
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            asl();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        asl();
        if (this.lsB != null && this.lsB.aWN() != null) {
            this.lsB.aWN().hide();
            this.lsr.setVisibility(0);
            this.lss.setText(StringUtils.isNull(((c) this.lsB.aWN().mD(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        MessageManager.getInstance().unRegisterListener(this.dDy);
        if (this.lsB != null) {
            this.lsB.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.cYu = z;
        if (!z && this.lsB != null) {
            this.lss.setText(R.string.reply_something);
            this.lsB.dep();
        }
        if (this.mHasInit) {
            if (this.cYu && (!this.lsA || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.lsn != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.cI("tid", this.lsn.thread_id);
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.af("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                ddV();
                this.lsA = false;
                return;
            }
            ddU();
            this.playTime = 1;
            asl();
        }
    }

    private void ddV() {
        if (this.lsn != null) {
            an anVar = new an("c12590");
            anVar.cI("tid", this.lsn.thread_id);
            anVar.cI("fid", this.lsn.forum_id);
            anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.af("obj_locate", this.lsu);
            anVar.af(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cI("obj_param1", aq.isEmpty(this.lsn.mRecomWeight) ? "0" : this.lsn.mRecomWeight);
            anVar.cI("extra", aq.isEmpty(this.lsn.mRecomExtra) ? "0" : this.lsn.mRecomExtra);
            anVar.cI("obj_id", this.dop);
            anVar.cI(TiebaInitialize.Params.AB_TAG, aq.isEmpty(this.lsn.mRecomAbTag) ? "0" : this.lsn.mRecomAbTag);
            anVar.cI("obj_source", aq.isEmpty(this.lsn.mRecomSource) ? "0" : this.lsn.mRecomSource);
            anVar.cI("obj_type", this.mFromPage);
            anVar.af("is_vertical", 1);
            if (this.lsn.baijiahaoData != null) {
                anVar.cI("obj_param4", this.lsn.baijiahaoData.oriUgcNid);
                anVar.cI("obj_param6", this.lsn.baijiahaoData.oriUgcVid);
                if (this.lsn.baijiahaoData.oriUgcType == 4) {
                    anVar.af("obj_param5", 2);
                } else if (this.lsn.baijiahaoData.oriUgcType == 2) {
                    anVar.af("obj_param5", 3);
                }
            } else {
                anVar.af("obj_param5", 1);
            }
            TiebaStatic.log(anVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.kfd != null && str != null && !str.equals(this.mVideoUrl)) {
            if (cIS()) {
                ((QuickVideoView) this.kfd).setRecoveryState(0);
            }
            this.kfd.setVideoPath(str, this.lsn.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!deb()) {
            cJe();
            if (this.lsj != null) {
                this.lsj.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.lrV.getVisibility() == 0) {
                this.lrV.clearAnimation();
                this.lrV.startAnimation(this.eSa);
            }
            if (this.kfd != null) {
                if (TbVideoViewSet.cKt().IP(this.mVideoUrl) == null || TbVideoViewSet.cKt().IP(this.mVideoUrl) != this.kfd) {
                    this.kfd.setVideoPath(this.mVideoUrl, this.lsn.thread_id);
                }
                this.kfd.start();
                bEE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEE() {
        if (this.lsn != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.ahO = this.lsn.thread_id;
            yVar.eQk = this.lsn.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.lsn.mRecomSource;
            yVar.kir = this.lsn.mRecomAbTag;
            yVar.kis = this.lsn.mRecomWeight;
            yVar.kit = "";
            yVar.dop = "";
            yVar.kiw = this.lsn.mMd5;
            if (this.mRect != null) {
                yVar.kix = "1";
            } else {
                yVar.kix = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.kiy = "1";
                yVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                yVar.kit = "index";
            }
            com.baidu.tieba.play.l.a(this.lsn.mMd5, "", "1", yVar);
        }
    }

    private void cJe() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dav().fd(getContext());
        }
    }

    private void asl() {
        if (this.kfd != null) {
            this.kfd.pause();
        }
    }

    private void stopPlay() {
        if (this.kfd != null) {
            if (cIS()) {
                ((QuickVideoView) this.kfd).setRecoveryState(5);
            }
            this.kfd.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddW() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.lsn.thread_id, this.lsn.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.lsn.forum_id));
        createNormalCfg.setForumName(this.lsn.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.lsn.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddX() {
        if (this.dkF == null) {
            this.lsv = new com.baidu.tieba.view.a(getActivity());
            this.dkF = new e(getActivity(), this.lsv.aNh());
            this.dkF.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.kfd.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.lsv != null) {
            ArrayList arrayList = new ArrayList();
            a.C0692a c0692a = new a.C0692a(this.lsv);
            c0692a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bc.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.dkF.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.dkF.dismiss();
                    if (VideoPlayFragment.this.lsn != null) {
                        boolean z = VideoPlayFragment.this.lsn.post_id != null && VideoPlayFragment.this.lsn.post_id.equals(VideoPlayFragment.this.lsn.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.lsn.thread_id);
                        markData.setPostId(VideoPlayFragment.this.lsn.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.lsn.thread_id);
                        markData.setForumId(VideoPlayFragment.this.lsn.forum_id);
                        if (VideoPlayFragment.this.jtz != null) {
                            VideoPlayFragment.this.jtz.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.jtz.aGZ();
                            } else {
                                VideoPlayFragment.this.jtz.aGY();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.lsn != null && this.lsn.post_id != null && this.lsn.post_id.equals(this.lsn.mark_id)) {
                z = true;
            }
            if (z) {
                c0692a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0692a.setText(getResources().getString(R.string.mark));
            }
            if (this.lsn != null && !this.lsn.isBjhVideo) {
                arrayList.add(c0692a);
            }
            a.C0692a c0692a2 = new a.C0692a(getActivity().getString(R.string.delete), this.lsv);
            c0692a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.dkF.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.lsn != null) {
                        String str = VideoPlayFragment.this.lsn.thread_id;
                        String str2 = VideoPlayFragment.this.lsn.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.lsn.post_id;
                        if (VideoPlayFragment.this.lsn.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.lsn.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.lsn.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0692a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0692a2);
            if (this.fqL) {
                a.C0692a c0692a3 = new a.C0692a(getActivity().getString(R.string.delete), this.lsv);
                c0692a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.dkF.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.kd(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.lsn != null) {
                                    VideoPlayFragment.this.gqg.a(VideoPlayFragment.this.lsn.forum_id, VideoPlayFragment.this.lsn.forum_name, VideoPlayFragment.this.lsn.thread_id, VideoPlayFragment.this.lsn.post_id, 0, 0, VideoPlayFragment.this.fqL, null);
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
                        aVar.gE(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.aMS();
                    }
                });
                c0692a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0692a3);
            }
            this.lsv.aI(arrayList);
        }
        this.dkF.show();
    }

    private void ddY() {
        if (this.lsn != null) {
            this.lrV.startLoad(this.lsn.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.lsn.title);
            if (StringUtils.isNull(this.lsn.title) || matcher.matches()) {
                this.lse.setVisibility(8);
            } else {
                this.lse.setVisibility(0);
                this.lse.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.lse.setTextColor(R.color.cp_cont_a);
                this.lse.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.lse.setExpandable(true);
                this.lse.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void nw(boolean z) {
                        VideoPlayFragment.this.lsn.isTitleExpanded = z;
                    }
                });
                this.lse.setData(this.lsn.title, this.lsn.isTitleExpanded);
            }
            this.lsg.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lsn.comment_num, 0L)));
            this.lsh.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lsn.agree_num, 0L)));
            this.lsi.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lsn.share_num, 0L)));
            if (this.lsn.author_info != null) {
                if (!TextUtils.isEmpty(this.lsn.author_info.bjhAvatar)) {
                    this.lrX.startLoad(this.lsn.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.lsn.author_info.portrait) && this.lsn.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.lrX.startLoad(this.lsn.author_info.portrait, 10, false);
                } else {
                    this.lrX.startLoad(this.lsn.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.lsn.author_info.dar())) {
                    this.lsq.setVisibility(8);
                } else {
                    this.lsq.setVisibility(0);
                    this.lsq.setText(UgcConstant.AT_RULE_TAG + this.lsn.author_info.dar());
                }
            }
            if ("1".equals(this.lsn.is_private) && this.lso.getVisibility() != 0) {
                this.lsm.setVisibility(0);
            } else {
                this.lsm.setVisibility(8);
            }
            if ("1".equals(this.lsn.is_agreed)) {
                am.setImageResource(this.lsp, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.lsp, R.drawable.btn_video_agree);
            }
            if (this.lsn.act_info != null && !StringUtils.isNull(this.lsn.act_info.activity_name) && this.lso.getVisibility() != 0) {
                this.lsl.setVisibility(0);
                this.lsf.setText(this.lsn.act_info.activity_name);
            } else {
                this.lsl.setVisibility(8);
            }
            dea();
            if (this.lsn.isBjhVideo) {
                this.lrW.setVisibility(8);
            } else {
                this.lrW.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddZ() {
        if (this.lsn != null) {
            if ("1".equals(this.lsn.is_agreed)) {
                am.setImageResource(this.lsp, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.lsp, R.drawable.btn_video_agree);
            }
            this.lsh.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lsn.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dea() {
        if (this.fqL || (this.lsn.author_info != null && !"0".equals(this.lsn.author_info.is_follow))) {
            this.lsb.setVisibility(4);
            this.lsb.setClickable(false);
            return;
        }
        this.lsb.setVisibility(0);
        this.lsb.setClickable(true);
    }

    private void bCT() {
        if (getActivity() != null) {
            if (this.lsC == null || !this.lsC.isShowing()) {
                this.lsC = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.aOR().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.lsC.aP(inflate);
                this.lsC.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.lsC.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.lsC.kg(1);
                this.lsC.ke(R.color.cp_cont_b);
                this.lsC.gE(true);
                this.lsC.b(getPageContext());
                this.lsC.aMS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deb() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.dav().daw() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !com.baidu.adp.lib.util.j.isMobileNet() || !this.cYu) {
            return false;
        }
        if (this.lsj != null) {
            this.lsj.setVisibility(0);
        }
        asl();
        bCT();
        return true;
    }

    private void asn() {
        if (!deb() && this.kfd != null && this.lsj != null && this.lsn != null) {
            if (this.kfd.getParent() == null) {
                def();
                deg();
            }
            if (TbVideoViewSet.cKt().IP(this.mVideoUrl) == null || TbVideoViewSet.cKt().IP(this.mVideoUrl) != this.kfd) {
                this.kfd.setVideoPath(this.mVideoUrl, this.lsn.thread_id);
            }
            this.kfd.b(null);
            this.lsj.setVisibility(8);
            cJe();
            if (this.kgr != null) {
                this.kgr.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.lsw == null) {
            this.lsw = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.lsw;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0453a
    public void bdy() {
        if (this.kfd.isPlaying()) {
            this.kfd.pause();
            this.lsj.setVisibility(0);
        } else if (!deb()) {
            this.kfd.start();
            this.lsj.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0453a
    public void t(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.lsx) {
            dec();
            if (this.lsn != null && "0".equals(this.lsn.is_agreed)) {
                Ez(this.lrU);
            }
        }
    }

    private void dec() {
        if (this.mRootView != null) {
            this.lsx = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.lsz == null) {
                this.lsz = new RelativeLayout.LayoutParams(-2, -2);
                this.lsz.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.lsz);
            }
            if (this.lsy == null) {
                this.lsy = new AnimatorSet();
                this.lsy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.lsx = false;
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
            this.lsy.setTarget(imageView);
            this.lsy.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.lsy.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0453a
    public void bdz() {
        if (this.lsn != null && this.lsn.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.lsn.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cIS()) {
            return ((QuickVideoView) this.kfd).getMediaIDs();
        }
        return null;
    }

    public String ded() {
        if (cIS()) {
            return ((QuickVideoView) this.kfd).getMediaId();
        }
        return null;
    }

    public boolean dee() {
        if (this.lsB == null || this.lsB.aWN() == null || !this.lsB.aWN().isVisible()) {
            return false;
        }
        this.lsB.aWN().hide();
        this.lsr.setVisibility(0);
        if ((this.lsB.aWN().mD(28) instanceof c) && ((c) this.lsB.aWN().mD(28)).getInputView() != null && ((c) this.lsB.aWN().mD(28)).getInputView().getText() != null) {
            this.lss.setText(StringUtils.isNull(((c) this.lsB.aWN().mD(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.lsB != null) {
            this.lsB.onActivityResult(i, i2, intent);
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
        if (this.lsB != null && this.lsB.aWN() != null) {
            this.lsB.aWN().onChangeSkinType(i);
        }
        SvgManager.aOR().a(this.aox, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void def() {
        if (this.kfd != null && this.kfd.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.kfd.getView(), 0);
            this.kfd.getView().setLayoutParams(layoutParams);
            if (cIS()) {
                ((QuickVideoView) this.kfd).setNeedRecovery(true);
            }
            if (this.lsn != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.ahO = this.lsn.thread_id;
                yVar.eQk = this.lsn.forum_id;
                yVar.kiw = this.lsn.mMd5;
                yVar.dop = "";
                yVar.mSource = this.lsn.mRecomSource;
                yVar.kiv = this.lsn.mRecomAbTag;
                yVar.kiu = 1;
                if (this.lsn.baijiahaoData != null) {
                    if (this.lsn.baijiahaoData.oriUgcType == 2) {
                        yVar.kiu = 3;
                    } else if (this.lsn.baijiahaoData.oriUgcType == 4) {
                        yVar.kiu = 2;
                    }
                }
                yVar.kis = this.lsn.mRecomWeight;
                if (this.mRect != null) {
                    yVar.kix = "1";
                } else {
                    yVar.kix = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    yVar.kiy = "1";
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    yVar.kit = this.mFromPage;
                    yVar.dop = this.dop;
                    yVar.kir = this.lsn.mRecomWeight;
                } else {
                    yVar.mLocate = "14";
                }
                this.ePh.setVideoStatsData(yVar);
                this.ePh.khs = true;
            }
            this.kfd.setContinuePlayEnable(true);
            this.kfd.setBusiness(this.ePh);
        }
    }

    private void deg() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.kfd.setOnPreparedListener(this.lsF);
        }
        this.kfd.setOnCompletionListener(this.lsE);
        this.kfd.setOnOutInfoListener(this.lsD);
    }
}
